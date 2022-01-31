package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import a.l;
import a.v;
import android.os.Parcelable;
import android.util.SparseArray;
import com.tencent.luggage.sdk.launching.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.i;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.ui.MMActivity;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalAPIInvokeManager;", "", "runtime", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalRuntime;", "(Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalRuntime;)V", "callbackContextMap", "Landroid/util/SparseArray;", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/CallbackContext;", "callbackIdGenerator", "", "getRuntime", "()Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalRuntime;", "navigateBack", "", "transitiveData", "", "invokeResult", "onCallback", "component", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/IFunctionalComponent;", "callbackId", "data", "performInvoke", "invokeData", "plugin-appbrand-integration_release"})
public final class c
{
  int iox;
  final SparseArray<a> ioy;
  final j ioz;
  
  public c(j paramj)
  {
    AppMethodBeat.i(134734);
    this.ioz = paramj;
    this.ioy = new SparseArray();
    AppMethodBeat.o(134734);
  }
  
  public final void a(m paramm, int paramInt, String paramString)
  {
    AppMethodBeat.i(134732);
    a.f.b.j.q(paramm, "component");
    a.f.b.j.q(paramString, "data");
    paramm = (a)this.ioy.get(paramInt, null);
    if ((paramm instanceof n))
    {
      this.ioy.remove(paramInt);
      cC(((n)paramm).hiO, paramString);
      AppMethodBeat.o(134732);
      return;
    }
    if ((paramm instanceof o))
    {
      this.ioy.remove(paramInt);
      paramm = this.ioz.atV();
      if (paramm != null) {
        paramm.moveTaskToBack(true);
      }
      this.ioz.finish();
    }
    AppMethodBeat.o(134732);
  }
  
  final void cC(String paramString1, String paramString2)
  {
    AppMethodBeat.i(134733);
    Object localObject = this.ioz.atS().bDf;
    if (localObject != null)
    {
      if (localObject == null)
      {
        paramString1 = new v("null cannot be cast to non-null type com.tencent.luggage.sdk.launching.OnWXAppResultListener<com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.ByRuntimeQrcodeResult>");
        AppMethodBeat.o(134733);
        throw paramString1;
      }
      ((b)localObject).b((Parcelable)new ByRuntimeQrcodeResult(paramString2, paramString1));
      this.ioz.finish();
      AppMethodBeat.o(134733);
      return;
    }
    this.iox += 1;
    int i = this.iox;
    localObject = new i();
    i locali = new i();
    locali.f("data", paramString2);
    locali.f("transitiveData", paramString1);
    ((i)localObject).f("extraData", locali);
    paramString1 = ((i)localObject).toString();
    a.f.b.j.p(paramString1, "JSONObject().apply {\n   …   )\n        }.toString()");
    this.ioy.put(i, o.ioM);
    this.ioz.atU().q("navigateBackApplication", paramString1, i);
    AppMethodBeat.o(134733);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.c
 * JD-Core Version:    0.7.0.1
 */