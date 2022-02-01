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
import com.tencent.mm.protocal.protobuf.fnn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMSlotKt;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV.NativeBuffer;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.vfs.y;
import com.tencent.xweb.WebView.WebViewKind;
import com.tencent.xweb.ao;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.u;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewManager;", "", "()V", "TAG", "", "cacheControllers", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController;", "contentBuff", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV$NativeBuffer;", "priorityWebView", "", "startredControllers", "createWebView", "Lcom/tencent/mm/ui/widget/MMWebView;", "context", "Landroid/content/Context;", "createWebViewController", "tmplParams", "Lcom/tencent/mm/protocal/protobuf/TmplParams;", "contextWrapper", "Landroid/content/MutableContextWrapper;", "getNativeBuffer", "size", "getWebViewFromCache", "tmplType", "intent", "Landroid/content/Intent;", "onStartCreate", "", "obtainPreloadTmplWebView", "obtainTmplWebView", "pick", "preloadWebViewInner", "", "tryPreloadAllTmplWebview", "tryPreloadTmplWebview", "updateTmplWebview", "MPWebView", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  private static final String TAG;
  public static final a vXb;
  private static final ConcurrentHashMap<Integer, MpWebViewController> vXc;
  private static final ConcurrentHashMap<Integer, MpWebViewController> vXd;
  private static boolean vXe;
  private static MultiProcessMMKV.NativeBuffer vXf;
  
  static
  {
    AppMethodBeat.i(6940);
    vXb = new a();
    TAG = "MicroMsg.Preload.TmplWebViewManager";
    vXc = new ConcurrentHashMap();
    vXd = new ConcurrentHashMap();
    vXf = new MultiProcessMMKV.NativeBuffer(0L, 0);
    AppMethodBeat.o(6940);
  }
  
  public static void HS(int paramInt)
  {
    AppMethodBeat.i(6930);
    j.a locala = j.vSB;
    if (j.a.dft())
    {
      AppMethodBeat.o(6930);
      return;
    }
    if (vXe)
    {
      AppMethodBeat.o(6930);
      return;
    }
    Log.i(TAG, kotlin.g.b.s.X("tryPreloadTmplWebview:", Integer.valueOf(paramInt)));
    d.uiThread((kotlin.g.a.a)new c(paramInt));
    AppMethodBeat.o(6930);
  }
  
  /* Error */
  private final void HT(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: sipush 6931
    //   5: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 84	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/a:TAG	Ljava/lang/String;
    //   11: ldc 150
    //   13: iload_1
    //   14: invokestatic 126	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   17: invokestatic 132	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   20: invokestatic 137	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   23: iload_1
    //   24: invokestatic 156	com/tencent/mm/plugin/brandservice/ui/timeline/preload/c/b:HQ	(I)Lcom/tencent/mm/protocal/protobuf/fnn;
    //   27: astore_3
    //   28: aload_3
    //   29: ifnull +151 -> 180
    //   32: getstatic 89	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/a:vXc	Ljava/util/concurrent/ConcurrentHashMap;
    //   35: iload_1
    //   36: invokestatic 126	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   39: invokevirtual 160	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   42: ifne +123 -> 165
    //   45: aload_3
    //   46: new 162	android/content/MutableContextWrapper
    //   49: dup
    //   50: invokestatic 168	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   53: invokespecial 171	android/content/MutableContextWrapper:<init>	(Landroid/content/Context;)V
    //   56: invokestatic 174	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/a:a	(Lcom/tencent/mm/protocal/protobuf/fnn;Landroid/content/MutableContextWrapper;)Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController;
    //   59: astore_3
    //   60: aload_3
    //   61: ifnull +119 -> 180
    //   64: getstatic 89	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/a:vXc	Ljava/util/concurrent/ConcurrentHashMap;
    //   67: checkcast 176	java/util/Map
    //   70: iload_1
    //   71: invokestatic 126	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   74: aload_3
    //   75: invokeinterface 180 3 0
    //   80: pop
    //   81: getstatic 186	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:vWr	Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$c;
    //   84: astore 4
    //   86: invokestatic 190	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:dhq	()I
    //   89: istore_2
    //   90: new 9	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/a$b
    //   93: dup
    //   94: iload_1
    //   95: aload_3
    //   96: invokespecial 193	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/a$b:<init>	(ILcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController;)V
    //   99: checkcast 141	kotlin/g/a/a
    //   102: astore 4
    //   104: aload 4
    //   106: ldc 195
    //   108: invokestatic 199	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   111: aload_3
    //   112: iload_2
    //   113: invokevirtual 205	com/tencent/mm/plugin/webview/core/BaseWebViewController:atl	(I)Ljava/util/concurrent/ConcurrentLinkedDeque;
    //   116: aload 4
    //   118: invokevirtual 210	java/util/concurrent/ConcurrentLinkedDeque:add	(Ljava/lang/Object;)Z
    //   121: pop
    //   122: getstatic 84	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/a:TAG	Ljava/lang/String;
    //   125: new 212	java/lang/StringBuilder
    //   128: dup
    //   129: ldc 214
    //   131: invokespecial 217	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   134: iload_1
    //   135: invokevirtual 221	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   138: ldc 223
    //   140: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: aload_3
    //   144: invokevirtual 229	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:irL	()I
    //   147: invokevirtual 221	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   150: invokevirtual 233	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   153: invokestatic 137	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   156: sipush 6931
    //   159: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   162: aload_0
    //   163: monitorexit
    //   164: return
    //   165: getstatic 84	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/a:TAG	Ljava/lang/String;
    //   168: ldc 235
    //   170: iload_1
    //   171: invokestatic 126	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   174: invokestatic 132	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   177: invokestatic 137	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   180: sipush 6931
    //   183: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   186: goto -24 -> 162
    //   189: astore_3
    //   190: aload_0
    //   191: monitorexit
    //   192: aload_3
    //   193: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	194	0	this	a
    //   0	194	1	paramInt	int
    //   89	24	2	i	int
    //   27	117	3	localObject1	Object
    //   189	4	3	localObject2	Object
    //   84	33	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   2	28	189	finally
    //   32	60	189	finally
    //   64	162	189	finally
    //   165	180	189	finally
    //   180	186	189	finally
  }
  
  public static final MpWebViewController a(Context paramContext, fnn paramfnn)
  {
    try
    {
      AppMethodBeat.i(303474);
      kotlin.g.b.s.u(paramContext, "context");
      kotlin.g.b.s.u(paramfnn, "tmplParams");
      long l = MMSlotKt.now();
      Log.v(TAG, kotlin.g.b.s.X("[obtainTmplWebView]tmplParams:", Integer.valueOf(paramfnn.vST)));
      paramContext = a(paramfnn, new MutableContextWrapper(paramContext));
      if (paramContext != null)
      {
        paramfnn = paramContext.sMP;
        paramfnn.getPerformanceHelper().cf("onCreateStart", l);
        paramfnn.getPerformanceHelper().cf("onCreateEnd", MMSlotKt.now());
      }
      AppMethodBeat.o(303474);
      return paramContext;
    }
    finally {}
  }
  
  /* Error */
  public static final MpWebViewController a(Context paramContext, fnn paramfnn, Intent paramIntent)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 277
    //   6: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: ldc 238
    //   12: invokestatic 199	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   15: aload_1
    //   16: ldc 239
    //   18: invokestatic 199	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   21: aload_2
    //   22: ldc_w 278
    //   25: invokestatic 199	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   28: invokestatic 245	com/tencent/mm/sdk/platformtools/MMSlotKt:now	()J
    //   31: lstore_3
    //   32: getstatic 84	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/a:TAG	Ljava/lang/String;
    //   35: ldc_w 280
    //   38: aload_1
    //   39: getfield 253	com/tencent/mm/protocal/protobuf/fnn:vST	I
    //   42: invokestatic 126	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   45: invokestatic 132	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   48: invokestatic 256	com/tencent/mm/sdk/platformtools/Log:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   51: getstatic 80	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/a:vXb	Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/a;
    //   54: aload_1
    //   55: getfield 253	com/tencent/mm/protocal/protobuf/fnn:vST	I
    //   58: aload_2
    //   59: invokespecial 284	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/a:e	(ILandroid/content/Intent;)Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController;
    //   62: astore_1
    //   63: aload_1
    //   64: ifnull +59 -> 123
    //   67: getstatic 84	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/a:TAG	Ljava/lang/String;
    //   70: ldc_w 286
    //   73: invokestatic 256	com/tencent/mm/sdk/platformtools/Log:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   76: aload_1
    //   77: getfield 259	com/tencent/mm/plugin/webview/core/BaseWebViewController:sMP	Lcom/tencent/mm/ui/widget/MMWebView;
    //   80: astore_2
    //   81: aload_2
    //   82: invokevirtual 265	com/tencent/mm/ui/widget/MMWebView:getPerformanceHelper	()Lcom/tencent/mm/pluginsdk/s;
    //   85: ldc_w 267
    //   88: lload_3
    //   89: invokevirtual 273	com/tencent/mm/pluginsdk/s:cf	(Ljava/lang/String;J)V
    //   92: aload_2
    //   93: aload_0
    //   94: invokevirtual 289	com/tencent/mm/ui/widget/MMWebView:bm	(Landroid/content/Context;)V
    //   97: aload_2
    //   98: invokevirtual 265	com/tencent/mm/ui/widget/MMWebView:getPerformanceHelper	()Lcom/tencent/mm/pluginsdk/s;
    //   101: ldc_w 275
    //   104: invokestatic 245	com/tencent/mm/sdk/platformtools/MMSlotKt:now	()J
    //   107: invokevirtual 273	com/tencent/mm/pluginsdk/s:cf	(Ljava/lang/String;J)V
    //   110: ldc_w 277
    //   113: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   116: aload_1
    //   117: astore_0
    //   118: ldc 2
    //   120: monitorexit
    //   121: aload_0
    //   122: areturn
    //   123: aconst_null
    //   124: astore_0
    //   125: ldc_w 277
    //   128: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   131: goto -13 -> 118
    //   134: astore_0
    //   135: ldc 2
    //   137: monitorexit
    //   138: aload_0
    //   139: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	140	0	paramContext	Context
    //   0	140	1	paramfnn	fnn
    //   0	140	2	paramIntent	Intent
    //   31	58	3	l	long
    // Exception table:
    //   from	to	target	type
    //   3	63	134	finally
    //   67	116	134	finally
    //   125	131	134	finally
  }
  
  private static MpWebViewController a(fnn paramfnn, MutableContextWrapper paramMutableContextWrapper)
  {
    AppMethodBeat.i(303461);
    if (paramfnn.vST == -1)
    {
      Log.w(TAG, "[preloadWebViewInner] empty tmplType %d", new Object[] { Integer.valueOf(paramfnn.vST) });
      AppMethodBeat.o(303461);
      return null;
    }
    if (Util.isNullOrNil(paramfnn.WET))
    {
      Log.w(TAG, "[preloadWebViewInner] initUrl " + paramfnn.WET + " is empty");
      AppMethodBeat.o(303461);
      return null;
    }
    if (!y.ZC(paramfnn.abNy))
    {
      Log.w(TAG, "[preloadWebViewInner] filePath %s isn't exist", new Object[] { paramfnn.abNy });
      AppMethodBeat.o(303461);
      return null;
    }
    for (;;)
    {
      try
      {
        Context localContext = (Context)paramMutableContextWrapper;
        WebView.WebViewKind localWebViewKind = MMWebView.afUn;
        if (!MMApplicationContext.isMainProcess()) {
          continue;
        }
        paramMutableContextWrapper = "mm";
        ao.initWebviewCore(localContext, localWebViewKind, paramMutableContextWrapper, null);
        paramfnn = new MpWebViewController(paramfnn, (MMWebView)new a(localContext));
        paramfnn.init();
      }
      catch (Exception paramfnn)
      {
        Log.w(TAG, kotlin.g.b.s.X("createWebView ex ", paramfnn.getMessage()));
        paramfnn = null;
        continue;
      }
      AppMethodBeat.o(303461);
      return paramfnn;
      if (MMApplicationContext.isToolsMpProcess()) {
        paramMutableContextWrapper = "toolsmp";
      } else {
        paramMutableContextWrapper = "tools";
      }
    }
  }
  
  /* Error */
  public static final void aj(Intent paramIntent)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: ldc 2
    //   4: monitorenter
    //   5: ldc_w 369
    //   8: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   11: aload_0
    //   12: ldc_w 278
    //   15: invokestatic 199	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   18: aload_0
    //   19: ldc_w 371
    //   22: invokevirtual 377	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   25: astore_3
    //   26: aload_3
    //   27: invokestatic 381	kotlin/g/b/s:checkNotNull	(Ljava/lang/Object;)V
    //   30: aload_3
    //   31: ldc_w 383
    //   34: invokestatic 386	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   37: aload_3
    //   38: invokestatic 307	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   41: ifne +34 -> 75
    //   44: getstatic 392	com/tencent/mm/plugin/webview/ui/tools/floatball/d:XbW	Lcom/tencent/mm/plugin/webview/ui/tools/floatball/d;
    //   47: astore 4
    //   49: aload_3
    //   50: invokestatic 396	com/tencent/mm/plugin/webview/ui/tools/floatball/d:bmc	(Ljava/lang/String;)Lcom/tencent/mm/plugin/webview/core/k;
    //   53: ifnull +22 -> 75
    //   56: getstatic 84	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/a:TAG	Ljava/lang/String;
    //   59: ldc_w 398
    //   62: invokestatic 137	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   65: ldc_w 369
    //   68: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   71: ldc 2
    //   73: monitorexit
    //   74: return
    //   75: getstatic 403	com/tencent/mm/ui/f$s:adwN	Ljava/lang/String;
    //   78: astore_3
    //   79: aload_3
    //   80: ldc_w 405
    //   83: invokestatic 386	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   86: aload_0
    //   87: aload_3
    //   88: invokevirtual 409	android/content/Intent:getByteArrayExtra	(Ljava/lang/String;)[B
    //   91: astore_3
    //   92: aload_3
    //   93: ifnull +322 -> 415
    //   96: aload_3
    //   97: arraylength
    //   98: istore_1
    //   99: iload_1
    //   100: ifne +287 -> 387
    //   103: iconst_1
    //   104: istore_1
    //   105: iload_1
    //   106: ifne +286 -> 392
    //   109: iload_2
    //   110: istore_1
    //   111: iload_1
    //   112: ifeq +303 -> 415
    //   115: ldc 249
    //   117: invokevirtual 415	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   120: astore 4
    //   122: aload 4
    //   124: checkcast 417	com/tencent/mm/bx/a
    //   127: aload_3
    //   128: invokevirtual 421	com/tencent/mm/bx/a:parseFrom	([B)Lcom/tencent/mm/bx/a;
    //   131: pop
    //   132: aload 4
    //   134: checkcast 417	com/tencent/mm/bx/a
    //   137: astore_3
    //   138: aload_3
    //   139: checkcast 249	com/tencent/mm/protocal/protobuf/fnn
    //   142: astore 4
    //   144: aload 4
    //   146: astore_3
    //   147: aload 4
    //   149: ifnonnull +96 -> 245
    //   152: new 423	android/content/res/Resources$NotFoundException
    //   155: dup
    //   156: ldc_w 425
    //   159: invokespecial 426	android/content/res/Resources$NotFoundException:<init>	(Ljava/lang/String;)V
    //   162: astore_3
    //   163: ldc_w 369
    //   166: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   169: aload_3
    //   170: athrow
    //   171: astore_3
    //   172: getstatic 84	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/a:TAG	Ljava/lang/String;
    //   175: new 212	java/lang/StringBuilder
    //   178: dup
    //   179: ldc_w 428
    //   182: invokespecial 217	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   185: aload_3
    //   186: invokevirtual 362	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   189: invokevirtual 312	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   192: bipush 32
    //   194: invokevirtual 431	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   197: aload_0
    //   198: invokestatic 437	com/tencent/mm/plugin/brandservice/ui/timeline/preload/f:ai	(Landroid/content/Intent;)Ljava/lang/String;
    //   201: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: invokevirtual 233	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   207: invokestatic 439	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   210: sipush 152
    //   213: invokestatic 444	com/tencent/mm/plugin/webview/g/a:atP	(I)V
    //   216: getstatic 450	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   219: sipush 17260
    //   222: iconst_2
    //   223: anewarray 4	java/lang/Object
    //   226: dup
    //   227: iconst_0
    //   228: iconst_2
    //   229: invokestatic 126	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   232: aastore
    //   233: dup
    //   234: iconst_1
    //   235: aload_0
    //   236: invokestatic 437	com/tencent/mm/plugin/brandservice/ui/timeline/preload/f:ai	(Landroid/content/Intent;)Ljava/lang/String;
    //   239: aastore
    //   240: invokevirtual 454	com/tencent/mm/plugin/report/service/h:b	(I[Ljava/lang/Object;)V
    //   243: aconst_null
    //   244: astore_3
    //   245: aload_3
    //   246: ifnull +225 -> 471
    //   249: aload_3
    //   250: getfield 253	com/tencent/mm/protocal/protobuf/fnn:vST	I
    //   253: istore_1
    //   254: getstatic 89	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/a:vXc	Ljava/util/concurrent/ConcurrentHashMap;
    //   257: iload_1
    //   258: invokestatic 126	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   261: invokevirtual 458	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   264: checkcast 182	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController
    //   267: astore_3
    //   268: aload_3
    //   269: ifnull +186 -> 455
    //   272: aload_3
    //   273: getstatic 461	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:vWM	I
    //   276: invokevirtual 465	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:atn	(I)Z
    //   279: ifeq +141 -> 420
    //   282: getstatic 89	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/a:vXc	Ljava/util/concurrent/ConcurrentHashMap;
    //   285: iload_1
    //   286: invokestatic 126	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   289: invokevirtual 468	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   292: pop
    //   293: aload_3
    //   294: aload_0
    //   295: invokevirtual 471	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:bJ	(Landroid/content/Intent;)V
    //   298: getstatic 91	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/a:vXd	Ljava/util/concurrent/ConcurrentHashMap;
    //   301: iload_1
    //   302: invokestatic 126	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   305: invokevirtual 468	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   308: checkcast 182	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController
    //   311: astore_0
    //   312: aload_0
    //   313: ifnull +7 -> 320
    //   316: aload_0
    //   317: invokevirtual 474	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:destroy	()V
    //   320: getstatic 91	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/a:vXd	Ljava/util/concurrent/ConcurrentHashMap;
    //   323: checkcast 176	java/util/Map
    //   326: iload_1
    //   327: invokestatic 126	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   330: aload_3
    //   331: invokeinterface 180 3 0
    //   336: pop
    //   337: getstatic 84	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/a:TAG	Ljava/lang/String;
    //   340: new 212	java/lang/StringBuilder
    //   343: dup
    //   344: ldc_w 476
    //   347: invokespecial 217	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   350: iload_1
    //   351: invokevirtual 221	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   354: ldc 223
    //   356: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: aload_3
    //   360: invokevirtual 229	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:irL	()I
    //   363: invokevirtual 221	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   366: invokevirtual 233	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   369: invokestatic 137	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   372: ldc_w 369
    //   375: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   378: goto -307 -> 71
    //   381: astore_0
    //   382: ldc 2
    //   384: monitorexit
    //   385: aload_0
    //   386: athrow
    //   387: iconst_0
    //   388: istore_1
    //   389: goto -284 -> 105
    //   392: iconst_0
    //   393: istore_1
    //   394: goto -283 -> 111
    //   397: astore_3
    //   398: ldc_w 478
    //   401: aload_3
    //   402: checkcast 480	java/lang/Throwable
    //   405: ldc_w 482
    //   408: iconst_0
    //   409: anewarray 4	java/lang/Object
    //   412: invokestatic 486	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   415: aconst_null
    //   416: astore_3
    //   417: goto -279 -> 138
    //   420: getstatic 84	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/a:TAG	Ljava/lang/String;
    //   423: new 212	java/lang/StringBuilder
    //   426: dup
    //   427: ldc_w 488
    //   430: invokespecial 217	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   433: iload_1
    //   434: invokevirtual 221	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   437: ldc 223
    //   439: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   442: aload_3
    //   443: invokevirtual 229	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:irL	()I
    //   446: invokevirtual 221	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   449: invokevirtual 233	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   452: invokestatic 316	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   455: getstatic 84	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/a:TAG	Ljava/lang/String;
    //   458: ldc_w 490
    //   461: iload_1
    //   462: invokestatic 126	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   465: invokestatic 132	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   468: invokestatic 316	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   471: ldc_w 369
    //   474: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   477: goto -406 -> 71
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	480	0	paramIntent	Intent
    //   98	364	1	i	int
    //   1	109	2	j	int
    //   25	145	3	localObject1	Object
    //   171	15	3	localException1	Exception
    //   244	116	3	localMpWebViewController	MpWebViewController
    //   397	5	3	localException2	Exception
    //   416	27	3	localObject2	Object
    //   47	101	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   18	71	171	java/lang/Exception
    //   75	92	171	java/lang/Exception
    //   96	99	171	java/lang/Exception
    //   138	144	171	java/lang/Exception
    //   152	171	171	java/lang/Exception
    //   398	415	171	java/lang/Exception
    //   5	18	381	finally
    //   18	71	381	finally
    //   75	92	381	finally
    //   96	99	381	finally
    //   115	138	381	finally
    //   138	144	381	finally
    //   152	171	381	finally
    //   172	243	381	finally
    //   249	268	381	finally
    //   272	312	381	finally
    //   316	320	381	finally
    //   320	378	381	finally
    //   398	415	381	finally
    //   420	455	381	finally
    //   455	471	381	finally
    //   471	477	381	finally
    //   115	138	397	java/lang/Exception
  }
  
  public static final void dhs()
  {
    AppMethodBeat.i(6929);
    HS(-1);
    AppMethodBeat.o(6929);
  }
  
  private final MpWebViewController e(int paramInt, Intent paramIntent)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(303456);
        MpWebViewController localMpWebViewController = (MpWebViewController)vXd.get(Integer.valueOf(paramInt));
        if (localMpWebViewController != null)
        {
          kotlin.g.b.s.u(paramIntent, "intent");
          if (!localMpWebViewController.WwC) {
            break label299;
          }
          paramIntent = paramIntent.getStringExtra("rawUrl");
          if (paramIntent == null)
          {
            paramIntent = null;
            if (!kotlin.g.b.s.p(paramIntent, localMpWebViewController.dgY())) {
              break label299;
            }
            i = 1;
            if (i != 0)
            {
              Log.i(TAG, "pick started:" + paramInt + ", " + localMpWebViewController.irL());
              vXd.remove(Integer.valueOf(paramInt));
              AppMethodBeat.o(303456);
              paramIntent = localMpWebViewController;
              return paramIntent;
            }
          }
          else
          {
            paramIntent = n.bW(paramIntent, "http://", "https://");
            continue;
          }
        }
        paramIntent = (MpWebViewController)vXc.get(Integer.valueOf(paramInt));
        if (paramIntent != null)
        {
          if (paramIntent.atn(MpWebViewController.vWM))
          {
            vXc.remove(Integer.valueOf(paramInt));
            Log.i(TAG, "pick cached:" + paramInt + ", " + paramIntent.irL());
            AppMethodBeat.o(303456);
            continue;
          }
          Log.w(TAG, "pick null when tmpl not ready:" + paramInt + ", " + paramIntent.irL());
        }
      }
      finally {}
      Log.w(TAG, kotlin.g.b.s.X("pick null:", Integer.valueOf(paramInt)));
      AppMethodBeat.o(303456);
      paramIntent = null;
      continue;
      label299:
      int i = 0;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewManager$MPWebView;", "Lcom/tencent/mm/ui/widget/MMWebView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "currentUrlProxy", "Lkotlin/Function0;", "", "getCurrentUrlProxy", "()Lkotlin/jvm/functions/Function0;", "setCurrentUrlProxy", "(Lkotlin/jvm/functions/Function0;)V", "validUrlProxy", "Lkotlin/Function1;", "", "getValidUrlProxy", "()Lkotlin/jvm/functions/Function1;", "setValidUrlProxy", "(Lkotlin/jvm/functions/Function1;)V", "getUrl", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends MMWebView
  {
    private kotlin.g.a.a<String> vXg;
    private kotlin.g.a.b<? super String, Boolean> vXh;
    
    public a(Context paramContext)
    {
      super();
      AppMethodBeat.i(303313);
      this.lYs = true;
      this.aifv = getIsX5Kernel();
      AppMethodBeat.o(303313);
    }
    
    public final kotlin.g.a.a<String> getCurrentUrlProxy()
    {
      return this.vXg;
    }
    
    public final String getUrl()
    {
      AppMethodBeat.i(303333);
      Object localObject = super.getUrl();
      if ((this.vXg != null) && (this.vXh != null))
      {
        kotlin.g.a.b localb = this.vXh;
        kotlin.g.b.s.checkNotNull(localb);
        if (!((Boolean)localb.invoke(localObject)).booleanValue()) {}
      }
      else
      {
        AppMethodBeat.o(303333);
        return localObject;
      }
      localObject = this.vXg;
      kotlin.g.b.s.checkNotNull(localObject);
      localObject = (String)((kotlin.g.a.a)localObject).invoke();
      AppMethodBeat.o(303333);
      return localObject;
    }
    
    public final kotlin.g.a.b<String, Boolean> getValidUrlProxy()
    {
      return this.vXh;
    }
    
    public final void setCurrentUrlProxy(kotlin.g.a.a<String> parama)
    {
      this.vXg = parama;
    }
    
    public final void setValidUrlProxy(kotlin.g.a.b<? super String, Boolean> paramb)
    {
      this.vXh = paramb;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(int paramInt, MpWebViewController paramMpWebViewController)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    c(int paramInt)
    {
      super();
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/kt/CommonKt$idle$1", "Landroid/os/MessageQueue$IdleHandler;", "queueIdle", "", "libktcomm_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements MessageQueue.IdleHandler
    {
      public a(int paramInt) {}
      
      public final boolean queueIdle()
      {
        AppMethodBeat.i(303302);
        Looper.myQueue().removeIdleHandler((MessageQueue.IdleHandler)this);
        if (this.vXk == -1)
        {
          Object localObject = com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.b.vVO;
          localObject = com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.b.dgL();
          int j = localObject.length;
          int i = 0;
          while (i < j)
          {
            int k = ((Number)localObject[i]).intValue();
            if (k != 6) {
              a.a(a.vXb, k);
            }
            i += 1;
          }
        }
        a.a(a.vXb, this.vXk);
        AppMethodBeat.o(303302);
        return false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.a
 * JD-Core Version:    0.7.0.1
 */