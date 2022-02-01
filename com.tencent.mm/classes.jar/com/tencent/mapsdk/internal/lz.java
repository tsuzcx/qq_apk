package com.tencent.mapsdk.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public final class lz
  implements ma
{
  private static final String g = "UTF-16LE";
  private ByteArrayOutputStream h;
  
  public lz()
  {
    AppMethodBeat.i(222752);
    this.h = new ByteArrayOutputStream();
    AppMethodBeat.o(222752);
  }
  
  public static int a(byte[] paramArrayOfByte)
  {
    return paramArrayOfByte[0] & 0xFF | 0xFF00 & paramArrayOfByte[1] << 8 | 0xFF0000 & paramArrayOfByte[2] << 16 | 0xFF000000 & paramArrayOfByte[3] << 24;
  }
  
  public static String a(byte[] paramArrayOfByte, String paramString)
  {
    AppMethodBeat.i(222945);
    try
    {
      paramArrayOfByte = new String(paramArrayOfByte, paramString).trim();
      AppMethodBeat.o(222945);
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      AppMethodBeat.o(222945);
    }
    return null;
  }
  
  private void a(byte paramByte)
  {
    AppMethodBeat.i(222764);
    this.h.write(paramByte);
    AppMethodBeat.o(222764);
  }
  
  private void a(char paramChar)
  {
    AppMethodBeat.i(222790);
    int i = 0;
    while (i < 2)
    {
      a((byte)(paramChar >> i * 8 & 0xFF));
      i += 1;
    }
    AppMethodBeat.o(222790);
  }
  
  private void a(int paramInt)
  {
    AppMethodBeat.i(222782);
    a(paramInt, 2);
    AppMethodBeat.o(222782);
  }
  
  private void a(long paramLong)
  {
    AppMethodBeat.i(222820);
    a(paramLong, 8);
    AppMethodBeat.o(222820);
  }
  
  private void a(long paramLong, int paramInt)
  {
    AppMethodBeat.i(222850);
    paramInt -= 1;
    while (paramInt >= 0)
    {
      a((byte)(int)(paramLong >> paramInt * 8 & 0xFF));
      paramInt -= 1;
    }
    AppMethodBeat.o(222850);
  }
  
  private static void a(long paramLong, byte[] paramArrayOfByte)
  {
    int i = 3;
    while (i >= 0)
    {
      paramArrayOfByte[(4 - i - 1)] = ((byte)(int)(paramLong >> i * 8 & 0xFF));
      i -= 1;
    }
  }
  
  private void a(String paramString)
  {
    AppMethodBeat.i(222830);
    if (paramString == null)
    {
      AppMethodBeat.o(222830);
      return;
    }
    paramString = paramString.getBytes();
    a(paramString.length, 2);
    this.h.write(paramString, 0, paramString.length);
    AppMethodBeat.o(222830);
  }
  
  private void a(boolean paramBoolean)
  {
    AppMethodBeat.i(222774);
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      a((byte)i);
      AppMethodBeat.o(222774);
      return;
    }
  }
  
  private byte[] a()
  {
    byte[] arrayOfByte2 = null;
    AppMethodBeat.i(222840);
    byte[] arrayOfByte1 = arrayOfByte2;
    try
    {
      this.h.close();
      arrayOfByte1 = arrayOfByte2;
      arrayOfByte2 = this.h.toByteArray();
      arrayOfByte1 = arrayOfByte2;
      this.h = null;
      arrayOfByte1 = arrayOfByte2;
    }
    catch (IOException localIOException)
    {
      label35:
      break label35;
    }
    AppMethodBeat.o(222840);
    return arrayOfByte1;
  }
  
  private static byte[] a(double paramDouble)
  {
    AppMethodBeat.i(222914);
    long l = Double.doubleToLongBits(paramDouble);
    int i = (byte)(int)l;
    int j = (byte)(int)(l >> 8);
    int k = (byte)(int)(l >> 16);
    int m = (byte)(int)(l >> 24);
    int n = (byte)(int)(l >> 32);
    int i1 = (byte)(int)(l >> 40);
    int i2 = (byte)(int)(l >> 48);
    int i3 = (byte)(int)(l >> 56);
    AppMethodBeat.o(222914);
    return new byte[] { i, j, k, m, n, i1, i2, i3 };
  }
  
  private static byte[] a(float paramFloat)
  {
    AppMethodBeat.i(222893);
    int n = Float.floatToIntBits(paramFloat);
    int i = (byte)n;
    int j = (byte)(n >> 8);
    int k = (byte)(n >> 16);
    int m = (byte)(n >> 24);
    AppMethodBeat.o(222893);
    return new byte[] { i, j, k, m };
  }
  
  public static String b(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(222935);
    try
    {
      paramArrayOfByte = new String(paramArrayOfByte, "UTF-16LE").trim();
      AppMethodBeat.o(222935);
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      AppMethodBeat.o(222935);
    }
    return null;
  }
  
  private static byte[] b(int paramInt)
  {
    byte[] arrayOfByte = new byte[4];
    long l = paramInt;
    paramInt = 3;
    while (paramInt >= 0)
    {
      arrayOfByte[(4 - paramInt - 1)] = ((byte)(int)(l >> paramInt * 8 & 0xFF));
      paramInt -= 1;
    }
    return arrayOfByte;
  }
  
  private static byte[] b(long paramLong)
  {
    return new byte[] { (byte)(int)paramLong, (byte)(int)(paramLong >> 8), (byte)(int)(paramLong >> 16), (byte)(int)(paramLong >> 24), (byte)(int)(paramLong >> 32), (byte)(int)(paramLong >> 40), (byte)(int)(paramLong >> 48), (byte)(int)(paramLong >> 56) };
  }
  
  private static byte[] b(String paramString)
  {
    AppMethodBeat.i(222926);
    if (paramString != null) {
      try
      {
        paramString = paramString.getBytes("UTF-16LE");
        AppMethodBeat.o(222926);
        return paramString;
      }
      catch (Exception paramString) {}
    }
    AppMethodBeat.o(222926);
    return new byte[0];
  }
  
  private void c(int paramInt)
  {
    AppMethodBeat.i(222811);
    a(paramInt, 4);
    AppMethodBeat.o(222811);
  }
  
  private void c(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(222759);
    this.h.write(paramArrayOfByte, 0, paramArrayOfByte.length);
    AppMethodBeat.o(222759);
  }
  
  private static boolean d(byte[] paramArrayOfByte)
  {
    boolean bool = false;
    if (paramArrayOfByte[0] > 0) {
      bool = true;
    }
    return bool;
  }
  
  private static byte[] d(int paramInt)
  {
    return new byte[] { (byte)paramInt, (byte)(paramInt >> 8), (byte)(paramInt >> 16), (byte)(paramInt >> 24) };
  }
  
  private static long e(byte[] paramArrayOfByte)
  {
    return paramArrayOfByte[0] & 0xFF | (paramArrayOfByte[1] & 0xFF) << 8 | (paramArrayOfByte[2] & 0xFF) << 16 | (paramArrayOfByte[3] & 0xFF) << 24 | (paramArrayOfByte[4] & 0xFF) << 32 | (paramArrayOfByte[5] & 0xFF) << 40 | (paramArrayOfByte[6] & 0xFF) << 48 | (paramArrayOfByte[7] & 0xFF) << 56;
  }
  
  private static float f(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(222901);
    float f = Float.intBitsToFloat(a(paramArrayOfByte));
    AppMethodBeat.o(222901);
    return f;
  }
  
  private static double g(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(222920);
    double d = Double.longBitsToDouble(paramArrayOfByte[0] & 0xFF | (paramArrayOfByte[1] & 0xFF) << 8 | (paramArrayOfByte[2] & 0xFF) << 16 | (paramArrayOfByte[3] & 0xFF) << 24 | (paramArrayOfByte[4] & 0xFF) << 32 | (paramArrayOfByte[5] & 0xFF) << 40 | (paramArrayOfByte[6] & 0xFF) << 48 | (paramArrayOfByte[7] & 0xFF) << 56);
    AppMethodBeat.o(222920);
    return d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mapsdk.internal.lz
 * JD-Core Version:    0.7.0.1
 */