package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.ae;
import org.json.JSONObject;

final class ax
  extends bi
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
      ae.e("MicroMsg.AppBrand.UnitAppendFile", "call with path(%s), put append fail ex = %s", new Object[] { paramString, paramc });
      paramc = new i.a("fail " + m.jPN.name(), new Object[0]);
      AppMethodBeat.o(128908);
    }
    return paramc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.ax
 * JD-Core Version:    0.7.0.1
 */