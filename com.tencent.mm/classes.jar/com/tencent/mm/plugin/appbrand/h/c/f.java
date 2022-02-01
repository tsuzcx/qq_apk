package com.tencent.mm.plugin.appbrand.h.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.net.InetAddress;

public final class f
{
  private static int jJK = 900;
  InetAddress jJL;
  int jJM;
  int port;
  
  public f(String paramString)
  {
    this(InetAddress.getByName(paramString), jJK);
    AppMethodBeat.i(158987);
    AppMethodBeat.o(158987);
  }
  
  private f(InetAddress paramInetAddress, int paramInt)
  {
    this.jJL = paramInetAddress;
    this.port = 1900;
    this.jJM = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.h.c.f
 * JD-Core Version:    0.7.0.1
 */