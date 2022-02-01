package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import android.app.Activity;
import android.os.Parcelable;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.i;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import d.g.b.k;
import d.l;
import d.v;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalAPIInvokeManager;", "", "runtime", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalRuntime;", "(Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalRuntime;)V", "callbackContextMap", "Landroid/util/SparseArray;", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/CallbackContext;", "callbackIdGenerator", "", "getRuntime", "()Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalRuntime;", "navigateBack", "", "transitiveData", "", "invokeResult", "onCallback", "component", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/IFunctionalComponent;", "callbackId", "data", "performInvoke", "invokeData", "plugin-appbrand-integration_release"})
public final class c
{
  int kPr;
  final SparseArray<a> kPs;
  final j kPt;
  
  public c(j paramj)
  {
    AppMethodBeat.i(50863);
    this.kPt = paramj;
    this.kPs = new SparseArray();
    AppMethodBeat.o(50863);
  }
  
  public final void a(m paramm, int paramInt, String paramString)
  {
    AppMethodBeat.i(50861);
    k.h(paramm, "component");
    k.h(paramString, "data");
    paramm = (a)this.kPs.get(paramInt, null);
    if ((paramm instanceof n))
    {
      this.kPs.remove(paramInt);
      dA(((n)paramm).jdG, paramString);
      AppMethodBeat.o(50861);
      return;
    }
    if ((paramm instanceof o))
    {
      this.kPs.remove(paramInt);
      paramm = this.kPt.getContext();
      if (paramm != null) {
        paramm.moveTaskToBack(true);
      }
      this.kPt.finish();
    }
    AppMethodBeat.o(50861);
  }
  
  final void dA(String paramString1, String paramString2)
  {
    AppMethodBeat.i(50862);
    Object localObject = this.kPt.aNc().cfm;
    if (localObject != null)
    {
      if (localObject == null)
      {
        paramString1 = new v("null cannot be cast to non-null type com.tencent.luggage.sdk.launching.OnWXAppResultListener<com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.ByRuntimeQrcodeResult>");
        AppMethodBeat.o(50862);
        throw paramString1;
      }
      ((com.tencent.luggage.sdk.launching.a)localObject).b((Parcelable)new ByRuntimeQrcodeResult(paramString2, paramString1));
      this.kPt.finish();
      AppMethodBeat.o(50862);
      return;
    }
    this.kPr += 1;
    int i = this.kPr;
    localObject = new i();
    i locali = new i();
    locali.j("data", paramString2);
    locali.j("transitiveData", paramString1);
    ((i)localObject).j("extraData", locali);
    paramString1 = ((i)localObject).toString();
    k.g(paramString1, "JSONObject().apply {\n   …   )\n        }.toString()");
    this.kPs.put(i, o.kPE);
    this.kPt.aNe().w("navigateBackApplication", paramString1, i);
    AppMethodBeat.o(50862);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.c
 * JD-Core Version:    0.7.0.1
 */