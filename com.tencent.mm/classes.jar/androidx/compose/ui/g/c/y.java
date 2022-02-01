package androidx.compose.ui.g.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/input/pointer/PointerType;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class y
{
  private static final int aKm;
  public static final y.a aLM;
  private static final int aLN;
  private static final int aLO;
  private static final int aLP;
  private static final int aLQ;
  
  static
  {
    AppMethodBeat.i(205951);
    aLM = new y.a((byte)0);
    aKm = 0;
    aLN = 1;
    aLO = 2;
    aLP = 3;
    aLQ = 4;
    AppMethodBeat.o(205951);
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
    switch (paramInt)
    {
    default: 
      return "Unknown";
    case 1: 
      return "Touch";
    case 2: 
      return "Mouse";
    case 3: 
      return "Stylus";
    }
    return "Eraser";
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
 * Qualified Name:     androidx.compose.ui.g.c.y
 * JD-Core Version:    0.7.0.1
 */