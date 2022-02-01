package com.tencent.util;

import java.lang.reflect.Array;

public class DesUtils
{
  public static final int a = 1;
  public static final byte[] a;
  private static final int[] jdField_a_of_type_ArrayOfInt = { 58, 50, 42, 34, 26, 18, 10, 2, 60, 52, 44, 36, 28, 20, 12, 4, 62, 54, 46, 38, 30, 22, 14, 6, 64, 56, 48, 40, 32, 24, 16, 8, 57, 49, 41, 33, 25, 17, 9, 1, 59, 51, 43, 35, 27, 19, 11, 3, 61, 53, 45, 37, 29, 21, 13, 5, 63, 55, 47, 39, 31, 23, 15, 7 };
  private static final int[][][] jdField_a_of_type_Array3dOfInt;
  public static final int b = 0;
  public static final byte[] b;
  private static final int[] b;
  public static final byte[] c;
  private static final int[] c;
  public static final byte[] d;
  private static final int[] d;
  public static final byte[] e;
  private static final int[] e;
  private static final int[] f;
  private static final int[] g;
  
  static
  {
    jdField_b_of_type_ArrayOfInt = new int[] { 40, 8, 48, 16, 56, 24, 64, 32, 39, 7, 47, 15, 55, 23, 63, 31, 38, 6, 46, 14, 54, 22, 62, 30, 37, 5, 45, 13, 53, 21, 61, 29, 36, 4, 44, 12, 52, 20, 60, 28, 35, 3, 43, 11, 51, 19, 59, 27, 34, 2, 42, 10, 50, 18, 58, 26, 33, 1, 41, 9, 49, 17, 57, 25 };
    jdField_c_of_type_ArrayOfInt = new int[] { 57, 49, 41, 33, 25, 17, 9, 1, 58, 50, 42, 34, 26, 18, 10, 2, 59, 51, 43, 35, 27, 19, 11, 3, 60, 52, 44, 36, 63, 55, 47, 39, 31, 23, 15, 7, 62, 54, 46, 38, 30, 22, 14, 6, 61, 53, 45, 37, 29, 21, 13, 5, 28, 20, 12, 4 };
    jdField_d_of_type_ArrayOfInt = new int[] { 14, 17, 11, 24, 1, 5, 3, 28, 15, 6, 21, 10, 23, 19, 12, 4, 26, 8, 16, 7, 27, 20, 13, 2, 41, 52, 31, 37, 47, 55, 30, 40, 51, 45, 33, 48, 44, 49, 39, 56, 34, 53, 46, 42, 50, 36, 29, 32 };
    jdField_e_of_type_ArrayOfInt = new int[] { 32, 1, 2, 3, 4, 5, 4, 5, 6, 7, 8, 9, 8, 9, 10, 11, 12, 13, 12, 13, 14, 15, 16, 17, 16, 17, 18, 19, 20, 21, 20, 21, 22, 23, 24, 25, 24, 25, 26, 27, 28, 29, 28, 29, 30, 31, 32, 1 };
    f = new int[] { 16, 7, 20, 21, 29, 12, 28, 17, 1, 15, 23, 26, 5, 18, 31, 10, 2, 8, 24, 14, 32, 27, 3, 9, 19, 13, 30, 6, 22, 11, 4, 25 };
    int[][] arrayOfInt1 = { { 14, 4, 13, 1, 2, 15, 11, 8, 3, 10, 6, 12, 5, 9, 0, 7 }, { 0, 15, 7, 4, 14, 2, 13, 1, 10, 6, 12, 11, 9, 5, 3, 8 }, { 4, 1, 14, 8, 13, 6, 2, 11, 15, 12, 9, 7, 3, 10, 5, 0 }, { 15, 12, 8, 2, 4, 9, 1, 7, 5, 11, 3, 14, 10, 0, 6, 13 } };
    int[][] arrayOfInt2 = { { 15, 1, 8, 14, 6, 11, 3, 4, 9, 7, 2, 13, 12, 0, 5, 10 }, { 3, 13, 4, 7, 15, 2, 8, 14, 12, 0, 1, 10, 6, 9, 11, 5 }, { 0, 14, 7, 11, 10, 4, 13, 1, 5, 8, 12, 6, 9, 3, 2, 15 }, { 13, 8, 10, 1, 3, 15, 4, 2, 11, 6, 7, 12, 0, 5, 14, 9 } };
    int[][] arrayOfInt3 = { { 10, 0, 9, 14, 6, 3, 15, 5, 1, 13, 12, 7, 11, 4, 2, 8 }, { 13, 7, 0, 9, 3, 4, 6, 10, 2, 8, 5, 14, 12, 11, 15, 1 }, { 13, 6, 4, 9, 8, 15, 3, 0, 11, 1, 2, 12, 5, 10, 14, 7 }, { 1, 10, 13, 0, 6, 9, 8, 7, 4, 15, 14, 3, 11, 5, 2, 12 } };
    Object localObject = { 13, 8, 11, 5, 6, 15, 0, 3, 4, 7, 2, 12, 1, 10, 14, 9 };
    int[] arrayOfInt4 = { 10, 6, 9, 0, 12, 11, 7, 13, 15, 1, 3, 14, 5, 2, 8, 4 };
    localObject = new int[][] { { 7, 13, 14, 3, 0, 6, 9, 10, 1, 2, 8, 5, 11, 12, 4, 15 }, localObject, arrayOfInt4, { 3, 15, 0, 6, 10, 1, 13, 8, 9, 4, 5, 11, 12, 7, 2, 14 } };
    int[] arrayOfInt7 = { 2, 12, 4, 1, 7, 10, 11, 6, 8, 5, 3, 15, 13, 0, 14, 9 };
    int[] arrayOfInt8 = { 14, 11, 2, 12, 4, 7, 13, 1, 5, 0, 15, 10, 3, 9, 8, 6 };
    arrayOfInt4 = new int[] { 12, 1, 10, 15, 9, 2, 6, 8, 0, 13, 3, 4, 14, 7, 5, 11 };
    int[] arrayOfInt5 = { 9, 14, 15, 5, 2, 8, 12, 3, 7, 0, 4, 10, 1, 13, 11, 6 };
    int[] arrayOfInt6 = { 4, 3, 2, 12, 9, 5, 15, 10, 11, 14, 1, 7, 6, 0, 8, 13 };
    int[] arrayOfInt10 = { 4, 11, 2, 14, 15, 0, 8, 13, 3, 12, 9, 7, 5, 10, 6, 1 };
    int[] arrayOfInt11 = { 13, 0, 11, 7, 4, 9, 1, 10, 14, 3, 5, 12, 2, 15, 8, 6 };
    int[] arrayOfInt12 = { 1, 4, 11, 13, 12, 3, 7, 14, 10, 15, 6, 8, 0, 5, 9, 2 };
    int[] arrayOfInt13 = { 6, 11, 13, 8, 1, 4, 10, 7, 9, 5, 0, 15, 14, 2, 3, 12 };
    int[] arrayOfInt9 = { 7, 11, 4, 1, 9, 12, 14, 2, 0, 6, 10, 13, 15, 3, 5, 8 };
    jdField_a_of_type_Array3dOfInt = new int[][][] { arrayOfInt1, arrayOfInt2, arrayOfInt3, localObject, { arrayOfInt7, arrayOfInt8, { 4, 2, 1, 11, 10, 13, 7, 8, 15, 9, 12, 5, 6, 3, 0, 14 }, { 11, 8, 12, 7, 1, 14, 2, 13, 6, 15, 0, 9, 10, 4, 5, 3 } }, { arrayOfInt4, { 10, 15, 4, 2, 7, 12, 9, 5, 6, 1, 13, 14, 0, 11, 3, 8 }, arrayOfInt5, arrayOfInt6 }, { arrayOfInt10, arrayOfInt11, arrayOfInt12, arrayOfInt13 }, { { 13, 2, 8, 4, 6, 15, 11, 1, 10, 9, 3, 14, 5, 0, 12, 7 }, { 1, 15, 13, 8, 10, 3, 7, 4, 12, 5, 6, 11, 0, 14, 9, 2 }, arrayOfInt9, { 2, 1, 14, 7, 4, 10, 8, 13, 15, 12, 9, 0, 3, 5, 6, 11 } } };
    g = new int[] { 1, 1, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 1 };
    jdField_a_of_type_ArrayOfByte = new byte[] { 98, -24, 57, -84, -115, 117, 55, 121 };
    jdField_b_of_type_ArrayOfByte = new byte[] { -25, -101, -115, 1, 47, 7, -27, -59, 18, -128, 123, 79, -44, 37, 46, 115 };
    jdField_c_of_type_ArrayOfByte = new byte[] { 37, -110, 60, 127, 42, -27, -17, -110 };
    jdField_d_of_type_ArrayOfByte = new byte[] { -122, -8, -23, -84, -125, 113, 84, 99 };
    jdField_e_of_type_ArrayOfByte = "AL!#$AC9Ahg@KLJ1".getBytes();
  }
  
