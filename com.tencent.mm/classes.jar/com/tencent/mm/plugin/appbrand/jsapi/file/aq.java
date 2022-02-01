package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.af.k;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import com.tencent.mm.plugin.appbrand.appstorage.w;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.p.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONObject;

public final class aq
  extends c
{
  public static final int CTRL_INDEX = 51;
  public static final String NAME = "saveFile";
  
  public static String a(f paramf, u paramu, String paramString, k<String> paramk)
  {
    AppMethodBeat.i(170099);
    if ((paramu == null) || (!paramu.jKS()))
    {
      AppMethodBeat.o(170099);
      return "fail:file not exists";
    }
    Object localObject2 = paramf.getFileSystem().Vt(paramString);
    Object localObject1 = localObject2;
    if (localObject2 != r.qML) {}
    try
    {
      localObject2 = new k();
      paramf = paramf.getFileSystem().a(paramu, paramString, (k)localObject2);
      localObject1 = paramf;
      if (paramk != null)
      {
        paramk.value = ((k)localObject2).value;
        localObject1 = paramf;
      }
      switch (2.rXN[localObject1.ordinal()])
      {
      default: 
        paramf = "fail " + ((r)localObject1).name();
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
  
  static p.a e(f paramf, JSONObject paramJSONObject)
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
    localObject2 = paramf.getFileSystem().Wm((String)localObject2);
    if ((localObject2 == null) || (!((u)localObject2).jKS()))
    {
      Log.e("MicroMsg.JsApiSaveFile", "fail tempFilePath file not exist");
      paramf = new p.a("fail tempFilePath file not exist", new Object[0]);
      AppMethodBeat.o(128899);
      return paramf;
    }
    paramJSONObject = new k();
    paramf = a(paramf, (u)localObject2, (String)localObject1, paramJSONObject);
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
    e.rXi.execute(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(128896);
        if (!paramf.isRunning())
        {
          AppMethodBeat.o(128896);
          return;
        }
        p.a locala = aq.e(paramf, paramJSONObject);
        paramf.callback(paramInt, aq.this.m(locala.errMsg, locala.values));
        AppMethodBeat.o(128896);
      }
    });
    AppMethodBeat.o(128898);
  }
  
  public final boolean cpE()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.aq
 * JD-Core Version:    0.7.0.1
 */