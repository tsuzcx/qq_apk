package com.tencent.mm.plugin.facedetect.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.facedetect.c.a;
import com.tencent.mm.sdk.platformtools.ab;

final class FaceDetectPrepareUI$9
  implements Runnable
{
  FaceDetectPrepareUI$9(FaceDetectPrepareUI paramFaceDetectPrepareUI, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(412);
    try
    {
      FaceDetectPrepareUI.b(this.mlC).No(this.cbL);
      AppMethodBeat.o(412);
      return;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.FaceDetectPrepareUI", localException, "", new Object[0]);
      AppMethodBeat.o(412);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.FaceDetectPrepareUI.9
 * JD-Core Version:    0.7.0.1
 */