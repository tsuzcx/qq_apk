package com.tencent.mm.plugin.facedetect.ui;

import android.graphics.RectF;
import com.tencent.mm.plugin.facedetect.views.FaceDetectDecorView;
import com.tencent.mm.plugin.facedetect.views.FaceDetectView;
import com.tencent.mm.plugin.facedetect.views.FaceScanRect;
import com.tencent.mm.plugin.facedetect.views.FaceScanRect.b;

final class FaceDetectUI$3
  implements FaceScanRect.b
{
  FaceDetectUI$3(FaceDetectUI paramFaceDetectUI) {}
  
  public final void aPg()
  {
    Object localObject = FaceDetectUI.c(this.jRF);
    RectF localRectF = new RectF(FaceDetectUI.b(this.jRF).getLeft(), FaceDetectUI.b(this.jRF).getTop(), FaceDetectUI.b(this.jRF).getRight(), FaceDetectUI.b(this.jRF).getBottom());
    localObject = ((FaceDetectView)localObject).jUr;
    ((FaceDetectDecorView)localObject).jUm = true;
    ((FaceDetectDecorView)localObject).jUn = true;
    ((FaceDetectDecorView)localObject).jUo = localRectF;
    ((FaceDetectDecorView)localObject).invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.FaceDetectUI.3
 * JD-Core Version:    0.7.0.1
 */