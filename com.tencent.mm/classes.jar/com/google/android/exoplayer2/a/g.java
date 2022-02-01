package com.google.android.exoplayer2.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

final class g
  implements d
{
  private boolean active;
  private ByteBuffer buffer = cIl;
  private int cJL = -1;
  int[] cJM;
  private int[] cJN;
  private boolean cJO;
  private int channelCount = -1;
  private ByteBuffer outputBuffer = cIl;
  
  public final boolean C(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(91802);
    if (!Arrays.equals(this.cJM, this.cJN)) {}
    for (int k = 1;; k = 0)
    {
      this.cJN = this.cJM;
      if (this.cJN != null) {
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
    if ((k == 0) && (this.cJL == paramInt1) && (this.channelCount == paramInt2))
    {
      AppMethodBeat.o(91802);
      return false;
    }
    this.cJL = paramInt1;
    this.channelCount = paramInt2;
    if (paramInt2 != this.cJN.length) {}
    int i;
    for (k = 1;; k = 0)
    {
      this.active = k;
      i = 0;
      if (i >= this.cJN.length) {
        break label231;
      }
      j = this.cJN[i];
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
  
  public final boolean QU()
  {
    return (this.cJO) && (this.outputBuffer == cIl);
  }
  
  public final int Rb()
  {
    if (this.cJN == null) {
      return this.channelCount;
    }
    return this.cJN.length;
  }
  
  public final int Rc()
  {
    return 2;
  }
  
  public final void Rd()
  {
    this.cJO = true;
  }
  
  public final ByteBuffer Re()
  {
    ByteBuffer localByteBuffer = this.outputBuffer;
    this.outputBuffer = cIl;
    return localByteBuffer;
  }
  
  public final void d(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(91803);
    int i = paramByteBuffer.position();
    int k = paramByteBuffer.limit();
    int j = (k - i) / (this.channelCount * 2) * this.cJN.length * 2;
    if (this.buffer.capacity() < j) {
      this.buffer = ByteBuffer.allocateDirect(j).order(ByteOrder.nativeOrder());
    }
    while (i < k)
    {
      int[] arrayOfInt = this.cJN;
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
    this.outputBuffer = cIl;
    this.cJO = false;
  }
  
  public final boolean isActive()
  {
    return this.active;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(91804);
    flush();
    this.buffer = cIl;
    this.channelCount = -1;
    this.cJL = -1;
    this.cJN = null;
    this.active = false;
    AppMethodBeat.o(91804);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.a.g
 * JD-Core Version:    0.7.0.1
 */