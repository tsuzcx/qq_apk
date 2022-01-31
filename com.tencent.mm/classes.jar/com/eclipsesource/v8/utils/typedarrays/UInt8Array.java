package com.eclipsesource.v8.utils.typedarrays;

import java.nio.ByteBuffer;

public class UInt8Array
  extends TypedArray
{
  public UInt8Array(ArrayBuffer paramArrayBuffer)
  {
    this(paramArrayBuffer.getByteBuffer());
  }
  
  public UInt8Array(ByteBuffer paramByteBuffer)
  {
    super(paramByteBuffer);
  }
  
  public short get(int paramInt)
  {
    return (short)(this.buffer.get(paramInt) & 0xFF);
  }
  
  public int getType()
  {
    return 11;
  }
  
  public int length()
  {
    return this.buffer.limit();
  }
  
  public void put(int paramInt, short paramShort)
  {
    this.buffer.put(paramInt, (byte)(paramShort & 0xFF));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.eclipsesource.v8.utils.typedarrays.UInt8Array
 * JD-Core Version:    0.7.0.1
 */