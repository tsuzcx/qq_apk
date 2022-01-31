package com.google.android.gms.common.util;

import com.google.android.gms.common.internal.zzaa;
import java.util.ArrayList;
import java.util.Arrays;

public final class zzb
{
  public static <T> int zza(T[] paramArrayOfT, T paramT)
  {
    int j = 0;
    int i;
    if (paramArrayOfT != null) {
      i = paramArrayOfT.length;
    }
    while (j < i) {
      if (zzaa.equal(paramArrayOfT[j], paramT))
      {
        return j;
        i = 0;
      }
      else
      {
        j += 1;
      }
    }
    return -1;
  }
  
  public static void zza(StringBuilder paramStringBuilder, double[] paramArrayOfDouble)
  {
    int j = paramArrayOfDouble.length;
    int i = 0;
    while (i < j)
    {
      if (i != 0) {
        paramStringBuilder.append(",");
      }
      paramStringBuilder.append(Double.toString(paramArrayOfDouble[i]));
      i += 1;
    }
  }
  
  public static void zza(StringBuilder paramStringBuilder, float[] paramArrayOfFloat)
  {
    int j = paramArrayOfFloat.length;
    int i = 0;
    while (i < j)
    {
      if (i != 0) {
        paramStringBuilder.append(",");
      }
      paramStringBuilder.append(Float.toString(paramArrayOfFloat[i]));
      i += 1;
    }
  }
  
  public static void zza(StringBuilder paramStringBuilder, int[] paramArrayOfInt)
  {
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      if (i != 0) {
        paramStringBuilder.append(",");
      }
      paramStringBuilder.append(Integer.toString(paramArrayOfInt[i]));
      i += 1;
    }
  }
  
  public static void zza(StringBuilder paramStringBuilder, long[] paramArrayOfLong)
  {
    int j = paramArrayOfLong.length;
    int i = 0;
    while (i < j)
    {
      if (i != 0) {
        paramStringBuilder.append(",");
      }
      paramStringBuilder.append(Long.toString(paramArrayOfLong[i]));
      i += 1;
    }
  }
  
  public static <T> void zza(StringBuilder paramStringBuilder, T[] paramArrayOfT)
  {
    int j = paramArrayOfT.length;
    int i = 0;
    while (i < j)
    {
      if (i != 0) {
        paramStringBuilder.append(",");
      }
      paramStringBuilder.append(paramArrayOfT[i].toString());
      i += 1;
    }
  }
  
  public static void zza(StringBuilder paramStringBuilder, String[] paramArrayOfString)
  {
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (i != 0) {
        paramStringBuilder.append(",");
      }
      paramStringBuilder.append("\"").append(paramArrayOfString[i]).append("\"");
      i += 1;
    }
  }
  
  public static void zza(StringBuilder paramStringBuilder, boolean[] paramArrayOfBoolean)
  {
    int j = paramArrayOfBoolean.length;
    int i = 0;
    while (i < j)
    {
      if (i != 0) {
        paramStringBuilder.append(",");
      }
      paramStringBuilder.append(Boolean.toString(paramArrayOfBoolean[i]));
      i += 1;
    }
  }
  
  public static byte[] zza(byte[]... paramVarArgs)
  {
    if (paramVarArgs.length == 0) {
      return new byte[0];
    }
    int i = 0;
    int j = 0;
    while (i < paramVarArgs.length)
    {
      j += paramVarArgs[i].length;
      i += 1;
    }
    byte[] arrayOfByte1 = Arrays.copyOf(paramVarArgs[0], j);
    j = paramVarArgs[0].length;
    i = 1;
    while (i < paramVarArgs.length)
    {
      byte[] arrayOfByte2 = paramVarArgs[i];
      System.arraycopy(arrayOfByte2, 0, arrayOfByte1, j, arrayOfByte2.length);
      j += arrayOfByte2.length;
      i += 1;
    }
    return arrayOfByte1;
  }
  
  public static Integer[] zza(int[] paramArrayOfInt)
  {
    Object localObject;
    if (paramArrayOfInt == null)
    {
      localObject = null;
      return localObject;
    }
    int j = paramArrayOfInt.length;
    Integer[] arrayOfInteger = new Integer[j];
    int i = 0;
    for (;;)
    {
      localObject = arrayOfInteger;
      if (i >= j) {
        break;
      }
      arrayOfInteger[i] = Integer.valueOf(paramArrayOfInt[i]);
      i += 1;
    }
  }
  
  public static <T> ArrayList<T> zzb(T[] paramArrayOfT)
  {
    int j = paramArrayOfT.length;
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      localArrayList.add(paramArrayOfT[i]);
      i += 1;
    }
    return localArrayList;
  }
  
  public static <T> boolean zzb(T[] paramArrayOfT, T paramT)
  {
    return zza(paramArrayOfT, paramT) >= 0;
  }
  
  public static <T> ArrayList<T> zzyY()
  {
    return new ArrayList();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.common.util.zzb
 * JD-Core Version:    0.7.0.1
 */