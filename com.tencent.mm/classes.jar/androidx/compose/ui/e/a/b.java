package androidx.compose.ui.e.a;

import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/graphics/colorspace/ColorModel;", "", "packedValue", "", "constructor-impl", "(J)J", "componentCount", "", "getComponentCount$annotations", "()V", "getComponentCount-impl", "(J)I", "equals", "", "other", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "Companion", "ui-graphics_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b.a ayJ;
  private static final long ayK;
  private static final long ayL;
  private static final long ayM;
  private static final long ayN;
  
  static
  {
    AppMethodBeat.i(206210);
    ayJ = new b.a((byte)0);
    ayK = 12884901888L;
    ayL = 12884901889L;
    ayM = 12884901890L;
    ayN = 17179869187L;
    AppMethodBeat.o(206210);
  }
  
  public static String H(long paramLong)
  {
    AppMethodBeat.i(206175);
    if (e(paramLong, ayK))
    {
      AppMethodBeat.o(206175);
      return "Rgb";
    }
    if (e(paramLong, ayL))
    {
      AppMethodBeat.o(206175);
      return "Xyz";
    }
    if (e(paramLong, ayM))
    {
      AppMethodBeat.o(206175);
      return "Lab";
    }
    if (e(paramLong, ayN))
    {
      AppMethodBeat.o(206175);
      return "Cmyk";
    }
    AppMethodBeat.o(206175);
    return "Unknown";
  }
  
  public static int I(long paramLong)
  {
    AppMethodBeat.i(206181);
    int i = q.a..ExternalSyntheticBackport0.m(paramLong);
    AppMethodBeat.o(206181);
    return i;
  }
  
  public static final int an(long paramLong)
  {
    return (int)(paramLong >> 32);
  }
  
  public static final boolean e(long paramLong1, long paramLong2)
  {
    return paramLong1 == paramLong2;
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
 * Qualified Name:     androidx.compose.ui.e.a.b
 * JD-Core Version:    0.7.0.1
 */