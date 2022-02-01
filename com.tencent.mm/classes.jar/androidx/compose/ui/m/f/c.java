package androidx.compose.ui.m.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/text/style/TextAlign;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "ui-text_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  private static final int Center;
  private static final int Left;
  private static final int Right;
  public static final c.a beg;
  private static final int beh;
  private static final int bei;
  private static final int bej;
  public final int value;
  
  static
  {
    AppMethodBeat.i(205085);
    beg = new c.a((byte)0);
    Left = 1;
    Right = 2;
    Center = 3;
    beh = 4;
    bei = 5;
    bej = 6;
    AppMethodBeat.o(205085);
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
    if (!(paramObject instanceof c)) {}
    while (i != ((c)paramObject).value) {
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
    AppMethodBeat.i(205093);
    int i = this.value;
    if (C(i, Left))
    {
      AppMethodBeat.o(205093);
      return "Left";
    }
    if (C(i, Right))
    {
      AppMethodBeat.o(205093);
      return "Right";
    }
    if (C(i, Center))
    {
      AppMethodBeat.o(205093);
      return "Center";
    }
    if (C(i, beh))
    {
      AppMethodBeat.o(205093);
      return "Justify";
    }
    if (C(i, bei))
    {
      AppMethodBeat.o(205093);
      return "Start";
    }
    if (C(i, bej))
    {
      AppMethodBeat.o(205093);
      return "End";
    }
    AppMethodBeat.o(205093);
    return "Invalid";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.m.f.c
 * JD-Core Version:    0.7.0.1
 */