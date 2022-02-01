package com.facebook.appevents.codeless.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum EventBinding$MappingMethod
{
  static
  {
    AppMethodBeat.i(17532);
    MANUAL = new MappingMethod("MANUAL", 0);
    INFERENCE = new MappingMethod("INFERENCE", 1);
    $VALUES = new MappingMethod[] { MANUAL, INFERENCE };
    AppMethodBeat.o(17532);
  }
  
  private EventBinding$MappingMethod() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.facebook.appevents.codeless.internal.EventBinding.MappingMethod
 * JD-Core Version:    0.7.0.1
 */