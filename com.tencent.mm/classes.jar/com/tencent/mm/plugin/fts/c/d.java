package com.tencent.mm.plugin.fts.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.h;
import com.tencent.mm.plugin.fts.a.i;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.wcdb.database.SQLiteStatement;

public final class d
  implements i
{
  private boolean aKE;
  private boolean czD;
  public h swc;
  public SQLiteStatement swe;
  
  public d()
  {
    AppMethodBeat.i(52808);
    ac.i("MicroMsg.FTS.FTS5SOSHistoryStorage", "Create %s", new Object[] { "FTS5SOSHistoryStorage" });
    AppMethodBeat.o(52808);
  }
  
  public final void create()
  {
    AppMethodBeat.i(52809);
    ac.i("MicroMsg.FTS.FTS5SOSHistoryStorage", "OnCreate %s | isCreated =%b", new Object[] { "FTS5SOSHistoryStorage", Boolean.valueOf(this.czD) });
    int i;
    if (!this.czD)
    {
      if (((n)g.ad(n.class)).isFTSContextReady()) {
        break label85;
      }
      ac.i("MicroMsg.FTS.FTS5SOSHistoryStorage", "Create Fail!");
      i = 0;
      if (i != 0)
      {
        ac.i("MicroMsg.FTS.FTS5SOSHistoryStorage", "SetCreated");
        this.czD = true;
      }
    }
    AppMethodBeat.o(52809);
    return;
    label85:
    this.swc = ((n)g.ad(n.class)).getFTSIndexDB();
    ac.i("MicroMsg.FTS.FTS5SOSHistoryStorage", "Create Success!");
    if ((this.swc.afI("FTS5MetaSOSHistory")) && (this.swc.fO(-109, 2))) {
      ac.i("MicroMsg.FTS.FTS5SOSHistoryStorage", "Table Exist, Not Need To Create");
    }
    for (;;)
    {
      String str1 = String.format("INSERT OR REPLACE INTO %s (key, timestamp, content) VALUES (?, ?, ?);", new Object[] { "FTS5MetaSOSHistory" });
      this.swe = this.swc.compileStatement(str1);
      i = 1;
      break;
      ac.i("MicroMsg.FTS.FTS5SOSHistoryStorage", "Table Not Exist, Need To Create");
      str1 = String.format("DROP TABLE IF EXISTS %s;", new Object[] { "FTS5IndexSOSHistory" });
      String str2 = String.format("DROP TABLE IF EXISTS %s;", new Object[] { "FTS5MetaSOSHistory" });
      this.swc.execSQL(str1);
      this.swc.execSQL(str2);
      str1 = String.format("CREATE TABLE IF NOT EXISTS %s (key TEXT PRIMARY KEY, timestamp INTEGER, content TEXT);", new Object[] { "FTS5MetaSOSHistory" });
      this.swc.execSQL(str1);
      this.swc.execSQL(String.format("CREATE INDEX IF NOT EXISTS SOSHistory_timestamp ON %s(timestamp);", new Object[] { "FTS5MetaSOSHistory" }));
      this.swc.R(-109L, 2L);
    }
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(52810);
    ac.i("MicroMsg.FTS.FTS5SOSHistoryStorage", "OnDestroy %s | isDestroyed %b | isCreated %b", new Object[] { "FTS5SOSHistoryStorage", Boolean.valueOf(this.aKE), Boolean.valueOf(this.czD) });
    if ((!this.aKE) && (this.czD))
    {
      this.swe.close();
      ac.i("MicroMsg.FTS.FTS5SOSHistoryStorage", "SetDestroyed");
      this.aKE = true;
    }
    AppMethodBeat.o(52810);
  }
  
  public final String jdMethod_do(String paramString, int paramInt)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.c.d
 * JD-Core Version:    0.7.0.1
 */