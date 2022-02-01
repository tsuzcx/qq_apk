package com.facebook.appevents;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum FlushResult
{
  static
  {
    AppMethodBeat.i(17445);
    SUCCESS = new FlushResult("SUCCESS", 0);
    SERVER_ERROR = new FlushResult("SERVER_ERROR", 1);
    NO_CONNECTIVITY = new FlushResult("NO_CONNECTIVITY", 2);
    UNKNOWN_ERROR = new FlushResult("UNKNOWN_ERROR", 3);
    $VALUES = new FlushResult[] { SUCCESS, SERVER_ERROR, NO_CONNECTIVITY, UNKNOWN_ERROR };
    AppMethodBeat.o(17445);
  }
  
  private FlushResult() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.facebook.appevents.FlushResult
 * JD-Core Version:    0.7.0.1
 */