package com.tencent.mm.plugin.facedetect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.facedetect.FaceProNative;
import com.tencent.mm.plugin.facedetect.FaceProNative.FaceResult;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class g
{
  public FaceProNative zSS = null;
  
  public final FaceProNative.FaceResult dOQ()
  {
    AppMethodBeat.i(103739);
    if (this.zSS == null)
    {
      Log.e("MicroMsg.FaceDetectNativeManager", "hy: release out not init");
      AppMethodBeat.o(103739);
      return null;
    }
    try
    {
      long l = Util.currentTicks();
      FaceProNative.FaceResult localFaceResult = this.zSS.engineReleaseOut();
      Log.i("MicroMsg.FaceDetectNativeManager", "hy: uninitialize result : %d, using: %d ms", new Object[] { Integer.valueOf(localFaceResult.result), Long.valueOf(Util.currentTicks() - l) });
      this.zSS = null;
      AppMethodBeat.o(103739);
      return localFaceResult;
    }
    finally
    {
      Log.printErrStackTrace("MicroMsg.FaceDetectNativeManager", localThrowable, "hy: face lib release crash!!!", new Object[0]);
      this.zSS.engineRelease();
      this.zSS = null;
      AppMethodBeat.o(103739);
    }
    return null;
  }
  
  public final int dOR()
  {
    AppMethodBeat.i(103740);
    if (this.zSS == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.v("MicroMsg.FaceDetectNativeManager", "alvinluo cutDown sFaceProNative == null: %b", new Object[] { Boolean.valueOf(bool) });
      if (this.zSS != null) {
        break;
      }
      Log.e("MicroMsg.FaceDetectNativeManager", "hy: reelase not init");
      AppMethodBeat.o(103740);
      return -101;
    }
    int i = this.zSS.engineRelease();
    Log.i("MicroMsg.FaceDetectNativeManager", "hy: cut down result: %d", new Object[] { Integer.valueOf(i) });
    this.zSS = null;
    AppMethodBeat.o(103740);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.model.g
 * JD-Core Version:    0.7.0.1
 */