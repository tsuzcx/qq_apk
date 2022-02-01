package com.tencent.mm.plugin.facedetect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.facedetect.FaceProNative;
import com.tencent.mm.plugin.facedetect.FaceProNative.FaceResult;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public final class g
{
  public FaceProNative qxy = null;
  
  public final int cnA()
  {
    AppMethodBeat.i(103740);
    if (this.qxy == null) {}
    for (boolean bool = true;; bool = false)
    {
      ac.v("MicroMsg.FaceDetectNativeManager", "alvinluo cutDown sFaceProNative == null: %b", new Object[] { Boolean.valueOf(bool) });
      if (this.qxy != null) {
        break;
      }
      ac.e("MicroMsg.FaceDetectNativeManager", "hy: reelase not init");
      AppMethodBeat.o(103740);
      return -101;
    }
    int i = this.qxy.engineRelease();
    ac.i("MicroMsg.FaceDetectNativeManager", "hy: cut down result: %d", new Object[] { Integer.valueOf(i) });
    this.qxy = null;
    AppMethodBeat.o(103740);
    return i;
  }
  
  public final FaceProNative.FaceResult cnz()
  {
    AppMethodBeat.i(103739);
    if (this.qxy == null)
    {
      ac.e("MicroMsg.FaceDetectNativeManager", "hy: release out not init");
      AppMethodBeat.o(103739);
      return null;
    }
    try
    {
      long l = bs.Gn();
      FaceProNative.FaceResult localFaceResult = this.qxy.engineReleaseOut();
      ac.i("MicroMsg.FaceDetectNativeManager", "hy: uninitialize result : %d, using: %d ms", new Object[] { Integer.valueOf(localFaceResult.result), Long.valueOf(bs.Gn() - l) });
      this.qxy = null;
      AppMethodBeat.o(103739);
      return localFaceResult;
    }
    catch (Throwable localThrowable)
    {
      ac.printErrStackTrace("MicroMsg.FaceDetectNativeManager", localThrowable, "hy: face lib release crash!!!", new Object[0]);
      this.qxy.engineRelease();
      this.qxy = null;
      AppMethodBeat.o(103739);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.model.g
 * JD-Core Version:    0.7.0.1
 */