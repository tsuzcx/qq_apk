package com.tencent.mm.plugin.appbrand.jsapi;

import a.f.b.j;
import a.l;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.sdk.g.a.e;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.bo;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiGetMenuButtonBoundingClientRectWithReport;", "Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiGetMenuButtonBoundingClientRect;", "()V", "invoke", "", "env", "Lcom/tencent/mm/plugin/appbrand/AppBrandService;", "data", "Lorg/json/JSONObject;", "component1", "L", "R", "Landroid/util/Pair;", "(Landroid/util/Pair;)Ljava/lang/Object;", "component2", "plugin-appbrand-integration_release"})
public final class al
  extends ak
{
  public final String h(r paramr)
  {
    AppMethodBeat.i(134641);
    long l1 = bo.yB();
    Pair localPair = super.i(paramr);
    j.q(localPair, "receiver$0");
    String str = (String)localPair.first;
    j.q(localPair, "receiver$0");
    ak.a locala = (ak.a)localPair.second;
    if (paramr != null)
    {
      long l2 = bo.yB();
      d.ysm.execute((Runnable)new al.a(l2 - l1, locala, str, this, paramr, l1));
    }
    paramr = localPair.first;
    j.p(paramr, "super.invokeImpl(env, da…       }\n\n        }.first");
    paramr = (String)paramr;
    AppMethodBeat.o(134641);
    return paramr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.al
 * JD-Core Version:    0.7.0.1
 */