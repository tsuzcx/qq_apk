package com.facebook.appevents;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum AppEventsLogger$FlushBehavior
{
  static
  {
    AppMethodBeat.i(17349);
    AUTO = new FlushBehavior("AUTO", 0);
    EXPLICIT_ONLY = new FlushBehavior("EXPLICIT_ONLY", 1);
    $VALUES = new FlushBehavior[] { AUTO, EXPLICIT_ONLY };
    AppMethodBeat.o(17349);
  }
  
  private AppEventsLogger$FlushBehavior() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.facebook.appevents.AppEventsLogger.FlushBehavior
 * JD-Core Version:    0.7.0.1
 */