package com.tencent.mm.plugin.gallery.picker.view;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.ui.WxCropOperationLayout.j;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run", "com/tencent/mm/plugin/gallery/picker/view/ImageCropUI$initMattingCropLayout$1$1$1$1"})
final class ImageCropUI$r$1$1
  implements Runnable
{
  ImageCropUI$r$1$1(ImageCropUI.r.1 param1) {}
  
  public final void run()
  {
    AppMethodBeat.i(196920);
    this.tyi.rEJ.rEI.a(ImageCropUI.a(this.tyi.rEJ.rEv, ImageCropUI.n(this.tyi.rEJ.rEv)[0], ImageCropUI.n(this.tyi.rEJ.rEv)[1], this.tyi.rEJ.rEI.getWidth(), this.tyi.rEJ.rEI.getHeight()), WxCropOperationLayout.j.LpL);
    WxMediaCropLayout.a(this.tyi.rEJ.rEI, System.currentTimeMillis(), ImageCropUI.m(this.tyi.rEJ.rEv), true, null, this.tyi.rEJ.rEv.rEs, 8);
    AppMethodBeat.o(196920);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.picker.view.ImageCropUI.r.1.1
 * JD-Core Version:    0.7.0.1
 */