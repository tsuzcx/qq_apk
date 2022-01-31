package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum TouchAction
{
  static
  {
    AppMethodBeat.i(141475);
    DOWN = new TouchAction("DOWN", 0);
    UP = new TouchAction("UP", 1);
    MOVE = new TouchAction("MOVE", 2);
    $VALUES = new TouchAction[] { DOWN, UP, MOVE };
    AppMethodBeat.o(141475);
  }
  
  private TouchAction() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.kinda.gen.TouchAction
 * JD-Core Version:    0.7.0.1
 */