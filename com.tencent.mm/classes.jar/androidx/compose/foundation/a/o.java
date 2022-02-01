package androidx.compose.foundation.a;

import androidx.compose.a.a.ar;
import androidx.compose.a.a.ar.a;
import androidx.compose.a.a.as;
import androidx.compose.a.a.aw;
import androidx.compose.a.a.ay;
import androidx.compose.a.a.c;
import androidx.compose.a.a.g;
import androidx.compose.a.a.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.d<-Ljava.lang.Float;>;
import kotlin.g.a.b;
import kotlin.g.b.ah.c;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"animateScrollBy", "", "Landroidx/compose/foundation/gestures/ScrollableState;", "value", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "(Landroidx/compose/foundation/gestures/ScrollableState;FLandroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "scrollBy", "(Landroidx/compose/foundation/gestures/ScrollableState;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stopScroll", "", "scrollPriority", "Landroidx/compose/foundation/MutatePriority;", "(Landroidx/compose/foundation/gestures/ScrollableState;Landroidx/compose/foundation/MutatePriority;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class o
{
  public static final Object a(s params, float paramFloat, final g<Float> paramg, kotlin.d.d<? super Float> paramd)
  {
    AppMethodBeat.i(204176);
    if ((paramd instanceof a))
    {
      localObject = (a)paramd;
      if ((((a)localObject).label & 0x80000000) != 0) {
        ((a)localObject).label += -2147483648;
      }
    }
    a locala;
    for (paramd = (kotlin.d.d<? super Float>)localObject;; paramd = new a(paramd))
    {
      localObject = paramd.result;
      locala = a.aiwj;
      switch (paramd.label)
      {
      default: 
        params = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(204176);
        throw params;
      }
    }
    ResultKt.throwOnFailure(localObject);
    Object localObject = new ah.c();
    paramg = (kotlin.g.a.m)new b(paramFloat, paramg, (ah.c)localObject, null);
    paramd.L$0 = localObject;
    paramd.label = 1;
    if (s.a.a(params, paramg, paramd) == locala)
    {
      AppMethodBeat.o(204176);
      return locala;
      params = (ah.c)paramd.L$0;
      ResultKt.throwOnFailure(localObject);
    }
    for (;;)
    {
      paramFloat = params.aixa;
      AppMethodBeat.o(204176);
      return Float.valueOf(paramFloat);
      params = (s)localObject;
    }
  }
  
  public static final Object a(s params, final float paramFloat, kotlin.d.d<? super Float> paramd)
  {
    AppMethodBeat.i(204186);
    if ((paramd instanceof c))
    {
      localObject = (c)paramd;
      if ((((c)localObject).label & 0x80000000) != 0) {
        ((c)localObject).label += -2147483648;
      }
    }
    a locala;
    for (paramd = (kotlin.d.d<? super Float>)localObject;; paramd = new c(paramd))
    {
      localObject = paramd.result;
      locala = a.aiwj;
      switch (paramd.label)
      {
      default: 
        params = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(204186);
        throw params;
      }
    }
    ResultKt.throwOnFailure(localObject);
    Object localObject = new ah.c();
    kotlin.g.a.m localm = (kotlin.g.a.m)new d((ah.c)localObject, paramFloat, null);
    paramd.L$0 = localObject;
    paramd.label = 1;
    if (s.a.a(params, localm, paramd) == locala)
    {
      AppMethodBeat.o(204186);
      return locala;
      params = (ah.c)paramd.L$0;
      ResultKt.throwOnFailure(localObject);
    }
    for (;;)
    {
      paramFloat = params.aixa;
      AppMethodBeat.o(204186);
      return Float.valueOf(paramFloat);
      params = (s)localObject;
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends kotlin.d.b.a.d
  {
    Object L$0;
    int label;
    
    a(kotlin.d.d<? super a> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(204098);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = o.a(null, 0.0F, null, (kotlin.d.d)this);
      AppMethodBeat.o(204098);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Landroidx/compose/foundation/gestures/ScrollScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.d.b.a.k
    implements kotlin.g.a.m<p, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    b(float paramFloat, g<Float> paramg, ah.c paramc, kotlin.d.d<? super b> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(204106);
      paramd = new b(this.abb, paramg, this.abd, paramd);
      paramd.L$0 = paramObject;
      paramObject = (kotlin.d.d)paramd;
      AppMethodBeat.o(204106);
      return paramObject;
    }
    
    public final Object invokeSuspend(final Object paramObject)
    {
      AppMethodBeat.i(204099);
      a locala = a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(204099);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = (p)this.L$0;
        float f = this.abb;
        g localg = paramg;
        kotlin.g.a.m localm = (kotlin.g.a.m)new u(this.abd) {};
        kotlin.d.d locald = (kotlin.d.d)this;
        this.label = 1;
        aw localaw = ay.a(kotlin.g.b.m.aiwV);
        Float localFloat = Float.valueOf(0.0F);
        paramObject = Float.valueOf(0.0F);
        if (paramObject == null) {}
        for (paramObject = null;; paramObject = (androidx.compose.a.a.k)localaw.md().invoke(paramObject))
        {
          Object localObject = paramObject;
          if (paramObject == null) {
            localObject = androidx.compose.a.a.o.b((androidx.compose.a.a.k)localaw.md().invoke(localFloat));
          }
          paramObject = new as(localg, localaw, localFloat, Float.valueOf(f), (androidx.compose.a.a.k)localObject);
          localObject = ar.a(new i(localaw, localFloat, (androidx.compose.a.a.k)localObject, 0L, 0L, 56), (c)paramObject, -9223372036854775808L, (b)new ar.a(localm, localaw), locald);
          paramObject = localObject;
          if (localObject != a.aiwj) {
            paramObject = ah.aiuX;
          }
          localObject = paramObject;
          if (paramObject != a.aiwj) {
            localObject = ah.aiuX;
          }
          if (localObject != locala) {
            break;
          }
          AppMethodBeat.o(204099);
          return locala;
        }
      }
      ResultKt.throwOnFailure(paramObject);
      paramObject = ah.aiuX;
      AppMethodBeat.o(204099);
      return paramObject;
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.d.b.a.d
  {
    Object L$0;
    int label;
    
    c(kotlin.d.d<? super c> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(204107);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = o.a(null, 0.0F, (kotlin.d.d)this);
      AppMethodBeat.o(204107);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Landroidx/compose/foundation/gestures/ScrollScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends kotlin.d.b.a.k
    implements kotlin.g.a.m<p, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    d(ah.c paramc, float paramFloat, kotlin.d.d<? super d> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(204102);
      paramd = new d(this.abf, paramFloat, paramd);
      paramd.L$0 = paramObject;
      paramObject = (kotlin.d.d)paramd;
      AppMethodBeat.o(204102);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(204095);
      a locala = a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(204095);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      paramObject = (p)this.L$0;
      this.abf.aixa = paramObject.t(paramFloat);
      paramObject = ah.aiuX;
      AppMethodBeat.o(204095);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.foundation.a.o
 * JD-Core Version:    0.7.0.1
 */