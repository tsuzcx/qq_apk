package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum ClearButtonMode
{
  static
  {
    AppMethodBeat.i(141168);
    NEVER = new ClearButtonMode("NEVER", 0);
    WHILEEDITING = new ClearButtonMode("WHILEEDITING", 1);
    UNLESSEDITING = new ClearButtonMode("UNLESSEDITING", 2);
    ALWAYS = new ClearButtonMode("ALWAYS", 3);
    $VALUES = new ClearButtonMode[] { NEVER, WHILEEDITING, UNLESSEDITING, ALWAYS };
    AppMethodBeat.o(141168);
  }
  
  private ClearButtonMode() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.gen.ClearButtonMode
 * JD-Core Version:    0.7.0.1
 */