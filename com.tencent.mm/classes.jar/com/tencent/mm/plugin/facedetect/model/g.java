package com.tencent.mm.plugin.facedetect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.facedetect.FaceProNative;
import com.tencent.mm.plugin.facedetect.FaceProNative.FaceResult;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class g
{
  public FaceProNative mic = null;
  
  public final FaceProNative.FaceResult buy()
  {
    AppMethodBeat.i(214);
    if (this.mic == null)
    {
      ab.e("MicroMsg.FaceDetectNativeManager", "hy: release out not init");
      AppMethodBeat.o(214);
      return null;
    }
    try
    {
      long l = bo.yB();
      FaceProNative.FaceResult localFaceResult = this.mic.engineReleaseOut();
      ab.i("MicroMsg.FaceDetectNativeManager", "hy: uninitialize result : %d, using: %d ms", new Object[] { Integer.valueOf(localFaceResult.result), Long.valueOf(bo.yB() - l) });
      this.mic = null;
      AppMethodBeat.o(214);
      return localFaceResult;
    }
    catch (Throwable localThrowable)
    {
      ab.printErrStackTrace("MicroMsg.FaceDetectNativeManager", localThrowable, "hy: face lib release crash!!!", new Object[0]);
      this.mic.engineRelease();
      this.mic = null;
      AppMethodBeat.o(214);
    }
    return null;
  }
  
  public final int buz()
  {
    AppMethodBeat.i(215);
    if (this.mic == null) {}
    for (boolean bool = true;; bool = false)
    {
      ab.v("MicroMsg.FaceDetectNativeManager", "alvinluo cutDown sFaceProNative == null: %b", new Object[] { Boolean.valueOf(bool) });
      if (this.mic != null) {
        break;
      }
      ab.e("MicroMsg.FaceDetectNativeManager", "hy: reelase not init");
      AppMethodBeat.o(215);
      return -101;
    }
    int i = this.mic.engineRelease();
    ab.i("MicroMsg.FaceDetectNativeManager", "hy: cut down result: %d", new Object[] { Integer.valueOf(i) });
    this.mic = null;
    AppMethodBeat.o(215);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.model.g
 * JD-Core Version:    0.7.0.1
 */