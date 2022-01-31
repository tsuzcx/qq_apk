package com.tencent.mm.plugin.facedetect.ui;

import com.tencent.mm.plugin.facedetect.a.i;
import com.tencent.mm.plugin.facedetect.views.c;
import com.tencent.mm.sdk.platformtools.y;

final class FaceDetectUI$5
  implements c
{
  FaceDetectUI$5(FaceDetectUI paramFaceDetectUI) {}
  
  public final void qT(int paramInt)
  {
    y.i("MicroMsg.FaceDetectUI", "alvinluo onPreviewInitDone: %d", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt == 0) {
      FaceDetectUI.f(this.jRF);
    }
    do
    {
      return;
      if (paramInt == 1)
      {
        FaceDetectUI.g(this.jRF);
        return;
      }
    } while (paramInt != 2);
    FaceDetectUI.a(this.jRF, "camera permission not granted", this.jRF.getString(a.i.permission_camera_request_again_msg));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.FaceDetectUI.5
 * JD-Core Version:    0.7.0.1
 */