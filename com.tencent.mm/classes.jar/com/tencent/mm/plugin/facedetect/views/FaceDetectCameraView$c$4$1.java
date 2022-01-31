package com.tencent.mm.plugin.facedetect.views;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class FaceDetectCameraView$c$4$1
  implements Runnable
{
  FaceDetectCameraView$c$4$1(FaceDetectCameraView.c.4 param4) {}
  
  public final void run()
  {
    y.v("MicroMsg.FaceDetectCameraView", "hy: on get preview");
    long l1 = bk.UZ();
    long l2 = l1 - FaceDetectCameraView.p(this.jUk.jUi.jUa);
    if (FaceDetectCameraView.p(this.jUk.jUi.jUa) >= 0L) {
      y.v("MicroMsg.FaceDetectCameraView", "hy: tweenMillis: %d", new Object[] { Long.valueOf(l2) });
    }
    if ((FaceDetectCameraView.p(this.jUk.jUi.jUa) < 0L) || (l2 > FaceDetectCameraView.c(this.jUk.jUi.jUa)))
    {
      FaceDetectCameraView.a(this.jUk.jUi.jUa, l1);
      FaceDetectCameraView.b(this.jUk.jUi.jUa, FaceDetectCameraView.o(this.jUk.jUi.jUa));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView.c.4.1
 * JD-Core Version:    0.7.0.1
 */