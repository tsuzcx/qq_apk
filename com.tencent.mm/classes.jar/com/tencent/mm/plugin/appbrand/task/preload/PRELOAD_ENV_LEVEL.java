package com.tencent.mm.plugin.appbrand.task.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;

 enum PRELOAD_ENV_LEVEL
{
  static
  {
    AppMethodBeat.i(48508);
    LOW_LEVEL = new PRELOAD_ENV_LEVEL("LOW_LEVEL", 0);
    MIDDLE_LEVEL = new PRELOAD_ENV_LEVEL("MIDDLE_LEVEL", 1);
    HIGH_LEVEL = new PRELOAD_ENV_LEVEL("HIGH_LEVEL", 2);
    $VALUES = new PRELOAD_ENV_LEVEL[] { LOW_LEVEL, MIDDLE_LEVEL, HIGH_LEVEL };
    AppMethodBeat.o(48508);
  }
  
  private PRELOAD_ENV_LEVEL() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.preload.PRELOAD_ENV_LEVEL
 * JD-Core Version:    0.7.0.1
 */