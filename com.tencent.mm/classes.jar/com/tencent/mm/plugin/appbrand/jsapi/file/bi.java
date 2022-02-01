package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.FileStructStat;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import com.tencent.mm.plugin.appbrand.appstorage.z;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

final class bi
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
  
  private static i.a g(e parame, String paramString)
  {
    AppMethodBeat.i(128927);
    Object localObject = new LinkedList();
    parame = parame.getFileSystem().h(paramString, (List)localObject);
    switch (1.oSw[parame.ordinal()])
    {
    default: 
      parame = new i.a("fail " + parame.name(), new Object[0]);
      AppMethodBeat.o(128927);
      return parame;
    }
    parame = new i.a("ok", new Object[0]);
    paramString = ((List)localObject).iterator();
    while (paramString.hasNext())
    {
      localObject = (z)paramString.next();
      parame.p(((z)localObject).nNF, a((FileStructStat)localObject, new HashMap()));
    }
    AppMethodBeat.o(128927);
    return parame;
  }
  
  final i.a a(e parame, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(128926);
    boolean bool = paramJSONObject.optBoolean("recursive", false);
    paramJSONObject = new FileStructStat();
    m localm = parame.getFileSystem().a(paramString, paramJSONObject);
    switch (1.oSw[localm.ordinal()])
    {
    default: 
      parame = new i.a("fail " + localm.name(), new Object[0]);
      AppMethodBeat.o(128926);
      return parame;
    case 1: 
      if ((!paramJSONObject.isDirectory()) || (!bool))
      {
        parame = new i.a("ok", new Object[0]).G(a(paramJSONObject, new HashMap()));
        AppMethodBeat.o(128926);
        return parame;
      }
      parame = g(parame, paramString);
      AppMethodBeat.o(128926);
      return parame;
    case 2: 
    case 3: 
      parame = new i.a("fail no such file or directory \"%s\"", new Object[] { paramString });
      AppMethodBeat.o(128926);
      return parame;
    }
    parame = new i.a("fail permission denied, open \"%s\"", new Object[] { paramString });
    AppMethodBeat.o(128926);
    return parame;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.bi
 * JD-Core Version:    0.7.0.1
 */