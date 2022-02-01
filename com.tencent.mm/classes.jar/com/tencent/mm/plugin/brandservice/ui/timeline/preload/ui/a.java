package com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui;

import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.j;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.j.a;
import com.tencent.mm.plugin.webview.core.BaseWebViewController;
import com.tencent.mm.pluginsdk.r;
import com.tencent.mm.protocal.protobuf.ese;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMSlotKt;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV.NativeBuffer;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.vfs.u;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.c;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.n.n;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewManager;", "", "()V", "TAG", "", "cacheControllers", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController;", "contentBuff", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV$NativeBuffer;", "priorityWebView", "", "startredControllers", "createWebView", "Lcom/tencent/mm/ui/widget/MMWebView;", "context", "Landroid/content/Context;", "createWebViewController", "tmplParams", "Lcom/tencent/mm/protocal/protobuf/TmplParams;", "contextWrapper", "Landroid/content/MutableContextWrapper;", "getNativeBuffer", "size", "getWebViewFromCache", "tmplType", "intent", "Landroid/content/Intent;", "onStartCreate", "", "obtainPreloadTmplWebView", "obtainTmplWebView", "pick", "preloadWebViewInner", "", "tryPreloadAllTmplWebview", "tryPreloadTmplWebview", "updateTmplWebview", "MPWebView", "plugin-brandservice_release"})
public final class a
{
  private static final String TAG = "MicroMsg.Preload.TmplWebViewManager";
  private static final ConcurrentHashMap<Integer, MpWebViewController> sRF;
  private static final ConcurrentHashMap<Integer, MpWebViewController> sRG;
  private static boolean sRH;
  private static MultiProcessMMKV.NativeBuffer sRI;
  public static final a sRJ;
  
  static
  {
    AppMethodBeat.i(6940);
    sRJ = new a();
    TAG = "MicroMsg.Preload.TmplWebViewManager";
    sRF = new ConcurrentHashMap();
    sRG = new ConcurrentHashMap();
    sRI = new MultiProcessMMKV.NativeBuffer(0L, 0);
    AppMethodBeat.o(6940);
  }
  
  public static void Hp(int paramInt)
  {
    AppMethodBeat.i(6930);
    j.a locala = j.sMO;
    if (j.a.cCh())
    {
      AppMethodBeat.o(6930);
      return;
    }
    if (sRH)
    {
      AppMethodBeat.o(6930);
      return;
    }
    Log.i(TAG, "tryPreloadTmplWebview:".concat(String.valueOf(paramInt)));
    d.uiThread((kotlin.g.a.a)new c(paramInt));
    AppMethodBeat.o(6930);
  }
  
