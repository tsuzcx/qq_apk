package com.tencent.mm.plugin.facedetectaction.ui;

import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;

final class FaceActionUI$3
  implements Runnable
{
  FaceActionUI$3(FaceActionUI paramFaceActionUI) {}
  
  public final void run()
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)FaceActionUI.k(this.jWU).getLayoutParams();
    localMarginLayoutParams.topMargin = ((int)(FaceActionUI.l(this.jWU).getHeight() * 0.4D));
    FaceActionUI.k(this.jWU).setLayoutParams(localMarginLayoutParams);
    FaceActionUI.k(this.jWU).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.ui.FaceActionUI.3
 * JD-Core Version:    0.7.0.1
 */