package com.tencent.mm.plugin.facedetect.ui;

import com.tencent.mm.plugin.facedetect.c.a;
import com.tencent.mm.sdk.platformtools.y;

final class FaceDetectPrepareUI$8
  implements Runnable
{
  FaceDetectPrepareUI$8(FaceDetectPrepareUI paramFaceDetectPrepareUI, String paramString) {}
  
  public final void run()
  {
    try
    {
      y.i("MicroMsg.FaceDetectPrepareUI", "call controller start upload biobuffer: %s", new Object[] { this.val$filePath });
      FaceDetectPrepareUI.b(this.jRg).Cn(this.val$filePath);
      return;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.FaceDetectPrepareUI", localException, "", new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.FaceDetectPrepareUI.8
 * JD-Core Version:    0.7.0.1
 */