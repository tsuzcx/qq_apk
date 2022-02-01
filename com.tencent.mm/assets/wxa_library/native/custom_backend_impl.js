var custom_backend_nodes = {};
var render_callback = new Array()

var scrollTop = 0;

(function(glob){

var SWIPER_ITEM_STYLE = 'width: 100%; position: absolute; height: 100%; transform: translate(0%, 0px) translateZ(0px);'


// cpp interface
var cppNatives = glob.cppNatives
var cppNativesId = cppNatives.id
var id = 0
var rootNodeId = 0
var needRender = false
function increaseIntId() {
    if (id >= 1000000000) { // before/after use id > 1000000000
        id = 0
    }
    id ++
    return id
}


var Element = function() {
    this.innerId = increaseIntId()
    this.count = 0
    this.tagName = ''
    this.name = ''
    this.id = ''
}

Element.prototype.release = function() {
//    console.error('garryyan release id:' + this.innerId + ', count:' + this.count + ', name:' + this.name + ', tagname:' + this.tagName)
    this.count--
    if (this.count <= 0) {
        cppNatives.release(cppNativesId, this.innerId)
        delete custom_backend_nodes[this.innerId]
    }
}

Element.prototype.cloneNode = function() {
    var name = this.name
    var tagName = this.tagName
    var ele;
    if ("empty" == name) {
        ele =  new EmptyElement()
        ele.tagName = tagName
    } else if ("text" == name) {
        ele = new TextElement()
    } else if ("fragment" == name) {
        ele = new FragmentElement();
    } else if ("image" == name) {
        ele = new ImageElement()
    } else {
//    //    console.error("garryyan createElement unknown name:" + name + ", tagName:" + tagName)
        throw new Error("unknown name:" + name)
    }
    ele.name = name
    ele.count++
    cppNatives.createElement(cppNativesId, ele.innerId, name, tagName)
    if (tagName == 'wx-swiper-item') {
        cppNatives.setStyle(cppNativesId, ele.innerId, SWIPER_ITEM_STYLE)
    }
    needRender = true
//    console.error('garryyan cloneNode id:' + this.innerId + ', return ele id:' + ele.innerId)
    return ele
}

Element.prototype.downcast = function(name) {
//    console.error('garryyan downcast from ' + this.name + ' to ' + name)
    try {
        if ("empty" == name) {
            this.prototype = EmptyElement.prototype
        } else if ("text" == name) {
            this.prototype.constructor = TextElement.prototype
        } else if ("fragment" == name) {
            this.prototype.constructor = FragmentElement.prototype
        } else if ("image" == name) {
            this.prototype.constructor = ImageElement.prototype
        } else {
            throw new Error("unknown name:" + name)
        }
    } catch(err) {
//    //    console.error(this.name + ' downcast to ' + name + ' fail')
        throw new Error(this.name + ' downcast to ' + name + ' fail')
    }
}

Element.prototype.equal = function(other) {
//    console.error('garryyan equal ...')
    return this.innerId == other.innerId
}

Element.prototype.getParentNode = function() {
//    console.error('garryyan getParentNode id:' + this.innerId)
    return custom_backend_nodes[cppNatives.getParentNode(cppNativesId, this.innerId)]
}

Element.prototype.getChildNode = function(index) {
//    console.error('garryyan getChildNode id:' + this.innerId + ', index:' + index)
    return custom_backend_nodes[cppNatives.getChildNode(cppNativesId, this.innerId, index)]
}

Element.prototype.appendChild = function(child) {
//    console.error('garryyan appendChild parentid:' + this.innerId + ", child:" + child.innerId)
    cppNatives.appendChild(cppNativesId, this.innerId, child.innerId)
    needRender = true
}

Element.prototype.insertChild = function(child, index) {
//    console.error('garryyan insertChild....')
    cppNatives.insertChild(cppNativesId, this.innerId, child.innerId, index)
    needRender = true
}

Element.prototype.removeChild = function(index) {
//    console.error('garryyan removeChild....')
    cppNatives.removeChild(cppNativesId, this.innerId, index)
    needRender = true
}

Element.prototype.replaceChild = function(child, index) {
//    console.error('garryyan replaceChild. innerid:' + this.innerId + ', child id:' + child.innerId + ', index:' + index)
    cppNatives.replaceChild(cppNativesId, this.innerId, child.innerId, index)
    needRender = true
}

Element.prototype.splice = function(index, deleteCount, other) {
//    console.error('garryyan splice id:' + this.innerId + ", index:" + index + ", deleteCount:" + deleteCount + ", other:" + other.innerId)
    cppNatives.spliceChild(cppNativesId, this.innerId, index, deleteCount, other.innerId,)
    needRender = true
}

Element.prototype.findChildPosition = function(child) {
    var pos = cppNatives.findChildPosition(cppNativesId, this.innerId, child.innerId)
//    console.error('garryyan findChildPosition pid:' + this.innerId + ', cid:' + child.innerId + ', pos:' + pos)
    return pos;
}

Element.prototype.length = function() {
//    console.error('garryyan length id:' + this.innerId)
    cppNatives.childrenLength(cppNativesId, this.innerId)
}

Element.prototype.nodeUnderPoint = function(left, top) {
//    console.error('garryyan no implement nodeUnderPoint ...')
}

Element.prototype.setId = function(id) {
//    console.error('garryyan setId...')
    this.id = id
    cppNatives.setId(cppNativesId, this.innerId, id)
    needRender = true
}

Element.prototype.setClass = function(clazz) {
//    console.error('garryyan setClass id:' + this.innerId + ", clzz:" + clazz)
    cppNatives.setClass(cppNativesId, this.innerId, clazz)
    needRender = true
}

Element.prototype.setStyle = function(style) {
    if (this.tagName == 'wx-swiper-item') {
        return;
    }
//    console.error('garryyan setStyle id:' + this.innerId + ", style:" + style)
    cppNatives.setStyle(cppNativesId, this.innerId, style)
    needRender = true
}

Element.prototype.getBoundingClientRect = function() {
    if (needRender) {
        cppNatives.requestLayout(cppNativesId)
        needRender = false
        render_callback.push(undefined)
    }
    if (this.innerId == rootNodeId) {
        var w = cppNatives.getWindowWidth(cppNativesId)
        var h = cppNatives.getWindowHeight(cppNativesId)
        return {left:0, top:0, right:w, bottom:h, width:w, height:h}
    }
    var rectStr = cppNatives.getBoundingClientRect(cppNativesId, this.innerId)
    var rect = JSON.parse(rectStr);
    return { left:rect[0], top:rect[1]-scrollTop, right:rect[2], bottom:rect[3]-scrollTop, width:rect[4], height:rect[5] }
}

Element.prototype.getScrollPosition = function() {
    if (needRender) {
        cppNatives.requestLayout(cppNativesId)
        needRender = false
        render_callback.push(undefined)
    }
    var ret = cppNatives.getScrollPosition(cppNativesId, this.innerId)
    return JSON.parse(ret)
}

Element.prototype.setScrollPosition = function(detail) {
//    console.error('garryyan setScrollPosition:' + JSON.stringify(detail))
    cppNatives.setScrollPosition(cppNativesId, this.innerId, JSON.stringify(detail))
}

Element.prototype.associateComponent = function(exparserComponent) {
    var id = this.innerId
    custom_backend_nodes[id] = exparserComponent

    __virtualDOM__.setEventHandlerChangeListener(exparserComponent,
        function(eventName, bindFuncName, isCapture) {
//            console.error('garryyan event:' + eventName + "," + bindFuncName + "," + id)
            cppNatives.eventListenerChange(cppNativesId, id, true, eventName)
        })
}

function object(o) {
    function F(){}
    F.prototype = o
    return new F()
}

function inheritPrototype(subType,superType) {
    var prototype = object(superType.prototype)
    prototype.constructor = subType
    subType.prototype = prototype
}

var EmptyElement = function() {
    Element.call(this)
}
inheritPrototype(EmptyElement, Element)

var TextElement = function() {
    Element.call(this)
}
inheritPrototype(TextElement, Element)

TextElement.prototype.setText = function(text) {
    // &nbsp;
    text = text.trim().replace(/&nbsp;/g, ' ')
//    console.error('garryyan setText text:' + text + ", id:" + this.innerId)
    cppNatives.setText(cppNativesId, this.innerId, text)
    needRender = true
}

var FragmentElement = function() {
    Element.call(this)
}
inheritPrototype(FragmentElement, Element)

var ImageElement = function() {
    Element.call(this)
}
inheritPrototype(ImageElement, Element)

// 现在 image 的 src 是走属性变化回调的
ImageElement.prototype.load = function(url) {
//    console.error('garryyan unimplemented function load url:' + url)
    // natives.imageLoadUrl(this.innerId, url)
}

var Context = function() {
}

Context.prototype.appendStyleSheet = function(styleText) {
//    console.error('garryyan appendStyleSheet:' + styleText)
    cppNatives.appendStyle(cppNativesId, styleText)
    needRender = true
}

Context.prototype.getRootNode = function() {
    var ele = new EmptyElement()
    ele.tagName = 'wx-page'
    cppNatives.createRootNode(cppNativesId, ele.innerId)
    ele.count += 2
    return ele;
}

Context.prototype.setRootNode = function(node) {
//    console.error('garryyan setRootNode, id:' + node.innerId)
    rootNodeId = node.innerId
    cppNatives.setRootNode(cppNativesId, node.innerId)
    needRender = true
}
// 开平那边的问题：
// TODO replace index 是 undefined
// TODO 事件没实现 好像只有 tap 事件有 listener 回调以及能触发
// TODO setData之后没回调 done
// 我这边的问题：
// TODO release 结点还没做
// TODO 完善未实现的函数
// TODO 删除 debug 日志
// TODO 其他事件

Context.prototype.createElement = function(name, tagName) {
    var ele;
    if ("empty" == name) {
        ele =  new EmptyElement()
        if (tagName === undefined) {
            tagName = ''
        }
        ele.tagName = tagName
    } else if ("text" == name) {
        ele = new TextElement()
    } else if ("fragment" == name) {
        ele = new FragmentElement();
    } else if ("image" == name) {
        ele = new ImageElement()
    } else {
//    //    console.error("garryyan createElement unknown name:" + name + ", tagName:" + tagName)
        throw new Error("unknown name:" + name)
    }
    ele.name = name
    ele.count++
//    console.error("garryyan createElement name:" + name + ", tagName:" + tagName + ", id:" + ele.innerId)
    cppNatives.createElement(cppNativesId, ele.innerId, name, tagName)
    if (tagName == 'wx-swiper-item') {
        cppNatives.setStyle(cppNativesId, ele.innerId, SWIPER_ITEM_STYLE)
    }
    needRender = true
    return ele
}

Context.prototype.render = function(callback) {
//    console.error('garryyan render')
    cppNatives.requestLayout(cppNativesId)
    needRender = false
    render_callback.push(callback)
}

Context.prototype.getNodeUnderPoint = function(left, top) {
//    console.error('garryyan unimplemented getNodeUnderPoint:' + left + ', top:' + top)
    // TODO garryyan
}

Context.prototype.replaceStyleSheet = function(index, styleText) {
//    console.error('garryyan replaceStyleSheet')
    cppNatives.replaceStyle(cppNativesId, index, styleText)
    needRender = true
}

Context.prototype.clearStyleSheets = function() {
//    console.error('garryyan clearStyleSheets')
    cppNatives.clearStyle(cppNativesId)
    needRender = true
}

Context.prototype.getWindowWidth = function() {
    var w = cppNatives.getWindowWidth(cppNativesId)
    return w
}

Context.prototype.getWindowHeight = function() {
    var h = cppNatives.getWindowHeight(cppNativesId)
    return h
}

Context.prototype.getDevicePixelRatio = function() {
    var r = cppNatives.getDevicePixelRatio(cppNativesId)
    return r
}

exparser.globalOptions.renderingMode = 'full'
exparser.globalOptions.documentBackend = 'custom'
exparser.globalOptions.publicProperties = true
exparser.globalOptions.lazyRegistration = false
exparser.globalOptions.customContext = new Context()
exparser.globalOptions.listenerChangeLifeTimes = true 
exparser.initBackend()

var inputMethods = {
    getNodeId() {
        this.__nodeId = this.__nodeId || (this.ownerShadowRoot ? __virtualDOM__.getNodeId(this.ownerShadowRoot.__wxHost) : '')
        return this.__nodeId
    },
    generateEventData: function () {
        var bindinput = this.data.bindinput
        if (!bindinput) return ''
        var event = {
            bindinput: bindinput,
            target: {
                id: this.id,
                dataset: this.dataset,
            },
            setKeyboardValue: true
        }
        event.currentTarget = event.target
        event.nodeId = this.getNodeId()
        return event
    },
}
var buttonMethods = {
    processClass: function() {
        this.processClassItem('hoverClass')
    },
    _preventTapOnDisabled: function() {
      if(this.disabled) {
        return false
      }
    },
    _onThisTap: function(){
      var self = this
      if (this.openType === 'contact') {
        wx.enterContact({
          sessionFrom: this.sessionFrom,
          businessId: this.businessId,
          sendMessageTitle: this.sendMessageTitle,
          sendMessagePath: this.sendMessagePath,
          sendMessageImg: this.sendMessageImg,
          showMessageCard: this.showMessageCard,
          complete(res) {
            self.triggerEvent('contact', res)
          }
        })
      } else if (this.openType === 'subscribe') {
        wx.subscribeMessage({
          success(res) {
            self.triggerEvent('subscribe', res)
          },
          fail(res) {
            self.triggerEvent('subscribe', res)
          }
        })
      } else if (this.openType === 'getPhoneNumber') {
        wx.getPhoneNumber({
          data: {
            api_name: 'webapi_getuserwxphone',
            with_credentials: true
          },
          complete(res) {
            const realRes = {}
            if (res.errMsg) {
              realRes.errMsg = res.errMsg
            }
            if (res.encryptedData) {
              realRes.encryptedData = res.encryptedData
            }
            if (res.iv) {
              realRes.iv = res.iv
            }
            if (res.cloud_id) {
              realRes.cloudID = res.cloud_id
            }
            self.triggerEvent('getphonenumber', realRes)
          }
        })
      } else if (this.openType === 'share') {
        wx.publish('tapShareButton', {
          target: {
            id: this.id,
            dataset: this.dataset,
            offsetTop: this.$$.offsetTop,
            offsetLeft: this.$$.offsetLeft
          }
        })
      } else if (this.openType === 'getUserInfo') {
        wx.getUserInfo({
          withCredentials: self.withCredentials,
          lang: self.lang,
          complete(res) {
            self.triggerEvent('getuserinfo', res)
          }
        })
      } else if (this.openType === 'realnameAuth') {
        wx.invoke('openRealnameAuth', {
          categoryId: this.categoryId
        }, (res) => {
          this.triggerEvent('realnameauth', res)
        })
      } else if (this.openType === 'getRealnameAuthInfo') {
        let type = 1 << 0 // 左边第1位是授权信息
        if (this.needPhoneNumber) {
          type += 1 << 1 // 左边第2位是手机号，相加表示两者都需要
        }
        wx.invoke('openRealnameAuth', {
          categoryId: this.categoryId,
          authType: type
        }, (res) => {
          this.triggerEvent('getrealnameauthinfo', res)
        })
      } else if (this.openType === 'launchApp') {
        // 获取跳 APP 所需的信息，包括从启动到现在的场景值历史记录 sceneHistory 和跳到小程序的 APP 的 appId
        wx.getLaunchAppInfo({
          success: res => {
            const sceneHistory = res.sceneHistory
            const appId = res.appId

            let canLaunchApp = false
            let method = 'launchApplication'

            sceneHistory.forEach(item => {
              if (item === 1036) {
                canLaunchApp = true
                method = 'launchApplication'
              } else if (item === 1069) {
                canLaunchApp = true
                method = 'navigateBackApplication'
              } else if (!(item === 1089 || item === 1090 || item === 1038 || item === 1041)) {
                canLaunchApp = false
              }
            })

            if (!canLaunchApp) {
              this.triggerEvent('error', {
                errMsg: 'invalid scene'
              })
              return
            }

            const args = {
              appId,
              success: res => this.triggerEvent('launchapp', res),
              fail: res => this.triggerEvent('error', res)
            }

            if (method === 'navigateBackApplication') {
              // navigateBackApplication 用 extraData 传参数
              args.extraData = this.appParameter
            } else if (wx.getPlatform() === 'ios') {
              args.messageExt = this.appParameter
            } else {
              args.extInfo = this.appParameter
            }

            wx[method](args)
          },
          fail: () => {
            this.triggerEvent('error', {
              errMsg: 'can\'t get scene history'
            })
          }
        })
      } else if (this.openType === 'openSetting') {
        wx.openSetting({
          success(res) {
            res.authSetting = res.authSetting.reduce((ret, item) => {
              ret[item.scope] = item.state === 1
              return ret
            }, {})
          },
          complete: (res) => {
            this.triggerEvent('opensetting', res)
          }
        })
      } else if (this.openType === 'feedback') {
        wx.invoke('private_openUrl', {
          url: `https://mp.weixin.qq.com/mp/wapreportwxadevlog?action=get_page&appid=${window.__appId__}#wechat_redirect`,
          isNativeStyle: true
        }, () => {
          // console.log('res', res)
          // this.triggerEvent('openFeedback', res)
        })
      }
    },
    handleLabelTap: function(e){
      exparser.triggerEvent(this.shadowRoot, 'tap', e.detail, {bubbles: true, composed: true, extraFields: {
        touches: e.touches,
        changedTouches: e.changedTouches
      }})
    }
}
var viewMethods = {
    processClass: function() {
        this.processClassItem('hoverClass')
    }
}

var SLIDE_ACTIVE_COLOR = '#1AAD19';
var SLIDE_BACKGROUND_COLOR = '#E9E9E9'
var PROGRESS_BACKGROUND_COLOR = '#EBEBEB'
var PROGRESS_ACTIVE_COLOR = '#09BB07'

// 注意: 如果属性包含下划线，请改成驼峰式注册，如小程序官方文档定义了属性：a_b，注册时应该注册 aB
var elements = [
    {is: 'wx-listview', properties:{value:{type:Array,value:[],public:true}, switch:{type:String, public:true}}},
    {is: 'wx-listcell', properties:{case:{type:String, public:true}}},
    {is: 'wx-audio', properties:{action:{type:Object,public:true},name:{type:String,value:'未知歌曲',public:true},
        author:{type:String,value:'未知作者',public:true},loop:{type:Boolean,value:false,public:true},hidden: {type:Boolean,public:true},
        controls:{type:Boolean,value:false,public:true},_srcTimer:{type:Number},_actionTimer:{type:Number},_canSrc:{type:Boolean,value:true},
        _deferredSrc:{type:String,value:''},_canAction:{type:Boolean,value:false},_deferredAction:{type:Array,value:[]}}},
    {is: 'wx-button', properties:{type:{type:String,value:'default',public:true},size:{type:String,value:'default',public:true},
        disabled:{type:Boolean,public:true},plain:{type:Boolean,public:true},loading:{type:Boolean,public:true},hidden: {type:Boolean,public:true},
        formType:{type:String,public:true},openType:{value:'',type:String,public:true}, appParameter: {value: '', type: String,public: true},withCredentials:{value:true,type:Boolean,public:true},
        lang:{value:'en',type:String,public:true},hoverStartTime:{type:Number,value:20,public:true},hoverStayTime:{type:Number,value:70,public:true},
        hoverClass:{type:String,value:'button-hover',public:true,},sessionFrom:{type:String,value:'wxapp',public:true},
        businessId:{type:String,value:'',public:true},sendMessageTitle:{type:String,value:'',public:true},sendMessagePath:{type:String,value:'',
        public:true},sendMessageImg:{type:String,value:'',public:true},showMessageCard:{type:Boolean,value:false,public:true},
        categoryId: {type: Array,value: [],public: true},needPhoneNumber: {type: Boolean, value: false, public: true,}},
        methods: buttonMethods, listeners:{'tap': '_preventTapOnDisabled', 'this.tap': '_onThisTap'}},
    {is: 'wx-canvas', properties:{canvasId:{type:String,public:true},bindtouchstart:{type:String,value:'',public:true},
        bindtouchmove:{type:String,value:'',public:true},bindtouchend:{type:String,value:'',public:true},hidden: {type:Boolean,public:true},
        bindtouchcancel:{type:String,value:'',public:true},bindlongtap:{type:String,value:'',public:true},
        disableScroll:{type:Boolean,value:false,public:true,}}},
    {is: 'wx-checkbox', properties:{name:{type:String,public:true},hidden:{type:Boolean,public:true},color:{type:String,value:'#09BB07',public:true},value:{type:String,public:true},disabled:{type:Boolean,public:true},checked:{type:Boolean,public:true}}},
    {is: 'wx-checkbox-group', properties:{name:{type:String,public:true},hidden:{type:Boolean,public:true},value:{type:Array,value:[]}}},
    {is: 'wx-contact-button', properties:{name:{type:String,public:true},hidden:{type:Boolean,public:true},type:{type:String,value:'default-dark',public:true,},size:{type:Number,value:36,public:true,},
        sessionFrom:{type:String,value:'wxapp',public:true},businessId:{type:String,value:'',public:true}}},
    {is: 'wx-cover-image', properties:{hidden:{type:Boolean,public:true},src:{type:String,value:'',public:true},bindtap:{type:String,value:'',public:true},catchtap:{type:String,value:'',public:true}}},
    {is: 'wx-cover-view', properties:{hidden:{type:Boolean,public:true},bindtap:{type:String,value:'',public:true},catchtap:{type:String,value:'',public:true}}},
    {is: 'wx-form', properties:{hidden:{type:Boolean,public:true},reportSubmit:{type:Boolean,value:false,public:true}}},
    {is: 'wx-icon', properties:{hidden:{type:Boolean,public:true},type:{type:String,public:true},size:{type:Number,value:23,public:true},color:{type:String,public:true}}},
    {is: 'wx-image', properties: {hidden:{type:Boolean,public:true},src:{type:String,public:true,},mode:{type:String,public:true},lazyLoad:{type:Boolean,value:false,public:true},
        _disableSizePositionRepeat:{type:Boolean,value:false},backgroundSize:{type:String,value:'100% 100%',public:true},
        backgroundPosition:{type:String,public:true},backgroundRepeat:{type:String,value:'no-repeat',public:true},
        _hasScrollViewParent:{type:Boolean,value:false},_imageInstanceId:{type:String}}},
    {is: 'wx-input', properties:{name:{type:String,public:true},hidden:{type:Boolean,public:true},bindinput: String,focus:{type:Boolean,value:0,public:true},autoFocus:{type:Boolean,value:false,public:true},
        placeholder:{type:String,value:'',public:true},placeholderStyle:{type:String,value:"",public:true,},value:{type:String,value:'',public:true},
        placeholderClass:{type:String,value:"",public:true,},dropdownStyle:{type:Object,value:{},public:true,}, confirmType:{type:String,value:'',public:true},
        maxlength:{type:Number,value:"",public:true,},confirmHold:{type:String,value:"",public:true,},adjustPosition:{type:Boolean,value:true,public:true,},
        type:{type:String,value:'',public:true},password:{type:Boolean,value:false,public:true},disabled:{type:Boolean,value:false,public:true},
        cursor:{type:Number,value:-1,public:true},selectionStart:{type:Number,value:-1,public:true}, selectionEnd:{type:Number,value:-1,public:true}},
        methods: inputMethods},
    {is: 'wx-label', properties:{hidden:{type:Boolean,public:true},for:{type:String,public:true}}},
    {is: 'wx-loading', properties:{hidden:{type:Boolean,public:true}}},
    {is: 'wx-map', properties:{hidden:{type:Boolean,public:true},latitude:{type:Number,public:true,value:39.92},longitude:{type:Number,public:true,value:116.46},
        scale:{type:Number,public:true,value:16},markers:{type:Array,value:[],public:true,},covers:{type:Array,value:[],public:true,},
        includePoints:{type:Array,value:[],public:true,},polyline:{type:Array,value:[],public:true,},circles:{type:Array,value:[],public:true,},
        controls:{type:Array,value:[],public:true,},showLocation:{type:Boolean,value:false,public:true,},bindmarkertap:{type:String,value:'',public:true},
        bindcallouttap:{type:String,value:'',public:true},bindcontroltap:{type:String,value:'',public:true},bindregionchange:{type:String,value:'',public:true},
        bindtap:{type:String,value:'',public:true},_mapId:{type:Number}}},
    {is: 'wx-mask', properties:{hidden:{type:Boolean,value:true,public:true}}},
    {is: 'wx-modal', properties:{hidden:{type:Boolean,public:true},title:{type:String,public:true},noCancel:{type:Boolean,value:false,public:true},
        confirmText:{type:String,value:'确定',public:true},cancelText:{type:String,value:'取消',public:true}}},
    {is: 'wx-movable-area', properties:{hidden:{type:Boolean,public:true},style:{type:String,public:true,},class:{type:String,public:true,},}},
    {is: 'wx-movable-view', properties:{hidden:{type:Boolean,public:true},x:{type:Number,value:0,public:true,},y:{type:Number,value:0,public:true,},
        direction:{type:String,value:'none',public:true,},outOfBounds:{type:Boolean,value:false,public:true,},
        inertia:{type:Boolean,value:false,public:true,},style:{type:String,public:true,},class:{type:String,public:true,},
        friction:{type:Number,value:2,public:true},damping:{type:Number,value:20,public:true},}},
    {is: 'wx-open-data', properties:{hidden:{type:Boolean,public:true},openGid:{type:String,public:true,},type:{type:String,public:true,},
        gidCounter:{type:Number,value:0,},lastGid:{type:Number,value:0}}},
    {is: 'wx-picker', properties:{hidden:{type:Boolean,public:true},range:{type:Array,value:[],public:true,},value:{value:'',public:true,},
        mode:{type:String,value:'selector',public:true},fields:{type:String,value:'day',public:true},start:{type:String,value:'',public:true},
        end:{type:String,value:'',public:true},disabled:{type:Boolean,value:false,public:true},rangeKey:{type:String,value:'',public:true},
        customItem:{type:String,value:'',public:true}}},
    {is: 'wx-picker-view', properties:{hidden:{type:Boolean,public:true},value:{type:Array,value:[],public:true,},indicatorStyle:{type:String,value:'',public:true},
        indicatorClass:{type:String,value:'',public:true},maskStyle:{type:String,value:'',public:true},
        maskClass:{type:String,value:'',public:true}}},
    {is: 'wx-picker-view-column', properties:{hidden:{type:Boolean,public:true}}},
    {is: 'wx-progress', properties:{hidden:{type:Boolean,public:true},percent:{type:Number,public:true},curPercent:{type:Number},showInfo:{type:Boolean,value:false,public:true},
        strokeWidth:{type:Number,value:6,public:true},active:{type:Boolean,value:false,public:true,},
        activeColor:{type:String,value:PROGRESS_ACTIVE_COLOR,public:true},backgroundColor:{type:String,value:PROGRESS_BACKGROUND_COLOR,public:true},
        color:{type:String,value:PROGRESS_ACTIVE_COLOR,},}},
    {is: 'wx-radio', properties:{name:{type:String,public:true},hidden:{type:Boolean,public:true},color:{type:String,value:'#09BB07',public:true}, value:{type:String, public:true}, disabled:{type:Boolean,public:true},checked:{type:String,public:true}}},
    {is: 'wx-radio-group', properties:{name:{type:String,public:true},hidden:{type:Boolean,public:true},value:{type:String}}},
    {is: 'wx-rich-text', properties:{hidden:{type:Boolean,public:true},nodes:{value:[],public:true,}}},
    {is: 'wx-scroll-view', properties:{hidden:{type:Boolean,public:true},scrollX:{type:Boolean,value:false,public:true,},scrollY:{type:Boolean,value:false,public:true,},
        upperThreshold:{type:Number,value:50,public:true,},lowerThreshold:{type:Number,value:50,public:true,},scrollTop:{type:Number,public:true,},
        scrollLeft:{type:Number,public:true,},scrollIntoView:{type:String,public:true,},scrollWithAnimation:{type:Boolean,public:true,value:false},
        enableBackToTop:{type:Boolean,public:true,value:false}}},
    {is: 'wx-slider', properties:{name:{type:String,public:true},hidden:{type:Boolean,public:true},min:{type:Number,value:0,public:true,},max:{type:Number,value:100,public:true,},
        step:{type:Number,value:1,public:true},value:{type:Number,value:0,public:true,},showValue:{type:Boolean,value:false,public:true},
        activeColor:{type:String,value:SLIDE_ACTIVE_COLOR,public:true,},backgroundColor:{type:String,value:SLIDE_BACKGROUND_COLOR,public:true,},
        selectedColor:{type:String,value:SLIDE_ACTIVE_COLOR,},color:{type:String,value:SLIDE_BACKGROUND_COLOR,},
        disabled:{type:Boolean,value:false,public:true},blockSize:{type:Number,value:28,public:true},blockColor:{type:String}}},
    {is: 'wx-swiper', properties:{hidden:{type:Boolean,public:true},indicatorDots:{type:Boolean,value:false,public:true},vertical:{type:Boolean,value:false,public:true},
        autoplay:{type:Boolean,value:false,public:true},circular:{type:Boolean,value:false,public:true},interval:{type:Number,value:5000,public:true,},
        duration:{type:Number,value:500,public:true},current:{type:Number,value:0,public:true},indicatorColor:{type:String,value:'',public:true},
        indicatorActiveColor:{type:String,value:'',public:true}}},
    {is: 'wx-swiper-item', properties:{hidden:{type:Boolean,public:true}}},
    {is: 'wx-span', properties:{hidden:{type:Boolean,public:true}}},
    {is: 'wx-switch', properties:{name:{type:String,public:true},hidden:{type:Boolean,public:true},checked:{type:Boolean,value:false,public:true},type:{type:String,value:'switch',public:true},
        color:{type:String,value:'#04BE02',public:true}}},
    {is: 'wx-textarea', properties:{name:{type:String,public:true},hidden:{type:Boolean,public:true},value:{type:String,value:'',public:true},maxlength:{type:Number,value:140,public:true},
        placeholder:{type:String,value:'',public:true},disabled:{type:Boolean,value:false,public:true},hidden:{type:Boolean,value:false,public:true,},
        focus:{type:Boolean,value:false,public:true,},autoFocus:{type:Boolean,value:false,public:true},placeholderStyle:{type:String,value:'',public:true},
        placeholderClass:{type:String,value:'textarea-placeholder',public:true},autoHeight:{type:Boolean,value:false,public:true},
        confirm:{type:Boolean,value:true,public:true},bindinput:{type:String,value:"",public:true},cursorSpacing:{type:Number,value:0,public:true},
        fixed:{type:Boolean,value:false,public:true},cursor:{type:Number,value:-1,public:true},selectionStart:{type:Number,value:-1,public:true}, selectionEnd:{type:Number,value:-1,public:true}},
        methods: inputMethods},
    {is: 'wx-toast', properties:{hidden:{type:Boolean,public:true},icon:{type:String,value:'success_no_circle',public:true},hidden:{type:Boolean,value:false,public:true,},
        duration:{type:Number,value:1500,public:true,}}},
    {is: 'wx-video', properties:{hidden:{type:Boolean,public:true},autoplay:{type:Boolean,value:false,public:true},src:{type:String,value:'',public:true},
        danmuBtn:{type:Boolean,value:false,public:true,},enableDanmu:{type:Boolean,value:false,public:true},
        controls:{type:Boolean,value:true,public:true,},danmuList:{type:Array,value:[],public:true,},src:{type:String,value:'',public:true},
        objectFit:{type:String,value:'contain',public:true},duration:{type:Number,value:0,public:true},
        live:{type:Number,value:false,public:true,},muted:{type:Boolean,value:false,public:true,},loop:{type:Boolean,value:false,public:true,},
        pageGesture:{type:Boolean,value:false,public:true,},_videoId:{type:Number},_insert2WebLayer:{type:Boolean,value:false},
        initialTime:{type:Number,value:0,public:true},direction:{type:Number,value:0,public:true},showProgress:{type:Boolean,value:true,public:true},
        showFullscreenBtn:{type:Boolean,value:true,public:true},showPlayBtn:{type:Boolean,value:true,public:true},
        showCenterPlayBtn:{type:Boolean,value:true,public:true},enableProgressGesture:{type:Boolean,value:true,public:true},
        poster:{type:String,value:'',public:true,},showMuteBtn:{type:Boolean,value:false,public:true},title:{type:String,public:true},
        playBtnPosition:{type:String,value:'bottom',public:true},enablePlayGesture:{type:Boolean,value:false,public:true},
        autoPauseIfNavigate:{type:Boolean,value:true,public:true},autoPauseIfOpenNative:{type:Boolean,value:true,public:true},
        vslideGesture:{type:Boolean,value:false,public:true},vslideGestureInFullscreen:{type:Boolean,value:true,public:true}}},
    {is: 'wx-view', properties:{inline:{type:Boolean,public:true},hover:{type:Boolean,value:false,public:true},
        hidden: {type:Boolean,public:true},
        sessionFrom:{type:String,value:'wxapp',public:true}},
     methods: viewMethods},
    {is: 'wx-page', properties:{hidden:{type:Boolean,public:true}}},
]

exparser.registerElement({
    is: 'wx-navigator',
    properties: {
        url: {
          type: String,
          public: true
        },
        delta: {
          type: Number,
          public: true,
          value: 1
        },
        redirect: {
          type: Boolean,
          value: false,
          public: true
        },
        target: {
          type: String,
          value: 'self',
          public: true,
        },
        openType: {
          type: String,
          value: 'navigate',
          public: true
        },
        hoverClass: {
          type: String,
          value: '', // 对，这里是空的！！！
          public: true,
          observer: '_hoverClassChange'
        },
        hover: {
          type: Boolean,
          value: true
        },
        hoverStayTime: {
          type: Number,
          value: 600,
          public: true
        },
    
        // navigateToMiniProgram 用
        appId: {
          type: String,
          value: '',
          public: true,
        },
        path: {
          type: String,
          value: '',
          public: true,
        },
        extraData: {
          type: Object,
          value: '',
          public: true,
        },
        version: {
          type: String,
          value: 'release',
          public: true,
        },
        scene: {
          type: Number,
          value: 1037,
          public: true,
        },
        sceneNote: {
          type: String,
          value: '',
          public: true,
        },
        ariaLabel: {
          type: String,
          value: '',
          public: true
        },
    },
    listeners: {
        tap: 'navigateTo'
    },
    created() {
//        custom_backend_nodes[this.$$.innerId] = this;
    },
    listenerChanged(isAdd, eventName, func, options) {
//        cppNatives.eventListenerChange(cppNativesId, this.$$.innerId, isAdd, eventName)
    },
    // observers: observers,
    methods: {
        processClass: function() {
            this.processClassItem('hoverClass')
        },
        navigateInMiniPrograms() {
          switch (this.openType) {
            case 'navigate':
              // eslint-disable-next-line
              const args = {
                appId: this.appId,
                path: this.path,
                extraData: this.extraData,
                envVersion: this.version,
                success: (res) => {
                  this.triggerEvent('success', res)
                },
                fail: (res) => {
                  this.triggerEvent('fail', res)
                },
                complete: (res) => {
                  this.triggerEvent('complete', res)
                }
              }
              if (__wxConfig.appType === 7) {
                args.scene = this.scene
                args.sceneNote = this.sceneNote
              }
              wx.navigateToMiniProgram(args)
              return
            case 'exit':
              wx.exitMiniProgram()
              return
            default:
              // eslint-disable-next-line no-console
          //    console.error(`<navigator/> using invalid openType ${this.openType} with miniProgram target`)
          }
        },
        navigateTo(e) {
          if (this.target === 'miniProgram') {
            if (this.openType === 'navigate' && !this.appId) {
              // eslint-disable-next-line no-console
          //    console.error('<navigator/> should have app-id attribute when using navigate with miniProgram target')
              return
            }
          } else if (this.openType !== 'navigateBack' && !this.url) {
            // eslint-disable-next-line no-console
        //    console.error('<navigator/> should have url attribute when using navigateTo, redirectTo or switchTab')
            return
          }

          const LOCK_TIMEOUT = 1000

          if (this._lock) return
          this._lock = true
          setTimeout(() => {
            this._lock = false
          }, LOCK_TIMEOUT)

          if (this.target === 'miniProgram') {
            this.navigateInMiniPrograms()
            return
          }

          // 兼容旧有的 redirect 属性
          if (this.redirect) {
            wx.redirectTo({
              url: this.url
            })
            return
          }

          // 有设置 openType
          switch (this.openType) {
            case 'navigate':
            case 'navigateTo':
              wx.navigateToWithRelatedInfo({
                url: this.url,
                _relatedInfo: e._relatedInfo
              })
              return
            case 'redirect':
            case 'redirectTo':
              wx.redirectTo({
                url: this.url
              })
              return
            case 'switchTab':
              wx.switchTab({
                url: this.url
              })
              return
            case 'navigateBack':
              wx.navigateBack({
                delta: this.delta
              })
              return
            case 'reLaunch':
              wx.reLaunch({
                url: this.url
              })
              return
            default:
              // eslint-disable-next-line no-console
          //    console.error(`<navigator/> with invalid openType ${this.openType}`)
          }
        }
    }
});

for (var i=0; i<elements.length; ++i) {
    var ele = elements[i]
    var observers = {};
    var properties_keys
    if (undefined != ele.properties) {
        properties_keys = Object.keys(ele.properties)
    }
    for (var j=0; j<properties_keys.length; ++j) {
        var key = properties_keys[j];
        if (key == 'hoverClass') {
            continue;
        }
        (function(property){
            observers[property] = function(newVal) {
                var value;
                if (typeof(newVal) == 'object') {
                    value = JSON.stringify(newVal);
                } else {
                    value = newVal + '';
                }
                // console.error('garryyan observers, property:' + property + ", value:" + value + ", id:" + this.$$.innerId + 'type:' + typeof(newVal))
                cppNatives.setAttr(cppNativesId, this.$$.innerId, property, value)
            }
        })(key);
    }

    var listeners = {}
    var methods = {}
    if (undefined != ele.listeners) {
        listeners = ele.listeners
    }
    if (undefined != ele.methods) {
        methods = ele.methods
        methods.getClassPrefix = function() {
            if (this.ownerShadowRoot) {
                var prefix = this.classList._prefix
                if (prefix) return prefix + '--'
            }
            return ''
        }
        methods.processClassItem = function(name) {
            var classValue = this.data[name];
            if (classValue == undefined || classValue == '') return;
            var prefix = this.getClassPrefix();
            if (prefix != '') {
                var classList = classValue.split(' ')
                classValue = ''
                for (var i = 0, len = classList.length; i < len; i++) {
                    if (classList[i] == '') continue;
                    if (classValue != '') classValue += ' '
                    classValue += prefix + classList[i];
                }
            }
            console.error('garryyan processClass, value=' + classValue)
            cppNatives.setAttr(cppNativesId, this.$$.innerId, name, classValue)
        }
    }


    exparser.registerElement({
        is: ele.is,
        properties: ele.properties,
        observers: observers,
        methods: methods,
        listeners: listeners,
        attached: function() {
            if (undefined != this.processClass) {
                this.processClass()
            }
        },
    })

}

//console.error('garryyan after registerElement:' + Object.keys(exparser.Component._list).join(' '))
})(this);

