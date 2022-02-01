package androidx.compose.ui.m.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/text/font/FontStyle;", "", "value", "", "constructor-impl", "(I)I", "getValue", "()I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "ui-text_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
{
  public static final g.a bbW;
  private static final int bbX;
  private static final int bbY;
  public final int value;
  
  static
  {
    AppMethodBeat.i(205345);
    bbW = new g.a((byte)0);
    bbX = 0;
    bbY = 1;
    AppMethodBeat.o(205345);
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
    AppMethodBeat.i(205311);
    if (C(paramInt, bbX))
    {
      AppMethodBeat.o(205311);
      return "Normal";
    }
    if (C(paramInt, bbY))
    {
      AppMethodBeat.o(205311);
      return "Italic";
    }
    AppMethodBeat.o(205311);
    return "Invalid";
  }
  
  public final boolean equals(Object paramObject)
  {
    int i = this.value;
    if (!(paramObject instanceof g)) {}
    while (i != ((g)paramObject).value) {
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
    AppMethodBeat.i(205355);
    String str = cJ(this.value);
    AppMethodBeat.o(205355);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.m.b.g
 * JD-Core Version:    0.7.0.1
 */