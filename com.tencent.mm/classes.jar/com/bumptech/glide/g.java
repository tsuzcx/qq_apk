package com.bumptech.glide;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum g
{
  static
  {
    AppMethodBeat.i(76789);
    aCM = new g("IMMEDIATE", 0);
    aCN = new g("HIGH", 1);
    aCO = new g("NORMAL", 2);
    aCP = new g("LOW", 3);
    aCQ = new g[] { aCM, aCN, aCO, aCP };
    AppMethodBeat.o(76789);
  }
  
  private g() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.g
 * JD-Core Version:    0.7.0.1
 */