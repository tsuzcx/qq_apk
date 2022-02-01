package com.tencent.mm.audio.mix.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public final class e
{
  public int channels = 2;
  public int hqI = 2;
  public byte[] hqJ;
  public String hqQ;
  public long hqT = 0L;
  public boolean hqU = false;
  public int sampleRate = 44100;
  
  public final void reset()
  {
    AppMethodBeat.i(136726);
    this.sampleRate = 44100;
    this.channels = 44100;
    this.hqI = 2;
    this.hqQ = "";
    this.hqT = 0L;
    if (this.hqJ != null) {
      Arrays.fill(this.hqJ, 0, this.hqJ.length, (byte)0);
    }
    AppMethodBeat.o(136726);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.audio.mix.a.e
 * JD-Core Version:    0.7.0.1
 */