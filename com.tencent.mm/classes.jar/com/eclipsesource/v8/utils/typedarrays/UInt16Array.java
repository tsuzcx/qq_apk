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
    AppMethodBeat.i(75068);
    AppMethodBeat.o(75068);
  }
  
  public UInt16Array(ByteBuffer paramByteBuffer)
  {
    super(paramByteBuffer);
  }
  
  public int get(int paramInt)
  {
    AppMethodBeat.i(75069);
    paramInt = this.buffer.asShortBuffer().get(paramInt);
    AppMethodBeat.o(75069);
    return 0xFFFF & paramInt;
  }
  
  public int getType()
  {
    return 14;
  }
  
  public int length()
  {
    AppMethodBeat.i(75070);
    int i = this.buffer.asShortBuffer().limit();
    AppMethodBeat.o(75070);
    return i;
  }
  
  public void put(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(75071);
    this.buffer.asShortBuffer().put(paramInt1, (short)(0xFFFF & paramInt2));
    AppMethodBeat.o(75071);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.eclipsesource.v8.utils.typedarrays.UInt16Array
 * JD-Core Version:    0.7.0.1
 */