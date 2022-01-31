package com.tencent.mm.plugin.backup.c;

import com.tencent.mm.lan_cs.Client.a;
import java.io.IOException;

final class a$2
  implements Client.a
{
  a$2(a parama) {}
  
  public final void EL()
  {
    a.a(this.hFP, 10011, "client onDisconnect".getBytes());
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
      a.a(this.hFP, 10006, ("client readErr:" + paramString.toString()).getBytes());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.c.a.2
 * JD-Core Version:    0.7.0.1
 */