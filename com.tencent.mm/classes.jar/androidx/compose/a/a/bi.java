package androidx.compose.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/animation/core/VectorizedTweenSpec;", "V", "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/animation/core/VectorizedDurationBasedAnimationSpec;", "durationMillis", "", "delayMillis", "easing", "Landroidx/compose/animation/core/Easing;", "(IILandroidx/compose/animation/core/Easing;)V", "anim", "Landroidx/compose/animation/core/VectorizedFloatAnimationSpec;", "getDelayMillis", "()I", "getDurationMillis", "getEasing", "()Landroidx/compose/animation/core/Easing;", "getValueFromNanos", "playTimeNanos", "", "initialValue", "targetValue", "initialVelocity", "(JLandroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)Landroidx/compose/animation/core/AnimationVector;", "getVelocityFromNanos", "animation-core_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bi<V extends k>
  implements bc<V>
{
  public static final int Ue = 8;
  private final y Va;
  private final int WN;
  private final int XE;
  private final be<V> XF;
  
  public bi(int paramInt1, int paramInt2, y paramy)
  {
    AppMethodBeat.i(203313);
    this.WN = paramInt1;
    this.XE = paramInt2;
    this.Va = paramy;
    this.XF = new be((ab)new ae(this.WN, this.XE, this.Va));
    AppMethodBeat.o(203313);
  }
  
  public final long a(V paramV1, V paramV2, V paramV3)
  {
    AppMethodBeat.i(203357);
    s.u(this, "this");
    s.u(paramV1, "initialValue");
    s.u(paramV2, "targetValue");
    s.u(paramV3, "initialVelocity");
    long l = mg() + mf();
    AppMethodBeat.o(203357);
    return l * 1000000L;
  }
  
  public final V a(long paramLong, V paramV1, V paramV2, V paramV3)
  {
    AppMethodBeat.i(203348);
    s.u(paramV1, "initialValue");
    s.u(paramV2, "targetValue");
    s.u(paramV3, "initialVelocity");
    paramV1 = this.XF.a(paramLong, paramV1, paramV2, paramV3);
    AppMethodBeat.o(203348);
    return paramV1;
  }
  
  public final V b(long paramLong, V paramV1, V paramV2, V paramV3)
  {
    AppMethodBeat.i(203351);
    s.u(paramV1, "initialValue");
    s.u(paramV2, "targetValue");
    s.u(paramV3, "initialVelocity");
    paramV1 = this.XF.b(paramLong, paramV1, paramV2, paramV3);
    AppMethodBeat.o(203351);
    return paramV1;
  }
  
  public final V b(V paramV1, V paramV2, V paramV3)
  {
    AppMethodBeat.i(203368);
    Object localObject = (bc)this;
    s.u(localObject, "this");
    s.u(paramV1, "initialValue");
    s.u(paramV2, "targetValue");
    s.u(paramV3, "initialVelocity");
    localObject = (bd)localObject;
    s.u(localObject, "this");
    s.u(paramV1, "initialValue");
    s.u(paramV2, "targetValue");
    s.u(paramV3, "initialVelocity");
    paramV1 = az.a.a((az)localObject, paramV1, paramV2, paramV3);
    AppMethodBeat.o(203368);
    return paramV1;
  }
  
  public final boolean lF()
  {
    AppMethodBeat.i(203378);
    bc localbc = (bc)this;
    s.u(localbc, "this");
    s.u((bd)localbc, "this");
    AppMethodBeat.o(203378);
    return false;
  }
  
  public final int mf()
  {
    return this.WN;
  }
  
  public final int mg()
  {
    return this.XE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.a.a.bi
 * JD-Core Version:    0.7.0.1
 */