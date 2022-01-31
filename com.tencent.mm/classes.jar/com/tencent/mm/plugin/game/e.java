package com.tencent.mm.plugin.game;

import com.tencent.mm.cf.h;
import com.tencent.mm.cf.h.d;
import com.tencent.mm.kernel.api.bucket.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.a.c;
import com.tencent.mm.plugin.game.model.a.f;
import com.tencent.mm.plugin.game.model.s;
import com.tencent.mm.plugin.game.model.x;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;

public final class e
  implements com.tencent.mm.kernel.api.bucket.a, d, c
{
  private s kLP;
  private x kLQ;
  private f kLR;
  
  public final s aYf()
  {
    g.DN().CX();
    if (this.kLP == null)
    {
      g.DQ();
      this.kLP = new s(g.DP().dKu);
    }
    return this.kLP;
  }
  
  public final x aYg()
  {
    g.DN().CX();
    if (this.kLQ == null)
    {
      g.DQ();
      this.kLQ = new x(g.DP().dKu);
    }
    return this.kLQ;
  }
  
  public final f aYh()
  {
    g.DN().CX();
    if (this.kLR == null)
    {
      g.DQ();
      this.kLR = new f(g.DP().dKu);
    }
    return this.kLR;
  }
  
  public final HashMap<Integer, h.d> collectDatabaseFactory()
  {
    y.i("MicroMsg.GameStorage", "GameStorage collectDatabaseFactory");
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf("GAME_CENTER_MSG_INFO_TABLE".hashCode()), new e.1(this));
    localHashMap.put(Integer.valueOf("GAME_CENTER_PB_CACHE_TABLE".hashCode()), new e.2(this));
    localHashMap.put(Integer.valueOf("GAME_CENTER_SILENT_DOWNLOAD_TABLE".hashCode()), new e.3(this));
    localHashMap.put(Integer.valueOf("CHECK_WEPKG_VERSION".hashCode()), new e.4(this));
    localHashMap.put(Integer.valueOf("WEPKG_PRELOAD_FILES".hashCode()), new e.5(this));
    return localHashMap;
  }
  
  public final void onDataBaseClosed(h paramh1, h paramh2) {}
  
  public final void onDataBaseOpened(h paramh1, h paramh2)
  {
    y.i("MicroMsg.GameStorage", "GameStorage onDataBaseOpened");
    this.kLP = new s(paramh1);
    this.kLR = new f(paramh1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.e
 * JD-Core Version:    0.7.0.1
 */