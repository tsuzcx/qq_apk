package com.google.android.exoplayer2.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

final class j
  implements d
{
  private int bgs = -1;
  private boolean bgv;
  private ByteBuffer buffer = beR;
  private int channelCount = -1;
  private int encoding = 0;
  private ByteBuffer outputBuffer = beR;
  
  public final void f(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(91831);
    int i = paramByteBuffer.position();
    int m = paramByteBuffer.limit();
    int j = m - i;
    switch (this.encoding)
    {
    default: 
      paramByteBuffer = new IllegalStateException();
      AppMethodBeat.o(91831);
      throw paramByteBuffer;
    case 3: 
      j *= 2;
      label79:
      if (this.buffer.capacity() < j) {
        this.buffer = ByteBuffer.allocateDirect(j).order(ByteOrder.nativeOrder());
      }
      break;
    }
    int k;
    for (;;)
    {
      j = i;
      k = i;
      switch (this.encoding)
      {
      default: 
        paramByteBuffer = new IllegalStateException();
        AppMethodBeat.o(91831);
        throw paramByteBuffer;
        j = j / 3 * 2;
        break label79;
        j /= 2;
        break label79;
        this.buffer.clear();
      }
    }
    while (j < m)
    {
      this.buffer.put((byte)0);
      this.buffer.put((byte)((paramByteBuffer.get(j) & 0xFF) - 128));
      j += 1;
      continue;
      while (k < m)
      {
        this.buffer.put(paramByteBuffer.get(k + 1));
        this.buffer.put(paramByteBuffer.get(k + 2));
        k += 3;
      }
    }
    for (;;)
    {
      if (i < m)
      {
        this.buffer.put(paramByteBuffer.get(i + 2));
        this.buffer.put(paramByteBuffer.get(i + 3));
        i += 4;
      }
      else
      {
        paramByteBuffer.position(paramByteBuffer.limit());
        this.buffer.flip();
        this.outputBuffer = this.buffer;
        AppMethodBeat.o(91831);
        return;
      }
    }
  }
  
  public final void flush()
  {
    this.outputBuffer = beR;
    this.bgv = false;
  }
  
  public final boolean isActive()
  {
    return (this.encoding != 0) && (this.encoding != 2);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(91832);
    flush();
    this.buffer = beR;
    this.bgs = -1;
    this.channelCount = -1;
    this.encoding = 0;
    AppMethodBeat.o(91832);
  }
  
  public final boolean s(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(91830);
    if ((paramInt3 != 3) && (paramInt3 != 2) && (paramInt3 != -2147483648) && (paramInt3 != 1073741824))
    {
      d.a locala = new d.a(paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(91830);
      throw locala;
    }
    if ((this.bgs == paramInt1) && (this.channelCount == paramInt2) && (this.encoding == paramInt3))
    {
      AppMethodBeat.o(91830);
      return false;
    }
    this.bgs = paramInt1;
    this.channelCount = paramInt2;
    this.encoding = paramInt3;
    if (paramInt3 == 2) {
      this.buffer = beR;
    }
    AppMethodBeat.o(91830);
    return true;
  }
  
  public final int tC()
  {
    return this.channelCount;
  }
  
  public final void tD()
  {
    this.bgv = true;
  }
  
  public final ByteBuffer tE()
  {
    ByteBuffer localByteBuffer = this.outputBuffer;
    this.outputBuffer = beR;
    return localByteBuffer;
  }
  
  public final boolean tw()
  {
    return (this.bgv) && (this.outputBuffer == beR);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.a.j
 * JD-Core Version:    0.7.0.1
 */