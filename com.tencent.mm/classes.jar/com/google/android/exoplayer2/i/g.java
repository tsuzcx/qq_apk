package com.google.android.exoplayer2.i;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g
{
  public final int bcw;
  public final int bqJ;
  public final int bqK;
  public final int bqL;
  public final int bqM;
  public final long bqN;
  public final int channels;
  public final int sampleRate;
  
  public g(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(93135);
    paramArrayOfByte = new l(paramArrayOfByte);
    paramArrayOfByte.setPosition(136);
    this.bqJ = paramArrayOfByte.eA(16);
    this.bqK = paramArrayOfByte.eA(16);
    this.bqL = paramArrayOfByte.eA(24);
    this.bqM = paramArrayOfByte.eA(24);
    this.sampleRate = paramArrayOfByte.eA(20);
    this.channels = (paramArrayOfByte.eA(3) + 1);
    this.bcw = (paramArrayOfByte.eA(5) + 1);
    long l = paramArrayOfByte.eA(4);
    this.bqN = (paramArrayOfByte.eA(32) & 0xFFFFFFFF | (l & 0xF) << 32);
    AppMethodBeat.o(93135);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.i.g
 * JD-Core Version:    0.7.0.1
 */