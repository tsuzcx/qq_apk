package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum BaselineAdjustmentAlign
{
  static
  {
    AppMethodBeat.i(135650);
    BASELINE = new BaselineAdjustmentAlign("BASELINE", 0);
    CENTERS = new BaselineAdjustmentAlign("CENTERS", 1);
    NONE = new BaselineAdjustmentAlign("NONE", 2);
    $VALUES = new BaselineAdjustmentAlign[] { BASELINE, CENTERS, NONE };
    AppMethodBeat.o(135650);
  }
  
  private BaselineAdjustmentAlign() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.kinda.gen.BaselineAdjustmentAlign
 * JD-Core Version:    0.7.0.1
 */