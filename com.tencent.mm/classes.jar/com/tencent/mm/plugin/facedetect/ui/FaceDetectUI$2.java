package com.tencent.mm.plugin.facedetect.ui;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class FaceDetectUI$2
  implements Runnable
{
  FaceDetectUI$2(FaceDetectUI paramFaceDetectUI) {}
  
  public final void run()
  {
    long l = bk.UZ();
    Runtime.getRuntime().gc();
    y.i("MicroMsg.FaceDetectUI", "hy: gc uses: %d ms", new Object[] { Long.valueOf(bk.cp(l)) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.FaceDetectUI.2
 * JD-Core Version:    0.7.0.1
 */