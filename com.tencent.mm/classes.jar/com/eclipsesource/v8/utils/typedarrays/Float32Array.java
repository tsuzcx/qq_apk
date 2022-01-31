package com.eclipsesource.v8.utils.typedarrays;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

public class Float32Array
  extends TypedArray
{
  public Float32Array(ArrayBuffer paramArrayBuffer)
  {
    this(paramArrayBuffer.getByteBuffer());
  }
  
  public Float32Array(ByteBuffer paramByteBuffer)
  {
    super(paramByteBuffer);
  }
  
  public float get(int paramInt)
  {
    return this.buffer.asFloatBuffer().get(paramInt);
  }
  
  public int getType()
  {
    return 16;
  }
  
  public int length()
  {
    return this.buffer.asFloatBuffer().limit();
  }
  
  public void put(int paramInt, float paramFloat)
  {
    this.buffer.asFloatBuffer().put(paramInt, paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.eclipsesource.v8.utils.typedarrays.Float32Array
 * JD-Core Version:    0.7.0.1
 */