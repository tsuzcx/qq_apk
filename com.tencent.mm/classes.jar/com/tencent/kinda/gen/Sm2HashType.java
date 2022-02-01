package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum Sm2HashType
{
  static
  {
    AppMethodBeat.i(226721);
    MD5 = new Sm2HashType("MD5", 0);
    PBKDF2 = new Sm2HashType("PBKDF2", 1);
    $VALUES = new Sm2HashType[] { MD5, PBKDF2 };
    AppMethodBeat.o(226721);
  }
  
  private Sm2HashType() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.kinda.gen.Sm2HashType
 * JD-Core Version:    0.7.0.1
 */