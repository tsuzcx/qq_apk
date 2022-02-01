package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.plugin.appbrand.widget.dialog.k.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vending.g.b;
import com.tencent.mm.vending.g.d.a;
import org.json.JSONObject;

public class i
  implements c
{
  static final i jZg;
  
  static
  {
    AppMethodBeat.i(147197);
    jZg = new i();
    AppMethodBeat.o(147197);
  }
  
  public com.tencent.mm.vending.g.c<AppBrandInitConfigLU> a(com.tencent.mm.plugin.appbrand.d paramd, LaunchParcel paramLaunchParcel, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(147195);
    paramd = com.tencent.mm.vending.g.g.ee(null);
    AppMethodBeat.o(147195);
    return paramd;
  }
  
  public final void a(final com.tencent.mm.plugin.appbrand.d paramd, final String paramString1, int paramInt, String paramString2, final c.a parama, final JSONObject paramJSONObject, final c.c paramc)
  {
    AppMethodBeat.i(147196);
    com.tencent.mm.plugin.appbrand.keylogger.c.a(KSProcessWeAppLaunch.class, paramString1);
    com.tencent.mm.plugin.appbrand.keylogger.c.a(KSProcessWeAppLaunch.class, paramString1, String.format("Network:%s", new Object[] { ay.getNetTypeString(paramd.getRuntime().mContext) }));
    Object localObject1 = paramd.getAppId();
    int i;
    JSONObject localJSONObject2;
    JSONObject localJSONObject1;
    if (parama != null)
    {
      i = parama.sourceType;
      ad.i("MicroMsg.MiniProgramNavigator", "navigateTo fromAppID(%s) targetAppID(%s) sourceType:%d", new Object[] { localObject1, paramString1, Integer.valueOf(i) });
      localJSONObject2 = paramJSONObject.optJSONObject("extraData");
      localJSONObject1 = paramJSONObject.optJSONObject("privateExtraData");
      if (!(paramd instanceof aa)) {
        break label657;
      }
      localObject1 = (aa)paramd;
      label116:
      if (localObject1 == null) {
        break label736;
      }
    }
    label296:
    label315:
    label334:
    label724:
    label730:
    label736:
    for (localObject1 = ((aa)localObject1).kWX;; localObject1 = "")
    {
      final com.tencent.luggage.sdk.d.c localc = (com.tencent.luggage.sdk.d.c)paramd.getRuntime();
      String str = paramd.getAppId() + ":" + localc.DZ().Da() + ":" + (localc.DZ().cfd + 1000);
      Object localObject2 = localc.DZ().cfo;
      AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
      if ((parama != null) && (parama.scene != 0))
      {
        i = parama.scene;
        label231:
        localAppBrandStatObject.scene = i;
        localAppBrandStatObject.dzQ = ((AppBrandStatObject)localObject2).dzQ;
        if ((parama == null) || (parama.scene == 0) || (bt.isNullOrNil(parama.dbt))) {
          break label677;
        }
        str = String.format("%s:%s", new Object[] { str, parama.dbt });
        localAppBrandStatObject.dbt = str;
        if (parama == null) {
          break label680;
        }
        i = parama.dzS;
        localAppBrandStatObject.dzS = i;
        if (parama == null) {
          break label686;
        }
        str = parama.dzT;
        localAppBrandStatObject.dzT = str;
        if (parama == null) {
          break label692;
        }
        str = parama.jYX;
        label353:
        localAppBrandStatObject.jYX = str;
        localObject2 = new AppBrandLaunchReferrer();
        ((AppBrandLaunchReferrer)localObject2).appId = paramd.getAppId();
        if (localJSONObject2 != null) {
          break label698;
        }
        str = "{}";
        ((AppBrandLaunchReferrer)localObject2).dqq = str;
        if (localJSONObject1 != null) {
          break label708;
        }
        str = "{}";
        ((AppBrandLaunchReferrer)localObject2).jdD = str;
        ((AppBrandLaunchReferrer)localObject2).jdC = 1;
        ((AppBrandLaunchReferrer)localObject2).url = ((String)localObject1);
        if (parama == null) {
          break label718;
        }
        i = parama.sourceType;
        ((AppBrandLaunchReferrer)localObject2).sourceType = i;
        if (parama == null) {
          break label724;
        }
        localObject1 = parama.jdE;
        ((AppBrandLaunchReferrer)localObject2).jdE = ((String)localObject1);
        if (parama == null) {
          break label730;
        }
      }
      for (parama = parama.businessType;; parama = null)
      {
        ((AppBrandLaunchReferrer)localObject2).businessType = parama;
        long l = bt.eGO();
        parama = new LaunchParcel();
        parama.username = null;
        parama.appId = paramString1;
        parama.version = 0;
        parama.gXn = paramInt;
        parama.iJb = paramString2;
        parama.kOh = localAppBrandStatObject;
        parama.cfi = ((AppBrandLaunchReferrer)localObject2);
        parama.kOi = null;
        parama.kOj = l;
        paramString1 = new com.tencent.mm.plugin.appbrand.aa.i();
        com.tencent.mm.vending.g.g.fhq().b(localc).f(new com.tencent.mm.vending.c.a() {}).f(new com.tencent.mm.vending.c.a() {}).f(new com.tencent.mm.vending.c.a() {}).a(new d.a()
        {
          public final void ce(Object paramAnonymousObject)
          {
            AppMethodBeat.i(147186);
            if (paramc != null)
            {
              if (!(paramAnonymousObject instanceof Exception)) {
                break label60;
              }
              paramAnonymousObject = ((Exception)paramAnonymousObject).getMessage();
            }
            for (;;)
            {
              paramc.k(false, paramAnonymousObject);
              localc.i(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(147185);
                  if (i.1.this.jZj.value != null) {
                    ((com.tencent.mm.plugin.appbrand.o.d)i.1.this.jZj.value).dismiss();
                  }
                  AppMethodBeat.o(147185);
                }
              }, 0L);
              AppMethodBeat.o(147186);
              return;
              label60:
              if (paramAnonymousObject == null) {
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
        localObject1 = ((q)paramd).getCurrentPageView();
        break label116;
        i = 1037;
        break label231;
        break label296;
        i = 0;
        break label315;
        str = null;
        break label334;
        str = null;
        break label353;
        str = localJSONObject2.toString();
        break label387;
        str = localJSONObject1.toString();
        break label403;
        i = 0;
        break label435;
        localObject1 = null;
        break label454;
      }
    }
  }
  
  public boolean a(com.tencent.mm.plugin.appbrand.d paramd, LaunchParcel paramLaunchParcel, c.b paramb)
  {
    return false;
  }
  
  protected k.a ae(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(147194);
    paramAppBrandRuntime = new com.tencent.mm.plugin.appbrand.widget.dialog.g(com.tencent.mm.sdk.f.a.iV(paramAppBrandRuntime.mContext));
    AppMethodBeat.o(147194);
    return paramAppBrandRuntime;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.i
 * JD-Core Version:    0.7.0.1
 */