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
  private com.tencent.mm.plugin.game.b.d HSA;
  private s HSv;
  private w HSw;
  private com.tencent.mm.plugin.game.model.silent_download.g HSx;
  private com.tencent.mm.plugin.game.media.g HSy;
  private com.tencent.mm.plugin.game.media.d HSz;
  
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
        return com.tencent.mm.plugin.game.model.silent_download.g.SQL_CREATE;
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
        AppMethodBeat.i(275312);
        Object localObject = com.tencent.mm.plugin.game.b.d.Ity;
        localObject = com.tencent.mm.plugin.game.b.d.dZh();
        AppMethodBeat.o(275312);
        return localObject;
      }
    });
    AppMethodBeat.o(40847);
    return localHashMap;
  }
  
  public final s fCh()
  {
    AppMethodBeat.i(40848);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (this.HSv == null)
    {
      com.tencent.mm.kernel.h.baF();
      this.HSv = new s(com.tencent.mm.kernel.h.baE().mCN);
    }
    s locals = this.HSv;
    AppMethodBeat.o(40848);
    return locals;
  }
  
  public final w fCi()
  {
    AppMethodBeat.i(40849);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (this.HSw == null)
    {
      com.tencent.mm.kernel.h.baF();
      this.HSw = new w(com.tencent.mm.kernel.h.baE().mCN);
    }
    w localw = this.HSw;
    AppMethodBeat.o(40849);
    return localw;
  }
  
  public final com.tencent.mm.plugin.game.model.silent_download.g fCj()
  {
    AppMethodBeat.i(40850);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (this.HSx == null)
    {
      com.tencent.mm.kernel.h.baF();
      this.HSx = new com.tencent.mm.plugin.game.model.silent_download.g(com.tencent.mm.kernel.h.baE().mCN);
    }
    com.tencent.mm.plugin.game.model.silent_download.g localg = this.HSx;
    AppMethodBeat.o(40850);
    return localg;
  }
  
  public final com.tencent.mm.plugin.game.media.g fCk()
  {
    AppMethodBeat.i(40851);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (this.HSy == null)
    {
      com.tencent.mm.kernel.h.baF();
      this.HSy = new com.tencent.mm.plugin.game.media.g(com.tencent.mm.kernel.h.baE().mCN);
    }
    com.tencent.mm.plugin.game.media.g localg = this.HSy;
    AppMethodBeat.o(40851);
    return localg;
  }
  
  public final com.tencent.mm.plugin.game.media.d fCl()
  {
    AppMethodBeat.i(40852);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (this.HSz == null)
    {
      com.tencent.mm.kernel.h.baF();
      this.HSz = new com.tencent.mm.plugin.game.media.d(com.tencent.mm.kernel.h.baE().mCN);
    }
    com.tencent.mm.plugin.game.media.d locald = this.HSz;
    AppMethodBeat.o(40852);
    return locald;
  }
  
  public final com.tencent.mm.plugin.game.b.d fCm()
  {
    AppMethodBeat.i(275304);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (this.HSA == null)
    {
      com.tencent.mm.kernel.h.baF();
      this.HSA = new com.tencent.mm.plugin.game.b.d(com.tencent.mm.kernel.h.baE().mCN);
    }
    com.tencent.mm.plugin.game.b.d locald = this.HSA;
    AppMethodBeat.o(275304);
    return locald;
  }
  
  public final void onDataBaseClosed(com.tencent.mm.storagebase.h paramh1, com.tencent.mm.storagebase.h paramh2) {}
  
  public final void onDataBaseOpened(com.tencent.mm.storagebase.h paramh1, com.tencent.mm.storagebase.h paramh2)
  {
    AppMethodBeat.i(40846);
    Log.i("MicroMsg.GameStorage", "GameStorage onDataBaseOpened");
    this.HSv = new s(paramh1);
    this.HSx = new com.tencent.mm.plugin.game.model.silent_download.g(paramh1);
    this.HSy = new com.tencent.mm.plugin.game.media.g(paramh1);
    this.HSz = new com.tencent.mm.plugin.game.media.d(paramh1);
    this.HSA = new com.tencent.mm.plugin.game.b.d(paramh1);
    AppMethodBeat.o(40846);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.f
 * JD-Core Version:    0.7.0.1
 */