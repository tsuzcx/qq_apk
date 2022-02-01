package com.tencent.mm.plugin.appbrand.z.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.z.e.i;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

public final class d
  extends c
{
  public final com.tencent.mm.plugin.appbrand.z.e.c a(com.tencent.mm.plugin.appbrand.z.e.a parama, i parami)
  {
    AppMethodBeat.i(156647);
    super.a(parama, parami);
    parami.VT("WebSocket Protocol Handshake");
    parami.put("Server", "Java-WebSocket");
    parama = Calendar.getInstance();
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
    localSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
    parami.put("Date", localSimpleDateFormat.format(parama.getTime()));
    AppMethodBeat.o(156647);
    return parami;
  }
  
  public final a bCz()
  {
    AppMethodBeat.i(156648);
    d locald = new d();
    AppMethodBeat.o(156648);
    return locald;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.z.b.d
 * JD-Core Version:    0.7.0.1
 */