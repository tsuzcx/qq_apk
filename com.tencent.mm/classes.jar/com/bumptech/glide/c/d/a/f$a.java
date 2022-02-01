package com.bumptech.glide.c.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

final class f$a
  implements f.c
{
  private final ByteBuffer byteBuffer;
  
  f$a(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(77362);
    this.byteBuffer = paramByteBuffer;
    paramByteBuffer.order(ByteOrder.BIG_ENDIAN);
    AppMethodBeat.o(77362);
  }
  
  public final int pb()
  {
    AppMethodBeat.i(77363);
    int i = pd();
    int j = pd();
    AppMethodBeat.o(77363);
    return i << 8 & 0xFF00 | j & 0xFF;
  }
  
  public final short pc()
  {
    AppMethodBeat.i(77364);
    short s = (short)(pd() & 0xFF);
    AppMethodBeat.o(77364);
    return s;
  }
  
  public final int pd()
  {
    AppMethodBeat.i(77367);
    if (this.byteBuffer.remaining() <= 0)
    {
      AppMethodBeat.o(77367);
      return -1;
    }
    int i = this.byteBuffer.get();
    AppMethodBeat.o(77367);
    return i;
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(77366);
    paramInt = Math.min(paramInt, this.byteBuffer.remaining());
    if (paramInt == 0)
    {
      AppMethodBeat.o(77366);
      return -1;
    }
    this.byteBuffer.get(paramArrayOfByte, 0, paramInt);
    AppMethodBeat.o(77366);
    return paramInt;
  }
  
  public final long skip(long paramLong)
  {
    AppMethodBeat.i(77365);
    int i = (int)Math.min(this.byteBuffer.remaining(), paramLong);
    this.byteBuffer.position(this.byteBuffer.position() + i);
    paramLong = i;
    AppMethodBeat.o(77365);
    return paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.bumptech.glide.c.d.a.f.a
 * JD-Core Version:    0.7.0.1
 */