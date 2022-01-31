package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.luggage.j.b;
import com.tencent.mm.plugin.appbrand.appstorage.f;
import com.tencent.mm.plugin.appbrand.appstorage.h;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

final class ar
  extends d
{
  final f.a a(c paramc, String paramString, JSONObject paramJSONObject)
  {
    paramJSONObject = new LinkedList();
    com.tencent.mm.plugin.appbrand.u.k localk = new com.tencent.mm.plugin.appbrand.u.k();
    paramc = paramc.Zl().a(paramString, localk);
    b.c(paramJSONObject, (List)localk.value);
    switch (ar.1.gqS[paramc.ordinal()])
    {
    default: 
      return new f.a("fail " + paramc.name(), new Object[0]);
    case 1: 
    case 2: 
      return new f.a("fail no such file or directory \"%s\"", new Object[] { paramString });
    case 3: 
      return new f.a("fail not a directory \"%s\"", new Object[] { paramString });
    case 4: 
      return new f.a("fail permission denied, open \"%s\"", new Object[] { paramString });
    case 5: 
      return new f.a("fail \"%s\" is not a regular file", new Object[] { paramString });
    }
    paramc = new JSONArray();
    paramString = paramJSONObject.iterator();
    while (paramString.hasNext()) {
      paramc.put(((f)paramString.next()).fileName);
    }
    return new f.a("ok", new Object[0]).m("files", paramc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.ar
 * JD-Core Version:    0.7.0.1
 */