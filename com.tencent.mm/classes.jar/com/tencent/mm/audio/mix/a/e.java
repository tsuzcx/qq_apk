package com.tencent.mm.audio.mix.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public final class e
{
  public int channels = 2;
  public int dbW = 2;
  public byte[] dbX;
  public String dce;
  public long dch = 0L;
  public boolean dci = false;
  public int sampleRate = 44100;
  
  public final void reset()
  {
    AppMethodBeat.i(136726);
    this.sampleRate = 44100;
    this.channels = 44100;
    this.dbW = 2;
    this.dce = "";
    this.dch = 0L;
    if (this.dbX != null) {
      Arrays.fill(this.dbX, 0, this.dbX.length, (byte)0);
    }
    AppMethodBeat.o(136726);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.audio.mix.a.e
 * JD-Core Version:    0.7.0.1
 */