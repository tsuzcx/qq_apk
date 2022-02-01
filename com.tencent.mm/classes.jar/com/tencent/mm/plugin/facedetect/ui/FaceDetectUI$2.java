package com.tencent.mm.plugin.facedetect.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

final class FaceDetectUI$2
  implements Runnable
{
  FaceDetectUI$2(FaceDetectUI paramFaceDetectUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(103978);
    long l = Util.currentTicks();
    Runtime.getRuntime().gc();
    Log.i("MicroMsg.FaceDetectUI", "hy: gc uses: %d ms", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
    AppMethodBeat.o(103978);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.FaceDetectUI.2
 * JD-Core Version:    0.7.0.1
 */