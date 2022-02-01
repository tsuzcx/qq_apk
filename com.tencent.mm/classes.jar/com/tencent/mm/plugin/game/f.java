package com.tencent.mm.plugin.game;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.game.model.s;
import com.tencent.mm.plugin.game.model.w;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public final class f
  implements com.tencent.mm.kernel.api.bucket.a, com.tencent.mm.kernel.api.bucket.d, com.tencent.mm.plugin.game.api.f
{
  private s xtN;
  private w xtO;
  private com.tencent.mm.plugin.game.model.a.g xtP;
  private com.tencent.mm.plugin.game.media.g xtQ;
  private com.tencent.mm.plugin.game.media.d xtR;
  private com.tencent.mm.plugin.game.c.d xtS;
  
  public final HashMap<Integer, h.b> collectDatabaseFactory()
  {
    AppMethodBeat.i(40847);
    Log.i("MicroMsg.GameStorage", "GameStorage collectDatabaseFactory");
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf("GAME_CENTER_MSG_INFO_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return s.SQL_CREATE;
      }
    });
    localHashMap.put(Integer.valueOf("GAME_CENTER_PB_CACHE_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return w.SQL_CREATE;
      }
    });
    localHashMap.put(Integer.valueOf("GAME_CENTER_SILENT_DOWNLOAD_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.game.model.a.g.SQL_CREATE;
      }
    });
    localHashMap.put(Integer.valueOf("GAME_HAOWAN_EDITION".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.game.media.g.SQL_CREATE;
      }
    });
    localHashMap.put(Integer.valueOf("GAME_HAOWAN_MEDIA".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.game.media.d.SQL_CREATE;
      }
    });
    localHashMap.put(Integer.valueOf("GAME_RESOURCE_DOWNLOAD".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        AppMethodBeat.i(204094);
        Object localObject = com.tencent.mm.plugin.game.c.d.xvT;
        localObject = com.tencent.mm.plugin.game.c.d.dax();
        AppMethodBeat.o(204094);
        return localObject;
      }
    });
    AppMethodBeat.o(40847);
    return localHashMap;
  }
  
  public final s dSK()
  {
    AppMethodBeat.i(40848);
    com.tencent.mm.kernel.g.aAf().azk();
    if (this.xtN == null)
    {
      com.tencent.mm.kernel.g.aAi();
      this.xtN = new s(com.tencent.mm.kernel.g.aAh().hqK);
    }
    s locals = this.xtN;
    AppMethodBeat.o(40848);
    return locals;
  }
  
  public final w dSL()
  {
    AppMethodBeat.i(40849);
    com.tencent.mm.kernel.g.aAf().azk();
    if (this.xtO == null)
    {
      com.tencent.mm.kernel.g.aAi();
      this.xtO = new w(com.tencent.mm.kernel.g.aAh().hqK);
    }
    w localw = this.xtO;
    AppMethodBeat.o(40849);
    return localw;
  }
  
  public final com.tencent.mm.plugin.game.model.a.g dSM()
  {
    AppMethodBeat.i(40850);
    com.tencent.mm.kernel.g.aAf().azk();
    if (this.xtP == null)
    {
      com.tencent.mm.kernel.g.aAi();
      this.xtP = new com.tencent.mm.plugin.game.model.a.g(com.tencent.mm.kernel.g.aAh().hqK);
    }
    com.tencent.mm.plugin.game.model.a.g localg = this.xtP;
    AppMethodBeat.o(40850);
    return localg;
  }
  
  public final com.tencent.mm.plugin.game.media.g dSN()
  {
    AppMethodBeat.i(40851);
    com.tencent.mm.kernel.g.aAf().azk();
    if (this.xtQ == null)
    {
      com.tencent.mm.kernel.g.aAi();
      this.xtQ = new com.tencent.mm.plugin.game.media.g(com.tencent.mm.kernel.g.aAh().hqK);
    }
    com.tencent.mm.plugin.game.media.g localg = this.xtQ;
    AppMethodBeat.o(40851);
    return localg;
  }
  
  public final com.tencent.mm.plugin.game.media.d dSO()
  {
    AppMethodBeat.i(40852);
    com.tencent.mm.kernel.g.aAf().azk();
    if (this.xtR == null)
    {
      com.tencent.mm.kernel.g.aAi();
      this.xtR = new com.tencent.mm.plugin.game.media.d(com.tencent.mm.kernel.g.aAh().hqK);
    }
    com.tencent.mm.plugin.game.media.d locald = this.xtR;
    AppMethodBeat.o(40852);
    return locald;
  }
  
  public final com.tencent.mm.plugin.game.c.d dSP()
  {
    AppMethodBeat.i(204095);
    com.tencent.mm.kernel.g.aAf().azk();
    if (this.xtS == null)
    {
      com.tencent.mm.kernel.g.aAi();
      this.xtS = new com.tencent.mm.plugin.game.c.d(com.tencent.mm.kernel.g.aAh().hqK);
    }
    com.tencent.mm.plugin.game.c.d locald = this.xtS;
    AppMethodBeat.o(204095);
    return locald;
  }
  
  public final void onDataBaseClosed(h paramh1, h paramh2) {}
  
  public final void onDataBaseOpened(h paramh1, h paramh2)
  {
    AppMethodBeat.i(40846);
    Log.i("MicroMsg.GameStorage", "GameStorage onDataBaseOpened");
    this.xtN = new s(paramh1);
    this.xtP = new com.tencent.mm.plugin.game.model.a.g(paramh1);
    this.xtQ = new com.tencent.mm.plugin.game.media.g(paramh1);
    this.xtR = new com.tencent.mm.plugin.game.media.d(paramh1);
    this.xtS = new com.tencent.mm.plugin.game.c.d(paramh1);
    AppMethodBeat.o(40846);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.f
 * JD-Core Version:    0.7.0.1
 */