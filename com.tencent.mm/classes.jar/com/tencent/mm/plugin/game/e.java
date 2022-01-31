package com.tencent.mm.plugin.game;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.kernel.api.bucket.d;
import com.tencent.mm.plugin.game.media.c;
import com.tencent.mm.plugin.game.media.f;
import com.tencent.mm.plugin.game.model.r;
import com.tencent.mm.plugin.game.model.w;
import com.tencent.mm.plugin.wepkg.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;

public final class e
  implements com.tencent.mm.kernel.api.bucket.a, d, com.tencent.mm.plugin.game.api.e
{
  private r nit;
  private w niu;
  private com.tencent.mm.plugin.game.model.a.g niv;
  private f niw;
  private c nix;
  
  public final r bES()
  {
    AppMethodBeat.i(111174);
    com.tencent.mm.kernel.g.RJ().QQ();
    if (this.nit == null)
    {
      com.tencent.mm.kernel.g.RM();
      this.nit = new r(com.tencent.mm.kernel.g.RL().eHS);
    }
    r localr = this.nit;
    AppMethodBeat.o(111174);
    return localr;
  }
  
  public final w bET()
  {
    AppMethodBeat.i(111175);
    com.tencent.mm.kernel.g.RJ().QQ();
    if (this.niu == null)
    {
      com.tencent.mm.kernel.g.RM();
      this.niu = new w(com.tencent.mm.kernel.g.RL().eHS);
    }
    w localw = this.niu;
    AppMethodBeat.o(111175);
    return localw;
  }
  
  public final com.tencent.mm.plugin.game.model.a.g bEU()
  {
    AppMethodBeat.i(111176);
    com.tencent.mm.kernel.g.RJ().QQ();
    if (this.niv == null)
    {
      com.tencent.mm.kernel.g.RM();
      this.niv = new com.tencent.mm.plugin.game.model.a.g(com.tencent.mm.kernel.g.RL().eHS);
    }
    com.tencent.mm.plugin.game.model.a.g localg = this.niv;
    AppMethodBeat.o(111176);
    return localg;
  }
  
  public final f bEV()
  {
    AppMethodBeat.i(151786);
    com.tencent.mm.kernel.g.RJ().QQ();
    if (this.niw == null)
    {
      com.tencent.mm.kernel.g.RM();
      this.niw = new f(com.tencent.mm.kernel.g.RL().eHS);
    }
    f localf = this.niw;
    AppMethodBeat.o(151786);
    return localf;
  }
  
  public final c bEW()
  {
    AppMethodBeat.i(151787);
    com.tencent.mm.kernel.g.RJ().QQ();
    if (this.nix == null)
    {
      com.tencent.mm.kernel.g.RM();
      this.nix = new c(com.tencent.mm.kernel.g.RL().eHS);
    }
    c localc = this.nix;
    AppMethodBeat.o(151787);
    return localc;
  }
  
  public final HashMap<Integer, h.d> collectDatabaseFactory()
  {
    AppMethodBeat.i(111173);
    ab.i("MicroMsg.GameStorage", "GameStorage collectDatabaseFactory");
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf("GAME_CENTER_MSG_INFO_TABLE".hashCode()), new e.1(this));
    localHashMap.put(Integer.valueOf("GAME_CENTER_PB_CACHE_TABLE".hashCode()), new e.2(this));
    localHashMap.put(Integer.valueOf("GAME_CENTER_SILENT_DOWNLOAD_TABLE".hashCode()), new e.3(this));
    localHashMap.put(Integer.valueOf("CHECK_WEPKG_VERSION".hashCode()), new e.4(this));
    localHashMap.put(Integer.valueOf("WEPKG_PRELOAD_FILES".hashCode()), new e.5(this));
    localHashMap.put(Integer.valueOf("WEPKG_DIFF_PACK".hashCode()), new h.d()
    {
      public final String[] getSQLs()
      {
        return b.SQL_CREATE;
      }
    });
    localHashMap.put(Integer.valueOf("GAME_HAOWAN_EDITION".hashCode()), new e.7(this));
    localHashMap.put(Integer.valueOf("GAME_HAOWAN_MEDIA".hashCode()), new e.8(this));
    AppMethodBeat.o(111173);
    return localHashMap;
  }
  
  public final void onDataBaseClosed(h paramh1, h paramh2) {}
  
  public final void onDataBaseOpened(h paramh1, h paramh2)
  {
    AppMethodBeat.i(111172);
    ab.i("MicroMsg.GameStorage", "GameStorage onDataBaseOpened");
    this.nit = new r(paramh1);
    this.niv = new com.tencent.mm.plugin.game.model.a.g(paramh1);
    this.niw = new f(paramh1);
    this.nix = new c(paramh1);
    AppMethodBeat.o(111172);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.e
 * JD-Core Version:    0.7.0.1
 */