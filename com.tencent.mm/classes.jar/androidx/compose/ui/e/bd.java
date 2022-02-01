package androidx.compose.ui.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/graphics/TileMode;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "ui-graphics_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bd
{
  private static final int ayA;
  private static final int ayB;
  public static final bd.a ayy;
  private static final int ayz;
  
  static
  {
    AppMethodBeat.i(206044);
    ayy = new bd.a((byte)0);
    ayz = 0;
    ayA = 1;
    ayB = 2;
    AppMethodBeat.o(206044);
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
    AppMethodBeat.i(206016);
    if (C(paramInt, ayz))
    {
      AppMethodBeat.o(206016);
      return "Clamp";
    }
    if (C(paramInt, ayA))
    {
      AppMethodBeat.o(206016);
      return "Repeated";
    }
    if (C(paramInt, ayB))
    {
      AppMethodBeat.o(206016);
      return "Mirror";
    }
    AppMethodBeat.o(206016);
    return "Unknown";
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
 * Qualified Name:     androidx.compose.ui.e.bd
 * JD-Core Version:    0.7.0.1
 */