package androidx.compose.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.m;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"exponentialDecay", "Landroidx/compose/animation/core/DecayAnimationSpec;", "T", "frictionMultiplier", "", "absVelocityThreshold", "calculateTargetValue", "V", "Landroidx/compose/animation/core/AnimationVector;", "typeConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "initialValue", "initialVelocity", "(Landroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "generateDecayAnimationSpec", "Landroidx/compose/animation/core/FloatDecayAnimationSpec;", "animation-core_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class w
{
  public static final float a(u<Float> paramu, float paramFloat)
  {
    AppMethodBeat.i(203280);
    s.u(paramu, "<this>");
    paramFloat = ((l)paramu.b(ay.a(m.aiwV)).c((k)o.q(0.0F), (k)o.q(paramFloat))).value;
    AppMethodBeat.o(203280);
    return paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.a.a.w
 * JD-Core Version:    0.7.0.1
 */