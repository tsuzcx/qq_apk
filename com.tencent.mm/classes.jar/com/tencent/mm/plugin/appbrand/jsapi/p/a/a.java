package com.tencent.mm.plugin.appbrand.jsapi.p.a;

import com.tencent.mars.cdn.CronetLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.o;
import com.tencent.mm.plugin.appbrand.ac.i;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import com.tencent.mm.plugin.appbrand.jsapi.az;
import com.tencent.mm.plugin.appbrand.jsapi.base.h;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.file.ao;
import com.tencent.mm.plugin.appbrand.s.b.1;
import com.tencent.mm.plugin.appbrand.s.b.a;
import com.tencent.mm.plugin.appbrand.s.b.b;
import com.tencent.mm.plugin.appbrand.s.c;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.vfs.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class a
  implements h
{
  private b.b peG;
  protected boolean peH;
  com.tencent.mm.plugin.appbrand.jsapi.base.a pei;
  private final AtomicBoolean pes;
  
  public a(b.b paramb, com.tencent.mm.plugin.appbrand.jsapi.base.a parama)
  {
    AppMethodBeat.i(186790);
    this.peH = false;
    this.pes = new AtomicBoolean(false);
    this.peG = paramb;
    this.pei = parama;
    AppMethodBeat.o(186790);
  }
  
  public void a(e parame, com.tencent.mm.plugin.appbrand.s.a arg2, boolean paramBoolean, JSONObject paramJSONObject, int paramInt, Map<String, String> arg6, b.a parama1, String paramString)
  {
    AppMethodBeat.i(179509);
    Object localObject1 = c.cbO().akP(parame.getAppId());
    if (localObject1 == null)
    {
      localObject1 = new com.tencent.mm.plugin.appbrand.s.b(parame, this.peH);
      ??? = c.cbO();
      parame = parame.getAppId();
      if (!((c)???).qiH.containsKey(parame)) {
        ((c)???).qiH.put(parame, localObject1);
      }
    }
    for (parame = (e)localObject1;; parame = (e)localObject1)
    {
      if (parame != null)
      {
        Log.i("MicroMsg.BaseCreateDownloadTask", "before do download, checkDomains = %b, timeout %d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
        int i = ???.nWV;
        if (paramBoolean) {
          ??? = ???.cxD;
        }
        for (;;)
        {
          localObject1 = paramJSONObject.optString("url");
          Log.i("MicroMsg.AppBrandNetworkDownload", "download taskId:%s url:%s", new Object[] { paramString, localObject1 });
          localObject1 = j.akZ((String)localObject1);
          synchronized (parame.qiD)
          {
            if (parame.qiD.size() >= parame.qiy)
            {
              parama1.aj(-1, "max_connected");
              Log.i("MicroMsg.AppBrandNetworkDownload", "max connected mDownloadTaskList.size():%d,mMaxConnected:%d", new Object[] { Integer.valueOf(parame.qiD.size()), Integer.valueOf(parame.qiy) });
              AppMethodBeat.o(179509);
              return;
              ??? = null;
            }
            else
            {
              ??? = paramJSONObject.optString("filePath");
              String str = parame.qiz + MD5Util.getMD5String((String)localObject1) + "temp" + System.currentTimeMillis();
              paramBoolean = paramJSONObject.optBoolean("enableHttp2", false);
              boolean bool1 = paramJSONObject.optBoolean("enableQuic", false);
              boolean bool2 = paramJSONObject.optBoolean("enableCache", false);
              boolean bool3 = paramJSONObject.optBoolean("enableProfile", true);
              Log.i("MicroMsg.AppBrandNetworkDownload", "download taskId %s,useHttp2 %b, useQuic %b, useMemoryCache %b, useProfile %b", new Object[] { paramString, Boolean.valueOf(paramBoolean), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
              paramJSONObject = new com.tencent.mm.plugin.appbrand.s.a.b(parame.okQ, (String)localObject1, str, (String)???, parame.pFt, parame.peH, paramBoolean, bool1, bool2, bool3, new b.1(parame, paramString, parama1));
              paramJSONObject.qjY = ???;
              paramJSONObject.timeout = paramInt;
              paramJSONObject.isRunning = true;
              paramJSONObject.qjb = ???;
              paramJSONObject.qjZ = i;
              paramJSONObject.qiA = parame.qiA;
              paramJSONObject.mvB = paramString;
              paramJSONObject.qjg = "createDownloadTask";
              synchronized (parame.qiD)
              {
                parame.qiD.add(paramJSONObject);
              }
            }
          }
        }
        synchronized (parame.qiC)
        {
          if (!parame.qiC.containsKey(localObject1))
          {
            ??? = new ConcurrentLinkedQueue();
            parame.qiC.put(localObject1, ???);
            ???.offer(paramJSONObject);
            if ((parame.qiC.get(localObject1) != null) && (((ConcurrentLinkedQueue)parame.qiC.get(localObject1)).size() > 1))
            {
              Log.i("MicroMsg.AppBrandNetworkDownload", "hy: more than one same url in the queue, just add and wait");
              AppMethodBeat.o(179509);
              return;
              parame = finally;
              AppMethodBeat.o(179509);
              throw parame;
              parame = finally;
              AppMethodBeat.o(179509);
              throw parame;
            }
          }
          else
          {
            ??? = (ConcurrentLinkedQueue)parame.qiC.get(localObject1);
          }
        }
        parame.akL((String)localObject1);
      }
      AppMethodBeat.o(179509);
      return;
    }
  }
  
  public final void a(final e parame, JSONObject paramJSONObject, final String paramString)
  {
    AppMethodBeat.i(179508);
    Log.d("MicroMsg.BaseCreateDownloadTask", "JsApiCreateDownloadTask");
    Object localObject;
    if (!this.pes.getAndSet(true))
    {
      if (this.peG != null)
      {
        localObject = this.peG;
        parame.getAppId();
        this.peH = ((b.b)localObject).bEx();
      }
      if (this.peH)
      {
        localObject = (com.tencent.mm.plugin.appbrand.s.a)parame.au(com.tencent.mm.plugin.appbrand.s.a.class);
        if (localObject != null) {
          break label192;
        }
        Log.e("MicroMsg.BaseCreateDownloadTask", "setupRequestMode config not found, setUserCertVerify false appId(%s)", new Object[] { parame.getAppId() });
        CronetLogic.setUserCertVerify(false);
      }
    }
    com.tencent.mm.plugin.appbrand.s.a locala;
    Map localMap;
    String str;
    for (;;)
    {
      parame.getAppId();
      localObject = new b.a()
      {
        private JSONObject peI;
        
        public final void M(JSONObject paramAnonymousJSONObject)
        {
          AppMethodBeat.i(179505);
          if (paramAnonymousJSONObject == null)
          {
            AppMethodBeat.o(179505);
            return;
          }
          if (paramAnonymousJSONObject.optBoolean("__AppBrandRemoteDebugRequestHeader__"))
          {
            if (!((com.tencent.mm.plugin.appbrand.s.a)parame.au(com.tencent.mm.plugin.appbrand.s.a.class)).cwS)
            {
              AppMethodBeat.o(179505);
              return;
            }
            paramAnonymousJSONObject.remove("__AppBrandRemoteDebugRequestHeader__");
            o localo = new o();
            localo.fuU.fuV = "download";
            localo.fuU.fuX = paramAnonymousJSONObject;
            localo.fuU.fuW = paramString;
            EventCenter.instance.publish(localo);
            AppMethodBeat.o(179505);
            return;
          }
          this.peI = paramAnonymousJSONObject;
          paramAnonymousJSONObject = new HashMap();
          paramAnonymousJSONObject.put("downloadTaskId", paramString);
          paramAnonymousJSONObject.put("state", "headersReceived");
          paramAnonymousJSONObject.put("header", this.peI);
          paramAnonymousJSONObject = new JSONObject(paramAnonymousJSONObject).toString();
          new a.a().j(parame).agU(paramAnonymousJSONObject).b(a.this.pei.ahn(paramString));
          AppMethodBeat.o(179505);
        }
        
        public final void a(int paramAnonymousInt1, String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt2, long paramAnonymousLong, Map paramAnonymousMap)
        {
          AppMethodBeat.i(179502);
          Log.i("MicroMsg.BaseCreateDownloadTask", "onDownloadResultWithCode errMsg = %d, mimeType = %s, filePath = %s, statusCode = %d, dataLength = %d", new Object[] { Integer.valueOf(paramAnonymousInt1), paramAnonymousString1, paramAnonymousString2, Integer.valueOf(paramAnonymousInt2), Long.valueOf(paramAnonymousLong) });
          if (!Util.isNullOrNil(this.miZ))
          {
            paramAnonymousString1 = ao.a(parame, new q(paramAnonymousString2), this.miZ, null);
            if ((com.tencent.mm.plugin.appbrand.s.b.FAILED == paramAnonymousInt1) || (!"ok".equals(paramAnonymousString1)))
            {
              if (a.i(parame, paramString))
              {
                AppMethodBeat.o(179502);
                return;
              }
              if (paramAnonymousInt1 == com.tencent.mm.plugin.appbrand.s.b.FAILED)
              {
                a.this.b(parame, paramString, "download fail with code ".concat(String.valueOf(paramAnonymousInt2)));
                AppMethodBeat.o(179502);
                return;
              }
              a.this.b(parame, paramString, paramAnonymousString1);
              AppMethodBeat.o(179502);
              return;
            }
            Log.i("MicroMsg.BaseCreateDownloadTask", "onDownloadResultWithCode filePath %s", new Object[] { this.miZ });
            paramAnonymousString1 = new HashMap();
            paramAnonymousString1.put("downloadTaskId", paramString);
            paramAnonymousString1.put("filePath", this.miZ);
            paramAnonymousString1.put("dataLength", Long.valueOf(paramAnonymousLong));
            paramAnonymousString1.put("statusCode", Integer.valueOf(paramAnonymousInt2));
            paramAnonymousString1.put("state", "success");
            if (this.peI != null) {
              paramAnonymousString1.put("header", this.peI);
            }
            if ((paramAnonymousMap != null) && (paramAnonymousMap.size() > 0)) {
              paramAnonymousString1.put("profile", paramAnonymousMap);
            }
            paramAnonymousString1 = new JSONObject(paramAnonymousString1).toString();
            new a.a().j(parame).agU(paramAnonymousString1).b(a.this.pei.ahn(paramString));
            a.this.pei.remove(paramString);
            AppMethodBeat.o(179502);
            return;
          }
          i locali = new i();
          e locale = parame;
          String str2 = MimeTypeUtil.getExtByMimeType(paramAnonymousString1);
          String str1 = str2;
          if (Util.isNullOrNil(str2))
          {
            str1 = str2;
            if ("audio/mp4".equals(paramAnonymousString1)) {
              str1 = "mp4";
            }
          }
          paramAnonymousString1 = new i();
          paramAnonymousString2 = locale.getFileSystem().a(new q(paramAnonymousString2), str1, true, paramAnonymousString1);
          locali.value = paramAnonymousString2;
          if (paramAnonymousString2 != m.nMR) {
            paramAnonymousString1 = null;
          }
          while ((paramAnonymousInt1 == com.tencent.mm.plugin.appbrand.s.b.FAILED) || (paramAnonymousString1 == null)) {
            if (a.i(parame, paramString))
            {
              AppMethodBeat.o(179502);
              return;
              paramAnonymousString1 = (String)paramAnonymousString1.value;
            }
            else
            {
              if (paramAnonymousInt1 == com.tencent.mm.plugin.appbrand.s.b.FAILED)
              {
                a.this.b(parame, paramString, "download fail with code ".concat(String.valueOf(paramAnonymousInt2)));
                AppMethodBeat.o(179502);
                return;
              }
              paramAnonymousString2 = a.this;
              paramAnonymousMap = parame;
              str1 = paramString;
              if (locali.value == m.nNg) {}
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
          if (this.peI != null) {
            paramAnonymousString2.put("header", this.peI);
          }
          if ((paramAnonymousMap != null) && (paramAnonymousMap.size() > 0)) {
            paramAnonymousString2.put("profile", paramAnonymousMap);
          }
          paramAnonymousString1 = new JSONObject(paramAnonymousString2).toString();
          new a.a().j(parame).agU(paramAnonymousString1).b(a.this.pei.ahn(paramString));
          a.this.pei.remove(paramString);
          AppMethodBeat.o(179502);
        }
        
        public final void aj(int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(187008);
          Log.i("MicroMsg.BaseCreateDownloadTask", "onDownloadError  downloadTaskId = %s, errMsg = %d, error = %s", new Object[] { paramString, Integer.valueOf(paramAnonymousInt), paramAnonymousString });
          if (a.i(parame, paramString))
          {
            AppMethodBeat.o(187008);
            return;
          }
          a.this.b(parame, paramString, paramAnonymousString);
          AppMethodBeat.o(187008);
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
          new a.a().j(parame).agU((String)localObject).b(a.this.pei.ahn(paramString));
          AppMethodBeat.o(179503);
        }
      };
      locala = (com.tencent.mm.plugin.appbrand.s.a)parame.au(com.tencent.mm.plugin.appbrand.s.a.class);
      localMap = j.a(paramJSONObject, locala);
      str = paramJSONObject.optString("url");
      if (!Util.isNullOrNil(str)) {
        break;
      }
      Log.i("MicroMsg.BaseCreateDownloadTask", "url is null");
      b(parame, paramString, "url is null or nil");
      AppMethodBeat.o(179508);
      return;
      label192:
      Log.i("MicroMsg.BaseCreateDownloadTask", "setupRequestMode(%b),appId(%s)", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.appbrand.s.a)localObject).qix), parame.getAppId() });
      CronetLogic.setUserCertVerify(((com.tencent.mm.plugin.appbrand.s.a)localObject).qix);
    }
    if (paramJSONObject.optBoolean("__skipDomainCheck__")) {}
    for (boolean bool = false; (bool) && (!j.b(locala.cxD, str)); bool = locala.qim)
    {
      Log.i("MicroMsg.BaseCreateDownloadTask", "not in domain url %s", new Object[] { str });
      b(parame, paramString, "url not in domain list");
      AppMethodBeat.o(179508);
      return;
    }
    if (locala.cxr <= 0) {
      Log.i("MicroMsg.BaseCreateDownloadTask", "maxDownloadConcurrent <= 0 ");
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
    Log.i("MicroMsg.BaseCreateDownloadTask", "lm:configTimeout: %d,timeout: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    a(parame, locala, bool, paramJSONObject, j, localMap, (b.a)localObject, paramString);
    AppMethodBeat.o(179508);
  }
  
  public final String aBF()
  {
    return "downloadTaskId";
  }
  
  public final void b(e parame, String paramString1, String paramString2)
  {
    AppMethodBeat.i(179510);
    Log.w("MicroMsg.BaseCreateDownloadTask", "sendFailMsg, downloadTaskId = %s, errMsg = %s", new Object[] { paramString1, paramString2 });
    HashMap localHashMap = new HashMap();
    localHashMap.put("downloadTaskId", paramString1);
    localHashMap.put("state", "fail");
    localHashMap.put("errMsg", paramString2);
    paramString2 = new JSONObject(localHashMap).toString();
    new a().j(parame).agU(paramString2).b(this.pei.ahn(paramString1));
    this.pei.remove(paramString1);
    AppMethodBeat.o(179510);
  }
  
  public final String bsL()
  {
    AppMethodBeat.i(179507);
    Object localObject = new StringBuilder();
    c.cbO();
    localObject = c.cbN();
    AppMethodBeat.o(179507);
    return localObject;
  }
  
  public static final class a
    extends az
  {
    public static final int CTRL_INDEX = 271;
    public static final String NAME = "onDownloadTaskStateChange";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.p.a.a
 * JD-Core Version:    0.7.0.1
 */