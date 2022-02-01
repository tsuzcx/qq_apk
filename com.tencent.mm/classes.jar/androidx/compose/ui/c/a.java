package androidx.compose.ui.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/focus/FocusDirection;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  private static final int Left;
  private static final int Right;
  public static final a.a auH;
  private static final int auI;
  private static final int auJ;
  private static final int auK;
  private static final int auL;
  private static final int auM;
  private static final int auN;
  public final int value;
  
  static
  {
    AppMethodBeat.i(204393);
    auH = new a.a((byte)0);
    auI = 1;
    auJ = 2;
    Left = 3;
    Right = 4;
    auK = 5;
    auL = 6;
    auM = 7;
    auN = 8;
    AppMethodBeat.o(204393);
  }
  
  public static final boolean C(int paramInt1, int paramInt2)
  {
    return paramInt1 == paramInt2;
  }
  
  public final boolean equals(Object paramObject)
  {
    int i = this.value;
    if (!(paramObject instanceof a)) {}
    while (i != ((a)paramObject).value) {
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
    AppMethodBeat.i(204399);
    int i = this.value;
    if (C(i, auI))
    {
      AppMethodBeat.o(204399);
      return "Next";
    }
    if (C(i, auJ))
    {
      AppMethodBeat.o(204399);
      return "Previous";
    }
    if (C(i, Left))
    {
      AppMethodBeat.o(204399);
      return "Left";
    }
    if (C(i, Right))
    {
      AppMethodBeat.o(204399);
      return "Right";
    }
    if (C(i, auK))
    {
      AppMethodBeat.o(204399);
      return "Up";
    }
    if (C(i, auL))
    {
      AppMethodBeat.o(204399);
      return "Down";
    }
    if (C(i, auM))
    {
      AppMethodBeat.o(204399);
      return "In";
    }
    if (C(i, auN))
    {
      AppMethodBeat.o(204399);
      return "Out";
    }
    AppMethodBeat.o(204399);
    return "Invalid FocusDirection";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.c.a
 * JD-Core Version:    0.7.0.1
 */