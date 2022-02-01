package com.tencent.mm.plugin.facedetect.c;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.facedetect.b.e;
import com.tencent.mm.plugin.facedetect.b.o;
import com.tencent.mm.plugin.facedetect.b.s;
import com.tencent.mm.plugin.facedetect.b.t;
import com.tencent.mm.plugin.facedetect.model.FaceDetectReporter;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;

public final class c
  extends a
{
  boolean isRetry = false;
  private String rgK;
  private String rgL;
  private int rgM;
  
  c(Context paramContext, f paramf, int paramInt1, int paramInt2)
  {
    super(paramContext, paramf, paramInt1, paramInt2);
    this.rgG = true;
    this.rgM = paramInt1;
  }
  
  private void a(final int paramInt1, final int paramInt2, final String paramString, final boolean paramBoolean, final Bundle paramBundle)
  {
    AppMethodBeat.i(103658);
    b(paramInt1, paramInt2, paramString, paramBundle);
    Object localObject = aj.getContext();
    if (paramString == null) {}
    for (String str1 = ((Context)localObject).getString(2131758686);; str1 = paramString)
    {
      String str2;
      if (paramBoolean)
      {
        str2 = ((Context)localObject).getString(2131758762);
        if (!paramBoolean) {
          break label130;
        }
      }
      label130:
      for (localObject = ((Context)localObject).getString(2131755691);; localObject = null)
      {
        paramString = com.tencent.mm.plugin.facedetect.ui.a.b(2131232130, str1, str2, (String)localObject, new View.OnClickListener()new View.OnClickListener
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(103647);
            b localb = new b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/facedetect/controller/FaceDetectLoginController$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            if (paramBoolean)
            {
              paramAnonymousView = c.this;
              paramAnonymousView.csI();
              paramAnonymousView.isRetry = true;
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/facedetect/controller/FaceDetectLoginController$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(103647);
              return;
              c.this.a(paramInt1, paramInt2, paramString, paramBundle);
            }
          }
        }, new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(103648);
            b localb = new b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/facedetect/controller/FaceDetectLoginController$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            c.this.a(paramInt1, paramInt2, paramString, paramBundle);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/facedetect/controller/FaceDetectLoginController$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(103648);
          }
        });
        paramString.status = 3;
        a(true, false, paramString);
        AppMethodBeat.o(103658);
        return;
        str2 = ((Context)localObject).getString(2131758760);
        break;
      }
    }
  }
  
  private String getResultKey()
  {
    switch (this.rgM)
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
  
  public final void aT(int paramInt, String paramString)
  {
    AppMethodBeat.i(103656);
    ad.i("MicroMsg.FaceDetectLoginController", "alvinluo onCancel, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt), paramString });
    if (!FaceDetectReporter.cth().rhS) {
      FaceDetectReporter.cth().a(FaceDetectReporter.DL(this.rgM), this.isRetry, 2, 1, paramInt);
    }
    a(1, paramInt, paramString, null);
    AppMethodBeat.o(103656);
  }
  
  public final void c(int paramInt1, int paramInt2, String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(103655);
    ad.i("MicroMsg.FaceDetectLoginController", "alvinluo onError errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (!FaceDetectReporter.cth().rhS) {
      FaceDetectReporter.cth().a(FaceDetectReporter.DL(this.rgM), this.isRetry, 3, paramInt1, paramInt2);
    }
    if (paramBundle != null)
    {
      Bundle localBundle = new Bundle();
      paramBundle = paramBundle.getString(getResultKey());
      localBundle.putString(getResultKey(), paramBundle);
      a(paramInt1, paramInt2, paramString, localBundle);
      AppMethodBeat.o(103655);
      return;
    }
    a(paramInt1, paramInt2, paramString, null);
    AppMethodBeat.o(103655);
  }
  
  public final boolean c(int paramInt, String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(103653);
    ad.i("MicroMsg.FaceDetectLoginController", "alvinluo onUploadEnd errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(0), paramString });
    if (paramInt != 0)
    {
      FaceDetectReporter.cth().a(FaceDetectReporter.DL(this.rgM), this.isRetry, 1, 2, 90012);
      a(paramInt, 0, paramString, false, null);
      AppMethodBeat.o(103653);
      return true;
    }
    if ((paramBundle == null) || (bt.isNullOrNil(paramBundle.getString("key_pic_cdn_id"))))
    {
      ad.e("MicroMsg.FaceDetectLoginController", "hy: not return cdn id!");
      a(4, 6, "not return cdn id", false, null);
      AppMethodBeat.o(103653);
      return true;
    }
    this.rgK = paramBundle.getString("key_pic_cdn_id");
    this.rgL = paramBundle.getString("key_cdn_aes_key");
    ad.v("MicroMsg.FaceDetectLoginController", "hy: start upload: picCdnId: %s, aes key: %s", new Object[] { this.rgK, this.rgL });
    AppMethodBeat.o(103653);
    return false;
  }
  
  public final com.tencent.mm.al.n csL()
  {
    AppMethodBeat.i(103649);
    long l = csJ();
    Object localObject = this.rgK;
    String str = this.rgL;
    switch (this.rgM)
    {
    case 2: 
    default: 
      AppMethodBeat.o(103649);
      return null;
    case 0: 
      localObject = new com.tencent.mm.plugin.facedetect.b.n(l, (String)localObject, str);
      AppMethodBeat.o(103649);
      return localObject;
    case 1: 
      localObject = new s(l, (String)localObject, str);
      AppMethodBeat.o(103649);
      return localObject;
    case 3: 
      localObject = new o(l, (String)localObject, str);
      AppMethodBeat.o(103649);
      return localObject;
    }
    localObject = new t(l, (String)localObject, str);
    AppMethodBeat.o(103649);
    return localObject;
  }
  
  public final Bundle csM()
  {
    AppMethodBeat.i(103657);
    Bundle localBundle = new Bundle();
    localBundle.putLong("k_bio_id", csJ());
    AppMethodBeat.o(103657);
    return localBundle;
  }
  
  public final void f(final int paramInt1, final int paramInt2, final String paramString, final com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(103654);
    ad.i("MicroMsg.FaceDetectLoginController", "alvinluo onVerifyEnd sceneType: %d, errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramn.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    Object localObject;
    FaceDetectReporter localFaceDetectReporter;
    int j;
    boolean bool;
    if ((paramn instanceof e))
    {
      localObject = (e)paramn;
      paramn = new Bundle();
      paramn.putString(getResultKey(), ((e)localObject).csF());
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        localFaceDetectReporter = FaceDetectReporter.cth();
        j = this.rgD;
        bool = ((e)localObject).csE();
        if (this.rgF != null) {}
        for (i = this.rgF.rfP;; i = 0)
        {
          localFaceDetectReporter.a(j, bool, 0, paramInt1, paramInt2, i);
          localObject = com.tencent.mm.plugin.facedetect.ui.a.ctH();
          ((com.tencent.mm.plugin.facedetect.ui.c)localObject).rlR = true;
          ((com.tencent.mm.plugin.facedetect.ui.c)localObject).rlZ = aj.getResources().getString(2131760594);
          ((com.tencent.mm.plugin.facedetect.ui.c)localObject).status = 2;
          a(false, true, (com.tencent.mm.plugin.facedetect.ui.c)localObject);
          aq.o(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(103646);
              c.this.a(paramInt1, paramInt2, paramString, paramn);
              AppMethodBeat.o(103646);
            }
          }, 1500L);
          AppMethodBeat.o(103654);
          return;
        }
      }
      localFaceDetectReporter = FaceDetectReporter.cth();
      j = this.rgD;
      bool = ((e)localObject).csE();
      if (this.rgF == null) {
        break label284;
      }
    }
    label284:
    for (int i = this.rgF.rfP;; i = 0)
    {
      localFaceDetectReporter.a(j, bool, 1, paramInt1, paramInt2, i);
      a(paramInt1, paramInt2, paramString, ((e)localObject).csE(), paramn);
      AppMethodBeat.o(103654);
      return;
    }
  }
  
  public final void onRelease()
  {
    AppMethodBeat.i(103651);
    if (!FaceDetectReporter.cth().rhS) {
      FaceDetectReporter.cth().a(FaceDetectReporter.DL(this.rgM), this.isRetry, 2, 1, 90006);
    }
    AppMethodBeat.o(103651);
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(103650);
    ad.i("MicroMsg.FaceDetectLoginController", "alvinluo onStart and create report session");
    FaceDetectReporter.cth().cti();
    FaceDetectReporter.cth().ab(FaceDetectReporter.DL(this.rgM), this.isRetry);
    AppMethodBeat.o(103650);
  }
  
  public final void t(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(103652);
    ad.v("MicroMsg.FaceDetectLoginController", "alvinluo onCollectEnd errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    AppMethodBeat.o(103652);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.c.c
 * JD-Core Version:    0.7.0.1
 */