package androidx.compose.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.a.b;

@Metadata(d1={""}, d2={"Landroidx/compose/animation/core/DecayAnimation;", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/animation/core/Animation;", "animationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "typeConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "initialValue", "initialVelocityVector", "(Landroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/Object;Landroidx/compose/animation/core/AnimationVector;)V", "initialVelocity", "(Landroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/Object;Ljava/lang/Object;)V", "Landroidx/compose/animation/core/VectorizedDecayAnimationSpec;", "(Landroidx/compose/animation/core/VectorizedDecayAnimationSpec;Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/Object;Landroidx/compose/animation/core/AnimationVector;)V", "durationNanos", "", "getDurationNanos", "()J", "endVelocity", "Landroidx/compose/animation/core/AnimationVector;", "getInitialValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "initialValueVector", "getInitialVelocityVector", "()Landroidx/compose/animation/core/AnimationVector;", "isInfinite", "", "()Z", "targetValue", "getTargetValue", "getTypeConverter", "()Landroidx/compose/animation/core/TwoWayConverter;", "getValueFromNanos", "playTimeNanos", "(J)Ljava/lang/Object;", "getVelocityVectorFromNanos", "(J)Landroidx/compose/animation/core/AnimationVector;", "animation-core_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class t<T, V extends k>
  implements c<T, V>
{
  private final aw<T, V> TT;
  private final bb<V> UG;
  private final T UH;
  private final V UJ;
  private final V UK;
  private final V UL;
  private final long UM;
  private final boolean UN;
  private final T Us;
  
  private t(bb<V> parambb, aw<T, V> paramaw, T paramT, V paramV)
  {
    AppMethodBeat.i(203298);
    this.UG = parambb;
    this.TT = paramaw;
    this.UH = paramT;
    this.UJ = ((k)this.TT.md().invoke(this.UH));
    this.UK = o.c(paramV);
    this.Us = this.TT.me().invoke(this.UG.c(this.UJ, paramV));
    this.UM = this.UG.b(this.UJ, paramV);
    this.UL = o.c(this.UG.b(this.UM, this.UJ, paramV));
    int i = 0;
    int k = this.UL.lK();
    if (k > 0) {}
    for (;;)
    {
      int j = i + 1;
      parambb = this.UL;
      parambb.e(i, kotlin.k.k.C(parambb.bq(i), -this.UG.lz(), this.UG.lz()));
      if (j >= k)
      {
        AppMethodBeat.o(203298);
        return;
      }
      i = j;
    }
  }
  
  public t(u<T> paramu, aw<T, V> paramaw, T paramT, V paramV)
  {
    this(paramu.b(paramaw), paramaw, paramT, paramV);
    AppMethodBeat.i(203304);
    AppMethodBeat.o(203304);
  }
  
  public final T k(long paramLong)
  {
    AppMethodBeat.i(203328);
    if (!c.a.a(this, paramLong))
    {
      localObject = this.TT.me().invoke(this.UG.a(paramLong, this.UJ, this.UK));
      AppMethodBeat.o(203328);
      return localObject;
    }
    Object localObject = this.Us;
    AppMethodBeat.o(203328);
    return localObject;
  }
  
  public final V l(long paramLong)
  {
    AppMethodBeat.i(203333);
    if (!c.a.a(this, paramLong))
    {
      localk = this.UG.b(paramLong, this.UJ, this.UK);
      AppMethodBeat.o(203333);
      return localk;
    }
    k localk = this.UL;
    AppMethodBeat.o(203333);
    return localk;
  }
  
  public final long lC()
  {
    return this.UM;
  }
  
  public final aw<T, V> lD()
  {
    return this.TT;
  }
  
  public final T lE()
  {
    return this.Us;
  }
  
  public final boolean lF()
  {
    return this.UN;
  }
  
  public final boolean m(long paramLong)
  {
    AppMethodBeat.i(369512);
    boolean bool = c.a.a(this, paramLong);
    AppMethodBeat.o(369512);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.a.a.t
 * JD-Core Version:    0.7.0.1
 */