package com.tencent.mm.plugin.facedetect.views;

import com.tencent.mm.sdk.platformtools.y;

public final class FaceDetectView$4
  implements c
{
  public FaceDetectView$4(FaceDetectView paramFaceDetectView, c paramc) {}
  
  public final void qT(int paramInt)
  {
    y.i("MicroMsg.FaceDetectView", "hy: camera preview init done : %d", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt == 0)
    {
      FaceDetectView.a(this.jUI, false);
      FaceDetectView.h(this.jUI);
    }
    if (this.jUL != null) {
      this.jUL.qT(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.views.FaceDetectView.4
 * JD-Core Version:    0.7.0.1
 */