  private static void a(int[] paramArrayOfInt, int paramInt)
  {
    int j = 0;
    int[] arrayOfInt1 = new int[28];
    int[] arrayOfInt2 = new int[28];
    int[] arrayOfInt3 = new int[28];
    int[] arrayOfInt4 = new int[28];
    int i = 0;
    while (i < 28)
    {
      arrayOfInt1[i] = paramArrayOfInt[i];
      arrayOfInt2[i] = paramArrayOfInt[(i + 28)];
      i += 1;
    }
    if (paramInt == 1)
    {
      paramInt = 0;
      while (paramInt < 27)
      {
        arrayOfInt3[paramInt] = arrayOfInt1[(paramInt + 1)];
        arrayOfInt4[paramInt] = arrayOfInt2[(paramInt + 1)];
        paramInt += 1;
      }
      arrayOfInt3[27] = arrayOfInt1[0];
      arrayOfInt4[27] = arrayOfInt2[0];
      i = j;
    }
    while (i < 28)
    {
      paramArrayOfInt[i] = arrayOfInt3[i];
      paramArrayOfInt[(i + 28)] = arrayOfInt4[i];
      i += 1;
      continue;
      i = j;
      if (paramInt == 2)
      {
        paramInt = 0;
        while (paramInt < 26)
        {
          arrayOfInt3[paramInt] = arrayOfInt1[(paramInt + 2)];
          arrayOfInt4[paramInt] = arrayOfInt2[(paramInt + 2)];
          paramInt += 1;
        }
        arrayOfInt3[26] = arrayOfInt1[0];
        arrayOfInt4[26] = arrayOfInt2[0];
        arrayOfInt3[27] = arrayOfInt1[1];
        arrayOfInt4[27] = arrayOfInt2[1];
        i = j;
      }
    }
  }
  
