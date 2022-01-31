package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum SelectBioType
{
  static
  {
    AppMethodBeat.i(141457);
    NONE = new SelectBioType("NONE", 0);
    TOUCHID = new SelectBioType("TOUCHID", 1);
    FACEID = new SelectBioType("FACEID", 2);
    $VALUES = new SelectBioType[] { NONE, TOUCHID, FACEID };
    AppMethodBeat.o(141457);
  }
  
  private SelectBioType() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.kinda.gen.SelectBioType
 * JD-Core Version:    0.7.0.1
 */