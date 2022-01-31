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
  
  public final void bvl()
  {
    AppMethodBeat.i(460);
    Object localObject = FaceDetectUI.c(this.mmb);
    RectF localRectF = new RectF(FaceDetectUI.b(this.mmb).getLeft(), FaceDetectUI.b(this.mmb).getTop(), FaceDetectUI.b(this.mmb).getRight(), FaceDetectUI.b(this.mmb).getBottom());
    localObject = ((FaceDetectView)localObject).moK;
    ((FaceDetectDecorView)localObject).moF = true;
    ((FaceDetectDecorView)localObject).moG = true;
    ((FaceDetectDecorView)localObject).moH = localRectF;
    ((FaceDetectDecorView)localObject).invalidate();
    AppMethodBeat.o(460);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.FaceDetectUI.3
 * JD-Core Version:    0.7.0.1
 */