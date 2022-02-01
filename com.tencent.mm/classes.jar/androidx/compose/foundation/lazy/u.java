package androidx.compose.foundation.lazy;

import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import android.view.Display;
import android.view.View;
import androidx.compose.runtime.az;
import androidx.compose.runtime.bm;
import androidx.compose.ui.h.af;
import androidx.compose.ui.h.af.b;
import androidx.compose.ui.h.ag;
import androidx.compose.ui.h.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Landroidx/compose/foundation/lazy/LazyListPrefetcher;", "Landroidx/compose/runtime/RememberObserver;", "Landroidx/compose/foundation/lazy/LazyListOnScrolledListener;", "Landroidx/compose/foundation/lazy/LazyListOnPostMeasureListener;", "Ljava/lang/Runnable;", "Landroid/view/Choreographer$FrameCallback;", "subcomposeLayoutState", "Landroidx/compose/ui/layout/SubcomposeLayoutState;", "lazyListState", "Landroidx/compose/foundation/lazy/LazyListState;", "stateOfItemsProvider", "Landroidx/compose/runtime/State;", "Landroidx/compose/foundation/lazy/LazyListItemsProvider;", "itemContentFactory", "Landroidx/compose/foundation/lazy/LazyListItemContentFactory;", "view", "Landroid/view/View;", "(Landroidx/compose/ui/layout/SubcomposeLayoutState;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/runtime/State;Landroidx/compose/foundation/lazy/LazyListItemContentFactory;Landroid/view/View;)V", "averagePrecomposeTimeNs", "", "averagePremeasureTimeNs", "choreographer", "Landroid/view/Choreographer;", "kotlin.jvm.PlatformType", "indexToPrefetch", "", "isActive", "", "precomposedSlotHandle", "Landroidx/compose/ui/layout/SubcomposeLayoutState$PrecomposedSlotHandle;", "prefetchScheduled", "premeasuringIsNeeded", "wasScrollingForward", "calculateAverageTime", "new", "current", "doFrame", "", "frameTimeNanos", "onAbandoned", "onForgotten", "onRemembered", "onScrolled", "delta", "", "precompose", "itemProvider", "index", "run", "onPostMeasure", "Landroidx/compose/ui/layout/SubcomposeMeasureScope;", "childConstraints", "Landroidx/compose/ui/unit/Constraints;", "result", "Landroidx/compose/foundation/lazy/LazyListMeasureResult;", "onPostMeasure-VKLhPVY", "(Landroidx/compose/ui/layout/SubcomposeMeasureScope;JLandroidx/compose/foundation/lazy/LazyListMeasureResult;)V", "Companion", "foundation_release"}, k=1, mv={1, 5, 1}, xi=48)
final class u
  implements Choreographer.FrameCallback, s, t, az, Runnable
{
  public static final u.a afg;
  private static long aft;
  private final af afh;
  private final aa afi;
  private final bm<n> afj;
  private final k afk;
  private boolean afl;
  private int afn;
  private af.b afo;
  private long afp;
  private long afq;
  private boolean afr;
  private boolean afs;
  private final Choreographer choreographer;
  private boolean isActive;
  private final View view;
  
  static
  {
    AppMethodBeat.i(204245);
    afg = new u.a((byte)0);
    AppMethodBeat.o(204245);
  }
  
  public u(af paramaf, aa paramaa, bm<? extends n> parambm, k paramk, View paramView)
  {
    AppMethodBeat.i(204237);
    this.afh = paramaf;
    this.afi = paramaa;
    this.afj = parambm;
    this.afk = paramk;
    this.view = paramView;
    this.afn = -1;
    this.choreographer = Choreographer.getInstance();
    paramaf = this.view;
    float f;
    if (aft == 0L)
    {
      paramaa = paramaf.getDisplay();
      if ((paramaf.isInEditMode()) || (paramaa == null)) {
        break label138;
      }
      f = paramaa.getRefreshRate();
      if (f < 30.0F) {
        break label138;
      }
    }
    for (;;)
    {
      aft = (1.0E+009F / f);
      AppMethodBeat.o(204237);
      return;
      label138:
      f = 60.0F;
    }
  }
  
  private static long c(long paramLong1, long paramLong2)
  {
    if (paramLong2 == 0L) {
      return paramLong1;
    }
    return paramLong2 / 4L * 3L + paramLong1 / 4L;
  }
  
  public final void E(float paramFloat)
  {
    AppMethodBeat.i(204270);
    if (!this.afi.afY)
    {
      AppMethodBeat.o(204270);
      return;
    }
    Object localObject = this.afi.mQ();
    int i;
    if (!((Collection)((p)localObject).mE()).isEmpty()) {
      i = 1;
    }
    boolean bool;
    int j;
    while (i != 0) {
      if (!this.isActive)
      {
        localObject = (Throwable)new IllegalStateException("Check failed.".toString());
        AppMethodBeat.o(204270);
        throw ((Throwable)localObject);
        i = 0;
      }
      else
      {
        if (paramFloat >= 0.0F) {
          break label233;
        }
        bool = true;
        if (!bool) {
          break label239;
        }
        j = ((m)kotlin.a.p.oM(((p)localObject).mE())).getIndex() + 1;
        label126:
        if (j != this.afn)
        {
          if (j < 0) {
            break label268;
          }
          if (j >= ((p)localObject).mG()) {
            break label263;
          }
          i = 1;
        }
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        localObject = this.afo;
        if ((localObject != null) && (this.afl != bool)) {
          ((af.b)localObject).dispose();
        }
        this.afl = bool;
        this.afn = j;
        this.afo = null;
        this.afr = false;
        if (!this.afs)
        {
          this.afs = true;
          this.view.post((Runnable)this);
        }
      }
      AppMethodBeat.o(204270);
      return;
      label233:
      bool = false;
      break;
      label239:
      j = ((m)kotlin.a.p.oK(((p)localObject).mE())).getIndex() - 1;
      break label126;
      label263:
      i = 0;
      continue;
      label268:
      i = 0;
    }
  }
  
  public final void a(ag paramag, long paramLong, r paramr)
  {
    int m = 1;
    int k = 0;
    AppMethodBeat.i(204277);
    kotlin.g.b.s.u(paramag, "$receiver");
    kotlin.g.b.s.u(paramr, "result");
    int i1 = this.afn;
    n localn;
    List localList;
    int n;
    if ((this.afr) && (i1 != -1))
    {
      if (!this.isActive)
      {
        paramag = (Throwable)new IllegalStateException("Check failed.".toString());
        AppMethodBeat.o(204277);
        throw paramag;
      }
      localn = (n)this.afj.getValue();
      if (i1 < localn.getItemsCount())
      {
        localList = paramr.aem;
        n = localList.size() - 1;
        if (n < 0) {}
      }
    }
    int j;
    label276:
    label409:
    label416:
    for (int i = 0;; i = j)
    {
      j = i + 1;
      label168:
      int i2;
      if (((m)localList.get(i)).getIndex() == i1)
      {
        i = 1;
        if (i == 0) {
          break label276;
        }
        i = 1;
        if (paramr.afc == null) {
          break label308;
        }
        paramr = paramr.afc;
        i2 = paramr.size() - 1;
        if (i2 < 0) {
          break label302;
        }
      }
      for (j = 0;; j = n)
      {
        n = j + 1;
        if (((ac)paramr.get(j)).index == i1)
        {
          j = 1;
          label231:
          if (j == 0) {
            break label295;
          }
          j = 1;
          label239:
          if (j == 0) {
            break label308;
          }
        }
        label295:
        label302:
        label308:
        for (j = m;; j = 0)
        {
          if ((i == 0) && (j == 0)) {
            break label314;
          }
          this.afr = false;
          AppMethodBeat.o(204277);
          return;
          i = 0;
          break;
          if (j <= n) {
            break label416;
          }
          i = 0;
          break label168;
          j = 0;
          break label231;
          if (n <= i2) {
            break label409;
          }
          j = 0;
          break label239;
        }
        label314:
        paramr = localn.bu(i1);
        paramag = paramag.d(paramr, this.afk.f(i1, paramr));
        m = paramag.size() - 1;
        if (m >= 0) {}
        for (i = k;; i = j)
        {
          j = i + 1;
          ((o)paramag.get(i)).aw(paramLong);
          if (j > m)
          {
            AppMethodBeat.o(204277);
            return;
          }
        }
      }
    }
  }
  
  public final void doFrame(long paramLong)
  {
    AppMethodBeat.i(204264);
    if (this.isActive) {
      this.view.post((Runnable)this);
    }
    AppMethodBeat.o(204264);
  }
  
  public final void mJ()
  {
    this.afi.aga = ((t)this);
    this.afi.agb = ((s)this);
    this.isActive = true;
  }
  
  public final void mK()
  {
    AppMethodBeat.i(204286);
    this.isActive = false;
    this.afi.aga = null;
    this.afi.agb = null;
    this.view.removeCallbacks((Runnable)this);
    this.choreographer.removeFrameCallback((Choreographer.FrameCallback)this);
    AppMethodBeat.o(204286);
  }
  
  public final void mL() {}
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: ldc_w 342
    //   5: invokestatic 113	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 150	androidx/compose/foundation/lazy/u:afn	I
    //   12: iconst_m1
    //   13: if_icmpeq +17 -> 30
    //   16: aload_0
    //   17: getfield 253	androidx/compose/foundation/lazy/u:afs	Z
    //   20: ifeq +10 -> 30
    //   23: aload_0
    //   24: getfield 212	androidx/compose/foundation/lazy/u:isActive	Z
    //   27: ifne +10 -> 37
    //   30: ldc_w 342
    //   33: invokestatic 122	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   36: return
    //   37: aload_0
    //   38: getfield 242	androidx/compose/foundation/lazy/u:afo	Landroidx/compose/ui/h/af$b;
    //   41: ifnonnull +407 -> 448
    //   44: ldc_w 344
    //   47: invokestatic 349	android/os/Trace:beginSection	(Ljava/lang/String;)V
    //   50: getstatic 355	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   53: aload_0
    //   54: getfield 148	androidx/compose/foundation/lazy/u:view	Landroid/view/View;
    //   57: invokevirtual 359	android/view/View:getDrawingTime	()J
    //   60: invokevirtual 363	java/util/concurrent/TimeUnit:toNanos	(J)J
    //   63: getstatic 160	androidx/compose/foundation/lazy/u:aft	J
    //   66: ladd
    //   67: lstore_3
    //   68: invokestatic 368	java/lang/System:nanoTime	()J
    //   71: lstore 5
    //   73: lload 5
    //   75: lload_3
    //   76: lcmp
    //   77: ifgt +15 -> 92
    //   80: aload_0
    //   81: getfield 370	androidx/compose/foundation/lazy/u:afp	J
    //   84: lload 5
    //   86: ladd
    //   87: lload_3
    //   88: lcmp
    //   89: ifge +263 -> 352
    //   92: aload_0
    //   93: getfield 150	androidx/compose/foundation/lazy/u:afn	I
    //   96: istore_2
    //   97: aload_0
    //   98: getfield 144	androidx/compose/foundation/lazy/u:afj	Landroidx/compose/runtime/bm;
    //   101: invokeinterface 272 1 0
    //   106: checkcast 274	androidx/compose/foundation/lazy/n
    //   109: astore 7
    //   111: aload_0
    //   112: getfield 148	androidx/compose/foundation/lazy/u:view	Landroid/view/View;
    //   115: invokevirtual 373	android/view/View:getWindowVisibility	()I
    //   118: ifne +322 -> 440
    //   121: iload_2
    //   122: iflt +261 -> 383
    //   125: iload_2
    //   126: aload 7
    //   128: invokeinterface 277 1 0
    //   133: if_icmpge +245 -> 378
    //   136: iload_1
    //   137: ifeq +303 -> 440
    //   140: aload 7
    //   142: iload_2
    //   143: invokeinterface 302 2 0
    //   148: astore 9
    //   150: aload_0
    //   151: getfield 146	androidx/compose/foundation/lazy/u:afk	Landroidx/compose/foundation/lazy/k;
    //   154: iload_2
    //   155: aload 9
    //   157: invokevirtual 308	androidx/compose/foundation/lazy/k:f	(ILjava/lang/Object;)Lkotlin/g/a/m;
    //   160: astore 10
    //   162: aload_0
    //   163: getfield 140	androidx/compose/foundation/lazy/u:afh	Landroidx/compose/ui/h/af;
    //   166: astore 11
    //   168: aload 10
    //   170: ldc_w 375
    //   173: invokestatic 131	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   176: aload 11
    //   178: invokevirtual 380	androidx/compose/ui/h/af:xa	()V
    //   181: aload 11
    //   183: getfield 384	androidx/compose/ui/h/af:aNp	Ljava/util/Map;
    //   186: aload 9
    //   188: invokeinterface 390 2 0
    //   193: ifne +124 -> 317
    //   196: aload 11
    //   198: getfield 393	androidx/compose/ui/h/af:aNr	Ljava/util/Map;
    //   201: astore 12
    //   203: aload 12
    //   205: aload 9
    //   207: invokeinterface 396 2 0
    //   212: astore 8
    //   214: aload 8
    //   216: astore 7
    //   218: aload 8
    //   220: ifnonnull +83 -> 303
    //   223: aload 11
    //   225: getfield 399	androidx/compose/ui/h/af:aNs	I
    //   228: ifle +160 -> 388
    //   231: aload 11
    //   233: aload 9
    //   235: invokevirtual 403	androidx/compose/ui/h/af:aj	(Ljava/lang/Object;)Landroidx/compose/ui/i/f;
    //   238: astore 7
    //   240: aload 11
    //   242: aload 11
    //   244: invokevirtual 407	androidx/compose/ui/h/af:getRoot	()Landroidx/compose/ui/i/f;
    //   247: getfield 413	androidx/compose/ui/i/f:aOh	Landroidx/compose/runtime/a/e;
    //   250: invokevirtual 418	androidx/compose/runtime/a/e:qp	()Ljava/util/List;
    //   253: aload 7
    //   255: invokeinterface 422 2 0
    //   260: aload 11
    //   262: invokevirtual 407	androidx/compose/ui/h/af:getRoot	()Landroidx/compose/ui/i/f;
    //   265: getfield 413	androidx/compose/ui/i/f:aOh	Landroidx/compose/runtime/a/e;
    //   268: invokevirtual 418	androidx/compose/runtime/a/e:qp	()Ljava/util/List;
    //   271: invokeinterface 288 1 0
    //   276: invokevirtual 426	androidx/compose/ui/h/af:ac	(II)V
    //   279: aload 11
    //   281: aload 11
    //   283: getfield 429	androidx/compose/ui/h/af:aNt	I
    //   286: iconst_1
    //   287: iadd
    //   288: putfield 429	androidx/compose/ui/h/af:aNt	I
    //   291: aload 12
    //   293: aload 9
    //   295: aload 7
    //   297: invokeinterface 433 3 0
    //   302: pop
    //   303: aload 11
    //   305: aload 7
    //   307: checkcast 409	androidx/compose/ui/i/f
    //   310: aload 9
    //   312: aload 10
    //   314: invokevirtual 436	androidx/compose/ui/h/af:a	(Landroidx/compose/ui/i/f;Ljava/lang/Object;Lkotlin/g/a/m;)V
    //   317: aload_0
    //   318: new 438	androidx/compose/ui/h/af$e
    //   321: dup
    //   322: aload 11
    //   324: aload 9
    //   326: invokespecial 441	androidx/compose/ui/h/af$e:<init>	(Landroidx/compose/ui/h/af;Ljava/lang/Object;)V
    //   329: checkcast 246	androidx/compose/ui/h/af$b
    //   332: putfield 242	androidx/compose/foundation/lazy/u:afo	Landroidx/compose/ui/h/af$b;
    //   335: aload_0
    //   336: invokestatic 368	java/lang/System:nanoTime	()J
    //   339: lload 5
    //   341: lsub
    //   342: aload_0
    //   343: getfield 370	androidx/compose/foundation/lazy/u:afp	J
    //   346: invokestatic 443	androidx/compose/foundation/lazy/u:c	(JJ)J
    //   349: putfield 370	androidx/compose/foundation/lazy/u:afp	J
    //   352: aload_0
    //   353: getfield 158	androidx/compose/foundation/lazy/u:choreographer	Landroid/view/Choreographer;
    //   356: aload_0
    //   357: checkcast 6	android/view/Choreographer$FrameCallback
    //   360: invokevirtual 446	android/view/Choreographer:postFrameCallback	(Landroid/view/Choreographer$FrameCallback;)V
    //   363: getstatic 452	kotlin/ah:aiuX	Lkotlin/ah;
    //   366: astore 7
    //   368: invokestatic 455	android/os/Trace:endSection	()V
    //   371: ldc_w 342
    //   374: invokestatic 122	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   377: return
    //   378: iconst_0
    //   379: istore_1
    //   380: goto -244 -> 136
    //   383: iconst_0
    //   384: istore_1
    //   385: goto -249 -> 136
    //   388: aload 11
    //   390: aload 11
    //   392: invokevirtual 407	androidx/compose/ui/h/af:getRoot	()Landroidx/compose/ui/i/f;
    //   395: getfield 413	androidx/compose/ui/i/f:aOh	Landroidx/compose/runtime/a/e;
    //   398: invokevirtual 418	androidx/compose/runtime/a/e:qp	()Ljava/util/List;
    //   401: invokeinterface 288 1 0
    //   406: invokevirtual 459	androidx/compose/ui/h/af:cQ	(I)Landroidx/compose/ui/i/f;
    //   409: astore 7
    //   411: aload 11
    //   413: aload 11
    //   415: getfield 429	androidx/compose/ui/h/af:aNt	I
    //   418: iconst_1
    //   419: iadd
    //   420: putfield 429	androidx/compose/ui/h/af:aNt	I
    //   423: goto -132 -> 291
    //   426: astore 7
    //   428: invokestatic 455	android/os/Trace:endSection	()V
    //   431: ldc_w 342
    //   434: invokestatic 122	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   437: aload 7
    //   439: athrow
    //   440: aload_0
    //   441: iconst_0
    //   442: putfield 253	androidx/compose/foundation/lazy/u:afs	Z
    //   445: goto -82 -> 363
    //   448: ldc_w 461
    //   451: invokestatic 349	android/os/Trace:beginSection	(Ljava/lang/String;)V
    //   454: getstatic 355	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   457: aload_0
    //   458: getfield 148	androidx/compose/foundation/lazy/u:view	Landroid/view/View;
    //   461: invokevirtual 359	android/view/View:getDrawingTime	()J
    //   464: invokevirtual 363	java/util/concurrent/TimeUnit:toNanos	(J)J
    //   467: getstatic 160	androidx/compose/foundation/lazy/u:aft	J
    //   470: ladd
    //   471: lstore_3
    //   472: invokestatic 368	java/lang/System:nanoTime	()J
    //   475: lstore 5
    //   477: lload 5
    //   479: lload_3
    //   480: lcmp
    //   481: ifgt +15 -> 496
    //   484: aload_0
    //   485: getfield 463	androidx/compose/foundation/lazy/u:afq	J
    //   488: lload 5
    //   490: ladd
    //   491: lload_3
    //   492: lcmp
    //   493: ifge +67 -> 560
    //   496: aload_0
    //   497: getfield 148	androidx/compose/foundation/lazy/u:view	Landroid/view/View;
    //   500: invokevirtual 373	android/view/View:getWindowVisibility	()I
    //   503: ifne +37 -> 540
    //   506: aload_0
    //   507: iconst_1
    //   508: putfield 251	androidx/compose/foundation/lazy/u:afr	Z
    //   511: aload_0
    //   512: getfield 142	androidx/compose/foundation/lazy/u:afi	Landroidx/compose/foundation/lazy/aa;
    //   515: invokevirtual 467	androidx/compose/foundation/lazy/aa:mR	()Landroidx/compose/ui/h/z;
    //   518: invokeinterface 472 1 0
    //   523: aload_0
    //   524: invokestatic 368	java/lang/System:nanoTime	()J
    //   527: lload 5
    //   529: lsub
    //   530: aload_0
    //   531: getfield 463	androidx/compose/foundation/lazy/u:afq	J
    //   534: invokestatic 443	androidx/compose/foundation/lazy/u:c	(JJ)J
    //   537: putfield 463	androidx/compose/foundation/lazy/u:afq	J
    //   540: aload_0
    //   541: iconst_0
    //   542: putfield 253	androidx/compose/foundation/lazy/u:afs	Z
    //   545: getstatic 452	kotlin/ah:aiuX	Lkotlin/ah;
    //   548: astore 7
    //   550: invokestatic 455	android/os/Trace:endSection	()V
    //   553: ldc_w 342
    //   556: invokestatic 122	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   559: return
    //   560: aload_0
    //   561: getfield 158	androidx/compose/foundation/lazy/u:choreographer	Landroid/view/Choreographer;
    //   564: aload_0
    //   565: checkcast 6	android/view/Choreographer$FrameCallback
    //   568: invokevirtual 446	android/view/Choreographer:postFrameCallback	(Landroid/view/Choreographer$FrameCallback;)V
    //   571: goto -26 -> 545
    //   574: astore 7
    //   576: invokestatic 455	android/os/Trace:endSection	()V
    //   579: ldc_w 342
    //   582: invokestatic 122	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   585: aload 7
    //   587: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	588	0	this	u
    //   1	384	1	i	int
    //   96	59	2	j	int
    //   67	425	3	l1	long
    //   71	457	5	l2	long
    //   109	301	7	localObject1	Object
    //   426	12	7	localObject2	Object
    //   548	1	7	localah	kotlin.ah
    //   574	12	7	localObject3	Object
    //   212	7	8	localObject4	Object
    //   148	177	9	localObject5	Object
    //   160	153	10	localm	kotlin.g.a.m
    //   166	248	11	localaf	af
    //   201	91	12	localMap	java.util.Map
    // Exception table:
    //   from	to	target	type
    //   50	73	426	finally
    //   80	92	426	finally
    //   92	121	426	finally
    //   125	136	426	finally
    //   140	214	426	finally
    //   223	291	426	finally
    //   291	303	426	finally
    //   303	317	426	finally
    //   317	352	426	finally
    //   352	363	426	finally
    //   363	368	426	finally
    //   388	423	426	finally
    //   440	445	426	finally
    //   454	477	574	finally
    //   484	496	574	finally
    //   496	540	574	finally
    //   540	545	574	finally
    //   545	550	574	finally
    //   560	571	574	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.foundation.lazy.u
 * JD-Core Version:    0.7.0.1
 */