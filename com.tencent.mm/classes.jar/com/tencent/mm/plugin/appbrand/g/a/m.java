package com.tencent.mm.plugin.appbrand.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class m
  extends e
{
  public m(String paramString1, String paramString2)
  {
    this(paramString1, paramString2, (byte)0);
  }
  
  private m(String paramString1, String paramString2, byte paramByte)
  {
    super(paramString1, "");
    AppMethodBeat.i(158900);
    a(e.a.rhS);
    dx("Nt", "upnp:event");
    dx("Timeout", "Second-10800");
    dx("Callback", "<" + paramString2 + ">");
    AppMethodBeat.o(158900);
  }
  
  public final String cmR()
  {
    return "SUBSCRIBE";
  }
  
  public final String cmS()
  {
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.g.a.m
 * JD-Core Version:    0.7.0.1
 */