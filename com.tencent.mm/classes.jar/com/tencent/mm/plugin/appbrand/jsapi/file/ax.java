package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

final class ax
  extends bi
{
  final i.a a(f paramf, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(128908);
    try
    {
      paramJSONObject.put("append", true);
      paramf = super.a(paramf, paramString, paramJSONObject);
      AppMethodBeat.o(128908);
      return paramf;
    }
    catch (Exception paramf)
    {
      Log.e("MicroMsg.AppBrand.UnitAppendFile", "call with path(%s), put append fail ex = %s", new Object[] { paramString, paramf });
      paramf = new i.a("fail " + m.kSv.name(), new Object[0]);
      AppMethodBeat.o(128908);
    }
    return paramf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.ax
 * JD-Core Version:    0.7.0.1
 */