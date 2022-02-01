package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum Ellipsize
{
  static
  {
    AppMethodBeat.i(135669);
    DEFAULT = new Ellipsize("DEFAULT", 0);
    TAIL = new Ellipsize("TAIL", 1);
    HEAD = new Ellipsize("HEAD", 2);
    MIDDLE = new Ellipsize("MIDDLE", 3);
    $VALUES = new Ellipsize[] { DEFAULT, TAIL, HEAD, MIDDLE };
    AppMethodBeat.o(135669);
  }
  
  private Ellipsize() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.gen.Ellipsize
 * JD-Core Version:    0.7.0.1
 */