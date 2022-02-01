package com.tencent.mm.plugin.appbrand.jsapi.nfc.rw;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.a.ae;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;
import kotlin.s;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/JsApiEventOnNFCDiscovered;", "Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiEvent;", "()V", "dispatch", "", "id", "", "techs", "", "", "data", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "setContext", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "Companion", "luggage-commons-jsapi-nfc-ext_release"})
public final class c
  extends bc
{
  public static final int CTRL_INDEX = 790;
  public static final String NAME = "onNFCDiscovered";
  public static final a mhU;
  
  static
  {
    AppMethodBeat.i(183645);
    mhU = new a((byte)0);
    AppMethodBeat.o(183645);
  }
  
  public final void a(byte[] paramArrayOfByte, List<String> paramList, HashMap<String, Object> paramHashMap)
  {
    AppMethodBeat.i(207115);
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
    for (paramArrayOfByte = (Map)paramHashMap;; paramArrayOfByte = ae.e(new o[] { s.U("id", paramArrayOfByte), s.U("techs", paramList) }))
    {
      L(paramArrayOfByte).bEo();
      AppMethodBeat.o(207115);
      return;
    }
  }
  
  public final void bEo()
  {
    AppMethodBeat.i(183642);
    Log.d("MicroMsg.AppBrand.JsApiEventOnNFCDiscovered", "dispatch, data: " + getData());
    super.bEo();
    AppMethodBeat.o(183642);
  }
  
  public final c v(f paramf)
  {
    AppMethodBeat.i(183643);
    paramf = super.h(paramf);
    if (paramf == null)
    {
      paramf = new t("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.JsApiEventOnNFCDiscovered");
      AppMethodBeat.o(183643);
      throw paramf;
    }
    paramf = (c)paramf;
    AppMethodBeat.o(183643);
    return paramf;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/JsApiEventOnNFCDiscovered$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "PARAM_ID", "PARAM_TECHS", "TAG", "luggage-commons-jsapi-nfc-ext_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.c
 * JD-Core Version:    0.7.0.1
 */