package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum Wrap
{
  static
  {
    AppMethodBeat.i(141547);
    NOWRAP = new Wrap("NOWRAP", 0);
    WRAP = new Wrap("WRAP", 1);
    WRAPREVERSE = new Wrap("WRAPREVERSE", 2);
    $VALUES = new Wrap[] { NOWRAP, WRAP, WRAPREVERSE };
    AppMethodBeat.o(141547);
  }
  
  private Wrap() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.kinda.gen.Wrap
 * JD-Core Version:    0.7.0.1
 */