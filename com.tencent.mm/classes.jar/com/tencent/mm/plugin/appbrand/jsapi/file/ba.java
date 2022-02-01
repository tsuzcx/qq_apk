package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.luggage.k.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.i;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.appstorage.o;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.q;
import java.nio.ByteBuffer;
import java.util.Locale;
import org.json.JSONObject;

final class ba
  extends g
{
  protected final String Z(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(128911);
    paramJSONObject = paramJSONObject.optString("srcPath");
    AppMethodBeat.o(128911);
    return paramJSONObject;
  }
  
  final i.a a(e parame, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(128910);
    paramJSONObject = paramJSONObject.optString("destPath");
    String str1 = String.format(Locale.US, "fail no such file or directory, copyFile \"%s\" -> \"%s\"", new Object[] { paramString, paramJSONObject });
    String str2 = String.format(Locale.US, "fail permission denied, copyFile \"%s\" -> \"%s\"", new Object[] { paramString, paramJSONObject });
    Object localObject = parame.getFileSystem().adL(paramString);
    boolean bool = parame.getFileSystem().adJ(paramString);
    if ((localObject == null) || (!((q)localObject).ifE()) || (!((q)localObject).ifH()))
    {
      if (!bool)
      {
        parame = new i.a(str2, new Object[0]);
        AppMethodBeat.o(128910);
        return parame;
      }
      localObject = new i();
      parame.getFileSystem().b(paramString, (i)localObject);
      if (((i)localObject).value == null)
      {
        parame = new i.a(str1, new Object[0]);
        AppMethodBeat.o(128910);
        return parame;
      }
      paramString = new a((ByteBuffer)((i)localObject).value);
      parame = parame.getFileSystem().a(paramJSONObject, paramString, false);
      Util.qualityClose(paramString);
    }
    for (;;)
    {
      switch (1.oSw[parame.ordinal()])
      {
      default: 
        parame = new i.a("fail " + parame.name(), new Object[0]);
        AppMethodBeat.o(128910);
        return parame;
        if (o.t((q)localObject))
        {
          parame = new i.a("fail \"%s\" not a regular file", new Object[] { paramString });
          AppMethodBeat.o(128910);
          return parame;
        }
        parame = parame.getFileSystem().a(paramJSONObject, (q)localObject, false);
      }
    }
    parame = new i.a(str2, new Object[0]);
    AppMethodBeat.o(128910);
    return parame;
    parame = new i.a(str1, new Object[0]);
    AppMethodBeat.o(128910);
    return parame;
    parame = new i.a("fail sdcard not mounted", new Object[0]);
    AppMethodBeat.o(128910);
    return parame;
    parame = new i.a("fail illegal operation on a directory, open \"%s\"", new Object[] { paramJSONObject });
    AppMethodBeat.o(128910);
    return parame;
    parame = new i.a("fail \"%s\" is not a regular file", new Object[] { paramJSONObject });
    AppMethodBeat.o(128910);
    return parame;
    parame = new i.a("fail the maximum size of the file storage limit is exceeded", new Object[0]);
    AppMethodBeat.o(128910);
    return parame;
    parame = new i.a("ok", new Object[0]);
    AppMethodBeat.o(128910);
    return parame;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.ba
 * JD-Core Version:    0.7.0.1
 */