package com.tencent.mm.plugin.game;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.model.s;
import com.tencent.mm.plugin.game.model.w;
import com.tencent.mm.plugin.wepkg.b.b;
import com.tencent.mm.plugin.wepkg.b.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public final class e
  implements com.tencent.mm.kernel.api.bucket.a, com.tencent.mm.kernel.api.bucket.d, com.tencent.mm.plugin.game.api.e
{
  private s rNo;
  private w rNp;
  private com.tencent.mm.plugin.game.model.a.g rNq;
  private com.tencent.mm.plugin.game.media.g rNr;
  private com.tencent.mm.plugin.game.media.d rNs;
  
  public final s cBd()
  {
    AppMethodBeat.i(40848);
    com.tencent.mm.kernel.g.afz().aeD();
    if (this.rNo == null)
    {
      com.tencent.mm.kernel.g.afC();
      this.rNo = new s(com.tencent.mm.kernel.g.afB().gda);
    }
    s locals = this.rNo;
    AppMethodBeat.o(40848);
    return locals;
  }
  
  public final w cBe()
  {
    AppMethodBeat.i(40849);
    com.tencent.mm.kernel.g.afz().aeD();
    if (this.rNp == null)
    {
      com.tencent.mm.kernel.g.afC();
      this.rNp = new w(com.tencent.mm.kernel.g.afB().gda);
    }
    w localw = this.rNp;
    AppMethodBeat.o(40849);
    return localw;
  }
  
  public final com.tencent.mm.plugin.game.model.a.g cBf()
  {
    AppMethodBeat.i(40850);
    com.tencent.mm.kernel.g.afz().aeD();
    if (this.rNq == null)
    {
      com.tencent.mm.kernel.g.afC();
      this.rNq = new com.tencent.mm.plugin.game.model.a.g(com.tencent.mm.kernel.g.afB().gda);
    }
    com.tencent.mm.plugin.game.model.a.g localg = this.rNq;
    AppMethodBeat.o(40850);
    return localg;
  }
  
  public final com.tencent.mm.plugin.game.media.g cBg()
  {
    AppMethodBeat.i(40851);
    com.tencent.mm.kernel.g.afz().aeD();
    if (this.rNr == null)
    {
      com.tencent.mm.kernel.g.afC();
      this.rNr = new com.tencent.mm.plugin.game.media.g(com.tencent.mm.kernel.g.afB().gda);
    }
    com.tencent.mm.plugin.game.media.g localg = this.rNr;
    AppMethodBeat.o(40851);
    return localg;
  }
  
  public final com.tencent.mm.plugin.game.media.d cBh()
  {
    AppMethodBeat.i(40852);
    com.tencent.mm.kernel.g.afz().aeD();
    if (this.rNs == null)
    {
      com.tencent.mm.kernel.g.afC();
      this.rNs = new com.tencent.mm.plugin.game.media.d(com.tencent.mm.kernel.g.afB().gda);
    }
    com.tencent.mm.plugin.game.media.d locald = this.rNs;
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
    localHashMap.put(Integer.valueOf("CHECK_WEPKG_VERSION".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return f.SQL_CREATE;
      }
    });
    localHashMap.put(Integer.valueOf("WEPKG_PRELOAD_FILES".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.wepkg.b.d.SQL_CREATE;
      }
    });
    localHashMap.put(Integer.valueOf("WEPKG_DIFF_PACK".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return b.SQL_CREATE;
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
    this.rNo = new s(paramh1);
    this.rNq = new com.tencent.mm.plugin.game.model.a.g(paramh1);
    this.rNr = new com.tencent.mm.plugin.game.media.g(paramh1);
    this.rNs = new com.tencent.mm.plugin.game.media.d(paramh1);
    AppMethodBeat.o(40846);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.e
 * JD-Core Version:    0.7.0.1
 */