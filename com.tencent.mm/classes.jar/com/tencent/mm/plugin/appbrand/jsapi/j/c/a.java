package com.tencent.mm.plugin.appbrand.jsapi.j.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.m;
import com.tencent.mm.plugin.appbrand.appstorage.p;
import com.tencent.mm.plugin.appbrand.jsapi.ar;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.p.g;
import com.tencent.mm.plugin.appbrand.p.g.a;
import com.tencent.mm.plugin.appbrand.p.i;
import com.tencent.mm.plugin.appbrand.p.j;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.q;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class a
  implements com.tencent.mm.plugin.appbrand.jsapi.j.e
{
  com.tencent.mm.plugin.appbrand.jsapi.j.a kAW;
  
  public a(com.tencent.mm.plugin.appbrand.jsapi.j.a parama)
  {
    this.kAW = parama;
  }
  
  final void a(c paramc, String paramString1, String paramString2)
  {
    AppMethodBeat.i(179541);
    ac.w("MicroMsg.BaseCreateUploadTask", "sendFailMsg, uploadTaskId = %s, errMsg = %s", new Object[] { paramString1, paramString2 });
    HashMap localHashMap = new HashMap();
    localHashMap.put("uploadTaskId", paramString1);
    localHashMap.put("state", "fail");
    localHashMap.put("errMsg", paramString2);
    paramString2 = new JSONObject(localHashMap).toString();
    new a().h(paramc).LO(paramString2).a(this.kAW.MJ(paramString1));
    this.kAW.remove(paramString1);
    AppMethodBeat.o(179541);
  }
  
  public final void a(final c paramc, JSONObject paramJSONObject, final String paramString)
  {
    AppMethodBeat.i(179540);
    ac.d("MicroMsg.BaseCreateUploadTask", "JsApiCreateUploadTask");
    String str4 = paramc.getAppId();
    String str1 = paramJSONObject.optString("filePath");
    if (bs.isNullOrNil(str1))
    {
      a(paramc, paramString, "filePath is null");
      AppMethodBeat.o(179540);
      return;
    }
    Object localObject = paramc.DH().IS(str1);
    if ((localObject == null) || (!((com.tencent.mm.vfs.e)localObject).exists()))
    {
      ac.e("MicroMsg.BaseCreateUploadTask", "upload appId(%s) tempFilePath(%s), found no real file", new Object[] { paramc.getAppId(), str1 });
      a(paramc, paramString, "fail:file doesn't exist");
      AppMethodBeat.o(179540);
      return;
    }
    final String str2 = q.B(((com.tencent.mm.vfs.e)localObject).fxV());
    String str3 = com.tencent.mm.sdk.f.d.aIh(str1);
    ac.i("MicroMsg.BaseCreateUploadTask", "upload appId(%s) tempFilePath(%s) realFilePath(%s)", new Object[] { paramc.getAppId(), str1, str2 });
    g.a local1 = new g.a()
    {
      private JSONObject kBw;
      
      public final void C(JSONObject paramAnonymousJSONObject)
      {
        AppMethodBeat.i(179538);
        if (paramAnonymousJSONObject == null)
        {
          AppMethodBeat.o(179538);
          return;
        }
        if (paramAnonymousJSONObject.optBoolean("__AppBrandRemoteDebugRequestHeader__"))
        {
          if (!((com.tencent.mm.plugin.appbrand.p.a)paramc.ar(com.tencent.mm.plugin.appbrand.p.a.class)).ccb)
          {
            AppMethodBeat.o(179538);
            return;
          }
          paramAnonymousJSONObject.remove("__AppBrandRemoteDebugRequestHeader__");
          m localm = new m();
          localm.cYH.cYI = "upload";
          localm.cYH.cYK = paramAnonymousJSONObject;
          localm.cYH.cYJ = paramString;
          com.tencent.mm.sdk.b.a.GpY.l(localm);
          AppMethodBeat.o(179538);
          return;
        }
        this.kBw = paramAnonymousJSONObject;
        paramAnonymousJSONObject = new HashMap();
        paramAnonymousJSONObject.put("uploadTaskId", paramString);
        paramAnonymousJSONObject.put("state", "headersReceived");
        paramAnonymousJSONObject.put("header", this.kBw);
        paramAnonymousJSONObject = new JSONObject(paramAnonymousJSONObject).toString();
        new a.a().h(paramc).LO(paramAnonymousJSONObject).a(a.this.kAW.MJ(paramString));
        AppMethodBeat.o(179538);
      }
      
      public final void MM(String paramAnonymousString)
      {
        AppMethodBeat.i(179535);
        ac.i("MicroMsg.BaseCreateUploadTask", "onUploadResult uploadTaskId:%s, filePath:%s, result:%s, errMsg:%d", new Object[] { paramString, str2, paramAnonymousString, Integer.valueOf(-1) });
        if (a.j(paramc, paramString))
        {
          AppMethodBeat.o(179535);
          return;
        }
        a.this.a(paramc, paramString, paramAnonymousString);
        AppMethodBeat.o(179535);
      }
      
      public final void h(int paramAnonymousInt, long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(179537);
        Object localObject = new HashMap();
        ((Map)localObject).put("uploadTaskId", paramString);
        ((Map)localObject).put("state", "progressUpdate");
        ((Map)localObject).put("progress", Integer.valueOf(paramAnonymousInt));
        ((Map)localObject).put("totalBytesSent", Long.valueOf(paramAnonymousLong1));
        ((Map)localObject).put("totalBytesExpectedToSend", Long.valueOf(paramAnonymousLong2));
        localObject = new JSONObject((Map)localObject).toString();
        new a.a().h(paramc).LO((String)localObject).a(a.this.kAW.MJ(paramString));
        AppMethodBeat.o(179537);
      }
      
      public final void j(int paramAnonymousInt1, String paramAnonymousString, int paramAnonymousInt2)
      {
        AppMethodBeat.i(179536);
        ac.i("MicroMsg.BaseCreateUploadTask", "onUploadResultWithCode uploadTaskId:%s, filePath:%s, result:%s, errMsg:%d, statusCode %d", new Object[] { paramString, str2, paramAnonymousString, Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        if (paramAnonymousInt1 == 0)
        {
          HashMap localHashMap = new HashMap();
          localHashMap.put("data", paramAnonymousString);
          localHashMap.put("statusCode", Integer.valueOf(paramAnonymousInt2));
          localHashMap.put("uploadTaskId", paramString);
          localHashMap.put("state", "success");
          if (this.kBw != null) {
            localHashMap.put("header", this.kBw);
          }
          paramAnonymousString = new JSONObject(localHashMap).toString();
          new a.a().h(paramc).LO(paramAnonymousString).a(a.this.kAW.MJ(paramString));
          a.this.kAW.remove(paramString);
          AppMethodBeat.o(179536);
          return;
        }
        if (a.j(paramc, paramString))
        {
          AppMethodBeat.o(179536);
          return;
        }
        a.this.a(paramc, paramString, paramAnonymousString);
        AppMethodBeat.o(179536);
      }
    };
    com.tencent.mm.plugin.appbrand.p.a locala = (com.tencent.mm.plugin.appbrand.p.a)paramc.ar(com.tencent.mm.plugin.appbrand.p.a.class);
    Map localMap = j.a(paramJSONObject, locala);
    localObject = paramJSONObject.optString("url");
    if (bs.isNullOrNil((String)localObject))
    {
      ac.i("MicroMsg.BaseCreateUploadTask", "url is null");
      a(paramc, paramString, "url is null or nil");
      AppMethodBeat.o(179540);
      return;
    }
    if (paramJSONObject.optBoolean("__skipDomainCheck__")) {}
    for (boolean bool = false; (bool) && (!j.c(locala.ccG, (String)localObject)); bool = locala.lvY)
    {
      ac.i("MicroMsg.BaseCreateUploadTask", "not in domain url %s", new Object[] { localObject });
      a(paramc, paramString, "url not in domain list");
      AppMethodBeat.o(179540);
      return;
    }
    if (locala.ccw <= 0) {
      ac.i("MicroMsg.BaseCreateUploadTask", "concurrent <= 0 ");
    }
    int j = paramJSONObject.optInt("timeout", 0);
    int i = j;
    if (j <= 0) {
      i = j.a(locala, 2);
    }
    if (i > 0) {}
    for (;;)
    {
      if (i.bpl().Pl(str4) == null)
      {
        localObject = new g(paramc);
        i locali = i.bpl();
        paramc = (c)localObject;
        if (!locali.lwt.containsKey(str4)) {
          locali.lwt.put(str4, localObject);
        }
      }
      for (paramc = (c)localObject;; paramc = i.bpl().Pl(str4))
      {
        localObject = org.apache.commons.a.d.getName(str1);
        if (paramc == null) {
          break label520;
        }
        ac.i("MicroMsg.BaseCreateUploadTask", "before do upload, checkDomains = %b, timeout %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) });
        if (bool) {
          break;
        }
        paramc.a(i, str3, str2, paramJSONObject, localMap, null, local1, paramString, "createUploadTask", (String)localObject);
        AppMethodBeat.o(179540);
        return;
      }
      paramc.a(i, str3, str2, paramJSONObject, localMap, locala.ccG, local1, paramString, "createUploadTask", (String)localObject);
      label520:
      AppMethodBeat.o(179540);
      return;
      i = 60000;
    }
  }
  
  public final String aLs()
  {
    AppMethodBeat.i(179539);
    Object localObject = new StringBuilder();
    i.bpl();
    localObject = i.bpf();
    AppMethodBeat.o(179539);
    return localObject;
  }
  
  public final String acf()
  {
    return "uploadTaskId";
  }
  
  public static final class a
    extends ar
  {
    public static final int CTRL_INDEX = 274;
    public static final String NAME = "onUploadTaskStateChange";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.j.c.a
 * JD-Core Version:    0.7.0.1
 */