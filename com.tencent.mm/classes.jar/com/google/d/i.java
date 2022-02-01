package com.google.d;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public abstract class i
{
  int dIR;
  int dIS = 100;
  int dIT = 2147483647;
  j dIU;
  boolean dIV = false;
  
  public static i B(byte[] paramArrayOfByte)
  {
    return c(paramArrayOfByte, 0, paramArrayOfByte.length, false);
  }
  
  static i a(ByteBuffer paramByteBuffer, boolean paramBoolean)
  {
    if (paramByteBuffer.hasArray()) {
      return c(paramByteBuffer.array(), paramByteBuffer.arrayOffset() + paramByteBuffer.position(), paramByteBuffer.remaining(), paramBoolean);
    }
    if ((paramByteBuffer.isDirect()) && (ds.ajP())) {
      return new c(paramByteBuffer, paramBoolean, (byte)0);
    }
    byte[] arrayOfByte = new byte[paramByteBuffer.remaining()];
    paramByteBuffer.duplicate().get(arrayOfByte);
    return c(arrayOfByte, 0, arrayOfByte.length, true);
  }
  
  public static int b(int paramInt, InputStream paramInputStream)
  {
    int j;
    if ((paramInt & 0x80) == 0)
    {
      j = paramInt;
      return j;
    }
    int i = paramInt & 0x7F;
    paramInt = 7;
    for (;;)
    {
      j = paramInt;
      if (paramInt >= 32) {
        break label78;
      }
      int k = paramInputStream.read();
      if (k == -1) {
        throw bk.aij();
      }
      i |= (k & 0x7F) << paramInt;
      j = i;
      if ((k & 0x80) == 0) {
        break;
      }
      paramInt += 7;
    }
    label78:
    do
    {
      j += 7;
      if (j >= 64) {
        break;
      }
      paramInt = paramInputStream.read();
      if (paramInt == -1) {
        throw bk.aij();
      }
    } while ((paramInt & 0x80) != 0);
    return i;
    throw bk.ail();
  }
  
  static i c(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    paramArrayOfByte = new a(paramArrayOfByte, paramInt1, paramInt2, paramBoolean, (byte)0);
    try
    {
      paramArrayOfByte.jO(paramInt2);
      return paramArrayOfByte;
    }
    catch (bk paramArrayOfByte)
    {
      throw new IllegalArgumentException(paramArrayOfByte);
    }
  }
  
  public static long cO(long paramLong)
  {
    return paramLong >>> 1 ^ -(1L & paramLong);
  }
  
  public static i i(ByteBuffer paramByteBuffer)
  {
    return a(paramByteBuffer, false);
  }
  
  public static int jQ(int paramInt)
  {
    return paramInt >>> 1 ^ -(paramInt & 0x1);
  }
  
  public static i r(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return c(paramArrayOfByte, paramInt1, paramInt2, false);
  }
  
  public static i u(InputStream paramInputStream)
  {
    if (paramInputStream == null)
    {
      paramInputStream = bj.EMPTY_BYTE_ARRAY;
      return c(paramInputStream, 0, paramInputStream.length, false);
    }
    return new b(paramInputStream);
  }
  
  public abstract <T extends ce> T a(cs<T> paramcs, at paramat);
  
  public abstract void a(int paramInt, ce.a parama, at paramat);
  
  public abstract void a(ce.a parama, at paramat);
  
  public abstract int aac();
  
  public abstract long aad();
  
  public abstract long aae();
  
  public abstract int aaf();
  
  public abstract long aag();
  
  public abstract int aah();
  
  public abstract boolean aai();
  
  public abstract String aaj();
  
  public abstract h aak();
  
  public abstract int aal();
  
  public abstract int aam();
  
  public abstract int aan();
  
  public abstract long aao();
  
  public abstract int aap();
  
  public abstract long aaq();
  
  public abstract int aar();
  
  abstract long aas();
  
  public abstract int aat();
  
  public abstract boolean aau();
  
  public abstract int aav();
  
  public abstract void jM(int paramInt);
  
  public abstract boolean jN(int paramInt);
  
  public abstract int jO(int paramInt);
  
  public abstract void jP(int paramInt);
  
  public abstract double readDouble();
  
  public abstract float readFloat();
  
  public abstract String readString();
  
  static final class a
    extends i
  {
    private final byte[] buffer;
    private final boolean dIW;
    private int dIX;
    private int dIY;
    private int dIZ;
    private boolean dJa;
    private int dJb = 2147483647;
    private int limit;
    private int pos;
    
    private a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
    {
      super();
      this.buffer = paramArrayOfByte;
      this.limit = (paramInt1 + paramInt2);
      this.pos = paramInt1;
      this.dIY = this.pos;
      this.dIW = paramBoolean;
    }
    
    private byte aaA()
    {
      if (this.pos == this.limit) {
        throw bk.aij();
      }
      byte[] arrayOfByte = this.buffer;
      int i = this.pos;
      this.pos = (i + 1);
      return arrayOfByte[i];
    }
    
    private long aaw()
    {
      int i = this.pos;
      byte[] arrayOfByte;
      int j;
      int k;
      long l;
      if (this.limit != i)
      {
        arrayOfByte = this.buffer;
        j = i + 1;
        k = arrayOfByte[i];
        if (k >= 0)
        {
          this.pos = j;
          return k;
        }
        if (this.limit - j >= 9)
        {
          i = j + 1;
          k ^= arrayOfByte[j] << 7;
          if (k < 0) {
            l = k ^ 0xFFFFFF80;
          }
        }
      }
      for (;;)
      {
        this.pos = i;
        return l;
        j = i + 1;
        k ^= arrayOfByte[i] << 14;
        if (k >= 0)
        {
          l = k ^ 0x3F80;
          i = j;
        }
        else
        {
          i = j + 1;
          j = k ^ arrayOfByte[j] << 21;
          if (j < 0)
          {
            l = j ^ 0xFFE03F80;
          }
          else
          {
            l = j;
            j = i + 1;
            l ^= arrayOfByte[i] << 28;
            if (l >= 0L)
            {
              l ^= 0xFE03F80;
              i = j;
            }
            else
            {
              i = j + 1;
              l ^= arrayOfByte[j] << 35;
              if (l < 0L)
              {
                l ^= 0xFE03F80;
              }
              else
              {
                j = i + 1;
                l ^= arrayOfByte[i] << 42;
                if (l >= 0L)
                {
                  l ^= 0xFE03F80;
                  i = j;
                }
                else
                {
                  i = j + 1;
                  l ^= arrayOfByte[j] << 49;
                  if (l < 0L)
                  {
                    l ^= 0xFE03F80;
                  }
                  else
                  {
                    j = i + 1;
                    l = l ^ arrayOfByte[i] << 56 ^ 0xFE03F80;
                    if (l < 0L)
                    {
                      i = j + 1;
                      if (arrayOfByte[j] < 0L) {
                        return aas();
                      }
                    }
                    else
                    {
                      i = j;
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    
    private int aax()
    {
      int i = this.pos;
      if (this.limit - i < 4) {
        throw bk.aij();
      }
      byte[] arrayOfByte = this.buffer;
      this.pos = (i + 4);
      int j = arrayOfByte[i];
      int k = arrayOfByte[(i + 1)];
      int m = arrayOfByte[(i + 2)];
      return (arrayOfByte[(i + 3)] & 0xFF) << 24 | j & 0xFF | (k & 0xFF) << 8 | (m & 0xFF) << 16;
    }
    
    private long aay()
    {
      int i = this.pos;
      if (this.limit - i < 8) {
        throw bk.aij();
      }
      byte[] arrayOfByte = this.buffer;
      this.pos = (i + 8);
      long l1 = arrayOfByte[i];
      long l2 = arrayOfByte[(i + 1)];
      long l3 = arrayOfByte[(i + 2)];
      long l4 = arrayOfByte[(i + 3)];
      long l5 = arrayOfByte[(i + 4)];
      long l6 = arrayOfByte[(i + 5)];
      long l7 = arrayOfByte[(i + 6)];
      return (arrayOfByte[(i + 7)] & 0xFF) << 56 | l1 & 0xFF | (l2 & 0xFF) << 8 | (l3 & 0xFF) << 16 | (l4 & 0xFF) << 24 | (l5 & 0xFF) << 32 | (l6 & 0xFF) << 40 | (l7 & 0xFF) << 48;
    }
    
    private void aaz()
    {
      this.limit += this.dIX;
      int i = this.limit - this.dIY;
      if (i > this.dJb)
      {
        this.dIX = (i - this.dJb);
        this.limit -= this.dIX;
        return;
      }
      this.dIX = 0;
    }
    
    private void jR(int paramInt)
    {
      if ((paramInt >= 0) && (paramInt <= this.limit - this.pos))
      {
        this.pos += paramInt;
        return;
      }
      if (paramInt < 0) {
        throw bk.aik();
      }
      throw bk.aij();
    }
    
    public final <T extends ce> T a(cs<T> paramcs, at paramat)
    {
      int i = aar();
      if (this.dIR >= this.dIS) {
        throw bk.aip();
      }
      i = jO(i);
      this.dIR += 1;
      paramcs = (ce)paramcs.parsePartialFrom(this, paramat);
      jM(0);
      this.dIR -= 1;
      jP(i);
      return paramcs;
    }
    
    public final void a(int paramInt, ce.a parama, at paramat)
    {
      if (this.dIR >= this.dIS) {
        throw bk.aip();
      }
      this.dIR += 1;
      parama.mergeFrom(this, paramat);
      jM(du.cU(paramInt, 4));
      this.dIR -= 1;
    }
    
    public final void a(ce.a parama, at paramat)
    {
      int i = aar();
      if (this.dIR >= this.dIS) {
        throw bk.aip();
      }
      i = jO(i);
      this.dIR += 1;
      parama.mergeFrom(this, paramat);
      jM(0);
      this.dIR -= 1;
      jP(i);
    }
    
    public final int aac()
    {
      if (aau())
      {
        this.dIZ = 0;
        return 0;
      }
      this.dIZ = aar();
      if (du.lE(this.dIZ) == 0) {
        throw bk.aim();
      }
      return this.dIZ;
    }
    
    public final long aad()
    {
      return aaw();
    }
    
    public final long aae()
    {
      return aaw();
    }
    
    public final int aaf()
    {
      return aar();
    }
    
    public final long aag()
    {
      return aay();
    }
    
    public final int aah()
    {
      return aax();
    }
    
    public final boolean aai()
    {
      return aaw() != 0L;
    }
    
    public final String aaj()
    {
      int i = aar();
      if ((i > 0) && (i <= this.limit - this.pos))
      {
        String str = dt.u(this.buffer, this.pos, i);
        this.pos = (i + this.pos);
        return str;
      }
      if (i == 0) {
        return "";
      }
      if (i <= 0) {
        throw bk.aik();
      }
      throw bk.aij();
    }
    
    public final h aak()
    {
      int i = aar();
      if ((i > 0) && (i <= this.limit - this.pos))
      {
        if ((this.dIW) && (this.dJa)) {}
        for (localObject = h.p(this.buffer, this.pos, i);; localObject = h.o(this.buffer, this.pos, i))
        {
          this.pos = (i + this.pos);
          return localObject;
        }
      }
      if (i == 0) {
        return h.dIJ;
      }
      int j;
      if ((i > 0) && (i <= this.limit - this.pos))
      {
        j = this.pos;
        this.pos = (i + this.pos);
      }
      for (Object localObject = Arrays.copyOfRange(this.buffer, j, this.pos);; localObject = bj.EMPTY_BYTE_ARRAY)
      {
        return h.A((byte[])localObject);
        if (i > 0) {
          break label154;
        }
        if (i != 0) {
          break;
        }
      }
      throw bk.aik();
      label154:
      throw bk.aij();
    }
    
    public final int aal()
    {
      return aar();
    }
    
    public final int aam()
    {
      return aar();
    }
    
    public final int aan()
    {
      return aax();
    }
    
    public final long aao()
    {
      return aay();
    }
    
    public final int aap()
    {
      return jQ(aar());
    }
    
    public final long aaq()
    {
      return cO(aaw());
    }
    
    public final int aar()
    {
      int i = this.pos;
      byte[] arrayOfByte;
      int j;
      int k;
      if (this.limit != i)
      {
        arrayOfByte = this.buffer;
        j = i + 1;
        k = arrayOfByte[i];
        if (k >= 0)
        {
          this.pos = j;
          return k;
        }
        if (this.limit - j >= 9)
        {
          i = j + 1;
          k ^= arrayOfByte[j] << 7;
          if (k < 0) {
            j = k ^ 0xFFFFFF80;
          }
        }
      }
      for (;;)
      {
        this.pos = i;
        return j;
        j = i + 1;
        k ^= arrayOfByte[i] << 14;
        if (k >= 0)
        {
          k ^= 0x3F80;
          i = j;
          j = k;
        }
        else
        {
          i = j + 1;
          k ^= arrayOfByte[j] << 21;
          if (k < 0)
          {
            j = k ^ 0xFFE03F80;
          }
          else
          {
            int m = i + 1;
            j = arrayOfByte[i];
            k = k ^ j << 28 ^ 0xFE03F80;
            i = m;
            if (j < 0)
            {
              int n = m + 1;
              j = k;
              i = n;
              if (arrayOfByte[m] >= 0) {
                continue;
              }
              m = n + 1;
              i = m;
              if (arrayOfByte[n] < 0)
              {
                n = m + 1;
                j = k;
                i = n;
                if (arrayOfByte[m] >= 0) {
                  continue;
                }
                m = n + 1;
                i = m;
                if (arrayOfByte[n] < 0)
                {
                  i = m + 1;
                  j = k;
                  if (arrayOfByte[m] >= 0) {
                    continue;
                  }
                  return (int)aas();
                }
              }
            }
            j = k;
          }
        }
      }
    }
    
    final long aas()
    {
      long l = 0L;
      int i = 0;
      while (i < 64)
      {
        int j = aaA();
        l |= (j & 0x7F) << i;
        if ((j & 0x80) == 0) {
          return l;
        }
        i += 7;
      }
      throw bk.ail();
    }
    
    public final int aat()
    {
      if (this.dJb == 2147483647) {
        return -1;
      }
      return this.dJb - aav();
    }
    
    public final boolean aau()
    {
      return this.pos == this.limit;
    }
    
    public final int aav()
    {
      return this.pos - this.dIY;
    }
    
    public final void jM(int paramInt)
    {
      if (this.dIZ != paramInt) {
        throw bk.ain();
      }
    }
    
    public final boolean jN(int paramInt)
    {
      int j = 0;
      int i = 0;
      switch (du.lD(paramInt))
      {
      default: 
        throw bk.aio();
      case 0: 
        paramInt = j;
        if (this.limit - this.pos >= 10)
        {
          paramInt = i;
          while (paramInt < 10)
          {
            byte[] arrayOfByte = this.buffer;
            i = this.pos;
            this.pos = (i + 1);
            if (arrayOfByte[i] >= 0) {
              break label142;
            }
            paramInt += 1;
          }
          throw bk.ail();
        }
        while (paramInt < 10)
        {
          if (aaA() >= 0) {
            break label142;
          }
          paramInt += 1;
        }
        throw bk.ail();
      case 1: 
        jR(8);
        return true;
      case 2: 
        jR(aar());
        return true;
      case 3: 
        do
        {
          i = aac();
        } while ((i != 0) && (jN(i)));
        jM(du.cU(du.lE(paramInt), 4));
        return true;
      case 4: 
        label142:
        return false;
      }
      jR(4);
      return true;
    }
    
    public final int jO(int paramInt)
    {
      if (paramInt < 0) {
        throw bk.aik();
      }
      paramInt = aav() + paramInt;
      int i = this.dJb;
      if (paramInt > i) {
        throw bk.aij();
      }
      this.dJb = paramInt;
      aaz();
      return i;
    }
    
    public final void jP(int paramInt)
    {
      this.dJb = paramInt;
      aaz();
    }
    
    public final double readDouble()
    {
      return Double.longBitsToDouble(aay());
    }
    
    public final float readFloat()
    {
      return Float.intBitsToFloat(aax());
    }
    
    public final String readString()
    {
      int i = aar();
      if ((i > 0) && (i <= this.limit - this.pos))
      {
        String str = new String(this.buffer, this.pos, i, bj.UTF_8);
        this.pos = (i + this.pos);
        return str;
      }
      if (i == 0) {
        return "";
      }
      if (i < 0) {
        throw bk.aik();
      }
      throw bk.aij();
    }
  }
  
  static final class b
    extends i
  {
    private final byte[] buffer;
    private int bufferSize;
    private int dIX;
    private int dIZ;
    private int dJb = 2147483647;
    private final InputStream dJc;
    private int dJd;
    private a dJe = null;
    private int pos;
    
    private b(InputStream paramInputStream, int paramInt)
    {
      super();
      bj.c(paramInputStream, "input");
      this.dJc = paramInputStream;
      this.buffer = new byte[4096];
      this.bufferSize = 0;
      this.pos = 0;
      this.dJd = 0;
    }
    
    private byte aaA()
    {
      if (this.pos == this.bufferSize) {
        jS(1);
      }
      byte[] arrayOfByte = this.buffer;
      int i = this.pos;
      this.pos = (i + 1);
      return arrayOfByte[i];
    }
    
    private long aaw()
    {
      int i = this.pos;
      byte[] arrayOfByte;
      int j;
      int k;
      long l;
      if (this.bufferSize != i)
      {
        arrayOfByte = this.buffer;
        j = i + 1;
        k = arrayOfByte[i];
        if (k >= 0)
        {
          this.pos = j;
          return k;
        }
        if (this.bufferSize - j >= 9)
        {
          i = j + 1;
          k ^= arrayOfByte[j] << 7;
          if (k < 0) {
            l = k ^ 0xFFFFFF80;
          }
        }
      }
      for (;;)
      {
        this.pos = i;
        return l;
        j = i + 1;
        k ^= arrayOfByte[i] << 14;
        if (k >= 0)
        {
          l = k ^ 0x3F80;
          i = j;
        }
        else
        {
          i = j + 1;
          j = k ^ arrayOfByte[j] << 21;
          if (j < 0)
          {
            l = j ^ 0xFFE03F80;
          }
          else
          {
            l = j;
            j = i + 1;
            l ^= arrayOfByte[i] << 28;
            if (l >= 0L)
            {
              l ^= 0xFE03F80;
              i = j;
            }
            else
            {
              i = j + 1;
              l ^= arrayOfByte[j] << 35;
              if (l < 0L)
              {
                l ^= 0xFE03F80;
              }
              else
              {
                j = i + 1;
                l ^= arrayOfByte[i] << 42;
                if (l >= 0L)
                {
                  l ^= 0xFE03F80;
                  i = j;
                }
                else
                {
                  i = j + 1;
                  l ^= arrayOfByte[j] << 49;
                  if (l < 0L)
                  {
                    l ^= 0xFE03F80;
                  }
                  else
                  {
                    j = i + 1;
                    l = l ^ arrayOfByte[i] << 56 ^ 0xFE03F80;
                    if (l < 0L)
                    {
                      i = j + 1;
                      if (arrayOfByte[j] < 0L) {
                        return aas();
                      }
                    }
                    else
                    {
                      i = j;
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    
    private int aax()
    {
      int j = this.pos;
      int i = j;
      if (this.bufferSize - j < 4)
      {
        jS(4);
        i = this.pos;
      }
      byte[] arrayOfByte = this.buffer;
      this.pos = (i + 4);
      j = arrayOfByte[i];
      int k = arrayOfByte[(i + 1)];
      int m = arrayOfByte[(i + 2)];
      return (arrayOfByte[(i + 3)] & 0xFF) << 24 | j & 0xFF | (k & 0xFF) << 8 | (m & 0xFF) << 16;
    }
    
    private long aay()
    {
      int j = this.pos;
      int i = j;
      if (this.bufferSize - j < 8)
      {
        jS(8);
        i = this.pos;
      }
      byte[] arrayOfByte = this.buffer;
      this.pos = (i + 8);
      long l1 = arrayOfByte[i];
      long l2 = arrayOfByte[(i + 1)];
      long l3 = arrayOfByte[(i + 2)];
      long l4 = arrayOfByte[(i + 3)];
      long l5 = arrayOfByte[(i + 4)];
      long l6 = arrayOfByte[(i + 5)];
      long l7 = arrayOfByte[(i + 6)];
      return (arrayOfByte[(i + 7)] & 0xFF) << 56 | l1 & 0xFF | (l2 & 0xFF) << 8 | (l3 & 0xFF) << 16 | (l4 & 0xFF) << 24 | (l5 & 0xFF) << 32 | (l6 & 0xFF) << 40 | (l7 & 0xFF) << 48;
    }
    
    private void aaz()
    {
      this.bufferSize += this.dIX;
      int i = this.dJd + this.bufferSize;
      if (i > this.dJb)
      {
        this.dIX = (i - this.dJb);
        this.bufferSize -= this.dIX;
        return;
      }
      this.dIX = 0;
    }
    
    private void jR(int paramInt)
    {
      if ((paramInt <= this.bufferSize - this.pos) && (paramInt >= 0))
      {
        this.pos += paramInt;
        return;
      }
      jX(paramInt);
    }
    
    private void jS(int paramInt)
    {
      if (!jT(paramInt))
      {
        if (paramInt > this.dIT - this.dJd - this.pos) {
          throw bk.aiq();
        }
        throw bk.aij();
      }
    }
    
    private boolean jT(int paramInt)
    {
      do
      {
        if (this.pos + paramInt <= this.bufferSize) {
          throw new IllegalStateException("refillBuffer() called when " + paramInt + " bytes were already available in buffer");
        }
        if (paramInt > this.dIT - this.dJd - this.pos) {}
        int i;
        do
        {
          do
          {
            return false;
          } while (this.dJd + this.pos + paramInt > this.dJb);
          i = this.pos;
          if (i > 0)
          {
            if (this.bufferSize > i)
            {
              byte[] arrayOfByte = this.buffer;
              System.arraycopy(arrayOfByte, i, arrayOfByte, 0, this.bufferSize - i);
            }
            this.dJd += i;
            this.bufferSize -= i;
            this.pos = 0;
          }
          i = this.dJc.read(this.buffer, this.bufferSize, Math.min(this.buffer.length - this.bufferSize, this.dIT - this.dJd - this.bufferSize));
          if ((i == 0) || (i < -1) || (i > this.buffer.length)) {
            throw new IllegalStateException(this.dJc.getClass() + "#read(byte[]) returned invalid result: " + i + "\nThe InputStream implementation is buggy.");
          }
        } while (i <= 0);
        this.bufferSize = (i + this.bufferSize);
        aaz();
      } while (this.bufferSize < paramInt);
      return true;
    }
    
    private byte[] jU(int paramInt)
    {
      byte[] arrayOfByte1 = jV(paramInt);
      if (arrayOfByte1 != null) {
        return arrayOfByte1;
      }
      int j = this.pos;
      int i = this.bufferSize - this.pos;
      this.dJd += this.bufferSize;
      this.pos = 0;
      this.bufferSize = 0;
      Object localObject = jW(paramInt - i);
      arrayOfByte1 = new byte[paramInt];
      System.arraycopy(this.buffer, j, arrayOfByte1, 0, i);
      localObject = ((List)localObject).iterator();
      byte[] arrayOfByte2;
      for (paramInt = i; ((Iterator)localObject).hasNext(); paramInt = arrayOfByte2.length + paramInt)
      {
        arrayOfByte2 = (byte[])((Iterator)localObject).next();
        System.arraycopy(arrayOfByte2, 0, arrayOfByte1, paramInt, arrayOfByte2.length);
      }
      return arrayOfByte1;
    }
    
    private byte[] jV(int paramInt)
    {
      if (paramInt == 0) {
        return bj.EMPTY_BYTE_ARRAY;
      }
      if (paramInt < 0) {
        throw bk.aik();
      }
      int i = this.dJd + this.pos + paramInt;
      if (i - this.dIT > 0) {
        throw bk.aiq();
      }
      if (i > this.dJb)
      {
        jR(this.dJb - this.dJd - this.pos);
        throw bk.aij();
      }
      i = this.bufferSize - this.pos;
      int j = paramInt - i;
      if ((j < 4096) || (j <= this.dJc.available()))
      {
        byte[] arrayOfByte = new byte[paramInt];
        System.arraycopy(this.buffer, this.pos, arrayOfByte, 0, i);
        this.dJd += this.bufferSize;
        this.pos = 0;
        this.bufferSize = 0;
        while (i < arrayOfByte.length)
        {
          j = this.dJc.read(arrayOfByte, i, paramInt - i);
          if (j == -1) {
            throw bk.aij();
          }
          this.dJd += j;
          i += j;
        }
        return arrayOfByte;
      }
      return null;
    }
    
    private List<byte[]> jW(int paramInt)
    {
      ArrayList localArrayList = new ArrayList();
      while (paramInt > 0)
      {
        byte[] arrayOfByte = new byte[Math.min(paramInt, 4096)];
        int i = 0;
        while (i < arrayOfByte.length)
        {
          int j = this.dJc.read(arrayOfByte, i, arrayOfByte.length - i);
          if (j == -1) {
            throw bk.aij();
          }
          this.dJd += j;
          i += j;
        }
        paramInt -= arrayOfByte.length;
        localArrayList.add(arrayOfByte);
      }
      return localArrayList;
    }
    
    private void jX(int paramInt)
    {
      int i = 0;
      if (paramInt < 0) {
        throw bk.aik();
      }
      if (this.dJd + this.pos + paramInt > this.dJb)
      {
        jR(this.dJb - this.dJd - this.pos);
        throw bk.aij();
      }
      if (this.dJe == null)
      {
        this.dJd += this.pos;
        i = this.bufferSize - this.pos;
        this.bufferSize = 0;
        this.pos = 0;
        while (i < paramInt)
        {
          int j = paramInt - i;
          long l;
          try
          {
            l = this.dJc.skip(j);
            if ((l < 0L) || (l > j)) {
              throw new IllegalStateException(this.dJc.getClass() + "#skip returned invalid result: " + l + "\nThe InputStream implementation is buggy.");
            }
          }
          finally
          {
            this.dJd = (i + this.dJd);
            aaz();
          }
          if (l == 0L) {
            break;
          }
          i += (int)l;
        }
        this.dJd += i;
        aaz();
      }
      if (i < paramInt)
      {
        i = this.bufferSize - this.pos;
        this.pos = this.bufferSize;
        jS(1);
        while (paramInt - i > this.bufferSize)
        {
          i += this.bufferSize;
          this.pos = this.bufferSize;
          jS(1);
        }
        this.pos = (paramInt - i);
      }
    }
    
    public final <T extends ce> T a(cs<T> paramcs, at paramat)
    {
      int i = aar();
      if (this.dIR >= this.dIS) {
        throw bk.aip();
      }
      i = jO(i);
      this.dIR += 1;
      paramcs = (ce)paramcs.parsePartialFrom(this, paramat);
      jM(0);
      this.dIR -= 1;
      jP(i);
      return paramcs;
    }
    
    public final void a(int paramInt, ce.a parama, at paramat)
    {
      if (this.dIR >= this.dIS) {
        throw bk.aip();
      }
      this.dIR += 1;
      parama.mergeFrom(this, paramat);
      jM(du.cU(paramInt, 4));
      this.dIR -= 1;
    }
    
    public final void a(ce.a parama, at paramat)
    {
      int i = aar();
      if (this.dIR >= this.dIS) {
        throw bk.aip();
      }
      i = jO(i);
      this.dIR += 1;
      parama.mergeFrom(this, paramat);
      jM(0);
      this.dIR -= 1;
      jP(i);
    }
    
    public final int aac()
    {
      if (aau())
      {
        this.dIZ = 0;
        return 0;
      }
      this.dIZ = aar();
      if (du.lE(this.dIZ) == 0) {
        throw bk.aim();
      }
      return this.dIZ;
    }
    
    public final long aad()
    {
      return aaw();
    }
    
    public final long aae()
    {
      return aaw();
    }
    
    public final int aaf()
    {
      return aar();
    }
    
    public final long aag()
    {
      return aay();
    }
    
    public final int aah()
    {
      return aax();
    }
    
    public final boolean aai()
    {
      return aaw() != 0L;
    }
    
    public final String aaj()
    {
      int j = aar();
      int i = this.pos;
      byte[] arrayOfByte;
      if ((j <= this.bufferSize - i) && (j > 0))
      {
        arrayOfByte = this.buffer;
        this.pos = (i + j);
      }
      for (;;)
      {
        return dt.u(arrayOfByte, i, j);
        if (j == 0) {
          return "";
        }
        if (j <= this.bufferSize)
        {
          jS(j);
          arrayOfByte = this.buffer;
          this.pos = (j + 0);
          i = 0;
        }
        else
        {
          arrayOfByte = jU(j);
          i = 0;
        }
      }
    }
    
    public final h aak()
    {
      int j = aar();
      if ((j <= this.bufferSize - this.pos) && (j > 0))
      {
        localObject1 = h.o(this.buffer, this.pos, j);
        this.pos = (j + this.pos);
        return localObject1;
      }
      if (j == 0) {
        return h.dIJ;
      }
      Object localObject1 = jV(j);
      if (localObject1 != null) {
        return h.z((byte[])localObject1);
      }
      int k = this.pos;
      int i = this.bufferSize - this.pos;
      this.dJd += this.bufferSize;
      this.pos = 0;
      this.bufferSize = 0;
      Object localObject2 = jW(j - i);
      localObject1 = new byte[j];
      System.arraycopy(this.buffer, k, localObject1, 0, i);
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        byte[] arrayOfByte = (byte[])((Iterator)localObject2).next();
        System.arraycopy(arrayOfByte, 0, localObject1, i, arrayOfByte.length);
        i = arrayOfByte.length + i;
      }
      return h.A((byte[])localObject1);
    }
    
    public final int aal()
    {
      return aar();
    }
    
    public final int aam()
    {
      return aar();
    }
    
    public final int aan()
    {
      return aax();
    }
    
    public final long aao()
    {
      return aay();
    }
    
    public final int aap()
    {
      return jQ(aar());
    }
    
    public final long aaq()
    {
      return cO(aaw());
    }
    
    public final int aar()
    {
      int i = this.pos;
      byte[] arrayOfByte;
      int j;
      int k;
      if (this.bufferSize != i)
      {
        arrayOfByte = this.buffer;
        j = i + 1;
        k = arrayOfByte[i];
        if (k >= 0)
        {
          this.pos = j;
          return k;
        }
        if (this.bufferSize - j >= 9)
        {
          i = j + 1;
          k ^= arrayOfByte[j] << 7;
          if (k < 0) {
            j = k ^ 0xFFFFFF80;
          }
        }
      }
      for (;;)
      {
        this.pos = i;
        return j;
        j = i + 1;
        k ^= arrayOfByte[i] << 14;
        if (k >= 0)
        {
          k ^= 0x3F80;
          i = j;
          j = k;
        }
        else
        {
          i = j + 1;
          k ^= arrayOfByte[j] << 21;
          if (k < 0)
          {
            j = k ^ 0xFFE03F80;
          }
          else
          {
            int m = i + 1;
            j = arrayOfByte[i];
            k = k ^ j << 28 ^ 0xFE03F80;
            i = m;
            if (j < 0)
            {
              int n = m + 1;
              j = k;
              i = n;
              if (arrayOfByte[m] >= 0) {
                continue;
              }
              m = n + 1;
              i = m;
              if (arrayOfByte[n] < 0)
              {
                n = m + 1;
                j = k;
                i = n;
                if (arrayOfByte[m] >= 0) {
                  continue;
                }
                m = n + 1;
                i = m;
                if (arrayOfByte[n] < 0)
                {
                  i = m + 1;
                  j = k;
                  if (arrayOfByte[m] >= 0) {
                    continue;
                  }
                  return (int)aas();
                }
              }
            }
            j = k;
          }
        }
      }
    }
    
    final long aas()
    {
      long l = 0L;
      int i = 0;
      while (i < 64)
      {
        int j = aaA();
        l |= (j & 0x7F) << i;
        if ((j & 0x80) == 0) {
          return l;
        }
        i += 7;
      }
      throw bk.ail();
    }
    
    public final int aat()
    {
      if (this.dJb == 2147483647) {
        return -1;
      }
      int i = this.dJd;
      int j = this.pos;
      return this.dJb - (i + j);
    }
    
    public final boolean aau()
    {
      return (this.pos == this.bufferSize) && (!jT(1));
    }
    
    public final int aav()
    {
      return this.dJd + this.pos;
    }
    
    public final void jM(int paramInt)
    {
      if (this.dIZ != paramInt) {
        throw bk.ain();
      }
    }
    
    public final boolean jN(int paramInt)
    {
      int j = 0;
      int i = 0;
      switch (du.lD(paramInt))
      {
      default: 
        throw bk.aio();
      case 0: 
        paramInt = j;
        if (this.bufferSize - this.pos >= 10)
        {
          paramInt = i;
          while (paramInt < 10)
          {
            byte[] arrayOfByte = this.buffer;
            i = this.pos;
            this.pos = (i + 1);
            if (arrayOfByte[i] >= 0) {
              break label142;
            }
            paramInt += 1;
          }
          throw bk.ail();
        }
        while (paramInt < 10)
        {
          if (aaA() >= 0) {
            break label142;
          }
          paramInt += 1;
        }
        throw bk.ail();
      case 1: 
        jR(8);
        return true;
      case 2: 
        jR(aar());
        return true;
      case 3: 
        do
        {
          i = aac();
        } while ((i != 0) && (jN(i)));
        jM(du.cU(du.lE(paramInt), 4));
        return true;
      case 4: 
        label142:
        return false;
      }
      jR(4);
      return true;
    }
    
    public final int jO(int paramInt)
    {
      if (paramInt < 0) {
        throw bk.aik();
      }
      paramInt = this.dJd + this.pos + paramInt;
      int i = this.dJb;
      if (paramInt > i) {
        throw bk.aij();
      }
      this.dJb = paramInt;
      aaz();
      return i;
    }
    
    public final void jP(int paramInt)
    {
      this.dJb = paramInt;
      aaz();
    }
    
    public final double readDouble()
    {
      return Double.longBitsToDouble(aay());
    }
    
    public final float readFloat()
    {
      return Float.intBitsToFloat(aax());
    }
    
    public final String readString()
    {
      int i = aar();
      String str;
      if ((i > 0) && (i <= this.bufferSize - this.pos))
      {
        str = new String(this.buffer, this.pos, i, bj.UTF_8);
        this.pos = (i + this.pos);
        return str;
      }
      if (i == 0) {
        return "";
      }
      if (i <= this.bufferSize)
      {
        jS(i);
        str = new String(this.buffer, this.pos, i, bj.UTF_8);
        this.pos = (i + this.pos);
        return str;
      }
      return new String(jU(i), bj.UTF_8);
    }
    
    static abstract interface a {}
  }
  
  static final class c
    extends i
  {
    private final ByteBuffer buffer;
    private final boolean dIW;
    private int dIX;
    private int dIZ;
    private boolean dJa;
    private int dJb = 2147483647;
    private final long dJf;
    private long dJg;
    private long dJh;
    private long startPos;
    
    private c(ByteBuffer paramByteBuffer, boolean paramBoolean)
    {
      super();
      this.buffer = paramByteBuffer;
      this.dJf = ds.j(paramByteBuffer);
      this.dJg = (this.dJf + paramByteBuffer.limit());
      this.dJh = (this.dJf + paramByteBuffer.position());
      this.startPos = this.dJh;
      this.dIW = paramBoolean;
    }
    
    private ByteBuffer K(long paramLong1, long paramLong2)
    {
      int i = this.buffer.position();
      int j = this.buffer.limit();
      try
      {
        this.buffer.position((int)(paramLong1 - this.dJf));
        this.buffer.limit((int)(paramLong2 - this.dJf));
        ByteBuffer localByteBuffer = this.buffer.slice();
        return localByteBuffer;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        throw bk.aij();
      }
      finally
      {
        this.buffer.position(i);
        this.buffer.limit(j);
      }
    }
    
    private byte aaA()
    {
      if (this.dJh == this.dJg) {
        throw bk.aij();
      }
      long l = this.dJh;
      this.dJh = (1L + l);
      return ds.de(l);
    }
    
    private int aaB()
    {
      return (int)(this.dJg - this.dJh);
    }
    
    private long aaw()
    {
      long l1 = this.dJh;
      long l2;
      int i;
      if (this.dJg != l1)
      {
        l2 = l1 + 1L;
        i = ds.de(l1);
        if (i >= 0)
        {
          this.dJh = l2;
          return i;
        }
        if (this.dJg - l2 >= 9L)
        {
          l1 = l2 + 1L;
          i ^= ds.de(l2) << 7;
          if (i < 0) {
            l2 = i ^ 0xFFFFFF80;
          }
        }
      }
      for (;;)
      {
        this.dJh = l1;
        return l2;
        l2 = l1 + 1L;
        i ^= ds.de(l1) << 14;
        long l3;
        if (i >= 0)
        {
          l3 = i ^ 0x3F80;
          l1 = l2;
          l2 = l3;
        }
        else
        {
          l1 = l2 + 1L;
          i ^= ds.de(l2) << 21;
          if (i < 0)
          {
            l2 = i ^ 0xFFE03F80;
          }
          else
          {
            l3 = i;
            l2 = l1 + 1L;
            l3 ^= ds.de(l1) << 28;
            if (l3 >= 0L)
            {
              l3 ^= 0xFE03F80;
              l1 = l2;
              l2 = l3;
            }
            else
            {
              l1 = l2 + 1L;
              l3 ^= ds.de(l2) << 35;
              if (l3 < 0L)
              {
                l2 = l3 ^ 0xFE03F80;
              }
              else
              {
                l2 = l1 + 1L;
                l3 ^= ds.de(l1) << 42;
                if (l3 >= 0L)
                {
                  l3 ^= 0xFE03F80;
                  l1 = l2;
                  l2 = l3;
                }
                else
                {
                  l1 = l2 + 1L;
                  l2 = l3 ^ ds.de(l2) << 49;
                  if (l2 < 0L)
                  {
                    l2 ^= 0xFE03F80;
                  }
                  else
                  {
                    l3 = l1 + 1L;
                    l2 = l2 ^ ds.de(l1) << 56 ^ 0xFE03F80;
                    if (l2 < 0L)
                    {
                      l1 = l3 + 1L;
                      if (ds.de(l3) < 0L) {
                        return aas();
                      }
                    }
                    else
                    {
                      l1 = l3;
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    
    private int aax()
    {
      long l = this.dJh;
      if (this.dJg - l < 4L) {
        throw bk.aij();
      }
      this.dJh = (l + 4L);
      int i = ds.de(l);
      int j = ds.de(1L + l);
      int k = ds.de(2L + l);
      return (ds.de(l + 3L) & 0xFF) << 24 | i & 0xFF | (j & 0xFF) << 8 | (k & 0xFF) << 16;
    }
    
    private long aay()
    {
      long l1 = this.dJh;
      if (this.dJg - l1 < 8L) {
        throw bk.aij();
      }
      this.dJh = (l1 + 8L);
      long l2 = ds.de(l1);
      long l3 = ds.de(1L + l1);
      long l4 = ds.de(2L + l1);
      long l5 = ds.de(3L + l1);
      long l6 = ds.de(4L + l1);
      long l7 = ds.de(5L + l1);
      long l8 = ds.de(6L + l1);
      return (ds.de(l1 + 7L) & 0xFF) << 56 | l2 & 0xFF | (l3 & 0xFF) << 8 | (l4 & 0xFF) << 16 | (l5 & 0xFF) << 24 | (l6 & 0xFF) << 32 | (l7 & 0xFF) << 40 | (l8 & 0xFF) << 48;
    }
    
    private void aaz()
    {
      this.dJg += this.dIX;
      int i = (int)(this.dJg - this.startPos);
      if (i > this.dJb)
      {
        this.dIX = (i - this.dJb);
        this.dJg -= this.dIX;
        return;
      }
      this.dIX = 0;
    }
    
    private void jR(int paramInt)
    {
      if ((paramInt >= 0) && (paramInt <= aaB()))
      {
        this.dJh += paramInt;
        return;
      }
      if (paramInt < 0) {
        throw bk.aik();
      }
      throw bk.aij();
    }
    
    public final <T extends ce> T a(cs<T> paramcs, at paramat)
    {
      int i = aar();
      if (this.dIR >= this.dIS) {
        throw bk.aip();
      }
      i = jO(i);
      this.dIR += 1;
      paramcs = (ce)paramcs.parsePartialFrom(this, paramat);
      jM(0);
      this.dIR -= 1;
      jP(i);
      return paramcs;
    }
    
    public final void a(int paramInt, ce.a parama, at paramat)
    {
      if (this.dIR >= this.dIS) {
        throw bk.aip();
      }
      this.dIR += 1;
      parama.mergeFrom(this, paramat);
      jM(du.cU(paramInt, 4));
      this.dIR -= 1;
    }
    
    public final void a(ce.a parama, at paramat)
    {
      int i = aar();
      if (this.dIR >= this.dIS) {
        throw bk.aip();
      }
      i = jO(i);
      this.dIR += 1;
      parama.mergeFrom(this, paramat);
      jM(0);
      this.dIR -= 1;
      jP(i);
    }
    
    public final int aac()
    {
      if (aau())
      {
        this.dIZ = 0;
        return 0;
      }
      this.dIZ = aar();
      if (du.lE(this.dIZ) == 0) {
        throw bk.aim();
      }
      return this.dIZ;
    }
    
    public final long aad()
    {
      return aaw();
    }
    
    public final long aae()
    {
      return aaw();
    }
    
    public final int aaf()
    {
      return aar();
    }
    
    public final long aag()
    {
      return aay();
    }
    
    public final int aah()
    {
      return aax();
    }
    
    public final boolean aai()
    {
      return aaw() != 0L;
    }
    
    public final String aaj()
    {
      int i = aar();
      if ((i > 0) && (i <= aaB()))
      {
        int j = (int)(this.dJh - this.dJf);
        String str = dt.a(this.buffer, j, i);
        this.dJh += i;
        return str;
      }
      if (i == 0) {
        return "";
      }
      if (i <= 0) {
        throw bk.aik();
      }
      throw bk.aij();
    }
    
    public final h aak()
    {
      int i = aar();
      if ((i > 0) && (i <= aaB()))
      {
        if ((this.dIW) && (this.dJa))
        {
          localObject = K(this.dJh, this.dJh + i);
          this.dJh += i;
          return h.h((ByteBuffer)localObject);
        }
        Object localObject = new byte[i];
        ds.a(this.dJh, (byte[])localObject, i);
        this.dJh += i;
        return h.A((byte[])localObject);
      }
      if (i == 0) {
        return h.dIJ;
      }
      if (i < 0) {
        throw bk.aik();
      }
      throw bk.aij();
    }
    
    public final int aal()
    {
      return aar();
    }
    
    public final int aam()
    {
      return aar();
    }
    
    public final int aan()
    {
      return aax();
    }
    
    public final long aao()
    {
      return aay();
    }
    
    public final int aap()
    {
      return jQ(aar());
    }
    
    public final long aaq()
    {
      return cO(aaw());
    }
    
    public final int aar()
    {
      long l1 = this.dJh;
      long l2;
      int i;
      if (this.dJg != l1)
      {
        l2 = l1 + 1L;
        i = ds.de(l1);
        if (i >= 0)
        {
          this.dJh = l2;
          return i;
        }
        if (this.dJg - l2 >= 9L)
        {
          l1 = l2 + 1L;
          i ^= ds.de(l2) << 7;
          if (i < 0) {
            i ^= 0xFFFFFF80;
          }
        }
      }
      for (;;)
      {
        this.dJh = l1;
        return i;
        l2 = l1 + 1L;
        i ^= ds.de(l1) << 14;
        if (i >= 0)
        {
          i ^= 0x3F80;
          l1 = l2;
        }
        else
        {
          l1 = l2 + 1L;
          int j = i ^ ds.de(l2) << 21;
          if (j < 0)
          {
            i = j ^ 0xFFE03F80;
          }
          else
          {
            l2 = l1 + 1L;
            i = ds.de(l1);
            j = j ^ i << 28 ^ 0xFE03F80;
            l1 = l2;
            if (i < 0)
            {
              long l3 = l2 + 1L;
              i = j;
              l1 = l3;
              if (ds.de(l2) >= 0) {
                continue;
              }
              l2 = l3 + 1L;
              l1 = l2;
              if (ds.de(l3) < 0)
              {
                l3 = l2 + 1L;
                i = j;
                l1 = l3;
                if (ds.de(l2) >= 0) {
                  continue;
                }
                l2 = l3 + 1L;
                l1 = l2;
                if (ds.de(l3) < 0)
                {
                  l1 = l2 + 1L;
                  i = j;
                  if (ds.de(l2) >= 0) {
                    continue;
                  }
                  return (int)aas();
                }
              }
            }
            i = j;
          }
        }
      }
    }
    
    final long aas()
    {
      long l = 0L;
      int i = 0;
      while (i < 64)
      {
        int j = aaA();
        l |= (j & 0x7F) << i;
        if ((j & 0x80) == 0) {
          return l;
        }
        i += 7;
      }
      throw bk.ail();
    }
    
    public final int aat()
    {
      if (this.dJb == 2147483647) {
        return -1;
      }
      return this.dJb - aav();
    }
    
    public final boolean aau()
    {
      return this.dJh == this.dJg;
    }
    
    public final int aav()
    {
      return (int)(this.dJh - this.startPos);
    }
    
    public final void jM(int paramInt)
    {
      if (this.dIZ != paramInt) {
        throw bk.ain();
      }
    }
    
    public final boolean jN(int paramInt)
    {
      int j = 0;
      int i = 0;
      switch (du.lD(paramInt))
      {
      default: 
        throw bk.aio();
      case 0: 
        paramInt = j;
        if (aaB() >= 10)
        {
          paramInt = i;
          while (paramInt < 10)
          {
            long l = this.dJh;
            this.dJh = (1L + l);
            if (ds.de(l) >= 0) {
              break label134;
            }
            paramInt += 1;
          }
          throw bk.ail();
        }
        while (paramInt < 10)
        {
          if (aaA() >= 0) {
            break label134;
          }
          paramInt += 1;
        }
        throw bk.ail();
      case 1: 
        jR(8);
        return true;
      case 2: 
        jR(aar());
        return true;
      case 3: 
        do
        {
          i = aac();
        } while ((i != 0) && (jN(i)));
        jM(du.cU(du.lE(paramInt), 4));
        return true;
      case 4: 
        label134:
        return false;
      }
      jR(4);
      return true;
    }
    
    public final int jO(int paramInt)
    {
      if (paramInt < 0) {
        throw bk.aik();
      }
      paramInt = aav() + paramInt;
      int i = this.dJb;
      if (paramInt > i) {
        throw bk.aij();
      }
      this.dJb = paramInt;
      aaz();
      return i;
    }
    
    public final void jP(int paramInt)
    {
      this.dJb = paramInt;
      aaz();
    }
    
    public final double readDouble()
    {
      return Double.longBitsToDouble(aay());
    }
    
    public final float readFloat()
    {
      return Float.intBitsToFloat(aax());
    }
    
    public final String readString()
    {
      int i = aar();
      if ((i > 0) && (i <= aaB()))
      {
        Object localObject = new byte[i];
        ds.a(this.dJh, (byte[])localObject, i);
        localObject = new String((byte[])localObject, bj.UTF_8);
        this.dJh += i;
        return localObject;
      }
      if (i == 0) {
        return "";
      }
      if (i < 0) {
        throw bk.aik();
      }
      throw bk.aij();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.google.d.i
 * JD-Core Version:    0.7.0.1
 */