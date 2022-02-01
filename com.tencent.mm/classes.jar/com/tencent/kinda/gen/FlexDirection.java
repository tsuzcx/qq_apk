package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum FlexDirection
{
  static
  {
    AppMethodBeat.i(135672);
    COLUMN = new FlexDirection("COLUMN", 0);
    COLUMNREVERSE = new FlexDirection("COLUMNREVERSE", 1);
    ROW = new FlexDirection("ROW", 2);
    ROWREVERSE = new FlexDirection("ROWREVERSE", 3);
    $VALUES = new FlexDirection[] { COLUMN, COLUMNREVERSE, ROW, ROWREVERSE };
    AppMethodBeat.o(135672);
  }
  
  private FlexDirection() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.gen.FlexDirection
 * JD-Core Version:    0.7.0.1
 */