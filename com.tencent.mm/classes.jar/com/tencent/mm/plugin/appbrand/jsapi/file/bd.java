package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.FileStructStat;
import com.tencent.mm.plugin.appbrand.appstorage.l;
import com.tencent.mm.plugin.appbrand.appstorage.p;
import com.tencent.mm.plugin.appbrand.appstorage.v;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

final class bd
  extends g
{
  private static Map<String, Object> a(FileStructStat paramFileStructStat, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(128928);
    paramMap.put("mode", Integer.valueOf(paramFileStructStat.st_mode));
    paramMap.put("size", Long.valueOf(paramFileStructStat.st_size));
    paramMap.put("lastAccessedTime", Long.valueOf(paramFileStructStat.st_atime));
    paramMap.put("lastModifiedTime", Long.valueOf(paramFileStructStat.st_mtime));
    AppMethodBeat.o(128928);
    return paramMap;
  }
  
  private static i.a g(c paramc, String paramString)
  {
    AppMethodBeat.i(128927);
    Object localObject = new LinkedList();
    paramc = paramc.Fg().g(paramString, (List)localObject);
    switch (1.kMS[paramc.ordinal()])
    {
    default: 
      paramc = new i.a("fail " + paramc.name(), new Object[0]);
      AppMethodBeat.o(128927);
      return paramc;
    }
    paramc = new i.a("ok", new Object[0]);
    paramString = ((List)localObject).iterator();
    while (paramString.hasNext())
    {
      localObject = (v)paramString.next();
      paramc.q(((v)localObject).jNe, a((FileStructStat)localObject, new HashMap()));
    }
    AppMethodBeat.o(128927);
    return paramc;
  }
  
  final i.a a(c paramc, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(128926);
    boolean bool = paramJSONObject.optBoolean("recursive", false);
    paramJSONObject = new FileStructStat();
    l locall = paramc.Fg().a(paramString, paramJSONObject);
    switch (1.kMS[locall.ordinal()])
    {
    default: 
      paramc = new i.a("fail " + locall.name(), new Object[0]);
      AppMethodBeat.o(128926);
      return paramc;
    case 1: 
      if ((!paramJSONObject.isDirectory()) || (!bool))
      {
        paramc = new i.a("ok", new Object[0]).D(a(paramJSONObject, new HashMap()));
        AppMethodBeat.o(128926);
        return paramc;
      }
      paramc = g(paramc, paramString);
      AppMethodBeat.o(128926);
      return paramc;
    case 2: 
    case 3: 
      paramc = new i.a("fail no such file or directory \"%s\"", new Object[] { paramString });
      AppMethodBeat.o(128926);
      return paramc;
    }
    paramc = new i.a("fail permission denied, open \"%s\"", new Object[] { paramString });
    AppMethodBeat.o(128926);
    return paramc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.bd
 * JD-Core Version:    0.7.0.1
 */