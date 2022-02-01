package com.google.android.exoplayer2.i;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g
{
  public final int bHa;
  public final int bHb;
  public final int bHc;
  public final int bHd;
  public final long bHe;
  public final int bsU;
  public final int channels;
  public final int sampleRate;
  
  public g(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(93135);
    paramArrayOfByte = new l(paramArrayOfByte);
    paramArrayOfByte.setPosition(136);
    this.bHa = paramArrayOfByte.em(16);
    this.bHb = paramArrayOfByte.em(16);
    this.bHc = paramArrayOfByte.em(24);
    this.bHd = paramArrayOfByte.em(24);
    this.sampleRate = paramArrayOfByte.em(20);
    this.channels = (paramArrayOfByte.em(3) + 1);
    this.bsU = (paramArrayOfByte.em(5) + 1);
    long l = paramArrayOfByte.em(4);
    this.bHe = (paramArrayOfByte.em(32) & 0xFFFFFFFF | (l & 0xF) << 32);
    AppMethodBeat.o(93135);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.i.g
 * JD-Core Version:    0.7.0.1
 */