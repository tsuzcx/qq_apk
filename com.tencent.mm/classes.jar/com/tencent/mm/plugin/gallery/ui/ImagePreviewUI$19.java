package com.tencent.mm.plugin.gallery.ui;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;

final class ImagePreviewUI$19
  implements Runnable
{
  ImagePreviewUI$19(ImagePreviewUI paramImagePreviewUI, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(111582);
    RecyclerView localRecyclerView = ImagePreviewUI.r(this.Cdw);
    com.tencent.mm.hellhoundlib.b.a locala = c.a(this.CdC, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.b(localRecyclerView, locala.aFh(), "com/tencent/mm/plugin/gallery/ui/ImagePreviewUI$26", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
    localRecyclerView.smoothScrollToPosition(((Integer)locala.sf(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(localRecyclerView, "com/tencent/mm/plugin/gallery/ui/ImagePreviewUI$26", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
    AppMethodBeat.o(111582);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.ImagePreviewUI.19
 * JD-Core Version:    0.7.0.1
 */