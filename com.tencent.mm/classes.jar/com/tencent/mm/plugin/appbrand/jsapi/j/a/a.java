package com.tencent.mm.plugin.appbrand.jsapi.j.a;

import com.tencent.mars.cdn.CronetLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.m;
import com.tencent.mm.plugin.appbrand.appstorage.l;
import com.tencent.mm.plugin.appbrand.appstorage.p;
import com.tencent.mm.plugin.appbrand.jsapi.ar;
import com.tencent.mm.plugin.appbrand.jsapi.file.ak;
import com.tencent.mm.plugin.appbrand.p.b.1;
import com.tencent.mm.plugin.appbrand.p.b.a;
import com.tencent.mm.plugin.appbrand.p.b.b;
import com.tencent.mm.plugin.appbrand.p.j;
import com.tencent.mm.plugin.appbrand.z.i;
import com.tencent.mm.sdk.f.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class a
  implements com.tencent.mm.plugin.appbrand.jsapi.j.e
{
  com.tencent.mm.plugin.appbrand.jsapi.j.a kAW;
  private final AtomicBoolean kBg;
  private b.b kBu;
  protected boolean kBv;
  
  public a(b.b paramb, com.tencent.mm.plugin.appbrand.jsapi.j.a parama)
  {
    AppMethodBeat.i(199905);
    this.kBv = false;
    this.kBg = new AtomicBoolean(false);
    this.kBu = paramb;
    this.kAW = parama;
    AppMethodBeat.o(199905);
  }
  
  public void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, com.tencent.mm.plugin.appbrand.p.a arg2, boolean paramBoolean, JSONObject paramJSONObject, int paramInt, Map<String, String> arg6, b.a parama1, String paramString)
  {
    AppMethodBeat.i(179509);
    Object localObject1 = com.tencent.mm.plugin.appbrand.p.c.bpg().Pg(paramc.getAppId());
    if (localObject1 == null)
    {
      localObject1 = new com.tencent.mm.plugin.appbrand.p.b(paramc, this.kBv);
      ??? = com.tencent.mm.plugin.appbrand.p.c.bpg();
      paramc = paramc.getAppId();
      if (!((com.tencent.mm.plugin.appbrand.p.c)???).lwt.containsKey(paramc)) {
        ((com.tencent.mm.plugin.appbrand.p.c)???).lwt.put(paramc, localObject1);
      }
    }
    for (paramc = (com.tencent.mm.plugin.appbrand.jsapi.c)localObject1;; paramc = (com.tencent.mm.plugin.appbrand.jsapi.c)localObject1)
    {
      if (paramc != null)
      {
        ac.i("MicroMsg.BaseCreateDownloadTask", "before do download, checkDomains = %b, timeout %d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
        int i = ???.jCy;
        if (paramBoolean) {
          ??? = ???.ccH;
        }
        for (;;)
        {
          localObject1 = paramJSONObject.optString("url");
          ac.i("MicroMsg.AppBrandNetworkDownload", "download taskId:%s url:%s", new Object[] { paramString, localObject1 });
          localObject1 = j.Pp((String)localObject1);
          synchronized (paramc.lwp)
          {
            if (paramc.lwp.size() >= paramc.lwk)
            {
              parama1.ac(-1, "max_connected");
              ac.i("MicroMsg.AppBrandNetworkDownload", "max connected mDownloadTaskList.size():%d,mMaxConnected:%d", new Object[] { Integer.valueOf(paramc.lwp.size()), Integer.valueOf(paramc.lwk) });
              AppMethodBeat.o(179509);
              return;
              ??? = null;
            }
            else
            {
              ??? = paramJSONObject.optString("filePath");
              String str = paramc.lwl + ah.dg((String)localObject1) + "temp" + System.currentTimeMillis();
              paramBoolean = paramJSONObject.optBoolean("enableHttp2", false);
              boolean bool1 = paramJSONObject.optBoolean("enableQuic", false);
              boolean bool2 = paramJSONObject.optBoolean("enableCache", false);
              boolean bool3 = paramJSONObject.optBoolean("enableProfile", true);
              ac.i("MicroMsg.AppBrandNetworkDownload", "download taskId %s,useHttp2 %b, useQuic %b, useMemoryCache %b, useProfile %b", new Object[] { paramString, Boolean.valueOf(paramBoolean), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
              paramJSONObject = new com.tencent.mm.plugin.appbrand.p.a.b(paramc.jOV, (String)localObject1, str, (String)???, paramc.kXC, paramc.kBv, paramBoolean, bool1, bool2, bool3, new b.1(paramc, paramString, parama1));
              paramJSONObject.lxH = ???;
              paramJSONObject.timeout = paramInt;
              paramJSONObject.isRunning = true;
              paramJSONObject.lwO = ???;
              paramJSONObject.lxI = i;
              paramJSONObject.lwm = paramc.lwm;
              paramJSONObject.imk = paramString;
              paramJSONObject.lwT = "createDownloadTask";
              synchronized (paramc.lwp)
              {
                paramc.lwp.add(paramJSONObject);
              }
            }
          }
        }
        synchronized (paramc.lwo)
        {
          if (!paramc.lwo.containsKey(localObject1))
          {
            ??? = new ConcurrentLinkedQueue();
            paramc.lwo.put(localObject1, ???);
            ???.offer(paramJSONObject);
            if ((paramc.lwo.get(localObject1) != null) && (((ConcurrentLinkedQueue)paramc.lwo.get(localObject1)).size() > 1))
            {
              ac.i("MicroMsg.AppBrandNetworkDownload", "hy: more than one same url in the queue, just add and wait");
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
            ??? = (ConcurrentLinkedQueue)paramc.lwo.get(localObject1);
          }
        }
        paramc.Pc((String)localObject1);
      }
      AppMethodBeat.o(179509);
      return;
    }
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, String paramString1, String paramString2)
  {
    AppMethodBeat.i(179510);
    ac.w("MicroMsg.BaseCreateDownloadTask", "sendFailMsg, downloadTaskId = %s, errMsg = %s", new Object[] { paramString1, paramString2 });
    HashMap localHashMap = new HashMap();
    localHashMap.put("downloadTaskId", paramString1);
    localHashMap.put("state", "fail");
    localHashMap.put("errMsg", paramString2);
    paramString2 = new JSONObject(localHashMap).toString();
    new a().h(paramc).LO(paramString2).a(this.kAW.MJ(paramString1));
    this.kAW.remove(paramString1);
    AppMethodBeat.o(179510);
  }
  
  public final void a(final com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, final String paramString)
  {
    AppMethodBeat.i(179508);
    ac.d("MicroMsg.BaseCreateDownloadTask", "JsApiCreateDownloadTask");
    Object localObject;
    if (!this.kBg.getAndSet(true))
    {
      if (this.kBu != null) {
        this.kBv = this.kBu.aUI();
      }
      if (this.kBv)
      {
        localObject = (com.tencent.mm.plugin.appbrand.p.a)paramc.ar(com.tencent.mm.plugin.appbrand.p.a.class);
        if (localObject != null) {
          break label174;
        }
        ac.e("MicroMsg.BaseCreateDownloadTask", "setupRequestMode config not found, setUserCertVerify false appId(%s)", new Object[] { paramc.getAppId() });
        CronetLogic.setUserCertVerify(false);
      }
    }
    com.tencent.mm.plugin.appbrand.p.a locala;
    Map localMap;
    String str;
    for (;;)
    {
      localObject = new b.a()
      {
        private JSONObject kBw;
        
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
            if (!((com.tencent.mm.plugin.appbrand.p.a)paramc.ar(com.tencent.mm.plugin.appbrand.p.a.class)).ccb)
            {
              AppMethodBeat.o(179505);
              return;
            }
            paramAnonymousJSONObject.remove("__AppBrandRemoteDebugRequestHeader__");
            m localm = new m();
            localm.cYH.cYI = "download";
            localm.cYH.cYK = paramAnonymousJSONObject;
            localm.cYH.cYJ = paramString;
            com.tencent.mm.sdk.b.a.GpY.l(localm);
            AppMethodBeat.o(179505);
            return;
          }
          this.kBw = paramAnonymousJSONObject;
          paramAnonymousJSONObject = new HashMap();
          paramAnonymousJSONObject.put("downloadTaskId", paramString);
          paramAnonymousJSONObject.put("state", "headersReceived");
          paramAnonymousJSONObject.put("header", this.kBw);
          paramAnonymousJSONObject = new JSONObject(paramAnonymousJSONObject).toString();
          new a.a().h(paramc).LO(paramAnonymousJSONObject).a(a.this.kAW.MJ(paramString));
          AppMethodBeat.o(179505);
        }
        
        public final void a(int paramAnonymousInt1, String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt2, long paramAnonymousLong, Map paramAnonymousMap)
        {
          AppMethodBeat.i(179502);
          ac.i("MicroMsg.BaseCreateDownloadTask", "onDownloadResultWithCode errMsg = %d, mimeType = %s, filePath = %s, statusCode = %d, dataLength = %d", new Object[] { Integer.valueOf(paramAnonymousInt1), paramAnonymousString1, paramAnonymousString2, Integer.valueOf(paramAnonymousInt2), Long.valueOf(paramAnonymousLong) });
          if (!bs.isNullOrNil(this.ibP))
          {
            paramAnonymousString1 = ak.a(paramc, new com.tencent.mm.vfs.e(paramAnonymousString2), this.ibP, null);
            if ((com.tencent.mm.plugin.appbrand.p.b.FAILED == paramAnonymousInt1) || (!"ok".equals(paramAnonymousString1)))
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
            ac.i("MicroMsg.BaseCreateDownloadTask", "onDownloadResultWithCode filePath %s", new Object[] { this.ibP });
            paramAnonymousString1 = new HashMap();
            paramAnonymousString1.put("downloadTaskId", paramString);
            paramAnonymousString1.put("filePath", this.ibP);
            paramAnonymousString1.put("dataLength", Long.valueOf(paramAnonymousLong));
            paramAnonymousString1.put("statusCode", Integer.valueOf(paramAnonymousInt2));
            paramAnonymousString1.put("state", "success");
            if (this.kBw != null) {
              paramAnonymousString1.put("header", this.kBw);
            }
            if ((paramAnonymousMap != null) && (paramAnonymousMap.size() > 0)) {
              paramAnonymousString1.put("profile", paramAnonymousMap);
            }
            paramAnonymousString1 = new JSONObject(paramAnonymousString1).toString();
            new a.a().h(paramc).LO(paramAnonymousString1).a(a.this.kAW.MJ(paramString));
            a.this.kAW.remove(paramString);
            AppMethodBeat.o(179502);
            return;
          }
          com.tencent.mm.plugin.appbrand.jsapi.c localc = paramc;
          String str2 = d.aGP(paramAnonymousString1);
          String str1 = str2;
          if (bs.isNullOrNil(str2))
          {
            str1 = str2;
            if ("audio/mp4".equals(paramAnonymousString1)) {
              str1 = "mp4";
            }
          }
          paramAnonymousString1 = new i();
          if (localc.DH().a(new com.tencent.mm.vfs.e(paramAnonymousString2), str1, true, paramAnonymousString1) != l.jsB) {
            paramAnonymousString1 = null;
          }
          while ((paramAnonymousInt1 == com.tencent.mm.plugin.appbrand.p.b.FAILED) || (paramAnonymousString1 == null)) {
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
          ac.i("MicroMsg.BaseCreateDownloadTask", "onDownloadResultWithCode localId %s", new Object[] { paramAnonymousString1 });
          paramAnonymousString2 = new HashMap();
          paramAnonymousString2.put("downloadTaskId", paramString);
          paramAnonymousString2.put("tempFilePath", paramAnonymousString1);
          paramAnonymousString2.put("dataLength", Long.valueOf(paramAnonymousLong));
          paramAnonymousString2.put("statusCode", Integer.valueOf(paramAnonymousInt2));
          paramAnonymousString2.put("state", "success");
          if (this.kBw != null) {
            paramAnonymousString2.put("header", this.kBw);
          }
          if ((paramAnonymousMap != null) && (paramAnonymousMap.size() > 0)) {
            paramAnonymousString2.put("profile", paramAnonymousMap);
          }
          paramAnonymousString1 = new JSONObject(paramAnonymousString2).toString();
          new a.a().h(paramc).LO(paramAnonymousString1).a(a.this.kAW.MJ(paramString));
          a.this.kAW.remove(paramString);
          AppMethodBeat.o(179502);
        }
        
        public final void ac(int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(199904);
          ac.i("MicroMsg.BaseCreateDownloadTask", "onDownloadError  downloadTaskId = %s, errMsg = %d, error = %s", new Object[] { paramString, Integer.valueOf(paramAnonymousInt), paramAnonymousString });
          if (a.i(paramc, paramString))
          {
            AppMethodBeat.o(199904);
            return;
          }
          a.this.a(paramc, paramString, paramAnonymousString);
          AppMethodBeat.o(199904);
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
          new a.a().h(paramc).LO((String)localObject).a(a.this.kAW.MJ(paramString));
          AppMethodBeat.o(179503);
        }
      };
      locala = (com.tencent.mm.plugin.appbrand.p.a)paramc.ar(com.tencent.mm.plugin.appbrand.p.a.class);
      localMap = j.a(paramJSONObject, locala);
      str = paramJSONObject.optString("url");
      if (!bs.isNullOrNil(str)) {
        break;
      }
      ac.i("MicroMsg.BaseCreateDownloadTask", "url is null");
      a(paramc, paramString, "url is null or nil");
      AppMethodBeat.o(179508);
      return;
      label174:
      ac.i("MicroMsg.BaseCreateDownloadTask", "setupRequestMode(%b),appId(%s)", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.appbrand.p.a)localObject).lwj), paramc.getAppId() });
      CronetLogic.setUserCertVerify(((com.tencent.mm.plugin.appbrand.p.a)localObject).lwj);
    }
    if (paramJSONObject.optBoolean("__skipDomainCheck__")) {}
    for (boolean bool = false; (bool) && (!j.c(locala.ccH, str)); bool = locala.lvY)
    {
      ac.i("MicroMsg.BaseCreateDownloadTask", "not in domain url %s", new Object[] { str });
      a(paramc, paramString, "url not in domain list");
      AppMethodBeat.o(179508);
      return;
    }
    if (locala.ccx <= 0) {
      ac.i("MicroMsg.BaseCreateDownloadTask", "maxDownloadConcurrent <= 0 ");
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
    ac.i("MicroMsg.BaseCreateDownloadTask", "lm:configTimeout: %d,timeout: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    a(paramc, locala, bool, paramJSONObject, j, localMap, (b.a)localObject, paramString);
    AppMethodBeat.o(179508);
  }
  
  public final String aLs()
  {
    AppMethodBeat.i(179507);
    Object localObject = new StringBuilder();
    com.tencent.mm.plugin.appbrand.p.c.bpg();
    localObject = com.tencent.mm.plugin.appbrand.p.c.bpf();
    AppMethodBeat.o(179507);
    return localObject;
  }
  
  public final String acf()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.j.a.a
 * JD-Core Version:    0.7.0.1
 */