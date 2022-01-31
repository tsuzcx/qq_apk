package com.tencent.mm.plugin.facedetect.views;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class FaceDetectView$3
  implements Runnable
{
  FaceDetectView$3(FaceDetectView paramFaceDetectView) {}
  
  public final void run()
  {
    AppMethodBeat.i(622);
    if ((FaceDetectView.d(this.mpb) != null) && (!FaceDetectView.a(this.mpb))) {
      FaceDetectView.d(this.mpb).U(0, "");
    }
    FaceDetectView.bvA();
    AppMethodBeat.o(622);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.views.FaceDetectView.3
 * JD-Core Version:    0.7.0.1
 */