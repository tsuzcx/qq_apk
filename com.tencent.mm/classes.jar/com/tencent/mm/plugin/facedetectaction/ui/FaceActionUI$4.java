package com.tencent.mm.plugin.facedetectaction.ui;

import android.view.ViewGroup.MarginLayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.al;

final class FaceActionUI$4
  implements Runnable
{
  FaceActionUI$4(FaceActionUI paramFaceActionUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(721);
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)FaceActionUI.m(this.mrl).getLayoutParams();
    int i = (int)(FaceActionUI.l(this.mrl).getHeight() * 0.4D) + (int)(FaceActionUI.l(this.mrl).getWidth() * 0.35D) + al.fromDPToPix(this.mrl, 30);
    localMarginLayoutParams.topMargin = i;
    ab.i("MicroMsg.FaceActionUI", "topMargin：%d", new Object[] { Integer.valueOf(i) });
    FaceActionUI.m(this.mrl).setLayoutParams(localMarginLayoutParams);
    FaceActionUI.m(this.mrl).setVisibility(0);
    AppMethodBeat.o(721);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.ui.FaceActionUI.4
 * JD-Core Version:    0.7.0.1
 */