package com.tencent.mm.plugin.facedetect.ui;

import android.graphics.Bitmap;
import com.tencent.mm.plugin.facedetect.model.o;
import com.tencent.mm.sdk.platformtools.ai;

final class FaceDetectPrepareUI$15
  implements Runnable
{
  FaceDetectPrepareUI$15(FaceDetectPrepareUI paramFaceDetectPrepareUI) {}
  
  public final void run()
  {
    Bitmap localBitmap = o.Co(FaceDetectPrepareUI.c(this.jRg));
    ai.d(new FaceDetectPrepareUI.15.2(this, new FaceDetectPrepareUI.15.1(this), localBitmap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.FaceDetectPrepareUI.15
 * JD-Core Version:    0.7.0.1
 */