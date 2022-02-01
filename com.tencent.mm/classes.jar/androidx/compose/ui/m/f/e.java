package androidx.compose.ui.m.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/text/style/TextDirection;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "ui-text_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  public static final e.a beo;
  private static final int bep;
  private static final int beq;
  private static final int ber;
  private static final int bes;
  private static final int bet;
  public final int value;
  
  static
  {
    AppMethodBeat.i(205108);
    beo = new e.a((byte)0);
    bep = 1;
    beq = 2;
    ber = 3;
    bes = 4;
    bet = 5;
    AppMethodBeat.o(205108);
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
    if (!(paramObject instanceof e)) {}
    while (i != ((e)paramObject).value) {
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
    AppMethodBeat.i(205114);
    int i = this.value;
    if (C(i, bep))
    {
      AppMethodBeat.o(205114);
      return "Ltr";
    }
    if (C(i, beq))
    {
      AppMethodBeat.o(205114);
      return "Rtl";
    }
    if (C(i, ber))
    {
      AppMethodBeat.o(205114);
      return "Content";
    }
    if (C(i, bes))
    {
      AppMethodBeat.o(205114);
      return "ContentOrLtr";
    }
    if (C(i, bet))
    {
      AppMethodBeat.o(205114);
      return "ContentOrRtl";
    }
    AppMethodBeat.o(205114);
    return "Invalid";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.m.f.e
 * JD-Core Version:    0.7.0.1
 */