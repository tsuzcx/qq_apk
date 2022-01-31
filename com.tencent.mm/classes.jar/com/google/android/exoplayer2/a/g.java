package com.google.android.exoplayer2.a;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

final class g
  implements d
{
  private int auC = -1;
  private int axB = -1;
  int[] axC;
  private boolean axD;
  private int[] axE;
  private boolean axF;
  private ByteBuffer axd = avY;
  private ByteBuffer buffer = avY;
  
  public final void c(ByteBuffer paramByteBuffer)
  {
    int i = paramByteBuffer.position();
    int k = paramByteBuffer.limit();
    int j = (k - i) / (this.auC * 2) * this.axE.length * 2;
    if (this.buffer.capacity() < j) {
      this.buffer = ByteBuffer.allocateDirect(j).order(ByteOrder.nativeOrder());
    }
    while (i < k)
    {
      int[] arrayOfInt = this.axE;
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
      i += this.auC * 2;
    }
    paramByteBuffer.position(k);
    this.buffer.flip();
    this.axd = this.buffer;
  }
  
  public final void flush()
  {
    this.axd = avY;
    this.axF = false;
  }
  
  public final boolean isActive()
  {
    return this.axD;
  }
  
  public final boolean kU()
  {
    return (this.axF) && (this.axd == avY);
  }
  
  public final int kZ()
  {
    if (this.axE == null) {
      return this.auC;
    }
    return this.axE.length;
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
    if (!Arrays.equals(this.axC, this.axE)) {}
    for (int k = 1;; k = 0)
    {
      this.axE = this.axC;
      if (this.axE != null) {
        break;
      }
      this.axD = false;
      return k;
    }
    if (paramInt3 != 2) {
      throw new d.a(paramInt1, paramInt2, paramInt3);
    }
    if ((k == 0) && (this.axB == paramInt1) && (this.auC == paramInt2)) {
      return false;
    }
    this.axB = paramInt1;
    this.auC = paramInt2;
    if (paramInt2 != this.axE.length) {}
    int i;
    for (k = 1;; k = 0)
    {
      this.axD = k;
      i = 0;
      if (i >= this.axE.length) {
        break label198;
      }
      j = this.axE[i];
      if (j < paramInt2) {
        break;
      }
      throw new d.a(paramInt1, paramInt2, paramInt3);
    }
    k = this.axD;
    if (j != i) {}
    for (int j = 1;; j = 0)
    {
      this.axD = (j | k);
      i += 1;
      break;
    }
    label198:
    return true;
  }
  
  public final void reset()
  {
    flush();
    this.buffer = avY;
    this.auC = -1;
    this.axB = -1;
    this.axE = null;
    this.axD = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.a.g
 * JD-Core Version:    0.7.0.1
 */