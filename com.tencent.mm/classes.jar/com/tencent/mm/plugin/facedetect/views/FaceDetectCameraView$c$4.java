package com.tencent.mm.plugin.facedetect.views;

import com.tencent.mm.memory.a;
import com.tencent.mm.plugin.facedetect.model.c;
import com.tencent.mm.plugin.facedetect.model.d.b;
import com.tencent.mm.plugin.facedetect.model.f;
import com.tencent.mm.sdk.platformtools.ah;

final class FaceDetectCameraView$c$4
  implements d.b
{
  FaceDetectCameraView$c$4(FaceDetectCameraView.c paramc) {}
  
  public final a<byte[]> aOg()
  {
    return c.jNB;
  }
  
  public final void aw(byte[] paramArrayOfByte)
  {
    if (!FaceDetectCameraView.n(this.jUi.jUa))
    {
      if (FaceDetectCameraView.o(this.jUi.jUa) == null) {
        FaceDetectCameraView.a(this.jUi.jUa, c.jNB.f(Integer.valueOf(paramArrayOfByte.length)));
      }
      System.arraycopy(paramArrayOfByte, 0, FaceDetectCameraView.o(this.jUi.jUa), 0, paramArrayOfByte.length);
      FaceDetectCameraView.a(this.jUi.jUa, paramArrayOfByte);
    }
    c.jNB.z(paramArrayOfByte);
    f.aOp().post(new FaceDetectCameraView.c.4.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView.c.4
 * JD-Core Version:    0.7.0.1
 */