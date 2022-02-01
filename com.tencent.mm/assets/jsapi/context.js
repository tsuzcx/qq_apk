const { addEventListener, removeEventListener, postMessage, dispatchEvent, callbackWrapper, registerMethod, invokeMethod } = (function() {
  var eventMap = {};
  var methodMap = {};
  var messenger = { postMessage: function() {} };
  if (typeof wxMessage !== 'undefined') {
    messenger = wxMessage;
    delete wxMessage;
  }
  return {
    addEventListener : function (eventType, listener) {
      if (eventMap.hasOwnProperty(eventType)) {
        var eventDispatcher = eventMap[eventType];
        var index = eventDispatcher.indexOf(listener);
        if (index == -1) {
          eventDispatcher.push(listener);
        }
      } else {
        eventMap[eventType] = [listener];
      }
    },
    removeEventListener : function (eventType, listener) {
      if (!eventMap.hasOwnProperty(eventType)) { return; }
      var eventDispatcher = eventMap[eventType];
      var index = eventDispatcher.indexOf(listener);
      if (index != -1) {
        eventDispatcher.splice(index, 1);
      }
    },
    postMessage : function(message, targetOrigin) {
      messenger.postMessage(message, targetOrigin);
    },
    dispatchEvent : function(eventType, event) {
      if (!eventMap.hasOwnProperty(eventType)) { return; }
      var eventDispatcher = eventMap[eventType];
      for (var i = 0; i < eventDispatcher.length; i++) {
        eventDispatcher[i](event);
      }
    },
    registerMethod : function(name, method) {
        methodMap[name] = method;
    },
    invokeMethod : function(name, params) {
        return typeof methodMap[name] === 'function' && methodMap[name](params);
    },
    callbackWrapper : function(callback) {
      if (typeof callback !== 'function') {
        return ""
      }
      var callbackId = "__callbackId:" + new Date().getTime() + "_" + Math.round(Math.random() * 10000);
      var callbackWrapper = function() {
        removeEventListener(callbackId, callbackWrapper);
        callback.apply(null, Array.from(arguments));
      };
      addEventListener(callbackId, callbackWrapper);
      return callbackId;
    }
  }
})();