package com.eclipsesource.v8.utils.typedarrays;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

public class Int8Array
  extends TypedArray
{
  public Int8Array(ArrayBuffer paramArrayBuffer)
  {
    this(paramArrayBuffer.getByteBuffer());
    AppMethodBeat.i(75064);
    AppMethodBeat.o(75064);
  }
  
  public Int8Array(ByteBuffer paramByteBuffer)
  {
    super(paramByteBuffer);
  }
  
  public byte get(int paramInt)
  {
    AppMethodBeat.i(75065);
    byte b = this.buffer.get(paramInt);
    AppMethodBeat.o(75065);
    return b;
  }
  
  public int getType()
  {
    return 9;
  }
  
  public int length()
  {
    AppMethodBeat.i(75066);
    int i = this.buffer.limit();
    AppMethodBeat.o(75066);
    return i;
  }
  
  public void put(int paramInt, byte paramByte)
  {
    AppMethodBeat.i(75067);
    this.buffer.put(paramInt, paramByte);
    AppMethodBeat.o(75067);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.eclipsesource.v8.utils.typedarrays.Int8Array
 * JD-Core Version:    0.7.0.1
 */