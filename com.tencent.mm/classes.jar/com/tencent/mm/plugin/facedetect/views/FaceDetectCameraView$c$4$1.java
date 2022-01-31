package com.tencent.mm.plugin.facedetect.views;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class FaceDetectCameraView$c$4$1
  implements Runnable
{
  FaceDetectCameraView$c$4$1(FaceDetectCameraView.c.4 param4) {}
  
  public final void run()
  {
    AppMethodBeat.i(582);
    ab.v("MicroMsg.FaceDetectCameraView", "hy: on get preview");
    long l1 = bo.yB();
    long l2 = l1 - FaceDetectCameraView.p(this.moD.moB.mot);
    if (FaceDetectCameraView.p(this.moD.moB.mot) >= 0L) {
      ab.v("MicroMsg.FaceDetectCameraView", "hy: tweenMillis: %d", new Object[] { Long.valueOf(l2) });
    }
    if ((FaceDetectCameraView.p(this.moD.moB.mot) < 0L) || (l2 > FaceDetectCameraView.c(this.moD.moB.mot)))
    {
      FaceDetectCameraView.a(this.moD.moB.mot, l1);
      FaceDetectCameraView.b(this.moD.moB.mot, FaceDetectCameraView.o(this.moD.moB.mot));
    }
    AppMethodBeat.o(582);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView.c.4.1
 * JD-Core Version:    0.7.0.1
 */