package com.tencent.mm.plugin.facedetect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.facedetect.FaceProNative;
import com.tencent.mm.plugin.facedetect.FaceProNative.FaceResult;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class g
{
  public FaceProNative sQQ = null;
  
  public final FaceProNative.FaceResult cTb()
  {
    AppMethodBeat.i(103739);
    if (this.sQQ == null)
    {
      Log.e("MicroMsg.FaceDetectNativeManager", "hy: release out not init");
      AppMethodBeat.o(103739);
      return null;
    }
    try
    {
      long l = Util.currentTicks();
      FaceProNative.FaceResult localFaceResult = this.sQQ.engineReleaseOut();
      Log.i("MicroMsg.FaceDetectNativeManager", "hy: uninitialize result : %d, using: %d ms", new Object[] { Integer.valueOf(localFaceResult.result), Long.valueOf(Util.currentTicks() - l) });
      this.sQQ = null;
      AppMethodBeat.o(103739);
      return localFaceResult;
    }
    catch (Throwable localThrowable)
    {
      Log.printErrStackTrace("MicroMsg.FaceDetectNativeManager", localThrowable, "hy: face lib release crash!!!", new Object[0]);
      this.sQQ.engineRelease();
      this.sQQ = null;
      AppMethodBeat.o(103739);
    }
    return null;
  }
  
  public final int cTc()
  {
    AppMethodBeat.i(103740);
    if (this.sQQ == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.v("MicroMsg.FaceDetectNativeManager", "alvinluo cutDown sFaceProNative == null: %b", new Object[] { Boolean.valueOf(bool) });
      if (this.sQQ != null) {
        break;
      }
      Log.e("MicroMsg.FaceDetectNativeManager", "hy: reelase not init");
      AppMethodBeat.o(103740);
      return -101;
    }
    int i = this.sQQ.engineRelease();
    Log.i("MicroMsg.FaceDetectNativeManager", "hy: cut down result: %d", new Object[] { Integer.valueOf(i) });
    this.sQQ = null;
    AppMethodBeat.o(103740);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.model.g
 * JD-Core Version:    0.7.0.1
 */