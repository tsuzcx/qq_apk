

(function(glob){

var customContext = luggageLiteContext
var root = customContext.createElement("empty", "wx-page")
customContext.setRootNode(root)

var view = customContext.createElement("empty", "wx-view")

var str = customContext.createElement("empty", "")
str.setText("Hello World2!----------------")
view.appendChild(str)
root.appendChild(view)

var style = "wx-view {color: red;font-size: 22px;}"

customContext.appendStyleSheet(style)

customContext.render(function() {})

})(this)