  private static void a(int[] paramArrayOfInt, int paramInt1, int paramInt2, int[][] paramArrayOfInt1)
  {
    int[] arrayOfInt1 = new int[32];
    int[] arrayOfInt2 = new int[32];
    int[] arrayOfInt3 = new int[32];
    int[] arrayOfInt4 = new int[32];
    int[] arrayOfInt5 = new int[48];
    int[][] arrayOfInt = (int[][])Array.newInstance(Integer.TYPE, new int[] { 8, 6 });
    int[] arrayOfInt6 = new int[8];
    int[] arrayOfInt7 = new int[32];
    int[] arrayOfInt8 = new int[32];
    int i = 0;
    while (i < 32)
    {
      arrayOfInt1[i] = paramArrayOfInt[i];
      arrayOfInt2[i] = paramArrayOfInt[(i + 32)];
      i += 1;
    }
    i = 0;
    if (i < 48)
    {
      arrayOfInt5[i] = arrayOfInt2[(jdField_e_of_type_ArrayOfInt[i] - 1)];
      arrayOfInt5[i] += paramArrayOfInt1[paramInt1][i];
      if (arrayOfInt5[i] != 2) {}
      for (;;)
      {
        i += 1;
        break;
        arrayOfInt5[i] = 0;
      }
    }
    i = 0;
    while (i < 8)
    {
      int j = 0;
      while (j < 6)
      {
        arrayOfInt[i][j] = arrayOfInt5[(i * 6 + j)];
        j += 1;
      }
      arrayOfInt6[i] = jdField_a_of_type_Array3dOfInt[i][((arrayOfInt[i][0] << 1) + arrayOfInt[i][5])][((arrayOfInt[i][1] << 3) + (arrayOfInt[i][2] << 2) + (arrayOfInt[i][3] << 1) + arrayOfInt[i][4])];
      j = 0;
      while (j < 4)
      {
        arrayOfInt7[(i * 4 + 3 - j)] = (arrayOfInt6[i] % 2);
        arrayOfInt6[i] /= 2;
        j += 1;
      }
      i += 1;
    }
    i = 0;
    if (i < 32)
    {
      arrayOfInt8[i] = arrayOfInt7[(f[i] - 1)];
      arrayOfInt3[i] = arrayOfInt2[i];
      arrayOfInt1[i] += arrayOfInt8[i];
      if (arrayOfInt4[i] == 2) {
        arrayOfInt4[i] = 0;
      }
      if (((paramInt2 == 0) && (paramInt1 == 0)) || ((paramInt2 == 1) && (paramInt1 == 15)))
      {
        paramArrayOfInt[i] = arrayOfInt4[i];
        paramArrayOfInt[(i + 32)] = arrayOfInt3[i];
      }
      for (;;)
      {
        i += 1;
        break;
        paramArrayOfInt[i] = arrayOfInt3[i];
        paramArrayOfInt[(i + 32)] = arrayOfInt4[i];
      }
    }
  }
  
