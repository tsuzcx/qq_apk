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
    AppMethodBeat.i(40301);
    UTF_8 = Charset.forName("UTF-8");
    ISO_8859_1 = Charset.forName("ISO-8859-1");
    zzbxg = new Object();
    AppMethodBeat.o(40301);
  }
  
  public static boolean equals(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    AppMethodBeat.i(40294);
    if ((paramArrayOfInt1 == null) || (paramArrayOfInt1.length == 0))
    {
      if ((paramArrayOfInt2 == null) || (paramArrayOfInt2.length == 0))
      {
        AppMethodBeat.o(40294);
        return true;
      }
      AppMethodBeat.o(40294);
      return false;
    }
    boolean bool = Arrays.equals(paramArrayOfInt1, paramArrayOfInt2);
    AppMethodBeat.o(40294);
    return bool;
  }
  
  public static boolean equals(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    AppMethodBeat.i(40295);
    if ((paramArrayOfLong1 == null) || (paramArrayOfLong1.length == 0))
    {
      if ((paramArrayOfLong2 == null) || (paramArrayOfLong2.length == 0))
      {
        AppMethodBeat.o(40295);
        return true;
      }
      AppMethodBeat.o(40295);
      return false;
    }
    boolean bool = Arrays.equals(paramArrayOfLong1, paramArrayOfLong2);
    AppMethodBeat.o(40295);
    return bool;
  }
  
  public static boolean equals(Object[] paramArrayOfObject1, Object[] paramArrayOfObject2)
  {
    AppMethodBeat.i(40296);
    int k;
    if (paramArrayOfObject1 == null)
    {
      k = 0;
      if (paramArrayOfObject2 != null) {
        break label49;
      }
    }
    int j;
    int i;
    label49:
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
            break label116;
          }
        }
        label116:
        for (int i1 = 1;; i1 = 0)
        {
          if ((n == 0) || (i1 == 0)) {
            break label122;
          }
          AppMethodBeat.o(40296);
          return true;
          n = 0;
          break;
        }
        label122:
        if (n != i1)
        {
          AppMethodBeat.o(40296);
          return false;
        }
        if (!paramArrayOfObject1[i].equals(paramArrayOfObject2[j]))
        {
          AppMethodBeat.o(40296);
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
    AppMethodBeat.i(40297);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length == 0))
    {
      AppMethodBeat.o(40297);
      return 0;
    }
    int i = Arrays.hashCode(paramArrayOfInt);
    AppMethodBeat.o(40297);
    return i;
  }
  
  public static int hashCode(long[] paramArrayOfLong)
  {
    AppMethodBeat.i(40298);
    if ((paramArrayOfLong == null) || (paramArrayOfLong.length == 0))
    {
      AppMethodBeat.o(40298);
      return 0;
    }
    int i = Arrays.hashCode(paramArrayOfLong);
    AppMethodBeat.o(40298);
    return i;
  }
  
  public static int hashCode(Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(40299);
    int j;
    int k;
    int i;
    if (paramArrayOfObject == null)
    {
      j = 0;
      k = 0;
      i = 0;
      label15:
      if (k >= j) {
        break label54;
      }
      Object localObject = paramArrayOfObject[k];
      if (localObject == null) {
        break label61;
      }
      i = localObject.hashCode() + i * 31;
    }
    label54:
    label61:
    for (;;)
    {
      k += 1;
      break label15;
      j = paramArrayOfObject.length;
      break;
      AppMethodBeat.o(40299);
      return i;
    }
  }
  
  public static void zza(zzaby paramzzaby1, zzaby paramzzaby2)
  {
    AppMethodBeat.i(40300);
    if (paramzzaby1.zzbww != null) {
      paramzzaby2.zzbww = ((zzaca)paramzzaby1.zzbww.clone());
    }
    AppMethodBeat.o(40300);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzacc
 * JD-Core Version:    0.7.0.1
 */