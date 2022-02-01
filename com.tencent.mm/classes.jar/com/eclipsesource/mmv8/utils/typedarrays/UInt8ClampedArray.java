package com.eclipsesource.mmv8.utils.typedarrays;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

public class UInt8ClampedArray
  extends TypedArray
{
  public UInt8ClampedArray(ArrayBuffer paramArrayBuffer)
  {
    this(paramArrayBuffer.getByteBuffer());
    AppMethodBeat.i(61704);
    AppMethodBeat.o(61704);
  }
  
  public UInt8ClampedArray(ByteBuffer paramByteBuffer)
  {
    super(paramByteBuffer);
  }
  
  public short get(int paramInt)
  {
    AppMethodBeat.i(61705);
    short s = (short)(this.buffer.get(paramInt) & 0xFF);
    AppMethodBeat.o(61705);
    return s;
  }
  
  public int getType()
  {
    return 12;
  }
  
  public int length()
  {
    AppMethodBeat.i(61706);
    int i = this.buffer.limit();
    AppMethodBeat.o(61706);
    return i;
  }
  
  public void put(int paramInt, short paramShort)
  {
    AppMethodBeat.i(61707);
    if (paramShort > 255)
    {
      this.buffer.put(paramInt, (byte)-1);
      AppMethodBeat.o(61707);
      return;
    }
    if (paramShort < 0)
    {
      this.buffer.put(paramInt, (byte)0);
      AppMethodBeat.o(61707);
      return;
    }
    this.buffer.put(paramInt, (byte)paramShort);
    AppMethodBeat.o(61707);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.eclipsesource.mmv8.utils.typedarrays.UInt8ClampedArray
 * JD-Core Version:    0.7.0.1
 */