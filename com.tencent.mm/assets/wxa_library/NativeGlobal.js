var NativeGlobal = function (window) {

    var _public = {};

    var ej = new Ejecta.EjectaCore();

    var DestructiveObjectEventHandler = Ejecta.DestructiveObjectEventHandler;

    _public.__wxConfig = window.__wxConfig;

    _public.EventHandler = function () {
        var result = {};
        result.ontouchstart = undefined;
        result.ontouchend = undefined;
        result.ontouchmove = undefined;
        result.ontouchcancel = undefined;
        var destructiveEventHandler = new DestructiveObjectEventHandler();
        Object.defineProperty(result, "onbindingobjectdestruct", {set: function (listener) {
            destructiveEventHandler.onbindingobjectdestruct = listener;
        }});
        result.__triggerTouchEvent__ = function () {

            function Touch(native, index) {
                this.id = this.identifier = native[index];
                this.pageX = this.clientX = this.screenX = native[index + 1];
                this.pageY = this.clientY = this.screenY = native[index + 2];
                this.pressure = native[index + 3];
                return this;
            }

            function _touches(pointers, length, stride) {
                var j = 0;
                var result = [];
                for (; j < length; j++) {
                    result.push(new Touch(pointers, j * stride));
                }
                return result;
            }

            var TOUCH_DATA_STRIDE = 4;

            function TouchEvent(pointers, actionIndexList, timeStamp, eventType) {
                if (!pointers || pointers.length === 0 || !actionIndexList || actionIndexList.length === 0) {
                    return null;
                }
                var length = Math.floor(pointers.length / TOUCH_DATA_STRIDE);
                if (length <= 0) {
                    return null;
                }
                this.touches = _touches(pointers, length, TOUCH_DATA_STRIDE);
                this.changedTouches = [];
                for (var i = 0; i < actionIndexList.length; i++) {
                    this.changedTouches.push(this.touches[actionIndexList[i]]);
                    if(eventType == 2 || eventType == 3){
                        this.touches.splice(actionIndexList[i]);
                    }
                }
                this.timeStamp = timeStamp;
                this.stopPropagation = this.preventDefault = function () {
                    // do nothing
                };
                return this;
            }

            return function (native) {
                if (!native || native.length === 0) {
                    return;
                }
                var type = native[3];
                var callback;
                switch (type) {
                    case 0:
                        callback = _public.EventHandler.ontouchstart;
                        break;
                    case 1:
                        callback = _public.EventHandler.ontouchmove;
                        break;
                    case 2:
                        callback = _public.EventHandler.ontouchend;
                        break;
                    case 3:
                        callback = _public.EventHandler.ontouchcancel;
                        break;
                    default:
                }
                if (typeof callback === 'undefined' && typeof callback !== 'function') {
                    return;
                }
                var touchEvent = new TouchEvent(native[0], native[1], native[2], native[3]);
                if (touchEvent === null) {
                    return;
                }
                callback(touchEvent);
            };
        }();
        return result;
    }();

    _public.log = function () {
        if (typeof window.WeixinJSCore === 'undefined') {
            return ej.log;
        }

        var core = window.WeixinJSCore;
        return function (data) {
            core.invokeHandler('logInJava', data, 0);
        };
    }();

    window.requestAnimationFrame = _public.requestAnimationFrame = ej.requestAnimationFrame;
    window.cancelAnimationFrame = _public.cancelAnimationFrame = ej.cancelAnimationFrame;
    // Timers
    window.setTimeout = _public.setTimeout = ej.setTimeout;
    window.clearTimeout = _public.clearTimeout = ej.clearTimeout;
    _public.setInterval = ej.setInterval;
    _public.clearInterval = ej.clearInterval;

    _public.Canvas = Ejecta.Canvas;
    _public.SharedCanvas = Ejecta.SharedCanvas;
    _public.Image = Ejecta.Image;
    _public.Audio = Ejecta.Audio;
    _public.performanceNow = window.performanceNow = ej.performanceNow;

    _public.loadFont = function (path) {
        return ej.loadFont(path);
    };

    _public.getTextLineHeight = ej.getTextLineHeight
    _public.XMLReader = Ejecta.XMLReader;
    _public.encodeArrayBuffer = ej.encodeArrayBuffer;
    _public.decodeArrayBuffer = ej.decodeArrayBuffer;
    _public.BindingObject = Ejecta.DestructiveObject;
    _public.setPreferredFramesPerSecond = (function () {
        var core = window.WeixinJSCore;
        return function (fps) {
            var data = {'fps': fps };
            core.invokeHandler('setPreferredFramesPerSecond', JSON.stringify(data), 0);
        };
    })();
    _public.gc = gc;
    gc = undefined;

    return _public;
}(this);
Object.defineProperty(this, "__WxNativeHandler__", {value: {}});
Object.defineProperty(__WxNativeHandler__, "__triggerTouchEvent__", {
    value: NativeGlobal.EventHandler.__triggerTouchEvent__
});
Ejecta = undefined;
