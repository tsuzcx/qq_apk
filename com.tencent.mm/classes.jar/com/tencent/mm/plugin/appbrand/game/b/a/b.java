package com.tencent.mm.plugin.appbrand.game.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ad;

public final class b
  extends j<a>
{
  public static final String[] gLs;
  private final boolean jqw;
  
  static
  {
    AppMethodBeat.i(45098);
    gLs = new String[] { j.getCreateSQLs(a.info, "WxagGameInfo") };
    AppMethodBeat.o(45098);
  }
  
  public b(e parame)
  {
    super(parame, a.info, "WxagGameInfo", null);
    AppMethodBeat.i(45096);
    if (parame != null) {}
    for (boolean bool = true;; bool = false)
    {
      this.jqw = bool;
      if (!this.jqw) {
        ad.e("MicroMsg.MiniGameInfoStorage", "storage can not work!!!");
      }
      AppMethodBeat.o(45096);
      return;
    }
  }
  
  public final void add(k.a parama)
  {
    AppMethodBeat.i(45097);
    add("MicroMsg.MiniGameInfoStorage.WORKER", parama);
    AppMethodBeat.o(45097);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.b.a.b
 * JD-Core Version:    0.7.0.1
 */