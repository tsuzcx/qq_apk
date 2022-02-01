package com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui;

import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.c;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.h;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.h.a;
import com.tencent.mm.plugin.webview.core.BaseWebViewController;
import com.tencent.mm.protocal.protobuf.dnj;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ax.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.vfs.i;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.c;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.n.n;
import d.z;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewManager;", "", "()V", "TAG", "", "cacheControllers", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController;", "contentBuff", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV$NativeBuffer;", "priorityWebView", "", "startredControllers", "createWebView", "Lcom/tencent/mm/ui/widget/MMWebView;", "context", "Landroid/content/Context;", "createWebViewController", "tmplParams", "Lcom/tencent/mm/protocal/protobuf/TmplParams;", "contextWrapper", "Landroid/content/MutableContextWrapper;", "getNativeBuffer", "size", "getWebViewFromCache", "tmplType", "intent", "Landroid/content/Intent;", "onStartCreate", "", "obtainPreloadTmplWebView", "obtainTmplWebView", "pick", "preloadWebViewInner", "", "tryPreloadAllTmplWebview", "tryPreloadTmplWebview", "updateTmplWebview", "clear", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebView;", "MPWebView", "plugin-brandservice_release"})
public final class a
{
  private static final String TAG = "MicroMsg.Preload.TmplWebViewManager";
  private static final ConcurrentHashMap<Integer, MpWebViewController> onA;
  private static boolean onB;
  private static ax.a onC;
  public static final a onD;
  private static final ConcurrentHashMap<Integer, MpWebViewController> onz;
  
  static
  {
    AppMethodBeat.i(6940);
    onD = new a();
    TAG = "MicroMsg.Preload.TmplWebViewManager";
    onz = new ConcurrentHashMap();
    onA = new ConcurrentHashMap();
    onC = new ax.a();
    AppMethodBeat.o(6940);
  }
  
