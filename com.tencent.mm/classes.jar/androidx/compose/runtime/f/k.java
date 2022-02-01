package androidx.compose.runtime.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"lowestBitOf", "", "bits", "", "binarySearch", "", "value", "runtime_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class k
{
  static final int C(long paramLong)
  {
    int j = 32;
    if ((0xFFFFFFFF & paramLong) == 0L) {}
    for (long l = paramLong >> 32;; l = paramLong)
    {
      int i = j;
      paramLong = l;
      if ((0xFFFF & l) == 0L)
      {
        i = j + 16;
        paramLong = l >> 16;
      }
      j = i;
      l = paramLong;
      if ((0xFF & paramLong) == 0L)
      {
        j = i + 8;
        l = paramLong >> 8;
      }
      i = j;
      paramLong = l;
      if ((0xF & l) == 0L)
      {
        i = j + 4;
        paramLong = l >> 4;
      }
      if ((1L & paramLong) != 0L) {
        return i;
      }
      if ((0x2 & paramLong) != 0L) {
        return i + 1;
      }
      if ((0x4 & paramLong) != 0L) {
        return i + 2;
      }
      if ((paramLong & 0x8) != 0L) {
        return i + 3;
      }
      return -1;
      j = 0;
    }
  }
  
  public static final int p(int[] paramArrayOfInt, int paramInt)
  {
    AppMethodBeat.i(202497);
    s.u(paramArrayOfInt, "<this>");
    int i = 0;
    int j = paramArrayOfInt.length - 1;
    while (i <= j)
    {
      int k = i + j >>> 1;
      int m = paramArrayOfInt[k];
      if (paramInt > m)
      {
        i = k + 1;
      }
      else if (paramInt < m)
      {
        j = k - 1;
      }
      else
      {
        AppMethodBeat.o(202497);
        return k;
      }
    }
    paramInt = -(i + 1);
    AppMethodBeat.o(202497);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.runtime.f.k
 * JD-Core Version:    0.7.0.1
 */