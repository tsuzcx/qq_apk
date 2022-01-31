package com.tencent.mm.network.a;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.q;
import com.tencent.mm.sdk.platformtools.y;
import java.net.InetAddress;

public final class c
{
  private InetAddress ePB;
  private int port;
  private int type;
  
  private c(InetAddress paramInetAddress, int paramInt1, int paramInt2)
  {
    this.ePB = paramInetAddress;
    this.port = paramInt1;
    this.type = paramInt2;
  }
  
  public static c oN(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      paramString = paramString.split(":");
    } while ((paramString == null) || (paramString.length != 3));
    try
    {
      paramString = new c(q.Ze(paramString[0]), Integer.parseInt(paramString[1]), Integer.parseInt(paramString[2]));
      return paramString;
    }
    catch (Exception paramString)
    {
      y.e("MicroMsg.InAddress", "exception:%s", new Object[] { bk.j(paramString) });
    }
    return null;
  }
  
  public final String toString()
  {
    String str = "hc";
    if (this.type == 2) {
      str = "dns";
    }
    for (;;)
    {
      return this.ePB.getHostAddress() + ":" + this.port + "(" + str + ")";
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