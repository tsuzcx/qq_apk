package com.tencent.mm.plugin.appbrand.jsapi.openvoice;

import android.app.Activity;
import android.support.v4.app.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.a.c.a;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.page.b.a;
import com.tencent.mm.plugin.appbrand.page.r;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.permission.p;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import org.json.JSONObject;

public abstract class i
  extends a<c>
{
  private static c.a kwN;
  private aa ckN = null;
  
  abstract void a(c paramc, JSONObject paramJSONObject, int paramInt);
  
  public final void b(final c paramc, final JSONObject paramJSONObject, final int paramInt)
  {
    if (paramc.au(Activity.class) == null)
    {
      ad.e("MicroMsg.OpenVoice.JsApiOpenVoiceBase", "hy: no page context");
      return;
    }
    p.b(paramc.getAppId(), new a.a()
    {
      public final void onRequestPermissionsResult(int paramAnonymousInt, String[] paramAnonymousArrayOfString, int[] paramAnonymousArrayOfInt)
      {
        AppMethodBeat.i(188479);
        if (paramAnonymousInt != 121)
        {
          ad.e("MicroMsg.OpenVoice.JsApiOpenVoiceBase", "requestAudioPermission requestCode is not for open voice api");
          AppMethodBeat.o(188479);
          return;
        }
        if ((paramAnonymousArrayOfInt != null) && (paramAnonymousArrayOfInt.length > 0) && (paramAnonymousArrayOfInt[0] == 0))
        {
          ad.i("MicroMsg.OpenVoice.JsApiOpenVoiceBase", "requestAudioPermission permission is grant for open voice api");
          i.this.b(paramc, paramJSONObject, paramInt);
          AppMethodBeat.o(188479);
          return;
        }
        ad.e("MicroMsg.OpenVoice.JsApiOpenVoiceBase", "requestAudioPermission sys perm denied for open voice api");
        paramc.h(paramInt, i.this.e("fail:system permission denied", null));
        AppMethodBeat.o(188479);
      }
    });
    Object localObject = paramc.getContext();
    int i;
    if ((localObject == null) || (!(localObject instanceof Activity)))
    {
      ad.e("MicroMsg.OpenVoice.JsApiOpenVoiceBase", "fail, requestAudioPermission pageContext is null");
      paramc.h(paramInt, e("fail: context is null", null));
      i = 0;
    }
    boolean bool;
    while (i == 0)
    {
      ad.e("MicroMsg.OpenVoice.JsApiOpenVoiceBase", "requestAudioPermission is fail");
      ad.w("MicroMsg.OpenVoice.JsApiOpenVoiceBase", "hy: no record audio permission");
      paramc.h(paramInt, e("fail: no record audio permission", null));
      return;
      bool = com.tencent.mm.pluginsdk.permission.b.a((Activity)localObject, "android.permission.RECORD_AUDIO", 121, "", "");
      i = bool;
      if (bool)
      {
        p.TS(paramc.getAppId());
        i = bool;
      }
    }
    p.b(paramc.getAppId(), new a.a()
    {
      public final void onRequestPermissionsResult(int paramAnonymousInt, String[] paramAnonymousArrayOfString, int[] paramAnonymousArrayOfInt)
      {
        AppMethodBeat.i(188480);
        if (paramAnonymousInt != 122)
        {
          ad.e("MicroMsg.OpenVoice.JsApiOpenVoiceBase", "requestCameraPermission requestCode is not for open voice api");
          AppMethodBeat.o(188480);
          return;
        }
        if ((paramAnonymousArrayOfInt != null) && (paramAnonymousArrayOfInt.length > 0) && (paramAnonymousArrayOfInt[0] == 0))
        {
          ad.i("MicroMsg.OpenVoice.JsApiOpenVoiceBase", "requestCameraPermission permission is grant for open voice api");
          i.this.b(paramc, paramJSONObject, paramInt);
          AppMethodBeat.o(188480);
          return;
        }
        ad.e("MicroMsg.OpenVoice.JsApiOpenVoiceBase", "requestCameraPermission sys perm denied for open voice api");
        paramc.h(paramInt, i.this.e("fail:system permission denied", null));
        AppMethodBeat.o(188480);
      }
    });
    localObject = paramc.getContext();
    if ((localObject == null) || (!(localObject instanceof Activity)))
    {
      ad.e("MicroMsg.OpenVoice.JsApiOpenVoiceBase", "fail, requestCameraPermission pageContext is null");
      paramc.h(paramInt, e("fail: context is null", null));
      i = 0;
    }
    while (i == 0)
    {
      ad.e("MicroMsg.OpenVoice.JsApiOpenVoiceBase", "requestCameraPermission is fail");
      ad.w("MicroMsg.OpenVoice.JsApiOpenVoiceBase", "hy: no record video permission");
      paramc.h(paramInt, e("fail: no record video permission", null));
      return;
      bool = com.tencent.mm.pluginsdk.permission.b.a((Activity)localObject, "android.permission.CAMERA", 122, "", "");
      i = bool;
      if (bool)
      {
        p.TS(paramc.getAppId());
        i = bool;
      }
    }
    localObject = paramc.getRuntime().aXd();
    if ((((u)localObject).getCurrentPage() != null) || (((u)localObject).getCurrentPage().getCurrentPageView() != null)) {
      this.ckN = ((u)localObject).getCurrentPage().getCurrentPageView();
    }
    a(paramc, paramJSONObject, paramInt);
  }
  
  public final void gq(final boolean paramBoolean)
  {
    try
    {
      if (!aq.isMainThread())
      {
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(46692);
            i.this.gq(paramBoolean);
            AppMethodBeat.o(46692);
          }
        });
        return;
      }
      if ((this.ckN != null) && (this.ckN.getRuntime() != null))
      {
        if (kwN != null)
        {
          kwN.dismiss();
          kwN = null;
        }
        if (paramBoolean)
        {
          kwN = com.tencent.mm.plugin.appbrand.page.b.ac(this.ckN.getRuntime()).a(b.a.lYL);
          return;
        }
      }
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.OpenVoice.JsApiOpenVoiceBase", "setSubTitle error:" + localException.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.openvoice.i
 * JD-Core Version:    0.7.0.1
 */