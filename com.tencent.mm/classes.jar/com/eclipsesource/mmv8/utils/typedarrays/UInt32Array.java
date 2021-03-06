package com.eclipsesource.mmv8.utils.typedarrays;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;

public class UInt32Array
  extends TypedArray
{
  public UInt32Array(ArrayBuffer paramArrayBuffer)
  {
    this(paramArrayBuffer.getByteBuffer());
    AppMethodBeat.i(61696);
    AppMethodBeat.o(61696);
  }
  
  public UInt32Array(ByteBuffer paramByteBuffer)
  {
    super(paramByteBuffer);
  }
  
  public long get(int paramInt)
  {
    AppMethodBeat.i(61697);
    long l = this.buffer.asIntBuffer().get(paramInt) & 0xFFFFFFFF;
    AppMethodBeat.o(61697);
    return l;
  }
  
  public int getType()
  {
    return 15;
  }
  
  public int length()
  {
    AppMethodBeat.i(61698);
    int i = this.buffer.asIntBuffer().limit();
    AppMethodBeat.o(61698);
    return i;
  }
  
  public void put(int paramInt, long paramLong)
  {
    AppMethodBeat.i(61699);
    this.buffer.asIntBuffer().put(paramInt, (int)(0xFFFFFFFF & paramLong));
    AppMethodBeat.o(61699);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.eclipsesource.mmv8.utils.typedarrays.UInt32Array
 * JD-Core Version:    0.7.0.1
 */