package com.google.android.exoplayer2.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

final class g
  implements d
{
  private int aPP = -1;
  int[] aPQ;
  private int[] aPR;
  private boolean aPS;
  private boolean active;
  private ByteBuffer buffer = aOp;
  private int channelCount = -1;
  private ByteBuffer outputBuffer = aOp;
  
  public final void c(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(91803);
    int i = paramByteBuffer.position();
    int k = paramByteBuffer.limit();
    int j = (k - i) / (this.channelCount * 2) * this.aPR.length * 2;
    if (this.buffer.capacity() < j) {
      this.buffer = ByteBuffer.allocateDirect(j).order(ByteOrder.nativeOrder());
    }
    while (i < k)
    {
      int[] arrayOfInt = this.aPR;
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
    this.outputBuffer = aOp;
    this.aPS = false;
  }
  
  public final boolean isActive()
  {
    return this.active;
  }
  
  public final boolean m(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(91802);
    if (!Arrays.equals(this.aPQ, this.aPR)) {}
    for (int k = 1;; k = 0)
    {
      this.aPR = this.aPQ;
      if (this.aPR != null) {
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
    if ((k == 0) && (this.aPP == paramInt1) && (this.channelCount == paramInt2))
    {
      AppMethodBeat.o(91802);
      return false;
    }
    this.aPP = paramInt1;
    this.channelCount = paramInt2;
    if (paramInt2 != this.aPR.length) {}
    int i;
    for (k = 1;; k = 0)
    {
      this.active = k;
      i = 0;
      if (i >= this.aPR.length) {
        break label231;
      }
      j = this.aPR[i];
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
  
  public final void rA()
  {
    this.aPS = true;
  }
  
  public final ByteBuffer rB()
  {
    ByteBuffer localByteBuffer = this.outputBuffer;
    this.outputBuffer = aOp;
    return localByteBuffer;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(91804);
    flush();
    this.buffer = aOp;
    this.channelCount = -1;
    this.aPP = -1;
    this.aPR = null;
    this.active = false;
    AppMethodBeat.o(91804);
  }
  
  public final boolean rt()
  {
    return (this.aPS) && (this.outputBuffer == aOp);
  }
  
  public final int rz()
  {
    if (this.aPR == null) {
      return this.channelCount;
    }
    return this.aPR.length;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.a.g
 * JD-Core Version:    0.7.0.1
 */