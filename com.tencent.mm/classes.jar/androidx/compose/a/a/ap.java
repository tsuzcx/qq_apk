package androidx.compose.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"UNSET", "", "getUNSET", "()F", "VelocityThresholdMultiplier", "", "Motion", "Landroidx/compose/animation/core/Motion;", "value", "velocity", "(FF)J", "animation-core_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class ap
{
  private static final float VU = 3.4028235E+38F;
  
  public static final float lQ()
  {
    return VU;
  }
  
  public static final long t(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(203347);
    long l1 = Float.floatToIntBits(paramFloat1);
    long l2 = Float.floatToIntBits(paramFloat2);
    AppMethodBeat.o(203347);
    return l1 << 32 | l2 & 0xFFFFFFFF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.a.a.ap
 * JD-Core Version:    0.7.0.1
 */