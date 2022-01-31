package com.tencent.mm.plugin.facedetectaction.b;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.youtu.ytposedetect.YTPoseDetectInterface.PoseDetectOnFrame;

final class b$1
  implements YTPoseDetectInterface.PoseDetectOnFrame
{
  b$1(b paramb) {}
  
  public final void onFailed(int paramInt, String paramString1, String paramString2)
  {
    y.i("MicroMsg.FaceCheckActionEngine", "detect action failed, %s %s %s", new Object[] { Integer.valueOf(paramInt), paramString1, paramString2 });
    b.a(this.jWe, 4);
    h.nFQ.a(917L, 43L, 1L, false);
    if (b.a(this.jWe) != null) {
      b.a(this.jWe);
    }
  }
  
  public final void onRecordingDone(byte[][] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramArrayOfByte != null) {
      y.i("MicroMsg.FaceCheckActionEngine", "notify start record, frameDatas.length: %s, width: %s, height: %s", new Object[] { Integer.valueOf(paramArrayOfByte.length), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    }
    for (;;)
    {
      b.a(this.jWe, 5);
      if (b.a(this.jWe) != null) {
        b.a(this.jWe).a(paramArrayOfByte, paramInt1, paramInt2);
      }
      return;
      y.e("MicroMsg.FaceCheckActionEngine", "onRecordingDone, frameData is null!!");
    }
  }
  
  public final void onSuccess(int paramInt)
  {
    y.i("MicroMsg.FaceCheckActionEngine", "detect action success: %s", new Object[] { Integer.valueOf(paramInt) });
    b.a(this.jWe, 3);
    h.nFQ.a(917L, 42L, 1L, false);
    if (b.a(this.jWe) != null) {
      b.a(this.jWe);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.b.b.1
 * JD-Core Version:    0.7.0.1
 */