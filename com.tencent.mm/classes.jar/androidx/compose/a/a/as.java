package androidx.compose.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.a.b;

@Metadata(d1={""}, d2={"Landroidx/compose/animation/core/TargetBasedAnimation;", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/animation/core/Animation;", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "typeConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "initialValue", "targetValue", "initialVelocityVector", "(Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/animation/core/AnimationVector;)V", "Landroidx/compose/animation/core/VectorizedAnimationSpec;", "(Landroidx/compose/animation/core/VectorizedAnimationSpec;Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/animation/core/AnimationVector;)V", "getAnimationSpec$animation_core_release", "()Landroidx/compose/animation/core/VectorizedAnimationSpec;", "durationNanos", "", "getDurationNanos", "()J", "endVelocity", "Landroidx/compose/animation/core/AnimationVector;", "getInitialValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "initialValueVector", "isInfinite", "", "()Z", "getTargetValue", "targetValueVector", "getTypeConverter", "()Landroidx/compose/animation/core/TwoWayConverter;", "getValueFromNanos", "playTimeNanos", "(J)Ljava/lang/Object;", "getVelocityVectorFromNanos", "(J)Landroidx/compose/animation/core/AnimationVector;", "animation-core_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class as<T, V extends k>
  implements c<T, V>
{
  private final aw<T, V> TT;
  final T UH;
  private final V UJ;
  private final V UK;
  private final V UL;
  final long UM;
  final T Us;
  private final az<V> Wb;
  private final V Wc;
  
  private as(az<V> paramaz, aw<T, V> paramaw, T paramT1, T paramT2, V paramV)
  {
    AppMethodBeat.i(203335);
    this.Wb = paramaz;
    this.TT = paramaw;
    this.UH = paramT1;
    this.Us = paramT2;
    this.UJ = ((k)this.TT.md().invoke(this.UH));
    this.Wc = ((k)this.TT.md().invoke(this.Us));
    if (paramV == null) {}
    for (paramaz = null;; paramaz = o.c(paramV))
    {
      paramaw = paramaz;
      if (paramaz == null) {
        paramaw = o.b((k)this.TT.md().invoke(this.UH));
      }
      this.UK = paramaw;
      this.UM = this.Wb.a(this.UJ, this.Wc, this.UK);
      this.UL = this.Wb.b(this.UJ, this.Wc, this.UK);
      AppMethodBeat.o(203335);
      return;
    }
  }
  
  public as(g<T> paramg, aw<T, V> paramaw, T paramT1, T paramT2, V paramV)
  {
    this(paramg.a(paramaw), paramaw, paramT1, paramT2, paramV);
    AppMethodBeat.i(203341);
    AppMethodBeat.o(203341);
  }
  
  public final T k(long paramLong)
  {
    AppMethodBeat.i(203358);
    if (!c.a.a(this, paramLong))
    {
      localObject = this.TT.me().invoke(this.Wb.a(paramLong, this.UJ, this.Wc, this.UK));
      AppMethodBeat.o(203358);
      return localObject;
    }
    Object localObject = this.Us;
    AppMethodBeat.o(203358);
    return localObject;
  }
  
  public final V l(long paramLong)
  {
    AppMethodBeat.i(203369);
    if (!c.a.a(this, paramLong))
    {
      localk = this.Wb.b(paramLong, this.UJ, this.Wc, this.UK);
      AppMethodBeat.o(203369);
      return localk;
    }
    k localk = this.UL;
    AppMethodBeat.o(203369);
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
    AppMethodBeat.i(203354);
    boolean bool = this.Wb.lF();
    AppMethodBeat.o(203354);
    return bool;
  }
  
  public final boolean m(long paramLong)
  {
    AppMethodBeat.i(369513);
    boolean bool = c.a.a(this, paramLong);
    AppMethodBeat.o(369513);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.a.a.as
 * JD-Core Version:    0.7.0.1
 */