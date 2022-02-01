package androidx.compose.ui.m.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/text/font/FontSynthesis;", "", "value", "", "constructor-impl", "(I)I", "isStyleOn", "", "isStyleOn-impl$ui_text_release", "(I)Z", "isWeightOn", "isWeightOn-impl$ui_text_release", "equals", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "ui-text_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
{
  private static final int All;
  private static final int None;
  public static final h.a bbZ;
  private static final int bca;
  private static final int bcb;
  public final int value;
  
  static
  {
    AppMethodBeat.i(205342);
    bbZ = new h.a((byte)0);
    None = 0;
    All = 1;
    bca = 2;
    bcb = 3;
    AppMethodBeat.o(205342);
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
    AppMethodBeat.i(205315);
    if (C(paramInt, None))
    {
      AppMethodBeat.o(205315);
      return "None";
    }
    if (C(paramInt, All))
    {
      AppMethodBeat.o(205315);
      return "All";
    }
    if (C(paramInt, bca))
    {
      AppMethodBeat.o(205315);
      return "Weight";
    }
    if (C(paramInt, bcb))
    {
      AppMethodBeat.o(205315);
      return "Style";
    }
    AppMethodBeat.o(205315);
    return "Invalid";
  }
  
  public final boolean equals(Object paramObject)
  {
    int i = this.value;
    if (!(paramObject instanceof h)) {}
    while (i != ((h)paramObject).value) {
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
    AppMethodBeat.i(205349);
    String str = cJ(this.value);
    AppMethodBeat.o(205349);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.m.b.h
 * JD-Core Version:    0.7.0.1
 */