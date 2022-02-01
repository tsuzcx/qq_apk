package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.luggage.h.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.i;
import com.tencent.mm.plugin.appbrand.appstorage.k;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

final class bb
  extends g
{
  final i.a a(f paramf, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(128917);
    paramJSONObject = new LinkedList();
    i locali = new i();
    paramf = paramf.getFileSystem().a(paramString, locali);
    b.c(paramJSONObject, (List)locali.value);
    switch (1.lVs[paramf.ordinal()])
    {
    default: 
      paramf = new i.a("fail " + paramf.name(), new Object[0]);
      AppMethodBeat.o(128917);
      return paramf;
    case 1: 
    case 2: 
      paramf = new i.a("fail no such file or directory \"%s\"", new Object[] { paramString });
      AppMethodBeat.o(128917);
      return paramf;
    case 3: 
      paramf = new i.a("fail not a directory \"%s\"", new Object[] { paramString });
      AppMethodBeat.o(128917);
      return paramf;
    case 4: 
      paramf = new i.a("fail permission denied, open \"%s\"", new Object[] { paramString });
      AppMethodBeat.o(128917);
      return paramf;
    case 5: 
      paramf = new i.a("fail \"%s\" is not a regular file", new Object[] { paramString });
      AppMethodBeat.o(128917);
      return paramf;
    }
    paramf = new JSONArray();
    paramString = paramJSONObject.iterator();
    while (paramString.hasNext()) {
      paramf.put(((k)paramString.next()).fileName);
    }
    paramf = new i.a("ok", new Object[0]).q("files", paramf);
    AppMethodBeat.o(128917);
    return paramf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.bb
 * JD-Core Version:    0.7.0.1
 */