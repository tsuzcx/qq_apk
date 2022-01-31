package com.facebook;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum GraphResponse$PagingDirection
{
  static
  {
    AppMethodBeat.i(71761);
    NEXT = new PagingDirection("NEXT", 0);
    PREVIOUS = new PagingDirection("PREVIOUS", 1);
    $VALUES = new PagingDirection[] { NEXT, PREVIOUS };
    AppMethodBeat.o(71761);
  }
  
  private GraphResponse$PagingDirection() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.facebook.GraphResponse.PagingDirection
 * JD-Core Version:    0.7.0.1
 */