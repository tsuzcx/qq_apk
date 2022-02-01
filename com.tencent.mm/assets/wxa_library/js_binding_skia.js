
;(function(global) {
    try {
        NativeGlobal = typeof NativeGlobal === 'object' ? NativeGlobal : {};

        // new
        NativeGlobal.SkiaCanvas = global.Canvas;
        NativeGlobal.SkiaCanvasView = global.CanvasView;
        NativeGlobal.SkiaImages = global.Image;
        NativeGlobal.SkiaImage = global.Image;
        NativeGlobal.SkiaImageData = global.ImageData;
        NativeGlobal.SkiaPath2D = global.Path2D;
        NativeGlobal.SkiaCanvasLoadNewFont = global.skiacanvasLoadNewFont;
        NativeGlobal.SkiaCanvasRequestAnimationFrame = global.skiacanvasRequestAnimationFrame;
        NativeGlobal.SkiaCanvasCancelAnimationFrame = global.skiacanvasCancelAnimationFrame;

        //NativeGlobal.globalSkiaCanvasView = new global.CanvasView(3);
        //console.log("skia globalSkiaCanvasView", NativeGlobal.globalSkiaCanvasView.id);

        // old
        NativeGlobal.HTMLCanvasView = {
             createView: function(id) {
                 return new NativeGlobal.SkiaCanvasView(id);
             }
         }

        NativeGlobal.HTMLCanvasElement = {
            createElement: function(canvasView) {
                return new NativeGlobal.SkiaCanvas(canvasView.id)
            }
        };

        console.info("skia inject success");
    } catch (err) {
        console.error("skia inject fail", err);
    }
})(this);
