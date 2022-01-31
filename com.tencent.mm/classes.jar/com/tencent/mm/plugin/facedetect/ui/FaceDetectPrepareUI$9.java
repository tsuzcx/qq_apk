package com.tencent.mm.plugin.facedetect.ui;

import com.tencent.mm.plugin.facedetect.c.a;
import com.tencent.mm.sdk.platformtools.y;

final class FaceDetectPrepareUI$9
  implements Runnable
{
  FaceDetectPrepareUI$9(FaceDetectPrepareUI paramFaceDetectPrepareUI, String paramString) {}
  
  public final void run()
  {
    try
    {
      FaceDetectPrepareUI.b(this.jRg).Cn(this.eIv);
      return;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.FaceDetectPrepareUI", localException, "", new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.FaceDetectPrepareUI.9
 * JD-Core Version:    0.7.0.1
 */