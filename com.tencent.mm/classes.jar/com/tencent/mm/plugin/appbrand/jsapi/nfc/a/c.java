package com.tencent.mm.plugin.appbrand.jsapi.nfc.a;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.at;
import com.tencent.mm.sdk.platformtools.ad;
import d.a.ae;
import d.g.b.p;
import d.l;
import d.o;
import d.u;
import d.v;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/JsApiEventOnNFCDiscovered;", "Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiEvent;", "()V", "dispatch", "", "id", "", "techs", "", "", "data", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "setContext", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "Companion", "luggage-commons-jsapi-nfc-ext_release"})
public final class c
  extends at
{
  public static final int CTRL_INDEX = 790;
  public static final String NAME = "onNFCDiscovered";
  public static final a kYU;
  
  static
  {
    AppMethodBeat.i(183645);
    kYU = new a((byte)0);
    AppMethodBeat.o(183645);
  }
  
  public final void a(byte[] paramArrayOfByte, List<String> paramList, HashMap<String, Object> paramHashMap)
  {
    AppMethodBeat.i(199665);
    p.h(paramList, "techs");
    Object localObject = paramArrayOfByte;
    if (paramArrayOfByte == null) {
      localObject = new byte[0];
    }
    paramArrayOfByte = Base64.encode((byte[])localObject, 2);
    p.g(paramArrayOfByte, "Base64.encode(id ?: ByteArray(0), Base64.NO_WRAP)");
    localObject = StandardCharsets.UTF_8;
    p.g(localObject, "StandardCharsets.UTF_8");
    paramArrayOfByte = new String(paramArrayOfByte, (Charset)localObject);
    if (paramHashMap != null)
    {
      paramHashMap.put("id", paramArrayOfByte);
      paramHashMap.put("techs", paramList);
      if (paramHashMap == null) {}
    }
    for (paramArrayOfByte = (Map)paramHashMap;; paramArrayOfByte = ae.a(new o[] { u.S("id", paramArrayOfByte), u.S("techs", paramList) }))
    {
      B(paramArrayOfByte).bir();
      AppMethodBeat.o(199665);
      return;
    }
  }
  
  public final void bir()
  {
    AppMethodBeat.i(183642);
    ad.d("MicroMsg.AppBrand.JsApiEventOnNFCDiscovered", "dispatch, data: " + getData());
    super.bir();
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
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/JsApiEventOnNFCDiscovered$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "PARAM_ID", "PARAM_TECHS", "TAG", "luggage-commons-jsapi-nfc-ext_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.a.c
 * JD-Core Version:    0.7.0.1
 */