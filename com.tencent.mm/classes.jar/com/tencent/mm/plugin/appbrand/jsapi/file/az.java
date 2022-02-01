package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

final class az
  extends bl
{
  final i.a a(e parame, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(128908);
    try
    {
      paramJSONObject.put("append", true);
      parame = super.a(parame, paramString, paramJSONObject);
      AppMethodBeat.o(128908);
      return parame;
    }
    catch (Exception parame)
    {
      Log.e("MicroMsg.AppBrand.UnitAppendFile", "call with path(%s), put append fail ex = %s", new Object[] { paramString, parame });
      parame = new i.a("fail " + m.nMS.name(), new Object[0]);
      AppMethodBeat.o(128908);
    }
    return parame;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.az
 * JD-Core Version:    0.7.0.1
 */