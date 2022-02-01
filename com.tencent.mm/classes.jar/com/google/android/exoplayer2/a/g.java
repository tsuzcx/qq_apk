package com.google.android.exoplayer2.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

final class g
  implements d
{
  private int aVX = -1;
  int[] aVY;
  private int[] aVZ;
  private boolean aWa;
  private boolean active;
  private ByteBuffer buffer = aUx;
  private int channelCount = -1;
  private ByteBuffer outputBuffer = aUx;
  
  public final void f(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(91803);
    int i = paramByteBuffer.position();
    int k = paramByteBuffer.limit();
    int j = (k - i) / (this.channelCount * 2) * this.aVZ.length * 2;
    if (this.buffer.capacity() < j) {
      this.buffer = ByteBuffer.allocateDirect(j).order(ByteOrder.nativeOrder());
    }
    while (i < k)
    {
      int[] arrayOfInt = this.aVZ;
      int m = arrayOfInt.length;
      j = 0;
      for (;;)
      {
        if (j < m)
        {
          int n = arrayOfInt[j];
          this.buffer.putShort(paramByteBuffer.getShort(n * 2 + i));
          j += 1;
          continue;
          this.buffer.clear();
          break;
        }
      }
      i += this.channelCount * 2;
    }
    paramByteBuffer.position(k);
    this.buffer.flip();
    this.outputBuffer = this.buffer;
    AppMethodBeat.o(91803);
  }
  
  public final void flush()
  {
    this.outputBuffer = aUx;
    this.aWa = false;
  }
  
  public final boolean isActive()
  {
    return this.active;
  }
  
  public final boolean rX()
  {
    return (this.aWa) && (this.outputBuffer == aUx);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(91804);
    flush();
    this.buffer = aUx;
    this.channelCount = -1;
    this.aVX = -1;
    this.aVZ = null;
    this.active = false;
    AppMethodBeat.o(91804);
  }
  
  public final boolean s(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(91802);
    if (!Arrays.equals(this.aVY, this.aVZ)) {}
    for (int k = 1;; k = 0)
    {
      this.aVZ = this.aVY;
      if (this.aVZ != null) {
        break;
      }
      this.active = false;
      AppMethodBeat.o(91802);
      return k;
    }
    d.a locala;
    if (paramInt3 != 2)
    {
      locala = new d.a(paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(91802);
      throw locala;
    }
    if ((k == 0) && (this.aVX == paramInt1) && (this.channelCount == paramInt2))
    {
      AppMethodBeat.o(91802);
      return false;
    }
    this.aVX = paramInt1;
    this.channelCount = paramInt2;
    if (paramInt2 != this.aVZ.length) {}
    int i;
    for (k = 1;; k = 0)
    {
      this.active = k;
      i = 0;
      if (i >= this.aVZ.length) {
        break label231;
      }
      j = this.aVZ[i];
      if (j < paramInt2) {
        break;
      }
      locala = new d.a(paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(91802);
      throw locala;
    }
    k = this.active;
    if (j != i) {}
    for (int j = 1;; j = 0)
    {
      this.active = (j | k);
      i += 1;
      break;
    }
    label231:
    AppMethodBeat.o(91802);
    return true;
  }
  
  public final int sd()
  {
    if (this.aVZ == null) {
      return this.channelCount;
    }
    return this.aVZ.length;
  }
  
  public final void se()
  {
    this.aWa = true;
  }
  
  public final ByteBuffer sf()
  {
    ByteBuffer localByteBuffer = this.outputBuffer;
    this.outputBuffer = aUx;
    return localByteBuffer;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.a.g
 * JD-Core Version:    0.7.0.1
 */