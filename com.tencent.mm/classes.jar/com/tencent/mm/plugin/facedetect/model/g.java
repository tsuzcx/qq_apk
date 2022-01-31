package com.tencent.mm.plugin.facedetect.model;

import com.tencent.mm.plugin.facedetect.FaceProNative;
import com.tencent.mm.plugin.facedetect.FaceProNative.FaceResult;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class g
{
  public FaceProNative jNQ = null;
  
  public final FaceProNative.FaceResult aOv()
  {
    if (this.jNQ == null)
    {
      y.e("MicroMsg.FaceDetectNativeManager", "hy: release out not init");
      return null;
    }
    try
    {
      long l = bk.UZ();
      FaceProNative.FaceResult localFaceResult = this.jNQ.engineReleaseOut();
      y.i("MicroMsg.FaceDetectNativeManager", "hy: uninitialize result : %d, using: %d ms", new Object[] { Integer.valueOf(localFaceResult.result), Long.valueOf(bk.UZ() - l) });
      this.jNQ = null;
      return localFaceResult;
    }
    catch (Throwable localThrowable)
    {
      y.printErrStackTrace("MicroMsg.FaceDetectNativeManager", localThrowable, "hy: face lib release crash!!!", new Object[0]);
      this.jNQ.engineRelease();
      this.jNQ = null;
    }
    return null;
  }
  
  public final int aOw()
  {
    if (this.jNQ == null) {}
    for (boolean bool = true;; bool = false)
    {
      y.v("MicroMsg.FaceDetectNativeManager", "alvinluo cutDown sFaceProNative == null: %b", new Object[] { Boolean.valueOf(bool) });
      if (this.jNQ != null) {
        break;
      }
      y.e("MicroMsg.FaceDetectNativeManager", "hy: reelase not init");
      return -101;
    }
    int i = this.jNQ.engineRelease();
    y.i("MicroMsg.FaceDetectNativeManager", "hy: cut down result: %d", new Object[] { Integer.valueOf(i) });
    this.jNQ = null;
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.model.g
 * JD-Core Version:    0.7.0.1
 */