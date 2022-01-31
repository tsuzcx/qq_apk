package com.tencent.mm.plugin.facedetect.ui;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.facedetect.model.p;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;

final class FaceDetectUI$7
  implements Runnable
{
  FaceDetectUI$7(FaceDetectUI paramFaceDetectUI, Bitmap paramBitmap) {}
  
  public final void run()
  {
    AppMethodBeat.i(466);
    ah.getContext();
    al.d(new FaceDetectUI.7.1(this, p.n(FaceDetectUI.i(this.mmb), this.mmc)));
    AppMethodBeat.o(466);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.FaceDetectUI.7
 * JD-Core Version:    0.7.0.1
 */