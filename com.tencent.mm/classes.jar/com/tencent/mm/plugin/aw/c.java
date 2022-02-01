package com.tencent.mm.plugin.aw;

import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.appbrand.v8.IJSRuntime;
import com.tencent.mm.appbrand.v8.IJSRuntime.Config;
import com.tencent.mm.plugin.appbrand.ac.d;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkg;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.vfs.u;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import kotlin.a.j;
import kotlin.n.n;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webjsengine/WebJsEngine;", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandNodeJSBasedJsEngine;", "Lcom/tencent/mm/plugin/webjsapi/JSEngineAPIContext;", "()V", "contextMap", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "engineMap", "engineReporter", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngineReporter;", "getEngineReporter", "()Lcom/tencent/mm/plugin/webjsengine/WebJsEngineReporter;", "isDestroyed", "", "meta", "Lcom/tencent/mm/json/JSONObject;", "getMeta", "()Lcom/tencent/mm/json/JSONObject;", "meta$delegate", "Lkotlin/Lazy;", "nativeContextJs", "kotlin.jvm.PlatformType", "getNativeContextJs", "()Ljava/lang/String;", "nativeContextJs$delegate", "version", "getVersion", "()I", "version$delegate", "vmConfig", "getVmConfig", "vmConfig$delegate", "wxaPkg", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;", "getWxaPkg", "()Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;", "config", "", "cb", "Lkotlin/Function1;", "configClient", "context", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJSContext;", "name", "type", "clientInfo", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngine$ClientInfo;", "createJSRuntime", "Lcom/tencent/mm/appbrand/v8/IJSRuntime;", "Lcom/tencent/mm/appbrand/v8/IJSRuntime$Config;", "destroy", "dispatch", "eventType", "event", "Landroid/webkit/ValueCallback;", "getCacheCategory", "appId", "path", "getClientConfig", "getClientInfo", "getEngineName", "invoke", "target", "func", "params", "", "", "callback", "message", "targetOrigin", "onConfigClientInject", "contextReporter", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngineContextReporter;", "onError", "contextId", "stackTrace", "onTransferMessage", "setup", "clientReporter", "cache", "ClientInfo", "Companion", "ReadPkgResult", "webview-sdk_release"})
public abstract class c
  extends com.tencent.mm.plugin.appbrand.m.x
  implements com.tencent.mm.plugin.av.c
{
  private static final kotlin.f Pwg;
  private static final String Pwh;
  private static com.tencent.mm.memory.a.c<String, i> Pwi = new com.tencent.mm.memory.a.c(1);
  public static final b Pwj = new b((byte)0);
  private static final String TAG = "MicroMsg.WebJsEngine";
  private final kotlin.f Pup = kotlin.g.ar((kotlin.g.a.a)new j(this));
  private final HashMap<String, Integer> Pwb = new HashMap();
  private final kotlin.f Pwc = kotlin.g.ar((kotlin.g.a.a)new f(this));
  private final kotlin.f Pwd = kotlin.g.ar((kotlin.g.a.a)new i(this));
  private final HashMap<String, Integer> Pwe = new HashMap();
  private final kotlin.f Pwf = kotlin.g.ar((kotlin.g.a.a)g.Pwz);
  private boolean aJQ;
  
  static
  {
    Pwg = kotlin.g.ar((kotlin.g.a.a)c.Pwn);
    String str = com.tencent.mm.loader.j.b.aSL() + "jsengine/pkg";
    Log.i("DEBUG_PATH", "WebCanvas debug path = ".concat(String.valueOf(str)));
    Pwh = str;
  }
  
  /* Error */
  private void a(i parami, com.tencent.mm.plugin.appbrand.m.g paramg, final f paramf, boolean paramBoolean, final String paramString1, final String paramString2, kotlin.g.a.b<? super String, kotlin.x> paramb)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 245
    //   3: invokestatic 251	kotlin/g/b/p:k	(Ljava/lang/Object;Ljava/lang/String;)V
    //   6: aload_2
    //   7: ldc 252
    //   9: invokestatic 251	kotlin/g/b/p:k	(Ljava/lang/Object;Ljava/lang/String;)V
    //   12: aload_3
    //   13: ldc 253
    //   15: invokestatic 251	kotlin/g/b/p:k	(Ljava/lang/Object;Ljava/lang/String;)V
    //   18: aload 5
    //   20: ldc 254
    //   22: invokestatic 251	kotlin/g/b/p:k	(Ljava/lang/Object;Ljava/lang/String;)V
    //   25: aload 6
    //   27: ldc 255
    //   29: invokestatic 251	kotlin/g/b/p:k	(Ljava/lang/Object;Ljava/lang/String;)V
    //   32: aload_0
    //   33: getfield 257	com/tencent/mm/plugin/aw/c:aJQ	Z
    //   36: ifeq +13 -> 49
    //   39: getstatic 153	com/tencent/mm/plugin/aw/c:TAG	Ljava/lang/String;
    //   42: ldc_w 259
    //   45: invokestatic 262	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   48: return
    //   49: new 169	java/lang/StringBuilder
    //   52: dup
    //   53: invokespecial 171	java/lang/StringBuilder:<init>	()V
    //   56: aload 5
    //   58: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: ldc_w 264
    //   64: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: aload_2
    //   68: invokeinterface 269 1 0
    //   73: invokevirtual 272	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   76: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   79: astore 11
    //   81: aload_2
    //   82: new 31	com/tencent/mm/plugin/aw/c$h
    //   85: dup
    //   86: aload_2
    //   87: aload_0
    //   88: aload 11
    //   90: aload_3
    //   91: aload 6
    //   93: aload 5
    //   95: invokespecial 275	com/tencent/mm/plugin/aw/c$h:<init>	(Lcom/tencent/mm/plugin/appbrand/m/g;Lcom/tencent/mm/plugin/aw/c;Ljava/lang/String;Lcom/tencent/mm/plugin/aw/f;Ljava/lang/String;Ljava/lang/String;)V
    //   98: checkcast 277	com/tencent/mm/plugin/appbrand/m/h
    //   101: invokeinterface 281 2 0
    //   106: new 283	com/tencent/mm/plugin/av/h
    //   109: dup
    //   110: aload 11
    //   112: invokespecial 286	com/tencent/mm/plugin/av/h:<init>	(Ljava/lang/String;)V
    //   115: aload_2
    //   116: checkcast 288	com/tencent/mm/plugin/appbrand/m/i
    //   119: invokevirtual 292	com/tencent/mm/plugin/av/h:h	(Lcom/tencent/mm/plugin/appbrand/m/i;)V
    //   122: aload_1
    //   123: ldc_w 294
    //   126: invokevirtual 300	com/tencent/mm/ad/i:has	(Ljava/lang/String;)Z
    //   129: ifeq +307 -> 436
    //   132: aload_1
    //   133: ldc_w 294
    //   136: invokevirtual 304	com/tencent/mm/ad/i:MH	(Ljava/lang/String;)Lcom/tencent/mm/ad/f;
    //   139: astore 12
    //   141: aload 12
    //   143: ifnull +293 -> 436
    //   146: aload 12
    //   148: invokevirtual 309	com/tencent/mm/ad/f:length	()I
    //   151: istore 9
    //   153: iconst_0
    //   154: istore 8
    //   156: iload 8
    //   158: iload 9
    //   160: if_icmpge +276 -> 436
    //   163: aload 12
    //   165: iload 8
    //   167: invokevirtual 313	com/tencent/mm/ad/f:getString	(I)Ljava/lang/String;
    //   170: astore 13
    //   172: aload_0
    //   173: getfield 221	com/tencent/mm/plugin/aw/c:Pwb	Ljava/util/HashMap;
    //   176: aload 13
    //   178: invokevirtual 317	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   181: ifeq +160 -> 341
    //   184: aload_0
    //   185: getfield 221	com/tencent/mm/plugin/aw/c:Pwb	Ljava/util/HashMap;
    //   188: aload 13
    //   190: invokevirtual 321	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   193: checkcast 323	java/lang/Integer
    //   196: astore 10
    //   198: aload 10
    //   200: ifnull +72 -> 272
    //   203: aload 10
    //   205: ldc_w 325
    //   208: invokestatic 328	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   211: aload_0
    //   212: aload 10
    //   214: invokevirtual 331	java/lang/Integer:intValue	()I
    //   217: invokevirtual 335	com/tencent/mm/plugin/aw/c:Bx	(I)Lcom/tencent/mm/plugin/appbrand/m/g;
    //   220: astore 10
    //   222: aload 10
    //   224: ifnull +13 -> 237
    //   227: aload 10
    //   229: aload_2
    //   230: aload 13
    //   232: invokeinterface 338 3 0
    //   237: getstatic 153	com/tencent/mm/plugin/aw/c:TAG	Ljava/lang/String;
    //   240: new 169	java/lang/StringBuilder
    //   243: dup
    //   244: ldc_w 340
    //   247: invokespecial 341	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   250: aload 13
    //   252: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: ldc_w 343
    //   258: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: aload 11
    //   263: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   269: invokestatic 345	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   272: iload 8
    //   274: iconst_1
    //   275: iadd
    //   276: istore 8
    //   278: goto -122 -> 156
    //   281: astore_1
    //   282: aload_3
    //   283: new 347	com/tencent/mm/plugin/aw/f$c
    //   286: dup
    //   287: invokespecial 348	com/tencent/mm/plugin/aw/f$c:<init>	()V
    //   290: checkcast 350	com/tencent/mm/plugin/aw/f$i
    //   293: invokevirtual 355	com/tencent/mm/plugin/aw/f:a	(Lcom/tencent/mm/plugin/aw/f$i;)V
    //   296: getstatic 153	com/tencent/mm/plugin/aw/c:TAG	Ljava/lang/String;
    //   299: aload_1
    //   300: checkcast 357	java/lang/Throwable
    //   303: ldc_w 359
    //   306: aload 11
    //   308: invokestatic 195	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   311: invokevirtual 199	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   314: iconst_0
    //   315: anewarray 361	java/lang/Object
    //   318: invokestatic 365	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   321: getstatic 371	com/tencent/mm/plugin/webcanvas/l:PuB	Lcom/tencent/mm/plugin/webcanvas/l;
    //   324: astore_2
    //   325: aload 6
    //   327: aload 5
    //   329: aload_1
    //   330: invokevirtual 374	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   333: invokestatic 378	com/tencent/mm/plugin/webcanvas/l:aU	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   336: aload_1
    //   337: checkcast 357	java/lang/Throwable
    //   340: athrow
    //   341: aload_0
    //   342: getfield 234	com/tencent/mm/plugin/aw/c:Pwe	Ljava/util/HashMap;
    //   345: aload 13
    //   347: invokevirtual 317	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   350: ifeq +20 -> 370
    //   353: aload_0
    //   354: getfield 234	com/tencent/mm/plugin/aw/c:Pwe	Ljava/util/HashMap;
    //   357: aload 13
    //   359: invokevirtual 321	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   362: checkcast 323	java/lang/Integer
    //   365: astore 10
    //   367: goto -169 -> 198
    //   370: aconst_null
    //   371: astore 10
    //   373: goto -175 -> 198
    //   376: astore_1
    //   377: aload_3
    //   378: new 380	com/tencent/mm/plugin/aw/f$a
    //   381: dup
    //   382: invokespecial 381	com/tencent/mm/plugin/aw/f$a:<init>	()V
    //   385: checkcast 350	com/tencent/mm/plugin/aw/f$i
    //   388: invokevirtual 355	com/tencent/mm/plugin/aw/f:a	(Lcom/tencent/mm/plugin/aw/f$i;)V
    //   391: getstatic 371	com/tencent/mm/plugin/webcanvas/l:PuB	Lcom/tencent/mm/plugin/webcanvas/l;
    //   394: astore_2
    //   395: aload 6
    //   397: aload 5
    //   399: aload_1
    //   400: invokevirtual 374	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   403: invokestatic 378	com/tencent/mm/plugin/webcanvas/l:aU	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   406: getstatic 153	com/tencent/mm/plugin/aw/c:TAG	Ljava/lang/String;
    //   409: aload_1
    //   410: checkcast 357	java/lang/Throwable
    //   413: ldc_w 383
    //   416: aload 11
    //   418: invokestatic 195	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   421: invokevirtual 199	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   424: iconst_0
    //   425: anewarray 361	java/lang/Object
    //   428: invokestatic 365	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   431: aload_1
    //   432: checkcast 357	java/lang/Throwable
    //   435: athrow
    //   436: aload_1
    //   437: ldc_w 384
    //   440: invokevirtual 386	com/tencent/mm/ad/i:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   443: astore 10
    //   445: getstatic 391	com/tencent/mm/sdk/platformtools/BuildInfo:DEBUG	Z
    //   448: ifeq +197 -> 645
    //   451: aload_0
    //   452: invokevirtual 395	com/tencent/mm/plugin/aw/c:gPi	()Lcom/tencent/mm/plugin/appbrand/appcache/p;
    //   455: astore 12
    //   457: aload 10
    //   459: ldc_w 384
    //   462: invokestatic 328	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   465: aload 12
    //   467: aload 10
    //   469: invokestatic 400	com/tencent/mm/plugin/webview/l/a:a	(Lcom/tencent/mm/plugin/appbrand/appcache/p;Ljava/lang/String;)Ljava/lang/String;
    //   472: astore 12
    //   474: aload 7
    //   476: ifnull +280 -> 756
    //   479: new 402	com/tencent/mm/plugin/aw/e
    //   482: dup
    //   483: aload 7
    //   485: invokespecial 405	com/tencent/mm/plugin/aw/e:<init>	(Lkotlin/g/a/b;)V
    //   488: astore 7
    //   490: aload_2
    //   491: aload 12
    //   493: aload 7
    //   495: checkcast 407	android/webkit/ValueCallback
    //   498: invokeinterface 411 3 0
    //   503: iload 4
    //   505: ifeq +44 -> 549
    //   508: aload_0
    //   509: getfield 221	com/tencent/mm/plugin/aw/c:Pwb	Ljava/util/HashMap;
    //   512: checkcast 413	java/util/Map
    //   515: astore 7
    //   517: aload_1
    //   518: ldc 254
    //   520: invokevirtual 386	com/tencent/mm/ad/i:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   523: astore_1
    //   524: aload_1
    //   525: ldc_w 415
    //   528: invokestatic 328	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   531: aload 7
    //   533: aload_1
    //   534: aload_2
    //   535: invokeinterface 269 1 0
    //   540: invokestatic 418	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   543: invokeinterface 422 3 0
    //   548: pop
    //   549: getstatic 153	com/tencent/mm/plugin/aw/c:TAG	Ljava/lang/String;
    //   552: new 169	java/lang/StringBuilder
    //   555: dup
    //   556: ldc_w 424
    //   559: invokespecial 341	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   562: aload 11
    //   564: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   567: ldc_w 426
    //   570: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   573: aload 10
    //   575: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   578: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   581: invokestatic 205	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   584: return
    //   585: astore_1
    //   586: aload_3
    //   587: new 428	com/tencent/mm/plugin/aw/f$e
    //   590: dup
    //   591: invokespecial 429	com/tencent/mm/plugin/aw/f$e:<init>	()V
    //   594: checkcast 350	com/tencent/mm/plugin/aw/f$i
    //   597: invokevirtual 355	com/tencent/mm/plugin/aw/f:a	(Lcom/tencent/mm/plugin/aw/f$i;)V
    //   600: getstatic 371	com/tencent/mm/plugin/webcanvas/l:PuB	Lcom/tencent/mm/plugin/webcanvas/l;
    //   603: astore_2
    //   604: aload 6
    //   606: aload 5
    //   608: aload_1
    //   609: invokevirtual 374	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   612: invokestatic 378	com/tencent/mm/plugin/webcanvas/l:aU	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   615: getstatic 153	com/tencent/mm/plugin/aw/c:TAG	Ljava/lang/String;
    //   618: aload_1
    //   619: checkcast 357	java/lang/Throwable
    //   622: ldc_w 431
    //   625: aload 11
    //   627: invokestatic 195	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   630: invokevirtual 199	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   633: iconst_0
    //   634: anewarray 361	java/lang/Object
    //   637: invokestatic 365	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   640: aload_1
    //   641: checkcast 357	java/lang/Throwable
    //   644: athrow
    //   645: new 433	java/net/URL
    //   648: dup
    //   649: ldc_w 435
    //   652: aload 10
    //   654: invokestatic 195	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   657: invokevirtual 199	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   660: invokespecial 436	java/net/URL:<init>	(Ljava/lang/String;)V
    //   663: astore 12
    //   665: aload 10
    //   667: ldc_w 384
    //   670: invokestatic 328	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   673: ldc_w 438
    //   676: aload 10
    //   678: invokestatic 442	com/tencent/mm/plugin/aw/c:mb	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   681: astore 13
    //   683: aload_0
    //   684: getfield 232	com/tencent/mm/plugin/aw/c:Pwd	Lkotlin/f;
    //   687: invokeinterface 448 1 0
    //   692: checkcast 450	java/lang/Number
    //   695: invokevirtual 451	java/lang/Number:intValue	()I
    //   698: istore 8
    //   700: aload_0
    //   701: invokevirtual 395	com/tencent/mm/plugin/aw/c:gPi	()Lcom/tencent/mm/plugin/appbrand/appcache/p;
    //   704: aload 10
    //   706: invokestatic 400	com/tencent/mm/plugin/webview/l/a:a	(Lcom/tencent/mm/plugin/appbrand/appcache/p;Ljava/lang/String;)Ljava/lang/String;
    //   709: astore 14
    //   711: aload 7
    //   713: ifnull +40 -> 753
    //   716: new 402	com/tencent/mm/plugin/aw/e
    //   719: dup
    //   720: aload 7
    //   722: invokespecial 405	com/tencent/mm/plugin/aw/e:<init>	(Lkotlin/g/a/b;)V
    //   725: astore 7
    //   727: aload_2
    //   728: aload 12
    //   730: aload 13
    //   732: iload 8
    //   734: invokestatic 453	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   737: iconst_0
    //   738: aload 14
    //   740: aload 7
    //   742: checkcast 407	android/webkit/ValueCallback
    //   745: invokeinterface 456 7 0
    //   750: goto -247 -> 503
    //   753: goto -26 -> 727
    //   756: goto -266 -> 490
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	759	0	this	c
    //   0	759	1	parami	i
    //   0	759	2	paramg	com.tencent.mm.plugin.appbrand.m.g
    //   0	759	3	paramf	f
    //   0	759	4	paramBoolean	boolean
    //   0	759	5	paramString1	String
    //   0	759	6	paramString2	String
    //   0	759	7	paramb	kotlin.g.a.b<? super String, kotlin.x>
    //   154	579	8	i	int
    //   151	10	9	j	int
    //   196	509	10	localObject1	Object
    //   79	547	11	str1	String
    //   139	590	12	localObject2	Object
    //   170	561	13	str2	String
    //   709	30	14	str3	String
    // Exception table:
    //   from	to	target	type
    //   81	122	281	java/lang/Exception
    //   122	141	376	java/lang/Exception
    //   146	153	376	java/lang/Exception
    //   163	198	376	java/lang/Exception
    //   203	222	376	java/lang/Exception
    //   227	237	376	java/lang/Exception
    //   237	272	376	java/lang/Exception
    //   341	367	376	java/lang/Exception
    //   436	474	585	java/lang/Exception
    //   479	490	585	java/lang/Exception
    //   490	503	585	java/lang/Exception
    //   508	549	585	java/lang/Exception
    //   549	584	585	java/lang/Exception
    //   645	711	585	java/lang/Exception
    //   716	727	585	java/lang/Exception
    //   727	750	585	java/lang/Exception
  }
  
  protected static String mb(String paramString1, String paramString2)
  {
    kotlin.g.b.p.k(paramString1, "appId");
    kotlin.g.b.p.k(paramString2, "path");
    return paramString1 + ':' + URLEncoder.encode(paramString2);
  }
  
  public void a(com.tencent.mm.plugin.appbrand.m.g paramg, String paramString1, String paramString2, kotlin.g.a.b<? super String, kotlin.x> paramb, a parama)
  {
    kotlin.g.b.p.k(paramg, "context");
    kotlin.g.b.p.k(paramString1, "name");
    kotlin.g.b.p.k(paramString2, "type");
    if (this.aJQ)
    {
      Log.w(TAG, "configClient but engine destroyed");
      return;
    }
    a locala = parama;
    if (parama == null) {}
    try
    {
      locala = bie(paramString2);
      parama = new f(locala.Pwk, f.j.PwG);
      try
      {
        gPh().a((g.o)new g.c());
        i locali = biy(paramString2);
        parama.a((f.i)new f.g());
        a(this, locali, paramg, parama, false, paramString1, locala.appId, 36);
        a(paramString1, paramString2, paramg, parama, paramb);
        parama.a((f.i)new f.h());
        gPh().a((g.o)new g.d());
        return;
      }
      catch (Exception paramg)
      {
        gPh().a((g.o)new g.a());
        parama.a((f.i)new f.b());
        paramString2 = com.tencent.mm.plugin.webcanvas.l.PuB;
        com.tencent.mm.plugin.webcanvas.l.aU(locala.appId, paramString1, paramg.getMessage());
        Log.printErrStackTrace(TAG, (Throwable)paramg, "configClient engineContext err", new Object[0]);
        return;
      }
      return;
    }
    catch (Exception paramg)
    {
      Log.printErrStackTrace(TAG, (Throwable)paramg, "configClient getClientInfo err", new Object[0]);
      paramString2 = com.tencent.mm.plugin.webcanvas.l.PuB;
      com.tencent.mm.plugin.webcanvas.l.aU("ClientInfo", paramString1, paramg.getMessage());
    }
  }
  
  protected void a(String paramString1, String paramString2, com.tencent.mm.plugin.appbrand.m.g paramg, f paramf, kotlin.g.a.b<? super String, kotlin.x> paramb)
  {
    kotlin.g.b.p.k(paramString1, "name");
    kotlin.g.b.p.k(paramString2, "type");
    kotlin.g.b.p.k(paramg, "context");
    kotlin.g.b.p.k(paramf, "contextReporter");
  }
  
  public final void a(String paramString1, String paramString2, List<? extends Object> paramList, kotlin.g.a.b<? super String, kotlin.x> paramb)
  {
    kotlin.g.b.p.k(paramString1, "target");
    kotlin.g.b.p.k(paramString2, "func");
    kotlin.g.b.p.k(paramb, "callback");
    StringBuilder localStringBuilder = new StringBuilder("invokeMethod('").append(paramString2).append("', { target: '").append(paramString1).append("', data: { params: ");
    if (paramList != null)
    {
      paramString2 = j.a((Iterable)paramList, (CharSequence)",", (CharSequence)"[", (CharSequence)"]", 0, null, (kotlin.g.a.b)c.b.c.Pwq, 24);
      paramString1 = paramString2;
      if (paramString2 != null) {}
    }
    else
    {
      paramString1 = "[]";
    }
    evaluateJavascript(paramString1 + "}})", (ValueCallback)new e(paramb));
  }
  
  /* Error */
  public final void ad(final kotlin.g.a.b<? super String, kotlin.x> paramb)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 257	com/tencent/mm/plugin/aw/c:aJQ	Z
    //   4: ifeq +13 -> 17
    //   7: getstatic 153	com/tencent/mm/plugin/aw/c:TAG	Ljava/lang/String;
    //   10: ldc_w 593
    //   13: invokestatic 262	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   16: return
    //   17: aload_0
    //   18: invokevirtual 510	com/tencent/mm/plugin/aw/c:gPh	()Lcom/tencent/mm/plugin/aw/g;
    //   21: new 595	com/tencent/mm/plugin/aw/g$i
    //   24: dup
    //   25: invokespecial 596	com/tencent/mm/plugin/aw/g$i:<init>	()V
    //   28: checkcast 515	com/tencent/mm/plugin/aw/g$o
    //   31: invokevirtual 520	com/tencent/mm/plugin/aw/g:a	(Lcom/tencent/mm/plugin/aw/g$o;)V
    //   34: aload_0
    //   35: invokevirtual 600	com/tencent/mm/plugin/aw/c:gPk	()Lcom/tencent/mm/ad/i;
    //   38: astore 4
    //   40: aload_0
    //   41: invokevirtual 510	com/tencent/mm/plugin/aw/c:gPh	()Lcom/tencent/mm/plugin/aw/g;
    //   44: new 602	com/tencent/mm/plugin/aw/g$m
    //   47: dup
    //   48: invokespecial 603	com/tencent/mm/plugin/aw/g$m:<init>	()V
    //   51: checkcast 515	com/tencent/mm/plugin/aw/g$o
    //   54: invokevirtual 520	com/tencent/mm/plugin/aw/g:a	(Lcom/tencent/mm/plugin/aw/g$o;)V
    //   57: new 605	com/tencent/mm/plugin/av/l
    //   60: dup
    //   61: new 25	com/tencent/mm/plugin/aw/c$e
    //   64: dup
    //   65: aload_0
    //   66: aload_1
    //   67: invokespecial 608	com/tencent/mm/plugin/aw/c$e:<init>	(Lcom/tencent/mm/plugin/aw/c;Lkotlin/g/a/b;)V
    //   70: checkcast 610	com/tencent/mm/plugin/av/m
    //   73: invokespecial 613	com/tencent/mm/plugin/av/l:<init>	(Lcom/tencent/mm/plugin/av/m;)V
    //   76: astore 5
    //   78: aload_0
    //   79: invokevirtual 617	com/tencent/mm/plugin/aw/c:bYU	()Lcom/tencent/mm/plugin/appbrand/m/g;
    //   82: astore 6
    //   84: aload 6
    //   86: ldc_w 619
    //   89: invokestatic 328	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   92: aload 5
    //   94: aload 6
    //   96: checkcast 288	com/tencent/mm/plugin/appbrand/m/i
    //   99: invokevirtual 620	com/tencent/mm/plugin/av/l:h	(Lcom/tencent/mm/plugin/appbrand/m/i;)V
    //   102: aload_0
    //   103: invokevirtual 617	com/tencent/mm/plugin/aw/c:bYU	()Lcom/tencent/mm/plugin/appbrand/m/g;
    //   106: aload_0
    //   107: getfield 240	com/tencent/mm/plugin/aw/c:Pwf	Lkotlin/f;
    //   110: invokeinterface 448 1 0
    //   115: checkcast 191	java/lang/String
    //   118: aconst_null
    //   119: invokeinterface 411 3 0
    //   124: aload 4
    //   126: ldc_w 622
    //   129: invokevirtual 625	com/tencent/mm/ad/i:MJ	(Ljava/lang/String;)Lcom/tencent/mm/ad/i;
    //   132: astore 5
    //   134: aload_0
    //   135: invokevirtual 617	com/tencent/mm/plugin/aw/c:bYU	()Lcom/tencent/mm/plugin/appbrand/m/g;
    //   138: astore 6
    //   140: aload 6
    //   142: ldc_w 619
    //   145: invokestatic 328	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   148: new 352	com/tencent/mm/plugin/aw/f
    //   151: dup
    //   152: aload 5
    //   154: ldc_w 627
    //   157: lconst_0
    //   158: invokevirtual 631	com/tencent/mm/ad/i:optLong	(Ljava/lang/String;J)J
    //   161: getstatic 634	com/tencent/mm/plugin/aw/f$j:PwE	Lcom/tencent/mm/plugin/aw/f$j;
    //   164: invokespecial 506	com/tencent/mm/plugin/aw/f:<init>	(JLcom/tencent/mm/plugin/aw/f$j;)V
    //   167: astore 7
    //   169: aload 5
    //   171: ldc 254
    //   173: invokevirtual 637	com/tencent/mm/ad/i:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   176: astore 8
    //   178: aload 8
    //   180: ldc_w 639
    //   183: invokestatic 328	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   186: aload_0
    //   187: aload 5
    //   189: aload 6
    //   191: aload 7
    //   193: iconst_1
    //   194: aload 8
    //   196: ldc_w 464
    //   199: aload_1
    //   200: invokespecial 466	com/tencent/mm/plugin/aw/c:a	(Lcom/tencent/mm/ad/i;Lcom/tencent/mm/plugin/appbrand/m/g;Lcom/tencent/mm/plugin/aw/f;ZLjava/lang/String;Ljava/lang/String;Lkotlin/g/a/b;)V
    //   203: aload_0
    //   204: invokevirtual 510	com/tencent/mm/plugin/aw/c:gPh	()Lcom/tencent/mm/plugin/aw/g;
    //   207: new 641	com/tencent/mm/plugin/aw/g$n
    //   210: dup
    //   211: invokespecial 642	com/tencent/mm/plugin/aw/g$n:<init>	()V
    //   214: checkcast 515	com/tencent/mm/plugin/aw/g$o
    //   217: invokevirtual 520	com/tencent/mm/plugin/aw/g:a	(Lcom/tencent/mm/plugin/aw/g$o;)V
    //   220: aload 4
    //   222: ldc_w 644
    //   225: invokevirtual 300	com/tencent/mm/ad/i:has	(Ljava/lang/String;)Z
    //   228: ifeq +267 -> 495
    //   231: aload_0
    //   232: invokevirtual 510	com/tencent/mm/plugin/aw/c:gPh	()Lcom/tencent/mm/plugin/aw/g;
    //   235: new 646	com/tencent/mm/plugin/aw/g$g
    //   238: dup
    //   239: invokespecial 647	com/tencent/mm/plugin/aw/g$g:<init>	()V
    //   242: checkcast 515	com/tencent/mm/plugin/aw/g$o
    //   245: invokevirtual 520	com/tencent/mm/plugin/aw/g:a	(Lcom/tencent/mm/plugin/aw/g$o;)V
    //   248: aload 4
    //   250: ldc_w 644
    //   253: invokevirtual 304	com/tencent/mm/ad/i:MH	(Ljava/lang/String;)Lcom/tencent/mm/ad/f;
    //   256: astore_1
    //   257: aload_1
    //   258: ifnull +220 -> 478
    //   261: aload_1
    //   262: invokevirtual 309	com/tencent/mm/ad/f:length	()I
    //   265: istore_3
    //   266: iconst_0
    //   267: istore_2
    //   268: iload_2
    //   269: iload_3
    //   270: if_icmpge +208 -> 478
    //   273: aload_1
    //   274: iload_2
    //   275: invokevirtual 651	com/tencent/mm/ad/f:sx	(I)Lcom/tencent/mm/ad/i;
    //   278: astore 4
    //   280: aload 4
    //   282: ldc 254
    //   284: invokevirtual 386	com/tencent/mm/ad/i:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   287: astore 5
    //   289: aload_0
    //   290: getfield 234	com/tencent/mm/plugin/aw/c:Pwe	Ljava/util/HashMap;
    //   293: checkcast 413	java/util/Map
    //   296: astore 6
    //   298: aload 5
    //   300: ldc_w 653
    //   303: invokestatic 328	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   306: aload_0
    //   307: invokevirtual 656	com/tencent/mm/plugin/aw/c:bYV	()Lcom/tencent/mm/plugin/appbrand/m/g;
    //   310: astore 7
    //   312: aload 4
    //   314: ldc_w 658
    //   317: invokestatic 328	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   320: aload 7
    //   322: ldc 252
    //   324: invokestatic 328	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   327: aload_0
    //   328: aload 4
    //   330: aload 7
    //   332: new 352	com/tencent/mm/plugin/aw/f
    //   335: dup
    //   336: aload 4
    //   338: ldc_w 627
    //   341: invokevirtual 662	com/tencent/mm/ad/i:getLong	(Ljava/lang/String;)J
    //   344: getstatic 665	com/tencent/mm/plugin/aw/f$j:PwF	Lcom/tencent/mm/plugin/aw/f$j;
    //   347: invokespecial 506	com/tencent/mm/plugin/aw/f:<init>	(JLcom/tencent/mm/plugin/aw/f$j;)V
    //   350: iconst_1
    //   351: aconst_null
    //   352: aconst_null
    //   353: bipush 56
    //   355: invokestatic 531	com/tencent/mm/plugin/aw/c:a	(Lcom/tencent/mm/plugin/aw/c;Lcom/tencent/mm/ad/i;Lcom/tencent/mm/plugin/appbrand/m/g;Lcom/tencent/mm/plugin/aw/f;ZLjava/lang/String;Ljava/lang/String;I)V
    //   358: getstatic 153	com/tencent/mm/plugin/aw/c:TAG	Ljava/lang/String;
    //   361: new 169	java/lang/StringBuilder
    //   364: dup
    //   365: ldc_w 667
    //   368: invokespecial 341	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   371: aload 5
    //   373: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   376: bipush 35
    //   378: invokevirtual 481	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   381: aload 7
    //   383: invokeinterface 269 1 0
    //   388: invokevirtual 272	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   391: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   394: invokestatic 205	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   397: aload 6
    //   399: aload 5
    //   401: aload 7
    //   403: invokeinterface 269 1 0
    //   408: invokestatic 418	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   411: invokeinterface 422 3 0
    //   416: pop
    //   417: iload_2
    //   418: iconst_1
    //   419: iadd
    //   420: istore_2
    //   421: goto -153 -> 268
    //   424: astore_1
    //   425: aload_0
    //   426: invokevirtual 510	com/tencent/mm/plugin/aw/c:gPh	()Lcom/tencent/mm/plugin/aw/g;
    //   429: new 669	com/tencent/mm/plugin/aw/g$k
    //   432: dup
    //   433: invokespecial 670	com/tencent/mm/plugin/aw/g$k:<init>	()V
    //   436: checkcast 515	com/tencent/mm/plugin/aw/g$o
    //   439: invokevirtual 520	com/tencent/mm/plugin/aw/g:a	(Lcom/tencent/mm/plugin/aw/g$o;)V
    //   442: getstatic 153	com/tencent/mm/plugin/aw/c:TAG	Ljava/lang/String;
    //   445: aload_1
    //   446: checkcast 357	java/lang/Throwable
    //   449: ldc_w 672
    //   452: iconst_0
    //   453: anewarray 361	java/lang/Object
    //   456: invokestatic 365	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   459: getstatic 371	com/tencent/mm/plugin/webcanvas/l:PuB	Lcom/tencent/mm/plugin/webcanvas/l;
    //   462: astore 4
    //   464: ldc_w 464
    //   467: ldc_w 622
    //   470: aload_1
    //   471: invokevirtual 374	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   474: invokestatic 378	com/tencent/mm/plugin/webcanvas/l:aU	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   477: return
    //   478: aload_0
    //   479: invokevirtual 510	com/tencent/mm/plugin/aw/c:gPh	()Lcom/tencent/mm/plugin/aw/g;
    //   482: new 674	com/tencent/mm/plugin/aw/g$h
    //   485: dup
    //   486: invokespecial 675	com/tencent/mm/plugin/aw/g$h:<init>	()V
    //   489: checkcast 515	com/tencent/mm/plugin/aw/g$o
    //   492: invokevirtual 520	com/tencent/mm/plugin/aw/g:a	(Lcom/tencent/mm/plugin/aw/g$o;)V
    //   495: aload_0
    //   496: invokevirtual 510	com/tencent/mm/plugin/aw/c:gPh	()Lcom/tencent/mm/plugin/aw/g;
    //   499: new 677	com/tencent/mm/plugin/aw/g$j
    //   502: dup
    //   503: invokespecial 678	com/tencent/mm/plugin/aw/g$j:<init>	()V
    //   506: checkcast 515	com/tencent/mm/plugin/aw/g$o
    //   509: invokevirtual 520	com/tencent/mm/plugin/aw/g:a	(Lcom/tencent/mm/plugin/aw/g$o;)V
    //   512: return
    //   513: astore_1
    //   514: aload_0
    //   515: invokevirtual 510	com/tencent/mm/plugin/aw/c:gPh	()Lcom/tencent/mm/plugin/aw/g;
    //   518: new 680	com/tencent/mm/plugin/aw/g$e
    //   521: dup
    //   522: invokespecial 681	com/tencent/mm/plugin/aw/g$e:<init>	()V
    //   525: checkcast 515	com/tencent/mm/plugin/aw/g$o
    //   528: invokevirtual 520	com/tencent/mm/plugin/aw/g:a	(Lcom/tencent/mm/plugin/aw/g$o;)V
    //   531: getstatic 153	com/tencent/mm/plugin/aw/c:TAG	Ljava/lang/String;
    //   534: aload_1
    //   535: checkcast 357	java/lang/Throwable
    //   538: ldc_w 683
    //   541: iconst_0
    //   542: anewarray 361	java/lang/Object
    //   545: invokestatic 365	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   548: getstatic 371	com/tencent/mm/plugin/webcanvas/l:PuB	Lcom/tencent/mm/plugin/webcanvas/l;
    //   551: astore 4
    //   553: ldc_w 464
    //   556: ldc_w 644
    //   559: aload_1
    //   560: invokevirtual 374	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   563: invokestatic 378	com/tencent/mm/plugin/webcanvas/l:aU	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   566: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	567	0	this	c
    //   0	567	1	paramb	kotlin.g.a.b<? super String, kotlin.x>
    //   267	154	2	i	int
    //   265	6	3	j	int
    //   38	514	4	localObject1	Object
    //   76	324	5	localObject2	Object
    //   82	316	6	localObject3	Object
    //   167	235	7	localObject4	Object
    //   176	19	8	str	String
    // Exception table:
    //   from	to	target	type
    //   40	220	424	java/lang/Exception
    //   231	257	513	java/lang/Exception
    //   261	266	513	java/lang/Exception
    //   273	417	513	java/lang/Exception
    //   478	495	513	java/lang/Exception
  }
  
  public final void b(String paramString1, String paramString2, ValueCallback<String> paramValueCallback)
  {
    kotlin.g.b.p.k(paramString1, "eventType");
    kotlin.g.b.p.k(paramString2, "event");
    if (kotlin.g.b.p.h(paramString1, "")) {
      Log.i(TAG, "skip dispath");
    }
    do
    {
      return;
      evaluateJavascript("dispatchEvent('" + paramString1 + "', " + paramString2 + ')', paramValueCallback);
    } while ((n.M(paramString1, "touch", false)) || (!(kotlin.g.b.p.h(paramString1, "scroll") ^ true)) || (!(kotlin.g.b.p.h(paramString1, "message") ^ true)));
    Log.d(TAG, "dispatch: " + paramString1 + ", " + paramString2);
  }
  
  protected abstract a bie(String paramString);
  
  public i biy(String paramString)
  {
    kotlin.g.b.p.k(paramString, "type");
    paramString = gPk().MJ("client");
    kotlin.g.b.p.j(paramString, "vmConfig.getJSONObject(\"client\")");
    return paramString;
  }
  
  public String cAJ()
  {
    String str = getClass().getSimpleName();
    kotlin.g.b.p.j(str, "this.javaClass.simpleName");
    return str;
  }
  
  public void destroy()
  {
    this.aJQ = true;
    super.destroy();
  }
  
  public final IJSRuntime g(IJSRuntime.Config paramConfig)
  {
    IJSRuntime.Config localConfig = paramConfig;
    if (paramConfig == null) {
      localConfig = new IJSRuntime.Config();
    }
    localConfig.fhX = (cAJ() + '#');
    Log.d(TAG, "createJSRuntime " + localConfig.fhX);
    paramConfig = new com.tencent.mm.vfs.q(com.tencent.mm.loader.j.b.aSD() + "webservice/codecache");
    if (!paramConfig.ifE()) {
      paramConfig.ifL();
    }
    localConfig.fhP = paramConfig.getPath();
    if (!((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vyG, false))
    {
      Log.d(TAG, "use code cache");
      if (com.tencent.mm.compatible.deviceinfo.q.is64BitRuntime()) {
        paramConfig = d.and("wxa_library/v8_snapshot64.bin");
      }
    }
    for (;;)
    {
      localConfig.fhQ = paramConfig;
      return super.g(localConfig);
      paramConfig = d.and("wxa_library/v8_snapshot.bin");
      continue;
      paramConfig = null;
    }
  }
  
  public final i gPO()
  {
    return (i)this.Pwc.getValue();
  }
  
  protected abstract g gPh();
  
  public abstract com.tencent.mm.plugin.appbrand.appcache.p gPi();
  
  protected i gPk()
  {
    return (i)this.Pup.getValue();
  }
  
  protected abstract void lW(String paramString1, String paramString2);
  
  public final void mc(String paramString1, String paramString2)
  {
    kotlin.g.b.p.k(paramString1, "message");
    kotlin.g.b.p.k(paramString2, "targetOrigin");
    com.tencent.mm.plugin.av.c.a.a(this, "message", "{ target:'" + paramString2 + "', data: " + paramString1 + " }", null, 4);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webjsengine/WebJsEngine$ClientInfo;", "", "appId", "", "idKey", "", "(Ljava/lang/String;J)V", "getAppId", "()Ljava/lang/String;", "getIdKey", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "webview-sdk_release"})
  public static final class a
  {
    final long Pwk;
    final String appId;
    
    public a(String paramString, long paramLong)
    {
      AppMethodBeat.i(206562);
      this.appId = paramString;
      this.Pwk = paramLong;
      AppMethodBeat.o(206562);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(206568);
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if ((!kotlin.g.b.p.h(this.appId, paramObject.appId)) || (this.Pwk != paramObject.Pwk)) {}
        }
      }
      else
      {
        AppMethodBeat.o(206568);
        return true;
      }
      AppMethodBeat.o(206568);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(206565);
      String str = this.appId;
      if (str != null) {}
      for (int i = str.hashCode();; i = 0)
      {
        long l = this.Pwk;
        int j = (int)(l ^ l >>> 32);
        AppMethodBeat.o(206565);
        return i * 31 + j;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(206564);
      String str = "ClientInfo(appId=" + this.appId + ", idKey=" + this.Pwk + ")";
      AppMethodBeat.o(206564);
      return str;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webjsengine/WebJsEngine$Companion;", "", "()V", "DEBUG_PATH", "", "TAG", "bizJsCoreRecycle", "", "getBizJsCoreRecycle", "()Z", "bizJsCoreRecycle$delegate", "Lkotlin/Lazy;", "pkgConfigJson", "Lcom/tencent/mm/memory/cache/DefaultResource;", "Lcom/tencent/mm/json/JSONObject;", "getPkgConfig", "pkg", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;", "getPkgResPath", "appId", "getReadPkgInfo", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngine$Companion$ReadPkgInfo;", "file", "isPreview", "resPath", "readPkg", "pkgInfo", "validResPkg", "Lkotlin/Function3;", "", "callback", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngine$ReadPkgResult;", "", "hasAssets", "toJsonString", "", "ReadPkgInfo", "webview-sdk_release"})
  public static final class b
  {
    private static com.tencent.mm.plugin.appbrand.appcache.p a(a parama, final kotlin.g.a.q<? super Integer, ? super Integer, ? super com.tencent.mm.plugin.appbrand.appcache.p, Boolean> paramq, final kotlin.g.a.q<? super c.d, ? super Integer, ? super String, kotlin.x> paramq1, boolean paramBoolean)
    {
      AppMethodBeat.i(215133);
      kotlin.g.b.p.k(parama, "pkgInfo");
      kotlin.g.b.p.k(paramq, "validResPkg");
      Object localObject = new b(parama, paramq, paramq1);
      int j;
      if ((parama.Pwl) && (u.agG(parama.cIr)))
      {
        localObject = (com.tencent.mm.plugin.appbrand.appcache.p)new WxaPkg(parama.cIr);
        ((com.tencent.mm.plugin.appbrand.appcache.p)localObject).bGl();
        j = com.tencent.mm.plugin.webview.l.a.b((com.tencent.mm.plugin.appbrand.appcache.p)localObject);
        String str = c.access$getTAG$cp();
        StringBuilder localStringBuilder = new StringBuilder("#readPkg ").append(parama.appId).append(" use ");
        if (parama.isPreview)
        {
          paramq = "preview";
          Log.i(str, paramq);
          paramq = com.tencent.mm.plugin.report.service.h.IzE;
          str = parama.appId;
          if (!parama.isPreview) {
            break label237;
          }
          i = 1;
          label149:
          paramq.a(20781, new Object[] { str, Integer.valueOf(0), Integer.valueOf(j), Integer.valueOf(i), "" });
          if (paramq1 != null) {
            if (!parama.isPreview) {
              break label243;
            }
          }
        }
        label237:
        label243:
        for (parama = c.d.Pws;; parama = c.d.Pwr)
        {
          paramq1.c(parama, Integer.valueOf(j), "");
          AppMethodBeat.o(215133);
          return localObject;
          paramq = "debug";
          break;
          i = 0;
          break label149;
        }
      }
      if (!paramBoolean) {
        try
        {
          paramq = ((b)localObject).ana(0);
          if (paramq == null) {
            kotlin.g.b.p.iCn();
          }
          AppMethodBeat.o(215133);
          return paramq;
        }
        catch (Exception paramq)
        {
          Log.i(c.access$getTAG$cp(), "#readPkg " + parama.appId + "  fail " + paramq.getMessage());
          parama = (Throwable)paramq;
          AppMethodBeat.o(215133);
          throw parama;
        }
      }
      paramq = (com.tencent.mm.plugin.appbrand.appcache.p)new com.tencent.mm.plugin.appbrand.appcache.f(MMApplicationContext.getContext(), parama.Pwm);
      paramq.bGl();
      int i = 0;
      try
      {
        j = com.tencent.mm.plugin.webview.l.a.b(paramq);
        i = j;
        localObject = ((b)localObject).ana(j);
        k = j;
        if (localObject != null)
        {
          i = j;
          AppMethodBeat.o(215133);
          return localObject;
        }
      }
      catch (Exception localException)
      {
        Log.e(c.access$getTAG$cp(), "#readPkg " + parama.cIr + " handle error: " + parama.appId + ' ' + localException.getMessage() + " version:" + i);
        com.tencent.mm.plugin.report.service.h.IzE.a(20781, new Object[] { parama.appId, Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(2), localException.getMessage() });
        int k = i;
        if (paramq1 != null)
        {
          paramq1.c(c.d.Pwv, Integer.valueOf(i), localException.getMessage());
          k = i;
        }
        Log.i(c.access$getTAG$cp(), "#readPkg " + parama.appId + " use assert version:" + k);
        com.tencent.mm.plugin.report.service.h.IzE.a(20781, new Object[] { parama.appId, Integer.valueOf(0), Integer.valueOf(k), Integer.valueOf(2), "" });
        if (paramq1 != null) {
          paramq1.c(c.d.Pwu, Integer.valueOf(k), "");
        }
        AppMethodBeat.o(215133);
      }
      return paramq;
    }
    
    public static a a(String paramString1, boolean paramBoolean, String paramString2, String paramString3)
    {
      AppMethodBeat.i(215129);
      kotlin.g.b.p.k(paramString1, "file");
      kotlin.g.b.p.k(paramString3, "appId");
      String str = c.gPQ() + '/' + paramString1;
      paramString1 = "jsapi/".concat(String.valueOf(paramString1));
      if (((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED) || (WeChatEnvironment.hasDebugger())) && (u.agG(str)))
      {
        paramString1 = new a(true, paramBoolean, str, paramString1, paramString3);
        AppMethodBeat.o(215129);
        return paramString1;
      }
      paramString1 = new a(false, paramBoolean, paramString2, paramString1, paramString3);
      AppMethodBeat.o(215129);
      return paramString1;
    }
    
    public static String biz(String paramString)
    {
      AppMethodBeat.i(215139);
      Object localObject = com.tencent.mm.plugin.webcanvas.m.PuL;
      if (com.tencent.mm.plugin.webcanvas.m.gPr() == 1)
      {
        localObject = com.tencent.mm.plugin.webcanvas.m.PuL;
        localObject = paramString;
        if (paramString == null) {
          localObject = "";
        }
      }
      com.tencent.mm.plugin.webcanvas.m localm;
      for (paramString = com.tencent.mm.plugin.webcanvas.m.bir((String)localObject);; paramString = localm.bip((String)localObject))
      {
        localObject = paramString;
        if (paramString == null) {
          localObject = "";
        }
        AppMethodBeat.o(215139);
        return localObject;
        localm = com.tencent.mm.plugin.webcanvas.m.PuL;
        localObject = paramString;
        if (paramString == null) {
          localObject = "";
        }
      }
    }
    
    public static boolean gPS()
    {
      AppMethodBeat.i(215124);
      kotlin.f localf = c.gPP();
      b localb = c.Pwj;
      boolean bool = ((Boolean)localf.getValue()).booleanValue();
      AppMethodBeat.o(215124);
      return bool;
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webjsengine/WebJsEngine$Companion$ReadPkgInfo;", "", "isDebugger", "", "isPreview", "resPath", "", "assetsPath", "appId", "(ZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "getAssetsPath", "()Z", "getResPath", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "webview-sdk_release"})
    public static final class a
    {
      final boolean Pwl;
      final String Pwm;
      final String appId;
      public final String cIr;
      final boolean isPreview;
      
      public a(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2, String paramString3)
      {
        AppMethodBeat.i(205547);
        this.Pwl = paramBoolean1;
        this.isPreview = paramBoolean2;
        this.cIr = paramString1;
        this.Pwm = paramString2;
        this.appId = paramString3;
        AppMethodBeat.o(205547);
      }
      
      public final boolean equals(Object paramObject)
      {
        AppMethodBeat.i(205552);
        if (this != paramObject)
        {
          if ((paramObject instanceof a))
          {
            paramObject = (a)paramObject;
            if ((this.Pwl != paramObject.Pwl) || (this.isPreview != paramObject.isPreview) || (!kotlin.g.b.p.h(this.cIr, paramObject.cIr)) || (!kotlin.g.b.p.h(this.Pwm, paramObject.Pwm)) || (!kotlin.g.b.p.h(this.appId, paramObject.appId))) {}
          }
        }
        else
        {
          AppMethodBeat.o(205552);
          return true;
        }
        AppMethodBeat.o(205552);
        return false;
      }
      
      public final int hashCode()
      {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
      }
      
      public final String toString()
      {
        AppMethodBeat.i(205548);
        String str = "ReadPkgInfo(isDebugger=" + this.Pwl + ", isPreview=" + this.isPreview + ", resPath=" + this.cIr + ", assetsPath=" + this.Pwm + ", appId=" + this.appId + ")";
        AppMethodBeat.o(205548);
        return str;
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"readResPkg", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;", "assetsVersion", "", "invoke"})
    static final class b
      extends kotlin.g.b.q
      implements kotlin.g.a.b<Integer, com.tencent.mm.plugin.appbrand.appcache.p>
    {
      b(c.b.a parama, kotlin.g.a.q paramq1, kotlin.g.a.q paramq2)
      {
        super();
      }
      
      public final com.tencent.mm.plugin.appbrand.appcache.p ana(int paramInt)
      {
        AppMethodBeat.i(207259);
        if (u.agG(this.Pwo.cIr))
        {
          com.tencent.mm.plugin.appbrand.appcache.p localp = (com.tencent.mm.plugin.appbrand.appcache.p)new WxaPkg(this.Pwo.cIr);
          localp.bGl();
          int i = com.tencent.mm.plugin.webview.l.a.b(localp);
          Log.i(c.access$getTAG$cp(), "#readPkg " + this.Pwo.appId + " resVersion = " + i + " assetsVersion=" + paramInt);
          if (((Boolean)paramq.c(Integer.valueOf(paramInt), Integer.valueOf(i), localp)).booleanValue())
          {
            Log.i(c.access$getTAG$cp(), "#readPkg " + this.Pwo.appId + " use res");
            paramInt = com.tencent.mm.plugin.webcanvas.m.PuL.bit(this.Pwo.appId);
            com.tencent.mm.plugin.report.service.h.IzE.a(20781, new Object[] { this.Pwo.appId, Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(3), "" });
            kotlin.g.a.q localq = paramq1;
            if (localq != null) {
              localq.c(c.d.Pwt, Integer.valueOf(i), "");
            }
            AppMethodBeat.o(207259);
            return localp;
          }
        }
        AppMethodBeat.o(207259);
        return null;
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "invoke"})
    static final class c
      extends kotlin.g.b.q
      implements kotlin.g.a.b<Object, CharSequence>
    {
      public static final c Pwq;
      
      static
      {
        AppMethodBeat.i(205914);
        Pwq = new c();
        AppMethodBeat.o(205914);
      }
      
      c()
      {
        super();
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Boolean>
  {
    public static final c Pwn;
    
    static
    {
      AppMethodBeat.i(206812);
      Pwn = new c();
      AppMethodBeat.o(206812);
    }
    
    c()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webjsengine/WebJsEngine$ReadPkgResult;", "", "(Ljava/lang/String;I)V", "UseDebugPkg", "UsePreviewPkg", "UseResPkg", "UseAssetsPkg", "FallbackAssetsPkg", "webview-sdk_release"})
  public static enum d
  {
    static
    {
      AppMethodBeat.i(205136);
      d locald1 = new d("UseDebugPkg", 0);
      Pwr = locald1;
      d locald2 = new d("UsePreviewPkg", 1);
      Pws = locald2;
      d locald3 = new d("UseResPkg", 2);
      Pwt = locald3;
      d locald4 = new d("UseAssetsPkg", 3);
      Pwu = locald4;
      d locald5 = new d("FallbackAssetsPkg", 4);
      Pwv = locald5;
      Pww = new d[] { locald1, locald2, locald3, locald4, locald5 };
      AppMethodBeat.o(205136);
    }
    
    private d() {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/webjsengine/WebJsEngine$config$1$1", "Lcom/tencent/mm/plugin/webjsapi/WxMessageAPIContext;", "postMessage", "", "message", "", "targetOrigin", "webview-sdk_release"})
  public static final class e
    implements com.tencent.mm.plugin.av.m
  {
    e(c paramc, kotlin.g.a.b paramb) {}
    
    public final void postMessage(String paramString1, String paramString2)
    {
      AppMethodBeat.i(205571);
      kotlin.g.b.p.k(paramString1, "message");
      kotlin.g.b.p.k(paramString2, "targetOrigin");
      this.Pwx.lW(paramString1, paramString2);
      AppMethodBeat.o(205571);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/json/JSONObject;", "invoke"})
  static final class f
    extends kotlin.g.b.q
    implements kotlin.g.a.a<i>
  {
    f(c paramc)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "kotlin.jvm.PlatformType", "invoke"})
  static final class g
    extends kotlin.g.b.q
    implements kotlin.g.a.a<String>
  {
    public static final g Pwz;
    
    static
    {
      AppMethodBeat.i(208014);
      Pwz = new g();
      AppMethodBeat.o(208014);
    }
    
    g()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "message", "", "kotlin.jvm.PlatformType", "stackTrace", "handleException", "com/tencent/mm/plugin/webjsengine/WebJsEngine$setup$1$1"})
  static final class h
    implements com.tencent.mm.plugin.appbrand.m.h
  {
    h(com.tencent.mm.plugin.appbrand.m.g paramg, c paramc, String paramString1, f paramf, String paramString2, String paramString3) {}
    
    public final void A(String paramString1, String paramString2)
    {
      AppMethodBeat.i(207194);
      Log.e(c.access$getTAG$cp(), "JsException[" + str1 + "]:" + paramString1 + '\n' + paramString2);
      paramf.a((f.i)new f.d());
      Object localObject2 = jdField_this.gPh();
      Object localObject1 = paramf.PwD;
      switch (d.$EnumSwitchMapping$0[localObject1.ordinal()])
      {
      default: 
        localObject1 = (g.o)new g.b();
      }
      for (;;)
      {
        ((g)localObject2).a((g.o)localObject1);
        localObject1 = jdField_this;
        int i = this.PwA.bYT();
        localObject2 = paramString1;
        kotlin.g.b.p.k(localObject2, "name");
        Object localObject3 = new i();
        ((i)localObject3).al("id", i);
        ((i)localObject3).g("name", localObject2);
        ((i)localObject3).g("message", paramString1);
        ((i)localObject3).g("stackTrace", paramString2);
        paramString1 = ((i)localObject3).toString();
        kotlin.g.b.p.j(paramString1, "err.toString()");
        com.tencent.mm.plugin.av.c.a.a((com.tencent.mm.plugin.av.c)localObject1, "error", paramString1, null, 4);
        AppMethodBeat.o(207194);
        return;
        localObject1 = new g.l();
        localObject3 = com.tencent.mm.plugin.webcanvas.l.PuB;
        com.tencent.mm.plugin.webcanvas.l.aU(paramString2, paramString1, paramString1 + '\t' + paramString2);
        localObject1 = (g.o)localObject1;
        continue;
        localObject1 = new g.f();
        localObject3 = com.tencent.mm.plugin.webcanvas.l.PuB;
        com.tencent.mm.plugin.webcanvas.l.aU(paramString2, paramString1, paramString1 + '\t' + paramString2);
        localObject1 = (g.o)localObject1;
        continue;
        localObject1 = new g.b();
        localObject3 = com.tencent.mm.plugin.webcanvas.l.PuB;
        com.tencent.mm.plugin.webcanvas.l.aU(paramString2, paramString1, paramString1 + '\t' + paramString2);
        localObject1 = (g.o)localObject1;
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class i
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Integer>
  {
    i(c paramc)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/json/JSONObject;", "kotlin.jvm.PlatformType", "invoke"})
  static final class j
    extends kotlin.g.b.q
    implements kotlin.g.a.a<i>
  {
    j(c paramc)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.aw.c
 * JD-Core Version:    0.7.0.1
 */