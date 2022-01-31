package com.google.android.exoplayer2.i;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g
{
  public final int aMB;
  public final int baM;
  public final int baN;
  public final int baO;
  public final int baP;
  public final long baQ;
  public final int channels;
  public final int sampleRate;
  
  public g(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(95875);
    paramArrayOfByte = new l(paramArrayOfByte);
    paramArrayOfByte.setPosition(136);
    this.baM = paramArrayOfByte.dD(16);
    this.baN = paramArrayOfByte.dD(16);
    this.baO = paramArrayOfByte.dD(24);
    this.baP = paramArrayOfByte.dD(24);
    this.sampleRate = paramArrayOfByte.dD(20);
    this.channels = (paramArrayOfByte.dD(3) + 1);
    this.aMB = (paramArrayOfByte.dD(5) + 1);
    long l = paramArrayOfByte.dD(4);
    this.baQ = (paramArrayOfByte.dD(32) & 0xFFFFFFFF | (l & 0xF) << 32);
    AppMethodBeat.o(95875);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.i.g
 * JD-Core Version:    0.7.0.1
 */