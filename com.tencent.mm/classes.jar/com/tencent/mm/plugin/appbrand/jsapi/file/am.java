package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.i;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.p.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONObject;

public final class am
  extends d
{
  public static final int CTRL_INDEX = 51;
  public static final String NAME = "saveFile";
  
  public static String a(f paramf, o paramo, String paramString, i<String> parami)
  {
    AppMethodBeat.i(170099);
    if ((paramo == null) || (!paramo.exists()))
    {
      AppMethodBeat.o(170099);
      return "fail:file not exists";
    }
    Object localObject2 = paramf.getFileSystem().Vl(paramString);
    Object localObject1 = localObject2;
    if (localObject2 != m.kSu) {}
    try
    {
      localObject2 = new i();
      paramf = paramf.getFileSystem().a(paramo, paramString, (i)localObject2);
      localObject1 = paramf;
      if (parami != null)
      {
        parami.value = ((i)localObject2).value;
        localObject1 = paramf;
      }
      switch (2.lVs[localObject1.ordinal()])
      {
      default: 
        paramf = "fail " + ((m)localObject1).name();
        AppMethodBeat.o(170099);
        return paramf;
      }
    }
    catch (Exception paramf)
    {
      paramf = "fail:writeFile exception: " + paramf.toString();
      AppMethodBeat.o(170099);
      return paramf;
    }
    paramf = String.format("fail permission denied, open \"%s\"", new Object[] { paramString });
    AppMethodBeat.o(170099);
    return paramf;
    paramf = String.format("fail no such file or directory \"%s\"", new Object[] { paramString });
    AppMethodBeat.o(170099);
    return paramf;
    paramf = String.format("fail illegal operation on a directory, open \"%s\"", new Object[] { paramString });
    AppMethodBeat.o(170099);
    return paramf;
    AppMethodBeat.o(170099);
    return "fail the maximum size of the file storage limit is exceeded";
    AppMethodBeat.o(170099);
    return "ok";
  }
  
  static p.a f(f paramf, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(128899);
    Object localObject2 = paramJSONObject.optString("tempFilePath");
    Object localObject1 = paramJSONObject.optString("filePath");
    if (Util.isNullOrNil((String)localObject2))
    {
      Log.e("MicroMsg.JsApiSaveFile", "temp localId is null or nil");
      paramf = new p.a("fail", new Object[0]);
      AppMethodBeat.o(128899);
      return paramf;
    }
    localObject2 = paramf.getFileSystem().VY((String)localObject2);
    if ((localObject2 == null) || (!((o)localObject2).exists()))
    {
      paramf = new p.a("fail tempFilePath file not exist", new Object[0]);
      AppMethodBeat.o(128899);
      return paramf;
    }
    paramJSONObject = new i();
    paramf = a(paramf, (o)localObject2, (String)localObject1, paramJSONObject);
    localObject1 = new HashMap();
    if ("ok".equals(paramf)) {
      ((Map)localObject1).put("savedFilePath", paramJSONObject.value);
    }
    paramf = new p.a(paramf, new Object[0]).I((Map)localObject1);
    AppMethodBeat.o(128899);
    return paramf;
  }
  
  public final void a(final f paramf, final JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(128898);
    e.lUJ.execute(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(128896);
        if (!paramf.isRunning())
        {
          AppMethodBeat.o(128896);
          return;
        }
        p.a locala = am.f(paramf, paramJSONObject);
        paramf.i(paramInt, am.this.n(locala.errMsg, locala.values));
        AppMethodBeat.o(128896);
      }
    });
    AppMethodBeat.o(128898);
  }
  
  public final boolean bEa()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.am
 * JD-Core Version:    0.7.0.1
 */