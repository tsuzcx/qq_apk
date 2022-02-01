package com.tencent.mm.audio.mix.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class b
{
  public int channels;
  public int dcY;
  public byte[] dcZ;
  public volatile LinkedList<String> dda;
  public int sampleRate;
  
  public b()
  {
    AppMethodBeat.i(136708);
    this.sampleRate = 0;
    this.channels = 0;
    this.dcY = 2;
    this.dda = new LinkedList();
    AppMethodBeat.o(136708);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.audio.mix.a.b
 * JD-Core Version:    0.7.0.1
 */