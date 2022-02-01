package com.tencent.mm.plugin.appbrand.jsapi.o.a;

import com.tencent.mars.cdn.CronetLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.n;
import com.tencent.mm.plugin.appbrand.ac.i;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.jsapi.base.h;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.file.am;
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
import com.tencent.mm.vfs.o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class a
  implements h
{
  private b.b mgA;
  protected boolean mgB;
  com.tencent.mm.plugin.appbrand.jsapi.base.a mgb;
  private final AtomicBoolean mgl;
  
  public a(b.b paramb, com.tencent.mm.plugin.appbrand.jsapi.base.a parama)
  {
    AppMethodBeat.i(207094);
    this.mgB = false;
    this.mgl = new AtomicBoolean(false);
    this.mgA = paramb;
    this.mgb = parama;
    AppMethodBeat.o(207094);
  }
  
  public void a(f paramf, com.tencent.mm.plugin.appbrand.s.a arg2, boolean paramBoolean, JSONObject paramJSONObject, int paramInt, Map<String, String> arg6, b.a parama1, String paramString)
  {
    AppMethodBeat.i(179509);
    Object localObject1 = c.bPx().acV(paramf.getAppId());
    if (localObject1 == null)
    {
      localObject1 = new com.tencent.mm.plugin.appbrand.s.b(paramf, this.mgB);
      ??? = c.bPx();
      paramf = paramf.getAppId();
      if (!((c)???).nhY.containsKey(paramf)) {
        ((c)???).nhY.put(paramf, localObject1);
      }
    }
    for (paramf = (f)localObject1;; paramf = (f)localObject1)
    {
      if (paramf != null)
      {
        Log.i("MicroMsg.BaseCreateDownloadTask", "before do download, checkDomains = %b, timeout %d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
        int i = ???.lcM;
        if (paramBoolean) {
          ??? = ???.cyW;
        }
        for (;;)
        {
          localObject1 = paramJSONObject.optString("url");
          Log.i("MicroMsg.AppBrandNetworkDownload", "download taskId:%s url:%s", new Object[] { paramString, localObject1 });
          localObject1 = j.adg((String)localObject1);
          synchronized (paramf.nhU)
          {
            if (paramf.nhU.size() >= paramf.nhP)
            {
              parama1.ah(-1, "max_connected");
              Log.i("MicroMsg.AppBrandNetworkDownload", "max connected mDownloadTaskList.size():%d,mMaxConnected:%d", new Object[] { Integer.valueOf(paramf.nhU.size()), Integer.valueOf(paramf.nhP) });
              AppMethodBeat.o(179509);
              return;
              ??? = null;
            }
            else
            {
              ??? = paramJSONObject.optString("filePath");
              String str = paramf.nhQ + MD5Util.getMD5String((String)localObject1) + "temp" + System.currentTimeMillis();
              paramBoolean = paramJSONObject.optBoolean("enableHttp2", false);
              boolean bool1 = paramJSONObject.optBoolean("enableQuic", false);
              boolean bool2 = paramJSONObject.optBoolean("enableCache", false);
              boolean bool3 = paramJSONObject.optBoolean("enableProfile", true);
              Log.i("MicroMsg.AppBrandNetworkDownload", "download taskId %s,useHttp2 %b, useQuic %b, useMemoryCache %b, useProfile %b", new Object[] { paramString, Boolean.valueOf(paramBoolean), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
              paramJSONObject = new com.tencent.mm.plugin.appbrand.s.a.b(paramf.lqg, (String)localObject1, str, (String)???, paramf.mGo, paramf.mgB, paramBoolean, bool1, bool2, bool3, new b.1(paramf, paramString, parama1));
              paramJSONObject.njn = ???;
              paramJSONObject.timeout = paramInt;
              paramJSONObject.isRunning = true;
              paramJSONObject.nis = ???;
              paramJSONObject.njo = i;
              paramJSONObject.nhR = paramf.nhR;
              paramJSONObject.jEY = paramString;
              paramJSONObject.nix = "createDownloadTask";
              synchronized (paramf.nhU)
              {
                paramf.nhU.add(paramJSONObject);
              }
            }
          }
        }
        synchronized (paramf.nhT)
        {
          if (!paramf.nhT.containsKey(localObject1))
          {
            ??? = new ConcurrentLinkedQueue();
            paramf.nhT.put(localObject1, ???);
            ???.offer(paramJSONObject);
            if ((paramf.nhT.get(localObject1) != null) && (((ConcurrentLinkedQueue)paramf.nhT.get(localObject1)).size() > 1))
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
            ??? = (ConcurrentLinkedQueue)paramf.nhT.get(localObject1);
          }
        }
        paramf.acR((String)localObject1);
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
    if (!this.mgl.getAndSet(true))
    {
      if (this.mgA != null)
      {
        localObject = this.mgA;
        paramf.getAppId();
        this.mgB = ((b.b)localObject).btA();
      }
      if (this.mgB)
      {
        localObject = (com.tencent.mm.plugin.appbrand.s.a)paramf.av(com.tencent.mm.plugin.appbrand.s.a.class);
        if (localObject != null) {
          break label192;
        }
        Log.e("MicroMsg.BaseCreateDownloadTask", "setupRequestMode config not found, setUserCertVerify false appId(%s)", new Object[] { paramf.getAppId() });
        CronetLogic.setUserCertVerify(false);
      }
    }
    com.tencent.mm.plugin.appbrand.s.a locala;
    Map localMap;
    String str;
    for (;;)
    {
      paramf.getAppId();
      localObject = new b.a()
      {
        private JSONObject mgC;
        
        public final void J(JSONObject paramAnonymousJSONObject)
        {
          AppMethodBeat.i(179505);
          if (paramAnonymousJSONObject == null)
          {
            AppMethodBeat.o(179505);
            return;
          }
          if (paramAnonymousJSONObject.optBoolean("__AppBrandRemoteDebugRequestHeader__"))
          {
            if (!((com.tencent.mm.plugin.appbrand.s.a)paramf.av(com.tencent.mm.plugin.appbrand.s.a.class)).cyp)
            {
              AppMethodBeat.o(179505);
              return;
            }
            paramAnonymousJSONObject.remove("__AppBrandRemoteDebugRequestHeader__");
            n localn = new n();
            localn.dCn.dCo = "download";
            localn.dCn.dCq = paramAnonymousJSONObject;
            localn.dCn.dCp = paramString;
            EventCenter.instance.publish(localn);
            AppMethodBeat.o(179505);
            return;
          }
          this.mgC = paramAnonymousJSONObject;
          paramAnonymousJSONObject = new HashMap();
          paramAnonymousJSONObject.put("downloadTaskId", paramString);
          paramAnonymousJSONObject.put("state", "headersReceived");
          paramAnonymousJSONObject.put("header", this.mgC);
          paramAnonymousJSONObject = new JSONObject(paramAnonymousJSONObject).toString();
          new a.a().h(paramf).Zh(paramAnonymousJSONObject).a(a.this.mgb.Zz(paramString));
          AppMethodBeat.o(179505);
        }
        
        public final void a(int paramAnonymousInt1, String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt2, long paramAnonymousLong, Map paramAnonymousMap)
        {
          AppMethodBeat.i(179502);
          Log.i("MicroMsg.BaseCreateDownloadTask", "onDownloadResultWithCode errMsg = %d, mimeType = %s, filePath = %s, statusCode = %d, dataLength = %d", new Object[] { Integer.valueOf(paramAnonymousInt1), paramAnonymousString1, paramAnonymousString2, Integer.valueOf(paramAnonymousInt2), Long.valueOf(paramAnonymousLong) });
          if (!Util.isNullOrNil(this.jtv))
          {
            paramAnonymousString1 = am.a(paramf, new o(paramAnonymousString2), this.jtv, null);
            if ((com.tencent.mm.plugin.appbrand.s.b.FAILED == paramAnonymousInt1) || (!"ok".equals(paramAnonymousString1)))
            {
              if (a.i(paramf, paramString))
              {
                AppMethodBeat.o(179502);
                return;
              }
              a.this.b(paramf, paramString, paramAnonymousString1);
              AppMethodBeat.o(179502);
              return;
            }
            Log.i("MicroMsg.BaseCreateDownloadTask", "onDownloadResultWithCode filePath %s", new Object[] { this.jtv });
            paramAnonymousString1 = new HashMap();
            paramAnonymousString1.put("downloadTaskId", paramString);
            paramAnonymousString1.put("filePath", this.jtv);
            paramAnonymousString1.put("dataLength", Long.valueOf(paramAnonymousLong));
            paramAnonymousString1.put("statusCode", Integer.valueOf(paramAnonymousInt2));
            paramAnonymousString1.put("state", "success");
            if (this.mgC != null) {
              paramAnonymousString1.put("header", this.mgC);
            }
            if ((paramAnonymousMap != null) && (paramAnonymousMap.size() > 0)) {
              paramAnonymousString1.put("profile", paramAnonymousMap);
            }
            paramAnonymousString1 = new JSONObject(paramAnonymousString1).toString();
            new a.a().h(paramf).Zh(paramAnonymousString1).a(a.this.mgb.Zz(paramString));
            a.this.mgb.remove(paramString);
            AppMethodBeat.o(179502);
            return;
          }
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
          paramAnonymousString1 = new i();
          if (localf.getFileSystem().a(new o(paramAnonymousString2), str1, true, paramAnonymousString1) != m.kSu) {
            paramAnonymousString1 = null;
          }
          while ((paramAnonymousInt1 == com.tencent.mm.plugin.appbrand.s.b.FAILED) || (paramAnonymousString1 == null)) {
            if (a.i(paramf, paramString))
            {
              AppMethodBeat.o(179502);
              return;
              paramAnonymousString1 = (String)paramAnonymousString1.value;
            }
            else
            {
              a.this.b(paramf, paramString, "download fail");
              AppMethodBeat.o(179502);
              return;
            }
          }
          Log.i("MicroMsg.BaseCreateDownloadTask", "onDownloadResultWithCode localId %s", new Object[] { paramAnonymousString1 });
          paramAnonymousString2 = new HashMap();
          paramAnonymousString2.put("downloadTaskId", paramString);
          paramAnonymousString2.put("tempFilePath", paramAnonymousString1);
          paramAnonymousString2.put("dataLength", Long.valueOf(paramAnonymousLong));
          paramAnonymousString2.put("statusCode", Integer.valueOf(paramAnonymousInt2));
          paramAnonymousString2.put("state", "success");
          if (this.mgC != null) {
            paramAnonymousString2.put("header", this.mgC);
          }
          if ((paramAnonymousMap != null) && (paramAnonymousMap.size() > 0)) {
            paramAnonymousString2.put("profile", paramAnonymousMap);
          }
          paramAnonymousString1 = new JSONObject(paramAnonymousString2).toString();
          new a.a().h(paramf).Zh(paramAnonymousString1).a(a.this.mgb.Zz(paramString));
          a.this.mgb.remove(paramString);
          AppMethodBeat.o(179502);
        }
        
        public final void ah(int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(207093);
          Log.i("MicroMsg.BaseCreateDownloadTask", "onDownloadError  downloadTaskId = %s, errMsg = %d, error = %s", new Object[] { paramString, Integer.valueOf(paramAnonymousInt), paramAnonymousString });
          if (a.i(paramf, paramString))
          {
            AppMethodBeat.o(207093);
            return;
          }
          a.this.b(paramf, paramString, paramAnonymousString);
          AppMethodBeat.o(207093);
        }
        
        public final void h(int paramAnonymousInt, long paramAnonymousLong1, long paramAnonymousLong2)
        {
          AppMethodBeat.i(179503);
          Object localObject = new HashMap();
          ((Map)localObject).put("downloadTaskId", paramString);
          ((Map)localObject).put("state", "progressUpdate");
          ((Map)localObject).put("progress", Integer.valueOf(paramAnonymousInt));
          ((Map)localObject).put("totalBytesWritten", Long.valueOf(paramAnonymousLong1));
          ((Map)localObject).put("totalBytesExpectedToWrite", Long.valueOf(paramAnonymousLong2));
          localObject = new JSONObject((Map)localObject).toString();
          new a.a().h(paramf).Zh((String)localObject).a(a.this.mgb.Zz(paramString));
          AppMethodBeat.o(179503);
        }
      };
      locala = (com.tencent.mm.plugin.appbrand.s.a)paramf.av(com.tencent.mm.plugin.appbrand.s.a.class);
      localMap = j.a(paramJSONObject, locala);
      str = paramJSONObject.optString("url");
      if (!Util.isNullOrNil(str)) {
        break;
      }
      Log.i("MicroMsg.BaseCreateDownloadTask", "url is null");
      b(paramf, paramString, "url is null or nil");
      AppMethodBeat.o(179508);
      return;
      label192:
      Log.i("MicroMsg.BaseCreateDownloadTask", "setupRequestMode(%b),appId(%s)", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.appbrand.s.a)localObject).nhO), paramf.getAppId() });
      CronetLogic.setUserCertVerify(((com.tencent.mm.plugin.appbrand.s.a)localObject).nhO);
    }
    if (paramJSONObject.optBoolean("__skipDomainCheck__")) {}
    for (boolean bool = false; (bool) && (!j.c(locala.cyW, str)); bool = locala.nhD)
    {
      Log.i("MicroMsg.BaseCreateDownloadTask", "not in domain url %s", new Object[] { str });
      b(paramf, paramString, "url not in domain list");
      AppMethodBeat.o(179508);
      return;
    }
    if (locala.cyM <= 0) {
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
    a(paramf, locala, bool, paramJSONObject, j, localMap, (b.a)localObject, paramString);
    AppMethodBeat.o(179508);
  }
  
  public final String auJ()
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
    new a().h(paramf).Zh(paramString2).a(this.mgb.Zz(paramString1));
    this.mgb.remove(paramString1);
    AppMethodBeat.o(179510);
  }
  
  public final String bjl()
  {
    AppMethodBeat.i(179507);
    Object localObject = new StringBuilder();
    c.bPx();
    localObject = c.bPw();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.o.a.a
 * JD-Core Version:    0.7.0.1
 */