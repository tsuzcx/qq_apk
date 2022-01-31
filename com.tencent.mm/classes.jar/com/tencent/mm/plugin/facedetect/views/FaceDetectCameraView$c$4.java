package com.tencent.mm.plugin.facedetect.views;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.a;
import com.tencent.mm.plugin.facedetect.model.c;
import com.tencent.mm.plugin.facedetect.model.d.b;
import com.tencent.mm.plugin.facedetect.model.f;
import com.tencent.mm.sdk.platformtools.ak;

final class FaceDetectCameraView$c$4
  implements d.b
{
  FaceDetectCameraView$c$4(FaceDetectCameraView.c paramc) {}
  
  public final void aU(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(583);
    if (!FaceDetectCameraView.n(this.moB.mot))
    {
      if (FaceDetectCameraView.o(this.moB.mot) == null) {
        FaceDetectCameraView.a(this.moB.mot, c.mhN.f(Integer.valueOf(paramArrayOfByte.length)));
      }
      System.arraycopy(paramArrayOfByte, 0, FaceDetectCameraView.o(this.moB.mot), 0, paramArrayOfByte.length);
      FaceDetectCameraView.a(this.moB.mot, paramArrayOfByte);
    }
    c.mhN.O(paramArrayOfByte);
    f.bus().post(new FaceDetectCameraView.c.4.1(this));
    AppMethodBeat.o(583);
  }
  
  public final a<byte[]> buj()
  {
    return c.mhN;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView.c.4
 * JD-Core Version:    0.7.0.1
 */