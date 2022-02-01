package androidx.compose.ui.d;

import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.m;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/geometry/Size;", "", "packedValue", "", "constructor-impl", "(J)J", "height", "", "getHeight$annotations", "()V", "getHeight-impl", "(J)F", "maxDimension", "getMaxDimension$annotations", "getMaxDimension-impl", "minDimension", "getMinDimension$annotations", "getMinDimension-impl", "getPackedValue$annotations", "width", "getWidth$annotations", "getWidth-impl", "component1", "component1-impl", "component2", "component2-impl", "copy", "copy-xjbvk4A", "(JFF)J", "div", "operand", "div-7Ah8Wj8", "(JF)J", "equals", "", "other", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(J)I", "isEmpty", "isEmpty-impl", "(J)Z", "times", "times-7Ah8Wj8", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "Companion", "ui-geometry_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
{
  public static final k.a avA;
  private static final long avn;
  private static final long avr;
  public final long avp;
  
  static
  {
    AppMethodBeat.i(205595);
    avA = new k.a((byte)0);
    avn = l.z(0.0F, 0.0F);
    avr = l.z((0.0F / 0.0F), (0.0F / 0.0F));
    AppMethodBeat.o(205595);
  }
  
  public static String H(long paramLong)
  {
    AppMethodBeat.i(205549);
    if (paramLong != avr) {}
    for (int i = 1; i != 0; i = 0)
    {
      String str = "Size(" + c.I(Q(paramLong)) + ", " + c.I(R(paramLong)) + ')';
      AppMethodBeat.o(205549);
      return str;
    }
    AppMethodBeat.o(205549);
    return "Size(UNSPECIFIED)";
  }
  
  public static int I(long paramLong)
  {
    AppMethodBeat.i(205557);
    int i = q.a..ExternalSyntheticBackport0.m(paramLong);
    AppMethodBeat.o(205557);
    return i;
  }
  
  public static long J(long paramLong)
  {
    return paramLong;
  }
  
  public static final float Q(long paramLong)
  {
    AppMethodBeat.i(205529);
    if (paramLong != avr) {}
    for (int i = 1; i == 0; i = 0)
    {
      localObject = (Throwable)new IllegalStateException("Size is unspecified".toString());
      AppMethodBeat.o(205529);
      throw ((Throwable)localObject);
    }
    Object localObject = m.aiwV;
    float f = Float.intBitsToFloat((int)(paramLong >> 32));
    AppMethodBeat.o(205529);
    return f;
  }
  
  public static final float R(long paramLong)
  {
    AppMethodBeat.i(205534);
    if (paramLong != avr) {}
    for (int i = 1; i == 0; i = 0)
    {
      localObject = (Throwable)new IllegalStateException("Size is unspecified".toString());
      AppMethodBeat.o(205534);
      throw ((Throwable)localObject);
    }
    Object localObject = m.aiwV;
    float f = Float.intBitsToFloat((int)(0xFFFFFFFF & paramLong));
    AppMethodBeat.o(205534);
    return f;
  }
  
  public static final boolean S(long paramLong)
  {
    AppMethodBeat.i(205539);
    if ((Q(paramLong) <= 0.0F) || (R(paramLong) <= 0.0F))
    {
      AppMethodBeat.o(205539);
      return true;
    }
    AppMethodBeat.o(205539);
    return false;
  }
  
  public static final float T(long paramLong)
  {
    AppMethodBeat.i(205544);
    float f = Math.min(Math.abs(Q(paramLong)), Math.abs(R(paramLong)));
    AppMethodBeat.o(205544);
    return f;
  }
  
  public static final boolean e(long paramLong1, long paramLong2)
  {
    return paramLong1 == paramLong2;
  }
  
  public static boolean e(long paramLong, Object paramObject)
  {
    if (!(paramObject instanceof k)) {}
    while (paramLong != ((k)paramObject).avp) {
      return false;
    }
    return true;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(205609);
    boolean bool = e(this.avp, paramObject);
    AppMethodBeat.o(205609);
    return bool;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(205605);
    int i = q.a..ExternalSyntheticBackport0.m(this.avp);
    AppMethodBeat.o(205605);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(205601);
    String str = H(this.avp);
    AppMethodBeat.o(205601);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.d.k
 * JD-Core Version:    0.7.0.1
 */