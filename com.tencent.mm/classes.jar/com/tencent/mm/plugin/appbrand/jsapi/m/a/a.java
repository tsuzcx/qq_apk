package com.tencent.mm.plugin.appbrand.jsapi.m.a;

import com.tencent.mars.cdn.CronetLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.jsapi.at;
import com.tencent.mm.plugin.appbrand.jsapi.base.h;
import com.tencent.mm.plugin.appbrand.jsapi.file.am;
import com.tencent.mm.plugin.appbrand.o.b.1;
import com.tencent.mm.plugin.appbrand.o.b.a;
import com.tencent.mm.plugin.appbrand.o.b.b;
import com.tencent.mm.plugin.appbrand.o.j;
import com.tencent.mm.plugin.appbrand.y.i;
import com.tencent.mm.sdk.f.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class a
  implements h
{
  com.tencent.mm.plugin.appbrand.jsapi.base.a laM;
  private final AtomicBoolean laW;
  private b.b lbk;
  protected boolean lbl;
  
  public a(b.b paramb, com.tencent.mm.plugin.appbrand.jsapi.base.a parama)
  {
    AppMethodBeat.i(193475);
    this.lbl = false;
    this.laW = new AtomicBoolean(false);
    this.lbk = paramb;
    this.laM = parama;
    AppMethodBeat.o(193475);
  }
  
  public void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, com.tencent.mm.plugin.appbrand.o.a arg2, boolean paramBoolean, JSONObject paramJSONObject, int paramInt, Map<String, String> arg6, b.a parama1, String paramString)
  {
    AppMethodBeat.i(179509);
    Object localObject1 = com.tencent.mm.plugin.appbrand.o.c.btQ().Tr(paramc.getAppId());
    if (localObject1 == null)
    {
      localObject1 = new com.tencent.mm.plugin.appbrand.o.b(paramc, this.lbl);
      ??? = com.tencent.mm.plugin.appbrand.o.c.btQ();
      paramc = paramc.getAppId();
      if (!((com.tencent.mm.plugin.appbrand.o.c)???).mak.containsKey(paramc)) {
        ((com.tencent.mm.plugin.appbrand.o.c)???).mak.put(paramc, localObject1);
      }
    }
    for (paramc = (com.tencent.mm.plugin.appbrand.jsapi.c)localObject1;; paramc = (com.tencent.mm.plugin.appbrand.jsapi.c)localObject1)
    {
      if (paramc != null)
      {
        ae.i("MicroMsg.BaseCreateDownloadTask", "before do download, checkDomains = %b, timeout %d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
        int i = ???.jZJ;
        if (paramBoolean) {
          ??? = ???.cna;
        }
        for (;;)
        {
          localObject1 = paramJSONObject.optString("url");
          ae.i("MicroMsg.AppBrandNetworkDownload", "download taskId:%s url:%s", new Object[] { paramString, localObject1 });
          localObject1 = j.TB((String)localObject1);
          synchronized (paramc.mag)
          {
            if (paramc.mag.size() >= paramc.maa)
            {
              parama1.ae(-1, "max_connected");
              ae.i("MicroMsg.AppBrandNetworkDownload", "max connected mDownloadTaskList.size():%d,mMaxConnected:%d", new Object[] { Integer.valueOf(paramc.mag.size()), Integer.valueOf(paramc.maa) });
              AppMethodBeat.o(179509);
              return;
              ??? = null;
            }
            else
            {
              ??? = paramJSONObject.optString("filePath");
              String str = paramc.mab + aj.ej((String)localObject1) + "temp" + System.currentTimeMillis();
              paramBoolean = paramJSONObject.optBoolean("enableHttp2", false);
              boolean bool1 = paramJSONObject.optBoolean("enableQuic", false);
              boolean bool2 = paramJSONObject.optBoolean("enableCache", false);
              boolean bool3 = paramJSONObject.optBoolean("enableProfile", true);
              ae.i("MicroMsg.AppBrandNetworkDownload", "download taskId %s,useHttp2 %b, useQuic %b, useMemoryCache %b, useProfile %b", new Object[] { paramString, Boolean.valueOf(paramBoolean), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
              paramJSONObject = new com.tencent.mm.plugin.appbrand.o.a.b(paramc.kmw, (String)localObject1, str, (String)???, paramc.lza, paramc.lbl, paramBoolean, bool1, bool2, bool3, new b.1(paramc, paramString, parama1));
              paramJSONObject.mbB = ???;
              paramJSONObject.timeout = paramInt;
              paramJSONObject.isRunning = true;
              paramJSONObject.maH = ???;
              paramJSONObject.mbC = i;
              paramJSONObject.mad = paramc.mad;
              paramJSONObject.iIu = paramString;
              paramJSONObject.maM = "createDownloadTask";
              synchronized (paramc.mag)
              {
                paramc.mag.add(paramJSONObject);
              }
            }
          }
        }
        synchronized (paramc.maf)
        {
          if (!paramc.maf.containsKey(localObject1))
          {
            ??? = new ConcurrentLinkedQueue();
            paramc.maf.put(localObject1, ???);
            ???.offer(paramJSONObject);
            if ((paramc.maf.get(localObject1) != null) && (((ConcurrentLinkedQueue)paramc.maf.get(localObject1)).size() > 1))
            {
              ae.i("MicroMsg.AppBrandNetworkDownload", "hy: more than one same url in the queue, just add and wait");
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
            ??? = (ConcurrentLinkedQueue)paramc.maf.get(localObject1);
          }
        }
        paramc.Tn((String)localObject1);
      }
      AppMethodBeat.o(179509);
      return;
    }
  }
  
  public final void a(final com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, final String paramString)
  {
    AppMethodBeat.i(179508);
    ae.d("MicroMsg.BaseCreateDownloadTask", "JsApiCreateDownloadTask");
    Object localObject;
    if (!this.laW.getAndSet(true))
    {
      if (this.lbk != null) {
        this.lbl = this.lbk.aYn();
      }
      if (this.lbl)
      {
        localObject = (com.tencent.mm.plugin.appbrand.o.a)paramc.ar(com.tencent.mm.plugin.appbrand.o.a.class);
        if (localObject != null) {
          break label174;
        }
        ae.e("MicroMsg.BaseCreateDownloadTask", "setupRequestMode config not found, setUserCertVerify false appId(%s)", new Object[] { paramc.getAppId() });
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
        private JSONObject lbm;
        
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
            if (!((com.tencent.mm.plugin.appbrand.o.a)paramc.ar(com.tencent.mm.plugin.appbrand.o.a.class)).cmu)
            {
              AppMethodBeat.o(179505);
              return;
            }
            paramAnonymousJSONObject.remove("__AppBrandRemoteDebugRequestHeader__");
            com.tencent.mm.g.a.m localm = new com.tencent.mm.g.a.m();
            localm.dlb.dlc = "download";
            localm.dlb.dle = paramAnonymousJSONObject;
            localm.dlb.dld = paramString;
            com.tencent.mm.sdk.b.a.IvT.l(localm);
            AppMethodBeat.o(179505);
            return;
          }
          this.lbm = paramAnonymousJSONObject;
          paramAnonymousJSONObject = new HashMap();
          paramAnonymousJSONObject.put("downloadTaskId", paramString);
          paramAnonymousJSONObject.put("state", "headersReceived");
          paramAnonymousJSONObject.put("header", this.lbm);
          paramAnonymousJSONObject = new JSONObject(paramAnonymousJSONObject).toString();
          new a.a().h(paramc).PQ(paramAnonymousJSONObject).a(a.this.laM.PY(paramString));
          AppMethodBeat.o(179505);
        }
        
        public final void a(int paramAnonymousInt1, String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt2, long paramAnonymousLong, Map paramAnonymousMap)
        {
          AppMethodBeat.i(179502);
          ae.i("MicroMsg.BaseCreateDownloadTask", "onDownloadResultWithCode errMsg = %d, mimeType = %s, filePath = %s, statusCode = %d, dataLength = %d", new Object[] { Integer.valueOf(paramAnonymousInt1), paramAnonymousString1, paramAnonymousString2, Integer.valueOf(paramAnonymousInt2), Long.valueOf(paramAnonymousLong) });
          if (!bu.isNullOrNil(this.iye))
          {
            paramAnonymousString1 = am.a(paramc, new k(paramAnonymousString2), this.iye, null);
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
            ae.i("MicroMsg.BaseCreateDownloadTask", "onDownloadResultWithCode filePath %s", new Object[] { this.iye });
            paramAnonymousString1 = new HashMap();
            paramAnonymousString1.put("downloadTaskId", paramString);
            paramAnonymousString1.put("filePath", this.iye);
            paramAnonymousString1.put("dataLength", Long.valueOf(paramAnonymousLong));
            paramAnonymousString1.put("statusCode", Integer.valueOf(paramAnonymousInt2));
            paramAnonymousString1.put("state", "success");
            if (this.lbm != null) {
              paramAnonymousString1.put("header", this.lbm);
            }
            if ((paramAnonymousMap != null) && (paramAnonymousMap.size() > 0)) {
              paramAnonymousString1.put("profile", paramAnonymousMap);
            }
            paramAnonymousString1 = new JSONObject(paramAnonymousString1).toString();
            new a.a().h(paramc).PQ(paramAnonymousString1).a(a.this.laM.PY(paramString));
            a.this.laM.remove(paramString);
            AppMethodBeat.o(179502);
            return;
          }
          com.tencent.mm.plugin.appbrand.jsapi.c localc = paramc;
          String str2 = d.aNM(paramAnonymousString1);
          String str1 = str2;
          if (bu.isNullOrNil(str2))
          {
            str1 = str2;
            if ("audio/mp4".equals(paramAnonymousString1)) {
              str1 = "mp4";
            }
          }
          paramAnonymousString1 = new i();
          if (localc.Fl().a(new k(paramAnonymousString2), str1, true, paramAnonymousString1) != com.tencent.mm.plugin.appbrand.appstorage.m.jPM) {
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
          ae.i("MicroMsg.BaseCreateDownloadTask", "onDownloadResultWithCode localId %s", new Object[] { paramAnonymousString1 });
          paramAnonymousString2 = new HashMap();
          paramAnonymousString2.put("downloadTaskId", paramString);
          paramAnonymousString2.put("tempFilePath", paramAnonymousString1);
          paramAnonymousString2.put("dataLength", Long.valueOf(paramAnonymousLong));
          paramAnonymousString2.put("statusCode", Integer.valueOf(paramAnonymousInt2));
          paramAnonymousString2.put("state", "success");
          if (this.lbm != null) {
            paramAnonymousString2.put("header", this.lbm);
          }
          if ((paramAnonymousMap != null) && (paramAnonymousMap.size() > 0)) {
            paramAnonymousString2.put("profile", paramAnonymousMap);
          }
          paramAnonymousString1 = new JSONObject(paramAnonymousString2).toString();
          new a.a().h(paramc).PQ(paramAnonymousString1).a(a.this.laM.PY(paramString));
          a.this.laM.remove(paramString);
          AppMethodBeat.o(179502);
        }
        
        public final void ae(int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(193474);
          ae.i("MicroMsg.BaseCreateDownloadTask", "onDownloadError  downloadTaskId = %s, errMsg = %d, error = %s", new Object[] { paramString, Integer.valueOf(paramAnonymousInt), paramAnonymousString });
          if (a.i(paramc, paramString))
          {
            AppMethodBeat.o(193474);
            return;
          }
          a.this.b(paramc, paramString, paramAnonymousString);
          AppMethodBeat.o(193474);
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
          new a.a().h(paramc).PQ((String)localObject).a(a.this.laM.PY(paramString));
          AppMethodBeat.o(179503);
        }
      };
      locala = (com.tencent.mm.plugin.appbrand.o.a)paramc.ar(com.tencent.mm.plugin.appbrand.o.a.class);
      localMap = j.a(paramJSONObject, locala);
      str = paramJSONObject.optString("url");
      if (!bu.isNullOrNil(str)) {
        break;
      }
      ae.i("MicroMsg.BaseCreateDownloadTask", "url is null");
      b(paramc, paramString, "url is null or nil");
      AppMethodBeat.o(179508);
      return;
      label174:
      ae.i("MicroMsg.BaseCreateDownloadTask", "setupRequestMode(%b),appId(%s)", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.appbrand.o.a)localObject).lZZ), paramc.getAppId() });
      CronetLogic.setUserCertVerify(((com.tencent.mm.plugin.appbrand.o.a)localObject).lZZ);
    }
    if (paramJSONObject.optBoolean("__skipDomainCheck__")) {}
    for (boolean bool = false; (bool) && (!j.c(locala.cna, str)); bool = locala.lZO)
    {
      ae.i("MicroMsg.BaseCreateDownloadTask", "not in domain url %s", new Object[] { str });
      b(paramc, paramString, "url not in domain list");
      AppMethodBeat.o(179508);
      return;
    }
    if (locala.cmQ <= 0) {
      ae.i("MicroMsg.BaseCreateDownloadTask", "maxDownloadConcurrent <= 0 ");
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
    ae.i("MicroMsg.BaseCreateDownloadTask", "lm:configTimeout: %d,timeout: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    a(paramc, locala, bool, paramJSONObject, j, localMap, (b.a)localObject, paramString);
    AppMethodBeat.o(179508);
  }
  
  public final String aOZ()
  {
    AppMethodBeat.i(179507);
    Object localObject = new StringBuilder();
    com.tencent.mm.plugin.appbrand.o.c.btQ();
    localObject = com.tencent.mm.plugin.appbrand.o.c.btP();
    AppMethodBeat.o(179507);
    return localObject;
  }
  
  public final String aeV()
  {
    return "downloadTaskId";
  }
  
  public final void b(com.tencent.mm.plugin.appbrand.jsapi.c paramc, String paramString1, String paramString2)
  {
    AppMethodBeat.i(179510);
    ae.w("MicroMsg.BaseCreateDownloadTask", "sendFailMsg, downloadTaskId = %s, errMsg = %s", new Object[] { paramString1, paramString2 });
    HashMap localHashMap = new HashMap();
    localHashMap.put("downloadTaskId", paramString1);
    localHashMap.put("state", "fail");
    localHashMap.put("errMsg", paramString2);
    paramString2 = new JSONObject(localHashMap).toString();
    new a().h(paramc).PQ(paramString2).a(this.laM.PY(paramString1));
    this.laM.remove(paramString1);
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