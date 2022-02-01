package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.luggage.h.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.appstorage.n;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.y.i;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.k;
import java.nio.ByteBuffer;
import java.util.Locale;
import org.json.JSONObject;

final class ay
  extends g
{
  protected final String M(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(128911);
    paramJSONObject = paramJSONObject.optString("srcPath");
    AppMethodBeat.o(128911);
    return paramJSONObject;
  }
  
  final i.a a(c paramc, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(128910);
    paramJSONObject = paramJSONObject.optString("destPath");
    String str1 = String.format(Locale.US, "fail no such file or directory, copyFile \"%s\" -> \"%s\"", new Object[] { paramString, paramJSONObject });
    String str2 = String.format(Locale.US, "fail permission denied, copyFile \"%s\" -> \"%s\"", new Object[] { paramString, paramJSONObject });
    Object localObject = paramc.Fl().MP(paramString);
    boolean bool = paramc.Fl().MN(paramString);
    if ((localObject == null) || (!((k)localObject).exists()) || (!((k)localObject).isFile()))
    {
      if (!bool)
      {
        paramc = new i.a(str2, new Object[0]);
        AppMethodBeat.o(128910);
        return paramc;
      }
      localObject = new i();
      paramc.Fl().b(paramString, (i)localObject);
      if (((i)localObject).value == null)
      {
        paramc = new i.a(str1, new Object[0]);
        AppMethodBeat.o(128910);
        return paramc;
      }
      paramString = new a((ByteBuffer)((i)localObject).value);
      paramc = paramc.Fl().a(paramJSONObject, paramString, false);
      bu.d(paramString);
    }
    for (;;)
    {
      switch (1.kQn[paramc.ordinal()])
      {
      default: 
        paramc = new i.a("fail " + paramc.name(), new Object[0]);
        AppMethodBeat.o(128910);
        return paramc;
        if (n.v((k)localObject))
        {
          paramc = new i.a("fail \"%s\" not a regular file", new Object[] { paramString });
          AppMethodBeat.o(128910);
          return paramc;
        }
        paramc = paramc.Fl().a(paramJSONObject, (k)localObject, false);
      }
    }
    paramc = new i.a(str2, new Object[0]);
    AppMethodBeat.o(128910);
    return paramc;
    paramc = new i.a(str1, new Object[0]);
    AppMethodBeat.o(128910);
    return paramc;
    paramc = new i.a("fail sdcard not mounted", new Object[0]);
    AppMethodBeat.o(128910);
    return paramc;
    paramc = new i.a("fail illegal operation on a directory, open \"%s\"", new Object[] { paramJSONObject });
    AppMethodBeat.o(128910);
    return paramc;
    paramc = new i.a("fail \"%s\" is not a regular file", new Object[] { paramJSONObject });
    AppMethodBeat.o(128910);
    return paramc;
    paramc = new i.a("fail the maximum size of the file storage limit is exceeded", new Object[0]);
    AppMethodBeat.o(128910);
    return paramc;
    paramc = new i.a("ok", new Object[0]);
    AppMethodBeat.o(128910);
    return paramc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.ay
 * JD-Core Version:    0.7.0.1
 */