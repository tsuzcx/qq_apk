package androidx.compose.ui.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/graphics/StrokeCap;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "ui-graphics_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bb
{
  public static final bb.a ayr;
  private static final int ays;
  private static final int ayt;
  private static final int ayu;
  public final int value;
  
  static
  {
    AppMethodBeat.i(206054);
    ayr = new bb.a((byte)0);
    ays = 0;
    ayt = 1;
    ayu = 2;
    AppMethodBeat.o(206054);
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
    AppMethodBeat.i(206008);
    if (C(paramInt, ays))
    {
      AppMethodBeat.o(206008);
      return "Butt";
    }
    if (C(paramInt, ayt))
    {
      AppMethodBeat.o(206008);
      return "Round";
    }
    if (C(paramInt, ayu))
    {
      AppMethodBeat.o(206008);
      return "Square";
    }
    AppMethodBeat.o(206008);
    return "Unknown";
  }
  
  public final boolean equals(Object paramObject)
  {
    int i = this.value;
    if (!(paramObject instanceof bb)) {}
    while (i != ((bb)paramObject).value) {
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
    AppMethodBeat.i(206059);
    String str = cJ(this.value);
    AppMethodBeat.o(206059);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.e.bb
 * JD-Core Version:    0.7.0.1
 */