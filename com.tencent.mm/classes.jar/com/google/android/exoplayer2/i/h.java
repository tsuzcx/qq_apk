package com.google.android.exoplayer2.i;

import java.nio.ByteBuffer;
import java.util.Arrays;

public final class h
{
  public static final byte[] aSg = { 0, 0, 0, 1 };
  public static final float[] aSo = { 1.0F, 1.0F, 1.090909F, 0.9090909F, 1.454546F, 1.212121F, 2.181818F, 1.818182F, 2.909091F, 2.424243F, 1.636364F, 1.363636F, 1.939394F, 1.616162F, 1.333333F, 1.5F, 2.0F };
  private static final Object aSp = new Object();
  private static int[] aSq = new int[10];
  
  public static int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean[] paramArrayOfBoolean)
  {
    boolean bool2 = true;
    int j = paramInt2 - paramInt1;
    if (j >= 0)
    {
      bool1 = true;
      a.aC(bool1);
      if (j != 0) {
        break label34;
      }
    }
    label34:
    do
    {
      return paramInt2;
      bool1 = false;
      break;
      if (paramArrayOfBoolean != null)
      {
        if (paramArrayOfBoolean[0] != 0)
        {
          b(paramArrayOfBoolean);
          return paramInt1 - 3;
        }
        if ((j > 1) && (paramArrayOfBoolean[1] != 0) && (paramArrayOfByte[paramInt1] == 1))
        {
          b(paramArrayOfBoolean);
          return paramInt1 - 2;
        }
        if ((j > 2) && (paramArrayOfBoolean[2] != 0) && (paramArrayOfByte[paramInt1] == 0) && (paramArrayOfByte[(paramInt1 + 1)] == 1))
        {
          b(paramArrayOfBoolean);
          return paramInt1 - 1;
        }
      }
      paramInt1 += 2;
      while (paramInt1 < paramInt2 - 1)
      {
        int i = paramInt1;
        if ((paramArrayOfByte[paramInt1] & 0xFE) == 0)
        {
          if ((paramArrayOfByte[(paramInt1 - 2)] == 0) && (paramArrayOfByte[(paramInt1 - 1)] == 0) && (paramArrayOfByte[paramInt1] == 1))
          {
            if (paramArrayOfBoolean != null) {
              b(paramArrayOfBoolean);
            }
            return paramInt1 - 2;
          }
          i = paramInt1 - 2;
        }
        paramInt1 = i + 3;
      }
    } while (paramArrayOfBoolean == null);
    if (j > 2) {
      if ((paramArrayOfByte[(paramInt2 - 3)] == 0) && (paramArrayOfByte[(paramInt2 - 2)] == 0) && (paramArrayOfByte[(paramInt2 - 1)] == 1))
      {
        bool1 = true;
        paramArrayOfBoolean[0] = bool1;
        if (j <= 1) {
          break label358;
        }
        if ((paramArrayOfByte[(paramInt2 - 2)] != 0) || (paramArrayOfByte[(paramInt2 - 1)] != 0)) {
          break label352;
        }
        bool1 = true;
        label254:
        paramArrayOfBoolean[1] = bool1;
        if (paramArrayOfByte[(paramInt2 - 1)] != 0) {
          break label384;
        }
      }
    }
    label384:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramArrayOfBoolean[2] = bool1;
      return paramInt2;
      bool1 = false;
      break;
      if (j == 2)
      {
        if ((paramArrayOfBoolean[2] != 0) && (paramArrayOfByte[(paramInt2 - 2)] == 0) && (paramArrayOfByte[(paramInt2 - 1)] == 1))
        {
          bool1 = true;
          break;
        }
        bool1 = false;
        break;
      }
      if ((paramArrayOfBoolean[1] != 0) && (paramArrayOfByte[(paramInt2 - 1)] == 1))
      {
        bool1 = true;
        break;
      }
      bool1 = false;
      break;
      label352:
      bool1 = false;
      break label254;
      label358:
      if ((paramArrayOfBoolean[2] != 0) && (paramArrayOfByte[(paramInt2 - 1)] == 0))
      {
        bool1 = true;
        break label254;
      }
      bool1 = false;
      break label254;
    }
  }
  
  public static void b(boolean[] paramArrayOfBoolean)
  {
    paramArrayOfBoolean[0] = false;
    paramArrayOfBoolean[1] = false;
    paramArrayOfBoolean[2] = false;
  }
  
  public static boolean b(String paramString, byte paramByte)
  {
    return (("video/avc".equals(paramString)) && ((paramByte & 0x1F) == 6)) || (("video/hevc".equals(paramString)) && ((paramByte & 0x7E) >> 1 == 39));
  }
  
  public static void e(ByteBuffer paramByteBuffer)
  {
    int m = paramByteBuffer.position();
    int k = 0;
    int i = 0;
    while (k + 1 < m)
    {
      int n = paramByteBuffer.get(k) & 0xFF;
      int j;
      if (i == 3)
      {
        j = i;
        if (n == 1)
        {
          j = i;
          if ((paramByteBuffer.get(k + 1) & 0x1F) == 7)
          {
            ByteBuffer localByteBuffer = paramByteBuffer.duplicate();
            localByteBuffer.position(k - 3);
            localByteBuffer.limit(m);
            paramByteBuffer.position(0);
            paramByteBuffer.put(localByteBuffer);
          }
        }
      }
      else
      {
        j = i;
        if (n == 0) {
          j = i + 1;
        }
      }
      i = j;
      if (n != 0) {
        i = 0;
      }
      k += 1;
    }
    paramByteBuffer.clear();
  }
  
  public static int i(byte[] paramArrayOfByte, int paramInt)
  {
    Object localObject = aSp;
    int k = 0;
    int i = 0;
    label18:
    int j;
    label50:
    do
    {
      if (i >= paramInt) {
        break label198;
      }
      if (i >= paramInt - 2) {
        break label193;
      }
      if ((paramArrayOfByte[i] != 0) || (paramArrayOfByte[(i + 1)] != 0) || (paramArrayOfByte[(i + 2)] != 3)) {
        break;
      }
      j = i;
      i = j;
    } while (j >= paramInt);
    for (;;)
    {
      try
      {
        if (aSq.length <= k) {
          aSq = Arrays.copyOf(aSq, aSq.length * 2);
        }
        aSq[k] = j;
        i = j + 3;
        k += 1;
        break;
      }
      finally {}
      if (paramInt < k)
      {
        int n = aSq[paramInt] - j;
        System.arraycopy(paramArrayOfByte, j, paramArrayOfByte, i, n);
        int i1 = i + n;
        i = i1 + 1;
        paramArrayOfByte[i1] = 0;
        paramArrayOfByte[i] = 0;
        j += n + 3;
        paramInt += 1;
        i += 1;
      }
      else
      {
        System.arraycopy(paramArrayOfByte, j, paramArrayOfByte, i, m - i);
        return m;
        i += 1;
        break label18;
        label193:
        j = paramInt;
        break label50;
        label198:
        int m = paramInt - k;
        paramInt = 0;
        i = 0;
        j = 0;
      }
    }
  }
  
  public static int j(byte[] paramArrayOfByte, int paramInt)
  {
    return paramArrayOfByte[(paramInt + 3)] & 0x1F;
  }
  
  public static h.b j(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramArrayOfByte = new k(paramArrayOfByte, paramInt1, paramInt2);
    paramArrayOfByte.dy(8);
    paramInt1 = paramArrayOfByte.dz(8);
    paramArrayOfByte.dy(16);
    int i2 = paramArrayOfByte.on();
    int i = 1;
    boolean bool1 = false;
    int i1;
    int j;
    label180:
    int m;
    int n;
    int k;
    if ((paramInt1 == 100) || (paramInt1 == 110) || (paramInt1 == 122) || (paramInt1 == 244) || (paramInt1 == 44) || (paramInt1 == 83) || (paramInt1 == 86) || (paramInt1 == 118) || (paramInt1 == 128) || (paramInt1 == 138))
    {
      i1 = paramArrayOfByte.on();
      if (i1 == 3) {
        bool1 = paramArrayOfByte.ob();
      }
      paramArrayOfByte.on();
      paramArrayOfByte.on();
      paramArrayOfByte.ok();
      if (paramArrayOfByte.ob())
      {
        if (i1 != 3)
        {
          paramInt2 = 8;
          i = 0;
        }
        for (;;)
        {
          if (i >= paramInt2) {
            break label266;
          }
          if (paramArrayOfByte.ob())
          {
            if (i < 6)
            {
              j = 16;
              m = 8;
              n = 8;
              k = 0;
              label191:
              if (k >= j) {
                break label257;
              }
              paramInt1 = n;
              if (n != 0) {
                paramInt1 = (paramArrayOfByte.om() + m + 256) % 256;
              }
              if (paramInt1 != 0) {
                break label251;
              }
            }
            for (;;)
            {
              k += 1;
              n = paramInt1;
              break label191;
              paramInt2 = 12;
              break;
              j = 64;
              break label180;
              label251:
              m = paramInt1;
            }
          }
          label257:
          i += 1;
        }
      }
      label266:
      i = i1;
    }
    for (;;)
    {
      n = paramArrayOfByte.on();
      i1 = paramArrayOfByte.on();
      j = 0;
      boolean bool2 = false;
      boolean bool3;
      if (i1 == 0)
      {
        paramInt2 = paramArrayOfByte.on() + 4;
        paramArrayOfByte.on();
        paramArrayOfByte.ok();
        k = paramArrayOfByte.on();
        j = paramArrayOfByte.on();
        bool3 = paramArrayOfByte.ob();
        if (!bool3) {
          break label608;
        }
        paramInt1 = 1;
        label334:
        if (!bool3) {
          paramArrayOfByte.ok();
        }
        paramArrayOfByte.ok();
        k = (k + 1) * 16;
        m = (2 - paramInt1) * (j + 1) * 16;
        if (!paramArrayOfByte.ob()) {
          break label702;
        }
        int i5 = paramArrayOfByte.on();
        int i6 = paramArrayOfByte.on();
        int i3 = paramArrayOfByte.on();
        int i4 = paramArrayOfByte.on();
        if (i != 0) {
          break label618;
        }
        i = 1;
        if (!bool3) {
          break label613;
        }
        paramInt1 = 1;
        label415:
        paramInt1 = 2 - paramInt1;
        j = k - i * (i5 + i6);
        i = m - paramInt1 * (i3 + i4);
        paramInt1 = j;
      }
      for (;;)
      {
        float f2 = 1.0F;
        float f1;
        if ((paramArrayOfByte.ob()) && (paramArrayOfByte.ob()))
        {
          j = paramArrayOfByte.dz(8);
          if (j == 255)
          {
            j = paramArrayOfByte.dz(16);
            k = paramArrayOfByte.dz(16);
            f1 = f2;
            if (j != 0)
            {
              f1 = f2;
              if (k != 0) {
                f1 = j / k;
              }
            }
          }
        }
        for (;;)
        {
          return new h.b(i2, paramInt1, i, f1, bool1, bool3, n + 4, i1, paramInt2, bool2);
          paramInt2 = j;
          if (i1 != 1) {
            break;
          }
          bool3 = paramArrayOfByte.ob();
          paramArrayOfByte.om();
          paramArrayOfByte.om();
          long l = paramArrayOfByte.on();
          paramInt1 = 0;
          for (;;)
          {
            paramInt2 = j;
            bool2 = bool3;
            if (paramInt1 >= l) {
              break;
            }
            paramArrayOfByte.on();
            paramInt1 += 1;
          }
          label608:
          paramInt1 = 0;
          break label334;
          label613:
          paramInt1 = 0;
          break label415;
          label618:
          if (i == 3)
          {
            paramInt1 = 1;
            label626:
            if (i != 1) {
              break label666;
            }
            i = 2;
            label635:
            if (!bool3) {
              break label672;
            }
          }
          label666:
          label672:
          for (j = 1;; j = 0)
          {
            j = (2 - j) * i;
            i = paramInt1;
            paramInt1 = j;
            break;
            paramInt1 = 2;
            break label626;
            i = 1;
            break label635;
          }
          if (j < aSo.length) {
            f1 = aSo[j];
          } else {
            f1 = 1.0F;
          }
        }
        label702:
        paramInt1 = k;
        i = m;
      }
      bool1 = false;
    }
  }
  
  public static int k(byte[] paramArrayOfByte, int paramInt)
  {
    return (paramArrayOfByte[(paramInt + 3)] & 0x7E) >> 1;
  }
  
  public static h.a l(byte[] paramArrayOfByte, int paramInt)
  {
    paramArrayOfByte = new k(paramArrayOfByte, 3, paramInt);
    paramArrayOfByte.dy(8);
    paramInt = paramArrayOfByte.on();
    int i = paramArrayOfByte.on();
    paramArrayOfByte.ok();
    return new h.a(paramInt, i, paramArrayOfByte.ob());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.i.h
 * JD-Core Version:    0.7.0.1
 */