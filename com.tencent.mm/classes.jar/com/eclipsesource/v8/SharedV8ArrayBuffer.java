package com.eclipsesource.v8;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

public class SharedV8ArrayBuffer
  extends V8ArrayBuffer
{
  private SharedV8ArrayBuffer(V8 paramV8, int paramInt)
  {
    super(paramV8, paramInt);
    AppMethodBeat.i(75026);
    paramV8 = new IllegalArgumentException("not support this way construct");
    AppMethodBeat.o(75026);
    throw paramV8;
  }
  
  public SharedV8ArrayBuffer(V8 paramV8, ByteBuffer paramByteBuffer)
  {
    super(paramV8, paramByteBuffer);
  }
  
  protected void initialize(long paramLong, Object paramObject)
  {
    AppMethodBeat.i(75027);
    this.v8.checkThread();
    paramObject = (ByteBuffer)paramObject;
    int i = paramObject.limit();
    this.objectHandle = this.v8.initNewSharedV8ArrayBuffer(this.v8.getV8RuntimePtr(), paramObject, i);
    this.released = false;
    addObjectReference(this.objectHandle);
    AppMethodBeat.o(75027);
  }
  
  public void manualRelease()
  {
    AppMethodBeat.i(75028);
    super.release();
    AppMethodBeat.o(75028);
  }
  
  public void release() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.eclipsesource.v8.SharedV8ArrayBuffer
 * JD-Core Version:    0.7.0.1
 */