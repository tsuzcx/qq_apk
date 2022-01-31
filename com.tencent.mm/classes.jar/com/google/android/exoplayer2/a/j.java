package com.google.android.exoplayer2.a;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

final class j
  implements d
{
  private int auC = -1;
  private int axB = -1;
  private boolean axF;
  private ByteBuffer axd = avY;
  private ByteBuffer buffer = avY;
  private int encoding = 0;
  
  public final void c(ByteBuffer paramByteBuffer)
  {
    int i = paramByteBuffer.position();
    int m = paramByteBuffer.limit();
    int j = m - i;
    switch (this.encoding)
    {
    default: 
      throw new IllegalStateException();
    case 3: 
      j *= 2;
      label68:
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
        throw new IllegalStateException();
        j = j / 3 * 2;
        break label68;
        j /= 2;
        break label68;
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
        this.axd = this.buffer;
        return;
      }
    }
  }
  
  public final void flush()
  {
    this.axd = avY;
    this.axF = false;
  }
  
  public final boolean isActive()
  {
    return (this.encoding != 0) && (this.encoding != 2);
  }
  
  public final boolean kU()
  {
    return (this.axF) && (this.axd == avY);
  }
  
  public final int kZ()
  {
    return this.auC;
  }
  
  public final int la()
  {
    return 2;
  }
  
  public final void lb()
  {
    this.axF = true;
  }
  
  public final ByteBuffer lc()
  {
    ByteBuffer localByteBuffer = this.axd;
    this.axd = avY;
    return localByteBuffer;
  }
  
  public final boolean q(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt3 != 3) && (paramInt3 != 2) && (paramInt3 != -2147483648) && (paramInt3 != 1073741824)) {
      throw new d.a(paramInt1, paramInt2, paramInt3);
    }
    if ((this.axB == paramInt1) && (this.auC == paramInt2) && (this.encoding == paramInt3)) {
      return false;
    }
    this.axB = paramInt1;
    this.auC = paramInt2;
    this.encoding = paramInt3;
    if (paramInt3 == 2) {
      this.buffer = avY;
    }
    return true;
  }
  
  public final void reset()
  {
    flush();
    this.buffer = avY;
    this.axB = -1;
    this.auC = -1;
    this.encoding = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.a.j
 * JD-Core Version:    0.7.0.1
 */