package com.google.android.exoplayer2.i;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g
{
  public final int cWr;
  public final int channels;
  public final int dkn;
  public final int dko;
  public final int dkp;
  public final int dkq;
  public final long dkr;
  public final int sampleRate;
  
  public g(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(93135);
    paramArrayOfByte = new l(paramArrayOfByte);
    paramArrayOfByte.setPosition(136);
    this.dkn = paramArrayOfByte.hQ(16);
    this.dko = paramArrayOfByte.hQ(16);
    this.dkp = paramArrayOfByte.hQ(24);
    this.dkq = paramArrayOfByte.hQ(24);
    this.sampleRate = paramArrayOfByte.hQ(20);
    this.channels = (paramArrayOfByte.hQ(3) + 1);
    this.cWr = (paramArrayOfByte.hQ(5) + 1);
    long l = paramArrayOfByte.hQ(4);
    this.dkr = (paramArrayOfByte.hQ(32) & 0xFFFFFFFF | (l & 0xF) << 32);
    AppMethodBeat.o(93135);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.google.android.exoplayer2.i.g
 * JD-Core Version:    0.7.0.1
 */