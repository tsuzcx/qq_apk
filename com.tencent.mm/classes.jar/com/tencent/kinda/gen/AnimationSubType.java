package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum AnimationSubType
{
  static
  {
    AppMethodBeat.i(135640);
    FROMRIGHT = new AnimationSubType("FROMRIGHT", 0);
    FROMLEFT = new AnimationSubType("FROMLEFT", 1);
    FROMTOP = new AnimationSubType("FROMTOP", 2);
    FROMBOTTOM = new AnimationSubType("FROMBOTTOM", 3);
    $VALUES = new AnimationSubType[] { FROMRIGHT, FROMLEFT, FROMTOP, FROMBOTTOM };
    AppMethodBeat.o(135640);
  }
  
  private AnimationSubType() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.kinda.gen.AnimationSubType
 * JD-Core Version:    0.7.0.1
 */