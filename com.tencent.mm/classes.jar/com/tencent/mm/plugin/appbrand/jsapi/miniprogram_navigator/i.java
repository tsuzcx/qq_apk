package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.plugin.appbrand.widget.dialog.k.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vending.g.b;
import com.tencent.mm.vending.g.d.a;
import org.json.JSONObject;

public class i
  implements c
{
  static final i kZL;
  
  static
  {
    AppMethodBeat.i(147197);
    kZL = new i();
    AppMethodBeat.o(147197);
  }
  
  protected k.a X(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(147194);
    paramAppBrandRuntime = new com.tencent.mm.plugin.appbrand.widget.dialog.g(com.tencent.mm.sdk.f.a.jw(paramAppBrandRuntime.mContext));
    AppMethodBeat.o(147194);
    return paramAppBrandRuntime;
  }
  
  public com.tencent.mm.vending.g.c<AppBrandInitConfigLU> a(com.tencent.mm.plugin.appbrand.d paramd, LaunchParcel paramLaunchParcel, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(147195);
    paramd = com.tencent.mm.vending.g.g.ej(null);
    AppMethodBeat.o(147195);
    return paramd;
  }
  
  public final void a(final com.tencent.mm.plugin.appbrand.d paramd, final String paramString1, int paramInt, String paramString2, final c.a parama, final JSONObject paramJSONObject, final c.c paramc)
  {
    AppMethodBeat.i(147196);
    com.tencent.mm.plugin.appbrand.keylogger.c.a(KSProcessWeAppLaunch.class, paramString1);
    com.tencent.mm.plugin.appbrand.keylogger.c.a(KSProcessWeAppLaunch.class, paramString1, String.format("Network:%s", new Object[] { az.getNetTypeString(paramd.getRuntime().mContext) }));
    Object localObject1 = paramd.getAppId();
    int i;
    JSONObject localJSONObject2;
    JSONObject localJSONObject1;
    if (parama != null)
    {
      i = parama.sourceType;
      ae.i("MicroMsg.MiniProgramNavigator", "navigateTo fromAppID(%s) targetAppID(%s) sourceType:%d", new Object[] { localObject1, paramString1, Integer.valueOf(i) });
      localJSONObject2 = paramJSONObject.optJSONObject("extraData");
      localJSONObject1 = paramJSONObject.optJSONObject("privateExtraData");
      if (!(paramd instanceof z)) {
        break label657;
      }
      localObject1 = (z)paramd;
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
    for (localObject1 = ((z)localObject1).mcM;; localObject1 = "")
    {
      final com.tencent.luggage.sdk.d.d locald = (com.tencent.luggage.sdk.d.d)paramd.getRuntime();
      String str = paramd.getAppId() + ":" + locald.Fg().Ef() + ":" + (locald.Fg().cmt + 1000);
      Object localObject2 = locald.Fg().cmE;
      AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
      if ((parama != null) && (parama.scene != 0))
      {
        i = parama.scene;
        label231:
        localAppBrandStatObject.scene = i;
        localAppBrandStatObject.dLd = ((AppBrandStatObject)localObject2).dLd;
        if ((parama == null) || (parama.scene == 0) || (bu.isNullOrNil(parama.dlj))) {
          break label677;
        }
        str = String.format("%s:%s", new Object[] { str, parama.dlj });
        localAppBrandStatObject.dlj = str;
        if (parama == null) {
          break label680;
        }
        i = parama.dLf;
        localAppBrandStatObject.dLf = i;
        if (parama == null) {
          break label686;
        }
        str = parama.dLg;
        localAppBrandStatObject.dLg = str;
        if (parama == null) {
          break label692;
        }
        str = parama.kZC;
        label353:
        localAppBrandStatObject.kZC = str;
        localObject2 = new AppBrandLaunchReferrer();
        ((AppBrandLaunchReferrer)localObject2).appId = paramd.getAppId();
        if (localJSONObject2 != null) {
          break label698;
        }
        str = "{}";
        ((AppBrandLaunchReferrer)localObject2).dAU = str;
        if (localJSONObject1 != null) {
          break label708;
        }
        str = "{}";
        ((AppBrandLaunchReferrer)localObject2).kbh = str;
        ((AppBrandLaunchReferrer)localObject2).kbg = 1;
        ((AppBrandLaunchReferrer)localObject2).url = ((String)localObject1);
        if (parama == null) {
          break label718;
        }
        i = parama.sourceType;
        ((AppBrandLaunchReferrer)localObject2).sourceType = i;
        if (parama == null) {
          break label724;
        }
        localObject1 = parama.kbi;
        ((AppBrandLaunchReferrer)localObject2).kbi = ((String)localObject1);
        if (parama == null) {
          break label730;
        }
      }
      for (parama = parama.businessType;; parama = null)
      {
        ((AppBrandLaunchReferrer)localObject2).businessType = parama;
        long l = bu.fpO();
        parama = new LaunchParcel();
        parama.username = null;
        parama.appId = paramString1;
        parama.version = 0;
        parama.hSZ = paramInt;
        parama.jFL = paramString2;
        parama.lRA = localAppBrandStatObject;
        parama.cmx = ((AppBrandLaunchReferrer)localObject2);
        parama.lRB = null;
        parama.lRC = l;
        paramString1 = new com.tencent.mm.plugin.appbrand.y.i();
        com.tencent.mm.vending.g.g.fSA().b(locald).f(new com.tencent.mm.vending.c.a() {}).f(new com.tencent.mm.vending.c.a() {}).f(new com.tencent.mm.vending.c.a() {}).a(new d.a()
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
              paramc.o(false, paramAnonymousObject);
              locald.j(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(147185);
                  if (i.1.this.kZO.value != null) {
                    ((com.tencent.mm.plugin.appbrand.m.d)i.1.this.kZO.value).dismiss();
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
        localObject1 = ((r)paramd).getCurrentPageView();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.i
 * JD-Core Version:    0.7.0.1
 */