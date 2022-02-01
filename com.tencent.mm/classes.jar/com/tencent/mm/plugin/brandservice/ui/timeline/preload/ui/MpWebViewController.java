package com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources.NotFoundException;
import android.net.Uri;
import android.os.Process;
import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.kernel.b.g.a;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.UrlExKt;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.j.a;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.m;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.m.c;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.u;
import com.tencent.mm.plugin.webview.core.BaseWebViewController;
import com.tencent.mm.plugin.webview.core.BaseWebViewController.ControllerAction;
import com.tencent.mm.plugin.webview.core.BaseWebViewController.b;
import com.tencent.mm.plugin.webview.core.BaseWebViewController.e;
import com.tencent.mm.plugin.webview.core.k.a;
import com.tencent.mm.plugin.webview.d.h.a;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.bhj;
import com.tencent.mm.protocal.protobuf.dei;
import com.tencent.mm.protocal.protobuf.eic;
import com.tencent.mm.protocal.protobuf.fn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMSlotKt;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.ui.e.p;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.vfs.s;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.c;
import com.tencent.xweb.ag;
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
import kotlin.g.b.aa;
import kotlin.g.b.z.a;
import kotlin.l;
import kotlin.x;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController;", "Lcom/tencent/mm/plugin/webview/core/WebViewController;", "tmplParams", "Lcom/tencent/mm/protocal/protobuf/TmplParams;", "viewWV", "Lcom/tencent/mm/ui/widget/MMWebView;", "(Lcom/tencent/mm/protocal/protobuf/TmplParams;Lcom/tencent/mm/ui/widget/MMWebView;)V", "API", "", "TAG", "getTAG", "()Ljava/lang/String;", "TAG$delegate", "Lkotlin/Lazy;", "TIMEOUT_TIME", "", "getTIMEOUT_TIME", "()J", "actionsCheckList", "", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$WebEvent;", "getActionsCheckList", "()Ljava/util/List;", "canFinishProgress", "", "getCanFinishProgress", "()Z", "checkNotifyPageTimer", "Ljava/lang/Runnable;", "contentId", "fullUrl", "gettingA8KeyUrl", "Ljava/util/HashSet;", "injectAPI", "isCheckingInject", "<set-?>", "isInjectDataSuccess", "isNotifyPageSuccess", "setNotifyPageSuccess", "(Z)V", "isStopCheckNotifyPage", "setStopCheckNotifyPage", "isTmplReady", "isUseDataCache", "setUseDataCache", "kv15862", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/Kv15862;", "getKv15862", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/Kv15862;", "preloadNext", "getPreloadNext", "setPreloadNext", "rawUrl", "getRawUrl", "receivePageData", "getReceivePageData", "setReceivePageData", "(J)V", "recodeInject", "session", "Lcom/tencent/mm/protocal/protobuf/PreloadSession;", "getSession", "()Lcom/tencent/mm/protocal/protobuf/PreloadSession;", "session$delegate", "startGetPageData", "getStartGetPageData", "setStartGetPageData", "startLoadPage", "getStartLoadPage", "setStartLoadPage", "adjustInnerWidth", "", "canHandleUrl", "url", "cancelReport", "checkInject", "checkNotifyPage", "getLogAPI", "value", "initEnviroment", "isPageCached", "isSameStart", "intent", "Landroid/content/Intent;", "loadForceUrl", "forceUrl", "fullScreen", "loadTmpl", "modifyForceUrl", "needSyncGetA8Key", "notifyPageInfo", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "pageInfo", "onError", "reason", "", "reqUrl", "errType", "errCode", "errMsg", "onPageFinished", "view", "Lcom/tencent/xweb/WebView;", "onPermissionUpdate", "response", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyResp;", "onStartLoad", "onWebLog", "processCommonGetA8KeyFullUrl", "httpHeader", "", "processData", "processGetAppContext", "result", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$MountableCGIResult;", "appMsgContext", "Lcom/tencent/mm/protocal/protobuf/AppMsgContext;", "processReport", "setMpUrl", "startAuth", "force", "stopCheckNotifyPage", "tryPreloadNextWebView", "updateAuth", "isSuccess", "updateData", "updateKV", "updatePageAuth", "validCommitUrl", "validStartUrl", "waitForInject", "waitForReady", "Companion", "ForceUrl", "MpWebViewInterceptor", "NotifyAuth", "PreloadNext", "StartPreload", "UpdateData", "plugin-brandservice_release"})
public final class MpWebViewController
  extends com.tencent.mm.plugin.webview.core.i
{
  private static final int pFV = -101;
  static final int pFW = -102;
  private static final int pFX = -103;
  private static final int pFY = -111;
  private static final int pFZ = -112;
  private static final int pGa = -113;
  private static final int pGb = -121;
  private static final int pGc = -122;
  private static final int pGd = -123;
  private static final int pGe = -124;
  private static final int pGf = -130;
  public static final f pGg;
  private final eic pBf;
  private final kotlin.f pFA;
  final com.tencent.mm.plugin.brandservice.ui.timeline.preload.i pFB;
  private long pFC;
  private long pFD;
  private long pFE;
  private boolean pFF;
  private boolean pFG;
  private final long pFH;
  private final kotlin.f pFI;
  private String pFJ;
  String pFK;
  private boolean pFL;
  private boolean pFM;
  private final String pFN;
  private final List<BaseWebViewController.e> pFO;
  private final String pFP;
  boolean pFQ;
  private final HashSet<String> pFR;
  boolean pFS;
  boolean pFT;
  private final Runnable pFU;
  
  static
  {
    AppMethodBeat.i(195850);
    pGg = new f((byte)0);
    pFV = -101;
    pFW = -102;
    pFX = -103;
    pFY = -111;
    pFZ = -112;
    pGa = -113;
    pGb = -121;
    pGc = -122;
    pGd = -123;
    pGe = -124;
    pGf = -130;
    AppMethodBeat.o(195850);
  }
  
  public MpWebViewController(eic parameic, final MMWebView paramMMWebView)
  {
    super(paramMMWebView);
    AppMethodBeat.i(195849);
    this.pBf = parameic;
    this.pFA = kotlin.g.ah((kotlin.g.a.a)new h(this));
    parameic = new com.tencent.mm.plugin.brandservice.ui.timeline.preload.i();
    parameic.a(this.pBf);
    this.pFB = parameic;
    this.pFF = true;
    this.pFH = 5000L;
    this.pFI = kotlin.g.ah((kotlin.g.a.a)new u(this, paramMMWebView));
    this.pFN = "__tmpl_webview_inject_data";
    if (!(paramMMWebView instanceof a.a)) {}
    for (parameic = null;; parameic = paramMMWebView)
    {
      parameic = (a.a)parameic;
      if (parameic != null)
      {
        parameic.setValidUrlProxy((kotlin.g.a.b)new d(this));
        parameic.setCurrentUrlProxy((kotlin.g.a.a)new e(this));
      }
      parameic = super.cpb();
      parameic.addAll((Collection)kotlin.a.j.listOf(new BaseWebViewController.e[] { new BaseWebViewController.e(aa.bp(UpdateData.class), (kotlin.g.a.a)new i((MpWebViewController)this)), new BaseWebViewController.e(aa.bp(StartPreload.class), (kotlin.g.a.a)new a(this)), new BaseWebViewController.e(aa.bp(PreloadNext.class), (kotlin.g.a.a)new j((MpWebViewController)this)), new BaseWebViewController.e(aa.bp(NotifyAuth.class), (kotlin.g.a.a)new b(this)), new BaseWebViewController.e(aa.bp(ForceUrl.class), (kotlin.g.a.a)new c(this)) }));
      this.pFO = parameic;
      this.pFP = (this.pFN + ".__getString()");
      this.pFR = new HashSet();
      this.pFU = ((Runnable)new l(this));
      AppMethodBeat.o(195849);
      return;
    }
  }
  
  private final void a(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    AppMethodBeat.i(195845);
    Log.i(getTAG(), "[updatePageAuth]reqUrl:" + paramString1 + " fullUrl:" + paramString2 + " httpHeader:" + paramMap);
    paramString1 = this.pGj.getSettings();
    kotlin.g.b.p.g(paramString1, "viewWV.settings");
    paramString1 = paramString1.getUserAgentString();
    kotlin.g.b.p.g(paramString1, "viewWV.settings.userAgentString");
    paramMap.put("User-agent", paramString1);
    paramString1 = getJsapi();
    if (paramMap == null)
    {
      paramString1 = new kotlin.t("null cannot be cast to non-null type kotlin.collections.Map<*, *>");
      AppMethodBeat.o(195845);
      throw paramString1;
    }
    paramString1.aYb(new JSONObject(paramMap).toString());
    paramString1 = Uri.parse(paramString2).getQueryParameter("pass_ticket");
    getJsapi().aYa(paramString1);
    AppMethodBeat.o(195845);
  }
  
  /* Error */
  private final boolean a(com.tencent.mm.plugin.webview.d.n paramn)
  {
    // Byte code:
    //   0: ldc_w 662
    //   3: invokestatic 281	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: getstatic 666	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$p:pGl	Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$p;
    //   9: astore 10
    //   11: aload_1
    //   12: invokestatic 670	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$p:c	(Lcom/tencent/mm/plugin/webview/d/n;)Ljava/lang/String;
    //   15: astore 10
    //   17: aload_0
    //   18: invokevirtual 447	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:getTAG	()Ljava/lang/String;
    //   21: ldc_w 672
    //   24: aload 10
    //   26: invokestatic 678	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   29: invokevirtual 681	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   32: invokestatic 465	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   35: new 620	org/json/JSONObject
    //   38: dup
    //   39: aload 10
    //   41: invokespecial 682	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   44: astore 10
    //   46: new 620	org/json/JSONObject
    //   49: dup
    //   50: aload 10
    //   52: ldc_w 684
    //   55: invokevirtual 687	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   58: invokespecial 682	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   61: astore 11
    //   63: aload 11
    //   65: ldc_w 689
    //   68: invokevirtual 693	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   71: lstore_2
    //   72: aload 11
    //   74: ldc_w 695
    //   77: invokevirtual 693	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   80: lstore 4
    //   82: aload 11
    //   84: ldc_w 697
    //   87: invokevirtual 693	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   90: lstore 6
    //   92: aload 11
    //   94: ldc_w 699
    //   97: invokevirtual 693	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   100: lstore 8
    //   102: aload_0
    //   103: getfield 703	com/tencent/mm/plugin/webview/core/BaseWebViewController:IKa	Lcom/tencent/mm/plugin/webview/k/j;
    //   106: ldc_w 697
    //   109: lload 6
    //   111: invokevirtual 709	com/tencent/mm/plugin/webview/k/j:bN	(Ljava/lang/String;J)V
    //   114: aload_0
    //   115: getfield 703	com/tencent/mm/plugin/webview/core/BaseWebViewController:IKa	Lcom/tencent/mm/plugin/webview/k/j;
    //   118: ldc_w 699
    //   121: lload 8
    //   123: invokevirtual 709	com/tencent/mm/plugin/webview/k/j:bN	(Ljava/lang/String;J)V
    //   126: aload_0
    //   127: getfield 349	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:pFB	Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/i;
    //   130: lload_2
    //   131: putfield 712	com/tencent/mm/plugin/brandservice/ui/timeline/preload/i:pBq	J
    //   134: aload_0
    //   135: getfield 349	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:pFB	Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/i;
    //   138: lload 4
    //   140: putfield 715	com/tencent/mm/plugin/brandservice/ui/timeline/preload/i:pBr	J
    //   143: aload_0
    //   144: getfield 349	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:pFB	Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/i;
    //   147: lload 6
    //   149: putfield 718	com/tencent/mm/plugin/brandservice/ui/timeline/preload/i:pBn	J
    //   152: aload_0
    //   153: getfield 349	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:pFB	Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/i;
    //   156: lload 8
    //   158: putfield 721	com/tencent/mm/plugin/brandservice/ui/timeline/preload/i:pBp	J
    //   161: aload 10
    //   163: ldc_w 723
    //   166: ldc_w 725
    //   169: invokevirtual 728	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   172: ldc_w 730
    //   175: invokestatic 734	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   178: ifeq +122 -> 300
    //   181: aload_0
    //   182: iconst_1
    //   183: putfield 736	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:pFS	Z
    //   186: aload_0
    //   187: getfield 349	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:pFB	Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/i;
    //   190: iconst_1
    //   191: putfield 739	com/tencent/mm/plugin/brandservice/ui/timeline/preload/i:pCf	Z
    //   194: aload_0
    //   195: getfield 349	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:pFB	Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/i;
    //   198: new 61	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$r
    //   201: dup
    //   202: aload_0
    //   203: invokespecial 740	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$r:<init>	(Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController;)V
    //   206: checkcast 742	kotlin/g/a/q
    //   209: invokevirtual 745	com/tencent/mm/plugin/brandservice/ui/timeline/preload/i:b	(Lkotlin/g/a/q;)V
    //   212: aload_0
    //   213: getfield 327	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:pBf	Lcom/tencent/mm/protocal/protobuf/eic;
    //   216: getfield 470	com/tencent/mm/protocal/protobuf/eic:reportId	I
    //   219: sipush 131
    //   222: invokestatic 478	com/tencent/mm/plugin/webview/h/a:gH	(II)V
    //   225: bipush 108
    //   227: invokestatic 748	com/tencent/mm/plugin/webview/h/a:agi	(I)V
    //   230: aload_0
    //   231: getfield 349	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:pFB	Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/i;
    //   234: invokestatic 503	com/tencent/mm/sdk/platformtools/MMSlotKt:now	()J
    //   237: putfield 751	com/tencent/mm/plugin/brandservice/ui/timeline/preload/i:pBF	J
    //   240: aload_0
    //   241: invokespecial 561	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:cpg	()V
    //   244: aload_0
    //   245: invokespecial 754	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:cpf	()V
    //   248: aload_0
    //   249: invokevirtual 613	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:getJsapi	()Lcom/tencent/mm/plugin/webview/d/h;
    //   252: aload_1
    //   253: getfield 759	com/tencent/mm/plugin/webview/d/n:ISe	Ljava/lang/String;
    //   256: ldc_w 761
    //   259: aconst_null
    //   260: invokevirtual 763	com/tencent/mm/plugin/webview/d/h:h	(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V
    //   263: bipush 90
    //   265: invokestatic 766	com/tencent/mm/plugin/webview/h/a:pl	(I)V
    //   268: getstatic 772	kotlinx/coroutines/bn:TUK	Lkotlinx/coroutines/bn;
    //   271: checkcast 774	kotlinx/coroutines/ai
    //   274: aconst_null
    //   275: new 776	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$q
    //   278: dup
    //   279: aload_0
    //   280: aconst_null
    //   281: invokespecial 779	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$q:<init>	(Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController;Lkotlin/d/d;)V
    //   284: checkcast 781	kotlin/g/a/m
    //   287: iconst_3
    //   288: invokestatic 786	kotlinx/coroutines/f:b	(Lkotlinx/coroutines/ai;Lkotlin/d/f;Lkotlin/g/a/m;I)Lkotlinx/coroutines/bu;
    //   291: pop
    //   292: ldc_w 662
    //   295: invokestatic 311	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   298: iconst_1
    //   299: ireturn
    //   300: aload_0
    //   301: getfield 349	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:pFB	Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/i;
    //   304: iconst_1
    //   305: putfield 558	com/tencent/mm/plugin/brandservice/ui/timeline/preload/i:pCu	Z
    //   308: aload_0
    //   309: getstatic 307	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:pGe	I
    //   312: invokevirtual 789	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:afH	(I)V
    //   315: aload_0
    //   316: invokevirtual 447	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:getTAG	()Ljava/lang/String;
    //   319: ldc_w 791
    //   322: invokestatic 465	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   325: goto -95 -> 230
    //   328: astore 10
    //   330: aload_0
    //   331: invokevirtual 447	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:getTAG	()Ljava/lang/String;
    //   334: aload 10
    //   336: checkcast 793	java/lang/Throwable
    //   339: ldc_w 794
    //   342: iconst_0
    //   343: anewarray 796	java/lang/Object
    //   346: invokestatic 800	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   349: aload_0
    //   350: getfield 349	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:pFB	Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/i;
    //   353: iconst_1
    //   354: putfield 558	com/tencent/mm/plugin/brandservice/ui/timeline/preload/i:pCu	Z
    //   357: aload_0
    //   358: getstatic 307	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:pGe	I
    //   361: invokevirtual 789	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:afH	(I)V
    //   364: goto -134 -> 230
    //   367: astore 10
    //   369: aload_0
    //   370: invokevirtual 447	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:getTAG	()Ljava/lang/String;
    //   373: aload 10
    //   375: checkcast 793	java/lang/Throwable
    //   378: ldc_w 801
    //   381: iconst_0
    //   382: anewarray 796	java/lang/Object
    //   385: invokestatic 800	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   388: aload_0
    //   389: invokevirtual 613	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:getJsapi	()Lcom/tencent/mm/plugin/webview/d/h;
    //   392: aload_1
    //   393: getfield 759	com/tencent/mm/plugin/webview/d/n:ISe	Ljava/lang/String;
    //   396: ldc_w 803
    //   399: aconst_null
    //   400: invokevirtual 763	com/tencent/mm/plugin/webview/d/h:h	(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V
    //   403: bipush 91
    //   405: invokestatic 766	com/tencent/mm/plugin/webview/h/a:pl	(I)V
    //   408: ldc_w 662
    //   411: invokestatic 311	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   414: iconst_0
    //   415: ireturn
    //   416: astore 10
    //   418: aload_0
    //   419: invokevirtual 447	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:getTAG	()Ljava/lang/String;
    //   422: aload 10
    //   424: checkcast 793	java/lang/Throwable
    //   427: ldc_w 801
    //   430: iconst_0
    //   431: anewarray 796	java/lang/Object
    //   434: invokestatic 800	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   437: goto -49 -> 388
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	440	0	this	MpWebViewController
    //   0	440	1	paramn	com.tencent.mm.plugin.webview.d.n
    //   71	60	2	l1	long
    //   80	59	4	l2	long
    //   90	58	6	l3	long
    //   100	57	8	l4	long
    //   9	153	10	localObject	Object
    //   328	7	10	localJSONException1	org.json.JSONException
    //   367	7	10	localJSONException2	org.json.JSONException
    //   416	7	10	localRemoteException	android.os.RemoteException
    //   61	32	11	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   35	230	328	org/json/JSONException
    //   300	325	328	org/json/JSONException
    //   11	35	367	org/json/JSONException
    //   230	298	367	org/json/JSONException
    //   330	364	367	org/json/JSONException
    //   11	35	416	android/os/RemoteException
    //   35	230	416	android/os/RemoteException
    //   230	298	416	android/os/RemoteException
    //   300	325	416	android/os/RemoteException
    //   330	364	416	android/os/RemoteException
  }
  
  private void aiA(String paramString)
  {
    AppMethodBeat.i(195846);
    kotlin.g.b.p.h(paramString, "forceUrl");
    cpf();
    j.a locala = com.tencent.mm.plugin.brandservice.ui.timeline.preload.j.pCC;
    if (j.a.coa())
    {
      AppMethodBeat.o(195846);
      return;
    }
    fZF();
    this.IKf = true;
    k(aiB(paramString), true, 8);
    AppMethodBeat.o(195846);
  }
  
  private static String aiB(String paramString)
  {
    AppMethodBeat.i(195848);
    paramString = UrlExKt.appendUrlParam(UrlExKt.clearUrlParam$default(UrlExKt.clearUrlParam$default(UrlExKt.clearUrlParam$default(paramString, "fasttmpl_flag", false, 2, null), "fasttmpl_type", false, 2, null), "fasttmpl_fullversion", false, 2, null), "forceh5", "1");
    AppMethodBeat.o(195848);
    return paramString;
  }
  
  private final void aiz(String paramString)
  {
    AppMethodBeat.i(195839);
    this.IJM = paramString;
    aXx(paramString);
    aXy(paramString);
    kotlin.g.b.p.h(paramString, "<set-?>");
    this.djt = paramString;
    AppMethodBeat.o(195839);
  }
  
  private dei coW()
  {
    AppMethodBeat.i(195823);
    dei localdei = (dei)this.pFI.getValue();
    AppMethodBeat.o(195823);
    return localdei;
  }
  
  private final void cpf()
  {
    AppMethodBeat.i(195837);
    Log.d(getTAG(), "stopCheckNotifyPage");
    bkj().removeCallbacks(this.pFU);
    this.pFT = true;
    AppMethodBeat.o(195837);
  }
  
  private final void cpg()
  {
    AppMethodBeat.i(195838);
    Log.v(getTAG(), "terry trace updateKV");
    this.pFB.pBA = this.IKa.bO("onInjectStart", 0L);
    this.pFB.pBB = this.IKa.bO("onInjectEnd", 0L);
    this.pFB.pBD = this.IKa.bO("onTmplLoadStart", 0L);
    this.pFB.pBE = this.IKa.bO("onTmplLoadEnd", 0L);
    this.pFB.pBy = this.IKa.bO("onCreateStart", 0L);
    this.pFB.pBz = this.IKa.bO("onCreateEnd", 0L);
    this.pFB.pBW = this.pFQ;
    this.pFB.pBC = this.IKa.bO("onWebInjectEnd", 0L);
    com.tencent.mm.plugin.brandservice.ui.timeline.preload.i locali = this.pFB;
    String str = this.pGj.getRandomStr();
    kotlin.g.b.p.g(str, "viewWV.randomStr");
    locali.setKey(str);
    this.pFB.pBX = afI(pFW);
    AppMethodBeat.o(195838);
  }
  
  private void t(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(195840);
    kotlin.g.b.p.h(paramString, "contentId");
    Log.v(getTAG(), "[updateData] " + coX());
    m.aij(coX());
    aiz(coX());
    this.pFK = paramString;
    this.pFC = paramLong1;
    this.pFE = paramLong2;
    afH(pFY);
    AppMethodBeat.o(195840);
  }
  
  public final void a(int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2)
  {
    AppMethodBeat.i(195844);
    kotlin.g.b.p.h(paramString1, "reqUrl");
    kotlin.g.b.p.h(paramString2, "errMsg");
    super.a(paramInt1, paramString1, paramInt2, paramInt3, paramString2);
    if (paramInt1 == 0)
    {
      this.pFJ = paramString1;
      afH(pGc);
    }
    AppMethodBeat.o(195844);
  }
  
  public final void a(int paramInt, String paramString1, String paramString2, bhj parambhj)
  {
    AppMethodBeat.i(195841);
    kotlin.g.b.p.h(paramString1, "reqUrl");
    kotlin.g.b.p.h(paramString2, "fullUrl");
    kotlin.g.b.p.h(parambhj, "response");
    if (paramInt == 0) {
      aiz(paramString2);
    }
    super.a(paramInt, paramString1, paramString2, parambhj);
    if (paramInt == 0)
    {
      this.pFJ = paramString2;
      parambhj = com.tencent.mm.plugin.webview.f.c.ij((List)parambhj.LRq);
      kotlin.g.b.p.g(parambhj, "LuggageGetA8Key.getHttpH…ders(response.HttpHeader)");
      com.tencent.mm.plugin.webview.h.a.gH(this.pBf.reportId, 117);
      this.pFB.pBx = MMSlotKt.now();
      this.pFB.pCe = true;
      cpg();
      this.pFB.b((kotlin.g.a.q)new s(this));
      a(paramString1, paramString2, parambhj);
      afH(pGb);
    }
    AppMethodBeat.o(195841);
  }
  
  public final boolean aK(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(195834);
    kotlin.g.b.p.h(paramString, "url");
    if (((kotlin.g.b.p.j(paramString, this.pBf.ISo) ^ true)) && (super.aK(paramString, paramBoolean)))
    {
      AppMethodBeat.o(195834);
      return true;
    }
    AppMethodBeat.o(195834);
    return false;
  }
  
  public final boolean ah(Intent paramIntent)
  {
    AppMethodBeat.i(195825);
    kotlin.g.b.p.h(paramIntent, "intent");
    if (this.IJR)
    {
      paramIntent = paramIntent.getStringExtra("rawUrl");
      kotlin.g.b.p.g(paramIntent, "intent.getStringExtra(Co…antsUI.WebViewUI.KRawUrl)");
      if (kotlin.g.b.p.j(kotlin.n.n.by(paramIntent, "http://", "https://"), coX()))
      {
        AppMethodBeat.o(195825);
        return true;
      }
    }
    AppMethodBeat.o(195825);
    return false;
  }
  
  public final boolean aiw(String paramString)
  {
    AppMethodBeat.i(195830);
    kotlin.g.b.p.h(paramString, "url");
    if ((super.aix(paramString)) && ((kotlin.g.b.p.j(paramString, this.pBf.ISo) ^ true)))
    {
      AppMethodBeat.o(195830);
      return true;
    }
    AppMethodBeat.o(195830);
    return false;
  }
  
  public final boolean aix(String paramString)
  {
    AppMethodBeat.i(195831);
    kotlin.g.b.p.h(paramString, "url");
    if ((super.aix(paramString)) && ((kotlin.g.b.p.j(paramString, this.pBf.ISo) ^ true)))
    {
      AppMethodBeat.o(195831);
      return true;
    }
    AppMethodBeat.o(195831);
    return false;
  }
  
  public final boolean aiy(String paramString)
  {
    AppMethodBeat.i(195833);
    if ((kotlin.g.b.p.j(paramString, this.pBf.ISo)) || ((paramString != null) && (kotlin.n.n.J(paramString, "file://", false) == true)))
    {
      AppMethodBeat.o(195833);
      return true;
    }
    AppMethodBeat.o(195833);
    return false;
  }
  
  public final void b(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(195835);
    super.b(paramWebView, paramString);
    if (kotlin.g.b.p.j(paramString, this.pBf.ISo))
    {
      if ((afI(pFW)) || (afI(pFV)))
      {
        AppMethodBeat.o(195835);
        return;
      }
      Log.i(getTAG(), "checkInject start");
      com.tencent.mm.plugin.webview.h.a.gH(this.pBf.reportId, 113);
      n("JSON.stringify(window.__appmsg_skeleton_success__)", (kotlin.g.a.b)new k(this));
      int i = com.tencent.mm.cb.a.jn(this.pGj.getContext());
      float f = com.tencent.mm.cb.a.getDensity(this.pGj.getContext());
      Log.i(getTAG(), "adjustInnerWidth() screenWidth:" + i + ", density:" + f);
      if ((i > 0) && (f > 0.0F))
      {
        i = (int)(i / f);
        Log.i(getTAG(), "adjustInnerWidth() innerWidth:".concat(String.valueOf(i)));
        n("window.innerWidth = ".concat(String.valueOf(i)), null);
      }
      Log.i(getTAG(), "[onPageReady]");
    }
    AppMethodBeat.o(195835);
  }
  
  public final String coX()
  {
    AppMethodBeat.i(195824);
    String str = kotlin.n.n.by(BaseWebViewController.b.bj(getIntent()), "http://", "https://");
    AppMethodBeat.o(195824);
    return str;
  }
  
  public final boolean coY()
  {
    AppMethodBeat.i(195826);
    if ((afI(pFZ)) || (afI(pGa)))
    {
      AppMethodBeat.o(195826);
      return true;
    }
    AppMethodBeat.o(195826);
    return false;
  }
  
  public final boolean coZ()
  {
    AppMethodBeat.i(195827);
    if ((afI(this.IKl)) && (afI(pFW)))
    {
      AppMethodBeat.o(195827);
      return true;
    }
    AppMethodBeat.o(195827);
    return false;
  }
  
  public final boolean cpa()
  {
    AppMethodBeat.i(195828);
    if ((fZz()) && (afI(pGb)))
    {
      AppMethodBeat.o(195828);
      return true;
    }
    AppMethodBeat.o(195828);
    return false;
  }
  
  public final List<BaseWebViewController.e> cpb()
  {
    return this.pFO;
  }
  
  public final void cpc()
  {
    AppMethodBeat.i(195829);
    a((com.tencent.mm.plugin.webview.core.k)new g(this.pBf, this.pGj));
    super.cpc();
    this.pGj.addJavascriptInterface(new m(this), this.pFN);
    getJsapi().gaT();
    getJsapi().a((h.a)new n(this));
    String str = this.pBf.ISo;
    Log.i(getTAG(), "WebView-Trace loadTmpl getResourceResponse, requrl:%s, url:%s", new Object[] { str, this.pBf.Nhr });
    Object localObject = this.pBf.Nhr;
    kotlin.g.b.p.g(localObject, "tmplParams.initFilePath");
    localObject = new o((String)localObject);
    Log.v(getTAG(), "response path:" + Util.nullAs(((o)localObject).path, "null"));
    if (f.g((WebView)this.pGj, ((o)localObject).path) != null)
    {
      Log.i(getTAG(), "return intercepted success");
      afH(this.IKm);
      this.pGj.loadUrl(str);
      afH(this.IKl);
      AppMethodBeat.o(195829);
      return;
    }
    Log.e(getTAG(), "return intercepted null");
    com.tencent.mm.plugin.webview.h.a.gH(this.pBf.reportId, 126);
    if (((o)localObject).kwO) {
      com.tencent.mm.plugin.webview.h.a.gH(this.pBf.reportId, 233);
    }
    AppMethodBeat.o(195829);
  }
  
  public final void cpd()
  {
    int j = 1;
    AppMethodBeat.i(195832);
    Log.i(getTAG(), "onStartLoad");
    Object localObject1 = getIntent();
    kotlin.g.b.p.h(localObject1, "intent");
    Log.v(getTAG(), "processData");
    setIntent((Intent)localObject1);
    this.pFD = MMSlotKt.now();
    this.pFF = ((Intent)localObject1).getBooleanExtra(e.p.Ozr, true);
    this.pFC = ((Intent)localObject1).getLongExtra(e.p.Ozs, 0L);
    Object localObject2 = com.tencent.mm.kernel.g.aAe().azG();
    kotlin.g.b.p.g(localObject2, "MMKernel.process().current()");
    localObject2 = ((com.tencent.mm.kernel.b.h)localObject2).aBa();
    String str = ((Intent)localObject1).getStringExtra(e.p.Ozu);
    if ((((Intent)localObject1).getStringExtra("rawUrl") == null) || (str == null))
    {
      Log.e(getTAG(), "rawUrl is null, " + com.tencent.mm.plugin.brandservice.ui.timeline.preload.f.ag((Intent)localObject1));
      com.tencent.mm.plugin.webview.h.a.agi(151);
      com.tencent.mm.plugin.report.service.h.CyF.a(17260, new Object[] { Integer.valueOf(1), com.tencent.mm.plugin.brandservice.ui.timeline.preload.f.ag((Intent)localObject1) });
      i = 0;
      if (i == 0)
      {
        onFinish();
        AppMethodBeat.o(195832);
      }
    }
    else
    {
      com.tencent.mm.plugin.brandservice.ui.timeline.preload.i locali = this.pFB;
      if (((g.a)localObject2).hty < this.pFC)
      {
        bool = true;
        label233:
        locali.pCc = bool;
        if (!this.pFB.pCc) {
          break label541;
        }
        i = 104;
        label252:
        com.tencent.mm.plugin.webview.h.a.agi(i);
        switch (u.a(((Intent)localObject1).getIntExtra(e.p.Ozz, -1), this.pFC, Process.myPid(), ((g.a)localObject2).htq))
        {
        }
      }
      for (;;)
      {
        this.pFB.kwO = coW().MJt;
        this.pFB.pBZ = coW().MJu;
        this.pFB.pCa = com.tencent.mm.plugin.webview.d.k.b((WebView)this.pGj);
        this.pFB.pCb = coW().pCb;
        this.pFB.pBL = ((g.a)localObject2).htq;
        this.pFB.pBM = ((g.a)localObject2).htr;
        this.pFB.pBN = ((g.a)localObject2).hts;
        this.pFB.pBO = ((g.a)localObject2).htt;
        this.pFB.pBP = ((g.a)localObject2).htu;
        this.pFB.pBQ = ((g.a)localObject2).htv;
        this.pFB.pBR = ((g.a)localObject2).htw;
        this.pFB.pBS = ((g.a)localObject2).htx;
        this.pFB.pBT = ((g.a)localObject2).hty;
        this.pFB.pBm = this.pFC;
        this.pFB.pBs = this.pFD;
        this.pFB.pmM = coW().pmM;
        m.pCU.a(this, str, coW(), (kotlin.g.a.q)new t(this));
        i = j;
        break;
        bool = false;
        break label233;
        label541:
        i = 103;
        break label252;
        this.pFB.pCd = 1;
        this.pFC = ((g.a)localObject2).htq;
        continue;
        this.pFB.pCd = 2;
        this.pFC = -1L;
      }
    }
    this.pFB.a(this.pBf);
    localObject1 = this.pFB;
    localObject2 = coX();
    kotlin.g.b.p.h(localObject2, "<set-?>");
    ((com.tencent.mm.plugin.brandservice.ui.timeline.preload.i)localObject1).url = ((String)localObject2);
    boolean bool = afI(pFW);
    this.pFB.pBV = bool;
    this.pFB.pBU = this.pFG;
    this.pFB.pCs = this.pGj.getWebCoreType().name();
    if (bool) {}
    for (int i = 106;; i = 105)
    {
      com.tencent.mm.plugin.webview.h.a.agi(i);
      BaseWebViewController.a(this, coX());
      if (!this.pFS)
      {
        cpf();
        Log.i(getTAG(), "check notifyPage");
        this.pFT = false;
        bkj().postUIDelayed(this.pFU, this.pFH);
      }
      AppMethodBeat.o(195832);
      return;
    }
  }
  
  public final boolean cpe()
  {
    return false;
  }
  
  public final boolean cph()
  {
    AppMethodBeat.i(195843);
    boolean bool = afI(this.IKl);
    AppMethodBeat.o(195843);
    return bool;
  }
  
  final String getTAG()
  {
    AppMethodBeat.i(195822);
    String str = (String)this.pFA.getValue();
    AppMethodBeat.o(195822);
    return str;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$ForceUrl;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$ControllerAction;", "()V", "verify", "", "plugin-brandservice_release"})
  @Keep
  protected static final class ForceUrl
    extends BaseWebViewController.ControllerAction
  {
    public final boolean verify()
    {
      AppMethodBeat.i(195777);
      Object localObject = getController();
      if (localObject == null)
      {
        localObject = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.MpWebViewController");
        AppMethodBeat.o(195777);
        throw ((Throwable)localObject);
      }
      localObject = (MpWebViewController)localObject;
      MpWebViewController.f localf = MpWebViewController.pGg;
      if (((waitFor(MpWebViewController.cpq())) || (waitFor(MpWebViewController.cpn())) || (waitFor(MpWebViewController.cpo()))) && (waitFor(MpWebViewController.b((MpWebViewController)localObject))))
      {
        AppMethodBeat.o(195777);
        return true;
      }
      AppMethodBeat.o(195777);
      return false;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$NotifyAuth;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$ControllerAction;", "()V", "verify", "", "plugin-brandservice_release"})
  @Keep
  protected static final class NotifyAuth
    extends BaseWebViewController.ControllerAction
  {
    public final boolean verify()
    {
      AppMethodBeat.i(195788);
      Object localObject = getController();
      if (localObject == null)
      {
        localObject = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.MpWebViewController");
        AppMethodBeat.o(195788);
        throw ((Throwable)localObject);
      }
      localObject = (MpWebViewController)localObject;
      if ((waitFor(MpWebViewController.cpi())) && (((waitFor(MpWebViewController.a((MpWebViewController)localObject))) && (waitFor(MpWebViewController.cpk()))) || (waitFor(MpWebViewController.cpl()))))
      {
        AppMethodBeat.o(195788);
        return true;
      }
      AppMethodBeat.o(195788);
      return false;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$PreloadNext;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$ControllerAction;", "()V", "verify", "", "plugin-brandservice_release"})
  @Keep
  protected static final class PreloadNext
    extends BaseWebViewController.ControllerAction
  {
    public final boolean verify()
    {
      AppMethodBeat.i(195789);
      if (getController() == null)
      {
        kotlin.t localt = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.MpWebViewController");
        AppMethodBeat.o(195789);
        throw localt;
      }
      boolean bool = waitFor(MpWebViewController.cpm());
      AppMethodBeat.o(195789);
      return bool;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$StartPreload;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$ControllerAction;", "()V", "verify", "", "plugin-brandservice_release"})
  @Keep
  protected static final class StartPreload
    extends BaseWebViewController.ControllerAction
  {
    public final boolean verify()
    {
      AppMethodBeat.i(195790);
      Object localObject = getController();
      if (localObject == null)
      {
        localObject = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.MpWebViewController");
        AppMethodBeat.o(195790);
        throw ((Throwable)localObject);
      }
      boolean bool = waitFor(MpWebViewController.b((MpWebViewController)localObject));
      AppMethodBeat.o(195790);
      return bool;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$UpdateData;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$ControllerAction;", "()V", "verify", "", "plugin-brandservice_release"})
  @Keep
  protected static final class UpdateData
    extends BaseWebViewController.ControllerAction
  {
    public final boolean verify()
    {
      AppMethodBeat.i(195792);
      if (getController() == null)
      {
        kotlin.t localt = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.MpWebViewController");
        AppMethodBeat.o(195792);
        throw localt;
      }
      if ((waitFor(MpWebViewController.cpi())) && (waitFor(MpWebViewController.cpj())))
      {
        AppMethodBeat.o(195792);
        return true;
      }
      AppMethodBeat.o(195792);
      return false;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$actionsCheckList$1$2"})
  static final class a
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    a(MpWebViewController paramMpWebViewController)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$actionsCheckList$1$4"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    b(MpWebViewController paramMpWebViewController)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$actionsCheckList$1$5"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    c(MpWebViewController paramMpWebViewController)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "invoke", "com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$1$1"})
  static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.b<String, Boolean>
  {
    d(MpWebViewController paramMpWebViewController)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$1$2"})
  static final class e
    extends kotlin.g.b.q
    implements kotlin.g.a.a<String>
  {
    e(MpWebViewController paramMpWebViewController)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$Companion;", "", "()V", "MP_AUTH_ERR", "", "MP_AUTH_NOTIFIED", "MP_AUTH_SUCC", "MP_DATA_INJECT_ERR", "MP_DATA_INJECT_SUCC", "MP_DATA_READY", "MP_NOTIFY_ERR", "MP_PRELOAD_NEXT", "MP_TMPL_CHECKING", "MP_TMPL_ERR", "getMP_TMPL_ERR$plugin_brandservice_release", "()I", "MP_TMPL_READY", "readFileWebResp", "Lcom/tencent/xweb/WebResourceResponse;", "webview", "Lcom/tencent/xweb/WebView;", "fileName", "", "plugin-brandservice_release"})
  public static final class f
  {
    static WebResourceResponse g(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(195776);
      if (!s.YS(paramString))
      {
        Log.e("MicroMsg.WebViewController", "tmpl file not found:".concat(String.valueOf(paramString)));
        AppMethodBeat.o(195776);
        return null;
      }
      Object localObject1 = MimeTypeUtil.getMimeTypeByFilePath(paramString);
      Object localObject2;
      if ((kotlin.n.n.K(paramString, ".js", false)) && (com.tencent.mm.plugin.webview.d.k.b(paramWebView)))
      {
        paramWebView = new ag(3, 256, paramWebView);
        paramWebView.bso(paramString);
        paramWebView = paramWebView.toString();
        localObject2 = StandardCharsets.UTF_8;
        kotlin.g.b.p.g(localObject2, "StandardCharsets.UTF_8");
        if (paramWebView == null)
        {
          paramWebView = new kotlin.t("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(195776);
          throw paramWebView;
        }
        localObject2 = paramWebView.getBytes((Charset)localObject2);
        kotlin.g.b.p.g(localObject2, "(this as java.lang.String).getBytes(charset)");
        localObject1 = new WebResourceResponse((String)localObject1, "UTF-8", (InputStream)new ByteArrayInputStream((byte[])localObject2));
      }
      for (;;)
      {
        localObject2 = new HashMap();
        str = Integer.toHexString(paramString.hashCode() & 0xFFFFFFFF);
        kotlin.g.b.p.g(str, "Integer.toHexString(file…Code() and (-1).ushr(32))");
        if (str != null) {
          break;
        }
        paramWebView = new kotlin.t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(195776);
        throw paramWebView;
        try
        {
          paramWebView = (InputStream)new FileInputStream(paramString);
          if (paramWebView == null)
          {
            Log.e("MicroMsg.WebViewController", "stream is null, err");
            AppMethodBeat.o(195776);
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
      String str = str.toLowerCase();
      kotlin.g.b.p.g(str, "(this as java.lang.String).toLowerCase()");
      ((Map)localObject2).put("Cache-Control", "max-age=31536000");
      ((Map)localObject2).put("ETag", str);
      if (paramWebView != null) {
        ((Map)localObject2).put("RunLocalJS", paramWebView);
      }
      ((WebResourceResponse)localObject1).setResponseHeaders((Map)localObject2);
      Log.i("MicroMsg.WebViewController", "readFileWebResp:%s\nETag:%s", new Object[] { paramString, str });
      AppMethodBeat.o(195776);
      return localObject1;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$MpWebViewInterceptor;", "Lcom/tencent/mm/plugin/webview/core/WebViewInterceptor;", "tmplParams", "Lcom/tencent/mm/protocal/protobuf/TmplParams;", "viewWV", "Lcom/tencent/mm/ui/widget/MMWebView;", "(Lcom/tencent/mm/protocal/protobuf/TmplParams;Lcom/tencent/mm/ui/widget/MMWebView;)V", "getTmplParams", "()Lcom/tencent/mm/protocal/protobuf/TmplParams;", "getViewWV", "()Lcom/tencent/mm/ui/widget/MMWebView;", "intercept", "Lcom/tencent/xweb/WebResourceResponse;", "webview", "Lcom/tencent/xweb/WebView;", "request", "Lcom/tencent/xweb/WebResourceRequest;", "overrideReload", "", "url", "", "overrideUrl", "Lcom/tencent/mm/plugin/webview/core/WebViewInterceptor$OverrideUrlResult;", "webView", "overrideUrlRedirect", "reason", "", "forceRedirect", "reqUrl", "fullUrl", "plugin-brandservice_release"})
  static final class g
    extends com.tencent.mm.plugin.webview.core.k
  {
    private final eic pBf;
    private final MMWebView pGj;
    
    public g(eic parameic, MMWebView paramMMWebView)
    {
      AppMethodBeat.i(195787);
      this.pBf = parameic;
      this.pGj = paramMMWebView;
      AppMethodBeat.o(195787);
    }
    
    public final boolean a(int paramInt, boolean paramBoolean, String paramString1, String paramString2)
    {
      AppMethodBeat.i(195783);
      kotlin.g.b.p.h(paramString1, "reqUrl");
      kotlin.g.b.p.h(paramString2, "fullUrl");
      if ((paramInt == 0) && (UrlExKt.isMpUrl(paramString2)) && (kotlin.g.b.p.j(com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.ahX(paramString1), com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.ahX(paramString2))))
      {
        AppMethodBeat.o(195783);
        return true;
      }
      paramBoolean = super.a(paramInt, paramBoolean, paramString1, paramString2);
      AppMethodBeat.o(195783);
      return paramBoolean;
    }
    
    public final boolean aiD(String paramString)
    {
      AppMethodBeat.i(195785);
      kotlin.g.b.p.h(paramString, "url");
      Object localObject2 = getController();
      Object localObject1 = localObject2;
      if (!(localObject2 instanceof MpWebViewController)) {
        localObject1 = null;
      }
      localObject1 = (MpWebViewController)localObject1;
      if ((localObject1 != null) && (((MpWebViewController.a((MpWebViewController)localObject1, MpWebViewController.b((MpWebViewController)localObject1))) && (kotlin.g.b.p.j(com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.ahX(paramString), com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.ahX(((MpWebViewController)localObject1).coX())))) || ((MpWebViewController.a((MpWebViewController)localObject1, MpWebViewController.cpk())) && (kotlin.g.b.p.j(com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.ahX(paramString), com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.ahX(MpWebViewController.c((MpWebViewController)localObject1)))) && (getController().fZF()))))
      {
        localObject2 = ((Iterable)MpWebViewController.d((MpWebViewController)localObject1)).iterator();
        while (((Iterator)localObject2).hasNext()) {
          com.tencent.mm.ac.d.h((kotlin.g.a.a)new b((com.tencent.mm.plugin.webview.core.j)((Iterator)localObject2).next()));
        }
        ((BaseWebViewController)localObject1).IKf = true;
        ((MpWebViewController)localObject1).k(MpWebViewController.aiC(paramString), true, 8);
        AppMethodBeat.o(195785);
        return true;
      }
      AppMethodBeat.o(195785);
      return false;
    }
    
    public final WebResourceResponse b(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
    {
      AppMethodBeat.i(195784);
      kotlin.g.b.p.h(paramWebView, "webview");
      kotlin.g.b.p.h(paramWebResourceRequest, "request");
      paramWebView = paramWebResourceRequest.getUrl().toString();
      kotlin.g.b.p.g(paramWebView, "request.url.toString()");
      if (((kotlin.g.b.p.j(paramWebView, this.pBf.ISo) ^ true)) && (!kotlin.n.n.J(paramWebView, com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b.getPrefix(), false)))
      {
        Log.d("MicroMsg.WebViewController", "WebView-Trace intercept return");
        AppMethodBeat.o(195784);
        return null;
      }
      Log.i("MicroMsg.WebViewController", "getResourceResponse, requrl:%s, url:%s", new Object[] { paramWebView, this.pBf.Nhr });
      if (paramWebResourceRequest.isForMainFrame())
      {
        paramWebView = this.pBf.Nhr;
        kotlin.g.b.p.g(paramWebView, "tmplParams.initFilePath");
        paramWebView = new a(paramWebView, false);
      }
      while (paramWebView != null)
      {
        Log.v("MicroMsg.WebViewController", "response path: " + paramWebView.path);
        paramWebResourceRequest = MpWebViewController.pGg;
        paramWebResourceRequest = MpWebViewController.f.g((WebView)this.pGj, paramWebView.path);
        if (paramWebResourceRequest != null)
        {
          Log.i("MicroMsg.WebViewController", "return intercepted success");
          AppMethodBeat.o(195784);
          return paramWebResourceRequest;
          int i;
          if (kotlin.n.n.J(paramWebView, com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b.coT(), false))
          {
            i = this.pBf.pCV;
            paramWebResourceRequest = this.pBf.hFF;
            kotlin.g.b.p.g(paramWebResourceRequest, "tmplParams.uid");
            paramWebView = (CharSequence)paramWebView;
            paramWebView = new a(com.tencent.mm.plugin.brandservice.ui.timeline.preload.t.u(i, paramWebResourceRequest, new kotlin.n.k(com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b.coT()).f(paramWebView, "")), true);
          }
          else if (kotlin.n.n.J(paramWebView, com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b.getPrefix(), false))
          {
            i = this.pBf.pCV;
            paramWebResourceRequest = this.pBf.hFF;
            kotlin.g.b.p.g(paramWebResourceRequest, "tmplParams.uid");
            paramWebView = (CharSequence)paramWebView;
            paramWebView = new a(com.tencent.mm.plugin.brandservice.ui.timeline.preload.t.u(i, paramWebResourceRequest, new kotlin.n.k(com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b.getPrefix()).f(paramWebView, "")), true);
          }
          else
          {
            paramWebView = null;
          }
        }
        else
        {
          Log.e("MicroMsg.WebViewController", "return intercepted null");
          com.tencent.mm.plugin.webview.h.a.gH(this.pBf.reportId, 126);
          if (paramWebView.kwO) {
            com.tencent.mm.plugin.webview.h.a.gH(this.pBf.reportId, 233);
          }
        }
      }
      AppMethodBeat.o(195784);
      return null;
    }
    
    public final k.a c(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
    {
      AppMethodBeat.i(195786);
      kotlin.g.b.p.h(paramWebView, "webView");
      kotlin.g.b.p.h(paramWebResourceRequest, "request");
      Object localObject2 = getController();
      Object localObject1 = localObject2;
      if (!(localObject2 instanceof MpWebViewController)) {
        localObject1 = null;
      }
      localObject1 = (MpWebViewController)localObject1;
      if ((localObject1 != null) && (paramWebResourceRequest.isForMainFrame()) && (paramWebResourceRequest.getUrl() != null))
      {
        Log.i(MpWebViewController.e((MpWebViewController)localObject1), "edw opt, shouldOverride url isForMainFrame");
        localObject2 = paramWebResourceRequest.getUrl().toString();
        kotlin.g.b.p.g(localObject2, "request.url.toString()");
        String str = com.tencent.mm.plugin.webview.h.a.pFm;
        kotlin.g.b.p.g(str, "ConstantsPreload.HARDCODE_URL");
        if ((!kotlin.n.n.J((String)localObject2, str, false)) && (getController().fZF()))
        {
          Log.i(MpWebViewController.e((MpWebViewController)localObject1), "edw opt, shouldOverride url exitTmpl");
          MpWebViewController.f((MpWebViewController)localObject1);
          ((BaseWebViewController)localObject1).IKf = true;
        }
      }
      paramWebView = super.c(paramWebView, paramWebResourceRequest);
      AppMethodBeat.o(195786);
      return paramWebView;
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$MpWebViewInterceptor$intercept$InterceptInfo", "", "path", "", "isZip", "", "(Ljava/lang/String;Z)V", "()Z", "getPath", "()Ljava/lang/String;", "component1", "component2", "copy", "(Ljava/lang/String;Z)Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$MpWebViewInterceptor$intercept$InterceptInfo;", "equals", "other", "hashCode", "", "toString", "plugin-brandservice_release"})
    public static final class a
    {
      final boolean kwO;
      final String path;
      
      public a(String paramString, boolean paramBoolean)
      {
        AppMethodBeat.i(195778);
        this.path = paramString;
        this.kwO = paramBoolean;
        AppMethodBeat.o(195778);
      }
      
      public final boolean equals(Object paramObject)
      {
        AppMethodBeat.i(195781);
        if (this != paramObject)
        {
          if ((paramObject instanceof a))
          {
            paramObject = (a)paramObject;
            if ((!kotlin.g.b.p.j(this.path, paramObject.path)) || (this.kwO != paramObject.kwO)) {}
          }
        }
        else
        {
          AppMethodBeat.o(195781);
          return true;
        }
        AppMethodBeat.o(195781);
        return false;
      }
      
      public final int hashCode()
      {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
      }
      
      public final String toString()
      {
        AppMethodBeat.i(195779);
        String str = "InterceptInfo(path=" + this.path + ", isZip=" + this.kwO + ")";
        AppMethodBeat.o(195779);
        return str;
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class b
      extends kotlin.g.b.q
      implements kotlin.g.a.a<x>
    {
      b(com.tencent.mm.plugin.webview.core.j paramj)
      {
        super();
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class h
    extends kotlin.g.b.q
    implements kotlin.g.a.a<String>
  {
    h(MpWebViewController paramMpWebViewController)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "value", "", "invoke"})
  static final class k
    extends kotlin.g.b.q
    implements kotlin.g.a.b<String, x>
  {
    k(MpWebViewController paramMpWebViewController)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class l
    implements Runnable
  {
    l(MpWebViewController paramMpWebViewController) {}
    
    public final void run()
    {
      AppMethodBeat.i(195798);
      Log.v(MpWebViewController.e(this.pGh), "checkNotifyPageTimer isNotifyPageSuccess=" + this.pGh.pFS + ", isStopCheckNotifyPage=" + this.pGh.pFT);
      if ((!this.pGh.pFS) && (!this.pGh.pFT))
      {
        com.tencent.mm.plugin.webview.h.a.pl(92);
        this.pGh.pFB.pCu = true;
        this.pGh.pFB.pCv = true;
        MpWebViewController.p(this.pGh);
        MpWebViewController.b(this.pGh, MpWebViewController.cpo());
        Log.e(MpWebViewController.e(this.pGh), "check notifyPage timeout");
      }
      AppMethodBeat.o(195798);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$initEnviroment$1", "", "__getString", "", "__log", "", "value", "plugin-brandservice_release"})
  public static final class m
  {
    @android.webkit.JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final String __getString()
    {
      AppMethodBeat.i(195800);
      Object localObject1 = MpWebViewController.g(this.pGh);
      kotlin.g.b.p.h(localObject1, "$this$getContent");
      Object localObject2 = m.pCU;
      localObject1 = com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.b(m.coe(), (String)localObject1);
      if (localObject1 != null)
      {
        localObject2 = com.tencent.mm.vfs.p.an((com.tencent.mm.vfs.o)localObject1);
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = "";
      }
      AppMethodBeat.o(195800);
      return localObject1;
    }
    
    @android.webkit.JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void __log(String paramString)
    {
      AppMethodBeat.i(195799);
      Object localObject = this.pGh;
      if (paramString != null)
      {
        paramString = new JSONObject(paramString).getJSONObject("err");
        if (paramString != null)
        {
          int i = paramString.getInt("errCode");
          paramString = paramString.getString("msg");
          String str = ((MpWebViewController)localObject).getTAG();
          StringBuilder localStringBuilder = new StringBuilder("onWebLog:");
          localObject = ((MpWebViewController)localObject).pFK;
          if (localObject == null) {
            kotlin.g.b.p.btv("contentId");
          }
          Log.e(str, (String)localObject + ',' + i + ',' + paramString);
          com.tencent.mm.plugin.webview.h.a.agi(114);
          AppMethodBeat.o(195799);
          return;
        }
      }
      AppMethodBeat.o(195799);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Lcom/tencent/mm/protocal/JsapiPermissionWrapper;", "handleMsg"})
  static final class n
    implements h.a
  {
    n(MpWebViewController paramMpWebViewController) {}
    
    public final boolean b(com.tencent.mm.plugin.webview.d.n paramn)
    {
      AppMethodBeat.i(195801);
      MpWebViewController localMpWebViewController;
      if (kotlin.g.b.p.j(paramn.mhO, "notifyPageInfo"))
      {
        Log.v(MpWebViewController.e(this.pGh), "handleMsg " + paramn.mhO);
        localMpWebViewController = this.pGh;
        kotlin.g.b.p.g(paramn, "msg");
        MpWebViewController.a(localMpWebViewController, paramn);
        AppMethodBeat.o(195801);
        return true;
      }
      if (kotlin.g.b.p.j(paramn.mhO, "updatePageAuth"))
      {
        Log.v(MpWebViewController.e(this.pGh), "handleMsg " + paramn.mhO);
        localMpWebViewController = this.pGh;
        kotlin.g.b.p.g(paramn, "msg");
        MpWebViewController.b(localMpWebViewController, paramn);
        AppMethodBeat.o(195801);
        return true;
      }
      AppMethodBeat.o(195801);
      return false;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$loadTmpl$InterceptInfo", "", "path", "", "isZip", "", "(Ljava/lang/String;Z)V", "()Z", "getPath", "()Ljava/lang/String;", "component1", "component2", "copy", "(Ljava/lang/String;Z)Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$loadTmpl$InterceptInfo;", "equals", "other", "hashCode", "", "toString", "plugin-brandservice_release"})
  public static final class o
  {
    final boolean kwO;
    final String path;
    
    public o(String paramString)
    {
      AppMethodBeat.i(195802);
      this.path = paramString;
      this.kwO = false;
      AppMethodBeat.o(195802);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(195805);
      if (this != paramObject)
      {
        if ((paramObject instanceof o))
        {
          paramObject = (o)paramObject;
          if ((!kotlin.g.b.p.j(this.path, paramObject.path)) || (this.kwO != paramObject.kwO)) {}
        }
      }
      else
      {
        AppMethodBeat.o(195805);
        return true;
      }
      AppMethodBeat.o(195805);
      return false;
    }
    
    public final int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final String toString()
    {
      AppMethodBeat.i(195803);
      String str = "InterceptInfo(path=" + this.path + ", isZip=" + this.kwO + ")";
      AppMethodBeat.o(195803);
      return str;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"getNotifyPageInfoString", "", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "invoke"})
  static final class p
    extends kotlin.g.b.q
    implements kotlin.g.a.b<com.tencent.mm.plugin.webview.d.n, String>
  {
    public static final p pGl;
    
    static
    {
      AppMethodBeat.i(195808);
      pGl = new p();
      AppMethodBeat.o(195808);
    }
    
    p()
    {
      super();
    }
    
    public static String c(com.tencent.mm.plugin.webview.d.n paramn)
    {
      AppMethodBeat.i(195807);
      kotlin.g.b.p.h(paramn, "msg");
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("performance", (String)paramn.params.get("performance"));
      localJSONObject.put("injectPageDataResult", (String)paramn.params.get("injectPageDataResult"));
      paramn = localJSONObject.toString();
      kotlin.g.b.p.g(paramn, "pageInfo.toString()");
      AppMethodBeat.o(195807);
      return paramn;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "titles", "", "data", "performance", "", "Lkotlin/Pair;", "invoke"})
  static final class r
    extends kotlin.g.b.q
    implements kotlin.g.a.q<String, String, List<? extends kotlin.o<? extends String, ? extends String>>, x>
  {
    r(MpWebViewController paramMpWebViewController)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "titles", "", "data", "performance", "", "Lkotlin/Pair;", "invoke"})
  static final class s
    extends kotlin.g.b.q
    implements kotlin.g.a.q<String, String, List<? extends kotlin.o<? extends String, ? extends String>>, x>
  {
    s(MpWebViewController paramMpWebViewController)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "contextRef", "Ljava/lang/ref/WeakReference;", "", "result", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$MountableCGIResult;", "appMsgContext", "Lcom/tencent/mm/protocal/protobuf/AppMsgContext;", "invoke"})
  static final class t
    extends kotlin.g.b.q
    implements kotlin.g.a.q<WeakReference<Object>, m.c, fn, x>
  {
    t(MpWebViewController paramMpWebViewController)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/protocal/protobuf/PreloadSession;", "invoke"})
  static final class u
    extends kotlin.g.b.q
    implements kotlin.g.a.a<dei>
  {
    u(MpWebViewController paramMpWebViewController, MMWebView paramMMWebView)
    {
      super();
    }
    
    private dei cpr()
    {
      AppMethodBeat.i(195816);
      try
      {
        localObject1 = MpWebViewController.m(this.pGh);
        localObject3 = e.p.OzC;
        kotlin.g.b.p.g(localObject3, "ConstantsUI.WebViewUI.KTmplSession");
        localObject1 = ((Intent)localObject1).getByteArrayExtra((String)localObject3);
        if (localObject1 == null) {
          break label258;
        }
        i = localObject1.length;
        if (i != 0) {
          break label232;
        }
        i = 1;
      }
      catch (Exception localException1)
      {
        dei localdei;
        for (;;)
        {
          try
          {
            Object localObject3 = dei.class.newInstance();
            ((com.tencent.mm.bw.a)localObject3).parseFrom((byte[])localObject1);
            Object localObject1 = (com.tencent.mm.bw.a)localObject3;
            localObject3 = (dei)localObject1;
            localObject1 = localObject3;
            if (localObject3 != null) {
              break;
            }
            localObject1 = (Throwable)new Resources.NotFoundException("TmplSession");
            AppMethodBeat.o(195816);
            throw ((Throwable)localObject1);
          }
          catch (Exception localException2)
          {
            int i;
            Object localObject2;
            Log.printErrStackTrace("Intent.decodeProtoBuffer", (Throwable)localException2, "decode ProtoBuffer", new Object[0]);
          }
          localException1 = localException1;
          Log.e(MpWebViewController.e(this.pGh), "session is null, " + localException1.getMessage() + ' ' + com.tencent.mm.plugin.brandservice.ui.timeline.preload.f.ag(MpWebViewController.m(this.pGh)));
          com.tencent.mm.plugin.webview.h.a.agi(153);
          com.tencent.mm.plugin.report.service.h.CyF.a(17260, new Object[] { Integer.valueOf(2), com.tencent.mm.plugin.brandservice.ui.timeline.preload.f.ag(MpWebViewController.m(this.pGh)) });
          if ((paramMMWebView.getActivityContextIfHas() instanceof Activity))
          {
            localObject2 = paramMMWebView.getActivityContextIfHas();
            if (localObject2 == null)
            {
              localObject2 = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
              AppMethodBeat.o(195816);
              throw ((Throwable)localObject2);
              i = 0;
              continue;
              i = 0;
              continue;
              localdei = null;
            }
            else
            {
              ((Activity)localdei).finish();
            }
          }
          else
          {
            localdei = new dei();
          }
        }
        AppMethodBeat.o(195816);
        return localdei;
      }
      if (i == 0)
      {
        i = 1;
        if (i == 0) {
          break label258;
        }
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "invoke"})
  static final class v
    extends kotlin.g.b.q
    implements kotlin.g.a.b<String, x>
  {
    v(MpWebViewController paramMpWebViewController)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "value", "", "invoke"})
  static final class w
    extends kotlin.g.b.q
    implements kotlin.g.a.b<String, x>
  {
    w(MpWebViewController paramMpWebViewController)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "value", "", "invoke"})
  static final class x
    extends kotlin.g.b.q
    implements kotlin.g.a.b<String, x>
  {
    x(MpWebViewController paramMpWebViewController)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "value", "", "invoke"})
  static final class y
    extends kotlin.g.b.q
    implements kotlin.g.a.b<String, x>
  {
    y(MpWebViewController paramMpWebViewController, long paramLong1, z.a parama, long paramLong2)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "callback"})
  static final class z
    implements IPCRunCgi.a
  {
    z(MpWebViewController paramMpWebViewController, String paramString, com.tencent.mm.plugin.webview.d.n paramn) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.d paramd)
    {
      AppMethodBeat.i(195821);
      MpWebViewController.h(this.pGh).remove(this.pGq);
      kotlin.g.b.p.g(paramd, "rr");
      if (!(paramd.aYK() instanceof bhj))
      {
        AppMethodBeat.o(195821);
        return;
      }
      paramString = paramd.aYK();
      if (paramString == null)
      {
        paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetA8KeyResp");
        AppMethodBeat.o(195821);
        throw paramString;
      }
      paramString = (bhj)paramString;
      if (Util.isNullOrNil(paramString.LRH))
      {
        Log.e(MpWebViewController.e(this.pGh), "updatePageAuth fail fullurl is null");
        com.tencent.mm.plugin.webview.h.a.pl(82);
        paramString = this.pGh.getJsapi();
        if (paramString != null)
        {
          paramString.h(this.pGr.ISe, this.pGr.mhO + ":fail", null);
          AppMethodBeat.o(195821);
          return;
        }
        AppMethodBeat.o(195821);
        return;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        try
        {
          paramd = new JsapiPermissionWrapper(com.tencent.mm.platformtools.z.a(paramString.LRQ));
          Object localObject = new GeneralControlWrapper(paramString.LRK);
          this.pGh.mHi.a(paramString.LRH, paramd, (GeneralControlWrapper)localObject);
          paramd = this.pGh;
          localObject = this.pGq;
          String str = paramString.LRH;
          kotlin.g.b.p.g(str, "resp.FullURL");
          Map localMap = com.tencent.mm.plugin.webview.f.c.ij((List)paramString.LRq);
          kotlin.g.b.p.g(localMap, "LuggageGetA8Key.getHttpHeaders(resp.HttpHeader)");
          MpWebViewController.a(paramd, (String)localObject, str, localMap);
          com.tencent.mm.plugin.webview.h.a.agi(109);
          paramd = (Map)new HashMap();
          paramString = paramString.LRH;
          kotlin.g.b.p.g(paramString, "resp.FullURL");
          paramd.put("fullUrl", paramString);
          Log.i(MpWebViewController.e(this.pGh), "updatePageAuth values:%s", new Object[] { paramd });
          com.tencent.mm.plugin.webview.h.a.pl(81);
          paramString = this.pGh.getJsapi();
          if (paramString != null)
          {
            paramString.h(this.pGr.ISe, this.pGr.mhO + ":ok", paramd);
            AppMethodBeat.o(195821);
            return;
          }
        }
        catch (Exception paramString)
        {
          com.tencent.mm.plugin.webview.h.a.pl(82);
          paramString = this.pGh.getJsapi();
          if (paramString != null)
          {
            paramString.h(this.pGr.ISe, this.pGr.mhO + ":fail", null);
            AppMethodBeat.o(195821);
            return;
            AppMethodBeat.o(195821);
            return;
          }
          AppMethodBeat.o(195821);
          return;
        }
      }
      com.tencent.mm.plugin.webview.h.a.pl(82);
      paramString = this.pGh.getJsapi();
      if (paramString != null)
      {
        paramString.h(this.pGr.ISe, this.pGr.mhO + ":fail", null);
        AppMethodBeat.o(195821);
        return;
      }
      AppMethodBeat.o(195821);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.MpWebViewController
 * JD-Core Version:    0.7.0.1
 */