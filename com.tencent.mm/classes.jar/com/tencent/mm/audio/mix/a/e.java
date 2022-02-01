package com.tencent.mm.audio.mix.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public final class e
{
  public int channels = 2;
  public String fmF;
  public long fmI = 0L;
  public boolean fmJ = false;
  public int fmx = 2;
  public byte[] fmy;
  public int sampleRate = 44100;
  
  public final void reset()
  {
    AppMethodBeat.i(136726);
    this.sampleRate = 44100;
    this.channels = 44100;
    this.fmx = 2;
    this.fmF = "";
    this.fmI = 0L;
    if (this.fmy != null) {
      Arrays.fill(this.fmy, 0, this.fmy.length, (byte)0);
    }
    AppMethodBeat.o(136726);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.audio.mix.a.e
 * JD-Core Version:    0.7.0.1
 */