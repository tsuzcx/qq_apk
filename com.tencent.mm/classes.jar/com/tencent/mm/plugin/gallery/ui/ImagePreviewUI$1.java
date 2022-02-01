package com.tencent.mm.plugin.gallery.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

final class ImagePreviewUI$1
  implements Runnable
{
  ImagePreviewUI$1(ImagePreviewUI paramImagePreviewUI, long paramLong) {}
  
  public final void run()
  {
    AppMethodBeat.i(111559);
    ImagePreviewUI.a(this.tZM, true);
    ae.v("MicroMsg.ImagePreviewUI", "test oncreate post: %d", new Object[] { Long.valueOf(bu.aO(this.tZL)) });
    AppMethodBeat.o(111559);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.ImagePreviewUI.1
 * JD-Core Version:    0.7.0.1
 */