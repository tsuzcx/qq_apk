package com.tencent.mm.plugin.appbrand.jsapi.s.a;

import com.tencent.mars.cdn.CronetLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.q;
import com.tencent.mm.plugin.appbrand.af.k;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import com.tencent.mm.plugin.appbrand.appstorage.w;
import com.tencent.mm.plugin.appbrand.jsapi.base.h;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.file.aq;
import com.tencent.mm.plugin.appbrand.t.b.1;
import com.tencent.mm.plugin.appbrand.t.b.a;
import com.tencent.mm.plugin.appbrand.t.b.b;
import com.tencent.mm.plugin.appbrand.t.c;
import com.tencent.mm.plugin.appbrand.t.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.vfs.u;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class a
  implements h
{
  private final AtomicBoolean sjI;
  private b.b sjX;
  protected boolean sjY;
  com.tencent.mm.plugin.appbrand.jsapi.base.a sjy;
  
  public a(b.b paramb, com.tencent.mm.plugin.appbrand.jsapi.base.a parama)
  {
    AppMethodBeat.i(327286);
    this.sjY = false;
    this.sjI = new AtomicBoolean(false);
    this.sjX = paramb;
    this.sjy = parama;
    AppMethodBeat.o(327286);
  }
  
  public void a(f paramf, com.tencent.mm.plugin.appbrand.t.a arg2, boolean paramBoolean, JSONObject paramJSONObject, int paramInt, Map<String, String> arg6, b.a parama1, String paramString)
  {
    AppMethodBeat.i(179509);
    Object localObject1 = c.cCh().adW(paramf.getAppId());
    if (localObject1 == null)
    {
      localObject1 = new com.tencent.mm.plugin.appbrand.t.b(paramf, this.sjY);
      ??? = c.cCh();
      paramf = paramf.getAppId();
      if (!((c)???).tnt.containsKey(paramf)) {
        ((c)???).tnt.put(paramf, localObject1);
      }
    }
    for (paramf = (f)localObject1;; paramf = (f)localObject1)
    {
      if (paramf != null)
      {
        Log.i("MicroMsg.BaseCreateDownloadTask", "before do download, checkDomains = %b, timeout %d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
        int i = ???.qWL;
        if (paramBoolean) {
          ??? = ???.epX;
        }
        for (;;)
        {
          localObject1 = paramJSONObject.optString("url");
          Log.i("MicroMsg.AppBrandNetworkDownload", "download taskId:%s url:%s", new Object[] { paramString, localObject1 });
          localObject1 = i.aeg((String)localObject1);
          synchronized (paramf.tnp)
          {
            if (paramf.tnp.size() >= paramf.tnk)
            {
              parama1.at(com.tencent.mm.plugin.appbrand.t.b.FAILED, "max_connected");
              Log.i("MicroMsg.AppBrandNetworkDownload", "max connected mDownloadTaskList.size():%d,mMaxConnected:%d", new Object[] { Integer.valueOf(paramf.tnp.size()), Integer.valueOf(paramf.tnk) });
              AppMethodBeat.o(179509);
              return;
              ??? = null;
            }
            else
            {
              ??? = paramJSONObject.optString("filePath");
              String str = paramf.tnl + MD5Util.getMD5String((String)localObject1) + "temp" + System.currentTimeMillis();
              paramBoolean = paramJSONObject.optBoolean("enableHttp2", false);
              boolean bool1 = paramJSONObject.optBoolean("enableQuic", false);
              boolean bool2 = paramJSONObject.optBoolean("enableCache", false);
              boolean bool3 = paramJSONObject.optBoolean("enableProfile", true);
              Log.i("MicroMsg.AppBrandNetworkDownload", "download taskId %s,useHttp2 %b, useQuic %b, useMemoryCache %b, useProfile %b", new Object[] { paramString, Boolean.valueOf(paramBoolean), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
              paramJSONObject = new com.tencent.mm.plugin.appbrand.t.a.b(paramf.rot, (String)localObject1, str, (String)???, paramf.sKB, paramf.sjY, paramBoolean, bool1, bool2, bool3, new b.1(paramf, paramString, parama1));
              paramJSONObject.toO = ???;
              paramJSONObject.timeout = paramInt;
              paramJSONObject.Uz = true;
              paramJSONObject.tnQ = ???;
              paramJSONObject.toP = i;
              paramJSONObject.tnm = paramf.tnm;
              paramJSONObject.ppa = paramString;
              paramJSONObject.tnV = "createDownloadTask";
              synchronized (paramf.tnp)
              {
                paramf.tnp.add(paramJSONObject);
              }
            }
          }
        }
        synchronized (paramf.tno)
        {
          if (!paramf.tno.containsKey(localObject1))
          {
            ??? = new ConcurrentLinkedQueue();
            paramf.tno.put(localObject1, ???);
            ???.offer(paramJSONObject);
            if ((paramf.tno.get(localObject1) != null) && (((ConcurrentLinkedQueue)paramf.tno.get(localObject1)).size() > 1))
            {
              Log.i("MicroMsg.AppBrandNetworkDownload", "hy: more than one same url in the queue, just add and wait");
              AppMethodBeat.o(179509);
              return;
              paramf = finally;
              AppMethodBeat.o(179509);
              throw paramf;
              paramf = finally;
              AppMethodBeat.o(179509);
              throw paramf;
            }
          }
          else
          {
            ??? = (ConcurrentLinkedQueue)paramf.tno.get(localObject1);
          }
        }
        paramf.adS((String)localObject1);
      }
      AppMethodBeat.o(179509);
      return;
    }
  }
  
  public final void a(final f paramf, JSONObject paramJSONObject, final String paramString)
  {
    AppMethodBeat.i(179508);
    Log.d("MicroMsg.BaseCreateDownloadTask", "JsApiCreateDownloadTask");
    Object localObject;
    if (!this.sjI.getAndSet(true))
    {
      if (this.sjX != null)
      {
        localObject = this.sjX;
        paramf.getAppId();
        this.sjY = ((b.b)localObject).cdJ();
      }
      if (this.sjY)
      {
        localObject = (com.tencent.mm.plugin.appbrand.t.a)paramf.aN(com.tencent.mm.plugin.appbrand.t.a.class);
        if (localObject != null) {
          break label192;
        }
        Log.e("MicroMsg.BaseCreateDownloadTask", "setupRequestMode config not found, setUserCertVerify false appId(%s)", new Object[] { paramf.getAppId() });
        CronetLogic.setUserCertVerify(false);
      }
    }
    com.tencent.mm.plugin.appbrand.t.a locala;
    Map localMap;
    String str;
    for (;;)
    {
      paramf.getAppId();
      localObject = new b.a()
      {
        private JSONObject sjZ;
        
        public final void X(JSONObject paramAnonymousJSONObject)
        {
          AppMethodBeat.i(179505);
          if (paramAnonymousJSONObject == null)
          {
            AppMethodBeat.o(179505);
            return;
          }
          if (paramAnonymousJSONObject.optBoolean("__AppBrandRemoteDebugRequestHeader__"))
          {
            if (!((com.tencent.mm.plugin.appbrand.t.a)paramf.aN(com.tencent.mm.plugin.appbrand.t.a.class)).eoX)
            {
              AppMethodBeat.o(179505);
              return;
            }
            paramAnonymousJSONObject.remove("__AppBrandRemoteDebugRequestHeader__");
            q localq = new q();
            localq.hzo.hzp = "download";
            localq.hzo.hzr = paramAnonymousJSONObject;
            localq.hzo.hzq = paramString;
            localq.publish();
            AppMethodBeat.o(179505);
            return;
          }
          this.sjZ = paramAnonymousJSONObject;
          paramAnonymousJSONObject = new HashMap();
          paramAnonymousJSONObject.put("downloadTaskId", paramString);
          paramAnonymousJSONObject.put("state", "headersReceived");
          paramAnonymousJSONObject.put("header", this.sjZ);
          paramAnonymousJSONObject = new JSONObject(paramAnonymousJSONObject).toString();
          new a.a().i(paramf).ZR(paramAnonymousJSONObject).b(a.this.sjy.aak(paramString));
          AppMethodBeat.o(179505);
        }
        
        public final void a(int paramAnonymousInt1, String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt2, long paramAnonymousLong, Map paramAnonymousMap)
        {
          AppMethodBeat.i(179502);
          Log.i("MicroMsg.BaseCreateDownloadTask", "onDownloadResultWithCode errMsg = %d, mimeType = %s, filePath = %s, statusCode = %d, dataLength = %d", new Object[] { Integer.valueOf(paramAnonymousInt1), paramAnonymousString1, paramAnonymousString2, Integer.valueOf(paramAnonymousInt2), Long.valueOf(paramAnonymousLong) });
          if (!Util.isNullOrNil(this.pcw))
          {
            paramAnonymousString1 = aq.a(paramf, new u(paramAnonymousString2), this.pcw, null);
            if ((com.tencent.mm.plugin.appbrand.t.b.FAILED == paramAnonymousInt1) || (!"ok".equals(paramAnonymousString1)))
            {
              if (a.i(paramf, paramString))
              {
                AppMethodBeat.o(179502);
                return;
              }
              if (paramAnonymousInt1 == com.tencent.mm.plugin.appbrand.t.b.FAILED)
              {
                a.this.b(paramf, paramString, "download fail with code ".concat(String.valueOf(paramAnonymousInt2)));
                AppMethodBeat.o(179502);
                return;
              }
              a.this.b(paramf, paramString, paramAnonymousString1);
              AppMethodBeat.o(179502);
              return;
            }
            Log.i("MicroMsg.BaseCreateDownloadTask", "onDownloadResultWithCode filePath %s", new Object[] { this.pcw });
            paramAnonymousString1 = new HashMap();
            paramAnonymousString1.put("downloadTaskId", paramString);
            paramAnonymousString1.put("filePath", this.pcw);
            paramAnonymousString1.put("dataLength", Long.valueOf(paramAnonymousLong));
            paramAnonymousString1.put("statusCode", Integer.valueOf(paramAnonymousInt2));
            paramAnonymousString1.put("state", "success");
            if (this.sjZ != null) {
              paramAnonymousString1.put("header", this.sjZ);
            }
            if ((paramAnonymousMap != null) && (paramAnonymousMap.size() > 0)) {
              paramAnonymousString1.put("profile", paramAnonymousMap);
            }
            paramAnonymousString1 = new JSONObject(paramAnonymousString1).toString();
            new a.a().i(paramf).ZR(paramAnonymousString1).b(a.this.sjy.aak(paramString));
            a.this.sjy.remove(paramString);
            AppMethodBeat.o(179502);
            return;
          }
          k localk = new k();
          f localf = paramf;
          String str2 = MimeTypeUtil.getExtByMimeType(paramAnonymousString1);
          String str1 = str2;
          if (Util.isNullOrNil(str2))
          {
            str1 = str2;
            if ("audio/mp4".equals(paramAnonymousString1)) {
              str1 = "mp4";
            }
          }
          paramAnonymousString1 = new k();
          paramAnonymousString2 = localf.getFileSystem().a(new u(paramAnonymousString2), str1, true, paramAnonymousString1);
          localk.value = paramAnonymousString2;
          if (paramAnonymousString2 != r.qML) {
            paramAnonymousString1 = null;
          }
          while ((paramAnonymousInt1 == com.tencent.mm.plugin.appbrand.t.b.FAILED) || (paramAnonymousString1 == null)) {
            if (a.i(paramf, paramString))
            {
              AppMethodBeat.o(179502);
              return;
              paramAnonymousString1 = (String)paramAnonymousString1.value;
            }
            else
            {
              if (paramAnonymousInt1 == com.tencent.mm.plugin.appbrand.t.b.FAILED)
              {
                a.this.b(paramf, paramString, "download fail with code ".concat(String.valueOf(paramAnonymousInt2)));
                AppMethodBeat.o(179502);
                return;
              }
              paramAnonymousString2 = a.this;
              paramAnonymousMap = paramf;
              str1 = paramString;
              if (localk.value == r.qNa) {}
              for (paramAnonymousString1 = "temp file size exceed limit";; paramAnonymousString1 = "download fail save file fail")
              {
                paramAnonymousString2.b(paramAnonymousMap, str1, paramAnonymousString1);
                AppMethodBeat.o(179502);
                return;
              }
            }
          }
          Log.i("MicroMsg.BaseCreateDownloadTask", "onDownloadResultWithCode localId %s", new Object[] { paramAnonymousString1 });
          paramAnonymousString2 = new HashMap();
          paramAnonymousString2.put("downloadTaskId", paramString);
          paramAnonymousString2.put("tempFilePath", paramAnonymousString1);
          paramAnonymousString2.put("dataLength", Long.valueOf(paramAnonymousLong));
          paramAnonymousString2.put("statusCode", Integer.valueOf(paramAnonymousInt2));
          paramAnonymousString2.put("state", "success");
          if (this.sjZ != null) {
            paramAnonymousString2.put("header", this.sjZ);
          }
          if ((paramAnonymousMap != null) && (paramAnonymousMap.size() > 0)) {
            paramAnonymousString2.put("profile", paramAnonymousMap);
          }
          paramAnonymousString1 = new JSONObject(paramAnonymousString2).toString();
          new a.a().i(paramf).ZR(paramAnonymousString1).b(a.this.sjy.aak(paramString));
          a.this.sjy.remove(paramString);
          AppMethodBeat.o(179502);
        }
        
        public final void at(int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(327298);
          Log.i("MicroMsg.BaseCreateDownloadTask", "onDownloadError  downloadTaskId = %s, errMsg = %d, error = %s", new Object[] { paramString, Integer.valueOf(paramAnonymousInt), paramAnonymousString });
          if (a.i(paramf, paramString))
          {
            AppMethodBeat.o(327298);
            return;
          }
          a.this.b(paramf, paramString, paramAnonymousString);
          AppMethodBeat.o(327298);
        }
        
        public final void j(int paramAnonymousInt, long paramAnonymousLong1, long paramAnonymousLong2)
        {
          AppMethodBeat.i(179503);
          Object localObject = new HashMap();
          ((Map)localObject).put("downloadTaskId", paramString);
          ((Map)localObject).put("state", "progressUpdate");
          ((Map)localObject).put("progress", Integer.valueOf(paramAnonymousInt));
          ((Map)localObject).put("totalBytesWritten", Long.valueOf(paramAnonymousLong1));
          ((Map)localObject).put("totalBytesExpectedToWrite", Long.valueOf(paramAnonymousLong2));
          localObject = new JSONObject((Map)localObject).toString();
          new a.a().i(paramf).ZR((String)localObject).b(a.this.sjy.aak(paramString));
          AppMethodBeat.o(179503);
        }
      };
      locala = (com.tencent.mm.plugin.appbrand.t.a)paramf.aN(com.tencent.mm.plugin.appbrand.t.a.class);
      localMap = i.a(paramJSONObject, locala);
      str = paramJSONObject.optString("url");
      if (!Util.isNullOrNil(str)) {
        break;
      }
      Log.i("MicroMsg.BaseCreateDownloadTask", "url is null");
      b(paramf, paramString, "url is null or nil");
      AppMethodBeat.o(179508);
      return;
      label192:
      Log.i("MicroMsg.BaseCreateDownloadTask", "setupRequestMode(%b),appId(%s)", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.appbrand.t.a)localObject).tnj), paramf.getAppId() });
      CronetLogic.setUserCertVerify(((com.tencent.mm.plugin.appbrand.t.a)localObject).tnj);
    }
    if (paramJSONObject.optBoolean("__skipDomainCheck__")) {}
    for (boolean bool = false; (bool) && (!i.c(locala.epX, str)); bool = locala.tmY)
    {
      Log.i("MicroMsg.BaseCreateDownloadTask", "not in domain url %s", new Object[] { str });
      b(paramf, paramString, "url not in domain list");
      AppMethodBeat.o(179508);
      return;
    }
    if (locala.epJ <= 0) {
      Log.i("MicroMsg.BaseCreateDownloadTask", "maxDownloadConcurrent <= 0 ");
    }
    int j = 60000;
    int k = paramJSONObject.optInt("timeout", 0);
    int i = k;
    if (k <= 0) {
      i = i.a(locala, 3);
    }
    if (i > 0) {
      j = i;
    }
    Log.i("MicroMsg.BaseCreateDownloadTask", "lm:configTimeout: %d,timeout: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    a(paramf, locala, bool, paramJSONObject, j, localMap, (b.a)localObject, paramString);
    AppMethodBeat.o(179508);
  }
  
  public final String aUD()
  {
    return "downloadTaskId";
  }
  
  public final void b(f paramf, String paramString1, String paramString2)
  {
    AppMethodBeat.i(179510);
    Log.w("MicroMsg.BaseCreateDownloadTask", "sendFailMsg, downloadTaskId = %s, errMsg = %s", new Object[] { paramString1, paramString2 });
    HashMap localHashMap = new HashMap();
    localHashMap.put("downloadTaskId", paramString1);
    localHashMap.put("state", "fail");
    localHashMap.put("errMsg", paramString2);
    paramString2 = new JSONObject(localHashMap).toString();
    new a().i(paramf).ZR(paramString2).b(this.sjy.aak(paramString1));
    AppMethodBeat.o(179510);
  }
  
  public final String bQs()
  {
    AppMethodBeat.i(179507);
    Object localObject = new StringBuilder();
    c.cCh();
    localObject = c.cCg();
    AppMethodBeat.o(179507);
    return localObject;
  }
  
  public static final class a
    extends bc
  {
    public static final int CTRL_INDEX = 271;
    public static final String NAME = "onDownloadTaskStateChange";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.s.a.a
 * JD-Core Version:    0.7.0.1
 */