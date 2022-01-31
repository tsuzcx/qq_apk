package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.j;
import com.tencent.mm.plugin.appbrand.appstorage.k;
import com.tencent.mm.plugin.appbrand.appstorage.o;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import java.io.File;
import java.util.Locale;
import org.json.JSONObject;

final class av
  extends f
{
  protected final String D(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(102830);
    paramJSONObject = paramJSONObject.optString("oldPath");
    AppMethodBeat.o(102830);
    return paramJSONObject;
  }
  
  final h.a a(c paramc, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(102829);
    String str2 = paramJSONObject.optString("newPath");
    paramJSONObject = String.format(Locale.US, "fail no such file or directory, rename \"%s\" -> \"%s\"", new Object[] { paramString, str2 });
    String str1 = String.format(Locale.US, "fail permission denied, rename \"%s\" -> \"%s\"", new Object[] { paramString, str2 });
    File localFile = paramc.wX().aa(paramString, true);
    if ((localFile == null) || (!localFile.exists()))
    {
      paramc = new h.a(paramJSONObject, new Object[0]);
      AppMethodBeat.o(102829);
      return paramc;
    }
    if (k.C(localFile))
    {
      paramc = new h.a("fail \"%s\" not a regular file", new Object[] { paramString });
      AppMethodBeat.o(102829);
      return paramc;
    }
    paramc = paramc.wX().a(str2, localFile, true);
    switch (av.1.hMg[paramc.ordinal()])
    {
    default: 
      paramc = new h.a("fail " + paramc.name(), new Object[0]);
      AppMethodBeat.o(102829);
      return paramc;
    case 1: 
      paramc = new h.a(str1, new Object[0]);
      AppMethodBeat.o(102829);
      return paramc;
    case 2: 
      paramc = new h.a(paramJSONObject, new Object[0]);
      AppMethodBeat.o(102829);
      return paramc;
    case 3: 
      paramc = new h.a("fail sdcard not mounted", new Object[0]);
      AppMethodBeat.o(102829);
      return paramc;
    }
    paramc = new h.a("ok", new Object[0]);
    AppMethodBeat.o(102829);
    return paramc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.av
 * JD-Core Version:    0.7.0.1
 */