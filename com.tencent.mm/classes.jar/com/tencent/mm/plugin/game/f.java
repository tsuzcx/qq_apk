package com.tencent.mm.plugin.game;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.bucket.a;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.game.model.s;
import com.tencent.mm.plugin.game.model.w;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public final class f
  implements a, com.tencent.mm.kernel.api.bucket.d, com.tencent.mm.plugin.game.api.f
{
  private s Cgm;
  private w Cgn;
  private com.tencent.mm.plugin.game.model.a.g Cgo;
  private com.tencent.mm.plugin.game.media.g Cgp;
  private com.tencent.mm.plugin.game.media.d Cgq;
  private com.tencent.mm.plugin.game.b.d Cgr;
  
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
        AppMethodBeat.i(205722);
        Object localObject = com.tencent.mm.plugin.game.b.d.CzN;
        localObject = com.tencent.mm.plugin.game.b.d.dqy();
        AppMethodBeat.o(205722);
        return localObject;
      }
    });
    AppMethodBeat.o(40847);
    return localHashMap;
  }
  
  public final s evo()
  {
    AppMethodBeat.i(40848);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (this.Cgm == null)
    {
      com.tencent.mm.kernel.h.aHH();
      this.Cgm = new s(com.tencent.mm.kernel.h.aHG().kcF);
    }
    s locals = this.Cgm;
    AppMethodBeat.o(40848);
    return locals;
  }
  
  public final w evp()
  {
    AppMethodBeat.i(40849);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (this.Cgn == null)
    {
      com.tencent.mm.kernel.h.aHH();
      this.Cgn = new w(com.tencent.mm.kernel.h.aHG().kcF);
    }
    w localw = this.Cgn;
    AppMethodBeat.o(40849);
    return localw;
  }
  
  public final com.tencent.mm.plugin.game.model.a.g evq()
  {
    AppMethodBeat.i(40850);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (this.Cgo == null)
    {
      com.tencent.mm.kernel.h.aHH();
      this.Cgo = new com.tencent.mm.plugin.game.model.a.g(com.tencent.mm.kernel.h.aHG().kcF);
    }
    com.tencent.mm.plugin.game.model.a.g localg = this.Cgo;
    AppMethodBeat.o(40850);
    return localg;
  }
  
  public final com.tencent.mm.plugin.game.media.g evr()
  {
    AppMethodBeat.i(40851);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (this.Cgp == null)
    {
      com.tencent.mm.kernel.h.aHH();
      this.Cgp = new com.tencent.mm.plugin.game.media.g(com.tencent.mm.kernel.h.aHG().kcF);
    }
    com.tencent.mm.plugin.game.media.g localg = this.Cgp;
    AppMethodBeat.o(40851);
    return localg;
  }
  
  public final com.tencent.mm.plugin.game.media.d evs()
  {
    AppMethodBeat.i(40852);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (this.Cgq == null)
    {
      com.tencent.mm.kernel.h.aHH();
      this.Cgq = new com.tencent.mm.plugin.game.media.d(com.tencent.mm.kernel.h.aHG().kcF);
    }
    com.tencent.mm.plugin.game.media.d locald = this.Cgq;
    AppMethodBeat.o(40852);
    return locald;
  }
  
  public final com.tencent.mm.plugin.game.b.d evt()
  {
    AppMethodBeat.i(197823);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (this.Cgr == null)
    {
      com.tencent.mm.kernel.h.aHH();
      this.Cgr = new com.tencent.mm.plugin.game.b.d(com.tencent.mm.kernel.h.aHG().kcF);
    }
    com.tencent.mm.plugin.game.b.d locald = this.Cgr;
    AppMethodBeat.o(197823);
    return locald;
  }
  
  public final void onDataBaseClosed(com.tencent.mm.storagebase.h paramh1, com.tencent.mm.storagebase.h paramh2) {}
  
  public final void onDataBaseOpened(com.tencent.mm.storagebase.h paramh1, com.tencent.mm.storagebase.h paramh2)
  {
    AppMethodBeat.i(40846);
    Log.i("MicroMsg.GameStorage", "GameStorage onDataBaseOpened");
    this.Cgm = new s(paramh1);
    this.Cgo = new com.tencent.mm.plugin.game.model.a.g(paramh1);
    this.Cgp = new com.tencent.mm.plugin.game.media.g(paramh1);
    this.Cgq = new com.tencent.mm.plugin.game.media.d(paramh1);
    this.Cgr = new com.tencent.mm.plugin.game.b.d(paramh1);
    AppMethodBeat.o(40846);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.f
 * JD-Core Version:    0.7.0.1
 */