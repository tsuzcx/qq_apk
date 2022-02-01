package com.tencent.mm.plugin.facedetectaction.ui;

import android.view.ViewGroup.MarginLayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.ao;

final class FaceActionUI$4
  implements Runnable
{
  FaceActionUI$4(FaceActionUI paramFaceActionUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(104243);
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)FaceActionUI.l(this.pXP).getLayoutParams();
    int i = (int)(FaceActionUI.k(this.pXP).getHeight() * 0.4D) + (int)(FaceActionUI.k(this.pXP).getWidth() * 0.35D) + ao.fromDPToPix(this.pXP, 30);
    localMarginLayoutParams.topMargin = i;
    ad.i("MicroMsg.FaceActionUI", "topMargin：%d", new Object[] { Integer.valueOf(i) });
    FaceActionUI.l(this.pXP).setLayoutParams(localMarginLayoutParams);
    FaceActionUI.l(this.pXP).setVisibility(0);
    AppMethodBeat.o(104243);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.ui.FaceActionUI.4
 * JD-Core Version:    0.7.0.1
 */