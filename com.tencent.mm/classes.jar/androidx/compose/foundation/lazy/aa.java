package androidx.compose.foundation.lazy;

import androidx.compose.foundation.b.e;
import androidx.compose.foundation.o;
import androidx.compose.runtime.an;
import androidx.compose.runtime.bj;
import androidx.compose.runtime.e.i;
import androidx.compose.ui.f.c;
import androidx.compose.ui.f.c.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Landroidx/compose/foundation/lazy/LazyListState;", "Landroidx/compose/foundation/gestures/ScrollableState;", "firstVisibleItemIndex", "", "firstVisibleItemScrollOffset", "(II)V", "canScrollBackward", "", "canScrollForward", "density", "Landroidx/compose/ui/unit/Density;", "getDensity$foundation_release", "()Landroidx/compose/ui/unit/Density;", "setDensity$foundation_release", "(Landroidx/compose/ui/unit/Density;)V", "getFirstVisibleItemIndex", "()I", "firstVisibleItemIndexNonObservable", "Landroidx/compose/foundation/lazy/DataIndex;", "getFirstVisibleItemIndexNonObservable-jQJCoq8$foundation_release", "getFirstVisibleItemScrollOffset", "firstVisibleItemScrollOffsetNonObservable", "getFirstVisibleItemScrollOffsetNonObservable$foundation_release", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "getInteractionSource", "()Landroidx/compose/foundation/interaction/InteractionSource;", "internalInteractionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "getInternalInteractionSource$foundation_release", "()Landroidx/compose/foundation/interaction/MutableInteractionSource;", "isScrollInProgress", "()Z", "layoutInfo", "Landroidx/compose/foundation/lazy/LazyListLayoutInfo;", "getLayoutInfo", "()Landroidx/compose/foundation/lazy/LazyListLayoutInfo;", "layoutInfoState", "Landroidx/compose/runtime/MutableState;", "<set-?>", "numMeasurePasses", "getNumMeasurePasses$foundation_release", "onPostMeasureListener", "Landroidx/compose/foundation/lazy/LazyListOnPostMeasureListener;", "getOnPostMeasureListener$foundation_release", "()Landroidx/compose/foundation/lazy/LazyListOnPostMeasureListener;", "setOnPostMeasureListener$foundation_release", "(Landroidx/compose/foundation/lazy/LazyListOnPostMeasureListener;)V", "onScrolledListener", "Landroidx/compose/foundation/lazy/LazyListOnScrolledListener;", "getOnScrolledListener$foundation_release", "()Landroidx/compose/foundation/lazy/LazyListOnScrolledListener;", "setOnScrolledListener$foundation_release", "(Landroidx/compose/foundation/lazy/LazyListOnScrolledListener;)V", "prefetchingEnabled", "getPrefetchingEnabled$foundation_release", "setPrefetchingEnabled$foundation_release", "(Z)V", "remeasurement", "Landroidx/compose/ui/layout/Remeasurement;", "getRemeasurement$foundation_release", "()Landroidx/compose/ui/layout/Remeasurement;", "setRemeasurement$foundation_release", "(Landroidx/compose/ui/layout/Remeasurement;)V", "remeasurementModifier", "Landroidx/compose/ui/layout/RemeasurementModifier;", "getRemeasurementModifier$foundation_release", "()Landroidx/compose/ui/layout/RemeasurementModifier;", "scrollPosition", "Landroidx/compose/foundation/lazy/LazyListScrollPosition;", "", "scrollToBeConsumed", "getScrollToBeConsumed$foundation_release", "()F", "scrollableState", "visibleItemsCount", "getVisibleItemsCount$foundation_release", "setVisibleItemsCount$foundation_release", "(I)V", "animateScrollToItem", "", "index", "scrollOffset", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "applyMeasureResult", "result", "Landroidx/compose/foundation/lazy/LazyListMeasureResult;", "applyMeasureResult$foundation_release", "dispatchRawDelta", "delta", "onScroll", "distance", "onScroll$foundation_release", "scroll", "scrollPriority", "Landroidx/compose/foundation/MutatePriority;", "block", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/ScrollScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "scrollToItem", "snapToItemIndexInternal", "snapToItemIndexInternal$foundation_release", "updateScrollPositionIfTheFirstItemWasMoved", "itemsProvider", "Landroidx/compose/foundation/lazy/LazyListItemsProvider;", "updateScrollPositionIfTheFirstItemWasMoved$foundation_release", "Companion", "foundation_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class aa
  implements androidx.compose.foundation.a.s
{
  private static final i<aa, ?> ZG;
  public static final aa.a afR;
  androidx.compose.ui.n.d TD;
  final e ZC;
  private final androidx.compose.foundation.a.s ZF;
  public final y afS;
  final an<p> afT;
  float afU;
  int afV;
  public androidx.compose.ui.h.z afW;
  int afX;
  boolean afY;
  final androidx.compose.ui.h.aa afZ;
  boolean afa;
  t aga;
  s agb;
  boolean agc;
  
  static
  {
    AppMethodBeat.i(204310);
    afR = new aa.a((byte)0);
    ZG = androidx.compose.runtime.e.a.a((m)b.agd, (kotlin.g.a.b)c.agf);
    AppMethodBeat.o(204310);
  }
  
  public aa()
  {
    this(0, 3, (byte)0);
  }
  
  public aa(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(204285);
    this.afS = new y(paramInt1, paramInt2);
    this.afT = bj.T(b.ael);
    this.ZC = androidx.compose.foundation.b.d.ms();
    this.TD = androidx.compose.ui.n.f.H(1.0F, 1.0F);
    this.ZF = androidx.compose.foundation.a.t.d((kotlin.g.a.b)new f(this));
    this.afY = true;
    this.afZ = ((androidx.compose.ui.h.aa)new d(this));
    AppMethodBeat.o(204285);
  }
  
  public final void F(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(204329);
    this.afS.D(paramInt1, paramInt2);
    mR().wZ();
    AppMethodBeat.o(204329);
  }
  
  public final Object a(int paramInt1, int paramInt2, kotlin.d.d<? super ah> paramd)
  {
    AppMethodBeat.i(204350);
    paramd = z.a(this, paramInt1, paramInt2, paramd);
    if (paramd == kotlin.d.a.a.aiwj)
    {
      AppMethodBeat.o(204350);
      return paramd;
    }
    paramd = ah.aiuX;
    AppMethodBeat.o(204350);
    return paramd;
  }
  
  public final Object a(o paramo, m<? super androidx.compose.foundation.a.p, ? super kotlin.d.d<? super ah>, ? extends Object> paramm, kotlin.d.d<? super ah> paramd)
  {
    AppMethodBeat.i(204332);
    paramo = this.ZF.a(paramo, paramm, paramd);
    if (paramo == kotlin.d.a.a.aiwj)
    {
      AppMethodBeat.o(204332);
      return paramo;
    }
    paramo = ah.aiuX;
    AppMethodBeat.o(204332);
    return paramo;
  }
  
  public final void b(n paramn)
  {
    AppMethodBeat.i(204356);
    kotlin.g.b.s.u(paramn, "itemsProvider");
    this.afS.a(paramn);
    AppMethodBeat.o(204356);
  }
  
  public final p mQ()
  {
    AppMethodBeat.i(204317);
    p localp = (p)this.afT.getValue();
    AppMethodBeat.o(204317);
    return localp;
  }
  
  public final androidx.compose.ui.h.z mR()
  {
    AppMethodBeat.i(204323);
    androidx.compose.ui.h.z localz = this.afW;
    if (localz != null)
    {
      AppMethodBeat.o(204323);
      return localz;
    }
    kotlin.g.b.s.bIx("remeasurement");
    AppMethodBeat.o(204323);
    return null;
  }
  
  public final boolean ml()
  {
    AppMethodBeat.i(204344);
    boolean bool = this.ZF.ml();
    AppMethodBeat.o(204344);
    return bool;
  }
  
  public final float s(float paramFloat)
  {
    AppMethodBeat.i(204338);
    paramFloat = this.ZF.s(paramFloat);
    AppMethodBeat.o(204338);
    return paramFloat;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "", "Landroidx/compose/runtime/saveable/SaverScope;", "it", "Landroidx/compose/foundation/lazy/LazyListState;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements m<androidx.compose.runtime.e.k, aa, List<? extends Integer>>
  {
    public static final b agd;
    
    static
    {
      AppMethodBeat.i(204308);
      agd = new b();
      AppMethodBeat.o(204308);
    }
    
    b()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/compose/foundation/lazy/LazyListState;", "it", "", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.b<List<? extends Integer>, aa>
  {
    public static final c agf;
    
    static
    {
      AppMethodBeat.i(204309);
      agf = new c();
      AppMethodBeat.o(204309);
    }
    
    c()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"androidx/compose/foundation/lazy/LazyListState$remeasurementModifier$1", "Landroidx/compose/ui/layout/RemeasurementModifier;", "onRemeasurementAvailable", "", "remeasurement", "Landroidx/compose/ui/layout/Remeasurement;", "foundation_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements androidx.compose.ui.h.aa
  {
    d(aa paramaa) {}
    
    public final androidx.compose.ui.f a(androidx.compose.ui.f paramf)
    {
      AppMethodBeat.i(204355);
      androidx.compose.ui.h.aa localaa = (androidx.compose.ui.h.aa)this;
      kotlin.g.b.s.u(localaa, "this");
      kotlin.g.b.s.u(paramf, "other");
      paramf = f.c.a.a((f.c)localaa, paramf);
      AppMethodBeat.o(204355);
      return paramf;
    }
    
    public final <R> R a(R paramR, m<? super R, ? super f.c, ? extends R> paramm)
    {
      AppMethodBeat.i(204327);
      androidx.compose.ui.h.aa localaa = (androidx.compose.ui.h.aa)this;
      kotlin.g.b.s.u(localaa, "this");
      kotlin.g.b.s.u(paramm, "operation");
      paramR = f.c.a.a((f.c)localaa, paramR, paramm);
      AppMethodBeat.o(204327);
      return paramR;
    }
    
    public final void a(androidx.compose.ui.h.z paramz)
    {
      AppMethodBeat.i(204318);
      kotlin.g.b.s.u(paramz, "remeasurement");
      aa localaa = this.agg;
      kotlin.g.b.s.u(paramz, "<set-?>");
      localaa.afW = paramz;
      AppMethodBeat.o(204318);
    }
    
    public final boolean a(kotlin.g.a.b<? super f.c, Boolean> paramb)
    {
      AppMethodBeat.i(204346);
      androidx.compose.ui.h.aa localaa = (androidx.compose.ui.h.aa)this;
      kotlin.g.b.s.u(localaa, "this");
      kotlin.g.b.s.u(paramb, "predicate");
      boolean bool = f.c.a.a((f.c)localaa, paramb);
      AppMethodBeat.o(204346);
      return bool;
    }
    
    public final <R> R b(R paramR, m<? super f.c, ? super R, ? extends R> paramm)
    {
      AppMethodBeat.i(204335);
      androidx.compose.ui.h.aa localaa = (androidx.compose.ui.h.aa)this;
      kotlin.g.b.s.u(localaa, "this");
      kotlin.g.b.s.u(paramm, "operation");
      paramR = f.c.a.b((f.c)localaa, paramR, paramm);
      AppMethodBeat.o(204335);
      return paramR;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Landroidx/compose/foundation/gestures/ScrollScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends kotlin.d.b.a.k
    implements m<androidx.compose.foundation.a.p, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    e(aa paramaa, int paramInt1, int paramInt2, kotlin.d.d<? super e> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(204312);
      paramObject = (kotlin.d.d)new e(this.agg, this.afA, this.afK, paramd);
      AppMethodBeat.o(204312);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(204304);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(204304);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      this.agg.F(this.afA, this.afK);
      paramObject = ah.aiuX;
      AppMethodBeat.o(204304);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.b<Float, Float>
  {
    f(aa paramaa)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.foundation.lazy.aa
 * JD-Core Version:    0.7.0.1
 */