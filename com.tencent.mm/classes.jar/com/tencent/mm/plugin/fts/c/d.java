package com.tencent.mm.plugin.fts.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.i;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.wcdb.database.SQLiteStatement;

public final class d
  implements i
{
  public com.tencent.mm.plugin.fts.a.h BGp;
  public SQLiteStatement BGr;
  private boolean aJQ;
  private boolean dfI;
  
  public d()
  {
    AppMethodBeat.i(52808);
    Log.i("MicroMsg.FTS.FTS5SOSHistoryStorage", "Create %s", new Object[] { "FTS5SOSHistoryStorage" });
    AppMethodBeat.o(52808);
  }
  
  public static String eqI()
  {
    return "FTS5MetaSOSHistory";
  }
  
  public static String eqJ()
  {
    return "FTS5IndexSOSHistory";
  }
  
  public final void create()
  {
    AppMethodBeat.i(52809);
    Log.i("MicroMsg.FTS.FTS5SOSHistoryStorage", "OnCreate %s | isCreated =%b", new Object[] { "FTS5SOSHistoryStorage", Boolean.valueOf(this.dfI) });
    int i;
    if (!this.dfI)
    {
      if (((n)com.tencent.mm.kernel.h.ag(n.class)).isFTSContextReady()) {
        break label85;
      }
      Log.i("MicroMsg.FTS.FTS5SOSHistoryStorage", "Create Fail!");
      i = 0;
      if (i != 0)
      {
        Log.i("MicroMsg.FTS.FTS5SOSHistoryStorage", "SetCreated");
        this.dfI = true;
      }
    }
    AppMethodBeat.o(52809);
    return;
    label85:
    this.BGp = ((n)com.tencent.mm.kernel.h.ag(n.class)).getFTSIndexDB();
    Log.i("MicroMsg.FTS.FTS5SOSHistoryStorage", "Create Success!");
    if ((this.BGp.aHB(eqI())) && (this.BGp.hw(-109, 2))) {
      Log.i("MicroMsg.FTS.FTS5SOSHistoryStorage", "Table Exist, Not Need To Create");
    }
    for (;;)
    {
      String str1 = String.format("INSERT OR REPLACE INTO %s (key, timestamp, content) VALUES (?, ?, ?);", new Object[] { eqI() });
      this.BGr = this.BGp.compileStatement(str1);
      i = 1;
      break;
      Log.i("MicroMsg.FTS.FTS5SOSHistoryStorage", "Table Not Exist, Need To Create");
      str1 = String.format("DROP TABLE IF EXISTS %s;", new Object[] { eqJ() });
      String str2 = String.format("DROP TABLE IF EXISTS %s;", new Object[] { eqI() });
      this.BGp.execSQL(str1);
      this.BGp.execSQL(str2);
      str1 = String.format("CREATE TABLE IF NOT EXISTS %s (key TEXT PRIMARY KEY, timestamp INTEGER, content TEXT);", new Object[] { eqI() });
      this.BGp.execSQL(str1);
      this.BGp.execSQL(String.format("CREATE INDEX IF NOT EXISTS SOSHistory_timestamp ON %s(timestamp);", new Object[] { eqI() }));
      this.BGp.ad(-109L, 2L);
    }
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(52810);
    Log.i("MicroMsg.FTS.FTS5SOSHistoryStorage", "OnDestroy %s | isDestroyed %b | isCreated %b", new Object[] { "FTS5SOSHistoryStorage", Boolean.valueOf(this.aJQ), Boolean.valueOf(this.dfI) });
    if ((!this.aJQ) && (this.dfI))
    {
      this.BGr.close();
      Log.i("MicroMsg.FTS.FTS5SOSHistoryStorage", "SetDestroyed");
      this.aJQ = true;
    }
    AppMethodBeat.o(52810);
  }
  
  public final String eu(String paramString, int paramInt)
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