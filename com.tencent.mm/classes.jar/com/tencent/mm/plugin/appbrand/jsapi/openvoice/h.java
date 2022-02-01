package com.tencent.mm.plugin.appbrand.jsapi.openvoice;

import android.app.Activity;
import android.support.v4.app.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.page.a.c.a;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.page.b.a;
import com.tencent.mm.plugin.appbrand.page.r;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import org.json.JSONObject;

public abstract class h
  extends a<c>
{
  private static c.a kco;
  private aa caw = null;
  
  abstract void a(c paramc, JSONObject paramJSONObject, int paramInt);
  
  public final void b(final c paramc, final JSONObject paramJSONObject, final int paramInt)
  {
    if (paramc.au(Activity.class) == null)
    {
      ac.e("MicroMsg.OpenVoice.JsApiOpenVoiceBase", "hy: no page context");
      return;
    }
    com.tencent.mm.plugin.appbrand.permission.o.b(paramc.getAppId(), new a.a()
    {
      public final void onRequestPermissionsResult(int paramAnonymousInt, String[] paramAnonymousArrayOfString, int[] paramAnonymousArrayOfInt)
      {
        AppMethodBeat.i(186733);
        if (paramAnonymousInt != 121)
        {
          ac.e("MicroMsg.OpenVoice.JsApiOpenVoiceBase", "requestAudioPermission requestCode is not for open voice api");
          AppMethodBeat.o(186733);
          return;
        }
        if ((paramAnonymousArrayOfInt != null) && (paramAnonymousArrayOfInt.length > 0) && (paramAnonymousArrayOfInt[0] == 0))
        {
          ac.i("MicroMsg.OpenVoice.JsApiOpenVoiceBase", "requestAudioPermission permission is grant for open voice api");
          h.this.b(paramc, paramJSONObject, paramInt);
          AppMethodBeat.o(186733);
          return;
        }
        ac.e("MicroMsg.OpenVoice.JsApiOpenVoiceBase", "requestAudioPermission sys perm denied for open voice api");
        paramc.h(paramInt, h.this.e("fail:system permission denied", null));
        AppMethodBeat.o(186733);
      }
    });
    Object localObject = paramc.getContext();
    int i;
    if ((localObject == null) || (!(localObject instanceof Activity)))
    {
      ac.e("MicroMsg.OpenVoice.JsApiOpenVoiceBase", "fail, requestAudioPermission pageContext is null");
      paramc.h(paramInt, e("fail: context is null", null));
      i = 0;
    }
    boolean bool;
    while (i == 0)
    {
      ac.e("MicroMsg.OpenVoice.JsApiOpenVoiceBase", "requestAudioPermission is fail");
      ac.w("MicroMsg.OpenVoice.JsApiOpenVoiceBase", "hy: no record audio permission");
      paramc.h(paramInt, e("fail: no record audio permission", null));
      return;
      bool = com.tencent.mm.pluginsdk.permission.b.a((Activity)localObject, "android.permission.RECORD_AUDIO", 121, "", "");
      i = bool;
      if (bool)
      {
        com.tencent.mm.plugin.appbrand.permission.o.Qo(paramc.getAppId());
        i = bool;
      }
    }
    com.tencent.mm.plugin.appbrand.permission.o.b(paramc.getAppId(), new a.a()
    {
      public final void onRequestPermissionsResult(int paramAnonymousInt, String[] paramAnonymousArrayOfString, int[] paramAnonymousArrayOfInt)
      {
        AppMethodBeat.i(186734);
        if (paramAnonymousInt != 122)
        {
          ac.e("MicroMsg.OpenVoice.JsApiOpenVoiceBase", "requestCameraPermission requestCode is not for open voice api");
          AppMethodBeat.o(186734);
          return;
        }
        if ((paramAnonymousArrayOfInt != null) && (paramAnonymousArrayOfInt.length > 0) && (paramAnonymousArrayOfInt[0] == 0))
        {
          ac.i("MicroMsg.OpenVoice.JsApiOpenVoiceBase", "requestCameraPermission permission is grant for open voice api");
          h.this.b(paramc, paramJSONObject, paramInt);
          AppMethodBeat.o(186734);
          return;
        }
        ac.e("MicroMsg.OpenVoice.JsApiOpenVoiceBase", "requestCameraPermission sys perm denied for open voice api");
        paramc.h(paramInt, h.this.e("fail:system permission denied", null));
        AppMethodBeat.o(186734);
      }
    });
    localObject = paramc.getContext();
    if ((localObject == null) || (!(localObject instanceof Activity)))
    {
      ac.e("MicroMsg.OpenVoice.JsApiOpenVoiceBase", "fail, requestCameraPermission pageContext is null");
      paramc.h(paramInt, e("fail: context is null", null));
      i = 0;
    }
    while (i == 0)
    {
      ac.e("MicroMsg.OpenVoice.JsApiOpenVoiceBase", "requestCameraPermission is fail");
      ac.w("MicroMsg.OpenVoice.JsApiOpenVoiceBase", "hy: no record video permission");
      paramc.h(paramInt, e("fail: no record video permission", null));
      return;
      bool = com.tencent.mm.pluginsdk.permission.b.a((Activity)localObject, "android.permission.CAMERA", 122, "", "");
      i = bool;
      if (bool)
      {
        com.tencent.mm.plugin.appbrand.permission.o.Qo(paramc.getAppId());
        i = bool;
      }
    }
    localObject = paramc.getRuntime().aTT();
    if ((((u)localObject).getCurrentPage() != null) || (((u)localObject).getCurrentPage().getCurrentPageView() != null)) {
      this.caw = ((u)localObject).getCurrentPage().getCurrentPageView();
    }
    a(paramc, paramJSONObject, paramInt);
  }
  
  public final void gl(final boolean paramBoolean)
  {
    try
    {
      if (!ap.isMainThread())
      {
        ap.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(46692);
            h.this.gl(paramBoolean);
            AppMethodBeat.o(46692);
          }
        });
        return;
      }
      if ((this.caw != null) && (this.caw.getRuntime() != null))
      {
        if (kco != null)
        {
          kco.dismiss();
          kco = null;
        }
        if (paramBoolean)
        {
          kco = com.tencent.mm.plugin.appbrand.page.b.ai(this.caw.getRuntime()).a(b.a.lzn);
          return;
        }
      }
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.OpenVoice.JsApiOpenVoiceBase", "setSubTitle error:" + localException.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.openvoice.h
 * JD-Core Version:    0.7.0.1
 */