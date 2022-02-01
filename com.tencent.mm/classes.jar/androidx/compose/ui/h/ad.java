package androidx.compose.ui.h;

import androidx.compose.ui.d.k;
import androidx.compose.ui.d.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"isSpecified", "", "Landroidx/compose/ui/layout/ScaleFactor;", "isSpecified-FK8aYYs$annotations", "(J)V", "isSpecified-FK8aYYs", "(J)Z", "isUnspecified", "isUnspecified-FK8aYYs$annotations", "isUnspecified-FK8aYYs", "ScaleFactor", "scaleX", "", "scaleY", "(FF)J", "lerp", "start", "stop", "fraction", "lerp--bDIf60", "(JJF)J", "div", "Landroidx/compose/ui/geometry/Size;", "scaleFactor", "div-UQTWf7w", "(JJ)J", "roundToTenths", "takeOrElse", "block", "Lkotlin/Function0;", "takeOrElse-oyDd2qo", "(JLkotlin/jvm/functions/Function0;)J", "times", "times-UQTWf7w", "size", "times-m-w2e94", "ui_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class ad
{
  public static final long F(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(205579);
    long l = ac.J(Float.floatToIntBits(paramFloat1) << 32 | Float.floatToIntBits(paramFloat2) & 0xFFFFFFFF);
    AppMethodBeat.o(205579);
    return l;
  }
  
  public static final long p(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(205588);
    paramLong1 = l.z(k.Q(paramLong1) * ac.az(paramLong2), k.R(paramLong1) * ac.aA(paramLong2));
    AppMethodBeat.o(205588);
    return paramLong1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.h.ad
 * JD-Core Version:    0.7.0.1
 */