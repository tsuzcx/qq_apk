package com.qq.taf.jce;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;

public final class JceUtil
{
  private static final byte[] highDigits;
  private static final int iConstant = 37;
  private static final int iTotal = 17;
  private static final byte[] lowDigits;
  
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
    for (;;)
    {
      if (i >= 256)
      {
        highDigits = arrayOfByte2;
        lowDigits = arrayOfByte3;
        return;
      }
      arrayOfByte2[i] = arrayOfByte1[(i >>> 4)];
      arrayOfByte3[i] = arrayOfByte1[(i & 0xF)];
      i += 1;
    }
  }
  
  public static int compareTo(byte paramByte1, byte paramByte2)
  {
    if (paramByte1 < paramByte2) {
      return -1;
    }
    if (paramByte1 > paramByte2) {
      return 1;
    }
    return 0;
  }
  
  public static int compareTo(char paramChar1, char paramChar2)
  {
    if (paramChar1 < paramChar2) {
      return -1;
    }
    if (paramChar1 > paramChar2) {
      return 1;
    }
    return 0;
  }
  
  public static int compareTo(double paramDouble1, double paramDouble2)
  {
    if (paramDouble1 < paramDouble2) {
      return -1;
    }
    if (paramDouble1 > paramDouble2) {
      return 1;
    }
    return 0;
  }
  
  public static int compareTo(float paramFloat1, float paramFloat2)
  {
    if (paramFloat1 < paramFloat2) {
      return -1;
    }
    if (paramFloat1 > paramFloat2) {
      return 1;
    }
    return 0;
  }
  
  public static int compareTo(int paramInt1, int paramInt2)
  {
    if (paramInt1 < paramInt2) {
      return -1;
    }
    if (paramInt1 > paramInt2) {
      return 1;
    }
    return 0;
  }
  
  public static int compareTo(long paramLong1, long paramLong2)
  {
    if (paramLong1 < paramLong2) {
      return -1;
    }
    if (paramLong1 > paramLong2) {
      return 1;
    }
    return 0;
  }
  
  public static <T extends Comparable<T>> int compareTo(T paramT1, T paramT2)
  {
    AppMethodBeat.i(109641);
    int i = paramT1.compareTo(paramT2);
    AppMethodBeat.o(109641);
    return i;
  }
  
  public static <T extends Comparable<T>> int compareTo(List<T> paramList1, List<T> paramList2)
  {
    AppMethodBeat.i(109642);
    paramList1 = paramList1.iterator();
    paramList2 = paramList2.iterator();
    int i;
    do
    {
      if ((!paramList1.hasNext()) || (!paramList2.hasNext()))
      {
        i = compareTo(paramList1.hasNext(), paramList2.hasNext());
        AppMethodBeat.o(109642);
        return i;
      }
      i = ((Comparable)paramList1.next()).compareTo((Comparable)paramList2.next());
    } while (i == 0);
    AppMethodBeat.o(109642);
    return i;
  }
  
  public static int compareTo(short paramShort1, short paramShort2)
  {
    if (paramShort1 < paramShort2) {
      return -1;
    }
    if (paramShort1 > paramShort2) {
      return 1;
    }
    return 0;
  }
  
  public static int compareTo(boolean paramBoolean1, boolean paramBoolean2)
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
  
  public static int compareTo(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(109645);
    int j = 0;
    int i = 0;
    for (;;)
    {
      if ((i >= paramArrayOfByte1.length) || (j >= paramArrayOfByte2.length))
      {
        i = compareTo(paramArrayOfByte1.length, paramArrayOfByte2.length);
        AppMethodBeat.o(109645);
        return i;
      }
      int k = compareTo(paramArrayOfByte1[i], paramArrayOfByte2[j]);
      if (k != 0)
      {
        AppMethodBeat.o(109645);
        return k;
      }
      j += 1;
      i += 1;
    }
  }
  
  public static int compareTo(char[] paramArrayOfChar1, char[] paramArrayOfChar2)
  {
    AppMethodBeat.i(109646);
    int j = 0;
    int i = 0;
    for (;;)
    {
      if ((i >= paramArrayOfChar1.length) || (j >= paramArrayOfChar2.length))
      {
        i = compareTo(paramArrayOfChar1.length, paramArrayOfChar2.length);
        AppMethodBeat.o(109646);
        return i;
      }
      int k = compareTo(paramArrayOfChar1[i], paramArrayOfChar2[j]);
      if (k != 0)
      {
        AppMethodBeat.o(109646);
        return k;
      }
      j += 1;
      i += 1;
    }
  }
  
  public static int compareTo(double[] paramArrayOfDouble1, double[] paramArrayOfDouble2)
  {
    AppMethodBeat.i(109651);
    int j = 0;
    int i = 0;
    for (;;)
    {
      if ((i >= paramArrayOfDouble1.length) || (j >= paramArrayOfDouble2.length))
      {
        i = compareTo(paramArrayOfDouble1.length, paramArrayOfDouble2.length);
        AppMethodBeat.o(109651);
        return i;
      }
      int k = compareTo(paramArrayOfDouble1[i], paramArrayOfDouble2[j]);
      if (k != 0)
      {
        AppMethodBeat.o(109651);
        return k;
      }
      j += 1;
      i += 1;
    }
  }
  
  public static int compareTo(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    AppMethodBeat.i(109650);
    int j = 0;
    int i = 0;
    for (;;)
    {
      if ((i >= paramArrayOfFloat1.length) || (j >= paramArrayOfFloat2.length))
      {
        i = compareTo(paramArrayOfFloat1.length, paramArrayOfFloat2.length);
        AppMethodBeat.o(109650);
        return i;
      }
      int k = compareTo(paramArrayOfFloat1[i], paramArrayOfFloat2[j]);
      if (k != 0)
      {
        AppMethodBeat.o(109650);
        return k;
      }
      j += 1;
      i += 1;
    }
  }
  
  public static int compareTo(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    AppMethodBeat.i(109648);
    int j = 0;
    int i = 0;
    for (;;)
    {
      if ((i >= paramArrayOfInt1.length) || (j >= paramArrayOfInt2.length))
      {
        i = compareTo(paramArrayOfInt1.length, paramArrayOfInt2.length);
        AppMethodBeat.o(109648);
        return i;
      }
      int k = compareTo(paramArrayOfInt1[i], paramArrayOfInt2[j]);
      if (k != 0)
      {
        AppMethodBeat.o(109648);
        return k;
      }
      j += 1;
      i += 1;
    }
  }
  
  public static int compareTo(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    AppMethodBeat.i(109649);
    int j = 0;
    int i = 0;
    for (;;)
    {
      if ((i >= paramArrayOfLong1.length) || (j >= paramArrayOfLong2.length))
      {
        i = compareTo(paramArrayOfLong1.length, paramArrayOfLong2.length);
        AppMethodBeat.o(109649);
        return i;
      }
      int k = compareTo(paramArrayOfLong1[i], paramArrayOfLong2[j]);
      if (k != 0)
      {
        AppMethodBeat.o(109649);
        return k;
      }
      j += 1;
      i += 1;
    }
  }
  
  public static <T extends Comparable<T>> int compareTo(T[] paramArrayOfT1, T[] paramArrayOfT2)
  {
    AppMethodBeat.i(109643);
    int j = 0;
    int i = 0;
    for (;;)
    {
      if ((i >= paramArrayOfT1.length) || (j >= paramArrayOfT2.length))
      {
        i = compareTo(paramArrayOfT1.length, paramArrayOfT2.length);
        AppMethodBeat.o(109643);
        return i;
      }
      int k = paramArrayOfT1[i].compareTo(paramArrayOfT2[j]);
      if (k != 0)
      {
        AppMethodBeat.o(109643);
        return k;
      }
      j += 1;
      i += 1;
    }
  }
  
  public static int compareTo(short[] paramArrayOfShort1, short[] paramArrayOfShort2)
  {
    AppMethodBeat.i(109647);
    int j = 0;
    int i = 0;
    for (;;)
    {
      if ((i >= paramArrayOfShort1.length) || (j >= paramArrayOfShort2.length))
      {
        i = compareTo(paramArrayOfShort1.length, paramArrayOfShort2.length);
        AppMethodBeat.o(109647);
        return i;
      }
      int k = compareTo(paramArrayOfShort1[i], paramArrayOfShort2[j]);
      if (k != 0)
      {
        AppMethodBeat.o(109647);
        return k;
      }
      j += 1;
      i += 1;
    }
  }
  
  public static int compareTo(boolean[] paramArrayOfBoolean1, boolean[] paramArrayOfBoolean2)
  {
    AppMethodBeat.i(109644);
    int j = 0;
    int i = 0;
    for (;;)
    {
      if ((i >= paramArrayOfBoolean1.length) || (j >= paramArrayOfBoolean2.length))
      {
        i = compareTo(paramArrayOfBoolean1.length, paramArrayOfBoolean2.length);
        AppMethodBeat.o(109644);
        return i;
      }
      int k = compareTo(paramArrayOfBoolean1[i], paramArrayOfBoolean2[j]);
      if (k != 0)
      {
        AppMethodBeat.o(109644);
        return k;
      }
      j += 1;
      i += 1;
    }
  }
  
  public static boolean equals(byte paramByte1, byte paramByte2)
  {
    return paramByte1 == paramByte2;
  }
  
  public static boolean equals(char paramChar1, char paramChar2)
  {
    return paramChar1 == paramChar2;
  }
  
  public static boolean equals(double paramDouble1, double paramDouble2)
  {
    return paramDouble1 == paramDouble2;
  }
  
  public static boolean equals(float paramFloat1, float paramFloat2)
  {
    return paramFloat1 == paramFloat2;
  }
  
  public static boolean equals(int paramInt1, int paramInt2)
  {
    return paramInt1 == paramInt2;
  }
  
  public static boolean equals(long paramLong1, long paramLong2)
  {
    return paramLong1 == paramLong2;
  }
  
  public static boolean equals(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(109640);
    boolean bool = paramObject1.equals(paramObject2);
    AppMethodBeat.o(109640);
    return bool;
  }
  
  public static boolean equals(short paramShort1, short paramShort2)
  {
    return paramShort1 == paramShort2;
  }
  
  public static boolean equals(boolean paramBoolean1, boolean paramBoolean2)
  {
    return paramBoolean1 == paramBoolean2;
  }
  
  public static String getHexdump(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(109660);
    int i = paramByteBuffer.remaining();
    if (i == 0)
    {
      AppMethodBeat.o(109660);
      return "empty";
    }
    StringBuffer localStringBuffer = new StringBuffer(paramByteBuffer.remaining() * 3 - 1);
    int j = paramByteBuffer.position();
    int k = paramByteBuffer.get() & 0xFF;
    localStringBuffer.append((char)highDigits[k]);
    localStringBuffer.append((char)lowDigits[k]);
    i -= 1;
    for (;;)
    {
      if (i <= 0)
      {
        paramByteBuffer.position(j);
        paramByteBuffer = localStringBuffer.toString();
        AppMethodBeat.o(109660);
        return paramByteBuffer;
      }
      localStringBuffer.append(' ');
      k = paramByteBuffer.get() & 0xFF;
      localStringBuffer.append((char)highDigits[k]);
      localStringBuffer.append((char)lowDigits[k]);
      i -= 1;
    }
  }
  
  public static String getHexdump(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(109659);
    paramArrayOfByte = getHexdump(ByteBuffer.wrap(paramArrayOfByte));
    AppMethodBeat.o(109659);
    return paramArrayOfByte;
  }
  
  public static byte[] getJceBufArray(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(109658);
    byte[] arrayOfByte = new byte[paramByteBuffer.position()];
    System.arraycopy(paramByteBuffer.array(), 0, arrayOfByte, 0, arrayOfByte.length);
    AppMethodBeat.o(109658);
    return arrayOfByte;
  }
  
  public static int hashCode(byte paramByte)
  {
    return paramByte + 629;
  }
  
  public static int hashCode(char paramChar)
  {
    return paramChar + 'ɵ';
  }
  
  public static int hashCode(double paramDouble)
  {
    AppMethodBeat.i(109652);
    int i = hashCode(Double.doubleToLongBits(paramDouble));
    AppMethodBeat.o(109652);
    return i;
  }
  
  public static int hashCode(float paramFloat)
  {
    AppMethodBeat.i(109654);
    int i = Float.floatToIntBits(paramFloat);
    AppMethodBeat.o(109654);
    return i + 629;
  }
  
  public static int hashCode(int paramInt)
  {
    return paramInt + 629;
  }
  
  public static int hashCode(long paramLong)
  {
    return (int)(paramLong >> 32 ^ paramLong) + 629;
  }
  
  public static int hashCode(Object paramObject)
  {
    AppMethodBeat.i(109657);
    for (;;)
    {
      if (paramObject == null)
      {
        AppMethodBeat.o(109657);
        return 629;
      }
      if (!paramObject.getClass().isArray()) {
        break;
      }
      if ((paramObject instanceof long[]))
      {
        i = hashCode((long[])paramObject);
        AppMethodBeat.o(109657);
        return i;
      }
      if ((paramObject instanceof int[]))
      {
        i = hashCode((int[])paramObject);
        AppMethodBeat.o(109657);
        return i;
      }
      if ((paramObject instanceof short[]))
      {
        i = hashCode((short[])paramObject);
        AppMethodBeat.o(109657);
        return i;
      }
      if ((paramObject instanceof char[]))
      {
        i = hashCode((char[])paramObject);
        AppMethodBeat.o(109657);
        return i;
      }
      if ((paramObject instanceof byte[]))
      {
        i = hashCode((byte[])paramObject);
        AppMethodBeat.o(109657);
        return i;
      }
      if ((paramObject instanceof double[]))
      {
        i = hashCode((double[])paramObject);
        AppMethodBeat.o(109657);
        return i;
      }
      if ((paramObject instanceof float[]))
      {
        i = hashCode((float[])paramObject);
        AppMethodBeat.o(109657);
        return i;
      }
      if ((paramObject instanceof boolean[]))
      {
        i = hashCode((boolean[])paramObject);
        AppMethodBeat.o(109657);
        return i;
      }
      if ((paramObject instanceof JceStruct[]))
      {
        i = hashCode((JceStruct[])paramObject);
        AppMethodBeat.o(109657);
        return i;
      }
      paramObject = (Object[])paramObject;
    }
    if ((paramObject instanceof JceStruct))
    {
      i = paramObject.hashCode();
      AppMethodBeat.o(109657);
      return i;
    }
    int i = paramObject.hashCode();
    AppMethodBeat.o(109657);
    return i + 629;
  }
  
  public static int hashCode(short paramShort)
  {
    return paramShort + 629;
  }
  
  public static int hashCode(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 0;; i = 1) {
      return i + 629;
    }
  }
  
  public static int hashCode(byte[] paramArrayOfByte)
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
  
  public static int hashCode(char[] paramArrayOfChar)
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
  
  public static int hashCode(double[] paramArrayOfDouble)
  {
    AppMethodBeat.i(109653);
    if (paramArrayOfDouble == null)
    {
      AppMethodBeat.o(109653);
      return 629;
    }
    int j = 17;
    int i = 0;
    for (;;)
    {
      if (i >= paramArrayOfDouble.length)
      {
        AppMethodBeat.o(109653);
        return j;
      }
      j = j * 37 + (int)(Double.doubleToLongBits(paramArrayOfDouble[i]) ^ Double.doubleToLongBits(paramArrayOfDouble[i]) >> 32);
      i += 1;
    }
  }
  
  public static int hashCode(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(109655);
    if (paramArrayOfFloat == null)
    {
      AppMethodBeat.o(109655);
      return 629;
    }
    int j = 17;
    int i = 0;
    for (;;)
    {
      if (i >= paramArrayOfFloat.length)
      {
        AppMethodBeat.o(109655);
        return j;
      }
      j = j * 37 + Float.floatToIntBits(paramArrayOfFloat[i]);
      i += 1;
    }
  }
  
  public static int hashCode(int[] paramArrayOfInt)
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
  
  public static int hashCode(long[] paramArrayOfLong)
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
  
  public static int hashCode(JceStruct[] paramArrayOfJceStruct)
  {
    AppMethodBeat.i(109656);
    if (paramArrayOfJceStruct == null)
    {
      AppMethodBeat.o(109656);
      return 629;
    }
    int j = 17;
    int i = 0;
    for (;;)
    {
      if (i >= paramArrayOfJceStruct.length)
      {
        AppMethodBeat.o(109656);
        return j;
      }
      j = j * 37 + paramArrayOfJceStruct[i].hashCode();
      i += 1;
    }
  }
  
  public static int hashCode(short[] paramArrayOfShort)
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
  
  public static int hashCode(boolean[] paramArrayOfBoolean)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.qq.taf.jce.JceUtil
 * JD-Core Version:    0.7.0.1
 */