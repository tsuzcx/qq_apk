package com.tencent.mm.plugin.appbrand.jsapi.s.c;

import com.tencent.mars.cdn.CronetLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.q;
import com.tencent.mm.plugin.appbrand.appstorage.w;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.t.g;
import com.tencent.mm.plugin.appbrand.t.g.a;
import com.tencent.mm.plugin.appbrand.t.g.b;
import com.tencent.mm.plugin.appbrand.t.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.commons.b.c;
import org.json.JSONObject;

public final class a
  implements com.tencent.mm.plugin.appbrand.jsapi.base.h
{
  private final AtomicBoolean sjI;
  com.tencent.mm.plugin.appbrand.jsapi.base.a sjy;
  private g.b skl;
  protected boolean skm;
  
  public a(g.b paramb, com.tencent.mm.plugin.appbrand.jsapi.base.a parama)
  {
    AppMethodBeat.i(327270);
    this.skm = false;
    this.sjI = new AtomicBoolean(false);
    this.skl = paramb;
    this.sjy = parama;
    AppMethodBeat.o(327270);
  }
  
  public final void a(final f paramf, JSONObject paramJSONObject, final String paramString)
  {
    AppMethodBeat.i(179540);
    Log.d("MicroMsg.BaseCreateUploadTask", "JsApiCreateUploadTask, appId:%s taskId:%s", new Object[] { paramf.getAppId(), paramString });
    if (!this.sjI.getAndSet(true))
    {
      if (this.skl != null)
      {
        localObject = this.skl;
        paramf.getAppId();
        this.skm = ((g.b)localObject).cdJ();
      }
      if (this.skm)
      {
        localObject = (com.tencent.mm.plugin.appbrand.t.a)paramf.aN(com.tencent.mm.plugin.appbrand.t.a.class);
        if (localObject != null) {
          break label158;
        }
        Log.e("MicroMsg.BaseCreateUploadTask", "setupRequestMode config not found, setUserCertVerify false appId(%s)", new Object[] { paramf.getAppId() });
        CronetLogic.setUserCertVerify(false);
      }
    }
    String str4;
    String str1;
    for (;;)
    {
      str4 = paramf.getAppId();
      str1 = paramJSONObject.optString("filePath");
      if (!Util.isNullOrNil(str1)) {
        break;
      }
      b(paramf, paramString, "filePath is null");
      AppMethodBeat.o(179540);
      return;
      label158:
      Log.i("MicroMsg.BaseCreateUploadTask", "setupRequestMode(%b),appId(%s)", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.appbrand.t.a)localObject).tnj), paramf.getAppId() });
      CronetLogic.setUserCertVerify(((com.tencent.mm.plugin.appbrand.t.a)localObject).tnj);
    }
    Object localObject = paramf.getFileSystem().Wm(str1);
    if ((localObject == null) || (!((u)localObject).jKS()))
    {
      Log.e("MicroMsg.BaseCreateUploadTask", "upload appId(%s) tempFilePath(%s), found no real file", new Object[] { paramf.getAppId(), str1 });
      b(paramf, paramString, "fail:file doesn't exist");
      AppMethodBeat.o(179540);
      return;
    }
    final String str2 = ah.v(((u)localObject).jKT());
    String str3 = MimeTypeUtil.getMimeTypeByFilePath(str1);
    Log.i("MicroMsg.BaseCreateUploadTask", "upload appId(%s) tempFilePath(%s) realFilePath(%s)", new Object[] { paramf.getAppId(), str1, str2 });
    g.a local1 = new g.a()
    {
      private JSONObject sjZ;
      
      public final void X(JSONObject paramAnonymousJSONObject)
      {
        AppMethodBeat.i(179538);
        if (paramAnonymousJSONObject == null)
        {
          AppMethodBeat.o(179538);
          return;
        }
        if (paramAnonymousJSONObject.optBoolean("__AppBrandRemoteDebugRequestHeader__"))
        {
          if (!((com.tencent.mm.plugin.appbrand.t.a)paramf.aN(com.tencent.mm.plugin.appbrand.t.a.class)).eoX)
          {
            AppMethodBeat.o(179538);
            return;
          }
          paramAnonymousJSONObject.remove("__AppBrandRemoteDebugRequestHeader__");
          q localq = new q();
          localq.hzo.hzp = "upload";
          localq.hzo.hzr = paramAnonymousJSONObject;
          localq.hzo.hzq = paramString;
          localq.publish();
          AppMethodBeat.o(179538);
          return;
        }
        this.sjZ = paramAnonymousJSONObject;
        paramAnonymousJSONObject = new HashMap();
        paramAnonymousJSONObject.put("uploadTaskId", paramString);
        paramAnonymousJSONObject.put("state", "headersReceived");
        paramAnonymousJSONObject.put("header", this.sjZ);
        paramAnonymousJSONObject = new JSONObject(paramAnonymousJSONObject).toString();
        new a.a().i(paramf).ZR(paramAnonymousJSONObject).b(a.this.sjy.aak(paramString));
        AppMethodBeat.o(179538);
      }
      
      public final void abi(String paramAnonymousString)
      {
        int i = 1;
        AppMethodBeat.i(179535);
        Log.i("MicroMsg.BaseCreateUploadTask", "onUploadResult uploadTaskId:%s, filePath:%s, result:%s, errMsg:%d", new Object[] { paramString, str2, paramAnonymousString, Integer.valueOf(-1) });
        Object localObject = paramf;
        String str = paramString;
        localObject = com.tencent.mm.plugin.appbrand.t.h.cCm().aec(((f)localObject).getAppId());
        if ((localObject != null) && (((g)localObject).adU(str))) {
          Log.i("MicroMsg.BaseCreateUploadTask", "upload abort %s", new Object[] { str });
        }
        while (i != 0)
        {
          AppMethodBeat.o(179535);
          return;
          i = 0;
        }
        a.this.b(paramf, paramString, paramAnonymousString);
        AppMethodBeat.o(179535);
      }
      
      public final void cH(String paramAnonymousString, int paramAnonymousInt)
      {
        AppMethodBeat.i(327279);
        Log.i("MicroMsg.BaseCreateUploadTask", "onUploadResultWithCode uploadTaskId:%s, filePath:%s, result:%s, errMsg:%d, statusCode %d", new Object[] { paramString, str2, paramAnonymousString, Integer.valueOf(0), Integer.valueOf(paramAnonymousInt) });
        HashMap localHashMap = new HashMap();
        localHashMap.put("data", paramAnonymousString);
        localHashMap.put("statusCode", Integer.valueOf(paramAnonymousInt));
        localHashMap.put("uploadTaskId", paramString);
        localHashMap.put("state", "success");
        if (this.sjZ != null) {
          localHashMap.put("header", this.sjZ);
        }
        paramAnonymousString = new JSONObject(localHashMap).toString();
        new a.a().i(paramf).ZR(paramAnonymousString).b(a.this.sjy.aak(paramString));
        a.this.sjy.remove(paramString);
        AppMethodBeat.o(327279);
      }
      
      public final void k(int paramAnonymousInt, long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(179537);
        Object localObject = new HashMap();
        ((Map)localObject).put("uploadTaskId", paramString);
        ((Map)localObject).put("state", "progressUpdate");
        ((Map)localObject).put("progress", Integer.valueOf(paramAnonymousInt));
        ((Map)localObject).put("totalBytesSent", Long.valueOf(paramAnonymousLong1));
        ((Map)localObject).put("totalBytesExpectedToSend", Long.valueOf(paramAnonymousLong2));
        localObject = new JSONObject((Map)localObject).toString();
        new a.a().i(paramf).ZR((String)localObject).b(a.this.sjy.aak(paramString));
        AppMethodBeat.o(179537);
      }
    };
    com.tencent.mm.plugin.appbrand.t.a locala = (com.tencent.mm.plugin.appbrand.t.a)paramf.aN(com.tencent.mm.plugin.appbrand.t.a.class);
    Map localMap = i.a(paramJSONObject, locala);
    localObject = paramJSONObject.optString("url");
    if (Util.isNullOrNil((String)localObject))
    {
      Log.i("MicroMsg.BaseCreateUploadTask", "url is null");
      b(paramf, paramString, "url is null or nil");
      AppMethodBeat.o(179540);
      return;
    }
    if (paramJSONObject.optBoolean("__skipDomainCheck__")) {}
    for (boolean bool = false; (bool) && (!i.c(locala.epW, (String)localObject)); bool = locala.tmY)
    {
      Log.i("MicroMsg.BaseCreateUploadTask", "not in domain url %s", new Object[] { localObject });
      b(paramf, paramString, "url not in domain list");
      AppMethodBeat.o(179540);
      return;
    }
    if (locala.epI <= 0) {
      Log.i("MicroMsg.BaseCreateUploadTask", "concurrent <= 0 ");
    }
    int j = 60000;
    int k = paramJSONObject.optInt("timeout", 0);
    int i = k;
    if (k <= 0) {
      i = i.a(locala, 2);
    }
    if (i > 0) {
      j = i;
    }
    Log.i("MicroMsg.BaseCreateUploadTask", "lm:configTimeout: %d,timeout: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    if (com.tencent.mm.plugin.appbrand.t.h.cCm().aec(str4) == null)
    {
      localObject = new g(paramf, this.skm);
      com.tencent.mm.plugin.appbrand.t.h localh = com.tencent.mm.plugin.appbrand.t.h.cCm();
      paramf = (f)localObject;
      if (!localh.tnt.containsKey(str4)) {
        localh.tnt.put(str4, localObject);
      }
    }
    for (paramf = (f)localObject;; paramf = com.tencent.mm.plugin.appbrand.t.h.cCm().aec(str4))
    {
      localObject = c.bei(str1);
      if (paramf == null) {
        break label709;
      }
      Log.i("MicroMsg.BaseCreateUploadTask", "before do upload, checkDomains = %b, timeout %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(j) });
      if (bool) {
        break;
      }
      paramf.a(j, str3, str2, paramJSONObject, localMap, null, local1, paramString, "createUploadTask", (String)localObject);
      AppMethodBeat.o(179540);
      return;
    }
    paramf.a(j, str3, str2, paramJSONObject, localMap, locala.epW, local1, paramString, "createUploadTask", (String)localObject);
    label709:
    AppMethodBeat.o(179540);
  }
  
  public final String aUD()
  {
    return "uploadTaskId";
  }
  
  final void b(f paramf, String paramString1, String paramString2)
  {
    AppMethodBeat.i(179541);
    Log.w("MicroMsg.BaseCreateUploadTask", "sendFailMsg, uploadTaskId = %s, errMsg = %s", new Object[] { paramString1, paramString2 });
    HashMap localHashMap = new HashMap();
    localHashMap.put("uploadTaskId", paramString1);
    localHashMap.put("state", "fail");
    localHashMap.put("errMsg", paramString2);
    paramString2 = new JSONObject(localHashMap).toString();
    new a().i(paramf).ZR(paramString2).b(this.sjy.aak(paramString1));
    AppMethodBeat.o(179541);
  }
  
  public final String bQs()
  {
    AppMethodBeat.i(179539);
    Object localObject = new StringBuilder();
    com.tencent.mm.plugin.appbrand.t.h.cCm();
    localObject = com.tencent.mm.plugin.appbrand.t.h.cCg();
    AppMethodBeat.o(179539);
    return localObject;
  }
  
  public static final class a
    extends bc
  {
    public static final int CTRL_INDEX = 274;
    public static final String NAME = "onUploadTaskStateChange";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.s.c.a
 * JD-Core Version:    0.7.0.1
 */