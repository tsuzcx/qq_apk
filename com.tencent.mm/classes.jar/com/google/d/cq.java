package com.google.d;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

final class cq
  extends h.g
{
  private final ByteBuffer buffer;
  
  cq(ByteBuffer paramByteBuffer)
  {
    bj.c(paramByteBuffer, "buffer");
    this.buffer = paramByteBuffer.slice().order(ByteOrder.nativeOrder());
  }
  
  protected final int Q(int paramInt1, int paramInt2, int paramInt3)
  {
    return dt.a(paramInt1, this.buffer, paramInt2, paramInt2 + paramInt3);
  }
  
  protected final int R(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = paramInt2;
    while (i < paramInt2 + paramInt3)
    {
      paramInt1 = paramInt1 * 31 + this.buffer.get(i);
      i += 1;
    }
    return paramInt1;
  }
  
  public final ByteBuffer ZU()
  {
    return this.buffer.asReadOnlyBuffer();
  }
  
  public final boolean ZW()
  {
    return dt.k(this.buffer);
  }
  
  public final i ZX()
  {
    return i.a(this.buffer, true);
  }
  
  protected final String a(Charset paramCharset)
  {
    byte[] arrayOfByte;
    int j;
    if (this.buffer.hasArray())
    {
      arrayOfByte = this.buffer.array();
      i = this.buffer.arrayOffset();
      j = this.buffer.position() + i;
    }
    for (int i = this.buffer.remaining();; i = arrayOfByte.length)
    {
      return new String(arrayOfByte, j, i, paramCharset);
      arrayOfByte = toByteArray();
      j = 0;
    }
  }
  
  final void a(g paramg)
  {
    paramg.g(this.buffer.slice());
  }
  
  final boolean a(h paramh, int paramInt1, int paramInt2)
  {
    return cC(0, paramInt2).equals(paramh.cC(paramInt1, paramInt1 + paramInt2));
  }
  
  protected final void c(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    ByteBuffer localByteBuffer = this.buffer.slice();
    localByteBuffer.position(paramInt1);
    localByteBuffer.get(paramArrayOfByte, paramInt2, paramInt3);
  }
  
  public final h cC(int paramInt1, int paramInt2)
  {
    try
    {
      if ((paramInt1 < this.buffer.position()) || (paramInt2 > this.buffer.limit()) || (paramInt1 > paramInt2)) {
        throw new IllegalArgumentException(String.format("Invalid indices [%d, %d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
      }
    }
    catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
    {
      throw localArrayIndexOutOfBoundsException;
      Object localObject = this.buffer.slice();
      ((ByteBuffer)localObject).position(paramInt1 - this.buffer.position());
      ((ByteBuffer)localObject).limit(paramInt2 - this.buffer.position());
      localObject = new cq((ByteBuffer)localObject);
      return localObject;
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      throw new ArrayIndexOutOfBoundsException(localIndexOutOfBoundsException.getMessage());
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof h)) {
      return false;
    }
    h localh = (h)paramObject;
    if (this.buffer.remaining() != localh.size()) {
      return false;
    }
    if (this.buffer.remaining() == 0) {
      return true;
    }
    if ((paramObject instanceof cq)) {
      return this.buffer.equals(((cq)paramObject).buffer);
    }
    if ((paramObject instanceof db)) {
      return paramObject.equals(this);
    }
    return this.buffer.equals(localh.ZU());
  }
  
  public final byte jJ(int paramInt)
  {
    try
    {
      byte b = this.buffer.get(paramInt);
      return b;
    }
    catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
    {
      throw localArrayIndexOutOfBoundsException;
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      throw new ArrayIndexOutOfBoundsException(localIndexOutOfBoundsException.getMessage());
    }
  }
  
  public final byte jK(int paramInt)
  {
    return jJ(paramInt);
  }
  
  public final int size()
  {
    return this.buffer.remaining();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.google.d.cq
 * JD-Core Version:    0.7.0.1
 */