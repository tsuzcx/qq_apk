(function(global) {
  var __NativeGlobal = global.NativeGlobal;
  var __WeixinCanvas = global.WeixinCanvas;
  if (__WeixinCanvas) {
    delete global.WeixinCanvas;
  }
  if (__WeixinCanvas && __NativeGlobal
    && typeof __NativeGlobal.findElementById === 'function'
    && __NativeGlobal.EventHandler
    && typeof __NativeGlobal.EventHandler.addEventListener === 'function'
    && typeof __NativeGlobal.EventHandler.removeEventListener === 'function') {

      __NativeGlobal.bindFrameSet = function(id) {
        // console.log('bindFrameSet', id, __WeixinCanvas);
        if (!__WeixinCanvas.hasFrameSet(id)) return null;
        return {
          get id() {
            return id;
          },
          get name() {
            return __WeixinCanvas.getFrameSetName(id);
          },
          get width() {
            return __WeixinCanvas.getFrameSetWidth(id);
          },
          get height() {
            return __WeixinCanvas.getFrameSetHeight(id);
          },
          createCanvas() {
            var canvasId = __WeixinCanvas.createCanvas(id);
            var canvas = __NativeGlobal.findElementById(canvasId);
            wrap(canvasId, canvas);
            return canvas;
          }
        };
      };
    function toArray(args) { return Array.prototype.slice.call(args); }
    function wrap(id, canvas) {
      if (!__WeixinCanvas.has(id)) {
        return
      }
      const style = {
        set left(left) {
          __WeixinCanvas.setLeft(id, left);
        },
        get left() {
            return __WeixinCanvas.getLeft(id);
        },
        set top(top) {
            __WeixinCanvas.setTop(id, top);
        },
        get top() {
            return __WeixinCanvas.getTop(id);
        },
        set width(width) {
            __WeixinCanvas.setWidth(id, width);
        },
        get width() {
            return __WeixinCanvas.getWidth(id);
        },
        set height(height) {
            __WeixinCanvas.setHeight(id, height);
        },
        get height() {
            return __WeixinCanvas.getHeight(id);
        }
      };
      Object.defineProperties(canvas, {
        __wrapped__: {
            value: true
        },
        id: {
            value: id,
            enumerable: true
        },
        style: {
          value: style,
          enumerable: true
        },
        remove: {
          value: function() {
            if (__WeixinCanvas.has(id) && !canvas.__has_destroy__) {
              __WeixinCanvas.remove(id);
              canvas.destroy();
              canvas.__has_destroy__ = true;
            } else {
              throw `canvas#${id} had been removed before`;
            }
          }
        },
        createImage: {
            value: function() {
                return new NativeGlobal.Image();
            }
        },
        addEventListener: {
          value: function(event, callback, options) {
            if (typeof callback != 'function') return;
            var __wrapper__ = function(e) {
              if (e.target == canvas) {
                callback.apply(this, toArray(arguments));
              }
            };
            callback['__wrapper__'] = __wrapper__;
            return __NativeGlobal.EventHandler.addEventListener(event, __wrapper__, options);
          },
          enumerable: true
        },
        removeEventListener: {
          value: function(event, callback, options) {
            if (typeof callback != 'function' || typeof callback['__wrapper__'] != 'function') return;
            var __wrapper__ = callback['__wrapper__'];
            delete callback['__wrapper__'];
            return __NativeGlobal.EventHandler.removeEventListener(event, __wrapper__, options);
          },
          enumerable: true
        }
      });
    }

    // var findElementById = __NativeGlobal.findElementById;
    // __NativeGlobal.findElementById = function(id) {
    //   var canvas = findElementById.apply(__NativeGlobal, toArray(arguments));
    //   if (canvas && !canvas.__wrapped__) {
    //     wrap(id, canvas);
    //   }
    //   return canvas;
    // };
  }
})(this);