package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.luggage.h.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.utils.x;
import com.tencent.mm.plugin.appbrand.utils.x.a;
import com.tencent.mm.sdk.platformtools.bu;
import java.io.ByteArrayInputStream;
import java.nio.ByteBuffer;
import java.util.Map;
import org.json.JSONObject;

class bi
  extends g
{
  i.a a(c paramc, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(128935);
    boolean bool = paramJSONObject.optBoolean("append", false);
    String str = paramJSONObject.optString("encoding");
    x.a(paramc.aYB(), null, paramJSONObject, (x.a)paramc.ar(x.a.class));
    Object localObject = paramJSONObject.opt("data");
    if ((localObject instanceof String)) {
      if (bu.isNullOrNil(str)) {
        paramJSONObject = (h)h.a.kPP.get("utf8");
      }
    }
    for (;;)
    {
      try
      {
        paramJSONObject = paramJSONObject.Qk((String)localObject);
        paramJSONObject = new a(paramJSONObject);
        paramc = paramc.Fl().a(paramString, paramJSONObject, bool);
        switch (1.kQn[paramc.ordinal()])
        {
        default: 
          paramc = new i.a("fail " + paramc.name(), new Object[0]);
          AppMethodBeat.o(128935);
          return paramc;
        }
      }
      catch (Exception paramc)
      {
        paramc = new i.a("fail " + paramc.getMessage(), new Object[0]);
        AppMethodBeat.o(128935);
        return paramc;
      }
      paramJSONObject = (h)h.a.kPP.get(str.toLowerCase());
      if (paramJSONObject == null)
      {
        paramc = new i.a("fail invalid encoding", new Object[0]);
        AppMethodBeat.o(128935);
        return paramc;
        if ((localObject instanceof ByteBuffer))
        {
          paramJSONObject = new a((ByteBuffer)localObject);
        }
        else if (localObject == null)
        {
          if (bool)
          {
            paramc = new i.a("ok", new Object[0]);
            AppMethodBeat.o(128935);
            return paramc;
          }
          paramJSONObject = new ByteArrayInputStream(new byte[0]);
        }
        else
        {
          paramc = new i.a("fail invalid data", new Object[0]);
          AppMethodBeat.o(128935);
          return paramc;
          paramc = new i.a("fail no such file or directory, open \"%s\"", new Object[] { paramString });
          AppMethodBeat.o(128935);
          return paramc;
          paramc = new i.a("fail no such file \"%s\"", new Object[] { paramString });
          AppMethodBeat.o(128935);
          return paramc;
          paramc = new i.a("fail illegal operation on a directory, open \"%s\"", new Object[] { paramString });
          AppMethodBeat.o(128935);
          return paramc;
          paramc = new i.a("fail permission denied, open \"%s\"", new Object[] { paramString });
          AppMethodBeat.o(128935);
          return paramc;
          paramc = new i.a("fail \"%s\" is not a regular file", new Object[] { paramString });
          AppMethodBeat.o(128935);
          return paramc;
          paramc = new i.a("fail the maximum size of the file storage limit is exceeded", new Object[0]);
          AppMethodBeat.o(128935);
          return paramc;
          paramc = new i.a("ok", new Object[0]);
          AppMethodBeat.o(128935);
          return paramc;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.bi
 * JD-Core Version:    0.7.0.1
 */