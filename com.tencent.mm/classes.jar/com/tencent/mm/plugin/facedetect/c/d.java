package com.tencent.mm.plugin.facedetect.c;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.facedetect.b.m;
import com.tencent.mm.plugin.facedetect.model.FaceDetectReporter;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import java.lang.ref.WeakReference;

public final class d
  extends a
{
  String appId;
  boolean isRetry;
  private String jsonString;
  private String rgK;
  private String rgL;
  String rgQ;
  private float rgR;
  private boolean rgS;
  
  d(Context paramContext, f paramf, int paramInt1, int paramInt2, Bundle paramBundle)
  {
    super(paramContext, paramf, paramInt1, paramInt2);
    AppMethodBeat.i(103663);
    this.isRetry = false;
    this.rgG = true;
    this.appId = paramBundle.getString("k_app_id", null);
    this.jsonString = paramBundle.getString("request_verify_pre_info", null);
    this.rgQ = paramBundle.getString("key_feedback_url", null);
    this.rgR = paramBundle.getFloat("key_current_light", 0.0F);
    this.rgS = paramBundle.getBoolean("key_upload_video", false);
    AppMethodBeat.o(103663);
  }
  
  private void a(final int paramInt1, final int paramInt2, final String paramString, final boolean paramBoolean, final Bundle paramBundle)
  {
    AppMethodBeat.i(103673);
    ad.e("MicroMsg.FaceDetectMpController", "carson onVerifyFailed（）");
    b(paramInt1, paramInt2, paramString, paramBundle);
    final Context localContext = aj.getContext();
    if (paramString == null) {}
    for (String str1 = localContext.getString(2131758686);; str1 = paramString)
    {
      String str2;
      if (paramBoolean)
      {
        str2 = localContext.getString(2131758762);
        if (!paramBoolean) {
          break label162;
        }
      }
      label162:
      for (String str3 = localContext.getString(2131755691);; str3 = null)
      {
        paramString = com.tencent.mm.plugin.facedetect.ui.a.b(2131232130, str1, str2, str3, new View.OnClickListener()new View.OnClickListener
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(103660);
            b localb = new b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/facedetect/controller/FaceDetectMpController$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            if (paramBoolean)
            {
              paramAnonymousView = d.this;
              paramAnonymousView.csI();
              paramAnonymousView.isRetry = true;
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/facedetect/controller/FaceDetectMpController$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(103660);
              return;
              d.this.a(paramInt1, paramInt2, paramString, paramBundle);
            }
          }
        }, new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(103661);
            b localb = new b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/facedetect/controller/FaceDetectMpController$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            d.this.a(paramInt1, paramInt2, paramString, paramBundle);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/facedetect/controller/FaceDetectMpController$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(103661);
          }
        });
        paramString.status = 3;
        com.tencent.mm.plugin.facedetect.ui.a.a(paramString, localContext.getString(2131758717), new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(103662);
            Object localObject = new b();
            ((b)localObject).bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/facedetect/controller/FaceDetectMpController$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
            if (bt.isNullOrNil(d.this.rgQ))
            {
              ad.e("MicroMsg.FaceDetectMpController", "alvinluo feedback url is null");
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/facedetect/controller/FaceDetectMpController$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(103662);
              return;
            }
            if ((d.this.rgB != null) && (d.this.rgB.get() != null)) {
              ((f)d.this.rgB.get()).csN();
            }
            paramAnonymousView = null;
            if (paramBundle != null) {
              paramAnonymousView = paramBundle.getString("verify_result");
            }
            for (;;)
            {
              try
              {
                if (d.this.appId == null) {
                  continue;
                }
                localObject = d.this.appId;
                int i = paramInt2;
                if (paramAnonymousView == null) {
                  continue;
                }
                paramAnonymousView = q.encode(String.format("appid=%s;errcode=%d;identifyid=%s", new Object[] { localObject, Integer.valueOf(i), paramAnonymousView }), "UTF-8");
                paramAnonymousView = d.this.rgQ + "?customInfo=" + paramAnonymousView;
                ad.i("MicroMsg.FaceDetectMpController", "alvinluo feedback url: %s", new Object[] { paramAnonymousView });
                localObject = new Intent();
                ((Intent)localObject).putExtra("rawUrl", paramAnonymousView);
                com.tencent.mm.bs.d.b(localContext, "webview", ".ui.tools.WebViewUI", (Intent)localObject);
              }
              catch (Exception paramAnonymousView)
              {
                ad.printErrStackTrace("MicroMsg.FaceDetectMpController", paramAnonymousView, "alvinluo start feedback webview exception", new Object[0]);
                continue;
              }
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/facedetect/controller/FaceDetectMpController$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(103662);
              return;
              localObject = "";
              continue;
              paramAnonymousView = "";
            }
          }
        });
        a(true, false, paramString);
        AppMethodBeat.o(103673);
        return;
        str2 = localContext.getString(2131758760);
        break;
      }
    }
  }
  
  public final void aT(int paramInt, String paramString)
  {
    AppMethodBeat.i(103671);
    ad.i("MicroMsg.FaceDetectMpController", "alvinluo onCancel, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt), paramString });
    if (!FaceDetectReporter.cth().rhS) {
      FaceDetectReporter.cth().a(this.rgD, this.isRetry, 2, 1, paramInt);
    }
    a(1, paramInt, paramString, null);
    AppMethodBeat.o(103671);
  }
  
  public final void c(int paramInt1, int paramInt2, String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(103670);
    ad.i("MicroMsg.FaceDetectMpController", "alvinluo onError errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (!FaceDetectReporter.cth().rhS) {
      FaceDetectReporter.cth().a(this.rgD, this.isRetry, 3, paramInt1, paramInt2);
    }
    if (paramBundle != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("verify_result", paramBundle.getString("verify_result"));
      a(paramInt1, paramInt2, paramString, localBundle);
      AppMethodBeat.o(103670);
      return;
    }
    a(paramInt1, paramInt2, paramString, null);
    AppMethodBeat.o(103670);
  }
  
  public final boolean c(int paramInt, String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(103668);
    ad.i("MicroMsg.FaceDetectMpController", "alvinluo onUploadEnd errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(0), paramString });
    if (paramInt != 0)
    {
      FaceDetectReporter.cth().a(this.rgD, this.isRetry, 1, 2, 90012);
      a(paramInt, 0, paramString, false, null);
      AppMethodBeat.o(103668);
      return true;
    }
    if ((paramBundle == null) || (bt.isNullOrNil(paramBundle.getString("key_pic_cdn_id"))))
    {
      ad.e("MicroMsg.FaceDetectMpController", "hy: not return cdn id!");
      a(4, 6, "not return cdn id", false, null);
      AppMethodBeat.o(103668);
      return true;
    }
    this.rgK = paramBundle.getString("key_pic_cdn_id");
    this.rgL = paramBundle.getString("key_cdn_aes_key");
    ad.v("MicroMsg.FaceDetectMpController", "hy: start upload: picCdnId: %s, aes key: %s", new Object[] { this.rgK, this.rgL });
    AppMethodBeat.o(103668);
    return false;
  }
  
  public final n csL()
  {
    AppMethodBeat.i(103664);
    long l = csJ();
    Object localObject = this.appId;
    String str1 = this.jsonString;
    String str2 = this.rgK;
    String str3 = this.rgL;
    int j = this.rgH;
    float f = this.rgR;
    if (this.rgS) {}
    for (int i = 1;; i = 0)
    {
      localObject = new m(l, (String)localObject, str1, str2, str3, j, f, i);
      AppMethodBeat.o(103664);
      return localObject;
    }
  }
  
  public final Bundle csM()
  {
    AppMethodBeat.i(103672);
    Bundle localBundle = new Bundle();
    localBundle.putLong("k_bio_id", csJ());
    localBundle.putString("key_app_id", this.appId);
    AppMethodBeat.o(103672);
    return localBundle;
  }
  
  public final void f(final int paramInt1, final int paramInt2, final String paramString, n paramn)
  {
    AppMethodBeat.i(103669);
    ad.i("MicroMsg.FaceDetectMpController", "alvinluo onVerifyEnd sceneType: %d, errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramn.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    final Bundle localBundle;
    int j;
    boolean bool;
    FaceDetectReporter localFaceDetectReporter;
    if ((paramn instanceof m))
    {
      localBundle = new Bundle();
      localBundle.putString("verify_result", ((m)paramn).rgq);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramn = FaceDetectReporter.cth();
        j = this.rgD;
        bool = this.isRetry;
        if (this.rgF != null) {}
        for (i = this.rgF.rfP;; i = 0)
        {
          paramn.a(j, bool, 0, paramInt1, paramInt2, i);
          g.yhR.idkeyStat(917L, 15L, 1L, false);
          FaceDetectReporter.cth().ric = true;
          paramn = com.tencent.mm.plugin.facedetect.ui.a.ctH();
          paramn.rlR = true;
          paramn.rlZ = aj.getResources().getString(2131760594);
          paramn.status = 2;
          a(false, true, paramn);
          aq.o(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(103659);
              d.this.a(paramInt1, paramInt2, paramString, localBundle);
              AppMethodBeat.o(103659);
            }
          }, 1500L);
          AppMethodBeat.o(103669);
          return;
        }
      }
      localFaceDetectReporter = FaceDetectReporter.cth();
      j = this.rgD;
      bool = this.isRetry;
      if (this.rgF == null) {
        break label307;
      }
    }
    label307:
    for (int i = this.rgF.rfP;; i = 0)
    {
      localFaceDetectReporter.a(j, bool, 1, paramInt1, paramInt2, i);
      g.yhR.idkeyStat(917L, 16L, 1L, false);
      a(paramInt1, paramInt2, paramString, ((m)paramn).pQM, localBundle);
      AppMethodBeat.o(103669);
      return;
    }
  }
  
  public final void onRelease()
  {
    AppMethodBeat.i(103666);
    if (!FaceDetectReporter.cth().rhS) {
      FaceDetectReporter.cth().a(this.rgD, this.isRetry, 2, 1, 90006);
    }
    AppMethodBeat.o(103666);
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(103665);
    ad.i("MicroMsg.FaceDetectMpController", "alvinluo onStart and create report session");
    FaceDetectReporter.cth().cti();
    FaceDetectReporter.cth().ab(this.rgD, this.isRetry);
    FaceDetectReporter localFaceDetectReporter = FaceDetectReporter.cth();
    localFaceDetectReporter.rib += 1;
    ad.v("MicroMsg.FaceDetectReporter", "alvinluo addFaceDetectCount: %d", new Object[] { Integer.valueOf(localFaceDetectReporter.rib) });
    AppMethodBeat.o(103665);
  }
  
  public final void t(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(103667);
    ad.v("MicroMsg.FaceDetectMpController", "alvinluo onCollectEnd errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    AppMethodBeat.o(103667);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.c.d
 * JD-Core Version:    0.7.0.1
 */