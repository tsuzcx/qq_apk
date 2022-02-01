package com.eclipsesource.mmv8.debug;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum StepAction
{
  int index;
  
  static
  {
    AppMethodBeat.i(61543);
    STEP_OUT = new StepAction("STEP_OUT", 0, 0);
    STEP_NEXT = new StepAction("STEP_NEXT", 1, 1);
    STEP_IN = new StepAction("STEP_IN", 2, 2);
    STEP_FRAME = new StepAction("STEP_FRAME", 3, 3);
    $VALUES = new StepAction[] { STEP_OUT, STEP_NEXT, STEP_IN, STEP_FRAME };
    AppMethodBeat.o(61543);
  }
  
  private StepAction(int paramInt)
  {
    this.index = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.eclipsesource.mmv8.debug.StepAction
 * JD-Core Version:    0.7.0.1
 */