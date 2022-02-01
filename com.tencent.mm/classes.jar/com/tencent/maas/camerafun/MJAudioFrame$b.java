package com.tencent.maas.camerafun;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum MJAudioFrame$b
{
  private final int eEP;
  
  static
  {
    AppMethodBeat.i(216851);
    eER = new b("None", 0, -1);
    eES = new b("I16", 1, 0);
    eET = new b("I32", 2, 1);
    eEU = new b("F32", 3, 2);
    eEV = new b[] { eER, eES, eET, eEU };
    AppMethodBeat.o(216851);
  }
  
  private MJAudioFrame$b(int paramInt)
  {
    this.eEP = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.maas.camerafun.MJAudioFrame.b
 * JD-Core Version:    0.7.0.1
 */