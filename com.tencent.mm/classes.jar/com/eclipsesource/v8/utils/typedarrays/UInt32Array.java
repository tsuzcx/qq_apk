package com.eclipsesource.v8.utils.typedarrays;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

public class UInt32Array
  extends TypedArray
{
  public UInt32Array(ArrayBuffer paramArrayBuffer)
  {
    this(paramArrayBuffer.getByteBuffer());
  }
  
  public UInt32Array(ByteBuffer paramByteBuffer)
  {
    super(paramByteBuffer);
  }
  
  public long get(int paramInt)
  {
    return this.buffer.asIntBuffer().get(paramInt) & 0xFFFFFFFF;
  }
  
  public int getType()
  {
    return 15;
  }
  
  public int length()
  {
    return this.buffer.asIntBuffer().limit();
  }
  
  public void put(int paramInt, long paramLong)
  {
    this.buffer.asIntBuffer().put(paramInt, (int)(0xFFFFFFFF & paramLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.eclipsesource.v8.utils.typedarrays.UInt32Array
 * JD-Core Version:    0.7.0.1
 */