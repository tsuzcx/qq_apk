package androidx.compose.ui.n;

import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/unit/Constraints;", "", "value", "", "constructor-impl", "(J)J", "focusIndex", "", "getFocusIndex-impl", "(J)I", "hasBoundedHeight", "", "getHasBoundedHeight-impl", "(J)Z", "hasBoundedWidth", "getHasBoundedWidth-impl", "hasFixedHeight", "getHasFixedHeight$annotations", "()V", "getHasFixedHeight-impl", "hasFixedWidth", "getHasFixedWidth$annotations", "getHasFixedWidth-impl", "isZero", "isZero$annotations", "isZero-impl", "maxHeight", "getMaxHeight-impl", "maxWidth", "getMaxWidth-impl", "minHeight", "getMinHeight-impl", "minWidth", "getMinWidth-impl", "getValue$annotations", "copy", "copy-Zbe2FdA", "(JIIII)J", "equals", "other", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "Companion", "ui-unit_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final a beE;
  private static final int[] beF;
  private static final int[] beG;
  private static final int[] beH;
  public final long value;
  
  static
  {
    AppMethodBeat.i(204833);
    beE = new a((byte)0);
    beF = new int[] { 18, 20, 17, 15 };
    beG = new int[] { 65535, 262143, 32767, 8191 };
    beH = new int[] { 32767, 8191, 65535, 262143 };
    AppMethodBeat.o(204833);
  }
  
  public static String H(long paramLong)
  {
    AppMethodBeat.i(204776);
    int i = aU(paramLong);
    String str1;
    if (i == 2147483647)
    {
      str1 = "Infinity";
      i = aW(paramLong);
      if (i != 2147483647) {
        break label105;
      }
    }
    label105:
    for (String str2 = "Infinity";; str2 = String.valueOf(i))
    {
      str1 = "Constraints(minWidth = " + aT(paramLong) + ", maxWidth = " + str1 + ", minHeight = " + aV(paramLong) + ", maxHeight = " + str2 + ')';
      AppMethodBeat.o(204776);
      return str1;
      str1 = String.valueOf(i);
      break;
    }
  }
  
  public static int I(long paramLong)
  {
    AppMethodBeat.i(204783);
    int i = q.a..ExternalSyntheticBackport0.m(paramLong);
    AppMethodBeat.o(204783);
    return i;
  }
  
  public static long J(long paramLong)
  {
    return paramLong;
  }
  
  public static final int aT(long paramLong)
  {
    return beG[((int)(0x3 & paramLong))] & (int)(paramLong >> 2);
  }
  
  public static final int aU(long paramLong)
  {
    int i = beG[((int)(0x3 & paramLong))] & (int)(paramLong >> 33);
    if (i == 0) {
      return 2147483647;
    }
    return i - 1;
  }
  
  public static final int aV(long paramLong)
  {
    int i = (int)(0x3 & paramLong);
    int j = beH[i];
    return (int)(paramLong >> beF[i]) & j;
  }
  
  public static final int aW(long paramLong)
  {
    int i = (int)(0x3 & paramLong);
    int j = beH[i];
    i = (int)(paramLong >> beF[i] + 31) & j;
    if (i == 0) {
      return 2147483647;
    }
    return i - 1;
  }
  
  public static final boolean aX(long paramLong)
  {
    return (beG[((int)(0x3 & paramLong))] & (int)(paramLong >> 33)) != 0;
  }
  
  public static final boolean aY(long paramLong)
  {
    int i = (int)(0x3 & paramLong);
    int j = beH[i];
    return ((int)(paramLong >> beF[i] + 31) & j) != 0;
  }
  
  public static final boolean aZ(long paramLong)
  {
    AppMethodBeat.i(204744);
    if (aU(paramLong) == aT(paramLong))
    {
      AppMethodBeat.o(204744);
      return true;
    }
    AppMethodBeat.o(204744);
    return false;
  }
  
  public static final boolean ba(long paramLong)
  {
    AppMethodBeat.i(204757);
    if (aW(paramLong) == aV(paramLong))
    {
      AppMethodBeat.o(204757);
      return true;
    }
    AppMethodBeat.o(204757);
    return false;
  }
  
  public static final boolean e(long paramLong1, long paramLong2)
  {
    return paramLong1 == paramLong2;
  }
  
  public final boolean equals(Object paramObject)
  {
    long l = this.value;
    if (!(paramObject instanceof b)) {}
    while (l != ((b)paramObject).value) {
      return false;
    }
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(204848);
    int i = q.a..ExternalSyntheticBackport0.m(this.value);
    AppMethodBeat.o(204848);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(204840);
    String str = H(this.value);
    AppMethodBeat.o(204840);
    return str;
  }
  
  @Metadata(d1={""}, d2={"Landroidx/compose/ui/unit/Constraints$Companion;", "", "()V", "FocusMask", "", "HeightMask", "", "Infinity", "", "MaxFocusBits", "MaxFocusHeight", "MaxFocusMask", "MaxFocusWidth", "MaxNonFocusBits", "MaxNonFocusMask", "MinFocusBits", "MinFocusHeight", "MinFocusMask", "MinFocusWidth", "MinHeightOffsets", "MinNonFocusBits", "MinNonFocusMask", "WidthMask", "bitsNeedForSize", "size", "createConstraints", "Landroidx/compose/ui/unit/Constraints;", "minWidth", "maxWidth", "minHeight", "maxHeight", "createConstraints-Zbe2FdA$ui_unit_release", "(IIII)J", "fixed", "width", "height", "fixed-JhjzzOo", "(II)J", "fixedHeight", "fixedHeight-OenEA2s", "(I)J", "fixedWidth", "fixedWidth-OenEA2s", "ui-unit_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static long ak(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(204789);
      if ((paramInt1 >= 0) && (paramInt2 >= 0)) {}
      for (int i = 1; i == 0; i = 0)
      {
        Throwable localThrowable = (Throwable)new IllegalArgumentException(("width(" + paramInt1 + ") and height(" + paramInt2 + ") must be >= 0").toString());
        AppMethodBeat.o(204789);
        throw localThrowable;
      }
      long l = j(paramInt1, paramInt1, paramInt2, paramInt2);
      AppMethodBeat.o(204789);
      return l;
    }
    
    private static int dF(int paramInt)
    {
      AppMethodBeat.i(204814);
      if (paramInt < 8191)
      {
        AppMethodBeat.o(204814);
        return 13;
      }
      if (paramInt < 32767)
      {
        AppMethodBeat.o(204814);
        return 15;
      }
      if (paramInt < 65535)
      {
        AppMethodBeat.o(204814);
        return 16;
      }
      if (paramInt < 262143)
      {
        AppMethodBeat.o(204814);
        return 18;
      }
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("Can't represent a size of " + paramInt + " in Constraints");
      AppMethodBeat.o(204814);
      throw localIllegalArgumentException;
    }
    
    public static long j(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(204805);
      int i;
      int k;
      if (paramInt4 == 2147483647)
      {
        i = paramInt3;
        k = dF(i);
        if (paramInt2 != 2147483647) {
          break label102;
        }
      }
      int m;
      Object localObject;
      label102:
      for (int j = paramInt1;; j = paramInt2)
      {
        m = dF(j);
        if (k + m <= 31) {
          break label108;
        }
        localObject = new IllegalArgumentException("Can't represent a width of " + j + " and height of " + i + " in Constraints");
        AppMethodBeat.o(204805);
        throw ((Throwable)localObject);
        i = paramInt4;
        break;
      }
      label108:
      long l1;
      switch (m)
      {
      case 14: 
      case 17: 
      default: 
        localObject = new IllegalStateException("Should only have the provided constants.");
        AppMethodBeat.o(204805);
        throw ((Throwable)localObject);
      case 15: 
        l1 = 2L;
        if (paramInt2 == 2147483647)
        {
          paramInt2 = 0;
          label180:
          if (paramInt4 != 2147483647) {
            break label277;
          }
          paramInt4 = 0;
        }
        break;
      }
      for (;;)
      {
        i = b.Cf()[((int)l1)];
        long l2 = paramInt1;
        long l3 = paramInt2;
        long l4 = paramInt3;
        l1 = b.J(paramInt4 << i + 31 | l1 | l2 << 2 | l3 << 33 | l4 << i);
        AppMethodBeat.o(204805);
        return l1;
        l1 = 0L;
        break;
        l1 = 3L;
        break;
        l1 = 1L;
        break;
        paramInt2 += 1;
        break label180;
        label277:
        paramInt4 += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.n.b
 * JD-Core Version:    0.7.0.1
 */