package com.tencent.mm.plugin.appbrand.jsapi.m.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.m;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.jsapi.at;
import com.tencent.mm.plugin.appbrand.jsapi.base.h;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.o.g;
import com.tencent.mm.plugin.appbrand.o.g.a;
import com.tencent.mm.plugin.appbrand.o.i;
import com.tencent.mm.plugin.appbrand.o.j;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.w;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class a
  implements h
{
  com.tencent.mm.plugin.appbrand.jsapi.base.a laM;
  
  public a(com.tencent.mm.plugin.appbrand.jsapi.base.a parama)
  {
    this.laM = parama;
  }
  
  public final void a(final c paramc, JSONObject paramJSONObject, final String paramString)
  {
    AppMethodBeat.i(179540);
    ae.d("MicroMsg.BaseCreateUploadTask", "JsApiCreateUploadTask");
    String str4 = paramc.getAppId();
    String str1 = paramJSONObject.optString("filePath");
    if (bu.isNullOrNil(str1))
    {
      b(paramc, paramString, "filePath is null");
      AppMethodBeat.o(179540);
      return;
    }
    Object localObject = paramc.Fl().MP(str1);
    if ((localObject == null) || (!((k)localObject).exists()))
    {
      ae.e("MicroMsg.BaseCreateUploadTask", "upload appId(%s) tempFilePath(%s), found no real file", new Object[] { paramc.getAppId(), str1 });
      b(paramc, paramString, "fail:file doesn't exist");
      AppMethodBeat.o(179540);
      return;
    }
    final String str2 = w.B(((k)localObject).fTh());
    String str3 = com.tencent.mm.sdk.f.d.aPg(str1);
    ae.i("MicroMsg.BaseCreateUploadTask", "upload appId(%s) tempFilePath(%s) realFilePath(%s)", new Object[] { paramc.getAppId(), str1, str2 });
    g.a local1 = new g.a()
    {
      private JSONObject lbm;
      
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
          if (!((com.tencent.mm.plugin.appbrand.o.a)paramc.ar(com.tencent.mm.plugin.appbrand.o.a.class)).cmu)
          {
            AppMethodBeat.o(179538);
            return;
          }
          paramAnonymousJSONObject.remove("__AppBrandRemoteDebugRequestHeader__");
          m localm = new m();
          localm.dlb.dlc = "upload";
          localm.dlb.dle = paramAnonymousJSONObject;
          localm.dlb.dld = paramString;
          com.tencent.mm.sdk.b.a.IvT.l(localm);
          AppMethodBeat.o(179538);
          return;
        }
        this.lbm = paramAnonymousJSONObject;
        paramAnonymousJSONObject = new HashMap();
        paramAnonymousJSONObject.put("uploadTaskId", paramString);
        paramAnonymousJSONObject.put("state", "headersReceived");
        paramAnonymousJSONObject.put("header", this.lbm);
        paramAnonymousJSONObject = new JSONObject(paramAnonymousJSONObject).toString();
        new a.a().h(paramc).PQ(paramAnonymousJSONObject).a(a.this.laM.PY(paramString));
        AppMethodBeat.o(179538);
      }
      
      public final void QS(String paramAnonymousString)
      {
        AppMethodBeat.i(179535);
        ae.i("MicroMsg.BaseCreateUploadTask", "onUploadResult uploadTaskId:%s, filePath:%s, result:%s, errMsg:%d", new Object[] { paramString, str2, paramAnonymousString, Integer.valueOf(-1) });
        if (a.j(paramc, paramString))
        {
          AppMethodBeat.o(179535);
          return;
        }
        a.this.b(paramc, paramString, paramAnonymousString);
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
        new a.a().h(paramc).PQ((String)localObject).a(a.this.laM.PY(paramString));
        AppMethodBeat.o(179537);
      }
      
      public final void j(int paramAnonymousInt1, String paramAnonymousString, int paramAnonymousInt2)
      {
        AppMethodBeat.i(179536);
        ae.i("MicroMsg.BaseCreateUploadTask", "onUploadResultWithCode uploadTaskId:%s, filePath:%s, result:%s, errMsg:%d, statusCode %d", new Object[] { paramString, str2, paramAnonymousString, Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        if (paramAnonymousInt1 == 0)
        {
          HashMap localHashMap = new HashMap();
          localHashMap.put("data", paramAnonymousString);
          localHashMap.put("statusCode", Integer.valueOf(paramAnonymousInt2));
          localHashMap.put("uploadTaskId", paramString);
          localHashMap.put("state", "success");
          if (this.lbm != null) {
            localHashMap.put("header", this.lbm);
          }
          paramAnonymousString = new JSONObject(localHashMap).toString();
          new a.a().h(paramc).PQ(paramAnonymousString).a(a.this.laM.PY(paramString));
          a.this.laM.remove(paramString);
          AppMethodBeat.o(179536);
          return;
        }
        if (a.j(paramc, paramString))
        {
          AppMethodBeat.o(179536);
          return;
        }
        a.this.b(paramc, paramString, paramAnonymousString);
        AppMethodBeat.o(179536);
      }
    };
    com.tencent.mm.plugin.appbrand.o.a locala = (com.tencent.mm.plugin.appbrand.o.a)paramc.ar(com.tencent.mm.plugin.appbrand.o.a.class);
    Map localMap = j.a(paramJSONObject, locala);
    localObject = paramJSONObject.optString("url");
    if (bu.isNullOrNil((String)localObject))
    {
      ae.i("MicroMsg.BaseCreateUploadTask", "url is null");
      b(paramc, paramString, "url is null or nil");
      AppMethodBeat.o(179540);
      return;
    }
    if (paramJSONObject.optBoolean("__skipDomainCheck__")) {}
    for (boolean bool = false; (bool) && (!j.c(locala.cmZ, (String)localObject)); bool = locala.lZO)
    {
      ae.i("MicroMsg.BaseCreateUploadTask", "not in domain url %s", new Object[] { localObject });
      b(paramc, paramString, "url not in domain list");
      AppMethodBeat.o(179540);
      return;
    }
    if (locala.cmP <= 0) {
      ae.i("MicroMsg.BaseCreateUploadTask", "concurrent <= 0 ");
    }
    int j = paramJSONObject.optInt("timeout", 0);
    int i = j;
    if (j <= 0) {
      i = j.a(locala, 2);
    }
    if (i > 0) {}
    for (;;)
    {
      if (i.btV().Tx(str4) == null)
      {
        localObject = new g(paramc);
        i locali = i.btV();
        paramc = (c)localObject;
        if (!locali.mak.containsKey(str4)) {
          locali.mak.put(str4, localObject);
        }
      }
      for (paramc = (c)localObject;; paramc = i.btV().Tx(str4))
      {
        localObject = org.apache.commons.a.d.getName(str1);
        if (paramc == null) {
          break label517;
        }
        ae.i("MicroMsg.BaseCreateUploadTask", "before do upload, checkDomains = %b, timeout %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) });
        if (bool) {
          break;
        }
        paramc.a(i, str3, str2, paramJSONObject, localMap, null, local1, paramString, "createUploadTask", (String)localObject);
        AppMethodBeat.o(179540);
        return;
      }
      paramc.a(i, str3, str2, paramJSONObject, localMap, locala.cmZ, local1, paramString, "createUploadTask", (String)localObject);
      label517:
      AppMethodBeat.o(179540);
      return;
      i = 60000;
    }
  }
  
  public final String aOZ()
  {
    AppMethodBeat.i(179539);
    Object localObject = new StringBuilder();
    i.btV();
    localObject = i.btP();
    AppMethodBeat.o(179539);
    return localObject;
  }
  
  public final String aeV()
  {
    return "uploadTaskId";
  }
  
  final void b(c paramc, String paramString1, String paramString2)
  {
    AppMethodBeat.i(179541);
    ae.w("MicroMsg.BaseCreateUploadTask", "sendFailMsg, uploadTaskId = %s, errMsg = %s", new Object[] { paramString1, paramString2 });
    HashMap localHashMap = new HashMap();
    localHashMap.put("uploadTaskId", paramString1);
    localHashMap.put("state", "fail");
    localHashMap.put("errMsg", paramString2);
    paramString2 = new JSONObject(localHashMap).toString();
    new a().h(paramc).PQ(paramString2).a(this.laM.PY(paramString1));
    this.laM.remove(paramString1);
    AppMethodBeat.o(179541);
  }
  
  public static final class a
    extends at
  {
    public static final int CTRL_INDEX = 274;
    public static final String NAME = "onUploadTaskStateChange";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.m.c.a
 * JD-Core Version:    0.7.0.1
 */