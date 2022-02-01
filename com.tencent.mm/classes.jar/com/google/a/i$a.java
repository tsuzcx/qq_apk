package com.google.a;

final class i$a
  extends i
{
  private final byte[] buffer;
  private final int limit;
  private final int offset;
  private int position;
  
  i$a(byte[] paramArrayOfByte, int paramInt)
  {
    super((byte)0);
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
  
  private void fZ(int paramInt)
  {
    br(2, 0);
    fL(paramInt);
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
  
  public final void a(int paramInt, aw paramaw)
  {
    br(paramInt, 2);
    c(paramaw);
  }
  
  public final void a(int paramInt, g paramg)
  {
    br(paramInt, 2);
    a(paramg);
  }
  
  public final void a(g paramg)
  {
    fL(paramg.size());
    paramg.a(this);
  }
  
  public final void av(long paramLong)
  {
    long l = paramLong;
    byte[] arrayOfByte;
    int i;
    if (i.bNy)
    {
      l = paramLong;
      if (zz() >= 10) {
        for (;;)
        {
          if ((paramLong & 0xFFFFFF80) == 0L)
          {
            arrayOfByte = this.buffer;
            i = this.position;
            this.position = (i + 1);
            ch.a(arrayOfByte, i, (byte)(int)paramLong);
            return;
          }
          arrayOfByte = this.buffer;
          i = this.position;
          this.position = (i + 1);
          ch.a(arrayOfByte, i, (byte)((int)paramLong & 0x7F | 0x80));
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
  
  public final void ax(long paramLong)
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
  
  public final void b(int paramInt, aw paramaw)
  {
    br(1, 3);
    fZ(paramInt);
    a(3, paramaw);
    br(1, 4);
  }
  
  public final void b(int paramInt, g paramg)
  {
    br(1, 3);
    fZ(paramInt);
    a(3, paramg);
    br(1, 4);
  }
  
  public final void br(int paramInt1, int paramInt2)
  {
    fL(cj.bA(paramInt1, paramInt2));
  }
  
  public final void bs(int paramInt1, int paramInt2)
  {
    br(paramInt1, 0);
    fK(paramInt2);
  }
  
  public final void bt(int paramInt1, int paramInt2)
  {
    br(paramInt1, 5);
    fN(paramInt2);
  }
  
  public final void c(aw paramaw)
  {
    fL(paramaw.yC());
    paramaw.a(this);
  }
  
  public final void ca(String paramString)
  {
    int i = this.position;
    try
    {
      int k = fU(paramString.length() * 3);
      int j = fU(paramString.length());
      if (j == k)
      {
        this.position = (i + j);
        k = ci.a(paramString, this.buffer, this.position, zz());
        this.position = i;
        fL(k - i - j);
        this.position = k;
        return;
      }
      fL(ci.v(paramString));
      this.position = ci.a(paramString, this.buffer, this.position, zz());
      return;
    }
    catch (ci.d locald)
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
  
  public final void e(int paramInt, String paramString)
  {
    br(paramInt, 2);
    ca(paramString);
  }
  
  public final void fK(int paramInt)
  {
    if (paramInt >= 0)
    {
      fL(paramInt);
      return;
    }
    av(paramInt);
  }
  
  public final void fL(int paramInt)
  {
    int i = paramInt;
    byte[] arrayOfByte;
    if (i.bNy)
    {
      i = paramInt;
      if (!e.yM())
      {
        i = paramInt;
        if (zz() >= 5)
        {
          if ((paramInt & 0xFFFFFF80) == 0)
          {
            arrayOfByte = this.buffer;
            i = this.position;
            this.position = (i + 1);
            ch.a(arrayOfByte, i, (byte)paramInt);
            return;
          }
          arrayOfByte = this.buffer;
          i = this.position;
          this.position = (i + 1);
          ch.a(arrayOfByte, i, (byte)(paramInt | 0x80));
          paramInt >>>= 7;
          if ((paramInt & 0xFFFFFF80) == 0)
          {
            arrayOfByte = this.buffer;
            i = this.position;
            this.position = (i + 1);
            ch.a(arrayOfByte, i, (byte)paramInt);
            return;
          }
          arrayOfByte = this.buffer;
          i = this.position;
          this.position = (i + 1);
          ch.a(arrayOfByte, i, (byte)(paramInt | 0x80));
          paramInt >>>= 7;
          if ((paramInt & 0xFFFFFF80) == 0)
          {
            arrayOfByte = this.buffer;
            i = this.position;
            this.position = (i + 1);
            ch.a(arrayOfByte, i, (byte)paramInt);
            return;
          }
          arrayOfByte = this.buffer;
          i = this.position;
          this.position = (i + 1);
          ch.a(arrayOfByte, i, (byte)(paramInt | 0x80));
          paramInt >>>= 7;
          if ((paramInt & 0xFFFFFF80) == 0)
          {
            arrayOfByte = this.buffer;
            i = this.position;
            this.position = (i + 1);
            ch.a(arrayOfByte, i, (byte)paramInt);
            return;
          }
          arrayOfByte = this.buffer;
          i = this.position;
          this.position = (i + 1);
          ch.a(arrayOfByte, i, (byte)(paramInt | 0x80));
          arrayOfByte = this.buffer;
          i = this.position;
          this.position = (i + 1);
          ch.a(arrayOfByte, i, (byte)(paramInt >>> 7));
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
  
  public final void fN(int paramInt)
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
    br(paramInt, 0);
    av(paramLong);
  }
  
  public final void o(int paramInt, long paramLong)
  {
    br(paramInt, 1);
    ax(paramLong);
  }
  
  public final void o(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    write(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public final void r(int paramInt, boolean paramBoolean)
  {
    int i = 0;
    br(paramInt, 0);
    paramInt = i;
    if (paramBoolean) {
      paramInt = 1;
    }
    d((byte)paramInt);
  }
  
  public final void r(byte[] paramArrayOfByte, int paramInt)
  {
    fL(paramInt);
    write(paramArrayOfByte, 0, paramInt);
  }
  
  public final int zz()
  {
    return this.limit - this.position;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.a.i.a
 * JD-Core Version:    0.7.0.1
 */