package androidx.compose.ui.m.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/text/input/KeyboardType;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "ui-text_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
{
  public static final l.a bcQ;
  private static final int bcR;
  private static final int bcS;
  private static final int bcT;
  private static final int bcU;
  private static final int bcV;
  private static final int bcW;
  private static final int bcX;
  private static final int bcY;
  
  static
  {
    AppMethodBeat.i(205307);
    bcQ = new l.a((byte)0);
    bcR = 1;
    bcS = 2;
    bcT = 3;
    bcU = 4;
    bcV = 5;
    bcW = 6;
    bcX = 7;
    bcY = 8;
    AppMethodBeat.o(205307);
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
    AppMethodBeat.i(205273);
    if (C(paramInt, bcR))
    {
      AppMethodBeat.o(205273);
      return "Text";
    }
    if (C(paramInt, bcS))
    {
      AppMethodBeat.o(205273);
      return "Ascii";
    }
    if (C(paramInt, bcT))
    {
      AppMethodBeat.o(205273);
      return "Number";
    }
    if (C(paramInt, bcU))
    {
      AppMethodBeat.o(205273);
      return "Phone";
    }
    if (C(paramInt, bcV))
    {
      AppMethodBeat.o(205273);
      return "Uri";
    }
    if (C(paramInt, bcW))
    {
      AppMethodBeat.o(205273);
      return "Email";
    }
    if (C(paramInt, bcX))
    {
      AppMethodBeat.o(205273);
      return "Password";
    }
    if (C(paramInt, bcY))
    {
      AppMethodBeat.o(205273);
      return "NumberPassword";
    }
    AppMethodBeat.o(205273);
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
 * Qualified Name:     androidx.compose.ui.m.c.l
 * JD-Core Version:    0.7.0.1
 */