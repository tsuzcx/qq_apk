package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.e.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ac.i;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.plugin.appbrand.v;
import com.tencent.mm.plugin.appbrand.widget.dialog.j.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vending.g.b;
import com.tencent.mm.vending.g.d.a;
import org.json.JSONObject;

public class j
  implements c
{
  static final j pcV;
  
  static
  {
    AppMethodBeat.i(147197);
    pcV = new j();
    AppMethodBeat.o(147197);
  }
  
  public com.tencent.mm.vending.g.c<AppBrandInitConfigLU> a(com.tencent.mm.plugin.appbrand.g paramg, LaunchParcel paramLaunchParcel, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(147195);
    paramg = com.tencent.mm.vending.g.g.et(null);
    AppMethodBeat.o(147195);
    return paramg;
  }
  
  public final void a(final com.tencent.mm.plugin.appbrand.g paramg, final String paramString1, int paramInt, final String paramString2, final c.a parama, final JSONObject paramJSONObject, final c.c paramc)
  {
    AppMethodBeat.i(147196);
    com.tencent.mm.plugin.appbrand.keylogger.c.d(KSProcessWeAppLaunch.class, paramString1);
    com.tencent.mm.plugin.appbrand.keylogger.c.a(KSProcessWeAppLaunch.class, paramString1, String.format("Network:%s", new Object[] { NetStatusUtil.getNetTypeString(paramg.getRuntime().mContext) }));
    Object localObject1 = paramg.getAppId();
    int i;
    final String str2;
    JSONObject localJSONObject2;
    JSONObject localJSONObject1;
    if (parama != null)
    {
      i = parama.sourceType;
      Log.i("MicroMsg.MiniProgramNavigator", "navigateTo fromAppID(%s) targetAppID(%s) sourceType:%d", new Object[] { localObject1, paramString1, Integer.valueOf(i) });
      str2 = paramg.getAppId();
      localJSONObject2 = paramJSONObject.optJSONObject("extraData");
      localJSONObject1 = paramJSONObject.optJSONObject("privateExtraData");
      if (!(paramg instanceof ad)) {
        break label670;
      }
      localObject1 = (ad)paramg;
      label122:
      if (localObject1 == null) {
        break label749;
      }
    }
    label302:
    label321:
    label340:
    label359:
    label749:
    for (localObject1 = ((ad)localObject1).qoI;; localObject1 = "")
    {
      final d locald = (d)paramg.getRuntime();
      String str1 = paramg.getAppId() + ":" + locald.Sk().cwP + ":" + (locald.Sk().cwR + 1000);
      Object localObject2 = locald.Sk().cxf;
      AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
      if ((parama != null) && (parama.scene != 0))
      {
        i = parama.scene;
        label237:
        localAppBrandStatObject.scene = i;
        localAppBrandStatObject.fWX = ((AppBrandStatObject)localObject2).fWX;
        if ((parama == null) || (parama.scene == 0) || (Util.isNullOrNil(parama.fvd))) {
          break label690;
        }
        str1 = String.format("%s:%s", new Object[] { str1, parama.fvd });
        localAppBrandStatObject.fvd = str1;
        if (parama == null) {
          break label693;
        }
        i = parama.fXa;
        localAppBrandStatObject.fXa = i;
        if (parama == null) {
          break label699;
        }
        str1 = parama.fXb;
        localAppBrandStatObject.fXb = str1;
        if (parama == null) {
          break label705;
        }
        str1 = parama.pcH;
        localAppBrandStatObject.pcH = str1;
        localObject2 = new AppBrandLaunchReferrer();
        ((AppBrandLaunchReferrer)localObject2).appId = paramg.getAppId();
        if (localJSONObject2 != null) {
          break label711;
        }
        str1 = "{}";
        ((AppBrandLaunchReferrer)localObject2).fMh = str1;
        if (localJSONObject1 != null) {
          break label721;
        }
        str1 = "{}";
        ((AppBrandLaunchReferrer)localObject2).nYC = str1;
        ((AppBrandLaunchReferrer)localObject2).nYB = 1;
        ((AppBrandLaunchReferrer)localObject2).url = ((String)localObject1);
        if (parama == null) {
          break label731;
        }
        i = parama.sourceType;
        ((AppBrandLaunchReferrer)localObject2).sourceType = i;
        if (parama == null) {
          break label737;
        }
        localObject1 = parama.nYD;
        ((AppBrandLaunchReferrer)localObject2).nYD = ((String)localObject1);
        if (parama == null) {
          break label743;
        }
      }
      for (parama = parama.businessType;; parama = null)
      {
        ((AppBrandLaunchReferrer)localObject2).businessType = parama;
        long l = Util.nowMilliSecond();
        parama = new LaunchParcel();
        parama.username = null;
        parama.appId = paramString1;
        parama.version = 0;
        parama.cBU = paramInt;
        parama.nBq = paramString2;
        parama.pdk = localAppBrandStatObject;
        parama.cwV = ((AppBrandLaunchReferrer)localObject2);
        parama.pZj = null;
        parama.pZk = l;
        paramString2 = new i();
        com.tencent.mm.vending.g.g.ieN().b(locald).f(new com.tencent.mm.vending.c.a() {}).f(new com.tencent.mm.vending.c.a() {}).f(new com.tencent.mm.vending.c.a() {}).a(new d.a()
        {
          public final void cm(Object paramAnonymousObject)
          {
            AppMethodBeat.i(147186);
            if (paramc != null)
            {
              if (!(paramAnonymousObject instanceof Exception)) {
                break label62;
              }
              paramAnonymousObject = ((Exception)paramAnonymousObject).getMessage();
            }
            for (;;)
            {
              for (boolean bool = false;; bool = true)
              {
                paramc.s(bool, paramAnonymousObject);
                locald.h(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(147185);
                    if (j.1.this.pcY.value != null) {
                      ((com.tencent.mm.plugin.appbrand.p.c)j.1.this.pcY.value).dismiss();
                    }
                    AppMethodBeat.o(147185);
                  }
                }, 0L);
                AppMethodBeat.o(147186);
                return;
                label62:
                if (c.b.a.pcJ != paramAnonymousObject) {
                  break;
                }
                paramAnonymousObject = "ok";
              }
              if (c.b.a.pcK == paramAnonymousObject) {
                paramAnonymousObject = "cancel";
              } else if (paramAnonymousObject == null) {
                paramAnonymousObject = "internal error";
              } else {
                paramAnonymousObject = paramAnonymousObject.toString();
              }
            }
          }
        });
        AppMethodBeat.o(147196);
        return;
        i = 0;
        break;
        localObject1 = ((v)paramg).getCurrentPageView();
        break label122;
        i = 1037;
        break label237;
        break label302;
        i = 0;
        break label321;
        str1 = null;
        break label340;
        str1 = null;
        break label359;
        str1 = localJSONObject2.toString();
        break label393;
        str1 = localJSONObject1.toString();
        break label409;
        i = 0;
        break label441;
        localObject1 = null;
        break label460;
      }
    }
  }
  
  public boolean a(com.tencent.mm.plugin.appbrand.g paramg, LaunchParcel paramLaunchParcel, c.b paramb)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.j
 * JD-Core Version:    0.7.0.1
 */