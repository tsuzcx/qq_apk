package com.tencent.mm.plugin.game;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.game.model.s;
import com.tencent.mm.plugin.game.model.w;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public final class f
  implements com.tencent.mm.kernel.api.bucket.a, com.tencent.mm.kernel.api.bucket.d, com.tencent.mm.plugin.game.api.f
{
  private com.tencent.mm.plugin.game.media.g ucA;
  private com.tencent.mm.plugin.game.media.d ucB;
  private s ucx;
  private w ucy;
  private com.tencent.mm.plugin.game.model.a.g ucz;
  
  public final s cZl()
  {
    AppMethodBeat.i(40848);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (this.ucx == null)
    {
      com.tencent.mm.kernel.g.ajS();
      this.ucx = new s(com.tencent.mm.kernel.g.ajR().gDX);
    }
    s locals = this.ucx;
    AppMethodBeat.o(40848);
    return locals;
  }
  
  public final w cZm()
  {
    AppMethodBeat.i(40849);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (this.ucy == null)
    {
      com.tencent.mm.kernel.g.ajS();
      this.ucy = new w(com.tencent.mm.kernel.g.ajR().gDX);
    }
    w localw = this.ucy;
    AppMethodBeat.o(40849);
    return localw;
  }
  
  public final com.tencent.mm.plugin.game.model.a.g cZn()
  {
    AppMethodBeat.i(40850);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (this.ucz == null)
    {
      com.tencent.mm.kernel.g.ajS();
      this.ucz = new com.tencent.mm.plugin.game.model.a.g(com.tencent.mm.kernel.g.ajR().gDX);
    }
    com.tencent.mm.plugin.game.model.a.g localg = this.ucz;
    AppMethodBeat.o(40850);
    return localg;
  }
  
  public final com.tencent.mm.plugin.game.media.g cZo()
  {
    AppMethodBeat.i(40851);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (this.ucA == null)
    {
      com.tencent.mm.kernel.g.ajS();
      this.ucA = new com.tencent.mm.plugin.game.media.g(com.tencent.mm.kernel.g.ajR().gDX);
    }
    com.tencent.mm.plugin.game.media.g localg = this.ucA;
    AppMethodBeat.o(40851);
    return localg;
  }
  
  public final com.tencent.mm.plugin.game.media.d cZp()
  {
    AppMethodBeat.i(40852);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (this.ucB == null)
    {
      com.tencent.mm.kernel.g.ajS();
      this.ucB = new com.tencent.mm.plugin.game.media.d(com.tencent.mm.kernel.g.ajR().gDX);
    }
    com.tencent.mm.plugin.game.media.d locald = this.ucB;
    AppMethodBeat.o(40852);
    return locald;
  }
  
  public final HashMap<Integer, h.b> collectDatabaseFactory()
  {
    AppMethodBeat.i(40847);
    ae.i("MicroMsg.GameStorage", "GameStorage collectDatabaseFactory");
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
    ae.i("MicroMsg.GameStorage", "GameStorage onDataBaseOpened");
    this.ucx = new s(paramh1);
    this.ucz = new com.tencent.mm.plugin.game.model.a.g(paramh1);
    this.ucA = new com.tencent.mm.plugin.game.media.g(paramh1);
    this.ucB = new com.tencent.mm.plugin.game.media.d(paramh1);
    AppMethodBeat.o(40846);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.f
 * JD-Core Version:    0.7.0.1
 */