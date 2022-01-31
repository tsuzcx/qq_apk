package com.tencent.mm.plugin.gallery.ui;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.mm.R.f;
import com.tencent.mm.compatible.util.j;

final class ImagePreviewUI$21
  implements Runnable
{
  ImagePreviewUI$21(ImagePreviewUI paramImagePreviewUI) {}
  
  public final void run()
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)ImagePreviewUI.a(this.kKb).getLayoutParams();
    localMarginLayoutParams.topMargin = ((int)(j.V(this.kKb) + this.kKb.getResources().getDimension(R.f.DefaultActionbarHeightPort)));
    ImagePreviewUI.a(this.kKb).setLayoutParams(localMarginLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.ImagePreviewUI.21
 * JD-Core Version:    0.7.0.1
 */