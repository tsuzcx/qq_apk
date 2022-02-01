package com.facebook.soloader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.ClosedByInterruptException;

public final class k
{
  private static String a(f paramf, ByteBuffer paramByteBuffer, long paramLong)
  {
    AppMethodBeat.i(208117);
    StringBuilder localStringBuilder = new StringBuilder();
    for (;;)
    {
      int i = e(paramf, paramByteBuffer, paramLong);
      if (i == 0) {
        break;
      }
      localStringBuilder.append((char)i);
      paramLong = 1L + paramLong;
    }
    paramf = localStringBuilder.toString();
    AppMethodBeat.o(208117);
    return paramf;
  }
  
  private static void a(f paramf, ByteBuffer paramByteBuffer, int paramInt, long paramLong)
  {
    AppMethodBeat.i(208126);
    paramByteBuffer.position(0);
    paramByteBuffer.limit(paramInt);
    while (paramByteBuffer.remaining() > 0)
    {
      paramInt = paramf.a(paramByteBuffer, paramLong);
      if (paramInt == -1) {
        break;
      }
      paramLong += paramInt;
    }
    if (paramByteBuffer.remaining() > 0)
    {
      paramf = new a("ELF file truncated");
      AppMethodBeat.o(208126);
      throw paramf;
    }
    paramByteBuffer.position(0);
    AppMethodBeat.o(208126);
  }
  
  public static String[] a(f paramf)
  {
    AppMethodBeat.i(208086);
    if ((paramf instanceof g))
    {
      paramf = a((g)paramf);
      AppMethodBeat.o(208086);
      return paramf;
    }
    paramf = b(paramf);
    AppMethodBeat.o(208086);
    return paramf;
  }
  
  private static String[] a(g paramg)
  {
    AppMethodBeat.i(208079);
    int i = 0;
    for (;;)
    {
      try
      {
        String[] arrayOfString = b(paramg);
        AppMethodBeat.o(208079);
        return arrayOfString;
      }
      catch (ClosedByInterruptException localClosedByInterruptException)
      {
        i += 1;
        if (i > 4)
        {
          AppMethodBeat.o(208079);
          throw localClosedByInterruptException;
        }
        Thread.interrupted();
        paramg.PT();
      }
    }
  }
  
  private static long b(f paramf, ByteBuffer paramByteBuffer, long paramLong)
  {
    AppMethodBeat.i(208132);
    a(paramf, paramByteBuffer, 8, paramLong);
    paramLong = paramByteBuffer.getLong();
    AppMethodBeat.o(208132);
    return paramLong;
  }
  
