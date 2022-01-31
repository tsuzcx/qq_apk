package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.luggage.g.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.j;
import com.tencent.mm.plugin.appbrand.appstorage.o;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.t.q;
import com.tencent.mm.plugin.appbrand.t.q.a;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.ByteArrayInputStream;
import java.nio.ByteBuffer;
import java.util.Map;
import org.json.JSONObject;

class ba
  extends f
{
  h.a a(c paramc, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(102843);
    boolean bool = paramJSONObject.optBoolean("append", false);
    String str = paramJSONObject.optString("encoding");
    q.a(paramc.aAO(), paramJSONObject, (q.a)paramc.U(q.a.class));
    Object localObject = paramJSONObject.opt("data");
    if ((localObject instanceof String)) {
      if (bo.isNullOrNil(str)) {
        paramJSONObject = (g)g.a.hLT.get("utf8");
      }
    }
    for (;;)
    {
      try
      {
        paramJSONObject = paramJSONObject.BZ((String)localObject);
        paramJSONObject = new a(paramJSONObject);
        paramc = paramc.wX().a(paramString, paramJSONObject, bool);
        switch (ba.1.hMg[paramc.ordinal()])
        {
        default: 
          paramc = new h.a("fail " + paramc.name(), new Object[0]);
          AppMethodBeat.o(102843);
          return paramc;
        }
      }
      catch (Exception paramc)
      {
        paramc = new h.a("fail " + paramc.getMessage(), new Object[0]);
        AppMethodBeat.o(102843);
        return paramc;
      }
      paramJSONObject = (g)g.a.hLT.get(str.toLowerCase());
      if (paramJSONObject == null)
      {
        paramc = new h.a("fail invalid encoding", new Object[0]);
        AppMethodBeat.o(102843);
        return paramc;
        if ((localObject instanceof ByteBuffer))
        {
          paramJSONObject = new a((ByteBuffer)localObject);
        }
        else if (localObject == null)
        {
          if (bool)
          {
            paramc = new h.a("ok", new Object[0]);
            AppMethodBeat.o(102843);
            return paramc;
          }
          paramJSONObject = new ByteArrayInputStream(new byte[0]);
        }
        else
        {
          paramc = new h.a("fail invalid data", new Object[0]);
          AppMethodBeat.o(102843);
          return paramc;
          paramc = new h.a("fail no such file or directory, open \"%s\"", new Object[] { paramString });
          AppMethodBeat.o(102843);
          return paramc;
          paramc = new h.a("fail no such file \"%s\"", new Object[] { paramString });
          AppMethodBeat.o(102843);
          return paramc;
          paramc = new h.a("fail illegal operation on a directory, open \"%s\"", new Object[] { paramString });
          AppMethodBeat.o(102843);
          return paramc;
          paramc = new h.a("fail permission denied, open \"%s\"", new Object[] { paramString });
          AppMethodBeat.o(102843);
          return paramc;
          paramc = new h.a("fail \"%s\" is not a regular file", new Object[] { paramString });
          AppMethodBeat.o(102843);
          return paramc;
          paramc = new h.a("fail the maximum size of the file storage limit is exceeded", new Object[0]);
          AppMethodBeat.o(102843);
          return paramc;
          paramc = new h.a("ok", new Object[0]);
          AppMethodBeat.o(102843);
          return paramc;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.ba
 * JD-Core Version:    0.7.0.1
 */