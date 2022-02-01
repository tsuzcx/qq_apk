package com.tencent.mm.plugin.gallery.ui;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.i;

final class ImagePreviewUI$12
  implements Runnable
{
  ImagePreviewUI$12(ImagePreviewUI paramImagePreviewUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(111575);
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)ImagePreviewUI.a(this.xrb).getLayoutParams();
    localMarginLayoutParams.topMargin = ((int)(i.getStatusHeight(this.xrb) + this.xrb.getResources().getDimension(2131165256)));
    ImagePreviewUI.a(this.xrb).setLayoutParams(localMarginLayoutParams);
    AppMethodBeat.o(111575);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.ImagePreviewUI.12
 * JD-Core Version:    0.7.0.1
 */