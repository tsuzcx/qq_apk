package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum KeyEvent
{
  static
  {
    AppMethodBeat.i(220048);
    UNKONWN = new KeyEvent("UNKONWN", 0);
    ENTER = new KeyEvent("ENTER", 1);
    $VALUES = new KeyEvent[] { UNKONWN, ENTER };
    AppMethodBeat.o(220048);
  }
  
  private KeyEvent() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.kinda.gen.KeyEvent
 * JD-Core Version:    0.7.0.1
 */