  /* Error */
  public static final MpWebViewController a(Context paramContext, dnj paramdnj)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 103
    //   5: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: ldc 104
    //   11: invokestatic 110	d/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   14: aload_1
    //   15: ldc 111
    //   17: invokestatic 110	d/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   20: invokestatic 117	java/lang/System:currentTimeMillis	()J
    //   23: lstore_2
    //   24: getstatic 84	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/a:TAG	Ljava/lang/String;
    //   27: new 119	java/lang/StringBuilder
    //   30: dup
    //   31: ldc 121
    //   33: invokespecial 124	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   36: aload_1
    //   37: getfield 130	com/tencent/mm/protocal/protobuf/dnj:ojt	I
    //   40: invokevirtual 134	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   43: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: invokestatic 144	com/tencent/mm/sdk/platformtools/ad:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   49: aload_1
    //   50: new 146	android/content/MutableContextWrapper
    //   53: dup
    //   54: aload_0
    //   55: invokespecial 149	android/content/MutableContextWrapper:<init>	(Landroid/content/Context;)V
    //   58: invokestatic 152	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/a:a	(Lcom/tencent/mm/protocal/protobuf/dnj;Landroid/content/MutableContextWrapper;)Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController;
    //   61: astore_0
    //   62: aload_0
    //   63: ifnull +41 -> 104
    //   66: aload_0
    //   67: getfield 157	com/tencent/mm/plugin/webview/core/BaseWebViewController:omW	Lcom/tencent/mm/ui/widget/MMWebView;
    //   70: invokevirtual 163	com/tencent/mm/ui/widget/MMWebView:getPerformanceHelper	()Lcom/tencent/mm/pluginsdk/r;
    //   73: ldc 165
    //   75: lload_2
    //   76: invokevirtual 171	com/tencent/mm/pluginsdk/r:bL	(Ljava/lang/String;J)V
    //   79: aload_0
    //   80: getfield 157	com/tencent/mm/plugin/webview/core/BaseWebViewController:omW	Lcom/tencent/mm/ui/widget/MMWebView;
    //   83: invokevirtual 163	com/tencent/mm/ui/widget/MMWebView:getPerformanceHelper	()Lcom/tencent/mm/pluginsdk/r;
    //   86: ldc 173
    //   88: invokestatic 117	java/lang/System:currentTimeMillis	()J
    //   91: invokevirtual 171	com/tencent/mm/pluginsdk/r:bL	(Ljava/lang/String;J)V
    //   94: ldc 103
    //   96: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   99: ldc 2
    //   101: monitorexit
    //   102: aload_0
    //   103: areturn
    //   104: aconst_null
    //   105: astore_0
    //   106: ldc 103
    //   108: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   111: goto -12 -> 99
    //   114: astore_0
    //   115: ldc 2
    //   117: monitorexit
    //   118: aload_0
    //   119: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	120	0	paramContext	Context
    //   0	120	1	paramdnj	dnj
    //   23	53	2	l	long
    // Exception table:
    //   from	to	target	type
    //   3	62	114	finally
    //   66	99	114	finally
    //   106	111	114	finally
  }
  
  /* Error */
  public static final MpWebViewController a(Context paramContext, dnj paramdnj, Intent paramIntent)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 175
    //   5: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: ldc 104
    //   11: invokestatic 110	d/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   14: aload_1
    //   15: ldc 111
    //   17: invokestatic 110	d/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   20: aload_2
    //   21: ldc 176
    //   23: invokestatic 110	d/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   26: invokestatic 117	java/lang/System:currentTimeMillis	()J
    //   29: lstore_3
    //   30: getstatic 84	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/a:TAG	Ljava/lang/String;
    //   33: new 119	java/lang/StringBuilder
    //   36: dup
    //   37: ldc 178
    //   39: invokespecial 124	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   42: aload_1
    //   43: getfield 130	com/tencent/mm/protocal/protobuf/dnj:ojt	I
    //   46: invokevirtual 134	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   49: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: invokestatic 144	com/tencent/mm/sdk/platformtools/ad:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   55: getstatic 82	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/a:onD	Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/a;
    //   58: aload_1
    //   59: getfield 130	com/tencent/mm/protocal/protobuf/dnj:ojt	I
    //   62: aload_2
    //   63: invokespecial 182	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/a:c	(ILandroid/content/Intent;)Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController;
    //   66: astore_1
    //   67: aload_1
    //   68: ifnull +55 -> 123
    //   71: getstatic 84	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/a:TAG	Ljava/lang/String;
    //   74: ldc 184
    //   76: invokestatic 144	com/tencent/mm/sdk/platformtools/ad:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   79: aload_1
    //   80: getfield 157	com/tencent/mm/plugin/webview/core/BaseWebViewController:omW	Lcom/tencent/mm/ui/widget/MMWebView;
    //   83: astore_2
    //   84: aload_2
    //   85: invokevirtual 163	com/tencent/mm/ui/widget/MMWebView:getPerformanceHelper	()Lcom/tencent/mm/pluginsdk/r;
    //   88: ldc 165
    //   90: lload_3
    //   91: invokevirtual 171	com/tencent/mm/pluginsdk/r:bL	(Ljava/lang/String;J)V
    //   94: aload_2
    //   95: aload_0
    //   96: invokevirtual 187	com/tencent/mm/ui/widget/MMWebView:aw	(Landroid/content/Context;)V
    //   99: aload_2
    //   100: invokevirtual 163	com/tencent/mm/ui/widget/MMWebView:getPerformanceHelper	()Lcom/tencent/mm/pluginsdk/r;
    //   103: ldc 173
    //   105: invokestatic 117	java/lang/System:currentTimeMillis	()J
    //   108: invokevirtual 171	com/tencent/mm/pluginsdk/r:bL	(Ljava/lang/String;J)V
    //   111: ldc 175
    //   113: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   116: aload_1
    //   117: astore_0
    //   118: ldc 2
    //   120: monitorexit
    //   121: aload_0
    //   122: areturn
    //   123: aconst_null
    //   124: astore_0
    //   125: ldc 175
    //   127: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   130: goto -12 -> 118
    //   133: astore_0
    //   134: ldc 2
    //   136: monitorexit
    //   137: aload_0
    //   138: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	139	0	paramContext	Context
    //   0	139	1	paramdnj	dnj
    //   0	139	2	paramIntent	Intent
    //   29	62	3	l	long
    // Exception table:
    //   from	to	target	type
    //   3	67	133	finally
    //   71	116	133	finally
    //   125	130	133	finally
  }
  
  private static MpWebViewController a(dnj paramdnj, MutableContextWrapper paramMutableContextWrapper)
  {
    AppMethodBeat.i(210087);
    if (paramdnj.ojt == -1)
    {
      ad.w(TAG, "[preloadWebViewInner] empty tmplType %d", new Object[] { Integer.valueOf(paramdnj.ojt) });
      AppMethodBeat.o(210087);
      return null;
    }
    if (bt.isNullOrNil(paramdnj.DNG))
    {
      ad.w(TAG, "[preloadWebViewInner] initUrl " + paramdnj.DNG + " is empty");
      AppMethodBeat.o(210087);
      return null;
    }
    if (!i.fv(paramdnj.HBu))
    {
      ad.w(TAG, "[preloadWebViewInner] filePath %s isn't exist", new Object[] { paramdnj.HBu });
      AppMethodBeat.o(210087);
      return null;
    }
    paramdnj = new MpWebViewController(paramdnj, es((Context)paramMutableContextWrapper));
    paramdnj.init();
    AppMethodBeat.o(210087);
    return paramdnj;
  }
  
  /* Error */
  public static final void ah(Intent paramIntent)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: ldc 2
    //   4: monitorenter
    //   5: ldc 251
    //   7: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: aload_0
    //   11: ldc 176
    //   13: invokestatic 110	d/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   16: getstatic 256	com/tencent/mm/ui/e$m:IUH	Ljava/lang/String;
    //   19: astore_3
    //   20: aload_3
    //   21: ldc_w 258
    //   24: invokestatic 261	d/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   27: aload_0
    //   28: aload_3
    //   29: invokevirtual 267	android/content/Intent:getByteArrayExtra	(Ljava/lang/String;)[B
    //   32: astore_3
    //   33: aload_3
    //   34: ifnull +328 -> 362
    //   37: aload_3
    //   38: arraylength
    //   39: istore_1
    //   40: iload_1
    //   41: ifne +293 -> 334
    //   44: iconst_1
    //   45: istore_1
    //   46: iload_1
    //   47: ifne +292 -> 339
    //   50: iload_2
    //   51: istore_1
    //   52: iload_1
    //   53: ifeq +309 -> 362
    //   56: ldc 126
    //   58: invokevirtual 273	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   61: astore 4
    //   63: aload 4
    //   65: checkcast 275	com/tencent/mm/bx/a
    //   68: aload_3
    //   69: invokevirtual 279	com/tencent/mm/bx/a:parseFrom	([B)Lcom/tencent/mm/bx/a;
    //   72: pop
    //   73: aload 4
    //   75: checkcast 275	com/tencent/mm/bx/a
    //   78: astore_3
    //   79: aload_3
    //   80: checkcast 126	com/tencent/mm/protocal/protobuf/dnj
    //   83: astore 4
    //   85: aload 4
    //   87: astore_3
    //   88: aload 4
    //   90: ifnonnull +98 -> 188
    //   93: new 281	android/content/res/Resources$NotFoundException
    //   96: dup
    //   97: ldc_w 283
    //   100: invokespecial 284	android/content/res/Resources$NotFoundException:<init>	(Ljava/lang/String;)V
    //   103: checkcast 286	java/lang/Throwable
    //   106: astore_3
    //   107: ldc 251
    //   109: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   112: aload_3
    //   113: athrow
    //   114: astore_3
    //   115: getstatic 84	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/a:TAG	Ljava/lang/String;
    //   118: new 119	java/lang/StringBuilder
    //   121: dup
    //   122: ldc_w 288
    //   125: invokespecial 124	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   128: aload_3
    //   129: invokevirtual 291	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   132: invokevirtual 214	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: bipush 32
    //   137: invokevirtual 294	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   140: aload_0
    //   141: invokestatic 300	com/tencent/mm/plugin/brandservice/ui/timeline/preload/d:ag	(Landroid/content/Intent;)Ljava/lang/String;
    //   144: invokevirtual 214	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   150: invokestatic 303	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   153: sipush 152
    //   156: invokestatic 308	com/tencent/mm/plugin/webview/g/a:WU	(I)V
    //   159: getstatic 314	com/tencent/mm/plugin/report/service/g:yhR	Lcom/tencent/mm/plugin/report/service/g;
    //   162: sipush 17260
    //   165: iconst_2
    //   166: anewarray 4	java/lang/Object
    //   169: dup
    //   170: iconst_0
    //   171: iconst_2
    //   172: invokestatic 196	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   175: aastore
    //   176: dup
    //   177: iconst_1
    //   178: aload_0
    //   179: invokestatic 300	com/tencent/mm/plugin/brandservice/ui/timeline/preload/d:ag	(Landroid/content/Intent;)Ljava/lang/String;
    //   182: aastore
    //   183: invokevirtual 318	com/tencent/mm/plugin/report/service/g:f	(I[Ljava/lang/Object;)V
    //   186: aconst_null
    //   187: astore_3
    //   188: aload_3
    //   189: ifnull +244 -> 433
    //   192: aload_3
    //   193: getfield 130	com/tencent/mm/protocal/protobuf/dnj:ojt	I
    //   196: istore_1
    //   197: getstatic 89	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/a:onz	Ljava/util/concurrent/ConcurrentHashMap;
    //   200: iload_1
    //   201: invokestatic 196	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   204: invokevirtual 322	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   207: checkcast 230	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController
    //   210: astore_3
    //   211: aload_3
    //   212: ifnull +191 -> 403
    //   215: aload_3
    //   216: getstatic 325	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:omJ	I
    //   219: invokevirtual 329	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:Ws	(I)Z
    //   222: ifeq +145 -> 367
    //   225: getstatic 89	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/a:onz	Ljava/util/concurrent/ConcurrentHashMap;
    //   228: iload_1
    //   229: invokestatic 196	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   232: invokevirtual 332	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   235: pop
    //   236: aload_3
    //   237: aload_0
    //   238: invokevirtual 335	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:at	(Landroid/content/Intent;)V
    //   241: getstatic 91	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/a:onA	Ljava/util/concurrent/ConcurrentHashMap;
    //   244: iload_1
    //   245: invokestatic 196	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   248: invokevirtual 332	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   251: checkcast 230	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController
    //   254: astore_0
    //   255: aload_0
    //   256: ifnull +7 -> 263
    //   259: aload_0
    //   260: invokevirtual 338	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:destroy	()V
    //   263: getstatic 91	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/a:onA	Ljava/util/concurrent/ConcurrentHashMap;
    //   266: checkcast 340	java/util/Map
    //   269: astore_0
    //   270: aload_3
    //   271: ldc_w 342
    //   274: invokestatic 261	d/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   277: aload_0
    //   278: iload_1
    //   279: invokestatic 196	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   282: aload_3
    //   283: invokeinterface 346 3 0
    //   288: pop
    //   289: getstatic 84	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/a:TAG	Ljava/lang/String;
    //   292: new 119	java/lang/StringBuilder
    //   295: dup
    //   296: ldc_w 348
    //   299: invokespecial 124	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   302: iload_1
    //   303: invokevirtual 134	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   306: ldc_w 350
    //   309: invokevirtual 214	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: aload_3
    //   313: invokevirtual 354	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:eNj	()I
    //   316: invokevirtual 134	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   319: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   322: invokestatic 356	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   325: ldc 251
    //   327: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   330: ldc 2
    //   332: monitorexit
    //   333: return
    //   334: iconst_0
    //   335: istore_1
    //   336: goto -290 -> 46
    //   339: iconst_0
    //   340: istore_1
    //   341: goto -289 -> 52
    //   344: astore_3
    //   345: ldc_w 358
    //   348: aload_3
    //   349: checkcast 286	java/lang/Throwable
    //   352: ldc_w 360
    //   355: iconst_0
    //   356: anewarray 4	java/lang/Object
    //   359: invokestatic 364	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   362: aconst_null
    //   363: astore_3
    //   364: goto -285 -> 79
    //   367: getstatic 84	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/a:TAG	Ljava/lang/String;
    //   370: new 119	java/lang/StringBuilder
    //   373: dup
    //   374: ldc_w 366
    //   377: invokespecial 124	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   380: iload_1
    //   381: invokevirtual 134	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   384: ldc_w 350
    //   387: invokevirtual 214	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   390: aload_3
    //   391: invokevirtual 354	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:eNj	()I
    //   394: invokevirtual 134	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   397: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   400: invokestatic 218	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   403: getstatic 84	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/a:TAG	Ljava/lang/String;
    //   406: ldc_w 368
    //   409: iload_1
    //   410: invokestatic 373	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   413: invokevirtual 377	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   416: invokestatic 218	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   419: ldc 251
    //   421: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   424: goto -94 -> 330
    //   427: astore_0
    //   428: ldc 2
    //   430: monitorexit
    //   431: aload_0
    //   432: athrow
    //   433: ldc 251
    //   435: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   438: goto -108 -> 330
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	441	0	paramIntent	Intent
    //   39	371	1	i	int
    //   1	50	2	j	int
    //   19	94	3	localObject1	Object
    //   114	15	3	localException1	java.lang.Exception
    //   187	126	3	localMpWebViewController	MpWebViewController
    //   344	5	3	localException2	java.lang.Exception
    //   363	28	3	localObject2	Object
    //   61	28	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   16	33	114	java/lang/Exception
    //   37	40	114	java/lang/Exception
    //   79	85	114	java/lang/Exception
    //   93	114	114	java/lang/Exception
    //   345	362	114	java/lang/Exception
    //   56	79	344	java/lang/Exception
    //   5	16	427	finally
    //   16	33	427	finally
    //   37	40	427	finally
    //   56	79	427	finally
    //   79	85	427	finally
    //   93	114	427	finally
    //   115	186	427	finally
    //   192	211	427	finally
    //   215	255	427	finally
    //   259	263	427	finally
    //   263	330	427	finally
    //   345	362	427	finally
    //   367	403	427	finally
    //   403	424	427	finally
    //   433	438	427	finally
  }
  
  public static final void bQY()
  {
    AppMethodBeat.i(6929);
    zS(-1);
    AppMethodBeat.o(6929);
  }
  
  private final MpWebViewController c(int paramInt, Intent paramIntent)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(210086);
        MpWebViewController localMpWebViewController = (MpWebViewController)onA.get(Integer.valueOf(paramInt));
        if (localMpWebViewController != null)
        {
          p.h(paramIntent, "intent");
          if (localMpWebViewController.Ws(localMpWebViewController.DGv))
          {
            paramIntent = paramIntent.getStringExtra("rawUrl");
            p.g(paramIntent, "intent.getStringExtra(Co…antsUI.WebViewUI.KRawUrl)");
            if (p.i(n.bp(paramIntent, "http://", "https://"), localMpWebViewController.bQm()))
            {
              i = 1;
              if (i == 0) {
                continue;
              }
              ad.i(TAG, "pick started:" + paramInt + ", " + localMpWebViewController.eNj());
              onA.remove(Integer.valueOf(paramInt));
              AppMethodBeat.o(210086);
              paramIntent = localMpWebViewController;
              return paramIntent;
            }
          }
          int i = 0;
          continue;
        }
        paramIntent = (MpWebViewController)onz.get(Integer.valueOf(paramInt));
        if (paramIntent != null)
        {
          if (paramIntent.Ws(MpWebViewController.omJ))
          {
            onz.remove(Integer.valueOf(paramInt));
            ad.i(TAG, "pick cached:" + paramInt + ", " + paramIntent.eNj());
            AppMethodBeat.o(210086);
            continue;
          }
          ad.w(TAG, "pick null when tmpl not ready:" + paramInt + ", " + paramIntent.eNj());
        }
      }
      finally {}
      ad.w(TAG, "pick null:".concat(String.valueOf(paramInt)));
      paramIntent = null;
      AppMethodBeat.o(210086);
    }
  }
  
  private static MMWebView es(Context paramContext)
  {
    AppMethodBeat.i(210088);
    WebView.c localc = MMWebView.KSk;
    String str;
    if (aj.cmR()) {
      str = "mm";
    }
    for (;;)
    {
      WebView.initWebviewCore(paramContext, localc, str, null);
      paramContext = (MMWebView)new a(paramContext);
      AppMethodBeat.o(210088);
      return paramContext;
      if (aj.fkJ()) {
        str = "toolsmp";
      } else {
        str = "tools";
      }
    }
  }
  
  public static void zS(int paramInt)
  {
    AppMethodBeat.i(6930);
    h.a locala = h.ojh;
    if (h.a.bPv())
    {
      AppMethodBeat.o(6930);
      return;
    }
    if (onB)
    {
      AppMethodBeat.o(6930);
      return;
    }
    ad.i(TAG, "tryPreloadTmplWebview:".concat(String.valueOf(paramInt)));
    c.g((d.g.a.a)new c(paramInt));
    AppMethodBeat.o(6930);
  }
  
  private final void zT(final int paramInt)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(6931);
        ad.i(TAG, "[preloadWebViewInner]tmplParams: ".concat(String.valueOf(paramInt)));
        Object localObject1 = b.zP(paramInt);
        if (localObject1 == null) {
          break label208;
        }
        if (!onz.containsKey(Integer.valueOf(paramInt)))
        {
          localObject1 = a((dnj)localObject1, new MutableContextWrapper(aj.getContext()));
          if (localObject1 != null)
          {
            ((Map)onz).put(Integer.valueOf(paramInt), localObject1);
            Object localObject3 = MpWebViewController.omT;
            int i = MpWebViewController.bQF();
            localObject3 = (d.g.a.a)new b((MpWebViewController)localObject1, paramInt);
            p.h(localObject3, "callback");
            ((BaseWebViewController)localObject1).Wq(i).add(localObject3);
            ad.i(TAG, "preload:" + paramInt + ", " + ((MpWebViewController)localObject1).eNj());
            AppMethodBeat.o(6931);
            return;
          }
          AppMethodBeat.o(6931);
          continue;
        }
        ad.i(TAG, "preload skip when exist:".concat(String.valueOf(paramInt)));
      }
      finally {}
      AppMethodBeat.o(6931);
      continue;
      label208:
      AppMethodBeat.o(6931);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewManager$MPWebView;", "Lcom/tencent/mm/ui/widget/MMWebView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "currentUrlProxy", "Lkotlin/Function0;", "", "getCurrentUrlProxy", "()Lkotlin/jvm/functions/Function0;", "setCurrentUrlProxy", "(Lkotlin/jvm/functions/Function0;)V", "getUrl", "plugin-brandservice_release"})
  public static final class a
    extends MMWebView
  {
    private d.g.a.a<String> onE;
    
    public a(Context paramContext)
    {
      super();
      AppMethodBeat.i(210081);
      this.gcX = true;
      this.isX5Kernel = getIsX5Kernel();
      AppMethodBeat.o(210081);
    }
    
    public final d.g.a.a<String> getCurrentUrlProxy()
    {
      return this.onE;
    }
    
    public final String getUrl()
    {
      AppMethodBeat.i(210080);
      if (this.onE != null)
      {
        localObject = this.onE;
        if (localObject == null) {
          p.gfZ();
        }
        localObject = (String)((d.g.a.a)localObject).invoke();
        AppMethodBeat.o(210080);
        return localObject;
      }
      Object localObject = super.getUrl();
      AppMethodBeat.o(210080);
      return localObject;
    }
    
    public final void setCurrentUrlProxy(d.g.a.a<String> parama)
    {
      this.onE = parama;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewManager$preloadWebViewInner$1$1$1", "com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewManager$$special$$inlined$also$lambda$1"})
  static final class b
    extends q
    implements d.g.a.a<z>
  {
    b(MpWebViewController paramMpWebViewController, int paramInt)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements d.g.a.a<z>
  {
    c(int paramInt)
    {
      super();
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/kt/CommonKt$idle$1", "Landroid/os/MessageQueue$IdleHandler;", "queueIdle", "", "libktcomm_release"})
    public static final class a
      implements MessageQueue.IdleHandler
    {
      public a(a.c paramc) {}
      
      public final boolean queueIdle()
      {
        AppMethodBeat.i(210083);
        Looper.myQueue().removeIdleHandler((MessageQueue.IdleHandler)this);
        if (this.onI.onH == -1)
        {
          Object localObject = b.omd;
          localObject = b.bQf();
          int j = localObject.length;
          int i = 0;
          while (i < j)
          {
            int k = ((Number)localObject[i]).intValue();
            a.a(a.onD, k);
            i += 1;
          }
        }
        a.a(a.onD, this.onI.onH);
        AppMethodBeat.o(210083);
        return false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.a
 * JD-Core Version:    0.7.0.1
 */