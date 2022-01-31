package com.google.android.exoplayer2.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

final class j
  implements d
{
  private int awU = -1;
  private int azR = -1;
  private boolean azU;
  private ByteBuffer azt = ayo;
  private ByteBuffer buffer = ayo;
  private int encoding = 0;
  
  public final void c(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(94720);
    int i = paramByteBuffer.position();
    int m = paramByteBuffer.limit();
    int j = m - i;
    switch (this.encoding)
    {
    default: 
      paramByteBuffer = new IllegalStateException();
      AppMethodBeat.o(94720);
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
        AppMethodBeat.o(94720);
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
        this.azt = this.buffer;
        AppMethodBeat.o(94720);
        return;
      }
    }
  }
  
  public final void flush()
  {
    this.azt = ayo;
    this.azU = false;
  }
  
  public final boolean isActive()
  {
    return (this.encoding != 0) && (this.encoding != 2);
  }
  
  public final boolean nd()
  {
    return (this.azU) && (this.azt == ayo);
  }
  
  public final int ni()
  {
    return this.awU;
  }
  
  public final void nj()
  {
    this.azU = true;
  }
  
  public final ByteBuffer nk()
  {
    ByteBuffer localByteBuffer = this.azt;
    this.azt = ayo;
    return localByteBuffer;
  }
  
  public final boolean q(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(94719);
    if ((paramInt3 != 3) && (paramInt3 != 2) && (paramInt3 != -2147483648) && (paramInt3 != 1073741824))
    {
      d.a locala = new d.a(paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(94719);
      throw locala;
    }
    if ((this.azR == paramInt1) && (this.awU == paramInt2) && (this.encoding == paramInt3))
    {
      AppMethodBeat.o(94719);
      return false;
    }
    this.azR = paramInt1;
    this.awU = paramInt2;
    this.encoding = paramInt3;
    if (paramInt3 == 2) {
      this.buffer = ayo;
    }
    AppMethodBeat.o(94719);
    return true;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(94721);
    flush();
    this.buffer = ayo;
    this.azR = -1;
    this.awU = -1;
    this.encoding = 0;
    AppMethodBeat.o(94721);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.exoplayer2.a.j
 * JD-Core Version:    0.7.0.1
 */