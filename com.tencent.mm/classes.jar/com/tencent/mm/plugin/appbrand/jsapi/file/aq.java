package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.luggage.g.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.k;
import com.tencent.mm.plugin.appbrand.appstorage.o;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.Locale;
import org.json.JSONObject;

final class aq
  extends f
{
  protected final String D(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(102819);
    paramJSONObject = paramJSONObject.optString("srcPath");
    AppMethodBeat.o(102819);
    return paramJSONObject;
  }
  
  final h.a a(c paramc, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(102818);
    paramJSONObject = paramJSONObject.optString("destPath");
    String str1 = String.format(Locale.US, "fail no such file or directory, copyFile \"%s\" -> \"%s\"", new Object[] { paramString, paramJSONObject });
    String str2 = String.format(Locale.US, "fail permission denied, copyFile \"%s\" -> \"%s\"", new Object[] { paramString, paramJSONObject });
    Object localObject = paramc.wX().zg(paramString);
    if ((localObject == null) || (!((File)localObject).exists()) || (!((File)localObject).isFile()))
    {
      localObject = new com.tencent.mm.plugin.appbrand.s.j();
      paramc.wX().b(paramString, (com.tencent.mm.plugin.appbrand.s.j)localObject);
      if (((com.tencent.mm.plugin.appbrand.s.j)localObject).value == null)
      {
        paramc = new h.a(str1, new Object[0]);
        AppMethodBeat.o(102818);
        return paramc;
      }
      paramString = new a((ByteBuffer)((com.tencent.mm.plugin.appbrand.s.j)localObject).value);
      paramc = paramc.wX().a(paramJSONObject, paramString, false);
      bo.b(paramString);
    }
    for (;;)
    {
      switch (aq.1.hMg[paramc.ordinal()])
      {
      default: 
        paramc = new h.a("fail " + paramc.name(), new Object[0]);
        AppMethodBeat.o(102818);
        return paramc;
        if (k.C((File)localObject))
        {
          paramc = new h.a("fail \"%s\" not a regular file", new Object[] { paramString });
          AppMethodBeat.o(102818);
          return paramc;
        }
        paramc = paramc.wX().a(paramJSONObject, (File)localObject, false);
      }
    }
    paramc = new h.a(str2, new Object[0]);
    AppMethodBeat.o(102818);
    return paramc;
    paramc = new h.a(str1, new Object[0]);
    AppMethodBeat.o(102818);
    return paramc;
    paramc = new h.a("fail sdcard not mounted", new Object[0]);
    AppMethodBeat.o(102818);
    return paramc;
    paramc = new h.a("fail illegal operation on a directory, open \"%s\"", new Object[] { paramJSONObject });
    AppMethodBeat.o(102818);
    return paramc;
    paramc = new h.a("fail \"%s\" is not a regular file", new Object[] { paramJSONObject });
    AppMethodBeat.o(102818);
    return paramc;
    paramc = new h.a("fail the maximum size of the file storage limit is exceeded", new Object[0]);
    AppMethodBeat.o(102818);
    return paramc;
    paramc = new h.a("ok", new Object[0]);
    AppMethodBeat.o(102818);
    return paramc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.aq
 * JD-Core Version:    0.7.0.1
 */