package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum TransitionStyle
{
  static
  {
    AppMethodBeat.i(141479);
    COVERVERTICAL = new TransitionStyle("COVERVERTICAL", 0);
    FLIPHORIZONTAL = new TransitionStyle("FLIPHORIZONTAL", 1);
    CROSSDISSOLVE = new TransitionStyle("CROSSDISSOLVE", 2);
    $VALUES = new TransitionStyle[] { COVERVERTICAL, FLIPHORIZONTAL, CROSSDISSOLVE };
    AppMethodBeat.o(141479);
  }
  
  private TransitionStyle() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.kinda.gen.TransitionStyle
 * JD-Core Version:    0.7.0.1
 */