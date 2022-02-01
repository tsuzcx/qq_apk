package com.tencent.mm.plugin.appbrand.h.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.net.InetAddress;

public final class f
{
  private static int jjx = 900;
  InetAddress jjy;
  int jjz;
  int port;
  
  public f(String paramString)
  {
    this(InetAddress.getByName(paramString), jjx);
    AppMethodBeat.i(158987);
    AppMethodBeat.o(158987);
  }
  
  private f(InetAddress paramInetAddress, int paramInt)
  {
    this.jjy = paramInetAddress;
    this.port = 1900;
    this.jjz = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.h.c.f
 * JD-Core Version:    0.7.0.1
 */