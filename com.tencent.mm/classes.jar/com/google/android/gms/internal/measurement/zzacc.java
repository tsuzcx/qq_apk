package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.charset.Charset;
import java.util.Arrays;

public final class zzacc
{
  private static final Charset ISO_8859_1;
  protected static final Charset UTF_8;
  public static final Object zzbxg;
  
  static
  {
    AppMethodBeat.i(3511);
    UTF_8 = Charset.forName("UTF-8");
    ISO_8859_1 = Charset.forName("ISO-8859-1");
    zzbxg = new Object();
    AppMethodBeat.o(3511);
  }
  
  public static boolean equals(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    AppMethodBeat.i(3504);
    if ((paramArrayOfInt1 == null) || (paramArrayOfInt1.length == 0))
    {
      if ((paramArrayOfInt2 == null) || (paramArrayOfInt2.length == 0))
      {
        AppMethodBeat.o(3504);
        return true;
      }
      AppMethodBeat.o(3504);
      return false;
    }
    boolean bool = Arrays.equals(paramArrayOfInt1, paramArrayOfInt2);
    AppMethodBeat.o(3504);
    return bool;
  }
  
  public static boolean equals(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    AppMethodBeat.i(3505);
    if ((paramArrayOfLong1 == null) || (paramArrayOfLong1.length == 0))
    {
      if ((paramArrayOfLong2 == null) || (paramArrayOfLong2.length == 0))
      {
        AppMethodBeat.o(3505);
        return true;
      }
      AppMethodBeat.o(3505);
      return false;
    }
    boolean bool = Arrays.equals(paramArrayOfLong1, paramArrayOfLong2);
    AppMethodBeat.o(3505);
    return bool;
  }
  
  public static boolean equals(Object[] paramArrayOfObject1, Object[] paramArrayOfObject2)
  {
    AppMethodBeat.i(3506);
    int k;
    if (paramArrayOfObject1 == null)
    {
      k = 0;
      if (paramArrayOfObject2 != null) {
        break label50;
      }
    }
    int j;
    int i;
    label50:
    for (int m = 0;; m = paramArrayOfObject2.length)
    {
      j = 0;
      i = 0;
      while ((i < k) && (paramArrayOfObject1[i] == null)) {
        i += 1;
      }
      k = paramArrayOfObject1.length;
      break;
    }
    for (;;)
    {
      if ((j < m) && (paramArrayOfObject2[j] == null))
      {
        j += 1;
      }
      else
      {
        int n;
        if (i >= k)
        {
          n = 1;
          if (j < m) {
            break label118;
          }
        }
        label118:
        for (int i1 = 1;; i1 = 0)
        {
          if ((n == 0) || (i1 == 0)) {
            break label124;
          }
          AppMethodBeat.o(3506);
          return true;
          n = 0;
          break;
        }
        label124:
        if (n != i1)
        {
          AppMethodBeat.o(3506);
          return false;
        }
        if (!paramArrayOfObject1[i].equals(paramArrayOfObject2[j]))
        {
          AppMethodBeat.o(3506);
          return false;
        }
        j += 1;
        i += 1;
        break;
      }
    }
  }
  
  public static int hashCode(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(3507);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length == 0))
    {
      AppMethodBeat.o(3507);
      return 0;
    }
    int i = Arrays.hashCode(paramArrayOfInt);
    AppMethodBeat.o(3507);
    return i;
  }
  
  public static int hashCode(long[] paramArrayOfLong)
  {
    AppMethodBeat.i(3508);
    if ((paramArrayOfLong == null) || (paramArrayOfLong.length == 0))
    {
      AppMethodBeat.o(3508);
      return 0;
    }
    int i = Arrays.hashCode(paramArrayOfLong);
    AppMethodBeat.o(3508);
    return i;
  }
  
  public static int hashCode(Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(3509);
    int j;
    int k;
    int i;
    if (paramArrayOfObject == null)
    {
      j = 0;
      k = 0;
      i = 0;
      label16:
      if (k >= j) {
        break label55;
      }
      Object localObject = paramArrayOfObject[k];
      if (localObject == null) {
        break label63;
      }
      i = localObject.hashCode() + i * 31;
    }
    label55:
    label63:
    for (;;)
    {
      k += 1;
      break label16;
      j = paramArrayOfObject.length;
      break;
      AppMethodBeat.o(3509);
      return i;
    }
  }
  
  public static void zza(zzaby paramzzaby1, zzaby paramzzaby2)
  {
    AppMethodBeat.i(3510);
    if (paramzzaby1.zzbww != null) {
      paramzzaby2.zzbww = ((zzaca)paramzzaby1.zzbww.clone());
    }
    AppMethodBeat.o(3510);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzacc
 * JD-Core Version:    0.7.0.1
 */