package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.j;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONObject;

final class ap
  extends ba
{
  final h.a a(c paramc, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(102816);
    try
    {
      paramJSONObject.put("append", true);
      paramc = super.a(paramc, paramString, paramJSONObject);
      AppMethodBeat.o(102816);
      return paramc;
    }
    catch (Exception paramc)
    {
      ab.e("MicroMsg.AppBrand.UnitAppendFile", "call with path(%s), put append fail ex = %s", new Object[] { paramString, paramc });
      paramc = new h.a("fail " + j.gZB.name(), new Object[0]);
      AppMethodBeat.o(102816);
    }
    return paramc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.ap
 * JD-Core Version:    0.7.0.1
 */