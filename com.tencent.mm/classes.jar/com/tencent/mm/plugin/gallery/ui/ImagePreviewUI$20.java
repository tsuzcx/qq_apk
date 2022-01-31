package com.tencent.mm.plugin.gallery.ui;

import android.support.v7.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ImagePreviewUI$20
  implements Runnable
{
  ImagePreviewUI$20(ImagePreviewUI paramImagePreviewUI, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(21519);
    ImagePreviewUI.p(this.ngC).smoothScrollToPosition(this.ngI);
    AppMethodBeat.o(21519);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.ImagePreviewUI.20
 * JD-Core Version:    0.7.0.1
 */