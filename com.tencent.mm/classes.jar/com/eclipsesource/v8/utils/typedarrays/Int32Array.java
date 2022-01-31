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
    AppMethodBeat.i(75060);
    AppMethodBeat.o(75060);
  }
  
  public Int32Array(ByteBuffer paramByteBuffer)
  {
    super(paramByteBuffer);
  }
  
  public int get(int paramInt)
  {
    AppMethodBeat.i(75061);
    paramInt = this.buffer.asIntBuffer().get(paramInt);
    AppMethodBeat.o(75061);
    return paramInt;
  }
  
  public int getType()
  {
    return 1;
  }
  
  public int length()
  {
    AppMethodBeat.i(75062);
    int i = this.buffer.asIntBuffer().limit();
    AppMethodBeat.o(75062);
    return i;
  }
  
  public void put(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(75063);
    this.buffer.asIntBuffer().put(paramInt1, paramInt2);
    AppMethodBeat.o(75063);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.eclipsesource.v8.utils.typedarrays.Int32Array
 * JD-Core Version:    0.7.0.1
 */