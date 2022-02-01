package com.tencent.mm.plugin.appbrand.jsapi.nfc.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ar;
import com.tencent.mm.sdk.platformtools.ac;
import d.a.ae;
import d.g.b.k;
import d.l;
import d.u;
import d.v;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/JsApiEventOnNFCDiscovered;", "Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiEvent;", "()V", "dispatch", "", "techs", "", "", "data", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "setContext", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "Companion", "luggage-commons-jsapi-nfc-ext_release"})
public final class c
  extends ar
{
  public static final int CTRL_INDEX = 790;
  public static final String NAME = "onNFCDiscovered";
  public static final a kCN;
  
  static
  {
    AppMethodBeat.i(183645);
    kCN = new a((byte)0);
    AppMethodBeat.o(183645);
  }
  
  public final void a(List<String> paramList, HashMap<String, Object> paramHashMap)
  {
    AppMethodBeat.i(183640);
    k.h(paramList, "techs");
    if (paramHashMap != null)
    {
      paramHashMap.put("techs", paramList);
      if (paramHashMap == null) {}
    }
    for (paramList = (Map)paramHashMap;; paramList = ae.b(u.Q("techs", paramList)))
    {
      B(paramList).beN();
      AppMethodBeat.o(183640);
      return;
    }
  }
  
  public final void beN()
  {
    AppMethodBeat.i(183642);
    ac.d("MicroMsg.AppBrand.JsApiEventOnNFCDiscovered", "dispatch, data: " + getData());
    super.beN();
    AppMethodBeat.o(183642);
  }
  
  public final c v(com.tencent.mm.plugin.appbrand.jsapi.c paramc)
  {
    AppMethodBeat.i(183643);
    paramc = super.h(paramc);
    if (paramc == null)
    {
      paramc = new v("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.JsApiEventOnNFCDiscovered");
      AppMethodBeat.o(183643);
      throw paramc;
    }
    paramc = (c)paramc;
    AppMethodBeat.o(183643);
    return paramc;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/JsApiEventOnNFCDiscovered$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "PARAM_TECHS", "TAG", "luggage-commons-jsapi-nfc-ext_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.a.c
 * JD-Core Version:    0.7.0.1
 */