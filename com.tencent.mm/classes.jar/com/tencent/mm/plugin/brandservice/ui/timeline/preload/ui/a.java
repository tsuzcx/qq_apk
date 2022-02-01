package com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui;

import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.j;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.j.a;
import com.tencent.mm.plugin.webview.core.BaseWebViewController;
import com.tencent.mm.protocal.protobuf.eic;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV.NativeBuffer;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.vfs.s;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.c;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewManager;", "", "()V", "TAG", "", "cacheControllers", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController;", "contentBuff", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV$NativeBuffer;", "priorityWebView", "", "startredControllers", "createWebView", "Lcom/tencent/mm/ui/widget/MMWebView;", "context", "Landroid/content/Context;", "createWebViewController", "tmplParams", "Lcom/tencent/mm/protocal/protobuf/TmplParams;", "contextWrapper", "Landroid/content/MutableContextWrapper;", "getNativeBuffer", "size", "getWebViewFromCache", "tmplType", "intent", "Landroid/content/Intent;", "onStartCreate", "", "obtainPreloadTmplWebView", "obtainTmplWebView", "pick", "preloadWebViewInner", "", "tryPreloadAllTmplWebview", "tryPreloadTmplWebview", "updateTmplWebview", "clear", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebView;", "MPWebView", "plugin-brandservice_release"})
public final class a
{
  private static final String TAG = "MicroMsg.Preload.TmplWebViewManager";
  private static final ConcurrentHashMap<Integer, MpWebViewController> pGM;
  private static final ConcurrentHashMap<Integer, MpWebViewController> pGN;
  private static boolean pGO;
  private static MultiProcessMMKV.NativeBuffer pGP;
  public static final a pGQ;
  
  static
  {
    AppMethodBeat.i(6940);
    pGQ = new a();
    TAG = "MicroMsg.Preload.TmplWebViewManager";
    pGM = new ConcurrentHashMap();
    pGN = new ConcurrentHashMap();
    pGP = new MultiProcessMMKV.NativeBuffer(0L, 0);
    AppMethodBeat.o(6940);
  }
  
  public static void DH(int paramInt)
  {
    AppMethodBeat.i(6930);
    j.a locala = j.pCC;
    if (j.a.cob())
    {
      AppMethodBeat.o(6930);
      return;
    }
    if (pGO)
    {
      AppMethodBeat.o(6930);
      return;
    }
    Log.i(TAG, "tryPreloadTmplWebview:".concat(String.valueOf(paramInt)));
    d.h((kotlin.g.a.a)new c(paramInt));
    AppMethodBeat.o(6930);
  }
  
