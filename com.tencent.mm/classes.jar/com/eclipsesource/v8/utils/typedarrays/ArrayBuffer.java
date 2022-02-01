package com.eclipsesource.v8.utils.typedarrays;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

public class ArrayBuffer
{
  private ByteBuffer byteBuffer;
  
  public ArrayBuffer(int paramInt)
  {
    AppMethodBeat.i(61664);
    this.byteBuffer = ByteBuffer.allocateDirect(paramInt);
    AppMethodBeat.o(61664);
  }
  
  public ArrayBuffer(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(61666);
    this.byteBuffer = validateByteBuffer(paramByteBuffer);
    AppMethodBeat.o(61666);
  }
  
  public ArrayBuffer(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(61665);
    this.byteBuffer = ByteBuffer.allocateDirect(paramArrayOfByte.length);
    this.byteBuffer.put(paramArrayOfByte, 0, paramArrayOfByte.length);
    AppMethodBeat.o(61665);
  }
  
  private ByteBuffer validateByteBuffer(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(61667);
    if (!paramByteBuffer.isDirect())
    {
      paramByteBuffer = new IllegalArgumentException("ByteBuffer must be a allocated as a direct ByteBuffer");
      AppMethodBeat.o(61667);
      throw paramByteBuffer;
    }
    AppMethodBeat.o(61667);
    return paramByteBuffer;
  }
  
  public byte getByte(int paramInt)
  {
    AppMethodBeat.i(61668);
    byte b = this.byteBuffer.get(paramInt);
    AppMethodBeat.o(61668);
    return b;
  }
  
  public ByteBuffer getByteBuffer()
  {
    return this.byteBuffer;
  }
  
  public short getUnsignedByte(int paramInt)
  {
    AppMethodBeat.i(61669);
    short s = (short)(this.byteBuffer.get(paramInt) & 0xFF);
    AppMethodBeat.o(61669);
    return s;
  }
  
  public int limit()
  {
    AppMethodBeat.i(61671);
    int i = this.byteBuffer.limit();
    AppMethodBeat.o(61671);
    return i;
  }
  
  public void put(int paramInt, byte paramByte)
  {
    AppMethodBeat.i(61670);
    this.byteBuffer.put(paramInt, paramByte);
    AppMethodBeat.o(61670);
  }
  
  public String toString()
  {
    return "[object ArrayBuffer]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.eclipsesource.v8.utils.typedarrays.ArrayBuffer
 * JD-Core Version:    0.7.0.1
 */