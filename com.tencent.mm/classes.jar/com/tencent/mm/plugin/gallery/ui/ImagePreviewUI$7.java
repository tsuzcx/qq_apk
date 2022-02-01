package com.tencent.mm.plugin.gallery.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.plugin.gallery.b.c;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

final class ImagePreviewUI$7
  implements Runnable
{
  ImagePreviewUI$7(ImagePreviewUI paramImagePreviewUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(111565);
    int i = (int)MMApplicationContext.getContext().getResources().getDimension(b.c.LargePadding);
    int j = this.Cdw.getResources().getDisplayMetrics().widthPixels / 7;
    ImagePreviewUI.r(this.Cdw).getLayoutParams().height = (i * 2 + j);
    RecyclerView localRecyclerView = ImagePreviewUI.r(this.Cdw);
    com.tencent.mm.hellhoundlib.b.a locala = c.a(ImagePreviewUI.g(this.Cdw).intValue(), new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.b(localRecyclerView, locala.aFh(), "com/tencent/mm/plugin/gallery/ui/ImagePreviewUI$15", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
    localRecyclerView.smoothScrollToPosition(((Integer)locala.sf(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(localRecyclerView, "com/tencent/mm/plugin/gallery/ui/ImagePreviewUI$15", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
    AppMethodBeat.o(111565);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.ImagePreviewUI.7
 * JD-Core Version:    0.7.0.1
 */