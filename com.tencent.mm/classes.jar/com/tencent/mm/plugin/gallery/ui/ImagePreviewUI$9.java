package com.tencent.mm.plugin.gallery.ui;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;

final class ImagePreviewUI$9
  implements Runnable
{
  ImagePreviewUI$9(ImagePreviewUI paramImagePreviewUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(150882);
    int i = (int)ah.getContext().getResources().getDimension(2131427772);
    int j = this.ngC.getResources().getDisplayMetrics().widthPixels / 7;
    ImagePreviewUI.p(this.ngC).getLayoutParams().height = (i * 2 + j);
    ImagePreviewUI.p(this.ngC).smoothScrollToPosition(ImagePreviewUI.g(this.ngC).intValue());
    AppMethodBeat.o(150882);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.ImagePreviewUI.9
 * JD-Core Version:    0.7.0.1
 */