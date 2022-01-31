package a.i;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"coerceAtLeast", "T", "", "minimumValue", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)Ljava/lang/Comparable;", "", "", "", "", "", "", "coerceAtMost", "maximumValue", "coerceIn", "(Ljava/lang/Comparable;Ljava/lang/Comparable;Ljava/lang/Comparable;)Ljava/lang/Comparable;", "range", "Lkotlin/ranges/ClosedFloatingPointRange;", "(Ljava/lang/Comparable;Lkotlin/ranges/ClosedFloatingPointRange;)Ljava/lang/Comparable;", "Lkotlin/ranges/ClosedRange;", "(Ljava/lang/Comparable;Lkotlin/ranges/ClosedRange;)Ljava/lang/Comparable;", "contains", "", "Lkotlin/ranges/CharRange;", "element", "", "(Lkotlin/ranges/CharRange;Ljava/lang/Character;)Z", "value", "byteRangeContains", "doubleRangeContains", "floatRangeContains", "intRangeContains", "longRangeContains", "shortRangeContains", "Lkotlin/ranges/IntRange;", "(Lkotlin/ranges/IntRange;Ljava/lang/Integer;)Z", "Lkotlin/ranges/LongRange;", "(Lkotlin/ranges/LongRange;Ljava/lang/Long;)Z", "downTo", "Lkotlin/ranges/IntProgression;", "to", "Lkotlin/ranges/LongProgression;", "Lkotlin/ranges/CharProgression;", "random", "Lkotlin/random/Random;", "reversed", "step", "toByteExactOrNull", "(D)Ljava/lang/Byte;", "(F)Ljava/lang/Byte;", "(I)Ljava/lang/Byte;", "(J)Ljava/lang/Byte;", "(S)Ljava/lang/Byte;", "toIntExactOrNull", "(D)Ljava/lang/Integer;", "(F)Ljava/lang/Integer;", "(J)Ljava/lang/Integer;", "toLongExactOrNull", "(D)Ljava/lang/Long;", "(F)Ljava/lang/Long;", "toShortExactOrNull", "(D)Ljava/lang/Short;", "(F)Ljava/lang/Short;", "(I)Ljava/lang/Short;", "(J)Ljava/lang/Short;", "until", "kotlin-stdlib"}, eaR=1)
public class h
  extends g
{
  public static final boolean a(a<Integer> parama, float paramFloat)
  {
    AppMethodBeat.i(55984);
    j.q(parama, "receiver$0");
    Integer localInteger = e.bF(paramFloat);
    if (localInteger != null)
    {
      boolean bool = parama.contains((Comparable)localInteger);
      AppMethodBeat.o(55984);
      return bool;
    }
    AppMethodBeat.o(55984);
    return false;
  }
  
  public static final int aP(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(55987);
    if (paramInt2 > paramInt3)
    {
      Throwable localThrowable = (Throwable)new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + paramInt3 + " is less than minimum " + paramInt2 + '.');
      AppMethodBeat.o(55987);
      throw localThrowable;
    }
    if (paramInt1 < paramInt2)
    {
      AppMethodBeat.o(55987);
      return paramInt2;
    }
    if (paramInt1 > paramInt3)
    {
      AppMethodBeat.o(55987);
      return paramInt3;
    }
    AppMethodBeat.o(55987);
    return paramInt1;
  }
  
  public static final long ak(long paramLong1, long paramLong2)
  {
    if (paramLong1 < paramLong2) {
      return paramLong2;
    }
    return paramLong1;
  }
  
  public static final long al(long paramLong1, long paramLong2)
  {
    if (paramLong1 > paramLong2) {
      return paramLong2;
    }
    return paramLong1;
  }
  
  public static final Integer bF(float paramFloat)
  {
    AppMethodBeat.i(55985);
    if ((paramFloat >= -2.147484E+009F) && (paramFloat <= 2.147484E+009F))
    {
      int i = (int)paramFloat;
      AppMethodBeat.o(55985);
      return Integer.valueOf(i);
    }
    AppMethodBeat.o(55985);
    return null;
  }
  
  public static final d iD(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(55986);
    if (paramInt2 <= -2147483648)
    {
      localObject = d.BNC;
      localObject = d.ebm();
      AppMethodBeat.o(55986);
      return localObject;
    }
    Object localObject = new d(paramInt1, paramInt2 - 1);
    AppMethodBeat.o(55986);
    return localObject;
  }
  
  public static final int iE(int paramInt1, int paramInt2)
  {
    if (paramInt1 < paramInt2) {
      return paramInt2;
    }
    return paramInt1;
  }
  
  public static final int iF(int paramInt1, int paramInt2)
  {
    if (paramInt1 > paramInt2) {
      return paramInt2;
    }
    return paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     a.i.h
 * JD-Core Version:    0.7.0.1
 */