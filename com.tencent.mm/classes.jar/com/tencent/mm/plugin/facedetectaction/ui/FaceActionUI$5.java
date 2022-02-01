package com.tencent.mm.plugin.facedetectaction.ui;

import android.view.ViewGroup.MarginLayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.at;

final class FaceActionUI$5
  implements Runnable
{
  FaceActionUI$5(FaceActionUI paramFaceActionUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(104243);
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)FaceActionUI.m(this.sYw).getLayoutParams();
    int i = (int)(FaceActionUI.l(this.sYw).getHeight() * 0.4D) + (int)(FaceActionUI.l(this.sYw).getWidth() * 0.35D) + at.fromDPToPix(this.sYw, 30);
    localMarginLayoutParams.topMargin = i;
    Log.i("MicroMsg.FaceActionUI", "topMargin：%d", new Object[] { Integer.valueOf(i) });
    FaceActionUI.m(this.sYw).setLayoutParams(localMarginLayoutParams);
    FaceActionUI.m(this.sYw).setVisibility(0);
    AppMethodBeat.o(104243);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.ui.FaceActionUI.5
 * JD-Core Version:    0.7.0.1
 */