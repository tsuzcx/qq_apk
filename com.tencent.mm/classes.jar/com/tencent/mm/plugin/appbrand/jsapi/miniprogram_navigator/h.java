package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.page.v;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.plugin.appbrand.widget.b.g;
import com.tencent.mm.plugin.appbrand.widget.b.k.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.f;
import org.json.JSONObject;

public class h
  implements c
{
  static final h hTk;
  
  static
  {
    AppMethodBeat.i(101993);
    hTk = new h();
    AppMethodBeat.o(101993);
  }
  
  protected k.a B(i parami)
  {
    AppMethodBeat.i(140847);
    parami = new g(parami.getContext());
    AppMethodBeat.o(140847);
    return parami;
  }
  
  public com.tencent.mm.vending.g.c<AppBrandInitConfigLU> a(d paramd, LaunchParcel paramLaunchParcel)
  {
    AppMethodBeat.i(101991);
    paramd = f.cN(null);
    AppMethodBeat.o(101991);
    return paramd;
  }
  
  public final void a(final d paramd, String paramString1, int paramInt, String paramString2, final c.a parama, final JSONObject paramJSONObject1, JSONObject paramJSONObject2, final c.c paramc)
  {
    AppMethodBeat.i(101992);
    Object localObject1 = paramd.getAppId();
    int i;
    if (parama != null)
    {
      i = parama.cpG;
      ab.i("MicroMsg.MiniProgramNavigator", "navigateTo fromAppID(%s) targetAppID(%s) sourceType:%d", new Object[] { localObject1, paramString1, Integer.valueOf(i) });
      if (!(paramd instanceof v)) {
        break label603;
      }
      localObject1 = (v)paramd;
      label64:
      if (localObject1 == null) {
        break label682;
      }
    }
    label263:
    label282:
    label670:
    label676:
    label682:
    for (localObject1 = ((v)localObject1).iuB;; localObject1 = "")
    {
      b localb = (b)paramd.getRuntime();
      Object localObject2 = paramd.getAppId() + ":" + localb.wS().vZ() + ":" + (localb.wS().bCV + 1000);
      AppBrandStatObject localAppBrandStatObject2 = localb.wS().bDh;
      AppBrandStatObject localAppBrandStatObject1 = new AppBrandStatObject();
      if ((parama != null) && (parama.scene != 0))
      {
        i = parama.scene;
        label179:
        localAppBrandStatObject1.scene = i;
        localAppBrandStatObject1.cIZ = localAppBrandStatObject2.cIZ;
        if ((parama == null) || (parama.scene == 0) || (bo.isNullOrNil(parama.cmF))) {
          break label623;
        }
        localObject2 = String.format("%s:%s", new Object[] { localObject2, parama.cmF });
        label244:
        localAppBrandStatObject1.cmF = ((String)localObject2);
        if (parama == null) {
          break label626;
        }
        i = parama.cJb;
        localAppBrandStatObject1.cJb = i;
        if (parama == null) {
          break label632;
        }
        localObject2 = parama.cJc;
        localAppBrandStatObject1.cJc = ((String)localObject2);
        if (parama == null) {
          break label638;
        }
        localObject2 = parama.hST;
        label301:
        localAppBrandStatObject1.hST = ((String)localObject2);
        localObject2 = new AppBrandLaunchReferrer();
        ((AppBrandLaunchReferrer)localObject2).appId = paramd.getAppId();
        if (paramJSONObject1 != null) {
          break label644;
        }
        paramJSONObject1 = "{}";
        label335:
        ((AppBrandLaunchReferrer)localObject2).cAh = paramJSONObject1;
        if (paramJSONObject2 != null) {
          break label654;
        }
        paramJSONObject1 = "{}";
        label351:
        ((AppBrandLaunchReferrer)localObject2).hiL = paramJSONObject1;
        ((AppBrandLaunchReferrer)localObject2).hiK = 1;
        ((AppBrandLaunchReferrer)localObject2).url = ((String)localObject1);
        if (parama == null) {
          break label664;
        }
        i = parama.cpG;
        label383:
        ((AppBrandLaunchReferrer)localObject2).cpG = i;
        if (parama == null) {
          break label670;
        }
        paramJSONObject1 = parama.hiM;
        ((AppBrandLaunchReferrer)localObject2).hiM = paramJSONObject1;
        if (parama == null) {
          break label676;
        }
      }
      for (parama = parama.businessType;; parama = null)
      {
        ((AppBrandLaunchReferrer)localObject2).businessType = parama;
        long l = bo.aoy();
        parama = new LaunchParcel();
        parama.username = null;
        parama.appId = paramString1;
        parama.version = 0;
        parama.hcr = paramInt;
        parama.hiw = paramString2;
        parama.inG = localAppBrandStatObject1;
        parama.hiz = ((AppBrandLaunchReferrer)localObject2);
        parama.inH = null;
        parama.inI = l;
        paramJSONObject1 = new j();
        f.dQr().f(new h.4(this, paramJSONObject1, localb, paramd, parama)).f(new h.3(this, paramd, paramString1, paramString2, parama)).f(new a() {}).a(new h.1(this, paramc, localb, paramJSONObject1));
        AppMethodBeat.o(101992);
        return;
        i = 0;
        break;
        label603:
        localObject1 = ((r)paramd).getCurrentPageView();
        break label64;
        i = 1037;
        break label179;
        label623:
        break label244;
        label626:
        i = 0;
        break label263;
        label632:
        localObject2 = null;
        break label282;
        label638:
        localObject2 = null;
        break label301;
        paramJSONObject1 = paramJSONObject1.toString();
        break label335;
        paramJSONObject1 = paramJSONObject2.toString();
        break label351;
        i = 0;
        break label383;
        paramJSONObject1 = null;
        break label402;
      }
    }
  }
  
  public boolean a(d paramd, LaunchParcel paramLaunchParcel, c.b paramb)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.h
 * JD-Core Version:    0.7.0.1
 */