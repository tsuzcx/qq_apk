package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.luggage.h.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.utils.x;
import com.tencent.mm.plugin.appbrand.utils.x.a;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.ByteArrayInputStream;
import java.nio.ByteBuffer;
import java.util.Map;
import org.json.JSONObject;

class bi
  extends g
{
  i.a a(f paramf, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(128935);
    boolean bool = paramJSONObject.optBoolean("append", false);
    String str = paramJSONObject.optString("encoding");
    x.a(paramf.getJsRuntime(), null, paramJSONObject, (x.a)paramf.av(x.a.class));
    Object localObject = paramJSONObject.opt("data");
    if ((localObject instanceof String)) {
      if (Util.isNullOrNil(str)) {
        paramJSONObject = (h)h.a.lUN.get("utf8");
      }
    }
    for (;;)
    {
      try
      {
        paramJSONObject = paramJSONObject.ZL((String)localObject);
        paramJSONObject = new a(paramJSONObject);
        paramf = paramf.getFileSystem().a(paramString, paramJSONObject, bool);
        switch (1.lVs[paramf.ordinal()])
        {
        default: 
          paramf = new i.a("fail " + paramf.name(), new Object[0]);
          AppMethodBeat.o(128935);
          return paramf;
        }
      }
      catch (Exception paramf)
      {
        paramf = new i.a("fail " + paramf.getMessage(), new Object[0]);
        AppMethodBeat.o(128935);
        return paramf;
      }
      paramJSONObject = (h)h.a.lUN.get(str.toLowerCase());
      if (paramJSONObject == null)
      {
        paramf = new i.a("fail invalid encoding", new Object[0]);
        AppMethodBeat.o(128935);
        return paramf;
        if ((localObject instanceof ByteBuffer))
        {
          paramJSONObject = new a((ByteBuffer)localObject);
        }
        else if (localObject == null)
        {
          if (bool)
          {
            paramf = new i.a("ok", new Object[0]);
            AppMethodBeat.o(128935);
            return paramf;
          }
          paramJSONObject = new ByteArrayInputStream(new byte[0]);
        }
        else
        {
          paramf = new i.a("fail invalid data", new Object[0]);
          AppMethodBeat.o(128935);
          return paramf;
          paramf = new i.a("fail no such file or directory, open \"%s\"", new Object[] { paramString });
          AppMethodBeat.o(128935);
          return paramf;
          paramf = new i.a("fail no such file \"%s\"", new Object[] { paramString });
          AppMethodBeat.o(128935);
          return paramf;
          paramf = new i.a("fail illegal operation on a directory, open \"%s\"", new Object[] { paramString });
          AppMethodBeat.o(128935);
          return paramf;
          paramf = new i.a("fail permission denied, open \"%s\"", new Object[] { paramString });
          AppMethodBeat.o(128935);
          return paramf;
          paramf = new i.a("fail \"%s\" is not a regular file", new Object[] { paramString });
          AppMethodBeat.o(128935);
          return paramf;
          paramf = new i.a("fail the maximum size of the file storage limit is exceeded", new Object[0]);
          AppMethodBeat.o(128935);
          return paramf;
          paramf = new i.a("ok", new Object[0]);
          AppMethodBeat.o(128935);
          return paramf;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.bi
 * JD-Core Version:    0.7.0.1
 */