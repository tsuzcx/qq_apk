package com.tencent.mm.plugin.gallery.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.model.e;
import com.tencent.mm.plugin.gallery.model.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class ImagePreviewUI$12
  implements Runnable
{
  ImagePreviewUI$12(ImagePreviewUI paramImagePreviewUI, long paramLong) {}
  
  public final void run()
  {
    AppMethodBeat.i(21510);
    ImagePreviewUI.a(this.ngC, true);
    e.bDR().wL(-8);
    ab.v("MicroMsg.ImagePreviewUI", "test oncreate post: %d", new Object[] { Long.valueOf(bo.av(this.ngG)) });
    AppMethodBeat.o(21510);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.ImagePreviewUI.12
 * JD-Core Version:    0.7.0.1
 */