package com.tencent.mm.plugin.facedetect.views;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class FaceDetectCameraView$1
  implements Runnable
{
  FaceDetectCameraView$1(FaceDetectCameraView paramFaceDetectCameraView) {}
  
  public final void run()
  {
    AppMethodBeat.i(572);
    this.mot.a(FaceDetectCameraView.b(this.mot), FaceDetectCameraView.c(this.mot));
    FaceDetectCameraView.a(this.mot, false);
    AppMethodBeat.o(572);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView.1
 * JD-Core Version:    0.7.0.1
 */