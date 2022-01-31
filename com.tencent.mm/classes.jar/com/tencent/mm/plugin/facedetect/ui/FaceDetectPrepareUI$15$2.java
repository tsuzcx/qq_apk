package com.tencent.mm.plugin.facedetect.ui;

import android.graphics.Bitmap;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class FaceDetectPrepareUI$15$2
  implements Runnable
{
  FaceDetectPrepareUI$15$2(FaceDetectPrepareUI.15 param15, View.OnClickListener paramOnClickListener, Bitmap paramBitmap) {}
  
  public final void run()
  {
    AppMethodBeat.i(419);
    c localc = a.a(this.mlH.mlC, this.mlI);
    localc.mmR = this.mlJ;
    this.mlH.mlC.a(false, false, localc);
    AppMethodBeat.o(419);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.FaceDetectPrepareUI.15.2
 * JD-Core Version:    0.7.0.1
 */