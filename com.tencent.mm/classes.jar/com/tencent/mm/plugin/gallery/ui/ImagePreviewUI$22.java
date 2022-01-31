package com.tencent.mm.plugin.gallery.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.sdk.platformtools.ab;

final class ImagePreviewUI$22
  implements Runnable
{
  ImagePreviewUI$22(ImagePreviewUI paramImagePreviewUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(21520);
    if (this.ngC.isFinishing())
    {
      ab.i("MicroMsg.ImagePreviewUI", "image-preview is finished");
      AppMethodBeat.o(21520);
      return;
    }
    ImagePreviewUI.b(this.ngC, CaptureMMProxy.getInstance().useMediaRecordNew());
    this.ngC.initView();
    AppMethodBeat.o(21520);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.ImagePreviewUI.22
 * JD-Core Version:    0.7.0.1
 */