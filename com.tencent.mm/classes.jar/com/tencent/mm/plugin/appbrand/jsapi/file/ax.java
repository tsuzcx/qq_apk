package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.FileStructStat;
import com.tencent.mm.plugin.appbrand.appstorage.j;
import com.tencent.mm.plugin.appbrand.appstorage.o;
import com.tencent.mm.plugin.appbrand.appstorage.u;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

final class ax
  extends f
{
  private static Map<String, Object> a(FileStructStat paramFileStructStat, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(102836);
    paramMap.put("mode", Integer.valueOf(paramFileStructStat.st_mode));
    paramMap.put("size", Long.valueOf(paramFileStructStat.st_size));
    paramMap.put("lastAccessedTime", Long.valueOf(paramFileStructStat.st_atime));
    paramMap.put("lastModifiedTime", Long.valueOf(paramFileStructStat.st_mtime));
    AppMethodBeat.o(102836);
    return paramMap;
  }
  
  private static h.a h(c paramc, String paramString)
  {
    AppMethodBeat.i(102835);
    Object localObject = new LinkedList();
    paramc = paramc.wX().h(paramString, (List)localObject);
    switch (1.hMg[paramc.ordinal()])
    {
    default: 
      paramc = new h.a("fail " + paramc.name(), new Object[0]);
      AppMethodBeat.o(102835);
      return paramc;
    }
    paramc = new h.a("ok", new Object[0]);
    paramString = ((List)localObject).iterator();
    while (paramString.hasNext())
    {
      localObject = (u)paramString.next();
      paramc.n(((u)localObject).haf, a((FileStructStat)localObject, new HashMap()));
    }
    AppMethodBeat.o(102835);
    return paramc;
  }
  
  final h.a a(c paramc, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(102834);
    boolean bool = paramJSONObject.optBoolean("recursive", false);
    paramJSONObject = new FileStructStat();
    j localj = paramc.wX().a(paramString, paramJSONObject);
    switch (1.hMg[localj.ordinal()])
    {
    default: 
      paramc = new h.a("fail " + localj.name(), new Object[0]);
      AppMethodBeat.o(102834);
      return paramc;
    case 1: 
      if ((!paramJSONObject.isDirectory()) || (!bool))
      {
        paramc = new h.a("ok", new Object[0]).z(a(paramJSONObject, new HashMap()));
        AppMethodBeat.o(102834);
        return paramc;
      }
      paramc = h(paramc, paramString);
      AppMethodBeat.o(102834);
      return paramc;
    case 2: 
    case 3: 
      paramc = new h.a("fail no such file or directory \"%s\"", new Object[] { paramString });
      AppMethodBeat.o(102834);
      return paramc;
    }
    paramc = new h.a("fail permission denied, open \"%s\"", new Object[] { paramString });
    AppMethodBeat.o(102834);
    return paramc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.ax
 * JD-Core Version:    0.7.0.1
 */