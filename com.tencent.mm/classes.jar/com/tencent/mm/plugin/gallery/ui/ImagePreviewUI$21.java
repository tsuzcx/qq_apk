package com.tencent.mm.plugin.gallery.ui;

import android.support.v7.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ImagePreviewUI$21
  implements Runnable
{
  ImagePreviewUI$21(ImagePreviewUI paramImagePreviewUI, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(150895);
    ImagePreviewUI.p(this.ngC).smoothScrollToPosition(this.ngJ);
    AppMethodBeat.o(150895);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.ImagePreviewUI.21
 * JD-Core Version:    0.7.0.1
 */