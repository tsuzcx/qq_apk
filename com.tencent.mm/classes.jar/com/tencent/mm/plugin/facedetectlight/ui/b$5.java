package com.tencent.mm.plugin.facedetectlight.ui;

import android.content.Context;
import com.tencent.mm.plugin.facedetect.a.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface.LightLiveCheckResult;
import com.tencent.youtu.ytagreflectlivecheck.requester.LightDiffResponse;

final class b$5
  implements YTAGReflectLiveCheckInterface.LightLiveCheckResult
{
  b$5(b paramb) {}
  
  public final void onFailed(int paramInt, String paramString1, String paramString2)
  {
    y.i("MicroMsg.FaceReflectLogic", "reflect failed");
    y.i("MicroMsg.FaceReflectLogic", "message：%s、tips：%s，resultcode：%s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt) });
    h.nFQ.a(917L, 10L, 1L, false);
    this.jXK.jXm.aPG();
    this.jXK.mState = 3;
    this.jXK.jXm.k(90023, "face track failed or not stable", ae.getContext().getString(a.i.face_compare_fail));
  }
  
  public final void onSuccess(boolean paramBoolean, LightDiffResponse paramLightDiffResponse)
  {
    y.i("MicroMsg.FaceReflectLogic", "reflect success");
    this.jXK.jXm.aPG();
    this.jXK.mState = 2;
    h.nFQ.a(917L, 9L, 1L, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectlight.ui.b.5
 * JD-Core Version:    0.7.0.1
 */