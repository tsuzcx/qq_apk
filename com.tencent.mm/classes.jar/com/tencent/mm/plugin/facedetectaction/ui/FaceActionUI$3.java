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
    AppMethodBeat.i(104242);
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)FaceActionUI.j(this.rys).getLayoutParams();
    localMarginLayoutParams.topMargin = ((int)(FaceActionUI.k(this.rys).getHeight() * 0.4D));
    FaceActionUI.j(this.rys).setLayoutParams(localMarginLayoutParams);
    FaceActionUI.j(this.rys).setVisibility(0);
    AppMethodBeat.o(104242);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.ui.FaceActionUI.3
 * JD-Core Version:    0.7.0.1
 */