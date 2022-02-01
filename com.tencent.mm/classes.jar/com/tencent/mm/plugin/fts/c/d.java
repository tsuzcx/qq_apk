package com.tencent.mm.plugin.fts.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.h;
import com.tencent.mm.plugin.fts.a.i;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.wcdb.database.SQLiteStatement;

public final class d
  implements i
{
  private boolean aJO;
  private boolean cCu;
  public h rni;
  public SQLiteStatement rnk;
  
  public d()
  {
    AppMethodBeat.i(52808);
    ad.i("MicroMsg.FTS.FTS5SOSHistoryStorage", "Create %s", new Object[] { "FTS5SOSHistoryStorage" });
    AppMethodBeat.o(52808);
  }
  
  public final void create()
  {
    AppMethodBeat.i(52809);
    ad.i("MicroMsg.FTS.FTS5SOSHistoryStorage", "OnCreate %s | isCreated =%b", new Object[] { "FTS5SOSHistoryStorage", Boolean.valueOf(this.cCu) });
    int i;
    if (!this.cCu)
    {
      if (((n)g.ad(n.class)).isFTSContextReady()) {
        break label85;
      }
      ad.i("MicroMsg.FTS.FTS5SOSHistoryStorage", "Create Fail!");
      i = 0;
      if (i != 0)
      {
        ad.i("MicroMsg.FTS.FTS5SOSHistoryStorage", "SetCreated");
        this.cCu = true;
      }
    }
    AppMethodBeat.o(52809);
    return;
    label85:
    this.rni = ((n)g.ad(n.class)).getFTSIndexDB();
    ad.i("MicroMsg.FTS.FTS5SOSHistoryStorage", "Create Success!");
    if ((this.rni.aaQ("FTS5MetaSOSHistory")) && (this.rni.fH(-109, 2))) {
      ad.i("MicroMsg.FTS.FTS5SOSHistoryStorage", "Table Exist, Not Need To Create");
    }
    for (;;)
    {
      String str1 = String.format("INSERT OR REPLACE INTO %s (key, timestamp, content) VALUES (?, ?, ?);", new Object[] { "FTS5MetaSOSHistory" });
      this.rnk = this.rni.compileStatement(str1);
      i = 1;
      break;
      ad.i("MicroMsg.FTS.FTS5SOSHistoryStorage", "Table Not Exist, Need To Create");
      str1 = String.format("DROP TABLE IF EXISTS %s;", new Object[] { "FTS5IndexSOSHistory" });
      String str2 = String.format("DROP TABLE IF EXISTS %s;", new Object[] { "FTS5MetaSOSHistory" });
      this.rni.execSQL(str1);
      this.rni.execSQL(str2);
      str1 = String.format("CREATE TABLE IF NOT EXISTS %s (key TEXT PRIMARY KEY, timestamp INTEGER, content TEXT);", new Object[] { "FTS5MetaSOSHistory" });
      this.rni.execSQL(str1);
      this.rni.execSQL(String.format("CREATE INDEX IF NOT EXISTS SOSHistory_timestamp ON %s(timestamp);", new Object[] { "FTS5MetaSOSHistory" }));
      this.rni.U(-109L, 2L);
    }
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(52810);
    ad.i("MicroMsg.FTS.FTS5SOSHistoryStorage", "OnDestroy %s | isDestroyed %b | isCreated %b", new Object[] { "FTS5SOSHistoryStorage", Boolean.valueOf(this.aJO), Boolean.valueOf(this.cCu) });
    if ((!this.aJO) && (this.cCu))
    {
      this.rnk.close();
      ad.i("MicroMsg.FTS.FTS5SOSHistoryStorage", "SetDestroyed");
      this.aJO = true;
    }
    AppMethodBeat.o(52810);
  }
  
  public final String di(String paramString, int paramInt)
  {
    return null;
  }
  
  public final String getName()
  {
    return "FTS5SOSHistoryStorage";
  }
  
  public final int getPriority()
  {
    return 1024;
  }
  
  public final int getType()
  {
    return 1024;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.c.d
 * JD-Core Version:    0.7.0.1
 */