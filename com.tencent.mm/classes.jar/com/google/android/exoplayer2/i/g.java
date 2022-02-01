package com.google.android.exoplayer2.i;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g
{
  public final int biF;
  public final int bwv;
  public final int bww;
  public final int bwx;
  public final int bwy;
  public final long bwz;
  public final int channels;
  public final int sampleRate;
  
  public g(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(93135);
    paramArrayOfByte = new l(paramArrayOfByte);
    paramArrayOfByte.setPosition(136);
    this.bwv = paramArrayOfByte.eo(16);
    this.bww = paramArrayOfByte.eo(16);
    this.bwx = paramArrayOfByte.eo(24);
    this.bwy = paramArrayOfByte.eo(24);
    this.sampleRate = paramArrayOfByte.eo(20);
    this.channels = (paramArrayOfByte.eo(3) + 1);
    this.biF = (paramArrayOfByte.eo(5) + 1);
    long l = paramArrayOfByte.eo(4);
    this.bwz = (paramArrayOfByte.eo(32) & 0xFFFFFFFF | (l & 0xF) << 32);
    AppMethodBeat.o(93135);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.i.g
 * JD-Core Version:    0.7.0.1
 */