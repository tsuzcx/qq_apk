package com.tencent.mm.network.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.u;
import java.net.InetAddress;

public final class c
{
  private InetAddress inF;
  private int port;
  private int type;
  
  private c(InetAddress paramInetAddress, int paramInt1, int paramInt2)
  {
    this.inF = paramInetAddress;
    this.port = paramInt1;
    this.type = paramInt2;
  }
  
  public static c Fi(String paramString)
  {
    AppMethodBeat.i(132966);
    if (paramString == null)
    {
      AppMethodBeat.o(132966);
      return null;
    }
    paramString = paramString.split(":");
    if ((paramString == null) || (paramString.length != 3))
    {
      AppMethodBeat.o(132966);
      return null;
    }
    try
    {
      paramString = new c(u.aKH(paramString[0]), Integer.parseInt(paramString[1]), Integer.parseInt(paramString[2]));
      AppMethodBeat.o(132966);
      return paramString;
    }
    catch (Exception paramString)
    {
      ac.e("MicroMsg.InAddress", "exception:%s", new Object[] { bs.m(paramString) });
      AppMethodBeat.o(132966);
    }
    return null;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(132965);
    String str = "hc";
    if (this.type == 2) {
      str = "dns";
    }
    for (;;)
    {
      str = this.inF.getHostAddress() + ":" + this.port + "(" + str + ")";
      AppMethodBeat.o(132965);
      return str;
      if (this.type == 3) {
        str = "svrdns";
      } else if (this.type == 4) {
        str = "waphc";
      } else if (this.type == 5) {
        str = "newdns";
      } else if (this.type == 6) {
        str = "auth";
      } else if (this.type == 7) {
        str = "debug";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.network.a.c
 * JD-Core Version:    0.7.0.1
 */