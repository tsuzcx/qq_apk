package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum Visible
{
  static
  {
    AppMethodBeat.i(136008);
    VISIBLE = new Visible("VISIBLE", 0);
    INVISIBLE = new Visible("INVISIBLE", 1);
    GONE = new Visible("GONE", 2);
    $VALUES = new Visible[] { VISIBLE, INVISIBLE, GONE };
    AppMethodBeat.o(136008);
  }
  
  private Visible() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.kinda.gen.Visible
 * JD-Core Version:    0.7.0.1
 */