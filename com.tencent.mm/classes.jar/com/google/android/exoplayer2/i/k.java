package com.google.android.exoplayer2.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.util.Arrays;

public final class k
{
  public static final byte[] baF;
  public static final float[] baS;
  private static final Object baT;
  private static int[] baU;
  
  static
  {
    AppMethodBeat.i(95892);
    baF = new byte[] { 0, 0, 0, 1 };
    baS = new float[] { 1.0F, 1.0F, 1.090909F, 0.9090909F, 1.454546F, 1.212121F, 2.181818F, 1.818182F, 2.909091F, 2.424243F, 1.636364F, 1.363636F, 1.939394F, 1.616162F, 1.333333F, 1.5F, 2.0F };
    baT = new Object();
    baU = new int[10];
    AppMethodBeat.o(95892);
  }
  
  public static int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean[] paramArrayOfBoolean)
  {
    boolean bool2 = true;
    AppMethodBeat.i(95891);
    int j = paramInt2 - paramInt1;
    if (j >= 0) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      a.checkState(bool1);
      if (j != 0) {
        break;
      }
      AppMethodBeat.o(95891);
      return paramInt2;
    }
    if (paramArrayOfBoolean != null)
    {
      if (paramArrayOfBoolean[0] != 0)
      {
        a(paramArrayOfBoolean);
        AppMethodBeat.o(95891);
        return paramInt1 - 3;
      }
      if ((j > 1) && (paramArrayOfBoolean[1] != 0) && (paramArrayOfByte[paramInt1] == 1))
      {
        a(paramArrayOfBoolean);
        AppMethodBeat.o(95891);
        return paramInt1 - 2;
      }
      if ((j > 2) && (paramArrayOfBoolean[2] != 0) && (paramArrayOfByte[paramInt1] == 0) && (paramArrayOfByte[(paramInt1 + 1)] == 1))
      {
        a(paramArrayOfBoolean);
        AppMethodBeat.o(95891);
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
            a(paramArrayOfBoolean);
          }
          AppMethodBeat.o(95891);
          return paramInt1 - 2;
        }
        i = paramInt1 - 2;
      }
      paramInt1 = i + 3;
    }
    if (paramArrayOfBoolean != null)
    {
      if (j <= 2) {
        break label319;
      }
      if ((paramArrayOfByte[(paramInt2 - 3)] != 0) || (paramArrayOfByte[(paramInt2 - 2)] != 0) || (paramArrayOfByte[(paramInt2 - 1)] != 1)) {
        break label313;
      }
      bool1 = true;
      paramArrayOfBoolean[0] = bool1;
      if (j <= 1) {
        break label393;
      }
      if ((paramArrayOfByte[(paramInt2 - 2)] != 0) || (paramArrayOfByte[(paramInt2 - 1)] != 0)) {
        break label387;
      }
      bool1 = true;
      label284:
      paramArrayOfBoolean[1] = bool1;
      if (paramArrayOfByte[(paramInt2 - 1)] != 0) {
        break label419;
      }
    }
    label387:
    label393:
    label419:
    for (bool1 = bool2;; bool1 = false)
    {
      paramArrayOfBoolean[2] = bool1;
      AppMethodBeat.o(95891);
      return paramInt2;
      label313:
      bool1 = false;
      break;
      label319:
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
      bool1 = false;
      break label284;
      if ((paramArrayOfBoolean[2] != 0) && (paramArrayOfByte[(paramInt2 - 1)] == 0))
      {
        bool1 = true;
        break label284;
      }
      bool1 = false;
      break label284;
    }
  }
  
  public static void a(boolean[] paramArrayOfBoolean)
  {
    paramArrayOfBoolean[0] = false;
    paramArrayOfBoolean[1] = false;
    paramArrayOfBoolean[2] = false;
  }
  
  public static boolean b(String paramString, byte paramByte)
  {
    AppMethodBeat.i(95888);
    if ((("video/avc".equals(paramString)) && ((paramByte & 0x1F) == 6)) || (("video/hevc".equals(paramString)) && ((paramByte & 0x7E) >> 1 == 39)))
    {
      AppMethodBeat.o(95888);
      return true;
    }
    AppMethodBeat.o(95888);
    return false;
  }
  
  public static void e(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(95887);
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
            AppMethodBeat.o(95887);
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
    AppMethodBeat.o(95887);
  }
  
  public static int h(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(95886);
    Object localObject = baT;
    int k = 0;
    int i = 0;
    label23:
    int j;
    label55:
    do
    {
      if (i >= paramInt) {
        break label216;
      }
      if (i >= paramInt - 2) {
        break label211;
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
        if (baU.length <= k)
        {
          int[] arrayOfInt = baU;
          baU = Arrays.copyOf(arrayOfInt, arrayOfInt.length * 2);
        }
        baU[k] = j;
        i = j + 3;
        k += 1;
        break;
      }
      finally
      {
        int n;
        int i1;
        AppMethodBeat.o(95886);
      }
      if (paramInt < k)
      {
        n = baU[paramInt] - j;
        System.arraycopy(paramArrayOfByte, j, paramArrayOfByte, i, n);
        i += n;
        i1 = i + 1;
        paramArrayOfByte[i] = 0;
        i = i1 + 1;
        paramArrayOfByte[i1] = 0;
        j += n + 3;
        paramInt += 1;
      }
      else
      {
        System.arraycopy(paramArrayOfByte, j, paramArrayOfByte, i, m - i);
        AppMethodBeat.o(95886);
        return m;
        i += 1;
        break label23;
        label211:
        j = paramInt;
        break label55;
        label216:
        int m = paramInt - k;
        i = 0;
        paramInt = 0;
        j = 0;
      }
    }
  }
  
  public static int i(byte[] paramArrayOfByte, int paramInt)
  {
    return paramArrayOfByte[(paramInt + 3)] & 0x1F;
  }
  
  public static int j(byte[] paramArrayOfByte, int paramInt)
  {
    return (paramArrayOfByte[(paramInt + 3)] & 0x7E) >> 1;
  }
  
  public static k.a k(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(95890);
    paramArrayOfByte = new n(paramArrayOfByte, 3, paramInt);
    paramArrayOfByte.dE(8);
    paramInt = paramArrayOfByte.qZ();
    int i = paramArrayOfByte.qZ();
    paramArrayOfByte.qK();
    paramArrayOfByte = new k.a(paramInt, i, paramArrayOfByte.oj());
    AppMethodBeat.o(95890);
    return paramArrayOfByte;
  }
  
  public static k.b k(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(95889);
    paramArrayOfByte = new n(paramArrayOfByte, paramInt1, paramInt2);
    paramArrayOfByte.dE(8);
    paramInt1 = paramArrayOfByte.dD(8);
    paramArrayOfByte.dE(16);
    int i2 = paramArrayOfByte.qZ();
    int i = 1;
    boolean bool1 = false;
    int i1;
    int j;
    label185:
    int m;
    int n;
    int k;
    if ((paramInt1 == 100) || (paramInt1 == 110) || (paramInt1 == 122) || (paramInt1 == 244) || (paramInt1 == 44) || (paramInt1 == 83) || (paramInt1 == 86) || (paramInt1 == 118) || (paramInt1 == 128) || (paramInt1 == 138))
    {
      i1 = paramArrayOfByte.qZ();
      if (i1 == 3) {
        bool1 = paramArrayOfByte.oj();
      }
      paramArrayOfByte.qZ();
      paramArrayOfByte.qZ();
      paramArrayOfByte.qK();
      if (paramArrayOfByte.oj())
      {
        if (i1 != 3)
        {
          paramInt2 = 8;
          i = 0;
        }
        for (;;)
        {
          if (i >= paramInt2) {
            break label271;
          }
          if (paramArrayOfByte.oj())
          {
            if (i < 6)
            {
              j = 16;
              m = 8;
              n = 8;
              k = 0;
              label196:
              if (k >= j) {
                break label262;
              }
              paramInt1 = n;
              if (n != 0) {
                paramInt1 = (paramArrayOfByte.qY() + m + 256) % 256;
              }
              if (paramInt1 != 0) {
                break label256;
              }
            }
            for (;;)
            {
              k += 1;
              n = paramInt1;
              break label196;
              paramInt2 = 12;
              break;
              j = 64;
              break label185;
              label256:
              m = paramInt1;
            }
          }
          label262:
          i += 1;
        }
      }
      label271:
      i = i1;
    }
    for (;;)
    {
      n = paramArrayOfByte.qZ();
      i1 = paramArrayOfByte.qZ();
      j = 0;
      boolean bool2 = false;
      boolean bool3;
      if (i1 == 0)
      {
        paramInt2 = paramArrayOfByte.qZ() + 4;
        paramArrayOfByte.qZ();
        paramArrayOfByte.qK();
        k = paramArrayOfByte.qZ();
        j = paramArrayOfByte.qZ();
        bool3 = paramArrayOfByte.oj();
        if (!bool3) {
          break label620;
        }
        paramInt1 = 1;
        label339:
        if (!bool3) {
          paramArrayOfByte.qK();
        }
        paramArrayOfByte.qK();
        k = (k + 1) * 16;
        m = (2 - paramInt1) * (j + 1) * 16;
        if (!paramArrayOfByte.oj()) {
          break label714;
        }
        int i5 = paramArrayOfByte.qZ();
        int i6 = paramArrayOfByte.qZ();
        int i3 = paramArrayOfByte.qZ();
        int i4 = paramArrayOfByte.qZ();
        if (i != 0) {
          break label630;
        }
        i = 1;
        if (!bool3) {
          break label625;
        }
        paramInt1 = 1;
        label420:
        paramInt1 = 2 - paramInt1;
        j = k - i * (i5 + i6);
        i = m - paramInt1 * (i3 + i4);
        paramInt1 = j;
      }
      for (;;)
      {
        float f2 = 1.0F;
        float f1;
        if ((paramArrayOfByte.oj()) && (paramArrayOfByte.oj()))
        {
          j = paramArrayOfByte.dD(8);
          if (j == 255)
          {
            j = paramArrayOfByte.dD(16);
            k = paramArrayOfByte.dD(16);
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
          paramArrayOfByte = new k.b(i2, paramInt1, i, f1, bool1, bool3, n + 4, i1, paramInt2, bool2);
          AppMethodBeat.o(95889);
          return paramArrayOfByte;
          paramInt2 = j;
          if (i1 != 1) {
            break;
          }
          bool3 = paramArrayOfByte.oj();
          paramArrayOfByte.qY();
          paramArrayOfByte.qY();
          long l = paramArrayOfByte.qZ();
          paramInt1 = 0;
          for (;;)
          {
            paramInt2 = j;
            bool2 = bool3;
            if (paramInt1 >= l) {
              break;
            }
            paramArrayOfByte.qZ();
            paramInt1 += 1;
          }
          label620:
          paramInt1 = 0;
          break label339;
          label625:
          paramInt1 = 0;
          break label420;
          label630:
          if (i == 3)
          {
            paramInt1 = 1;
            label638:
            if (i != 1) {
              break label678;
            }
            i = 2;
            if (!bool3) {
              break label684;
            }
          }
          label647:
          label678:
          label684:
          for (j = 1;; j = 0)
          {
            j = (2 - j) * i;
            i = paramInt1;
            paramInt1 = j;
            break;
            paramInt1 = 2;
            break label638;
            i = 1;
            break label647;
          }
          if (j < baS.length) {
            f1 = baS[j];
          } else {
            f1 = 1.0F;
          }
        }
        label714:
        paramInt1 = k;
        i = m;
      }
      bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.i.k
 * JD-Core Version:    0.7.0.1
 */