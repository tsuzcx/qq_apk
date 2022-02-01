package com.tencent.mm.plugin.appbrand.jsapi.openvoice;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.capsulebar.a;
import com.tencent.mm.plugin.appbrand.page.capsulebar.a.b;
import com.tencent.mm.plugin.appbrand.page.capsulebar.i.a;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.page.x;
import com.tencent.mm.plugin.appbrand.permission.r;
import com.tencent.mm.plugin.appbrand.t;
import com.tencent.mm.plugin.appbrand.v;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.Map;
import org.json.JSONObject;

public abstract class i
  extends com.tencent.mm.plugin.appbrand.jsapi.c<com.tencent.mm.plugin.appbrand.service.c>
{
  private static i.a ozW;
  private ad cvo = null;
  
  protected static void b(Map<String, Object> paramMap, int paramInt)
  {
    paramMap.put("errCode", Integer.valueOf(paramInt));
  }
  
  protected static int eC(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      return 0;
    }
    if ((paramInt1 != -10086) && (paramInt1 != -10087)) {
      return -1000;
    }
    switch (paramInt2)
    {
    case 0: 
    default: 
      return -1000;
    case -9: 
      return -3;
    case -1: 
      return -1;
    }
    return -2;
  }
  
  abstract void a(com.tencent.mm.plugin.appbrand.service.c paramc, JSONObject paramJSONObject, int paramInt);
  
  public final void b(final com.tencent.mm.plugin.appbrand.service.c paramc, final JSONObject paramJSONObject, final int paramInt)
  {
    if (paramc.ax(Activity.class) == null)
    {
      Log.e("MicroMsg.OpenVoice.JsApiOpenVoiceBase", "hy: no page context");
      return;
    }
    r.b(paramc.getAppId(), new androidx.core.app.a.a()
    {
      public final void onRequestPermissionsResult(int paramAnonymousInt, String[] paramAnonymousArrayOfString, int[] paramAnonymousArrayOfInt)
      {
        AppMethodBeat.i(281372);
        if (paramAnonymousInt != 121)
        {
          Log.e("MicroMsg.OpenVoice.JsApiOpenVoiceBase", "requestAudioPermission requestCode is not for open voice api");
          AppMethodBeat.o(281372);
          return;
        }
        if ((paramAnonymousArrayOfInt != null) && (paramAnonymousArrayOfInt.length > 0) && (paramAnonymousArrayOfInt[0] == 0))
        {
          Log.i("MicroMsg.OpenVoice.JsApiOpenVoiceBase", "requestAudioPermission permission is grant for open voice api");
          i.this.b(paramc, paramJSONObject, paramInt);
          AppMethodBeat.o(281372);
          return;
        }
        Log.e("MicroMsg.OpenVoice.JsApiOpenVoiceBase", "requestAudioPermission sys perm denied for open voice api");
        paramc.j(paramInt, i.this.h("fail:system permission denied", null));
        AppMethodBeat.o(281372);
      }
    });
    Object localObject = paramc.getContext();
    int i;
    if ((localObject == null) || (!(localObject instanceof Activity)))
    {
      Log.e("MicroMsg.OpenVoice.JsApiOpenVoiceBase", "fail, requestAudioPermission pageContext is null");
      paramc.j(paramInt, h("fail: context is null", null));
      i = 0;
    }
    boolean bool;
    while (i == 0)
    {
      Log.e("MicroMsg.OpenVoice.JsApiOpenVoiceBase", "requestAudioPermission is fail");
      Log.w("MicroMsg.OpenVoice.JsApiOpenVoiceBase", "hy: no record audio permission");
      paramc.j(paramInt, h("fail: no record audio permission", null));
      return;
      bool = b.a((Activity)localObject, "android.permission.RECORD_AUDIO", 121, "", "");
      i = bool;
      if (bool)
      {
        r.amk(paramc.getAppId());
        i = bool;
      }
    }
    r.b(paramc.getAppId(), new androidx.core.app.a.a()
    {
      public final void onRequestPermissionsResult(int paramAnonymousInt, String[] paramAnonymousArrayOfString, int[] paramAnonymousArrayOfInt)
      {
        AppMethodBeat.i(272387);
        if (paramAnonymousInt != 122)
        {
          Log.e("MicroMsg.OpenVoice.JsApiOpenVoiceBase", "requestCameraPermission requestCode is not for open voice api");
          AppMethodBeat.o(272387);
          return;
        }
        if ((paramAnonymousArrayOfInt != null) && (paramAnonymousArrayOfInt.length > 0) && (paramAnonymousArrayOfInt[0] == 0))
        {
          Log.i("MicroMsg.OpenVoice.JsApiOpenVoiceBase", "requestCameraPermission permission is grant for open voice api");
          i.this.b(paramc, paramJSONObject, paramInt);
          AppMethodBeat.o(272387);
          return;
        }
        Log.e("MicroMsg.OpenVoice.JsApiOpenVoiceBase", "requestCameraPermission sys perm denied for open voice api");
        paramc.j(paramInt, i.this.h("fail:system permission denied", null));
        AppMethodBeat.o(272387);
      }
    });
    localObject = paramc.getContext();
    if ((localObject == null) || (!(localObject instanceof Activity)))
    {
      Log.e("MicroMsg.OpenVoice.JsApiOpenVoiceBase", "fail, requestCameraPermission pageContext is null");
      paramc.j(paramInt, h("fail: context is null", null));
      i = 0;
    }
    while (i == 0)
    {
      Log.e("MicroMsg.OpenVoice.JsApiOpenVoiceBase", "requestCameraPermission is fail");
      Log.w("MicroMsg.OpenVoice.JsApiOpenVoiceBase", "hy: no record video permission");
      paramc.j(paramInt, h("fail: no record video permission", null));
      return;
      bool = b.a((Activity)localObject, "android.permission.CAMERA", 122, "", "");
      i = bool;
      if (bool)
      {
        r.amk(paramc.getAppId());
        i = bool;
      }
    }
    localObject = paramc.getRuntime().bDz();
    if ((((x)localObject).getCurrentPage() != null) || (((x)localObject).getCurrentPage().getCurrentPageView() != null)) {
      this.cvo = ((x)localObject).getCurrentPage().getCurrentPageView();
    }
    a(paramc, paramJSONObject, paramInt);
  }
  
  public final void ib(final boolean paramBoolean)
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
            i.this.ib(paramBoolean);
            AppMethodBeat.o(46692);
          }
        });
        return;
      }
      if ((this.cvo != null) && (this.cvo.getRuntime() != null))
      {
        if (ozW != null)
        {
          ozW.dismiss();
          ozW = null;
        }
        if (paramBoolean)
        {
          ozW = com.tencent.mm.plugin.appbrand.page.capsulebar.a.a.ah(this.cvo.getRuntime()).a(a.b.qwM);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.openvoice.i
 * JD-Core Version:    0.7.0.1
 */