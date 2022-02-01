package com.tencent.mm.plugin.facedetect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.facedetect.FaceProNative;
import com.tencent.mm.plugin.facedetect.FaceProNative.FaceResult;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class g
{
  public FaceProNative rho = null;
  
  public final FaceProNative.FaceResult cte()
  {
    AppMethodBeat.i(103739);
    if (this.rho == null)
    {
      ad.e("MicroMsg.FaceDetectNativeManager", "hy: release out not init");
      AppMethodBeat.o(103739);
      return null;
    }
    try
    {
      long l = bt.HI();
      FaceProNative.FaceResult localFaceResult = this.rho.engineReleaseOut();
      ad.i("MicroMsg.FaceDetectNativeManager", "hy: uninitialize result : %d, using: %d ms", new Object[] { Integer.valueOf(localFaceResult.result), Long.valueOf(bt.HI() - l) });
      this.rho = null;
      AppMethodBeat.o(103739);
      return localFaceResult;
    }
    catch (Throwable localThrowable)
    {
      ad.printErrStackTrace("MicroMsg.FaceDetectNativeManager", localThrowable, "hy: face lib release crash!!!", new Object[0]);
      this.rho.engineRelease();
      this.rho = null;
      AppMethodBeat.o(103739);
    }
    return null;
  }
  
  public final int ctf()
  {
    AppMethodBeat.i(103740);
    if (this.rho == null) {}
    for (boolean bool = true;; bool = false)
    {
      ad.v("MicroMsg.FaceDetectNativeManager", "alvinluo cutDown sFaceProNative == null: %b", new Object[] { Boolean.valueOf(bool) });
      if (this.rho != null) {
        break;
      }
      ad.e("MicroMsg.FaceDetectNativeManager", "hy: reelase not init");
      AppMethodBeat.o(103740);
      return -101;
    }
    int i = this.rho.engineRelease();
    ad.i("MicroMsg.FaceDetectNativeManager", "hy: cut down result: %d", new Object[] { Integer.valueOf(i) });
    this.rho = null;
    AppMethodBeat.o(103740);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.model.g
 * JD-Core Version:    0.7.0.1
 */