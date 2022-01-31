package com.eclipsesource.v8.utils.typedarrays;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

public class UInt8Array
  extends TypedArray
{
  public UInt8Array(ArrayBuffer paramArrayBuffer)
  {
    this(paramArrayBuffer.getByteBuffer());
    AppMethodBeat.i(75076);
    AppMethodBeat.o(75076);
  }
  
  public UInt8Array(ByteBuffer paramByteBuffer)
  {
    super(paramByteBuffer);
  }
  
  public short get(int paramInt)
  {
    AppMethodBeat.i(75077);
    short s = (short)(this.buffer.get(paramInt) & 0xFF);
    AppMethodBeat.o(75077);
    return s;
  }
  
  public int getType()
  {
    return 11;
  }
  
  public int length()
  {
    AppMethodBeat.i(75078);
    int i = this.buffer.limit();
    AppMethodBeat.o(75078);
    return i;
  }
  
  public void put(int paramInt, short paramShort)
  {
    AppMethodBeat.i(75079);
    this.buffer.put(paramInt, (byte)(paramShort & 0xFF));
    AppMethodBeat.o(75079);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.eclipsesource.v8.utils.typedarrays.UInt8Array
 * JD-Core Version:    0.7.0.1
 */