package com.tencent.mm.plugin.facedetectaction.ui;

import android.view.ViewGroup.MarginLayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.aq;

final class FaceActionUI$4
  implements Runnable
{
  FaceActionUI$4(FaceActionUI paramFaceActionUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(104243);
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)FaceActionUI.l(this.rys).getLayoutParams();
    int i = (int)(FaceActionUI.k(this.rys).getHeight() * 0.4D) + (int)(FaceActionUI.k(this.rys).getWidth() * 0.35D) + aq.fromDPToPix(this.rys, 30);
    localMarginLayoutParams.topMargin = i;
    ae.i("MicroMsg.FaceActionUI", "topMargin：%d", new Object[] { Integer.valueOf(i) });
    FaceActionUI.l(this.rys).setLayoutParams(localMarginLayoutParams);
    FaceActionUI.l(this.rys).setVisibility(0);
    AppMethodBeat.o(104243);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.ui.FaceActionUI.4
 * JD-Core Version:    0.7.0.1
 */