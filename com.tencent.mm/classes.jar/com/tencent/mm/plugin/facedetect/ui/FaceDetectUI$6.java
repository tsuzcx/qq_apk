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
import com.tencent.mm.sdk.platformtools.ae;

final class FaceDetectUI$6
  implements Runnable
{
  FaceDetectUI$6(FaceDetectUI paramFaceDetectUI) {}
  
  public final void run()
  {
    Object localObject1 = null;
    AppMethodBeat.i(103983);
    ae.i("MicroMsg.FaceDetectUI", "alvinluo dismiss cover and start capture");
    FaceDetectUI.h(this.rtn).cvu();
    FaceDetectUI.h(this.rtn).cvv();
    FaceDetectUI localFaceDetectUI = this.rtn;
    if (h.rpv == null) {
      h.rpv = new h();
    }
    localFaceDetectUI.rsZ = h.rpv;
    Object localObject2 = localFaceDetectUI.rsZ;
    ((h)localObject2).pVK = 0;
    ((h)localObject2).rpt = null;
    ((h)localObject2).rpu = -1;
    localObject2 = localFaceDetectUI.rsZ;
    Object localObject3 = f.rpo.rpp.rrr;
    int i;
    label134:
    String str;
    if (((g)localObject3).rps == null)
    {
      ae.e("MicroMsg.FaceDetectNativeManager", "hy: get all motion not init");
      ((h)localObject2).rpt = ((int[])localObject1);
      if (((h)localObject2).rpt != null) {
        break label318;
      }
      i = 0;
      ((h)localObject2).rpu = i;
      localFaceDetectUI.qiX = true;
      localObject1 = localFaceDetectUI.rtf;
      localObject2 = new RectF(localFaceDetectUI.rtg.getLeft(), localFaceDetectUI.rtg.getTop(), localFaceDetectUI.rtg.getRight(), localFaceDetectUI.rtg.getBottom());
      localObject3 = ((FaceDetectView)localObject1).rvT;
      str = ((RectF)localObject2).toString();
      if (((FaceDetectDecorView)localObject3).rvQ != null) {
        break label328;
      }
    }
    label318:
    label328:
    for (localObject1 = "null";; localObject1 = ((FaceDetectDecorView)localObject3).rvQ.toString())
    {
      ae.i("MicroMsg.FaceDetectDecorView", "hy: trigger showCover cover: %s, old: %s", new Object[] { str, localObject1 });
      ((FaceDetectDecorView)localObject3).rvO = true;
      if ((((FaceDetectDecorView)localObject3).rvQ == null) || (!((FaceDetectDecorView)localObject3).rvQ.equals(localObject2)))
      {
        ((FaceDetectDecorView)localObject3).rvQ = ((RectF)localObject2);
        ae.i("MicroMsg.FaceDetectDecorView", "alvinluo invalidate %s", new Object[] { ((FaceDetectDecorView)localObject3).rvQ.toString() });
        ((FaceDetectDecorView)localObject3).invalidate();
      }
      localFaceDetectUI.cvq();
      AppMethodBeat.o(103983);
      return;
      localObject1 = ((g)localObject3).rps.engineGetAllMotions();
      break;
      i = ((h)localObject2).rpt.length;
      break label134;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.FaceDetectUI.6
 * JD-Core Version:    0.7.0.1
 */