package com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources.NotFoundException;
import android.net.Uri;
import android.os.Process;
import androidx.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.kernel.b.g.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.UrlExKt;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.j.a;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.m.c;
import com.tencent.mm.plugin.webview.core.BaseWebViewController;
import com.tencent.mm.plugin.webview.core.BaseWebViewController.ControllerAction;
import com.tencent.mm.plugin.webview.core.BaseWebViewController.c;
import com.tencent.mm.plugin.webview.core.BaseWebViewController.f;
import com.tencent.mm.plugin.webview.core.k.a;
import com.tencent.mm.plugin.webview.d.h.a;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.bot;
import com.tencent.mm.protocal.protobuf.dny;
import com.tencent.mm.protocal.protobuf.ese;
import com.tencent.mm.protocal.protobuf.fh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMSlotKt;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.ui.f.r;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.vfs.r;
import com.tencent.mm.vfs.u;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.c;
import com.tencent.xweb.aa;
import com.tencent.xweb.ai;
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
import kotlin.ResultKt;
import kotlin.g.b.aa.a;
import kotlin.g.b.ab;
import kotlin.l;
import kotlin.o;
import kotlin.t;
import kotlin.x;
import kotlinx.coroutines.ak;
import kotlinx.coroutines.aw;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController;", "Lcom/tencent/mm/plugin/webview/core/WebViewController;", "tmplParams", "Lcom/tencent/mm/protocal/protobuf/TmplParams;", "viewWV", "Lcom/tencent/mm/ui/widget/MMWebView;", "(Lcom/tencent/mm/protocal/protobuf/TmplParams;Lcom/tencent/mm/ui/widget/MMWebView;)V", "API", "", "MPWC_TAG", "getMPWC_TAG", "()Ljava/lang/String;", "MPWC_TAG$delegate", "Lkotlin/Lazy;", "TIMEOUT_TIME", "", "getTIMEOUT_TIME", "()J", "actionsCheckList", "", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$WebEvent;", "getActionsCheckList", "()Ljava/util/List;", "canFinishProgress", "", "getCanFinishProgress", "()Z", "checkNotifyPageTimer", "Ljava/lang/Runnable;", "contentId", "fullUrl", "gettingA8KeyUrl", "Ljava/util/HashSet;", "injectAPI", "isCheckingInject", "<set-?>", "isInjectDataSuccess", "isNotifyPageSuccess", "setNotifyPageSuccess", "(Z)V", "isStopCheckNotifyPage", "setStopCheckNotifyPage", "isTmplReady", "isUseDataCache", "setUseDataCache", "kv15862", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/Kv15862;", "getKv15862", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/Kv15862;", "preloadNext", "getPreloadNext", "setPreloadNext", "rawUrl", "getRawUrl", "receivePageData", "getReceivePageData", "setReceivePageData", "(J)V", "recodeInject", "session", "Lcom/tencent/mm/protocal/protobuf/PreloadSession;", "getSession", "()Lcom/tencent/mm/protocal/protobuf/PreloadSession;", "session$delegate", "startGetPageData", "getStartGetPageData", "setStartGetPageData", "startLoadPage", "getStartLoadPage", "setStartLoadPage", "adjustInnerWidth", "", "canHandleUrl", "url", "cancelReport", "checkInject", "checkNotifyPage", "getLogAPI", "value", "initEnviroment", "isPageCached", "isSameStart", "intent", "Landroid/content/Intent;", "loadForceUrl", "forceUrl", "fullScreen", "loadTmpl", "modifyForceUrl", "needSyncGetA8Key", "notifyPageInfo", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "pageInfo", "onError", "reason", "", "reqUrl", "errType", "errCode", "errMsg", "onPageFinished", "view", "Lcom/tencent/xweb/WebView;", "onPermissionUpdate", "response", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyResp;", "onStartLoad", "onWebLog", "processCommonGetA8KeyFullUrl", "httpHeader", "", "processData", "processGetAppContext", "result", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$MountableCGIResult;", "appMsgContext", "Lcom/tencent/mm/protocal/protobuf/AppMsgContext;", "processReport", "setMpUrl", "startAuth", "force", "stopCheckNotifyPage", "tryPreloadNextWebView", "updateAuth", "isSuccess", "updateData", "updateKV", "updatePageAuth", "validCommitUrl", "validStartUrl", "waitForInject", "waitForReady", "Companion", "ForceUrl", "MpWebViewInterceptor", "NotifyAuth", "PreloadNext", "StartPreload", "UpdateData", "plugin-brandservice_release"})
public final class MpWebViewController
  extends com.tencent.mm.plugin.webview.core.i
{
  private static final int sRj = -101;
  static final int sRk = -102;
  private static final int sRl = -103;
  private static final int sRm = -111;
  private static final int sRn = -112;
  private static final int sRo = -113;
  private static final int sRp = -121;
  private static final int sRq = -122;
  private static final int sRr = -123;
  private static final int sRs = -124;
  private static final int sRt = -130;
  public static final f sRu;
  private String pHq;
  private final ese sLr;
  private final kotlin.f sQP;
  final com.tencent.mm.plugin.brandservice.ui.timeline.preload.i sQQ;
  private long sQR;
  private long sQS;
  private long sQT;
  private boolean sQU;
  private boolean sQV;
  private final long sQW;
  private final kotlin.f sQX;
  String sQY;
  private boolean sQZ;
  private boolean sRa;
  private final String sRb;
  private final List<BaseWebViewController.f> sRc;
  private final String sRd;
  boolean sRe;
  private final HashSet<String> sRf;
  boolean sRg;
  boolean sRh;
  private final Runnable sRi;
  
  static
  {
    AppMethodBeat.i(264246);
    sRu = new f((byte)0);
    sRj = -101;
    sRk = -102;
    sRl = -103;
    sRm = -111;
    sRn = -112;
    sRo = -113;
    sRp = -121;
    sRq = -122;
    sRr = -123;
    sRs = -124;
    sRt = -130;
    AppMethodBeat.o(264246);
  }
  
  public MpWebViewController(ese paramese, final MMWebView paramMMWebView)
  {
    super(paramMMWebView);
    AppMethodBeat.i(264245);
    this.sLr = paramese;
    this.sQP = kotlin.g.ar((kotlin.g.a.a)new g(this));
    paramese = new com.tencent.mm.plugin.brandservice.ui.timeline.preload.i();
    paramese.a(this.sLr);
    this.sQQ = paramese;
    this.sQU = true;
    this.sQW = 5000L;
    this.sQX = kotlin.g.ar((kotlin.g.a.a)new u(this, paramMMWebView));
    this.sRb = "__tmpl_webview_inject_data";
    if (!(paramMMWebView instanceof a.a)) {}
    for (paramese = null;; paramese = paramMMWebView)
    {
      paramese = (a.a)paramese;
      if (paramese != null)
      {
        paramese.setValidUrlProxy((kotlin.g.a.b)new d(this));
        paramese.setCurrentUrlProxy((kotlin.g.a.a)new e(this));
      }
      paramese = super.cDy();
      paramese.addAll((Collection)kotlin.a.j.listOf(new BaseWebViewController.f[] { new BaseWebViewController.f(ab.bO(UpdateData.class), (kotlin.g.a.a)new i((MpWebViewController)this)), new BaseWebViewController.f(ab.bO(StartPreload.class), (kotlin.g.a.a)new a(this)), new BaseWebViewController.f(ab.bO(PreloadNext.class), (kotlin.g.a.a)new j((MpWebViewController)this)), new BaseWebViewController.f(ab.bO(NotifyAuth.class), (kotlin.g.a.a)new b(this)), new BaseWebViewController.f(ab.bO(ForceUrl.class), (kotlin.g.a.a)new c(this)) }));
      this.sRc = paramese;
      this.sRd = (this.sRb + ".__getString()");
      this.sRf = new HashSet();
      this.sRi = ((Runnable)new l(this));
      AppMethodBeat.o(264245);
      return;
    }
  }
  
  private final void a(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    AppMethodBeat.i(264239);
    Log.i(cDs(), "[updatePageAuth]reqUrl:" + paramString1 + " fullUrl:" + paramString2 + " httpHeader:" + paramMap);
    paramString1 = this.pHS.getSettings();
    kotlin.g.b.p.j(paramString1, "viewWV.settings");
    paramString1 = paramString1.getUserAgentString();
    kotlin.g.b.p.j(paramString1, "viewWV.settings.userAgentString");
    paramMap.put("User-agent", paramString1);
    paramString1 = getJsapi();
    if (paramMap == null)
    {
      paramString1 = new t("null cannot be cast to non-null type kotlin.collections.Map<*, *>");
      AppMethodBeat.o(264239);
      throw paramString1;
    }
    paramString1.bjY(new JSONObject(paramMap).toString());
    paramString1 = Uri.parse(paramString2).getQueryParameter("pass_ticket");
    getJsapi().bjX(paramString1);
    AppMethodBeat.o(264239);
  }
  
  /* Error */
  private final boolean a(com.tencent.mm.plugin.webview.d.n paramn)
  {
    // Byte code:
    //   0: ldc_w 668
    //   3: invokestatic 285	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: getstatic 672	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$p:sRy	Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$p;
    //   9: astore 10
    //   11: aload_1
    //   12: invokestatic 676	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$p:c	(Lcom/tencent/mm/plugin/webview/d/n;)Ljava/lang/String;
    //   15: astore 10
    //   17: aload_0
    //   18: invokevirtual 452	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:cDs	()Ljava/lang/String;
    //   21: ldc_w 678
    //   24: aload 10
    //   26: invokestatic 684	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   29: invokevirtual 687	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   32: invokestatic 470	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   35: new 626	org/json/JSONObject
    //   38: dup
    //   39: aload 10
    //   41: invokespecial 688	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   44: astore 10
    //   46: new 626	org/json/JSONObject
    //   49: dup
    //   50: aload 10
    //   52: ldc_w 690
    //   55: invokevirtual 693	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   58: invokespecial 688	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   61: astore 11
    //   63: aload 11
    //   65: ldc_w 695
    //   68: invokevirtual 699	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   71: lstore_2
    //   72: aload 11
    //   74: ldc_w 701
    //   77: invokevirtual 699	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   80: lstore 4
    //   82: aload 11
    //   84: ldc_w 703
    //   87: invokevirtual 699	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   90: lstore 6
    //   92: aload 11
    //   94: ldc_w 705
    //   97: invokevirtual 699	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   100: lstore 8
    //   102: aload_0
    //   103: getfield 709	com/tencent/mm/plugin/webview/core/BaseWebViewController:PFY	Lcom/tencent/mm/plugin/webview/k/n;
    //   106: ldc_w 703
    //   109: lload 6
    //   111: invokevirtual 715	com/tencent/mm/plugin/webview/k/n:bU	(Ljava/lang/String;J)V
    //   114: aload_0
    //   115: getfield 709	com/tencent/mm/plugin/webview/core/BaseWebViewController:PFY	Lcom/tencent/mm/plugin/webview/k/n;
    //   118: ldc_w 705
    //   121: lload 8
    //   123: invokevirtual 715	com/tencent/mm/plugin/webview/k/n:bU	(Ljava/lang/String;J)V
    //   126: aload_0
    //   127: getfield 353	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:sQQ	Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/i;
    //   130: lload_2
    //   131: putfield 718	com/tencent/mm/plugin/brandservice/ui/timeline/preload/i:sLC	J
    //   134: aload_0
    //   135: getfield 353	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:sQQ	Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/i;
    //   138: lload 4
    //   140: putfield 721	com/tencent/mm/plugin/brandservice/ui/timeline/preload/i:sLD	J
    //   143: aload_0
    //   144: getfield 353	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:sQQ	Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/i;
    //   147: lload 6
    //   149: putfield 724	com/tencent/mm/plugin/brandservice/ui/timeline/preload/i:sLz	J
    //   152: aload_0
    //   153: getfield 353	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:sQQ	Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/i;
    //   156: lload 8
    //   158: putfield 727	com/tencent/mm/plugin/brandservice/ui/timeline/preload/i:sLB	J
    //   161: aload 10
    //   163: ldc_w 729
    //   166: ldc_w 731
    //   169: invokevirtual 734	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   172: ldc_w 736
    //   175: invokestatic 739	kotlin/g/b/p:h	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   178: ifeq +122 -> 300
    //   181: aload_0
    //   182: iconst_1
    //   183: putfield 741	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:sRg	Z
    //   186: aload_0
    //   187: getfield 353	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:sQQ	Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/i;
    //   190: iconst_1
    //   191: putfield 744	com/tencent/mm/plugin/brandservice/ui/timeline/preload/i:sMr	Z
    //   194: aload_0
    //   195: getfield 353	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:sQQ	Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/i;
    //   198: new 65	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$r
    //   201: dup
    //   202: aload_0
    //   203: invokespecial 745	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$r:<init>	(Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController;)V
    //   206: checkcast 747	kotlin/g/a/q
    //   209: invokevirtual 750	com/tencent/mm/plugin/brandservice/ui/timeline/preload/i:b	(Lkotlin/g/a/q;)V
    //   212: aload_0
    //   213: getfield 331	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:sLr	Lcom/tencent/mm/protocal/protobuf/ese;
    //   216: getfield 475	com/tencent/mm/protocal/protobuf/ese:reportId	I
    //   219: sipush 131
    //   222: invokestatic 483	com/tencent/mm/plugin/webview/h/a:gU	(II)V
    //   225: bipush 108
    //   227: invokestatic 753	com/tencent/mm/plugin/webview/h/a:anX	(I)V
    //   230: aload_0
    //   231: getfield 353	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:sQQ	Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/i;
    //   234: invokestatic 508	com/tencent/mm/sdk/platformtools/MMSlotKt:now	()J
    //   237: putfield 756	com/tencent/mm/plugin/brandservice/ui/timeline/preload/i:sLR	J
    //   240: aload_0
    //   241: invokespecial 566	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:cDC	()V
    //   244: aload_0
    //   245: invokespecial 759	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:cDB	()V
    //   248: aload_0
    //   249: invokevirtual 619	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:getJsapi	()Lcom/tencent/mm/plugin/webview/d/h;
    //   252: aload_1
    //   253: getfield 764	com/tencent/mm/plugin/webview/d/n:POu	Ljava/lang/String;
    //   256: ldc_w 766
    //   259: aconst_null
    //   260: invokevirtual 768	com/tencent/mm/plugin/webview/d/h:h	(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V
    //   263: bipush 90
    //   265: invokestatic 771	com/tencent/mm/plugin/webview/h/a:rE	(I)V
    //   268: getstatic 777	kotlinx/coroutines/br:abxo	Lkotlinx/coroutines/br;
    //   271: checkcast 779	kotlinx/coroutines/ak
    //   274: aconst_null
    //   275: new 63	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$q
    //   278: dup
    //   279: aload_0
    //   280: aconst_null
    //   281: invokespecial 782	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$q:<init>	(Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController;Lkotlin/d/d;)V
    //   284: checkcast 784	kotlin/g/a/m
    //   287: iconst_3
    //   288: invokestatic 789	kotlinx/coroutines/g:b	(Lkotlinx/coroutines/ak;Lkotlin/d/f;Lkotlin/g/a/m;I)Lkotlinx/coroutines/by;
    //   291: pop
    //   292: ldc_w 668
    //   295: invokestatic 315	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   298: iconst_1
    //   299: ireturn
    //   300: aload_0
    //   301: getfield 353	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:sQQ	Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/i;
    //   304: iconst_1
    //   305: putfield 563	com/tencent/mm/plugin/brandservice/ui/timeline/preload/i:sMG	Z
    //   308: aload_0
    //   309: getstatic 311	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:sRs	I
    //   312: invokevirtual 792	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:anv	(I)V
    //   315: aload_0
    //   316: invokevirtual 452	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:cDs	()Ljava/lang/String;
    //   319: ldc_w 794
    //   322: invokestatic 470	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   325: goto -95 -> 230
    //   328: astore 10
    //   330: aload_0
    //   331: invokevirtual 452	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:cDs	()Ljava/lang/String;
    //   334: aload 10
    //   336: checkcast 796	java/lang/Throwable
    //   339: ldc_w 797
    //   342: iconst_0
    //   343: anewarray 799	java/lang/Object
    //   346: invokestatic 803	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   349: aload_0
    //   350: getfield 353	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:sQQ	Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/i;
    //   353: iconst_1
    //   354: putfield 563	com/tencent/mm/plugin/brandservice/ui/timeline/preload/i:sMG	Z
    //   357: aload_0
    //   358: getstatic 311	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:sRs	I
    //   361: invokevirtual 792	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:anv	(I)V
    //   364: goto -134 -> 230
    //   367: astore 10
    //   369: aload_0
    //   370: invokevirtual 452	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:cDs	()Ljava/lang/String;
    //   373: aload 10
    //   375: checkcast 796	java/lang/Throwable
    //   378: ldc_w 804
    //   381: iconst_0
    //   382: anewarray 799	java/lang/Object
    //   385: invokestatic 803	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   388: aload_0
    //   389: invokevirtual 619	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:getJsapi	()Lcom/tencent/mm/plugin/webview/d/h;
    //   392: aload_1
    //   393: getfield 764	com/tencent/mm/plugin/webview/d/n:POu	Ljava/lang/String;
    //   396: ldc_w 806
    //   399: aconst_null
    //   400: invokevirtual 768	com/tencent/mm/plugin/webview/d/h:h	(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V
    //   403: bipush 91
    //   405: invokestatic 771	com/tencent/mm/plugin/webview/h/a:rE	(I)V
    //   408: ldc_w 668
    //   411: invokestatic 315	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   414: iconst_0
    //   415: ireturn
    //   416: astore 10
    //   418: aload_0
    //   419: invokevirtual 452	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:cDs	()Ljava/lang/String;
    //   422: aload 10
    //   424: checkcast 796	java/lang/Throwable
    //   427: ldc_w 804
    //   430: iconst_0
    //   431: anewarray 799	java/lang/Object
    //   434: invokestatic 803	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
  
  private final void aqo(String paramString)
  {
    AppMethodBeat.i(264233);
    this.PFK = paramString;
    bjo(paramString);
    bjp(paramString);
    bjm(paramString);
    AppMethodBeat.o(264233);
  }
  
  private void aqp(String paramString)
  {
    AppMethodBeat.i(264240);
    kotlin.g.b.p.k(paramString, "forceUrl");
    cDB();
    j.a locala = com.tencent.mm.plugin.brandservice.ui.timeline.preload.j.sMO;
    if (j.a.cCg())
    {
      AppMethodBeat.o(264240);
      return;
    }
    gSz();
    this.PGd = true;
    n(aqq(paramString), true, 8);
    AppMethodBeat.o(264240);
  }
  
  private static String aqq(String paramString)
  {
    AppMethodBeat.i(264242);
    paramString = UrlExKt.appendUrlParam(UrlExKt.clearUrlParam$default(UrlExKt.clearUrlParam$default(UrlExKt.clearUrlParam$default(paramString, "fasttmpl_flag", false, 2, null), "fasttmpl_type", false, 2, null), "fasttmpl_fullversion", false, 2, null), "forceh5", "1");
    AppMethodBeat.o(264242);
    return paramString;
  }
  
  private final void cDB()
  {
    AppMethodBeat.i(264231);
    Log.d(cDs(), "stopCheckNotifyPage");
    btS().removeCallbacks(this.sRi);
    this.sRh = true;
    AppMethodBeat.o(264231);
  }
  
  private final void cDC()
  {
    AppMethodBeat.i(264232);
    Log.v(cDs(), "terry trace updateKV");
    this.sQQ.sLM = this.PFY.bV("onInjectStart", 0L);
    this.sQQ.sLN = this.PFY.bV("onInjectEnd", 0L);
    this.sQQ.sLP = this.PFY.bV("onTmplLoadStart", 0L);
    this.sQQ.sLQ = this.PFY.bV("onTmplLoadEnd", 0L);
    this.sQQ.sLK = this.PFY.bV("onCreateStart", 0L);
    this.sQQ.sLL = this.PFY.bV("onCreateEnd", 0L);
    this.sQQ.sMi = this.sRe;
    this.sQQ.sLO = this.PFY.bV("onWebInjectEnd", 0L);
    com.tencent.mm.plugin.brandservice.ui.timeline.preload.i locali = this.sQQ;
    String str = this.pHS.getRandomStr();
    kotlin.g.b.p.j(str, "viewWV.randomStr");
    locali.setKey(str);
    this.sQQ.sMj = anw(sRk);
    AppMethodBeat.o(264232);
  }
  
  private dny cDt()
  {
    AppMethodBeat.i(264199);
    dny localdny = (dny)this.sQX.getValue();
    AppMethodBeat.o(264199);
    return localdny;
  }
  
  private void s(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(264234);
    kotlin.g.b.p.k(paramString, "contentId");
    Log.v(cDs(), "[updateData] " + cDu());
    com.tencent.mm.plugin.brandservice.ui.timeline.preload.m.apV(cDu());
    aqo(cDu());
    this.sQY = paramString;
    this.sQR = paramLong1;
    this.sQT = paramLong2;
    anv(sRm);
    AppMethodBeat.o(264234);
  }
  
  public final void a(int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2)
  {
    AppMethodBeat.i(264238);
    kotlin.g.b.p.k(paramString1, "reqUrl");
    kotlin.g.b.p.k(paramString2, "errMsg");
    super.a(paramInt1, paramString1, paramInt2, paramInt3, paramString2);
    if (paramInt1 == 0)
    {
      this.pHq = paramString1;
      anv(sRq);
    }
    AppMethodBeat.o(264238);
  }
  
  public final void a(int paramInt, String paramString1, String paramString2, bot parambot)
  {
    AppMethodBeat.i(264235);
    kotlin.g.b.p.k(paramString1, "reqUrl");
    kotlin.g.b.p.k(paramString2, "fullUrl");
    kotlin.g.b.p.k(parambot, "response");
    if (paramInt == 0) {
      aqo(paramString2);
    }
    super.a(paramInt, paramString1, paramString2, parambot);
    if (paramInt == 0)
    {
      this.pHq = paramString2;
      parambot = com.tencent.mm.plugin.webview.f.c.iZ((List)parambot.SZV);
      kotlin.g.b.p.j(parambot, "LuggageGetA8Key.getHttpH…ders(response.HttpHeader)");
      com.tencent.mm.plugin.webview.h.a.gU(this.sLr.reportId, 117);
      this.sQQ.sLJ = MMSlotKt.now();
      this.sQQ.sMq = true;
      cDC();
      this.sQQ.b((kotlin.g.a.q)new s(this));
      a(paramString1, paramString2, parambot);
      anv(sRp);
    }
    AppMethodBeat.o(264235);
  }
  
  public final boolean aM(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(264224);
    kotlin.g.b.p.k(paramString, "url");
    if (((kotlin.g.b.p.h(paramString, this.sLr.POG) ^ true)) && (super.aM(paramString, paramBoolean)))
    {
      AppMethodBeat.o(264224);
      return true;
    }
    AppMethodBeat.o(264224);
    return false;
  }
  
  public final boolean aql(String paramString)
  {
    AppMethodBeat.i(264215);
    kotlin.g.b.p.k(paramString, "url");
    if ((super.aqm(paramString)) && ((kotlin.g.b.p.h(paramString, this.sLr.POG) ^ true)))
    {
      AppMethodBeat.o(264215);
      return true;
    }
    AppMethodBeat.o(264215);
    return false;
  }
  
  public final boolean aqm(String paramString)
  {
    AppMethodBeat.i(264217);
    kotlin.g.b.p.k(paramString, "url");
    if ((super.aqm(paramString)) && ((kotlin.g.b.p.h(paramString, this.sLr.POG) ^ true)))
    {
      AppMethodBeat.o(264217);
      return true;
    }
    AppMethodBeat.o(264217);
    return false;
  }
  
  public final boolean aqn(String paramString)
  {
    AppMethodBeat.i(264223);
    if ((kotlin.g.b.p.h(paramString, this.sLr.POG)) || ((paramString != null) && (kotlin.n.n.M(paramString, "file://", false) == true)))
    {
      AppMethodBeat.o(264223);
      return true;
    }
    AppMethodBeat.o(264223);
    return false;
  }
  
  public final void b(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(264225);
    super.b(paramWebView, paramString);
    if (kotlin.g.b.p.h(paramString, this.sLr.POG))
    {
      if ((anw(sRk)) || (anw(sRj)))
      {
        AppMethodBeat.o(264225);
        return;
      }
      Log.i(cDs(), "checkInject start");
      com.tencent.mm.plugin.webview.h.a.gU(this.sLr.reportId, 113);
      p("JSON.stringify(window.__appmsg_skeleton_success__)", (kotlin.g.a.b)new k(this));
      int i = com.tencent.mm.ci.a.kr(this.pHS.getContext());
      float f = com.tencent.mm.ci.a.getDensity(this.pHS.getContext());
      Log.i(cDs(), "adjustInnerWidth() screenWidth:" + i + ", density:" + f);
      if ((i > 0) && (f > 0.0F))
      {
        i = (int)(i / f);
        Log.i(cDs(), "adjustInnerWidth() innerWidth:".concat(String.valueOf(i)));
        p("window.innerWidth = ".concat(String.valueOf(i)), null);
      }
      Log.i(cDs(), "[onPageReady]");
    }
    AppMethodBeat.o(264225);
  }
  
  public final void bXH()
  {
    AppMethodBeat.i(264212);
    a((com.tencent.mm.plugin.webview.core.k)new h(this.sLr, this.pHS));
    super.bXH();
    this.pHS.addJavascriptInterface(new m(this), this.sRb);
    getJsapi().gTL();
    getJsapi().a((h.a)new n(this));
    String str = this.sLr.POG;
    Log.i(cDs(), "WebView-Trace loadTmpl getResourceResponse, requrl:%s, url:%s", new Object[] { str, this.sLr.UtX });
    Object localObject = this.sLr.UtX;
    kotlin.g.b.p.j(localObject, "tmplParams.initFilePath");
    localObject = new o((String)localObject);
    Log.v(cDs(), "response path:" + Util.nullAs(((o)localObject).path, "null"));
    if (f.g((WebView)this.pHS, ((o)localObject).path) != null)
    {
      Log.i(cDs(), "return intercepted success");
      anv(this.PGk);
      this.pHS.loadUrl(str);
      anv(this.PGj);
      AppMethodBeat.o(264212);
      return;
    }
    Log.e(cDs(), "return intercepted null");
    com.tencent.mm.plugin.webview.h.a.gU(this.sLr.reportId, 126);
    if (((o)localObject).npI) {
      com.tencent.mm.plugin.webview.h.a.gU(this.sLr.reportId, 233);
    }
    AppMethodBeat.o(264212);
  }
  
  public final boolean cDA()
  {
    return false;
  }
  
  public final boolean cDD()
  {
    AppMethodBeat.i(264237);
    boolean bool = anw(this.PGj);
    AppMethodBeat.o(264237);
    return bool;
  }
  
  final String cDs()
  {
    AppMethodBeat.i(264194);
    String str = (String)this.sQP.getValue();
    AppMethodBeat.o(264194);
    return str;
  }
  
  public final String cDu()
  {
    AppMethodBeat.i(264201);
    String str = kotlin.n.n.bx(BaseWebViewController.c.bk(getIntent()), "http://", "https://");
    AppMethodBeat.o(264201);
    return str;
  }
  
  public final boolean cDv()
  {
    AppMethodBeat.i(264203);
    if ((anw(sRn)) || (anw(sRo)))
    {
      AppMethodBeat.o(264203);
      return true;
    }
    AppMethodBeat.o(264203);
    return false;
  }
  
  public final boolean cDw()
  {
    AppMethodBeat.i(264205);
    if ((anw(this.PGj)) && (anw(sRk)))
    {
      AppMethodBeat.o(264205);
      return true;
    }
    AppMethodBeat.o(264205);
    return false;
  }
  
  public final boolean cDx()
  {
    AppMethodBeat.i(264207);
    if ((gSt()) && (anw(sRp)))
    {
      AppMethodBeat.o(264207);
      return true;
    }
    AppMethodBeat.o(264207);
    return false;
  }
  
  public final List<BaseWebViewController.f> cDy()
  {
    return this.sRc;
  }
  
  public final void cDz()
  {
    int j = 1;
    AppMethodBeat.i(264221);
    Log.i(cDs(), "onStartLoad");
    Object localObject1 = getIntent();
    kotlin.g.b.p.k(localObject1, "intent");
    Log.v(cDs(), "processData");
    setIntent((Intent)localObject1);
    this.sQS = MMSlotKt.now();
    this.sQU = ((Intent)localObject1).getBooleanExtra(f.r.VSF, true);
    this.sQR = ((Intent)localObject1).getLongExtra(f.r.VSG, 0L);
    Object localObject2 = com.tencent.mm.kernel.h.aHD().aHf();
    kotlin.g.b.p.j(localObject2, "MMKernel.process().current()");
    localObject2 = ((com.tencent.mm.kernel.b.h)localObject2).aID();
    String str = ((Intent)localObject1).getStringExtra(f.r.VSI);
    if ((((Intent)localObject1).getStringExtra("rawUrl") == null) || (str == null))
    {
      Log.e(cDs(), "rawUrl is null, " + com.tencent.mm.plugin.brandservice.ui.timeline.preload.f.ae((Intent)localObject1));
      com.tencent.mm.plugin.webview.h.a.anX(151);
      com.tencent.mm.plugin.report.service.h.IzE.a(17260, new Object[] { Integer.valueOf(1), com.tencent.mm.plugin.brandservice.ui.timeline.preload.f.ae((Intent)localObject1) });
      i = 0;
      if (i == 0)
      {
        onFinish();
        AppMethodBeat.o(264221);
      }
    }
    else
    {
      com.tencent.mm.plugin.brandservice.ui.timeline.preload.i locali = this.sQQ;
      if (((g.a)localObject2).kfu < this.sQR)
      {
        bool = true;
        label233:
        locali.sMo = bool;
        if (!this.sQQ.sMo) {
          break label541;
        }
        i = 104;
        label252:
        com.tencent.mm.plugin.webview.h.a.anX(i);
        switch (com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.a(((Intent)localObject1).getIntExtra(f.r.VSN, -1), this.sQR, Process.myPid(), ((g.a)localObject2).kfm))
        {
        }
      }
      for (;;)
      {
        this.sQQ.npI = cDt().TVi;
        this.sQQ.sMl = cDt().TVj;
        this.sQQ.sMm = com.tencent.mm.plugin.webview.d.k.c((WebView)this.pHS);
        this.sQQ.sMn = cDt().sMn;
        this.sQQ.sLX = ((g.a)localObject2).kfm;
        this.sQQ.sLY = ((g.a)localObject2).kfn;
        this.sQQ.sLZ = ((g.a)localObject2).kfo;
        this.sQQ.sMa = ((g.a)localObject2).kfp;
        this.sQQ.sMb = ((g.a)localObject2).kfq;
        this.sQQ.sMc = ((g.a)localObject2).kfr;
        this.sQQ.sMd = ((g.a)localObject2).kfs;
        this.sQQ.sMe = ((g.a)localObject2).kft;
        this.sQQ.sMf = ((g.a)localObject2).kfu;
        this.sQQ.sLy = this.sQR;
        this.sQQ.sLE = this.sQS;
        this.sQQ.svv = cDt().svv;
        com.tencent.mm.plugin.brandservice.ui.timeline.preload.m.sNg.a(this, str, cDt(), (kotlin.g.a.q)new t(this));
        i = j;
        break;
        bool = false;
        break label233;
        label541:
        i = 103;
        break label252;
        this.sQQ.sMp = 1;
        this.sQR = ((g.a)localObject2).kfm;
        continue;
        this.sQQ.sMp = 2;
        this.sQR = -1L;
      }
    }
    this.sQQ.a(this.sLr);
    localObject1 = this.sQQ;
    localObject2 = cDu();
    kotlin.g.b.p.k(localObject2, "<set-?>");
    ((com.tencent.mm.plugin.brandservice.ui.timeline.preload.i)localObject1).url = ((String)localObject2);
    boolean bool = anw(sRk);
    this.sQQ.sMh = bool;
    this.sQQ.sMg = this.sQV;
    this.sQQ.sME = this.pHS.getWebCoreType().name();
    if (bool) {}
    for (int i = 106;; i = 105)
    {
      com.tencent.mm.plugin.webview.h.a.anX(i);
      BaseWebViewController.a(this, cDu());
      if (!this.sRg)
      {
        cDB();
        Log.i(cDs(), "check notifyPage");
        this.sRh = false;
        btS().postUIDelayed(this.sRi, this.sQW);
      }
      AppMethodBeat.o(264221);
      return;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$ForceUrl;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$ControllerAction;", "()V", "verify", "", "plugin-brandservice_release"})
  @Keep
  protected static final class ForceUrl
    extends BaseWebViewController.ControllerAction
  {
    public final boolean verify()
    {
      AppMethodBeat.i(266167);
      Object localObject = getController();
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.MpWebViewController");
        AppMethodBeat.o(266167);
        throw ((Throwable)localObject);
      }
      localObject = (MpWebViewController)localObject;
      MpWebViewController.f localf = MpWebViewController.sRu;
      if (((waitFor(MpWebViewController.cDM())) || (waitFor(MpWebViewController.cDJ())) || (waitFor(MpWebViewController.cDK()))) && (waitFor(MpWebViewController.b((MpWebViewController)localObject))))
      {
        AppMethodBeat.o(266167);
        return true;
      }
      AppMethodBeat.o(266167);
      return false;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$NotifyAuth;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$ControllerAction;", "()V", "verify", "", "plugin-brandservice_release"})
  @Keep
  protected static final class NotifyAuth
    extends BaseWebViewController.ControllerAction
  {
    public final boolean verify()
    {
      AppMethodBeat.i(265087);
      Object localObject = getController();
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.MpWebViewController");
        AppMethodBeat.o(265087);
        throw ((Throwable)localObject);
      }
      localObject = (MpWebViewController)localObject;
      if ((waitFor(MpWebViewController.cDE())) && (((waitFor(MpWebViewController.a((MpWebViewController)localObject))) && (waitFor(MpWebViewController.cDG()))) || (waitFor(MpWebViewController.cDH()))))
      {
        AppMethodBeat.o(265087);
        return true;
      }
      AppMethodBeat.o(265087);
      return false;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$PreloadNext;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$ControllerAction;", "()V", "verify", "", "plugin-brandservice_release"})
  @Keep
  protected static final class PreloadNext
    extends BaseWebViewController.ControllerAction
  {
    public final boolean verify()
    {
      AppMethodBeat.i(263088);
      if (getController() == null)
      {
        t localt = new t("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.MpWebViewController");
        AppMethodBeat.o(263088);
        throw localt;
      }
      boolean bool = waitFor(MpWebViewController.cDI());
      AppMethodBeat.o(263088);
      return bool;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$StartPreload;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$ControllerAction;", "()V", "verify", "", "plugin-brandservice_release"})
  @Keep
  protected static final class StartPreload
    extends BaseWebViewController.ControllerAction
  {
    public final boolean verify()
    {
      AppMethodBeat.i(257336);
      Object localObject = getController();
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.MpWebViewController");
        AppMethodBeat.o(257336);
        throw ((Throwable)localObject);
      }
      boolean bool = waitFor(MpWebViewController.b((MpWebViewController)localObject));
      AppMethodBeat.o(257336);
      return bool;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$UpdateData;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$ControllerAction;", "()V", "verify", "", "plugin-brandservice_release"})
  @Keep
  protected static final class UpdateData
    extends BaseWebViewController.ControllerAction
  {
    public final boolean verify()
    {
      AppMethodBeat.i(265107);
      if (getController() == null)
      {
        t localt = new t("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.MpWebViewController");
        AppMethodBeat.o(265107);
        throw localt;
      }
      if ((waitFor(MpWebViewController.cDE())) && (waitFor(MpWebViewController.cDF())))
      {
        AppMethodBeat.o(265107);
        return true;
      }
      AppMethodBeat.o(265107);
      return false;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$actionsCheckList$1$2"})
  static final class a
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    a(MpWebViewController paramMpWebViewController)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$actionsCheckList$1$4"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    b(MpWebViewController paramMpWebViewController)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$actionsCheckList$1$5"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    c(MpWebViewController paramMpWebViewController)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "invoke", "com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$1$1"})
  static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.b<String, Boolean>
  {
    d(MpWebViewController paramMpWebViewController)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$1$2"})
  static final class e
    extends kotlin.g.b.q
    implements kotlin.g.a.a<String>
  {
    e(MpWebViewController paramMpWebViewController)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$Companion;", "", "()V", "MP_AUTH_ERR", "", "MP_AUTH_NOTIFIED", "MP_AUTH_SUCC", "MP_DATA_INJECT_ERR", "MP_DATA_INJECT_SUCC", "MP_DATA_READY", "MP_NOTIFY_ERR", "MP_PRELOAD_NEXT", "MP_TMPL_CHECKING", "MP_TMPL_ERR", "getMP_TMPL_ERR$plugin_brandservice_release", "()I", "MP_TMPL_READY", "readFileWebResp", "Lcom/tencent/xweb/WebResourceResponse;", "webview", "Lcom/tencent/xweb/WebView;", "fileName", "", "plugin-brandservice_release"})
  public static final class f
  {
    static WebResourceResponse g(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(264467);
      if (!u.agG(paramString))
      {
        Log.e("MicroMsg.WebViewController", "tmpl file not found:".concat(String.valueOf(paramString)));
        AppMethodBeat.o(264467);
        return null;
      }
      Object localObject1 = MimeTypeUtil.getMimeTypeByFilePath(paramString);
      Object localObject2;
      if ((kotlin.n.n.pu(paramString, ".js")) && (com.tencent.mm.plugin.webview.d.k.c(paramWebView)))
      {
        paramWebView = new ai(3, 256, paramWebView);
        paramWebView.bFn(paramString);
        paramWebView = paramWebView.toString();
        localObject2 = StandardCharsets.UTF_8;
        kotlin.g.b.p.j(localObject2, "StandardCharsets.UTF_8");
        if (paramWebView == null)
        {
          paramWebView = new t("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(264467);
          throw paramWebView;
        }
        localObject2 = paramWebView.getBytes((Charset)localObject2);
        kotlin.g.b.p.j(localObject2, "(this as java.lang.String).getBytes(charset)");
        localObject1 = new WebResourceResponse((String)localObject1, "UTF-8", (InputStream)new ByteArrayInputStream((byte[])localObject2));
      }
      for (;;)
      {
        localObject2 = new HashMap();
        str = Integer.toHexString(paramString.hashCode() & 0xFFFFFFFF);
        kotlin.g.b.p.j(str, "Integer.toHexString(file…Code() and (-1).ushr(32))");
        if (str != null) {
          break;
        }
        paramWebView = new t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(264467);
        throw paramWebView;
        try
        {
          paramWebView = (InputStream)new FileInputStream(paramString);
          if (paramWebView == null)
          {
            Log.e("MicroMsg.WebViewController", "stream is null, err");
            AppMethodBeat.o(264467);
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
      kotlin.g.b.p.j(str, "(this as java.lang.String).toLowerCase()");
      ((Map)localObject2).put("Cache-Control", "max-age=31536000");
      ((Map)localObject2).put("ETag", str);
      if (paramWebView != null) {
        ((Map)localObject2).put("RunLocalJS", paramWebView);
      }
      ((WebResourceResponse)localObject1).setResponseHeaders((Map)localObject2);
      Log.i("MicroMsg.WebViewController", "readFileWebResp:%s\nETag:%s", new Object[] { paramString, str });
      AppMethodBeat.o(264467);
      return localObject1;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class g
    extends kotlin.g.b.q
    implements kotlin.g.a.a<String>
  {
    g(MpWebViewController paramMpWebViewController)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$MpWebViewInterceptor;", "Lcom/tencent/mm/plugin/webview/core/WebViewInterceptor;", "tmplParams", "Lcom/tencent/mm/protocal/protobuf/TmplParams;", "viewWV", "Lcom/tencent/mm/ui/widget/MMWebView;", "(Lcom/tencent/mm/protocal/protobuf/TmplParams;Lcom/tencent/mm/ui/widget/MMWebView;)V", "getTmplParams", "()Lcom/tencent/mm/protocal/protobuf/TmplParams;", "getViewWV", "()Lcom/tencent/mm/ui/widget/MMWebView;", "intercept", "Lcom/tencent/xweb/WebResourceResponse;", "webview", "Lcom/tencent/xweb/WebView;", "request", "Lcom/tencent/xweb/WebResourceRequest;", "overrideReload", "", "url", "", "overrideUrl", "Lcom/tencent/mm/plugin/webview/core/WebViewInterceptor$OverrideUrlResult;", "webView", "overrideUrlRedirect", "reason", "", "forceRedirect", "reqUrl", "fullUrl", "plugin-brandservice_release"})
  static final class h
    extends com.tencent.mm.plugin.webview.core.k
  {
    private final MMWebView pHS;
    private final ese sLr;
    
    public h(ese paramese, MMWebView paramMMWebView)
    {
      AppMethodBeat.i(263892);
      this.sLr = paramese;
      this.pHS = paramMMWebView;
      AppMethodBeat.o(263892);
    }
    
    public final boolean a(int paramInt, boolean paramBoolean, String paramString1, String paramString2)
    {
      AppMethodBeat.i(263888);
      kotlin.g.b.p.k(paramString1, "reqUrl");
      kotlin.g.b.p.k(paramString2, "fullUrl");
      if ((paramInt == 0) && (UrlExKt.isMpUrl(paramString2)) && (kotlin.g.b.p.h(com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.apJ(paramString1), com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.apJ(paramString2))))
      {
        AppMethodBeat.o(263888);
        return true;
      }
      paramBoolean = super.a(paramInt, paramBoolean, paramString1, paramString2);
      AppMethodBeat.o(263888);
      return paramBoolean;
    }
    
    public final boolean aqs(String paramString)
    {
      AppMethodBeat.i(263890);
      kotlin.g.b.p.k(paramString, "url");
      Object localObject2 = getController();
      Object localObject1 = localObject2;
      if (!(localObject2 instanceof MpWebViewController)) {
        localObject1 = null;
      }
      localObject1 = (MpWebViewController)localObject1;
      if ((localObject1 != null) && (((MpWebViewController.a((MpWebViewController)localObject1, MpWebViewController.b((MpWebViewController)localObject1))) && (kotlin.g.b.p.h(com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.apJ(paramString), com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.apJ(((MpWebViewController)localObject1).cDu())))) || ((MpWebViewController.a((MpWebViewController)localObject1, MpWebViewController.cDG())) && (kotlin.g.b.p.h(com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.apJ(paramString), com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.apJ(MpWebViewController.c((MpWebViewController)localObject1)))) && (getController().gSz()))))
      {
        localObject2 = ((Iterable)MpWebViewController.d((MpWebViewController)localObject1)).iterator();
        while (((Iterator)localObject2).hasNext()) {
          com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new b((com.tencent.mm.plugin.webview.core.j)((Iterator)localObject2).next()));
        }
        ((BaseWebViewController)localObject1).PGd = true;
        ((MpWebViewController)localObject1).n(MpWebViewController.aqr(paramString), true, 8);
        AppMethodBeat.o(263890);
        return true;
      }
      AppMethodBeat.o(263890);
      return false;
    }
    
    public final WebResourceResponse b(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
    {
      AppMethodBeat.i(263889);
      kotlin.g.b.p.k(paramWebView, "webview");
      kotlin.g.b.p.k(paramWebResourceRequest, "request");
      paramWebView = paramWebResourceRequest.getUrl().toString();
      kotlin.g.b.p.j(paramWebView, "request.url.toString()");
      if (((kotlin.g.b.p.h(paramWebView, this.sLr.POG) ^ true)) && (!kotlin.n.n.M(paramWebView, com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.b.getPrefix(), false)))
      {
        Log.d("MicroMsg.WebViewController", "WebView-Trace intercept return");
        AppMethodBeat.o(263889);
        return null;
      }
      Log.i("MicroMsg.WebViewController", "getResourceResponse, requrl:%s, url:%s", new Object[] { paramWebView, this.sLr.UtX });
      if (paramWebResourceRequest.isForMainFrame())
      {
        paramWebView = this.sLr.UtX;
        kotlin.g.b.p.j(paramWebView, "tmplParams.initFilePath");
        paramWebView = new a(paramWebView, false);
      }
      while (paramWebView != null)
      {
        Log.v("MicroMsg.WebViewController", "response path: " + paramWebView.path);
        paramWebResourceRequest = MpWebViewController.sRu;
        paramWebResourceRequest = MpWebViewController.f.g((WebView)this.pHS, paramWebView.path);
        if (paramWebResourceRequest != null)
        {
          Log.i("MicroMsg.WebViewController", "return intercepted success");
          AppMethodBeat.o(263889);
          return paramWebResourceRequest;
          int i;
          if (kotlin.n.n.M(paramWebView, com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.b.cDp(), false))
          {
            i = this.sLr.sNh;
            paramWebResourceRequest = this.sLr.ktM;
            kotlin.g.b.p.j(paramWebResourceRequest, "tmplParams.uid");
            paramWebView = (CharSequence)paramWebView;
            paramWebView = new a(com.tencent.mm.plugin.brandservice.ui.timeline.preload.p.u(i, paramWebResourceRequest, new kotlin.n.k(com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.b.cDp()).f(paramWebView, "")), true);
          }
          else if (kotlin.n.n.M(paramWebView, com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.b.getPrefix(), false))
          {
            i = this.sLr.sNh;
            paramWebResourceRequest = this.sLr.ktM;
            kotlin.g.b.p.j(paramWebResourceRequest, "tmplParams.uid");
            paramWebView = (CharSequence)paramWebView;
            paramWebView = new a(com.tencent.mm.plugin.brandservice.ui.timeline.preload.p.u(i, paramWebResourceRequest, new kotlin.n.k(com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.b.getPrefix()).f(paramWebView, "")), true);
          }
          else
          {
            paramWebView = null;
          }
        }
        else
        {
          Log.e("MicroMsg.WebViewController", "return intercepted null");
          com.tencent.mm.plugin.webview.h.a.gU(this.sLr.reportId, 126);
          if (paramWebView.npI) {
            com.tencent.mm.plugin.webview.h.a.gU(this.sLr.reportId, 233);
          }
        }
      }
      AppMethodBeat.o(263889);
      return null;
    }
    
    public final k.a c(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
    {
      AppMethodBeat.i(263891);
      kotlin.g.b.p.k(paramWebView, "webView");
      kotlin.g.b.p.k(paramWebResourceRequest, "request");
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
        kotlin.g.b.p.j(localObject2, "request.url.toString()");
        String str = com.tencent.mm.plugin.webview.h.a.sQA;
        kotlin.g.b.p.j(str, "ConstantsPreload.HARDCODE_URL");
        if ((!kotlin.n.n.M((String)localObject2, str, false)) && (getController().gSz()))
        {
          Log.i(MpWebViewController.e((MpWebViewController)localObject1), "edw opt, shouldOverride url exitTmpl");
          MpWebViewController.f((MpWebViewController)localObject1);
          ((BaseWebViewController)localObject1).PGd = true;
        }
      }
      paramWebView = super.c(paramWebView, paramWebResourceRequest);
      AppMethodBeat.o(263891);
      return paramWebView;
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$MpWebViewInterceptor$intercept$InterceptInfo", "", "path", "", "isZip", "", "(Ljava/lang/String;Z)V", "()Z", "getPath", "()Ljava/lang/String;", "component1", "component2", "copy", "(Ljava/lang/String;Z)Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$MpWebViewInterceptor$intercept$InterceptInfo;", "equals", "other", "hashCode", "", "toString", "plugin-brandservice_release"})
    public static final class a
    {
      final boolean npI;
      final String path;
      
      public a(String paramString, boolean paramBoolean)
      {
        AppMethodBeat.i(257192);
        this.path = paramString;
        this.npI = paramBoolean;
        AppMethodBeat.o(257192);
      }
      
      public final boolean equals(Object paramObject)
      {
        AppMethodBeat.i(257195);
        if (this != paramObject)
        {
          if ((paramObject instanceof a))
          {
            paramObject = (a)paramObject;
            if ((!kotlin.g.b.p.h(this.path, paramObject.path)) || (this.npI != paramObject.npI)) {}
          }
        }
        else
        {
          AppMethodBeat.o(257195);
          return true;
        }
        AppMethodBeat.o(257195);
        return false;
      }
      
      public final int hashCode()
      {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
      }
      
      public final String toString()
      {
        AppMethodBeat.i(257193);
        String str = "InterceptInfo(path=" + this.path + ", isZip=" + this.npI + ")";
        AppMethodBeat.o(257193);
        return str;
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
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
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "value", "", "invoke"})
  static final class k
    extends kotlin.g.b.q
    implements kotlin.g.a.b<String, x>
  {
    k(MpWebViewController paramMpWebViewController)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class l
    implements Runnable
  {
    l(MpWebViewController paramMpWebViewController) {}
    
    public final void run()
    {
      AppMethodBeat.i(260024);
      Log.v(MpWebViewController.e(this.sRv), "checkNotifyPageTimer isNotifyPageSuccess=" + this.sRv.sRg + ", isStopCheckNotifyPage=" + this.sRv.sRh);
      if ((!this.sRv.sRg) && (!this.sRv.sRh))
      {
        com.tencent.mm.plugin.webview.h.a.rE(92);
        this.sRv.sQQ.sMG = true;
        this.sRv.sQQ.sMH = true;
        MpWebViewController.p(this.sRv);
        MpWebViewController.b(this.sRv, MpWebViewController.cDK());
        Log.e(MpWebViewController.e(this.sRv), "check notifyPage timeout");
      }
      AppMethodBeat.o(260024);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$initEnviroment$1", "", "__getString", "", "__log", "", "value", "plugin-brandservice_release"})
  public static final class m
  {
    @android.webkit.JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final String __getString()
    {
      AppMethodBeat.i(259643);
      Object localObject1 = MpWebViewController.g(this.sRv);
      kotlin.g.b.p.k(localObject1, "$this$getContent");
      Object localObject2 = com.tencent.mm.plugin.brandservice.ui.timeline.preload.m.sNg;
      localObject1 = com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.b(com.tencent.mm.plugin.brandservice.ui.timeline.preload.m.cCk(), (String)localObject1);
      if (localObject1 != null)
      {
        localObject2 = r.ak((com.tencent.mm.vfs.q)localObject1);
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = "";
      }
      AppMethodBeat.o(259643);
      return localObject1;
    }
    
    @android.webkit.JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void __log(String paramString)
    {
      AppMethodBeat.i(259640);
      Object localObject = this.sRv;
      if (paramString != null)
      {
        paramString = new JSONObject(paramString).getJSONObject("err");
        if (paramString != null)
        {
          int i = paramString.getInt("errCode");
          paramString = paramString.getString("msg");
          String str = ((MpWebViewController)localObject).cDs();
          StringBuilder localStringBuilder = new StringBuilder("onWebLog:");
          localObject = ((MpWebViewController)localObject).sQY;
          if (localObject == null) {
            kotlin.g.b.p.bGy("contentId");
          }
          Log.e(str, (String)localObject + ',' + i + ',' + paramString);
          com.tencent.mm.plugin.webview.h.a.anX(114);
          AppMethodBeat.o(259640);
          return;
        }
      }
      AppMethodBeat.o(259640);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Lcom/tencent/mm/protocal/JsapiPermissionWrapper;", "handleMsg"})
  static final class n
    implements h.a
  {
    n(MpWebViewController paramMpWebViewController) {}
    
    public final boolean b(com.tencent.mm.plugin.webview.d.n paramn)
    {
      AppMethodBeat.i(258014);
      MpWebViewController localMpWebViewController;
      if (kotlin.g.b.p.h(paramn.function, "notifyPageInfo"))
      {
        Log.v(MpWebViewController.e(this.sRv), "handleMsg " + paramn.function);
        localMpWebViewController = this.sRv;
        kotlin.g.b.p.j(paramn, "msg");
        MpWebViewController.a(localMpWebViewController, paramn);
        AppMethodBeat.o(258014);
        return true;
      }
      if (kotlin.g.b.p.h(paramn.function, "updatePageAuth"))
      {
        Log.v(MpWebViewController.e(this.sRv), "handleMsg " + paramn.function);
        localMpWebViewController = this.sRv;
        kotlin.g.b.p.j(paramn, "msg");
        MpWebViewController.b(localMpWebViewController, paramn);
        AppMethodBeat.o(258014);
        return true;
      }
      AppMethodBeat.o(258014);
      return false;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$loadTmpl$InterceptInfo", "", "path", "", "isZip", "", "(Ljava/lang/String;Z)V", "()Z", "getPath", "()Ljava/lang/String;", "component1", "component2", "copy", "(Ljava/lang/String;Z)Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$loadTmpl$InterceptInfo;", "equals", "other", "hashCode", "", "toString", "plugin-brandservice_release"})
  public static final class o
  {
    final boolean npI;
    final String path;
    
    public o(String paramString)
    {
      AppMethodBeat.i(259931);
      this.path = paramString;
      this.npI = false;
      AppMethodBeat.o(259931);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(259940);
      if (this != paramObject)
      {
        if ((paramObject instanceof o))
        {
          paramObject = (o)paramObject;
          if ((!kotlin.g.b.p.h(this.path, paramObject.path)) || (this.npI != paramObject.npI)) {}
        }
      }
      else
      {
        AppMethodBeat.o(259940);
        return true;
      }
      AppMethodBeat.o(259940);
      return false;
    }
    
    public final int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final String toString()
    {
      AppMethodBeat.i(259933);
      String str = "InterceptInfo(path=" + this.path + ", isZip=" + this.npI + ")";
      AppMethodBeat.o(259933);
      return str;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"getNotifyPageInfoString", "", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "invoke"})
  static final class p
    extends kotlin.g.b.q
    implements kotlin.g.a.b<com.tencent.mm.plugin.webview.d.n, String>
  {
    public static final p sRy;
    
    static
    {
      AppMethodBeat.i(266184);
      sRy = new p();
      AppMethodBeat.o(266184);
    }
    
    p()
    {
      super();
    }
    
    public static String c(com.tencent.mm.plugin.webview.d.n paramn)
    {
      AppMethodBeat.i(266183);
      kotlin.g.b.p.k(paramn, "msg");
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("performance", (String)paramn.params.get("performance"));
      localJSONObject.put("injectPageDataResult", (String)paramn.params.get("injectPageDataResult"));
      paramn = localJSONObject.toString();
      kotlin.g.b.p.j(paramn, "pageInfo.toString()");
      AppMethodBeat.o(266183);
      return paramn;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class q
    extends kotlin.d.b.a.j
    implements kotlin.g.a.m<ak, kotlin.d.d<? super x>, Object>
  {
    Object L$0;
    int label;
    private ak p$;
    
    q(MpWebViewController paramMpWebViewController, kotlin.d.d paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<x> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(265071);
      kotlin.g.b.p.k(paramd, "completion");
      paramd = new q(this.sRv, paramd);
      paramd.p$ = ((ak)paramObject);
      AppMethodBeat.o(265071);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(265072);
      paramObject1 = ((q)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(x.aazN);
      AppMethodBeat.o(265072);
      return paramObject1;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(265070);
      kotlin.d.a.a locala = kotlin.d.a.a.aaAA;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(265070);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        this.L$0 = this.p$;
        this.label = 1;
        if (aw.a(300L, this) == locala)
        {
          AppMethodBeat.o(265070);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      MpWebViewController.b(this.sRv, MpWebViewController.cDI());
      paramObject = x.aazN;
      AppMethodBeat.o(265070);
      return paramObject;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "titles", "", "data", "performance", "", "Lkotlin/Pair;", "invoke"})
  static final class r
    extends kotlin.g.b.q
    implements kotlin.g.a.q<String, String, List<? extends o<? extends String, ? extends String>>, x>
  {
    r(MpWebViewController paramMpWebViewController)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "titles", "", "data", "performance", "", "Lkotlin/Pair;", "invoke"})
  static final class s
    extends kotlin.g.b.q
    implements kotlin.g.a.q<String, String, List<? extends o<? extends String, ? extends String>>, x>
  {
    s(MpWebViewController paramMpWebViewController)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "contextRef", "Ljava/lang/ref/WeakReference;", "", "result", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$MountableCGIResult;", "appMsgContext", "Lcom/tencent/mm/protocal/protobuf/AppMsgContext;", "invoke"})
  static final class t
    extends kotlin.g.b.q
    implements kotlin.g.a.q<WeakReference<Object>, m.c, fh, x>
  {
    t(MpWebViewController paramMpWebViewController)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/protocal/protobuf/PreloadSession;", "invoke"})
  static final class u
    extends kotlin.g.b.q
    implements kotlin.g.a.a<dny>
  {
    u(MpWebViewController paramMpWebViewController, MMWebView paramMMWebView)
    {
      super();
    }
    
    private dny cDN()
    {
      AppMethodBeat.i(265234);
      try
      {
        localObject1 = MpWebViewController.m(this.sRv);
        localObject3 = f.r.VSQ;
        kotlin.g.b.p.j(localObject3, "ConstantsUI.WebViewUI.KTmplSession");
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
        dny localdny;
        for (;;)
        {
          try
          {
            Object localObject3 = dny.class.newInstance();
            ((com.tencent.mm.cd.a)localObject3).parseFrom((byte[])localObject1);
            Object localObject1 = (com.tencent.mm.cd.a)localObject3;
            localObject3 = (dny)localObject1;
            localObject1 = localObject3;
            if (localObject3 != null) {
              break;
            }
            localObject1 = (Throwable)new Resources.NotFoundException("TmplSession");
            AppMethodBeat.o(265234);
            throw ((Throwable)localObject1);
          }
          catch (Exception localException2)
          {
            int i;
            Object localObject2;
            Log.printErrStackTrace("Intent.decodeProtoBuffer", (Throwable)localException2, "decode ProtoBuffer", new Object[0]);
          }
          localException1 = localException1;
          Log.e(MpWebViewController.e(this.sRv), "session is null, " + localException1.getMessage() + ' ' + com.tencent.mm.plugin.brandservice.ui.timeline.preload.f.ae(MpWebViewController.m(this.sRv)));
          com.tencent.mm.plugin.webview.h.a.anX(153);
          com.tencent.mm.plugin.report.service.h.IzE.a(17260, new Object[] { Integer.valueOf(2), com.tencent.mm.plugin.brandservice.ui.timeline.preload.f.ae(MpWebViewController.m(this.sRv)) });
          if ((paramMMWebView.getActivityContextIfHas() instanceof Activity))
          {
            localObject2 = paramMMWebView.getActivityContextIfHas();
            if (localObject2 == null)
            {
              localObject2 = new t("null cannot be cast to non-null type android.app.Activity");
              AppMethodBeat.o(265234);
              throw ((Throwable)localObject2);
              i = 0;
              continue;
              i = 0;
              continue;
              localdny = null;
            }
            else
            {
              ((Activity)localdny).finish();
            }
          }
          else
          {
            localdny = new dny();
          }
        }
        AppMethodBeat.o(265234);
        return localdny;
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
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "invoke"})
  static final class v
    extends kotlin.g.b.q
    implements kotlin.g.a.b<String, x>
  {
    v(MpWebViewController paramMpWebViewController)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "value", "", "invoke"})
  static final class w
    extends kotlin.g.b.q
    implements kotlin.g.a.b<String, x>
  {
    w(MpWebViewController paramMpWebViewController)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "value", "", "invoke"})
  static final class x
    extends kotlin.g.b.q
    implements kotlin.g.a.b<String, x>
  {
    x(MpWebViewController paramMpWebViewController)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "value", "", "invoke"})
  static final class y
    extends kotlin.g.b.q
    implements kotlin.g.a.b<String, x>
  {
    y(MpWebViewController paramMpWebViewController, long paramLong1, aa.a parama, long paramLong2)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "callback"})
  static final class z
    implements IPCRunCgi.a
  {
    z(MpWebViewController paramMpWebViewController, String paramString, com.tencent.mm.plugin.webview.d.n paramn) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.d paramd)
    {
      AppMethodBeat.i(267061);
      MpWebViewController.h(this.sRv).remove(this.sRD);
      kotlin.g.b.p.j(paramd, "rr");
      if (!(paramd.bhY() instanceof bot))
      {
        AppMethodBeat.o(267061);
        return;
      }
      paramString = paramd.bhY();
      if (paramString == null)
      {
        paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetA8KeyResp");
        AppMethodBeat.o(267061);
        throw paramString;
      }
      paramString = (bot)paramString;
      if (Util.isNullOrNil(paramString.Tao))
      {
        Log.e(MpWebViewController.e(this.sRv), "updatePageAuth fail fullurl is null");
        com.tencent.mm.plugin.webview.h.a.rE(82);
        paramString = this.sRv.getJsapi();
        if (paramString != null)
        {
          paramString.h(this.sRE.POu, this.sRE.function + ":fail", null);
          AppMethodBeat.o(267061);
          return;
        }
        AppMethodBeat.o(267061);
        return;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        try
        {
          paramd = new JsapiPermissionWrapper(z.a(paramString.Taz));
          Object localObject = new GeneralControlWrapper(paramString.Tar);
          this.sRv.pGD.a(paramString.Tao, paramd, (GeneralControlWrapper)localObject);
          paramd = this.sRv;
          localObject = this.sRD;
          String str = paramString.Tao;
          kotlin.g.b.p.j(str, "resp.FullURL");
          Map localMap = com.tencent.mm.plugin.webview.f.c.iZ((List)paramString.SZV);
          kotlin.g.b.p.j(localMap, "LuggageGetA8Key.getHttpHeaders(resp.HttpHeader)");
          MpWebViewController.a(paramd, (String)localObject, str, localMap);
          com.tencent.mm.plugin.webview.h.a.anX(109);
          paramd = (Map)new HashMap();
          paramString = paramString.Tao;
          kotlin.g.b.p.j(paramString, "resp.FullURL");
          paramd.put("fullUrl", paramString);
          Log.i(MpWebViewController.e(this.sRv), "updatePageAuth values:%s", new Object[] { paramd });
          com.tencent.mm.plugin.webview.h.a.rE(81);
          paramString = this.sRv.getJsapi();
          if (paramString != null)
          {
            paramString.h(this.sRE.POu, this.sRE.function + ":ok", paramd);
            AppMethodBeat.o(267061);
            return;
          }
        }
        catch (Exception paramString)
        {
          com.tencent.mm.plugin.webview.h.a.rE(82);
          paramString = this.sRv.getJsapi();
          if (paramString != null)
          {
            paramString.h(this.sRE.POu, this.sRE.function + ":fail", null);
            AppMethodBeat.o(267061);
            return;
            AppMethodBeat.o(267061);
            return;
          }
          AppMethodBeat.o(267061);
          return;
        }
      }
      com.tencent.mm.plugin.webview.h.a.rE(82);
      paramString = this.sRv.getJsapi();
      if (paramString != null)
      {
        paramString.h(this.sRE.POu, this.sRE.function + ":fail", null);
        AppMethodBeat.o(267061);
        return;
      }
      AppMethodBeat.o(267061);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.MpWebViewController
 * JD-Core Version:    0.7.0.1
 */