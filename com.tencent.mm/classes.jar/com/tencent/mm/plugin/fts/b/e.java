package com.tencent.mm.plugin.fts.b;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.b;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.wcdb.database.SQLiteStatement;
import java.util.HashMap;
import java.util.HashSet;

public final class e
  extends b
{
  private m dBO;
  com.tencent.mm.plugin.fts.c.e kzv;
  HashSet<String> kzw;
  
  protected final boolean BB()
  {
    if (this.kzw != null) {
      this.kzw.clear();
    }
    this.kzv = null;
    this.dBO = null;
    return true;
  }
  
  public final void Ed(String paramString)
  {
    if (this.kzw.add(paramString))
    {
      com.tencent.mm.plugin.fts.c.e locale = this.kzv;
      locale.kzV.bindLong(1, 1L);
      locale.kzV.bindString(2, paramString);
      locale.kzV.execute();
    }
  }
  
  public final a a(i parami)
  {
    parami = new e.b(this, parami);
    return this.dBO.a(-65536, parami);
  }
  
  public final void a(String paramString, l paraml, int paramInt, HashMap<String, String> paramHashMap)
  {
    e.c localc = new e.c(this, (byte)0);
    e.c.a(localc, paramString);
    e.c.a(localc, paraml);
    e.c.a(localc, paramInt);
    e.c.a(localc, paramHashMap);
    this.dBO.a(65626, localc);
  }
  
  public final void d(int[] paramArrayOfInt, String paramString)
  {
    this.kzv.b(paramArrayOfInt, paramString);
  }
  
  public final String getName()
  {
    return "FTS5SearchTopHitsLogic";
  }
  
  protected final boolean onCreate()
  {
    if (!((n)g.t(n.class)).isFTSContextReady())
    {
      y.i("MicroMsg.FTS.FTS5SearchTopHitsLogic", "Create Fail!");
      return false;
    }
    y.i("MicroMsg.FTS.FTS5SearchTopHitsLogic", "Create Success!");
    this.kzw = new HashSet();
    this.kzv = ((com.tencent.mm.plugin.fts.c.e)((n)g.t(n.class)).getFTSIndexStorage(1));
    this.dBO = ((n)g.t(n.class)).getFTSTaskDaemon();
    this.dBO.a(65626, new e.a(this, (byte)0));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.e
 * JD-Core Version:    0.7.0.1
 */