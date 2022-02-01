package com.google.d;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class k
  extends g
{
  private static final boolean dJm = ds.ajO();
  private static final Logger logger = Logger.getLogger(k.class.getName());
  l dJn;
  boolean dJo;
  
  public static k C(byte[] paramArrayOfByte)
  {
    return new b(paramArrayOfByte, paramArrayOfByte.length);
  }
  
  public static int D(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte.length;
    return i + kq(i);
  }
  
  public static int a(int paramInt, bn parambn)
  {
    paramInt = ko(paramInt);
    int i = parambn.getSerializedSize();
    return paramInt + (i + kq(i));
  }
  
  public static int a(bn parambn)
  {
    int i = parambn.getSerializedSize();
    return i + kq(i);
  }
  
  static int a(ce paramce, dc paramdc)
  {
    int i = ((b)paramce).getSerializedSize(paramdc);
    return i + kq(i);
  }
  
  public static int aaF()
  {
    return 4;
  }
  
  public static int aaG()
  {
    return 4;
  }
  
  public static int aaH()
  {
    return 8;
  }
  
  public static int aaI()
  {
    return 8;
  }
  
  public static int aaJ()
  {
    return 4;
  }
  
  public static int aaK()
  {
    return 8;
  }
  
  public static int aaL()
  {
    return 1;
  }
  
  public static int b(int paramInt, bn parambn)
  {
    return ko(1) * 2 + cK(2, paramInt) + a(3, parambn);
  }
  
  static int b(int paramInt, ce paramce, dc paramdc)
  {
    return ko(paramInt) + a(paramce, paramdc);
  }
  
  public static int b(ce paramce)
  {
    int i = paramce.getSerializedSize();
    return i + kq(i);
  }
  
  public static int b(h paramh)
  {
    int i = paramh.size();
    return i + kq(i);
  }
  
  public static int c(int paramInt, ce paramce)
  {
    return ko(paramInt) + b(paramce);
  }
  
  @Deprecated
  static int c(int paramInt, ce paramce, dc paramdc)
  {
    return ko(paramInt) * 2 + ((b)paramce).getSerializedSize(paramdc);
  }
  
  public static int c(int paramInt, h paramh)
  {
    paramInt = ko(paramInt);
    int i = paramh.size();
    return paramInt + (i + kq(i));
  }
  
  @Deprecated
  public static int c(ce paramce)
  {
    return paramce.getSerializedSize();
  }
  
  public static k c(OutputStream paramOutputStream, int paramInt)
  {
    return new d(paramOutputStream, paramInt);
  }
  
  public static int cJ(int paramInt1, int paramInt2)
  {
    return ko(paramInt1) + kp(paramInt2);
  }
  
  public static int cK(int paramInt1, int paramInt2)
  {
    return ko(paramInt1) + kq(paramInt2);
  }
  
  public static int cL(int paramInt1, int paramInt2)
  {
    return ko(paramInt1) + kq(ku(paramInt2));
  }
  
  public static int cM(int paramInt1, int paramInt2)
  {
    return ko(paramInt1) + kp(paramInt2);
  }
  
  public static int cS(long paramLong)
  {
    return cT(paramLong);
  }
  
  public static int cT(long paramLong)
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
  
  public static int cU(long paramLong)
  {
    return cT(cV(paramLong));
  }
  
  private static long cV(long paramLong)
  {
    return paramLong << 1 ^ paramLong >> 63;
  }
  
  public static int d(int paramInt, ce paramce)
  {
    return ko(1) * 2 + cK(2, paramInt) + c(3, paramce);
  }
  
  public static int d(int paramInt, h paramh)
  {
    return ko(1) * 2 + cK(2, paramInt) + c(3, paramh);
  }
  
  public static int dU(String paramString)
  {
    try
    {
      i = dt.H(paramString);
      return i + kq(i);
    }
    catch (dt.d locald)
    {
      for (;;)
      {
        int i = paramString.getBytes(bj.UTF_8).length;
      }
    }
  }
  
  @Deprecated
  public static int f(int paramInt, ce paramce)
  {
    return ko(paramInt) * 2 + paramce.getSerializedSize();
  }
  
  public static int h(int paramInt, String paramString)
  {
    return ko(paramInt) + dU(paramString);
  }
  
  static int kc(int paramInt)
  {
    int i = paramInt;
    if (paramInt > 4096) {
      i = 4096;
    }
    return i;
  }
  
  public static int kh(int paramInt)
  {
    return ko(paramInt) + 4;
  }
  
  public static int ki(int paramInt)
  {
    return ko(paramInt) + 4;
  }
  
  public static int kj(int paramInt)
  {
    return ko(paramInt) + 8;
  }
  
  public static int kk(int paramInt)
  {
    return ko(paramInt) + 8;
  }
  
  public static int kl(int paramInt)
  {
    return ko(paramInt) + 4;
  }
  
  public static int km(int paramInt)
  {
    return ko(paramInt) + 8;
  }
  
  public static int kn(int paramInt)
  {
    return ko(paramInt) + 1;
  }
  
  public static int ko(int paramInt)
  {
    return kq(du.cU(paramInt, 0));
  }
  
  public static int kp(int paramInt)
  {
    if (paramInt >= 0) {
      return kq(paramInt);
    }
    return 10;
  }
  
  public static int kq(int paramInt)
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
  
  public static int kr(int paramInt)
  {
    return kq(ku(paramInt));
  }
  
  public static int ks(int paramInt)
  {
    return kp(paramInt);
  }
  
  static int kt(int paramInt)
  {
    return kq(paramInt) + paramInt;
  }
  
  private static int ku(int paramInt)
  {
    return paramInt << 1 ^ paramInt >> 31;
  }
  
  @Deprecated
  public static int kv(int paramInt)
  {
    return kq(paramInt);
  }
  
  public static int q(int paramInt, long paramLong)
  {
    return ko(paramInt) + cT(paramLong);
  }
  
  public static int r(int paramInt, long paramLong)
  {
    return ko(paramInt) + cT(paramLong);
  }
  
  public static int s(int paramInt, long paramLong)
  {
    return ko(paramInt) + cT(cV(paramLong));
  }
  
  public abstract void I(int paramInt, boolean paramBoolean);
  
  public abstract void a(int paramInt, ce paramce);
  
  abstract void a(int paramInt, ce paramce, dc paramdc);
  
  public abstract void a(int paramInt, h paramh);
  
  public abstract void a(ce paramce);
  
  public abstract void a(h paramh);
  
  final void a(String paramString, dt.d paramd)
  {
    logger.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", paramd);
    paramString = paramString.getBytes(bj.UTF_8);
    try
    {
      ke(paramString.length);
      n(paramString, 0, paramString.length);
      return;
    }
    catch (IndexOutOfBoundsException paramString)
    {
      throw new c(paramString);
    }
    catch (c paramString)
    {
      throw paramString;
    }
  }
  
  public abstract int aaM();
  
  public final void aaN()
  {
    if (aaM() != 0) {
      throw new IllegalStateException("Did not write as much data as expected.");
    }
  }
  
  public abstract void b(int paramInt, ce paramce);
  
  public abstract void b(int paramInt, h paramh);
  
  public final void bZ(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      e((byte)i);
      return;
    }
  }
  
  public final void bd(float paramFloat)
  {
    kg(Float.floatToRawIntBits(paramFloat));
  }
  
  public abstract void cE(int paramInt1, int paramInt2);
  
  public abstract void cF(int paramInt1, int paramInt2);
  
  public abstract void cG(int paramInt1, int paramInt2);
  
  public final void cH(int paramInt1, int paramInt2)
  {
    cG(paramInt1, ku(paramInt2));
  }
  
  public abstract void cI(int paramInt1, int paramInt2);
  
  public abstract void cP(long paramLong);
  
  public final void cQ(long paramLong)
  {
    cP(cV(paramLong));
  }
  
  public abstract void cR(long paramLong);
  
  public final void d(int paramInt, double paramDouble)
  {
    p(paramInt, Double.doubleToRawLongBits(paramDouble));
  }
  
  public abstract void dT(String paramString);
  
  public abstract void e(byte paramByte);
  
  @Deprecated
  public final void e(int paramInt, ce paramce)
  {
    cE(paramInt, 3);
    paramce.writeTo(this);
    cE(paramInt, 4);
  }
  
  public abstract void flush();
  
  public abstract void g(int paramInt, String paramString);
  
  public abstract void kd(int paramInt);
  
  public abstract void ke(int paramInt);
  
  public final void kf(int paramInt)
  {
    ke(ku(paramInt));
  }
  
  public abstract void kg(int paramInt);
  
  public final void l(int paramInt, float paramFloat)
  {
    cI(paramInt, Float.floatToRawIntBits(paramFloat));
  }
  
  public abstract void n(int paramInt, long paramLong);
  
  public abstract void n(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public final void o(int paramInt, long paramLong)
  {
    n(paramInt, cV(paramLong));
  }
  
  public abstract void p(int paramInt, long paramLong);
  
  abstract void q(byte[] paramArrayOfByte, int paramInt);
  
  public final void u(double paramDouble)
  {
    cR(Double.doubleToRawLongBits(paramDouble));
  }
  
  static abstract class a
    extends k
  {
    final byte[] buffer;
    int dJp;
    final int limit;
    int position;
    
    a(int paramInt)
    {
      super();
      if (paramInt < 0) {
        throw new IllegalArgumentException("bufferSize must be >= 0");
      }
      this.buffer = new byte[Math.max(paramInt, 20)];
      this.limit = this.buffer.length;
    }
    
    public final int aaM()
    {
      throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array or ByteBuffer.");
    }
    
    final void cN(int paramInt1, int paramInt2)
    {
      kw(du.cU(paramInt1, paramInt2));
    }
    
    final void cW(long paramLong)
    {
      long l = paramLong;
      if (k.dJm)
      {
        l = this.position;
        for (;;)
        {
          if ((paramLong & 0xFFFFFF80) == 0L)
          {
            arrayOfByte = this.buffer;
            i = this.position;
            this.position = (i + 1);
            ds.a(arrayOfByte, i, (byte)(int)paramLong);
            this.dJp = ((int)(this.position - l) + this.dJp);
            return;
          }
          arrayOfByte = this.buffer;
          i = this.position;
          this.position = (i + 1);
          ds.a(arrayOfByte, i, (byte)((int)paramLong & 0x7F | 0x80));
          paramLong >>>= 7;
        }
      }
      while ((l & 0xFFFFFF80) != 0L)
      {
        arrayOfByte = this.buffer;
        i = this.position;
        this.position = (i + 1);
        arrayOfByte[i] = ((byte)((int)l & 0x7F | 0x80));
        this.dJp += 1;
        l >>>= 7;
      }
      byte[] arrayOfByte = this.buffer;
      int i = this.position;
      this.position = (i + 1);
      arrayOfByte[i] = ((byte)(int)l);
      this.dJp += 1;
    }
    
    final void cX(long paramLong)
    {
      byte[] arrayOfByte = this.buffer;
      int i = this.position;
      this.position = (i + 1);
      arrayOfByte[i] = ((byte)(int)(paramLong & 0xFF));
      arrayOfByte = this.buffer;
      i = this.position;
      this.position = (i + 1);
      arrayOfByte[i] = ((byte)(int)(paramLong >> 8 & 0xFF));
      arrayOfByte = this.buffer;
      i = this.position;
      this.position = (i + 1);
      arrayOfByte[i] = ((byte)(int)(paramLong >> 16 & 0xFF));
      arrayOfByte = this.buffer;
      i = this.position;
      this.position = (i + 1);
      arrayOfByte[i] = ((byte)(int)(paramLong >> 24 & 0xFF));
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
      this.dJp += 8;
    }
    
    final void f(byte paramByte)
    {
      byte[] arrayOfByte = this.buffer;
      int i = this.position;
      this.position = (i + 1);
      arrayOfByte[i] = paramByte;
      this.dJp += 1;
    }
    
    final void kw(int paramInt)
    {
      int i = paramInt;
      if (k.dJm)
      {
        l = this.position;
        for (;;)
        {
          if ((paramInt & 0xFFFFFF80) == 0)
          {
            arrayOfByte = this.buffer;
            i = this.position;
            this.position = (i + 1);
            ds.a(arrayOfByte, i, (byte)paramInt);
            this.dJp = ((int)(this.position - l) + this.dJp);
            return;
          }
          arrayOfByte = this.buffer;
          i = this.position;
          this.position = (i + 1);
          ds.a(arrayOfByte, i, (byte)(paramInt & 0x7F | 0x80));
          paramInt >>>= 7;
        }
      }
      while ((i & 0xFFFFFF80) != 0)
      {
        long l;
        arrayOfByte = this.buffer;
        paramInt = this.position;
        this.position = (paramInt + 1);
        arrayOfByte[paramInt] = ((byte)(i & 0x7F | 0x80));
        this.dJp += 1;
        i >>>= 7;
      }
      byte[] arrayOfByte = this.buffer;
      paramInt = this.position;
      this.position = (paramInt + 1);
      arrayOfByte[paramInt] = ((byte)i);
      this.dJp += 1;
    }
    
    final void kx(int paramInt)
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
      this.dJp += 4;
    }
  }
  
  static final class b
    extends k
  {
    private final byte[] buffer;
    private final int limit;
    private final int offset;
    private int position;
    
    b(byte[] paramArrayOfByte, int paramInt)
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
        throw new k.c(String.format("Pos: %d, limit: %d, len: %d", new Object[] { Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(paramInt2) }), paramArrayOfByte);
      }
    }
    
    public final void I(int paramInt, boolean paramBoolean)
    {
      int i = 0;
      cE(paramInt, 0);
      paramInt = i;
      if (paramBoolean) {
        paramInt = 1;
      }
      e((byte)paramInt);
    }
    
    public final void a(int paramInt, ce paramce)
    {
      cE(paramInt, 2);
      a(paramce);
    }
    
    final void a(int paramInt, ce paramce, dc paramdc)
    {
      cE(paramInt, 2);
      ke(((b)paramce).getSerializedSize(paramdc));
      paramdc.a(paramce, this.dJn);
    }
    
    public final void a(int paramInt, h paramh)
    {
      cE(paramInt, 2);
      a(paramh);
    }
    
    public final void a(ce paramce)
    {
      ke(paramce.getSerializedSize());
      paramce.writeTo(this);
    }
    
    public final void a(h paramh)
    {
      ke(paramh.size());
      paramh.a(this);
    }
    
    public final int aaM()
    {
      return this.limit - this.position;
    }
    
    public final void b(int paramInt, ce paramce)
    {
      cE(1, 3);
      cG(2, paramInt);
      a(3, paramce);
      cE(1, 4);
    }
    
    public final void b(int paramInt, h paramh)
    {
      cE(1, 3);
      cG(2, paramInt);
      a(3, paramh);
      cE(1, 4);
    }
    
    public final void cE(int paramInt1, int paramInt2)
    {
      ke(du.cU(paramInt1, paramInt2));
    }
    
    public final void cF(int paramInt1, int paramInt2)
    {
      cE(paramInt1, 0);
      kd(paramInt2);
    }
    
    public final void cG(int paramInt1, int paramInt2)
    {
      cE(paramInt1, 0);
      ke(paramInt2);
    }
    
    public final void cI(int paramInt1, int paramInt2)
    {
      cE(paramInt1, 5);
      kg(paramInt2);
    }
    
    public final void cP(long paramLong)
    {
      long l = paramLong;
      byte[] arrayOfByte;
      int i;
      if (k.dJm)
      {
        l = paramLong;
        if (aaM() >= 10) {
          for (;;)
          {
            if ((paramLong & 0xFFFFFF80) == 0L)
            {
              arrayOfByte = this.buffer;
              i = this.position;
              this.position = (i + 1);
              ds.a(arrayOfByte, i, (byte)(int)paramLong);
              return;
            }
            arrayOfByte = this.buffer;
            i = this.position;
            this.position = (i + 1);
            ds.a(arrayOfByte, i, (byte)((int)paramLong & 0x7F | 0x80));
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
        throw new k.c(String.format("Pos: %d, limit: %d, len: %d", new Object[] { Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(1) }), localIndexOutOfBoundsException);
      }
    }
    
    public final void cR(long paramLong)
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
        throw new k.c(String.format("Pos: %d, limit: %d, len: %d", new Object[] { Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(1) }), localIndexOutOfBoundsException);
      }
    }
    
    public final void dT(String paramString)
    {
      int i = this.position;
      try
      {
        int k = kq(paramString.length() * 3);
        int j = kq(paramString.length());
        if (j == k)
        {
          this.position = (i + j);
          k = dt.a(paramString, this.buffer, this.position, aaM());
          this.position = i;
          ke(k - i - j);
          this.position = k;
          return;
        }
        ke(dt.H(paramString));
        this.position = dt.a(paramString, this.buffer, this.position, aaM());
        return;
      }
      catch (dt.d locald)
      {
        this.position = i;
        a(paramString, locald);
        return;
      }
      catch (IndexOutOfBoundsException paramString)
      {
        throw new k.c(paramString);
      }
    }
    
    public final void e(byte paramByte)
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
        throw new k.c(String.format("Pos: %d, limit: %d, len: %d", new Object[] { Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(1) }), localIndexOutOfBoundsException);
      }
    }
    
    public final void flush() {}
    
    public final void g(int paramInt, String paramString)
    {
      cE(paramInt, 2);
      dT(paramString);
    }
    
    public final void g(ByteBuffer paramByteBuffer)
    {
      int i = paramByteBuffer.remaining();
      try
      {
        paramByteBuffer.get(this.buffer, this.position, i);
        this.position += i;
        return;
      }
      catch (IndexOutOfBoundsException paramByteBuffer)
      {
        throw new k.c(String.format("Pos: %d, limit: %d, len: %d", new Object[] { Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(i) }), paramByteBuffer);
      }
    }
    
    public final void kd(int paramInt)
    {
      if (paramInt >= 0)
      {
        ke(paramInt);
        return;
      }
      cP(paramInt);
    }
    
    public final void ke(int paramInt)
    {
      int i = paramInt;
      byte[] arrayOfByte;
      if (k.dJm)
      {
        i = paramInt;
        if (!e.ZR())
        {
          i = paramInt;
          if (aaM() >= 5)
          {
            if ((paramInt & 0xFFFFFF80) == 0)
            {
              arrayOfByte = this.buffer;
              i = this.position;
              this.position = (i + 1);
              ds.a(arrayOfByte, i, (byte)paramInt);
              return;
            }
            arrayOfByte = this.buffer;
            i = this.position;
            this.position = (i + 1);
            ds.a(arrayOfByte, i, (byte)(paramInt | 0x80));
            paramInt >>>= 7;
            if ((paramInt & 0xFFFFFF80) == 0)
            {
              arrayOfByte = this.buffer;
              i = this.position;
              this.position = (i + 1);
              ds.a(arrayOfByte, i, (byte)paramInt);
              return;
            }
            arrayOfByte = this.buffer;
            i = this.position;
            this.position = (i + 1);
            ds.a(arrayOfByte, i, (byte)(paramInt | 0x80));
            paramInt >>>= 7;
            if ((paramInt & 0xFFFFFF80) == 0)
            {
              arrayOfByte = this.buffer;
              i = this.position;
              this.position = (i + 1);
              ds.a(arrayOfByte, i, (byte)paramInt);
              return;
            }
            arrayOfByte = this.buffer;
            i = this.position;
            this.position = (i + 1);
            ds.a(arrayOfByte, i, (byte)(paramInt | 0x80));
            paramInt >>>= 7;
            if ((paramInt & 0xFFFFFF80) == 0)
            {
              arrayOfByte = this.buffer;
              i = this.position;
              this.position = (i + 1);
              ds.a(arrayOfByte, i, (byte)paramInt);
              return;
            }
            arrayOfByte = this.buffer;
            i = this.position;
            this.position = (i + 1);
            ds.a(arrayOfByte, i, (byte)(paramInt | 0x80));
            arrayOfByte = this.buffer;
            i = this.position;
            this.position = (i + 1);
            ds.a(arrayOfByte, i, (byte)(paramInt >>> 7));
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
        throw new k.c(String.format("Pos: %d, limit: %d, len: %d", new Object[] { Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(1) }), localIndexOutOfBoundsException);
      }
    }
    
    public final void kg(int paramInt)
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
        throw new k.c(String.format("Pos: %d, limit: %d, len: %d", new Object[] { Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(1) }), localIndexOutOfBoundsException);
      }
    }
    
    public final void n(int paramInt, long paramLong)
    {
      cE(paramInt, 0);
      cP(paramLong);
    }
    
    public final void n(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      write(paramArrayOfByte, paramInt1, paramInt2);
    }
    
    public final void p(int paramInt, long paramLong)
    {
      cE(paramInt, 1);
      cR(paramLong);
    }
    
    public final void q(byte[] paramArrayOfByte, int paramInt)
    {
      ke(paramInt);
      write(paramArrayOfByte, 0, paramInt);
    }
  }
  
  public static final class c
    extends IOException
  {
    c()
    {
      super();
    }
    
    c(String paramString, Throwable paramThrowable)
    {
      super(paramThrowable);
    }
    
    c(Throwable paramThrowable)
    {
      super(paramThrowable);
    }
  }
  
  static final class d
    extends k.a
  {
    private final OutputStream out;
    
    d(OutputStream paramOutputStream, int paramInt)
    {
      super();
      if (paramOutputStream == null) {
        throw new NullPointerException("out");
      }
      this.out = paramOutputStream;
    }
    
    private void aaO()
    {
      this.out.write(this.buffer, 0, this.position);
      this.position = 0;
    }
    
    private void ky(int paramInt)
    {
      if (this.limit - this.position < paramInt) {
        aaO();
      }
    }
    
    private void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      if (this.limit - this.position >= paramInt2)
      {
        System.arraycopy(paramArrayOfByte, paramInt1, this.buffer, this.position, paramInt2);
        this.position += paramInt2;
      }
      for (;;)
      {
        this.dJp += paramInt2;
        return;
        int i = this.limit - this.position;
        System.arraycopy(paramArrayOfByte, paramInt1, this.buffer, this.position, i);
        paramInt1 += i;
        paramInt2 -= i;
        this.position = this.limit;
        this.dJp = (i + this.dJp);
        aaO();
        if (paramInt2 <= this.limit)
        {
          System.arraycopy(paramArrayOfByte, paramInt1, this.buffer, 0, paramInt2);
          this.position = paramInt2;
        }
        else
        {
          this.out.write(paramArrayOfByte, paramInt1, paramInt2);
        }
      }
    }
    
    public final void I(int paramInt, boolean paramBoolean)
    {
      int i = 0;
      ky(11);
      cN(paramInt, 0);
      paramInt = i;
      if (paramBoolean) {
        paramInt = 1;
      }
      f((byte)paramInt);
    }
    
    public final void a(int paramInt, ce paramce)
    {
      cE(paramInt, 2);
      a(paramce);
    }
    
    final void a(int paramInt, ce paramce, dc paramdc)
    {
      cE(paramInt, 2);
      ke(((b)paramce).getSerializedSize(paramdc));
      paramdc.a(paramce, this.dJn);
    }
    
    public final void a(int paramInt, h paramh)
    {
      cE(paramInt, 2);
      a(paramh);
    }
    
    public final void a(ce paramce)
    {
      ke(paramce.getSerializedSize());
      paramce.writeTo(this);
    }
    
    public final void a(h paramh)
    {
      ke(paramh.size());
      paramh.a(this);
    }
    
    public final void b(int paramInt, ce paramce)
    {
      cE(1, 3);
      cG(2, paramInt);
      a(3, paramce);
      cE(1, 4);
    }
    
    public final void b(int paramInt, h paramh)
    {
      cE(1, 3);
      cG(2, paramInt);
      a(3, paramh);
      cE(1, 4);
    }
    
    public final void cE(int paramInt1, int paramInt2)
    {
      ke(du.cU(paramInt1, paramInt2));
    }
    
    public final void cF(int paramInt1, int paramInt2)
    {
      ky(20);
      cN(paramInt1, 0);
      if (paramInt2 >= 0)
      {
        kw(paramInt2);
        return;
      }
      cW(paramInt2);
    }
    
    public final void cG(int paramInt1, int paramInt2)
    {
      ky(20);
      cN(paramInt1, 0);
      kw(paramInt2);
    }
    
    public final void cI(int paramInt1, int paramInt2)
    {
      ky(14);
      cN(paramInt1, 5);
      kx(paramInt2);
    }
    
    public final void cP(long paramLong)
    {
      ky(10);
      cW(paramLong);
    }
    
    public final void cR(long paramLong)
    {
      ky(8);
      cX(paramLong);
    }
    
    /* Error */
    public final void dT(String paramString)
    {
      // Byte code:
      //   0: aload_1
      //   1: invokevirtual 156	java/lang/String:length	()I
      //   4: iconst_3
      //   5: imul
      //   6: istore_3
      //   7: iload_3
      //   8: invokestatic 160	com/google/d/k$d:kq	(I)I
      //   11: istore_2
      //   12: iload_2
      //   13: iload_3
      //   14: iadd
      //   15: aload_0
      //   16: getfield 43	com/google/d/k$d:limit	I
      //   19: if_icmple +31 -> 50
      //   22: iload_3
      //   23: newarray byte
      //   25: astore 6
      //   27: aload_1
      //   28: aload 6
      //   30: iconst_0
      //   31: iload_3
      //   32: invokestatic 165	com/google/d/dt:a	(Ljava/lang/CharSequence;[BII)I
      //   35: istore_2
      //   36: aload_0
      //   37: iload_2
      //   38: invokevirtual 83	com/google/d/k$d:ke	(I)V
      //   41: aload_0
      //   42: aload 6
      //   44: iconst_0
      //   45: iload_2
      //   46: invokespecial 166	com/google/d/k$d:write	([BII)V
      //   49: return
      //   50: iload_3
      //   51: iload_2
      //   52: iadd
      //   53: aload_0
      //   54: getfield 43	com/google/d/k$d:limit	I
      //   57: aload_0
      //   58: getfield 33	com/google/d/k$d:position	I
      //   61: isub
      //   62: if_icmple +7 -> 69
      //   65: aload_0
      //   66: invokespecial 45	com/google/d/k$d:aaO	()V
      //   69: aload_1
      //   70: invokevirtual 156	java/lang/String:length	()I
      //   73: invokestatic 160	com/google/d/k$d:kq	(I)I
      //   76: istore 4
      //   78: aload_0
      //   79: getfield 33	com/google/d/k$d:position	I
      //   82: istore_3
      //   83: iload 4
      //   85: iload_2
      //   86: if_icmpne +104 -> 190
      //   89: aload_0
      //   90: iload_3
      //   91: iload 4
      //   93: iadd
      //   94: putfield 33	com/google/d/k$d:position	I
      //   97: aload_1
      //   98: aload_0
      //   99: getfield 29	com/google/d/k$d:buffer	[B
      //   102: aload_0
      //   103: getfield 33	com/google/d/k$d:position	I
      //   106: aload_0
      //   107: getfield 43	com/google/d/k$d:limit	I
      //   110: aload_0
      //   111: getfield 33	com/google/d/k$d:position	I
      //   114: isub
      //   115: invokestatic 165	com/google/d/dt:a	(Ljava/lang/CharSequence;[BII)I
      //   118: istore 5
      //   120: aload_0
      //   121: iload_3
      //   122: putfield 33	com/google/d/k$d:position	I
      //   125: iload 5
      //   127: iload_3
      //   128: isub
      //   129: iload 4
      //   131: isub
      //   132: istore_2
      //   133: aload_0
      //   134: iload_2
      //   135: invokevirtual 136	com/google/d/k$d:kw	(I)V
      //   138: aload_0
      //   139: iload 5
      //   141: putfield 33	com/google/d/k$d:position	I
      //   144: aload_0
      //   145: iload_2
      //   146: aload_0
      //   147: getfield 54	com/google/d/k$d:dJp	I
      //   150: iadd
      //   151: putfield 54	com/google/d/k$d:dJp	I
      //   154: return
      //   155: astore 6
      //   157: aload_0
      //   158: aload_0
      //   159: getfield 54	com/google/d/k$d:dJp	I
      //   162: aload_0
      //   163: getfield 33	com/google/d/k$d:position	I
      //   166: iload_3
      //   167: isub
      //   168: isub
      //   169: putfield 54	com/google/d/k$d:dJp	I
      //   172: aload_0
      //   173: iload_3
      //   174: putfield 33	com/google/d/k$d:position	I
      //   177: aload 6
      //   179: athrow
      //   180: astore 6
      //   182: aload_0
      //   183: aload_1
      //   184: aload 6
      //   186: invokevirtual 169	com/google/d/k$d:a	(Ljava/lang/String;Lcom/google/d/dt$d;)V
      //   189: return
      //   190: aload_1
      //   191: invokestatic 173	com/google/d/dt:H	(Ljava/lang/CharSequence;)I
      //   194: istore_2
      //   195: aload_0
      //   196: iload_2
      //   197: invokevirtual 136	com/google/d/k$d:kw	(I)V
      //   200: aload_0
      //   201: aload_1
      //   202: aload_0
      //   203: getfield 29	com/google/d/k$d:buffer	[B
      //   206: aload_0
      //   207: getfield 33	com/google/d/k$d:position	I
      //   210: iload_2
      //   211: invokestatic 165	com/google/d/dt:a	(Ljava/lang/CharSequence;[BII)I
      //   214: putfield 33	com/google/d/k$d:position	I
      //   217: goto -73 -> 144
      //   220: astore 6
      //   222: new 175	com/google/d/k$c
      //   225: dup
      //   226: aload 6
      //   228: invokespecial 178	com/google/d/k$c:<init>	(Ljava/lang/Throwable;)V
      //   231: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	232	0	this	d
      //   0	232	1	paramString	String
      //   11	200	2	i	int
      //   6	168	3	j	int
      //   76	56	4	k	int
      //   118	22	5	m	int
      //   25	18	6	arrayOfByte	byte[]
      //   155	23	6	locald1	dt.d
      //   180	5	6	locald2	dt.d
      //   220	7	6	localArrayIndexOutOfBoundsException	java.lang.ArrayIndexOutOfBoundsException
      // Exception table:
      //   from	to	target	type
      //   89	125	155	com/google/d/dt$d
      //   133	144	155	com/google/d/dt$d
      //   144	154	155	com/google/d/dt$d
      //   190	217	155	com/google/d/dt$d
      //   0	49	180	com/google/d/dt$d
      //   50	69	180	com/google/d/dt$d
      //   69	83	180	com/google/d/dt$d
      //   157	180	180	com/google/d/dt$d
      //   222	232	180	com/google/d/dt$d
      //   89	125	220	java/lang/ArrayIndexOutOfBoundsException
      //   133	144	220	java/lang/ArrayIndexOutOfBoundsException
      //   144	154	220	java/lang/ArrayIndexOutOfBoundsException
      //   190	217	220	java/lang/ArrayIndexOutOfBoundsException
    }
    
    public final void e(byte paramByte)
    {
      if (this.position == this.limit) {
        aaO();
      }
      f(paramByte);
    }
    
    public final void flush()
    {
      if (this.position > 0) {
        aaO();
      }
    }
    
    public final void g(int paramInt, String paramString)
    {
      cE(paramInt, 2);
      dT(paramString);
    }
    
    public final void g(ByteBuffer paramByteBuffer)
    {
      int i = paramByteBuffer.remaining();
      if (this.limit - this.position >= i)
      {
        paramByteBuffer.get(this.buffer, this.position, i);
        this.position += i;
        this.dJp = (i + this.dJp);
        return;
      }
      int j = this.limit - this.position;
      paramByteBuffer.get(this.buffer, this.position, j);
      i -= j;
      this.position = this.limit;
      this.dJp = (j + this.dJp);
      aaO();
      while (i > this.limit)
      {
        paramByteBuffer.get(this.buffer, 0, this.limit);
        this.out.write(this.buffer, 0, this.limit);
        i -= this.limit;
        this.dJp += this.limit;
      }
      paramByteBuffer.get(this.buffer, 0, i);
      this.position = i;
      this.dJp = (i + this.dJp);
    }
    
    public final void kd(int paramInt)
    {
      if (paramInt >= 0)
      {
        ke(paramInt);
        return;
      }
      cP(paramInt);
    }
    
    public final void ke(int paramInt)
    {
      ky(5);
      kw(paramInt);
    }
    
    public final void kg(int paramInt)
    {
      ky(4);
      kx(paramInt);
    }
    
    public final void n(int paramInt, long paramLong)
    {
      ky(20);
      cN(paramInt, 0);
      cW(paramLong);
    }
    
    public final void n(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      write(paramArrayOfByte, paramInt1, paramInt2);
    }
    
    public final void p(int paramInt, long paramLong)
    {
      ky(18);
      cN(paramInt, 1);
      cX(paramLong);
    }
    
    public final void q(byte[] paramArrayOfByte, int paramInt)
    {
      ke(paramInt);
      write(paramArrayOfByte, 0, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.google.d.k
 * JD-Core Version:    0.7.0.1
 */