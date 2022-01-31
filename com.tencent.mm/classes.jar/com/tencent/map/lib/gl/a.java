package com.tencent.map.lib.gl;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

public class a
{
  public static int a;
  
  static
  {
    AppMethodBeat.i(98045);
    long l = Runtime.getRuntime().maxMemory();
    if (l <= 16777216L)
    {
      a = 1;
      AppMethodBeat.o(98045);
      return;
    }
    if (l >= 67108864L)
    {
      a = 2;
      AppMethodBeat.o(98045);
      return;
    }
    a = 0;
    AppMethodBeat.o(98045);
  }
  
  public static FloatBuffer a(int paramInt)
  {
    AppMethodBeat.i(98041);
    ByteBuffer.allocate(0);
    try
    {
      Object localObject = ByteBuffer.allocateDirect(paramInt * 4);
      ((ByteBuffer)localObject).order(ByteOrder.nativeOrder());
      localObject = ((ByteBuffer)localObject).asFloatBuffer();
      ((FloatBuffer)localObject).rewind();
      AppMethodBeat.o(98041);
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
    AppMethodBeat.i(98042);
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
    AppMethodBeat.o(98042);
    return localFloatBuffer;
  }
  
  public static ShortBuffer a(short[] paramArrayOfShort, ShortBuffer paramShortBuffer)
  {
    AppMethodBeat.i(98044);
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
    AppMethodBeat.o(98044);
    return localShortBuffer;
  }
  
  public static ShortBuffer b(int paramInt)
  {
    AppMethodBeat.i(98043);
    Object localObject = ByteBuffer.allocateDirect(paramInt * 2);
    ((ByteBuffer)localObject).order(ByteOrder.nativeOrder());
    localObject = ((ByteBuffer)localObject).asShortBuffer();
    ((ShortBuffer)localObject).rewind();
    AppMethodBeat.o(98043);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.map.lib.gl.a
 * JD-Core Version:    0.7.0.1
 */