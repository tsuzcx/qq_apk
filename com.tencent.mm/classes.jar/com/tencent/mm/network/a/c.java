package com.tencent.mm.network.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.t;
import java.net.InetAddress;

public final class c
{
  private InetAddress gfo;
  private int port;
  private int type;
  
  private c(InetAddress paramInetAddress, int paramInt1, int paramInt2)
  {
    this.gfo = paramInetAddress;
    this.port = paramInt1;
    this.type = paramInt2;
  }
  
  public static c wf(String paramString)
  {
    AppMethodBeat.i(58716);
    if (paramString == null)
    {
      AppMethodBeat.o(58716);
      return null;
    }
    paramString = paramString.split(":");
    if ((paramString == null) || (paramString.length != 3))
    {
      AppMethodBeat.o(58716);
      return null;
    }
    try
    {
      paramString = new c(t.apc(paramString[0]), Integer.parseInt(paramString[1]), Integer.parseInt(paramString[2]));
      AppMethodBeat.o(58716);
      return paramString;
    }
    catch (Exception paramString)
    {
      ab.e("MicroMsg.InAddress", "exception:%s", new Object[] { bo.l(paramString) });
      AppMethodBeat.o(58716);
    }
    return null;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(58715);
    String str = "hc";
    if (this.type == 2) {
      str = "dns";
    }
    for (;;)
    {
      str = this.gfo.getHostAddress() + ":" + this.port + "(" + str + ")";
      AppMethodBeat.o(58715);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.network.a.c
 * JD-Core Version:    0.7.0.1
 */