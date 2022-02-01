package com.google.android.exoplayer2.i;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g
{
  public final int bia;
  public final int byN;
  public final int byO;
  public final int byP;
  public final int byQ;
  public final long byR;
  public final int channels;
  public final int sampleRate;
  
  public g(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(93135);
    paramArrayOfByte = new l(paramArrayOfByte);
    paramArrayOfByte.setPosition(136);
    this.byN = paramArrayOfByte.eo(16);
    this.byO = paramArrayOfByte.eo(16);
    this.byP = paramArrayOfByte.eo(24);
    this.byQ = paramArrayOfByte.eo(24);
    this.sampleRate = paramArrayOfByte.eo(20);
    this.channels = (paramArrayOfByte.eo(3) + 1);
    this.bia = (paramArrayOfByte.eo(5) + 1);
    long l = paramArrayOfByte.eo(4);
    this.byR = (paramArrayOfByte.eo(32) & 0xFFFFFFFF | (l & 0xF) << 32);
    AppMethodBeat.o(93135);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.i.g
 * JD-Core Version:    0.7.0.1
 */