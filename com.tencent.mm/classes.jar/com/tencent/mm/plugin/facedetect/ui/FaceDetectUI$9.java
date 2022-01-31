package com.tencent.mm.plugin.facedetect.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class FaceDetectUI$9
  implements FaceDetectUI.a
{
  FaceDetectUI$9(FaceDetectUI paramFaceDetectUI) {}
  
  public final void onFinish()
  {
    AppMethodBeat.i(469);
    ab.i("MicroMsg.FaceDetectUI", "alvinluo set result and return to FaceDetectPrepareUI");
    FaceDetectUI.k(this.mmb);
    this.mmb.a(0, 0, "collect data ok", null);
    AppMethodBeat.o(469);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.FaceDetectUI.9
 * JD-Core Version:    0.7.0.1
 */