package com.eclipsesource.v8.utils.typedarrays;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

public class ArrayBuffer
{
  private ByteBuffer byteBuffer;
  
  public ArrayBuffer(int paramInt)
  {
    AppMethodBeat.i(75040);
    this.byteBuffer = ByteBuffer.allocateDirect(paramInt);
    AppMethodBeat.o(75040);
  }
  
  public ArrayBuffer(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(75042);
    this.byteBuffer = validateByteBuffer(paramByteBuffer);
    AppMethodBeat.o(75042);
  }
  
  public ArrayBuffer(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(75041);
    this.byteBuffer = ByteBuffer.allocateDirect(paramArrayOfByte.length);
    this.byteBuffer.put(paramArrayOfByte, 0, paramArrayOfByte.length);
    AppMethodBeat.o(75041);
  }
  
  private ByteBuffer validateByteBuffer(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(75043);
    if (!paramByteBuffer.isDirect())
    {
      paramByteBuffer = new IllegalArgumentException("ByteBuffer must be a allocated as a direct ByteBuffer");
      AppMethodBeat.o(75043);
      throw paramByteBuffer;
    }
    AppMethodBeat.o(75043);
    return paramByteBuffer;
  }
  
  public byte getByte(int paramInt)
  {
    AppMethodBeat.i(75044);
    byte b = this.byteBuffer.get(paramInt);
    AppMethodBeat.o(75044);
    return b;
  }
  
  public ByteBuffer getByteBuffer()
  {
    return this.byteBuffer;
  }
  
  public short getUnsignedByte(int paramInt)
  {
    AppMethodBeat.i(75045);
    short s = (short)(this.byteBuffer.get(paramInt) & 0xFF);
    AppMethodBeat.o(75045);
    return s;
  }
  
  public int limit()
  {
    AppMethodBeat.i(75047);
    int i = this.byteBuffer.limit();
    AppMethodBeat.o(75047);
    return i;
  }
  
  public void put(int paramInt, byte paramByte)
  {
    AppMethodBeat.i(75046);
    this.byteBuffer.put(paramInt, paramByte);
    AppMethodBeat.o(75046);
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