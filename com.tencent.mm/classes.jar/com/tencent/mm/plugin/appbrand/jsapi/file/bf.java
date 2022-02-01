package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.af.k;
import com.tencent.mm.plugin.appbrand.appstorage.BrotliJNI;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import com.tencent.mm.plugin.appbrand.appstorage.w;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.ByteBuffer;
import org.json.JSONObject;

final class bf
  extends g
{
  final i.a a(f paramf, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(329076);
    if (paramf.getFileSystem() == null)
    {
      paramf = new i.a("fail no file system", new Object[0]);
      AppMethodBeat.o(329076);
      return paramf;
    }
    paramJSONObject = paramJSONObject.optString("compressionAlgorithm");
    Log.i("MicroMsg.AppBrand.UnitReadCompressedFile", "call, path %s, compressionAlgorithm %s", new Object[] { paramString, paramJSONObject });
    k localk = new k();
    paramf = paramf.getFileSystem().b(paramString, localk);
    if (paramf == r.qML)
    {
      paramf = localk.value;
      if (paramJSONObject.equals("br"))
      {
        paramf = BrotliJNI.decompress((ByteBuffer)localk.value);
        if (paramf == null)
        {
          paramf = new i.a("fail brotli decompress file \"%s\"", new Object[] { paramString });
          AppMethodBeat.o(329076);
          return paramf;
        }
        paramString = ByteBuffer.allocateDirect(paramf.length);
        paramString.put(paramf);
        paramf = new i.a("ok", new Object[0]).x("data", paramString);
        AppMethodBeat.o(329076);
        return paramf;
      }
      paramf = new i.a("fail invalid compressionAlgorithm \"%s\"", new Object[] { paramJSONObject });
      AppMethodBeat.o(329076);
      return paramf;
    }
    switch (1.rXN[paramf.ordinal()])
    {
    default: 
      paramf = new i.a("fail " + paramf.name(), new Object[0]);
      AppMethodBeat.o(329076);
      return paramf;
    case 1: 
      paramf = new i.a("fail no such file \"%s\"", new Object[] { paramString });
      AppMethodBeat.o(329076);
      return paramf;
    case 2: 
      paramf = new i.a("fail permission denied, open \"%s\"", new Object[] { paramString });
      AppMethodBeat.o(329076);
      return paramf;
    }
    paramf = new i.a("fail \"%s\" is not a regular file", new Object[] { paramString });
    AppMethodBeat.o(329076);
    return paramf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.bf
 * JD-Core Version:    0.7.0.1
 */