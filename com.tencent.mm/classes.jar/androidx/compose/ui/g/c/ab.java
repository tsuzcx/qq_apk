package androidx.compose.ui.g.c;

import androidx.compose.runtime.a.e;
import androidx.compose.ui.f.c;
import androidx.compose.ui.n.l;
import androidx.compose.ui.platform.av;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Result.Companion;
import kotlin.ah;
import kotlin.d.g;
import kotlin.d.h;
import kotlinx.coroutines.p;
import kotlinx.coroutines.q;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/input/pointer/SuspendingPointerInputFilter;", "Landroidx/compose/ui/input/pointer/PointerInputFilter;", "Landroidx/compose/ui/input/pointer/PointerInputModifier;", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "Landroidx/compose/ui/unit/Density;", "viewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "density", "(Landroidx/compose/ui/platform/ViewConfiguration;Landroidx/compose/ui/unit/Density;)V", "boundsSize", "Landroidx/compose/ui/unit/IntSize;", "J", "currentEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "", "getDensity", "()F", "dispatchingPointerHandlers", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/input/pointer/SuspendingPointerInputFilter$PointerEventHandlerCoroutine;", "fontScale", "getFontScale", "lastPointerEvent", "pointerHandlers", "pointerInputFilter", "getPointerInputFilter", "()Landroidx/compose/ui/input/pointer/PointerInputFilter;", "getViewConfiguration", "()Landroidx/compose/ui/platform/ViewConfiguration;", "awaitPointerEventScope", "R", "block", "Lkotlin/Function2;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dispatchPointerEvent", "", "pointerEvent", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "forEachCurrentPointerHandler", "Lkotlin/Function1;", "onCancel", "onPointerEvent", "bounds", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "roundToPx", "", "Landroidx/compose/ui/unit/Dp;", "roundToPx-0680j_4", "(F)I", "Landroidx/compose/ui/unit/TextUnit;", "roundToPx--R2X_6o", "(J)I", "toDp", "toDp-GaN1DYA", "(J)F", "toDp-u2uoSUM", "(F)F", "(I)F", "toPx", "toPx-0680j_4", "toPx--R2X_6o", "toRect", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/unit/DpRect;", "toSp", "toSp-0xMU5do", "(F)J", "toSp-kPz2Gy4", "(I)J", "PointerEventHandlerCoroutine", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ab
  extends s
  implements t, u
{
  private i aLS;
  private final e<a<?>> aLT;
  private final e<a<?>> aLU;
  private i aLV;
  private long aLW;
  final av ahE;
  
  public ab(av paramav, androidx.compose.ui.n.d paramd)
  {
    AppMethodBeat.i(205790);
    this.ahE = paramav;
    this.aaW = paramd;
    this.aLS = ac.ww();
    this.aLT = new e(new a[16]);
    this.aLU = new e(new a[16]);
    paramav = l.beO;
    this.aLW = l.su();
    AppMethodBeat.o(205790);
  }
  
  /* Error */
  private final void a(i parami, k paramk)
  {
    // Byte code:
    //   0: ldc 172
    //   2: invokestatic 132	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 151	androidx/compose/ui/g/c/ab:aLT	Landroidx/compose/runtime/a/e;
    //   9: astore 5
    //   11: aload 5
    //   13: monitorenter
    //   14: aload_0
    //   15: getfield 153	androidx/compose/ui/g/c/ab:aLU	Landroidx/compose/runtime/a/e;
    //   18: astore 6
    //   20: aload_0
    //   21: getfield 151	androidx/compose/ui/g/c/ab:aLT	Landroidx/compose/runtime/a/e;
    //   24: astore 7
    //   26: aload 6
    //   28: aload 6
    //   30: getfield 176	androidx/compose/runtime/a/e:size	I
    //   33: aload 7
    //   35: invokevirtual 179	androidx/compose/runtime/a/e:a	(ILandroidx/compose/runtime/a/e;)Z
    //   38: pop
    //   39: aload 5
    //   41: monitorexit
    //   42: getstatic 183	androidx/compose/ui/g/c/ab$b:$EnumSwitchMapping$0	[I
    //   45: aload_2
    //   46: invokevirtual 189	androidx/compose/ui/g/c/k:ordinal	()I
    //   49: iaload
    //   50: istore_3
    //   51: iload_3
    //   52: tableswitch	default:+28 -> 80, 1:+52->104, 2:+52->104, 3:+104->156
    //   81: getfield 153	androidx/compose/ui/g/c/ab:aLU	Landroidx/compose/runtime/a/e;
    //   84: invokevirtual 192	androidx/compose/runtime/a/e:clear	()V
    //   87: ldc 172
    //   89: invokestatic 168	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   92: return
    //   93: astore_1
    //   94: aload 5
    //   96: monitorexit
    //   97: ldc 172
    //   99: invokestatic 168	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   102: aload_1
    //   103: athrow
    //   104: aload_0
    //   105: getfield 153	androidx/compose/ui/g/c/ab:aLU	Landroidx/compose/runtime/a/e;
    //   108: astore 5
    //   110: aload 5
    //   112: getfield 176	androidx/compose/runtime/a/e:size	I
    //   115: istore 4
    //   117: iload 4
    //   119: ifle -39 -> 80
    //   122: aload 5
    //   124: getfield 196	androidx/compose/runtime/a/e:aqq	[Ljava/lang/Object;
    //   127: astore 5
    //   129: iconst_0
    //   130: istore_3
    //   131: aload 5
    //   133: iload_3
    //   134: aaload
    //   135: checkcast 10	androidx/compose/ui/g/c/ab$a
    //   138: aload_1
    //   139: aload_2
    //   140: invokevirtual 198	androidx/compose/ui/g/c/ab$a:b	(Landroidx/compose/ui/g/c/i;Landroidx/compose/ui/g/c/k;)V
    //   143: iload_3
    //   144: iconst_1
    //   145: iadd
    //   146: istore_3
    //   147: iload_3
    //   148: iload 4
    //   150: if_icmpge -70 -> 80
    //   153: goto -22 -> 131
    //   156: aload_0
    //   157: getfield 153	androidx/compose/ui/g/c/ab:aLU	Landroidx/compose/runtime/a/e;
    //   160: astore 5
    //   162: aload 5
    //   164: getfield 176	androidx/compose/runtime/a/e:size	I
    //   167: istore_3
    //   168: iload_3
    //   169: ifle -89 -> 80
    //   172: aload 5
    //   174: getfield 196	androidx/compose/runtime/a/e:aqq	[Ljava/lang/Object;
    //   177: astore 5
    //   179: iload_3
    //   180: iconst_1
    //   181: isub
    //   182: istore_3
    //   183: aload 5
    //   185: iload_3
    //   186: aaload
    //   187: checkcast 10	androidx/compose/ui/g/c/ab$a
    //   190: aload_1
    //   191: aload_2
    //   192: invokevirtual 198	androidx/compose/ui/g/c/ab$a:b	(Landroidx/compose/ui/g/c/i;Landroidx/compose/ui/g/c/k;)V
    //   195: iload_3
    //   196: iconst_1
    //   197: isub
    //   198: istore_3
    //   199: iload_3
    //   200: iflt -120 -> 80
    //   203: goto -20 -> 183
    //   206: astore_1
    //   207: aload_0
    //   208: getfield 153	androidx/compose/ui/g/c/ab:aLU	Landroidx/compose/runtime/a/e;
    //   211: invokevirtual 192	androidx/compose/runtime/a/e:clear	()V
    //   214: ldc 172
    //   216: invokestatic 168	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   219: aload_1
    //   220: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	221	0	this	ab
    //   0	221	1	parami	i
    //   0	221	2	paramk	k
    //   50	150	3	i	int
    //   115	36	4	j	int
    //   9	175	5	localObject	Object
    //   18	11	6	locale1	e
    //   24	10	7	locale2	e
    // Exception table:
    //   from	to	target	type
    //   14	39	93	finally
    //   42	51	206	finally
    //   104	117	206	finally
    //   122	129	206	finally
    //   131	143	206	finally
    //   156	168	206	finally
    //   172	179	206	finally
    //   183	195	206	finally
  }
  
  public final androidx.compose.ui.f a(androidx.compose.ui.f paramf)
  {
    AppMethodBeat.i(205923);
    paramf = t.a.a((t)this, paramf);
    AppMethodBeat.o(205923);
    return paramf;
  }
  
  public final <R> R a(R paramR, kotlin.g.a.m<? super R, ? super f.c, ? extends R> paramm)
  {
    AppMethodBeat.i(205912);
    paramR = t.a.a((t)this, paramR, paramm);
    AppMethodBeat.o(205912);
    return paramR;
  }
  
  public final <R> Object a(kotlin.g.a.m<? super a, ? super kotlin.d.d<? super R>, ? extends Object> paramm, kotlin.d.d<? super R> paramd)
  {
    AppMethodBeat.i(205909);
    q localq = new q(kotlin.d.a.b.au(paramd), 1);
    localq.kBA();
    p localp = (p)localq;
    a locala = new a((kotlin.d.d)localp);
    synchronized (this.aLT)
    {
      this.aLT.add(locala);
      Object localObject = (kotlin.d.d)locala;
      kotlin.g.b.s.u(paramm, "$this$createCoroutine");
      kotlin.g.b.s.u(localObject, "completion");
      paramm = (kotlin.d.d)new h(kotlin.d.a.b.au(kotlin.d.a.b.a(paramm, locala, (kotlin.d.d)localObject)), kotlin.d.a.a.aiwj);
      localObject = ah.aiuX;
      Result.Companion localCompanion = Result.Companion;
      paramm.resumeWith(Result.constructor-impl(localObject));
      paramm = ah.aiuX;
      localp.bg((kotlin.g.a.b)new c(locala));
      paramm = localq.getResult();
      if (paramm == kotlin.d.a.a.aiwj) {
        kotlin.g.b.s.u(paramd, "frame");
      }
      AppMethodBeat.o(205909);
      return paramm;
    }
  }
  
  public final void a(i parami, k paramk, long paramLong)
  {
    int j = 0;
    AppMethodBeat.i(205885);
    kotlin.g.b.s.u(parami, "pointerEvent");
    kotlin.g.b.s.u(paramk, "pass");
    this.aLW = paramLong;
    if (paramk == k.aLi) {
      this.aLS = parami;
    }
    a(parami, paramk);
    paramk = parami.alK;
    int m = paramk.size() - 1;
    if (m >= 0) {}
    int k;
    label133:
    label138:
    for (int i = 0;; i = k)
    {
      k = i + 1;
      if (!j.d((m)paramk.get(i)))
      {
        i = 0;
        if (i == 0) {
          j = 1;
        }
        if (j == 0) {
          break label133;
        }
      }
      for (;;)
      {
        this.aLV = parami;
        AppMethodBeat.o(205885);
        return;
        if (k <= m) {
          break label138;
        }
        i = 1;
        break;
        parami = null;
      }
    }
  }
  
  public final boolean a(kotlin.g.a.b<? super f.c, Boolean> paramb)
  {
    AppMethodBeat.i(205919);
    boolean bool = t.a.a((t)this, paramb);
    AppMethodBeat.o(205919);
    return bool;
  }
  
  public final <R> R b(R paramR, kotlin.g.a.m<? super f.c, ? super R, ? extends R> paramm)
  {
    AppMethodBeat.i(205916);
    paramR = t.a.b((t)this, paramR, paramm);
    AppMethodBeat.o(205916);
    return paramR;
  }
  
  public final float bs(int paramInt)
  {
    AppMethodBeat.i(205851);
    float f = this.aaW.bs(paramInt);
    AppMethodBeat.o(205851);
    return f;
  }
  
  public final av getViewConfiguration()
  {
    return this.ahE;
  }
  
  public final float mn()
  {
    AppMethodBeat.i(205859);
    float f = this.aaW.mn();
    AppMethodBeat.o(205859);
    return f;
  }
  
  public final float mo()
  {
    AppMethodBeat.i(205865);
    float f = this.aaW.mo();
    AppMethodBeat.o(205865);
    return f;
  }
  
  public final void onCancel()
  {
    AppMethodBeat.i(205900);
    Object localObject = this.aLV;
    if (localObject == null)
    {
      AppMethodBeat.o(205900);
      return;
    }
    List localList = ((i)localObject).alK;
    ArrayList localArrayList = new ArrayList(localList.size());
    int i = 0;
    int k = localList.size() - 1;
    if (k >= 0) {}
    for (;;)
    {
      int j = i + 1;
      localObject = (m)localList.get(i);
      long l;
      if (((m)localObject).aLn) {
        l = ((m)localObject).position;
      }
      for (localObject = m.a((m)localObject, 0L, 0L, 0L, false, ((m)localObject).aLm, l, ((m)localObject).aLn, ac.wx(), 0, 263);; localObject = null)
      {
        if (localObject != null) {
          ((Collection)localArrayList).add(localObject);
        }
        if (j <= k) {
          break;
        }
        localObject = new i((List)localArrayList);
        this.aLS = ((i)localObject);
        a((i)localObject, k.aLi);
        a((i)localObject, k.aLj);
        a((i)localObject, k.aLk);
        this.aLV = null;
        AppMethodBeat.o(205900);
        return;
      }
      i = j;
    }
  }
  
  public final float t(long paramLong)
  {
    AppMethodBeat.i(205844);
    float f = this.aaW.t(paramLong);
    AppMethodBeat.o(205844);
    return f;
  }
  
  public final int v(float paramFloat)
  {
    AppMethodBeat.i(205827);
    int i = this.aaW.v(paramFloat);
    AppMethodBeat.o(205827);
    return i;
  }
  
  public final float w(float paramFloat)
  {
    AppMethodBeat.i(205836);
    paramFloat = this.aaW.w(paramFloat);
    AppMethodBeat.o(205836);
    return paramFloat;
  }
  
  public final s wq()
  {
    return (s)this;
  }
  
  public final long x(float paramFloat)
  {
    AppMethodBeat.i(205839);
    long l = this.aaW.x(paramFloat);
    AppMethodBeat.o(205839);
    return l;
  }
  
  @Metadata(d1={""}, d2={"Landroidx/compose/ui/input/pointer/SuspendingPointerInputFilter$PointerEventHandlerCoroutine;", "R", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "Landroidx/compose/ui/unit/Density;", "Lkotlin/coroutines/Continuation;", "completion", "(Landroidx/compose/ui/input/pointer/SuspendingPointerInputFilter;Lkotlin/coroutines/Continuation;)V", "awaitPass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "currentEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "getCurrentEvent", "()Landroidx/compose/ui/input/pointer/PointerEvent;", "density", "", "getDensity", "()F", "fontScale", "getFontScale", "pointerAwaiter", "Lkotlinx/coroutines/CancellableContinuation;", "size", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g", "()J", "viewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "getViewConfiguration", "()Landroidx/compose/ui/platform/ViewConfiguration;", "awaitPointerEvent", "pass", "(Landroidx/compose/ui/input/pointer/PointerEventPass;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancel", "", "cause", "", "offerPointerEvent", "event", "resumeWith", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)V", "roundToPx", "", "Landroidx/compose/ui/unit/Dp;", "roundToPx-0680j_4", "(F)I", "Landroidx/compose/ui/unit/TextUnit;", "roundToPx--R2X_6o", "(J)I", "toDp", "toDp-GaN1DYA", "(J)F", "toDp-u2uoSUM", "(F)F", "(I)F", "toPx", "toPx-0680j_4", "toPx--R2X_6o", "toRect", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/unit/DpRect;", "toSp", "toSp-0xMU5do", "(F)J", "toSp-kPz2Gy4", "(I)J", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
  final class a<R>
    implements a, kotlin.d.d<R>
  {
    p<? super i> aLY;
    private k aLZ;
    private final kotlin.d.f aMa;
    private final kotlin.d.d<R> completion;
    
    public a()
    {
      AppMethodBeat.i(205793);
      this.completion = localObject;
      this.aLX = ab.this;
      this.aLZ = k.aLj;
      this.aMa = ((kotlin.d.f)g.aiwf);
      AppMethodBeat.o(205793);
    }
    
    public final Object a(k paramk, kotlin.d.d<? super i> paramd)
    {
      AppMethodBeat.i(205863);
      q localq = new q(kotlin.d.a.b.au(paramd), 1);
      localq.kBA();
      p localp = (p)localq;
      this.aLZ = paramk;
      this.aLY = localp;
      paramk = localq.getResult();
      if (paramk == kotlin.d.a.a.aiwj) {
        kotlin.g.b.s.u(paramd, "frame");
      }
      AppMethodBeat.o(205863);
      return paramk;
    }
    
    public final void b(i parami, k paramk)
    {
      AppMethodBeat.i(205843);
      kotlin.g.b.s.u(parami, "event");
      kotlin.g.b.s.u(paramk, "pass");
      if (paramk == this.aLZ)
      {
        paramk = this.aLY;
        if (paramk != null)
        {
          this.aLY = null;
          paramk = (kotlin.d.d)paramk;
          Result.Companion localCompanion = Result.Companion;
          paramk.resumeWith(Result.constructor-impl(parami));
        }
      }
      AppMethodBeat.o(205843);
    }
    
    public final float bs(int paramInt)
    {
      AppMethodBeat.i(205812);
      float f = this.aLX.bs(paramInt);
      AppMethodBeat.o(205812);
      return f;
    }
    
    public final kotlin.d.f getContext()
    {
      return this.aMa;
    }
    
    public final av getViewConfiguration()
    {
      return ab.this.ahE;
    }
    
    public final float mn()
    {
      AppMethodBeat.i(205814);
      float f = this.aLX.mn();
      AppMethodBeat.o(205814);
      return f;
    }
    
    public final float mo()
    {
      AppMethodBeat.i(205817);
      float f = this.aLX.mo();
      AppMethodBeat.o(205817);
      return f;
    }
    
    public final void resumeWith(Object paramObject)
    {
      AppMethodBeat.i(205855);
      e locale = ab.a(ab.this);
      Object localObject = ab.this;
      try
      {
        ab.a((ab)localObject).remove(this);
        localObject = ah.aiuX;
        this.completion.resumeWith(paramObject);
        AppMethodBeat.o(205855);
        return;
      }
      finally
      {
        AppMethodBeat.o(205855);
      }
    }
    
    public final float t(long paramLong)
    {
      AppMethodBeat.i(205809);
      float f = this.aLX.t(paramLong);
      AppMethodBeat.o(205809);
      return f;
    }
    
    public final int v(float paramFloat)
    {
      AppMethodBeat.i(205796);
      int i = this.aLX.v(paramFloat);
      AppMethodBeat.o(205796);
      return i;
    }
    
    public final float w(float paramFloat)
    {
      AppMethodBeat.i(205802);
      paramFloat = this.aLX.w(paramFloat);
      AppMethodBeat.o(205802);
      return paramFloat;
    }
    
    public final long wj()
    {
      AppMethodBeat.i(205831);
      long l = ab.c(ab.this);
      AppMethodBeat.o(205831);
      return l;
    }
    
    public final i wk()
    {
      AppMethodBeat.i(205824);
      i locali = ab.b(ab.this);
      AppMethodBeat.o(205824);
      return locali;
    }
    
    public final long x(float paramFloat)
    {
      AppMethodBeat.i(205807);
      long l = this.aLX.x(paramFloat);
      AppMethodBeat.o(205807);
      return l;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "R", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.g.b.u
    implements kotlin.g.a.b<Throwable, ah>
  {
    c(ab.a<R> parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.g.c.ab
 * JD-Core Version:    0.7.0.1
 */