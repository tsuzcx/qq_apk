package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum BioType
{
  static
  {
    AppMethodBeat.i(135654);
    NONE = new BioType("NONE", 0);
    FINGERPRINT = new BioType("FINGERPRINT", 1);
    FACEID = new BioType("FACEID", 2);
    $VALUES = new BioType[] { NONE, FINGERPRINT, FACEID };
    AppMethodBeat.o(135654);
  }
  
  private BioType() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.kinda.gen.BioType
 * JD-Core Version:    0.7.0.1
 */