  private final void DI(final int paramInt)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(6931);
        Log.i(TAG, "[preloadWebViewInner]tmplParams: ".concat(String.valueOf(paramInt)));
        Object localObject1 = com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b.DE(paramInt);
        if (localObject1 == null) {
          break label203;
        }
        if (!pGM.containsKey(Integer.valueOf(paramInt)))
        {
          localObject1 = a((eic)localObject1, new MutableContextWrapper(MMApplicationContext.getContext()));
          if (localObject1 != null)
          {
            ((Map)pGM).put(Integer.valueOf(paramInt), localObject1);
            Object localObject3 = MpWebViewController.pGg;
            int i = MpWebViewController.cpq();
            localObject3 = (kotlin.g.a.a)new b((MpWebViewController)localObject1, paramInt);
            p.h(localObject3, "callback");
            ((BaseWebViewController)localObject1).afG(i).add(localObject3);
            Log.i(TAG, "preload:" + paramInt + ", " + ((MpWebViewController)localObject1).fZu());
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
  
  /* Error */
  public static final MpWebViewController a(Context paramContext, eic parameic)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 240
    //   5: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: ldc 241
    //   11: invokestatic 202	kotlin/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   14: aload_1
    //   15: ldc 242
    //   17: invokestatic 202	kotlin/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   20: invokestatic 248	com/tencent/mm/sdk/platformtools/MMSlotKt:now	()J
    //   23: lstore_2
    //   24: getstatic 83	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/a:TAG	Ljava/lang/String;
    //   27: new 215	java/lang/StringBuilder
    //   30: dup
    //   31: ldc 250
    //   33: invokespecial 220	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   36: aload_1
    //   37: getfield 256	com/tencent/mm/protocal/protobuf/eic:pCV	I
    //   40: invokevirtual 224	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   43: invokevirtual 236	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: invokestatic 259	com/tencent/mm/sdk/platformtools/Log:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   49: aload_1
    //   50: new 164	android/content/MutableContextWrapper
    //   53: dup
    //   54: aload_0
    //   55: invokespecial 173	android/content/MutableContextWrapper:<init>	(Landroid/content/Context;)V
    //   58: invokestatic 176	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/a:a	(Lcom/tencent/mm/protocal/protobuf/eic;Landroid/content/MutableContextWrapper;)Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController;
    //   61: astore_0
    //   62: aload_0
    //   63: ifnull +43 -> 106
    //   66: aload_0
    //   67: getfield 262	com/tencent/mm/plugin/webview/core/BaseWebViewController:pGj	Lcom/tencent/mm/ui/widget/MMWebView;
    //   70: invokevirtual 268	com/tencent/mm/ui/widget/MMWebView:getPerformanceHelper	()Lcom/tencent/mm/pluginsdk/r;
    //   73: ldc_w 270
    //   76: lload_2
    //   77: invokevirtual 276	com/tencent/mm/pluginsdk/r:bN	(Ljava/lang/String;J)V
    //   80: aload_0
    //   81: getfield 262	com/tencent/mm/plugin/webview/core/BaseWebViewController:pGj	Lcom/tencent/mm/ui/widget/MMWebView;
    //   84: invokevirtual 268	com/tencent/mm/ui/widget/MMWebView:getPerformanceHelper	()Lcom/tencent/mm/pluginsdk/r;
    //   87: ldc_w 278
    //   90: invokestatic 248	com/tencent/mm/sdk/platformtools/MMSlotKt:now	()J
    //   93: invokevirtual 276	com/tencent/mm/pluginsdk/r:bN	(Ljava/lang/String;J)V
    //   96: ldc 240
    //   98: invokestatic 100	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   101: ldc 2
    //   103: monitorexit
    //   104: aload_0
    //   105: areturn
    //   106: aconst_null
    //   107: astore_0
    //   108: ldc 240
    //   110: invokestatic 100	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   113: goto -12 -> 101
    //   116: astore_0
    //   117: ldc 2
    //   119: monitorexit
    //   120: aload_0
    //   121: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	122	0	paramContext	Context
    //   0	122	1	parameic	eic
    //   23	54	2	l	long
    // Exception table:
    //   from	to	target	type
    //   3	62	116	finally
    //   66	101	116	finally
    //   108	113	116	finally
  }
  
  /* Error */
  public static final MpWebViewController a(Context paramContext, eic parameic, Intent paramIntent)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 280
    //   6: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: ldc 241
    //   12: invokestatic 202	kotlin/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   15: aload_1
    //   16: ldc 242
    //   18: invokestatic 202	kotlin/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   21: aload_2
    //   22: ldc_w 281
    //   25: invokestatic 202	kotlin/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   28: invokestatic 248	com/tencent/mm/sdk/platformtools/MMSlotKt:now	()J
    //   31: lstore_3
    //   32: getstatic 83	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/a:TAG	Ljava/lang/String;
    //   35: new 215	java/lang/StringBuilder
    //   38: dup
    //   39: ldc_w 283
    //   42: invokespecial 220	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   45: aload_1
    //   46: getfield 256	com/tencent/mm/protocal/protobuf/eic:pCV	I
    //   49: invokevirtual 224	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   52: invokevirtual 236	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: invokestatic 259	com/tencent/mm/sdk/platformtools/Log:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   58: getstatic 81	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/a:pGQ	Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/a;
    //   61: aload_1
    //   62: getfield 256	com/tencent/mm/protocal/protobuf/eic:pCV	I
    //   65: aload_2
    //   66: invokespecial 287	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/a:c	(ILandroid/content/Intent;)Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController;
    //   69: astore_1
    //   70: aload_1
    //   71: ifnull +59 -> 130
    //   74: getstatic 83	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/a:TAG	Ljava/lang/String;
    //   77: ldc_w 289
    //   80: invokestatic 259	com/tencent/mm/sdk/platformtools/Log:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   83: aload_1
    //   84: getfield 262	com/tencent/mm/plugin/webview/core/BaseWebViewController:pGj	Lcom/tencent/mm/ui/widget/MMWebView;
    //   87: astore_2
    //   88: aload_2
    //   89: invokevirtual 268	com/tencent/mm/ui/widget/MMWebView:getPerformanceHelper	()Lcom/tencent/mm/pluginsdk/r;
    //   92: ldc_w 270
    //   95: lload_3
    //   96: invokevirtual 276	com/tencent/mm/pluginsdk/r:bN	(Ljava/lang/String;J)V
    //   99: aload_2
    //   100: aload_0
    //   101: invokevirtual 292	com/tencent/mm/ui/widget/MMWebView:aG	(Landroid/content/Context;)V
    //   104: aload_2
    //   105: invokevirtual 268	com/tencent/mm/ui/widget/MMWebView:getPerformanceHelper	()Lcom/tencent/mm/pluginsdk/r;
    //   108: ldc_w 278
    //   111: invokestatic 248	com/tencent/mm/sdk/platformtools/MMSlotKt:now	()J
    //   114: invokevirtual 276	com/tencent/mm/pluginsdk/r:bN	(Ljava/lang/String;J)V
    //   117: ldc_w 280
    //   120: invokestatic 100	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   123: aload_1
    //   124: astore_0
    //   125: ldc 2
    //   127: monitorexit
    //   128: aload_0
    //   129: areturn
    //   130: aconst_null
    //   131: astore_0
    //   132: ldc_w 280
    //   135: invokestatic 100	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   138: goto -13 -> 125
    //   141: astore_0
    //   142: ldc 2
    //   144: monitorexit
    //   145: aload_0
    //   146: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	147	0	paramContext	Context
    //   0	147	1	parameic	eic
    //   0	147	2	paramIntent	Intent
    //   31	65	3	l	long
    // Exception table:
    //   from	to	target	type
    //   3	70	141	finally
    //   74	123	141	finally
    //   132	138	141	finally
  }
  
