package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.o;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONObject;

public final class ag
  extends a
{
  public static final int CTRL_INDEX = 51;
  public static final String NAME = "saveFile";
  
  public static String a(c paramc, File paramFile, String paramString, com.tencent.mm.plugin.appbrand.s.j<String> paramj)
  {
    AppMethodBeat.i(102808);
    if ((paramFile == null) || (!paramFile.exists()))
    {
      AppMethodBeat.o(102808);
      return "fail:file not exists";
    }
    Object localObject2 = paramc.wX().ze(paramString);
    Object localObject1 = localObject2;
    if (localObject2 != com.tencent.mm.plugin.appbrand.appstorage.j.gZA) {}
    try
    {
      localObject2 = new com.tencent.mm.plugin.appbrand.s.j();
      paramc = paramc.wX().a(paramFile, paramString, (com.tencent.mm.plugin.appbrand.s.j)localObject2);
      localObject1 = paramc;
      if (paramj != null)
      {
        paramj.value = ((com.tencent.mm.plugin.appbrand.s.j)localObject2).value;
        localObject1 = paramc;
      }
      switch (ag.2.hMg[localObject1.ordinal()])
      {
      default: 
        paramc = "fail " + ((com.tencent.mm.plugin.appbrand.appstorage.j)localObject1).name();
        AppMethodBeat.o(102808);
        return paramc;
      }
    }
    catch (Exception paramc)
    {
      paramc = "fail:writeFile exception: " + paramc.toString();
      AppMethodBeat.o(102808);
      return paramc;
    }
    paramc = String.format("fail permission denied, open \"%s\"", new Object[] { paramString });
    AppMethodBeat.o(102808);
    return paramc;
    paramc = String.format("fail no such file or directory \"%s\"", new Object[] { paramString });
    AppMethodBeat.o(102808);
    return paramc;
    paramc = String.format("fail illegal operation on a directory, open \"%s\"", new Object[] { paramString });
    AppMethodBeat.o(102808);
    return paramc;
    AppMethodBeat.o(102808);
    return "fail the maximum size of the file storage limit is exceeded";
    AppMethodBeat.o(102808);
    return "ok";
  }
  
  static m.a d(c paramc, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(102807);
    Object localObject2 = paramJSONObject.optString("tempFilePath");
    Object localObject1 = paramJSONObject.optString("filePath");
    if (bo.isNullOrNil((String)localObject2))
    {
      ab.e("MicroMsg.JsApiSaveFile", "temp localId is null or nil");
      paramc = new m.a("fail", new Object[0]);
      AppMethodBeat.o(102807);
      return paramc;
    }
    localObject2 = paramc.wX().zg((String)localObject2);
    if ((localObject2 == null) || (!((File)localObject2).exists()))
    {
      paramc = new m.a("fail tempFilePath file not exist", new Object[0]);
      AppMethodBeat.o(102807);
      return paramc;
    }
    paramJSONObject = new com.tencent.mm.plugin.appbrand.s.j();
    paramc = a(paramc, (File)localObject2, (String)localObject1, paramJSONObject);
    localObject1 = new HashMap();
    if ("ok".equals(paramc)) {
      ((Map)localObject1).put("savedFilePath", paramJSONObject.value);
    }
    paramc = new m.a(paramc, new Object[0]).u((Map)localObject1);
    AppMethodBeat.o(102807);
    return paramc;
  }
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(102806);
    d.hLQ.execute(new ag.1(this, paramc, paramJSONObject, paramInt));
    AppMethodBeat.o(102806);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.ag
 * JD-Core Version:    0.7.0.1
 */