  private static String[] b(f paramf)
  {
    AppMethodBeat.i(208107);
    ByteBuffer localByteBuffer = ByteBuffer.allocate(8);
    localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    long l1 = c(paramf, localByteBuffer, 0L);
    if (l1 != 1179403647L)
    {
      paramf = new a("file is not ELF: 0x" + Long.toHexString(l1));
      AppMethodBeat.o(208107);
      throw paramf;
    }
    int j;
    label126:
    long l2;
    label142:
    int k;
    label156:
    long l4;
    label184:
    label202:
    long l6;
    if (e(paramf, localByteBuffer, 4L) == 1)
    {
      j = 1;
      if (e(paramf, localByteBuffer, 5L) == 2) {
        localByteBuffer.order(ByteOrder.BIG_ENDIAN);
      }
      if (j == 0) {
        break label288;
      }
      l1 = c(paramf, localByteBuffer, 28L);
      if (j == 0) {
        break label302;
      }
      l2 = d(paramf, localByteBuffer, 44L);
      if (j == 0) {
        break label317;
      }
      k = d(paramf, localByteBuffer, 42L);
      l4 = l2;
      if (l2 == 65535L)
      {
        if (j == 0) {
          break label330;
        }
        l2 = c(paramf, localByteBuffer, 32L);
        if (j == 0) {
          break label344;
        }
        l4 = c(paramf, localByteBuffer, l2 + 28L);
      }
      l6 = 0L;
      l3 = 0L;
      l5 = l1;
    }
    for (;;)
    {
      l2 = l6;
      if (l3 < l4)
      {
        if (c(paramf, localByteBuffer, 0L + l5) != 2L) {
          break label378;
        }
        if (j == 0) {
          break label361;
        }
      }
      label288:
      label302:
      label317:
      label330:
      label344:
      label361:
      for (l2 = c(paramf, localByteBuffer, 4L + l5);; l2 = b(paramf, localByteBuffer, 8L + l5))
      {
        if (l2 != 0L) {
          break label394;
        }
        paramf = new a("ELF file does not contain dynamic linking information");
        AppMethodBeat.o(208107);
        throw paramf;
        j = 0;
        break;
        l1 = b(paramf, localByteBuffer, 32L);
        break label126;
        l2 = d(paramf, localByteBuffer, 56L);
        break label142;
        k = d(paramf, localByteBuffer, 54L);
        break label156;
        l2 = b(paramf, localByteBuffer, 40L);
        break label184;
        l4 = c(paramf, localByteBuffer, l2 + 44L);
        break label202;
      }
      label378:
      l5 += k;
      l3 += 1L;
    }
    label394:
    int i = 0;
    long l3 = 0L;
    long l5 = l2;
    if (j != 0) {
      l6 = c(paramf, localByteBuffer, 0L + l5);
    }
    while (l6 == 1L) {
      if (i == 2147483647)
      {
        paramf = new a("malformed DT_NEEDED section");
        AppMethodBeat.o(208107);
        throw paramf;
        l6 = b(paramf, localByteBuffer, 0L + l5);
      }
      else
      {
        i += 1;
      }
    }
    label570:
    label721:
    label977:
    for (;;)
    {
      if (j != 0) {}
      for (long l7 = 8L;; l7 = 16L)
      {
        l5 += l7;
        if (l6 != 0L) {
          break label974;
        }
        if (l3 != 0L) {
          break label570;
        }
        paramf = new a("Dynamic section string-table not found");
        AppMethodBeat.o(208107);
        throw paramf;
        if (l6 != 5L) {
          break label977;
        }
        if (j != 0) {}
        for (l3 = c(paramf, localByteBuffer, 4L + l5);; l3 = b(paramf, localByteBuffer, 8L + l5)) {
          break;
        }
      }
      int m = 0;
      if (m < l4) {
        if (c(paramf, localByteBuffer, 0L + l1) == 1L) {
          if (j != 0)
          {
            l5 = c(paramf, localByteBuffer, 8L + l1);
            label615:
            if (j == 0) {
              break label721;
            }
            l6 = c(paramf, localByteBuffer, 20L + l1);
            label633:
            if ((l5 > l3) || (l3 >= l6 + l5)) {
              break label755;
            }
            if (j == 0) {
              break label738;
            }
            l1 = c(paramf, localByteBuffer, 4L + l1);
          }
        }
      }
      for (l1 += l3 - l5;; l1 = 0L)
      {
        if (l1 == 0L)
        {
          paramf = new a("did not find file offset of DT_STRTAB table");
          AppMethodBeat.o(208107);
          throw paramf;
          l5 = b(paramf, localByteBuffer, 16L + l1);
          break label615;
          l6 = b(paramf, localByteBuffer, 40L + l1);
          break label633;
          label738:
          l1 = b(paramf, localByteBuffer, 8L + l1);
          break label670;
          label755:
          l5 = k;
          m += 1;
          l1 = l5 + l1;
          break;
        }
        String[] arrayOfString = new String[i];
        for (i = 0;; i = k)
        {
          if (j != 0)
          {
            l3 = c(paramf, localByteBuffer, 0L + l2);
            k = i;
            if (l3 != 1L) {
              break label900;
            }
            if (j == 0) {
              break label879;
            }
          }
          label879:
          for (l4 = c(paramf, localByteBuffer, 4L + l2);; l4 = b(paramf, localByteBuffer, 8L + l2))
          {
            arrayOfString[i] = a(paramf, localByteBuffer, l4 + l1);
            if (i != 2147483647) {
              break label896;
            }
            paramf = new a("malformed DT_NEEDED section");
            AppMethodBeat.o(208107);
            throw paramf;
            l3 = b(paramf, localByteBuffer, 0L + l2);
            break;
          }
          k = i + 1;
          if (j != 0) {
            l4 = 8L;
          }
          while (l3 == 0L) {
            if (k != arrayOfString.length)
            {
              paramf = new a("malformed DT_NEEDED section");
              AppMethodBeat.o(208107);
              throw paramf;
              l4 = 16L;
            }
            else
            {
              AppMethodBeat.o(208107);
              return arrayOfString;
            }
          }
          l2 = l4 + l2;
        }
      }
      break;
    }
  }
  
  private static long c(f paramf, ByteBuffer paramByteBuffer, long paramLong)
  {
    AppMethodBeat.i(208139);
    a(paramf, paramByteBuffer, 4, paramLong);
    paramLong = paramByteBuffer.getInt();
    AppMethodBeat.o(208139);
    return paramLong & 0xFFFFFFFF;
  }
  
  private static int d(f paramf, ByteBuffer paramByteBuffer, long paramLong)
  {
    AppMethodBeat.i(208146);
    a(paramf, paramByteBuffer, 2, paramLong);
    int i = paramByteBuffer.getShort();
    AppMethodBeat.o(208146);
    return i & 0xFFFF;
  }
  
  private static short e(f paramf, ByteBuffer paramByteBuffer, long paramLong)
  {
    AppMethodBeat.i(208154);
    a(paramf, paramByteBuffer, 1, paramLong);
    short s = (short)(paramByteBuffer.get() & 0xFF);
    AppMethodBeat.o(208154);
    return s;
  }
  
  static final class a
    extends RuntimeException
  {
    a(String paramString)
    {
      super();
    }
  }
  
  public static enum b
  {
    private final String value;
    
    static
    {
      AppMethodBeat.i(208145);
      cCR = new b("NOT_SO", 0, "not_so");
      cCS = new b("X86", 1, "x86");
      cCT = new b("ARM", 2, "armeabi-v7a");
      cCU = new b("X86_64", 3, "x86_64");
      cCV = new b("AARCH64", 4, "arm64-v8a");
      cCW = new b("OTHERS", 5, "others");
      cCX = new b[] { cCR, cCS, cCT, cCU, cCV, cCW };
      AppMethodBeat.o(208145);
    }
    
    private b(String paramString)
    {
      this.value = paramString;
    }
    
    public final String toString()
    {
      return this.value;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.facebook.soloader.k
 * JD-Core Version:    0.7.0.1
 */