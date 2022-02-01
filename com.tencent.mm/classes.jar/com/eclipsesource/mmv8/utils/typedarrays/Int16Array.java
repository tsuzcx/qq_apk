package com.eclipsesource.mmv8.utils.typedarrays;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ShortBuffer;

public class Int16Array
  extends TypedArray
{
  public Int16Array(ArrayBuffer paramArrayBuffer)
  {
    this(paramArrayBuffer.getByteBuffer());
    AppMethodBeat.i(61680);
    AppMethodBeat.o(61680);
  }
  
  public Int16Array(ByteBuffer paramByteBuffer)
  {
    super(paramByteBuffer);
  }
  
  public short get(int paramInt)
  {
    AppMethodBeat.i(61681);
    short s = this.buffer.asShortBuffer().get(paramInt);
    AppMethodBeat.o(61681);
    return s;
  }
  
  public int getType()
  {
    return 13;
  }
  
  public int length()
  {
    AppMethodBeat.i(61682);
    int i = this.buffer.asShortBuffer().limit();
    AppMethodBeat.o(61682);
    return i;
  }
  
  public void put(int paramInt, short paramShort)
  {
    AppMethodBeat.i(61683);
    this.buffer.asShortBuffer().put(paramInt, paramShort);
    AppMethodBeat.o(61683);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.eclipsesource.mmv8.utils.typedarrays.Int16Array
 * JD-Core Version:    0.7.0.1
 */