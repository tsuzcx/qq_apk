package com.hilive.mediasdk.serialize;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum Marshallable$ELenType
{
  static
  {
    AppMethodBeat.i(142862);
    E_SHORT = new ELenType("E_SHORT", 0);
    E_INT = new ELenType("E_INT", 1);
    E_NONE = new ELenType("E_NONE", 2);
    $VALUES = new ELenType[] { E_SHORT, E_INT, E_NONE };
    AppMethodBeat.o(142862);
  }
  
  private Marshallable$ELenType() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.hilive.mediasdk.serialize.Marshallable.ELenType
 * JD-Core Version:    0.7.0.1
 */