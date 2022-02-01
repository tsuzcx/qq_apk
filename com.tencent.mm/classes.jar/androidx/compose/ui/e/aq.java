package androidx.compose.ui.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/graphics/PathFillType;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "ui-graphics_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class aq
{
  public static final aq.a axV;
  private static final int axW;
  private static final int axX;
  public final int value;
  
  static
  {
    AppMethodBeat.i(206134);
    axV = new aq.a((byte)0);
    axW = 0;
    axX = 1;
    AppMethodBeat.o(206134);
  }
  
  public static final boolean C(int paramInt1, int paramInt2)
  {
    return paramInt1 == paramInt2;
  }
  
  public static int cG(int paramInt)
  {
    return paramInt;
  }
  
  public final boolean equals(Object paramObject)
  {
    int i = this.value;
    if (!(paramObject instanceof aq)) {}
    while (i != ((aq)paramObject).value) {
      return false;
    }
    return true;
  }
  
  public final int hashCode()
  {
    return this.value;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(206138);
    int i = this.value;
    if (C(i, axW))
    {
      AppMethodBeat.o(206138);
      return "NonZero";
    }
    if (C(i, axX))
    {
      AppMethodBeat.o(206138);
      return "EvenOdd";
    }
    AppMethodBeat.o(206138);
    return "Unknown";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.e.aq
 * JD-Core Version:    0.7.0.1
 */