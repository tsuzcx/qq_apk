package com.eclipsesource.v8.utils.typedarrays;

import java.nio.ByteBuffer;
import java.nio.ShortBuffer;

public class UInt16Array
  extends TypedArray
{
  public UInt16Array(ArrayBuffer paramArrayBuffer)
  {
    this(paramArrayBuffer.getByteBuffer());
  }
  
  public UInt16Array(ByteBuffer paramByteBuffer)
  {
    super(paramByteBuffer);
  }
  
  public int get(int paramInt)
  {
    return 0xFFFF & this.buffer.asShortBuffer().get(paramInt);
  }
  
  public int getType()
  {
    return 14;
  }
  
  public int length()
  {
    return this.buffer.asShortBuffer().limit();
  }
  
  public void put(int paramInt1, int paramInt2)
  {
    this.buffer.asShortBuffer().put(paramInt1, (short)(0xFFFF & paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.eclipsesource.v8.utils.typedarrays.UInt16Array
 * JD-Core Version:    0.7.0.1
 */