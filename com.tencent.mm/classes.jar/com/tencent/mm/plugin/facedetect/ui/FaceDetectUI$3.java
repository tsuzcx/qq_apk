package com.tencent.mm.plugin.facedetect.ui;

import android.graphics.RectF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.facedetect.views.FaceDetectDecorView;
import com.tencent.mm.plugin.facedetect.views.FaceDetectView;
import com.tencent.mm.plugin.facedetect.views.FaceScanRect;
import com.tencent.mm.plugin.facedetect.views.FaceScanRect.b;

final class FaceDetectUI$3
  implements FaceScanRect.b
{
  FaceDetectUI$3(FaceDetectUI paramFaceDetectUI) {}
  
  public final void cvt()
  {
    AppMethodBeat.i(103979);
    Object localObject = FaceDetectUI.c(this.rtn);
    RectF localRectF = new RectF(FaceDetectUI.b(this.rtn).getLeft(), FaceDetectUI.b(this.rtn).getTop(), FaceDetectUI.b(this.rtn).getRight(), FaceDetectUI.b(this.rtn).getBottom());
    localObject = ((FaceDetectView)localObject).rvT;
    ((FaceDetectDecorView)localObject).rvO = true;
    ((FaceDetectDecorView)localObject).rvP = true;
    ((FaceDetectDecorView)localObject).rvQ = localRectF;
    ((FaceDetectDecorView)localObject).invalidate();
    AppMethodBeat.o(103979);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.FaceDetectUI.3
 * JD-Core Version:    0.7.0.1
 */