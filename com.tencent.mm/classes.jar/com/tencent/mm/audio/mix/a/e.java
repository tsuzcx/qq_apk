package com.tencent.mm.audio.mix.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public final class e
{
  public int channels = 2;
  public int dcY = 2;
  public byte[] dcZ;
  public String ddg;
  public long ddj = 0L;
  public boolean ddk = false;
  public int sampleRate = 44100;
  
  public final void reset()
  {
    AppMethodBeat.i(136726);
    this.sampleRate = 44100;
    this.channels = 44100;
    this.dcY = 2;
    this.ddg = "";
    this.ddj = 0L;
    if (this.dcZ != null) {
      Arrays.fill(this.dcZ, 0, this.dcZ.length, (byte)0);
    }
    AppMethodBeat.o(136726);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.audio.mix.a.e
 * JD-Core Version:    0.7.0.1
 */