package com.eclipsesource.v8.utils.typedarrays;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

public class Int8Array
  extends TypedArray
{
  public Int8Array(ArrayBuffer paramArrayBuffer)
  {
    this(paramArrayBuffer.getByteBuffer());
    AppMethodBeat.i(61688);
    AppMethodBeat.o(61688);
  }
  
  public Int8Array(ByteBuffer paramByteBuffer)
  {
    super(paramByteBuffer);
  }
  
  public byte get(int paramInt)
  {
    AppMethodBeat.i(61689);
    byte b = this.buffer.get(paramInt);
    AppMethodBeat.o(61689);
    return b;
  }
  
  public int getType()
  {
    return 9;
  }
  
  public int length()
  {
    AppMethodBeat.i(61690);
    int i = this.buffer.limit();
    AppMethodBeat.o(61690);
    return i;
  }
  
  public void put(int paramInt, byte paramByte)
  {
    AppMethodBeat.i(61691);
    this.buffer.put(paramInt, paramByte);
    AppMethodBeat.o(61691);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.eclipsesource.v8.utils.typedarrays.Int8Array
 * JD-Core Version:    0.7.0.1
 */