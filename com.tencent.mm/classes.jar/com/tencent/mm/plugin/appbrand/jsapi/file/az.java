package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.k;
import com.tencent.mm.plugin.appbrand.appstorage.o;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vfs.b;
import com.tencent.mm.vfs.e;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.WritableByteChannel;
import org.json.JSONObject;

final class az
  extends f
{
  protected final String D(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(102841);
    paramJSONObject = paramJSONObject.optString("zipFilePath");
    AppMethodBeat.o(102841);
    return paramJSONObject;
  }
  
  final h.a a(c paramc, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(102840);
    String str = paramJSONObject.optString("targetDirectory", "");
    paramJSONObject = paramc.wX().ze(str);
    switch (az.1.hMg[paramJSONObject.ordinal()])
    {
    default: 
      paramJSONObject = paramc.wX().zg(paramString);
      if ((paramJSONObject == null) || (!paramJSONObject.exists()))
      {
        if (paramc.wX().zd(paramString) != com.tencent.mm.plugin.appbrand.appstorage.j.gZA) {
          break label643;
        }
        localObject = paramc.wX().zh(URLEncoder.encode(paramString));
        if (localObject == null) {
          break label643;
        }
        paramJSONObject = new com.tencent.mm.plugin.appbrand.s.j();
        paramc.wX().b(paramString, paramJSONObject);
      }
      break;
    case 1: 
    case 2: 
    case 3: 
      try
      {
        Channels.newChannel(e.r((b)localObject)).write((ByteBuffer)paramJSONObject.value);
        paramJSONObject = new File(com.tencent.mm.vfs.j.p(((b)localObject).dQJ()));
        i = 1;
      }
      catch (IOException paramJSONObject)
      {
        for (;;)
        {
          ab.e("MicroMsg.AppBrand.FileSystem.UnitUnzip", "copy ByteBuffer failed e = %s", new Object[] { paramJSONObject });
          paramJSONObject = null;
          i = 0;
        }
      }
      localObject = paramJSONObject;
      if (paramJSONObject != null) {
        break label324;
      }
      paramc = new h.a("fail no such file \"%s\"", new Object[] { paramString });
      AppMethodBeat.o(102840);
      return paramc;
      paramc = new h.a(String.format("fail permission denied, open \"%s\"", new Object[] { str }), new Object[0]);
      AppMethodBeat.o(102840);
      return paramc;
    }
    if ((paramJSONObject.isDirectory()) || (k.C(paramJSONObject)))
    {
      paramc = new h.a("fail permission denied, open \"%s\"", new Object[] { paramString });
      AppMethodBeat.o(102840);
      return paramc;
    }
    int i = 0;
    Object localObject = paramJSONObject;
    for (;;)
    {
      try
      {
        label324:
        paramc = paramc.wX().b(str, (File)localObject);
        if (i != 0) {
          e.deleteFile(((File)localObject).getAbsolutePath());
        }
        switch (az.1.hMg[paramc.ordinal()])
        {
        case 2: 
        case 3: 
          paramc = new h.a("fail " + paramc.name(), new Object[0]);
          AppMethodBeat.o(102840);
          return paramc;
        }
      }
      catch (Exception paramc)
      {
        ab.printErrStackTrace("MicroMsg.AppBrand.FileSystem.UnitUnzip", paramc, "write zip stream", new Object[0]);
        paramc = new h.a("fail read zip data", new Object[0]);
        AppMethodBeat.o(102840);
        return paramc;
      }
      paramc = new h.a("fail no such file or directory, open \"%s\"", new Object[] { paramString });
      AppMethodBeat.o(102840);
      return paramc;
      paramc = new h.a("fail illegal operation on a filePath, open \"%s\"", new Object[] { paramString });
      AppMethodBeat.o(102840);
      return paramc;
      paramc = new h.a("fail permission denied, open \"%s\"", new Object[] { paramString });
      AppMethodBeat.o(102840);
      return paramc;
      paramc = new h.a("fail the maximum size of the file storage limit is exceeded", new Object[0]);
      AppMethodBeat.o(102840);
      return paramc;
      paramc = new h.a("fail read zip data", new Object[0]);
      AppMethodBeat.o(102840);
      return paramc;
      paramc = new h.a("fail write entry", new Object[0]);
      AppMethodBeat.o(102840);
      return paramc;
      paramc = new h.a("ok", new Object[0]);
      AppMethodBeat.o(102840);
      return paramc;
      label643:
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.az
 * JD-Core Version:    0.7.0.1
 */