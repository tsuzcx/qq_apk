(function() {
    // don't repeated inject
    if (window.WeixinTranslate) {
        return;
    }
    // private variable
    var _xxyy = "__wx_trans_xxyy";
    var _needTransNodeList = [];
    var _nodeMap = new Map();
    var _transTimeInterval;
    var _mutationObserver = new MutationObserver((mutations, observer) => {
        mutations.forEach(function(mutation) {
            textNodesUnder(mutation.target);
        });
        sendPack();
    });

    // functions
    function postMessage(action,data){
        var sendData = {
            action:action,
            randomID:_xxyy,
            data:data
        };
        var sendDataJson = JSON.stringify(sendData);
        window.WXTransInterface.getContentFromWebpage(sendDataJson)
    }
    function sendPack(){
        var needSendArray = [];
        _needTransNodeList.forEach(function(node){
            var needSendNode = new Map();
            needSendNode['text'] = node.WXTransOrgText;
            needSendNode['hashID'] = node.WX_Trans_Info.hash;
            needSendNode['isFirstScreen'] = checkInScreen(node);
            needSendNode['isTitle'] = node.WX_Trans_Info.isTitle;
            needSendArray.push(needSendNode);
        });
        if (needSendArray.length!==0) {
            postMessage('trans',needSendArray);
            //清空
            _needTransNodeList = [];
        }
    }

    function checkInScreen(node) {
        const visibleBottom = document.documentElement.clientHeight;
        const visibleTop = 0;
        let totalTop = null, par = node.offsetParent;
        //首先把自己本身的进行累加
        totalTop += node.parentElement.offsetTop;
        //只要没有找到body，我们就把父级参照物的边框和偏移量累加
        while (par) {
            if (navigator.userAgent.indexOf("MSIE 8.0") === -1) {
                //不是标准的ie8浏览器，才进行边框累加
                //累加父级参照物边框
                totalTop += par.clientTop;
            }
            //累加父级参照物本身的偏移
            totalTop += par.offsetTop;
            par = par.offsetParent;
        }
        return totalTop > visibleTop && totalTop < visibleBottom;
    }

    var _hashIDSequence = 0;
    function genHash(node){
        return (++_hashIDSequence)+"";
    }

    function validTagName(tagName) {
        const tagFilter = new Set(['SPAN', 'A', 'P', 'H1', 'H2', 'H3', 'H4', 'H5', 'H6'
            , 'B', 'I', 'FIGCAPTION', 'DIV', 'EM', 'STRONG', 'LI','FONT','TABLE','TR','TH'
            , 'TD', 'TITLE', 'SECTION', 'LABEL', 'INPUT', 'BUTTON', 'Q', 'CITE', 'BLOCKQUOTE']);
        return tagFilter.has(tagName);
    }
    function processNode(node, isTitle){
        if(node === undefined){
            return;
        }
        if (node.WX_Trans_Info!==undefined && node.WX_Trans_Info.hasGoThrough !== undefined) {
            return;
        }
        var WX_Trans_Info_obj = {};
        WX_Trans_Info_obj.hash = genHash(node);
        WX_Trans_Info_obj.hasGoThrough = true;
        WX_Trans_Info_obj.hasTransed = false;
        WX_Trans_Info_obj.isTitle = isTitle;
        if(node.WXTransOrgText === undefined) {
            node.WXTransOrgText = node.nodeValue;
        }

        node.WX_Trans_Info = WX_Trans_Info_obj;
        _needTransNodeList.push(node);
        _nodeMap.set(node.WX_Trans_Info.hash, node);
    }
    function textNodesUnder(node) {
        if (node == null || node.firstChild == null){
            return;
        }
        for (node = node.firstChild; node; node = node.nextSibling) {
            if (node.nodeType === 3 && validTagName(node.parentElement.tagName) && node.nodeValue.replace(/\s+/, '') !== "") {
                processNode(node,false)
            } else {
                textNodesUnder(node)
            }
        }
    }

    function goThroughDOM(){
        var titleNodeParent = document.getElementsByTagName('title')[0]
        if (titleNodeParent != undefined) {
            const titleNode = document.getElementsByTagName('title')[0].childNodes[0];
            //公众号文章的titleNode比较特殊，要先判断一下
            processNode(titleNode,true);
        }
        textNodesUnder(document.body)
    }

    function startTrans(){
        //*1.先重置
        clearTransIntervalAndObserver();
        _nodeMap.forEach(function(value,key){
            if(value.WX_Trans_Info != undefined){
                value.WX_Trans_Info.hash = undefined;
                value.WX_Trans_Info.transText = undefined;
                value.WX_Trans_Info.hasGoThrough = undefined;
                value.WX_Trans_Info.hasTransed = undefined;
                value.WX_Trans_Info.isTitle = undefined;
                //scrText不能重置，否则取消翻译还原时就找不到了
            }
        });
        //*2.页面完全加载前主动遍历DOM
        _transTimeInterval = setInterval(function () {
            //在observer接管前要保证至少主动遍历一次！
            goThroughDOM();
            sendPack();
            if(document.readyState === 'complete'){
                clearInterval(_transTimeInterval);
                //*3.observer开始观察，在页面完全加载后生效
                _mutationObserver.observe(document.documentElement, {
                    attributes: true,
                    characterData: true,
                    childList: true,
                    subtree: true,
                });
            }
        },200);
    }

    function clearTransIntervalAndObserver(){
        if(_mutationObserver!==null){
            _mutationObserver.disconnect();
        }
        if(_transTimeInterval!==null){
            clearInterval(_transTimeInterval);
        }
    }

    function revertTrans(){
        clearTransIntervalAndObserver();
        _nodeMap.forEach(function (value,key,map) {
           if(value.WXTransOrgText !== undefined){
                value.nodeValue = value.WXTransOrgText;
                value.WX_Trans_Info = undefined;
           }
        });
    }

    function replaceText(jsonStr) {
        if(jsonStr instanceof Array == false){
            return;
        }
        var textWithHashList = jsonStr;
        textWithHashList.forEach(function(dic){
            var hash = dic['hashCode'];
            var transText = dic['transText'];
            var node = _nodeMap.get(hash);
            if(node != undefined){
                node.nodeValue = transText;
                if (node.WX_Trans_Info != undefined){
                    node.WX_Trans_Info.transText = transText;
                    node.WX_Trans_Info.hasTransed = true;//如果发现没有翻译，方便检查错误，看是不是后台的问题
                }
            }
        });
    }

    // public interface
    var _WeixinTranslate = {
        startTrans : startTrans,
        revertTrans : revertTrans,
        replaceText : replaceText,
    }

    // define window object
    if (!window.WeixinTranslate) {
        try {
            Object.defineProperty(window, 'WeixinTranslate', {
                value : _WeixinTranslate,
                writable : false,
                configurable : false,
            })
        } catch (e) {
            console.log('WeixinTranslate setup failure!')
        }
    }
})();
