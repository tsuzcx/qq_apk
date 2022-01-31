package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.mm.plugin.appbrand.appstorage.h;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONObject;

final class an
  extends ay
{
  final f.a a(c paramc, String paramString, JSONObject paramJSONObject)
  {
    try
    {
      paramJSONObject.put("append", true);
      return super.a(paramc, paramString, paramJSONObject);
    }
    catch (Exception paramc)
    {
      y.e("MicroMsg.AppBrand.UnitAppendFile", "call with path(%s), put append fail ex = %s", new Object[] { paramString, paramc });
    }
    return new f.a("fail " + h.fGV.name(), new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.an
 * JD-Core Version:    0.7.0.1
 */