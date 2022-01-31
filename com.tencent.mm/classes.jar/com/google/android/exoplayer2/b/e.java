package com.google.android.exoplayer2.b;

import java.nio.ByteBuffer;

public class e
  extends a
{
  public final b ayC = new b();
  public ByteBuffer ayD;
  public long ayE;
  public final int ayF;
  
  public e(int paramInt)
  {
    this.ayF = paramInt;
  }
  
  private ByteBuffer cJ(int paramInt)
  {
    if (this.ayF == 1) {
      return ByteBuffer.allocate(paramInt);
    }
    if (this.ayF == 2) {
      return ByteBuffer.allocateDirect(paramInt);
    }
    if (this.ayD == null) {}
    for (int i = 0;; i = this.ayD.capacity()) {
      throw new IllegalStateException("Buffer too small (" + i + " < " + paramInt + ")");
    }
  }
  
  public final void cI(int paramInt)
  {
    if (this.ayD == null) {
      this.ayD = cJ(paramInt);
    }
    int i;
    int j;
    do
    {
      return;
      i = this.ayD.capacity();
      j = this.ayD.position();
      paramInt = j + paramInt;
    } while (i >= paramInt);
    ByteBuffer localByteBuffer = cJ(paramInt);
    if (j > 0)
    {
      this.ayD.position(0);
      this.ayD.limit(j);
      localByteBuffer.put(this.ayD);
    }
    this.ayD = localByteBuffer;
  }
  
  public final void clear()
  {
    super.clear();
    if (this.ayD != null) {
      this.ayD.clear();
    }
  }
  
  public final boolean lE()
  {
    return cH(1073741824);
  }
  
  public final void lF()
  {
    this.ayD.flip();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.b.e
 * JD-Core Version:    0.7.0.1
 */