package androidx.compose.ui.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/layout/FixedScale;", "Landroidx/compose/ui/layout/ContentScale;", "value", "", "(F)V", "getValue", "()F", "component1", "computeScaleFactor", "Landroidx/compose/ui/layout/ScaleFactor;", "srcSize", "Landroidx/compose/ui/geometry/Size;", "dstSize", "computeScaleFactor-H7hwNQA", "(JJ)J", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  implements d
{
  private final float value = 1.0F;
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(205656);
    if (this == paramObject)
    {
      AppMethodBeat.o(205656);
      return true;
    }
    if (!(paramObject instanceof f))
    {
      AppMethodBeat.o(205656);
      return false;
    }
    paramObject = (f)paramObject;
    if (!s.p(Float.valueOf(this.value), Float.valueOf(paramObject.value)))
    {
      AppMethodBeat.o(205656);
      return false;
    }
    AppMethodBeat.o(205656);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(205653);
    int i = Float.floatToIntBits(this.value);
    AppMethodBeat.o(205653);
    return i;
  }
  
  public final long l(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(205642);
    paramLong1 = ad.F(this.value, this.value);
    AppMethodBeat.o(205642);
    return paramLong1;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(205648);
    String str = "FixedScale(value=" + this.value + ')';
    AppMethodBeat.o(205648);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.h.f
 * JD-Core Version:    0.7.0.1
 */