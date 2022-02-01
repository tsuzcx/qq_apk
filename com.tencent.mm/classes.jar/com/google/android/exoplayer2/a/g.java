package com.google.android.exoplayer2.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

final class g
  implements d
{
  private int aVk = -1;
  int[] aVl;
  private int[] aVm;
  private boolean aVn;
  private boolean active;
  private ByteBuffer buffer = aTH;
  private int channelCount = -1;
  private ByteBuffer outputBuffer = aTH;
  
  public final void f(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(91803);
    int i = paramByteBuffer.position();
    int k = paramByteBuffer.limit();
    int j = (k - i) / (this.channelCount * 2) * this.aVm.length * 2;
    if (this.buffer.capacity() < j) {
      this.buffer = ByteBuffer.allocateDirect(j).order(ByteOrder.nativeOrder());
    }
    while (i < k)
    {
      int[] arrayOfInt = this.aVm;
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
    this.outputBuffer = aTH;
    this.aVn = false;
  }
  
  public final boolean isActive()
  {
    return this.active;
  }
  
  public final boolean rM()
  {
    return (this.aVn) && (this.outputBuffer == aTH);
  }
  
  public final int rU()
  {
    if (this.aVm == null) {
      return this.channelCount;
    }
    return this.aVm.length;
  }
  
  public final void rV()
  {
    this.aVn = true;
  }
  
  public final ByteBuffer rW()
  {
    ByteBuffer localByteBuffer = this.outputBuffer;
    this.outputBuffer = aTH;
    return localByteBuffer;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(91804);
    flush();
    this.buffer = aTH;
    this.channelCount = -1;
    this.aVk = -1;
    this.aVm = null;
    this.active = false;
    AppMethodBeat.o(91804);
  }
  
  public final boolean s(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(91802);
    if (!Arrays.equals(this.aVl, this.aVm)) {}
    for (int k = 1;; k = 0)
    {
      this.aVm = this.aVl;
      if (this.aVm != null) {
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
    if ((k == 0) && (this.aVk == paramInt1) && (this.channelCount == paramInt2))
    {
      AppMethodBeat.o(91802);
      return false;
    }
    this.aVk = paramInt1;
    this.channelCount = paramInt2;
    if (paramInt2 != this.aVm.length) {}
    int i;
    for (k = 1;; k = 0)
    {
      this.active = k;
      i = 0;
      if (i >= this.aVm.length) {
        break label231;
      }
      j = this.aVm[i];
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.a.g
 * JD-Core Version:    0.7.0.1
 */