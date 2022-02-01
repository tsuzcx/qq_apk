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
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.UrlExKt;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.j.c;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.r;
import com.tencent.mm.plugin.webview.c.f.a;
import com.tencent.mm.plugin.webview.core.BaseWebViewController;
import com.tencent.mm.plugin.webview.core.BaseWebViewController.ControllerAction;
import com.tencent.mm.plugin.webview.core.BaseWebViewController.e;
import com.tencent.mm.plugin.webview.core.j.a;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.aoj;
import com.tencent.mm.protocal.protobuf.cbz;
import com.tencent.mm.protocal.protobuf.dch;
import com.tencent.mm.protocal.protobuf.eu;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.e.m;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.vfs.e;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.c;
import com.tencent.xweb.ae;
import d.g.a.m;
import d.g.b.u;
import d.g.b.v.a;
import d.g.b.w;
import d.n.n;
import d.o;
import d.v;
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
import kotlinx.coroutines.ao;
import org.json.JSONObject;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController;", "Lcom/tencent/mm/plugin/webview/core/WebViewController;", "tmplParams", "Lcom/tencent/mm/protocal/protobuf/TmplParams;", "viewWV", "Lcom/tencent/mm/ui/widget/MMWebView;", "(Lcom/tencent/mm/protocal/protobuf/TmplParams;Lcom/tencent/mm/ui/widget/MMWebView;)V", "API", "", "TAG", "getTAG", "()Ljava/lang/String;", "TAG$delegate", "Lkotlin/Lazy;", "TIMEOUT_TIME", "", "getTIMEOUT_TIME", "()J", "actionsCheckList", "", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$WebEvent;", "getActionsCheckList", "()Ljava/util/List;", "canFinishProgress", "", "getCanFinishProgress", "()Z", "checkNotifyPageTimer", "Ljava/lang/Runnable;", "contentId", "fullUrl", "gettingA8KeyUrl", "Ljava/util/HashSet;", "injectAPI", "isCheckingInject", "<set-?>", "isInjectDataSuccess", "isNotifyPageSuccess", "setNotifyPageSuccess", "(Z)V", "isTmplReady", "isUseDataCache", "setUseDataCache", "kv15862", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/Kv15862;", "getKv15862", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/Kv15862;", "preloadNext", "getPreloadNext", "setPreloadNext", "rawUrl", "getRawUrl", "receivePageData", "getReceivePageData", "setReceivePageData", "(J)V", "recodeInject", "session", "Lcom/tencent/mm/protocal/protobuf/PreloadSession;", "getSession", "()Lcom/tencent/mm/protocal/protobuf/PreloadSession;", "session$delegate", "startGetPageData", "getStartGetPageData", "setStartGetPageData", "startLoadPage", "getStartLoadPage", "setStartLoadPage", "adjustInnerWidth", "", "canHandleUrl", "url", "cancelReport", "checkInject", "checkNotifyPage", "getLogAPI", "value", "initEnviroment", "isPageCached", "isSameStart", "intent", "Landroid/content/Intent;", "loadForceUrl", "forceUrl", "fullScreen", "loadTmpl", "modifyForceUrl", "needSyncGetA8Key", "notifyPageInfo", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "pageInfo", "onError", "reason", "", "reqUrl", "errType", "errCode", "errMsg", "onPageFinished", "view", "Lcom/tencent/xweb/WebView;", "onPermissionUpdate", "response", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyResp;", "onStartLoad", "onWebLog", "processCommonGetA8KeyFullUrl", "httpHeader", "", "processData", "processGetAppContext", "result", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$MountableCGIResult;", "appMsgContext", "Lcom/tencent/mm/protocal/protobuf/AppMsgContext;", "processReport", "setMpUrl", "startAuth", "force", "stopCheckNotifyPage", "tryPreloadNextWebView", "updateAuth", "isSuccess", "updateData", "updateKV", "updatePageAuth", "validCommitUrl", "validStartUrl", "waitForInject", "waitForReady", "Companion", "ForceUrl", "MpWebViewInterceptor", "NotifyAuth", "PreloadNext", "StartPreload", "UpdateData", "plugin-brandservice_release"})
public final class MpWebViewController
  extends com.tencent.mm.plugin.webview.core.h
{
  private static final int nhk = -101;
  static final int nhl = -102;
  private static final int nhm = -103;
  private static final int nhn = -111;
  private static final int nho = -112;
  private static final int nhp = -113;
  private static final int nhq = -121;
  private static final int nhr = -122;
  private static final int nhs = -123;
  private static final int nht = -124;
  private static final int nhu = -130;
  public static final e nhv;
  String bnZ;
  private final dch ncu;
  private final d.f ngR;
  final com.tencent.mm.plugin.brandservice.ui.timeline.preload.f ngS;
  private long ngT;
  private long ngU;
  private long ngV;
  private boolean ngW;
  private boolean ngX;
  private final long ngY;
  private final d.f ngZ;
  private String nha;
  private boolean nhb;
  private boolean nhc;
  private final String nhd;
  private final List<BaseWebViewController.e> nhe;
  private final String nhf;
  boolean nhg;
  private final HashSet<String> nhh;
  boolean nhi;
  private final Runnable nhj;
  
  static
  {
    AppMethodBeat.i(193285);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bk(MpWebViewController.class), "TAG", "getTAG()Ljava/lang/String;")), (d.l.k)w.a(new u(w.bk(MpWebViewController.class), "session", "getSession()Lcom/tencent/mm/protocal/protobuf/PreloadSession;")) };
    nhv = new e((byte)0);
    nhk = -101;
    nhl = -102;
    nhm = -103;
    nhn = -111;
    nho = -112;
    nhp = -113;
    nhq = -121;
    nhr = -122;
    nhs = -123;
    nht = -124;
    nhu = -130;
    AppMethodBeat.o(193285);
  }
  
  public MpWebViewController(dch paramdch, final MMWebView paramMMWebView)
  {
    super(paramMMWebView);
    AppMethodBeat.i(193312);
    this.ncu = paramdch;
    this.ngR = d.g.E((d.g.a.a)new g(this));
    paramdch = new com.tencent.mm.plugin.brandservice.ui.timeline.preload.f();
    paramdch.a(this.ncu);
    this.ngS = paramdch;
    this.ngW = true;
    this.ngY = 5000L;
    this.ngZ = d.g.E((d.g.a.a)new t(this, paramMMWebView));
    this.nhd = "__tmpl_webview_inject_data";
    if (!(paramMMWebView instanceof a.a)) {}
    for (paramdch = null;; paramdch = paramMMWebView)
    {
      paramdch = (a.a)paramdch;
      if (paramdch != null) {
        paramdch.setCurrentUrlProxy((d.g.a.a)new d(this));
      }
      paramdch = super.bEB();
      paramdch.addAll((Collection)d.a.j.listOf(new BaseWebViewController.e[] { new BaseWebViewController.e(w.bk(UpdateData.class), (d.g.a.a)new h((MpWebViewController)this)), new BaseWebViewController.e(w.bk(StartPreload.class), (d.g.a.a)new a(this)), new BaseWebViewController.e(w.bk(PreloadNext.class), (d.g.a.a)new i((MpWebViewController)this)), new BaseWebViewController.e(w.bk(NotifyAuth.class), (d.g.a.a)new b(this)), new BaseWebViewController.e(w.bk(ForceUrl.class), (d.g.a.a)new c(this)) }));
      this.nhe = paramdch;
      this.nhf = (this.nhd + ".__getString()");
      this.nhh = new HashSet();
      this.nhj = ((Runnable)new k(this));
      AppMethodBeat.o(193312);
      return;
    }
  }
  
  private final void PS(String paramString)
  {
    AppMethodBeat.i(193302);
    this.AKH = paramString;
    avr(paramString);
    avs(paramString);
    d.g.b.k.h(paramString, "<set-?>");
    this.bob = paramString;
    AppMethodBeat.o(193302);
  }
  
  private void PT(String paramString)
  {
    AppMethodBeat.i(193309);
    d.g.b.k.h(paramString, "forceUrl");
    ejh();
    this.ALa = true;
    k(PU(paramString), true, 8);
    AppMethodBeat.o(193309);
  }
  
  private static String PU(String paramString)
  {
    AppMethodBeat.i(193311);
    paramString = UrlExKt.appendUrlParam(UrlExKt.clearUrlParam(UrlExKt.clearUrlParam(UrlExKt.clearUrlParam(paramString, "fasttmpl_flag"), "fasttmpl_type"), "fasttmpl_fullversion"), "forceh5", "1");
    AppMethodBeat.o(193311);
    return paramString;
  }
  
  private final void a(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    AppMethodBeat.i(193308);
    com.tencent.mm.sdk.platformtools.ad.i(getTAG(), "[updatePageAuth]reqUrl:" + paramString1 + " fullUrl:" + paramString2 + " httpHeader:" + paramMap);
    paramString1 = this.nhy.getSettings();
    d.g.b.k.g(paramString1, "viewWV.settings");
    paramString1 = paramString1.getUserAgentString();
    d.g.b.k.g(paramString1, "viewWV.settings.userAgentString");
    paramMap.put("User-agent", paramString1);
    getJsapi().avR(new JSONObject(paramMap).toString());
    paramString1 = Uri.parse(paramString2).getQueryParameter("pass_ticket");
    getJsapi().avQ(paramString1);
    AppMethodBeat.o(193308);
  }
  
  /* Error */
  private final boolean a(com.tencent.mm.plugin.webview.c.l paraml)
  {
    // Byte code:
    //   0: ldc_w 724
    //   3: invokestatic 280	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: getstatic 728	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$o:nhA	Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$o;
    //   9: astore 10
    //   11: aload_1
    //   12: invokestatic 732	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$o:c	(Lcom/tencent/mm/plugin/webview/c/l;)Ljava/lang/String;
    //   15: astore 10
    //   17: aload_0
    //   18: invokevirtual 514	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:getTAG	()Ljava/lang/String;
    //   21: ldc_w 734
    //   24: aload 10
    //   26: invokestatic 740	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   29: invokevirtual 743	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   32: invokestatic 648	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   35: new 683	org/json/JSONObject
    //   38: dup
    //   39: aload 10
    //   41: invokespecial 744	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   44: astore 10
    //   46: new 683	org/json/JSONObject
    //   49: dup
    //   50: aload 10
    //   52: ldc_w 746
    //   55: invokevirtual 749	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   58: invokespecial 744	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   61: astore 11
    //   63: aload 11
    //   65: ldc_w 751
    //   68: invokevirtual 755	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   71: lstore_2
    //   72: aload 11
    //   74: ldc_w 757
    //   77: invokevirtual 755	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   80: lstore 4
    //   82: aload 11
    //   84: ldc_w 759
    //   87: invokevirtual 755	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   90: lstore 6
    //   92: aload 11
    //   94: ldc_w 761
    //   97: invokevirtual 755	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   100: lstore 8
    //   102: aload_0
    //   103: getfield 765	com/tencent/mm/plugin/webview/core/BaseWebViewController:AKV	Lcom/tencent/mm/plugin/webview/j/h;
    //   106: ldc_w 759
    //   109: lload 6
    //   111: invokevirtual 771	com/tencent/mm/plugin/webview/j/h:bG	(Ljava/lang/String;J)V
    //   114: aload_0
    //   115: getfield 765	com/tencent/mm/plugin/webview/core/BaseWebViewController:AKV	Lcom/tencent/mm/plugin/webview/j/h;
    //   118: ldc_w 761
    //   121: lload 8
    //   123: invokevirtual 771	com/tencent/mm/plugin/webview/j/h:bG	(Ljava/lang/String;J)V
    //   126: aload_0
    //   127: getfield 373	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:ngS	Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/f;
    //   130: lload_2
    //   131: putfield 774	com/tencent/mm/plugin/brandservice/ui/timeline/preload/f:ncF	J
    //   134: aload_0
    //   135: getfield 373	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:ngS	Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/f;
    //   138: lload 4
    //   140: putfield 777	com/tencent/mm/plugin/brandservice/ui/timeline/preload/f:ncG	J
    //   143: aload_0
    //   144: getfield 373	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:ngS	Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/f;
    //   147: lload 6
    //   149: putfield 780	com/tencent/mm/plugin/brandservice/ui/timeline/preload/f:ncC	J
    //   152: aload_0
    //   153: getfield 373	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:ngS	Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/f;
    //   156: lload 8
    //   158: putfield 783	com/tencent/mm/plugin/brandservice/ui/timeline/preload/f:ncE	J
    //   161: aload 10
    //   163: ldc_w 785
    //   166: ldc_w 787
    //   169: invokevirtual 789	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   172: ldc_w 791
    //   175: invokestatic 794	d/g/b/k:g	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   178: ifeq +122 -> 300
    //   181: aload_0
    //   182: iconst_1
    //   183: putfield 796	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:nhi	Z
    //   186: aload_0
    //   187: getfield 373	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:ngS	Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/f;
    //   190: iconst_1
    //   191: putfield 799	com/tencent/mm/plugin/brandservice/ui/timeline/preload/f:ndv	Z
    //   194: aload_0
    //   195: getfield 373	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:ngS	Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/f;
    //   198: new 63	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$q
    //   201: dup
    //   202: aload_0
    //   203: invokespecial 800	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$q:<init>	(Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController;)V
    //   206: checkcast 802	d/g/a/q
    //   209: invokevirtual 805	com/tencent/mm/plugin/brandservice/ui/timeline/preload/f:a	(Ld/g/a/q;)V
    //   212: aload_0
    //   213: getfield 351	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:ncu	Lcom/tencent/mm/protocal/protobuf/dch;
    //   216: getfield 537	com/tencent/mm/protocal/protobuf/dch:reportId	I
    //   219: sipush 131
    //   222: invokestatic 545	com/tencent/mm/plugin/webview/g/a:fL	(II)V
    //   225: bipush 108
    //   227: invokestatic 808	com/tencent/mm/plugin/webview/g/a:SW	(I)V
    //   230: aload_0
    //   231: getfield 373	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:ngS	Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/f;
    //   234: invokestatic 570	java/lang/System:currentTimeMillis	()J
    //   237: putfield 811	com/tencent/mm/plugin/brandservice/ui/timeline/preload/f:ncU	J
    //   240: aload_0
    //   241: invokespecial 626	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:bEG	()V
    //   244: aload_0
    //   245: invokespecial 814	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:bEF	()V
    //   248: aload_0
    //   249: invokevirtual 681	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:getJsapi	()Lcom/tencent/mm/plugin/webview/c/f;
    //   252: aload_1
    //   253: getfield 819	com/tencent/mm/plugin/webview/c/l:ASg	Ljava/lang/String;
    //   256: ldc_w 821
    //   259: aconst_null
    //   260: invokevirtual 823	com/tencent/mm/plugin/webview/c/f:h	(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V
    //   263: bipush 90
    //   265: invokestatic 826	com/tencent/mm/plugin/webview/g/a:lI	(I)V
    //   268: getstatic 832	kotlinx/coroutines/bc:Kem	Lkotlinx/coroutines/bc;
    //   271: checkcast 834	kotlinx/coroutines/ad
    //   274: aconst_null
    //   275: new 61	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$p
    //   278: dup
    //   279: aload_0
    //   280: aconst_null
    //   281: invokespecial 837	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$p:<init>	(Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController;Ld/d/d;)V
    //   284: checkcast 839	d/g/a/m
    //   287: iconst_3
    //   288: invokestatic 844	kotlinx/coroutines/d:a	(Lkotlinx/coroutines/ad;Ld/d/f;Ld/g/a/m;I)Lkotlinx/coroutines/bj;
    //   291: pop
    //   292: ldc_w 724
    //   295: invokestatic 335	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   298: iconst_1
    //   299: ireturn
    //   300: aload_0
    //   301: getfield 373	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:ngS	Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/f;
    //   304: iconst_1
    //   305: putfield 623	com/tencent/mm/plugin/brandservice/ui/timeline/preload/f:ndK	Z
    //   308: aload_0
    //   309: getstatic 330	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:nht	I
    //   312: invokevirtual 847	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:Sr	(I)V
    //   315: aload_0
    //   316: invokevirtual 514	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:getTAG	()Ljava/lang/String;
    //   319: ldc_w 849
    //   322: invokestatic 648	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   325: goto -95 -> 230
    //   328: astore 10
    //   330: aload_0
    //   331: invokevirtual 514	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:getTAG	()Ljava/lang/String;
    //   334: aload 10
    //   336: checkcast 851	java/lang/Throwable
    //   339: ldc_w 852
    //   342: iconst_0
    //   343: anewarray 854	java/lang/Object
    //   346: invokestatic 858	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   349: aload_0
    //   350: getfield 373	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:ngS	Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/f;
    //   353: iconst_1
    //   354: putfield 623	com/tencent/mm/plugin/brandservice/ui/timeline/preload/f:ndK	Z
    //   357: aload_0
    //   358: getstatic 330	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:nht	I
    //   361: invokevirtual 847	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:Sr	(I)V
    //   364: goto -134 -> 230
    //   367: astore 10
    //   369: aload_0
    //   370: invokevirtual 514	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:getTAG	()Ljava/lang/String;
    //   373: aload 10
    //   375: checkcast 851	java/lang/Throwable
    //   378: ldc_w 859
    //   381: iconst_0
    //   382: anewarray 854	java/lang/Object
    //   385: invokestatic 858	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   388: aload_0
    //   389: invokevirtual 681	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:getJsapi	()Lcom/tencent/mm/plugin/webview/c/f;
    //   392: aload_1
    //   393: getfield 819	com/tencent/mm/plugin/webview/c/l:ASg	Ljava/lang/String;
    //   396: ldc_w 861
    //   399: aconst_null
    //   400: invokevirtual 823	com/tencent/mm/plugin/webview/c/f:h	(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V
    //   403: bipush 91
    //   405: invokestatic 826	com/tencent/mm/plugin/webview/g/a:lI	(I)V
    //   408: ldc_w 724
    //   411: invokestatic 335	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   414: iconst_0
    //   415: ireturn
    //   416: astore 10
    //   418: aload_0
    //   419: invokevirtual 514	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:getTAG	()Ljava/lang/String;
    //   422: aload 10
    //   424: checkcast 851	java/lang/Throwable
    //   427: ldc_w 859
    //   430: iconst_0
    //   431: anewarray 854	java/lang/Object
    //   434: invokestatic 858	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   437: goto -49 -> 388
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	440	0	this	MpWebViewController
    //   0	440	1	paraml	com.tencent.mm.plugin.webview.c.l
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
  
  private final void bEF()
  {
    AppMethodBeat.i(193300);
    aFm().removeCallbacks(this.nhj);
    AppMethodBeat.o(193300);
  }
  
  private final void bEG()
  {
    AppMethodBeat.i(193301);
    com.tencent.mm.sdk.platformtools.ad.v(getTAG(), "terry trace updateKV");
    this.ngS.ncP = this.AKV.bH("onInjectStart", 0L);
    this.ngS.ncQ = this.AKV.bH("onInjectEnd", 0L);
    this.ngS.ncS = this.AKV.bH("onTmplLoadStart", 0L);
    this.ngS.ncT = this.AKV.bH("onTmplLoadEnd", 0L);
    this.ngS.ncN = this.AKV.bH("onCreateStart", 0L);
    this.ngS.ncO = this.AKV.bH("onCreateEnd", 0L);
    this.ngS.ndl = this.nhg;
    this.ngS.ncR = this.AKV.bH("onWebInjectEnd", 0L);
    com.tencent.mm.plugin.brandservice.ui.timeline.preload.f localf = this.ngS;
    String str = this.nhy.getRandomStr();
    d.g.b.k.g(str, "viewWV.randomStr");
    localf.setKey(str);
    this.ngS.ndm = Ss(nhl);
    AppMethodBeat.o(193301);
  }
  
  private cbz bEw()
  {
    AppMethodBeat.i(193287);
    cbz localcbz = (cbz)this.ngZ.getValue();
    AppMethodBeat.o(193287);
    return localcbz;
  }
  
  private void u(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(193303);
    d.g.b.k.h(paramString, "contentId");
    com.tencent.mm.sdk.platformtools.ad.v(getTAG(), "[updateData] " + bEx());
    com.tencent.mm.plugin.brandservice.ui.timeline.preload.j.PD(bEx());
    PS(bEx());
    this.bnZ = paramString;
    this.ngT = paramLong1;
    this.ngV = paramLong2;
    Sr(nhn);
    AppMethodBeat.o(193303);
  }
  
  public final boolean PP(String paramString)
  {
    AppMethodBeat.i(193293);
    d.g.b.k.h(paramString, "url");
    if ((super.PQ(paramString)) && ((d.g.b.k.g(paramString, this.ncu.ASo) ^ true)))
    {
      AppMethodBeat.o(193293);
      return true;
    }
    AppMethodBeat.o(193293);
    return false;
  }
  
  public final boolean PQ(String paramString)
  {
    AppMethodBeat.i(193294);
    d.g.b.k.h(paramString, "url");
    if ((super.PQ(paramString)) && ((d.g.b.k.g(paramString, this.ncu.ASo) ^ true)))
    {
      AppMethodBeat.o(193294);
      return true;
    }
    AppMethodBeat.o(193294);
    return false;
  }
  
  public final boolean PR(String paramString)
  {
    AppMethodBeat.i(193296);
    boolean bool = d.g.b.k.g(paramString, this.ncu.ASo);
    AppMethodBeat.o(193296);
    return bool;
  }
  
  public final void a(int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2)
  {
    AppMethodBeat.i(193307);
    d.g.b.k.h(paramString1, "reqUrl");
    d.g.b.k.h(paramString2, "errMsg");
    super.a(paramInt1, paramString1, paramInt2, paramInt3, paramString2);
    if (paramInt1 == 0)
    {
      this.nha = paramString1;
      Sr(nhr);
    }
    AppMethodBeat.o(193307);
  }
  
  public final void a(int paramInt, String paramString1, String paramString2, aoj paramaoj)
  {
    AppMethodBeat.i(193304);
    d.g.b.k.h(paramString1, "reqUrl");
    d.g.b.k.h(paramString2, "fullUrl");
    d.g.b.k.h(paramaoj, "response");
    if (paramInt == 0) {
      PS(paramString2);
    }
    super.a(paramInt, paramString1, paramString2, paramaoj);
    if (paramInt == 0)
    {
      this.nha = paramString2;
      paramaoj = com.tencent.mm.plugin.webview.e.c.gx((List)paramaoj.Dqh);
      d.g.b.k.g(paramaoj, "LuggageGetA8Key.getHttpH…ders(response.HttpHeader)");
      com.tencent.mm.plugin.webview.g.a.fL(this.ncu.reportId, 117);
      this.ngS.ncM = System.currentTimeMillis();
      this.ngS.ndu = true;
      bEG();
      this.ngS.a((d.g.a.q)new r(this));
      a(paramString1, paramString2, paramaoj);
      Sr(nhq);
    }
    AppMethodBeat.o(193304);
  }
  
  public final boolean aD(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(193297);
    d.g.b.k.h(paramString, "url");
    if (((d.g.b.k.g(paramString, this.ncu.ASo) ^ true)) && (super.aD(paramString, paramBoolean)))
    {
      AppMethodBeat.o(193297);
      return true;
    }
    AppMethodBeat.o(193297);
    return false;
  }
  
  public final void b(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(193298);
    super.b(paramWebView, paramString);
    if (d.g.b.k.g(paramString, this.ncu.ASo))
    {
      if ((Ss(nhl)) || (Ss(nhk)))
      {
        AppMethodBeat.o(193298);
        return;
      }
      com.tencent.mm.sdk.platformtools.ad.i(getTAG(), "checkInject start");
      com.tencent.mm.plugin.webview.g.a.fL(this.ncu.reportId, 113);
      f("JSON.stringify(window.__appmsg_skeleton_success__)", (d.g.a.b)new j(this));
      int i = com.tencent.mm.cd.a.hV(this.nhy.getContext());
      float f = com.tencent.mm.cd.a.getDensity(this.nhy.getContext());
      com.tencent.mm.sdk.platformtools.ad.i(getTAG(), "adjustInnerWidth() screenWidth:" + i + ", density:" + f);
      if ((i > 0) && (f > 0.0F))
      {
        i = (int)(i / f);
        com.tencent.mm.sdk.platformtools.ad.i(getTAG(), "adjustInnerWidth() innerWidth:".concat(String.valueOf(i)));
        f("window.innerWidth = ".concat(String.valueOf(i)), null);
      }
      com.tencent.mm.sdk.platformtools.ad.i(getTAG(), "[onPageReady]");
    }
    AppMethodBeat.o(193298);
  }
  
  public final boolean bEA()
  {
    AppMethodBeat.i(193291);
    if ((bEz()) && (Ss(nhq)))
    {
      AppMethodBeat.o(193291);
      return true;
    }
    AppMethodBeat.o(193291);
    return false;
  }
  
  public final List<BaseWebViewController.e> bEB()
  {
    return this.nhe;
  }
  
  public final void bEC()
  {
    AppMethodBeat.i(193292);
    a((com.tencent.mm.plugin.webview.core.j)new f(this.ncu, this.nhy));
    super.bEC();
    this.nhy.addJavascriptInterface(new l(this), this.nhd);
    getJsapi().ekm();
    getJsapi().a((f.a)new m(this));
    String str = this.ncu.ASo;
    com.tencent.mm.sdk.platformtools.ad.i(getTAG(), "WebView-Trace loadTmpl getResourceResponse, requrl:%s, url:%s", new Object[] { str, this.ncu.EtM });
    Object localObject = this.ncu.EtM;
    d.g.b.k.g(localObject, "tmplParams.initFilePath");
    localObject = new n((String)localObject);
    com.tencent.mm.sdk.platformtools.ad.v(getTAG(), "response path:" + bt.by(((n)localObject).path, "null"));
    if (e.g((WebView)this.nhy, ((n)localObject).path) != null)
    {
      com.tencent.mm.sdk.platformtools.ad.i(getTAG(), "return intercepted success");
      this.nhy.loadUrl(str);
      Sr(this.ALg);
      AppMethodBeat.o(193292);
      return;
    }
    com.tencent.mm.sdk.platformtools.ad.e(getTAG(), "return intercepted null");
    com.tencent.mm.plugin.webview.g.a.fL(this.ncu.reportId, 126);
    if (((n)localObject).ndo) {
      com.tencent.mm.plugin.webview.g.a.fL(this.ncu.reportId, 233);
    }
    AppMethodBeat.o(193292);
  }
  
  public final void bED()
  {
    int j = 1;
    AppMethodBeat.i(193295);
    com.tencent.mm.sdk.platformtools.ad.i(getTAG(), "onStartLoad");
    Object localObject1 = getIntent();
    d.g.b.k.h(localObject1, "intent");
    com.tencent.mm.sdk.platformtools.ad.v(getTAG(), "processData");
    setIntent((Intent)localObject1);
    this.ngU = System.currentTimeMillis();
    this.ngW = ((Intent)localObject1).getBooleanExtra(e.m.FIk, true);
    this.ngT = ((Intent)localObject1).getLongExtra(e.m.FIl, 0L);
    Object localObject2 = com.tencent.mm.kernel.g.afy().aeZ();
    d.g.b.k.g(localObject2, "MMKernel.process().current()");
    localObject2 = ((com.tencent.mm.kernel.b.h)localObject2).agt();
    String str = ((Intent)localObject1).getStringExtra(e.m.FIn);
    if ((((Intent)localObject1).getStringExtra("rawUrl") == null) || (str == null))
    {
      com.tencent.mm.sdk.platformtools.ad.e(getTAG(), "rawUrl is null, " + com.tencent.mm.plugin.brandservice.ui.timeline.preload.d.ae((Intent)localObject1));
      com.tencent.mm.plugin.webview.g.a.SW(151);
      com.tencent.mm.plugin.report.service.h.vKh.f(17260, new Object[] { Integer.valueOf(1), com.tencent.mm.plugin.brandservice.ui.timeline.preload.d.ae((Intent)localObject1) });
      i = 0;
      if (i == 0)
      {
        onFinish();
        AppMethodBeat.o(193295);
      }
    }
    else
    {
      com.tencent.mm.plugin.brandservice.ui.timeline.preload.f localf = this.ngS;
      if (((g.a)localObject2).gfN < this.ngT)
      {
        bool = true;
        label233:
        localf.nds = bool;
        if (!this.ngS.nds) {
          break label541;
        }
        i = 104;
        label252:
        com.tencent.mm.plugin.webview.g.a.SW(i);
        switch (r.a(((Intent)localObject1).getIntExtra(e.m.FIs, -1), this.ngT, Process.myPid(), ((g.a)localObject2).gfF))
        {
        }
      }
      for (;;)
      {
        this.ngS.ndo = bEw().DYn;
        this.ngS.ndp = bEw().DYo;
        this.ngS.ndq = com.tencent.mm.plugin.webview.c.i.b((WebView)this.nhy);
        this.ngS.ndr = bEw().ndr;
        this.ngS.nda = ((g.a)localObject2).gfF;
        this.ngS.ndb = ((g.a)localObject2).gfG;
        this.ngS.ndc = ((g.a)localObject2).gfH;
        this.ngS.ndd = ((g.a)localObject2).gfI;
        this.ngS.nde = ((g.a)localObject2).gfJ;
        this.ngS.ndf = ((g.a)localObject2).gfK;
        this.ngS.ndg = ((g.a)localObject2).gfL;
        this.ngS.ndh = ((g.a)localObject2).gfM;
        this.ngS.ndi = ((g.a)localObject2).gfN;
        this.ngS.ncB = this.ngT;
        this.ngS.ncH = this.ngU;
        this.ngS.mSu = bEw().mSu;
        com.tencent.mm.plugin.brandservice.ui.timeline.preload.j.ned.a(this, str, bEw(), (d.g.a.q)new s(this));
        i = j;
        break;
        bool = false;
        break label233;
        label541:
        i = 103;
        break label252;
        this.ngS.ndt = 1;
        this.ngT = ((g.a)localObject2).gfF;
        continue;
        this.ngS.ndt = 2;
        this.ngT = -1L;
      }
    }
    this.ngS.a(this.ncu);
    localObject1 = this.ngS;
    localObject2 = bEx();
    d.g.b.k.h(localObject2, "<set-?>");
    ((com.tencent.mm.plugin.brandservice.ui.timeline.preload.f)localObject1).url = ((String)localObject2);
    boolean bool = Ss(nhl);
    this.ngS.ndk = bool;
    this.ngS.ndj = this.ngX;
    this.ngS.ndI = this.nhy.getWebCoreType().name();
    if (bool) {}
    for (int i = 106;; i = 105)
    {
      com.tencent.mm.plugin.webview.g.a.SW(i);
      BaseWebViewController.a(this, bEx());
      if (!this.nhi)
      {
        com.tencent.mm.sdk.platformtools.ad.i(getTAG(), "check notifyPage");
        bEF();
        aFm().postUIDelayed(this.nhj, this.ngY);
      }
      AppMethodBeat.o(193295);
      return;
    }
  }
  
  public final boolean bEE()
  {
    return false;
  }
  
  public final boolean bEH()
  {
    AppMethodBeat.i(193306);
    boolean bool = Ss(this.ALg);
    AppMethodBeat.o(193306);
    return bool;
  }
  
  public final String bEx()
  {
    AppMethodBeat.i(193288);
    String str = getIntent().getStringExtra("rawUrl");
    d.g.b.k.g(str, "intent.getStringExtra(Co…antsUI.WebViewUI.KRawUrl)");
    str = n.bb(str, "http://", "https://");
    AppMethodBeat.o(193288);
    return str;
  }
  
  public final boolean bEy()
  {
    AppMethodBeat.i(193289);
    if ((Ss(nho)) || (Ss(nhp)))
    {
      AppMethodBeat.o(193289);
      return true;
    }
    AppMethodBeat.o(193289);
    return false;
  }
  
  public final boolean bEz()
  {
    AppMethodBeat.i(193290);
    if ((Ss(this.ALg)) && (Ss(nhl)))
    {
      AppMethodBeat.o(193290);
      return true;
    }
    AppMethodBeat.o(193290);
    return false;
  }
  
  final String getTAG()
  {
    AppMethodBeat.i(193286);
    String str = (String)this.ngR.getValue();
    AppMethodBeat.o(193286);
    return str;
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$ForceUrl;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$ControllerAction;", "()V", "verify", "", "plugin-brandservice_release"})
  @Keep
  protected static final class ForceUrl
    extends BaseWebViewController.ControllerAction
  {
    public final boolean verify()
    {
      AppMethodBeat.i(193240);
      Object localObject = getController();
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.MpWebViewController");
        AppMethodBeat.o(193240);
        throw ((Throwable)localObject);
      }
      localObject = (MpWebViewController)localObject;
      MpWebViewController.e locale = MpWebViewController.nhv;
      if (((waitFor(MpWebViewController.bEQ())) || (waitFor(MpWebViewController.bEN())) || (waitFor(MpWebViewController.bEO()))) && (waitFor(MpWebViewController.b((MpWebViewController)localObject))))
      {
        AppMethodBeat.o(193240);
        return true;
      }
      AppMethodBeat.o(193240);
      return false;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$NotifyAuth;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$ControllerAction;", "()V", "verify", "", "plugin-brandservice_release"})
  @Keep
  protected static final class NotifyAuth
    extends BaseWebViewController.ControllerAction
  {
    public final boolean verify()
    {
      AppMethodBeat.i(193251);
      Object localObject = getController();
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.MpWebViewController");
        AppMethodBeat.o(193251);
        throw ((Throwable)localObject);
      }
      localObject = (MpWebViewController)localObject;
      if ((waitFor(MpWebViewController.bEI())) && (((waitFor(MpWebViewController.a((MpWebViewController)localObject))) && (waitFor(MpWebViewController.bEK()))) || (waitFor(MpWebViewController.bEL()))))
      {
        AppMethodBeat.o(193251);
        return true;
      }
      AppMethodBeat.o(193251);
      return false;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$PreloadNext;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$ControllerAction;", "()V", "verify", "", "plugin-brandservice_release"})
  @Keep
  protected static final class PreloadNext
    extends BaseWebViewController.ControllerAction
  {
    public final boolean verify()
    {
      AppMethodBeat.i(193252);
      if (getController() == null)
      {
        v localv = new v("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.MpWebViewController");
        AppMethodBeat.o(193252);
        throw localv;
      }
      boolean bool = waitFor(MpWebViewController.bEM());
      AppMethodBeat.o(193252);
      return bool;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$StartPreload;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$ControllerAction;", "()V", "verify", "", "plugin-brandservice_release"})
  @Keep
  protected static final class StartPreload
    extends BaseWebViewController.ControllerAction
  {
    public final boolean verify()
    {
      AppMethodBeat.i(193253);
      Object localObject = getController();
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.MpWebViewController");
        AppMethodBeat.o(193253);
        throw ((Throwable)localObject);
      }
      boolean bool = waitFor(MpWebViewController.b((MpWebViewController)localObject));
      AppMethodBeat.o(193253);
      return bool;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$UpdateData;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$ControllerAction;", "()V", "verify", "", "plugin-brandservice_release"})
  @Keep
  protected static final class UpdateData
    extends BaseWebViewController.ControllerAction
  {
    public final boolean verify()
    {
      AppMethodBeat.i(193255);
      if (getController() == null)
      {
        v localv = new v("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.MpWebViewController");
        AppMethodBeat.o(193255);
        throw localv;
      }
      if ((waitFor(MpWebViewController.bEI())) && (waitFor(MpWebViewController.bEJ())))
      {
        AppMethodBeat.o(193255);
        return true;
      }
      AppMethodBeat.o(193255);
      return false;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$actionsCheckList$1$2"})
  static final class a
    extends d.g.b.l
    implements d.g.a.a<d.y>
  {
    a(MpWebViewController paramMpWebViewController)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$actionsCheckList$1$4"})
  static final class b
    extends d.g.b.l
    implements d.g.a.a<d.y>
  {
    b(MpWebViewController paramMpWebViewController)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$actionsCheckList$1$5"})
  static final class c
    extends d.g.b.l
    implements d.g.a.a<d.y>
  {
    c(MpWebViewController paramMpWebViewController)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$1$1"})
  static final class d
    extends d.g.b.l
    implements d.g.a.a<String>
  {
    d(MpWebViewController paramMpWebViewController)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$Companion;", "", "()V", "MP_AUTH_ERR", "", "MP_AUTH_NOTIFIED", "MP_AUTH_SUCC", "MP_DATA_INJECT_ERR", "MP_DATA_INJECT_SUCC", "MP_DATA_READY", "MP_NOTIFY_ERR", "MP_PRELOAD_NEXT", "MP_TMPL_CHECKING", "MP_TMPL_ERR", "getMP_TMPL_ERR$plugin_brandservice_release", "()I", "MP_TMPL_READY", "readFileWebResp", "Lcom/tencent/xweb/WebResourceResponse;", "webview", "Lcom/tencent/xweb/WebView;", "fileName", "", "plugin-brandservice_release"})
  public static final class e
  {
    static WebResourceResponse g(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(193239);
      if (!com.tencent.mm.vfs.i.eK(paramString))
      {
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.WebViewController", "tmpl file not found:".concat(String.valueOf(paramString)));
        AppMethodBeat.o(193239);
        return null;
      }
      Object localObject1 = com.tencent.mm.sdk.f.d.aCP(paramString);
      Object localObject2;
      if ((n.mB(paramString, ".js")) && (com.tencent.mm.plugin.webview.c.i.b(paramWebView)))
      {
        paramWebView = new ae(3, 256, paramWebView);
        paramWebView.aPf(paramString);
        paramWebView = paramWebView.toString();
        localObject2 = StandardCharsets.UTF_8;
        d.g.b.k.g(localObject2, "StandardCharsets.UTF_8");
        if (paramWebView == null)
        {
          paramWebView = new v("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(193239);
          throw paramWebView;
        }
        localObject2 = paramWebView.getBytes((Charset)localObject2);
        d.g.b.k.g(localObject2, "(this as java.lang.String).getBytes(charset)");
        localObject1 = new WebResourceResponse((String)localObject1, "UTF-8", (InputStream)new ByteArrayInputStream((byte[])localObject2));
      }
      for (;;)
      {
        localObject2 = new HashMap();
        str = Integer.toHexString(paramString.hashCode() & 0xFFFFFFFF);
        d.g.b.k.g(str, "Integer.toHexString(file…Code() and (-1).ushr(32))");
        if (str != null) {
          break;
        }
        paramWebView = new v("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(193239);
        throw paramWebView;
        try
        {
          paramWebView = (InputStream)new FileInputStream(paramString);
          if (paramWebView == null)
          {
            com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.WebViewController", "stream is null, err");
            AppMethodBeat.o(193239);
            return null;
          }
        }
        catch (FileNotFoundException paramWebView)
        {
          for (;;)
          {
            com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.WebViewController", (Throwable)paramWebView, "", new Object[0]);
            paramWebView = null;
          }
          localObject1 = new WebResourceResponse((String)localObject1, "UTF-8", paramWebView);
          paramWebView = null;
        }
      }
      String str = str.toLowerCase();
      d.g.b.k.g(str, "(this as java.lang.String).toLowerCase()");
      ((Map)localObject2).put("Cache-Control", "max-age=31536000");
      ((Map)localObject2).put("ETag", str);
      if (paramWebView != null) {
        ((Map)localObject2).put("RunLocalJS", paramWebView);
      }
      ((WebResourceResponse)localObject1).setResponseHeaders((Map)localObject2);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebViewController", "readFileWebResp:%s\nETag:%s", new Object[] { paramString, str });
      AppMethodBeat.o(193239);
      return localObject1;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$MpWebViewInterceptor;", "Lcom/tencent/mm/plugin/webview/core/WebViewInterceptor;", "tmplParams", "Lcom/tencent/mm/protocal/protobuf/TmplParams;", "viewWV", "Lcom/tencent/mm/ui/widget/MMWebView;", "(Lcom/tencent/mm/protocal/protobuf/TmplParams;Lcom/tencent/mm/ui/widget/MMWebView;)V", "getTmplParams", "()Lcom/tencent/mm/protocal/protobuf/TmplParams;", "getViewWV", "()Lcom/tencent/mm/ui/widget/MMWebView;", "intercept", "Lcom/tencent/xweb/WebResourceResponse;", "webview", "Lcom/tencent/xweb/WebView;", "request", "Lcom/tencent/xweb/WebResourceRequest;", "overrideReload", "", "url", "", "overrideUrl", "Lcom/tencent/mm/plugin/webview/core/WebViewInterceptor$OverrideUrlResult;", "webView", "overrideUrlRedirect", "reason", "", "reqUrl", "fullUrl", "plugin-brandservice_release"})
  static final class f
    extends com.tencent.mm.plugin.webview.core.j
  {
    private final dch ncu;
    private final MMWebView nhy;
    
    public f(dch paramdch, MMWebView paramMMWebView)
    {
      AppMethodBeat.i(193250);
      this.ncu = paramdch;
      this.nhy = paramMMWebView;
      AppMethodBeat.o(193250);
    }
    
    public final boolean PW(String paramString)
    {
      AppMethodBeat.i(193248);
      d.g.b.k.h(paramString, "url");
      Object localObject2 = getController();
      Object localObject1 = localObject2;
      if (!(localObject2 instanceof MpWebViewController)) {
        localObject1 = null;
      }
      localObject1 = (MpWebViewController)localObject1;
      if ((localObject1 != null) && (((MpWebViewController.a((MpWebViewController)localObject1, MpWebViewController.b((MpWebViewController)localObject1))) && (d.g.b.k.g(com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.Ps(paramString), com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.Ps(((MpWebViewController)localObject1).bEx())))) || ((MpWebViewController.a((MpWebViewController)localObject1, MpWebViewController.bEK())) && (d.g.b.k.g(com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.Ps(paramString), com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.Ps(MpWebViewController.c((MpWebViewController)localObject1)))) && (getController().ejh()))))
      {
        localObject2 = ((Iterable)MpWebViewController.d((MpWebViewController)localObject1)).iterator();
        while (((Iterator)localObject2).hasNext()) {
          com.tencent.mm.ad.c.g((d.g.a.a)new b((com.tencent.mm.plugin.webview.core.i)((Iterator)localObject2).next()));
        }
        ((BaseWebViewController)localObject1).ALa = true;
        ((MpWebViewController)localObject1).k(MpWebViewController.PV(paramString), true, 8);
        AppMethodBeat.o(193248);
        return true;
      }
      AppMethodBeat.o(193248);
      return false;
    }
    
    public final WebResourceResponse b(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
    {
      AppMethodBeat.i(193247);
      d.g.b.k.h(paramWebView, "webview");
      d.g.b.k.h(paramWebResourceRequest, "request");
      paramWebView = paramWebResourceRequest.getUrl().toString();
      d.g.b.k.g(paramWebView, "request.url.toString()");
      if (((d.g.b.k.g(paramWebView, this.ncu.ASo) ^ true)) && (!n.mA(paramWebView, com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b.getPrefix())))
      {
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.WebViewController", "WebView-Trace intercept return");
        AppMethodBeat.o(193247);
        return null;
      }
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebViewController", "getResourceResponse, requrl:%s, url:%s", new Object[] { paramWebView, this.ncu.EtM });
      if (paramWebResourceRequest.isForMainFrame())
      {
        paramWebView = this.ncu.EtM;
        d.g.b.k.g(paramWebView, "tmplParams.initFilePath");
        paramWebView = new a(paramWebView, false);
      }
      while (paramWebView != null)
      {
        com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.WebViewController", "response path: " + paramWebView.path);
        paramWebResourceRequest = MpWebViewController.nhv;
        paramWebResourceRequest = MpWebViewController.e.g((WebView)this.nhy, paramWebView.path);
        if (paramWebResourceRequest != null)
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebViewController", "return intercepted success");
          AppMethodBeat.o(193247);
          return paramWebResourceRequest;
          int i;
          if (n.mA(paramWebView, com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b.bEt()))
          {
            i = this.ncu.nee;
            paramWebResourceRequest = this.ncu.yaG;
            d.g.b.k.g(paramWebResourceRequest, "tmplParams.uid");
            paramWebView = (CharSequence)paramWebView;
            paramWebView = new a(com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.t(i, paramWebResourceRequest, new d.n.k(com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b.bEt()).d(paramWebView, "")), true);
          }
          else if (n.mA(paramWebView, com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b.getPrefix()))
          {
            i = this.ncu.nee;
            paramWebResourceRequest = this.ncu.yaG;
            d.g.b.k.g(paramWebResourceRequest, "tmplParams.uid");
            paramWebView = (CharSequence)paramWebView;
            paramWebView = new a(com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.t(i, paramWebResourceRequest, new d.n.k(com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b.getPrefix()).d(paramWebView, "")), true);
          }
          else
          {
            paramWebView = null;
          }
        }
        else
        {
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.WebViewController", "return intercepted null");
          com.tencent.mm.plugin.webview.g.a.fL(this.ncu.reportId, 126);
          if (paramWebView.ndo) {
            com.tencent.mm.plugin.webview.g.a.fL(this.ncu.reportId, 233);
          }
        }
      }
      AppMethodBeat.o(193247);
      return null;
    }
    
    public final j.a c(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
    {
      AppMethodBeat.i(193249);
      d.g.b.k.h(paramWebView, "webView");
      d.g.b.k.h(paramWebResourceRequest, "request");
      Object localObject2 = getController();
      Object localObject1 = localObject2;
      if (!(localObject2 instanceof MpWebViewController)) {
        localObject1 = null;
      }
      localObject1 = (MpWebViewController)localObject1;
      if ((localObject1 != null) && (paramWebResourceRequest.isForMainFrame()) && (paramWebResourceRequest.getUrl() != null))
      {
        com.tencent.mm.sdk.platformtools.ad.i(MpWebViewController.e((MpWebViewController)localObject1), "edw opt, shouldOverride url isForMainFrame");
        localObject2 = paramWebResourceRequest.getUrl().toString();
        d.g.b.k.g(localObject2, "request.url.toString()");
        if ((!n.mA((String)localObject2, "https://mp.weixin.qq.com/__tmpl__/")) && (getController().ejh()))
        {
          com.tencent.mm.sdk.platformtools.ad.i(MpWebViewController.e((MpWebViewController)localObject1), "edw opt, shouldOverride url exitTmpl");
          ((BaseWebViewController)localObject1).ALa = true;
        }
      }
      paramWebView = super.c(paramWebView, paramWebResourceRequest);
      AppMethodBeat.o(193249);
      return paramWebView;
    }
    
    public final boolean u(int paramInt, String paramString1, String paramString2)
    {
      AppMethodBeat.i(193246);
      d.g.b.k.h(paramString1, "reqUrl");
      d.g.b.k.h(paramString2, "fullUrl");
      if ((paramInt == 0) && (UrlExKt.isMpUrl(paramString2)) && (d.g.b.k.g(com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.Ps(paramString1), com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.Ps(paramString2))))
      {
        AppMethodBeat.o(193246);
        return true;
      }
      boolean bool = super.u(paramInt, paramString1, paramString2);
      AppMethodBeat.o(193246);
      return bool;
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$MpWebViewInterceptor$intercept$InterceptInfo", "", "path", "", "isZip", "", "(Ljava/lang/String;Z)V", "()Z", "getPath", "()Ljava/lang/String;", "component1", "component2", "copy", "(Ljava/lang/String;Z)Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$MpWebViewInterceptor$intercept$InterceptInfo;", "equals", "other", "hashCode", "", "toString", "plugin-brandservice_release"})
    public static final class a
    {
      final boolean ndo;
      final String path;
      
      public a(String paramString, boolean paramBoolean)
      {
        AppMethodBeat.i(193241);
        this.path = paramString;
        this.ndo = paramBoolean;
        AppMethodBeat.o(193241);
      }
      
      public final boolean equals(Object paramObject)
      {
        AppMethodBeat.i(193244);
        if (this != paramObject)
        {
          if ((paramObject instanceof a))
          {
            paramObject = (a)paramObject;
            if ((!d.g.b.k.g(this.path, paramObject.path)) || (this.ndo != paramObject.ndo)) {}
          }
        }
        else
        {
          AppMethodBeat.o(193244);
          return true;
        }
        AppMethodBeat.o(193244);
        return false;
      }
      
      public final int hashCode()
      {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
      }
      
      public final String toString()
      {
        AppMethodBeat.i(193242);
        String str = "InterceptInfo(path=" + this.path + ", isZip=" + this.ndo + ")";
        AppMethodBeat.o(193242);
        return str;
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
    static final class b
      extends d.g.b.l
      implements d.g.a.a<d.y>
    {
      b(com.tencent.mm.plugin.webview.core.i parami)
      {
        super();
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class g
    extends d.g.b.l
    implements d.g.a.a<String>
  {
    g(MpWebViewController paramMpWebViewController)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "value", "", "invoke"})
  static final class j
    extends d.g.b.l
    implements d.g.a.b<String, d.y>
  {
    j(MpWebViewController paramMpWebViewController)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class k
    implements Runnable
  {
    k(MpWebViewController paramMpWebViewController) {}
    
    public final void run()
    {
      AppMethodBeat.i(193261);
      com.tencent.mm.sdk.platformtools.ad.v(MpWebViewController.e(this.nhw), "checkNotifyPageTimer isNotifyPageSuccess=" + this.nhw.nhi);
      if (!this.nhw.nhi)
      {
        com.tencent.mm.plugin.webview.g.a.lI(92);
        this.nhw.ngS.ndK = true;
        this.nhw.ngS.ndL = true;
        MpWebViewController.p(this.nhw);
        MpWebViewController.b(this.nhw, MpWebViewController.bEO());
        com.tencent.mm.sdk.platformtools.ad.e(MpWebViewController.e(this.nhw), "check notifyPage timeout");
      }
      AppMethodBeat.o(193261);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$initEnviroment$1", "", "__getString", "", "__log", "", "value", "plugin-brandservice_release"})
  public static final class l
  {
    @android.webkit.JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final String __getString()
    {
      AppMethodBeat.i(193263);
      Object localObject1 = MpWebViewController.f(this.nhw);
      d.g.b.k.h(localObject1, "$this$getContent");
      Object localObject2 = com.tencent.mm.plugin.brandservice.ui.timeline.preload.j.ned;
      localObject1 = com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b(com.tencent.mm.plugin.brandservice.ui.timeline.preload.j.bDK(), (String)localObject1);
      if (localObject1 != null)
      {
        localObject2 = com.tencent.mm.vfs.f.ag((e)localObject1);
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = "";
      }
      AppMethodBeat.o(193263);
      return localObject1;
    }
    
    @android.webkit.JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void __log(String paramString)
    {
      AppMethodBeat.i(193262);
      Object localObject = this.nhw;
      if (paramString != null)
      {
        paramString = new JSONObject(paramString).getJSONObject("err");
        if (paramString != null)
        {
          int i = paramString.getInt("errCode");
          paramString = paramString.getString("msg");
          String str = ((MpWebViewController)localObject).getTAG();
          StringBuilder localStringBuilder = new StringBuilder("onWebLog:");
          localObject = ((MpWebViewController)localObject).bnZ;
          if (localObject == null) {
            d.g.b.k.aPZ("contentId");
          }
          com.tencent.mm.sdk.platformtools.ad.e(str, (String)localObject + ',' + i + ',' + paramString);
          com.tencent.mm.plugin.webview.g.a.SW(114);
          AppMethodBeat.o(193262);
          return;
        }
      }
      AppMethodBeat.o(193262);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Lcom/tencent/mm/protocal/JsapiPermissionWrapper;", "handleMsg"})
  static final class m
    implements f.a
  {
    m(MpWebViewController paramMpWebViewController) {}
    
    public final boolean b(com.tencent.mm.plugin.webview.c.l paraml)
    {
      AppMethodBeat.i(193264);
      MpWebViewController localMpWebViewController;
      if (d.g.b.k.g(paraml.kbU, "notifyPageInfo"))
      {
        com.tencent.mm.sdk.platformtools.ad.v(MpWebViewController.e(this.nhw), "handleMsg " + paraml.kbU);
        localMpWebViewController = this.nhw;
        d.g.b.k.g(paraml, "msg");
        MpWebViewController.a(localMpWebViewController, paraml);
        AppMethodBeat.o(193264);
        return true;
      }
      if (d.g.b.k.g(paraml.kbU, "updatePageAuth"))
      {
        com.tencent.mm.sdk.platformtools.ad.v(MpWebViewController.e(this.nhw), "handleMsg " + paraml.kbU);
        localMpWebViewController = this.nhw;
        d.g.b.k.g(paraml, "msg");
        MpWebViewController.b(localMpWebViewController, paraml);
        AppMethodBeat.o(193264);
        return true;
      }
      AppMethodBeat.o(193264);
      return false;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$loadTmpl$InterceptInfo", "", "path", "", "isZip", "", "(Ljava/lang/String;Z)V", "()Z", "getPath", "()Ljava/lang/String;", "component1", "component2", "copy", "(Ljava/lang/String;Z)Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$loadTmpl$InterceptInfo;", "equals", "other", "hashCode", "", "toString", "plugin-brandservice_release"})
  public static final class n
  {
    final boolean ndo;
    final String path;
    
    public n(String paramString)
    {
      AppMethodBeat.i(193265);
      this.path = paramString;
      this.ndo = false;
      AppMethodBeat.o(193265);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(193268);
      if (this != paramObject)
      {
        if ((paramObject instanceof n))
        {
          paramObject = (n)paramObject;
          if ((!d.g.b.k.g(this.path, paramObject.path)) || (this.ndo != paramObject.ndo)) {}
        }
      }
      else
      {
        AppMethodBeat.o(193268);
        return true;
      }
      AppMethodBeat.o(193268);
      return false;
    }
    
    public final int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final String toString()
    {
      AppMethodBeat.i(193266);
      String str = "InterceptInfo(path=" + this.path + ", isZip=" + this.ndo + ")";
      AppMethodBeat.o(193266);
      return str;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"getNotifyPageInfoString", "", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "invoke"})
  static final class o
    extends d.g.b.l
    implements d.g.a.b<com.tencent.mm.plugin.webview.c.l, String>
  {
    public static final o nhA;
    
    static
    {
      AppMethodBeat.i(193271);
      nhA = new o();
      AppMethodBeat.o(193271);
    }
    
    o()
    {
      super();
    }
    
    public static String c(com.tencent.mm.plugin.webview.c.l paraml)
    {
      AppMethodBeat.i(193270);
      d.g.b.k.h(paraml, "msg");
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("performance", (String)paraml.uLu.get("performance"));
      localJSONObject.put("injectPageDataResult", (String)paraml.uLu.get("injectPageDataResult"));
      paraml = localJSONObject.toString();
      d.g.b.k.g(paraml, "pageInfo.toString()");
      AppMethodBeat.o(193270);
      return paraml;
    }
  }
  
  @d.d.b.a.f(c="com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.MpWebViewController$notifyPageInfo$2", f="MpWebViewController.kt", l={422}, m="invokeSuspend")
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class p
    extends d.d.b.a.j
    implements m<kotlinx.coroutines.ad, d.d.d<? super d.y>, Object>
  {
    int label;
    private kotlinx.coroutines.ad mTa;
    Object mTb;
    
    p(MpWebViewController paramMpWebViewController, d.d.d paramd)
    {
      super();
    }
    
    public final d.d.d<d.y> a(Object paramObject, d.d.d<?> paramd)
    {
      AppMethodBeat.i(193273);
      d.g.b.k.h(paramd, "completion");
      paramd = new p(this.nhw, paramd);
      paramd.mTa = ((kotlinx.coroutines.ad)paramObject);
      AppMethodBeat.o(193273);
      return paramd;
    }
    
    public final Object cP(Object paramObject)
    {
      AppMethodBeat.i(193272);
      paramObject = d.d.a.a.JgJ;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(193272);
        throw paramObject;
      case 0: 
        this.mTb = this.mTa;
        this.label = 1;
        if (ao.a(300L, this) == paramObject)
        {
          AppMethodBeat.o(193272);
          return paramObject;
        }
        break;
      }
      MpWebViewController.b(this.nhw, MpWebViewController.bEM());
      paramObject = d.y.JfV;
      AppMethodBeat.o(193272);
      return paramObject;
    }
    
    public final Object n(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(193274);
      paramObject1 = ((p)a(paramObject1, (d.d.d)paramObject2)).cP(d.y.JfV);
      AppMethodBeat.o(193274);
      return paramObject1;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "titles", "", "data", "performance", "", "Lkotlin/Pair;", "invoke"})
  static final class q
    extends d.g.b.l
    implements d.g.a.q<String, String, List<? extends o<? extends String, ? extends String>>, d.y>
  {
    q(MpWebViewController paramMpWebViewController)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "titles", "", "data", "performance", "", "Lkotlin/Pair;", "invoke"})
  static final class r
    extends d.g.b.l
    implements d.g.a.q<String, String, List<? extends o<? extends String, ? extends String>>, d.y>
  {
    r(MpWebViewController paramMpWebViewController)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "contextRef", "Ljava/lang/ref/WeakReference;", "", "result", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$MountableCGIResult;", "appMsgContext", "Lcom/tencent/mm/protocal/protobuf/AppMsgContext;", "invoke"})
  static final class s
    extends d.g.b.l
    implements d.g.a.q<WeakReference<Object>, j.c, eu, d.y>
  {
    s(MpWebViewController paramMpWebViewController)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Lcom/tencent/mm/protocal/protobuf/PreloadSession;", "invoke"})
  static final class t
    extends d.g.b.l
    implements d.g.a.a<cbz>
  {
    t(MpWebViewController paramMpWebViewController, MMWebView paramMMWebView)
    {
      super();
    }
    
    private cbz bER()
    {
      AppMethodBeat.i(193279);
      try
      {
        localObject1 = MpWebViewController.l(this.nhw);
        localObject3 = e.m.FIv;
        d.g.b.k.g(localObject3, "ConstantsUI.WebViewUI.KTmplSession");
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
        cbz localcbz;
        for (;;)
        {
          try
          {
            Object localObject3 = cbz.class.newInstance();
            ((com.tencent.mm.bx.a)localObject3).parseFrom((byte[])localObject1);
            Object localObject1 = (com.tencent.mm.bx.a)localObject3;
            localObject3 = (cbz)localObject1;
            localObject1 = localObject3;
            if (localObject3 != null) {
              break;
            }
            localObject1 = (Throwable)new Resources.NotFoundException("TmplSession");
            AppMethodBeat.o(193279);
            throw ((Throwable)localObject1);
          }
          catch (Exception localException2)
          {
            int i;
            Object localObject2;
            com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("Intent.decodeProtoBuffer", (Throwable)localException2, "decode ProtoBuffer", new Object[0]);
          }
          localException1 = localException1;
          com.tencent.mm.sdk.platformtools.ad.e(MpWebViewController.e(this.nhw), "session is null, " + localException1.getMessage() + ' ' + com.tencent.mm.plugin.brandservice.ui.timeline.preload.d.ae(MpWebViewController.l(this.nhw)));
          com.tencent.mm.plugin.webview.g.a.SW(153);
          com.tencent.mm.plugin.report.service.h.vKh.f(17260, new Object[] { Integer.valueOf(2), com.tencent.mm.plugin.brandservice.ui.timeline.preload.d.ae(MpWebViewController.l(this.nhw)) });
          if ((paramMMWebView.getActivityContextIfHas() instanceof Activity))
          {
            localObject2 = paramMMWebView.getActivityContextIfHas();
            if (localObject2 == null)
            {
              localObject2 = new v("null cannot be cast to non-null type android.app.Activity");
              AppMethodBeat.o(193279);
              throw ((Throwable)localObject2);
              i = 0;
              continue;
              i = 0;
              continue;
              localcbz = null;
            }
            else
            {
              ((Activity)localcbz).finish();
            }
          }
          else
          {
            localcbz = new cbz();
          }
        }
        AppMethodBeat.o(193279);
        return localcbz;
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
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "", "invoke"})
  static final class u
    extends d.g.b.l
    implements d.g.a.b<String, d.y>
  {
    u(MpWebViewController paramMpWebViewController)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "value", "", "invoke"})
  static final class v
    extends d.g.b.l
    implements d.g.a.b<String, d.y>
  {
    v(MpWebViewController paramMpWebViewController)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "value", "", "invoke"})
  static final class w
    extends d.g.b.l
    implements d.g.a.b<String, d.y>
  {
    w(MpWebViewController paramMpWebViewController)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "value", "", "invoke"})
  static final class x
    extends d.g.b.l
    implements d.g.a.b<String, d.y>
  {
    x(MpWebViewController paramMpWebViewController, long paramLong1, v.a parama, long paramLong2)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "callback"})
  static final class y
    implements IPCRunCgi.a
  {
    y(MpWebViewController paramMpWebViewController, String paramString, com.tencent.mm.plugin.webview.c.l paraml) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.b paramb)
    {
      AppMethodBeat.i(193284);
      MpWebViewController.g(this.nhw).remove(this.nhE);
      d.g.b.k.g(paramb, "rr");
      if (!(paramb.auM() instanceof aoj))
      {
        AppMethodBeat.o(193284);
        return;
      }
      paramString = paramb.auM();
      if (paramString == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetA8KeyResp");
        AppMethodBeat.o(193284);
        throw paramString;
      }
      paramString = (aoj)paramString;
      if (bt.isNullOrNil(paramString.DpW))
      {
        com.tencent.mm.sdk.platformtools.ad.e(MpWebViewController.e(this.nhw), "updatePageAuth fail fullurl is null");
        com.tencent.mm.plugin.webview.g.a.lI(82);
        paramString = this.nhw.getJsapi();
        if (paramString != null)
        {
          paramString.h(this.nhF.ASg, this.nhF.kbU + ":fail", null);
          AppMethodBeat.o(193284);
          return;
        }
        AppMethodBeat.o(193284);
        return;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        try
        {
          paramb = new JsapiPermissionWrapper(z.a(paramString.Dqf));
          Object localObject = new GeneralControlWrapper(paramString.DpZ);
          this.nhw.kxg.a(paramString.DpW, paramb, (GeneralControlWrapper)localObject);
          paramb = this.nhw;
          localObject = this.nhE;
          String str = paramString.DpW;
          d.g.b.k.g(str, "resp.FullURL");
          Map localMap = com.tencent.mm.plugin.webview.e.c.gx((List)paramString.Dqh);
          d.g.b.k.g(localMap, "LuggageGetA8Key.getHttpHeaders(resp.HttpHeader)");
          MpWebViewController.a(paramb, (String)localObject, str, localMap);
          com.tencent.mm.plugin.webview.g.a.SW(109);
          paramb = (Map)new HashMap();
          paramString = paramString.DpW;
          d.g.b.k.g(paramString, "resp.FullURL");
          paramb.put("fullUrl", paramString);
          com.tencent.mm.sdk.platformtools.ad.i(MpWebViewController.e(this.nhw), "updatePageAuth values:%s", new Object[] { paramb });
          com.tencent.mm.plugin.webview.g.a.lI(81);
          paramString = this.nhw.getJsapi();
          if (paramString != null)
          {
            paramString.h(this.nhF.ASg, this.nhF.kbU + ":ok", paramb);
            AppMethodBeat.o(193284);
            return;
          }
        }
        catch (Exception paramString)
        {
          com.tencent.mm.plugin.webview.g.a.lI(82);
          paramString = this.nhw.getJsapi();
          if (paramString != null)
          {
            paramString.h(this.nhF.ASg, this.nhF.kbU + ":fail", null);
            AppMethodBeat.o(193284);
            return;
            AppMethodBeat.o(193284);
            return;
          }
          AppMethodBeat.o(193284);
          return;
        }
      }
      com.tencent.mm.plugin.webview.g.a.lI(82);
      paramString = this.nhw.getJsapi();
      if (paramString != null)
      {
        paramString.h(this.nhF.ASg, this.nhF.kbU + ":fail", null);
        AppMethodBeat.o(193284);
        return;
      }
      AppMethodBeat.o(193284);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.MpWebViewController
 * JD-Core Version:    0.7.0.1
 */