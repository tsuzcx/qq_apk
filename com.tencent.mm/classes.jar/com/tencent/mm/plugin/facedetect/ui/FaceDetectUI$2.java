package com.tencent.mm.plugin.facedetect.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

final class FaceDetectUI$2
  implements Runnable
{
  FaceDetectUI$2(FaceDetectUI paramFaceDetectUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(103978);
    long l = bu.HQ();
    Runtime.getRuntime().gc();
    ae.i("MicroMsg.FaceDetectUI", "hy: gc uses: %d ms", new Object[] { Long.valueOf(bu.aO(l)) });
    AppMethodBeat.o(103978);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.FaceDetectUI.2
 * JD-Core Version:    0.7.0.1
 */