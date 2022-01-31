package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum LinkStyle
{
  static
  {
    AppMethodBeat.i(141434);
    DEFAULT = new LinkStyle("DEFAULT", 0);
    DELETED = new LinkStyle("DELETED", 1);
    UNDERLINE = new LinkStyle("UNDERLINE", 2);
    $VALUES = new LinkStyle[] { DEFAULT, DELETED, UNDERLINE };
    AppMethodBeat.o(141434);
  }
  
  private LinkStyle() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.kinda.gen.LinkStyle
 * JD-Core Version:    0.7.0.1
 */