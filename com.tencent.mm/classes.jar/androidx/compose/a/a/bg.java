package androidx.compose.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/animation/core/VectorizedInfiniteRepeatableSpec;", "V", "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/animation/core/VectorizedAnimationSpec;", "animation", "Landroidx/compose/animation/core/VectorizedDurationBasedAnimationSpec;", "repeatMode", "Landroidx/compose/animation/core/RepeatMode;", "(Landroidx/compose/animation/core/VectorizedDurationBasedAnimationSpec;Landroidx/compose/animation/core/RepeatMode;)V", "durationNanos", "", "getDurationNanos$animation_core_release", "()J", "isInfinite", "", "()Z", "getDurationNanos", "initialValue", "targetValue", "initialVelocity", "(Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)J", "getValueFromNanos", "playTimeNanos", "(JLandroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)Landroidx/compose/animation/core/AnimationVector;", "getVelocityFromNanos", "repetitionPlayTimeNanos", "repetitionStartVelocity", "start", "startVelocity", "end", "animation-core_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bg<V extends k>
  implements az<V>
{
  public static final int Ue = 8;
  private final long UM;
  private final am Vd;
  private final bc<V> XC;
  
  public bg(bc<V> parambc, am paramam)
  {
    AppMethodBeat.i(203305);
    this.XC = parambc;
    this.Vd = paramam;
    this.UM = ((this.XC.mg() + this.XC.mf()) * 1000000L);
    AppMethodBeat.o(203305);
  }
  
  private final V c(long paramLong, V paramV1, V paramV2, V paramV3)
  {
    AppMethodBeat.i(203315);
    if (paramLong > this.UM)
    {
      paramV1 = b(this.UM, paramV1, paramV2, paramV3);
      AppMethodBeat.o(203315);
      return paramV1;
    }
    AppMethodBeat.o(203315);
    return paramV2;
  }
  
  private final long s(long paramLong)
  {
    long l = paramLong / this.UM;
    if ((this.Vd == am.VG) || (l % 2L == 0L)) {
      return paramLong - l * this.UM;
    }
    return (l + 1L) * this.UM - paramLong;
  }
  
  public final long a(V paramV1, V paramV2, V paramV3)
  {
    AppMethodBeat.i(203339);
    s.u(paramV1, "initialValue");
    s.u(paramV2, "targetValue");
    s.u(paramV3, "initialVelocity");
    AppMethodBeat.o(203339);
    return 9223372036854775807L;
  }
  
  public final V a(long paramLong, V paramV1, V paramV2, V paramV3)
  {
    AppMethodBeat.i(203329);
    s.u(paramV1, "initialValue");
    s.u(paramV2, "targetValue");
    s.u(paramV3, "initialVelocity");
    paramV1 = this.XC.a(s(paramLong), paramV1, paramV2, c(paramLong, paramV1, paramV3, paramV2));
    AppMethodBeat.o(203329);
    return paramV1;
  }
  
  public final V b(long paramLong, V paramV1, V paramV2, V paramV3)
  {
    AppMethodBeat.i(203334);
    s.u(paramV1, "initialValue");
    s.u(paramV2, "targetValue");
    s.u(paramV3, "initialVelocity");
    paramV1 = this.XC.b(s(paramLong), paramV1, paramV2, c(paramLong, paramV1, paramV3, paramV2));
    AppMethodBeat.o(203334);
    return paramV1;
  }
  
  public final V b(V paramV1, V paramV2, V paramV3)
  {
    AppMethodBeat.i(203344);
    paramV1 = az.a.a(this, paramV1, paramV2, paramV3);
    AppMethodBeat.o(203344);
    return paramV1;
  }
  
  public final boolean lF()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.a.a.bg
 * JD-Core Version:    0.7.0.1
 */