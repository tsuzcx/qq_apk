package androidx.compose.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"infiniteRepeatable", "Landroidx/compose/animation/core/InfiniteRepeatableSpec;", "T", "animation", "Landroidx/compose/animation/core/DurationBasedAnimationSpec;", "repeatMode", "Landroidx/compose/animation/core/RepeatMode;", "keyframes", "Landroidx/compose/animation/core/KeyframesSpec;", "init", "Lkotlin/Function1;", "Landroidx/compose/animation/core/KeyframesSpec$KeyframesSpecConfig;", "", "Lkotlin/ExtensionFunctionType;", "repeatable", "Landroidx/compose/animation/core/RepeatableSpec;", "iterations", "", "snap", "Landroidx/compose/animation/core/SnapSpec;", "delayMillis", "spring", "Landroidx/compose/animation/core/SpringSpec;", "dampingRatio", "", "stiffness", "visibilityThreshold", "(FFLjava/lang/Object;)Landroidx/compose/animation/core/SpringSpec;", "tween", "Landroidx/compose/animation/core/TweenSpec;", "durationMillis", "easing", "Landroidx/compose/animation/core/Easing;", "convert", "V", "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/animation/core/TwoWayConverter;", "data", "(Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/Object;)Landroidx/compose/animation/core/AnimationVector;", "animation-core_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class h
{
  public static final <T> ag<T> a(x<T> paramx, am paramam)
  {
    AppMethodBeat.i(203284);
    s.u(paramx, "animation");
    s.u(paramam, "repeatMode");
    paramx = new ag(paramx, paramam);
    AppMethodBeat.o(203284);
    return paramx;
  }
  
  private static <T> aq<T> a(float paramFloat1, float paramFloat2, T paramT)
  {
    AppMethodBeat.i(203275);
    paramT = new aq(paramFloat1, paramFloat2, paramT);
    AppMethodBeat.o(203275);
    return paramT;
  }
  
  public static final <T> av<T> a(int paramInt1, int paramInt2, y paramy)
  {
    AppMethodBeat.i(203263);
    s.u(paramy, "easing");
    paramy = new av(paramInt1, paramInt2, paramy);
    AppMethodBeat.o(203263);
    return paramy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.a.a.h
 * JD-Core Version:    0.7.0.1
 */