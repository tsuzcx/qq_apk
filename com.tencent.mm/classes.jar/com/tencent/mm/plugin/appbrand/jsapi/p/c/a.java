package com.tencent.mm.plugin.appbrand.jsapi.p.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.o;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import com.tencent.mm.plugin.appbrand.jsapi.az;
import com.tencent.mm.plugin.appbrand.jsapi.base.h;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.s.g;
import com.tencent.mm.plugin.appbrand.s.g.a;
import com.tencent.mm.plugin.appbrand.s.i;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.vfs.q;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.a.c;
import org.json.JSONObject;

public final class a
  implements h
{
  com.tencent.mm.plugin.appbrand.jsapi.base.a pei;
  
  public a(com.tencent.mm.plugin.appbrand.jsapi.base.a parama)
  {
    this.pei = parama;
  }
  
  public final void a(final e parame, JSONObject paramJSONObject, final String paramString)
  {
    AppMethodBeat.i(179540);
    Log.d("MicroMsg.BaseCreateUploadTask", "JsApiCreateUploadTask, appId:%s taskId:%s", new Object[] { parame.getAppId(), paramString });
    String str4 = parame.getAppId();
    String str1 = paramJSONObject.optString("filePath");
    if (Util.isNullOrNil(str1))
    {
      b(parame, paramString, "filePath is null");
      AppMethodBeat.o(179540);
      return;
    }
    Object localObject = parame.getFileSystem().adL(str1);
    if ((localObject == null) || (!((q)localObject).ifE()))
    {
      Log.e("MicroMsg.BaseCreateUploadTask", "upload appId(%s) tempFilePath(%s), found no real file", new Object[] { parame.getAppId(), str1 });
      b(parame, paramString, "fail:file doesn't exist");
      AppMethodBeat.o(179540);
      return;
    }
    final String str2 = ((q)localObject).bOF();
    String str3 = MimeTypeUtil.getMimeTypeByFilePath(str1);
    Log.i("MicroMsg.BaseCreateUploadTask", "upload appId(%s) tempFilePath(%s) realFilePath(%s)", new Object[] { parame.getAppId(), str1, str2 });
    g.a local1 = new g.a()
    {
      private JSONObject peI;
      
      public final void M(JSONObject paramAnonymousJSONObject)
      {
        AppMethodBeat.i(179538);
        if (paramAnonymousJSONObject == null)
        {
          AppMethodBeat.o(179538);
          return;
        }
        if (paramAnonymousJSONObject.optBoolean("__AppBrandRemoteDebugRequestHeader__"))
        {
          if (!((com.tencent.mm.plugin.appbrand.s.a)parame.au(com.tencent.mm.plugin.appbrand.s.a.class)).cwS)
          {
            AppMethodBeat.o(179538);
            return;
          }
          paramAnonymousJSONObject.remove("__AppBrandRemoteDebugRequestHeader__");
          o localo = new o();
          localo.fuU.fuV = "upload";
          localo.fuU.fuX = paramAnonymousJSONObject;
          localo.fuU.fuW = paramString;
          EventCenter.instance.publish(localo);
          AppMethodBeat.o(179538);
          return;
        }
        this.peI = paramAnonymousJSONObject;
        paramAnonymousJSONObject = new HashMap();
        paramAnonymousJSONObject.put("uploadTaskId", paramString);
        paramAnonymousJSONObject.put("state", "headersReceived");
        paramAnonymousJSONObject.put("header", this.peI);
        paramAnonymousJSONObject = new JSONObject(paramAnonymousJSONObject).toString();
        new a.a().j(parame).agU(paramAnonymousJSONObject).b(a.this.pei.ahn(paramString));
        AppMethodBeat.o(179538);
      }
      
      public final void aik(String paramAnonymousString)
      {
        AppMethodBeat.i(179535);
        Log.i("MicroMsg.BaseCreateUploadTask", "onUploadResult uploadTaskId:%s, filePath:%s, result:%s, errMsg:%d", new Object[] { paramString, str2, paramAnonymousString, Integer.valueOf(-1) });
        if (a.j(parame, paramString))
        {
          AppMethodBeat.o(179535);
          return;
        }
        a.this.b(parame, paramString, paramAnonymousString);
        AppMethodBeat.o(179535);
      }
      
      public final void j(int paramAnonymousInt1, String paramAnonymousString, int paramAnonymousInt2)
      {
        AppMethodBeat.i(179536);
        Log.i("MicroMsg.BaseCreateUploadTask", "onUploadResultWithCode uploadTaskId:%s, filePath:%s, result:%s, errMsg:%d, statusCode %d", new Object[] { paramString, str2, paramAnonymousString, Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        if (paramAnonymousInt1 == 0)
        {
          HashMap localHashMap = new HashMap();
          localHashMap.put("data", paramAnonymousString);
          localHashMap.put("statusCode", Integer.valueOf(paramAnonymousInt2));
          localHashMap.put("uploadTaskId", paramString);
          localHashMap.put("state", "success");
          if (this.peI != null) {
            localHashMap.put("header", this.peI);
          }
          paramAnonymousString = new JSONObject(localHashMap).toString();
          new a.a().j(parame).agU(paramAnonymousString).b(a.this.pei.ahn(paramString));
          a.this.pei.remove(paramString);
          AppMethodBeat.o(179536);
          return;
        }
        if (a.j(parame, paramString))
        {
          AppMethodBeat.o(179536);
          return;
        }
        a.this.b(parame, paramString, paramAnonymousString);
        AppMethodBeat.o(179536);
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
        new a.a().j(parame).agU((String)localObject).b(a.this.pei.ahn(paramString));
        AppMethodBeat.o(179537);
      }
    };
    com.tencent.mm.plugin.appbrand.s.a locala = (com.tencent.mm.plugin.appbrand.s.a)parame.au(com.tencent.mm.plugin.appbrand.s.a.class);
    Map localMap = j.a(paramJSONObject, locala);
    localObject = paramJSONObject.optString("url");
    if (Util.isNullOrNil((String)localObject))
    {
      Log.i("MicroMsg.BaseCreateUploadTask", "url is null");
      b(parame, paramString, "url is null or nil");
      AppMethodBeat.o(179540);
      return;
    }
    if (paramJSONObject.optBoolean("__skipDomainCheck__")) {}
    for (boolean bool = false; (bool) && (!j.b(locala.cxC, (String)localObject)); bool = locala.qim)
    {
      Log.i("MicroMsg.BaseCreateUploadTask", "not in domain url %s", new Object[] { localObject });
      b(parame, paramString, "url not in domain list");
      AppMethodBeat.o(179540);
      return;
    }
    if (locala.cxq <= 0) {
      Log.i("MicroMsg.BaseCreateUploadTask", "concurrent <= 0 ");
    }
    int j = paramJSONObject.optInt("timeout", 0);
    int i = j;
    if (j <= 0) {
      i = j.a(locala, 2);
    }
    if (i > 0) {}
    for (;;)
    {
      if (i.cbT().akV(str4) == null)
      {
        localObject = new g(parame);
        i locali = i.cbT();
        parame = (e)localObject;
        if (!locali.qiH.containsKey(str4)) {
          locali.qiH.put(str4, localObject);
        }
      }
      for (parame = (e)localObject;; parame = i.cbT().akV(str4))
      {
        localObject = c.beJ(str1);
        if (parame == null) {
          break label531;
        }
        Log.i("MicroMsg.BaseCreateUploadTask", "before do upload, checkDomains = %b, timeout %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) });
        if (bool) {
          break;
        }
        parame.a(i, str3, str2, paramJSONObject, localMap, null, local1, paramString, "createUploadTask", (String)localObject);
        AppMethodBeat.o(179540);
        return;
      }
      parame.a(i, str3, str2, paramJSONObject, localMap, locala.cxC, local1, paramString, "createUploadTask", (String)localObject);
      label531:
      AppMethodBeat.o(179540);
      return;
      i = 60000;
    }
  }
  
  public final String aBF()
  {
    return "uploadTaskId";
  }
  
  final void b(e parame, String paramString1, String paramString2)
  {
    AppMethodBeat.i(179541);
    Log.w("MicroMsg.BaseCreateUploadTask", "sendFailMsg, uploadTaskId = %s, errMsg = %s", new Object[] { paramString1, paramString2 });
    HashMap localHashMap = new HashMap();
    localHashMap.put("uploadTaskId", paramString1);
    localHashMap.put("state", "fail");
    localHashMap.put("errMsg", paramString2);
    paramString2 = new JSONObject(localHashMap).toString();
    new a().j(parame).agU(paramString2).b(this.pei.ahn(paramString1));
    AppMethodBeat.o(179541);
  }
  
  public final String bsL()
  {
    AppMethodBeat.i(179539);
    Object localObject = new StringBuilder();
    i.cbT();
    localObject = i.cbN();
    AppMethodBeat.o(179539);
    return localObject;
  }
  
  public static final class a
    extends az
  {
    public static final int CTRL_INDEX = 274;
    public static final String NAME = "onUploadTaskStateChange";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.p.c.a
 * JD-Core Version:    0.7.0.1
 */