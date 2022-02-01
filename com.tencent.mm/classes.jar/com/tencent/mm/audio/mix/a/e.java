package com.tencent.mm.audio.mix.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public final class e
{
  public int cTj = 2;
  public byte[] cTk;
  public String cTr;
  public long cTu = 0L;
  public boolean cTv = false;
  public int channels = 2;
  public int sampleRate = 44100;
  
  public final void reset()
  {
    AppMethodBeat.i(136726);
    this.sampleRate = 44100;
    this.channels = 44100;
    this.cTj = 2;
    this.cTr = "";
    this.cTu = 0L;
    if (this.cTk != null) {
      Arrays.fill(this.cTk, 0, this.cTk.length, (byte)0);
    }
    AppMethodBeat.o(136726);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.audio.mix.a.e
 * JD-Core Version:    0.7.0.1
 */