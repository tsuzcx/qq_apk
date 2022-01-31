package com.eclipsesource.v8;

import java.nio.ByteBuffer;

public class V8TypedArray
  extends V8Array
{
  private V8TypedArray(V8 paramV8)
  {
    super(paramV8);
  }
  
  public V8TypedArray(V8 paramV8, V8ArrayBuffer paramV8ArrayBuffer, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramV8, new V8TypedArray.V8ArrayData(paramV8ArrayBuffer, paramInt2, paramInt3, paramInt1));
  }
  
  private void checkArrayProperties(V8TypedArray.V8ArrayData paramV8ArrayData)
  {
    checkOffset(paramV8ArrayData);
    checkSize(paramV8ArrayData);
  }
  
  private void checkOffset(V8TypedArray.V8ArrayData paramV8ArrayData)
  {
    if (V8TypedArray.V8ArrayData.access$200(paramV8ArrayData) % getStructureSize(V8TypedArray.V8ArrayData.access$000(paramV8ArrayData)) != 0) {
      throw new IllegalStateException("RangeError: Start offset of Int32Array must be a multiple of " + getStructureSize(V8TypedArray.V8ArrayData.access$000(paramV8ArrayData)));
    }
  }
  
  private void checkSize(V8TypedArray.V8ArrayData paramV8ArrayData)
  {
    if (V8TypedArray.V8ArrayData.access$300(paramV8ArrayData) < 0) {
      throw new IllegalStateException("RangeError: Invalid typed array length");
    }
    if (V8TypedArray.V8ArrayData.access$300(paramV8ArrayData) * getStructureSize(V8TypedArray.V8ArrayData.access$000(paramV8ArrayData)) + V8TypedArray.V8ArrayData.access$200(paramV8ArrayData) > V8TypedArray.V8ArrayData.access$100(paramV8ArrayData).getBackingStore().limit()) {
      throw new IllegalStateException("RangeError: Invalid typed array length");
    }
  }
  
  private long createTypedArray(long paramLong, V8TypedArray.V8ArrayData paramV8ArrayData)
  {
    switch (V8TypedArray.V8ArrayData.access$000(paramV8ArrayData))
    {
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 10: 
    default: 
      throw new IllegalArgumentException("Cannot create a typed array of type " + V8Value.getStringRepresentation(V8TypedArray.V8ArrayData.access$000(paramV8ArrayData)));
    case 16: 
      return this.v8.initNewV8Float32Array(paramLong, V8TypedArray.V8ArrayData.access$100(paramV8ArrayData).objectHandle, V8TypedArray.V8ArrayData.access$200(paramV8ArrayData), V8TypedArray.V8ArrayData.access$300(paramV8ArrayData));
    case 2: 
      return this.v8.initNewV8Float64Array(paramLong, V8TypedArray.V8ArrayData.access$100(paramV8ArrayData).objectHandle, V8TypedArray.V8ArrayData.access$200(paramV8ArrayData), V8TypedArray.V8ArrayData.access$300(paramV8ArrayData));
    case 15: 
      return this.v8.initNewV8UInt32Array(paramLong, V8TypedArray.V8ArrayData.access$100(paramV8ArrayData).objectHandle, V8TypedArray.V8ArrayData.access$200(paramV8ArrayData), V8TypedArray.V8ArrayData.access$300(paramV8ArrayData));
    case 13: 
      return this.v8.initNewV8Int16Array(paramLong, V8TypedArray.V8ArrayData.access$100(paramV8ArrayData).objectHandle, V8TypedArray.V8ArrayData.access$200(paramV8ArrayData), V8TypedArray.V8ArrayData.access$300(paramV8ArrayData));
    case 14: 
      return this.v8.initNewV8UInt16Array(paramLong, V8TypedArray.V8ArrayData.access$100(paramV8ArrayData).objectHandle, V8TypedArray.V8ArrayData.access$200(paramV8ArrayData), V8TypedArray.V8ArrayData.access$300(paramV8ArrayData));
    case 1: 
      return this.v8.initNewV8Int32Array(paramLong, V8TypedArray.V8ArrayData.access$100(paramV8ArrayData).objectHandle, V8TypedArray.V8ArrayData.access$200(paramV8ArrayData), V8TypedArray.V8ArrayData.access$300(paramV8ArrayData));
    case 11: 
      return this.v8.initNewV8UInt8Array(paramLong, V8TypedArray.V8ArrayData.access$100(paramV8ArrayData).objectHandle, V8TypedArray.V8ArrayData.access$200(paramV8ArrayData), V8TypedArray.V8ArrayData.access$300(paramV8ArrayData));
    case 9: 
      return this.v8.initNewV8Int8Array(paramLong, V8TypedArray.V8ArrayData.access$100(paramV8ArrayData).objectHandle, V8TypedArray.V8ArrayData.access$200(paramV8ArrayData), V8TypedArray.V8ArrayData.access$300(paramV8ArrayData));
    }
    return this.v8.initNewV8UInt8ClampedArray(paramLong, V8TypedArray.V8ArrayData.access$100(paramV8ArrayData).objectHandle, V8TypedArray.V8ArrayData.access$200(paramV8ArrayData), V8TypedArray.V8ArrayData.access$300(paramV8ArrayData));
  }
  
  public static int getStructureSize(int paramInt)
  {
    switch (paramInt)
    {
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 10: 
    default: 
      throw new IllegalArgumentException("Cannot create a typed array of type " + V8Value.getStringRepresentation(paramInt));
    case 2: 
      return 8;
    case 1: 
    case 15: 
    case 16: 
      return 4;
    case 13: 
    case 14: 
      return 2;
    }
    return 1;
  }
  
  protected V8Value createTwin()
  {
    return new V8TypedArray(this.v8);
  }
  
  public V8ArrayBuffer getBuffer()
  {
    return (V8ArrayBuffer)get("buffer");
  }
  
  public ByteBuffer getByteBuffer()
  {
    V8ArrayBuffer localV8ArrayBuffer = getBuffer();
    try
    {
      ByteBuffer localByteBuffer = localV8ArrayBuffer.getBackingStore();
      return localByteBuffer;
    }
    finally
    {
      localV8ArrayBuffer.release();
    }
  }
  
  protected void initialize(long paramLong, Object paramObject)
  {
    this.v8.checkThread();
    if (paramObject == null)
    {
      super.initialize(paramLong, paramObject);
      return;
    }
    paramObject = (V8TypedArray.V8ArrayData)paramObject;
    checkArrayProperties(paramObject);
    paramLong = createTypedArray(paramLong, paramObject);
    this.released = false;
    addObjectReference(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.eclipsesource.v8.V8TypedArray
 * JD-Core Version:    0.7.0.1
 */