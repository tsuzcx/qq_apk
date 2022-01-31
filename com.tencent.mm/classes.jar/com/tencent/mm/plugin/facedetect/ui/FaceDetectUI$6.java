package com.tencent.mm.plugin.facedetect.ui;

import android.graphics.RectF;
import com.tencent.mm.plugin.facedetect.FaceProNative;
import com.tencent.mm.plugin.facedetect.model.f;
import com.tencent.mm.plugin.facedetect.model.g;
import com.tencent.mm.plugin.facedetect.model.h;
import com.tencent.mm.plugin.facedetect.service.FaceDetectProcessService;
import com.tencent.mm.plugin.facedetect.views.FaceDetectDecorView;
import com.tencent.mm.plugin.facedetect.views.FaceDetectView;
import com.tencent.mm.plugin.facedetect.views.FaceScanRect;
import com.tencent.mm.sdk.platformtools.y;

final class FaceDetectUI$6
  implements Runnable
{
  FaceDetectUI$6(FaceDetectUI paramFaceDetectUI) {}
  
  public final void run()
  {
    Object localObject1 = null;
    y.i("MicroMsg.FaceDetectUI", "alvinluo dismiss cover and start capture");
    FaceDetectUI.h(this.jRF).aPh();
    FaceDetectUI.h(this.jRF).aPi();
    FaceDetectUI localFaceDetectUI = this.jRF;
    if (h.jNT == null) {
      h.jNT = new h();
    }
    localFaceDetectUI.jRq = h.jNT;
    Object localObject2 = localFaceDetectUI.jRq;
    ((h)localObject2).jiU = 0;
    ((h)localObject2).jNR = null;
    ((h)localObject2).jNS = -1;
    localObject2 = localFaceDetectUI.jRq;
    Object localObject3 = f.jNM.jNN.jPP;
    int i;
    label129:
    String str;
    if (((g)localObject3).jNQ == null)
    {
      y.e("MicroMsg.FaceDetectNativeManager", "hy: get all motion not init");
      ((h)localObject2).jNR = ((int[])localObject1);
      if (((h)localObject2).jNR != null) {
        break label308;
      }
      i = 0;
      ((h)localObject2).jNS = i;
      localFaceDetectUI.jvr = true;
      localObject1 = localFaceDetectUI.jRw;
      localObject2 = new RectF(localFaceDetectUI.jRx.getLeft(), localFaceDetectUI.jRx.getTop(), localFaceDetectUI.jRx.getRight(), localFaceDetectUI.jRx.getBottom());
      localObject3 = ((FaceDetectView)localObject1).jUr;
      str = ((RectF)localObject2).toString();
      if (((FaceDetectDecorView)localObject3).jUo != null) {
        break label318;
      }
    }
    label308:
    label318:
    for (localObject1 = "null";; localObject1 = ((FaceDetectDecorView)localObject3).jUo.toString())
    {
      y.i("MicroMsg.FaceDetectDecorView", "hy: trigger showCover cover: %s, old: %s", new Object[] { str, localObject1 });
      ((FaceDetectDecorView)localObject3).jUm = true;
      if ((((FaceDetectDecorView)localObject3).jUo == null) || (!((FaceDetectDecorView)localObject3).jUo.equals(localObject2)))
      {
        ((FaceDetectDecorView)localObject3).jUo = ((RectF)localObject2);
        y.i("MicroMsg.FaceDetectDecorView", "alvinluo invalidate %s", new Object[] { ((FaceDetectDecorView)localObject3).jUo.toString() });
        ((FaceDetectDecorView)localObject3).invalidate();
      }
      localFaceDetectUI.aPe();
      return;
      localObject1 = ((g)localObject3).jNQ.engineGetAllMotions();
      break;
      i = ((h)localObject2).jNR.length;
      break label129;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.FaceDetectUI.6
 * JD-Core Version:    0.7.0.1
 */