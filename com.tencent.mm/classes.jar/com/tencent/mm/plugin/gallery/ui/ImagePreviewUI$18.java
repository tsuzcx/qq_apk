package com.tencent.mm.plugin.gallery.ui;

import android.support.v7.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;

final class ImagePreviewUI$18
  implements Runnable
{
  ImagePreviewUI$18(ImagePreviewUI paramImagePreviewUI, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(111581);
    RecyclerView localRecyclerView = ImagePreviewUI.p(this.xrb);
    com.tencent.mm.hellhoundlib.b.a locala = c.a(this.xrg, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, locala.axQ(), "com/tencent/mm/plugin/gallery/ui/ImagePreviewUI$25", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
    localRecyclerView.smoothScrollToPosition(((Integer)locala.pG(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, "com/tencent/mm/plugin/gallery/ui/ImagePreviewUI$25", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
    AppMethodBeat.o(111581);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.ImagePreviewUI.18
 * JD-Core Version:    0.7.0.1
 */