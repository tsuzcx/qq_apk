package androidx.compose.ui.g.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
{
  public static final g.a aKL;
  private static final int aKM;
  private static final int aKN;
  private static final int aKO;
  
  static
  {
    AppMethodBeat.i(205749);
    aKL = new g.a((byte)0);
    aKM = 1;
    aKN = 2;
    aKO = 3;
    AppMethodBeat.o(205749);
  }
  
  public static final boolean C(int paramInt1, int paramInt2)
  {
    return paramInt1 == paramInt2;
  }
  
  public static String cJ(int paramInt)
  {
    AppMethodBeat.i(205728);
    if (C(paramInt, aKM))
    {
      AppMethodBeat.o(205728);
      return "Drag";
    }
    if (C(paramInt, aKN))
    {
      AppMethodBeat.o(205728);
      return "Fling";
    }
    if (C(paramInt, aKO))
    {
      AppMethodBeat.o(205728);
      return "Relocate";
    }
    AppMethodBeat.o(205728);
    return "Invalid";
  }
  
  public final boolean equals(Object paramObject)
  {
    throw null;
  }
  
  public final int hashCode()
  {
    throw null;
  }
  
  public final String toString()
  {
    throw null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.g.b.g
 * JD-Core Version:    0.7.0.1
 */