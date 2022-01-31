package com.tencent.mm.plugin.facedetect.views;

import com.tencent.mm.plugin.facedetect.FaceProNative.FaceResult;
import com.tencent.mm.plugin.facedetect.model.p;

final class FaceDetectView$5
  implements Runnable
{
  FaceDetectView$5(FaceDetectView paramFaceDetectView) {}
  
  public final void run()
  {
    this.jUI.jUq.aPo();
    if (this.jPV != null)
    {
      FaceProNative.FaceResult localFaceResult = FaceDetectView.j(this.jUI).aPq();
      this.jPV.b(localFaceResult);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.views.FaceDetectView.5
 * JD-Core Version:    0.7.0.1
 */