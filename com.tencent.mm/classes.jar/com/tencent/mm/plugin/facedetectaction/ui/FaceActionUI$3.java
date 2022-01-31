package com.tencent.mm.plugin.facedetectaction.ui;

import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class FaceActionUI$3
  implements Runnable
{
  FaceActionUI$3(FaceActionUI paramFaceActionUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(720);
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)FaceActionUI.k(this.mrl).getLayoutParams();
    localMarginLayoutParams.topMargin = ((int)(FaceActionUI.l(this.mrl).getHeight() * 0.4D));
    FaceActionUI.k(this.mrl).setLayoutParams(localMarginLayoutParams);
    FaceActionUI.k(this.mrl).setVisibility(0);
    AppMethodBeat.o(720);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.ui.FaceActionUI.3
 * JD-Core Version:    0.7.0.1
 */