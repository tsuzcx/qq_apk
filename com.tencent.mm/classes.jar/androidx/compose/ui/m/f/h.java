package androidx.compose.ui.m.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/text/style/TextOverflow;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "ui-text_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
{
  public static final h.a beA;
  private static final int beB;
  private static final int beC;
  private static final int beD;
  
  static
  {
    AppMethodBeat.i(205076);
    beA = new h.a((byte)0);
    beB = 1;
    beC = 2;
    beD = 3;
    AppMethodBeat.o(205076);
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
    AppMethodBeat.i(205054);
    if (C(paramInt, beB))
    {
      AppMethodBeat.o(205054);
      return "Clip";
    }
    if (C(paramInt, beC))
    {
      AppMethodBeat.o(205054);
      return "Ellipsis";
    }
    if (C(paramInt, beD))
    {
      AppMethodBeat.o(205054);
      return "Visible";
    }
    AppMethodBeat.o(205054);
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
 * Qualified Name:     androidx.compose.ui.m.f.h
 * JD-Core Version:    0.7.0.1
 */