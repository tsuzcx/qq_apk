package com.tencent.mm.plugin.ay;

import android.webkit.ValueCallback;
import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.IJSRuntime;
import com.tencent.mm.appbrand.v8.IJSRuntime.Config;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkg;
import com.tencent.mm.plugin.appbrand.n.g;
import com.tencent.mm.plugin.appbrand.n.x;
import com.tencent.mm.plugin.ax.l;
import com.tencent.mm.plugin.ax.m;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.vfs.y;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webjsengine/WebJsEngine;", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandNodeJSBasedJsEngine;", "Lcom/tencent/mm/plugin/webjsapi/JSEngineAPIContext;", "()V", "contextMap", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "debuggerListener", "Lcom/tencent/mm/api/DevToolsListener;", "engineMap", "engineReporter", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngineReporter;", "getEngineReporter", "()Lcom/tencent/mm/plugin/webjsengine/WebJsEngineReporter;", "isDestroyed", "", "meta", "Lcom/tencent/mm/json/JSONObject;", "getMeta", "()Lcom/tencent/mm/json/JSONObject;", "meta$delegate", "Lkotlin/Lazy;", "nativeContextJs", "kotlin.jvm.PlatformType", "getNativeContextJs", "()Ljava/lang/String;", "nativeContextJs$delegate", "version", "getVersion", "()I", "version$delegate", "vmConfig", "getVmConfig", "vmConfig$delegate", "wxaPkg", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;", "getWxaPkg", "()Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;", "config", "", "cb", "Lkotlin/Function1;", "configClient", "context", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJSContext;", "name", "type", "clientInfo", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngine$ClientInfo;", "createJSRuntime", "Lcom/tencent/mm/appbrand/v8/IJSRuntime;", "Lcom/tencent/mm/appbrand/v8/IJSRuntime$Config;", "destroy", "dispatch", "eventType", "event", "Landroid/webkit/ValueCallback;", "getCacheCategory", "appId", "path", "getClientConfig", "getClientInfo", "getEngineName", "invoke", "target", "func", "params", "", "", "callback", "message", "targetOrigin", "onConfigClientInject", "contextReporter", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngineContextReporter;", "onError", "contextId", "stackTrace", "onTransferMessage", "setup", "clientReporter", "cache", "ClientInfo", "Companion", "ReadPkgResult", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class c
  extends x
  implements com.tencent.mm.plugin.ax.c
{
  private static final String TAG;
  public static final b Wmq = new b((byte)0);
  private static final kotlin.j<Boolean> Wmw;
  private static final String Wmx;
  private static com.tencent.mm.memory.a.c<String, com.tencent.mm.ad.i> Wmy = new com.tencent.mm.memory.a.c(1);
  private com.tencent.mm.api.e SJW;
  private final kotlin.j WkS = kotlin.k.cm((kotlin.g.a.a)new k(this));
  private final HashMap<String, Integer> Wmr = new HashMap();
  private final kotlin.j Wms = kotlin.k.cm((kotlin.g.a.a)new h(this));
  private final kotlin.j Wmt = kotlin.k.cm((kotlin.g.a.a)new j(this));
  private final HashMap<String, Integer> Wmu = new HashMap();
  private final kotlin.j Wmv = kotlin.k.cm((kotlin.g.a.a)i.WmM);
  private boolean aUP;
  
  static
  {
    TAG = "MicroMsg.WebJsEngine";
    Wmw = kotlin.k.cm((kotlin.g.a.a)c.WmC);
    String str = kotlin.g.b.s.X(com.tencent.mm.loader.i.b.bmz(), "jsengine/pkg");
    Log.i("DEBUG_PATH", kotlin.g.b.s.X("WebCanvas debug path = ", str));
    Wmx = str;
  }
  
  /* Error */
  private void a(com.tencent.mm.ad.i parami, g paramg, d paramd, boolean paramBoolean, String paramString1, String paramString2, kotlin.g.a.b<? super String, kotlin.ah> paramb)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc_w 256
    //   4: invokestatic 260	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   7: aload_2
    //   8: ldc_w 261
    //   11: invokestatic 260	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   14: aload_3
    //   15: ldc_w 262
    //   18: invokestatic 260	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   21: aload 5
    //   23: ldc_w 263
    //   26: invokestatic 260	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   29: aload 6
    //   31: ldc_w 264
    //   34: invokestatic 260	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   37: aload_0
    //   38: getfield 266	com/tencent/mm/plugin/ay/c:aUP	Z
    //   41: ifeq +13 -> 54
    //   44: getstatic 179	com/tencent/mm/plugin/ay/c:TAG	Ljava/lang/String;
    //   47: ldc_w 268
    //   50: invokestatic 271	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   53: return
    //   54: new 273	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 274	java/lang/StringBuilder:<init>	()V
    //   61: aload 5
    //   63: invokevirtual 278	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: ldc_w 280
    //   69: invokevirtual 278	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: aload_2
    //   73: invokeinterface 285 1 0
    //   78: invokevirtual 288	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   81: invokevirtual 291	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   84: astore 12
    //   86: aload_2
    //   87: new 293	com/tencent/mm/plugin/ay/c$$ExternalSyntheticLambda3
    //   90: dup
    //   91: aload 12
    //   93: aload_3
    //   94: aload_0
    //   95: aload_2
    //   96: aload 5
    //   98: aload 6
    //   100: invokespecial 296	com/tencent/mm/plugin/ay/c$$ExternalSyntheticLambda3:<init>	(Ljava/lang/String;Lcom/tencent/mm/plugin/ay/d;Lcom/tencent/mm/plugin/ay/c;Lcom/tencent/mm/plugin/appbrand/n/g;Ljava/lang/String;Ljava/lang/String;)V
    //   103: invokeinterface 300 2 0
    //   108: new 302	com/tencent/mm/plugin/ax/h
    //   111: dup
    //   112: aload 12
    //   114: invokespecial 305	com/tencent/mm/plugin/ax/h:<init>	(Ljava/lang/String;)V
    //   117: aload_2
    //   118: checkcast 307	com/tencent/mm/plugin/appbrand/n/i
    //   121: invokevirtual 311	com/tencent/mm/plugin/ax/h:l	(Lcom/tencent/mm/plugin/appbrand/n/i;)V
    //   124: aload_1
    //   125: ldc_w 313
    //   128: invokevirtual 319	com/tencent/mm/ad/i:has	(Ljava/lang/String;)Z
    //   131: ifeq +146 -> 277
    //   134: aload_1
    //   135: ldc_w 313
    //   138: invokevirtual 323	com/tencent/mm/ad/i:Fq	(Ljava/lang/String;)Lcom/tencent/mm/ad/f;
    //   141: astore 13
    //   143: aload 13
    //   145: ifnull +132 -> 277
    //   148: iconst_0
    //   149: istore 8
    //   151: aload 13
    //   153: invokevirtual 328	com/tencent/mm/ad/f:length	()I
    //   156: istore 10
    //   158: iload 10
    //   160: ifle +117 -> 277
    //   163: iload 8
    //   165: iconst_1
    //   166: iadd
    //   167: istore 9
    //   169: aload 13
    //   171: iload 8
    //   173: invokevirtual 332	com/tencent/mm/ad/f:getString	(I)Ljava/lang/String;
    //   176: astore 14
    //   178: aload_0
    //   179: getfield 232	com/tencent/mm/plugin/ay/c:Wmr	Ljava/util/HashMap;
    //   182: aload 14
    //   184: invokevirtual 336	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   187: ifeq +344 -> 531
    //   190: aload_0
    //   191: getfield 232	com/tencent/mm/plugin/ay/c:Wmr	Ljava/util/HashMap;
    //   194: aload 14
    //   196: invokevirtual 340	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   199: checkcast 342	java/lang/Integer
    //   202: astore 11
    //   204: aload 11
    //   206: ifnull +64 -> 270
    //   209: aload_0
    //   210: aload 11
    //   212: invokevirtual 345	java/lang/Integer:intValue	()I
    //   215: invokevirtual 349	com/tencent/mm/plugin/ay/c:BK	(I)Lcom/tencent/mm/plugin/appbrand/n/g;
    //   218: astore 11
    //   220: aload 11
    //   222: ifnull +13 -> 235
    //   225: aload 11
    //   227: aload_2
    //   228: aload 14
    //   230: invokeinterface 352 3 0
    //   235: getstatic 179	com/tencent/mm/plugin/ay/c:TAG	Ljava/lang/String;
    //   238: new 273	java/lang/StringBuilder
    //   241: dup
    //   242: ldc_w 354
    //   245: invokespecial 355	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   248: aload 14
    //   250: invokevirtual 358	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   253: ldc_w 360
    //   256: invokevirtual 278	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: aload 12
    //   261: invokevirtual 278	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: invokevirtual 291	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   267: invokestatic 362	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   270: iload 9
    //   272: iload 10
    //   274: if_icmplt +468 -> 742
    //   277: aload_1
    //   278: ldc_w 363
    //   281: invokevirtual 366	com/tencent/mm/ad/i:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   284: astore 11
    //   286: getstatic 371	com/tencent/mm/sdk/platformtools/BuildInfo:DEBUG	Z
    //   289: ifeq +345 -> 634
    //   292: iconst_1
    //   293: invokestatic 374	com/tencent/mm/sdk/platformtools/Log:getLogLevel	()I
    //   296: if_icmple +338 -> 634
    //   299: aload_0
    //   300: invokevirtual 378	com/tencent/mm/plugin/ay/c:iox	()Lcom/tencent/mm/plugin/appbrand/appcache/q;
    //   303: astore 13
    //   305: aload 11
    //   307: ldc_w 363
    //   310: invokestatic 381	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   313: aload 13
    //   315: aload 11
    //   317: invokestatic 386	com/tencent/mm/plugin/appbrand/appcache/r:a	(Lcom/tencent/mm/plugin/appbrand/appcache/q;Ljava/lang/String;)Ljava/lang/String;
    //   320: astore 13
    //   322: aload 7
    //   324: ifnonnull +296 -> 620
    //   327: aconst_null
    //   328: astore 7
    //   330: aload_2
    //   331: aload 13
    //   333: aload 7
    //   335: invokeinterface 390 3 0
    //   340: iload 4
    //   342: ifeq +45 -> 387
    //   345: aload_0
    //   346: getfield 232	com/tencent/mm/plugin/ay/c:Wmr	Ljava/util/HashMap;
    //   349: checkcast 392	java/util/Map
    //   352: astore 7
    //   354: aload_1
    //   355: ldc_w 263
    //   358: invokevirtual 366	com/tencent/mm/ad/i:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   361: astore_1
    //   362: aload_1
    //   363: ldc_w 394
    //   366: invokestatic 381	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   369: aload 7
    //   371: aload_1
    //   372: aload_2
    //   373: invokeinterface 285 1 0
    //   378: invokestatic 398	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   381: invokeinterface 402 3 0
    //   386: pop
    //   387: getstatic 179	com/tencent/mm/plugin/ay/c:TAG	Ljava/lang/String;
    //   390: new 273	java/lang/StringBuilder
    //   393: dup
    //   394: ldc_w 404
    //   397: invokespecial 355	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   400: aload 12
    //   402: invokevirtual 278	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   405: ldc_w 406
    //   408: invokevirtual 278	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   411: aload 11
    //   413: invokevirtual 358	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   416: invokevirtual 291	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   419: invokestatic 216	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   422: return
    //   423: astore_1
    //   424: aload_3
    //   425: new 408	com/tencent/mm/plugin/ay/d$e
    //   428: dup
    //   429: invokespecial 409	com/tencent/mm/plugin/ay/d$e:<init>	()V
    //   432: checkcast 411	com/tencent/mm/plugin/ay/d$i
    //   435: invokevirtual 416	com/tencent/mm/plugin/ay/d:a	(Lcom/tencent/mm/plugin/ay/d$i;)V
    //   438: getstatic 422	com/tencent/mm/plugin/webcanvas/j:WkY	Lcom/tencent/mm/plugin/webcanvas/j;
    //   441: astore_2
    //   442: aload 6
    //   444: aload 5
    //   446: aload_1
    //   447: invokevirtual 425	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   450: invokestatic 429	com/tencent/mm/plugin/webcanvas/j:bn	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   453: getstatic 179	com/tencent/mm/plugin/ay/c:TAG	Ljava/lang/String;
    //   456: aload_1
    //   457: checkcast 431	java/lang/Throwable
    //   460: ldc_w 433
    //   463: aload 12
    //   465: invokestatic 206	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   468: iconst_0
    //   469: anewarray 435	java/lang/Object
    //   472: invokestatic 439	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   475: aload_1
    //   476: athrow
    //   477: astore_1
    //   478: aload_3
    //   479: new 441	com/tencent/mm/plugin/ay/d$c
    //   482: dup
    //   483: invokespecial 442	com/tencent/mm/plugin/ay/d$c:<init>	()V
    //   486: checkcast 411	com/tencent/mm/plugin/ay/d$i
    //   489: invokevirtual 416	com/tencent/mm/plugin/ay/d:a	(Lcom/tencent/mm/plugin/ay/d$i;)V
    //   492: getstatic 179	com/tencent/mm/plugin/ay/c:TAG	Ljava/lang/String;
    //   495: aload_1
    //   496: checkcast 431	java/lang/Throwable
    //   499: ldc_w 444
    //   502: aload 12
    //   504: invokestatic 206	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   507: iconst_0
    //   508: anewarray 435	java/lang/Object
    //   511: invokestatic 439	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   514: getstatic 422	com/tencent/mm/plugin/webcanvas/j:WkY	Lcom/tencent/mm/plugin/webcanvas/j;
    //   517: astore_2
    //   518: aload 6
    //   520: aload 5
    //   522: aload_1
    //   523: invokevirtual 425	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   526: invokestatic 429	com/tencent/mm/plugin/webcanvas/j:bn	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   529: aload_1
    //   530: athrow
    //   531: aload_0
    //   532: getfield 245	com/tencent/mm/plugin/ay/c:Wmu	Ljava/util/HashMap;
    //   535: aload 14
    //   537: invokevirtual 336	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   540: ifeq +20 -> 560
    //   543: aload_0
    //   544: getfield 245	com/tencent/mm/plugin/ay/c:Wmu	Ljava/util/HashMap;
    //   547: aload 14
    //   549: invokevirtual 340	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   552: checkcast 342	java/lang/Integer
    //   555: astore 11
    //   557: goto -353 -> 204
    //   560: aconst_null
    //   561: astore 11
    //   563: goto -359 -> 204
    //   566: astore_1
    //   567: aload_3
    //   568: new 446	com/tencent/mm/plugin/ay/d$a
    //   571: dup
    //   572: invokespecial 447	com/tencent/mm/plugin/ay/d$a:<init>	()V
    //   575: checkcast 411	com/tencent/mm/plugin/ay/d$i
    //   578: invokevirtual 416	com/tencent/mm/plugin/ay/d:a	(Lcom/tencent/mm/plugin/ay/d$i;)V
    //   581: getstatic 422	com/tencent/mm/plugin/webcanvas/j:WkY	Lcom/tencent/mm/plugin/webcanvas/j;
    //   584: astore_2
    //   585: aload 6
    //   587: aload 5
    //   589: aload_1
    //   590: invokevirtual 425	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   593: invokestatic 429	com/tencent/mm/plugin/webcanvas/j:bn	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   596: getstatic 179	com/tencent/mm/plugin/ay/c:TAG	Ljava/lang/String;
    //   599: aload_1
    //   600: checkcast 431	java/lang/Throwable
    //   603: ldc_w 449
    //   606: aload 12
    //   608: invokestatic 206	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   611: iconst_0
    //   612: anewarray 435	java/lang/Object
    //   615: invokestatic 439	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   618: aload_1
    //   619: athrow
    //   620: new 451	com/tencent/mm/plugin/ay/c$$ExternalSyntheticLambda0
    //   623: dup
    //   624: aload 7
    //   626: invokespecial 454	com/tencent/mm/plugin/ay/c$$ExternalSyntheticLambda0:<init>	(Lkotlin/g/a/b;)V
    //   629: astore 7
    //   631: goto -301 -> 330
    //   634: new 456	java/net/URL
    //   637: dup
    //   638: ldc_w 458
    //   641: aload 11
    //   643: invokestatic 206	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   646: invokespecial 459	java/net/URL:<init>	(Ljava/lang/String;)V
    //   649: astore 13
    //   651: aload 11
    //   653: ldc_w 363
    //   656: invokestatic 381	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   659: ldc_w 461
    //   662: aload 11
    //   664: invokestatic 465	com/tencent/mm/plugin/ay/c:nN	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   667: astore 14
    //   669: aload_0
    //   670: getfield 243	com/tencent/mm/plugin/ay/c:Wmt	Lkotlin/j;
    //   673: invokeinterface 471 1 0
    //   678: checkcast 473	java/lang/Number
    //   681: invokevirtual 474	java/lang/Number:intValue	()I
    //   684: istore 8
    //   686: aload_0
    //   687: invokevirtual 378	com/tencent/mm/plugin/ay/c:iox	()Lcom/tencent/mm/plugin/appbrand/appcache/q;
    //   690: aload 11
    //   692: invokestatic 386	com/tencent/mm/plugin/appbrand/appcache/r:a	(Lcom/tencent/mm/plugin/appbrand/appcache/q;Ljava/lang/String;)Ljava/lang/String;
    //   695: astore 15
    //   697: aload 7
    //   699: ifnonnull +29 -> 728
    //   702: aconst_null
    //   703: astore 7
    //   705: aload_2
    //   706: aload 13
    //   708: aload 14
    //   710: iload 8
    //   712: invokestatic 478	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   715: iconst_0
    //   716: aload 15
    //   718: aload 7
    //   720: invokeinterface 481 7 0
    //   725: goto -385 -> 340
    //   728: new 483	com/tencent/mm/plugin/ay/c$$ExternalSyntheticLambda1
    //   731: dup
    //   732: aload 7
    //   734: invokespecial 484	com/tencent/mm/plugin/ay/c$$ExternalSyntheticLambda1:<init>	(Lkotlin/g/a/b;)V
    //   737: astore 7
    //   739: goto -34 -> 705
    //   742: iload 9
    //   744: istore 8
    //   746: goto -583 -> 163
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	749	0	this	c
    //   0	749	1	parami	com.tencent.mm.ad.i
    //   0	749	2	paramg	g
    //   0	749	3	paramd	d
    //   0	749	4	paramBoolean	boolean
    //   0	749	5	paramString1	String
    //   0	749	6	paramString2	String
    //   0	749	7	paramb	kotlin.g.a.b<? super String, kotlin.ah>
    //   149	596	8	i	int
    //   167	576	9	j	int
    //   156	119	10	k	int
    //   202	489	11	localObject1	Object
    //   84	523	12	str1	String
    //   141	566	13	localObject2	Object
    //   176	533	14	str2	String
    //   695	22	15	str3	String
    // Exception table:
    //   from	to	target	type
    //   277	322	423	java/lang/Exception
    //   330	340	423	java/lang/Exception
    //   345	387	423	java/lang/Exception
    //   387	422	423	java/lang/Exception
    //   620	631	423	java/lang/Exception
    //   634	697	423	java/lang/Exception
    //   705	725	423	java/lang/Exception
    //   728	739	423	java/lang/Exception
    //   86	124	477	java/lang/Exception
    //   124	143	566	java/lang/Exception
    //   151	158	566	java/lang/Exception
    //   169	204	566	java/lang/Exception
    //   209	220	566	java/lang/Exception
    //   225	235	566	java/lang/Exception
    //   235	270	566	java/lang/Exception
    //   531	557	566	java/lang/Exception
  }
  
  private static final void a(String paramString1, d paramd, c paramc, g paramg, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    kotlin.g.b.s.u(paramString1, "$tagName");
    kotlin.g.b.s.u(paramd, "$clientReporter");
    kotlin.g.b.s.u(paramc, "this$0");
    kotlin.g.b.s.u(paramg, "$this_with");
    kotlin.g.b.s.u(paramString2, "$name");
    kotlin.g.b.s.u(paramString3, "$appId");
    Log.e(TAG, "JsException[" + paramString1 + "]:" + paramString4 + '\n' + paramString5);
    paramd.a((d.i)new d.d());
    e locale = paramc.iow();
    paramString1 = paramd.WmN;
    switch (e.$EnumSwitchMapping$0[paramString1.ordinal()])
    {
    default: 
      paramString1 = (e.o)new e.b();
    }
    for (;;)
    {
      locale.a(paramString1);
      int i = paramg.czh();
      kotlin.g.b.s.u(paramString2, "name");
      paramString1 = new com.tencent.mm.ad.i();
      paramString1.au("id", i);
      paramString1.m("name", paramString2);
      paramString1.m("message", paramString4);
      paramString1.m("stackTrace", paramString5);
      paramd = (com.tencent.mm.plugin.ax.c)paramc;
      paramString1 = paramString1.toString();
      kotlin.g.b.s.s(paramString1, "err.toString()");
      com.tencent.mm.plugin.ax.c.a.a(paramd, "error", paramString1, null, 4);
      return;
      paramString1 = new e.l();
      paramd = com.tencent.mm.plugin.webcanvas.j.WkY;
      com.tencent.mm.plugin.webcanvas.j.bn(paramString3, paramString2, paramString4 + '\t' + paramString5);
      paramd = kotlin.ah.aiuX;
      paramString1 = (e.o)paramString1;
      continue;
      paramString1 = new e.f();
      paramd = com.tencent.mm.plugin.webcanvas.j.WkY;
      com.tencent.mm.plugin.webcanvas.j.bn(paramString3, paramString2, paramString4 + '\t' + paramString5);
      paramd = kotlin.ah.aiuX;
      paramString1 = (e.o)paramString1;
      continue;
      paramString1 = new e.b();
      paramd = com.tencent.mm.plugin.webcanvas.j.WkY;
      com.tencent.mm.plugin.webcanvas.j.bn(paramString3, paramString2, paramString4 + '\t' + paramString5);
      paramd = kotlin.ah.aiuX;
      paramString1 = (e.o)paramString1;
    }
  }
  
  private static final void e(kotlin.g.a.b paramb, String paramString)
  {
    paramb.invoke(paramString);
  }
  
  private static final void f(kotlin.g.a.b paramb, String paramString)
  {
    paramb.invoke(paramString);
  }
  
  private static final void g(kotlin.g.a.b paramb, String paramString)
  {
    kotlin.g.b.s.u(paramb, "$tmp0");
    paramb.invoke(paramString);
  }
  
  protected static String nN(String paramString1, String paramString2)
  {
    kotlin.g.b.s.u(paramString1, "appId");
    kotlin.g.b.s.u(paramString2, "path");
    return paramString1 + ':' + URLEncoder.encode(paramString2);
  }
  
  public void a(g paramg, String paramString1, String paramString2, kotlin.g.a.b<? super String, kotlin.ah> paramb, a parama)
  {
    kotlin.g.b.s.u(paramg, "context");
    kotlin.g.b.s.u(paramString1, "name");
    kotlin.g.b.s.u(paramString2, "type");
    if (this.aUP)
    {
      Log.w(TAG, "configClient but engine destroyed");
      return;
    }
    a locala = parama;
    if (parama == null) {}
    try
    {
      locala = bhQ(paramString2);
      parama = new d(locala.Wmz, d.j.WmQ);
      try
      {
        iow().a((e.o)new e.c());
        com.tencent.mm.ad.i locali = big(paramString2);
        parama.a((d.i)new d.g());
        a(this, locali, paramg, parama, false, paramString1, locala.appId, 36);
        a(paramString1, paramString2, paramg, parama, paramb);
        parama.a((d.i)new d.h());
        iow().a((e.o)new e.d());
        return;
      }
      catch (Exception paramg)
      {
        iow().a((e.o)new e.a());
        parama.a((d.i)new d.b());
        paramb = com.tencent.mm.plugin.webcanvas.j.WkY;
        com.tencent.mm.plugin.webcanvas.j.bn(locala.appId, paramString1, "type=" + paramString2 + ", " + paramg.getMessage());
        Log.printErrStackTrace(TAG, (Throwable)paramg, "configClient engineContext err", new Object[0]);
        return;
      }
      return;
    }
    catch (Exception paramg)
    {
      Log.printErrStackTrace(TAG, (Throwable)paramg, "configClient getClientInfo err", new Object[0]);
      paramString2 = com.tencent.mm.plugin.webcanvas.j.WkY;
      com.tencent.mm.plugin.webcanvas.j.bn("ClientInfo", paramString1, paramg.getMessage());
    }
  }
  
  protected void a(String paramString1, String paramString2, g paramg, d paramd, kotlin.g.a.b<? super String, kotlin.ah> paramb)
  {
    kotlin.g.b.s.u(paramString1, "name");
    kotlin.g.b.s.u(paramString2, "type");
    kotlin.g.b.s.u(paramg, "context");
    kotlin.g.b.s.u(paramd, "contextReporter");
  }
  
  public final void a(String paramString1, String paramString2, List<? extends Object> paramList, kotlin.g.a.b<? super String, kotlin.ah> paramb)
  {
    kotlin.g.b.s.u(paramString1, "target");
    kotlin.g.b.s.u(paramString2, "func");
    kotlin.g.b.s.u(paramb, "callback");
    StringBuilder localStringBuilder = new StringBuilder("invokeMethod('").append(paramString2).append("', { target: '").append(paramString1).append("', data: { params: ");
    if (paramList == null) {
      paramString1 = "[]";
    }
    for (;;)
    {
      evaluateJavascript(paramString1 + "}})", new c..ExternalSyntheticLambda2(paramb));
      return;
      paramString2 = p.a((Iterable)paramList, (CharSequence)",", (CharSequence)"[", (CharSequence)"]", 0, null, (kotlin.g.a.b)c.b.b.WmD, 24);
      paramString1 = paramString2;
      if (paramString2 == null) {
        paramString1 = "[]";
      }
    }
  }
  
  public final void aR(kotlin.g.a.b<? super String, kotlin.ah> paramb)
  {
    if (this.aUP)
    {
      Log.w(TAG, "config but engine destroyed");
      return;
    }
    iow().a((e.o)new e.i());
    Object localObject1 = ioE();
    label584:
    for (;;)
    {
      try
      {
        iow().a((e.o)new e.m());
        Object localObject2 = new l((m)new f(this));
        Object localObject3 = czi();
        kotlin.g.b.s.s(localObject3, "mainJsContext");
        ((l)localObject2).l((com.tencent.mm.plugin.appbrand.n.i)localObject3);
        czi().evaluateJavascript((String)this.Wmv.getValue(), null);
        localObject2 = ((com.tencent.mm.ad.i)localObject1).Fs("main");
        kotlin.g.b.s.s(localObject2, "");
        localObject3 = czi();
        kotlin.g.b.s.s(localObject3, "mainJsContext");
        Object localObject4 = new d(((com.tencent.mm.ad.i)localObject2).optLong("idKey", 0L), d.j.WmO);
        String str = ((com.tencent.mm.ad.i)localObject2).optString("name");
        kotlin.g.b.s.s(str, "optString(\"name\")");
        a((com.tencent.mm.ad.i)localObject2, (g)localObject3, (d)localObject4, true, str, "wxfedb0854e2b1820d", paramb);
        iow().a((e.o)new e.n());
        if (((com.tencent.mm.ad.i)localObject1).has("engine")) {}
        int k;
        int j;
        int i = j;
      }
      catch (Exception paramb)
      {
        try
        {
          iow().a((e.o)new e.g());
          paramb = ((com.tencent.mm.ad.i)localObject1).Fq("engine");
          if (paramb != null)
          {
            k = paramb.length();
            if (k > 0)
            {
              i = 0;
              j = i + 1;
              localObject1 = paramb.st(i);
              localObject2 = ((com.tencent.mm.ad.i)localObject1).getString("name");
              localObject3 = (Map)this.Wmu;
              kotlin.g.b.s.s(localObject2, "engineName");
              localObject4 = this.sSV.czj();
              kotlin.g.b.s.s(localObject1, "engineObject");
              kotlin.g.b.s.s(localObject4, "context");
              a(this, (com.tencent.mm.ad.i)localObject1, (g)localObject4, new d(((com.tencent.mm.ad.i)localObject1).getLong("idKey"), d.j.WmP), true, null, null, 56);
              Log.i(TAG, "start engine " + localObject2 + '#' + ((g)localObject4).czh());
              ((Map)localObject3).put(localObject2, Integer.valueOf(((g)localObject4).czh()));
              if (j < k) {
                break label584;
              }
            }
          }
          iow().a((e.o)new e.h());
          iow().a((e.o)new e.j());
          return;
        }
        catch (Exception paramb)
        {
          iow().a((e.o)new e.e());
          Log.printErrStackTrace(TAG, (Throwable)paramb, "config engineContext err", new Object[0]);
          localObject1 = com.tencent.mm.plugin.webcanvas.j.WkY;
          com.tencent.mm.plugin.webcanvas.j.bn("wxfedb0854e2b1820d", "engine", paramb.getMessage());
          return;
        }
        paramb = paramb;
        iow().a((e.o)new e.k());
        Log.printErrStackTrace(TAG, (Throwable)paramb, "config mainContext err", new Object[0]);
        localObject1 = com.tencent.mm.plugin.webcanvas.j.WkY;
        com.tencent.mm.plugin.webcanvas.j.bn("wxfedb0854e2b1820d", "main", paramb.getMessage());
        return;
      }
    }
  }
  
  public final void b(String paramString1, String paramString2, ValueCallback<String> paramValueCallback)
  {
    kotlin.g.b.s.u(paramString1, "eventType");
    kotlin.g.b.s.u(paramString2, "event");
    if (kotlin.g.b.s.p(paramString1, "")) {
      Log.i(TAG, "skip dispath");
    }
    do
    {
      return;
      evaluateJavascript("dispatchEvent('" + paramString1 + "', " + paramString2 + ')', paramValueCallback);
    } while ((n.U(paramString1, "touch", false)) || (kotlin.g.b.s.p(paramString1, "scroll")) || (kotlin.g.b.s.p(paramString1, "message")));
    Log.d(TAG, "dispatch: " + paramString1 + ", " + paramString2);
  }
  
  protected abstract a bhQ(String paramString);
  
  public com.tencent.mm.ad.i big(String paramString)
  {
    kotlin.g.b.s.u(paramString, "type");
    paramString = ioE().Fs("client");
    kotlin.g.b.s.s(paramString, "vmConfig.getJSONObject(\"client\")");
    return paramString;
  }
  
  public String ddM()
  {
    String str = getClass().getSimpleName();
    kotlin.g.b.s.s(str, "this.javaClass.simpleName");
    return str;
  }
  
  public void destroy()
  {
    this.aUP = true;
    super.destroy();
  }
  
  public final IJSRuntime g(final IJSRuntime.Config paramConfig)
  {
    IJSRuntime.Config localConfig = paramConfig;
    if (paramConfig == null) {
      localConfig = new IJSRuntime.Config();
    }
    localConfig.hmj = kotlin.g.b.s.X(ddM(), "#");
    Log.d(TAG, kotlin.g.b.s.X("createJSRuntime ", localConfig.hmj));
    paramConfig = new com.tencent.mm.vfs.u(kotlin.g.b.s.X(com.tencent.mm.loader.i.b.bmr(), "webservice/codecache"));
    if (!paramConfig.jKS()) {
      paramConfig.jKY();
    }
    localConfig.hmb = com.tencent.mm.vfs.ah.v(paramConfig.mUri);
    if (!((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yMn, false))
    {
      Log.d(TAG, "createJSRuntime use snapShot");
      if (com.tencent.mm.compatible.deviceinfo.q.awm()) {
        paramConfig = com.tencent.mm.plugin.appbrand.af.d.agt("wxa_library/v8_snapshot64.bin");
      }
    }
    for (;;)
    {
      localConfig.hmc = paramConfig;
      paramConfig = kotlin.ah.aiuX;
      paramConfig = super.g(localConfig);
      if ((BuildInfo.DEBUG) && ((com.tencent.mm.api.s)com.tencent.mm.kernel.h.ax(com.tencent.mm.api.s.class) != null)) {
        this.SJW = ((com.tencent.mm.api.e)new g(this, paramConfig));
      }
      return paramConfig;
      paramConfig = com.tencent.mm.plugin.appbrand.af.d.agt("wxa_library/v8_snapshot.bin");
      continue;
      paramConfig = null;
    }
  }
  
  protected com.tencent.mm.ad.i ioE()
  {
    Object localObject = this.WkS.getValue();
    kotlin.g.b.s.s(localObject, "<get-vmConfig>(...)");
    return (com.tencent.mm.ad.i)localObject;
  }
  
  protected abstract e iow();
  
  public abstract com.tencent.mm.plugin.appbrand.appcache.q iox();
  
  public final com.tencent.mm.ad.i ipe()
  {
    return (com.tencent.mm.ad.i)this.Wms.getValue();
  }
  
  protected abstract void nI(String paramString1, String paramString2);
  
  public final void nO(String paramString1, String paramString2)
  {
    kotlin.g.b.s.u(paramString1, "message");
    kotlin.g.b.s.u(paramString2, "targetOrigin");
    com.tencent.mm.plugin.ax.c.a.a((com.tencent.mm.plugin.ax.c)this, "message", "{ target:'" + paramString2 + "', data: " + paramString1 + " }", null, 4);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webjsengine/WebJsEngine$ClientInfo;", "", "appId", "", "idKey", "", "(Ljava/lang/String;J)V", "getAppId", "()Ljava/lang/String;", "getIdKey", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    final long Wmz;
    final String appId;
    
    public a(String paramString, long paramLong)
    {
      AppMethodBeat.i(266759);
      this.appId = paramString;
      this.Wmz = paramLong;
      AppMethodBeat.o(266759);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(266773);
      if (this == paramObject)
      {
        AppMethodBeat.o(266773);
        return true;
      }
      if (!(paramObject instanceof a))
      {
        AppMethodBeat.o(266773);
        return false;
      }
      paramObject = (a)paramObject;
      if (!kotlin.g.b.s.p(this.appId, paramObject.appId))
      {
        AppMethodBeat.o(266773);
        return false;
      }
      if (this.Wmz != paramObject.Wmz)
      {
        AppMethodBeat.o(266773);
        return false;
      }
      AppMethodBeat.o(266773);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(266771);
      int i = this.appId.hashCode();
      int j = q.a..ExternalSyntheticBackport0.m(this.Wmz);
      AppMethodBeat.o(266771);
      return i * 31 + j;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(266765);
      String str = "ClientInfo(appId=" + this.appId + ", idKey=" + this.Wmz + ')';
      AppMethodBeat.o(266765);
      return str;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webjsengine/WebJsEngine$Companion;", "", "()V", "DEBUG_PATH", "", "getDEBUG_PATH", "()Ljava/lang/String;", "TAG", "bizJsCoreRecycle", "", "getBizJsCoreRecycle", "()Z", "bizJsCoreRecycle$delegate", "Lkotlin/Lazy;", "pkgConfigJson", "Lcom/tencent/mm/memory/cache/DefaultResource;", "Lcom/tencent/mm/json/JSONObject;", "getPkgConfig", "pkg", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;", "getPkgResPath", "appId", "getReadPkgInfo", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngine$Companion$ReadPkgInfo;", "file", "isPreview", "resPath", "readPkg", "pkgInfo", "validResPkg", "Lkotlin/Function3;", "", "callback", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngine$ReadPkgResult;", "", "hasAssets", "toJsonString", "", "ReadPkgInfo", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    private static final com.tencent.mm.plugin.appbrand.appcache.q a(a parama, kotlin.g.a.q<? super Integer, ? super Integer, ? super com.tencent.mm.plugin.appbrand.appcache.q, Boolean> paramq, kotlin.g.a.q<? super c.d, ? super Integer, ? super String, kotlin.ah> paramq1, int paramInt)
    {
      AppMethodBeat.i(266809);
      try
      {
        if (y.ZC(parama.eBX))
        {
          Object localObject = new WxaPkg(parama.eBX);
          ((com.tencent.mm.plugin.appbrand.appcache.q)localObject).cfK();
          localObject = (com.tencent.mm.plugin.appbrand.appcache.q)localObject;
          int i = com.tencent.mm.plugin.webview.l.a.h((com.tencent.mm.plugin.appbrand.appcache.q)localObject);
          Log.i(c.access$getTAG$cp(), "#readPkg " + parama.appId + " resVersion = " + i + " assetsVersion=" + paramInt);
          if (((Boolean)paramq.invoke(Integer.valueOf(paramInt), Integer.valueOf(i), localObject)).booleanValue())
          {
            Log.i(c.access$getTAG$cp(), "#readPkg " + parama.appId + " use res");
            paramq = com.tencent.mm.plugin.webcanvas.k.WkZ;
            paramInt = com.tencent.mm.plugin.webcanvas.k.bid(parama.appId);
            com.tencent.mm.plugin.report.service.h.OAn.b(20781, new Object[] { parama.appId, Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(3), "" });
            if (paramq1 != null) {
              paramq1.invoke(c.d.WmG, Integer.valueOf(i), "");
            }
            AppMethodBeat.o(266809);
            return localObject;
          }
        }
        else if (!Util.isNullOrNil(parama.eBX))
        {
          com.tencent.mm.plugin.report.service.h.OAn.b(20781, new Object[] { parama.appId, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", "", Integer.valueOf(1) });
          parama = com.tencent.mm.plugin.webcanvas.j.WkY;
          com.tencent.mm.plugin.webcanvas.j.xC(122L);
        }
      }
      finally
      {
        for (;;)
        {
          Log.printErrStackTrace(c.access$getTAG$cp(), parama, "readResPkg", new Object[0]);
        }
      }
      AppMethodBeat.o(266809);
      return null;
    }
    
    private static com.tencent.mm.plugin.appbrand.appcache.q a(a parama, kotlin.g.a.q<? super Integer, ? super Integer, ? super com.tencent.mm.plugin.appbrand.appcache.q, Boolean> paramq, kotlin.g.a.q<? super c.d, ? super Integer, ? super String, kotlin.ah> paramq1, boolean paramBoolean)
    {
      AppMethodBeat.i(266785);
      kotlin.g.b.s.u(parama, "pkgInfo");
      kotlin.g.b.s.u(paramq, "validResPkg");
      int j;
      if ((parama.WmA) && (y.ZC(parama.eBX)))
      {
        localObject = new WxaPkg(parama.eBX);
        ((com.tencent.mm.plugin.appbrand.appcache.q)localObject).cfK();
        j = com.tencent.mm.plugin.webview.l.a.h((com.tencent.mm.plugin.appbrand.appcache.q)localObject);
        String str = c.access$getTAG$cp();
        StringBuilder localStringBuilder = new StringBuilder("#readPkg ").append(parama.appId).append(" use ");
        if (parama.isPreview)
        {
          paramq = "preview";
          Log.i(str, paramq);
          paramq = com.tencent.mm.plugin.report.service.h.OAn;
          str = parama.appId;
          if (!parama.isPreview) {
            break label233;
          }
          i = 1;
          label140:
          paramq.b(20781, new Object[] { str, Integer.valueOf(0), Integer.valueOf(j), Integer.valueOf(i), "" });
          if (paramq1 != null) {
            if (!parama.isPreview) {
              break label239;
            }
          }
        }
        label233:
        label239:
        for (parama = c.d.WmF;; parama = c.d.WmE)
        {
          paramq1.invoke(parama, Integer.valueOf(j), "");
          parama = (com.tencent.mm.plugin.appbrand.appcache.q)localObject;
          AppMethodBeat.o(266785);
          return parama;
          paramq = "debug";
          break;
          i = 0;
          break label140;
        }
      }
      if (!paramBoolean) {
        try
        {
          paramq = a(parama, paramq, paramq1, 0);
          kotlin.g.b.s.checkNotNull(paramq);
          AppMethodBeat.o(266785);
          return paramq;
        }
        catch (Exception paramq)
        {
          Log.i(c.access$getTAG$cp(), "#readPkg " + parama.appId + "  fail " + paramq.getMessage());
          AppMethodBeat.o(266785);
          throw paramq;
        }
      }
      Object localObject = new com.tencent.mm.plugin.appbrand.appcache.f(MMApplicationContext.getContext(), parama.WmB);
      ((com.tencent.mm.plugin.appbrand.appcache.q)localObject).cfK();
      localObject = (com.tencent.mm.plugin.appbrand.appcache.q)localObject;
      int i = 0;
      try
      {
        j = com.tencent.mm.plugin.webview.l.a.h((com.tencent.mm.plugin.appbrand.appcache.q)localObject);
        i = j;
        paramq = a(parama, paramq, paramq1, j);
        k = j;
        if (paramq != null)
        {
          i = j;
          AppMethodBeat.o(266785);
          return paramq;
        }
      }
      catch (Exception paramq)
      {
        Log.e(c.access$getTAG$cp(), "#readPkg " + parama.eBX + " handle error: " + parama.appId + ' ' + paramq.getMessage() + " version:" + i);
        com.tencent.mm.plugin.report.service.h.OAn.b(20781, new Object[] { parama.appId, Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(2), paramq.getMessage() });
        int k = i;
        if (paramq1 != null)
        {
          paramq1.invoke(c.d.WmI, Integer.valueOf(i), paramq.getMessage());
          k = i;
        }
        Log.i(c.access$getTAG$cp(), "#readPkg " + parama.appId + " use assert version:" + k);
        com.tencent.mm.plugin.report.service.h.OAn.b(20781, new Object[] { parama.appId, Integer.valueOf(0), Integer.valueOf(k), Integer.valueOf(2), "" });
        if (paramq1 != null) {
          paramq1.invoke(c.d.WmH, Integer.valueOf(k), "");
        }
        AppMethodBeat.o(266785);
      }
      return localObject;
    }
    
    public static a b(String paramString1, boolean paramBoolean, String paramString2, String paramString3)
    {
      AppMethodBeat.i(266774);
      kotlin.g.b.s.u(paramString1, "file");
      kotlin.g.b.s.u(paramString3, "appId");
      String str = c.ipg() + '/' + paramString1;
      paramString1 = kotlin.g.b.s.X("jsapi/", paramString1);
      if (((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED) || (WeChatEnvironment.hasDebugger())) && (y.ZC(str)))
      {
        paramString1 = new a(true, paramBoolean, str, paramString1, paramString3);
        AppMethodBeat.o(266774);
        return paramString1;
      }
      paramString1 = new a(false, paramBoolean, paramString2, paramString1, paramString3);
      AppMethodBeat.o(266774);
      return paramString1;
    }
    
    public static String bih(String paramString)
    {
      AppMethodBeat.i(266802);
      if (paramString == null)
      {
        AppMethodBeat.o(266802);
        return "";
      }
      com.tencent.mm.plugin.webcanvas.k localk = com.tencent.mm.plugin.webcanvas.k.WkZ;
      if (com.tencent.mm.plugin.webcanvas.k.hBF() == 1) {
        localk = com.tencent.mm.plugin.webcanvas.k.WkZ;
      }
      for (paramString = com.tencent.mm.plugin.webcanvas.k.hK(paramString, 2); paramString == null; paramString = com.tencent.mm.plugin.webcanvas.k.bib(paramString))
      {
        AppMethodBeat.o(266802);
        return "";
        localk = com.tencent.mm.plugin.webcanvas.k.WkZ;
      }
      AppMethodBeat.o(266802);
      return paramString;
    }
    
    public static boolean ipi()
    {
      AppMethodBeat.i(266768);
      boolean bool = ((Boolean)c.ipf().getValue()).booleanValue();
      AppMethodBeat.o(266768);
      return bool;
    }
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webjsengine/WebJsEngine$Companion$ReadPkgInfo;", "", "isDebugger", "", "isPreview", "resPath", "", "assetsPath", "appId", "(ZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "getAssetsPath", "()Z", "getResPath", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
    {
      final boolean WmA;
      final String WmB;
      final String appId;
      public final String eBX;
      final boolean isPreview;
      
      public a(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2, String paramString3)
      {
        AppMethodBeat.i(266792);
        this.WmA = paramBoolean1;
        this.isPreview = paramBoolean2;
        this.eBX = paramString1;
        this.WmB = paramString2;
        this.appId = paramString3;
        AppMethodBeat.o(266792);
      }
      
      public final boolean equals(Object paramObject)
      {
        AppMethodBeat.i(266810);
        if (this == paramObject)
        {
          AppMethodBeat.o(266810);
          return true;
        }
        if (!(paramObject instanceof a))
        {
          AppMethodBeat.o(266810);
          return false;
        }
        paramObject = (a)paramObject;
        if (this.WmA != paramObject.WmA)
        {
          AppMethodBeat.o(266810);
          return false;
        }
        if (this.isPreview != paramObject.isPreview)
        {
          AppMethodBeat.o(266810);
          return false;
        }
        if (!kotlin.g.b.s.p(this.eBX, paramObject.eBX))
        {
          AppMethodBeat.o(266810);
          return false;
        }
        if (!kotlin.g.b.s.p(this.WmB, paramObject.WmB))
        {
          AppMethodBeat.o(266810);
          return false;
        }
        if (!kotlin.g.b.s.p(this.appId, paramObject.appId))
        {
          AppMethodBeat.o(266810);
          return false;
        }
        AppMethodBeat.o(266810);
        return true;
      }
      
      public final int hashCode()
      {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
      }
      
      public final String toString()
      {
        AppMethodBeat.i(266801);
        String str = "ReadPkgInfo(isDebugger=" + this.WmA + ", isPreview=" + this.isPreview + ", resPath=" + this.eBX + ", assetsPath=" + this.WmB + ", appId=" + this.appId + ')';
        AppMethodBeat.o(266801);
        return str;
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class b
      extends kotlin.g.b.u
      implements kotlin.g.a.b<Object, CharSequence>
    {
      public static final b WmD;
      
      static
      {
        AppMethodBeat.i(266795);
        WmD = new b();
        AppMethodBeat.o(266795);
      }
      
      b()
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.g.b.u
    implements kotlin.g.a.a<Boolean>
  {
    public static final c WmC;
    
    static
    {
      AppMethodBeat.i(266757);
      WmC = new c();
      AppMethodBeat.o(266757);
    }
    
    c()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webjsengine/WebJsEngine$ReadPkgResult;", "", "(Ljava/lang/String;I)V", "UseDebugPkg", "UsePreviewPkg", "UseResPkg", "UseAssetsPkg", "FallbackAssetsPkg", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum d
  {
    static
    {
      AppMethodBeat.i(266770);
      WmE = new d("UseDebugPkg", 0);
      WmF = new d("UsePreviewPkg", 1);
      WmG = new d("UseResPkg", 2);
      WmH = new d("UseAssetsPkg", 3);
      WmI = new d("FallbackAssetsPkg", 4);
      WmJ = new d[] { WmE, WmF, WmG, WmH, WmI };
      AppMethodBeat.o(266770);
    }
    
    private d() {}
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/webjsengine/WebJsEngine$config$1$1", "Lcom/tencent/mm/plugin/webjsapi/WxMessageAPIContext;", "postMessage", "", "message", "", "targetOrigin", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    implements m
  {
    f(c paramc) {}
    
    public final void postMessage(String paramString1, String paramString2)
    {
      AppMethodBeat.i(266749);
      kotlin.g.b.s.u(paramString1, "message");
      kotlin.g.b.s.u(paramString2, "targetOrigin");
      this.WmK.nI(paramString1, paramString2);
      AppMethodBeat.o(266749);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/webjsengine/WebJsEngine$createJSRuntime$1$1", "Lcom/tencent/mm/api/DevToolsListener;", "dispatch", "", "payload", "", "getDescription", "getName", "onOpen", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class g
    extends com.tencent.mm.api.e
  {
    g(c paramc, IJSRuntime paramIJSRuntime) {}
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/json/JSONObject;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends kotlin.g.b.u
    implements kotlin.g.a.a<com.tencent.mm.ad.i>
  {
    h(c paramc)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends kotlin.g.b.u
    implements kotlin.g.a.a<String>
  {
    public static final i WmM;
    
    static
    {
      AppMethodBeat.i(266734);
      WmM = new i();
      AppMethodBeat.o(266734);
    }
    
    i()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends kotlin.g.b.u
    implements kotlin.g.a.a<Integer>
  {
    j(c paramc)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/json/JSONObject;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class k
    extends kotlin.g.b.u
    implements kotlin.g.a.a<com.tencent.mm.ad.i>
  {
    k(c paramc)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ay.c
 * JD-Core Version:    0.7.0.1
 */