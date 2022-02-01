package com.tencent.mm.plugin.appbrand.jsapi.j.a;

import com.tencent.mars.cdn.CronetLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.m;
import com.tencent.mm.plugin.appbrand.aa.i;
import com.tencent.mm.plugin.appbrand.appstorage.l;
import com.tencent.mm.plugin.appbrand.appstorage.p;
import com.tencent.mm.plugin.appbrand.jsapi.ar;
import com.tencent.mm.plugin.appbrand.jsapi.file.ak;
import com.tencent.mm.plugin.appbrand.q.b.1;
import com.tencent.mm.plugin.appbrand.q.b.a;
import com.tencent.mm.plugin.appbrand.q.b.b;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.sdk.f.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class a
  implements com.tencent.mm.plugin.appbrand.jsapi.j.e
{
  private b.b kaH;
  protected boolean kaI;
  com.tencent.mm.plugin.appbrand.jsapi.j.a kaj;
  private final AtomicBoolean kat;
  
  public a(b.b paramb, com.tencent.mm.plugin.appbrand.jsapi.j.a parama)
  {
    AppMethodBeat.i(190826);
    this.kaI = false;
    this.kat = new AtomicBoolean(false);
    this.kaH = paramb;
    this.kaj = parama;
    AppMethodBeat.o(190826);
  }
  
  public void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, com.tencent.mm.plugin.appbrand.q.a arg2, boolean paramBoolean, JSONObject paramJSONObject, int paramInt, Map<String, String> arg6, b.a parama1, String paramString)
  {
    AppMethodBeat.i(179509);
    Object localObject1 = com.tencent.mm.plugin.appbrand.q.c.bim().KY(paramc.getAppId());
    if (localObject1 == null)
    {
      localObject1 = new com.tencent.mm.plugin.appbrand.q.b(paramc, this.kaI);
      ??? = com.tencent.mm.plugin.appbrand.q.c.bim();
      paramc = paramc.getAppId();
      if (!((com.tencent.mm.plugin.appbrand.q.c)???).kUJ.containsKey(paramc)) {
        ((com.tencent.mm.plugin.appbrand.q.c)???).kUJ.put(paramc, localObject1);
      }
    }
    for (paramc = (com.tencent.mm.plugin.appbrand.jsapi.c)localObject1;; paramc = (com.tencent.mm.plugin.appbrand.jsapi.c)localObject1)
    {
      if (paramc != null)
      {
        ad.i("MicroMsg.BaseCreateDownloadTask", "before do download, checkDomains = %b, timeout %d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
        int i = ???.jcl;
        if (paramBoolean) {
          ??? = ???.cfK;
        }
        for (;;)
        {
          localObject1 = paramJSONObject.optString("url");
          ad.i("MicroMsg.AppBrandNetworkDownload", "download taskId:%s url:%s", new Object[] { paramString, localObject1 });
          localObject1 = j.Lh((String)localObject1);
          synchronized (paramc.kUF)
          {
            if (paramc.kUF.size() >= paramc.kUA)
            {
              parama1.ab(-1, "max_connected");
              ad.i("MicroMsg.AppBrandNetworkDownload", "max connected mDownloadTaskList.size():%d,mMaxConnected:%d", new Object[] { Integer.valueOf(paramc.kUF.size()), Integer.valueOf(paramc.kUA) });
              AppMethodBeat.o(179509);
              return;
              ??? = null;
            }
            else
            {
              ??? = paramJSONObject.optString("filePath");
              String str = paramc.kUB + ai.du((String)localObject1) + "temp" + System.currentTimeMillis();
              paramBoolean = paramJSONObject.optBoolean("enableHttp2", false);
              boolean bool1 = paramJSONObject.optBoolean("enableQuic", false);
              boolean bool2 = paramJSONObject.optBoolean("enableCache", false);
              boolean bool3 = paramJSONObject.optBoolean("enableProfile", true);
              ad.i("MicroMsg.AppBrandNetworkDownload", "download taskId %s,useHttp2 %b, useQuic %b, useMemoryCache %b, useProfile %b", new Object[] { paramString, Boolean.valueOf(paramBoolean), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
              paramJSONObject = new com.tencent.mm.plugin.appbrand.q.a.b(paramc.joJ, (String)localObject1, str, (String)???, paramc.kwo, paramc.kaI, paramBoolean, bool1, bool2, bool3, new b.1(paramc, paramString, parama1));
              paramJSONObject.kVX = ???;
              paramJSONObject.timeout = paramInt;
              paramJSONObject.isRunning = true;
              paramJSONObject.kVe = ???;
              paramJSONObject.kVY = i;
              paramJSONObject.kUC = paramc.kUC;
              paramJSONObject.hLO = paramString;
              paramJSONObject.kVj = "createDownloadTask";
              synchronized (paramc.kUF)
              {
                paramc.kUF.add(paramJSONObject);
              }
            }
          }
        }
        synchronized (paramc.kUE)
        {
          if (!paramc.kUE.containsKey(localObject1))
          {
            ??? = new ConcurrentLinkedQueue();
            paramc.kUE.put(localObject1, ???);
            ???.offer(paramJSONObject);
            if ((paramc.kUE.get(localObject1) != null) && (((ConcurrentLinkedQueue)paramc.kUE.get(localObject1)).size() > 1))
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
            ??? = (ConcurrentLinkedQueue)paramc.kUE.get(localObject1);
          }
        }
        paramc.KU((String)localObject1);
      }
      AppMethodBeat.o(179509);
      return;
    }
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, String paramString1, String paramString2)
  {
    AppMethodBeat.i(179510);
    ad.w("MicroMsg.BaseCreateDownloadTask", "sendFailMsg, downloadTaskId = %s, errMsg = %s", new Object[] { paramString1, paramString2 });
    HashMap localHashMap = new HashMap();
    localHashMap.put("downloadTaskId", paramString1);
    localHashMap.put("state", "fail");
    localHashMap.put("errMsg", paramString2);
    paramString2 = new JSONObject(localHashMap).toString();
    new a().h(paramc).HK(paramString2).a(this.kaj.II(paramString1));
    this.kaj.remove(paramString1);
    AppMethodBeat.o(179510);
  }
  
  public final void a(final com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, final String paramString)
  {
    AppMethodBeat.i(179508);
    ad.d("MicroMsg.BaseCreateDownloadTask", "JsApiCreateDownloadTask");
    Object localObject;
    if (!this.kat.getAndSet(true))
    {
      if (this.kaH != null) {
        this.kaI = this.kaH.aNS();
      }
      if (this.kaI)
      {
        localObject = (com.tencent.mm.plugin.appbrand.q.a)paramc.ar(com.tencent.mm.plugin.appbrand.q.a.class);
        if (localObject != null) {
          break label174;
        }
        ad.e("MicroMsg.BaseCreateDownloadTask", "setupRequestMode config not found, setUserCertVerify false appId(%s)", new Object[] { paramc.getAppId() });
        CronetLogic.setUserCertVerify(false);
      }
    }
    com.tencent.mm.plugin.appbrand.q.a locala;
    Map localMap;
    String str;
    for (;;)
    {
      localObject = new b.a()
      {
        private JSONObject kaJ;
        
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
            if (!((com.tencent.mm.plugin.appbrand.q.a)paramc.ar(com.tencent.mm.plugin.appbrand.q.a.class)).cfe)
            {
              AppMethodBeat.o(179505);
              return;
            }
            paramAnonymousJSONObject.remove("__AppBrandRemoteDebugRequestHeader__");
            m localm = new m();
            localm.dbl.dbm = "download";
            localm.dbl.dbo = paramAnonymousJSONObject;
            localm.dbl.dbn = paramString;
            com.tencent.mm.sdk.b.a.ESL.l(localm);
            AppMethodBeat.o(179505);
            return;
          }
          this.kaJ = paramAnonymousJSONObject;
          paramAnonymousJSONObject = new HashMap();
          paramAnonymousJSONObject.put("downloadTaskId", paramString);
          paramAnonymousJSONObject.put("state", "headersReceived");
          paramAnonymousJSONObject.put("header", this.kaJ);
          paramAnonymousJSONObject = new JSONObject(paramAnonymousJSONObject).toString();
          new a.a().h(paramc).HK(paramAnonymousJSONObject).a(a.this.kaj.II(paramString));
          AppMethodBeat.o(179505);
        }
        
        public final void a(int paramAnonymousInt1, String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt2, long paramAnonymousLong, Map paramAnonymousMap)
        {
          AppMethodBeat.i(179502);
          ad.i("MicroMsg.BaseCreateDownloadTask", "onDownloadResultWithCode errMsg = %d, mimeType = %s, filePath = %s, statusCode = %d, dataLength = %d", new Object[] { Integer.valueOf(paramAnonymousInt1), paramAnonymousString1, paramAnonymousString2, Integer.valueOf(paramAnonymousInt2), Long.valueOf(paramAnonymousLong) });
          if (!bt.isNullOrNil(this.hBo))
          {
            paramAnonymousString1 = ak.a(paramc, new com.tencent.mm.vfs.e(paramAnonymousString2), this.hBo, null);
            if ((com.tencent.mm.plugin.appbrand.q.b.FAILED == paramAnonymousInt1) || (!"ok".equals(paramAnonymousString1)))
            {
              if (a.i(paramc, paramString))
              {
                AppMethodBeat.o(179502);
                return;
              }
              a.this.a(paramc, paramString, paramAnonymousString1);
              AppMethodBeat.o(179502);
              return;
            }
            ad.i("MicroMsg.BaseCreateDownloadTask", "onDownloadResultWithCode filePath %s", new Object[] { this.hBo });
            paramAnonymousString1 = new HashMap();
            paramAnonymousString1.put("downloadTaskId", paramString);
            paramAnonymousString1.put("filePath", this.hBo);
            paramAnonymousString1.put("dataLength", Long.valueOf(paramAnonymousLong));
            paramAnonymousString1.put("statusCode", Integer.valueOf(paramAnonymousInt2));
            paramAnonymousString1.put("state", "success");
            if (this.kaJ != null) {
              paramAnonymousString1.put("header", this.kaJ);
            }
            if ((paramAnonymousMap != null) && (paramAnonymousMap.size() > 0)) {
              paramAnonymousString1.put("profile", paramAnonymousMap);
            }
            paramAnonymousString1 = new JSONObject(paramAnonymousString1).toString();
            new a.a().h(paramc).HK(paramAnonymousString1).a(a.this.kaj.II(paramString));
            a.this.kaj.remove(paramString);
            AppMethodBeat.o(179502);
            return;
          }
          com.tencent.mm.plugin.appbrand.jsapi.c localc = paramc;
          String str2 = d.aBx(paramAnonymousString1);
          String str1 = str2;
          if (bt.isNullOrNil(str2))
          {
            str1 = str2;
            if ("audio/mp4".equals(paramAnonymousString1)) {
              str1 = "mp4";
            }
          }
          paramAnonymousString1 = new i();
          if (localc.Ee().a(new com.tencent.mm.vfs.e(paramAnonymousString2), str1, true, paramAnonymousString1) != l.iSq) {
            paramAnonymousString1 = null;
          }
          while ((paramAnonymousInt1 == com.tencent.mm.plugin.appbrand.q.b.FAILED) || (paramAnonymousString1 == null)) {
            if (a.i(paramc, paramString))
            {
              AppMethodBeat.o(179502);
              return;
              paramAnonymousString1 = (String)paramAnonymousString1.value;
            }
            else
            {
              a.this.a(paramc, paramString, "download fail");
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
          if (this.kaJ != null) {
            paramAnonymousString2.put("header", this.kaJ);
          }
          if ((paramAnonymousMap != null) && (paramAnonymousMap.size() > 0)) {
            paramAnonymousString2.put("profile", paramAnonymousMap);
          }
          paramAnonymousString1 = new JSONObject(paramAnonymousString2).toString();
          new a.a().h(paramc).HK(paramAnonymousString1).a(a.this.kaj.II(paramString));
          a.this.kaj.remove(paramString);
          AppMethodBeat.o(179502);
        }
        
        public final void ab(int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(190825);
          ad.i("MicroMsg.BaseCreateDownloadTask", "onDownloadError  downloadTaskId = %s, errMsg = %d, error = %s", new Object[] { paramString, Integer.valueOf(paramAnonymousInt), paramAnonymousString });
          if (a.i(paramc, paramString))
          {
            AppMethodBeat.o(190825);
            return;
          }
          a.this.a(paramc, paramString, paramAnonymousString);
          AppMethodBeat.o(190825);
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
          new a.a().h(paramc).HK((String)localObject).a(a.this.kaj.II(paramString));
          AppMethodBeat.o(179503);
        }
      };
      locala = (com.tencent.mm.plugin.appbrand.q.a)paramc.ar(com.tencent.mm.plugin.appbrand.q.a.class);
      localMap = j.a(paramJSONObject, locala);
      str = paramJSONObject.optString("url");
      if (!bt.isNullOrNil(str)) {
        break;
      }
      ad.i("MicroMsg.BaseCreateDownloadTask", "url is null");
      a(paramc, paramString, "url is null or nil");
      AppMethodBeat.o(179508);
      return;
      label174:
      ad.i("MicroMsg.BaseCreateDownloadTask", "setupRequestMode(%b),appId(%s)", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.appbrand.q.a)localObject).kUz), paramc.getAppId() });
      CronetLogic.setUserCertVerify(((com.tencent.mm.plugin.appbrand.q.a)localObject).kUz);
    }
    if (paramJSONObject.optBoolean("__skipDomainCheck__")) {}
    for (boolean bool = false; (bool) && (!j.c(locala.cfK, str)); bool = locala.kUo)
    {
      ad.i("MicroMsg.BaseCreateDownloadTask", "not in domain url %s", new Object[] { str });
      a(paramc, paramString, "url not in domain list");
      AppMethodBeat.o(179508);
      return;
    }
    if (locala.cfA <= 0) {
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
  
  public final String aEB()
  {
    AppMethodBeat.i(179507);
    Object localObject = new StringBuilder();
    com.tencent.mm.plugin.appbrand.q.c.bim();
    localObject = com.tencent.mm.plugin.appbrand.q.c.bil();
    AppMethodBeat.o(179507);
    return localObject;
  }
  
  public final String abh()
  {
    return "downloadTaskId";
  }
  
  public static final class a
    extends ar
  {
    public static final int CTRL_INDEX = 271;
    public static final String NAME = "onDownloadTaskStateChange";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.j.a.a
 * JD-Core Version:    0.7.0.1
 */