package androidx.compose.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.k.k;

@Metadata(d1={""}, d2={"Landroidx/compose/animation/core/FloatTweenSpec;", "Landroidx/compose/animation/core/FloatAnimationSpec;", "duration", "", "delay", "easing", "Landroidx/compose/animation/core/Easing;", "(IILandroidx/compose/animation/core/Easing;)V", "getDelay", "()I", "getDuration", "clampPlayTime", "", "playTime", "getDurationNanos", "initialValue", "", "targetValue", "initialVelocity", "getValueFromNanos", "playTimeNanos", "getVelocityFromNanos", "animation-core_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ae
  implements ab
{
  private final int UZ;
  private final y Va;
  private final int duration;
  
  public ae(int paramInt1, int paramInt2, y paramy)
  {
    AppMethodBeat.i(203414);
    this.duration = paramInt1;
    this.UZ = paramInt2;
    this.Va = paramy;
    AppMethodBeat.o(203414);
  }
  
  private final long n(long paramLong)
  {
    AppMethodBeat.i(203432);
    paramLong = k.B(paramLong - this.UZ, 0L, this.duration);
    AppMethodBeat.o(203432);
    return paramLong;
  }
  
  public final float a(long paramLong, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(203443);
    paramLong = n(paramLong / 1000000L);
    if (this.duration == 0) {}
    for (paramFloat3 = 1.0F;; paramFloat3 = (float)paramLong / this.duration)
    {
      paramFloat1 = ay.lerp(paramFloat1, paramFloat2, this.Va.r(k.C(paramFloat3, 0.0F, 1.0F)));
      AppMethodBeat.o(203443);
      return paramFloat1;
    }
  }
  
  public final float b(long paramLong, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(203459);
    paramLong = n(paramLong / 1000000L);
    if (paramLong < 0L)
    {
      AppMethodBeat.o(203459);
      return 0.0F;
    }
    if (paramLong == 0L)
    {
      AppMethodBeat.o(203459);
      return paramFloat3;
    }
    float f = a(1000000L * (paramLong - 1L), paramFloat1, paramFloat2, paramFloat3);
    paramFloat1 = a(1000000L * paramLong, paramFloat1, paramFloat2, paramFloat3);
    AppMethodBeat.o(203459);
    return (paramFloat1 - f) * 1000.0F;
  }
  
  public final float d(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(203466);
    s.u(this, "this");
    paramFloat1 = b(e(paramFloat1, paramFloat2, paramFloat3), paramFloat1, paramFloat2, paramFloat3);
    AppMethodBeat.o(203466);
    return paramFloat1;
  }
  
  public final long e(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return (this.UZ + this.duration) * 1000000L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.a.a.ae
 * JD-Core Version:    0.7.0.1
 */