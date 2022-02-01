package androidx.compose.ui.n;

import androidx.compose.ui.o.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"dp", "Landroidx/compose/ui/unit/Dp;", "", "getDp$annotations", "(D)V", "getDp", "(D)F", "", "(F)V", "(F)F", "", "(I)V", "(I)F", "height", "Landroidx/compose/ui/unit/DpRect;", "getHeight$annotations", "(Landroidx/compose/ui/unit/DpRect;)V", "getHeight", "(Landroidx/compose/ui/unit/DpRect;)F", "isFinite", "", "isFinite-0680j_4$annotations", "isFinite-0680j_4", "(F)Z", "isSpecified", "isSpecified-0680j_4$annotations", "isSpecified-0680j_4", "isUnspecified", "isUnspecified-0680j_4$annotations", "isUnspecified-0680j_4", "width", "getWidth$annotations", "getWidth", "DpOffset", "Landroidx/compose/ui/unit/DpOffset;", "x", "y", "DpOffset-YgX7TsA", "(FF)J", "lerp", "start", "stop", "fraction", "lerp-Md-fbLM", "(FFF)F", "lerp-xhh869w", "(JJF)J", "max", "a", "b", "max-YgX7TsA", "(FF)F", "min", "min-YgX7TsA", "coerceAtLeast", "minimumValue", "coerceAtLeast-YgX7TsA", "coerceAtMost", "maximumValue", "coerceAtMost-YgX7TsA", "coerceIn", "coerceIn-2z7ARbQ", "takeOrElse", "block", "Lkotlin/Function0;", "takeOrElse-D5KLDUw", "(FLkotlin/jvm/functions/Function0;)F", "times", "other", "times-3ABfNKs", "(DF)F", "(IF)F", "ui-unit_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class h
{
  public static final long J(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(204756);
    long l = i.J(Float.floatToIntBits(paramFloat1) << 32 | Float.floatToIntBits(paramFloat2) & 0xFFFFFFFF);
    AppMethodBeat.o(204756);
    return l;
  }
  
  public static final float f(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(204747);
    paramFloat1 = g.ai(a.lerp(paramFloat1, paramFloat2, paramFloat3));
    AppMethodBeat.o(204747);
    return paramFloat1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.n.h
 * JD-Core Version:    0.7.0.1
 */