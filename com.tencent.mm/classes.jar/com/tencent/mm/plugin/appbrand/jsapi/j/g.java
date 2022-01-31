package com.tencent.mm.plugin.appbrand.jsapi.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.o;
import com.tencent.mm.plugin.appbrand.jsapi.ai;
import com.tencent.mm.plugin.appbrand.m.a;
import com.tencent.mm.plugin.appbrand.m.i;
import com.tencent.mm.plugin.appbrand.m.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class g
  extends b
{
  public static final int CTRL_INDEX = 272;
  public static final String NAME = "createUploadTask";
  
  static void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, String paramString1, String paramString2)
  {
    AppMethodBeat.i(108058);
    HashMap localHashMap = new HashMap();
    localHashMap.put("uploadTaskId", paramString1);
    localHashMap.put("state", "fail");
    localHashMap.put("errMsg", paramString2);
    paramString1 = new JSONObject(localHashMap).toString();
    new g.a().j(paramc).BN(paramString1).aBz();
    AppMethodBeat.o(108058);
  }
  
  public final String Ox()
  {
    return "uploadTaskId";
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, String paramString)
  {
    AppMethodBeat.i(108057);
    ab.d("MicroMsg.JsApiCreateUploadTask", "JsApiCreateUploadTask");
    String str4 = paramc.getAppId();
    String str1 = paramJSONObject.optString("filePath");
    if (bo.isNullOrNil(str1))
    {
      a(paramc, paramString, "filePath is null");
      AppMethodBeat.o(108057);
      return;
    }
    Object localObject = paramc.wX().zg(str1);
    if ((localObject == null) || (!((File)localObject).exists()))
    {
      ab.e("MicroMsg.JsApiCreateUploadTask", "upload appId(%s) tempFilePath(%s), found no real file", new Object[] { paramc.getAppId(), str1 });
      a(paramc, paramString, "fail:file doesn't exist");
      AppMethodBeat.o(108057);
      return;
    }
    String str2 = ((File)localObject).getAbsolutePath();
    String str3 = com.tencent.mm.sdk.f.c.amX(str1);
    ab.i("MicroMsg.JsApiCreateUploadTask", "upload appId(%s) tempFilePath(%s) realFilePath(%s)", new Object[] { paramc.getAppId(), str1, str2 });
    g.1 local1 = new g.1(this, paramc, paramString, str2);
    a locala = (a)paramc.U(a.class);
    Map localMap = j.a(paramJSONObject, locala);
    localObject = paramJSONObject.optString("url");
    if (bo.isNullOrNil((String)localObject))
    {
      ab.i("MicroMsg.JsApiCreateUploadTask", "url is null");
      a(paramc, paramString, "url is null or nil");
      AppMethodBeat.o(108057);
      return;
    }
    if ((locala.isl) && (paramJSONObject.optBoolean("__skipDomainCheck__")))
    {
      i = 1;
      if (i == 0) {
        break label311;
      }
    }
    label311:
    for (boolean bool = false;; bool = locala.ism)
    {
      if ((!bool) || (j.c(locala.bDB, (String)localObject))) {
        break label321;
      }
      ab.i("MicroMsg.JsApiCreateUploadTask", "not in domain url %s", new Object[] { localObject });
      a(paramc, paramString, "url not in domain list");
      AppMethodBeat.o(108057);
      return;
      i = 0;
      break;
    }
    label321:
    if (locala.bDr <= 0) {
      ab.i("MicroMsg.JsApiCreateUploadTask", "concurrent <= 0 ");
    }
    int j = paramJSONObject.optInt("timeout", 0);
    int i = j;
    if (j <= 0) {
      i = j.a(locala, 2);
    }
    if (i > 0) {}
    for (;;)
    {
      if (i.aIm().DU(str4) == null)
      {
        localObject = new com.tencent.mm.plugin.appbrand.m.g(paramc);
        i locali = i.aIm();
        paramc = (com.tencent.mm.plugin.appbrand.jsapi.c)localObject;
        if (!locali.hIm.containsKey(str4)) {
          locali.hIm.put(str4, localObject);
        }
      }
      for (paramc = (com.tencent.mm.plugin.appbrand.jsapi.c)localObject;; paramc = i.aIm().DU(str4))
      {
        localObject = org.apache.commons.a.b.getName(str1);
        if (paramc == null) {
          break label532;
        }
        ab.i("MicroMsg.JsApiCreateUploadTask", "before do upload, checkDomains = %b, timeout %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) });
        if (bool) {
          break;
        }
        paramc.a(i, str3, str2, paramJSONObject, localMap, null, local1, paramString, "createUploadTask", (String)localObject);
        AppMethodBeat.o(108057);
        return;
      }
      paramc.a(i, str3, str2, paramJSONObject, localMap, locala.bDB, local1, paramString, "createUploadTask", (String)localObject);
      label532:
      AppMethodBeat.o(108057);
      return;
      i = 60000;
    }
  }
  
  public final String aAR()
  {
    AppMethodBeat.i(108056);
    Object localObject = new StringBuilder();
    i.aIm();
    localObject = i.aIg();
    AppMethodBeat.o(108056);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.j.g
 * JD-Core Version:    0.7.0.1
 */