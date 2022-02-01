package androidx.compose.ui.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.m;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/graphics/Float16;", "", "value", "", "constructor-impl", "(F)S", "", "(D)S", "halfValue", "", "(S)S", "exponent", "", "getExponent-impl", "(S)I", "getHalfValue", "()S", "sign", "getSign-slo4al4", "significand", "getSignificand-impl", "absoluteValue", "absoluteValue-slo4al4", "ceil", "ceil-slo4al4", "compareTo", "other", "compareTo-41bOqos", "(SS)I", "equals", "", "", "equals-impl", "(SLjava/lang/Object;)Z", "floor", "floor-slo4al4", "hashCode", "hashCode-impl", "isFinite", "isFinite-impl", "(S)Z", "isInfinite", "isInfinite-impl", "isNaN", "isNaN-impl", "isNormalized", "isNormalized-impl", "round", "round-slo4al4", "toBits", "toBits-impl", "toByte", "", "toByte-impl", "(S)B", "toDouble", "toDouble-impl", "(S)D", "toFloat", "toFloat-impl", "(S)F", "toHexString", "", "toHexString-impl", "(S)Ljava/lang/String;", "toInt", "toInt-impl", "toLong", "", "toLong-impl", "(S)J", "toRawBits", "toRawBits-impl", "toShort", "toShort-impl", "toString", "toString-impl", "trunc", "trunc-slo4al4", "withSign", "withSign-qCeQghg", "(SS)S", "Companion", "ui-graphics_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ac
  implements Comparable<ac>
{
  public static final ac.a awZ;
  private static final short axa;
  private static final short axb;
  private static final short axc;
  private static final short axd;
  private static final short axe;
  private static final short axf;
  private static final short axg;
  private static final short axh;
  private static final short axi;
  private static final short axj;
  private static final short axk;
  private static final short axl;
  private static final float axm;
  
  static
  {
    AppMethodBeat.i(206274);
    awZ = new ac.a((byte)0);
    axa = 5120;
    axb = -1025;
    axc = 31743;
    axd = 1024;
    axe = 1;
    axf = 32256;
    axg = -1024;
    axh = -32768;
    axi = 31744;
    axj = 0;
    axk = L(1.0F);
    axl = L(-1.0F);
    m localm = m.aiwV;
    axm = Float.intBitsToFloat(1056964608);
    AppMethodBeat.o(206274);
  }
  
  public static short L(float paramFloat)
  {
    int j = 31;
    int i = 0;
    AppMethodBeat.i(206267);
    int m = Float.floatToRawIntBits(paramFloat);
    int k = m >>> 31;
    int n = m >>> 23 & 0xFF;
    m &= 0x7FFFFF;
    if (n == 255) {
      if (m != 0) {
        i = 512;
      }
    }
    for (;;)
    {
      short s = (short)(k << 15 | j << 10 | i);
      AppMethodBeat.o(206267);
      return s;
      j = n - 127 + 15;
      if (j >= 31)
      {
        j = 49;
        i = 0;
      }
      else
      {
        if (j <= 0)
        {
          if (j >= -10)
          {
            j = (m | 0x800000) >> 1 - j;
            i = j;
            if ((j & 0x1000) != 0) {
              i = j + 8192;
            }
            i >>= 13;
            j = 0;
          }
        }
        else
        {
          i = m >> 13;
          if ((m & 0x1000) != 0)
          {
            s = (short)((i | j << 10) + 1 | k << 15);
            AppMethodBeat.o(206267);
            return s;
          }
          continue;
        }
        i = 0;
        j = 0;
      }
    }
  }
  
  public static final float c(short paramShort)
  {
    AppMethodBeat.i(206271);
    int i = 0xFFFF & paramShort;
    int j = i & 0x8000;
    paramShort = i >>> 10 & 0x1F;
    i &= 0x3FF;
    m localm;
    float f;
    if (paramShort == 0)
    {
      if (i != 0)
      {
        localm = m.aiwV;
        f = Float.intBitsToFloat(i + 1056964608) - axm;
        if (j == 0)
        {
          AppMethodBeat.o(206271);
          return f;
        }
        f = -f;
        AppMethodBeat.o(206271);
        return f;
      }
    }
    else
    {
      i <<= 13;
      if (paramShort == 31)
      {
        if (i == 0) {
          break label137;
        }
        i |= 0x400000;
        paramShort = 255;
      }
    }
    for (;;)
    {
      localm = m.aiwV;
      f = Float.intBitsToFloat(i | j << 16 | paramShort << 23);
      AppMethodBeat.o(206271);
      return f;
      paramShort = paramShort - 15 + 127;
      continue;
      label137:
      paramShort = 255;
      continue;
      i = 0;
      paramShort = 0;
    }
  }
  
  public static short d(short paramShort)
  {
    return paramShort;
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
 * Qualified Name:     androidx.compose.ui.e.ac
 * JD-Core Version:    0.7.0.1
 */