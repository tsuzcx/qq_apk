package com.tencent.mm.plugin.appbrand.jsapi.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.m;
import com.tencent.mm.plugin.appbrand.appstorage.o;
import com.tencent.mm.plugin.appbrand.jsapi.ai;
import com.tencent.mm.plugin.appbrand.m.b.1;
import com.tencent.mm.plugin.appbrand.m.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;
import org.json.JSONObject;

public class d
  extends b
{
  public static final int CTRL_INDEX = 269;
  public static final String NAME = "createDownloadTask";
  
  public static void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, String paramString1, String paramString2)
  {
    AppMethodBeat.i(108028);
    HashMap localHashMap = new HashMap();
    localHashMap.put("downloadTaskId", paramString1);
    localHashMap.put("state", "fail");
    localHashMap.put("errMsg", paramString2);
    paramString1 = new JSONObject(localHashMap).toString();
    new d.a().j(paramc).BN(paramString1).aBz();
    AppMethodBeat.o(108028);
  }
  
  public final String Ox()
  {
    return "downloadTaskId";
  }
  
  public void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, com.tencent.mm.plugin.appbrand.m.a arg2, boolean paramBoolean, JSONObject paramJSONObject, int paramInt, Map<String, String> arg6, b.a parama1, String paramString)
  {
    AppMethodBeat.i(108027);
    ??? = com.tencent.mm.plugin.appbrand.m.c.aIh().DP(paramc.getAppId());
    if (??? == null)
    {
      ??? = new com.tencent.mm.plugin.appbrand.m.b(paramc);
      com.tencent.mm.plugin.appbrand.m.c localc = com.tencent.mm.plugin.appbrand.m.c.aIh();
      paramc = paramc.getAppId();
      if (!localc.hIm.containsKey(paramc)) {
        localc.hIm.put(paramc, ???);
      }
    }
    for (paramc = (com.tencent.mm.plugin.appbrand.jsapi.c)???;; paramc = (com.tencent.mm.plugin.appbrand.jsapi.c)???)
    {
      if (paramc != null)
      {
        ab.i("MicroMsg.JsApiCreateDownloadTask", "before do download, checkDomains = %b, timeout %d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
        int i = ???.hhD;
        if (paramBoolean) {
          ??? = ???.bDC;
        }
        for (;;)
        {
          paramJSONObject = com.tencent.mm.plugin.appbrand.m.j.DY(paramJSONObject.optString("url"));
          synchronized (paramc.isC)
          {
            if (paramc.isC.size() >= paramc.isx)
            {
              parama1.BE("max_connected");
              ab.i("MicroMsg.AppBrandNetworkDownload", "max connected mDownloadTaskList.size():%d,mMaxConnected:%d", new Object[] { Integer.valueOf(paramc.isC.size()), Integer.valueOf(paramc.isx) });
              AppMethodBeat.o(108027);
              return;
              ??? = null;
            }
            else
            {
              ??? = paramc.isy + com.tencent.mm.sdk.platformtools.ag.cE(paramJSONObject) + "temp";
              parama1 = new com.tencent.mm.plugin.appbrand.m.a.b(paramc.hrA, paramJSONObject, (String)???, paramc.igf, new b.1(paramc, paramString, parama1));
              parama1.itJ = ???;
              parama1.eBM = paramInt;
              parama1.isRunning = true;
              parama1.isU = ???;
              parama1.itK = i;
              parama1.isz = paramc.isz;
              parama1.hwp = paramString;
              parama1.isY = "createDownloadTask";
              synchronized (paramc.isC)
              {
                paramc.isC.add(parama1);
              }
            }
          }
        }
        synchronized (paramc.isB)
        {
          if (!paramc.isB.containsKey(paramJSONObject))
          {
            ??? = new ConcurrentLinkedQueue();
            paramc.isB.put(paramJSONObject, ???);
            ???.offer(parama1);
            if ((paramc.isB.get(paramJSONObject) != null) && (((ConcurrentLinkedQueue)paramc.isB.get(paramJSONObject)).size() > 1))
            {
              ab.i("MicroMsg.AppBrandNetworkDownload", "hy: more than one same url in the queue, just add and wait");
              AppMethodBeat.o(108027);
              return;
              paramc = finally;
              AppMethodBeat.o(108027);
              throw paramc;
              paramc = finally;
              AppMethodBeat.o(108027);
              throw paramc;
            }
          }
          else
          {
            ??? = (ConcurrentLinkedQueue)paramc.isB.get(paramJSONObject);
          }
        }
        paramc.DL(paramJSONObject);
      }
      AppMethodBeat.o(108027);
      return;
    }
  }
  
  public final void a(final com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, final String paramString)
  {
    AppMethodBeat.i(108026);
    ab.d("MicroMsg.JsApiCreateDownloadTask", "JsApiCreateDownloadTask");
    b.a local1 = new b.a()
    {
      private JSONObject hTK;
      private JSONArray hTL;
      
      public final void BE(String paramAnonymousString)
      {
        AppMethodBeat.i(108023);
        if (d.i(paramc, paramString))
        {
          AppMethodBeat.o(108023);
          return;
        }
        d.a(paramc, paramString, paramAnonymousString);
        AppMethodBeat.o(108023);
      }
      
      public final void c(int paramAnonymousInt1, String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt2)
      {
        AppMethodBeat.i(108021);
        ab.i("MicroMsg.JsApiCreateDownloadTask", "onDownloadResultWithCode errMsg = %d, mimeType = %s, filePath = %s, statusCode = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), paramAnonymousString1, paramAnonymousString2, Integer.valueOf(paramAnonymousInt2) });
        if (!bo.isNullOrNil(this.fYB))
        {
          paramAnonymousString1 = com.tencent.mm.plugin.appbrand.jsapi.file.ag.a(paramc, new File(paramAnonymousString2), this.fYB, null);
          if ((com.tencent.mm.plugin.appbrand.m.b.FAILED == paramAnonymousInt1) || (!"ok".equals(paramAnonymousString1)))
          {
            if (d.i(paramc, paramString))
            {
              AppMethodBeat.o(108021);
              return;
            }
            d.a(paramc, paramString, paramAnonymousString1);
            AppMethodBeat.o(108021);
            return;
          }
          ab.i("MicroMsg.JsApiCreateDownloadTask", "onDownloadResultWithCode filePath %s", new Object[] { this.fYB });
          paramAnonymousString1 = new HashMap();
          paramAnonymousString1.put("downloadTaskId", paramString);
          paramAnonymousString1.put("filePath", this.fYB);
          paramAnonymousString1.put("statusCode", Integer.valueOf(paramAnonymousInt2));
          paramAnonymousString1.put("state", "success");
          if (this.hTK != null) {
            paramAnonymousString1.put("header", this.hTK);
          }
          if (this.hTL != null) {
            paramAnonymousString1.put("cookies", this.hTL);
          }
          paramAnonymousString1 = new JSONObject(paramAnonymousString1).toString();
          new d.a().j(paramc).BN(paramAnonymousString1).aBz();
          AppMethodBeat.o(108021);
          return;
        }
        if (paramAnonymousInt1 != com.tencent.mm.plugin.appbrand.m.b.FAILED)
        {
          com.tencent.mm.plugin.appbrand.jsapi.c localc = paramc;
          String str2 = com.tencent.mm.sdk.f.c.alX(paramAnonymousString1);
          String str1 = str2;
          if (bo.isNullOrNil(str2))
          {
            str1 = str2;
            if ("audio/mp4".equals(paramAnonymousString1)) {
              str1 = "mp4";
            }
          }
          paramAnonymousString1 = new com.tencent.mm.plugin.appbrand.s.j();
          if (localc.wX().a(new File(paramAnonymousString2), str1, true, paramAnonymousString1) == com.tencent.mm.plugin.appbrand.appstorage.j.gZA) {
            break label392;
          }
          paramAnonymousString1 = null;
        }
        while (paramAnonymousString1 == null) {
          if (d.i(paramc, paramString))
          {
            AppMethodBeat.o(108021);
            return;
            label392:
            paramAnonymousString1 = (String)paramAnonymousString1.value;
          }
          else
          {
            d.a(paramc, paramString, "download fail");
            AppMethodBeat.o(108021);
            return;
          }
        }
        ab.i("MicroMsg.JsApiCreateDownloadTask", "onDownloadResultWithCode localId %s", new Object[] { paramAnonymousString1 });
        paramAnonymousString2 = new HashMap();
        paramAnonymousString2.put("downloadTaskId", paramString);
        paramAnonymousString2.put("tempFilePath", paramAnonymousString1);
        paramAnonymousString2.put("statusCode", Integer.valueOf(paramAnonymousInt2));
        paramAnonymousString2.put("state", "success");
        if (this.hTK != null) {
          paramAnonymousString2.put("header", this.hTK);
        }
        if (this.hTL != null) {
          paramAnonymousString2.put("cookies", this.hTL);
        }
        paramAnonymousString1 = new JSONObject(paramAnonymousString2).toString();
        new d.a().j(paramc).BN(paramAnonymousString1).aBz();
        AppMethodBeat.o(108021);
      }
      
      public final void g(int paramAnonymousInt, long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(108022);
        Object localObject = new HashMap();
        ((Map)localObject).put("downloadTaskId", paramString);
        ((Map)localObject).put("state", "progressUpdate");
        ((Map)localObject).put("progress", Integer.valueOf(paramAnonymousInt));
        ((Map)localObject).put("totalBytesWritten", Long.valueOf(paramAnonymousLong1));
        ((Map)localObject).put("totalBytesExpectedToWrite", Long.valueOf(paramAnonymousLong2));
        localObject = new JSONObject((Map)localObject).toString();
        new d.a().j(paramc).BN((String)localObject).aBz();
        AppMethodBeat.o(108022);
      }
      
      public final void v(JSONObject paramAnonymousJSONObject)
      {
        AppMethodBeat.i(108024);
        if (paramAnonymousJSONObject == null)
        {
          AppMethodBeat.o(108024);
          return;
        }
        if (paramAnonymousJSONObject.optBoolean("__AppBrandRemoteDebugRequestHeader__"))
        {
          if (!((com.tencent.mm.plugin.appbrand.m.a)paramc.U(com.tencent.mm.plugin.appbrand.m.a.class)).bCW)
          {
            AppMethodBeat.o(108024);
            return;
          }
          paramAnonymousJSONObject.remove("__AppBrandRemoteDebugRequestHeader__");
          m localm = new m();
          localm.cmz.cmA = "download";
          localm.cmz.cmC = paramAnonymousJSONObject;
          localm.cmz.cmB = paramString;
          com.tencent.mm.sdk.b.a.ymk.l(localm);
          AppMethodBeat.o(108024);
          return;
        }
        this.hTK = paramAnonymousJSONObject;
        this.hTL = this.hTK.optJSONArray("cookies");
        paramAnonymousJSONObject = new HashMap();
        paramAnonymousJSONObject.put("downloadTaskId", paramString);
        paramAnonymousJSONObject.put("state", "headersReceived");
        paramAnonymousJSONObject.put("header", this.hTK);
        if (this.hTL != null) {
          paramAnonymousJSONObject.put("cookies", this.hTL);
        }
        paramAnonymousJSONObject = new JSONObject(paramAnonymousJSONObject).toString();
        new d.a().j(paramc).BN(paramAnonymousJSONObject).aBz();
        AppMethodBeat.o(108024);
      }
    };
    com.tencent.mm.plugin.appbrand.m.a locala = (com.tencent.mm.plugin.appbrand.m.a)paramc.U(com.tencent.mm.plugin.appbrand.m.a.class);
    Map localMap = com.tencent.mm.plugin.appbrand.m.j.a(paramJSONObject, locala);
    String str = paramJSONObject.optString("url");
    if (bo.isNullOrNil(str))
    {
      ab.i("MicroMsg.JsApiCreateDownloadTask", "url is null");
      a(paramc, paramString, "url is null or nil");
      AppMethodBeat.o(108026);
      return;
    }
    if ((locala.isl) && (paramJSONObject.optBoolean("__skipDomainCheck__")))
    {
      i = 1;
      if (i == 0) {
        break label178;
      }
    }
    label178:
    for (boolean bool = false;; bool = locala.ism)
    {
      if ((!bool) || (com.tencent.mm.plugin.appbrand.m.j.c(locala.bDC, str))) {
        break label188;
      }
      ab.i("MicroMsg.JsApiCreateDownloadTask", "not in domain url %s", new Object[] { str });
      a(paramc, paramString, "url not in domain list");
      AppMethodBeat.o(108026);
      return;
      i = 0;
      break;
    }
    label188:
    if (locala.bDs <= 0) {
      ab.i("MicroMsg.JsApiCreateDownloadTask", "maxDownloadConcurrent <= 0 ");
    }
    int j = 60000;
    int k = paramJSONObject.optInt("timeout", 0);
    int i = k;
    if (k <= 0) {
      i = com.tencent.mm.plugin.appbrand.m.j.a(locala, 3);
    }
    if (i > 0) {
      j = i;
    }
    ab.i("MicroMsg.JsApiCreateDownloadTask", "lm:configTimeout: %d,timeout: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    a(paramc, locala, bool, paramJSONObject, j, localMap, local1, paramString);
    AppMethodBeat.o(108026);
  }
  
  public final String aAR()
  {
    AppMethodBeat.i(108025);
    Object localObject = new StringBuilder();
    com.tencent.mm.plugin.appbrand.m.c.aIh();
    localObject = com.tencent.mm.plugin.appbrand.m.c.aIg();
    AppMethodBeat.o(108025);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.j.d
 * JD-Core Version:    0.7.0.1
 */