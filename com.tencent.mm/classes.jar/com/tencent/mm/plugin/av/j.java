package com.tencent.mm.plugin.av;

import android.util.Base64;
import android.webkit.JavascriptInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.an.aa;
import com.tencent.mm.an.aa.a;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.q;
import com.tencent.mm.plugin.webview.d.n.a;
import com.tencent.mm.protocal.protobuf.fkp;
import com.tencent.mm.protocal.protobuf.fkq;
import com.tencent.mm.protocal.protobuf.je;
import com.tencent.mm.protocal.protobuf.jf;
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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webjsapi/WxJsEngineContextAPI;", "Lcom/tencent/mm/plugin/webjsapi/JSAPI;", "Lcom/tencent/mm/plugin/webjsapi/WxJsEngineContextAPIContext;", "context", "(Lcom/tencent/mm/plugin/webjsapi/WxJsEngineContextAPIContext;)V", "cgi", "", "cmdId", "", "cgiUrl", "", "reqProtoBuf", "callback", "cgiCallBack", "errMsg", "commonCgi", "request", "getBasePkgVersion", "getBizPkgVersion", "getLocalData", "key", "invoke", "func", "message", "setLocalData", "data", "asCallbacker", "Lcom/tencent/mm/plugin/webview/jsapi/ICallbackHandler;", "webview-sdk_release"})
public final class j
  extends a<k>
{
  public j(k paramk)
  {
    super("wxJsEngineClient", (b)paramk);
    AppMethodBeat.i(209309);
    AppMethodBeat.o(209309);
  }
  
  @JavascriptInterface
  public final void cgi(final int paramInt, String paramString1, String paramString2, final String paramString3)
  {
    AppMethodBeat.i(209305);
    p.k(paramString1, "cgiUrl");
    p.k(paramString2, "reqProtoBuf");
    p.k(paramString3, "callback");
    if (!((k)this.Pvj).aF(paramInt, paramString1))
    {
      AppMethodBeat.o(209305);
      return;
    }
    Log.i(this.TAG, "do cgi cmdId=" + paramInt + ", cgiUrl=" + paramString1);
    try
    {
      d.a locala = new d.a();
      Charset localCharset = Charset.forName("UTF-8");
      p.j(localCharset, "Charset.forName(\"UTF-8\")");
      paramString2 = paramString2.getBytes(localCharset);
      p.j(paramString2, "(this as java.lang.String).getBytes(charset)");
      locala.c((com.tencent.mm.cd.a)new je(Base64.decode(paramString2, 2)));
      locala.d((com.tencent.mm.cd.a)new jf());
      locala.TW(paramString1);
      locala.vD(paramInt);
      aa.a(locala.bgN(), (aa.a)new b(this, paramInt, paramString3));
      AppMethodBeat.o(209305);
      return;
    }
    catch (Exception paramString1)
    {
      Log.printErrStackTrace(this.TAG, (Throwable)paramString1, "do cgi", new Object[0]);
      AppMethodBeat.o(209305);
    }
  }
  
  @JavascriptInterface
  public final void commonCgi(String paramString1, final String paramString2)
  {
    AppMethodBeat.i(209306);
    p.k(paramString1, "request");
    p.k(paramString2, "callback");
    Log.i(this.TAG, "[TRACE_VIDEO_PRELOAD] jsapi cgi");
    Object localObject = new d.a();
    ((d.a)localObject).c((com.tencent.mm.cd.a)new fkp());
    ((d.a)localObject).d((com.tencent.mm.cd.a)new fkq());
    ((d.a)localObject).TW("/cgi-bin/mmbiz-bin/appmsg/web_comm_prefetch");
    ((d.a)localObject).vD(4924);
    localObject = ((d.a)localObject).bgN();
    p.j(localObject, "rr");
    com.tencent.mm.cd.a locala = ((com.tencent.mm.an.d)localObject).bhX();
    if (locala == null)
    {
      paramString1 = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.WebCommPrefetchReq");
      AppMethodBeat.o(209306);
      throw paramString1;
    }
    ((fkp)locala).UJh = paramString1;
    aa.a((com.tencent.mm.an.d)localObject, (aa.a)new c(this, paramString2));
    AppMethodBeat.o(209306);
  }
  
  @JavascriptInterface
  public final int getBasePkgVersion()
  {
    AppMethodBeat.i(209301);
    int i = ((k)this.Pvj).getBasePkgVersion();
    AppMethodBeat.o(209301);
    return i;
  }
  
  @JavascriptInterface
  public final int getBizPkgVersion()
  {
    AppMethodBeat.i(209303);
    int i = ((k)this.Pvj).getBizPkgVersion();
    AppMethodBeat.o(209303);
    return i;
  }
  
  @JavascriptInterface
  public final String getLocalData(String paramString)
  {
    AppMethodBeat.i(209308);
    p.k(paramString, "key");
    paramString = ((k)this.Pvj).getLocalData(paramString);
    AppMethodBeat.o(209308);
    return paramString;
  }
  
  @JavascriptInterface
  public final void invoke(String paramString1, String paramString2, final String paramString3)
  {
    AppMethodBeat.i(209304);
    p.k(paramString1, "func");
    p.k(paramString2, "message");
    p.k(paramString3, "callback");
    Log.d(this.TAG, "invoke: " + paramString1 + ' ' + paramString3 + ' ' + paramString2);
    ((k)this.Pvj).cAI().a(n.a.aX(paramString1, paramString2, paramString3), (com.tencent.mm.plugin.webview.d.b)new a(this, paramString3));
    ((k)this.Pvj).fs(paramString1, paramString2);
    AppMethodBeat.o(209304);
  }
  
  @JavascriptInterface
  public final void setLocalData(String paramString1, String paramString2)
  {
    AppMethodBeat.i(209307);
    p.k(paramString1, "key");
    p.k(paramString2, "data");
    ((k)this.Pvj).setLocalData(paramString1, paramString2);
    AppMethodBeat.o(209307);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "callbackId", "", "kotlin.jvm.PlatformType", "ret", "retValue", "", "", "", "doCallback"})
  static final class a
    implements com.tencent.mm.plugin.webview.d.b
  {
    a(j paramj, String paramString) {}
    
    public final void h(String paramString1, String paramString2, Map<String, Object> paramMap)
    {
      AppMethodBeat.i(214051);
      HashMap localHashMap = new HashMap();
      Map localMap = (Map)localHashMap;
      p.j(paramString2, "ret");
      localMap.put("err_msg", paramString2);
      if (paramMap != null) {
        localHashMap.putAll(paramMap);
      }
      paramString1 = n.a.a(paramString1, (Map)localHashMap, false, "");
      Log.i(this.Pvs.TAG, "invoke callback: " + paramString2 + ", " + paramString3 + ", " + paramString1);
      paramString2 = (k)this.Pvs.Pvj;
      paramMap = paramString3;
      paramString1 = new i(paramString1).MJ("__params").toString();
      p.j(paramString1, "JSONObject(resp).getJSON…ct(\"__params\").toString()");
      c.a.a(paramString2, paramMap, paramString1, null, 4);
      AppMethodBeat.o(214051);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "<anonymous parameter 0>", "<anonymous parameter 1>", "<anonymous parameter 2>", "", "kotlin.jvm.PlatformType", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "<anonymous parameter 4>", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback"})
  static final class b
    implements aa.a
  {
    b(j paramj, int paramInt, String paramString) {}
    
    public final int a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.d paramd, q paramq)
    {
      AppMethodBeat.i(207135);
      p.k(paramd, "rr");
      Log.i(this.Pvs.TAG, "do cgi callback cmdId=" + paramInt);
      paramString = paramd.bhY();
      p.j(paramString, "rr.responseProtoBuf");
      if (Util.isNullOrNil(paramString.getData()))
      {
        j.a(this.Pvs, "fail response data is empty", paramString3);
        AppMethodBeat.o(207135);
        return 0;
      }
      paramString = paramd.bhY();
      p.j(paramString, "rr.responseProtoBuf");
      paramString = Base64.encode(paramString.getData(), 2);
      p.j(paramString, "Base64.encode(rr.respons…Buf.data, Base64.NO_WRAP)");
      paramd = StandardCharsets.UTF_8;
      p.j(paramd, "StandardCharsets.UTF_8");
      paramString = new String(paramString, paramd);
      c.a.a((k)this.Pvs.Pvj, paramString3, "'" + paramString + '\'', null, 4);
      AppMethodBeat.o(207135);
      return 0;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "errType", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "comReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback"})
  static final class c
    implements aa.a
  {
    c(j paramj, String paramString) {}
    
    public final int a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.d paramd, q paramq)
    {
      AppMethodBeat.i(207337);
      Log.i(this.Pvs.TAG, "videoPreloadCgi callback " + paramInt1 + '/' + paramInt1 + ' ' + paramString);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        paramString = new JSONObject();
        paramString.put("errMsg", "fail");
        paramString.put("errCode", paramInt2);
        paramString = paramString.toString();
        p.j(paramString, "org.json.JSONObject().ap…             }.toString()");
        c.a.a((k)this.Pvs.Pvj, paramString2, paramString, null, 4);
      }
      for (;;)
      {
        AppMethodBeat.o(207337);
        return 0;
        String str = this.Pvs.TAG;
        StringBuilder localStringBuilder = new StringBuilder("resp_str = ");
        p.j(paramd, "comReqResp");
        paramq = paramd.bhY();
        paramString = paramq;
        if (!(paramq instanceof fkq)) {
          paramString = null;
        }
        paramString = (fkq)paramString;
        if (paramString != null)
        {
          paramString = paramString.UJi;
          Log.d(str, paramString);
          paramq = new JSONObject();
          paramq.put("errMsg", "ok");
          paramq.put("errCode", paramInt2);
          paramd = paramd.bhY();
          paramString = paramd;
          if (!(paramd instanceof fkq)) {
            paramString = null;
          }
          paramString = (fkq)paramString;
          if (paramString != null)
          {
            paramd = paramString.UJi;
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
          p.j(paramString, "org.json.JSONObject().ap…             }.toString()");
          c.a.a((k)this.Pvs.Pvj, paramString2, paramString, null, 4);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.av.j
 * JD-Core Version:    0.7.0.1
 */