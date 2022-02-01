package com.eclipsesource.v8.utils.typedarrays;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;

public class Int32Array
  extends TypedArray
{
  public Int32Array(ArrayBuffer paramArrayBuffer)
  {
    this(paramArrayBuffer.getByteBuffer());
    AppMethodBeat.i(61684);
    AppMethodBeat.o(61684);
  }
  
  public Int32Array(ByteBuffer paramByteBuffer)
  {
    super(paramByteBuffer);
  }
  
  public int get(int paramInt)
  {
    AppMethodBeat.i(61685);
    paramInt = this.buffer.asIntBuffer().get(paramInt);
    AppMethodBeat.o(61685);
    return paramInt;
  }
  
  public int getType()
  {
    return 1;
  }
  
  public int length()
  {
    AppMethodBeat.i(61686);
    int i = this.buffer.asIntBuffer().limit();
    AppMethodBeat.o(61686);
    return i;
  }
  
  public void put(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(61687);
    this.buffer.asIntBuffer().put(paramInt1, paramInt2);
    AppMethodBeat.o(61687);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.eclipsesource.v8.utils.typedarrays.Int32Array
 * JD-Core Version:    0.7.0.1
 */