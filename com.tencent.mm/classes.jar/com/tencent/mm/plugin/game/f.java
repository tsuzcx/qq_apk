package com.tencent.mm.plugin.game;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.game.model.s;
import com.tencent.mm.plugin.game.model.w;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public final class f
  implements com.tencent.mm.kernel.api.bucket.a, com.tencent.mm.kernel.api.bucket.d, com.tencent.mm.plugin.game.api.f
{
  private s tRG;
  private w tRH;
  private com.tencent.mm.plugin.game.model.a.g tRI;
  private com.tencent.mm.plugin.game.media.g tRJ;
  private com.tencent.mm.plugin.game.media.d tRK;
  
  public final s cWH()
  {
    AppMethodBeat.i(40848);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (this.tRG == null)
    {
      com.tencent.mm.kernel.g.ajD();
      this.tRG = new s(com.tencent.mm.kernel.g.ajC().gBq);
    }
    s locals = this.tRG;
    AppMethodBeat.o(40848);
    return locals;
  }
  
  public final w cWI()
  {
    AppMethodBeat.i(40849);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (this.tRH == null)
    {
      com.tencent.mm.kernel.g.ajD();
      this.tRH = new w(com.tencent.mm.kernel.g.ajC().gBq);
    }
    w localw = this.tRH;
    AppMethodBeat.o(40849);
    return localw;
  }
  
  public final com.tencent.mm.plugin.game.model.a.g cWJ()
  {
    AppMethodBeat.i(40850);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (this.tRI == null)
    {
      com.tencent.mm.kernel.g.ajD();
      this.tRI = new com.tencent.mm.plugin.game.model.a.g(com.tencent.mm.kernel.g.ajC().gBq);
    }
    com.tencent.mm.plugin.game.model.a.g localg = this.tRI;
    AppMethodBeat.o(40850);
    return localg;
  }
  
  public final com.tencent.mm.plugin.game.media.g cWK()
  {
    AppMethodBeat.i(40851);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (this.tRJ == null)
    {
      com.tencent.mm.kernel.g.ajD();
      this.tRJ = new com.tencent.mm.plugin.game.media.g(com.tencent.mm.kernel.g.ajC().gBq);
    }
    com.tencent.mm.plugin.game.media.g localg = this.tRJ;
    AppMethodBeat.o(40851);
    return localg;
  }
  
  public final com.tencent.mm.plugin.game.media.d cWL()
  {
    AppMethodBeat.i(40852);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (this.tRK == null)
    {
      com.tencent.mm.kernel.g.ajD();
      this.tRK = new com.tencent.mm.plugin.game.media.d(com.tencent.mm.kernel.g.ajC().gBq);
    }
    com.tencent.mm.plugin.game.media.d locald = this.tRK;
    AppMethodBeat.o(40852);
    return locald;
  }
  
  public final HashMap<Integer, h.b> collectDatabaseFactory()
  {
    AppMethodBeat.i(40847);
    ad.i("MicroMsg.GameStorage", "GameStorage collectDatabaseFactory");
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
    ad.i("MicroMsg.GameStorage", "GameStorage onDataBaseOpened");
    this.tRG = new s(paramh1);
    this.tRI = new com.tencent.mm.plugin.game.model.a.g(paramh1);
    this.tRJ = new com.tencent.mm.plugin.game.media.g(paramh1);
    this.tRK = new com.tencent.mm.plugin.game.media.d(paramh1);
    AppMethodBeat.o(40846);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.f
 * JD-Core Version:    0.7.0.1
 */