package com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources.NotFoundException;
import android.net.Uri;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.c;
import com.tencent.mm.kernel.b.g.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.UrlExKt;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.f;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.i;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.j.a;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.m.c;
import com.tencent.mm.plugin.webview.core.BaseWebViewController;
import com.tencent.mm.plugin.webview.core.BaseWebViewController.ControllerAction;
import com.tencent.mm.plugin.webview.core.BaseWebViewController.c;
import com.tencent.mm.plugin.webview.core.BaseWebViewController.f;
import com.tencent.mm.plugin.webview.core.l;
import com.tencent.mm.plugin.webview.core.m.a;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.cdf;
import com.tencent.mm.protocal.protobuf.egp;
import com.tencent.mm.protocal.protobuf.fnn;
import com.tencent.mm.protocal.protobuf.gb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMSlotKt;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.ui.f.s;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.vfs.v;
import com.tencent.mm.vfs.y;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.WebViewKind;
import com.tencent.xweb.ad;
import com.tencent.xweb.an;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.g.b.ah.a;
import kotlin.g.b.ai;
import kotlin.g.b.s;
import kotlin.n.n;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.bb;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController;", "Lcom/tencent/mm/plugin/webview/core/WebViewController;", "tmplParams", "Lcom/tencent/mm/protocal/protobuf/TmplParams;", "viewWV", "Lcom/tencent/mm/ui/widget/MMWebView;", "(Lcom/tencent/mm/protocal/protobuf/TmplParams;Lcom/tencent/mm/ui/widget/MMWebView;)V", "API", "", "MPWC_TAG", "getMPWC_TAG", "()Ljava/lang/String;", "MPWC_TAG$delegate", "Lkotlin/Lazy;", "TIMEOUT_TIME", "", "getTIMEOUT_TIME", "()J", "actionsCheckList", "", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$WebEvent;", "getActionsCheckList", "()Ljava/util/List;", "canFinishProgress", "", "getCanFinishProgress", "()Z", "checkNotifyPageTimer", "Ljava/lang/Runnable;", "contentId", "fullUrl", "gettingA8KeyUrl", "Ljava/util/HashSet;", "injectAPI", "isCheckingInject", "<set-?>", "isInjectDataSuccess", "isNotifyPageSuccess", "setNotifyPageSuccess", "(Z)V", "isStopCheckNotifyPage", "setStopCheckNotifyPage", "isTmplReady", "isUseDataCache", "setUseDataCache", "kv15862", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/Kv15862;", "getKv15862", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/Kv15862;", "preloadNext", "getPreloadNext", "setPreloadNext", "rawUrl", "getRawUrl", "receivePageData", "getReceivePageData", "setReceivePageData", "(J)V", "recodeInject", "session", "Lcom/tencent/mm/protocal/protobuf/PreloadSession;", "getSession", "()Lcom/tencent/mm/protocal/protobuf/PreloadSession;", "session$delegate", "startGetPageData", "getStartGetPageData", "setStartGetPageData", "startLoadPage", "getStartLoadPage", "setStartLoadPage", "adjustInnerWidth", "", "canHandleUrl", "url", "cancelReport", "checkInject", "checkNotifyPage", "getLogAPI", "value", "initEnviroment", "isPageCached", "isSameStart", "intent", "Landroid/content/Intent;", "loadForceUrl", "forceUrl", "fullScreen", "loadTmpl", "modifyForceUrl", "needSyncGetA8Key", "notifyPageInfo", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "pageInfo", "onError", "reason", "", "reqUrl", "errType", "errCode", "errMsg", "onPageFinished", "view", "Lcom/tencent/xweb/WebView;", "onPermissionUpdate", "response", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyResp;", "onStartLoad", "onWebLog", "processCommonGetA8KeyFullUrl", "httpHeader", "", "processData", "processGetAppContext", "result", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$MountableCGIResult;", "appMsgContext", "Lcom/tencent/mm/protocal/protobuf/AppMsgContext;", "processReport", "setMpUrl", "startAuth", "force", "stopCheckNotifyPage", "tryPreloadNextWebView", "updateAuth", "isSuccess", "updateData", "updateKV", "updatePageAuth", "validCommitUrl", "validStartUrl", "waitForInject", "waitForReady", "Companion", "ForceUrl", "MpWebViewInterceptor", "NotifyAuth", "PreloadNext", "StartPreload", "UpdateData", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class MpWebViewController
  extends com.tencent.mm.plugin.webview.core.k
{
  private static final int vWL;
  static final int vWM;
  private static final int vWN;
  private static final int vWO;
  private static final int vWP;
  private static final int vWQ;
  private static final int vWR;
  private static final int vWS;
  private static final int vWT;
  private static final int vWU;
  private static final int vWV;
  public static final c vWr;
  private final kotlin.j psN;
  private String sMq;
  private final fnn vRg;
  String vWA;
  private boolean vWB;
  private boolean vWC;
  private final String vWD;
  private final List<BaseWebViewController.f> vWE;
  private final String vWF;
  boolean vWG;
  private final HashSet<String> vWH;
  private boolean vWI;
  private boolean vWJ;
  private final Runnable vWK;
  private final kotlin.j vWs;
  private final i vWt;
  private long vWu;
  private long vWv;
  private long vWw;
  private boolean vWx;
  private boolean vWy;
  private final long vWz;
  
  static
  {
    AppMethodBeat.i(303517);
    vWr = new c((byte)0);
    vWL = -101;
    vWM = -102;
    vWN = -103;
    vWO = -111;
    vWP = -112;
    vWQ = -113;
    vWR = -121;
    vWS = -122;
    vWT = -123;
    vWU = -124;
    vWV = -130;
    AppMethodBeat.o(303517);
  }
  
  public MpWebViewController(fnn paramfnn, final MMWebView paramMMWebView)
  {
    super(paramMMWebView);
    AppMethodBeat.i(303351);
    this.vRg = paramfnn;
    this.vWs = kotlin.k.cm((kotlin.g.a.a)new d(this));
    paramfnn = new i();
    paramfnn.a(this.vRg);
    ah localah = ah.aiuX;
    this.vWt = paramfnn;
    this.vWx = true;
    this.vWz = 5000L;
    this.psN = kotlin.k.cm((kotlin.g.a.a)new r(this, paramMMWebView));
    this.vWD = "__tmpl_webview_inject_data";
    paramfnn = (a.a)paramMMWebView;
    paramfnn.setValidUrlProxy((kotlin.g.a.b)new a(this));
    paramfnn.setCurrentUrlProxy((kotlin.g.a.a)new b(this));
    paramfnn = super.dhc();
    paramfnn.addAll((Collection)kotlin.a.p.listOf(new BaseWebViewController.f[] { new BaseWebViewController.f(ai.cz(UpdateData.class), (kotlin.g.a.a)new f()), new BaseWebViewController.f(ai.cz(StartPreload.class), (kotlin.g.a.a)new g(this)), new BaseWebViewController.f(ai.cz(PreloadNext.class), (kotlin.g.a.a)new h()), new BaseWebViewController.f(ai.cz(NotifyAuth.class), (kotlin.g.a.a)new i(this)), new BaseWebViewController.f(ai.cz(ForceUrl.class), (kotlin.g.a.a)new j(this)) }));
    paramMMWebView = ah.aiuX;
    this.vWE = paramfnn;
    this.vWF = s.X(this.vWD, ".__getString()");
    this.vWH = new HashSet();
    this.vWK = new MpWebViewController..ExternalSyntheticLambda2(this);
    AppMethodBeat.o(303351);
  }
  
  private static final void a(MpWebViewController paramMpWebViewController)
  {
    AppMethodBeat.i(303434);
    s.u(paramMpWebViewController, "this$0");
    Log.v(paramMpWebViewController.dgW(), "checkNotifyPageTimer isNotifyPageSuccess=" + paramMpWebViewController.vWI + ", isStopCheckNotifyPage=" + paramMpWebViewController.vWJ);
    if ((!paramMpWebViewController.vWI) && (!paramMpWebViewController.vWJ))
    {
      com.tencent.mm.plugin.webview.g.a.rG(92);
      paramMpWebViewController.vWt.vSv = true;
      paramMpWebViewController.vWt.vSw = true;
      paramMpWebViewController.dhg();
      paramMpWebViewController.atm(vWU);
      Log.e(paramMpWebViewController.dgW(), "check notifyPage timeout");
    }
    AppMethodBeat.o(303434);
  }
  
  private static final void a(MpWebViewController paramMpWebViewController, String paramString1, com.tencent.mm.plugin.webview.jsapi.p paramp, int paramInt1, int paramInt2, String paramString2, com.tencent.mm.am.c paramc)
  {
    AppMethodBeat.i(303429);
    s.u(paramMpWebViewController, "this$0");
    s.u(paramString1, "$reqUrl");
    s.u(paramp, "$msg");
    paramMpWebViewController.vWH.remove(paramString1);
    if (!(c.c.b(paramc.otC) instanceof cdf))
    {
      AppMethodBeat.o(303429);
      return;
    }
    paramString2 = c.c.b(paramc.otC);
    if (paramString2 == null)
    {
      paramMpWebViewController = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetA8KeyResp");
      AppMethodBeat.o(303429);
      throw paramMpWebViewController;
    }
    paramString2 = (cdf)paramString2;
    if (Util.isNullOrNil(paramString2.aanm))
    {
      Log.e(paramMpWebViewController.dgW(), "updatePageAuth fail fullurl is null");
      com.tencent.mm.plugin.webview.g.a.rG(82);
      paramMpWebViewController = paramMpWebViewController.getJsapi();
      if (paramMpWebViewController != null) {
        paramMpWebViewController.doCallback(paramp.WEH, s.X(paramp.function, ":fail"), null);
      }
      AppMethodBeat.o(303429);
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      try
      {
        paramc = new JsapiPermissionWrapper(w.a(paramString2.aanx));
        Object localObject = new GeneralControlWrapper(paramString2.aanp);
        paramMpWebViewController.sLD.a(paramString2.aanm, paramc, (GeneralControlWrapper)localObject);
        paramc = paramString2.aanm;
        s.s(paramc, "resp.FullURL");
        localObject = com.tencent.mm.plugin.webview.e.c.mi((List)paramString2.aamS);
        s.s(localObject, "getHttpHeaders(resp.HttpHeader)");
        paramMpWebViewController.a(paramString1, paramc, (Map)localObject);
        com.tencent.mm.plugin.webview.g.a.atP(109);
        paramString1 = (Map)new HashMap();
        paramString2 = paramString2.aanm;
        s.s(paramString2, "resp.FullURL");
        paramString1.put("fullUrl", paramString2);
        Log.i(paramMpWebViewController.dgW(), "updatePageAuth values:%s", new Object[] { paramString1 });
        com.tencent.mm.plugin.webview.g.a.rG(81);
        paramString2 = paramMpWebViewController.getJsapi();
        if (paramString2 == null) {
          break label438;
        }
        paramString2.doCallback(paramp.WEH, s.X(paramp.function, ":ok"), paramString1);
        AppMethodBeat.o(303429);
        return;
      }
      catch (Exception paramString1)
      {
        com.tencent.mm.plugin.webview.g.a.rG(82);
        paramMpWebViewController = paramMpWebViewController.getJsapi();
        if (paramMpWebViewController == null) {
          break label438;
        }
      }
      paramMpWebViewController.doCallback(paramp.WEH, s.X(paramp.function, ":fail"), null);
      AppMethodBeat.o(303429);
    }
    else
    {
      com.tencent.mm.plugin.webview.g.a.rG(82);
      paramMpWebViewController = paramMpWebViewController.getJsapi();
      if (paramMpWebViewController != null) {
        paramMpWebViewController.doCallback(paramp.WEH, s.X(paramp.function, ":fail"), null);
      }
    }
    label438:
    AppMethodBeat.o(303429);
  }
  
  private final void a(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    AppMethodBeat.i(303402);
    Log.i(dgW(), "[updatePageAuth]reqUrl:" + paramString1 + " fullUrl:" + paramString2 + " httpHeader:" + paramMap);
    paramString1 = this.sMP.getSettings().getUserAgentString();
    s.s(paramString1, "viewWV.settings.userAgentString");
    paramMap.put("User-agent", paramString1);
    getJsapi().WDX = new JSONObject(paramMap).toString();
    paramString1 = Uri.parse(paramString2).getQueryParameter("pass_ticket");
    getJsapi().WDW = paramString1;
    AppMethodBeat.o(303402);
  }
  
  private static final boolean a(MpWebViewController paramMpWebViewController, com.tencent.mm.plugin.webview.jsapi.p paramp, JsapiPermissionWrapper paramJsapiPermissionWrapper)
  {
    AppMethodBeat.i(303423);
    s.u(paramMpWebViewController, "this$0");
    if (s.p(paramp.function, "notifyPageInfo"))
    {
      Log.v(paramMpWebViewController.dgW(), s.X("handleMsg ", paramp.function));
      s.s(paramp, "msg");
      paramMpWebViewController.a(paramp);
      AppMethodBeat.o(303423);
      return true;
    }
    if (s.p(paramp.function, "updatePageAuth"))
    {
      Log.v(paramMpWebViewController.dgW(), s.X("handleMsg ", paramp.function));
      s.s(paramp, "msg");
      com.tencent.mm.plugin.webview.g.a.rG(80);
      paramJsapiPermissionWrapper = paramMpWebViewController.dgY();
      if (paramMpWebViewController.vWH.contains(paramJsapiPermissionWrapper))
      {
        Log.e(paramMpWebViewController.dgW(), "updatePageAuth fail, url:%s already run");
        paramMpWebViewController = paramMpWebViewController.getJsapi();
        if (paramMpWebViewController != null) {
          paramMpWebViewController.doCallback(paramp.WEH, s.X(paramp.function, ":fail updating"), null);
        }
        com.tencent.mm.plugin.webview.g.a.rG(82);
      }
      for (;;)
      {
        AppMethodBeat.o(303423);
        return true;
        paramMpWebViewController.vWH.add(paramJsapiPermissionWrapper);
        paramMpWebViewController.irI().a(paramJsapiPermissionWrapper, 8, new MpWebViewController..ExternalSyntheticLambda0(paramMpWebViewController, paramJsapiPermissionWrapper, paramp));
      }
    }
    AppMethodBeat.o(303423);
    return false;
  }
  
  /* Error */
  private final boolean a(com.tencent.mm.plugin.webview.jsapi.p paramp)
  {
    // Byte code:
    //   0: ldc_w 845
    //   3: invokestatic 267	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 772	org/json/JSONObject
    //   9: dup
    //   10: invokespecial 846	org/json/JSONObject:<init>	()V
    //   13: astore 10
    //   15: aload 10
    //   17: ldc_w 848
    //   20: aload_1
    //   21: getfield 852	com/tencent/mm/plugin/webview/jsapi/p:params	Ljava/util/Map;
    //   24: ldc_w 848
    //   27: invokeinterface 856 2 0
    //   32: checkcast 858	java/lang/String
    //   35: invokevirtual 861	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   38: pop
    //   39: aload 10
    //   41: ldc_w 863
    //   44: aload_1
    //   45: getfield 852	com/tencent/mm/plugin/webview/jsapi/p:params	Ljava/util/Map;
    //   48: ldc_w 863
    //   51: invokeinterface 856 2 0
    //   56: checkcast 858	java/lang/String
    //   59: invokevirtual 861	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   62: pop
    //   63: aload 10
    //   65: invokevirtual 776	org/json/JSONObject:toString	()Ljava/lang/String;
    //   68: astore 10
    //   70: aload 10
    //   72: ldc_w 865
    //   75: invokestatic 582	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   78: aload_0
    //   79: invokevirtual 446	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:dgW	()Ljava/lang/String;
    //   82: ldc_w 867
    //   85: aload 10
    //   87: invokestatic 428	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   90: invokestatic 513	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   93: new 772	org/json/JSONObject
    //   96: dup
    //   97: aload 10
    //   99: invokespecial 868	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   102: astore 10
    //   104: new 772	org/json/JSONObject
    //   107: dup
    //   108: aload 10
    //   110: ldc_w 848
    //   113: invokevirtual 871	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   116: invokespecial 868	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   119: astore 11
    //   121: aload 11
    //   123: ldc_w 873
    //   126: invokevirtual 877	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   129: lstore_2
    //   130: aload 11
    //   132: ldc_w 879
    //   135: invokevirtual 877	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   138: lstore 4
    //   140: aload 11
    //   142: ldc_w 881
    //   145: invokevirtual 877	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   148: lstore 6
    //   150: aload 11
    //   152: ldc_w 883
    //   155: invokevirtual 877	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   158: lstore 8
    //   160: aload_0
    //   161: getfield 887	com/tencent/mm/plugin/webview/core/BaseWebViewController:WwL	Lcom/tencent/mm/plugin/webview/k/r;
    //   164: ldc_w 881
    //   167: lload 6
    //   169: invokevirtual 893	com/tencent/mm/plugin/webview/k/r:cf	(Ljava/lang/String;J)V
    //   172: aload_0
    //   173: getfield 887	com/tencent/mm/plugin/webview/core/BaseWebViewController:WwL	Lcom/tencent/mm/plugin/webview/k/r;
    //   176: ldc_w 883
    //   179: lload 8
    //   181: invokevirtual 893	com/tencent/mm/plugin/webview/k/r:cf	(Ljava/lang/String;J)V
    //   184: aload_0
    //   185: getfield 356	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:vWt	Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/i;
    //   188: lload_2
    //   189: putfield 896	com/tencent/mm/plugin/brandservice/ui/timeline/preload/i:vRr	J
    //   192: aload_0
    //   193: getfield 356	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:vWt	Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/i;
    //   196: lload 4
    //   198: putfield 899	com/tencent/mm/plugin/brandservice/ui/timeline/preload/i:vRs	J
    //   201: aload_0
    //   202: getfield 356	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:vWt	Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/i;
    //   205: lload 6
    //   207: putfield 902	com/tencent/mm/plugin/brandservice/ui/timeline/preload/i:vRo	J
    //   210: aload_0
    //   211: getfield 356	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:vWt	Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/i;
    //   214: lload 8
    //   216: putfield 905	com/tencent/mm/plugin/brandservice/ui/timeline/preload/i:vRq	J
    //   219: aload 10
    //   221: ldc_w 863
    //   224: ldc_w 907
    //   227: invokevirtual 910	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   230: ldc_w 912
    //   233: invokestatic 808	kotlin/g/b/s:p	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   236: ifeq +123 -> 359
    //   239: aload_0
    //   240: iconst_1
    //   241: putfield 455	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:vWI	Z
    //   244: aload_0
    //   245: getfield 356	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:vWt	Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/i;
    //   248: iconst_1
    //   249: putfield 915	com/tencent/mm/plugin/brandservice/ui/timeline/preload/i:vSg	Z
    //   252: aload_0
    //   253: getfield 356	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:vWt	Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/i;
    //   256: new 59	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$o
    //   259: dup
    //   260: aload_0
    //   261: invokespecial 916	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$o:<init>	(Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController;)V
    //   264: checkcast 918	kotlin/g/a/q
    //   267: invokevirtual 922	com/tencent/mm/plugin/brandservice/ui/timeline/preload/i:h	(Lkotlin/g/a/q;)V
    //   270: aload_0
    //   271: getfield 329	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:vRg	Lcom/tencent/mm/protocal/protobuf/fnn;
    //   274: getfield 518	com/tencent/mm/protocal/protobuf/fnn:reportId	I
    //   277: sipush 131
    //   280: invokestatic 524	com/tencent/mm/plugin/webview/g/a:ik	(II)V
    //   283: bipush 108
    //   285: invokestatic 720	com/tencent/mm/plugin/webview/g/a:atP	(I)V
    //   288: aload_0
    //   289: getfield 356	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:vWt	Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/i;
    //   292: invokestatic 549	com/tencent/mm/sdk/platformtools/MMSlotKt:now	()J
    //   295: putfield 925	com/tencent/mm/plugin/brandservice/ui/timeline/preload/i:vRG	J
    //   298: aload_0
    //   299: invokespecial 489	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:dhg	()V
    //   302: aload_0
    //   303: invokespecial 928	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:dhf	()V
    //   306: aload_0
    //   307: invokevirtual 651	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:getJsapi	()Lcom/tencent/mm/plugin/webview/jsapi/j;
    //   310: aload_1
    //   311: getfield 656	com/tencent/mm/plugin/webview/jsapi/p:WEH	Ljava/lang/String;
    //   314: ldc_w 930
    //   317: aconst_null
    //   318: invokevirtual 667	com/tencent/mm/plugin/webview/jsapi/j:doCallback	(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V
    //   321: bipush 90
    //   323: invokestatic 480	com/tencent/mm/plugin/webview/g/a:rG	(I)V
    //   326: getstatic 936	kotlinx/coroutines/bu:ajwo	Lkotlinx/coroutines/bu;
    //   329: checkcast 938	kotlinx/coroutines/aq
    //   332: aconst_null
    //   333: aconst_null
    //   334: new 57	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$n
    //   337: dup
    //   338: aload_0
    //   339: aconst_null
    //   340: invokespecial 941	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$n:<init>	(Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController;Lkotlin/d/d;)V
    //   343: checkcast 943	kotlin/g/a/m
    //   346: iconst_3
    //   347: invokestatic 948	kotlinx/coroutines/j:a	(Lkotlinx/coroutines/aq;Lkotlin/d/f;Lkotlinx/coroutines/as;Lkotlin/g/a/m;I)Lkotlinx/coroutines/cb;
    //   350: pop
    //   351: ldc_w 845
    //   354: invokestatic 272	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   357: iconst_1
    //   358: ireturn
    //   359: aload_0
    //   360: getfield 356	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:vWt	Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/i;
    //   363: iconst_1
    //   364: putfield 483	com/tencent/mm/plugin/brandservice/ui/timeline/preload/i:vSv	Z
    //   367: aload_0
    //   368: getstatic 312	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:vWU	I
    //   371: invokevirtual 492	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:atm	(I)V
    //   374: aload_0
    //   375: invokevirtual 446	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:dgW	()Ljava/lang/String;
    //   378: ldc_w 950
    //   381: invokestatic 513	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   384: goto -96 -> 288
    //   387: astore 10
    //   389: aload_0
    //   390: invokevirtual 446	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:dgW	()Ljava/lang/String;
    //   393: aload 10
    //   395: checkcast 952	java/lang/Throwable
    //   398: ldc_w 804
    //   401: iconst_0
    //   402: anewarray 734	java/lang/Object
    //   405: invokestatic 956	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   408: aload_0
    //   409: getfield 356	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:vWt	Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/i;
    //   412: iconst_1
    //   413: putfield 483	com/tencent/mm/plugin/brandservice/ui/timeline/preload/i:vSv	Z
    //   416: aload_0
    //   417: getstatic 312	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:vWU	I
    //   420: invokevirtual 492	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:atm	(I)V
    //   423: goto -135 -> 288
    //   426: astore 10
    //   428: aload_0
    //   429: invokevirtual 446	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:dgW	()Ljava/lang/String;
    //   432: aload 10
    //   434: checkcast 952	java/lang/Throwable
    //   437: ldc_w 957
    //   440: iconst_0
    //   441: anewarray 734	java/lang/Object
    //   444: invokestatic 956	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   447: aload_0
    //   448: invokevirtual 651	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:getJsapi	()Lcom/tencent/mm/plugin/webview/jsapi/j;
    //   451: aload_1
    //   452: getfield 656	com/tencent/mm/plugin/webview/jsapi/p:WEH	Ljava/lang/String;
    //   455: ldc_w 959
    //   458: aconst_null
    //   459: invokevirtual 667	com/tencent/mm/plugin/webview/jsapi/j:doCallback	(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V
    //   462: bipush 91
    //   464: invokestatic 480	com/tencent/mm/plugin/webview/g/a:rG	(I)V
    //   467: ldc_w 845
    //   470: invokestatic 272	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   473: iconst_0
    //   474: ireturn
    //   475: astore 10
    //   477: aload_0
    //   478: invokevirtual 446	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:dgW	()Ljava/lang/String;
    //   481: aload 10
    //   483: checkcast 952	java/lang/Throwable
    //   486: ldc_w 957
    //   489: iconst_0
    //   490: anewarray 734	java/lang/Object
    //   493: invokestatic 956	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   496: goto -49 -> 447
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	499	0	this	MpWebViewController
    //   0	499	1	paramp	com.tencent.mm.plugin.webview.jsapi.p
    //   129	60	2	l1	long
    //   138	59	4	l2	long
    //   148	58	6	l3	long
    //   158	57	8	l4	long
    //   13	207	10	localObject	Object
    //   387	7	10	localJSONException1	org.json.JSONException
    //   426	7	10	localJSONException2	org.json.JSONException
    //   475	7	10	localRemoteException	android.os.RemoteException
    //   119	32	11	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   93	288	387	org/json/JSONException
    //   359	384	387	org/json/JSONException
    //   6	93	426	org/json/JSONException
    //   288	357	426	org/json/JSONException
    //   389	423	426	org/json/JSONException
    //   6	93	475	android/os/RemoteException
    //   93	288	475	android/os/RemoteException
    //   288	357	475	android/os/RemoteException
    //   359	384	475	android/os/RemoteException
    //   389	423	475	android/os/RemoteException
  }
  
  private final void ajN(String paramString)
  {
    AppMethodBeat.i(303392);
    this.Www = paramString;
    biZ(paramString);
    bja(paramString);
    biX(paramString);
    AppMethodBeat.o(303392);
  }
  
  private void ajO(String paramString)
  {
    AppMethodBeat.i(303406);
    s.u(paramString, "forceUrl");
    dhf();
    j.a locala = com.tencent.mm.plugin.brandservice.ui.timeline.preload.j.vSB;
    if (j.a.dfs())
    {
      AppMethodBeat.o(303406);
      return;
    }
    irY();
    this.WwQ = true;
    m(ajP(paramString), true, 8);
    AppMethodBeat.o(303406);
  }
  
  private static String ajP(String paramString)
  {
    AppMethodBeat.i(303418);
    paramString = UrlExKt.appendUrlParam(UrlExKt.clearUrlParam$default(UrlExKt.clearUrlParam$default(UrlExKt.clearUrlParam$default(paramString, "fasttmpl_flag", false, 2, null), "fasttmpl_type", false, 2, null), "fasttmpl_fullversion", false, 2, null), "forceh5", "1");
    AppMethodBeat.o(303418);
    return paramString;
  }
  
  private egp dgX()
  {
    AppMethodBeat.i(303358);
    egp localegp = (egp)this.psN.getValue();
    AppMethodBeat.o(303358);
    return localegp;
  }
  
  private final void dhf()
  {
    AppMethodBeat.i(303378);
    Log.d(dgW(), "stopCheckNotifyPage");
    getHandler().removeCallbacks(this.vWK);
    this.vWJ = true;
    AppMethodBeat.o(303378);
  }
  
  private final void dhg()
  {
    AppMethodBeat.i(303389);
    Log.v(dgW(), "terry trace updateKV");
    this.vWt.vRB = this.WwL.cg("onInjectStart", 0L);
    this.vWt.vRC = this.WwL.cg("onInjectEnd", 0L);
    this.vWt.vRE = this.WwL.cg("onTmplLoadStart", 0L);
    this.vWt.vRF = this.WwL.cg("onTmplLoadEnd", 0L);
    this.vWt.vRz = this.WwL.cg("onCreateStart", 0L);
    this.vWt.vRA = this.WwL.cg("onCreateEnd", 0L);
    this.vWt.vRX = this.vWG;
    this.vWt.vRD = this.WwL.cg("onWebInjectEnd", 0L);
    i locali = this.vWt;
    String str = this.sMP.getRandomStr();
    s.s(str, "viewWV.randomStr");
    locali.setKey(str);
    this.vWt.vRY = atn(vWM);
    AppMethodBeat.o(303389);
  }
  
  private void w(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(303396);
    s.u(paramString, "contentId");
    Log.v(dgW(), s.X("[updateData] ", dgY()));
    com.tencent.mm.plugin.brandservice.ui.timeline.preload.m.ajw(dgY());
    ajN(dgY());
    this.vWA = paramString;
    this.vWu = paramLong1;
    this.vWw = paramLong2;
    atm(vWO);
    AppMethodBeat.o(303396);
  }
  
  public final void a(int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2)
  {
    AppMethodBeat.i(303566);
    s.u(paramString1, "reqUrl");
    s.u(paramString2, "errMsg");
    super.a(paramInt1, paramString1, paramInt2, paramInt3, paramString2);
    if (paramInt1 == 0)
    {
      this.sMq = paramString1;
      atm(vWS);
    }
    AppMethodBeat.o(303566);
  }
  
  public final void a(int paramInt, String paramString1, String paramString2, cdf paramcdf)
  {
    AppMethodBeat.i(303563);
    s.u(paramString1, "reqUrl");
    s.u(paramString2, "fullUrl");
    s.u(paramcdf, "response");
    if (paramInt == 0) {
      ajN(paramString2);
    }
    super.a(paramInt, paramString1, paramString2, paramcdf);
    if (paramInt == 0)
    {
      this.sMq = paramString2;
      paramcdf = com.tencent.mm.plugin.webview.e.c.mi((List)paramcdf.aamS);
      s.s(paramcdf, "getHttpHeaders(response.HttpHeader)");
      com.tencent.mm.plugin.webview.g.a.ik(this.vRg.reportId, 117);
      this.vWt.vRy = MMSlotKt.now();
      this.vWt.vSf = true;
      dhg();
      this.vWt.h((kotlin.g.a.q)new p(this));
      a(paramString1, paramString2, paramcdf);
      atm(vWR);
    }
    AppMethodBeat.o(303563);
  }
  
  public final boolean aY(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(303560);
    s.u(paramString, "url");
    if ((!s.p(paramString, this.vRg.WET)) && (super.aY(paramString, paramBoolean)))
    {
      AppMethodBeat.o(303560);
      return true;
    }
    AppMethodBeat.o(303560);
    return false;
  }
  
  public final boolean ajK(String paramString)
  {
    AppMethodBeat.i(303548);
    s.u(paramString, "url");
    if ((super.ajL(paramString)) && (!s.p(paramString, this.vRg.WET)))
    {
      AppMethodBeat.o(303548);
      return true;
    }
    AppMethodBeat.o(303548);
    return false;
  }
  
  public final boolean ajL(String paramString)
  {
    AppMethodBeat.i(303551);
    s.u(paramString, "url");
    if ((super.ajL(paramString)) && (!s.p(paramString, this.vRg.WET)))
    {
      AppMethodBeat.o(303551);
      return true;
    }
    AppMethodBeat.o(303551);
    return false;
  }
  
  public final boolean ajM(String paramString)
  {
    AppMethodBeat.i(303559);
    if (!s.p(paramString, this.vRg.WET)) {
      if ((paramString == null) || (n.U(paramString, "file://", false) != true)) {
        break label50;
      }
    }
    label50:
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(303559);
      return true;
    }
    AppMethodBeat.o(303559);
    return false;
  }
  
  public final void b(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(303561);
    super.b(paramWebView, paramString);
    if (s.p(paramString, this.vRg.WET))
    {
      if ((atn(vWM)) || (atn(vWL)))
      {
        AppMethodBeat.o(303561);
        return;
      }
      Log.i(dgW(), "checkInject start");
      com.tencent.mm.plugin.webview.g.a.ik(this.vRg.reportId, 113);
      v("JSON.stringify(window.__appmsg_skeleton_success__)", (kotlin.g.a.b)new k(this));
      int i = com.tencent.mm.cd.a.ms(this.sMP.getContext());
      float f = com.tencent.mm.cd.a.getDensity(this.sMP.getContext());
      Log.i(dgW(), "adjustInnerWidth() screenWidth:" + i + ", density:" + f);
      if ((i > 0) && (f > 0.0F))
      {
        i = (int)(i / f);
        Log.i(dgW(), s.X("adjustInnerWidth() innerWidth:", Integer.valueOf(i)));
        ((BaseWebViewController)this).v(s.X("window.innerWidth = ", Integer.valueOf(i)), null);
      }
      Log.i(dgW(), "[onPageReady]");
    }
    AppMethodBeat.o(303561);
  }
  
  public final void cxS()
  {
    AppMethodBeat.i(303546);
    a((com.tencent.mm.plugin.webview.core.m)new e(this.vRg, this.sMP));
    super.cxS();
    this.sMP.addJavascriptInterface(new l(this), this.vWD);
    getJsapi().itv();
    getJsapi().WDL = new MpWebViewController..ExternalSyntheticLambda1(this);
    String str = this.vRg.WET;
    Log.i(dgW(), "WebView-Trace loadTmpl getResourceResponse, requrl:%s, url:%s", new Object[] { str, this.vRg.abNy });
    Object localObject = this.vRg.abNy;
    s.s(localObject, "tmplParams.initFilePath");
    localObject = new m((String)localObject);
    Log.v(dgW(), s.X("response path:", Util.nullAs(((m)localObject).path, "null")));
    if (c.g((WebView)this.sMP, ((m)localObject).path) != null)
    {
      Log.i(dgW(), "return intercepted success");
      atm(this.WwX);
      this.sMP.loadUrl(str);
      atm(this.WwW);
      AppMethodBeat.o(303546);
      return;
    }
    Log.e(dgW(), "return intercepted null");
    com.tencent.mm.plugin.webview.g.a.ik(this.vRg.reportId, 126);
    if (((m)localObject).qon) {
      com.tencent.mm.plugin.webview.g.a.ik(this.vRg.reportId, 233);
    }
    AppMethodBeat.o(303546);
  }
  
  final String dgW()
  {
    AppMethodBeat.i(303527);
    String str = (String)this.vWs.getValue();
    AppMethodBeat.o(303527);
    return str;
  }
  
  public final String dgY()
  {
    AppMethodBeat.i(303530);
    String str = n.bW(BaseWebViewController.c.bK(getIntent()), "http://", "https://");
    AppMethodBeat.o(303530);
    return str;
  }
  
  public final boolean dgZ()
  {
    AppMethodBeat.i(303534);
    if ((atn(vWP)) || (atn(vWQ)))
    {
      AppMethodBeat.o(303534);
      return true;
    }
    AppMethodBeat.o(303534);
    return false;
  }
  
  public final boolean dha()
  {
    AppMethodBeat.i(303538);
    if ((atn(this.WwW)) && (atn(vWM)))
    {
      AppMethodBeat.o(303538);
      return true;
    }
    AppMethodBeat.o(303538);
    return false;
  }
  
  public final boolean dhb()
  {
    AppMethodBeat.i(303541);
    if ((irQ()) && (atn(vWR)))
    {
      AppMethodBeat.o(303541);
      return true;
    }
    AppMethodBeat.o(303541);
    return false;
  }
  
  public final List<BaseWebViewController.f> dhc()
  {
    return this.vWE;
  }
  
  public final void dhd()
  {
    int j = 1;
    AppMethodBeat.i(303556);
    Log.i(dgW(), "onStartLoad");
    Object localObject1 = getIntent();
    s.u(localObject1, "intent");
    Log.v(dgW(), "processData");
    setIntent((Intent)localObject1);
    this.vWv = MMSlotKt.now();
    this.vWx = ((Intent)localObject1).getBooleanExtra(f.s.adwO, true);
    this.vWu = ((Intent)localObject1).getLongExtra(f.s.adwP, 0L);
    Object localObject2 = ((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.baB().bad()).mFH;
    String str = ((Intent)localObject1).getStringExtra(f.s.adwR);
    if ((((Intent)localObject1).getStringExtra("rawUrl") == null) || (str == null))
    {
      Log.e(dgW(), s.X("rawUrl is null, ", f.ai((Intent)localObject1)));
      com.tencent.mm.plugin.webview.g.a.atP(151);
      com.tencent.mm.plugin.report.service.h.OAn.b(17260, new Object[] { Integer.valueOf(1), f.ai((Intent)localObject1) });
      i = 0;
      if (i == 0)
      {
        onFinish();
        AppMethodBeat.o(303556);
      }
    }
    else
    {
      i locali = this.vWt;
      if (((g.a)localObject2).mFR < this.vWu)
      {
        bool = true;
        label211:
        locali.vSd = bool;
        if (!this.vWt.vSd) {
          break label517;
        }
        i = 104;
        label230:
        com.tencent.mm.plugin.webview.g.a.atP(i);
        switch (com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.a(((Intent)localObject1).getIntExtra(f.s.adwV, -1), this.vWu, Process.myPid(), ((g.a)localObject2).mFJ))
        {
        }
      }
      for (;;)
      {
        this.vWt.qon = dgX().ablS;
        this.vWt.vSa = dgX().ablT;
        this.vWt.vSb = com.tencent.mm.plugin.webview.jsapi.m.c((WebView)this.sMP);
        this.vWt.vSc = dgX().vSc;
        this.vWt.vRM = ((g.a)localObject2).mFJ;
        this.vWt.vRN = ((g.a)localObject2).mFK;
        this.vWt.vRO = ((g.a)localObject2).mFL;
        this.vWt.vRP = ((g.a)localObject2).mFM;
        this.vWt.vRQ = ((g.a)localObject2).mFN;
        this.vWt.vRR = ((g.a)localObject2).mFO;
        this.vWt.vRS = ((g.a)localObject2).mFP;
        this.vWt.vRT = ((g.a)localObject2).mFQ;
        this.vWt.vRU = ((g.a)localObject2).mFR;
        this.vWt.vRn = this.vWu;
        this.vWt.vRt = this.vWv;
        this.vWt.vAZ = dgX().vAZ;
        com.tencent.mm.plugin.brandservice.ui.timeline.preload.m.vSK.a(this, str, dgX(), (kotlin.g.a.q)new q(this));
        i = j;
        break;
        bool = false;
        break label211;
        label517:
        i = 103;
        break label230;
        this.vWt.vSe = 1;
        this.vWu = ((g.a)localObject2).mFJ;
        continue;
        this.vWt.vSe = 2;
        this.vWu = -1L;
      }
    }
    this.vWt.a(this.vRg);
    localObject1 = this.vWt;
    localObject2 = dgY();
    s.u(localObject2, "<set-?>");
    ((i)localObject1).url = ((String)localObject2);
    boolean bool = atn(vWM);
    this.vWt.vRW = bool;
    this.vWt.vRV = this.vWy;
    this.vWt.vSt = this.sMP.getWebCoreType().name();
    if (bool) {}
    for (int i = 106;; i = 105)
    {
      com.tencent.mm.plugin.webview.g.a.atP(i);
      BaseWebViewController.a((BaseWebViewController)this, dgY());
      if (!this.vWI)
      {
        dhf();
        Log.i(dgW(), "check notifyPage");
        this.vWJ = false;
        getHandler().postUIDelayed(this.vWK, this.vWz);
      }
      AppMethodBeat.o(303556);
      return;
    }
  }
  
  public final boolean dhe()
  {
    return false;
  }
  
  public final boolean dhh()
  {
    AppMethodBeat.i(303564);
    boolean bool = atn(this.WwW);
    AppMethodBeat.o(303564);
    return bool;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$ForceUrl;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$ControllerAction;", "()V", "verify", "", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
  protected static final class ForceUrl
    extends BaseWebViewController.ControllerAction
  {
    public final boolean verify()
    {
      AppMethodBeat.i(303403);
      MpWebViewController localMpWebViewController = (MpWebViewController)getController();
      MpWebViewController.c localc = MpWebViewController.vWr;
      if (((waitFor(MpWebViewController.dhq())) || (waitFor(MpWebViewController.dhn())) || (waitFor(MpWebViewController.dho()))) && (waitFor(MpWebViewController.c(localMpWebViewController))))
      {
        AppMethodBeat.o(303403);
        return true;
      }
      AppMethodBeat.o(303403);
      return false;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$NotifyAuth;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$ControllerAction;", "()V", "verify", "", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
  protected static final class NotifyAuth
    extends BaseWebViewController.ControllerAction
  {
    public final boolean verify()
    {
      AppMethodBeat.i(303381);
      MpWebViewController localMpWebViewController = (MpWebViewController)getController();
      if ((waitFor(MpWebViewController.dhi())) && (((waitFor(MpWebViewController.b(localMpWebViewController))) && (waitFor(MpWebViewController.dhk()))) || (waitFor(MpWebViewController.dhl()))))
      {
        AppMethodBeat.o(303381);
        return true;
      }
      AppMethodBeat.o(303381);
      return false;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$PreloadNext;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$ControllerAction;", "()V", "verify", "", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
  protected static final class PreloadNext
    extends BaseWebViewController.ControllerAction
  {
    public final boolean verify()
    {
      AppMethodBeat.i(303323);
      getController();
      boolean bool = waitFor(MpWebViewController.dhm());
      AppMethodBeat.o(303323);
      return bool;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$StartPreload;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$ControllerAction;", "()V", "verify", "", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
  protected static final class StartPreload
    extends BaseWebViewController.ControllerAction
  {
    public final boolean verify()
    {
      AppMethodBeat.i(303310);
      boolean bool = waitFor(MpWebViewController.c((MpWebViewController)getController()));
      AppMethodBeat.o(303310);
      return bool;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$UpdateData;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$ControllerAction;", "()V", "verify", "", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
  protected static final class UpdateData
    extends BaseWebViewController.ControllerAction
  {
    public final boolean verify()
    {
      AppMethodBeat.i(303274);
      getController();
      if ((waitFor(MpWebViewController.dhi())) && (waitFor(MpWebViewController.dhj())))
      {
        AppMethodBeat.o(303274);
        return true;
      }
      AppMethodBeat.o(303274);
      return false;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends kotlin.g.b.u
    implements kotlin.g.a.b<String, Boolean>
  {
    a(MpWebViewController paramMpWebViewController)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.g.b.u
    implements kotlin.g.a.a<String>
  {
    b(MpWebViewController paramMpWebViewController)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$Companion;", "", "()V", "MP_AUTH_ERR", "", "MP_AUTH_NOTIFIED", "MP_AUTH_SUCC", "MP_DATA_INJECT_ERR", "MP_DATA_INJECT_SUCC", "MP_DATA_READY", "MP_NOTIFY_ERR", "MP_PRELOAD_NEXT", "MP_TMPL_CHECKING", "MP_TMPL_ERR", "getMP_TMPL_ERR$plugin_brandservice_release", "()I", "MP_TMPL_READY", "readFileWebResp", "Lcom/tencent/xweb/WebResourceResponse;", "webview", "Lcom/tencent/xweb/WebView;", "fileName", "", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
  {
    static WebResourceResponse g(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(303334);
      if (!y.ZC(paramString))
      {
        Log.e("MicroMsg.WebViewController", s.X("tmpl file not found:", paramString));
        AppMethodBeat.o(303334);
        return null;
      }
      Object localObject1 = MimeTypeUtil.getMimeTypeByFilePath(paramString);
      Object localObject2;
      if ((n.rs(paramString, ".js")) && (com.tencent.mm.plugin.webview.jsapi.m.c(paramWebView)))
      {
        paramWebView = new an(3, 256, paramWebView);
        paramWebView.qU(paramString, "path");
        paramWebView = paramWebView.toString();
        localObject2 = StandardCharsets.UTF_8;
        s.s(localObject2, "UTF_8");
        if (paramWebView == null)
        {
          paramWebView = new NullPointerException("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(303334);
          throw paramWebView;
        }
        localObject2 = paramWebView.getBytes((Charset)localObject2);
        s.s(localObject2, "(this as java.lang.String).getBytes(charset)");
        localObject1 = new WebResourceResponse((String)localObject1, "UTF-8", (InputStream)new ByteArrayInputStream((byte[])localObject2));
      }
      for (;;)
      {
        localObject2 = new HashMap();
        String str = Integer.toHexString(paramString.hashCode() & 0xFFFFFFFF);
        s.s(str, "toHexString(fileName.hashCode() and (-1).ushr(32))");
        str = str.toLowerCase();
        s.s(str, "(this as java.lang.String).toLowerCase()");
        ((Map)localObject2).put("Cache-Control", "max-age=31536000");
        ((Map)localObject2).put("ETag", str);
        if (paramWebView != null) {
          ((Map)localObject2).put("RunLocalJS", paramWebView);
        }
        ((WebResourceResponse)localObject1).mResponseHeaders = ((Map)localObject2);
        Log.i("MicroMsg.WebViewController", "readFileWebResp:%s\nETag:%s", new Object[] { paramString, str });
        AppMethodBeat.o(303334);
        return localObject1;
        try
        {
          paramWebView = (InputStream)new FileInputStream(paramString);
          if (paramWebView == null)
          {
            Log.e("MicroMsg.WebViewController", "stream is null, err");
            AppMethodBeat.o(303334);
            return null;
          }
        }
        catch (FileNotFoundException paramWebView)
        {
          for (;;)
          {
            Log.printErrStackTrace("MicroMsg.WebViewController", (Throwable)paramWebView, "", new Object[0]);
            paramWebView = null;
          }
          localObject1 = new WebResourceResponse((String)localObject1, "UTF-8", paramWebView);
          paramWebView = null;
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends kotlin.g.b.u
    implements kotlin.g.a.a<String>
  {
    d(MpWebViewController paramMpWebViewController)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$MpWebViewInterceptor;", "Lcom/tencent/mm/plugin/webview/core/WebViewInterceptor;", "tmplParams", "Lcom/tencent/mm/protocal/protobuf/TmplParams;", "viewWV", "Lcom/tencent/mm/ui/widget/MMWebView;", "(Lcom/tencent/mm/protocal/protobuf/TmplParams;Lcom/tencent/mm/ui/widget/MMWebView;)V", "getTmplParams", "()Lcom/tencent/mm/protocal/protobuf/TmplParams;", "getViewWV", "()Lcom/tencent/mm/ui/widget/MMWebView;", "intercept", "Lcom/tencent/xweb/WebResourceResponse;", "webview", "Lcom/tencent/xweb/WebView;", "request", "Lcom/tencent/xweb/WebResourceRequest;", "overrideReload", "", "url", "", "overrideUrl", "Lcom/tencent/mm/plugin/webview/core/WebViewInterceptor$OverrideUrlResult;", "webView", "overrideUrlRedirect", "reason", "", "forceRedirect", "reqUrl", "fullUrl", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class e
    extends com.tencent.mm.plugin.webview.core.m
  {
    private final MMWebView sMP;
    private final fnn vRg;
    
    public e(fnn paramfnn, MMWebView paramMMWebView)
    {
      AppMethodBeat.i(303328);
      this.vRg = paramfnn;
      this.sMP = paramMMWebView;
      AppMethodBeat.o(303328);
    }
    
    public final boolean a(int paramInt, boolean paramBoolean, String paramString1, String paramString2)
    {
      AppMethodBeat.i(303335);
      s.u(paramString1, "reqUrl");
      s.u(paramString2, "fullUrl");
      if ((paramInt == 0) && (UrlExKt.isMpUrl(paramString2)) && (s.p(com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.ajk(paramString1), com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.ajk(paramString2))))
      {
        AppMethodBeat.o(303335);
        return true;
      }
      paramBoolean = super.a(paramInt, paramBoolean, paramString1, paramString2);
      AppMethodBeat.o(303335);
      return paramBoolean;
    }
    
    public final boolean ajR(String paramString)
    {
      AppMethodBeat.i(303355);
      s.u(paramString, "url");
      Object localObject1 = getController();
      if ((localObject1 instanceof MpWebViewController)) {
        localObject1 = (MpWebViewController)localObject1;
      }
      while (localObject1 != null)
      {
        Object localObject2;
        if ((!MpWebViewController.a((MpWebViewController)localObject1, MpWebViewController.c((MpWebViewController)localObject1))) || (!s.p(com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.ajk(paramString), com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.ajk(((MpWebViewController)localObject1).dgY()))))
        {
          if (MpWebViewController.a((MpWebViewController)localObject1, MpWebViewController.dhk()))
          {
            String str2 = com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.ajk(paramString);
            String str1 = MpWebViewController.d((MpWebViewController)localObject1);
            localObject2 = str1;
            if (str1 == null)
            {
              s.bIx("fullUrl");
              localObject2 = null;
            }
            if (!s.p(str2, com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.ajk((String)localObject2))) {
              break;
            }
          }
        }
        else if (getController().irY())
        {
          localObject2 = ((Iterable)MpWebViewController.e((MpWebViewController)localObject1)).iterator();
          for (;;)
          {
            if (((Iterator)localObject2).hasNext())
            {
              com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new b((l)((Iterator)localObject2).next()));
              continue;
              localObject1 = null;
              break;
            }
          }
          ((BaseWebViewController)localObject1).WwQ = true;
          ((MpWebViewController)localObject1).m(MpWebViewController.ajQ(paramString), true, 8);
          AppMethodBeat.o(303355);
          return true;
        }
      }
      AppMethodBeat.o(303355);
      return false;
    }
    
    public final WebResourceResponse b(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
    {
      AppMethodBeat.i(303346);
      s.u(paramWebView, "webview");
      s.u(paramWebResourceRequest, "request");
      paramWebView = paramWebResourceRequest.getUrl().toString();
      s.s(paramWebView, "request.url.toString()");
      if ((!s.p(paramWebView, this.vRg.WET)) && (!n.U(paramWebView, com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.b.getPrefix(), false)))
      {
        Log.d("MicroMsg.WebViewController", "WebView-Trace intercept return");
        AppMethodBeat.o(303346);
        return null;
      }
      Log.i("MicroMsg.WebViewController", "getResourceResponse, requrl:%s, url:%s", new Object[] { paramWebView, this.vRg.abNy });
      if (paramWebResourceRequest.isForMainFrame())
      {
        paramWebView = this.vRg.abNy;
        s.s(paramWebView, "tmplParams.initFilePath");
        paramWebView = new a(paramWebView, false);
      }
      while (paramWebView != null)
      {
        Log.v("MicroMsg.WebViewController", s.X("response path: ", paramWebView.path));
        paramWebResourceRequest = MpWebViewController.vWr;
        paramWebResourceRequest = MpWebViewController.c.g((WebView)this.sMP, paramWebView.path);
        if (paramWebResourceRequest != null)
        {
          Log.i("MicroMsg.WebViewController", "return intercepted success");
          AppMethodBeat.o(303346);
          return paramWebResourceRequest;
          int i;
          if (n.U(paramWebView, com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.b.dgP(), false))
          {
            i = this.vRg.vST;
            paramWebResourceRequest = this.vRg.mXG;
            s.s(paramWebResourceRequest, "tmplParams.uid");
            paramWebView = (CharSequence)paramWebView;
            paramWebView = new a(com.tencent.mm.plugin.brandservice.ui.timeline.preload.p.x(i, paramWebResourceRequest, new kotlin.n.k(com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.b.dgP()).f(paramWebView, "")), true);
          }
          else if (n.U(paramWebView, com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.b.getPrefix(), false))
          {
            i = this.vRg.vST;
            paramWebResourceRequest = this.vRg.mXG;
            s.s(paramWebResourceRequest, "tmplParams.uid");
            paramWebView = (CharSequence)paramWebView;
            paramWebView = new a(com.tencent.mm.plugin.brandservice.ui.timeline.preload.p.x(i, paramWebResourceRequest, new kotlin.n.k(com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.b.getPrefix()).f(paramWebView, "")), true);
          }
          else
          {
            paramWebView = null;
          }
        }
        else
        {
          Log.e("MicroMsg.WebViewController", "return intercepted null");
          com.tencent.mm.plugin.webview.g.a.ik(this.vRg.reportId, 126);
          if (paramWebView.qon) {
            com.tencent.mm.plugin.webview.g.a.ik(this.vRg.reportId, 233);
          }
        }
      }
      AppMethodBeat.o(303346);
      return null;
    }
    
    public final m.a c(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
    {
      AppMethodBeat.i(303364);
      s.u(paramWebView, "webView");
      s.u(paramWebResourceRequest, "request");
      Object localObject = getController();
      if ((localObject instanceof MpWebViewController)) {}
      for (localObject = (MpWebViewController)localObject;; localObject = null)
      {
        if ((localObject != null) && (paramWebResourceRequest.isForMainFrame()) && (paramWebResourceRequest.getUrl() != null))
        {
          Log.i(MpWebViewController.f((MpWebViewController)localObject), "edw opt, shouldOverride url isForMainFrame");
          String str1 = paramWebResourceRequest.getUrl().toString();
          s.s(str1, "request.url.toString()");
          String str2 = com.tencent.mm.plugin.webview.g.a.vVP;
          s.s(str2, "HARDCODE_URL");
          if ((!n.U(str1, str2, false)) && (getController().irY()))
          {
            Log.i(MpWebViewController.f((MpWebViewController)localObject), "edw opt, shouldOverride url exitTmpl");
            MpWebViewController.g((MpWebViewController)localObject);
            ((BaseWebViewController)localObject).WwQ = true;
          }
        }
        paramWebView = super.c(paramWebView, paramWebResourceRequest);
        AppMethodBeat.o(303364);
        return paramWebView;
      }
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$MpWebViewInterceptor$intercept$InterceptInfo", "", "path", "", "isZip", "", "(Ljava/lang/String;Z)V", "()Z", "getPath", "()Ljava/lang/String;", "component1", "component2", "copy", "(Ljava/lang/String;Z)Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$MpWebViewInterceptor$intercept$InterceptInfo;", "equals", "other", "hashCode", "", "toString", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
    {
      final String path;
      final boolean qon;
      
      public a(String paramString, boolean paramBoolean)
      {
        AppMethodBeat.i(303321);
        this.path = paramString;
        this.qon = paramBoolean;
        AppMethodBeat.o(303321);
      }
      
      public final boolean equals(Object paramObject)
      {
        AppMethodBeat.i(303348);
        if (this == paramObject)
        {
          AppMethodBeat.o(303348);
          return true;
        }
        if (!(paramObject instanceof a))
        {
          AppMethodBeat.o(303348);
          return false;
        }
        paramObject = (a)paramObject;
        if (!s.p(this.path, paramObject.path))
        {
          AppMethodBeat.o(303348);
          return false;
        }
        if (this.qon != paramObject.qon)
        {
          AppMethodBeat.o(303348);
          return false;
        }
        AppMethodBeat.o(303348);
        return true;
      }
      
      public final int hashCode()
      {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
      }
      
      public final String toString()
      {
        AppMethodBeat.i(303332);
        String str = "InterceptInfo(path=" + this.path + ", isZip=" + this.qon + ')';
        AppMethodBeat.o(303332);
        return str;
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class b
      extends kotlin.g.b.u
      implements kotlin.g.a.a<ah>
    {
      b(l paraml)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    g(MpWebViewController paramMpWebViewController)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    i(MpWebViewController paramMpWebViewController)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    j(MpWebViewController paramMpWebViewController)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "value", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class k
    extends kotlin.g.b.u
    implements kotlin.g.a.b<String, ah>
  {
    k(MpWebViewController paramMpWebViewController)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$initEnviroment$1", "", "__getString", "", "__log", "", "value", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class l
  {
    l(MpWebViewController paramMpWebViewController) {}
    
    @android.webkit.JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final String __getString()
    {
      AppMethodBeat.i(303363);
      Object localObject2 = MpWebViewController.h(this.vWW);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("contentId");
        localObject1 = null;
      }
      s.u(localObject1, "<this>");
      localObject2 = com.tencent.mm.plugin.brandservice.ui.timeline.preload.m.vSK;
      localObject1 = com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.b(com.tencent.mm.plugin.brandservice.ui.timeline.preload.m.dfw(), (String)localObject1);
      if (localObject1 == null)
      {
        AppMethodBeat.o(303363);
        return "";
      }
      localObject1 = v.an((com.tencent.mm.vfs.u)localObject1);
      if (localObject1 == null)
      {
        AppMethodBeat.o(303363);
        return "";
      }
      AppMethodBeat.o(303363);
      return localObject1;
    }
    
    @android.webkit.JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void __log(String paramString)
    {
      AppMethodBeat.i(303354);
      Object localObject = this.vWW;
      if (paramString != null)
      {
        paramString = new JSONObject(paramString).getJSONObject("err");
        if (paramString != null)
        {
          int i = paramString.getInt("errCode");
          String str1 = paramString.getString("msg");
          String str2 = ((MpWebViewController)localObject).dgW();
          StringBuilder localStringBuilder = new StringBuilder("onWebLog:");
          localObject = ((MpWebViewController)localObject).vWA;
          paramString = (String)localObject;
          if (localObject == null)
          {
            s.bIx("contentId");
            paramString = null;
          }
          Log.e(str2, paramString + ',' + i + ',' + str1);
          com.tencent.mm.plugin.webview.g.a.atP(114);
        }
      }
      AppMethodBeat.o(303354);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$loadTmpl$InterceptInfo", "", "path", "", "isZip", "", "(Ljava/lang/String;Z)V", "()Z", "getPath", "()Ljava/lang/String;", "component1", "component2", "copy", "(Ljava/lang/String;Z)Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$loadTmpl$InterceptInfo;", "equals", "other", "hashCode", "", "toString", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class m
  {
    final String path;
    final boolean qon;
    
    public m(String paramString)
    {
      AppMethodBeat.i(303356);
      this.path = paramString;
      this.qon = false;
      AppMethodBeat.o(303356);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(303377);
      if (this == paramObject)
      {
        AppMethodBeat.o(303377);
        return true;
      }
      if (!(paramObject instanceof m))
      {
        AppMethodBeat.o(303377);
        return false;
      }
      paramObject = (m)paramObject;
      if (!s.p(this.path, paramObject.path))
      {
        AppMethodBeat.o(303377);
        return false;
      }
      if (this.qon != paramObject.qon)
      {
        AppMethodBeat.o(303377);
        return false;
      }
      AppMethodBeat.o(303377);
      return true;
    }
    
    public final int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final String toString()
    {
      AppMethodBeat.i(303367);
      String str = "InterceptInfo(path=" + this.path + ", isZip=" + this.qon + ')';
      AppMethodBeat.o(303367);
      return str;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class n
    extends kotlin.d.b.a.k
    implements kotlin.g.a.m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    n(MpWebViewController paramMpWebViewController, kotlin.d.d<? super n> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(303369);
      paramObject = (kotlin.d.d)new n(this.vWW, paramd);
      AppMethodBeat.o(303369);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(303362);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(303362);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = (kotlin.d.d)this;
        this.label = 1;
        if (bb.e(300L, paramObject) == locala)
        {
          AppMethodBeat.o(303362);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      MpWebViewController.b(this.vWW, MpWebViewController.dhm());
      paramObject = ah.aiuX;
      AppMethodBeat.o(303362);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "titles", "", "data", "performance", "", "Lkotlin/Pair;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class o
    extends kotlin.g.b.u
    implements kotlin.g.a.q<String, String, List<? extends kotlin.r<? extends String, ? extends String>>, ah>
  {
    o(MpWebViewController paramMpWebViewController)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "titles", "", "data", "performance", "", "Lkotlin/Pair;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class p
    extends kotlin.g.b.u
    implements kotlin.g.a.q<String, String, List<? extends kotlin.r<? extends String, ? extends String>>, ah>
  {
    p(MpWebViewController paramMpWebViewController)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "contextRef", "Ljava/lang/ref/WeakReference;", "", "result", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$MountableCGIResult;", "appMsgContext", "Lcom/tencent/mm/protocal/protobuf/AppMsgContext;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class q
    extends kotlin.g.b.u
    implements kotlin.g.a.q<WeakReference<Object>, m.c, gb, ah>
  {
    q(MpWebViewController paramMpWebViewController)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/protocal/protobuf/PreloadSession;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class r
    extends kotlin.g.b.u
    implements kotlin.g.a.a<egp>
  {
    r(MpWebViewController paramMpWebViewController, MMWebView paramMMWebView)
    {
      super();
    }
    
    private egp dhr()
    {
      AppMethodBeat.i(303394);
      try
      {
        localObject1 = MpWebViewController.m(this.vWW);
        localObject3 = f.s.adwY;
        s.s(localObject3, "KTmplSession");
        localObject1 = ((Intent)localObject1).getByteArrayExtra((String)localObject3);
        if (localObject1 == null) {
          break label255;
        }
        i = localObject1.length;
        if (i != 0) {
          break label229;
        }
        i = 1;
      }
      catch (Exception localException1)
      {
        egp localegp;
        for (;;)
        {
          try
          {
            Object localObject3 = egp.class.newInstance();
            ((com.tencent.mm.bx.a)localObject3).parseFrom((byte[])localObject1);
            Object localObject1 = (com.tencent.mm.bx.a)localObject3;
            localObject3 = (egp)localObject1;
            localObject1 = localObject3;
            if (localObject3 != null) {
              break;
            }
            localObject1 = new Resources.NotFoundException("TmplSession");
            AppMethodBeat.o(303394);
            throw ((Throwable)localObject1);
          }
          catch (Exception localException2)
          {
            int i;
            Object localObject2;
            Log.printErrStackTrace("Intent.decodeProtoBuffer", (Throwable)localException2, "decode ProtoBuffer", new Object[0]);
          }
          localException1 = localException1;
          Log.e(MpWebViewController.f(this.vWW), "session is null, " + localException1.getMessage() + ' ' + f.ai(MpWebViewController.m(this.vWW)));
          com.tencent.mm.plugin.webview.g.a.atP(153);
          com.tencent.mm.plugin.report.service.h.OAn.b(17260, new Object[] { Integer.valueOf(2), f.ai(MpWebViewController.m(this.vWW)) });
          if ((paramMMWebView.getActivityContextIfHas() instanceof Activity))
          {
            localObject2 = paramMMWebView.getActivityContextIfHas();
            if (localObject2 == null)
            {
              localObject2 = new NullPointerException("null cannot be cast to non-null type android.app.Activity");
              AppMethodBeat.o(303394);
              throw ((Throwable)localObject2);
              i = 0;
              continue;
              i = 0;
              continue;
              localegp = null;
            }
            else
            {
              ((Activity)localegp).finish();
            }
          }
          else
          {
            localegp = new egp();
          }
        }
        AppMethodBeat.o(303394);
        return localegp;
      }
      if (i == 0)
      {
        i = 1;
        if (i == 0) {
          break label255;
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class s
    extends kotlin.g.b.u
    implements kotlin.g.a.b<String, ah>
  {
    s(MpWebViewController paramMpWebViewController)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "value", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class t
    extends kotlin.g.b.u
    implements kotlin.g.a.b<String, ah>
  {
    t(MpWebViewController paramMpWebViewController)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "value", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class u
    extends kotlin.g.b.u
    implements kotlin.g.a.b<String, ah>
  {
    u(MpWebViewController paramMpWebViewController)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "value", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class v
    extends kotlin.g.b.u
    implements kotlin.g.a.b<String, ah>
  {
    v(MpWebViewController paramMpWebViewController, long paramLong1, ah.a parama, long paramLong2)
    {
      super();
    }
    
    private static final void p(MpWebViewController paramMpWebViewController)
    {
      AppMethodBeat.i(303395);
      s.u(paramMpWebViewController, "this$0");
      AppMethodBeat.o(303395);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.MpWebViewController
 * JD-Core Version:    0.7.0.1
 */