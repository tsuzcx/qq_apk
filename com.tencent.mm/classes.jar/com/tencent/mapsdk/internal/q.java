package com.tencent.mapsdk.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;

public final class q
{
  private static final int a = 37;
  private static final int b = 17;
  private static final byte[] c;
  private static final byte[] d;
  
  static
  {
    byte[] arrayOfByte1 = new byte[16];
    byte[] tmp6_5 = arrayOfByte1;
    tmp6_5[0] = 48;
    byte[] tmp11_6 = tmp6_5;
    tmp11_6[1] = 49;
    byte[] tmp16_11 = tmp11_6;
    tmp16_11[2] = 50;
    byte[] tmp21_16 = tmp16_11;
    tmp21_16[3] = 51;
    byte[] tmp26_21 = tmp21_16;
    tmp26_21[4] = 52;
    byte[] tmp31_26 = tmp26_21;
    tmp31_26[5] = 53;
    byte[] tmp36_31 = tmp31_26;
    tmp36_31[6] = 54;
    byte[] tmp42_36 = tmp36_31;
    tmp42_36[7] = 55;
    byte[] tmp48_42 = tmp42_36;
    tmp48_42[8] = 56;
    byte[] tmp54_48 = tmp48_42;
    tmp54_48[9] = 57;
    byte[] tmp60_54 = tmp54_48;
    tmp60_54[10] = 65;
    byte[] tmp66_60 = tmp60_54;
    tmp66_60[11] = 66;
    byte[] tmp72_66 = tmp66_60;
    tmp72_66[12] = 67;
    byte[] tmp78_72 = tmp72_66;
    tmp78_72[13] = 68;
    byte[] tmp84_78 = tmp78_72;
    tmp84_78[14] = 69;
    byte[] tmp90_84 = tmp84_78;
    tmp90_84[15] = 70;
    tmp90_84;
    byte[] arrayOfByte2 = new byte[256];
    byte[] arrayOfByte3 = new byte[256];
    int i = 0;
    while (i < 256)
    {
      arrayOfByte2[i] = arrayOfByte1[(i >>> 4)];
      arrayOfByte3[i] = arrayOfByte1[(i & 0xF)];
      i += 1;
    }
    c = arrayOfByte2;
    d = arrayOfByte3;
  }
  
  private static int a(byte paramByte)
  {
    return paramByte + 629;
  }
  
  private static int a(char paramChar)
  {
    return paramChar + 'ɵ';
  }
  
  private static int a(double paramDouble)
  {
    AppMethodBeat.i(224737);
    long l = Double.doubleToLongBits(paramDouble);
    int i = (int)(l ^ l >> 32);
    AppMethodBeat.o(224737);
    return i + 629;
  }
  
  private static int a(float paramFloat)
  {
    AppMethodBeat.i(224756);
    int i = Float.floatToIntBits(paramFloat);
    AppMethodBeat.o(224756);
    return i + 629;
  }
  
  private static int a(int paramInt)
  {
    return paramInt + 629;
  }
  
  private static int a(long paramLong)
  {
    return (int)(paramLong >> 32 ^ paramLong) + 629;
  }
  
  private static <T extends Comparable<T>> int a(T paramT1, T paramT2)
  {
    AppMethodBeat.i(224572);
    int i = paramT1.compareTo(paramT2);
    AppMethodBeat.o(224572);
    return i;
  }
  
  private static int a(Object paramObject)
  {
    AppMethodBeat.i(224829);
    for (;;)
    {
      if (paramObject == null)
      {
        AppMethodBeat.o(224829);
        return 629;
      }
      if (!paramObject.getClass().isArray()) {
        break;
      }
      if ((paramObject instanceof p[]))
      {
        paramObject = (p[])paramObject;
        if (paramObject == null)
        {
          AppMethodBeat.o(224829);
          return 629;
        }
        int j = 17;
        i = 0;
        while (i < paramObject.length)
        {
          j = j * 37 + paramObject[i].hashCode();
          i += 1;
        }
        AppMethodBeat.o(224829);
        return j;
      }
      paramObject = (Object[])paramObject;
    }
    int i = paramObject.hashCode();
    AppMethodBeat.o(224829);
    return i + 629;
  }
  
