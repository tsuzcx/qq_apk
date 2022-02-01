package com.tencent.mm.plugin.appbrand.g.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.net.InetAddress;

public final class f
{
  private static int rjm = 900;
  int port;
  InetAddress rjn;
  int rjo;
  
  public f(String paramString)
  {
    this(InetAddress.getByName(paramString), rjm);
    AppMethodBeat.i(158987);
    AppMethodBeat.o(158987);
  }
  
  private f(InetAddress paramInetAddress, int paramInt)
  {
    this.rjn = paramInetAddress;
    this.port = 1900;
    this.rjo = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.g.c.f
 * JD-Core Version:    0.7.0.1
 */