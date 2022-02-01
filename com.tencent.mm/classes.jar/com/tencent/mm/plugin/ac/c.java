package com.tencent.mm.plugin.ac;

import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.i;
import com.tencent.mm.appbrand.v8.IJSRuntime;
import com.tencent.mm.appbrand.v8.IJSRuntime.Config;
import com.tencent.mm.plugin.appbrand.ac.d;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkg;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import kotlin.a.j;
import kotlin.g.a.a;
import kotlin.n.n;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webjsengine/WebJsEngine;", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandNodeJSBasedJsEngine;", "Lcom/tencent/mm/plugin/webjsapi/JSEngineAPIContext;", "()V", "contextMap", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "engineMap", "engineReporter", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngineReporter;", "getEngineReporter", "()Lcom/tencent/mm/plugin/webjsengine/WebJsEngineReporter;", "meta", "Lcom/tencent/mm/json/JSONObject;", "getMeta", "()Lcom/tencent/mm/json/JSONObject;", "meta$delegate", "Lkotlin/Lazy;", "nativeContextJs", "kotlin.jvm.PlatformType", "getNativeContextJs", "()Ljava/lang/String;", "nativeContextJs$delegate", "version", "getVersion", "()I", "version$delegate", "vmConfig", "getVmConfig", "vmConfig$delegate", "wxaPkg", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;", "getWxaPkg", "()Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;", "config", "", "cb", "Lkotlin/Function1;", "configClient", "context", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJSContext;", "name", "type", "clientInfo", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngine$ClientInfo;", "createJSRuntime", "Lcom/tencent/mm/appbrand/v8/IJSRuntime;", "Lcom/tencent/mm/appbrand/v8/IJSRuntime$Config;", "dispatch", "eventType", "event", "Landroid/webkit/ValueCallback;", "getCacheCategory", "appId", "path", "getClientConfig", "getClientInfo", "getEngineName", "invoke", "target", "func", "params", "", "", "callback", "message", "targetOrigin", "onConfigClientInject", "contextReporter", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngineContextReporter;", "onError", "contextId", "stackTrace", "onTransferMessage", "setup", "clientReporter", "cache", "", "ClientInfo", "Companion", "ReadPkgResult", "webview-sdk_release"})
public abstract class c
  extends com.tencent.mm.plugin.appbrand.m.x
  implements com.tencent.mm.plugin.ab.c
{
  private static final String IBT;
  public static final b IBU = new b((byte)0);
  private static final String TAG = "MicroMsg.WebJsEngine";
  private final kotlin.f IAm = kotlin.g.ah((a)new i(this));
  private final HashMap<String, Integer> IBO = new HashMap();
  private final kotlin.f IBP = kotlin.g.ah((a)new e(this));
  private final kotlin.f IBQ = kotlin.g.ah((a)new h(this));
  private final HashMap<String, Integer> IBR = new HashMap();
  private final kotlin.f IBS = kotlin.g.ah((a)c.f.ICj);
  
  static
  {
    String str = com.tencent.mm.loader.j.b.aKJ() + "jsengine/pkg";
    Log.i("DEBUG_PATH", "WebCanvas debug path = ".concat(String.valueOf(str)));
    IBT = str;
  }
  
  /* Error */
  private void a(i parami, com.tencent.mm.plugin.appbrand.m.g paramg, final f paramf, boolean paramBoolean, final String paramString1, final String paramString2, kotlin.g.a.b<? super String, kotlin.x> paramb)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 220
    //   3: invokestatic 226	kotlin/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   6: aload_2
    //   7: ldc 227
    //   9: invokestatic 226	kotlin/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   12: aload_3
    //   13: ldc 228
    //   15: invokestatic 226	kotlin/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   18: aload 5
    //   20: ldc 229
    //   22: invokestatic 226	kotlin/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   25: aload 6
    //   27: ldc 230
    //   29: invokestatic 226	kotlin/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   32: new 141	java/lang/StringBuilder
    //   35: dup
    //   36: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   39: aload 5
    //   41: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: ldc 232
    //   46: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: aload_2
    //   50: invokeinterface 237 1 0
    //   55: invokevirtual 240	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   58: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: astore 11
    //   63: aload_2
    //   64: new 25	com/tencent/mm/plugin/ac/c$g
    //   67: dup
    //   68: aload_2
    //   69: aload_0
    //   70: aload 11
    //   72: aload_3
    //   73: aload 6
    //   75: aload 5
    //   77: invokespecial 243	com/tencent/mm/plugin/ac/c$g:<init>	(Lcom/tencent/mm/plugin/appbrand/m/g;Lcom/tencent/mm/plugin/ac/c;Ljava/lang/String;Lcom/tencent/mm/plugin/ac/f;Ljava/lang/String;Ljava/lang/String;)V
    //   80: checkcast 245	com/tencent/mm/plugin/appbrand/m/h
    //   83: invokeinterface 249 2 0
    //   88: new 251	com/tencent/mm/plugin/ab/h
    //   91: dup
    //   92: aload 11
    //   94: invokespecial 254	com/tencent/mm/plugin/ab/h:<init>	(Ljava/lang/String;)V
    //   97: aload_2
    //   98: checkcast 256	com/tencent/mm/plugin/appbrand/m/i
    //   101: invokevirtual 260	com/tencent/mm/plugin/ab/h:f	(Lcom/tencent/mm/plugin/appbrand/m/i;)V
    //   104: aload_1
    //   105: ldc_w 262
    //   108: invokevirtual 268	com/tencent/mm/ab/i:has	(Ljava/lang/String;)Z
    //   111: ifeq +298 -> 409
    //   114: aload_1
    //   115: ldc_w 262
    //   118: invokevirtual 272	com/tencent/mm/ab/i:FH	(Ljava/lang/String;)Lcom/tencent/mm/ab/f;
    //   121: astore 12
    //   123: aload 12
    //   125: ifnull +284 -> 409
    //   128: aload 12
    //   130: invokevirtual 277	com/tencent/mm/ab/f:length	()I
    //   133: istore 9
    //   135: iconst_0
    //   136: istore 8
    //   138: iload 8
    //   140: iload 9
    //   142: if_icmpge +267 -> 409
    //   145: aload 12
    //   147: iload 8
    //   149: invokevirtual 281	com/tencent/mm/ab/f:getString	(I)Ljava/lang/String;
    //   152: astore 13
    //   154: aload_0
    //   155: getfield 186	com/tencent/mm/plugin/ac/c:IBO	Ljava/util/HashMap;
    //   158: aload 13
    //   160: invokevirtual 285	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   163: ifeq +151 -> 314
    //   166: aload_0
    //   167: getfield 186	com/tencent/mm/plugin/ac/c:IBO	Ljava/util/HashMap;
    //   170: aload 13
    //   172: invokevirtual 289	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   175: checkcast 291	java/lang/Integer
    //   178: astore 10
    //   180: aload 10
    //   182: ifnull +63 -> 245
    //   185: aload 10
    //   187: ldc_w 293
    //   190: invokestatic 296	kotlin/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   193: aload_0
    //   194: aload 10
    //   196: invokevirtual 299	java/lang/Integer:intValue	()I
    //   199: invokevirtual 303	com/tencent/mm/plugin/ac/c:xX	(I)Lcom/tencent/mm/plugin/appbrand/m/g;
    //   202: aload_2
    //   203: aload 13
    //   205: invokeinterface 306 3 0
    //   210: getstatic 139	com/tencent/mm/plugin/ac/c:TAG	Ljava/lang/String;
    //   213: new 141	java/lang/StringBuilder
    //   216: dup
    //   217: ldc_w 308
    //   220: invokespecial 309	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   223: aload 13
    //   225: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: ldc_w 311
    //   231: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: aload 11
    //   236: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   242: invokestatic 314	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   245: iload 8
    //   247: iconst_1
    //   248: iadd
    //   249: istore 8
    //   251: goto -113 -> 138
    //   254: astore_1
    //   255: aload_3
    //   256: new 316	com/tencent/mm/plugin/ac/f$c
    //   259: dup
    //   260: invokespecial 317	com/tencent/mm/plugin/ac/f$c:<init>	()V
    //   263: checkcast 319	com/tencent/mm/plugin/ac/f$i
    //   266: invokevirtual 324	com/tencent/mm/plugin/ac/f:a	(Lcom/tencent/mm/plugin/ac/f$i;)V
    //   269: getstatic 139	com/tencent/mm/plugin/ac/c:TAG	Ljava/lang/String;
    //   272: aload_1
    //   273: checkcast 326	java/lang/Throwable
    //   276: ldc_w 328
    //   279: aload 11
    //   281: invokestatic 167	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   284: invokevirtual 171	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   287: iconst_0
    //   288: anewarray 330	java/lang/Object
    //   291: invokestatic 334	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   294: getstatic 340	com/tencent/mm/plugin/webcanvas/l:IAx	Lcom/tencent/mm/plugin/webcanvas/l;
    //   297: astore_2
    //   298: aload 6
    //   300: aload 5
    //   302: aload_1
    //   303: invokevirtual 343	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   306: invokestatic 347	com/tencent/mm/plugin/webcanvas/l:ba	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   309: aload_1
    //   310: checkcast 326	java/lang/Throwable
    //   313: athrow
    //   314: aload_0
    //   315: getfield 207	com/tencent/mm/plugin/ac/c:IBR	Ljava/util/HashMap;
    //   318: aload 13
    //   320: invokevirtual 285	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   323: ifeq +20 -> 343
    //   326: aload_0
    //   327: getfield 207	com/tencent/mm/plugin/ac/c:IBR	Ljava/util/HashMap;
    //   330: aload 13
    //   332: invokevirtual 289	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   335: checkcast 291	java/lang/Integer
    //   338: astore 10
    //   340: goto -160 -> 180
    //   343: aconst_null
    //   344: astore 10
    //   346: goto -166 -> 180
    //   349: astore_1
    //   350: aload_3
    //   351: new 349	com/tencent/mm/plugin/ac/f$a
    //   354: dup
    //   355: invokespecial 350	com/tencent/mm/plugin/ac/f$a:<init>	()V
    //   358: checkcast 319	com/tencent/mm/plugin/ac/f$i
    //   361: invokevirtual 324	com/tencent/mm/plugin/ac/f:a	(Lcom/tencent/mm/plugin/ac/f$i;)V
    //   364: getstatic 340	com/tencent/mm/plugin/webcanvas/l:IAx	Lcom/tencent/mm/plugin/webcanvas/l;
    //   367: astore_2
    //   368: aload 6
    //   370: aload 5
    //   372: aload_1
    //   373: invokevirtual 343	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   376: invokestatic 347	com/tencent/mm/plugin/webcanvas/l:ba	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   379: getstatic 139	com/tencent/mm/plugin/ac/c:TAG	Ljava/lang/String;
    //   382: aload_1
    //   383: checkcast 326	java/lang/Throwable
    //   386: ldc_w 352
    //   389: aload 11
    //   391: invokestatic 167	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   394: invokevirtual 171	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   397: iconst_0
    //   398: anewarray 330	java/lang/Object
    //   401: invokestatic 334	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   404: aload_1
    //   405: checkcast 326	java/lang/Throwable
    //   408: athrow
    //   409: aload_1
    //   410: ldc_w 353
    //   413: invokevirtual 355	com/tencent/mm/ab/i:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   416: astore 10
    //   418: getstatic 361	com/tencent/mm/sdk/platformtools/BuildInfo:DEBUG	Z
    //   421: ifeq +137 -> 558
    //   424: aload_0
    //   425: invokevirtual 365	com/tencent/mm/plugin/ac/c:fWz	()Lcom/tencent/mm/plugin/appbrand/appcache/p;
    //   428: astore 12
    //   430: aload 10
    //   432: ldc_w 353
    //   435: invokestatic 296	kotlin/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   438: aload 12
    //   440: aload 10
    //   442: invokestatic 368	com/tencent/mm/plugin/ac/c$b:a	(Lcom/tencent/mm/plugin/appbrand/appcache/p;Ljava/lang/String;)Ljava/lang/String;
    //   445: astore 12
    //   447: aload 7
    //   449: ifnull +280 -> 729
    //   452: new 370	com/tencent/mm/plugin/ac/e
    //   455: dup
    //   456: aload 7
    //   458: invokespecial 373	com/tencent/mm/plugin/ac/e:<init>	(Lkotlin/g/a/b;)V
    //   461: astore 7
    //   463: aload_2
    //   464: aload 12
    //   466: aload 7
    //   468: checkcast 375	android/webkit/ValueCallback
    //   471: invokeinterface 379 3 0
    //   476: iload 4
    //   478: ifeq +44 -> 522
    //   481: aload_0
    //   482: getfield 186	com/tencent/mm/plugin/ac/c:IBO	Ljava/util/HashMap;
    //   485: checkcast 381	java/util/Map
    //   488: astore 7
    //   490: aload_1
    //   491: ldc 229
    //   493: invokevirtual 355	com/tencent/mm/ab/i:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   496: astore_1
    //   497: aload_1
    //   498: ldc_w 383
    //   501: invokestatic 296	kotlin/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   504: aload 7
    //   506: aload_1
    //   507: aload_2
    //   508: invokeinterface 237 1 0
    //   513: invokestatic 386	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   516: invokeinterface 390 3 0
    //   521: pop
    //   522: getstatic 139	com/tencent/mm/plugin/ac/c:TAG	Ljava/lang/String;
    //   525: new 141	java/lang/StringBuilder
    //   528: dup
    //   529: ldc_w 392
    //   532: invokespecial 309	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   535: aload 11
    //   537: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   540: ldc_w 394
    //   543: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   546: aload 10
    //   548: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   551: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   554: invokestatic 177	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   557: return
    //   558: new 396	java/net/URL
    //   561: dup
    //   562: ldc_w 398
    //   565: aload 10
    //   567: invokestatic 167	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   570: invokevirtual 171	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   573: invokespecial 399	java/net/URL:<init>	(Ljava/lang/String;)V
    //   576: astore 12
    //   578: aload 10
    //   580: ldc_w 353
    //   583: invokestatic 296	kotlin/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   586: ldc_w 401
    //   589: aload 10
    //   591: invokestatic 405	com/tencent/mm/plugin/ac/c:lB	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   594: astore 13
    //   596: aload_0
    //   597: getfield 205	com/tencent/mm/plugin/ac/c:IBQ	Lkotlin/f;
    //   600: invokeinterface 411 1 0
    //   605: checkcast 413	java/lang/Number
    //   608: invokevirtual 414	java/lang/Number:intValue	()I
    //   611: istore 8
    //   613: aload_0
    //   614: invokevirtual 365	com/tencent/mm/plugin/ac/c:fWz	()Lcom/tencent/mm/plugin/appbrand/appcache/p;
    //   617: aload 10
    //   619: invokestatic 368	com/tencent/mm/plugin/ac/c$b:a	(Lcom/tencent/mm/plugin/appbrand/appcache/p;Ljava/lang/String;)Ljava/lang/String;
    //   622: astore 14
    //   624: aload 7
    //   626: ifnull +100 -> 726
    //   629: new 370	com/tencent/mm/plugin/ac/e
    //   632: dup
    //   633: aload 7
    //   635: invokespecial 373	com/tencent/mm/plugin/ac/e:<init>	(Lkotlin/g/a/b;)V
    //   638: astore 7
    //   640: aload_2
    //   641: aload 12
    //   643: aload 13
    //   645: iload 8
    //   647: invokestatic 416	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   650: iconst_0
    //   651: aload 14
    //   653: aload 7
    //   655: checkcast 375	android/webkit/ValueCallback
    //   658: invokeinterface 419 7 0
    //   663: goto -187 -> 476
    //   666: astore_1
    //   667: aload_3
    //   668: new 421	com/tencent/mm/plugin/ac/f$e
    //   671: dup
    //   672: invokespecial 422	com/tencent/mm/plugin/ac/f$e:<init>	()V
    //   675: checkcast 319	com/tencent/mm/plugin/ac/f$i
    //   678: invokevirtual 324	com/tencent/mm/plugin/ac/f:a	(Lcom/tencent/mm/plugin/ac/f$i;)V
    //   681: getstatic 340	com/tencent/mm/plugin/webcanvas/l:IAx	Lcom/tencent/mm/plugin/webcanvas/l;
    //   684: astore_2
    //   685: aload 6
    //   687: aload 5
    //   689: aload_1
    //   690: invokevirtual 343	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   693: invokestatic 347	com/tencent/mm/plugin/webcanvas/l:ba	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   696: getstatic 139	com/tencent/mm/plugin/ac/c:TAG	Ljava/lang/String;
    //   699: aload_1
    //   700: checkcast 326	java/lang/Throwable
    //   703: ldc_w 424
    //   706: aload 11
    //   708: invokestatic 167	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   711: invokevirtual 171	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   714: iconst_0
    //   715: anewarray 330	java/lang/Object
    //   718: invokestatic 334	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   721: aload_1
    //   722: checkcast 326	java/lang/Throwable
    //   725: athrow
    //   726: goto -86 -> 640
    //   729: goto -266 -> 463
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	732	0	this	c
    //   0	732	1	parami	i
    //   0	732	2	paramg	com.tencent.mm.plugin.appbrand.m.g
    //   0	732	3	paramf	f
    //   0	732	4	paramBoolean	boolean
    //   0	732	5	paramString1	String
    //   0	732	6	paramString2	String
    //   0	732	7	paramb	kotlin.g.a.b<? super String, kotlin.x>
    //   136	510	8	i	int
    //   133	10	9	j	int
    //   178	440	10	localObject1	Object
    //   61	646	11	str1	String
    //   121	521	12	localObject2	Object
    //   152	492	13	str2	String
    //   622	30	14	str3	String
    // Exception table:
    //   from	to	target	type
    //   63	104	254	java/lang/Exception
    //   104	123	349	java/lang/Exception
    //   128	135	349	java/lang/Exception
    //   145	180	349	java/lang/Exception
    //   185	245	349	java/lang/Exception
    //   314	340	349	java/lang/Exception
    //   409	447	666	java/lang/Exception
    //   452	463	666	java/lang/Exception
    //   463	476	666	java/lang/Exception
    //   481	522	666	java/lang/Exception
    //   522	557	666	java/lang/Exception
    //   558	624	666	java/lang/Exception
    //   629	640	666	java/lang/Exception
    //   640	663	666	java/lang/Exception
  }
  
  protected static String lB(String paramString1, String paramString2)
  {
    kotlin.g.b.p.h(paramString1, "appId");
    kotlin.g.b.p.h(paramString2, "path");
    return paramString1 + ':' + URLEncoder.encode(paramString2);
  }
  
  /* Error */
  public final void P(final kotlin.g.a.b<? super String, kotlin.x> paramb)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 454	com/tencent/mm/plugin/ac/c:fWy	()Lcom/tencent/mm/plugin/ac/g;
    //   4: new 456	com/tencent/mm/plugin/ac/g$i
    //   7: dup
    //   8: invokespecial 457	com/tencent/mm/plugin/ac/g$i:<init>	()V
    //   11: checkcast 459	com/tencent/mm/plugin/ac/g$o
    //   14: invokevirtual 464	com/tencent/mm/plugin/ac/g:a	(Lcom/tencent/mm/plugin/ac/g$o;)V
    //   17: aload_0
    //   18: invokevirtual 468	com/tencent/mm/plugin/ac/c:fWB	()Lcom/tencent/mm/ab/i;
    //   21: astore 4
    //   23: aload_0
    //   24: invokevirtual 454	com/tencent/mm/plugin/ac/c:fWy	()Lcom/tencent/mm/plugin/ac/g;
    //   27: new 470	com/tencent/mm/plugin/ac/g$m
    //   30: dup
    //   31: invokespecial 471	com/tencent/mm/plugin/ac/g$m:<init>	()V
    //   34: checkcast 459	com/tencent/mm/plugin/ac/g$o
    //   37: invokevirtual 464	com/tencent/mm/plugin/ac/g:a	(Lcom/tencent/mm/plugin/ac/g$o;)V
    //   40: new 473	com/tencent/mm/plugin/ab/l
    //   43: dup
    //   44: new 21	com/tencent/mm/plugin/ac/c$d
    //   47: dup
    //   48: aload_0
    //   49: aload_1
    //   50: invokespecial 476	com/tencent/mm/plugin/ac/c$d:<init>	(Lcom/tencent/mm/plugin/ac/c;Lkotlin/g/a/b;)V
    //   53: checkcast 478	com/tencent/mm/plugin/ab/m
    //   56: invokespecial 481	com/tencent/mm/plugin/ab/l:<init>	(Lcom/tencent/mm/plugin/ab/m;)V
    //   59: astore 5
    //   61: aload_0
    //   62: invokevirtual 485	com/tencent/mm/plugin/ac/c:bMD	()Lcom/tencent/mm/plugin/appbrand/m/g;
    //   65: astore 6
    //   67: aload 6
    //   69: ldc_w 487
    //   72: invokestatic 296	kotlin/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   75: aload 5
    //   77: aload 6
    //   79: checkcast 256	com/tencent/mm/plugin/appbrand/m/i
    //   82: invokevirtual 488	com/tencent/mm/plugin/ab/l:f	(Lcom/tencent/mm/plugin/appbrand/m/i;)V
    //   85: aload_0
    //   86: invokevirtual 485	com/tencent/mm/plugin/ac/c:bMD	()Lcom/tencent/mm/plugin/appbrand/m/g;
    //   89: aload_0
    //   90: getfield 215	com/tencent/mm/plugin/ac/c:IBS	Lkotlin/f;
    //   93: invokeinterface 411 1 0
    //   98: checkcast 163	java/lang/String
    //   101: aconst_null
    //   102: invokeinterface 379 3 0
    //   107: aload 4
    //   109: ldc_w 490
    //   112: invokevirtual 494	com/tencent/mm/ab/i:FJ	(Ljava/lang/String;)Lcom/tencent/mm/ab/i;
    //   115: astore 5
    //   117: aload_0
    //   118: invokevirtual 485	com/tencent/mm/plugin/ac/c:bMD	()Lcom/tencent/mm/plugin/appbrand/m/g;
    //   121: astore 6
    //   123: aload 6
    //   125: ldc_w 487
    //   128: invokestatic 296	kotlin/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   131: new 321	com/tencent/mm/plugin/ac/f
    //   134: dup
    //   135: aload 5
    //   137: ldc_w 496
    //   140: lconst_0
    //   141: invokevirtual 500	com/tencent/mm/ab/i:optLong	(Ljava/lang/String;J)J
    //   144: getstatic 506	com/tencent/mm/plugin/ac/f$j:ICo	Lcom/tencent/mm/plugin/ac/f$j;
    //   147: invokespecial 509	com/tencent/mm/plugin/ac/f:<init>	(JLcom/tencent/mm/plugin/ac/f$j;)V
    //   150: astore 7
    //   152: aload 5
    //   154: ldc 229
    //   156: invokevirtual 512	com/tencent/mm/ab/i:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   159: astore 8
    //   161: aload 8
    //   163: ldc_w 514
    //   166: invokestatic 296	kotlin/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   169: aload_0
    //   170: aload 5
    //   172: aload 6
    //   174: aload 7
    //   176: iconst_1
    //   177: aload 8
    //   179: ldc_w 432
    //   182: aload_1
    //   183: invokespecial 434	com/tencent/mm/plugin/ac/c:a	(Lcom/tencent/mm/ab/i;Lcom/tencent/mm/plugin/appbrand/m/g;Lcom/tencent/mm/plugin/ac/f;ZLjava/lang/String;Ljava/lang/String;Lkotlin/g/a/b;)V
    //   186: aload_0
    //   187: invokevirtual 454	com/tencent/mm/plugin/ac/c:fWy	()Lcom/tencent/mm/plugin/ac/g;
    //   190: new 516	com/tencent/mm/plugin/ac/g$n
    //   193: dup
    //   194: invokespecial 517	com/tencent/mm/plugin/ac/g$n:<init>	()V
    //   197: checkcast 459	com/tencent/mm/plugin/ac/g$o
    //   200: invokevirtual 464	com/tencent/mm/plugin/ac/g:a	(Lcom/tencent/mm/plugin/ac/g$o;)V
    //   203: aload 4
    //   205: ldc_w 519
    //   208: invokevirtual 268	com/tencent/mm/ab/i:has	(Ljava/lang/String;)Z
    //   211: ifeq +267 -> 478
    //   214: aload_0
    //   215: invokevirtual 454	com/tencent/mm/plugin/ac/c:fWy	()Lcom/tencent/mm/plugin/ac/g;
    //   218: new 521	com/tencent/mm/plugin/ac/g$g
    //   221: dup
    //   222: invokespecial 522	com/tencent/mm/plugin/ac/g$g:<init>	()V
    //   225: checkcast 459	com/tencent/mm/plugin/ac/g$o
    //   228: invokevirtual 464	com/tencent/mm/plugin/ac/g:a	(Lcom/tencent/mm/plugin/ac/g$o;)V
    //   231: aload 4
    //   233: ldc_w 519
    //   236: invokevirtual 272	com/tencent/mm/ab/i:FH	(Ljava/lang/String;)Lcom/tencent/mm/ab/f;
    //   239: astore_1
    //   240: aload_1
    //   241: ifnull +220 -> 461
    //   244: aload_1
    //   245: invokevirtual 277	com/tencent/mm/ab/f:length	()I
    //   248: istore_3
    //   249: iconst_0
    //   250: istore_2
    //   251: iload_2
    //   252: iload_3
    //   253: if_icmpge +208 -> 461
    //   256: aload_1
    //   257: iload_2
    //   258: invokevirtual 526	com/tencent/mm/ab/f:pY	(I)Lcom/tencent/mm/ab/i;
    //   261: astore 4
    //   263: aload 4
    //   265: ldc 229
    //   267: invokevirtual 355	com/tencent/mm/ab/i:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   270: astore 5
    //   272: aload_0
    //   273: getfield 207	com/tencent/mm/plugin/ac/c:IBR	Ljava/util/HashMap;
    //   276: checkcast 381	java/util/Map
    //   279: astore 6
    //   281: aload 5
    //   283: ldc_w 528
    //   286: invokestatic 296	kotlin/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   289: aload_0
    //   290: invokevirtual 531	com/tencent/mm/plugin/ac/c:bME	()Lcom/tencent/mm/plugin/appbrand/m/g;
    //   293: astore 7
    //   295: aload 4
    //   297: ldc_w 533
    //   300: invokestatic 296	kotlin/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   303: aload 7
    //   305: ldc 227
    //   307: invokestatic 296	kotlin/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   310: aload_0
    //   311: aload 4
    //   313: aload 7
    //   315: new 321	com/tencent/mm/plugin/ac/f
    //   318: dup
    //   319: aload 4
    //   321: ldc_w 496
    //   324: invokevirtual 537	com/tencent/mm/ab/i:getLong	(Ljava/lang/String;)J
    //   327: getstatic 540	com/tencent/mm/plugin/ac/f$j:ICp	Lcom/tencent/mm/plugin/ac/f$j;
    //   330: invokespecial 509	com/tencent/mm/plugin/ac/f:<init>	(JLcom/tencent/mm/plugin/ac/f$j;)V
    //   333: iconst_1
    //   334: aconst_null
    //   335: aconst_null
    //   336: bipush 56
    //   338: invokestatic 542	com/tencent/mm/plugin/ac/c:a	(Lcom/tencent/mm/plugin/ac/c;Lcom/tencent/mm/ab/i;Lcom/tencent/mm/plugin/appbrand/m/g;Lcom/tencent/mm/plugin/ac/f;ZLjava/lang/String;Ljava/lang/String;I)V
    //   341: getstatic 139	com/tencent/mm/plugin/ac/c:TAG	Ljava/lang/String;
    //   344: new 141	java/lang/StringBuilder
    //   347: dup
    //   348: ldc_w 544
    //   351: invokespecial 309	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   354: aload 5
    //   356: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: bipush 35
    //   361: invokevirtual 445	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   364: aload 7
    //   366: invokeinterface 237 1 0
    //   371: invokevirtual 240	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   374: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   377: invokestatic 177	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   380: aload 6
    //   382: aload 5
    //   384: aload 7
    //   386: invokeinterface 237 1 0
    //   391: invokestatic 386	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   394: invokeinterface 390 3 0
    //   399: pop
    //   400: iload_2
    //   401: iconst_1
    //   402: iadd
    //   403: istore_2
    //   404: goto -153 -> 251
    //   407: astore_1
    //   408: aload_0
    //   409: invokevirtual 454	com/tencent/mm/plugin/ac/c:fWy	()Lcom/tencent/mm/plugin/ac/g;
    //   412: new 546	com/tencent/mm/plugin/ac/g$k
    //   415: dup
    //   416: invokespecial 547	com/tencent/mm/plugin/ac/g$k:<init>	()V
    //   419: checkcast 459	com/tencent/mm/plugin/ac/g$o
    //   422: invokevirtual 464	com/tencent/mm/plugin/ac/g:a	(Lcom/tencent/mm/plugin/ac/g$o;)V
    //   425: getstatic 139	com/tencent/mm/plugin/ac/c:TAG	Ljava/lang/String;
    //   428: aload_1
    //   429: checkcast 326	java/lang/Throwable
    //   432: ldc_w 549
    //   435: iconst_0
    //   436: anewarray 330	java/lang/Object
    //   439: invokestatic 334	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   442: getstatic 340	com/tencent/mm/plugin/webcanvas/l:IAx	Lcom/tencent/mm/plugin/webcanvas/l;
    //   445: astore 4
    //   447: ldc_w 432
    //   450: ldc_w 490
    //   453: aload_1
    //   454: invokevirtual 343	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   457: invokestatic 347	com/tencent/mm/plugin/webcanvas/l:ba	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   460: return
    //   461: aload_0
    //   462: invokevirtual 454	com/tencent/mm/plugin/ac/c:fWy	()Lcom/tencent/mm/plugin/ac/g;
    //   465: new 551	com/tencent/mm/plugin/ac/g$h
    //   468: dup
    //   469: invokespecial 552	com/tencent/mm/plugin/ac/g$h:<init>	()V
    //   472: checkcast 459	com/tencent/mm/plugin/ac/g$o
    //   475: invokevirtual 464	com/tencent/mm/plugin/ac/g:a	(Lcom/tencent/mm/plugin/ac/g$o;)V
    //   478: aload_0
    //   479: invokevirtual 454	com/tencent/mm/plugin/ac/c:fWy	()Lcom/tencent/mm/plugin/ac/g;
    //   482: new 554	com/tencent/mm/plugin/ac/g$j
    //   485: dup
    //   486: invokespecial 555	com/tencent/mm/plugin/ac/g$j:<init>	()V
    //   489: checkcast 459	com/tencent/mm/plugin/ac/g$o
    //   492: invokevirtual 464	com/tencent/mm/plugin/ac/g:a	(Lcom/tencent/mm/plugin/ac/g$o;)V
    //   495: return
    //   496: astore_1
    //   497: aload_0
    //   498: invokevirtual 454	com/tencent/mm/plugin/ac/c:fWy	()Lcom/tencent/mm/plugin/ac/g;
    //   501: new 557	com/tencent/mm/plugin/ac/g$e
    //   504: dup
    //   505: invokespecial 558	com/tencent/mm/plugin/ac/g$e:<init>	()V
    //   508: checkcast 459	com/tencent/mm/plugin/ac/g$o
    //   511: invokevirtual 464	com/tencent/mm/plugin/ac/g:a	(Lcom/tencent/mm/plugin/ac/g$o;)V
    //   514: getstatic 139	com/tencent/mm/plugin/ac/c:TAG	Ljava/lang/String;
    //   517: aload_1
    //   518: checkcast 326	java/lang/Throwable
    //   521: ldc_w 560
    //   524: iconst_0
    //   525: anewarray 330	java/lang/Object
    //   528: invokestatic 334	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   531: getstatic 340	com/tencent/mm/plugin/webcanvas/l:IAx	Lcom/tencent/mm/plugin/webcanvas/l;
    //   534: astore 4
    //   536: ldc_w 432
    //   539: ldc_w 519
    //   542: aload_1
    //   543: invokevirtual 343	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   546: invokestatic 347	com/tencent/mm/plugin/webcanvas/l:ba	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   549: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	550	0	this	c
    //   0	550	1	paramb	kotlin.g.a.b<? super String, kotlin.x>
    //   250	154	2	i	int
    //   248	6	3	j	int
    //   21	514	4	localObject1	Object
    //   59	324	5	localObject2	Object
    //   65	316	6	localObject3	Object
    //   150	235	7	localObject4	Object
    //   159	19	8	str	String
    // Exception table:
    //   from	to	target	type
    //   23	203	407	java/lang/Exception
    //   214	240	496	java/lang/Exception
    //   244	249	496	java/lang/Exception
    //   256	400	496	java/lang/Exception
    //   461	478	496	java/lang/Exception
  }
  
  public void a(com.tencent.mm.plugin.appbrand.m.g paramg, String paramString1, String paramString2, kotlin.g.a.b<? super String, kotlin.x> paramb, c.a parama)
  {
    kotlin.g.b.p.h(paramg, "context");
    kotlin.g.b.p.h(paramString1, "name");
    kotlin.g.b.p.h(paramString2, "type");
    locala = parama;
    if (parama == null) {}
    try
    {
      locala = aWx(paramString2);
      parama = new f(locala.IBV, f.j.ICq);
      i locali;
      return;
    }
    catch (Exception paramg)
    {
      try
      {
        fWy().a((g.o)new g.c());
        locali = aWQ(paramString2);
        parama.a((f.i)new f.g());
        a(this, locali, paramg, parama, false, paramString1, locala.appId, 36);
        a(paramString1, paramString2, paramg, parama, paramb);
        parama.a((f.i)new f.h());
        fWy().a((g.o)new g.d());
        return;
      }
      catch (Exception paramg)
      {
        fWy().a((g.o)new g.a());
        parama.a((f.i)new f.b());
        paramString2 = com.tencent.mm.plugin.webcanvas.l.IAx;
        com.tencent.mm.plugin.webcanvas.l.ba(locala.appId, paramString1, paramg.getMessage());
        Log.printErrStackTrace(TAG, (Throwable)paramg, "configClient engineContext err", new Object[0]);
      }
      paramg = paramg;
      Log.printErrStackTrace(TAG, (Throwable)paramg, "configClient getClientInfo err", new Object[0]);
      paramString2 = com.tencent.mm.plugin.webcanvas.l.IAx;
      com.tencent.mm.plugin.webcanvas.l.ba("ClientInfo", paramString1, paramg.getMessage());
      return;
    }
  }
  
  protected void a(String paramString1, String paramString2, com.tencent.mm.plugin.appbrand.m.g paramg, f paramf, kotlin.g.a.b<? super String, kotlin.x> paramb)
  {
    kotlin.g.b.p.h(paramString1, "name");
    kotlin.g.b.p.h(paramString2, "type");
    kotlin.g.b.p.h(paramg, "context");
    kotlin.g.b.p.h(paramf, "contextReporter");
  }
  
  public final void a(String paramString1, String paramString2, List<? extends Object> paramList, kotlin.g.a.b<? super String, kotlin.x> paramb)
  {
    kotlin.g.b.p.h(paramString1, "target");
    kotlin.g.b.p.h(paramString2, "func");
    kotlin.g.b.p.h(paramb, "callback");
    StringBuilder localStringBuilder = new StringBuilder("invokeMethod('").append(paramString2).append("', { target: '").append(paramString1).append("', data: { params: ");
    if (paramList != null)
    {
      paramString2 = j.a((Iterable)paramList, (CharSequence)",", (CharSequence)"[", (CharSequence)"]", 0, null, (kotlin.g.a.b)c.b.c.ICa, 24);
      paramString1 = paramString2;
      if (paramString2 != null) {}
    }
    else
    {
      paramString1 = "[]";
    }
    evaluateJavascript(paramString1 + "}})", (ValueCallback)new e(paramb));
  }
  
  public i aWQ(String paramString)
  {
    kotlin.g.b.p.h(paramString, "type");
    paramString = fWB().FJ("client");
    kotlin.g.b.p.g(paramString, "vmConfig.getJSONObject(\"client\")");
    return paramString;
  }
  
  protected abstract c.a aWx(String paramString);
  
  public final void b(String paramString1, String paramString2, ValueCallback<String> paramValueCallback)
  {
    kotlin.g.b.p.h(paramString1, "eventType");
    kotlin.g.b.p.h(paramString2, "event");
    if (kotlin.g.b.p.j(paramString1, "")) {
      Log.i(TAG, "skip dispath");
    }
    do
    {
      return;
      evaluateJavascript("dispatchEvent('" + paramString1 + "', " + paramString2 + ')', paramValueCallback);
    } while ((n.J(paramString1, "touch", false)) || (!(kotlin.g.b.p.j(paramString1, "scroll") ^ true)) || (!(kotlin.g.b.p.j(paramString1, "message") ^ true)));
    Log.d(TAG, "dispatch: " + paramString1 + ", " + paramString2);
  }
  
  protected i fWB()
  {
    return (i)this.IAm.getValue();
  }
  
  protected abstract g fWy();
  
  public abstract com.tencent.mm.plugin.appbrand.appcache.p fWz();
  
  public final i fXe()
  {
    return (i)this.IBP.getValue();
  }
  
  public String fXf()
  {
    String str = getClass().getSimpleName();
    kotlin.g.b.p.g(str, "this.javaClass.simpleName");
    return str;
  }
  
  public final IJSRuntime g(IJSRuntime.Config paramConfig)
  {
    IJSRuntime.Config localConfig = paramConfig;
    if (paramConfig == null) {
      localConfig = new IJSRuntime.Config();
    }
    localConfig.dpr = (fXf() + '#');
    Log.d(TAG, "createJSRuntime " + localConfig.dpr);
    paramConfig = new o(com.tencent.mm.loader.j.b.aKB() + "webservice/codecache");
    if (!paramConfig.exists()) {
      paramConfig.mkdirs();
    }
    localConfig.dpj = paramConfig.getPath();
    if (!((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rSh, false))
    {
      Log.d(TAG, "use code cache");
      if (com.tencent.mm.compatible.deviceinfo.q.is64BitRuntime()) {
        paramConfig = d.afB("wxa_library/v8_snapshot64.bin");
      }
    }
    for (;;)
    {
      localConfig.dpk = paramConfig;
      return super.g(localConfig);
      paramConfig = d.afB("wxa_library/v8_snapshot.bin");
      continue;
      paramConfig = null;
    }
  }
  
  public final void lC(String paramString1, String paramString2)
  {
    kotlin.g.b.p.h(paramString1, "message");
    kotlin.g.b.p.h(paramString2, "targetOrigin");
    com.tencent.mm.plugin.ab.c.a.a(this, "message", "{ target:'" + paramString2 + "', data: " + paramString1 + " }", null, 4);
  }
  
  protected abstract void ly(String paramString1, String paramString2);
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webjsengine/WebJsEngine$Companion;", "", "()V", "DEBUG_PATH", "", "TAG", "meta", "Lcom/tencent/mm/json/JSONObject;", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;", "getMeta", "(Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;)Lcom/tencent/mm/json/JSONObject;", "version", "", "getVersion", "(Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;)I", "getDebugInfo", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngine$Companion$ReadPkgInfo;", "file", "isPreview", "", "resPath", "appId", "readPkg", "pkgInfo", "validResPkg", "Lkotlin/Function3;", "callback", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngine$ReadPkgResult;", "", "hasAssets", "readFile", "path", "safeReadFile", "toJsonString", "", "ReadPkgInfo", "webview-sdk_release"})
  public static final class b
  {
    public static int a(com.tencent.mm.plugin.appbrand.appcache.p paramp)
    {
      AppMethodBeat.i(224883);
      kotlin.g.b.p.h(paramp, "$this$version");
      b localb = c.IBU;
      int i = b(paramp).optInt("version");
      AppMethodBeat.o(224883);
      return i;
    }
    
    public static a a(String paramString1, boolean paramBoolean, String paramString2, String paramString3)
    {
      AppMethodBeat.i(224884);
      kotlin.g.b.p.h(paramString1, "file");
      kotlin.g.b.p.h(paramString3, "appId");
      String str = c.fXg() + '/' + paramString1;
      paramString1 = "jsapi/".concat(String.valueOf(paramString1));
      if (((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED) || (WeChatEnvironment.hasDebugger())) && (s.YS(str)))
      {
        paramString1 = new a(true, paramBoolean, str, paramString1, paramString3);
        AppMethodBeat.o(224884);
        return paramString1;
      }
      paramString1 = new a(false, paramBoolean, paramString2, paramString1, paramString3);
      AppMethodBeat.o(224884);
      return paramString1;
    }
    
    public static com.tencent.mm.plugin.appbrand.appcache.p a(a parama, final kotlin.g.a.q<? super Integer, ? super Integer, ? super com.tencent.mm.plugin.appbrand.appcache.p, Boolean> paramq, final kotlin.g.a.q<? super c.c, ? super Integer, ? super String, kotlin.x> paramq1, boolean paramBoolean)
    {
      AppMethodBeat.i(224885);
      kotlin.g.b.p.h(parama, "pkgInfo");
      kotlin.g.b.p.h(paramq, "validResPkg");
      kotlin.g.b.p.h(paramq1, "callback");
      Object localObject1 = new b(parama, paramq, paramq1);
      Object localObject2;
      if ((parama.IBW) && (s.YS(parama.cHM)))
      {
        localObject1 = (com.tencent.mm.plugin.appbrand.appcache.p)new WxaPkg(parama.cHM);
        ((com.tencent.mm.plugin.appbrand.appcache.p)localObject1).bvf();
        paramq = c.IBU;
        j = a((com.tencent.mm.plugin.appbrand.appcache.p)localObject1);
        localObject2 = c.access$getTAG$cp();
        StringBuilder localStringBuilder = new StringBuilder("#readPkg ").append(parama.appId).append(" use ");
        if (parama.isPreview)
        {
          paramq = "preview";
          Log.i((String)localObject2, paramq);
          paramq = com.tencent.mm.plugin.report.service.h.CyF;
          localObject2 = parama.appId;
          if (!parama.isPreview) {
            break label243;
          }
          i = 1;
          label159:
          paramq.a(20781, new Object[] { localObject2, Integer.valueOf(0), Integer.valueOf(j), Integer.valueOf(i), "" });
          if (!parama.isPreview) {
            break label249;
          }
        }
        label243:
        label249:
        for (parama = c.c.ICc;; parama = c.c.ICb)
        {
          paramq1.d(parama, Integer.valueOf(j), "");
          AppMethodBeat.o(224885);
          return localObject1;
          paramq = "debug";
          break;
          i = 0;
          break label159;
        }
      }
      if (!paramBoolean) {
        try
        {
          paramq = ((b)localObject1).afm(0);
          if (paramq == null) {
            kotlin.g.b.p.hyc();
          }
          AppMethodBeat.o(224885);
          return paramq;
        }
        catch (Exception paramq)
        {
          Log.i(c.access$getTAG$cp(), "#readPkg " + parama.appId + "  fail " + paramq.getMessage());
          parama = (Throwable)paramq;
          AppMethodBeat.o(224885);
          throw parama;
        }
      }
      paramq = (com.tencent.mm.plugin.appbrand.appcache.p)new com.tencent.mm.plugin.appbrand.appcache.f(MMApplicationContext.getContext(), parama.IBX);
      paramq.bvf();
      int j = 0;
      int i = j;
      try
      {
        localObject2 = c.IBU;
        i = j;
        j = a(paramq);
        i = j;
        localObject1 = ((b)localObject1).afm(j);
        i = j;
        if (localObject1 != null)
        {
          i = j;
          AppMethodBeat.o(224885);
          return localObject1;
        }
      }
      catch (Exception localException)
      {
        Log.e(c.access$getTAG$cp(), "#readPkg " + parama.cHM + " handle error: " + parama.appId + ' ' + localException.getMessage() + " version:" + i);
        com.tencent.mm.plugin.report.service.h.CyF.a(20781, new Object[] { parama.appId, Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(2), localException.getMessage() });
        paramq1.d(c.c.ICf, Integer.valueOf(i), localException.getMessage());
        Log.i(c.access$getTAG$cp(), "#readPkg " + parama.appId + " use assert version:" + i);
        com.tencent.mm.plugin.report.service.h.CyF.a(20781, new Object[] { parama.appId, Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(2), "" });
        paramq1.d(c.c.ICe, Integer.valueOf(i), "");
        AppMethodBeat.o(224885);
      }
      return paramq;
    }
    
    /* Error */
    public static String a(com.tencent.mm.plugin.appbrand.appcache.p paramp, String paramString)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore_2
      //   2: ldc_w 277
      //   5: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   8: aload_0
      //   9: ldc_w 279
      //   12: invokestatic 73	kotlin/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
      //   15: aload_1
      //   16: ldc_w 280
      //   19: invokestatic 73	kotlin/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
      //   22: aload_0
      //   23: aload_1
      //   24: invokeinterface 284 2 0
      //   29: checkcast 286	java/io/Closeable
      //   32: astore_3
      //   33: aload_3
      //   34: checkcast 288	java/io/InputStream
      //   37: astore_0
      //   38: aload_0
      //   39: ldc_w 290
      //   42: invokestatic 293	kotlin/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
      //   45: new 115	java/lang/String
      //   48: dup
      //   49: aload_0
      //   50: invokestatic 299	kotlin/f/a:U	(Ljava/io/InputStream;)[B
      //   53: getstatic 305	kotlin/n/d:UTF_8	Ljava/nio/charset/Charset;
      //   56: invokespecial 308	java/lang/String:<init>	([BLjava/nio/charset/Charset;)V
      //   59: astore_0
      //   60: aload_3
      //   61: aconst_null
      //   62: invokestatic 313	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
      //   65: ldc_w 277
      //   68: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   71: aload_0
      //   72: areturn
      //   73: astore_1
      //   74: ldc_w 277
      //   77: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   80: aload_1
      //   81: athrow
      //   82: astore_0
      //   83: aload_3
      //   84: aload_1
      //   85: invokestatic 313	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
      //   88: ldc_w 277
      //   91: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   94: aload_0
      //   95: athrow
      //   96: astore_0
      //   97: aload_2
      //   98: astore_1
      //   99: goto -16 -> 83
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	102	0	paramp	com.tencent.mm.plugin.appbrand.appcache.p
      //   0	102	1	paramString	String
      //   1	97	2	localObject	Object
      //   32	52	3	localCloseable	java.io.Closeable
      // Exception table:
      //   from	to	target	type
      //   33	60	73	java/lang/Throwable
      //   74	82	82	finally
      //   33	60	96	finally
    }
    
    public static i b(com.tencent.mm.plugin.appbrand.appcache.p paramp)
    {
      AppMethodBeat.i(224882);
      kotlin.g.b.p.h(paramp, "$this$meta");
      b localb = c.IBU;
      paramp = new i(a(paramp, "/meta.json"));
      AppMethodBeat.o(224882);
      return paramp;
    }
    
    /* Error */
    public static String b(com.tencent.mm.plugin.appbrand.appcache.p paramp, String paramString)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore_2
      //   2: ldc_w 322
      //   5: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   8: aload_0
      //   9: ldc_w 324
      //   12: invokestatic 73	kotlin/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
      //   15: aload_1
      //   16: ldc_w 280
      //   19: invokestatic 73	kotlin/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
      //   22: aload_0
      //   23: aload_1
      //   24: invokeinterface 284 2 0
      //   29: checkcast 286	java/io/Closeable
      //   32: astore_3
      //   33: aload_3
      //   34: checkcast 288	java/io/InputStream
      //   37: astore_0
      //   38: aload_0
      //   39: ifnull +31 -> 70
      //   42: new 115	java/lang/String
      //   45: dup
      //   46: aload_0
      //   47: invokestatic 299	kotlin/f/a:U	(Ljava/io/InputStream;)[B
      //   50: getstatic 305	kotlin/n/d:UTF_8	Ljava/nio/charset/Charset;
      //   53: invokespecial 308	java/lang/String:<init>	([BLjava/nio/charset/Charset;)V
      //   56: astore_0
      //   57: aload_3
      //   58: aconst_null
      //   59: invokestatic 313	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
      //   62: ldc_w 322
      //   65: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   68: aload_0
      //   69: areturn
      //   70: ldc 207
      //   72: astore_0
      //   73: goto -16 -> 57
      //   76: astore_1
      //   77: ldc_w 322
      //   80: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   83: aload_1
      //   84: athrow
      //   85: astore_0
      //   86: aload_3
      //   87: aload_1
      //   88: invokestatic 313	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
      //   91: ldc_w 322
      //   94: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   97: aload_0
      //   98: athrow
      //   99: astore_0
      //   100: aload_2
      //   101: astore_1
      //   102: goto -16 -> 86
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	105	0	paramp	com.tencent.mm.plugin.appbrand.appcache.p
      //   0	105	1	paramString	String
      //   1	100	2	localObject	Object
      //   32	55	3	localCloseable	java.io.Closeable
      // Exception table:
      //   from	to	target	type
      //   33	38	76	java/lang/Throwable
      //   42	57	76	java/lang/Throwable
      //   77	85	85	finally
      //   33	38	99	finally
      //   42	57	99	finally
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webjsengine/WebJsEngine$Companion$ReadPkgInfo;", "", "isDebugger", "", "isPreview", "resPath", "", "assetsPath", "appId", "(ZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "getAssetsPath", "()Z", "getResPath", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "webview-sdk_release"})
    public static final class a
    {
      final boolean IBW;
      final String IBX;
      final String appId;
      public final String cHM;
      final boolean isPreview;
      
      public a(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2, String paramString3)
      {
        AppMethodBeat.i(224872);
        this.IBW = paramBoolean1;
        this.isPreview = paramBoolean2;
        this.cHM = paramString1;
        this.IBX = paramString2;
        this.appId = paramString3;
        AppMethodBeat.o(224872);
      }
      
      public final boolean equals(Object paramObject)
      {
        AppMethodBeat.i(224875);
        if (this != paramObject)
        {
          if ((paramObject instanceof a))
          {
            paramObject = (a)paramObject;
            if ((this.IBW != paramObject.IBW) || (this.isPreview != paramObject.isPreview) || (!kotlin.g.b.p.j(this.cHM, paramObject.cHM)) || (!kotlin.g.b.p.j(this.IBX, paramObject.IBX)) || (!kotlin.g.b.p.j(this.appId, paramObject.appId))) {}
          }
        }
        else
        {
          AppMethodBeat.o(224875);
          return true;
        }
        AppMethodBeat.o(224875);
        return false;
      }
      
      public final int hashCode()
      {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
      }
      
      public final String toString()
      {
        AppMethodBeat.i(224873);
        String str = "ReadPkgInfo(isDebugger=" + this.IBW + ", isPreview=" + this.isPreview + ", resPath=" + this.cHM + ", assetsPath=" + this.IBX + ", appId=" + this.appId + ")";
        AppMethodBeat.o(224873);
        return str;
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"readResPkg", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;", "assetsVersion", "", "invoke"})
    static final class b
      extends kotlin.g.b.q
      implements kotlin.g.a.b<Integer, com.tencent.mm.plugin.appbrand.appcache.p>
    {
      b(c.b.a parama, kotlin.g.a.q paramq1, kotlin.g.a.q paramq2)
      {
        super();
      }
      
      public final com.tencent.mm.plugin.appbrand.appcache.p afm(int paramInt)
      {
        AppMethodBeat.i(224877);
        if (s.YS(this.IBY.cHM))
        {
          com.tencent.mm.plugin.appbrand.appcache.p localp = (com.tencent.mm.plugin.appbrand.appcache.p)new WxaPkg(this.IBY.cHM);
          localp.bvf();
          c.b localb = c.IBU;
          int i = c.b.a(localp);
          Log.i(c.access$getTAG$cp(), "#readPkg " + this.IBY.appId + " resVersion = " + i + " assetsVersion=" + paramInt);
          if (((Boolean)paramq.d(Integer.valueOf(paramInt), Integer.valueOf(i), localp)).booleanValue())
          {
            Log.i(c.access$getTAG$cp(), "#readPkg " + this.IBY.appId + " use res");
            paramInt = com.tencent.mm.plugin.webcanvas.m.IAG.aWK(this.IBY.appId);
            com.tencent.mm.plugin.report.service.h.CyF.a(20781, new Object[] { this.IBY.appId, Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(3), "" });
            paramq1.d(c.c.ICd, Integer.valueOf(i), "");
            AppMethodBeat.o(224877);
            return localp;
          }
        }
        AppMethodBeat.o(224877);
        return null;
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webjsengine/WebJsEngine$ReadPkgResult;", "", "(Ljava/lang/String;I)V", "UseDebugPkg", "UsePreviewPkg", "UseResPkg", "UseAssetsPkg", "FallbackAssetsPkg", "webview-sdk_release"})
  public static enum c
  {
    static
    {
      AppMethodBeat.i(224886);
      c localc1 = new c("UseDebugPkg", 0);
      ICb = localc1;
      c localc2 = new c("UsePreviewPkg", 1);
      ICc = localc2;
      c localc3 = new c("UseResPkg", 2);
      ICd = localc3;
      c localc4 = new c("UseAssetsPkg", 3);
      ICe = localc4;
      c localc5 = new c("FallbackAssetsPkg", 4);
      ICf = localc5;
      ICg = new c[] { localc1, localc2, localc3, localc4, localc5 };
      AppMethodBeat.o(224886);
    }
    
    private c() {}
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/webjsengine/WebJsEngine$config$1$1", "Lcom/tencent/mm/plugin/webjsapi/WxMessageAPIContext;", "postMessage", "", "message", "", "targetOrigin", "webview-sdk_release"})
  public static final class d
    implements com.tencent.mm.plugin.ab.m
  {
    d(c paramc, kotlin.g.a.b paramb) {}
    
    public final void postMessage(String paramString1, String paramString2)
    {
      AppMethodBeat.i(224890);
      kotlin.g.b.p.h(paramString1, "message");
      kotlin.g.b.p.h(paramString2, "targetOrigin");
      this.ICh.ly(paramString1, paramString2);
      AppMethodBeat.o(224890);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/json/JSONObject;", "invoke"})
  static final class e
    extends kotlin.g.b.q
    implements a<i>
  {
    e(c paramc)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "message", "", "kotlin.jvm.PlatformType", "stackTrace", "handleException", "com/tencent/mm/plugin/webjsengine/WebJsEngine$setup$1$1"})
  static final class g
    implements com.tencent.mm.plugin.appbrand.m.h
  {
    g(com.tencent.mm.plugin.appbrand.m.g paramg, c paramc, String paramString1, f paramf, String paramString2, String paramString3) {}
    
    public final void u(String paramString1, String paramString2)
    {
      AppMethodBeat.i(224895);
      Log.e(c.access$getTAG$cp(), "JsException[" + str1 + "]:" + paramString1 + '\n' + paramString2);
      paramf.a((f.i)new f.d());
      Object localObject2 = jdField_this.fWy();
      Object localObject1 = paramf.ICn;
      switch (d.$EnumSwitchMapping$0[localObject1.ordinal()])
      {
      default: 
        localObject1 = (g.o)new g.b();
      }
      for (;;)
      {
        ((g)localObject2).a((g.o)localObject1);
        localObject1 = jdField_this;
        int i = this.ICk.bMC();
        localObject2 = paramString1;
        kotlin.g.b.p.h(localObject2, "name");
        Object localObject3 = new i();
        ((i)localObject3).U("id", i);
        ((i)localObject3).h("name", localObject2);
        ((i)localObject3).h("message", paramString1);
        ((i)localObject3).h("stackTrace", paramString2);
        paramString1 = ((i)localObject3).toString();
        kotlin.g.b.p.g(paramString1, "err.toString()");
        com.tencent.mm.plugin.ab.c.a.a((com.tencent.mm.plugin.ab.c)localObject1, "error", paramString1, null, 4);
        AppMethodBeat.o(224895);
        return;
        localObject1 = new g.l();
        localObject3 = com.tencent.mm.plugin.webcanvas.l.IAx;
        com.tencent.mm.plugin.webcanvas.l.ba(paramString2, paramString1, paramString1 + '\t' + paramString2);
        localObject1 = (g.o)localObject1;
        continue;
        localObject1 = new g.f();
        localObject3 = com.tencent.mm.plugin.webcanvas.l.IAx;
        com.tencent.mm.plugin.webcanvas.l.ba(paramString2, paramString1, paramString1 + '\t' + paramString2);
        localObject1 = (g.o)localObject1;
        continue;
        localObject1 = new g.b();
        localObject3 = com.tencent.mm.plugin.webcanvas.l.IAx;
        com.tencent.mm.plugin.webcanvas.l.ba(paramString2, paramString1, paramString1 + '\t' + paramString2);
        localObject1 = (g.o)localObject1;
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class h
    extends kotlin.g.b.q
    implements a<Integer>
  {
    h(c paramc)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/json/JSONObject;", "kotlin.jvm.PlatformType", "invoke"})
  static final class i
    extends kotlin.g.b.q
    implements a<i>
  {
    i(c paramc)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ac.c
 * JD-Core Version:    0.7.0.1
 */