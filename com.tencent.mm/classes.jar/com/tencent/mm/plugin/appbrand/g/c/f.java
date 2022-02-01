package com.tencent.mm.plugin.appbrand.g.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.net.InetAddress;

public final class f
{
  private static int ofI = 900;
  InetAddress ofJ;
  int ofK;
  int port;
  
  public f(String paramString)
  {
    this(InetAddress.getByName(paramString), ofI);
    AppMethodBeat.i(158987);
    AppMethodBeat.o(158987);
  }
  
  private f(InetAddress paramInetAddress, int paramInt)
  {
    this.ofJ = paramInetAddress;
    this.port = 1900;
    this.ofK = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.g.c.f
 * JD-Core Version:    0.7.0.1
 */