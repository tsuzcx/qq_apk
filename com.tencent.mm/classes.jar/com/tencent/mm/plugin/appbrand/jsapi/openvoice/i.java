package com.tencent.mm.plugin.appbrand.jsapi.openvoice;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.plugin.appbrand.page.capsulebar.a.b;
import com.tencent.mm.plugin.appbrand.page.capsulebar.i.a;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.plugin.appbrand.page.t;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import org.json.JSONObject;

public abstract class i
  extends com.tencent.mm.plugin.appbrand.jsapi.a<c>
{
  private static i.a kAc;
  private z ckP = null;
  
  abstract void a(c paramc, JSONObject paramJSONObject, int paramInt);
  
  public final void b(final c paramc, final JSONObject paramJSONObject, final int paramInt)
  {
    if (paramc.au(Activity.class) == null)
    {
      ae.e("MicroMsg.OpenVoice.JsApiOpenVoiceBase", "hy: no page context");
      return;
    }
    com.tencent.mm.plugin.appbrand.permission.r.b(paramc.getAppId(), new android.support.v4.app.a.a()
    {
      public final void onRequestPermissionsResult(int paramAnonymousInt, String[] paramAnonymousArrayOfString, int[] paramAnonymousArrayOfInt)
      {
        AppMethodBeat.i(222629);
        if (paramAnonymousInt != 121)
        {
          ae.e("MicroMsg.OpenVoice.JsApiOpenVoiceBase", "requestAudioPermission requestCode is not for open voice api");
          AppMethodBeat.o(222629);
          return;
        }
        if ((paramAnonymousArrayOfInt != null) && (paramAnonymousArrayOfInt.length > 0) && (paramAnonymousArrayOfInt[0] == 0))
        {
          ae.i("MicroMsg.OpenVoice.JsApiOpenVoiceBase", "requestAudioPermission permission is grant for open voice api");
          i.this.b(paramc, paramJSONObject, paramInt);
          AppMethodBeat.o(222629);
          return;
        }
        ae.e("MicroMsg.OpenVoice.JsApiOpenVoiceBase", "requestAudioPermission sys perm denied for open voice api");
        paramc.h(paramInt, i.this.e("fail:system permission denied", null));
        AppMethodBeat.o(222629);
      }
    });
    Object localObject = paramc.getContext();
    int i;
    if ((localObject == null) || (!(localObject instanceof Activity)))
    {
      ae.e("MicroMsg.OpenVoice.JsApiOpenVoiceBase", "fail, requestAudioPermission pageContext is null");
      paramc.h(paramInt, e("fail: context is null", null));
      i = 0;
    }
    boolean bool;
    while (i == 0)
    {
      ae.e("MicroMsg.OpenVoice.JsApiOpenVoiceBase", "requestAudioPermission is fail");
      ae.w("MicroMsg.OpenVoice.JsApiOpenVoiceBase", "hy: no record audio permission");
      paramc.h(paramInt, e("fail: no record audio permission", null));
      return;
      bool = b.a((Activity)localObject, "android.permission.RECORD_AUDIO", 121, "", "");
      i = bool;
      if (bool)
      {
        com.tencent.mm.plugin.appbrand.permission.r.UC(paramc.getAppId());
        i = bool;
      }
    }
    com.tencent.mm.plugin.appbrand.permission.r.b(paramc.getAppId(), new android.support.v4.app.a.a()
    {
      public final void onRequestPermissionsResult(int paramAnonymousInt, String[] paramAnonymousArrayOfString, int[] paramAnonymousArrayOfInt)
      {
        AppMethodBeat.i(222630);
        if (paramAnonymousInt != 122)
        {
          ae.e("MicroMsg.OpenVoice.JsApiOpenVoiceBase", "requestCameraPermission requestCode is not for open voice api");
          AppMethodBeat.o(222630);
          return;
        }
        if ((paramAnonymousArrayOfInt != null) && (paramAnonymousArrayOfInt.length > 0) && (paramAnonymousArrayOfInt[0] == 0))
        {
          ae.i("MicroMsg.OpenVoice.JsApiOpenVoiceBase", "requestCameraPermission permission is grant for open voice api");
          i.this.b(paramc, paramJSONObject, paramInt);
          AppMethodBeat.o(222630);
          return;
        }
        ae.e("MicroMsg.OpenVoice.JsApiOpenVoiceBase", "requestCameraPermission sys perm denied for open voice api");
        paramc.h(paramInt, i.this.e("fail:system permission denied", null));
        AppMethodBeat.o(222630);
      }
    });
    localObject = paramc.getContext();
    if ((localObject == null) || (!(localObject instanceof Activity)))
    {
      ae.e("MicroMsg.OpenVoice.JsApiOpenVoiceBase", "fail, requestCameraPermission pageContext is null");
      paramc.h(paramInt, e("fail: context is null", null));
      i = 0;
    }
    while (i == 0)
    {
      ae.e("MicroMsg.OpenVoice.JsApiOpenVoiceBase", "requestCameraPermission is fail");
      ae.w("MicroMsg.OpenVoice.JsApiOpenVoiceBase", "hy: no record video permission");
      paramc.h(paramInt, e("fail: no record video permission", null));
      return;
      bool = b.a((Activity)localObject, "android.permission.CAMERA", 122, "", "");
      i = bool;
      if (bool)
      {
        com.tencent.mm.plugin.appbrand.permission.r.UC(paramc.getAppId());
        i = bool;
      }
    }
    localObject = paramc.getRuntime().aXy();
    if ((((t)localObject).getCurrentPage() != null) || (((t)localObject).getCurrentPage().getCurrentPageView() != null)) {
      this.ckP = ((t)localObject).getCurrentPage().getCurrentPageView();
    }
    a(paramc, paramJSONObject, paramInt);
  }
  
  public final void go(final boolean paramBoolean)
  {
    try
    {
      if (!ar.isMainThread())
      {
        ar.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(46692);
            i.this.go(paramBoolean);
            AppMethodBeat.o(46692);
          }
        });
        return;
      }
      if ((this.ckP != null) && (this.ckP.getRuntime() != null))
      {
        if (kAc != null)
        {
          kAc.dismiss();
          kAc = null;
        }
        if (paramBoolean)
        {
          kAc = com.tencent.mm.plugin.appbrand.page.capsulebar.a.a.ag(this.ckP.getRuntime()).a(a.b.mku);
          return;
        }
      }
    }
    catch (Exception localException)
    {
      ae.e("MicroMsg.OpenVoice.JsApiOpenVoiceBase", "setSubTitle error:" + localException.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.openvoice.i
 * JD-Core Version:    0.7.0.1
 */