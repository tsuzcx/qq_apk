package com.tencent.mm.plugin.appbrand.w.b;

import com.tencent.mm.plugin.appbrand.w.e.i;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

public final class d
  extends c
{
  public final com.tencent.mm.plugin.appbrand.w.e.c a(com.tencent.mm.plugin.appbrand.w.e.a parama, i parami)
  {
    super.a(parama, parami);
    parami.wR("WebSocket Protocol Handshake");
    parami.put("Server", "Java-WebSocket");
    parama = Calendar.getInstance();
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
    localSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
    parami.put("Date", localSimpleDateFormat.format(parama.getTime()));
    return parami;
  }
  
  public final a aqI()
  {
    return new d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.w.b.d
 * JD-Core Version:    0.7.0.1
 */