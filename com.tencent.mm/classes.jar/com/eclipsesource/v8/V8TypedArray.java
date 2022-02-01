package com.eclipsesource.v8;

import com.tencent.matrix.trace.core.AppMethodBeat;
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
    super(paramV8, new V8ArrayData(paramV8ArrayBuffer, paramInt2, paramInt3, paramInt1));
    AppMethodBeat.i(62204);
    AppMethodBeat.o(62204);
  }
  
  private void checkArrayProperties(V8ArrayData paramV8ArrayData)
  {
    AppMethodBeat.i(62210);
    checkOffset(paramV8ArrayData);
    checkSize(paramV8ArrayData);
    AppMethodBeat.o(62210);
  }
  
  private void checkOffset(V8ArrayData paramV8ArrayData)
  {
    AppMethodBeat.i(62212);
    if (paramV8ArrayData.offset % getStructureSize(paramV8ArrayData.type) != 0)
    {
      paramV8ArrayData = new IllegalStateException("RangeError: Start offset of Int32Array must be a multiple of " + getStructureSize(paramV8ArrayData.type));
      AppMethodBeat.o(62212);
      throw paramV8ArrayData;
    }
    AppMethodBeat.o(62212);
  }
  
  private void checkSize(V8ArrayData paramV8ArrayData)
  {
    AppMethodBeat.i(62211);
    if (paramV8ArrayData.size < 0)
    {
      paramV8ArrayData = new IllegalStateException("RangeError: Invalid typed array length");
      AppMethodBeat.o(62211);
      throw paramV8ArrayData;
    }
    if (paramV8ArrayData.size * getStructureSize(paramV8ArrayData.type) + paramV8ArrayData.offset > paramV8ArrayData.buffer.getBackingStore().limit())
    {
      paramV8ArrayData = new IllegalStateException("RangeError: Invalid typed array length");
      AppMethodBeat.o(62211);
      throw paramV8ArrayData;
    }
    AppMethodBeat.o(62211);
  }
  
  private long createTypedArray(long paramLong, V8ArrayData paramV8ArrayData)
  {
    AppMethodBeat.i(62208);
    switch (paramV8ArrayData.type)
    {
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 10: 
    default: 
      paramV8ArrayData = new IllegalArgumentException("Cannot create a typed array of type " + V8Value.getStringRepresentation(paramV8ArrayData.type));
      AppMethodBeat.o(62208);
      throw paramV8ArrayData;
    case 16: 
      paramLong = this.v8.initNewV8Float32Array(paramLong, paramV8ArrayData.buffer.objectHandle, paramV8ArrayData.offset, paramV8ArrayData.size);
      AppMethodBeat.o(62208);
      return paramLong;
    case 2: 
      paramLong = this.v8.initNewV8Float64Array(paramLong, paramV8ArrayData.buffer.objectHandle, paramV8ArrayData.offset, paramV8ArrayData.size);
      AppMethodBeat.o(62208);
      return paramLong;
    case 15: 
      paramLong = this.v8.initNewV8UInt32Array(paramLong, paramV8ArrayData.buffer.objectHandle, paramV8ArrayData.offset, paramV8ArrayData.size);
      AppMethodBeat.o(62208);
      return paramLong;
    case 13: 
      paramLong = this.v8.initNewV8Int16Array(paramLong, paramV8ArrayData.buffer.objectHandle, paramV8ArrayData.offset, paramV8ArrayData.size);
      AppMethodBeat.o(62208);
      return paramLong;
    case 14: 
      paramLong = this.v8.initNewV8UInt16Array(paramLong, paramV8ArrayData.buffer.objectHandle, paramV8ArrayData.offset, paramV8ArrayData.size);
      AppMethodBeat.o(62208);
      return paramLong;
    case 1: 
      paramLong = this.v8.initNewV8Int32Array(paramLong, paramV8ArrayData.buffer.objectHandle, paramV8ArrayData.offset, paramV8ArrayData.size);
      AppMethodBeat.o(62208);
      return paramLong;
    case 11: 
      paramLong = this.v8.initNewV8UInt8Array(paramLong, paramV8ArrayData.buffer.objectHandle, paramV8ArrayData.offset, paramV8ArrayData.size);
      AppMethodBeat.o(62208);
      return paramLong;
    case 9: 
      paramLong = this.v8.initNewV8Int8Array(paramLong, paramV8ArrayData.buffer.objectHandle, paramV8ArrayData.offset, paramV8ArrayData.size);
      AppMethodBeat.o(62208);
      return paramLong;
    }
    paramLong = this.v8.initNewV8UInt8ClampedArray(paramLong, paramV8ArrayData.buffer.objectHandle, paramV8ArrayData.offset, paramV8ArrayData.size);
    AppMethodBeat.o(62208);
    return paramLong;
  }
  
  public static int getStructureSize(int paramInt)
  {
    AppMethodBeat.i(62209);
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
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("Cannot create a typed array of type " + V8Value.getStringRepresentation(paramInt));
      AppMethodBeat.o(62209);
      throw localIllegalArgumentException;
    case 2: 
      AppMethodBeat.o(62209);
      return 8;
    case 1: 
    case 15: 
    case 16: 
      AppMethodBeat.o(62209);
      return 4;
    case 13: 
    case 14: 
      AppMethodBeat.o(62209);
      return 2;
    }
    AppMethodBeat.o(62209);
    return 1;
  }
  
  protected V8Value createTwin()
  {
    AppMethodBeat.i(62213);
    V8TypedArray localV8TypedArray = new V8TypedArray(this.v8);
    AppMethodBeat.o(62213);
    return localV8TypedArray;
  }
  
  public V8ArrayBuffer getBuffer()
  {
    AppMethodBeat.i(62205);
    V8ArrayBuffer localV8ArrayBuffer = (V8ArrayBuffer)get("buffer");
    AppMethodBeat.o(62205);
    return localV8ArrayBuffer;
  }
  
  public ByteBuffer getByteBuffer()
  {
    AppMethodBeat.i(62206);
    V8ArrayBuffer localV8ArrayBuffer = getBuffer();
    try
    {
      ByteBuffer localByteBuffer = localV8ArrayBuffer.getBackingStore();
      return localByteBuffer;
    }
    finally
    {
      localV8ArrayBuffer.release();
      AppMethodBeat.o(62206);
    }
  }
  
  protected void initialize(long paramLong, Object paramObject)
  {
    AppMethodBeat.i(62207);
    this.v8.checkThread();
    if (paramObject == null)
    {
      super.initialize(paramLong, paramObject);
      AppMethodBeat.o(62207);
      return;
    }
    paramObject = (V8ArrayData)paramObject;
    checkArrayProperties(paramObject);
    paramLong = createTypedArray(paramLong, paramObject);
    this.released = false;
    addObjectReference(paramLong);
    AppMethodBeat.o(62207);
  }
  
  static class V8ArrayData
  {
    private V8ArrayBuffer buffer;
    private int offset;
    private int size;
    private int type;
    
    public V8ArrayData(V8ArrayBuffer paramV8ArrayBuffer, int paramInt1, int paramInt2, int paramInt3)
    {
      this.buffer = paramV8ArrayBuffer;
      this.offset = paramInt1;
      this.size = paramInt2;
      this.type = paramInt3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.eclipsesource.v8.V8TypedArray
 * JD-Core Version:    0.7.0.1
 */