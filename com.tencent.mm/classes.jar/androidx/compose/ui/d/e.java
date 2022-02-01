package androidx.compose.ui.d;

import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.m;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/geometry/Offset;", "", "packedValue", "", "constructor-impl", "(J)J", "x", "", "getX$annotations", "()V", "getX-impl", "(J)F", "y", "getY$annotations", "getY-impl", "component1", "component1-impl", "component2", "component2-impl", "copy", "copy-dBAh8RU", "(JFF)J", "div", "operand", "div-tuRUvjQ", "(JF)J", "equals", "", "other", "equals-impl", "(JLjava/lang/Object;)Z", "getDistance", "getDistance-impl", "getDistanceSquared", "getDistanceSquared-impl", "hashCode", "", "hashCode-impl", "(J)I", "isValid", "isValid-impl", "(J)Z", "minus", "minus-MK-Hz9U", "(JJ)J", "plus", "plus-MK-Hz9U", "rem", "rem-tuRUvjQ", "times", "times-tuRUvjQ", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "unaryMinus", "unaryMinus-F1C5BW0", "Companion", "ui-geometry_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  private static final long avn;
  public static final a avo;
  private static final long avq;
  private static final long avr;
  public final long avp;
  
  static
  {
    AppMethodBeat.i(205640);
    avo = new a((byte)0);
    avn = f.x(0.0F, 0.0F);
    avq = f.x((1.0F / 1.0F), (1.0F / 1.0F));
    avr = f.x((0.0F / 0.0F), (0.0F / 0.0F));
    AppMethodBeat.o(205640);
  }
  
  public static final float F(long paramLong)
  {
    AppMethodBeat.i(205545);
    if (paramLong != avr) {}
    for (int i = 1; i == 0; i = 0)
    {
      localObject = (Throwable)new IllegalStateException("Offset is unspecified".toString());
      AppMethodBeat.o(205545);
      throw ((Throwable)localObject);
    }
    Object localObject = m.aiwV;
    float f = Float.intBitsToFloat((int)(paramLong >> 32));
    AppMethodBeat.o(205545);
    return f;
  }
  
  public static final float G(long paramLong)
  {
    AppMethodBeat.i(205551);
    if (paramLong != avr) {}
    for (int i = 1; i == 0; i = 0)
    {
      localObject = (Throwable)new IllegalStateException("Offset is unspecified".toString());
      AppMethodBeat.o(205551);
      throw ((Throwable)localObject);
    }
    Object localObject = m.aiwV;
    float f = Float.intBitsToFloat((int)(0xFFFFFFFF & paramLong));
    AppMethodBeat.o(205551);
    return f;
  }
  
  public static String H(long paramLong)
  {
    AppMethodBeat.i(205590);
    String str = "Offset(" + c.I(F(paramLong)) + ", " + c.I(G(paramLong)) + ')';
    AppMethodBeat.o(205590);
    return str;
  }
  
  public static int I(long paramLong)
  {
    AppMethodBeat.i(205599);
    int i = q.a..ExternalSyntheticBackport0.m(paramLong);
    AppMethodBeat.o(205599);
    return i;
  }
  
  public static long J(long paramLong)
  {
    return paramLong;
  }
  
  public static final float K(long paramLong)
  {
    AppMethodBeat.i(205558);
    float f = F(paramLong);
    AppMethodBeat.o(205558);
    return f;
  }
  
  public static final float L(long paramLong)
  {
    AppMethodBeat.i(205565);
    float f = G(paramLong);
    AppMethodBeat.o(205565);
    return f;
  }
  
  public static final float M(long paramLong)
  {
    AppMethodBeat.i(205568);
    float f = (float)Math.sqrt(F(paramLong) * F(paramLong) + G(paramLong) * G(paramLong));
    AppMethodBeat.o(205568);
    return f;
  }
  
  public static final boolean e(long paramLong1, long paramLong2)
  {
    return paramLong1 == paramLong2;
  }
  
  public static final long f(long paramLong, float paramFloat)
  {
    AppMethodBeat.i(205580);
    paramLong = f.x(F(paramLong) * paramFloat, G(paramLong) * paramFloat);
    AppMethodBeat.o(205580);
    return paramLong;
  }
  
  public static final long f(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(205572);
    paramLong1 = f.x(F(paramLong1) - F(paramLong2), G(paramLong1) - G(paramLong2));
    AppMethodBeat.o(205572);
    return paramLong1;
  }
  
  public static final long g(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(205577);
    paramLong1 = f.x(F(paramLong1) + F(paramLong2), G(paramLong1) + G(paramLong2));
    AppMethodBeat.o(205577);
    return paramLong1;
  }
  
  public final boolean equals(Object paramObject)
  {
    long l = this.avp;
    if (!(paramObject instanceof e)) {}
    while (l != ((e)paramObject).avp) {
      return false;
    }
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(205650);
    int i = q.a..ExternalSyntheticBackport0.m(this.avp);
    AppMethodBeat.o(205650);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(205645);
    String str = H(this.avp);
    AppMethodBeat.o(205645);
    return str;
  }
  
  @Metadata(d1={""}, d2={"Landroidx/compose/ui/geometry/Offset$Companion;", "", "()V", "Infinite", "Landroidx/compose/ui/geometry/Offset;", "getInfinite-F1C5BW0$annotations", "getInfinite-F1C5BW0", "()J", "J", "Unspecified", "getUnspecified-F1C5BW0$annotations", "getUnspecified-F1C5BW0", "Zero", "getZero-F1C5BW0$annotations", "getZero-F1C5BW0", "ui-geometry_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.d.e
 * JD-Core Version:    0.7.0.1
 */