  private static MpWebViewController a(eic parameic, MutableContextWrapper paramMutableContextWrapper)
  {
    AppMethodBeat.i(195875);
    if (parameic.pCV == -1)
    {
      Log.w(TAG, "[preloadWebViewInner] empty tmplType %d", new Object[] { Integer.valueOf(parameic.pCV) });
      AppMethodBeat.o(195875);
      return null;
    }
    if (Util.isNullOrNil(parameic.ISo))
    {
      Log.w(TAG, "[preloadWebViewInner] initUrl " + parameic.ISo + " is empty");
      AppMethodBeat.o(195875);
      return null;
    }
    if (!s.YS(parameic.Nhr))
    {
      Log.w(TAG, "[preloadWebViewInner] filePath %s isn't exist", new Object[] { parameic.Nhr });
      AppMethodBeat.o(195875);
      return null;
    }
    parameic = new MpWebViewController(parameic, eR((Context)paramMutableContextWrapper));
    parameic.init();
    AppMethodBeat.o(195875);
    return parameic;
  }
  
  /* Error */
  public static final void ai(Intent paramIntent)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: ldc 2
    //   4: monitorenter
    //   5: ldc_w 344
    //   8: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   11: aload_0
    //   12: ldc_w 281
    //   15: invokestatic 202	kotlin/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   18: aload_0
    //   19: ldc_w 346
    //   22: invokevirtual 351	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   25: astore_3
    //   26: aload_3
    //   27: invokestatic 308	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   30: ifne +41 -> 71
    //   33: getstatic 357	com/tencent/mm/plugin/webview/ui/tools/floatball/d:JmQ	Lcom/tencent/mm/plugin/webview/ui/tools/floatball/d;
    //   36: astore 4
    //   38: aload_3
    //   39: ldc_w 359
    //   42: invokestatic 362	kotlin/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   45: aload_3
    //   46: invokestatic 366	com/tencent/mm/plugin/webview/ui/tools/floatball/d:baD	(Ljava/lang/String;)Lcom/tencent/mm/plugin/webview/core/i;
    //   49: ifnull +22 -> 71
    //   52: getstatic 83	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/a:TAG	Ljava/lang/String;
    //   55: ldc_w 368
    //   58: invokestatic 134	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   61: ldc_w 344
    //   64: invokestatic 100	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   67: ldc 2
    //   69: monitorexit
    //   70: return
    //   71: getstatic 373	com/tencent/mm/ui/e$p:Ozq	Ljava/lang/String;
    //   74: astore_3
    //   75: aload_3
    //   76: ldc_w 375
    //   79: invokestatic 362	kotlin/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   82: aload_0
    //   83: aload_3
    //   84: invokevirtual 379	android/content/Intent:getByteArrayExtra	(Ljava/lang/String;)[B
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
    //   111: ldc 252
    //   113: invokevirtual 385	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   116: astore 4
    //   118: aload 4
    //   120: checkcast 387	com/tencent/mm/bw/a
    //   123: aload_3
    //   124: invokevirtual 391	com/tencent/mm/bw/a:parseFrom	([B)Lcom/tencent/mm/bw/a;
    //   127: pop
    //   128: aload 4
    //   130: checkcast 387	com/tencent/mm/bw/a
    //   133: astore_3
    //   134: aload_3
    //   135: checkcast 252	com/tencent/mm/protocal/protobuf/eic
    //   138: astore 4
    //   140: aload 4
    //   142: astore_3
    //   143: aload 4
    //   145: ifnonnull +99 -> 244
    //   148: new 393	android/content/res/Resources$NotFoundException
    //   151: dup
    //   152: ldc_w 395
    //   155: invokespecial 396	android/content/res/Resources$NotFoundException:<init>	(Ljava/lang/String;)V
    //   158: checkcast 398	java/lang/Throwable
    //   161: astore_3
    //   162: ldc_w 344
    //   165: invokestatic 100	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   168: aload_3
    //   169: athrow
    //   170: astore_3
    //   171: getstatic 83	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/a:TAG	Ljava/lang/String;
    //   174: new 215	java/lang/StringBuilder
    //   177: dup
    //   178: ldc_w 400
    //   181: invokespecial 220	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   184: aload_3
    //   185: invokevirtual 403	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   188: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: bipush 32
    //   193: invokevirtual 406	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   196: aload_0
    //   197: invokestatic 412	com/tencent/mm/plugin/brandservice/ui/timeline/preload/f:ag	(Landroid/content/Intent;)Ljava/lang/String;
    //   200: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: invokevirtual 236	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   206: invokestatic 415	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   209: sipush 152
    //   212: invokestatic 420	com/tencent/mm/plugin/webview/h/a:agi	(I)V
    //   215: getstatic 426	com/tencent/mm/plugin/report/service/h:CyF	Lcom/tencent/mm/plugin/report/service/h;
    //   218: sipush 17260
    //   221: iconst_2
    //   222: anewarray 4	java/lang/Object
    //   225: dup
    //   226: iconst_0
    //   227: iconst_2
    //   228: invokestatic 158	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   231: aastore
    //   232: dup
    //   233: iconst_1
    //   234: aload_0
    //   235: invokestatic 412	com/tencent/mm/plugin/brandservice/ui/timeline/preload/f:ag	(Landroid/content/Intent;)Ljava/lang/String;
    //   238: aastore
    //   239: invokevirtual 429	com/tencent/mm/plugin/report/service/h:a	(I[Ljava/lang/Object;)V
    //   242: aconst_null
    //   243: astore_3
    //   244: aload_3
    //   245: ifnull +243 -> 488
    //   248: aload_3
    //   249: getfield 256	com/tencent/mm/protocal/protobuf/eic:pCV	I
    //   252: istore_1
    //   253: getstatic 88	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/a:pGM	Ljava/util/concurrent/ConcurrentHashMap;
    //   256: iload_1
    //   257: invokestatic 158	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   260: invokevirtual 433	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   263: checkcast 184	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController
    //   266: astore_3
    //   267: aload_3
    //   268: ifnull +195 -> 463
    //   271: aload_3
    //   272: getstatic 436	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:pFW	I
    //   275: invokevirtual 440	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:afI	(I)Z
    //   278: ifeq +150 -> 428
    //   281: getstatic 88	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/a:pGM	Ljava/util/concurrent/ConcurrentHashMap;
    //   284: iload_1
    //   285: invokestatic 158	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   288: invokevirtual 443	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   291: pop
    //   292: aload_3
    //   293: aload_0
    //   294: invokevirtual 446	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:aB	(Landroid/content/Intent;)V
    //   297: getstatic 90	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/a:pGN	Ljava/util/concurrent/ConcurrentHashMap;
    //   300: iload_1
    //   301: invokestatic 158	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   304: invokevirtual 443	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   307: checkcast 184	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController
    //   310: astore_0
    //   311: aload_0
    //   312: ifnull +7 -> 319
    //   315: aload_0
    //   316: invokevirtual 449	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:destroy	()V
    //   319: getstatic 90	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/a:pGN	Ljava/util/concurrent/ConcurrentHashMap;
    //   322: checkcast 178	java/util/Map
    //   325: astore_0
    //   326: aload_3
    //   327: ldc_w 451
    //   330: invokestatic 362	kotlin/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   333: aload_0
    //   334: iload_1
    //   335: invokestatic 158	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   338: aload_3
    //   339: invokeinterface 182 3 0
    //   344: pop
    //   345: getstatic 83	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/a:TAG	Ljava/lang/String;
    //   348: new 215	java/lang/StringBuilder
    //   351: dup
    //   352: ldc_w 453
    //   355: invokespecial 220	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   358: iload_1
    //   359: invokevirtual 224	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   362: ldc 226
    //   364: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: aload_3
    //   368: invokevirtual 232	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:fZu	()I
    //   371: invokevirtual 224	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   374: invokevirtual 236	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   377: invokestatic 134	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   380: ldc_w 344
    //   383: invokestatic 100	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   406: ldc_w 455
    //   409: aload_3
    //   410: checkcast 398	java/lang/Throwable
    //   413: ldc_w 457
    //   416: iconst_0
    //   417: anewarray 4	java/lang/Object
    //   420: invokestatic 461	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   423: aconst_null
    //   424: astore_3
    //   425: goto -291 -> 134
    //   428: getstatic 83	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/a:TAG	Ljava/lang/String;
    //   431: new 215	java/lang/StringBuilder
    //   434: dup
    //   435: ldc_w 463
    //   438: invokespecial 220	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   441: iload_1
    //   442: invokevirtual 224	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   445: ldc 226
    //   447: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   450: aload_3
    //   451: invokevirtual 232	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:fZu	()I
    //   454: invokevirtual 224	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   457: invokevirtual 236	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   460: invokestatic 314	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   463: getstatic 83	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/a:TAG	Ljava/lang/String;
    //   466: ldc_w 465
    //   469: iload_1
    //   470: invokestatic 125	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   473: invokevirtual 129	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   476: invokestatic 314	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   479: ldc_w 344
    //   482: invokestatic 100	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   485: goto -418 -> 67
    //   488: ldc_w 344
    //   491: invokestatic 100	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
        AppMethodBeat.i(195874);
        MpWebViewController localMpWebViewController = (MpWebViewController)pGN.get(Integer.valueOf(paramInt));
        if ((localMpWebViewController != null) && (localMpWebViewController.ah(paramIntent)))
        {
          Log.i(TAG, "pick started:" + paramInt + ", " + localMpWebViewController.fZu());
          pGN.remove(Integer.valueOf(paramInt));
          AppMethodBeat.o(195874);
          paramIntent = localMpWebViewController;
          return paramIntent;
        }
        paramIntent = (MpWebViewController)pGM.get(Integer.valueOf(paramInt));
        if (paramIntent != null)
        {
          if (paramIntent.afI(MpWebViewController.pFW))
          {
            pGM.remove(Integer.valueOf(paramInt));
            Log.i(TAG, "pick cached:" + paramInt + ", " + paramIntent.fZu());
            AppMethodBeat.o(195874);
            continue;
          }
          Log.w(TAG, "pick null when tmpl not ready:" + paramInt + ", " + paramIntent.fZu());
        }
      }
      finally {}
      Log.w(TAG, "pick null:".concat(String.valueOf(paramInt)));
      paramIntent = null;
      AppMethodBeat.o(195874);
    }
  }
  
  public static final void cpJ()
  {
    AppMethodBeat.i(6929);
    DH(-1);
    AppMethodBeat.o(6929);
  }
  
  private static MMWebView eR(Context paramContext)
  {
    AppMethodBeat.i(195876);
    WebView.c localc = MMWebView.QDR;
    String str;
    if (MMApplicationContext.isMainProcess()) {
      str = "mm";
    }
    for (;;)
    {
      WebView.initWebviewCore(paramContext, localc, str, null);
      paramContext = (MMWebView)new a(paramContext);
      AppMethodBeat.o(195876);
      return paramContext;
      if (MMApplicationContext.isToolsMpProcess()) {
        str = "toolsmp";
      } else {
        str = "tools";
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewManager$MPWebView;", "Lcom/tencent/mm/ui/widget/MMWebView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "currentUrlProxy", "Lkotlin/Function0;", "", "getCurrentUrlProxy", "()Lkotlin/jvm/functions/Function0;", "setCurrentUrlProxy", "(Lkotlin/jvm/functions/Function0;)V", "validUrlProxy", "Lkotlin/Function1;", "", "getValidUrlProxy", "()Lkotlin/jvm/functions/Function1;", "setValidUrlProxy", "(Lkotlin/jvm/functions/Function1;)V", "getUrl", "plugin-brandservice_release"})
  public static final class a
    extends MMWebView
  {
    private kotlin.g.a.a<String> pGR;
    private kotlin.g.a.b<? super String, Boolean> pGS;
    
    public a(Context paramContext)
    {
      super();
      AppMethodBeat.i(195869);
      this.gKM = true;
      this.isX5Kernel = getIsX5Kernel();
      AppMethodBeat.o(195869);
    }
    
    public final kotlin.g.a.a<String> getCurrentUrlProxy()
    {
      return this.pGR;
    }
    
    public final String getUrl()
    {
      AppMethodBeat.i(195868);
      Object localObject = super.getUrl();
      if ((this.pGR != null) && (this.pGS != null))
      {
        kotlin.g.a.b localb = this.pGS;
        if (localb == null) {
          p.hyc();
        }
        if (!((Boolean)localb.invoke(localObject)).booleanValue()) {}
      }
      else
      {
        AppMethodBeat.o(195868);
        return localObject;
      }
      localObject = this.pGR;
      if (localObject == null) {
        p.hyc();
      }
      localObject = (String)((kotlin.g.a.a)localObject).invoke();
      AppMethodBeat.o(195868);
      return localObject;
    }
    
    public final kotlin.g.a.b<String, Boolean> getValidUrlProxy()
    {
      return this.pGS;
    }
    
    public final void setCurrentUrlProxy(kotlin.g.a.a<String> parama)
    {
      this.pGR = parama;
    }
    
    public final void setValidUrlProxy(kotlin.g.a.b<? super String, Boolean> paramb)
    {
      this.pGS = paramb;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewManager$preloadWebViewInner$1$1$1", "com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewManager$$special$$inlined$also$lambda$1"})
  static final class b
    extends q
    implements kotlin.g.a.a<x>
  {
    b(MpWebViewController paramMpWebViewController, int paramInt)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<x>
  {
    c(int paramInt)
    {
      super();
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/kt/CommonKt$idle$1", "Landroid/os/MessageQueue$IdleHandler;", "queueIdle", "", "libktcomm_release"})
    public static final class a
      implements MessageQueue.IdleHandler
    {
      public a(a.c paramc) {}
      
      public final boolean queueIdle()
      {
        AppMethodBeat.i(195871);
        Looper.myQueue().removeIdleHandler((MessageQueue.IdleHandler)this);
        if (this.pGW.pGV == -1)
        {
          Object localObject = com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b.pFr;
          localObject = com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b.coQ();
          int j = localObject.length;
          int i = 0;
          while (i < j)
          {
            int k = ((Number)localObject[i]).intValue();
            a.a(a.pGQ, k);
            i += 1;
          }
        }
        a.a(a.pGQ, this.pGW.pGV);
        AppMethodBeat.o(195871);
        return false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.a
 * JD-Core Version:    0.7.0.1
 */