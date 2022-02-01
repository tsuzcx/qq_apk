package androidx.compose.ui.m.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/text/input/ImeAction;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "ui-text_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
{
  private static final int None;
  private static final int auI;
  private static final int auJ;
  private static final int bcA;
  private static final int bcB;
  private static final int bcC;
  private static final int bcD;
  public static final f.a bcy;
  private static final int bcz;
  final int value;
  
  static
  {
    AppMethodBeat.i(205314);
    bcy = new f.a((byte)0);
    bcz = 1;
    None = 0;
    bcA = 2;
    bcB = 3;
    bcC = 4;
    auJ = 5;
    auI = 6;
    bcD = 7;
    AppMethodBeat.o(205314);
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
    AppMethodBeat.i(205259);
    if (C(paramInt, None))
    {
      AppMethodBeat.o(205259);
      return "None";
    }
    if (C(paramInt, bcz))
    {
      AppMethodBeat.o(205259);
      return "Default";
    }
    if (C(paramInt, bcA))
    {
      AppMethodBeat.o(205259);
      return "Go";
    }
    if (C(paramInt, bcB))
    {
      AppMethodBeat.o(205259);
      return "Search";
    }
    if (C(paramInt, bcC))
    {
      AppMethodBeat.o(205259);
      return "Send";
    }
    if (C(paramInt, auJ))
    {
      AppMethodBeat.o(205259);
      return "Previous";
    }
    if (C(paramInt, auI))
    {
      AppMethodBeat.o(205259);
      return "Next";
    }
    if (C(paramInt, bcD))
    {
      AppMethodBeat.o(205259);
      return "Done";
    }
    AppMethodBeat.o(205259);
    return "Invalid";
  }
  
  public final boolean equals(Object paramObject)
  {
    int i = this.value;
    if (!(paramObject instanceof f)) {}
    while (i != ((f)paramObject).value) {
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
    AppMethodBeat.i(205320);
    String str = cJ(this.value);
    AppMethodBeat.o(205320);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.m.c.f
 * JD-Core Version:    0.7.0.1
 */