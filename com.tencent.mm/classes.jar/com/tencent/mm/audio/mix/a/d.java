package com.tencent.mm.audio.mix.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public final class d
{
  public int cel = 2;
  public byte[] cem;
  public String ceu;
  public long cex = 0L;
  public boolean cey = false;
  public int channels = 2;
  public int sampleRate = 44100;
  
  public final void reset()
  {
    AppMethodBeat.i(136978);
    this.sampleRate = 44100;
    this.channels = 44100;
    this.cel = 2;
    this.ceu = "";
    this.cex = 0L;
    if (this.cem != null) {
      Arrays.fill(this.cem, 0, this.cem.length, (byte)0);
    }
    AppMethodBeat.o(136978);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.audio.mix.a.d
 * JD-Core Version:    0.7.0.1
 */