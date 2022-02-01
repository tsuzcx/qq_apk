package com.tencent.maas.camerafun;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum MJAudioFrame$a
{
  private final int eEP;
  
  static
  {
    AppMethodBeat.i(216842);
    eEM = new a("None", 0, -1);
    eEN = new a("Mono", 1, 0);
    eEO = new a("Stereo", 2, 1);
    eEQ = new a[] { eEM, eEN, eEO };
    AppMethodBeat.o(216842);
  }
  
  private MJAudioFrame$a(int paramInt)
  {
    this.eEP = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.maas.camerafun.MJAudioFrame.a
 * JD-Core Version:    0.7.0.1
 */