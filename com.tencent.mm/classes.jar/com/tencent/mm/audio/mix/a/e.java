package com.tencent.mm.audio.mix.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public final class e
{
  public int cQG = 2;
  public byte[] cQH;
  public String cQO;
  public long cQR = 0L;
  public boolean cQS = false;
  public int channels = 2;
  public int sampleRate = 44100;
  
  public final void reset()
  {
    AppMethodBeat.i(136726);
    this.sampleRate = 44100;
    this.channels = 44100;
    this.cQG = 2;
    this.cQO = "";
    this.cQR = 0L;
    if (this.cQH != null) {
      Arrays.fill(this.cQH, 0, this.cQH.length, (byte)0);
    }
    AppMethodBeat.o(136726);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.audio.mix.a.e
 * JD-Core Version:    0.7.0.1
 */