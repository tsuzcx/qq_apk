package androidx.compose.ui.m.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/text/input/KeyboardCapitalization;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "ui-text_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
{
  private static final int None;
  public static final k.a bcM;
  private static final int bcN;
  private static final int bcO;
  private static final int bcP;
  
  static
  {
    AppMethodBeat.i(205310);
    bcM = new k.a((byte)0);
    None = 0;
    bcN = 1;
    bcO = 2;
    bcP = 3;
    AppMethodBeat.o(205310);
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
    AppMethodBeat.i(205277);
    if (C(paramInt, None))
    {
      AppMethodBeat.o(205277);
      return "None";
    }
    if (C(paramInt, bcN))
    {
      AppMethodBeat.o(205277);
      return "Characters";
    }
    if (C(paramInt, bcO))
    {
      AppMethodBeat.o(205277);
      return "Words";
    }
    if (C(paramInt, bcP))
    {
      AppMethodBeat.o(205277);
      return "Sentences";
    }
    AppMethodBeat.o(205277);
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
 * Qualified Name:     androidx.compose.ui.m.c.k
 * JD-Core Version:    0.7.0.1
 */