package com.google.android.exoplayer2.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class f
{
  private static final long[] bab = { 128L, 64L, 32L, 16L, 8L, 4L, 2L, 1L };
  private final byte[] aYm;
  int length;
  private int state;
  
  public f()
  {
    AppMethodBeat.i(92032);
    this.aYm = new byte[8];
    AppMethodBeat.o(92032);
  }
  
  public static long a(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
  {
    long l2 = paramArrayOfByte[0] & 0xFF;
    long l1 = l2;
    if (paramBoolean) {
      l1 = l2 & (bab[(paramInt - 1)] ^ 0xFFFFFFFF);
    }
    int i = 1;
    while (i < paramInt)
    {
      l1 = l1 << 8 | paramArrayOfByte[i] & 0xFF;
      i += 1;
    }
    return l1;
  }
  
  public static int ec(int paramInt)
  {
    int i = 0;
    while (i < bab.length)
    {
      if ((bab[i] & paramInt) != 0L) {
        return i + 1;
      }
      i += 1;
    }
    return -1;
  }
  
  public final long a(com.google.android.exoplayer2.c.f paramf, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    AppMethodBeat.i(92033);
    if (this.state == 0)
    {
      if (!paramf.a(this.aYm, 0, 1, paramBoolean1))
      {
        AppMethodBeat.o(92033);
        return -1L;
      }
      this.length = ec(this.aYm[0] & 0xFF);
      if (this.length == -1)
      {
        paramf = new IllegalStateException("No valid varint length mask found");
        AppMethodBeat.o(92033);
        throw paramf;
      }
      this.state = 1;
    }
    if (this.length > paramInt)
    {
      this.state = 0;
      AppMethodBeat.o(92033);
      return -2L;
    }
    if (this.length != 1) {
      paramf.readFully(this.aYm, 1, this.length - 1);
    }
    this.state = 0;
    long l = a(this.aYm, this.length, paramBoolean2);
    AppMethodBeat.o(92033);
    return l;
  }
  
  public final void reset()
  {
    this.state = 0;
    this.length = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.c.b.f
 * JD-Core Version:    0.7.0.1
 */