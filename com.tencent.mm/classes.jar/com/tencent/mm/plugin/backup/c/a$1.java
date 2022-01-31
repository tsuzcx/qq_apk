package com.tencent.mm.plugin.backup.c;

import com.tencent.mm.lan_cs.Server.a;
import com.tencent.mm.plugin.backup.g.b;
import java.io.IOException;

public final class a$1
  implements Server.a
{
  public a$1(a parama) {}
  
  public final void EL()
  {
    a.a(this.hFP, 10011, "listen server onDisconnect".getBytes());
  }
  
  public final void hC(int paramInt)
  {
    if (a.a(this.hFP) == 1) {
      b.nI(paramInt);
    }
  }
  
  public final void onConnect(String paramString, int paramInt)
  {
    a.a(this.hFP, paramString);
    a.a(this.hFP, paramInt);
  }
  
  public final void onRecv(String paramString, int paramInt, byte[] paramArrayOfByte)
  {
    a.a(this.hFP, paramString);
    a.a(this.hFP, paramInt);
    try
    {
      a.a(this.hFP, paramArrayOfByte);
      return;
    }
    catch (IOException paramString)
    {
      a.a(this.hFP, 10006, ("server readErr:" + paramString.toString()).getBytes());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.c.a.1
 * JD-Core Version:    0.7.0.1
 */