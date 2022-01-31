package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.luggage.j.a;
import com.tencent.mm.plugin.appbrand.appstorage.h;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.nio.ByteBuffer;
import java.util.Map;
import org.json.JSONObject;

final class as
  extends d
{
  final f.a a(c paramc, String paramString, JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.optString("encoding");
    y.i("MicroMsg.AppBrand.UnitReadFile", "call, path %s, encoding %s", new Object[] { paramString, paramJSONObject });
    if (bk.bl(paramJSONObject)) {
      paramJSONObject = null;
    }
    for (;;)
    {
      com.tencent.mm.plugin.appbrand.u.k localk = new com.tencent.mm.plugin.appbrand.u.k();
      paramc = paramc.Zl().b(paramString, localk);
      if (paramc == h.fGU)
      {
        if (paramJSONObject == null) {}
        for (paramc = (Comparable)localk.value;; paramc = paramJSONObject.j((ByteBuffer)localk.value))
        {
          if (!(paramc instanceof ByteBuffer)) {
            a.f((ByteBuffer)localk.value);
          }
          return new f.a("ok", new Object[0]).m("data", paramc);
          paramJSONObject = (e)e.a.gqH.get(paramJSONObject.toLowerCase());
          if (paramJSONObject != null) {
            break;
          }
          return new f.a("fail invalid encoding", new Object[0]);
        }
      }
      switch (as.1.gqS[paramc.ordinal()])
      {
      default: 
        return new f.a("fail " + paramc.name(), new Object[0]);
      case 1: 
        return new f.a("fail no such file \"%s\"", new Object[] { paramString });
      case 2: 
        return new f.a("fail permission denied, open \"%s\"", new Object[] { paramString });
      }
      return new f.a("fail \"%s\" is not a regular file", new Object[] { paramString });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.as
 * JD-Core Version:    0.7.0.1
 */