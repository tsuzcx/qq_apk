package com.tencent.mm.plugin.game.commlib;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.commlib.b.b;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public final class d
  implements com.tencent.mm.kernel.api.bucket.a, com.tencent.mm.kernel.api.bucket.d, com.tencent.mm.plugin.game.commlib.a.a
{
  private b sWf;
  
  public final void a(String paramString, com.tencent.mm.bw.a parama)
  {
    AppMethodBeat.i(89937);
    this.sWf.b(paramString, parama);
    AppMethodBeat.o(89937);
  }
  
  public final byte[] agO(String paramString)
  {
    AppMethodBeat.i(89938);
    if (this.sWf == null)
    {
      AppMethodBeat.o(89938);
      return null;
    }
    paramString = this.sWf.agO(paramString);
    AppMethodBeat.o(89938);
    return paramString;
  }
  
  public final void agP(String paramString)
  {
    AppMethodBeat.i(184538);
    this.sWf.agP(paramString);
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
        return b.SQL_CREATE;
      }
    });
    AppMethodBeat.o(89939);
    return localHashMap;
  }
  
  public final void onDataBaseClosed(h paramh1, h paramh2) {}
  
  public final void onDataBaseOpened(h paramh1, h paramh2)
  {
    AppMethodBeat.i(89940);
    this.sWf = new b(paramh1);
    AppMethodBeat.o(89940);
  }
  
  public final void p(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(184537);
    this.sWf.q(paramString, paramArrayOfByte);
    AppMethodBeat.o(184537);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.commlib.d
 * JD-Core Version:    0.7.0.1
 */