package androidx.compose.foundation.f.a;

import androidx.compose.ui.e.z;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Landroidx/compose/foundation/text/selection/TextSelectionColors;", "", "handleColor", "Landroidx/compose/ui/graphics/Color;", "backgroundColor", "(JJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getBackgroundColor-0d7_KjU", "()J", "J", "getHandleColor-0d7_KjU", "equals", "", "other", "hashCode", "", "toString", "", "foundation_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
{
  private final long ahS;
  public final long ahT;
  
  private i(long paramLong1, long paramLong2)
  {
    this.ahS = paramLong1;
    this.ahT = paramLong2;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(203755);
    if (this == paramObject)
    {
      AppMethodBeat.o(203755);
      return true;
    }
    if (!(paramObject instanceof i))
    {
      AppMethodBeat.o(203755);
      return false;
    }
    if (!z.e(this.ahS, ((i)paramObject).ahS))
    {
      AppMethodBeat.o(203755);
      return false;
    }
    if (!z.e(this.ahT, ((i)paramObject).ahT))
    {
      AppMethodBeat.o(203755);
      return false;
    }
    AppMethodBeat.o(203755);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(203762);
    int i = z.I(this.ahS);
    int j = z.I(this.ahT);
    AppMethodBeat.o(203762);
    return i * 31 + j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(203767);
    String str = "SelectionColors(selectionHandleColor=" + z.H(this.ahS) + ", selectionBackgroundColor=" + z.H(this.ahT) + ')';
    AppMethodBeat.o(203767);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.foundation.f.a.i
 * JD-Core Version:    0.7.0.1
 */