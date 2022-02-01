package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.luggage.h.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.i;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.appstorage.n;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import java.nio.ByteBuffer;
import java.util.Locale;
import org.json.JSONObject;

final class ay
  extends g
{
  protected final String V(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(128911);
    paramJSONObject = paramJSONObject.optString("srcPath");
    AppMethodBeat.o(128911);
    return paramJSONObject;
  }
  
  final i.a a(f paramf, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(128910);
    paramJSONObject = paramJSONObject.optString("destPath");
    String str1 = String.format(Locale.US, "fail no such file or directory, copyFile \"%s\" -> \"%s\"", new Object[] { paramString, paramJSONObject });
    String str2 = String.format(Locale.US, "fail permission denied, copyFile \"%s\" -> \"%s\"", new Object[] { paramString, paramJSONObject });
    Object localObject = paramf.getFileSystem().VY(paramString);
    boolean bool = paramf.getFileSystem().VW(paramString);
    if ((localObject == null) || (!((o)localObject).exists()) || (!((o)localObject).isFile()))
    {
      if (!bool)
      {
        paramf = new i.a(str2, new Object[0]);
        AppMethodBeat.o(128910);
        return paramf;
      }
      localObject = new i();
      paramf.getFileSystem().b(paramString, (i)localObject);
      if (((i)localObject).value == null)
      {
        paramf = new i.a(str1, new Object[0]);
        AppMethodBeat.o(128910);
        return paramf;
      }
      paramString = new a((ByteBuffer)((i)localObject).value);
      paramf = paramf.getFileSystem().a(paramJSONObject, paramString, false);
      Util.qualityClose(paramString);
    }
    for (;;)
    {
      switch (1.lVs[paramf.ordinal()])
      {
      default: 
        paramf = new i.a("fail " + paramf.name(), new Object[0]);
        AppMethodBeat.o(128910);
        return paramf;
        if (n.u((o)localObject))
        {
          paramf = new i.a("fail \"%s\" not a regular file", new Object[] { paramString });
          AppMethodBeat.o(128910);
          return paramf;
        }
        paramf = paramf.getFileSystem().a(paramJSONObject, (o)localObject, false);
      }
    }
    paramf = new i.a(str2, new Object[0]);
    AppMethodBeat.o(128910);
    return paramf;
    paramf = new i.a(str1, new Object[0]);
    AppMethodBeat.o(128910);
    return paramf;
    paramf = new i.a("fail sdcard not mounted", new Object[0]);
    AppMethodBeat.o(128910);
    return paramf;
    paramf = new i.a("fail illegal operation on a directory, open \"%s\"", new Object[] { paramJSONObject });
    AppMethodBeat.o(128910);
    return paramf;
    paramf = new i.a("fail \"%s\" is not a regular file", new Object[] { paramJSONObject });
    AppMethodBeat.o(128910);
    return paramf;
    paramf = new i.a("fail the maximum size of the file storage limit is exceeded", new Object[0]);
    AppMethodBeat.o(128910);
    return paramf;
    paramf = new i.a("ok", new Object[0]);
    AppMethodBeat.o(128910);
    return paramf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.ay
 * JD-Core Version:    0.7.0.1
 */