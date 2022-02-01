
var luggageLiteContext

(function(glob){

var custom_backend_nodes = {};

var scrollTop = 0;


// cpp interface
var cppNatives = glob.cppNatives
var cppNativesId = cppNatives.id
var id = 0
var rootNodeId = 0
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
}

Element.prototype.insertChild = function(child, index) {
//    console.error('garryyan insertChild....')
    cppNatives.insertChild(cppNativesId, this.innerId, child.innerId, index)
}

Element.prototype.removeChild = function(index) {
//    console.error('garryyan removeChild....')
    cppNatives.removeChild(cppNativesId, this.innerId, index)
}

Element.prototype.replaceChild = function(child, index) {
//    console.error('garryyan replaceChild. innerid:' + this.innerId + ', child id:' + child.innerId + ', index:' + index)
    cppNatives.replaceChild(cppNativesId, this.innerId, child.innerId, index)
}

Element.prototype.splice = function(index, deleteCount, other) {
//    console.error('garryyan splice id:' + this.innerId + ", index:" + index + ", deleteCount:" + deleteCount + ", other:" + other.innerId)
    cppNatives.spliceChild(cppNativesId, this.innerId, index, deleteCount, other.innerId,)
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
}

Element.prototype.setClass = function(clazz) {
//    console.error('garryyan setClass id:' + this.innerId + ", clzz:" + clazz)
    cppNatives.setClass(cppNativesId, this.innerId, clazz)
}

Element.prototype.setStyle = function(style) {
    if (this.tagName == 'wx-swiper-item') {
        return;
    }
//    console.error('garryyan setStyle id:' + this.innerId + ", style:" + style)
    cppNatives.setStyle(cppNativesId, this.innerId, style)
}

Element.prototype.setText = function(text) {
    // &nbsp;
    text = text.trim().replace(/&nbsp;/g, ' ')
//    console.error('garryyan setText text:' + text + ", id:" + this.innerId)
    cppNatives.setText(cppNativesId, this.innerId, text)
}

Element.prototype.getBoundingClientRect = function() {
    cppNatives.requestLayout(cppNativesId);
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
//    console.error('garryyan getScrollPosition' + this.innerId)
    cppNatives.requestLayout(cppNativesId)
    var ret = cppNatives.getScrollPosition(cppNativesId, this.innerId)
    return JSON.parse(ret)
}

Element.prototype.setScrollPosition = function(detail) {
//    console.error('garryyan setScrollPosition:' + JSON.stringify(detail))
    cppNatives.setScrollPosition(cppNativesId, this.innerId, JSON.stringify(detail))
}

Element.prototype.setAttr = function(key, val) {
    cppNatives.setAttr(cppNativesId, key, val)
}


var Context = function() {
}

Context.prototype.appendStyleSheet = function(styleText) {
//    console.error('garryyan appendStyleSheet:' + styleText)
    cppNatives.appendStyle(cppNativesId, styleText)
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
}


/*

创建 root结点的方法：
    目前是先创建结点，然后再通过setRootNode把结点设为root 结点

name 统一设置成 "empty"

tagName 和小程序组件的对应关系：

"" -> <string>
"wx-view" -> <view>
"wx-button" -> <button>
"wx-page" -> <page>
"wx-image" -> <image>

*/
Context.prototype.createElement = function(name, tagName) {
    var ele = new Element();

    ele.name = name
    ele.count++
    ele.tagName = tagName
//    console.error("garryyan createElement name:" + name + ", tagName:" + tagName + ", id:" + ele.innerId)
    cppNatives.createElement(cppNativesId, ele.innerId, name, tagName)

    return ele
}

Context.prototype.render = function(callback) {
//    console.error('garryyan render')
    cppNatives.requestLayout(cppNativesId)
    callback()
}

Context.prototype.getNodeUnderPoint = function(left, top) {
//    console.error('garryyan unimplemented getNodeUnderPoint:' + left + ', top:' + top)
    // TODO garryyan
}

Context.prototype.replaceStyleSheet = function(index, styleText) {
//    console.error('garryyan replaceStyleSheet')
    cppNatives.replaceStyle(cppNativesId, index, styleText)
}

Context.prototype.clearStyleSheets = function() {
//    console.error('garryyan clearStyleSheets')
    cppNatives.clearStyle(cppNativesId)
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

luggageLiteContext = new Context()

})(this);



