package com.tencent.mm.plugin.facedetect.c;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.facedetect.b.e;
import com.tencent.mm.plugin.facedetect.b.n;
import com.tencent.mm.plugin.facedetect.b.o;
import com.tencent.mm.plugin.facedetect.b.s;
import com.tencent.mm.plugin.facedetect.b.t;
import com.tencent.mm.plugin.facedetect.model.FaceDetectReporter;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;

public final class c
  extends a
{
  boolean isRetry = false;
  private int mhA;
  private String mhy;
  private String mhz;
  
  c(Context paramContext, f paramf, int paramInt1, int paramInt2)
  {
    super(paramContext, paramf, paramInt1, paramInt2);
    this.mhu = true;
    this.mhA = paramInt1;
  }
  
  private void a(int paramInt1, int paramInt2, String paramString, boolean paramBoolean, Bundle paramBundle)
  {
    AppMethodBeat.i(133);
    b(paramInt1, paramInt2, paramString, paramBundle);
    Object localObject = ah.getContext();
    if (paramString == null) {}
    for (String str1 = ((Context)localObject).getString(2131299529);; str1 = paramString)
    {
      String str2;
      if (paramBoolean)
      {
        str2 = ((Context)localObject).getString(2131299605);
        if (!paramBoolean) {
          break label132;
        }
      }
      label132:
      for (localObject = ((Context)localObject).getString(2131296888);; localObject = null)
      {
        paramString = com.tencent.mm.plugin.facedetect.ui.a.b(2130838689, str1, str2, (String)localObject, new c.2(this, paramBoolean, paramInt1, paramInt2, paramString, paramBundle), new c.3(this, paramInt1, paramInt2, paramString, paramBundle));
        paramString.status = 3;
        a(true, false, paramString);
        AppMethodBeat.o(133);
        return;
        str2 = ((Context)localObject).getString(2131299603);
        break;
      }
    }
  }
  
  private String getResultKey()
  {
    switch (this.mhA)
    {
    case 2: 
    case 5: 
    default: 
      return "verify_result";
    case 0: 
    case 3: 
      return "faceregister_ticket";
    }
    return "faceverify_ticket";
  }
  
  public final void ax(int paramInt, String paramString)
  {
    AppMethodBeat.i(131);
    ab.i("MicroMsg.FaceDetectLoginController", "alvinluo onCancel, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt), paramString });
    if (!FaceDetectReporter.buB().miH) {
      FaceDetectReporter.buB().b(FaceDetectReporter.vG(this.mhA), this.isRetry, 2, 1, paramInt);
    }
    a(1, paramInt, paramString, null);
    AppMethodBeat.o(131);
  }
  
  public final m buf()
  {
    AppMethodBeat.i(124);
    long l = bud();
    Object localObject = this.mhy;
    String str = this.mhz;
    switch (this.mhA)
    {
    case 2: 
    default: 
      AppMethodBeat.o(124);
      return null;
    case 0: 
      localObject = new n(l, (String)localObject, str);
      AppMethodBeat.o(124);
      return localObject;
    case 1: 
      localObject = new s(l, (String)localObject, str);
      AppMethodBeat.o(124);
      return localObject;
    case 3: 
      localObject = new o(l, (String)localObject, str);
      AppMethodBeat.o(124);
      return localObject;
    }
    localObject = new t(l, (String)localObject, str);
    AppMethodBeat.o(124);
    return localObject;
  }
  
  public final Bundle bug()
  {
    AppMethodBeat.i(132);
    Bundle localBundle = new Bundle();
    localBundle.putLong("k_bio_id", bud());
    AppMethodBeat.o(132);
    return localBundle;
  }
  
  public final void c(int paramInt1, int paramInt2, String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(130);
    ab.i("MicroMsg.FaceDetectLoginController", "alvinluo onError errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (!FaceDetectReporter.buB().miH) {
      FaceDetectReporter.buB().b(FaceDetectReporter.vG(this.mhA), this.isRetry, 3, paramInt1, paramInt2);
    }
    if (paramBundle != null)
    {
      Bundle localBundle = new Bundle();
      paramBundle = paramBundle.getString(getResultKey());
      localBundle.putString(getResultKey(), paramBundle);
      a(paramInt1, paramInt2, paramString, localBundle);
      AppMethodBeat.o(130);
      return;
    }
    a(paramInt1, paramInt2, paramString, null);
    AppMethodBeat.o(130);
  }
  
  public final boolean c(int paramInt, String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(128);
    ab.i("MicroMsg.FaceDetectLoginController", "alvinluo onUploadEnd errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(0), paramString });
    if (paramInt != 0)
    {
      FaceDetectReporter.buB().b(FaceDetectReporter.vG(this.mhA), this.isRetry, 1, 2, 90012);
      a(paramInt, 0, paramString, false, null);
      AppMethodBeat.o(128);
      return true;
    }
    if ((paramBundle == null) || (bo.isNullOrNil(paramBundle.getString("key_pic_cdn_id"))))
    {
      ab.e("MicroMsg.FaceDetectLoginController", "hy: not return cdn id!");
      a(4, 6, "not return cdn id", false, null);
      AppMethodBeat.o(128);
      return true;
    }
    this.mhy = paramBundle.getString("key_pic_cdn_id");
    this.mhz = paramBundle.getString("key_cdn_aes_key");
    ab.v("MicroMsg.FaceDetectLoginController", "hy: start upload: picCdnId: %s, aes key: %s", new Object[] { this.mhy, this.mhz });
    AppMethodBeat.o(128);
    return false;
  }
  
  public final void f(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(129);
    ab.i("MicroMsg.FaceDetectLoginController", "alvinluo onVerifyEnd sceneType: %d, errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramm.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    Object localObject;
    FaceDetectReporter localFaceDetectReporter;
    int j;
    boolean bool;
    if ((paramm instanceof e))
    {
      localObject = (e)paramm;
      paramm = new Bundle();
      paramm.putString(getResultKey(), ((e)localObject).btZ());
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        localFaceDetectReporter = FaceDetectReporter.buB();
        j = this.mhr;
        bool = ((e)localObject).btY();
        if (this.mht != null) {}
        for (i = this.mht.mgC;; i = 0)
        {
          localFaceDetectReporter.a(j, bool, 0, paramInt1, paramInt2, i);
          localObject = com.tencent.mm.plugin.facedetect.ui.a.bva();
          ((com.tencent.mm.plugin.facedetect.ui.c)localObject).mmK = true;
          ((com.tencent.mm.plugin.facedetect.ui.c)localObject).mmS = ah.getResources().getString(2131300992);
          ((com.tencent.mm.plugin.facedetect.ui.c)localObject).status = 2;
          a(false, true, (com.tencent.mm.plugin.facedetect.ui.c)localObject);
          al.p(new c.1(this, paramInt1, paramInt2, paramString, paramm), 1500L);
          AppMethodBeat.o(129);
          return;
        }
      }
      localFaceDetectReporter = FaceDetectReporter.buB();
      j = this.mhr;
      bool = ((e)localObject).btY();
      if (this.mht == null) {
        break label287;
      }
    }
    label287:
    for (int i = this.mht.mgC;; i = 0)
    {
      localFaceDetectReporter.a(j, bool, 1, paramInt1, paramInt2, i);
      a(paramInt1, paramInt2, paramString, ((e)localObject).btY(), paramm);
      AppMethodBeat.o(129);
      return;
    }
  }
  
  public final void onRelease()
  {
    AppMethodBeat.i(126);
    if (!FaceDetectReporter.buB().miH) {
      FaceDetectReporter.buB().b(FaceDetectReporter.vG(this.mhA), this.isRetry, 2, 1, 90006);
    }
    AppMethodBeat.o(126);
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(125);
    ab.i("MicroMsg.FaceDetectLoginController", "alvinluo onStart and create report session");
    FaceDetectReporter.buB().buC();
    FaceDetectReporter.buB().T(FaceDetectReporter.vG(this.mhA), this.isRetry);
    AppMethodBeat.o(125);
  }
  
  public final void q(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(127);
    ab.v("MicroMsg.FaceDetectLoginController", "alvinluo onCollectEnd errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    AppMethodBeat.o(127);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.c.c
 * JD-Core Version:    0.7.0.1
 */