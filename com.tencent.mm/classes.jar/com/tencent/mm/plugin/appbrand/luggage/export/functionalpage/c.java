package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import android.app.Activity;
import android.os.Parcelable;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.i;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import d.g.b.k;
import d.l;
import d.v;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalAPIInvokeManager;", "", "runtime", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalRuntime;", "(Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalRuntime;)V", "callbackContextMap", "Landroid/util/SparseArray;", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/CallbackContext;", "callbackIdGenerator", "", "getRuntime", "()Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalRuntime;", "navigateBack", "", "transitiveData", "", "invokeResult", "onCallback", "component", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/IFunctionalComponent;", "callbackId", "data", "performInvoke", "invokeData", "plugin-appbrand-integration_release"})
public final class c
{
  int lqQ;
  final SparseArray<a> lqR;
  final j lqS;
  
  public c(j paramj)
  {
    AppMethodBeat.i(50863);
    this.lqS = paramj;
    this.lqR = new SparseArray();
    AppMethodBeat.o(50863);
  }
  
  public final void a(m paramm, int paramInt, String paramString)
  {
    AppMethodBeat.i(50861);
    k.h(paramm, "component");
    k.h(paramString, "data");
    paramm = (a)this.lqR.get(paramInt, null);
    if ((paramm instanceof n))
    {
      this.lqR.remove(paramInt);
      dM(((n)paramm).jDU, paramString);
      AppMethodBeat.o(50861);
      return;
    }
    if ((paramm instanceof o))
    {
      this.lqR.remove(paramInt);
      paramm = this.lqS.getContext();
      if (paramm != null) {
        paramm.moveTaskToBack(true);
      }
      this.lqS.finish();
    }
    AppMethodBeat.o(50861);
  }
  
  final void dM(String paramString1, String paramString2)
  {
    AppMethodBeat.i(50862);
    Object localObject = this.lqS.aTS().ccj;
    if (localObject != null)
    {
      if (localObject == null)
      {
        paramString1 = new v("null cannot be cast to non-null type com.tencent.luggage.sdk.launching.OnWXAppResultListener<com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.ByRuntimeQrcodeResult>");
        AppMethodBeat.o(50862);
        throw paramString1;
      }
      ((com.tencent.luggage.sdk.launching.a)localObject).b((Parcelable)new ByRuntimeQrcodeResult(paramString2, paramString1));
      this.lqS.finish();
      AppMethodBeat.o(50862);
      return;
    }
    this.lqQ += 1;
    int i = this.lqQ;
    localObject = new i();
    i locali = new i();
    locali.i("data", paramString2);
    locali.i("transitiveData", paramString1);
    ((i)localObject).i("extraData", locali);
    paramString1 = ((i)localObject).toString();
    k.g(paramString1, "JSONObject().apply {\n   …   )\n        }.toString()");
    this.lqR.put(i, o.lrd);
    this.lqS.aTU().x("navigateBackApplication", paramString1, i);
    AppMethodBeat.o(50862);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.c
 * JD-Core Version:    0.7.0.1
 */