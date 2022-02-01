package com.tencent.mm.plugin.facedetect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.facedetect.FaceProNative;
import com.tencent.mm.plugin.facedetect.FaceProNative.FaceResult;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public final class g
{
  public FaceProNative rps = null;
  
  public final FaceProNative.FaceResult cuF()
  {
    AppMethodBeat.i(103739);
    if (this.rps == null)
    {
      ae.e("MicroMsg.FaceDetectNativeManager", "hy: release out not init");
      AppMethodBeat.o(103739);
      return null;
    }
    try
    {
      long l = bu.HQ();
      FaceProNative.FaceResult localFaceResult = this.rps.engineReleaseOut();
      ae.i("MicroMsg.FaceDetectNativeManager", "hy: uninitialize result : %d, using: %d ms", new Object[] { Integer.valueOf(localFaceResult.result), Long.valueOf(bu.HQ() - l) });
      this.rps = null;
      AppMethodBeat.o(103739);
      return localFaceResult;
    }
    catch (Throwable localThrowable)
    {
      ae.printErrStackTrace("MicroMsg.FaceDetectNativeManager", localThrowable, "hy: face lib release crash!!!", new Object[0]);
      this.rps.engineRelease();
      this.rps = null;
      AppMethodBeat.o(103739);
    }
    return null;
  }
  
  public final int cuG()
  {
    AppMethodBeat.i(103740);
    if (this.rps == null) {}
    for (boolean bool = true;; bool = false)
    {
      ae.v("MicroMsg.FaceDetectNativeManager", "alvinluo cutDown sFaceProNative == null: %b", new Object[] { Boolean.valueOf(bool) });
      if (this.rps != null) {
        break;
      }
      ae.e("MicroMsg.FaceDetectNativeManager", "hy: reelase not init");
      AppMethodBeat.o(103740);
      return -101;
    }
    int i = this.rps.engineRelease();
    ae.i("MicroMsg.FaceDetectNativeManager", "hy: cut down result: %d", new Object[] { Integer.valueOf(i) });
    this.rps = null;
    AppMethodBeat.o(103740);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.model.g
 * JD-Core Version:    0.7.0.1
 */