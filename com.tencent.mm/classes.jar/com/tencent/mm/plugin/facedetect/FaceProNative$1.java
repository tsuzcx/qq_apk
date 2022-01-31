package com.tencent.mm.plugin.facedetect;

import com.tencent.mm.plugin.facedetect.model.o;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.e;

final class FaceProNative$1
  implements Runnable
{
  public final void run()
  {
    int i;
    if (!FaceProNative.hasDetectInit)
    {
      i = FaceProNative.nativeFacedetectInitBin(e.c(o.aOD(), 0, -1));
      if (i == -1) {
        y.w("MicroMsg.FaceProNative", "detectFaceCnt init failed: %s", new Object[] { o.aOD() });
      }
    }
    else
    {
      return;
    }
    y.i("MicroMsg.FaceProNative", "detectFaceCnt init:%d, %s", new Object[] { Integer.valueOf(i), o.aOD() });
    FaceProNative.hasDetectInit = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.FaceProNative.1
 * JD-Core Version:    0.7.0.1
 */