  private final void Hq(final int paramInt)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(6931);
        Log.i(TAG, "[preloadWebViewInner]tmplParams: ".concat(String.valueOf(paramInt)));
        Object localObject1 = com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.b.Hn(paramInt);
        if (localObject1 == null) {
          break label203;
        }
        if (!sRF.containsKey(Integer.valueOf(paramInt)))
        {
          localObject1 = a((ese)localObject1, new MutableContextWrapper(MMApplicationContext.getContext()));
          if (localObject1 != null)
          {
            ((Map)sRF).put(Integer.valueOf(paramInt), localObject1);
            Object localObject3 = MpWebViewController.sRu;
            int i = MpWebViewController.cDM();
            localObject3 = (kotlin.g.a.a)new b((MpWebViewController)localObject1, paramInt);
            p.k(localObject3, "callback");
            ((BaseWebViewController)localObject1).anu(i).add(localObject3);
            Log.i(TAG, "preload:" + paramInt + ", " + ((MpWebViewController)localObject1).gSo());
            AppMethodBeat.o(6931);
            return;
          }
          AppMethodBeat.o(6931);
          continue;
        }
        Log.i(TAG, "preload skip when exist:".concat(String.valueOf(paramInt)));
      }
      finally {}
      AppMethodBeat.o(6931);
      continue;
      label203:
      AppMethodBeat.o(6931);
    }
  }
  
  public static final MpWebViewController a(Context paramContext, ese paramese)
  {
    try
    {
      AppMethodBeat.i(266402);
      p.k(paramContext, "context");
      p.k(paramese, "tmplParams");
      long l = MMSlotKt.now();
      Log.v(TAG, "[obtainTmplWebView]tmplParams:" + paramese.sNh);
      paramContext = a(paramese, new MutableContextWrapper(paramContext));
      if ((paramContext instanceof MpWebViewController))
      {
        paramese = paramContext.pHS;
        paramese.getPerformanceHelper().bU("onCreateStart", l);
        paramese.getPerformanceHelper().bU("onCreateEnd", MMSlotKt.now());
      }
      AppMethodBeat.o(266402);
      return paramContext;
    }
    finally {}
  }
  
  /* Error */
  public static final MpWebViewController a(Context paramContext, ese paramese, Intent paramIntent)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 279
    //   6: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: ldc 240
    //   12: invokestatic 201	kotlin/g/b/p:k	(Ljava/lang/Object;Ljava/lang/String;)V
    //   15: aload_1
    //   16: ldc 241
    //   18: invokestatic 201	kotlin/g/b/p:k	(Ljava/lang/Object;Ljava/lang/String;)V
    //   21: aload_2
    //   22: ldc_w 280
    //   25: invokestatic 201	kotlin/g/b/p:k	(Ljava/lang/Object;Ljava/lang/String;)V
    //   28: invokestatic 247	com/tencent/mm/sdk/platformtools/MMSlotKt:now	()J
    //   31: lstore_3
    //   32: getstatic 81	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/a:TAG	Ljava/lang/String;
    //   35: new 214	java/lang/StringBuilder
    //   38: dup
    //   39: ldc_w 282
    //   42: invokespecial 219	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   45: aload_1
    //   46: getfield 255	com/tencent/mm/protocal/protobuf/ese:sNh	I
    //   49: invokevirtual 223	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   52: invokevirtual 235	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: invokestatic 258	com/tencent/mm/sdk/platformtools/Log:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   58: getstatic 79	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/a:sRJ	Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/a;
    //   61: aload_1
    //   62: getfield 255	com/tencent/mm/protocal/protobuf/ese:sNh	I
    //   65: aload_2
    //   66: invokespecial 286	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/a:c	(ILandroid/content/Intent;)Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController;
    //   69: astore_1
    //   70: aload_1
    //   71: instanceof 182
    //   74: ifeq +59 -> 133
    //   77: getstatic 81	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/a:TAG	Ljava/lang/String;
    //   80: ldc_w 288
    //   83: invokestatic 258	com/tencent/mm/sdk/platformtools/Log:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   86: aload_1
    //   87: getfield 261	com/tencent/mm/plugin/webview/core/BaseWebViewController:pHS	Lcom/tencent/mm/ui/widget/MMWebView;
    //   90: astore_2
    //   91: aload_2
    //   92: invokevirtual 267	com/tencent/mm/ui/widget/MMWebView:getPerformanceHelper	()Lcom/tencent/mm/pluginsdk/r;
    //   95: ldc_w 269
    //   98: lload_3
    //   99: invokevirtual 275	com/tencent/mm/pluginsdk/r:bU	(Ljava/lang/String;J)V
    //   102: aload_2
    //   103: aload_0
    //   104: invokevirtual 291	com/tencent/mm/ui/widget/MMWebView:aD	(Landroid/content/Context;)V
    //   107: aload_2
    //   108: invokevirtual 267	com/tencent/mm/ui/widget/MMWebView:getPerformanceHelper	()Lcom/tencent/mm/pluginsdk/r;
    //   111: ldc_w 277
    //   114: invokestatic 247	com/tencent/mm/sdk/platformtools/MMSlotKt:now	()J
    //   117: invokevirtual 275	com/tencent/mm/pluginsdk/r:bU	(Ljava/lang/String;J)V
    //   120: ldc_w 279
    //   123: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   126: aload_1
    //   127: astore_0
    //   128: ldc 2
    //   130: monitorexit
    //   131: aload_0
    //   132: areturn
    //   133: aconst_null
    //   134: astore_0
    //   135: ldc_w 279
    //   138: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   141: goto -13 -> 128
    //   144: astore_0
    //   145: ldc 2
    //   147: monitorexit
    //   148: aload_0
    //   149: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	150	0	paramContext	Context
    //   0	150	1	paramese	ese
    //   0	150	2	paramIntent	Intent
    //   31	68	3	l	long
    // Exception table:
    //   from	to	target	type
    //   3	126	144	finally
    //   135	141	144	finally
  }
  
  private static MpWebViewController a(ese paramese, MutableContextWrapper paramMutableContextWrapper)
  {
    AppMethodBeat.i(266398);
    if (paramese.sNh == -1)
    {
      Log.w(TAG, "[preloadWebViewInner] empty tmplType %d", new Object[] { Integer.valueOf(paramese.sNh) });
      AppMethodBeat.o(266398);
      return null;
    }
    if (Util.isNullOrNil(paramese.POG))
    {
      Log.w(TAG, "[preloadWebViewInner] initUrl " + paramese.POG + " is empty");
      AppMethodBeat.o(266398);
      return null;
    }
    if (!u.agG(paramese.UtX))
    {
      Log.w(TAG, "[preloadWebViewInner] filePath %s isn't exist", new Object[] { paramese.UtX });
      AppMethodBeat.o(266398);
      return null;
    }
    paramese = new MpWebViewController(paramese, eV((Context)paramMutableContextWrapper));
    paramese.init();
    AppMethodBeat.o(266398);
    return paramese;
  }
  
  /* Error */
  public static final void af(Intent paramIntent)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: ldc 2
    //   4: monitorenter
    //   5: ldc_w 343
    //   8: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   11: aload_0
    //   12: ldc_w 280
    //   15: invokestatic 201	kotlin/g/b/p:k	(Ljava/lang/Object;Ljava/lang/String;)V
    //   18: aload_0
    //   19: ldc_w 345
    //   22: invokevirtual 350	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   25: astore_3
    //   26: aload_3
    //   27: invokestatic 307	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   30: ifne +41 -> 71
    //   33: getstatic 356	com/tencent/mm/plugin/webview/ui/tools/floatball/d:Qkh	Lcom/tencent/mm/plugin/webview/ui/tools/floatball/d;
    //   36: astore 4
    //   38: aload_3
    //   39: ldc_w 358
    //   42: invokestatic 361	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   45: aload_3
    //   46: invokestatic 365	com/tencent/mm/plugin/webview/ui/tools/floatball/d:bmB	(Ljava/lang/String;)Lcom/tencent/mm/plugin/webview/core/i;
    //   49: ifnull +22 -> 71
    //   52: getstatic 81	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/a:TAG	Ljava/lang/String;
    //   55: ldc_w 367
    //   58: invokestatic 132	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   61: ldc_w 343
    //   64: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   67: ldc 2
    //   69: monitorexit
    //   70: return
    //   71: getstatic 372	com/tencent/mm/ui/f$r:VSE	Ljava/lang/String;
    //   74: astore_3
    //   75: aload_3
    //   76: ldc_w 374
    //   79: invokestatic 361	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   82: aload_0
    //   83: aload_3
    //   84: invokevirtual 378	android/content/Intent:getByteArrayExtra	(Ljava/lang/String;)[B
    //   87: astore_3
    //   88: aload_3
    //   89: ifnull +334 -> 423
    //   92: aload_3
    //   93: arraylength
    //   94: istore_1
    //   95: iload_1
    //   96: ifne +299 -> 395
    //   99: iconst_1
    //   100: istore_1
    //   101: iload_1
    //   102: ifne +298 -> 400
    //   105: iload_2
    //   106: istore_1
    //   107: iload_1
    //   108: ifeq +315 -> 423
    //   111: ldc 251
    //   113: invokevirtual 384	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   116: astore 4
    //   118: aload 4
    //   120: checkcast 386	com/tencent/mm/cd/a
    //   123: aload_3
    //   124: invokevirtual 390	com/tencent/mm/cd/a:parseFrom	([B)Lcom/tencent/mm/cd/a;
    //   127: pop
    //   128: aload 4
    //   130: checkcast 386	com/tencent/mm/cd/a
    //   133: astore_3
    //   134: aload_3
    //   135: checkcast 251	com/tencent/mm/protocal/protobuf/ese
    //   138: astore 4
    //   140: aload 4
    //   142: astore_3
    //   143: aload 4
    //   145: ifnonnull +99 -> 244
    //   148: new 392	android/content/res/Resources$NotFoundException
    //   151: dup
    //   152: ldc_w 394
    //   155: invokespecial 395	android/content/res/Resources$NotFoundException:<init>	(Ljava/lang/String;)V
    //   158: checkcast 397	java/lang/Throwable
    //   161: astore_3
    //   162: ldc_w 343
    //   165: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   168: aload_3
    //   169: athrow
    //   170: astore_3
    //   171: getstatic 81	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/a:TAG	Ljava/lang/String;
    //   174: new 214	java/lang/StringBuilder
    //   177: dup
    //   178: ldc_w 399
    //   181: invokespecial 219	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   184: aload_3
    //   185: invokevirtual 402	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   188: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: bipush 32
    //   193: invokevirtual 405	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   196: aload_0
    //   197: invokestatic 411	com/tencent/mm/plugin/brandservice/ui/timeline/preload/f:ae	(Landroid/content/Intent;)Ljava/lang/String;
    //   200: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: invokevirtual 235	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   206: invokestatic 414	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   209: sipush 152
    //   212: invokestatic 419	com/tencent/mm/plugin/webview/h/a:anX	(I)V
    //   215: getstatic 425	com/tencent/mm/plugin/report/service/h:IzE	Lcom/tencent/mm/plugin/report/service/h;
    //   218: sipush 17260
    //   221: iconst_2
    //   222: anewarray 4	java/lang/Object
    //   225: dup
    //   226: iconst_0
    //   227: iconst_2
    //   228: invokestatic 156	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   231: aastore
    //   232: dup
    //   233: iconst_1
    //   234: aload_0
    //   235: invokestatic 411	com/tencent/mm/plugin/brandservice/ui/timeline/preload/f:ae	(Landroid/content/Intent;)Ljava/lang/String;
    //   238: aastore
    //   239: invokevirtual 428	com/tencent/mm/plugin/report/service/h:a	(I[Ljava/lang/Object;)V
    //   242: aconst_null
    //   243: astore_3
    //   244: aload_3
    //   245: ifnull +243 -> 488
    //   248: aload_3
    //   249: getfield 255	com/tencent/mm/protocal/protobuf/ese:sNh	I
    //   252: istore_1
    //   253: getstatic 86	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/a:sRF	Ljava/util/concurrent/ConcurrentHashMap;
    //   256: iload_1
    //   257: invokestatic 156	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   260: invokevirtual 432	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   263: checkcast 182	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController
    //   266: astore_3
    //   267: aload_3
    //   268: ifnull +195 -> 463
    //   271: aload_3
    //   272: getstatic 435	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:sRk	I
    //   275: invokevirtual 439	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:anw	(I)Z
    //   278: ifeq +150 -> 428
    //   281: getstatic 86	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/a:sRF	Ljava/util/concurrent/ConcurrentHashMap;
    //   284: iload_1
    //   285: invokestatic 156	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   288: invokevirtual 442	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   291: pop
    //   292: aload_3
    //   293: aload_0
    //   294: invokevirtual 445	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:bj	(Landroid/content/Intent;)V
    //   297: getstatic 88	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/a:sRG	Ljava/util/concurrent/ConcurrentHashMap;
    //   300: iload_1
    //   301: invokestatic 156	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   304: invokevirtual 442	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   307: checkcast 182	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController
    //   310: astore_0
    //   311: aload_0
    //   312: ifnull +7 -> 319
    //   315: aload_0
    //   316: invokevirtual 448	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:destroy	()V
    //   319: getstatic 88	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/a:sRG	Ljava/util/concurrent/ConcurrentHashMap;
    //   322: checkcast 176	java/util/Map
    //   325: astore_0
    //   326: aload_3
    //   327: ldc_w 450
    //   330: invokestatic 361	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   333: aload_0
    //   334: iload_1
    //   335: invokestatic 156	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   338: aload_3
    //   339: invokeinterface 180 3 0
    //   344: pop
    //   345: getstatic 81	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/a:TAG	Ljava/lang/String;
    //   348: new 214	java/lang/StringBuilder
    //   351: dup
    //   352: ldc_w 452
    //   355: invokespecial 219	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   358: iload_1
    //   359: invokevirtual 223	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   362: ldc 225
    //   364: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: aload_3
    //   368: invokevirtual 231	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:gSo	()I
    //   371: invokevirtual 223	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   374: invokevirtual 235	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   377: invokestatic 132	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   380: ldc_w 343
    //   383: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   386: goto -319 -> 67
    //   389: astore_0
    //   390: ldc 2
    //   392: monitorexit
    //   393: aload_0
    //   394: athrow
    //   395: iconst_0
    //   396: istore_1
    //   397: goto -296 -> 101
    //   400: iconst_0
    //   401: istore_1
    //   402: goto -295 -> 107
    //   405: astore_3
    //   406: ldc_w 454
    //   409: aload_3
    //   410: checkcast 397	java/lang/Throwable
    //   413: ldc_w 456
    //   416: iconst_0
    //   417: anewarray 4	java/lang/Object
    //   420: invokestatic 460	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   423: aconst_null
    //   424: astore_3
    //   425: goto -291 -> 134
    //   428: getstatic 81	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/a:TAG	Ljava/lang/String;
    //   431: new 214	java/lang/StringBuilder
    //   434: dup
    //   435: ldc_w 462
    //   438: invokespecial 219	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   441: iload_1
    //   442: invokevirtual 223	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   445: ldc 225
    //   447: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   450: aload_3
    //   451: invokevirtual 231	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:gSo	()I
    //   454: invokevirtual 223	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   457: invokevirtual 235	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   460: invokestatic 313	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   463: getstatic 81	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/a:TAG	Ljava/lang/String;
    //   466: ldc_w 464
    //   469: iload_1
    //   470: invokestatic 123	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   473: invokevirtual 127	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   476: invokestatic 313	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   479: ldc_w 343
    //   482: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   485: goto -418 -> 67
    //   488: ldc_w 343
    //   491: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   494: goto -427 -> 67
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	497	0	paramIntent	Intent
    //   94	376	1	i	int
    //   1	105	2	j	int
    //   25	144	3	localObject1	Object
    //   170	15	3	localException1	java.lang.Exception
    //   243	125	3	localMpWebViewController	MpWebViewController
    //   405	5	3	localException2	java.lang.Exception
    //   424	27	3	localObject2	Object
    //   36	108	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   18	67	170	java/lang/Exception
    //   71	88	170	java/lang/Exception
    //   92	95	170	java/lang/Exception
    //   134	140	170	java/lang/Exception
    //   148	170	170	java/lang/Exception
    //   406	423	170	java/lang/Exception
    //   5	18	389	finally
    //   18	67	389	finally
    //   71	88	389	finally
    //   92	95	389	finally
    //   111	134	389	finally
    //   134	140	389	finally
    //   148	170	389	finally
    //   171	242	389	finally
    //   248	267	389	finally
    //   271	311	389	finally
    //   315	319	389	finally
    //   319	386	389	finally
    //   406	423	389	finally
    //   428	463	389	finally
    //   463	485	389	finally
    //   488	494	389	finally
    //   111	134	405	java/lang/Exception
  }
  
  private final MpWebViewController c(int paramInt, Intent paramIntent)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(266397);
        MpWebViewController localMpWebViewController = (MpWebViewController)sRG.get(Integer.valueOf(paramInt));
        if (localMpWebViewController != null)
        {
          p.k(paramIntent, "intent");
          if (localMpWebViewController.PFP)
          {
            paramIntent = paramIntent.getStringExtra("rawUrl");
            p.j(paramIntent, "intent.getStringExtra(Co…antsUI.WebViewUI.KRawUrl)");
            if (p.h(n.bx(paramIntent, "http://", "https://"), localMpWebViewController.cDu()))
            {
              i = 1;
              if (i == 0) {
                continue;
              }
              Log.i(TAG, "pick started:" + paramInt + ", " + localMpWebViewController.gSo());
              sRG.remove(Integer.valueOf(paramInt));
              AppMethodBeat.o(266397);
              paramIntent = localMpWebViewController;
              return paramIntent;
            }
          }
          int i = 0;
          continue;
        }
        paramIntent = (MpWebViewController)sRF.get(Integer.valueOf(paramInt));
        if (paramIntent != null)
        {
          if (paramIntent.anw(MpWebViewController.sRk))
          {
            sRF.remove(Integer.valueOf(paramInt));
            Log.i(TAG, "pick cached:" + paramInt + ", " + paramIntent.gSo());
            AppMethodBeat.o(266397);
            continue;
          }
          Log.w(TAG, "pick null when tmpl not ready:" + paramInt + ", " + paramIntent.gSo());
        }
      }
      finally {}
      Log.w(TAG, "pick null:".concat(String.valueOf(paramInt)));
      paramIntent = null;
      AppMethodBeat.o(266397);
    }
  }
  
  public static final void cDO()
  {
    AppMethodBeat.i(6929);
    Hp(-1);
    AppMethodBeat.o(6929);
  }
  
  private static MMWebView eV(Context paramContext)
  {
    AppMethodBeat.i(266399);
    WebView.c localc = MMWebView.Yct;
    String str;
    if (MMApplicationContext.isMainProcess()) {
      str = "mm";
    }
    for (;;)
    {
      WebView.initWebviewCore(paramContext, localc, str, null);
      paramContext = (MMWebView)new a(paramContext);
      AppMethodBeat.o(266399);
      return paramContext;
      if (MMApplicationContext.isToolsMpProcess()) {
        str = "toolsmp";
      } else {
        str = "tools";
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewManager$MPWebView;", "Lcom/tencent/mm/ui/widget/MMWebView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "currentUrlProxy", "Lkotlin/Function0;", "", "getCurrentUrlProxy", "()Lkotlin/jvm/functions/Function0;", "setCurrentUrlProxy", "(Lkotlin/jvm/functions/Function0;)V", "validUrlProxy", "Lkotlin/Function1;", "", "getValidUrlProxy", "()Lkotlin/jvm/functions/Function1;", "setValidUrlProxy", "(Lkotlin/jvm/functions/Function1;)V", "getUrl", "plugin-brandservice_release"})
  public static final class a
    extends MMWebView
  {
    private kotlin.g.a.a<String> sRK;
    private kotlin.g.a.b<? super String, Boolean> sRL;
    
    public a(Context paramContext)
    {
      super();
      AppMethodBeat.i(265453);
      this.jvb = true;
      this.aabd = getIsX5Kernel();
      AppMethodBeat.o(265453);
    }
    
    public final kotlin.g.a.a<String> getCurrentUrlProxy()
    {
      return this.sRK;
    }
    
    public final String getUrl()
    {
      AppMethodBeat.i(265452);
      Object localObject = super.getUrl();
      if ((this.sRK != null) && (this.sRL != null))
      {
        kotlin.g.a.b localb = this.sRL;
        if (localb == null) {
          p.iCn();
        }
        if (!((Boolean)localb.invoke(localObject)).booleanValue()) {}
      }
      else
      {
        AppMethodBeat.o(265452);
        return localObject;
      }
      localObject = this.sRK;
      if (localObject == null) {
        p.iCn();
      }
      localObject = (String)((kotlin.g.a.a)localObject).invoke();
      AppMethodBeat.o(265452);
      return localObject;
    }
    
    public final kotlin.g.a.b<String, Boolean> getValidUrlProxy()
    {
      return this.sRL;
    }
    
    public final void setCurrentUrlProxy(kotlin.g.a.a<String> parama)
    {
      this.sRK = parama;
    }
    
    public final void setValidUrlProxy(kotlin.g.a.b<? super String, Boolean> paramb)
    {
      this.sRL = paramb;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewManager$preloadWebViewInner$1$1$1", "com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewManager$$special$$inlined$also$lambda$1"})
  static final class b
    extends q
    implements kotlin.g.a.a<x>
  {
    b(MpWebViewController paramMpWebViewController, int paramInt)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<x>
  {
    c(int paramInt)
    {
      super();
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/kt/CommonKt$idle$1", "Landroid/os/MessageQueue$IdleHandler;", "queueIdle", "", "libktcomm_release"})
    public static final class a
      implements MessageQueue.IdleHandler
    {
      public a(a.c paramc) {}
      
      public final boolean queueIdle()
      {
        AppMethodBeat.i(265843);
        Looper.myQueue().removeIdleHandler((MessageQueue.IdleHandler)this);
        if (this.sRP.sRO == -1)
        {
          Object localObject = com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.b.sQG;
          localObject = com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.b.cDm();
          int j = localObject.length;
          int i = 0;
          while (i < j)
          {
            int k = ((Number)localObject[i]).intValue();
            a.a(a.sRJ, k);
            i += 1;
          }
        }
        a.a(a.sRJ, this.sRP.sRO);
        AppMethodBeat.o(265843);
        return false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.a
 * JD-Core Version:    0.7.0.1
 */