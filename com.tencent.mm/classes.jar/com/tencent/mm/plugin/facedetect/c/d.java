package com.tencent.mm.plugin.facedetect.c;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.facedetect.a.d;
import com.tencent.mm.plugin.facedetect.a.i;
import com.tencent.mm.plugin.facedetect.model.FaceDetectReporter;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class d
  extends a
{
  String appId;
  private String bTX;
  boolean iHI = false;
  private String jNp;
  private String jNq;
  String jNv;
  
  d(Context paramContext, e parame, int paramInt1, int paramInt2, Bundle paramBundle)
  {
    super(paramContext, parame, paramInt1, paramInt2);
    this.jNl = true;
    this.appId = paramBundle.getString("k_app_id", null);
    this.bTX = paramBundle.getString("request_verify_pre_info", null);
    this.jNv = paramBundle.getString("key_feedback_url", null);
  }
  
  private void a(final int paramInt1, final int paramInt2, final String paramString, boolean paramBoolean, final Bundle paramBundle)
  {
    y.e("MicroMsg.FaceDetectMpController", "carson onVerifyFailed（）");
    b(paramInt1, paramInt2, paramString, paramBundle);
    Context localContext = ae.getContext();
    if (paramString == null) {}
    for (String str1 = localContext.getString(a.i.face_compare_fail);; str1 = paramString)
    {
      int i = a.d.face_err_icon;
      String str2;
      if (paramBoolean)
      {
        str2 = localContext.getString(a.i.face_try_again);
        if (!paramBoolean) {
          break label162;
        }
      }
      label162:
      for (String str3 = localContext.getString(a.i.app_cancel);; str3 = null)
      {
        paramString = com.tencent.mm.plugin.facedetect.ui.a.b(i, str1, str2, str3, new d.2(this, paramBoolean, paramInt1, paramInt2, paramString, paramBundle), new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            d.this.a(paramInt1, paramInt2, paramString, paramBundle);
          }
        });
        paramString.status = 3;
        com.tencent.mm.plugin.facedetect.ui.a.a(paramString, localContext.getString(a.i.face_detect_feedback), new d.4(this, paramBundle, paramInt2, localContext));
        a(true, false, paramString);
        return;
        str2 = localContext.getString(a.i.face_severe_error_main_btn);
        break;
      }
    }
  }
  
  public final com.tencent.mm.ah.m aOc()
  {
    return new com.tencent.mm.plugin.facedetect.b.m(aOa(), this.appId, this.bTX, this.jNp, this.jNq, this.jNm);
  }
  
  public final Bundle aOd()
  {
    Bundle localBundle = new Bundle();
    localBundle.putLong("k_bio_id", aOa());
    localBundle.putString("key_app_id", this.appId);
    return localBundle;
  }
  
  public final void ae(int paramInt, String paramString)
  {
    y.i("MicroMsg.FaceDetectMpController", "alvinluo onCancel, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt), paramString });
    if (!FaceDetectReporter.aOy().jOu) {
      FaceDetectReporter.aOy().a(this.jNi, this.iHI, 2, 1, paramInt);
    }
    a(1, paramInt, paramString, null);
  }
  
  public final void c(int paramInt1, int paramInt2, String paramString, Bundle paramBundle)
  {
    y.i("MicroMsg.FaceDetectMpController", "alvinluo onError errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (!FaceDetectReporter.aOy().jOu) {
      FaceDetectReporter.aOy().a(this.jNi, this.iHI, 3, paramInt1, paramInt2);
    }
    if (paramBundle != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("verify_result", paramBundle.getString("verify_result"));
      a(paramInt1, paramInt2, paramString, localBundle);
      return;
    }
    a(paramInt1, paramInt2, paramString, null);
  }
  
  public final boolean c(int paramInt, String paramString, Bundle paramBundle)
  {
    y.i("MicroMsg.FaceDetectMpController", "alvinluo onUploadEnd errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(0), paramString });
    if (paramInt != 0)
    {
      FaceDetectReporter.aOy().a(this.jNi, this.iHI, 1, 2, 90012);
      a(paramInt, 0, paramString, false, null);
      return true;
    }
    if ((paramBundle == null) || (bk.bl(paramBundle.getString("key_pic_cdn_id"))))
    {
      y.e("MicroMsg.FaceDetectMpController", "hy: not return cdn id!");
      a(4, 6, "not return cdn id", false, null);
      return true;
    }
    this.jNp = paramBundle.getString("key_pic_cdn_id");
    this.jNq = paramBundle.getString("key_cdn_aes_key");
    y.v("MicroMsg.FaceDetectMpController", "hy: start upload: picCdnId: %s, aes key: %s", new Object[] { this.jNp, this.jNq });
    return false;
  }
  
  public final void h(final int paramInt1, final int paramInt2, final String paramString, com.tencent.mm.ah.m paramm)
  {
    y.i("MicroMsg.FaceDetectMpController", "alvinluo onVerifyEnd sceneType: %d, errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramm.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    final Bundle localBundle;
    if ((paramm instanceof com.tencent.mm.plugin.facedetect.b.m))
    {
      localBundle = new Bundle();
      localBundle.putString("verify_result", ((com.tencent.mm.plugin.facedetect.b.m)paramm).jMU);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label216;
      }
      paramm = FaceDetectReporter.aOy();
      j = this.jNi;
      bool = this.iHI;
      if (this.jNk == null) {
        break label210;
      }
    }
    label210:
    for (int i = this.jNk.jMw;; i = 0)
    {
      paramm.a(j, bool, 0, paramInt1, paramInt2, i);
      h.nFQ.a(917L, 15L, 1L, false);
      FaceDetectReporter.aOy().jOB = true;
      paramm = com.tencent.mm.plugin.facedetect.ui.a.qQ(a.d.face_tick);
      paramm.jSo = true;
      paramm.jSw = ae.getResources().getString(a.i.jsapi_success);
      paramm.status = 2;
      a(false, true, paramm);
      ai.l(new Runnable()
      {
        public final void run()
        {
          d.this.a(paramInt1, paramInt2, paramString, localBundle);
        }
      }, 1500L);
      return;
    }
    label216:
    FaceDetectReporter localFaceDetectReporter = FaceDetectReporter.aOy();
    int j = this.jNi;
    boolean bool = this.iHI;
    if (this.jNk != null) {}
    for (i = this.jNk.jMw;; i = 0)
    {
      localFaceDetectReporter.a(j, bool, 1, paramInt1, paramInt2, i);
      h.nFQ.a(917L, 16L, 1L, false);
      a(paramInt1, paramInt2, paramString, ((com.tencent.mm.plugin.facedetect.b.m)paramm).jMV, localBundle);
      return;
    }
  }
  
  public final void m(int paramInt1, int paramInt2, String paramString)
  {
    y.v("MicroMsg.FaceDetectMpController", "alvinluo onCollectEnd errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
  }
  
  public final void onRelease()
  {
    if (!FaceDetectReporter.aOy().jOu) {
      FaceDetectReporter.aOy().a(this.jNi, this.iHI, 2, 1, 90006);
    }
  }
  
  public final void onStart()
  {
    y.i("MicroMsg.FaceDetectMpController", "alvinluo onStart and create report session");
    if (this.iHI) {
      FaceDetectReporter.aOy().aOz();
    }
    FaceDetectReporter.aOy().L(this.jNi, this.iHI);
    FaceDetectReporter localFaceDetectReporter = FaceDetectReporter.aOy();
    localFaceDetectReporter.jOA += 1;
    y.v("MicroMsg.FaceDetectReporter", "alvinluo addFaceDetectCount: %d", new Object[] { Integer.valueOf(localFaceDetectReporter.jOA) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.c.d
 * JD-Core Version:    0.7.0.1
 */