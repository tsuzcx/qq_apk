package com.google.android.exoplayer2.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

final class g
  implements d
{
  private boolean active;
  private int awU = -1;
  private int azR = -1;
  int[] azS;
  private int[] azT;
  private boolean azU;
  private ByteBuffer azt = ayo;
  private ByteBuffer buffer = ayo;
  
  public final void c(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(94692);
    int i = paramByteBuffer.position();
    int k = paramByteBuffer.limit();
    int j = (k - i) / (this.awU * 2) * this.azT.length * 2;
    if (this.buffer.capacity() < j) {
      this.buffer = ByteBuffer.allocateDirect(j).order(ByteOrder.nativeOrder());
    }
    while (i < k)
    {
      int[] arrayOfInt = this.azT;
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
      i += this.awU * 2;
    }
    paramByteBuffer.position(k);
    this.buffer.flip();
    this.azt = this.buffer;
    AppMethodBeat.o(94692);
  }
  
  public final void flush()
  {
    this.azt = ayo;
    this.azU = false;
  }
  
  public final boolean isActive()
  {
    return this.active;
  }
  
  public final boolean nd()
  {
    return (this.azU) && (this.azt == ayo);
  }
  
  public final int ni()
  {
    if (this.azT == null) {
      return this.awU;
    }
    return this.azT.length;
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
    AppMethodBeat.i(94691);
    if (!Arrays.equals(this.azS, this.azT)) {}
    for (int k = 1;; k = 0)
    {
      this.azT = this.azS;
      if (this.azT != null) {
        break;
      }
      this.active = false;
      AppMethodBeat.o(94691);
      return k;
    }
    d.a locala;
    if (paramInt3 != 2)
    {
      locala = new d.a(paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(94691);
      throw locala;
    }
    if ((k == 0) && (this.azR == paramInt1) && (this.awU == paramInt2))
    {
      AppMethodBeat.o(94691);
      return false;
    }
    this.azR = paramInt1;
    this.awU = paramInt2;
    if (paramInt2 != this.azT.length) {}
    int i;
    for (k = 1;; k = 0)
    {
      this.active = k;
      i = 0;
      if (i >= this.azT.length) {
        break label231;
      }
      j = this.azT[i];
      if (j < paramInt2) {
        break;
      }
      locala = new d.a(paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(94691);
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
    AppMethodBeat.o(94691);
    return true;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(94693);
    flush();
    this.buffer = ayo;
    this.awU = -1;
    this.azR = -1;
    this.azT = null;
    this.active = false;
    AppMethodBeat.o(94693);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.a.g
 * JD-Core Version:    0.7.0.1
 */