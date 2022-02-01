package com.tencent.mm.plugin.appbrand.jsapi.o.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.n;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.jsapi.base.h;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.s.g;
import com.tencent.mm.plugin.appbrand.s.g.a;
import com.tencent.mm.plugin.appbrand.s.i;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.a.d;
import org.json.JSONObject;

public final class a
  implements h
{
  com.tencent.mm.plugin.appbrand.jsapi.base.a mgb;
  
  public a(com.tencent.mm.plugin.appbrand.jsapi.base.a parama)
  {
    this.mgb = parama;
  }
  
  public final void a(final f paramf, JSONObject paramJSONObject, final String paramString)
  {
    AppMethodBeat.i(179540);
    Log.d("MicroMsg.BaseCreateUploadTask", "JsApiCreateUploadTask");
    String str4 = paramf.getAppId();
    String str1 = paramJSONObject.optString("filePath");
    if (Util.isNullOrNil(str1))
    {
      b(paramf, paramString, "filePath is null");
      AppMethodBeat.o(179540);
      return;
    }
    Object localObject = paramf.getFileSystem().VY(str1);
    if ((localObject == null) || (!((o)localObject).exists()))
    {
      Log.e("MicroMsg.BaseCreateUploadTask", "upload appId(%s) tempFilePath(%s), found no real file", new Object[] { paramf.getAppId(), str1 });
      b(paramf, paramString, "fail:file doesn't exist");
      AppMethodBeat.o(179540);
      return;
    }
    final String str2 = aa.z(((o)localObject).her());
    String str3 = MimeTypeUtil.getMimeTypeByFilePath(str1);
    Log.i("MicroMsg.BaseCreateUploadTask", "upload appId(%s) tempFilePath(%s) realFilePath(%s)", new Object[] { paramf.getAppId(), str1, str2 });
    g.a local1 = new g.a()
    {
      private JSONObject mgC;
      
      public final void J(JSONObject paramAnonymousJSONObject)
      {
        AppMethodBeat.i(179538);
        if (paramAnonymousJSONObject == null)
        {
          AppMethodBeat.o(179538);
          return;
        }
        if (paramAnonymousJSONObject.optBoolean("__AppBrandRemoteDebugRequestHeader__"))
        {
          if (!((com.tencent.mm.plugin.appbrand.s.a)paramf.av(com.tencent.mm.plugin.appbrand.s.a.class)).cyp)
          {
            AppMethodBeat.o(179538);
            return;
          }
          paramAnonymousJSONObject.remove("__AppBrandRemoteDebugRequestHeader__");
          n localn = new n();
          localn.dCn.dCo = "upload";
          localn.dCn.dCq = paramAnonymousJSONObject;
          localn.dCn.dCp = paramString;
          EventCenter.instance.publish(localn);
          AppMethodBeat.o(179538);
          return;
        }
        this.mgC = paramAnonymousJSONObject;
        paramAnonymousJSONObject = new HashMap();
        paramAnonymousJSONObject.put("uploadTaskId", paramString);
        paramAnonymousJSONObject.put("state", "headersReceived");
        paramAnonymousJSONObject.put("header", this.mgC);
        paramAnonymousJSONObject = new JSONObject(paramAnonymousJSONObject).toString();
        new a.a().h(paramf).Zh(paramAnonymousJSONObject).a(a.this.mgb.Zz(paramString));
        AppMethodBeat.o(179538);
      }
      
      public final void aat(String paramAnonymousString)
      {
        AppMethodBeat.i(179535);
        Log.i("MicroMsg.BaseCreateUploadTask", "onUploadResult uploadTaskId:%s, filePath:%s, result:%s, errMsg:%d", new Object[] { paramString, str2, paramAnonymousString, Integer.valueOf(-1) });
        if (a.j(paramf, paramString))
        {
          AppMethodBeat.o(179535);
          return;
        }
        a.this.b(paramf, paramString, paramAnonymousString);
        AppMethodBeat.o(179535);
      }
      
      public final void i(int paramAnonymousInt, long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(179537);
        Object localObject = new HashMap();
        ((Map)localObject).put("uploadTaskId", paramString);
        ((Map)localObject).put("state", "progressUpdate");
        ((Map)localObject).put("progress", Integer.valueOf(paramAnonymousInt));
        ((Map)localObject).put("totalBytesSent", Long.valueOf(paramAnonymousLong1));
        ((Map)localObject).put("totalBytesExpectedToSend", Long.valueOf(paramAnonymousLong2));
        localObject = new JSONObject((Map)localObject).toString();
        new a.a().h(paramf).Zh((String)localObject).a(a.this.mgb.Zz(paramString));
        AppMethodBeat.o(179537);
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
          if (this.mgC != null) {
            localHashMap.put("header", this.mgC);
          }
          paramAnonymousString = new JSONObject(localHashMap).toString();
          new a.a().h(paramf).Zh(paramAnonymousString).a(a.this.mgb.Zz(paramString));
          a.this.mgb.remove(paramString);
          AppMethodBeat.o(179536);
          return;
        }
        if (a.j(paramf, paramString))
        {
          AppMethodBeat.o(179536);
          return;
        }
        a.this.b(paramf, paramString, paramAnonymousString);
        AppMethodBeat.o(179536);
      }
    };
    com.tencent.mm.plugin.appbrand.s.a locala = (com.tencent.mm.plugin.appbrand.s.a)paramf.av(com.tencent.mm.plugin.appbrand.s.a.class);
    Map localMap = j.a(paramJSONObject, locala);
    localObject = paramJSONObject.optString("url");
    if (Util.isNullOrNil((String)localObject))
    {
      Log.i("MicroMsg.BaseCreateUploadTask", "url is null");
      b(paramf, paramString, "url is null or nil");
      AppMethodBeat.o(179540);
      return;
    }
    if (paramJSONObject.optBoolean("__skipDomainCheck__")) {}
    for (boolean bool = false; (bool) && (!j.c(locala.cyV, (String)localObject)); bool = locala.nhD)
    {
      Log.i("MicroMsg.BaseCreateUploadTask", "not in domain url %s", new Object[] { localObject });
      b(paramf, paramString, "url not in domain list");
      AppMethodBeat.o(179540);
      return;
    }
    if (locala.cyL <= 0) {
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
      if (i.bPC().adb(str4) == null)
      {
        localObject = new g(paramf);
        i locali = i.bPC();
        paramf = (f)localObject;
        if (!locali.nhY.containsKey(str4)) {
          locali.nhY.put(str4, localObject);
        }
      }
      for (paramf = (f)localObject;; paramf = i.bPC().adb(str4))
      {
        localObject = d.getName(str1);
        if (paramf == null) {
          break label517;
        }
        Log.i("MicroMsg.BaseCreateUploadTask", "before do upload, checkDomains = %b, timeout %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) });
        if (bool) {
          break;
        }
        paramf.a(i, str3, str2, paramJSONObject, localMap, null, local1, paramString, "createUploadTask", (String)localObject);
        AppMethodBeat.o(179540);
        return;
      }
      paramf.a(i, str3, str2, paramJSONObject, localMap, locala.cyV, local1, paramString, "createUploadTask", (String)localObject);
      label517:
      AppMethodBeat.o(179540);
      return;
      i = 60000;
    }
  }
  
  public final String auJ()
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
    new a().h(paramf).Zh(paramString2).a(this.mgb.Zz(paramString1));
    this.mgb.remove(paramString1);
    AppMethodBeat.o(179541);
  }
  
  public final String bjl()
  {
    AppMethodBeat.i(179539);
    Object localObject = new StringBuilder();
    i.bPC();
    localObject = i.bPw();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.o.c.a
 * JD-Core Version:    0.7.0.1
 */