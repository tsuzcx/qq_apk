package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.mm.plugin.appbrand.appstorage.h;
import com.tencent.mm.plugin.appbrand.appstorage.k;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import org.json.JSONObject;

final class ap
  extends d
{
  final f.a a(c paramc, String paramString, JSONObject paramJSONObject)
  {
    boolean bool = true;
    paramc = paramc.Zl().rv(paramString);
    switch (ap.1.gqS[paramc.ordinal()])
    {
    default: 
      return new f.a("fail " + paramc.name(), new Object[0]);
    case 1: 
      return new f.a("fail no such file or directory \"%s\"", new Object[] { paramString });
    }
    paramString = new f.a("ok", new Object[0]);
    if (paramc == h.fGU) {}
    for (;;)
    {
      return paramString.m("result", Boolean.valueOf(bool));
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.ap
 * JD-Core Version:    0.7.0.1
 */