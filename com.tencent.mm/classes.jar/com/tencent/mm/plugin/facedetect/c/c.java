package com.tencent.mm.plugin.facedetect.c;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.facedetect.a.d;
import com.tencent.mm.plugin.facedetect.a.i;
import com.tencent.mm.plugin.facedetect.b.n;
import com.tencent.mm.plugin.facedetect.b.o;
import com.tencent.mm.plugin.facedetect.b.s;
import com.tencent.mm.plugin.facedetect.b.t;
import com.tencent.mm.plugin.facedetect.model.FaceDetectReporter;
import com.tencent.mm.plugin.facedetect.ui.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class c
  extends a
{
  boolean iHI = false;
  private String jNp;
  private String jNq;
  private int jNr;
  
  c(Context paramContext, e parame, int paramInt1, int paramInt2)
  {
    super(paramContext, parame, paramInt1, paramInt2);
    this.jNl = true;
    this.jNr = paramInt1;
  }
  
  private void a(int paramInt1, int paramInt2, String paramString, boolean paramBoolean, Bundle paramBundle)
  {
    b(paramInt1, paramInt2, paramString, paramBundle);
    Object localObject = ae.getContext();
    if (paramString == null) {}
    for (String str1 = ((Context)localObject).getString(a.i.face_compare_fail);; str1 = paramString)
    {
      int i = a.d.face_err_icon;
      String str2;
      if (paramBoolean)
      {
        str2 = ((Context)localObject).getString(a.i.face_try_again);
        if (!paramBoolean) {
          break label129;
        }
      }
      label129:
      for (localObject = ((Context)localObject).getString(a.i.app_cancel);; localObject = null)
      {
        paramString = com.tencent.mm.plugin.facedetect.ui.a.b(i, str1, str2, (String)localObject, new c.2(this, paramBoolean, paramInt1, paramInt2, paramString, paramBundle), new c.3(this, paramInt1, paramInt2, paramString, paramBundle));
        paramString.status = 3;
        a(true, false, paramString);
        return;
        str2 = ((Context)localObject).getString(a.i.face_severe_error_main_btn);
        break;
      }
    }
  }
  
  private String getResultKey()
  {
    switch (this.jNr)
    {
    case 2: 
    default: 
      return "verify_result";
    case 0: 
    case 3: 
      return "faceregister_ticket";
    }
    return "faceverify_ticket";
  }
  
  public final m aOc()
  {
    long l = aOa();
    String str1 = this.jNp;
    String str2 = this.jNq;
    switch (this.jNr)
    {
    case 2: 
    default: 
      return null;
    case 0: 
      return new n(l, str1, str2);
    case 1: 
      return new s(l, str1, str2);
    case 3: 
      return new o(l, str1, str2);
    }
    return new t(l, str1, str2);
  }
  
  public final Bundle aOd()
  {
    Bundle localBundle = new Bundle();
    localBundle.putLong("k_bio_id", aOa());
    return localBundle;
  }
  
  public final void ae(int paramInt, String paramString)
  {
    y.i("MicroMsg.FaceDetectLoginController", "alvinluo onCancel, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt), paramString });
    if (!FaceDetectReporter.aOy().jOu) {
      FaceDetectReporter.aOy().a(FaceDetectReporter.qL(this.jNr), this.iHI, 2, 1, paramInt);
    }
    a(1, paramInt, paramString, null);
  }
  
  public final void c(int paramInt1, int paramInt2, String paramString, Bundle paramBundle)
  {
    y.i("MicroMsg.FaceDetectLoginController", "alvinluo onError errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (!FaceDetectReporter.aOy().jOu) {
      FaceDetectReporter.aOy().a(FaceDetectReporter.qL(this.jNr), this.iHI, 3, paramInt1, paramInt2);
    }
    if (paramBundle != null)
    {
      Bundle localBundle = new Bundle();
      paramBundle = paramBundle.getString(getResultKey());
      localBundle.putString(getResultKey(), paramBundle);
      a(paramInt1, paramInt2, paramString, localBundle);
      return;
    }
    a(paramInt1, paramInt2, paramString, null);
  }
  
  public final boolean c(int paramInt, String paramString, Bundle paramBundle)
  {
    y.i("MicroMsg.FaceDetectLoginController", "alvinluo onUploadEnd errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(0), paramString });
    if (paramInt != 0)
    {
      FaceDetectReporter.aOy().a(FaceDetectReporter.qL(this.jNr), this.iHI, 1, 2, 90012);
      a(paramInt, 0, paramString, false, null);
      return true;
    }
    if ((paramBundle == null) || (bk.bl(paramBundle.getString("key_pic_cdn_id"))))
    {
      y.e("MicroMsg.FaceDetectLoginController", "hy: not return cdn id!");
      a(4, 6, "not return cdn id", false, null);
      return true;
    }
    this.jNp = paramBundle.getString("key_pic_cdn_id");
    this.jNq = paramBundle.getString("key_cdn_aes_key");
    y.v("MicroMsg.FaceDetectLoginController", "hy: start upload: picCdnId: %s, aes key: %s", new Object[] { this.jNp, this.jNq });
    return false;
  }
  
  public final void h(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.i("MicroMsg.FaceDetectLoginController", "alvinluo onVerifyEnd sceneType: %d, errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramm.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    Object localObject;
    if ((paramm instanceof com.tencent.mm.plugin.facedetect.b.e))
    {
      localObject = (com.tencent.mm.plugin.facedetect.b.e)paramm;
      paramm = new Bundle();
      paramm.putString(getResultKey(), ((com.tencent.mm.plugin.facedetect.b.e)localObject).aNW());
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label206;
      }
      localFaceDetectReporter = FaceDetectReporter.aOy();
      j = this.jNi;
      bool = ((com.tencent.mm.plugin.facedetect.b.e)localObject).aNV();
      if (this.jNk == null) {
        break label200;
      }
    }
    label200:
    for (int i = this.jNk.jMw;; i = 0)
    {
      localFaceDetectReporter.a(j, bool, 0, paramInt1, paramInt2, i);
      localObject = com.tencent.mm.plugin.facedetect.ui.a.qQ(a.d.face_tick);
      ((d)localObject).jSo = true;
      ((d)localObject).jSw = ae.getResources().getString(a.i.jsapi_success);
      ((d)localObject).status = 2;
      a(false, true, (d)localObject);
      ai.l(new c.1(this, paramInt1, paramInt2, paramString, paramm), 1500L);
      return;
    }
    label206:
    FaceDetectReporter localFaceDetectReporter = FaceDetectReporter.aOy();
    int j = this.jNi;
    boolean bool = ((com.tencent.mm.plugin.facedetect.b.e)localObject).aNV();
    if (this.jNk != null) {}
    for (i = this.jNk.jMw;; i = 0)
    {
      localFaceDetectReporter.a(j, bool, 1, paramInt1, paramInt2, i);
      a(paramInt1, paramInt2, paramString, ((com.tencent.mm.plugin.facedetect.b.e)localObject).aNV(), paramm);
      return;
    }
  }
  
  public final void m(int paramInt1, int paramInt2, String paramString)
  {
    y.v("MicroMsg.FaceDetectLoginController", "alvinluo onCollectEnd errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
  }
  
  public final void onRelease()
  {
    if (!FaceDetectReporter.aOy().jOu) {
      FaceDetectReporter.aOy().a(FaceDetectReporter.qL(this.jNr), this.iHI, 2, 1, 90006);
    }
  }
  
  public final void onStart()
  {
    y.i("MicroMsg.FaceDetectLoginController", "alvinluo onStart and create report session");
    if (this.iHI)
    {
      FaceDetectReporter.aOy().aOz();
      FaceDetectReporter.aOy().L(FaceDetectReporter.qL(this.jNr), this.iHI);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.c.c
 * JD-Core Version:    0.7.0.1
 */