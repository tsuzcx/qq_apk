package com.tencent.mm.plugin.appbrand.g.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.net.InetAddress;

public final class f
{
  private static int kdW = 900;
  InetAddress kdX;
  int kdY;
  int port;
  
  public f(String paramString)
  {
    this(InetAddress.getByName(paramString), kdW);
    AppMethodBeat.i(158987);
    AppMethodBeat.o(158987);
  }
  
  private f(InetAddress paramInetAddress, int paramInt)
  {
    this.kdX = paramInetAddress;
    this.port = 1900;
    this.kdY = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.g.c.f
 * JD-Core Version:    0.7.0.1
 */