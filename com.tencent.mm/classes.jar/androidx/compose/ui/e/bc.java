package androidx.compose.ui.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/graphics/StrokeJoin;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "ui-graphics_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bc
{
  private static final int ayt;
  public static final bc.a ayv;
  private static final int ayw;
  private static final int ayx;
  public final int value;
  
  static
  {
    AppMethodBeat.i(206035);
    ayv = new bc.a((byte)0);
    ayw = 0;
    ayt = 1;
    ayx = 2;
    AppMethodBeat.o(206035);
  }
  
  public static final boolean C(int paramInt1, int paramInt2)
  {
    return paramInt1 == paramInt2;
  }
  
  public static int cG(int paramInt)
  {
    return paramInt;
  }
  
  public static String cJ(int paramInt)
  {
    AppMethodBeat.i(206006);
    if (C(paramInt, ayw))
    {
      AppMethodBeat.o(206006);
      return "Miter";
    }
    if (C(paramInt, ayt))
    {
      AppMethodBeat.o(206006);
      return "Round";
    }
    if (C(paramInt, ayx))
    {
      AppMethodBeat.o(206006);
      return "Bevel";
    }
    AppMethodBeat.o(206006);
    return "Unknown";
  }
  
  public final boolean equals(Object paramObject)
  {
    int i = this.value;
    if (!(paramObject instanceof bc)) {}
    while (i != ((bc)paramObject).value) {
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
    AppMethodBeat.i(206040);
    String str = cJ(this.value);
    AppMethodBeat.o(206040);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.e.bc
 * JD-Core Version:    0.7.0.1
 */