package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum KTransferDelayType
{
  static
  {
    AppMethodBeat.i(219994);
    NODELAY = new KTransferDelayType("NODELAY", 0);
    DELAY2HOUR = new KTransferDelayType("DELAY2HOUR", 1);
    DELAY24HOUR = new KTransferDelayType("DELAY24HOUR", 2);
    $VALUES = new KTransferDelayType[] { NODELAY, DELAY2HOUR, DELAY24HOUR };
    AppMethodBeat.o(219994);
  }
  
  private KTransferDelayType() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.kinda.gen.KTransferDelayType
 * JD-Core Version:    0.7.0.1
 */