  private static <T extends Comparable<T>> int a(List<T> paramList1, List<T> paramList2)
  {
    AppMethodBeat.i(224584);
    paramList1 = paramList1.iterator();
    paramList2 = paramList2.iterator();
    while ((paramList1.hasNext()) && (paramList2.hasNext()))
    {
      i = ((Comparable)paramList1.next()).compareTo(paramList2.next());
      if (i != 0)
      {
        AppMethodBeat.o(224584);
        return i;
      }
    }
    int i = b(paramList1.hasNext(), paramList2.hasNext());
    AppMethodBeat.o(224584);
    return i;
  }
  
  private static int a(short paramShort)
  {
    return paramShort + 629;
  }
  
  private static int a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 0;; i = 1) {
      return i + 629;
    }
  }
  
  private static int a(byte[] paramArrayOfByte)
  {
    int k;
    if (paramArrayOfByte == null)
    {
      k = 629;
      return k;
    }
    int i = 17;
    int j = 0;
    for (;;)
    {
      k = i;
      if (j >= paramArrayOfByte.length) {
        break;
      }
      i = i * 37 + paramArrayOfByte[j];
      j += 1;
    }
  }
  
  private static int a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(224617);
    int j = 0;
    int k = 0;
    while ((k < paramArrayOfByte1.length) && (j < paramArrayOfByte2.length))
    {
      i = paramArrayOfByte1[k];
      int m = paramArrayOfByte2[j];
      if (i < m) {
        i = -1;
      }
      while (i != 0)
      {
        AppMethodBeat.o(224617);
        return i;
        if (i > m) {
          i = 1;
        } else {
          i = 0;
        }
      }
      k += 1;
      j += 1;
    }
    int i = b(paramArrayOfByte1.length, paramArrayOfByte2.length);
    AppMethodBeat.o(224617);
    return i;
  }
  
  private static int a(char[] paramArrayOfChar)
  {
    int k;
    if (paramArrayOfChar == null)
    {
      k = 629;
      return k;
    }
    int i = 17;
    int j = 0;
    for (;;)
    {
      k = i;
      if (j >= paramArrayOfChar.length) {
        break;
      }
      i = i * 37 + paramArrayOfChar[j];
      j += 1;
    }
  }
  
  private static int a(char[] paramArrayOfChar1, char[] paramArrayOfChar2)
  {
    AppMethodBeat.i(224628);
    int j = 0;
    int k = 0;
    while ((k < paramArrayOfChar1.length) && (j < paramArrayOfChar2.length))
    {
      i = paramArrayOfChar1[k];
      int m = paramArrayOfChar2[j];
      if (i < m) {
        i = -1;
      }
      while (i != 0)
      {
        AppMethodBeat.o(224628);
        return i;
        if (i > m) {
          i = 1;
        } else {
          i = 0;
        }
      }
      k += 1;
      j += 1;
    }
    int i = b(paramArrayOfChar1.length, paramArrayOfChar2.length);
    AppMethodBeat.o(224628);
    return i;
  }
  
  private static int a(double[] paramArrayOfDouble)
  {
    AppMethodBeat.i(224743);
    if (paramArrayOfDouble == null)
    {
      AppMethodBeat.o(224743);
      return 629;
    }
    int j = 17;
    int i = 0;
    while (i < paramArrayOfDouble.length)
    {
      j = j * 37 + (int)(Double.doubleToLongBits(paramArrayOfDouble[i]) ^ Double.doubleToLongBits(paramArrayOfDouble[i]) >> 32);
      i += 1;
    }
    AppMethodBeat.o(224743);
    return j;
  }
  
  private static int a(double[] paramArrayOfDouble1, double[] paramArrayOfDouble2)
  {
    AppMethodBeat.i(224678);
    int j = 0;
    int k = 0;
    while ((k < paramArrayOfDouble1.length) && (j < paramArrayOfDouble2.length))
    {
      double d1 = paramArrayOfDouble1[k];
      double d2 = paramArrayOfDouble2[j];
      if (d1 < d2) {
        i = -1;
      }
      while (i != 0)
      {
        AppMethodBeat.o(224678);
        return i;
        if (d1 > d2) {
          i = 1;
        } else {
          i = 0;
        }
      }
      k += 1;
      j += 1;
    }
    int i = b(paramArrayOfDouble1.length, paramArrayOfDouble2.length);
    AppMethodBeat.o(224678);
    return i;
  }
  
  private static int a(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(224763);
    if (paramArrayOfFloat == null)
    {
      AppMethodBeat.o(224763);
      return 629;
    }
    int j = 17;
    int i = 0;
    while (i < paramArrayOfFloat.length)
    {
      j = j * 37 + Float.floatToIntBits(paramArrayOfFloat[i]);
      i += 1;
    }
    AppMethodBeat.o(224763);
    return j;
  }
  
  private static int a(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    AppMethodBeat.i(224670);
    int j = 0;
    int k = 0;
    while ((k < paramArrayOfFloat1.length) && (j < paramArrayOfFloat2.length))
    {
      float f1 = paramArrayOfFloat1[k];
      float f2 = paramArrayOfFloat2[j];
      if (f1 < f2) {
        i = -1;
      }
      while (i != 0)
      {
        AppMethodBeat.o(224670);
        return i;
        if (f1 > f2) {
          i = 1;
        } else {
          i = 0;
        }
      }
      k += 1;
      j += 1;
    }
    int i = b(paramArrayOfFloat1.length, paramArrayOfFloat2.length);
    AppMethodBeat.o(224670);
    return i;
  }
  
  private static int a(int[] paramArrayOfInt)
  {
    int k;
    if (paramArrayOfInt == null)
    {
      k = 629;
      return k;
    }
    int i = 17;
    int j = 0;
    for (;;)
    {
      k = i;
      if (j >= paramArrayOfInt.length) {
        break;
      }
      i = i * 37 + paramArrayOfInt[j];
      j += 1;
    }
  }
  
  private static int a(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    AppMethodBeat.i(224652);
    int j = 0;
    int i = 0;
    while ((i < paramArrayOfInt1.length) && (j < paramArrayOfInt2.length))
    {
      int k = b(paramArrayOfInt1[i], paramArrayOfInt2[j]);
      if (k != 0)
      {
        AppMethodBeat.o(224652);
        return k;
      }
      j += 1;
      i += 1;
    }
    i = b(paramArrayOfInt1.length, paramArrayOfInt2.length);
    AppMethodBeat.o(224652);
    return i;
  }
  
  private static int a(long[] paramArrayOfLong)
  {
    int k;
    if (paramArrayOfLong == null)
    {
      k = 629;
      return k;
    }
    int i = 17;
    int j = 0;
    for (;;)
    {
      k = i;
      if (j >= paramArrayOfLong.length) {
        break;
      }
      i = i * 37 + (int)(paramArrayOfLong[j] ^ paramArrayOfLong[j] >> 32);
      j += 1;
    }
  }
  
  private static int a(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    AppMethodBeat.i(224662);
    int j = 0;
    int k = 0;
    while ((k < paramArrayOfLong1.length) && (j < paramArrayOfLong2.length))
    {
      long l1 = paramArrayOfLong1[k];
      long l2 = paramArrayOfLong2[j];
      if (l1 < l2) {
        i = -1;
      }
      while (i != 0)
      {
        AppMethodBeat.o(224662);
        return i;
        if (l1 > l2) {
          i = 1;
        } else {
          i = 0;
        }
      }
      k += 1;
      j += 1;
    }
    int i = b(paramArrayOfLong1.length, paramArrayOfLong2.length);
    AppMethodBeat.o(224662);
    return i;
  }
  
  private static int a(p[] paramArrayOfp)
  {
    AppMethodBeat.i(224816);
    if (paramArrayOfp == null)
    {
      AppMethodBeat.o(224816);
      return 629;
    }
    int j = 17;
    int i = 0;
    while (i < paramArrayOfp.length)
    {
      j = j * 37 + paramArrayOfp[i].hashCode();
      i += 1;
    }
    AppMethodBeat.o(224816);
    return j;
  }
  
  private static <T extends Comparable<T>> int a(T[] paramArrayOfT1, T[] paramArrayOfT2)
  {
    AppMethodBeat.i(224597);
    int j = 0;
    int i = 0;
    while ((i < paramArrayOfT1.length) && (j < paramArrayOfT2.length))
    {
      int k = paramArrayOfT1[i].compareTo(paramArrayOfT2[j]);
      if (k != 0)
      {
        AppMethodBeat.o(224597);
        return k;
      }
      j += 1;
      i += 1;
    }
    i = b(paramArrayOfT1.length, paramArrayOfT2.length);
    AppMethodBeat.o(224597);
    return i;
  }
  
  private static int a(short[] paramArrayOfShort)
  {
    int k;
    if (paramArrayOfShort == null)
    {
      k = 629;
      return k;
    }
    int i = 17;
    int j = 0;
    for (;;)
    {
      k = i;
      if (j >= paramArrayOfShort.length) {
        break;
      }
      i = i * 37 + paramArrayOfShort[j];
      j += 1;
    }
  }
  
  private static int a(short[] paramArrayOfShort1, short[] paramArrayOfShort2)
  {
    AppMethodBeat.i(224642);
    int j = 0;
    int k = 0;
    while ((k < paramArrayOfShort1.length) && (j < paramArrayOfShort2.length))
    {
      i = paramArrayOfShort1[k];
      int m = paramArrayOfShort2[j];
      if (i < m) {
        i = -1;
      }
      while (i != 0)
      {
        AppMethodBeat.o(224642);
        return i;
        if (i > m) {
          i = 1;
        } else {
          i = 0;
        }
      }
      k += 1;
      j += 1;
    }
    int i = b(paramArrayOfShort1.length, paramArrayOfShort2.length);
    AppMethodBeat.o(224642);
    return i;
  }
  
  private static int a(boolean[] paramArrayOfBoolean)
  {
    if (paramArrayOfBoolean == null) {
      k = 629;
    }
    int i;
    int j;
    do
    {
      return k;
      i = 17;
      j = 0;
      k = i;
    } while (j >= paramArrayOfBoolean.length);
    if (paramArrayOfBoolean[j] != 0) {}
    for (int k = 0;; k = 1)
    {
      i = k + i * 37;
      j += 1;
      break;
    }
  }
  
  private static int a(boolean[] paramArrayOfBoolean1, boolean[] paramArrayOfBoolean2)
  {
    AppMethodBeat.i(224607);
    int j = 0;
    int i = 0;
    while ((i < paramArrayOfBoolean1.length) && (j < paramArrayOfBoolean2.length))
    {
      int k = b(paramArrayOfBoolean1[i], paramArrayOfBoolean2[j]);
      if (k != 0)
      {
        AppMethodBeat.o(224607);
        return k;
      }
      j += 1;
      i += 1;
    }
    i = b(paramArrayOfBoolean1.length, paramArrayOfBoolean2.length);
    AppMethodBeat.o(224607);
    return i;
  }
  
  public static boolean a(byte paramByte1, byte paramByte2)
  {
    return paramByte1 == paramByte2;
  }
  
  private static boolean a(char paramChar1, char paramChar2)
  {
    return paramChar1 == paramChar2;
  }
  
  private static boolean a(double paramDouble1, double paramDouble2)
  {
    return paramDouble1 == paramDouble2;
  }
  
  private static boolean a(float paramFloat1, float paramFloat2)
  {
    return paramFloat1 == paramFloat2;
  }
  
  public static boolean a(int paramInt1, int paramInt2)
  {
    return paramInt1 == paramInt2;
  }
  
  public static boolean a(long paramLong1, long paramLong2)
  {
    return paramLong1 == paramLong2;
  }
  
  public static boolean a(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(224488);
    if (paramObject1 == null)
    {
      if (paramObject1 == paramObject2)
      {
        AppMethodBeat.o(224488);
        return true;
      }
      AppMethodBeat.o(224488);
      return false;
    }
    boolean bool = paramObject1.equals(paramObject2);
    AppMethodBeat.o(224488);
    return bool;
  }
  
  public static boolean a(short paramShort1, short paramShort2)
  {
    return paramShort1 == paramShort2;
  }
  
  private static boolean a(boolean paramBoolean1, boolean paramBoolean2)
  {
    return paramBoolean1 == paramBoolean2;
  }
  
  public static byte[] a(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(224842);
    byte[] arrayOfByte = new byte[paramByteBuffer.position()];
    System.arraycopy(paramByteBuffer.array(), 0, arrayOfByte, 0, arrayOfByte.length);
    AppMethodBeat.o(224842);
    return arrayOfByte;
  }
  
  private static int b(byte paramByte1, byte paramByte2)
  {
    if (paramByte1 < paramByte2) {
      return -1;
    }
    if (paramByte1 > paramByte2) {
      return 1;
    }
    return 0;
  }
  
  private static int b(char paramChar1, char paramChar2)
  {
    if (paramChar1 < paramChar2) {
      return -1;
    }
    if (paramChar1 > paramChar2) {
      return 1;
    }
    return 0;
  }
  
  private static int b(double paramDouble1, double paramDouble2)
  {
    if (paramDouble1 < paramDouble2) {
      return -1;
    }
    if (paramDouble1 > paramDouble2) {
      return 1;
    }
    return 0;
  }
  
  private static int b(float paramFloat1, float paramFloat2)
  {
    if (paramFloat1 < paramFloat2) {
      return -1;
    }
    if (paramFloat1 > paramFloat2) {
      return 1;
    }
    return 0;
  }
  
  private static int b(int paramInt1, int paramInt2)
  {
    if (paramInt1 < paramInt2) {
      return -1;
    }
    if (paramInt1 > paramInt2) {
      return 1;
    }
    return 0;
  }
  
  private static int b(long paramLong1, long paramLong2)
  {
    if (paramLong1 < paramLong2) {
      return -1;
    }
    if (paramLong1 > paramLong2) {
      return 1;
    }
    return 0;
  }
  
  private static int b(short paramShort1, short paramShort2)
  {
    if (paramShort1 < paramShort2) {
      return -1;
    }
    if (paramShort1 > paramShort2) {
      return 1;
    }
    return 0;
  }
  
  private static int b(boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 1;
    int i;
    if (paramBoolean1)
    {
      i = 1;
      if (!paramBoolean2) {
        break label21;
      }
    }
    for (;;)
    {
      return i - j;
      i = 0;
      break;
      label21:
      j = 0;
    }
  }
  
  private static String b(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(224864);
    int i = paramByteBuffer.remaining();
    if (i == 0)
    {
      AppMethodBeat.o(224864);
      return "empty";
    }
    StringBuffer localStringBuffer = new StringBuffer(paramByteBuffer.remaining() * 3 - 1);
    int j = paramByteBuffer.position();
    int k = paramByteBuffer.get() & 0xFF;
    localStringBuffer.append((char)c[k]);
    localStringBuffer.append((char)d[k]);
    i -= 1;
    while (i > 0)
    {
      localStringBuffer.append(' ');
      k = paramByteBuffer.get() & 0xFF;
      localStringBuffer.append((char)c[k]);
      localStringBuffer.append((char)d[k]);
      i -= 1;
    }
    paramByteBuffer.position(j);
    paramByteBuffer = localStringBuffer.toString();
    AppMethodBeat.o(224864);
    return paramByteBuffer;
  }
  
  private static String b(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(224852);
    paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte);
    int i = paramArrayOfByte.remaining();
    if (i == 0)
    {
      AppMethodBeat.o(224852);
      return "empty";
    }
    StringBuffer localStringBuffer = new StringBuffer(paramArrayOfByte.remaining() * 3 - 1);
    int j = paramArrayOfByte.position();
    int k = paramArrayOfByte.get() & 0xFF;
    localStringBuffer.append((char)c[k]);
    localStringBuffer.append((char)d[k]);
    i -= 1;
    while (i > 0)
    {
      localStringBuffer.append(' ');
      k = paramArrayOfByte.get() & 0xFF;
      localStringBuffer.append((char)c[k]);
      localStringBuffer.append((char)d[k]);
      i -= 1;
    }
    paramArrayOfByte.position(j);
    paramArrayOfByte = localStringBuffer.toString();
    AppMethodBeat.o(224852);
    return paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mapsdk.internal.q
 * JD-Core Version:    0.7.0.1
 */