package com.tencent.mm.plugin.facedetectaction.ui;

import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class FaceActionUI$4
  implements Runnable
{
  FaceActionUI$4(FaceActionUI paramFaceActionUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(104242);
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)FaceActionUI.k(this.AaH).getLayoutParams();
    localMarginLayoutParams.topMargin = ((int)(FaceActionUI.l(this.AaH).getHeight() * 0.4D));
    FaceActionUI.k(this.AaH).setLayoutParams(localMarginLayoutParams);
    FaceActionUI.k(this.AaH).setVisibility(0);
    AppMethodBeat.o(104242);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.ui.FaceActionUI.4
 * JD-Core Version:    0.7.0.1
 */