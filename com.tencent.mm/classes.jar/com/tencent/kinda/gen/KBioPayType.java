package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum KBioPayType
{
  static
  {
    AppMethodBeat.i(226690);
    NONE = new KBioPayType("NONE", 0);
    TOUCHID = new KBioPayType("TOUCHID", 1);
    FACEID = new KBioPayType("FACEID", 2);
    $VALUES = new KBioPayType[] { NONE, TOUCHID, FACEID };
    AppMethodBeat.o(226690);
  }
  
  private KBioPayType() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.kinda.gen.KBioPayType
 * JD-Core Version:    0.7.0.1
 */