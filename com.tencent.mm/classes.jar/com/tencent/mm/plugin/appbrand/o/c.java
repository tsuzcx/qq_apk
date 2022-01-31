package com.tencent.mm.plugin.appbrand.o;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public enum c
{
  private Map<c.a, Long> iEM;
  private Map<c.a, Long> iEN;
  
  static
  {
    AppMethodBeat.i(91135);
    iEL = new c("INSTANCE");
    iEO = new c[] { iEL };
    AppMethodBeat.o(91135);
  }
  
  private c()
  {
    AppMethodBeat.i(91133);
    this.iEM = new HashMap();
    this.iEN = new HashMap();
    AppMethodBeat.o(91133);
  }
  
  public final void a(c.a parama)
  {
    AppMethodBeat.i(91134);
    this.iEM.put(parama, Long.valueOf(SystemClock.elapsedRealtime()));
    AppMethodBeat.o(91134);
  }
  
  public final String toString()
  {
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.o.c
 * JD-Core Version:    0.7.0.1
 */