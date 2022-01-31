package com.eclipsesource.v8.utils.typedarrays;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;

public class UInt32Array
  extends TypedArray
{
  public UInt32Array(ArrayBuffer paramArrayBuffer)
  {
    this(paramArrayBuffer.getByteBuffer());
    AppMethodBeat.i(75072);
    AppMethodBeat.o(75072);
  }
  
  public UInt32Array(ByteBuffer paramByteBuffer)
  {
    super(paramByteBuffer);
  }
  
  public long get(int paramInt)
  {
    AppMethodBeat.i(75073);
    long l = this.buffer.asIntBuffer().get(paramInt) & 0xFFFFFFFF;
    AppMethodBeat.o(75073);
    return l;
  }
  
  public int getType()
  {
    return 15;
  }
  
  public int length()
  {
    AppMethodBeat.i(75074);
    int i = this.buffer.asIntBuffer().limit();
    AppMethodBeat.o(75074);
    return i;
  }
  
  public void put(int paramInt, long paramLong)
  {
    AppMethodBeat.i(75075);
    this.buffer.asIntBuffer().put(paramInt, (int)(0xFFFFFFFF & paramLong));
    AppMethodBeat.o(75075);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.eclipsesource.v8.utils.typedarrays.UInt32Array
 * JD-Core Version:    0.7.0.1
 */