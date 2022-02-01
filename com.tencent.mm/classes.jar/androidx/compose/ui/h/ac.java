package androidx.compose.ui.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.m;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/layout/ScaleFactor;", "", "packedValue", "", "constructor-impl", "(J)J", "getPackedValue$annotations", "()V", "scaleX", "", "getScaleX$annotations", "getScaleX-impl", "(J)F", "scaleY", "getScaleY$annotations", "getScaleY-impl", "component1", "component1-impl", "component2", "component2-impl", "copy", "copy-8GGzs04", "(JFF)J", "div", "operand", "div-44nBxM0", "(JF)J", "equals", "", "other", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(J)I", "times", "times-44nBxM0", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "Companion", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ac
{
  public static final ac.a aNf;
  private static final long avr;
  
  static
  {
    AppMethodBeat.i(205619);
    aNf = new ac.a((byte)0);
    avr = ad.F((0.0F / 0.0F), (0.0F / 0.0F));
    AppMethodBeat.o(205619);
  }
  
  public static long J(long paramLong)
  {
    return paramLong;
  }
  
  public static final float aA(long paramLong)
  {
    AppMethodBeat.i(205604);
    if (paramLong != avr) {}
    for (int i = 1; i == 0; i = 0)
    {
      localObject = (Throwable)new IllegalStateException("ScaleFactor is unspecified".toString());
      AppMethodBeat.o(205604);
      throw ((Throwable)localObject);
    }
    Object localObject = m.aiwV;
    float f = Float.intBitsToFloat((int)(0xFFFFFFFF & paramLong));
    AppMethodBeat.o(205604);
    return f;
  }
  
  public static final float az(long paramLong)
  {
    AppMethodBeat.i(205594);
    if (paramLong != avr) {}
    for (int i = 1; i == 0; i = 0)
    {
      localObject = (Throwable)new IllegalStateException("ScaleFactor is unspecified".toString());
      AppMethodBeat.o(205594);
      throw ((Throwable)localObject);
    }
    Object localObject = m.aiwV;
    float f = Float.intBitsToFloat((int)(paramLong >> 32));
    AppMethodBeat.o(205594);
    return f;
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
 * Qualified Name:     androidx.compose.ui.h.ac
 * JD-Core Version:    0.7.0.1
 */