var NO_BUBBLE_EVENTS = ['scroll', 'load', 'focus', 'confirm', 'blur', 'timeupdate', 'scrolltoupper', 'scrolltolower', 'change']
function customBackendTriggerEvent(innerId, eventName, detail) {
    if (!(innerId in custom_backend_nodes)) {
        console.error("not in custom_backend_nodes:" + innerId)
        return
    }

    // console.error('garryyan customBackendTriggerEvent:' + innerId + ', event:' + eventName + ', detail:' + detail)
    
    var targetNode = custom_backend_nodes[innerId];
    var detailJson = JSON.parse(detail)
    if (NO_BUBBLE_EVENTS.includes(eventName)) {
        exparser.triggerEvent(
            targetNode,
            eventName,
            detailJson
        );
        if (eventName == 'scroll') {
            scrollTop = detailJson['scrollTop']
            // for createIntersectionObserver， 所有容器组件在产生定位偏移时必须要调用一下这个触发器，例如 scroll 和transform
            __virtualDOM__.scheduleIntersectionUpdate()
        }

        return
    }
    exparser.triggerEvent(
        targetNode.shadowRoot, // 触发事件的节点， 触摸类事件的这个值永远是 touchstart 时手指位于的节点
        eventName,
        'detail', // 由具体组件逻辑决定
        {
          // 事件的配置，由具体组件逻辑决定
          bubbles: true, // 是否冒泡（在触摸类事件上为 true ，其他事件一般为 false ）
          composed: true, // 是否在 composed tree 上冒泡（在触摸类事件上为 true ，其他事件绝大多数为 false ）
          capturePhase: true, // 是否具有 capture 阶段（在触摸类事件上为 true ，其他事件一般为 false ）
          type: detailJson.type || '',
          extraFields: {
            _requireActive:
                eventName == "tap" ||
                eventName == "longtap" ||
                eventName == "canceltap" ||
                eventName == "longpress" ||
                eventName == "submit"
                ? true : false,//_requireActive: true 时候才会命中公共库的重复点击拦截逻辑。
            // 仅 touch 类事件具有
            touches: [{ // 还在屏幕上的每个手指有个这个 Touch 对象
              identifier: 0,// 这个触摸序列的唯一标识符
              target: targetNode,  // touchstart 时的目标节点
              clientX: detailJson.clientX||0, // 触摸位置相对于可视区域的横坐标
              clientY: detailJson.clientY||0, // 触摸位置相对于可视区域的纵坐标
              pageX: detailJson.pageX||0, // 触摸位置相对于页面的横坐标
              pageY: detailJson.pageY||0, // 触摸位置相对于页面的纵坐标
            }],
            changedTouches: [
                { // 还在屏幕上的每个手指有个这个 Touch 对象
                    identifier: 0, // 这个触摸序列的唯一标识符
                    target: targetNode.shadowRoot, // touchstart 时的目标节点
                    clientX: detailJson.clientX||0, // 触摸位置相对于可视区域的横坐标
                    clientY: detailJson.clientY||0, // 触摸位置相对于可视区域的纵坐标
                    pageX: detailJson.pageX||0, // 触摸位置相对于页面的横坐标
                    pageY: detailJson.pageY||0, // 触摸位置相对于页面的纵坐标
                }
            ], // 与前者类似，但包含的是所有改变了的 Touch 对象；在 touchend 事件中，结束触摸的 Touch 不在 touches 中，而是在这个对象中
            }
        }
    );
}

function generateInputEventData(innerId) {
//    console.error('garryyan generateInputEventData:' + innerId)
    var targetNode = custom_backend_nodes[innerId]
    var data = JSON.stringify(targetNode.generateEventData())

    return data
}


function onLayoutComplete() {
    var callback = render_callback.shift()
    if (undefined != callback) {
        callback()
    }
}

