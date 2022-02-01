package com.eclipsesource.v8.utils.typedarrays;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

public class UInt8Array
  extends TypedArray
{
  public UInt8Array(ArrayBuffer paramArrayBuffer)
  {
    this(paramArrayBuffer.getByteBuffer());
    AppMethodBeat.i(61700);
    AppMethodBeat.o(61700);
  }
  
  public UInt8Array(ByteBuffer paramByteBuffer)
  {
    super(paramByteBuffer);
  }
  
  public short get(int paramInt)
  {
    AppMethodBeat.i(61701);
    short s = (short)(this.buffer.get(paramInt) & 0xFF);
    AppMethodBeat.o(61701);
    return s;
  }
  
  public int getType()
  {
    return 11;
  }
  
  public int length()
  {
    AppMethodBeat.i(61702);
    int i = this.buffer.limit();
    AppMethodBeat.o(61702);
    return i;
  }
  
  public void put(int paramInt, short paramShort)
  {
    AppMethodBeat.i(61703);
    this.buffer.put(paramInt, (byte)(paramShort & 0xFF));
    AppMethodBeat.o(61703);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.eclipsesource.v8.utils.typedarrays.UInt8Array
 * JD-Core Version:    0.7.0.1
 */