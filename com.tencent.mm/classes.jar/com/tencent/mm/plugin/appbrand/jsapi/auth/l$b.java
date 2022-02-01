package com.tencent.mm.plugin.appbrand.jsapi.auth;

import com.tencent.luggage.sdk.h.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.ni;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.jsapi.h.c;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.plugin.car_license_plate.a.e.a;
import com.tencent.mm.plugin.car_license_plate.ui.CarLicensePlateListViewContract.a;
import com.tencent.mm.plugin.car_license_plate.ui.CarLicensePlateListViewContract.b;
import com.tencent.mm.plugin.car_license_plate.ui.e;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
final class l$b
  implements Runnable
{
  l$b(l paraml, g paramg, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(279840);
    p localp = new p(this.owL, (p.a)new p.a()
    {
      public final void ahc(String paramAnonymousString)
      {
        AppMethodBeat.i(279932);
        kotlin.g.b.p.k(paramAnonymousString, "plateNo");
        Log.i("MicroMsg.AppBrand.JsApiChooseLicensePlate", "onPlateNoChosen plateNo:" + paramAnonymousString + ", appId:" + this.oCk.owL.getAppId() + ", callbackId:" + this.oCk.otk);
        g localg = this.oCk.owL;
        int i = this.oCk.otk;
        l locall = this.oCk.oCj;
        HashMap localHashMap = new HashMap();
        localHashMap.put("plateNumber", paramAnonymousString);
        localg.j(i, locall.m("ok", (Map)localHashMap));
        AppMethodBeat.o(279932);
      }
      
      public final void bQm()
      {
        AppMethodBeat.i(279933);
        Log.i("MicroMsg.AppBrand.JsApiChooseLicensePlate", "onUserCancel appId:" + this.oCk.owL.getAppId() + ", callbackId:" + this.oCk.otk);
        this.oCk.owL.j(this.oCk.otk, this.oCk.oCj.agS("fail cancel"));
        AppMethodBeat.o(279933);
      }
    });
    localp.oDk = ((CarLicensePlateListViewContract.a)new e(e.a.sXE));
    Object localObject1 = localp.oDk;
    if (localObject1 == null) {
      kotlin.g.b.p.bGy("viewPresenter");
    }
    ((CarLicensePlateListViewContract.a)localObject1).a((CarLicensePlateListViewContract.b)localp);
    localObject1 = localp.oDk;
    if (localObject1 == null) {
      kotlin.g.b.p.bGy("viewPresenter");
    }
    ((CarLicensePlateListViewContract.a)localObject1).cFE();
    localObject1 = localp.oDq;
    if (localObject1 == null) {
      kotlin.g.b.p.iCn();
    }
    localp.oDo.Ej(((g)localObject1).getAppId());
    Object localObject2 = com.tencent.mm.plugin.appbrand.report.quality.b.amO(((g)localObject1).getAppId());
    if (localObject2 != null)
    {
      localp.oDo.zt(((QualitySessionRuntime)localObject2).qNx);
      localp.oDo.zu(((QualitySessionRuntime)localObject2).qLQ);
      localp.oDo.zv(((QualitySessionRuntime)localObject2).apptype);
    }
    localObject2 = localp.oDk;
    if (localObject2 == null) {
      kotlin.g.b.p.bGy("viewPresenter");
    }
    ((CarLicensePlateListViewContract.a)localObject2).bQt().nIo = ((g)localObject1).getAppId();
    localObject2 = h.cDq;
    localObject2 = ((g)localObject1).getRuntime();
    kotlin.g.b.p.j(localObject2, "env.runtime");
    h.a((AppBrandRuntime)localObject2, (kotlin.g.a.b)new p.h(localp));
    if ((localObject1 instanceof ad)) {
      ((ad)localObject1).a((h.c)new p.i(localp));
    }
    AppMethodBeat.o(279840);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.l.b
 * JD-Core Version:    0.7.0.1
 */