  private static void a(int[] paramArrayOfInt, byte[] paramArrayOfByte)
  {
    int i = 0;
    while (i < 8)
    {
      int j = 0;
      while (j < 8)
      {
        paramArrayOfByte[i] = ((byte)(paramArrayOfByte[i] + (paramArrayOfInt[((i << 3) + j)] << 7 - j)));
        j += 1;
      }
      i += 1;
    }
  }
  
  private static void a(int[] paramArrayOfInt, int[][] paramArrayOfInt1)
  {
    int[] arrayOfInt = new int[56];
    int i = 0;
    while (i < 56)
    {
      arrayOfInt[i] = paramArrayOfInt[(jdField_c_of_type_ArrayOfInt[i] - 1)];
      i += 1;
    }
    i = 0;
    while (i < 16)
    {
      a(arrayOfInt, g[i]);
      int j = 0;
      while (j < 48)
      {
        paramArrayOfInt1[i][j] = arrayOfInt[(jdField_d_of_type_ArrayOfInt[j] - 1)];
        j += 1;
      }
      i += 1;
    }
  }
  
  private static byte[] a(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte.length;
    int j = 8 - i % 8;
    int k = i + j;
    byte[] arrayOfByte = new byte[k];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, i);
    while (i < k)
    {
      arrayOfByte[i] = ((byte)j);
      i += 1;
    }
    return arrayOfByte;
  }
  
  public static byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt)
  {
    int j = 0;
    if ((paramArrayOfByte2 == null) || (paramArrayOfByte1 == null)) {
      return paramArrayOfByte2;
    }
    for (;;)
    {
      try
      {
        paramArrayOfByte1 = b(paramArrayOfByte1);
        byte[] arrayOfByte2 = a(paramArrayOfByte2);
        i = arrayOfByte2.length;
        int k = i / 8;
        byte[] arrayOfByte1 = new byte[i];
        i = 0;
        if (i < k)
        {
          byte[] arrayOfByte3 = new byte[8];
          byte[] arrayOfByte4 = new byte[8];
          System.arraycopy(paramArrayOfByte1, 0, arrayOfByte3, 0, 8);
          System.arraycopy(arrayOfByte2, i * 8, arrayOfByte4, 0, 8);
          System.arraycopy(b(arrayOfByte3, arrayOfByte4, paramInt), 0, arrayOfByte1, i * 8, 8);
          i += 1;
          continue;
        }
        paramArrayOfByte1 = arrayOfByte1;
        if (paramInt == 0)
        {
          arrayOfByte2 = new byte[paramArrayOfByte2.length];
          System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, arrayOfByte2.length);
          k = arrayOfByte2[(arrayOfByte2.length - 1)];
          paramArrayOfByte1 = arrayOfByte1;
          if (k > 0)
          {
            paramArrayOfByte1 = arrayOfByte1;
            if (k <= 8)
            {
              paramInt = 0;
              if (paramInt >= k) {
                break label227;
              }
              i = j;
              if (k == arrayOfByte2[(arrayOfByte2.length - 1 - paramInt)])
              {
                paramInt += 1;
                continue;
              }
              paramArrayOfByte1 = arrayOfByte1;
              if (i != 0)
              {
                paramArrayOfByte1 = new byte[arrayOfByte2.length - k];
                System.arraycopy(arrayOfByte2, 0, paramArrayOfByte1, 0, paramArrayOfByte1.length);
              }
            }
          }
        }
        return paramArrayOfByte1;
      }
      catch (Exception paramArrayOfByte1)
      {
        return paramArrayOfByte2;
      }
      label227:
      int i = 1;
    }
  }
  
  private static byte[] a(int[] paramArrayOfInt, int paramInt, int[][] paramArrayOfInt1)
  {
    int k = 0;
    byte[] arrayOfByte = new byte[8];
    int[] arrayOfInt1 = new int[64];
    int[] arrayOfInt2 = new int[64];
    int i = 0;
    while (i < 64)
    {
      arrayOfInt1[i] = paramArrayOfInt[(jdField_a_of_type_ArrayOfInt[i] - 1)];
      i += 1;
    }
    if (paramInt == 1)
    {
      i = 0;
      while (i < 16)
      {
        a(arrayOfInt1, i, paramInt, paramArrayOfInt1);
        i += 1;
      }
    }
    int j = k;
    if (paramInt == 0)
    {
      i = 15;
      for (;;)
      {
        j = k;
        if (i <= -1) {
          break;
        }
        a(arrayOfInt1, i, paramInt, paramArrayOfInt1);
        i -= 1;
      }
    }
    while (j < 64)
    {
      arrayOfInt2[j] = arrayOfInt1[(jdField_b_of_type_ArrayOfInt[j] - 1)];
      j += 1;
    }
    a(arrayOfInt2, arrayOfByte);
    return arrayOfByte;
  }
  
  private static int[] a(byte[] paramArrayOfByte)
  {
    int[] arrayOfInt = new int[8];
    int i = 0;
    if (i < 8)
    {
      arrayOfInt[i] = paramArrayOfByte[i];
      if (arrayOfInt[i] >= 0) {}
      for (;;)
      {
        i += 1;
        break;
        arrayOfInt[i] += 256;
        arrayOfInt[i] %= 256;
      }
    }
    paramArrayOfByte = new int[64];
    i = 0;
    while (i < 8)
    {
      int j = 0;
      while (j < 8)
      {
        paramArrayOfByte[(i * 8 + 7 - j)] = (arrayOfInt[i] % 2);
        arrayOfInt[i] /= 2;
        j += 1;
      }
      i += 1;
    }
    return paramArrayOfByte;
  }
  
  private static byte[] b(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = new byte[8];
    int i = 0;
    while (i < arrayOfByte.length)
    {
      arrayOfByte[i] = 0;
      i += 1;
    }
    if (paramArrayOfByte.length > 8)
    {
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, arrayOfByte.length);
      return arrayOfByte;
    }
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, paramArrayOfByte.length);
    return arrayOfByte;
  }
  
  private static byte[] b(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt)
  {
    if ((paramArrayOfByte1.length != 8) || (paramArrayOfByte2.length != 8) || ((paramInt != 1) && (paramInt != 0))) {
      throw new RuntimeException("Data Format Error !");
    }
    Object localObject = new int[64];
    localObject = new int[64];
    localObject = new byte[8];
    localObject = (int[][])Array.newInstance(Integer.TYPE, new int[] { 16, 48 });
    paramArrayOfByte1 = a(paramArrayOfByte1);
    paramArrayOfByte2 = a(paramArrayOfByte2);
    a(paramArrayOfByte1, (int[][])localObject);
    return a(paramArrayOfByte2, paramInt, (int[][])localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.util.DesUtils
 * JD-Core Version:    0.7.0.1
 */