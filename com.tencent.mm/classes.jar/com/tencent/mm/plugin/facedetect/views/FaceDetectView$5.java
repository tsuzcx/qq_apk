package com.tencent.mm.plugin.facedetect.views;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.facedetect.FaceProNative.FaceResult;
import com.tencent.mm.plugin.facedetect.model.q;

final class FaceDetectView$5
  implements Runnable
{
  FaceDetectView$5(FaceDetectView paramFaceDetectView) {}
  
  public final void run()
  {
    AppMethodBeat.i(104144);
    this.pVK.pVs.cgP();
    if (this.pQW != null)
    {
      FaceProNative.FaceResult localFaceResult = FaceDetectView.j(this.pVK).cgR();
      this.pQW.b(localFaceResult);
    }
    AppMethodBeat.o(104144);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.views.FaceDetectView.5
 * JD-Core Version:    0.7.0.1
 */