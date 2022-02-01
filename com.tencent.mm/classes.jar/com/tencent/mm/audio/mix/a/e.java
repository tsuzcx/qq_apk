package com.tencent.mm.audio.mix.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public final class e
{
  public int channels = 2;
  public int dtP = 2;
  public byte[] dtQ;
  public String dtX;
  public long dua = 0L;
  public boolean dub = false;
  public int sampleRate = 44100;
  
  public final void reset()
  {
    AppMethodBeat.i(136726);
    this.sampleRate = 44100;
    this.channels = 44100;
    this.dtP = 2;
    this.dtX = "";
    this.dua = 0L;
    if (this.dtQ != null) {
      Arrays.fill(this.dtQ, 0, this.dtQ.length, (byte)0);
    }
    AppMethodBeat.o(136726);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.audio.mix.a.e
 * JD-Core Version:    0.7.0.1
 */