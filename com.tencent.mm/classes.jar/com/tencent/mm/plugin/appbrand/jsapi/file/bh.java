package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.appstorage.n;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.y.i;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.w;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.WritableByteChannel;
import org.json.JSONObject;

final class bh
  extends g
{
  protected final String M(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(128933);
    paramJSONObject = paramJSONObject.optString("zipFilePath");
    AppMethodBeat.o(128933);
    return paramJSONObject;
  }
  
  final i.a a(c paramc, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(128932);
    String str = paramJSONObject.optString("targetDirectory", "");
    paramJSONObject = paramc.Fl().Mc(str);
    switch (1.kQn[paramJSONObject.ordinal()])
    {
    default: 
      paramJSONObject = paramc.Fl().MP(paramString);
      if ((paramJSONObject == null) || (!paramJSONObject.exists()))
      {
        if (paramc.Fl().Ma(paramString) != m.jPM) {
          break label647;
        }
        localObject = paramc.Fl().MR(URLEncoder.encode(paramString));
        if (localObject == null) {
          break label647;
        }
        paramJSONObject = new i();
        paramc.Fl().b(paramString, paramJSONObject);
      }
      break;
    case 1: 
    case 2: 
    case 3: 
      try
      {
        Channels.newChannel(o.aj((k)localObject)).write((ByteBuffer)paramJSONObject.value);
        paramJSONObject = new k(w.B(((k)localObject).fTh()));
        i = 1;
      }
      catch (IOException paramJSONObject)
      {
        for (;;)
        {
          ae.e("MicroMsg.AppBrand.FileSystem.UnitUnzip", "copy ByteBuffer failed e = %s", new Object[] { paramJSONObject });
          paramJSONObject = null;
          i = 0;
        }
      }
      localObject = paramJSONObject;
      if (paramJSONObject != null) {
        break label324;
      }
      paramc = new i.a("fail no such file \"%s\"", new Object[] { paramString });
      AppMethodBeat.o(128932);
      return paramc;
      paramc = new i.a(String.format("fail permission denied, open \"%s\"", new Object[] { str }), new Object[0]);
      AppMethodBeat.o(128932);
      return paramc;
    }
    if ((paramJSONObject.isDirectory()) || (n.v(paramJSONObject)))
    {
      paramc = new i.a("fail permission denied, open \"%s\"", new Object[] { paramString });
      AppMethodBeat.o(128932);
      return paramc;
    }
    int i = 0;
    Object localObject = paramJSONObject;
    for (;;)
    {
      try
      {
        label324:
        paramc = paramc.Fl().a(str, (k)localObject);
        if (i != 0) {
          o.deleteFile(w.B(((k)localObject).fTh()));
        }
        switch (1.kQn[paramc.ordinal()])
        {
        case 2: 
        case 3: 
          paramc = new i.a("fail " + paramc.name(), new Object[0]);
          AppMethodBeat.o(128932);
          return paramc;
        }
      }
      catch (Exception paramc)
      {
        ae.printErrStackTrace("MicroMsg.AppBrand.FileSystem.UnitUnzip", paramc, "write zip stream", new Object[0]);
        paramc = new i.a("fail read zip data", new Object[0]);
        AppMethodBeat.o(128932);
        return paramc;
      }
      paramc = new i.a("fail no such file or directory, open \"%s\"", new Object[] { paramString });
      AppMethodBeat.o(128932);
      return paramc;
      paramc = new i.a("fail illegal operation on a filePath, open \"%s\"", new Object[] { paramString });
      AppMethodBeat.o(128932);
      return paramc;
      paramc = new i.a("fail permission denied, open \"%s\"", new Object[] { paramString });
      AppMethodBeat.o(128932);
      return paramc;
      paramc = new i.a("fail the maximum size of the file storage limit is exceeded", new Object[0]);
      AppMethodBeat.o(128932);
      return paramc;
      paramc = new i.a("fail read zip data", new Object[0]);
      AppMethodBeat.o(128932);
      return paramc;
      paramc = new i.a("fail write entry", new Object[0]);
      AppMethodBeat.o(128932);
      return paramc;
      paramc = new i.a("ok", new Object[0]);
      AppMethodBeat.o(128932);
      return paramc;
      label647:
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.bh
 * JD-Core Version:    0.7.0.1
 */