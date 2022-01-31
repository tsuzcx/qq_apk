package com.tencent.mm.plugin.backup.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.lan_cs.Client.a;
import java.io.IOException;

final class a$2
  implements Client.a
{
  a$2(a parama) {}
  
  public final void ST()
  {
    AppMethodBeat.i(17154);
    a.a(this.jzm, 10011, "client onDisconnect".getBytes());
    AppMethodBeat.o(17154);
  }
  
  public final void onRecv(String paramString, int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(17153);
    a.a(this.jzm, paramString);
    a.a(this.jzm, paramInt);
    try
    {
      a.a(this.jzm, paramArrayOfByte);
      AppMethodBeat.o(17153);
      return;
    }
    catch (IOException paramString)
    {
      a.a(this.jzm, 10006, ("client readErr:" + paramString.toString()).getBytes());
      AppMethodBeat.o(17153);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.c.a.2
 * JD-Core Version:    0.7.0.1
 */