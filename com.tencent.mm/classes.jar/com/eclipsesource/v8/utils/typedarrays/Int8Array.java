package com.eclipsesource.v8.utils.typedarrays;

import java.nio.ByteBuffer;

public class Int8Array
  extends TypedArray
{
  public Int8Array(ArrayBuffer paramArrayBuffer)
  {
    this(paramArrayBuffer.getByteBuffer());
  }
  
  public Int8Array(ByteBuffer paramByteBuffer)
  {
    super(paramByteBuffer);
  }
  
  public byte get(int paramInt)
  {
    return this.buffer.get(paramInt);
  }
  
  public int getType()
  {
    return 9;
  }
  
  public int length()
  {
    return this.buffer.limit();
  }
  
  public void put(int paramInt, byte paramByte)
  {
    this.buffer.put(paramInt, paramByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.eclipsesource.v8.utils.typedarrays.Int8Array
 * JD-Core Version:    0.7.0.1
 */