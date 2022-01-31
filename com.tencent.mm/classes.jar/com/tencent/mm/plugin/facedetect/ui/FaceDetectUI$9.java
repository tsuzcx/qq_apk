package com.tencent.mm.plugin.facedetect.ui;

import com.tencent.mm.sdk.platformtools.y;

final class FaceDetectUI$9
  implements FaceDetectUI.a
{
  FaceDetectUI$9(FaceDetectUI paramFaceDetectUI) {}
  
  public final void onFinish()
  {
    y.i("MicroMsg.FaceDetectUI", "alvinluo set result and return to FaceDetectPrepareUI");
    FaceDetectUI.k(this.jRF);
    this.jRF.a(0, 0, "collect data ok", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.FaceDetectUI.9
 * JD-Core Version:    0.7.0.1
 */