package com.tencent.mm.plugin.gallery.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

final class ImagePreviewUI$1
  implements Runnable
{
  ImagePreviewUI$1(ImagePreviewUI paramImagePreviewUI, long paramLong) {}
  
  public final void run()
  {
    AppMethodBeat.i(111559);
    ImagePreviewUI.a(this.sSr, true);
    ac.v("MicroMsg.ImagePreviewUI", "test oncreate post: %d", new Object[] { Long.valueOf(bs.aO(this.sSq)) });
    AppMethodBeat.o(111559);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.ImagePreviewUI.1
 * JD-Core Version:    0.7.0.1
 */