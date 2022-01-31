package com.tencent.mm.plugin.game.commlib;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.plugin.game.commlib.b.b;
import java.util.HashMap;

public final class d
  implements com.tencent.mm.kernel.api.bucket.a, com.tencent.mm.kernel.api.bucket.d, com.tencent.mm.plugin.game.commlib.a.a
{
  private b niV;
  
  public final byte[] PN(String paramString)
  {
    AppMethodBeat.i(59407);
    paramString = this.niV.PN(paramString);
    AppMethodBeat.o(59407);
    return paramString;
  }
  
  public final void a(String paramString, com.tencent.mm.bv.a parama)
  {
    AppMethodBeat.i(59406);
    this.niV.b(paramString, parama);
    AppMethodBeat.o(59406);
  }
  
  public final HashMap<Integer, h.d> collectDatabaseFactory()
  {
    AppMethodBeat.i(59408);
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf("GAME_CENTER_MSG_INFO_TABLE".hashCode()), new d.1(this));
    AppMethodBeat.o(59408);
    return localHashMap;
  }
  
  public final void onDataBaseClosed(h paramh1, h paramh2) {}
  
  public final void onDataBaseOpened(h paramh1, h paramh2)
  {
    AppMethodBeat.i(59409);
    this.niV = new b(paramh1);
    AppMethodBeat.o(59409);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.commlib.d
 * JD-Core Version:    0.7.0.1
 */