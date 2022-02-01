package com.tencent.mm.plugin.appbrand.jsapi.auth;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.ra;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.aw;
import com.tencent.mm.plugin.appbrand.b.c.a;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.jsapi.i.c;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.plugin.appbrand.report.quality.b;
import com.tencent.mm.plugin.car_license_plate.a.e.a;
import com.tencent.mm.plugin.car_license_plate.ui.CarLicensePlateListViewContract.a;
import com.tencent.mm.plugin.car_license_plate.ui.CarLicensePlateListViewContract.b;
import com.tencent.mm.plugin.car_license_plate.ui.d;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentSkipListSet;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/JsApiChooseLicensePlate;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
  extends com.tencent.mm.plugin.appbrand.jsapi.c<g>
{
  public static final int CTRL_INDEX = 1041;
  public static final String NAME = "chooseLicensePlate";
  public static final l.a rFG;
  
  static
  {
    AppMethodBeat.i(326907);
    rFG = new l.a((byte)0);
    AppMethodBeat.o(326907);
  }
  
  private static final void a(g paramg, final int paramInt, final l paraml)
  {
    Object localObject = null;
    AppMethodBeat.i(326900);
    s.u(paramg, "$env");
    s.u(paraml, "this$0");
    p localp = new p(paramg, (p.a)new b(paramg, paramInt, paraml));
    localp.rGB = ((CarLicensePlateListViewContract.a)new d(e.a.wbZ));
    paramg = localp.rGB;
    if (paramg == null)
    {
      s.bIx("viewPresenter");
      paramg = null;
    }
    for (;;)
    {
      paramg.a((CarLicensePlateListViewContract.b)localp);
      paraml = localp.rGB;
      paramg = paraml;
      if (paraml == null)
      {
        s.bIx("viewPresenter");
        paramg = null;
      }
      paramg.diX();
      g localg = localp.rGz;
      s.checkNotNull(localg);
      paramg = localp.rGF;
      paramg.imT = paramg.F("AppId", localg.getAppId(), true);
      paramg = b.afZ(localg.getAppId());
      if (paramg != null)
      {
        localp.rGF.ind = paramg.tSh;
        localp.rGF.ine = paramg.tQx;
        localp.rGF.jax = paramg.apptype;
      }
      paraml = localp.rGB;
      paramg = paraml;
      if (paraml == null)
      {
        s.bIx("viewPresenter");
        paramg = null;
      }
      paramg.cqq().qIf = localg.getAppId();
      localg.getRuntime().qsB.a((c.a)localp.rGH);
      paramg = localObject;
      if ((localg instanceof ad)) {
        paramg = (ad)localg;
      }
      if (paramg != null) {
        paramg.a((i.c)localp.rGH);
      }
      paramg = localg.getRuntime();
      paraml = (aw)localp;
      paramg.qsx.add(paraml);
      AppMethodBeat.o(326900);
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/auth/JsApiChooseLicensePlate$invoke$1$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/WxaCarLicensePlateChooserViewController$ChooserViewCallback;", "onPlateNoChosen", "", "plateNo", "", "onUserCancel", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements p.a
  {
    b(g paramg, int paramInt, l paraml) {}
    
    public final void ZZ(String paramString)
    {
      AppMethodBeat.i(326848);
      s.u(paramString, "plateNo");
      Log.i("MicroMsg.AppBrand.JsApiChooseLicensePlate", "onPlateNoChosen plateNo:" + paramString + ", appId:" + this.rCg.getAppId() + ", callbackId:" + paramInt);
      g localg = this.rCg;
      int i = paramInt;
      l locall = paraml;
      HashMap localHashMap = new HashMap();
      localHashMap.put("plateNumber", paramString);
      paramString = ah.aiuX;
      localg.callback(i, locall.m("ok", (Map)localHashMap));
      AppMethodBeat.o(326848);
    }
    
    public final void bSt()
    {
      AppMethodBeat.i(326858);
      Log.i("MicroMsg.AppBrand.JsApiChooseLicensePlate", "onUserCancel appId:" + this.rCg.getAppId() + ", callbackId:" + paramInt);
      this.rCg.callback(paramInt, paraml.ZP("fail cancel"));
      AppMethodBeat.o(326858);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.l
 * JD-Core Version:    0.7.0.1
 */