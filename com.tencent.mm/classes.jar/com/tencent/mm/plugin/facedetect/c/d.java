package com.tencent.mm.plugin.facedetect.c;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.compatible.util.p;
import com.tencent.mm.plugin.facedetect.b.m;
import com.tencent.mm.plugin.facedetect.model.FaceDetectReporter;
import com.tencent.mm.plugin.report.service.h;
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
  private String pOm;
  private String pOn;
  String pOs;
  private float pOt;
  private boolean pOu;
  
  d(Context paramContext, f paramf, int paramInt1, int paramInt2, Bundle paramBundle)
  {
    super(paramContext, paramf, paramInt1, paramInt2);
    AppMethodBeat.i(103663);
    this.isRetry = false;
    this.pOi = true;
    this.appId = paramBundle.getString("k_app_id", null);
    this.jsonString = paramBundle.getString("request_verify_pre_info", null);
    this.pOs = paramBundle.getString("key_feedback_url", null);
    this.pOt = paramBundle.getFloat("key_current_light", 0.0F);
    this.pOu = paramBundle.getBoolean("key_upload_video", false);
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
            if (paramBoolean)
            {
              paramAnonymousView = d.this;
              paramAnonymousView.cfw();
              paramAnonymousView.isRetry = true;
              AppMethodBeat.o(103660);
              return;
            }
            d.this.a(paramInt1, paramInt2, paramString, paramBundle);
            AppMethodBeat.o(103660);
          }
        }, new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(103661);
            d.this.a(paramInt1, paramInt2, paramString, paramBundle);
            AppMethodBeat.o(103661);
          }
        });
        paramString.status = 3;
        com.tencent.mm.plugin.facedetect.ui.a.a(paramString, localContext.getString(2131758717), new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(103662);
            if (bt.isNullOrNil(d.this.pOs))
            {
              ad.e("MicroMsg.FaceDetectMpController", "alvinluo feedback url is null");
              AppMethodBeat.o(103662);
              return;
            }
            if ((d.this.pOd != null) && (d.this.pOd.get() != null)) {
              ((f)d.this.pOd.get()).cfB();
            }
            paramAnonymousView = null;
            if (paramBundle != null) {
              paramAnonymousView = paramBundle.getString("verify_result");
            }
            try
            {
              Object localObject;
              int i;
              if (d.this.appId != null)
              {
                localObject = d.this.appId;
                i = paramInt2;
                if (paramAnonymousView == null) {
                  break label233;
                }
              }
              for (;;)
              {
                paramAnonymousView = p.encode(String.format("appid=%s;errcode=%d;identifyid=%s", new Object[] { localObject, Integer.valueOf(i), paramAnonymousView }), "UTF-8");
                paramAnonymousView = d.this.pOs + "?customInfo=" + paramAnonymousView;
                ad.i("MicroMsg.FaceDetectMpController", "alvinluo feedback url: %s", new Object[] { paramAnonymousView });
                localObject = new Intent();
                ((Intent)localObject).putExtra("rawUrl", paramAnonymousView);
                com.tencent.mm.bs.d.b(localContext, "webview", ".ui.tools.WebViewUI", (Intent)localObject);
                AppMethodBeat.o(103662);
                return;
                localObject = "";
                break;
                label233:
                paramAnonymousView = "";
              }
              return;
            }
            catch (Exception paramAnonymousView)
            {
              ad.printErrStackTrace("MicroMsg.FaceDetectMpController", paramAnonymousView, "alvinluo start feedback webview exception", new Object[0]);
              AppMethodBeat.o(103662);
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
  
  public final void aN(int paramInt, String paramString)
  {
    AppMethodBeat.i(103671);
    ad.i("MicroMsg.FaceDetectMpController", "alvinluo onCancel, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt), paramString });
    if (!FaceDetectReporter.cfV().pPu) {
      FaceDetectReporter.cfV().a(this.pOf, this.isRetry, 2, 1, paramInt);
    }
    a(1, paramInt, paramString, null);
    AppMethodBeat.o(103671);
  }
  
  public final void c(int paramInt1, int paramInt2, String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(103670);
    ad.i("MicroMsg.FaceDetectMpController", "alvinluo onError errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (!FaceDetectReporter.cfV().pPu) {
      FaceDetectReporter.cfV().a(this.pOf, this.isRetry, 3, paramInt1, paramInt2);
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
      FaceDetectReporter.cfV().a(this.pOf, this.isRetry, 1, 2, 90012);
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
    this.pOm = paramBundle.getString("key_pic_cdn_id");
    this.pOn = paramBundle.getString("key_cdn_aes_key");
    ad.v("MicroMsg.FaceDetectMpController", "hy: start upload: picCdnId: %s, aes key: %s", new Object[] { this.pOm, this.pOn });
    AppMethodBeat.o(103668);
    return false;
  }
  
  public final Bundle cfA()
  {
    AppMethodBeat.i(103672);
    Bundle localBundle = new Bundle();
    localBundle.putLong("k_bio_id", cfx());
    localBundle.putString("key_app_id", this.appId);
    AppMethodBeat.o(103672);
    return localBundle;
  }
  
  public final n cfz()
  {
    AppMethodBeat.i(103664);
    long l = cfx();
    Object localObject = this.appId;
    String str1 = this.jsonString;
    String str2 = this.pOm;
    String str3 = this.pOn;
    int j = this.pOj;
    float f = this.pOt;
    if (this.pOu) {}
    for (int i = 1;; i = 0)
    {
      localObject = new m(l, (String)localObject, str1, str2, str3, j, f, i);
      AppMethodBeat.o(103664);
      return localObject;
    }
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
      localBundle.putString("verify_result", ((m)paramn).pNS);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramn = FaceDetectReporter.cfV();
        j = this.pOf;
        bool = this.isRetry;
        if (this.pOh != null) {}
        for (i = this.pOh.pNr;; i = 0)
        {
          paramn.a(j, bool, 0, paramInt1, paramInt2, i);
          h.vKh.idkeyStat(917L, 15L, 1L, false);
          FaceDetectReporter.cfV().pPE = true;
          paramn = com.tencent.mm.plugin.facedetect.ui.a.cgv();
          paramn.pTw = true;
          paramn.pTE = aj.getResources().getString(2131760594);
          paramn.status = 2;
          a(false, true, paramn);
          aq.n(new Runnable()
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
      localFaceDetectReporter = FaceDetectReporter.cfV();
      j = this.pOf;
      bool = this.isRetry;
      if (this.pOh == null) {
        break label307;
      }
    }
    label307:
    for (int i = this.pOh.pNr;; i = 0)
    {
      localFaceDetectReporter.a(j, bool, 1, paramInt1, paramInt2, i);
      h.vKh.idkeyStat(917L, 16L, 1L, false);
      a(paramInt1, paramInt2, paramString, ((m)paramn).oJO, localBundle);
      AppMethodBeat.o(103669);
      return;
    }
  }
  
  public final void onRelease()
  {
    AppMethodBeat.i(103666);
    if (!FaceDetectReporter.cfV().pPu) {
      FaceDetectReporter.cfV().a(this.pOf, this.isRetry, 2, 1, 90006);
    }
    AppMethodBeat.o(103666);
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(103665);
    ad.i("MicroMsg.FaceDetectMpController", "alvinluo onStart and create report session");
    FaceDetectReporter.cfV().cfW();
    FaceDetectReporter.cfV().ab(this.pOf, this.isRetry);
    FaceDetectReporter localFaceDetectReporter = FaceDetectReporter.cfV();
    localFaceDetectReporter.pPD += 1;
    ad.v("MicroMsg.FaceDetectReporter", "alvinluo addFaceDetectCount: %d", new Object[] { Integer.valueOf(localFaceDetectReporter.pPD) });
    AppMethodBeat.o(103665);
  }
  
  public final void t(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(103667);
    ad.v("MicroMsg.FaceDetectMpController", "alvinluo onCollectEnd errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    AppMethodBeat.o(103667);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.c.d
 * JD-Core Version:    0.7.0.1
 */