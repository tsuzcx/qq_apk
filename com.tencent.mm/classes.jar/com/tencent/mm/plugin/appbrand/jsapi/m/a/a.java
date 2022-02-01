package com.tencent.mm.plugin.appbrand.jsapi.m.a;

import com.tencent.mars.cdn.CronetLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.m;
import com.tencent.mm.plugin.appbrand.appstorage.l;
import com.tencent.mm.plugin.appbrand.appstorage.p;
import com.tencent.mm.plugin.appbrand.jsapi.at;
import com.tencent.mm.plugin.appbrand.jsapi.base.h;
import com.tencent.mm.plugin.appbrand.jsapi.file.ak;
import com.tencent.mm.plugin.appbrand.o.b.1;
import com.tencent.mm.plugin.appbrand.o.b.a;
import com.tencent.mm.plugin.appbrand.o.b.b;
import com.tencent.mm.plugin.appbrand.o.j;
import com.tencent.mm.plugin.appbrand.z.i;
import com.tencent.mm.sdk.f.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class a
  implements h
{
  private b.b kXB;
  protected boolean kXC;
  com.tencent.mm.plugin.appbrand.jsapi.base.a kXd;
  private final AtomicBoolean kXn;
  
  public a(b.b paramb, com.tencent.mm.plugin.appbrand.jsapi.base.a parama)
  {
    AppMethodBeat.i(187746);
    this.kXC = false;
    this.kXn = new AtomicBoolean(false);
    this.kXB = paramb;
    this.kXd = parama;
    AppMethodBeat.o(187746);
  }
  
  public void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, com.tencent.mm.plugin.appbrand.o.a arg2, boolean paramBoolean, JSONObject paramJSONObject, int paramInt, Map<String, String> arg6, b.a parama1, String paramString)
  {
    AppMethodBeat.i(179509);
    Object localObject1 = com.tencent.mm.plugin.appbrand.o.c.btf().SI(paramc.getAppId());
    if (localObject1 == null)
    {
      localObject1 = new com.tencent.mm.plugin.appbrand.o.b(paramc, this.kXC);
      ??? = com.tencent.mm.plugin.appbrand.o.c.btf();
      paramc = paramc.getAppId();
      if (!((com.tencent.mm.plugin.appbrand.o.c)???).lVG.containsKey(paramc)) {
        ((com.tencent.mm.plugin.appbrand.o.c)???).lVG.put(paramc, localObject1);
      }
    }
    for (paramc = (com.tencent.mm.plugin.appbrand.jsapi.c)localObject1;; paramc = (com.tencent.mm.plugin.appbrand.jsapi.c)localObject1)
    {
      if (paramc != null)
      {
        ad.i("MicroMsg.BaseCreateDownloadTask", "before do download, checkDomains = %b, timeout %d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
        int i = ???.jWu;
        if (paramBoolean) {
          ??? = ???.cmY;
        }
        for (;;)
        {
          localObject1 = paramJSONObject.optString("url");
          ad.i("MicroMsg.AppBrandNetworkDownload", "download taskId:%s url:%s", new Object[] { paramString, localObject1 });
          localObject1 = j.SS((String)localObject1);
          synchronized (paramc.lVC)
          {
            if (paramc.lVC.size() >= paramc.lVx)
            {
              parama1.ae(-1, "max_connected");
              ad.i("MicroMsg.AppBrandNetworkDownload", "max connected mDownloadTaskList.size():%d,mMaxConnected:%d", new Object[] { Integer.valueOf(paramc.lVC.size()), Integer.valueOf(paramc.lVx) });
              AppMethodBeat.o(179509);
              return;
              ??? = null;
            }
            else
            {
              ??? = paramJSONObject.optString("filePath");
              String str = paramc.lVy + ai.ee((String)localObject1) + "temp" + System.currentTimeMillis();
              paramBoolean = paramJSONObject.optBoolean("enableHttp2", false);
              boolean bool1 = paramJSONObject.optBoolean("enableQuic", false);
              boolean bool2 = paramJSONObject.optBoolean("enableCache", false);
              boolean bool3 = paramJSONObject.optBoolean("enableProfile", true);
              ad.i("MicroMsg.AppBrandNetworkDownload", "download taskId %s,useHttp2 %b, useQuic %b, useMemoryCache %b, useProfile %b", new Object[] { paramString, Boolean.valueOf(paramBoolean), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
              paramJSONObject = new com.tencent.mm.plugin.appbrand.o.a.b(paramc.kjg, (String)localObject1, str, (String)???, paramc.luC, paramc.kXC, paramBoolean, bool1, bool2, bool3, new b.1(paramc, paramString, parama1));
              paramJSONObject.lWV = ???;
              paramJSONObject.timeout = paramInt;
              paramJSONObject.isRunning = true;
              paramJSONObject.lWb = ???;
              paramJSONObject.lWW = i;
              paramJSONObject.lVz = paramc.lVz;
              paramJSONObject.iFB = paramString;
              paramJSONObject.lWg = "createDownloadTask";
              synchronized (paramc.lVC)
              {
                paramc.lVC.add(paramJSONObject);
              }
            }
          }
        }
        synchronized (paramc.lVB)
        {
          if (!paramc.lVB.containsKey(localObject1))
          {
            ??? = new ConcurrentLinkedQueue();
            paramc.lVB.put(localObject1, ???);
            ???.offer(paramJSONObject);
            if ((paramc.lVB.get(localObject1) != null) && (((ConcurrentLinkedQueue)paramc.lVB.get(localObject1)).size() > 1))
            {
              ad.i("MicroMsg.AppBrandNetworkDownload", "hy: more than one same url in the queue, just add and wait");
              AppMethodBeat.o(179509);
              return;
              paramc = finally;
              AppMethodBeat.o(179509);
              throw paramc;
              paramc = finally;
              AppMethodBeat.o(179509);
              throw paramc;
            }
          }
          else
          {
            ??? = (ConcurrentLinkedQueue)paramc.lVB.get(localObject1);
          }
        }
        paramc.SE((String)localObject1);
      }
      AppMethodBeat.o(179509);
      return;
    }
  }
  
  public final void a(final com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, final String paramString)
  {
    AppMethodBeat.i(179508);
    ad.d("MicroMsg.BaseCreateDownloadTask", "JsApiCreateDownloadTask");
    Object localObject;
    if (!this.kXn.getAndSet(true))
    {
      if (this.kXB != null) {
        this.kXC = this.kXB.aXU();
      }
      if (this.kXC)
      {
        localObject = (com.tencent.mm.plugin.appbrand.o.a)paramc.ar(com.tencent.mm.plugin.appbrand.o.a.class);
        if (localObject != null) {
          break label174;
        }
        ad.e("MicroMsg.BaseCreateDownloadTask", "setupRequestMode config not found, setUserCertVerify false appId(%s)", new Object[] { paramc.getAppId() });
        CronetLogic.setUserCertVerify(false);
      }
    }
    com.tencent.mm.plugin.appbrand.o.a locala;
    Map localMap;
    String str;
    for (;;)
    {
      localObject = new b.a()
      {
        private JSONObject kXD;
        
        public final void C(JSONObject paramAnonymousJSONObject)
        {
          AppMethodBeat.i(179505);
          if (paramAnonymousJSONObject == null)
          {
            AppMethodBeat.o(179505);
            return;
          }
          if (paramAnonymousJSONObject.optBoolean("__AppBrandRemoteDebugRequestHeader__"))
          {
            if (!((com.tencent.mm.plugin.appbrand.o.a)paramc.ar(com.tencent.mm.plugin.appbrand.o.a.class)).cms)
            {
              AppMethodBeat.o(179505);
              return;
            }
            paramAnonymousJSONObject.remove("__AppBrandRemoteDebugRequestHeader__");
            m localm = new m();
            localm.djZ.dka = "download";
            localm.djZ.dkc = paramAnonymousJSONObject;
            localm.djZ.dkb = paramString;
            com.tencent.mm.sdk.b.a.IbL.l(localm);
            AppMethodBeat.o(179505);
            return;
          }
          this.kXD = paramAnonymousJSONObject;
          paramAnonymousJSONObject = new HashMap();
          paramAnonymousJSONObject.put("downloadTaskId", paramString);
          paramAnonymousJSONObject.put("state", "headersReceived");
          paramAnonymousJSONObject.put("header", this.kXD);
          paramAnonymousJSONObject = new JSONObject(paramAnonymousJSONObject).toString();
          new a.a().h(paramc).Pi(paramAnonymousJSONObject).a(a.this.kXd.Pq(paramString));
          AppMethodBeat.o(179505);
        }
        
        public final void a(int paramAnonymousInt1, String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt2, long paramAnonymousLong, Map paramAnonymousMap)
        {
          AppMethodBeat.i(179502);
          ad.i("MicroMsg.BaseCreateDownloadTask", "onDownloadResultWithCode errMsg = %d, mimeType = %s, filePath = %s, statusCode = %d, dataLength = %d", new Object[] { Integer.valueOf(paramAnonymousInt1), paramAnonymousString1, paramAnonymousString2, Integer.valueOf(paramAnonymousInt2), Long.valueOf(paramAnonymousLong) });
          if (!bt.isNullOrNil(this.ivl))
          {
            paramAnonymousString1 = ak.a(paramc, new e(paramAnonymousString2), this.ivl, null);
            if ((com.tencent.mm.plugin.appbrand.o.b.FAILED == paramAnonymousInt1) || (!"ok".equals(paramAnonymousString1)))
            {
              if (a.i(paramc, paramString))
              {
                AppMethodBeat.o(179502);
                return;
              }
              a.this.b(paramc, paramString, paramAnonymousString1);
              AppMethodBeat.o(179502);
              return;
            }
            ad.i("MicroMsg.BaseCreateDownloadTask", "onDownloadResultWithCode filePath %s", new Object[] { this.ivl });
            paramAnonymousString1 = new HashMap();
            paramAnonymousString1.put("downloadTaskId", paramString);
            paramAnonymousString1.put("filePath", this.ivl);
            paramAnonymousString1.put("dataLength", Long.valueOf(paramAnonymousLong));
            paramAnonymousString1.put("statusCode", Integer.valueOf(paramAnonymousInt2));
            paramAnonymousString1.put("state", "success");
            if (this.kXD != null) {
              paramAnonymousString1.put("header", this.kXD);
            }
            if ((paramAnonymousMap != null) && (paramAnonymousMap.size() > 0)) {
              paramAnonymousString1.put("profile", paramAnonymousMap);
            }
            paramAnonymousString1 = new JSONObject(paramAnonymousString1).toString();
            new a.a().h(paramc).Pi(paramAnonymousString1).a(a.this.kXd.Pq(paramString));
            a.this.kXd.remove(paramString);
            AppMethodBeat.o(179502);
            return;
          }
          com.tencent.mm.plugin.appbrand.jsapi.c localc = paramc;
          String str2 = d.aMq(paramAnonymousString1);
          String str1 = str2;
          if (bt.isNullOrNil(str2))
          {
            str1 = str2;
            if ("audio/mp4".equals(paramAnonymousString1)) {
              str1 = "mp4";
            }
          }
          paramAnonymousString1 = new i();
          if (localc.Fg().a(new e(paramAnonymousString2), str1, true, paramAnonymousString1) != l.jMv) {
            paramAnonymousString1 = null;
          }
          while ((paramAnonymousInt1 == com.tencent.mm.plugin.appbrand.o.b.FAILED) || (paramAnonymousString1 == null)) {
            if (a.i(paramc, paramString))
            {
              AppMethodBeat.o(179502);
              return;
              paramAnonymousString1 = (String)paramAnonymousString1.value;
            }
            else
            {
              a.this.b(paramc, paramString, "download fail");
              AppMethodBeat.o(179502);
              return;
            }
          }
          ad.i("MicroMsg.BaseCreateDownloadTask", "onDownloadResultWithCode localId %s", new Object[] { paramAnonymousString1 });
          paramAnonymousString2 = new HashMap();
          paramAnonymousString2.put("downloadTaskId", paramString);
          paramAnonymousString2.put("tempFilePath", paramAnonymousString1);
          paramAnonymousString2.put("dataLength", Long.valueOf(paramAnonymousLong));
          paramAnonymousString2.put("statusCode", Integer.valueOf(paramAnonymousInt2));
          paramAnonymousString2.put("state", "success");
          if (this.kXD != null) {
            paramAnonymousString2.put("header", this.kXD);
          }
          if ((paramAnonymousMap != null) && (paramAnonymousMap.size() > 0)) {
            paramAnonymousString2.put("profile", paramAnonymousMap);
          }
          paramAnonymousString1 = new JSONObject(paramAnonymousString2).toString();
          new a.a().h(paramc).Pi(paramAnonymousString1).a(a.this.kXd.Pq(paramString));
          a.this.kXd.remove(paramString);
          AppMethodBeat.o(179502);
        }
        
        public final void ae(int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(187745);
          ad.i("MicroMsg.BaseCreateDownloadTask", "onDownloadError  downloadTaskId = %s, errMsg = %d, error = %s", new Object[] { paramString, Integer.valueOf(paramAnonymousInt), paramAnonymousString });
          if (a.i(paramc, paramString))
          {
            AppMethodBeat.o(187745);
            return;
          }
          a.this.b(paramc, paramString, paramAnonymousString);
          AppMethodBeat.o(187745);
        }
        
        public final void g(int paramAnonymousInt, long paramAnonymousLong1, long paramAnonymousLong2)
        {
          AppMethodBeat.i(179503);
          Object localObject = new HashMap();
          ((Map)localObject).put("downloadTaskId", paramString);
          ((Map)localObject).put("state", "progressUpdate");
          ((Map)localObject).put("progress", Integer.valueOf(paramAnonymousInt));
          ((Map)localObject).put("totalBytesWritten", Long.valueOf(paramAnonymousLong1));
          ((Map)localObject).put("totalBytesExpectedToWrite", Long.valueOf(paramAnonymousLong2));
          localObject = new JSONObject((Map)localObject).toString();
          new a.a().h(paramc).Pi((String)localObject).a(a.this.kXd.Pq(paramString));
          AppMethodBeat.o(179503);
        }
      };
      locala = (com.tencent.mm.plugin.appbrand.o.a)paramc.ar(com.tencent.mm.plugin.appbrand.o.a.class);
      localMap = j.a(paramJSONObject, locala);
      str = paramJSONObject.optString("url");
      if (!bt.isNullOrNil(str)) {
        break;
      }
      ad.i("MicroMsg.BaseCreateDownloadTask", "url is null");
      b(paramc, paramString, "url is null or nil");
      AppMethodBeat.o(179508);
      return;
      label174:
      ad.i("MicroMsg.BaseCreateDownloadTask", "setupRequestMode(%b),appId(%s)", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.appbrand.o.a)localObject).lVw), paramc.getAppId() });
      CronetLogic.setUserCertVerify(((com.tencent.mm.plugin.appbrand.o.a)localObject).lVw);
    }
    if (paramJSONObject.optBoolean("__skipDomainCheck__")) {}
    for (boolean bool = false; (bool) && (!j.c(locala.cmY, str)); bool = locala.lVl)
    {
      ad.i("MicroMsg.BaseCreateDownloadTask", "not in domain url %s", new Object[] { str });
      b(paramc, paramString, "url not in domain list");
      AppMethodBeat.o(179508);
      return;
    }
    if (locala.cmO <= 0) {
      ad.i("MicroMsg.BaseCreateDownloadTask", "maxDownloadConcurrent <= 0 ");
    }
    int j = 60000;
    int k = paramJSONObject.optInt("timeout", 0);
    int i = k;
    if (k <= 0) {
      i = j.a(locala, 3);
    }
    if (i > 0) {
      j = i;
    }
    ad.i("MicroMsg.BaseCreateDownloadTask", "lm:configTimeout: %d,timeout: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    a(paramc, locala, bool, paramJSONObject, j, localMap, (b.a)localObject, paramString);
    AppMethodBeat.o(179508);
  }
  
  public final String aOC()
  {
    AppMethodBeat.i(179507);
    Object localObject = new StringBuilder();
    com.tencent.mm.plugin.appbrand.o.c.btf();
    localObject = com.tencent.mm.plugin.appbrand.o.c.bte();
    AppMethodBeat.o(179507);
    return localObject;
  }
  
  public final String aeJ()
  {
    return "downloadTaskId";
  }
  
  public final void b(com.tencent.mm.plugin.appbrand.jsapi.c paramc, String paramString1, String paramString2)
  {
    AppMethodBeat.i(179510);
    ad.w("MicroMsg.BaseCreateDownloadTask", "sendFailMsg, downloadTaskId = %s, errMsg = %s", new Object[] { paramString1, paramString2 });
    HashMap localHashMap = new HashMap();
    localHashMap.put("downloadTaskId", paramString1);
    localHashMap.put("state", "fail");
    localHashMap.put("errMsg", paramString2);
    paramString2 = new JSONObject(localHashMap).toString();
    new a().h(paramc).Pi(paramString2).a(this.kXd.Pq(paramString1));
    this.kXd.remove(paramString1);
    AppMethodBeat.o(179510);
  }
  
  public static final class a
    extends at
  {
    public static final int CTRL_INDEX = 271;
    public static final String NAME = "onDownloadTaskStateChange";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.m.a.a
 * JD-Core Version:    0.7.0.1
 */