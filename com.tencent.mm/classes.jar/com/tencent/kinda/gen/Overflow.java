package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum Overflow
{
  static
  {
    AppMethodBeat.i(135961);
    VISIBLE = new Overflow("VISIBLE", 0);
    HIDDEN = new Overflow("HIDDEN", 1);
    SCROLL = new Overflow("SCROLL", 2);
    $VALUES = new Overflow[] { VISIBLE, HIDDEN, SCROLL };
    AppMethodBeat.o(135961);
  }
  
  private Overflow() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.kinda.gen.Overflow
 * JD-Core Version:    0.7.0.1
 */