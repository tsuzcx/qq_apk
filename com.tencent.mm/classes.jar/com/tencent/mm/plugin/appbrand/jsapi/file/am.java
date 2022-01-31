package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.mm.plugin.appbrand.appstorage.h;
import com.tencent.mm.plugin.appbrand.appstorage.k;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import org.json.JSONObject;

final class am
  extends d
{
  final f.a a(c paramc, String paramString, JSONObject paramJSONObject)
  {
    if (paramc.Zl().ru(paramString) == h.fGU) {}
    for (paramc = "ok";; paramc = String.format("fail no such file or directory \"%s\"", new Object[] { paramString })) {
      return new f.a(paramc, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.am
 * JD-Core Version:    0.7.0.1
 */