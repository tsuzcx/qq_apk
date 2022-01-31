package com.google.android.exoplayer2.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class f
{
  private static final long[] aDX = { 128L, 64L, 32L, 16L, 8L, 4L, 2L, 1L };
  private final byte[] aCi;
  int length;
  private int state;
  
  public f()
  {
    AppMethodBeat.i(94917);
    this.aCi = new byte[8];
    AppMethodBeat.o(94917);
  }
  
  public static long b(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
  {
    long l2 = paramArrayOfByte[0] & 0xFF;
    long l1 = l2;
    if (paramBoolean) {
      l1 = l2 & (aDX[(paramInt - 1)] ^ 0xFFFFFFFF);
    }
    int i = 1;
    while (i < paramInt)
    {
      l1 = l1 << 8 | paramArrayOfByte[i] & 0xFF;
      i += 1;
    }
    return l1;
  }
  
  public static int dr(int paramInt)
  {
    int i = 0;
    while (i < aDX.length)
    {
      if ((aDX[i] & paramInt) != 0L) {
        return i + 1;
      }
      i += 1;
    }
    return -1;
  }
  
  public final long a(com.google.android.exoplayer2.c.f paramf, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    AppMethodBeat.i(94918);
    if (this.state == 0)
    {
      if (!paramf.a(this.aCi, 0, 1, paramBoolean1))
      {
        AppMethodBeat.o(94918);
        return -1L;
      }
      this.length = dr(this.aCi[0] & 0xFF);
      if (this.length == -1)
      {
        paramf = new IllegalStateException("No valid varint length mask found");
        AppMethodBeat.o(94918);
        throw paramf;
      }
      this.state = 1;
    }
    if (this.length > paramInt)
    {
      this.state = 0;
      AppMethodBeat.o(94918);
      return -2L;
    }
    if (this.length != 1) {
      paramf.readFully(this.aCi, 1, this.length - 1);
    }
    this.state = 0;
    long l = b(this.aCi, this.length, paramBoolean2);
    AppMethodBeat.o(94918);
    return l;
  }
  
  public final void reset()
  {
    this.state = 0;
    this.length = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.exoplayer2.c.b.f
 * JD-Core Version:    0.7.0.1
 */