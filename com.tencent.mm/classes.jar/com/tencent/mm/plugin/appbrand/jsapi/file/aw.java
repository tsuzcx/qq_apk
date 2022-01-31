package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.mm.plugin.appbrand.appstorage.h;
import com.tencent.mm.plugin.appbrand.appstorage.k;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import org.json.JSONObject;

final class aw
  extends d
{
  final f.a a(c paramc, String paramString, JSONObject paramJSONObject)
  {
    paramc = paramc.Zl().rw(paramString);
    switch (aw.1.gqS[paramc.ordinal()])
    {
    default: 
      return new f.a("fail " + paramc.name(), new Object[0]);
    case 1: 
      return new f.a("fail permission denied, open \"%s\"", new Object[] { paramString });
    case 2: 
      return new f.a("fail no such file or directory \"%s\"", new Object[] { paramString });
    case 3: 
      return new f.a("fail operation not permitted, unlink \"%s\"", new Object[] { paramString });
    }
    return new f.a("ok", new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.aw
 * JD-Core Version:    0.7.0.1
 */