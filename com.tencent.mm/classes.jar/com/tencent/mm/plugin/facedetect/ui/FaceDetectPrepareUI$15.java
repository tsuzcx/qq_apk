package com.tencent.mm.plugin.facedetect.ui;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.facedetect.model.p;
import com.tencent.mm.sdk.platformtools.al;

final class FaceDetectPrepareUI$15
  implements Runnable
{
  FaceDetectPrepareUI$15(FaceDetectPrepareUI paramFaceDetectPrepareUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(420);
    Bitmap localBitmap = p.Np(FaceDetectPrepareUI.c(this.mlC));
    al.d(new FaceDetectPrepareUI.15.2(this, new FaceDetectPrepareUI.15.1(this), localBitmap));
    AppMethodBeat.o(420);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.FaceDetectPrepareUI.15
 * JD-Core Version:    0.7.0.1
 */