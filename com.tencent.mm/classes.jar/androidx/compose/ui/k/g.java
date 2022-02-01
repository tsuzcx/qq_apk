package androidx.compose.ui.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/semantics/Role;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
{
  private static final int Image;
  public static final g.a aWD;
  private static final int aWE;
  private static final int aWF;
  private static final int aWG;
  private static final int aWH;
  private static final int aWI;
  public final int value;
  
  static
  {
    AppMethodBeat.i(205460);
    aWD = new g.a((byte)0);
    aWE = 0;
    aWF = 1;
    aWG = 2;
    aWH = 3;
    aWI = 4;
    Image = 5;
    AppMethodBeat.o(205460);
  }
  
  public static final boolean C(int paramInt1, int paramInt2)
  {
    return paramInt1 == paramInt2;
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
    AppMethodBeat.i(205467);
    int i = this.value;
    if (C(i, aWE))
    {
      AppMethodBeat.o(205467);
      return "Button";
    }
    if (C(i, aWF))
    {
      AppMethodBeat.o(205467);
      return "Checkbox";
    }
    if (C(i, aWG))
    {
      AppMethodBeat.o(205467);
      return "Switch";
    }
    if (C(i, aWH))
    {
      AppMethodBeat.o(205467);
      return "RadioButton";
    }
    if (C(i, aWI))
    {
      AppMethodBeat.o(205467);
      return "Tab";
    }
    if (C(i, Image))
    {
      AppMethodBeat.o(205467);
      return "Image";
    }
    AppMethodBeat.o(205467);
    return "Unknown";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.k.g
 * JD-Core Version:    0.7.0.1
 */