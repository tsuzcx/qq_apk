package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.luggage.l.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.af.k;
import com.tencent.mm.plugin.appbrand.appstorage.p;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import com.tencent.mm.plugin.appbrand.appstorage.w;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

final class bg
  extends g
{
  final i.a a(f paramf, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(128917);
    paramJSONObject = new LinkedList();
    k localk = new k();
    paramf = paramf.getFileSystem().a(paramString, localk);
    b.h(paramJSONObject, (List)localk.value);
    switch (1.rXN[paramf.ordinal()])
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
      paramf.put(((p)paramString.next()).fileName);
    }
    paramf = new i.a("ok", new Object[0]).x("files", paramf);
    AppMethodBeat.o(128917);
    return paramf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.bg
 * JD-Core Version:    0.7.0.1
 */