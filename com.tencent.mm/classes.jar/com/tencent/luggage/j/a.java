package com.tencent.luggage.j;

import com.tencent.mm.sdk.platformtools.y;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;

public final class a
  extends InputStream
{
  public final ByteBuffer bjB;
  private int bjC;
  
  public a(ByteBuffer paramByteBuffer)
  {
    this.bjB = paramByteBuffer;
  }
  
  public static void f(ByteBuffer paramByteBuffer)
  {
    Object localObject;
    if (paramByteBuffer.getClass().getName().equals("java.nio.DirectByteBuffer")) {
      localObject = paramByteBuffer.getClass();
    }
    try
    {
      localObject = ((Class)localObject).getDeclaredMethod("free", new Class[0]);
      boolean bool = ((Method)localObject).isAccessible();
      ((Method)localObject).setAccessible(true);
      ((Method)localObject).invoke(paramByteBuffer, new Object[0]);
      ((Method)localObject).setAccessible(bool);
      System.gc();
      return;
    }
    catch (Exception paramByteBuffer)
    {
      for (;;)
      {
        y.d("MicroMsg.ByteBufferBackedInputStream", "free ByteBuffer, exp = %s", new Object[] { paramByteBuffer });
      }
    }
  }
  
  public final int available()
  {
    return this.bjB.remaining();
  }
  
  public final void close()
  {
    super.close();
    f(this.bjB);
  }
  
  public final void mark(int paramInt)
  {
    try
    {
      this.bjC = this.bjB.position();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final boolean markSupported()
  {
    return true;
  }
  
  public final int read()
  {
    if (this.bjB.hasRemaining()) {
      return this.bjB.get() & 0xFF;
    }
    return -1;
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (!this.bjB.hasRemaining()) {
      return -1;
    }
    paramInt2 = Math.min(paramInt2, this.bjB.remaining());
    this.bjB.get(paramArrayOfByte, paramInt1, paramInt2);
    return paramInt2;
  }
  
  public final void reset()
  {
    try
    {
      this.bjB.position(this.bjC);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void seek(int paramInt)
  {
    try
    {
      this.bjB.position(paramInt);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.j.a
 * JD-Core Version:    0.7.0.1
 */