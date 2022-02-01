package androidx.compose.ui.m.f;

import androidx.compose.ui.n.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/text/style/TextIndent;", "", "firstLine", "Landroidx/compose/ui/unit/TextUnit;", "restLine", "(JJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getFirstLine-XSAIIZE", "()J", "J", "getRestLine-XSAIIZE", "copy", "copy-NB67dxo", "(JJ)Landroidx/compose/ui/text/style/TextIndent;", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "ui-text_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
{
  public static final g.a bew;
  private static final g bez;
  public final long bex;
  public final long bey;
  
  static
  {
    AppMethodBeat.i(205078);
    bew = new g.a((byte)0);
    bez = new g();
    AppMethodBeat.o(205078);
  }
  
  private g(long paramLong1, long paramLong2)
  {
    this.bex = paramLong1;
    this.bey = paramLong2;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(205084);
    if (this == paramObject)
    {
      AppMethodBeat.o(205084);
      return true;
    }
    if (!(paramObject instanceof g))
    {
      AppMethodBeat.o(205084);
      return false;
    }
    if (!o.e(this.bex, ((g)paramObject).bex))
    {
      AppMethodBeat.o(205084);
      return false;
    }
    if (!o.e(this.bey, ((g)paramObject).bey))
    {
      AppMethodBeat.o(205084);
      return false;
    }
    AppMethodBeat.o(205084);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(205091);
    int i = o.I(this.bex);
    int j = o.I(this.bey);
    AppMethodBeat.o(205091);
    return i * 31 + j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(205097);
    String str = "TextIndent(firstLine=" + o.H(this.bex) + ", restLine=" + o.H(this.bey) + ')';
    AppMethodBeat.o(205097);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.m.f.g
 * JD-Core Version:    0.7.0.1
 */