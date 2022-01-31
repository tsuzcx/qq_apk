package com.tencent.mm.plugin.facedetectaction.ui;

import android.view.ViewGroup.MarginLayoutParams;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.ap;

final class FaceActionUI$4
  implements Runnable
{
  FaceActionUI$4(FaceActionUI paramFaceActionUI) {}
  
  public final void run()
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)FaceActionUI.m(this.jWU).getLayoutParams();
    int i = (int)(FaceActionUI.l(this.jWU).getHeight() * 0.4D) + (int)(FaceActionUI.l(this.jWU).getWidth() * 0.35D) + ap.fromDPToPix(this.jWU, 30);
    localMarginLayoutParams.topMargin = i;
    y.i("MicroMsg.FaceActionUI", "topMargin：%d", new Object[] { Integer.valueOf(i) });
    FaceActionUI.m(this.jWU).setLayoutParams(localMarginLayoutParams);
    FaceActionUI.m(this.jWU).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.ui.FaceActionUI.4
 * JD-Core Version:    0.7.0.1
 */