package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ac.i;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.plugin.appbrand.widget.dialog.k.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vending.g.b;
import com.tencent.mm.vending.g.d.a;
import com.tencent.mm.vending.g.g;
import org.json.JSONObject;

public class j
  implements c
{
  static final j meZ;
  
  static
  {
    AppMethodBeat.i(147197);
    meZ = new j();
    AppMethodBeat.o(147197);
  }
  
  public com.tencent.mm.vending.g.c<AppBrandInitConfigLU> a(com.tencent.mm.plugin.appbrand.d paramd, LaunchParcel paramLaunchParcel, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(147195);
    paramd = g.en(null);
    AppMethodBeat.o(147195);
    return paramd;
  }
  
  public final void a(final com.tencent.mm.plugin.appbrand.d paramd, final String paramString1, int paramInt, String paramString2, final c.a parama, final JSONObject paramJSONObject, final c.c paramc)
  {
    AppMethodBeat.i(147196);
    com.tencent.mm.plugin.appbrand.keylogger.c.e(KSProcessWeAppLaunch.class, paramString1);
    com.tencent.mm.plugin.appbrand.keylogger.c.a(KSProcessWeAppLaunch.class, paramString1, String.format("Network:%s", new Object[] { NetStatusUtil.getNetTypeString(paramd.getRuntime().mContext) }));
    Object localObject1 = paramd.getAppId();
    int i;
    JSONObject localJSONObject2;
    JSONObject localJSONObject1;
    if (parama != null)
    {
      i = parama.sourceType;
      Log.i("MicroMsg.MiniProgramNavigator", "navigateTo fromAppID(%s) targetAppID(%s) sourceType:%d", new Object[] { localObject1, paramString1, Integer.valueOf(i) });
      localJSONObject2 = paramJSONObject.optJSONObject("extraData");
      localJSONObject1 = paramJSONObject.optJSONObject("privateExtraData");
      if (!(paramd instanceof ac)) {
        break label657;
      }
      localObject1 = (ac)paramd;
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
    for (localObject1 = ((ac)localObject1).nna;; localObject1 = "")
    {
      final com.tencent.luggage.sdk.d.d locald = (com.tencent.luggage.sdk.d.d)paramd.getRuntime();
      String str = paramd.getAppId() + ":" + locald.ON().cym + ":" + (locald.ON().cyo + 1000);
      Object localObject2 = locald.ON().cyA;
      AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
      if ((parama != null) && (parama.scene != 0))
      {
        i = parama.scene;
        label231:
        localAppBrandStatObject.scene = i;
        localAppBrandStatObject.ecS = ((AppBrandStatObject)localObject2).ecS;
        if ((parama == null) || (parama.scene == 0) || (Util.isNullOrNil(parama.dCw))) {
          break label677;
        }
        str = String.format("%s:%s", new Object[] { str, parama.dCw });
        localAppBrandStatObject.dCw = str;
        if (parama == null) {
          break label680;
        }
        i = parama.ecU;
        localAppBrandStatObject.ecU = i;
        if (parama == null) {
          break label686;
        }
        str = parama.ecV;
        localAppBrandStatObject.ecV = str;
        if (parama == null) {
          break label692;
        }
        str = parama.meP;
        label353:
        localAppBrandStatObject.meP = str;
        localObject2 = new AppBrandLaunchReferrer();
        ((AppBrandLaunchReferrer)localObject2).appId = paramd.getAppId();
        if (localJSONObject2 != null) {
          break label698;
        }
        str = "{}";
        ((AppBrandLaunchReferrer)localObject2).dSJ = str;
        if (localJSONObject1 != null) {
          break label708;
        }
        str = "{}";
        ((AppBrandLaunchReferrer)localObject2).lep = str;
        ((AppBrandLaunchReferrer)localObject2).leo = 1;
        ((AppBrandLaunchReferrer)localObject2).url = ((String)localObject1);
        if (parama == null) {
          break label718;
        }
        i = parama.sourceType;
        ((AppBrandLaunchReferrer)localObject2).sourceType = i;
        if (parama == null) {
          break label724;
        }
        localObject1 = parama.leq;
        ((AppBrandLaunchReferrer)localObject2).leq = ((String)localObject1);
        if (parama == null) {
          break label730;
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
        parama.iOo = paramInt;
        parama.kHw = paramString2;
        parama.mYK = localAppBrandStatObject;
        parama.cys = ((AppBrandLaunchReferrer)localObject2);
        parama.mYL = null;
        parama.mYM = l;
        paramString1 = new i();
        g.hdG().b(locald).f(new com.tencent.mm.vending.c.a() {}).f(new com.tencent.mm.vending.c.a() {}).f(new com.tencent.mm.vending.c.a() {}).a(new d.a()
        {
          public final void cn(Object paramAnonymousObject)
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
              paramc.o(false, paramAnonymousObject);
              locald.i(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(147185);
                  if (j.1.this.mfc.value != null) {
                    ((com.tencent.mm.plugin.appbrand.p.d)j.1.this.mfc.value).dismiss();
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
        localObject1 = ((s)paramd).getCurrentPageView();
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.j
 * JD-Core Version:    0.7.0.1
 */