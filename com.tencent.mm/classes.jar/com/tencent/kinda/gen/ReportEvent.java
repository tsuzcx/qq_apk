package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum ReportEvent
{
  static
  {
    AppMethodBeat.i(226713);
    CREATE = new ReportEvent("CREATE", 0);
    RESUME = new ReportEvent("RESUME", 1);
    CUSTOM = new ReportEvent("CUSTOM", 2);
    $VALUES = new ReportEvent[] { CREATE, RESUME, CUSTOM };
    AppMethodBeat.o(226713);
  }
  
  private ReportEvent() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.kinda.gen.ReportEvent
 * JD-Core Version:    0.7.0.1
 */