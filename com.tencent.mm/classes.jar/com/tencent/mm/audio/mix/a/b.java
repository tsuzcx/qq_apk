package com.tencent.mm.audio.mix.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class b
{
  public int channels;
  public int dtP;
  public byte[] dtQ;
  public volatile LinkedList<String> dtR;
  public int sampleRate;
  
  public b()
  {
    AppMethodBeat.i(136708);
    this.sampleRate = 0;
    this.channels = 0;
    this.dtP = 2;
    this.dtR = new LinkedList();
    AppMethodBeat.o(136708);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.audio.mix.a.b
 * JD-Core Version:    0.7.0.1
 */