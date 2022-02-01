package com.tencent.mm.plugin.game;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.model.s;
import com.tencent.mm.plugin.game.model.w;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public final class e
  implements com.tencent.mm.kernel.api.bucket.a, com.tencent.mm.kernel.api.bucket.d, com.tencent.mm.plugin.game.api.e
{
  private s sVd;
  private w sVe;
  private com.tencent.mm.plugin.game.model.a.g sVf;
  private com.tencent.mm.plugin.game.media.g sVg;
  private com.tencent.mm.plugin.game.media.d sVh;
  
  public final s cOm()
  {
    AppMethodBeat.i(40848);
    com.tencent.mm.kernel.g.agP().afT();
    if (this.sVd == null)
    {
      com.tencent.mm.kernel.g.agS();
      this.sVd = new s(com.tencent.mm.kernel.g.agR().ghG);
    }
    s locals = this.sVd;
    AppMethodBeat.o(40848);
    return locals;
  }
  
  public final w cOn()
  {
    AppMethodBeat.i(40849);
    com.tencent.mm.kernel.g.agP().afT();
    if (this.sVe == null)
    {
      com.tencent.mm.kernel.g.agS();
      this.sVe = new w(com.tencent.mm.kernel.g.agR().ghG);
    }
    w localw = this.sVe;
    AppMethodBeat.o(40849);
    return localw;
  }
  
  public final com.tencent.mm.plugin.game.model.a.g cOo()
  {
    AppMethodBeat.i(40850);
    com.tencent.mm.kernel.g.agP().afT();
    if (this.sVf == null)
    {
      com.tencent.mm.kernel.g.agS();
      this.sVf = new com.tencent.mm.plugin.game.model.a.g(com.tencent.mm.kernel.g.agR().ghG);
    }
    com.tencent.mm.plugin.game.model.a.g localg = this.sVf;
    AppMethodBeat.o(40850);
    return localg;
  }
  
  public final com.tencent.mm.plugin.game.media.g cOp()
  {
    AppMethodBeat.i(40851);
    com.tencent.mm.kernel.g.agP().afT();
    if (this.sVg == null)
    {
      com.tencent.mm.kernel.g.agS();
      this.sVg = new com.tencent.mm.plugin.game.media.g(com.tencent.mm.kernel.g.agR().ghG);
    }
    com.tencent.mm.plugin.game.media.g localg = this.sVg;
    AppMethodBeat.o(40851);
    return localg;
  }
  
  public final com.tencent.mm.plugin.game.media.d cOq()
  {
    AppMethodBeat.i(40852);
    com.tencent.mm.kernel.g.agP().afT();
    if (this.sVh == null)
    {
      com.tencent.mm.kernel.g.agS();
      this.sVh = new com.tencent.mm.plugin.game.media.d(com.tencent.mm.kernel.g.agR().ghG);
    }
    com.tencent.mm.plugin.game.media.d locald = this.sVh;
    AppMethodBeat.o(40852);
    return locald;
  }
  
  public final HashMap<Integer, h.b> collectDatabaseFactory()
  {
    AppMethodBeat.i(40847);
    ac.i("MicroMsg.GameStorage", "GameStorage collectDatabaseFactory");
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
    AppMethodBeat.o(40847);
    return localHashMap;
  }
  
  public final void onDataBaseClosed(h paramh1, h paramh2) {}
  
  public final void onDataBaseOpened(h paramh1, h paramh2)
  {
    AppMethodBeat.i(40846);
    ac.i("MicroMsg.GameStorage", "GameStorage onDataBaseOpened");
    this.sVd = new s(paramh1);
    this.sVf = new com.tencent.mm.plugin.game.model.a.g(paramh1);
    this.sVg = new com.tencent.mm.plugin.game.media.g(paramh1);
    this.sVh = new com.tencent.mm.plugin.game.media.d(paramh1);
    AppMethodBeat.o(40846);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.e
 * JD-Core Version:    0.7.0.1
 */