package com.tencent.mm.plugin.facedetect.c;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.facedetect.model.FaceDetectReporter;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;

public final class d
  extends a
{
  String appId;
  boolean isRetry;
  private String jsonString;
  String mhE;
  private float mhF;
  private boolean mhG;
  private String mhy;
  private String mhz;
  
  d(Context paramContext, f paramf, int paramInt1, int paramInt2, Bundle paramBundle)
  {
    super(paramContext, paramf, paramInt1, paramInt2);
    AppMethodBeat.i(138);
    this.isRetry = false;
    this.mhu = true;
    this.appId = paramBundle.getString("k_app_id", null);
    this.jsonString = paramBundle.getString("request_verify_pre_info", null);
    this.mhE = paramBundle.getString("key_feedback_url", null);
    this.mhF = paramBundle.getFloat("key_current_light", 0.0F);
    this.mhG = paramBundle.getBoolean("key_upload_video", false);
    AppMethodBeat.o(138);
  }
  
  private void a(int paramInt1, int paramInt2, String paramString, boolean paramBoolean, Bundle paramBundle)
  {
    AppMethodBeat.i(148);
    ab.e("MicroMsg.FaceDetectMpController", "carson onVerifyFailed（）");
    b(paramInt1, paramInt2, paramString, paramBundle);
    Context localContext = ah.getContext();
    if (paramString == null) {}
    for (String str1 = localContext.getString(2131299529);; str1 = paramString)
    {
      String str2;
      if (paramBoolean)
      {
        str2 = localContext.getString(2131299605);
        if (!paramBoolean) {
          break label164;
        }
      }
      label164:
      for (String str3 = localContext.getString(2131296888);; str3 = null)
      {
        paramString = com.tencent.mm.plugin.facedetect.ui.a.b(2130838689, str1, str2, str3, new d.2(this, paramBoolean, paramInt1, paramInt2, paramString, paramBundle), new d.3(this, paramInt1, paramInt2, paramString, paramBundle));
        paramString.status = 3;
        com.tencent.mm.plugin.facedetect.ui.a.a(paramString, localContext.getString(2131299560), new d.4(this, paramBundle, paramInt2, localContext));
        a(true, false, paramString);
        AppMethodBeat.o(148);
        return;
        str2 = localContext.getString(2131299603);
        break;
      }
    }
  }
  
  public final void ax(int paramInt, String paramString)
  {
    AppMethodBeat.i(146);
    ab.i("MicroMsg.FaceDetectMpController", "alvinluo onCancel, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt), paramString });
    if (!FaceDetectReporter.buB().miH) {
      FaceDetectReporter.buB().b(this.mhr, this.isRetry, 2, 1, paramInt);
    }
    a(1, paramInt, paramString, null);
    AppMethodBeat.o(146);
  }
  
  public final com.tencent.mm.ai.m buf()
  {
    AppMethodBeat.i(139);
    long l = bud();
    Object localObject = this.appId;
    String str1 = this.jsonString;
    String str2 = this.mhy;
    String str3 = this.mhz;
    int j = this.mhv;
    float f = this.mhF;
    if (this.mhG) {}
    for (int i = 1;; i = 0)
    {
      localObject = new com.tencent.mm.plugin.facedetect.b.m(l, (String)localObject, str1, str2, str3, j, f, i);
      AppMethodBeat.o(139);
      return localObject;
    }
  }
  
  public final Bundle bug()
  {
    AppMethodBeat.i(147);
    Bundle localBundle = new Bundle();
    localBundle.putLong("k_bio_id", bud());
    localBundle.putString("key_app_id", this.appId);
    AppMethodBeat.o(147);
    return localBundle;
  }
  
  public final void c(int paramInt1, int paramInt2, String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(145);
    ab.i("MicroMsg.FaceDetectMpController", "alvinluo onError errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (!FaceDetectReporter.buB().miH) {
      FaceDetectReporter.buB().b(this.mhr, this.isRetry, 3, paramInt1, paramInt2);
    }
    if (paramBundle != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("verify_result", paramBundle.getString("verify_result"));
      a(paramInt1, paramInt2, paramString, localBundle);
      AppMethodBeat.o(145);
      return;
    }
    a(paramInt1, paramInt2, paramString, null);
    AppMethodBeat.o(145);
  }
  
  public final boolean c(int paramInt, String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(143);
    ab.i("MicroMsg.FaceDetectMpController", "alvinluo onUploadEnd errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(0), paramString });
    if (paramInt != 0)
    {
      FaceDetectReporter.buB().b(this.mhr, this.isRetry, 1, 2, 90012);
      a(paramInt, 0, paramString, false, null);
      AppMethodBeat.o(143);
      return true;
    }
    if ((paramBundle == null) || (bo.isNullOrNil(paramBundle.getString("key_pic_cdn_id"))))
    {
      ab.e("MicroMsg.FaceDetectMpController", "hy: not return cdn id!");
      a(4, 6, "not return cdn id", false, null);
      AppMethodBeat.o(143);
      return true;
    }
    this.mhy = paramBundle.getString("key_pic_cdn_id");
    this.mhz = paramBundle.getString("key_cdn_aes_key");
    ab.v("MicroMsg.FaceDetectMpController", "hy: start upload: picCdnId: %s, aes key: %s", new Object[] { this.mhy, this.mhz });
    AppMethodBeat.o(143);
    return false;
  }
  
  public final void f(final int paramInt1, final int paramInt2, final String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(144);
    ab.i("MicroMsg.FaceDetectMpController", "alvinluo onVerifyEnd sceneType: %d, errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramm.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    final Bundle localBundle;
    int j;
    boolean bool;
    FaceDetectReporter localFaceDetectReporter;
    if ((paramm instanceof com.tencent.mm.plugin.facedetect.b.m))
    {
      localBundle = new Bundle();
      localBundle.putString("verify_result", ((com.tencent.mm.plugin.facedetect.b.m)paramm).mhd);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramm = FaceDetectReporter.buB();
        j = this.mhr;
        bool = this.isRetry;
        if (this.mht != null) {}
        for (i = this.mht.mgC;; i = 0)
        {
          paramm.a(j, bool, 0, paramInt1, paramInt2, i);
          h.qsU.idkeyStat(917L, 15L, 1L, false);
          FaceDetectReporter.buB().miR = true;
          paramm = com.tencent.mm.plugin.facedetect.ui.a.bva();
          paramm.mmK = true;
          paramm.mmS = ah.getResources().getString(2131300992);
          paramm.status = 2;
          a(false, true, paramm);
          al.p(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(134);
              d.this.a(paramInt1, paramInt2, paramString, localBundle);
              AppMethodBeat.o(134);
            }
          }, 1500L);
          AppMethodBeat.o(144);
          return;
        }
      }
      localFaceDetectReporter = FaceDetectReporter.buB();
      j = this.mhr;
      bool = this.isRetry;
      if (this.mht == null) {
        break label310;
      }
    }
    label310:
    for (int i = this.mht.mgC;; i = 0)
    {
      localFaceDetectReporter.a(j, bool, 1, paramInt1, paramInt2, i);
      h.qsU.idkeyStat(917L, 16L, 1L, false);
      a(paramInt1, paramInt2, paramString, ((com.tencent.mm.plugin.facedetect.b.m)paramm).mhe, localBundle);
      AppMethodBeat.o(144);
      return;
    }
  }
  
  public final void onRelease()
  {
    AppMethodBeat.i(141);
    if (!FaceDetectReporter.buB().miH) {
      FaceDetectReporter.buB().b(this.mhr, this.isRetry, 2, 1, 90006);
    }
    AppMethodBeat.o(141);
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(140);
    ab.i("MicroMsg.FaceDetectMpController", "alvinluo onStart and create report session");
    FaceDetectReporter.buB().buC();
    FaceDetectReporter.buB().T(this.mhr, this.isRetry);
    FaceDetectReporter localFaceDetectReporter = FaceDetectReporter.buB();
    localFaceDetectReporter.miQ += 1;
    ab.v("MicroMsg.FaceDetectReporter", "alvinluo addFaceDetectCount: %d", new Object[] { Integer.valueOf(localFaceDetectReporter.miQ) });
    AppMethodBeat.o(140);
  }
  
  public final void q(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(142);
    ab.v("MicroMsg.FaceDetectMpController", "alvinluo onCollectEnd errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    AppMethodBeat.o(142);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.c.d
 * JD-Core Version:    0.7.0.1
 */