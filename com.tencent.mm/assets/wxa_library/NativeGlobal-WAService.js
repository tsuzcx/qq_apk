;NativeGlobal.setTimeout = this.setTimeout;
NativeGlobal.clearTimeout = this.clearTimeout;
NativeGlobal.setInterval = this.setInterval;
NativeGlobal.clearInterval = this.clearInterval;
(function(){
let OffscreenCanvas = NativeGlobal.OffscreenCanvas;
NativeGlobal.OffscreenCanvas = function(width, height) {
return new OffscreenCanvas(width, height, {forbiddenContextTypes:['2d']});
}
let viewIdTransfer = MagicBrushViewIdTransfer;
let findElementById = NativeGlobal.findElementById;
NativeGlobal.findElementById = function(viewId) {
if (typeof viewIdTransfer === 'undefined') {
    console.error("HTMLCanvasElement ViewId Transfer not found.");
}
return findElementById(viewIdTransfer.exec(viewId));
}
})();
MagicBrushViewIdTransfer = undefined;
