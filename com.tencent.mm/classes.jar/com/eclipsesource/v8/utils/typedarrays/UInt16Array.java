package com.eclipsesource.v8.utils.typedarrays;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ShortBuffer;

public class UInt16Array
  extends TypedArray
{
  public UInt16Array(ArrayBuffer paramArrayBuffer)
  {
    this(paramArrayBuffer.getByteBuffer());
    AppMethodBeat.i(61692);
    AppMethodBeat.o(61692);
  }
  
  public UInt16Array(ByteBuffer paramByteBuffer)
  {
    super(paramByteBuffer);
  }
  
  public int get(int paramInt)
  {
    AppMethodBeat.i(61693);
    paramInt = this.buffer.asShortBuffer().get(paramInt);
    AppMethodBeat.o(61693);
    return 0xFFFF & paramInt;
  }
  
  public int getType()
  {
    return 14;
  }
  
  public int length()
  {
    AppMethodBeat.i(61694);
    int i = this.buffer.asShortBuffer().limit();
    AppMethodBeat.o(61694);
    return i;
  }
  
  public void put(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(61695);
    this.buffer.asShortBuffer().put(paramInt1, (short)(0xFFFF & paramInt2));
    AppMethodBeat.o(61695);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.eclipsesource.v8.utils.typedarrays.UInt16Array
 * JD-Core Version:    0.7.0.1
 */