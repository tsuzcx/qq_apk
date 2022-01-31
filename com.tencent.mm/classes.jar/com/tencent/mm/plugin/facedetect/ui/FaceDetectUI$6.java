package com.tencent.mm.plugin.facedetect.ui;

import android.graphics.RectF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.facedetect.FaceProNative;
import com.tencent.mm.plugin.facedetect.model.f;
import com.tencent.mm.plugin.facedetect.model.g;
import com.tencent.mm.plugin.facedetect.model.h;
import com.tencent.mm.plugin.facedetect.service.FaceDetectProcessService;
import com.tencent.mm.plugin.facedetect.views.FaceDetectDecorView;
import com.tencent.mm.plugin.facedetect.views.FaceDetectView;
import com.tencent.mm.plugin.facedetect.views.FaceScanRect;
import com.tencent.mm.sdk.platformtools.ab;

final class FaceDetectUI$6
  implements Runnable
{
  FaceDetectUI$6(FaceDetectUI paramFaceDetectUI) {}
  
  public final void run()
  {
    Object localObject1 = null;
    AppMethodBeat.i(464);
    ab.i("MicroMsg.FaceDetectUI", "alvinluo dismiss cover and start capture");
    FaceDetectUI.h(this.mmb).bvm();
    FaceDetectUI.h(this.mmb).bvn();
    FaceDetectUI localFaceDetectUI = this.mmb;
    if (h.mif == null) {
      h.mif = new h();
    }
    localFaceDetectUI.mlM = h.mif;
    Object localObject2 = localFaceDetectUI.mlM;
    ((h)localObject2).lrL = 0;
    ((h)localObject2).mid = null;
    ((h)localObject2).mie = -1;
    localObject2 = localFaceDetectUI.mlM;
    Object localObject3 = f.mhY.mhZ.mkf;
    int i;
    label135:
    String str;
    if (((g)localObject3).mic == null)
    {
      ab.e("MicroMsg.FaceDetectNativeManager", "hy: get all motion not init");
      ((h)localObject2).mid = ((int[])localObject1);
      if (((h)localObject2).mid != null) {
        break label320;
      }
      i = 0;
      ((h)localObject2).mie = i;
      localFaceDetectUI.lEQ = true;
      localObject1 = localFaceDetectUI.mlS;
      localObject2 = new RectF(localFaceDetectUI.mlT.getLeft(), localFaceDetectUI.mlT.getTop(), localFaceDetectUI.mlT.getRight(), localFaceDetectUI.mlT.getBottom());
      localObject3 = ((FaceDetectView)localObject1).moK;
      str = ((RectF)localObject2).toString();
      if (((FaceDetectDecorView)localObject3).moH != null) {
        break label330;
      }
    }
    label320:
    label330:
    for (localObject1 = "null";; localObject1 = ((FaceDetectDecorView)localObject3).moH.toString())
    {
      ab.i("MicroMsg.FaceDetectDecorView", "hy: trigger showCover cover: %s, old: %s", new Object[] { str, localObject1 });
      ((FaceDetectDecorView)localObject3).moF = true;
      if ((((FaceDetectDecorView)localObject3).moH == null) || (!((FaceDetectDecorView)localObject3).moH.equals(localObject2)))
      {
        ((FaceDetectDecorView)localObject3).moH = ((RectF)localObject2);
        ab.i("MicroMsg.FaceDetectDecorView", "alvinluo invalidate %s", new Object[] { ((FaceDetectDecorView)localObject3).moH.toString() });
        ((FaceDetectDecorView)localObject3).invalidate();
      }
      localFaceDetectUI.bvi();
      AppMethodBeat.o(464);
      return;
      localObject1 = ((g)localObject3).mic.engineGetAllMotions();
      break;
      i = ((h)localObject2).mid.length;
      break label135;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.FaceDetectUI.6
 * JD-Core Version:    0.7.0.1
 */