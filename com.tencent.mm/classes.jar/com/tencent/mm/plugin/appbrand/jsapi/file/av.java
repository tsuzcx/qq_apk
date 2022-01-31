package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.mm.plugin.appbrand.appstorage.FileStructStat;
import com.tencent.mm.plugin.appbrand.appstorage.h;
import com.tencent.mm.plugin.appbrand.appstorage.k;
import com.tencent.mm.plugin.appbrand.appstorage.n;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

final class av
  extends d
{
  private static Map<String, Object> a(FileStructStat paramFileStructStat, Map<String, Object> paramMap)
  {
    paramMap.put("mode", Integer.valueOf(paramFileStructStat.st_mode));
    paramMap.put("size", Long.valueOf(paramFileStructStat.st_size));
    paramMap.put("lastAccessedTime", Long.valueOf(paramFileStructStat.st_atime));
    paramMap.put("lastModifiedTime", Long.valueOf(paramFileStructStat.st_mtime));
    return paramMap;
  }
  
  private static f.a h(c paramc, String paramString)
  {
    Object localObject = new LinkedList();
    paramc = paramc.Zl().g(paramString, (List)localObject);
    switch (av.1.gqS[paramc.ordinal()])
    {
    default: 
      return new f.a("fail " + paramc.name(), new Object[0]);
    }
    paramc = new f.a("ok", new Object[0]);
    paramString = ((List)localObject).iterator();
    while (paramString.hasNext())
    {
      localObject = (n)paramString.next();
      paramc.m(((n)localObject).fHo, a((FileStructStat)localObject, new HashMap()));
    }
    return paramc;
  }
  
  final f.a a(c paramc, String paramString, JSONObject paramJSONObject)
  {
    boolean bool = paramJSONObject.optBoolean("recursive", false);
    paramJSONObject = new FileStructStat();
    h localh = paramc.Zl().a(paramString, paramJSONObject);
    switch (av.1.gqS[localh.ordinal()])
    {
    default: 
      return new f.a("fail " + localh.name(), new Object[0]);
    case 1: 
      if ((!paramJSONObject.isDirectory()) || (!bool)) {
        return new f.a("ok", new Object[0]).t(a(paramJSONObject, new HashMap()));
      }
      return h(paramc, paramString);
    case 2: 
    case 3: 
      return new f.a("fail no such file or directory \"%s\"", new Object[] { paramString });
    }
    return new f.a("fail permission denied, open \"%s\"", new Object[] { paramString });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.av
 * JD-Core Version:    0.7.0.1
 */