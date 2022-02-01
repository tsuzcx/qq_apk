package androidx.compose.foundation.a;

import androidx.compose.a.a.ar;
import androidx.compose.a.a.f;
import androidx.compose.a.a.j;
import androidx.compose.a.a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.d<-Ljava.lang.Float;>;
import kotlin.g.a.b;
import kotlin.g.b.ah.c;

@Metadata(d1={""}, d2={"Landroidx/compose/foundation/gestures/DefaultFlingBehavior;", "Landroidx/compose/foundation/gestures/FlingBehavior;", "flingDecay", "Landroidx/compose/animation/core/DecayAnimationSpec;", "", "(Landroidx/compose/animation/core/DecayAnimationSpec;)V", "performFling", "Landroidx/compose/foundation/gestures/ScrollScope;", "initialVelocity", "(Landroidx/compose/foundation/gestures/ScrollScope;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k=1, mv={1, 5, 1}, xi=48)
final class a
  implements i
{
  private final androidx.compose.a.a.u<Float> ZO;
  
  public a(androidx.compose.a.a.u<Float> paramu)
  {
    AppMethodBeat.i(204092);
    this.ZO = paramu;
    AppMethodBeat.o(204092);
  }
  
  public final Object a(final p paramp, float paramFloat, kotlin.d.d<? super Float> paramd)
  {
    AppMethodBeat.i(204103);
    Object localObject;
    if ((paramd instanceof a))
    {
      localObject = (a)paramd;
      if ((((a)localObject).label & 0x80000000) != 0) {
        ((a)localObject).label += -2147483648;
      }
    }
    kotlin.d.a.a locala;
    for (paramd = (kotlin.d.d<? super Float>)localObject;; paramd = new a(this, paramd))
    {
      localObject = paramd.result;
      locala = kotlin.d.a.a.aiwj;
      switch (paramd.label)
      {
      default: 
        paramp = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(204103);
        throw paramp;
      }
    }
    ResultKt.throwOnFailure(localObject);
    float f = paramFloat;
    if (Math.abs(paramFloat) > 1.0F)
    {
      localObject = new ah.c();
      ((ah.c)localObject).aixa = paramFloat;
      ah.c localc = new ah.c();
      androidx.compose.a.a.i locali = j.s(0.0F, paramFloat);
      androidx.compose.a.a.u localu = this.ZO;
      paramp = (b)new b(localc, paramp, (ah.c)localObject);
      paramd.L$0 = localObject;
      paramd.label = 1;
      if (ar.a(locali, localu, paramp, paramd) != locala) {
        break label247;
      }
      AppMethodBeat.o(204103);
      return locala;
      paramp = (ah.c)paramd.L$0;
      ResultKt.throwOnFailure(localObject);
    }
    for (;;)
    {
      f = paramp.aixa;
      AppMethodBeat.o(204103);
      return Float.valueOf(f);
      label247:
      paramp = (p)localObject;
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends kotlin.d.b.a.d
  {
    Object L$0;
    int label;
    
    a(a parama, kotlin.d.d<? super a> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(204097);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.ZP.a(null, 0.0F, (kotlin.d.d)this);
      AppMethodBeat.o(204097);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Landroidx/compose/animation/core/AnimationScope;", "", "Landroidx/compose/animation/core/AnimationVector1D;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.g.b.u
    implements b<f<Float, l>, ah>
  {
    b(ah.c paramc1, p paramp, ah.c paramc2)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.foundation.a.a
 * JD-Core Version:    0.7.0.1
 */