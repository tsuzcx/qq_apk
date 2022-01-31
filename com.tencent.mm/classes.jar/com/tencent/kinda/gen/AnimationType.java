package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum AnimationType
{
  static
  {
    AppMethodBeat.i(141154);
    FADE = new AnimationType("FADE", 0);
    MOVEIN = new AnimationType("MOVEIN", 1);
    PUSH = new AnimationType("PUSH", 2);
    REVEAL = new AnimationType("REVEAL", 3);
    $VALUES = new AnimationType[] { FADE, MOVEIN, PUSH, REVEAL };
    AppMethodBeat.o(141154);
  }
  
  private AnimationType() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.gen.AnimationType
 * JD-Core Version:    0.7.0.1
 */