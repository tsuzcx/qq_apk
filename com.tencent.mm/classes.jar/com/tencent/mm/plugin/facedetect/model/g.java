package com.tencent.mm.plugin.facedetect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.facedetect.FaceProNative;
import com.tencent.mm.plugin.facedetect.FaceProNative.FaceResult;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class g
{
  public FaceProNative pOQ = null;
  
  public final FaceProNative.FaceResult cfS()
  {
    AppMethodBeat.i(103739);
    if (this.pOQ == null)
    {
      ad.e("MicroMsg.FaceDetectNativeManager", "hy: release out not init");
      AppMethodBeat.o(103739);
      return null;
    }
    try
    {
      long l = bt.GC();
      FaceProNative.FaceResult localFaceResult = this.pOQ.engineReleaseOut();
      ad.i("MicroMsg.FaceDetectNativeManager", "hy: uninitialize result : %d, using: %d ms", new Object[] { Integer.valueOf(localFaceResult.result), Long.valueOf(bt.GC() - l) });
      this.pOQ = null;
      AppMethodBeat.o(103739);
      return localFaceResult;
    }
    catch (Throwable localThrowable)
    {
      ad.printErrStackTrace("MicroMsg.FaceDetectNativeManager", localThrowable, "hy: face lib release crash!!!", new Object[0]);
      this.pOQ.engineRelease();
      this.pOQ = null;
      AppMethodBeat.o(103739);
    }
    return null;
  }
  
  public final int cfT()
  {
    AppMethodBeat.i(103740);
    if (this.pOQ == null) {}
    for (boolean bool = true;; bool = false)
    {
      ad.v("MicroMsg.FaceDetectNativeManager", "alvinluo cutDown sFaceProNative == null: %b", new Object[] { Boolean.valueOf(bool) });
      if (this.pOQ != null) {
        break;
      }
      ad.e("MicroMsg.FaceDetectNativeManager", "hy: reelase not init");
      AppMethodBeat.o(103740);
      return -101;
    }
    int i = this.pOQ.engineRelease();
    ad.i("MicroMsg.FaceDetectNativeManager", "hy: cut down result: %d", new Object[] { Integer.valueOf(i) });
    this.pOQ = null;
    AppMethodBeat.o(103740);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.model.g
 * JD-Core Version:    0.7.0.1
 */