package com.tencent.mm.plugin.ab;

import android.util.Base64;
import android.webkit.JavascriptInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.i;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.aa.a;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.webview.d.n.a;
import com.tencent.mm.protocal.protobuf.ezy;
import com.tencent.mm.protocal.protobuf.ezz;
import com.tencent.mm.protocal.protobuf.jp;
import com.tencent.mm.protocal.protobuf.jq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webjsapi/WxJsEngineContextAPI;", "Lcom/tencent/mm/plugin/webjsapi/JSAPI;", "Lcom/tencent/mm/plugin/webjsapi/WxJsEngineContextAPIContext;", "context", "(Lcom/tencent/mm/plugin/webjsapi/WxJsEngineContextAPIContext;)V", "cgi", "", "cmdId", "", "cgiUrl", "", "reqProtoBuf", "callback", "cgiCallBack", "errMsg", "commonCgi", "request", "getBasePkgVersion", "getBizPkgVersion", "getLocalData", "key", "invoke", "func", "message", "setLocalData", "data", "asCallbacker", "Lcom/tencent/mm/plugin/webview/jsapi/ICallbackHandler;", "webview-sdk_release"})
public final class j
  extends a<k>
{
  public j(k paramk)
  {
    super("wxJsEngineClient", (b)paramk);
    AppMethodBeat.i(224834);
    AppMethodBeat.o(224834);
  }
  
  @JavascriptInterface
  public final void cgi(final int paramInt, String paramString1, String paramString2, final String paramString3)
  {
    AppMethodBeat.i(224830);
    p.h(paramString1, "cgiUrl");
    p.h(paramString2, "reqProtoBuf");
    p.h(paramString3, "callback");
    if (!((k)this.IBa).aD(paramInt, paramString1))
    {
      AppMethodBeat.o(224830);
      return;
    }
    Log.i(this.TAG, "do cgi cmdId=" + paramInt + ", cgiUrl=" + paramString1);
    try
    {
      d.a locala = new d.a();
      Charset localCharset = Charset.forName("UTF-8");
      p.g(localCharset, "Charset.forName(\"UTF-8\")");
      paramString2 = paramString2.getBytes(localCharset);
      p.g(paramString2, "(this as java.lang.String).getBytes(charset)");
      locala.c((com.tencent.mm.bw.a)new jp(Base64.decode(paramString2, 2)));
      locala.d((com.tencent.mm.bw.a)new jq());
      locala.MB(paramString1);
      locala.sG(paramInt);
      aa.a(locala.aXF(), (aa.a)new b(this, paramInt, paramString3));
      AppMethodBeat.o(224830);
      return;
    }
    catch (Exception paramString1)
    {
      Log.printErrStackTrace(this.TAG, (Throwable)paramString1, "do cgi", new Object[0]);
      AppMethodBeat.o(224830);
    }
  }
  
  @JavascriptInterface
  public final void commonCgi(String paramString1, final String paramString2)
  {
    AppMethodBeat.i(224831);
    p.h(paramString1, "request");
    p.h(paramString2, "callback");
    Log.i(this.TAG, "[TRACE_VIDEO_PRELOAD] jsapi cgi");
    Object localObject = new d.a();
    ((d.a)localObject).c((com.tencent.mm.bw.a)new ezy());
    ((d.a)localObject).d((com.tencent.mm.bw.a)new ezz());
    ((d.a)localObject).MB("/cgi-bin/mmbiz-bin/appmsg/web_comm_prefetch");
    ((d.a)localObject).sG(4924);
    localObject = ((d.a)localObject).aXF();
    p.g(localObject, "rr");
    com.tencent.mm.bw.a locala = ((com.tencent.mm.ak.d)localObject).aYJ();
    if (locala == null)
    {
      paramString1 = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.WebCommPrefetchReq");
      AppMethodBeat.o(224831);
      throw paramString1;
    }
    ((ezy)locala).NvW = paramString1;
    aa.a((com.tencent.mm.ak.d)localObject, (aa.a)new c(this, paramString2));
    AppMethodBeat.o(224831);
  }
  
  @JavascriptInterface
  public final int getBasePkgVersion()
  {
    AppMethodBeat.i(224827);
    int i = ((k)this.IBa).getBasePkgVersion();
    AppMethodBeat.o(224827);
    return i;
  }
  
  @JavascriptInterface
  public final int getBizPkgVersion()
  {
    AppMethodBeat.i(224828);
    int i = ((k)this.IBa).getBizPkgVersion();
    AppMethodBeat.o(224828);
    return i;
  }
  
  @JavascriptInterface
  public final String getLocalData(String paramString)
  {
    AppMethodBeat.i(224833);
    p.h(paramString, "key");
    paramString = ((k)this.IBa).getLocalData(paramString);
    AppMethodBeat.o(224833);
    return paramString;
  }
  
  @JavascriptInterface
  public final void invoke(String paramString1, String paramString2, final String paramString3)
  {
    AppMethodBeat.i(224829);
    p.h(paramString1, "func");
    p.h(paramString2, "message");
    p.h(paramString3, "callback");
    Log.d(this.TAG, "invoke: ".concat(String.valueOf(paramString2)));
    ((k)this.IBa).cna().a(n.a.lY(paramString1, paramString2), (com.tencent.mm.plugin.webview.d.b)new a(this, paramString3));
    ((k)this.IBa).fe(paramString1, paramString2);
    AppMethodBeat.o(224829);
  }
  
  @JavascriptInterface
  public final void setLocalData(String paramString1, String paramString2)
  {
    AppMethodBeat.i(224832);
    p.h(paramString1, "key");
    p.h(paramString2, "data");
    ((k)this.IBa).setLocalData(paramString1, paramString2);
    AppMethodBeat.o(224832);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "callbackId", "", "kotlin.jvm.PlatformType", "ret", "retValue", "", "", "", "doCallback"})
  static final class a
    implements com.tencent.mm.plugin.webview.d.b
  {
    a(j paramj, String paramString) {}
    
    public final void h(String paramString1, String paramString2, Map<String, Object> paramMap)
    {
      AppMethodBeat.i(224824);
      HashMap localHashMap = new HashMap();
      Map localMap = (Map)localHashMap;
      p.g(paramString2, "ret");
      localMap.put("err_msg", paramString2);
      if (paramMap != null) {
        localHashMap.putAll(paramMap);
      }
      paramString1 = n.a.a(paramString1, (Map)localHashMap, false, "");
      Log.i(this.IBj.TAG, "invoke callback: " + paramString2 + ", " + paramString1);
      paramString2 = (k)this.IBj.IBa;
      paramMap = paramString3;
      paramString1 = new i(paramString1).FJ("__params").toString();
      p.g(paramString1, "JSONObject(resp).getJSON…ct(\"__params\").toString()");
      c.a.a(paramString2, paramMap, paramString1, null, 4);
      AppMethodBeat.o(224824);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "<anonymous parameter 0>", "<anonymous parameter 1>", "<anonymous parameter 2>", "", "kotlin.jvm.PlatformType", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "<anonymous parameter 4>", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback"})
  static final class b
    implements aa.a
  {
    b(j paramj, int paramInt, String paramString) {}
    
    public final int a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.d paramd, q paramq)
    {
      AppMethodBeat.i(224825);
      p.h(paramd, "rr");
      Log.i(this.IBj.TAG, "do cgi callback cmdId=" + paramInt);
      paramString = paramd.aYK();
      p.g(paramString, "rr.responseProtoBuf");
      if (Util.isNullOrNil(paramString.getData()))
      {
        j.a(this.IBj, "fail response data is empty", paramString3);
        AppMethodBeat.o(224825);
        return 0;
      }
      paramString = paramd.aYK();
      p.g(paramString, "rr.responseProtoBuf");
      paramString = Base64.encode(paramString.getData(), 2);
      p.g(paramString, "Base64.encode(rr.respons…Buf.data, Base64.NO_WRAP)");
      paramd = StandardCharsets.UTF_8;
      p.g(paramd, "StandardCharsets.UTF_8");
      paramString = new String(paramString, paramd);
      c.a.a((k)this.IBj.IBa, paramString3, "'" + paramString + '\'', null, 4);
      AppMethodBeat.o(224825);
      return 0;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "errType", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "comReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback"})
  static final class c
    implements aa.a
  {
    c(j paramj, String paramString) {}
    
    public final int a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.d paramd, q paramq)
    {
      AppMethodBeat.i(224826);
      Log.i(this.IBj.TAG, "videoPreloadCgi callback " + paramInt1 + '/' + paramInt1 + ' ' + paramString);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        paramString = new JSONObject();
        paramString.put("errMsg", "fail");
        paramString.put("errCode", paramInt2);
        paramString = paramString.toString();
        p.g(paramString, "org.json.JSONObject().ap…             }.toString()");
        c.a.a((k)this.IBj.IBa, paramString2, paramString, null, 4);
      }
      for (;;)
      {
        AppMethodBeat.o(224826);
        return 0;
        String str = this.IBj.TAG;
        StringBuilder localStringBuilder = new StringBuilder("resp_str = ");
        p.g(paramd, "comReqResp");
        paramq = paramd.aYK();
        paramString = paramq;
        if (!(paramq instanceof ezz)) {
          paramString = null;
        }
        paramString = (ezz)paramString;
        if (paramString != null)
        {
          paramString = paramString.NvX;
          Log.d(str, paramString);
          paramq = new JSONObject();
          paramq.put("errMsg", "ok");
          paramq.put("errCode", paramInt2);
          paramd = paramd.aYK();
          paramString = paramd;
          if (!(paramd instanceof ezz)) {
            paramString = null;
          }
          paramString = (ezz)paramString;
          if (paramString != null)
          {
            paramd = paramString.NvX;
            paramString = paramd;
            if (paramd != null) {}
          }
          else
          {
            paramString = "{}";
          }
        }
        try
        {
          paramq.put("data", new JSONObject(paramString));
          paramString = paramq.toString();
          p.g(paramString, "org.json.JSONObject().ap…             }.toString()");
          c.a.a((k)this.IBj.IBa, paramString2, paramString, null, 4);
          continue;
          paramString = null;
        }
        catch (Exception paramd)
        {
          for (;;)
          {
            paramq.put("data", paramString);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ab.j
 * JD-Core Version:    0.7.0.1
 */