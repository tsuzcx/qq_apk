package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.mm.plugin.appbrand.appstorage.h;
import com.tencent.mm.plugin.appbrand.appstorage.k;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import org.json.JSONObject;

final class aq
  extends d
{
  final f.a a(c paramc, String paramString, JSONObject paramJSONObject)
  {
    boolean bool = paramJSONObject.optBoolean("recursive", false);
    paramc = paramc.Zl().U(paramString, bool);
    switch (aq.1.gqS[paramc.ordinal()])
    {
    default: 
      return new f.a("fail " + paramc.name(), new Object[0]);
    case 1: 
      return new f.a("fail no such file or directory \"%s\"", new Object[] { paramString });
    case 2: 
      return new f.a("fail permission denied, open \"%s\"", new Object[] { paramString });
    case 3: 
      return new f.a("fail file already exists \"%s\"", new Object[] { paramString });
    }
    return new f.a("ok", new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.aq
 * JD-Core Version:    0.7.0.1
 */