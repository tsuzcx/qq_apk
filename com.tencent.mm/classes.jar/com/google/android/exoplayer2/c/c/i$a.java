package com.google.android.exoplayer2.c.c;

import java.util.Arrays;

final class i$a
{
  static final byte[] aDR = { 0, 0, 1 };
  boolean aDS;
  public int aDT;
  public byte[] data = new byte[''];
  public int length;
  
  public final void d(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (!this.aDS) {
      return;
    }
    paramInt2 -= paramInt1;
    if (this.data.length < this.length + paramInt2) {
      this.data = Arrays.copyOf(this.data, (this.length + paramInt2) * 2);
    }
    System.arraycopy(paramArrayOfByte, paramInt1, this.data, this.length, paramInt2);
    this.length = (paramInt2 + this.length);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.c.c.i.a
 * JD-Core Version:    0.7.0.1
 */