package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.FileStructStat;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.appstorage.x;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

final class bf
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
  
  private static i.a g(f paramf, String paramString)
  {
    AppMethodBeat.i(128927);
    Object localObject = new LinkedList();
    paramf = paramf.getFileSystem().h(paramString, (List)localObject);
    switch (1.lVs[paramf.ordinal()])
    {
    default: 
      paramf = new i.a("fail " + paramf.name(), new Object[0]);
      AppMethodBeat.o(128927);
      return paramf;
    }
    paramf = new i.a("ok", new Object[0]);
    paramString = ((List)localObject).iterator();
    while (paramString.hasNext())
    {
      localObject = (x)paramString.next();
      paramf.q(((x)localObject).kTh, a((FileStructStat)localObject, new HashMap()));
    }
    AppMethodBeat.o(128927);
    return paramf;
  }
  
  final i.a a(f paramf, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(128926);
    boolean bool = paramJSONObject.optBoolean("recursive", false);
    paramJSONObject = new FileStructStat();
    m localm = paramf.getFileSystem().a(paramString, paramJSONObject);
    switch (1.lVs[localm.ordinal()])
    {
    default: 
      paramf = new i.a("fail " + localm.name(), new Object[0]);
      AppMethodBeat.o(128926);
      return paramf;
    case 1: 
      if ((!paramJSONObject.isDirectory()) || (!bool))
      {
        paramf = new i.a("ok", new Object[0]).N(a(paramJSONObject, new HashMap()));
        AppMethodBeat.o(128926);
        return paramf;
      }
      paramf = g(paramf, paramString);
      AppMethodBeat.o(128926);
      return paramf;
    case 2: 
    case 3: 
      paramf = new i.a("fail no such file or directory \"%s\"", new Object[] { paramString });
      AppMethodBeat.o(128926);
      return paramf;
    }
    paramf = new i.a("fail permission denied, open \"%s\"", new Object[] { paramString });
    AppMethodBeat.o(128926);
    return paramf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.bf
 * JD-Core Version:    0.7.0.1
 */