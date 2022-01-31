package com.tencent.mm.plugin.facedetect.views;

import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class FaceDetectCameraView$2
  implements Runnable
{
  FaceDetectCameraView$2(FaceDetectCameraView paramFaceDetectCameraView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void run()
  {
    AppMethodBeat.i(573);
    int i = this.mou - this.mov;
    ab.i("MicroMsg.FaceDetectCameraView", "alvinluo restHeight: %d", new Object[] { Integer.valueOf(i) });
    if (i <= 0)
    {
      AppMethodBeat.o(573);
      return;
    }
    i /= 2;
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(this.mow, this.mov);
    ViewGroup.MarginLayoutParams localMarginLayoutParams = new ViewGroup.MarginLayoutParams(this.mot.getLayoutParams());
    localLayoutParams.setMargins(localMarginLayoutParams.leftMargin, i, localMarginLayoutParams.rightMargin, localMarginLayoutParams.height + i);
    ab.v("MicroMsg.FaceDetectCameraView", "alvinluo margin left: %d, right: %d, top: %d, bottom: %d", new Object[] { Integer.valueOf(localMarginLayoutParams.leftMargin), Integer.valueOf(localMarginLayoutParams.rightMargin), Integer.valueOf(i), Integer.valueOf(i + localMarginLayoutParams.height) });
    this.mot.setLayoutParams(localLayoutParams);
    this.mot.invalidate();
    AppMethodBeat.o(573);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView.2
 * JD-Core Version:    0.7.0.1
 */