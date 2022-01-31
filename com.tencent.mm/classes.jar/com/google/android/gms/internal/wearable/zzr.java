package com.google.android.gms.internal.wearable;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.charset.Charset;
import java.util.Arrays;

public final class zzr
{
  private static final Charset ISO_8859_1;
  protected static final Charset UTF_8;
  public static final Object zzhk;
  
  static
  {
    AppMethodBeat.i(70775);
    UTF_8 = Charset.forName("UTF-8");
    ISO_8859_1 = Charset.forName("ISO-8859-1");
    zzhk = new Object();
    AppMethodBeat.o(70775);
  }
  
  public static boolean equals(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    AppMethodBeat.i(70769);
    if ((paramArrayOfFloat1 == null) || (paramArrayOfFloat1.length == 0))
    {
      if ((paramArrayOfFloat2 == null) || (paramArrayOfFloat2.length == 0))
      {
        AppMethodBeat.o(70769);
        return true;
      }
      AppMethodBeat.o(70769);
      return false;
    }
    boolean bool = Arrays.equals(paramArrayOfFloat1, paramArrayOfFloat2);
    AppMethodBeat.o(70769);
    return bool;
  }
  
  public static boolean equals(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    AppMethodBeat.i(70768);
    if ((paramArrayOfLong1 == null) || (paramArrayOfLong1.length == 0))
    {
      if ((paramArrayOfLong2 == null) || (paramArrayOfLong2.length == 0))
      {
        AppMethodBeat.o(70768);
        return true;
      }
      AppMethodBeat.o(70768);
      return false;
    }
    boolean bool = Arrays.equals(paramArrayOfLong1, paramArrayOfLong2);
    AppMethodBeat.o(70768);
    return bool;
  }
  
  public static boolean equals(Object[] paramArrayOfObject1, Object[] paramArrayOfObject2)
  {
    AppMethodBeat.i(70770);
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
          AppMethodBeat.o(70770);
          return true;
          n = 0;
          break;
        }
        label122:
        if (n != i1)
        {
          AppMethodBeat.o(70770);
          return false;
        }
        if (!paramArrayOfObject1[i].equals(paramArrayOfObject2[j]))
        {
          AppMethodBeat.o(70770);
          return false;
        }
        j += 1;
        i += 1;
        break;
      }
    }
  }
  
  public static int hashCode(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(70772);
    if ((paramArrayOfFloat == null) || (paramArrayOfFloat.length == 0))
    {
      AppMethodBeat.o(70772);
      return 0;
    }
    int i = Arrays.hashCode(paramArrayOfFloat);
    AppMethodBeat.o(70772);
    return i;
  }
  
  public static int hashCode(long[] paramArrayOfLong)
  {
    AppMethodBeat.i(70771);
    if ((paramArrayOfLong == null) || (paramArrayOfLong.length == 0))
    {
      AppMethodBeat.o(70771);
      return 0;
    }
    int i = Arrays.hashCode(paramArrayOfLong);
    AppMethodBeat.o(70771);
    return i;
  }
  
  public static int hashCode(Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(70773);
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
      AppMethodBeat.o(70773);
      return i;
    }
  }
  
  public static void zza(zzn paramzzn1, zzn paramzzn2)
  {
    AppMethodBeat.i(70774);
    if (paramzzn1.zzhc != null) {
      paramzzn2.zzhc = ((zzp)paramzzn1.zzhc.clone());
    }
    AppMethodBeat.o(70774);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.internal.wearable.zzr
 * JD-Core Version:    0.7.0.1
 */