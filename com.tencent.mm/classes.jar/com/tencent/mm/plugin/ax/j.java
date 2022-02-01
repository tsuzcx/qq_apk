package com.tencent.mm.plugin.ax;

import android.util.Base64;
import android.webkit.JavascriptInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.z;
import com.tencent.mm.plugin.webview.jsapi.f;
import com.tencent.mm.plugin.webview.jsapi.p.a;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.ghd;
import com.tencent.mm.protocal.protobuf.ghe;
import com.tencent.mm.protocal.protobuf.ka;
import com.tencent.mm.protocal.protobuf.kb;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.protocal.protobuf.pa;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webjsapi/WxJsEngineContextAPI;", "Lcom/tencent/mm/plugin/webjsapi/JSAPI;", "Lcom/tencent/mm/plugin/webjsapi/WxJsEngineContextAPIContext;", "context", "(Lcom/tencent/mm/plugin/webjsapi/WxJsEngineContextAPIContext;)V", "cgi", "", "cmdId", "", "cgiUrl", "", "reqProtoBuf", "callback", "cgiCallBack", "errMsg", "commonCgi", "request", "getBasePkgVersion", "getBizPkgVersion", "getLocalData", "key", "invoke", "func", "message", "setLocalData", "data", "asCallbacker", "Lcom/tencent/mm/plugin/webview/jsapi/ICallbackHandler;", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
  extends a<k>
{
  public j(k paramk)
  {
    super("wxJsEngineClient", (b)paramk);
    AppMethodBeat.i(260793);
    AppMethodBeat.o(260793);
  }
  
  private static final int a(j paramj, int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2, com.tencent.mm.am.c paramc, p paramp)
  {
    AppMethodBeat.i(260814);
    s.u(paramj, "this$0");
    s.u(paramString1, "$callback");
    s.u(paramc, "rr");
    Log.i(paramj.getTAG(), s.X("do cgi callback cmdId=", Integer.valueOf(paramInt1)));
    if (Util.isNullOrNil(c.c.b(paramc.otC).getData()))
    {
      paramString2 = new pa();
      paramString2.BaseResponse = new kd();
      paramc = paramString2.BaseResponse;
      paramp = new etl();
      paramp.btH("fail response data is empty");
      ah localah = ah.aiuX;
      paramc.akjO = paramp;
      paramString2.BaseResponse.Idd = -1;
      paramString2 = Base64.encode(paramString2.toByteArray(), 2);
      s.s(paramString2, "encode(resp.toByteArray(), Base64.NO_WRAP)");
      paramc = StandardCharsets.UTF_8;
      s.s(paramc, "UTF_8");
      paramString2 = new String(paramString2, paramc);
      c.a.a((c)paramj.WlE, paramString1, "'" + paramString2 + '\'', null, 4);
      AppMethodBeat.o(260814);
      return 0;
    }
    paramString2 = Base64.encode(c.c.b(paramc.otC).getData(), 2);
    s.s(paramString2, "encode(rr.responseProtoBuf.data, Base64.NO_WRAP)");
    paramc = StandardCharsets.UTF_8;
    s.s(paramc, "UTF_8");
    paramString2 = new String(paramString2, paramc);
    c.a.a((c)paramj.WlE, paramString1, "'" + paramString2 + '\'', null, 4);
    AppMethodBeat.o(260814);
    return 0;
  }
  
  private static final int a(j paramj, String paramString1, int paramInt1, int paramInt2, String paramString2, com.tencent.mm.am.c paramc, p paramp)
  {
    AppMethodBeat.i(260827);
    s.u(paramj, "this$0");
    s.u(paramString1, "$callback");
    Log.i(paramj.getTAG(), "videoPreloadCgi callback " + paramInt1 + '/' + paramInt1 + ' ' + paramString2);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      paramString2 = new JSONObject();
      paramString2.put("errMsg", "fail");
      paramString2.put("errCode", paramInt2);
      paramString2 = paramString2.toString();
      s.s(paramString2, "JSONObject().apply {\n   …             }.toString()");
      c.a.a((c)paramj.WlE, paramString1, paramString2, null, 4);
    }
    for (;;)
    {
      AppMethodBeat.o(260827);
      return 0;
      paramp = paramj.getTAG();
      paramString2 = c.c.b(paramc.otC);
      if ((paramString2 instanceof ghe))
      {
        paramString2 = (ghe)paramString2;
        label163:
        if (paramString2 != null) {
          break label305;
        }
        paramString2 = null;
        label171:
        Log.d(paramp, s.X("resp_str = ", paramString2));
        paramp = new JSONObject();
        paramp.put("errMsg", "ok");
        paramp.put("errCode", paramInt2);
        paramString2 = c.c.b(paramc.otC);
        if (!(paramString2 instanceof ghe)) {
          break label315;
        }
        paramString2 = (ghe)paramString2;
        label238:
        if (paramString2 != null) {
          break label321;
        }
        paramString2 = "{}";
      }
      try
      {
        for (;;)
        {
          paramp.put("data", new JSONObject(paramString2));
          paramString2 = paramp.toString();
          s.s(paramString2, "JSONObject().apply {\n   …             }.toString()");
          c.a.a((c)paramj.WlE, paramString1, paramString2, null, 4);
          break;
          paramString2 = null;
          break label163;
          label305:
          paramString2 = paramString2.acdq;
          break label171;
          label315:
          paramString2 = null;
          break label238;
          label321:
          paramc = paramString2.acdq;
          paramString2 = paramc;
          if (paramc == null) {
            paramString2 = "{}";
          }
        }
      }
      catch (Exception paramc)
      {
        for (;;)
        {
          paramp.put("data", paramString2);
        }
      }
    }
  }
  
  private static final void a(j paramj, String paramString1, String paramString2, String paramString3, Map paramMap)
  {
    AppMethodBeat.i(260804);
    s.u(paramj, "this$0");
    s.u(paramString1, "$this_asCallbacker");
    HashMap localHashMap = new HashMap();
    Map localMap = (Map)localHashMap;
    s.s(paramString3, "ret");
    localMap.put("err_msg", paramString3);
    if (paramMap != null) {
      localHashMap.putAll(paramMap);
    }
    paramString2 = p.a.a(paramString2, (Map)localHashMap, false, "");
    Log.i(paramj.getTAG(), "invoke callback: " + paramString3 + ", " + paramString1 + ", " + paramString2);
    paramj = (c)paramj.WlE;
    paramString2 = new i(paramString2).Fs("__params").toString();
    s.s(paramString2, "JSONObject(resp).getJSON…ct(\"__params\").toString()");
    c.a.a(paramj, paramString1, paramString2, null, 4);
    AppMethodBeat.o(260804);
  }
  
  @JavascriptInterface
  public final void cgi(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(260856);
    s.u(paramString1, "cgiUrl");
    s.u(paramString2, "reqProtoBuf");
    s.u(paramString3, "callback");
    if (!((k)this.WlE).aS(paramInt, paramString1))
    {
      AppMethodBeat.o(260856);
      return;
    }
    Log.i(getTAG(), "do cgi cmdId=" + paramInt + ", cgiUrl=" + paramString1);
    try
    {
      com.tencent.mm.am.c.a locala = new com.tencent.mm.am.c.a();
      Charset localCharset = Charset.forName("UTF-8");
      s.s(localCharset, "forName(\"UTF-8\")");
      paramString2 = paramString2.getBytes(localCharset);
      s.s(paramString2, "(this as java.lang.String).getBytes(charset)");
      locala.otE = ((com.tencent.mm.bx.a)new ka(Base64.decode(paramString2, 2)));
      locala.otF = ((com.tencent.mm.bx.a)new kb());
      locala.uri = paramString1;
      locala.funcId = paramInt;
      z.a(locala.bEF(), new j..ExternalSyntheticLambda0(this, paramInt, paramString3));
      AppMethodBeat.o(260856);
      return;
    }
    catch (Exception paramString1)
    {
      Log.printErrStackTrace(getTAG(), (Throwable)paramString1, "do cgi", new Object[0]);
      AppMethodBeat.o(260856);
    }
  }
  
  @JavascriptInterface
  public final void commonCgi(String paramString1, String paramString2)
  {
    AppMethodBeat.i(260862);
    s.u(paramString1, "request");
    s.u(paramString2, "callback");
    Log.i(getTAG(), "[TRACE_VIDEO_PRELOAD] jsapi cgi");
    Object localObject = new com.tencent.mm.am.c.a();
    ((com.tencent.mm.am.c.a)localObject).otE = ((com.tencent.mm.bx.a)new ghd());
    ((com.tencent.mm.am.c.a)localObject).otF = ((com.tencent.mm.bx.a)new ghe());
    ((com.tencent.mm.am.c.a)localObject).uri = "/cgi-bin/mmbiz-bin/appmsg/web_comm_prefetch";
    ((com.tencent.mm.am.c.a)localObject).funcId = 4924;
    localObject = ((com.tencent.mm.am.c.a)localObject).bEF();
    com.tencent.mm.bx.a locala = c.b.b(((com.tencent.mm.am.c)localObject).otB);
    if (locala == null)
    {
      paramString1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.WebCommPrefetchReq");
      AppMethodBeat.o(260862);
      throw paramString1;
    }
    ((ghd)locala).acdp = paramString1;
    z.a((com.tencent.mm.am.c)localObject, new j..ExternalSyntheticLambda1(this, paramString2));
    AppMethodBeat.o(260862);
  }
  
  @JavascriptInterface
  public final int getBasePkgVersion()
  {
    AppMethodBeat.i(260841);
    int i = ((k)this.WlE).getBasePkgVersion();
    AppMethodBeat.o(260841);
    return i;
  }
  
  @JavascriptInterface
  public final int getBizPkgVersion()
  {
    AppMethodBeat.i(260844);
    int i = ((k)this.WlE).getBizPkgVersion();
    AppMethodBeat.o(260844);
    return i;
  }
  
  @JavascriptInterface
  public final String getLocalData(String paramString)
  {
    AppMethodBeat.i(260875);
    s.u(paramString, "key");
    paramString = ((k)this.WlE).getLocalData(paramString);
    AppMethodBeat.o(260875);
    return paramString;
  }
  
  @JavascriptInterface
  public final void invoke(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(260850);
    s.u(paramString1, "func");
    s.u(paramString2, "message");
    s.u(paramString3, "callback");
    Log.d(getTAG(), "invoke: " + paramString1 + ' ' + paramString3 + ' ' + paramString2);
    ((k)this.WlE).ddL().a(p.a.bq(paramString1, paramString2, paramString3), new j..ExternalSyntheticLambda2(this, paramString3));
    ((k)this.WlE).fM(paramString1, paramString2);
    AppMethodBeat.o(260850);
  }
  
  @JavascriptInterface
  public final void setLocalData(String paramString1, String paramString2)
  {
    AppMethodBeat.i(260870);
    s.u(paramString1, "key");
    s.u(paramString2, "data");
    ((k)this.WlE).setLocalData(paramString1, paramString2);
    AppMethodBeat.o(260870);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ax.j
 * JD-Core Version:    0.7.0.1
 */