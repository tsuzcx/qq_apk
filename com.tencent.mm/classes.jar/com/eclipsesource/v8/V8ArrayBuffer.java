package com.eclipsesource.v8;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class V8ArrayBuffer
  extends V8Value
{
  private ByteBuffer byteBuffer;
  
  public V8ArrayBuffer(V8 paramV8, int paramInt)
  {
    super(paramV8);
    AppMethodBeat.i(62066);
    initialize(paramV8.getV8RuntimePtr(), Integer.valueOf(paramInt));
    this.byteBuffer = paramV8.createV8ArrayBufferBackingStore(paramV8.getV8RuntimePtr(), this.objectHandle, paramInt);
    this.byteBuffer.order(ByteOrder.nativeOrder());
    AppMethodBeat.o(62066);
  }
  
  public V8ArrayBuffer(V8 paramV8, ByteBuffer paramByteBuffer)
  {
    super(paramV8);
    AppMethodBeat.i(62067);
    if (!paramByteBuffer.isDirect())
    {
      paramV8 = new IllegalArgumentException("ByteBuffer must be a allocated as a direct ByteBuffer");
      AppMethodBeat.o(62067);
      throw paramV8;
    }
    initialize(paramV8.getV8RuntimePtr(), paramByteBuffer);
    this.byteBuffer = paramByteBuffer;
    paramByteBuffer.order(ByteOrder.nativeOrder());
    AppMethodBeat.o(62067);
  }
  
  protected V8Value createTwin()
  {
    AppMethodBeat.i(62069);
    V8ArrayBuffer localV8ArrayBuffer = new V8ArrayBuffer(this.v8, this.byteBuffer);
    AppMethodBeat.o(62069);
    return localV8ArrayBuffer;
  }
  
  public ByteBuffer getBackingStore()
  {
    AppMethodBeat.i(62071);
    this.v8.checkReleased();
    this.v8.checkThread();
    ByteBuffer localByteBuffer = this.byteBuffer;
    AppMethodBeat.o(62071);
    return localByteBuffer;
  }
  
  protected void initialize(long paramLong, Object paramObject)
  {
    AppMethodBeat.i(62068);
    this.v8.checkThread();
    int i;
    if ((paramObject instanceof ByteBuffer))
    {
      paramObject = (ByteBuffer)paramObject;
      i = paramObject.limit();
    }
    for (this.objectHandle = this.v8.initNewV8ArrayBuffer(this.v8.getV8RuntimePtr(), paramObject, i);; this.objectHandle = this.v8.initNewV8ArrayBuffer(this.v8.getV8RuntimePtr(), i))
    {
      this.released = false;
      addObjectReference(this.objectHandle);
      AppMethodBeat.o(62068);
      return;
      i = ((Integer)paramObject).intValue();
    }
  }
  
  public V8ArrayBuffer twin()
  {
    AppMethodBeat.i(62070);
    V8ArrayBuffer localV8ArrayBuffer = (V8ArrayBuffer)super.twin();
    AppMethodBeat.o(62070);
    return localV8ArrayBuffer;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.eclipsesource.v8.V8ArrayBuffer
 * JD-Core Version:    0.7.0.1
 */