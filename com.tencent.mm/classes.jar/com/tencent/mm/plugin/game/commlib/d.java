package com.tencent.mm.plugin.game.commlib;

import com.tencent.mm.cf.h;
import com.tencent.mm.cf.h.d;
import com.tencent.mm.plugin.game.commlib.b.b;
import java.util.HashMap;

public final class d
  implements com.tencent.mm.kernel.api.bucket.a, com.tencent.mm.kernel.api.bucket.d, com.tencent.mm.plugin.game.commlib.a.a
{
  private b kMb;
  
  public final byte[] Ey(String paramString)
  {
    return this.kMb.Ey(paramString);
  }
  
  public final void Ez(String paramString)
  {
    this.kMb.Ez(paramString);
  }
  
  public final void a(String paramString, com.tencent.mm.bv.a parama)
  {
    this.kMb.b(paramString, parama);
  }
  
  public final HashMap<Integer, h.d> collectDatabaseFactory()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf("GAME_CENTER_MSG_INFO_TABLE".hashCode()), new d.1(this));
    return localHashMap;
  }
  
  public final void onDataBaseClosed(h paramh1, h paramh2) {}
  
  public final void onDataBaseOpened(h paramh1, h paramh2)
  {
    this.kMb = new b(paramh1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.commlib.d
 * JD-Core Version:    0.7.0.1
 */