package com.tencent.map.lib.gl;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

public class a
{
  public static int a = 0;
  
  static
  {
    long l = Runtime.getRuntime().maxMemory();
    if (l <= 16777216L)
    {
      a = 1;
      return;
    }
    if (l >= 67108864L)
    {
      a = 2;
      return;
    }
  }
  
  public static FloatBuffer a(int paramInt)
  {
    ByteBuffer.allocate(0);
    try
    {
      Object localObject = ByteBuffer.allocateDirect(paramInt * 4);
      ((ByteBuffer)localObject).order(ByteOrder.nativeOrder());
      localObject = ((ByteBuffer)localObject).asFloatBuffer();
      ((FloatBuffer)localObject).rewind();
      return localObject;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(paramInt * 4);
      }
    }
  }
  
  public static FloatBuffer a(float[] paramArrayOfFloat, FloatBuffer paramFloatBuffer)
  {
    int i = paramArrayOfFloat.length;
    FloatBuffer localFloatBuffer;
    if (paramFloatBuffer != null)
    {
      localFloatBuffer = paramFloatBuffer;
      if (paramFloatBuffer.capacity() == i) {}
    }
    else
    {
      localFloatBuffer = a(i);
    }
    localFloatBuffer.put(paramArrayOfFloat);
    localFloatBuffer.rewind();
    return localFloatBuffer;
  }
  
  public static ShortBuffer a(short[] paramArrayOfShort, ShortBuffer paramShortBuffer)
  {
    int i = paramArrayOfShort.length;
    ShortBuffer localShortBuffer;
    if (paramShortBuffer != null)
    {
      localShortBuffer = paramShortBuffer;
      if (paramShortBuffer.capacity() == i) {}
    }
    else
    {
      localShortBuffer = b(i);
    }
    localShortBuffer.put(paramArrayOfShort);
    localShortBuffer.rewind();
    return localShortBuffer;
  }
  
  public static ShortBuffer b(int paramInt)
  {
    Object localObject = ByteBuffer.allocateDirect(paramInt * 2);
    ((ByteBuffer)localObject).order(ByteOrder.nativeOrder());
    localObject = ((ByteBuffer)localObject).asShortBuffer();
    ((ShortBuffer)localObject).rewind();
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.map.lib.gl.a
 * JD-Core Version:    0.7.0.1
 */