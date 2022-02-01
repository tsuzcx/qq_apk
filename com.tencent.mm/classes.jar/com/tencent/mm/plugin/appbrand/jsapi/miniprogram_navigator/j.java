package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.e.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.af.k;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.plugin.appbrand.widget.dialog.n.a;
import com.tencent.mm.plugin.appbrand.y;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vending.g.b;
import com.tencent.mm.vending.g.d.a;
import org.json.JSONObject;

public class j
  implements c
{
  static final j sil;
  
  static
  {
    AppMethodBeat.i(147197);
    sil = new j();
    AppMethodBeat.o(147197);
  }
  
  public com.tencent.mm.vending.g.c<AppBrandInitConfigLU> a(com.tencent.mm.plugin.appbrand.g paramg, LaunchParcel paramLaunchParcel, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(147195);
    paramg = com.tencent.mm.vending.g.g.gR(null);
    AppMethodBeat.o(147195);
    return paramg;
  }
  
  public final void a(final com.tencent.mm.plugin.appbrand.g paramg, final String paramString1, int paramInt, final String paramString2, final c.a parama, final JSONObject paramJSONObject, HalfScreenConfig paramHalfScreenConfig, final c.c paramc)
  {
    AppMethodBeat.i(326222);
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
        break label724;
      }
      localObject1 = (ad)paramg;
      label122:
      if (localObject1 == null) {
        break label810;
      }
    }
    label393:
    label409:
    label797:
    label803:
    label810:
    for (localObject1 = ((ad)localObject1).cEE();; localObject1 = "")
    {
      final d locald = (d)paramg.getRuntime();
      String str1 = paramg.getAppId() + ":" + locald.asA().eoP + ":" + (locald.asA().appServiceType + 1000);
      Object localObject2 = locald.asA().epn;
      AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
      if ((parama != null) && (parama.scene != 0))
      {
        i = parama.scene;
        label237:
        localAppBrandStatObject.scene = i;
        localAppBrandStatObject.icW = ((AppBrandStatObject)localObject2).icW;
        if ((parama == null) || (parama.scene == 0) || (Util.isNullOrNil(parama.hzx))) {
          break label744;
        }
        str1 = String.format("%s:%s", new Object[] { str1, parama.hzx });
        label302:
        localAppBrandStatObject.hzx = str1;
        if (parama == null) {
          break label747;
        }
        i = parama.icZ;
        label321:
        localAppBrandStatObject.icZ = i;
        if (parama == null) {
          break label753;
        }
        str1 = parama.ida;
        label340:
        localAppBrandStatObject.ida = str1;
        if (parama == null) {
          break label759;
        }
        str1 = parama.shW;
        label359:
        localAppBrandStatObject.shW = str1;
        localObject2 = new AppBrandLaunchReferrer();
        ((AppBrandLaunchReferrer)localObject2).appId = paramg.getAppId();
        if (localJSONObject2 != null) {
          break label765;
        }
        str1 = "{}";
        ((AppBrandLaunchReferrer)localObject2).hRR = str1;
        if (localJSONObject1 != null) {
          break label775;
        }
        str1 = "{}";
        ((AppBrandLaunchReferrer)localObject2).qYF = str1;
        ((AppBrandLaunchReferrer)localObject2).qYE = 1;
        ((AppBrandLaunchReferrer)localObject2).url = ((String)localObject1);
        if (parama == null) {
          break label785;
        }
        i = parama.sourceType;
        label441:
        ((AppBrandLaunchReferrer)localObject2).sourceType = i;
        if (parama == null) {
          break label791;
        }
        localObject1 = parama.qYG;
        label460:
        ((AppBrandLaunchReferrer)localObject2).qYG = ((String)localObject1);
        if (parama == null) {
          break label797;
        }
        parama = parama.businessType;
        label479:
        ((AppBrandLaunchReferrer)localObject2).businessType = parama;
        long l = Util.nowMilliSecond();
        parama = new LaunchParcel();
        parama.username = null;
        parama.appId = paramString1;
        parama.version = 0;
        parama.euz = paramInt;
        parama.qAF = paramString2;
        parama.siB = localAppBrandStatObject;
        parama.eoV = ((AppBrandLaunchReferrer)localObject2);
        parama.tdW = null;
        parama.tdX = l;
        if (paramHalfScreenConfig != null) {
          break label803;
        }
      }
      for (paramString2 = HalfScreenConfig.rad;; paramString2 = paramHalfScreenConfig)
      {
        parama.qAT = paramString2;
        parama.epk = locald.asA().epk;
        parama.epi = locald.asA().epi;
        parama.launchMode = b(paramHalfScreenConfig);
        paramString2 = new k();
        com.tencent.mm.vending.g.g.jJU().b(locald).f(new com.tencent.mm.vending.c.a() {}).f(new com.tencent.mm.vending.c.a() {}).f(new com.tencent.mm.vending.c.a() {}).a(new d.a()
        {
          public final void onInterrupt(Object paramAnonymousObject)
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
                paramc.onNavigateResult(bool, paramAnonymousObject);
                locald.i(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(147185);
                    if (j.1.this.sio.value != null) {
                      ((com.tencent.mm.plugin.appbrand.q.c)j.1.this.sio.value).dismiss();
                    }
                    AppMethodBeat.o(147185);
                  }
                }, 0L);
                AppMethodBeat.o(147186);
                return;
                label62:
                if (c.b.a.shY != paramAnonymousObject) {
                  break;
                }
                paramAnonymousObject = "ok";
              }
              if (c.b.a.shZ == paramAnonymousObject) {
                paramAnonymousObject = "cancel";
              } else if (paramAnonymousObject == null) {
                paramAnonymousObject = "internal error";
              } else {
                paramAnonymousObject = paramAnonymousObject.toString();
              }
            }
          }
        });
        AppMethodBeat.o(326222);
        return;
        i = 0;
        break;
        label724:
        localObject1 = ((y)paramg).getCurrentPageView();
        break label122;
        i = 1037;
        break label237;
        label744:
        break label302;
        label747:
        i = 0;
        break label321;
        label753:
        str1 = null;
        break label340;
        label759:
        str1 = null;
        break label359;
        label765:
        str1 = localJSONObject2.toString();
        break label393;
        str1 = localJSONObject1.toString();
        break label409;
        i = 0;
        break label441;
        localObject1 = null;
        break label460;
        parama = null;
        break label479;
      }
    }
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.g paramg, String paramString1, int paramInt, String paramString2, c.a parama, JSONObject paramJSONObject, c.c paramc)
  {
    AppMethodBeat.i(147196);
    a(paramg, paramString1, paramInt, paramString2, parama, paramJSONObject, null, paramc);
    AppMethodBeat.o(147196);
  }
  
  public boolean a(com.tencent.mm.plugin.appbrand.g paramg, LaunchParcel paramLaunchParcel, c.b paramb)
  {
    return false;
  }
  
  protected int b(HalfScreenConfig paramHalfScreenConfig)
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.j
 * JD-Core Version:    0.7.0.1
 */