package com.tencent.mm.plugin.fav.b.a;

import com.tencent.mm.plugin.fts.a.c;
import com.tencent.mm.sdk.platformtools.y;

final class b$b
  extends com.tencent.mm.plugin.fts.a.a.a
{
  private long kau;
  
  public b$b(b paramb, long paramLong)
  {
    this.kau = paramLong;
  }
  
  public final String afJ()
  {
    return String.format("{favItemId: %d}", new Object[] { Long.valueOf(this.kau) });
  }
  
  public final boolean execute()
  {
    y.d("MicroMsg.FTS.FTS5SearchFavoriteLogic", "start to delete favorite item");
    long l = this.kau;
    this.kap.kam.c(c.kuO, l);
    return true;
  }
  
  public final String getName()
  {
    return "DeleteFavItemTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.b.a.b.b
 * JD-Core Version:    0.7.0.1
 */