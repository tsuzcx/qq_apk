package com.tencent.mm.plugin.gallery.ui;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import com.tencent.mm.R.f;
import com.tencent.mm.sdk.platformtools.ae;

final class ImagePreviewUI$8
  implements Runnable
{
  ImagePreviewUI$8(ImagePreviewUI paramImagePreviewUI) {}
  
  public final void run()
  {
    int i = (int)ae.getContext().getResources().getDimension(R.f.LargePadding);
    int j = this.kKb.getResources().getDisplayMetrics().widthPixels / 7;
    ImagePreviewUI.o(this.kKb).getLayoutParams().height = (i * 2 + j);
    ImagePreviewUI.o(this.kKb).smoothScrollToPosition(ImagePreviewUI.g(this.kKb).intValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.ImagePreviewUI.8
 * JD-Core Version:    0.7.0.1
 */