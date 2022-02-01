package androidx.compose.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/animation/core/VectorizedSpringSpec;", "V", "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/animation/core/VectorizedFiniteAnimationSpec;", "dampingRatio", "", "stiffness", "visibilityThreshold", "(FFLandroidx/compose/animation/core/AnimationVector;)V", "anims", "Landroidx/compose/animation/core/Animations;", "(FFLandroidx/compose/animation/core/Animations;)V", "getDampingRatio", "()F", "isInfinite", "", "()Z", "getStiffness", "getDurationNanos", "", "initialValue", "targetValue", "initialVelocity", "(Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)J", "getEndVelocity", "(Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)Landroidx/compose/animation/core/AnimationVector;", "getValueFromNanos", "playTimeNanos", "(JLandroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)Landroidx/compose/animation/core/AnimationVector;", "getVelocityFromNanos", "animation-core_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bh<V extends k>
  implements bd<V>
{
  public static final int Ue = 8;
  private final float UV;
  private final float UW;
  
  public bh(float paramFloat1, float paramFloat2, V paramV) {}
  
  private bh(float paramFloat1, float paramFloat2, p paramp)
  {
    AppMethodBeat.i(203312);
    this.UV = paramFloat1;
    this.UW = paramFloat2;
    this.XD = new be(paramp);
    AppMethodBeat.o(203312);
  }
  
  public final long a(V paramV1, V paramV2, V paramV3)
  {
    AppMethodBeat.i(203326);
    s.u(paramV1, "initialValue");
    s.u(paramV2, "targetValue");
    s.u(paramV3, "initialVelocity");
    long l = this.XD.a(paramV1, paramV2, paramV3);
    AppMethodBeat.o(203326);
    return l;
  }
  
  public final V a(long paramLong, V paramV1, V paramV2, V paramV3)
  {
    AppMethodBeat.i(203337);
    s.u(paramV1, "initialValue");
    s.u(paramV2, "targetValue");
    s.u(paramV3, "initialVelocity");
    paramV1 = this.XD.a(paramLong, paramV1, paramV2, paramV3);
    AppMethodBeat.o(203337);
    return paramV1;
  }
  
  public final V b(long paramLong, V paramV1, V paramV2, V paramV3)
  {
    AppMethodBeat.i(203342);
    s.u(paramV1, "initialValue");
    s.u(paramV2, "targetValue");
    s.u(paramV3, "initialVelocity");
    paramV1 = this.XD.b(paramLong, paramV1, paramV2, paramV3);
    AppMethodBeat.o(203342);
    return paramV1;
  }
  
  public final V b(V paramV1, V paramV2, V paramV3)
  {
    AppMethodBeat.i(203331);
    s.u(paramV1, "initialValue");
    s.u(paramV2, "targetValue");
    s.u(paramV3, "initialVelocity");
    paramV1 = this.XD.b(paramV1, paramV2, paramV3);
    AppMethodBeat.o(203331);
    return paramV1;
  }
  
  public final boolean lF()
  {
    AppMethodBeat.i(203345);
    s.u(this.XD, "this");
    AppMethodBeat.o(203345);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.a.a.bh
 * JD-Core Version:    0.7.0.1
 */