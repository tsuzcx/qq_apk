package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.luggage.k.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.utils.z;
import com.tencent.mm.plugin.appbrand.utils.z.a;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.ByteArrayInputStream;
import java.nio.ByteBuffer;
import java.util.Map;
import org.json.JSONObject;

class bl
  extends g
{
  i.a a(e parame, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(128935);
    boolean bool = paramJSONObject.optBoolean("append", false);
    String str = paramJSONObject.optString("encoding");
    z.a(parame.getJsRuntime(), null, paramJSONObject, (z.a)parame.au(z.a.class));
    Object localObject = paramJSONObject.opt("data");
    if ((localObject instanceof String)) {
      if (Util.isNullOrNil(str)) {
        paramJSONObject = (h)h.a.oRM.get("utf8");
      }
    }
    for (;;)
    {
      try
      {
        paramJSONObject = paramJSONObject.ahA((String)localObject);
        paramJSONObject = new a(paramJSONObject);
        parame = parame.getFileSystem().a(paramString, paramJSONObject, bool);
        switch (1.oSw[parame.ordinal()])
        {
        default: 
          parame = new i.a("fail " + parame.name(), new Object[0]);
          AppMethodBeat.o(128935);
          return parame;
        }
      }
      catch (Exception parame)
      {
        parame = new i.a("fail " + parame.getMessage(), new Object[0]);
        AppMethodBeat.o(128935);
        return parame;
      }
      paramJSONObject = (h)h.a.oRM.get(str.toLowerCase());
      if (paramJSONObject == null)
      {
        parame = new i.a("fail invalid encoding", new Object[0]);
        AppMethodBeat.o(128935);
        return parame;
        if ((localObject instanceof ByteBuffer))
        {
          paramJSONObject = new a((ByteBuffer)localObject);
        }
        else if (localObject == null)
        {
          if (bool)
          {
            parame = new i.a("ok", new Object[0]);
            AppMethodBeat.o(128935);
            return parame;
          }
          paramJSONObject = new ByteArrayInputStream(new byte[0]);
        }
        else
        {
          parame = new i.a("fail invalid data", new Object[0]);
          AppMethodBeat.o(128935);
          return parame;
          parame = new i.a("fail no such file or directory, open \"%s\"", new Object[] { paramString });
          AppMethodBeat.o(128935);
          return parame;
          parame = new i.a("fail no such file \"%s\"", new Object[] { paramString });
          AppMethodBeat.o(128935);
          return parame;
          parame = new i.a("fail illegal operation on a directory, open \"%s\"", new Object[] { paramString });
          AppMethodBeat.o(128935);
          return parame;
          parame = new i.a("fail permission denied, open \"%s\"", new Object[] { paramString });
          AppMethodBeat.o(128935);
          return parame;
          parame = new i.a("fail \"%s\" is not a regular file", new Object[] { paramString });
          AppMethodBeat.o(128935);
          return parame;
          parame = new i.a("fail the maximum size of the file storage limit is exceeded", new Object[0]);
          AppMethodBeat.o(128935);
          return parame;
          parame = new i.a("ok", new Object[0]);
          AppMethodBeat.o(128935);
          return parame;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.bl
 * JD-Core Version:    0.7.0.1
 */