package com.tencent.mm.plugin.facedetect.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class FaceDetectUI$1
  implements View.OnClickListener
{
  FaceDetectUI$1(FaceDetectUI paramFaceDetectUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(458);
    ab.i("MicroMsg.FaceDetectUI", "hy: user cancelled with left button");
    FaceDetectUI.a(this.mmb);
    AppMethodBeat.o(458);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.FaceDetectUI.1
 * JD-Core Version:    0.7.0.1
 */