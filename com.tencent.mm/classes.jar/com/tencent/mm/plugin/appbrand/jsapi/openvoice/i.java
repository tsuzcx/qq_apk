package com.tencent.mm.plugin.appbrand.jsapi.openvoice;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.page.capsulebar.a;
import com.tencent.mm.plugin.appbrand.page.capsulebar.a.b;
import com.tencent.mm.plugin.appbrand.page.capsulebar.i.a;
import com.tencent.mm.plugin.appbrand.page.t;
import com.tencent.mm.plugin.appbrand.page.w;
import com.tencent.mm.plugin.appbrand.permission.r;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import org.json.JSONObject;

public abstract class i
  extends d<c>
{
  private static i.a lEv;
  private ac cwK = null;
  
  abstract void a(c paramc, JSONObject paramJSONObject, int paramInt);
  
  public final void b(final c paramc, final JSONObject paramJSONObject, final int paramInt)
  {
    if (paramc.ay(Activity.class) == null)
    {
      Log.e("MicroMsg.OpenVoice.JsApiOpenVoiceBase", "hy: no page context");
      return;
    }
    r.b(paramc.getAppId(), new android.support.v4.app.a.a()
    {
      public final void onRequestPermissionsResult(int paramAnonymousInt, String[] paramAnonymousArrayOfString, int[] paramAnonymousArrayOfInt)
      {
        AppMethodBeat.i(226938);
        if (paramAnonymousInt != 121)
        {
          Log.e("MicroMsg.OpenVoice.JsApiOpenVoiceBase", "requestAudioPermission requestCode is not for open voice api");
          AppMethodBeat.o(226938);
          return;
        }
        if ((paramAnonymousArrayOfInt != null) && (paramAnonymousArrayOfInt.length > 0) && (paramAnonymousArrayOfInt[0] == 0))
        {
          Log.i("MicroMsg.OpenVoice.JsApiOpenVoiceBase", "requestAudioPermission permission is grant for open voice api");
          i.this.b(paramc, paramJSONObject, paramInt);
          AppMethodBeat.o(226938);
          return;
        }
        Log.e("MicroMsg.OpenVoice.JsApiOpenVoiceBase", "requestAudioPermission sys perm denied for open voice api");
        paramc.i(paramInt, i.this.h("fail:system permission denied", null));
        AppMethodBeat.o(226938);
      }
    });
    Object localObject = paramc.getContext();
    int i;
    if ((localObject == null) || (!(localObject instanceof Activity)))
    {
      Log.e("MicroMsg.OpenVoice.JsApiOpenVoiceBase", "fail, requestAudioPermission pageContext is null");
      paramc.i(paramInt, h("fail: context is null", null));
      i = 0;
    }
    boolean bool;
    while (i == 0)
    {
      Log.e("MicroMsg.OpenVoice.JsApiOpenVoiceBase", "requestAudioPermission is fail");
      Log.w("MicroMsg.OpenVoice.JsApiOpenVoiceBase", "hy: no record audio permission");
      paramc.i(paramInt, h("fail: no record audio permission", null));
      return;
      bool = b.a((Activity)localObject, "android.permission.RECORD_AUDIO", 121, "", "");
      i = bool;
      if (bool)
      {
        r.aeq(paramc.getAppId());
        i = bool;
      }
    }
    r.b(paramc.getAppId(), new android.support.v4.app.a.a()
    {
      public final void onRequestPermissionsResult(int paramAnonymousInt, String[] paramAnonymousArrayOfString, int[] paramAnonymousArrayOfInt)
      {
        AppMethodBeat.i(226939);
        if (paramAnonymousInt != 122)
        {
          Log.e("MicroMsg.OpenVoice.JsApiOpenVoiceBase", "requestCameraPermission requestCode is not for open voice api");
          AppMethodBeat.o(226939);
          return;
        }
        if ((paramAnonymousArrayOfInt != null) && (paramAnonymousArrayOfInt.length > 0) && (paramAnonymousArrayOfInt[0] == 0))
        {
          Log.i("MicroMsg.OpenVoice.JsApiOpenVoiceBase", "requestCameraPermission permission is grant for open voice api");
          i.this.b(paramc, paramJSONObject, paramInt);
          AppMethodBeat.o(226939);
          return;
        }
        Log.e("MicroMsg.OpenVoice.JsApiOpenVoiceBase", "requestCameraPermission sys perm denied for open voice api");
        paramc.i(paramInt, i.this.h("fail:system permission denied", null));
        AppMethodBeat.o(226939);
      }
    });
    localObject = paramc.getContext();
    if ((localObject == null) || (!(localObject instanceof Activity)))
    {
      Log.e("MicroMsg.OpenVoice.JsApiOpenVoiceBase", "fail, requestCameraPermission pageContext is null");
      paramc.i(paramInt, h("fail: context is null", null));
      i = 0;
    }
    while (i == 0)
    {
      Log.e("MicroMsg.OpenVoice.JsApiOpenVoiceBase", "requestCameraPermission is fail");
      Log.w("MicroMsg.OpenVoice.JsApiOpenVoiceBase", "hy: no record video permission");
      paramc.i(paramInt, h("fail: no record video permission", null));
      return;
      bool = b.a((Activity)localObject, "android.permission.CAMERA", 122, "", "");
      i = bool;
      if (bool)
      {
        r.aeq(paramc.getAppId());
        i = bool;
      }
    }
    localObject = paramc.getRuntime().bsD();
    if ((((w)localObject).getCurrentPage() != null) || (((w)localObject).getCurrentPage().getCurrentPageView() != null)) {
      this.cwK = ((w)localObject).getCurrentPage().getCurrentPageView();
    }
    a(paramc, paramJSONObject, paramInt);
  }
  
  public final void hl(final boolean paramBoolean)
  {
    try
    {
      if (!MMHandlerThread.isMainThread())
      {
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(46692);
            i.this.hl(paramBoolean);
            AppMethodBeat.o(46692);
          }
        });
        return;
      }
      if ((this.cwK != null) && (this.cwK.getRuntime() != null))
      {
        if (lEv != null)
        {
          lEv.dismiss();
          lEv = null;
        }
        if (paramBoolean)
        {
          lEv = com.tencent.mm.plugin.appbrand.page.capsulebar.a.a.ah(this.cwK.getRuntime()).a(a.b.nuR);
          return;
        }
      }
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.OpenVoice.JsApiOpenVoiceBase", "setSubTitle error:" + localException.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.openvoice.i
 * JD-Core Version:    0.7.0.1
 */