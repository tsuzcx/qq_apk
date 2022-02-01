package com.google.b;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class i
  extends f
{
  private static final boolean bPx = df.Js();
  private static final Logger logger = Logger.getLogger(i.class.getName());
  
  public static i A(byte[] paramArrayOfByte)
  {
    return new a(paramArrayOfByte, paramArrayOfByte.length);
  }
  
  public static int AT()
  {
    return gL(6) + 8;
  }
  
  public static int AU()
  {
    return 4;
  }
  
  public static int AV()
  {
    return 4;
  }
  
  public static int AW()
  {
    return 8;
  }
  
  public static int AX()
  {
    return 8;
  }
  
  public static int AY()
  {
    return 4;
  }
  
  public static int AZ()
  {
    return 8;
  }
  
  public static int B(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte.length;
    return i + gN(i);
  }
  
  public static int Ba()
  {
    return 1;
  }
  
  public static int a(int paramInt, bi parambi)
  {
    int i = gL(1);
    paramInt = bN(2, paramInt);
    int j = gL(3);
    int k = parambi.Ad();
    return i * 2 + paramInt + (j + (k + gN(k)));
  }
  
  public static int a(bi parambi)
  {
    int i = parambi.Ad();
    return i + gN(i);
  }
  
  public static int aD(long paramLong)
  {
    return aE(paramLong);
  }
  
  public static int aE(long paramLong)
  {
    if ((0xFFFFFF80 & paramLong) == 0L)
    {
      j = 1;
      return j;
    }
    if (paramLong < 0L) {
      return 10;
    }
    int j = 2;
    if ((0x0 & paramLong) != 0L)
    {
      j = 6;
      paramLong >>>= 28;
    }
    for (;;)
    {
      int i = j;
      long l = paramLong;
      if ((0xFFE00000 & paramLong) != 0L)
      {
        i = j + 2;
        l = paramLong >>> 14;
      }
      j = i;
      if ((l & 0xFFFFC000) == 0L) {
        break;
      }
      return i + 1;
    }
  }
  
  public static int aF(long paramLong)
  {
    return aE(aG(paramLong));
  }
  
  private static long aG(long paramLong)
  {
    return paramLong << 1 ^ paramLong >> 63;
  }
  
  public static int b(g paramg)
  {
    int i = paramg.size();
    return i + gN(i);
  }
  
  public static int bM(int paramInt1, int paramInt2)
  {
    return gL(paramInt1) + gM(paramInt2);
  }
  
  public static int bN(int paramInt1, int paramInt2)
  {
    return gL(paramInt1) + gN(paramInt2);
  }
  
  public static int bO(int paramInt1, int paramInt2)
  {
    return gL(paramInt1) + gM(paramInt2);
  }
  
  public static int c(int paramInt, bw parambw)
  {
    return gL(paramInt) + c(parambw);
  }
  
  public static int c(int paramInt, g paramg)
  {
    paramInt = gL(paramInt);
    int i = paramg.size();
    return paramInt + (i + gN(i));
  }
  
  public static int c(bw parambw)
  {
    int i = parambw.Ad();
    return i + gN(i);
  }
  
  public static int cv(String paramString)
  {
    try
    {
      i = dg.B(paramString);
      return i + gN(i);
    }
    catch (dg.d locald)
    {
      for (;;)
      {
        int i = paramString.getBytes(be.UTF_8).length;
      }
    }
  }
  
  public static int d(int paramInt, bw parambw)
  {
    return gL(1) * 2 + bN(2, paramInt) + c(3, parambw);
  }
  
  public static int d(int paramInt, g paramg)
  {
    return gL(1) * 2 + bN(2, paramInt) + c(3, paramg);
  }
  
  @Deprecated
  public static int d(bw parambw)
  {
    return parambw.Ad();
  }
  
  @Deprecated
  public static int f(int paramInt, bw parambw)
  {
    return gL(paramInt) * 2 + parambw.Ad();
  }
  
  public static int g(int paramInt, String paramString)
  {
    return gL(paramInt) + cv(paramString);
  }
  
  public static int gH(int paramInt)
  {
    return gL(paramInt) + 4;
  }
  
  public static int gI(int paramInt)
  {
    return gL(paramInt) + 8;
  }
  
  public static int gJ(int paramInt)
  {
    return gL(paramInt) + 4;
  }
  
  public static int gK(int paramInt)
  {
    return gL(paramInt) + 1;
  }
  
  public static int gL(int paramInt)
  {
    return gN(dh.bT(paramInt, 0));
  }
  
  public static int gM(int paramInt)
  {
    if (paramInt >= 0) {
      return gN(paramInt);
    }
    return 10;
  }
  
  public static int gN(int paramInt)
  {
    if ((paramInt & 0xFFFFFF80) == 0) {
      return 1;
    }
    if ((paramInt & 0xFFFFC000) == 0) {
      return 2;
    }
    if ((0xFFE00000 & paramInt) == 0) {
      return 3;
    }
    if ((0xF0000000 & paramInt) == 0) {
      return 4;
    }
    return 5;
  }
  
  public static int gO(int paramInt)
  {
    return gN(gQ(paramInt));
  }
  
  public static int gP(int paramInt)
  {
    return gM(paramInt);
  }
  
  private static int gQ(int paramInt)
  {
    return paramInt << 1 ^ paramInt >> 31;
  }
  
  @Deprecated
  public static int gR(int paramInt)
  {
    return gN(paramInt);
  }
  
  public static int p(int paramInt, long paramLong)
  {
    return gL(paramInt) + aE(paramLong);
  }
  
  public static int q(int paramInt, long paramLong)
  {
    return gL(paramInt) + aE(paramLong);
  }
  
  public abstract int Bb();
  
  public final void Bc()
  {
    if (Bb() != 0) {
      throw new IllegalStateException("Did not write as much data as expected.");
    }
  }
  
  public abstract void a(int paramInt, bw parambw);
  
  public abstract void a(int paramInt, g paramg);
  
  public abstract void a(g paramg);
  
  final void a(String paramString, dg.d paramd)
  {
    logger.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", paramd);
    paramString = paramString.getBytes(be.UTF_8);
    try
    {
      gE(paramString.length);
      o(paramString, 0, paramString.length);
      return;
    }
    catch (IndexOutOfBoundsException paramString)
    {
      throw new b(paramString);
    }
    catch (b paramString)
    {
      throw paramString;
    }
  }
  
  public abstract void aA(long paramLong);
  
  public final void aB(long paramLong)
  {
    aA(aG(paramLong));
  }
  
  public abstract void aC(long paramLong);
  
  public final void ac(float paramFloat)
  {
    gG(Float.floatToRawIntBits(paramFloat));
  }
  
  public abstract void b(int paramInt, bw parambw);
  
  public abstract void b(int paramInt, g paramg);
  
  public abstract void b(bw parambw);
  
  public abstract void bI(int paramInt1, int paramInt2);
  
  public abstract void bJ(int paramInt1, int paramInt2);
  
  public abstract void bK(int paramInt1, int paramInt2);
  
  public abstract void bL(int paramInt1, int paramInt2);
  
  public final void br(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      d((byte)i);
      return;
    }
  }
  
  public abstract void cu(String paramString);
  
  public abstract void d(byte paramByte);
  
  @Deprecated
  public final void e(int paramInt, bw parambw)
  {
    bI(paramInt, 3);
    parambw.a(this);
    bI(paramInt, 4);
  }
  
  public final void f(double paramDouble)
  {
    aC(Double.doubleToRawLongBits(paramDouble));
  }
  
  public abstract void f(int paramInt, String paramString);
  
  public abstract void gD(int paramInt);
  
  public abstract void gE(int paramInt);
  
  public final void gF(int paramInt)
  {
    gE(gQ(paramInt));
  }
  
  public abstract void gG(int paramInt);
  
  public final void i(int paramInt, float paramFloat)
  {
    bL(paramInt, Float.floatToRawIntBits(paramFloat));
  }
  
  public abstract void n(int paramInt, long paramLong);
  
  public abstract void o(int paramInt, long paramLong);
  
  public abstract void o(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  abstract void r(byte[] paramArrayOfByte, int paramInt);
  
  public abstract void t(int paramInt, boolean paramBoolean);
  
  static final class a
    extends i
  {
    private final byte[] buffer;
    private final int limit;
    private final int offset;
    private int position;
    
    a(byte[] paramArrayOfByte, int paramInt)
    {
      super();
      if (paramArrayOfByte == null) {
        throw new NullPointerException("buffer");
      }
      if ((paramInt | 0x0 | paramArrayOfByte.length - (paramInt + 0)) < 0) {
        throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", new Object[] { Integer.valueOf(paramArrayOfByte.length), Integer.valueOf(0), Integer.valueOf(paramInt) }));
      }
      this.buffer = paramArrayOfByte;
      this.offset = 0;
      this.position = 0;
      this.limit = (paramInt + 0);
    }
    
    private void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      try
      {
        System.arraycopy(paramArrayOfByte, paramInt1, this.buffer, this.position, paramInt2);
        this.position += paramInt2;
        return;
      }
      catch (IndexOutOfBoundsException paramArrayOfByte)
      {
        throw new i.b(String.format("Pos: %d, limit: %d, len: %d", new Object[] { Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(paramInt2) }), paramArrayOfByte);
      }
    }
    
    public final int Bb()
    {
      return this.limit - this.position;
    }
    
    public final void a(int paramInt, bw parambw)
    {
      bI(paramInt, 2);
      b(parambw);
    }
    
    public final void a(int paramInt, g paramg)
    {
      bI(paramInt, 2);
      a(paramg);
    }
    
    public final void a(g paramg)
    {
      gE(paramg.size());
      paramg.a(this);
    }
    
    public final void aA(long paramLong)
    {
      long l = paramLong;
      byte[] arrayOfByte;
      int i;
      if (i.bPx)
      {
        l = paramLong;
        if (Bb() >= 10) {
          for (;;)
          {
            if ((paramLong & 0xFFFFFF80) == 0L)
            {
              arrayOfByte = this.buffer;
              i = this.position;
              this.position = (i + 1);
              df.a(arrayOfByte, i, (byte)(int)paramLong);
              return;
            }
            arrayOfByte = this.buffer;
            i = this.position;
            this.position = (i + 1);
            df.a(arrayOfByte, i, (byte)((int)paramLong & 0x7F | 0x80));
            paramLong >>>= 7;
          }
        }
      }
      try
      {
        do
        {
          arrayOfByte = this.buffer;
          i = this.position;
          this.position = (i + 1);
          arrayOfByte[i] = ((byte)((int)l & 0x7F | 0x80));
          l >>>= 7;
        } while ((l & 0xFFFFFF80) != 0L);
        arrayOfByte = this.buffer;
        i = this.position;
        this.position = (i + 1);
        arrayOfByte[i] = ((byte)(int)l);
        return;
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
      {
        throw new i.b(String.format("Pos: %d, limit: %d, len: %d", new Object[] { Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(1) }), localIndexOutOfBoundsException);
      }
    }
    
    public final void aC(long paramLong)
    {
      try
      {
        byte[] arrayOfByte = this.buffer;
        int i = this.position;
        this.position = (i + 1);
        arrayOfByte[i] = ((byte)((int)paramLong & 0xFF));
        arrayOfByte = this.buffer;
        i = this.position;
        this.position = (i + 1);
        arrayOfByte[i] = ((byte)((int)(paramLong >> 8) & 0xFF));
        arrayOfByte = this.buffer;
        i = this.position;
        this.position = (i + 1);
        arrayOfByte[i] = ((byte)((int)(paramLong >> 16) & 0xFF));
        arrayOfByte = this.buffer;
        i = this.position;
        this.position = (i + 1);
        arrayOfByte[i] = ((byte)((int)(paramLong >> 24) & 0xFF));
        arrayOfByte = this.buffer;
        i = this.position;
        this.position = (i + 1);
        arrayOfByte[i] = ((byte)((int)(paramLong >> 32) & 0xFF));
        arrayOfByte = this.buffer;
        i = this.position;
        this.position = (i + 1);
        arrayOfByte[i] = ((byte)((int)(paramLong >> 40) & 0xFF));
        arrayOfByte = this.buffer;
        i = this.position;
        this.position = (i + 1);
        arrayOfByte[i] = ((byte)((int)(paramLong >> 48) & 0xFF));
        arrayOfByte = this.buffer;
        i = this.position;
        this.position = (i + 1);
        arrayOfByte[i] = ((byte)((int)(paramLong >> 56) & 0xFF));
        return;
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
      {
        throw new i.b(String.format("Pos: %d, limit: %d, len: %d", new Object[] { Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(1) }), localIndexOutOfBoundsException);
      }
    }
    
    public final void b(int paramInt, bw parambw)
    {
      bI(1, 3);
      bK(2, paramInt);
      a(3, parambw);
      bI(1, 4);
    }
    
    public final void b(int paramInt, g paramg)
    {
      bI(1, 3);
      bK(2, paramInt);
      a(3, paramg);
      bI(1, 4);
    }
    
    public final void b(bw parambw)
    {
      gE(parambw.Ad());
      parambw.a(this);
    }
    
    public final void bI(int paramInt1, int paramInt2)
    {
      gE(dh.bT(paramInt1, paramInt2));
    }
    
    public final void bJ(int paramInt1, int paramInt2)
    {
      bI(paramInt1, 0);
      gD(paramInt2);
    }
    
    public final void bK(int paramInt1, int paramInt2)
    {
      bI(paramInt1, 0);
      gE(paramInt2);
    }
    
    public final void bL(int paramInt1, int paramInt2)
    {
      bI(paramInt1, 5);
      gG(paramInt2);
    }
    
    public final void cu(String paramString)
    {
      int i = this.position;
      try
      {
        int k = gN(paramString.length() * 3);
        int j = gN(paramString.length());
        if (j == k)
        {
          this.position = (i + j);
          k = dg.a(paramString, this.buffer, this.position, Bb());
          this.position = i;
          gE(k - i - j);
          this.position = k;
          return;
        }
        gE(dg.B(paramString));
        this.position = dg.a(paramString, this.buffer, this.position, Bb());
        return;
      }
      catch (dg.d locald)
      {
        this.position = i;
        a(paramString, locald);
        return;
      }
      catch (IndexOutOfBoundsException paramString)
      {
        throw new i.b(paramString);
      }
    }
    
    public final void d(byte paramByte)
    {
      try
      {
        byte[] arrayOfByte = this.buffer;
        int i = this.position;
        this.position = (i + 1);
        arrayOfByte[i] = paramByte;
        return;
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
      {
        throw new i.b(String.format("Pos: %d, limit: %d, len: %d", new Object[] { Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(1) }), localIndexOutOfBoundsException);
      }
    }
    
    public final void f(int paramInt, String paramString)
    {
      bI(paramInt, 2);
      cu(paramString);
    }
    
    public final void gD(int paramInt)
    {
      if (paramInt >= 0)
      {
        gE(paramInt);
        return;
      }
      aA(paramInt);
    }
    
    public final void gE(int paramInt)
    {
      int i = paramInt;
      byte[] arrayOfByte;
      if (i.bPx)
      {
        i = paramInt;
        if (!e.An())
        {
          i = paramInt;
          if (Bb() >= 5)
          {
            if ((paramInt & 0xFFFFFF80) == 0)
            {
              arrayOfByte = this.buffer;
              i = this.position;
              this.position = (i + 1);
              df.a(arrayOfByte, i, (byte)paramInt);
              return;
            }
            arrayOfByte = this.buffer;
            i = this.position;
            this.position = (i + 1);
            df.a(arrayOfByte, i, (byte)(paramInt | 0x80));
            paramInt >>>= 7;
            if ((paramInt & 0xFFFFFF80) == 0)
            {
              arrayOfByte = this.buffer;
              i = this.position;
              this.position = (i + 1);
              df.a(arrayOfByte, i, (byte)paramInt);
              return;
            }
            arrayOfByte = this.buffer;
            i = this.position;
            this.position = (i + 1);
            df.a(arrayOfByte, i, (byte)(paramInt | 0x80));
            paramInt >>>= 7;
            if ((paramInt & 0xFFFFFF80) == 0)
            {
              arrayOfByte = this.buffer;
              i = this.position;
              this.position = (i + 1);
              df.a(arrayOfByte, i, (byte)paramInt);
              return;
            }
            arrayOfByte = this.buffer;
            i = this.position;
            this.position = (i + 1);
            df.a(arrayOfByte, i, (byte)(paramInt | 0x80));
            paramInt >>>= 7;
            if ((paramInt & 0xFFFFFF80) == 0)
            {
              arrayOfByte = this.buffer;
              i = this.position;
              this.position = (i + 1);
              df.a(arrayOfByte, i, (byte)paramInt);
              return;
            }
            arrayOfByte = this.buffer;
            i = this.position;
            this.position = (i + 1);
            df.a(arrayOfByte, i, (byte)(paramInt | 0x80));
            arrayOfByte = this.buffer;
            i = this.position;
            this.position = (i + 1);
            df.a(arrayOfByte, i, (byte)(paramInt >>> 7));
            return;
          }
        }
      }
      try
      {
        do
        {
          arrayOfByte = this.buffer;
          paramInt = this.position;
          this.position = (paramInt + 1);
          arrayOfByte[paramInt] = ((byte)(i & 0x7F | 0x80));
          i >>>= 7;
        } while ((i & 0xFFFFFF80) != 0);
        arrayOfByte = this.buffer;
        paramInt = this.position;
        this.position = (paramInt + 1);
        arrayOfByte[paramInt] = ((byte)i);
        return;
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
      {
        throw new i.b(String.format("Pos: %d, limit: %d, len: %d", new Object[] { Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(1) }), localIndexOutOfBoundsException);
      }
    }
    
    public final void gG(int paramInt)
    {
      try
      {
        byte[] arrayOfByte = this.buffer;
        int i = this.position;
        this.position = (i + 1);
        arrayOfByte[i] = ((byte)(paramInt & 0xFF));
        arrayOfByte = this.buffer;
        i = this.position;
        this.position = (i + 1);
        arrayOfByte[i] = ((byte)(paramInt >> 8 & 0xFF));
        arrayOfByte = this.buffer;
        i = this.position;
        this.position = (i + 1);
        arrayOfByte[i] = ((byte)(paramInt >> 16 & 0xFF));
        arrayOfByte = this.buffer;
        i = this.position;
        this.position = (i + 1);
        arrayOfByte[i] = ((byte)(paramInt >> 24 & 0xFF));
        return;
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
      {
        throw new i.b(String.format("Pos: %d, limit: %d, len: %d", new Object[] { Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(1) }), localIndexOutOfBoundsException);
      }
    }
    
    public final void n(int paramInt, long paramLong)
    {
      bI(paramInt, 0);
      aA(paramLong);
    }
    
    public final void o(int paramInt, long paramLong)
    {
      bI(paramInt, 1);
      aC(paramLong);
    }
    
    public final void o(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      write(paramArrayOfByte, paramInt1, paramInt2);
    }
    
    public final void r(byte[] paramArrayOfByte, int paramInt)
    {
      gE(paramInt);
      write(paramArrayOfByte, 0, paramInt);
    }
    
    public final void t(int paramInt, boolean paramBoolean)
    {
      int i = 0;
      bI(paramInt, 0);
      paramInt = i;
      if (paramBoolean) {
        paramInt = 1;
      }
      d((byte)paramInt);
    }
  }
  
  public static final class b
    extends IOException
  {
    b()
    {
      super();
    }
    
    b(String paramString, Throwable paramThrowable)
    {
      super(paramThrowable);
    }
    
    b(Throwable paramThrowable)
    {
      super(paramThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.b.i
 * JD-Core Version:    0.7.0.1
 */