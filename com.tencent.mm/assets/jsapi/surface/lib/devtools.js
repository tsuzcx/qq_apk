(function(global) {
    if (DevtoolsMessage) {
        var _DevtoolsMessage = DevtoolsMessage;
        WeixinJSBridge.on('devtools:receive', function(msg) {
            _DevtoolsMessage.onreceive && _DevtoolsMessage.onreceive.call(_DevtoolsMessage, msg)
        });
    }
})(this);



