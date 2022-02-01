package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.l;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.ad;
import org.json.JSONObject;

final class av
  extends bg
{
  final i.a a(c paramc, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(128908);
    try
    {
      paramJSONObject.put("append", true);
      paramc = super.a(paramc, paramString, paramJSONObject);
      AppMethodBeat.o(128908);
      return paramc;
    }
    catch (Exception paramc)
    {
      ad.e("MicroMsg.AppBrand.UnitAppendFile", "call with path(%s), put append fail ex = %s", new Object[] { paramString, paramc });
      paramc = new i.a("fail " + l.jMw.name(), new Object[0]);
      AppMethodBeat.o(128908);
    }
    return paramc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.av
 * JD-Core Version:    0.7.0.1
 */