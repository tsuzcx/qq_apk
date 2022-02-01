package androidx.compose.foundation.a;

import androidx.compose.a.a.g;
import androidx.compose.a.a.h;
import androidx.compose.runtime.bm;
import androidx.compose.ui.d.e;
import androidx.compose.ui.d.e.a;
import androidx.compose.ui.d.f;
import androidx.compose.ui.n.r;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.d<-Landroidx.compose.ui.n.r;>;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.ah.e;
import kotlinx.coroutines.aq;

@Metadata(d1={""}, d2={"Landroidx/compose/foundation/gestures/ScrollingLogic;", "", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "reverseDirection", "", "nestedScrollDispatcher", "Landroidx/compose/runtime/State;", "Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;", "scrollableState", "Landroidx/compose/foundation/gestures/ScrollableState;", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "(Landroidx/compose/foundation/gestures/Orientation;ZLandroidx/compose/runtime/State;Landroidx/compose/foundation/gestures/ScrollableState;Landroidx/compose/foundation/gestures/FlingBehavior;)V", "getFlingBehavior", "()Landroidx/compose/foundation/gestures/FlingBehavior;", "getNestedScrollDispatcher", "()Landroidx/compose/runtime/State;", "getOrientation", "()Landroidx/compose/foundation/gestures/Orientation;", "getReverseDirection", "()Z", "getScrollableState", "()Landroidx/compose/foundation/gestures/ScrollableState;", "doFlingAnimation", "Landroidx/compose/ui/unit/Velocity;", "available", "doFlingAnimation-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onDragStopped", "", "axisVelocity", "", "(FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "performRawScroll", "Landroidx/compose/ui/geometry/Offset;", "scroll", "performRawScroll-MK-Hz9U", "(J)J", "performRelocationScroll", "performRelocationScroll-MK-Hz9U", "dispatchScroll", "Landroidx/compose/foundation/gestures/ScrollScope;", "scrollDelta", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "dispatchScroll-Tj5QQXo", "(Landroidx/compose/foundation/gestures/ScrollScope;FI)F", "reverseIfNeeded", "toFloat", "toFloat-k-4lQ0M", "(J)F", "toFloat-TH1AsA0", "toOffset", "toOffset-tuRUvjQ", "(F)J", "toVelocity", "toVelocity-adjELrA", "foundation_release"}, k=1, mv={1, 5, 1}, xi=48)
final class u
{
  final s ZF;
  final k abq;
  private final boolean abr;
  final bm<androidx.compose.ui.g.b.d> abs;
  final i abt;
  
  public u(k paramk, boolean paramBoolean, bm<androidx.compose.ui.g.b.d> parambm, s params, i parami)
  {
    AppMethodBeat.i(204168);
    this.abq = paramk;
    this.abr = paramBoolean;
    this.abs = parambm;
    this.ZF = params;
    this.abt = parami;
    AppMethodBeat.o(204168);
  }
  
  public final float A(float paramFloat)
  {
    float f = paramFloat;
    if (this.abr) {
      f = paramFloat * -1.0F;
    }
    return f;
  }
  
  public final float a(p paramp, float paramFloat, int paramInt)
  {
    AppMethodBeat.i(204193);
    kotlin.g.b.s.u(paramp, "$receiver");
    androidx.compose.ui.g.b.d locald = (androidx.compose.ui.g.b.d)this.abs.getValue();
    float f = paramFloat - u(locald.e(y(paramFloat), paramInt));
    paramFloat = A(paramp.t(A(f)));
    f -= paramFloat;
    locald.b(y(paramFloat), y(f), paramInt);
    AppMethodBeat.o(204193);
    return f;
  }
  
  public final Object a(float paramFloat, kotlin.d.d<? super ah> paramd)
  {
    AppMethodBeat.i(204203);
    c localc;
    if ((paramd instanceof c))
    {
      localc = (c)paramd;
      if ((localc.label & 0x80000000) != 0) {
        localc.label += -2147483648;
      }
    }
    a locala;
    for (;;)
    {
      localObject1 = localc.result;
      locala = a.aiwj;
      switch (localc.label)
      {
      default: 
        paramd = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(204203);
        throw paramd;
        localc = new c(this, paramd);
      }
    }
    ResultKt.throwOnFailure(localObject1);
    long l1 = z(paramFloat);
    paramd = (androidx.compose.ui.g.b.d)this.abs.getValue();
    localc.L$0 = this;
    localc.Yx = l1;
    localc.label = 1;
    Object localObject2 = paramd.c(l1, localc);
    Object localObject1 = localObject2;
    paramd = this;
    if (localObject2 == locala)
    {
      AppMethodBeat.o(204203);
      return locala;
      l1 = localc.Yx;
      paramd = (u)localc.L$0;
      ResultKt.throwOnFailure(localObject1);
    }
    l1 = r.t(l1, ((r)localObject1).avp);
    localc.L$0 = paramd;
    localc.Yx = l1;
    localc.label = 2;
    localObject2 = paramd.b(l1, localc);
    localObject1 = localObject2;
    if (localObject2 == locala)
    {
      AppMethodBeat.o(204203);
      return locala;
      l1 = localc.Yx;
      paramd = (u)localc.L$0;
      ResultKt.throwOnFailure(localObject1);
    }
    long l2 = ((r)localObject1).avp;
    paramd = (androidx.compose.ui.g.b.d)paramd.abs.getValue();
    l1 = r.t(l1, l2);
    localc.L$0 = null;
    localc.label = 3;
    if (paramd.b(l1, l2, localc) == locala)
    {
      AppMethodBeat.o(204203);
      return locala;
      ResultKt.throwOnFailure(localObject1);
    }
    paramd = ah.aiuX;
    AppMethodBeat.o(204203);
    return paramd;
  }
  
  public final Object b(final long paramLong, kotlin.d.d<? super r> paramd)
  {
    AppMethodBeat.i(204210);
    if ((paramd instanceof a))
    {
      localObject1 = (a)paramd;
      if ((((a)localObject1).label & 0x80000000) != 0) {
        ((a)localObject1).label += -2147483648;
      }
    }
    a locala;
    for (paramd = (kotlin.d.d<? super r>)localObject1;; paramd = new a(this, paramd))
    {
      localObject2 = paramd.result;
      locala = a.aiwj;
      switch (paramd.label)
      {
      default: 
        paramd = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(204210);
        throw paramd;
      }
    }
    ResultKt.throwOnFailure(localObject2);
    Object localObject1 = new ah.e();
    ((ah.e)localObject1).aixc = paramLong;
    Object localObject2 = this.ZF;
    m localm = (m)new b(this, (ah.e)localObject1, paramLong, null);
    paramd.L$0 = localObject1;
    paramd.label = 1;
    if (s.a.a((s)localObject2, localm, paramd) == locala)
    {
      AppMethodBeat.o(204210);
      return locala;
      localObject1 = (ah.e)paramd.L$0;
      ResultKt.throwOnFailure(localObject2);
    }
    paramd = r.bs(((ah.e)localObject1).aixc);
    AppMethodBeat.o(204210);
    return paramd;
  }
  
  public final float u(long paramLong)
  {
    AppMethodBeat.i(204178);
    if (this.abq == k.aaU)
    {
      f = e.F(paramLong);
      AppMethodBeat.o(204178);
      return f;
    }
    float f = e.G(paramLong);
    AppMethodBeat.o(204178);
    return f;
  }
  
  public final long y(float paramFloat)
  {
    AppMethodBeat.i(204172);
    if (paramFloat == 0.0F) {}
    for (int i = 1; i != 0; i = 0)
    {
      e.a locala = e.avo;
      l = e.su();
      AppMethodBeat.o(204172);
      return l;
    }
    if (this.abq == k.aaU)
    {
      l = f.x(paramFloat, 0.0F);
      AppMethodBeat.o(204172);
      return l;
    }
    long l = f.x(0.0F, paramFloat);
    AppMethodBeat.o(204172);
    return l;
  }
  
  public final long z(float paramFloat)
  {
    AppMethodBeat.i(204174);
    if (this.abq == k.aaU)
    {
      l = androidx.compose.ui.n.s.K(paramFloat, 0.0F);
      AppMethodBeat.o(204174);
      return l;
    }
    long l = androidx.compose.ui.n.s.K(0.0F, paramFloat);
    AppMethodBeat.o(204174);
    return l;
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends kotlin.d.b.a.d
  {
    Object L$0;
    int label;
    
    a(u paramu, kotlin.d.d<? super a> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(204046);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.abu.b(0L, (kotlin.d.d)this);
      AppMethodBeat.o(204046);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Landroidx/compose/foundation/gestures/ScrollScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.d.b.a.k
    implements m<p, kotlin.d.d<? super ah>, Object>
  {
    Object Uf;
    Object VC;
    int label;
    
    b(u paramu, ah.e parame, long paramLong, kotlin.d.d<? super b> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(204057);
      paramd = new b(this.abu, this.abv, paramLong, paramd);
      paramd.L$0 = paramObject;
      paramObject = (kotlin.d.d)paramd;
      AppMethodBeat.o(204057);
      return paramObject;
    }
    
    public final Object invokeSuspend(final Object paramObject)
    {
      AppMethodBeat.i(204048);
      Object localObject1 = a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(204048);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = (p)this.L$0;
        localObject3 = new b((b)new a(this.abu, paramObject));
        paramObject = this.abu;
        locale = this.abv;
        long l = paramLong;
        localObject2 = paramObject.abt;
        localObject3 = (p)localObject3;
        if (paramObject.abq == k.aaU) {}
        for (float f = r.F(l);; f = r.G(l))
        {
          f = paramObject.A(f);
          this.L$0 = paramObject;
          this.Uf = paramObject;
          this.VC = locale;
          this.label = 1;
          localObject3 = ((i)localObject2).a((p)localObject3, f, this);
          if (localObject3 != localObject1) {
            break;
          }
          AppMethodBeat.o(204048);
          return localObject1;
        }
      }
      ah.e locale = (ah.e)this.VC;
      Object localObject3 = (u)this.Uf;
      Object localObject2 = (u)this.L$0;
      ResultKt.throwOnFailure(paramObject);
      localObject1 = paramObject;
      paramObject = localObject3;
      for (;;)
      {
        locale.aixc = paramObject.z(((u)localObject2).A(((Number)localObject1).floatValue()));
        paramObject = ah.aiuX;
        AppMethodBeat.o(204048);
        return paramObject;
        localObject1 = paramObject;
        localObject2 = paramObject;
        paramObject = localObject1;
        localObject1 = localObject3;
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "delta"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends kotlin.g.b.u
      implements b<Float, Float>
    {
      a(u paramu, p paramp)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"androidx/compose/foundation/gestures/ScrollingLogic$doFlingAnimation$2$scope$1", "Landroidx/compose/foundation/gestures/ScrollScope;", "scrollBy", "", "pixels", "foundation_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class b
      implements p
    {
      b(b<? super Float, Float> paramb) {}
      
      public final float t(float paramFloat)
      {
        AppMethodBeat.i(204083);
        paramFloat = ((Number)this.abx.invoke(Float.valueOf(paramFloat))).floatValue();
        AppMethodBeat.o(204083);
        return paramFloat;
      }
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.d.b.a.d
  {
    Object L$0;
    long Yx;
    int label;
    
    c(u paramu, kotlin.d.d<? super c> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(204036);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.abu.a(0.0F, (kotlin.d.d)this);
      AppMethodBeat.o(204036);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    d(u paramu, long paramLong, kotlin.d.d<? super d> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(204051);
      paramObject = (kotlin.d.d)new d(this.abu, this.aby, paramd);
      AppMethodBeat.o(204051);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(204044);
      a locala = a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(204044);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.abu.ZF;
        float f = this.abu.A(this.abu.u(this.aby));
        kotlin.d.d locald = (kotlin.d.d)this;
        this.label = 1;
        if (o.a(paramObject, f, (g)h.a(0.0F, 0.0F, null, 7), locald) == locala)
        {
          AppMethodBeat.o(204044);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = ah.aiuX;
      AppMethodBeat.o(204044);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.foundation.a.u
 * JD-Core Version:    0.7.0.1
 */