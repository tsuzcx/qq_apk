package com.google.android.exoplayer2.i;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g
{
  public final int bGJ;
  public final int bGK;
  public final int bGL;
  public final int bGM;
  public final long bGN;
  public final int bsZ;
  public final int channels;
  public final int sampleRate;
  
  public g(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(93135);
    paramArrayOfByte = new l(paramArrayOfByte);
    paramArrayOfByte.setPosition(136);
    this.bGJ = paramArrayOfByte.es(16);
    this.bGK = paramArrayOfByte.es(16);
    this.bGL = paramArrayOfByte.es(24);
    this.bGM = paramArrayOfByte.es(24);
    this.sampleRate = paramArrayOfByte.es(20);
    this.channels = (paramArrayOfByte.es(3) + 1);
    this.bsZ = (paramArrayOfByte.es(5) + 1);
    long l = paramArrayOfByte.es(4);
    this.bGN = (paramArrayOfByte.es(32) & 0xFFFFFFFF | (l & 0xF) << 32);
    AppMethodBeat.o(93135);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.i.g
 * JD-Core Version:    0.7.0.1
 */