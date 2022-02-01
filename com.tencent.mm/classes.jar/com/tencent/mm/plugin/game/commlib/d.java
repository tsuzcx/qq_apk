package com.tencent.mm.plugin.game.commlib;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.commlib.b.c;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public final class d
  implements com.tencent.mm.kernel.api.bucket.a, com.tencent.mm.kernel.api.bucket.d, com.tencent.mm.plugin.game.commlib.a.a
{
  private c IsQ;
  
  public final void a(String paramString, com.tencent.mm.bx.a parama)
  {
    AppMethodBeat.i(89937);
    this.IsQ.b(paramString, parama);
    AppMethodBeat.o(89937);
  }
  
  public final byte[] aFI(String paramString)
  {
    AppMethodBeat.i(89938);
    if (this.IsQ == null)
    {
      AppMethodBeat.o(89938);
      return null;
    }
    paramString = this.IsQ.aFI(paramString);
    AppMethodBeat.o(89938);
    return paramString;
  }
  
  public final void aFJ(String paramString)
  {
    AppMethodBeat.i(184538);
    this.IsQ.aFJ(paramString);
    AppMethodBeat.o(184538);
  }
  
  public final HashMap<Integer, h.b> collectDatabaseFactory()
  {
    AppMethodBeat.i(89939);
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf("GAME_CENTER_MSG_INFO_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return c.SQL_CREATE;
      }
    });
    AppMethodBeat.o(89939);
    return localHashMap;
  }
  
  public final void onDataBaseClosed(h paramh1, h paramh2) {}
  
  public final void onDataBaseOpened(h paramh1, h paramh2)
  {
    AppMethodBeat.i(89940);
    this.IsQ = new c(paramh1);
    AppMethodBeat.o(89940);
  }
  
  public final void x(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(184537);
    this.IsQ.y(paramString, paramArrayOfByte);
    AppMethodBeat.o(184537);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.commlib.d
 * JD-Core Version:    0.7.0.1
 */