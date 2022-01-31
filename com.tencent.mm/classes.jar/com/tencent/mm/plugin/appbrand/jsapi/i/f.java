package com.tencent.mm.plugin.appbrand.jsapi.i;

import com.tencent.mm.plugin.appbrand.appstorage.k;
import com.tencent.mm.plugin.appbrand.jsapi.ac;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.o.g;
import com.tencent.mm.plugin.appbrand.o.i;
import com.tencent.mm.plugin.appbrand.o.j;
import com.tencent.mm.plugin.appbrand.v.m;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class f
  extends b
{
  public static final int CTRL_INDEX = 272;
  public static final String NAME = "createUploadTask";
  
  private static void a(c paramc, String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("uploadTaskId", paramString1);
    localHashMap.put("state", "fail");
    localHashMap.put("errMsg", paramString2);
    paramString1 = new JSONObject(localHashMap).toString();
    new f.a().e(paramc).tM(paramString1).dispatch();
  }
  
  public final void a(c paramc, JSONObject paramJSONObject, String paramString)
  {
    y.d("MicroMsg.JsApiCreateUploadTask", "JsApiCreateUploadTask");
    String str4 = paramc.getAppId();
    String str1 = paramJSONObject.optString("filePath");
    if (bk.bl(str1))
    {
      a(paramc, paramString, "filePath is null");
      return;
    }
    Object localObject = paramc.Zl().rx(str1);
    if ((localObject == null) || (!((File)localObject).exists()))
    {
      y.e("MicroMsg.JsApiCreateUploadTask", "upload appId(%s) tempFilePath(%s), found no real file", new Object[] { paramc.getAppId(), str1 });
      a(paramc, paramString, "fail:file doesn't exist");
      return;
    }
    String str2 = ((File)localObject).getAbsolutePath();
    String str3 = m.wK(str1);
    y.i("MicroMsg.JsApiCreateUploadTask", "upload appId(%s) tempFilePath(%s) realFilePath(%s)", new Object[] { paramc.getAppId(), str1, str2 });
    f.1 local1 = new f.1(this, paramc, paramString, str2);
    com.tencent.mm.plugin.appbrand.o.a locala = (com.tencent.mm.plugin.appbrand.o.a)paramc.D(com.tencent.mm.plugin.appbrand.o.a.class);
    Map localMap = j.a(paramJSONObject, locala);
    localObject = paramJSONObject.optString("url");
    if (bk.bl((String)localObject))
    {
      y.i("MicroMsg.JsApiCreateUploadTask", "url is null");
      a(paramc, paramString, "url is null or nil");
      return;
    }
    if ((locala.gQw) && (paramJSONObject.optBoolean("__skipDomainCheck__")))
    {
      i = 1;
      if (i == 0) {
        break label286;
      }
    }
    label286:
    for (boolean bool = false;; bool = locala.gQx)
    {
      if ((!bool) || (j.c(locala.fQl, (String)localObject))) {
        break label296;
      }
      y.i("MicroMsg.JsApiCreateUploadTask", "not in domain url %s", new Object[] { localObject });
      a(paramc, paramString, "url not in domain list");
      return;
      i = 0;
      break;
    }
    label296:
    if (locala.fQa <= 0) {
      y.i("MicroMsg.JsApiCreateUploadTask", "concurrent <= 0 ");
    }
    int j = paramJSONObject.optInt("timeout", 0);
    int i = j;
    if (j <= 0) {
      i = j.a(locala, 2);
    }
    if (i > 0) {}
    for (;;)
    {
      if (i.amI().vx(str4) == null)
      {
        localObject = new g(paramc);
        i locali = i.amI();
        paramc = (c)localObject;
        if (!locali.goq.containsKey(str4)) {
          locali.goq.put(str4, localObject);
        }
      }
      for (paramc = (c)localObject;; paramc = i.amI().vx(str4))
      {
        localObject = org.a.a.a.a.getName(str1);
        if (paramc == null) {
          break;
        }
        y.i("MicroMsg.JsApiCreateUploadTask", "before do upload, checkDomains = %b, timeout %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) });
        if (bool) {
          break label477;
        }
        paramc.a(i, str3, str2, paramJSONObject, localMap, null, local1, paramString, "createUploadTask", (String)localObject);
        return;
      }
      label477:
      paramc.a(i, str3, str2, paramJSONObject, localMap, locala.fQl, local1, paramString, "createUploadTask", (String)localObject);
      return;
      i = 60000;
    }
  }
  
  protected final String ajy()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    i.amI();
    return i.amC();
  }
  
  protected final String ajz()
  {
    return "uploadTaskId";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.i.f
 * JD-Core Version:    0.7.0.1
 */