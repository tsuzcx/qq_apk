package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum KindaJSEventType
{
  static
  {
    AppMethodBeat.i(135947);
    WEB = new KindaJSEventType("WEB", 0);
    TINYAPP = new KindaJSEventType("TINYAPP", 1);
    $VALUES = new KindaJSEventType[] { WEB, TINYAPP };
    AppMethodBeat.o(135947);
  }
  
  private KindaJSEventType() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.kinda.gen.KindaJSEventType
 * JD-Core Version:    0.7.0.1
 */