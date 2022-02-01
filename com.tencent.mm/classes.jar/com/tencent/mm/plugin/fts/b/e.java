package com.tencent.mm.plugin.fts.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.i;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.wcdb.database.SQLiteStatement;

public final class e
  implements i
{
  public com.tencent.mm.plugin.fts.a.h HqR;
  public SQLiteStatement HqT;
  private boolean aUP;
  private boolean feX;
  
  public e()
  {
    AppMethodBeat.i(52808);
    Log.i("MicroMsg.FTS.FTS5SOSHistoryStorage", "Create %s", new Object[] { "FTS5SOSHistoryStorage" });
    AppMethodBeat.o(52808);
  }
  
  public static String fxn()
  {
    return "FTS5MetaSOSHistory";
  }
  
  public static String fxo()
  {
    return "FTS5IndexSOSHistory";
  }
  
  public final void create()
  {
    AppMethodBeat.i(52809);
    Log.i("MicroMsg.FTS.FTS5SOSHistoryStorage", "OnCreate %s | isCreated =%b", new Object[] { "FTS5SOSHistoryStorage", Boolean.valueOf(this.feX) });
    int i;
    if (!this.feX)
    {
      if (((n)com.tencent.mm.kernel.h.az(n.class)).isFTSContextReady()) {
        break label85;
      }
      Log.i("MicroMsg.FTS.FTS5SOSHistoryStorage", "Create Fail!");
      i = 0;
      if (i != 0)
      {
        Log.i("MicroMsg.FTS.FTS5SOSHistoryStorage", "SetCreated");
        this.feX = true;
      }
    }
    AppMethodBeat.o(52809);
    return;
    label85:
    this.HqR = ((n)com.tencent.mm.kernel.h.az(n.class)).getFTSIndexDB();
    Log.i("MicroMsg.FTS.FTS5SOSHistoryStorage", "Create Success!");
    if ((this.HqR.aDZ(fxn())) && (this.HqR.iV(-109, 2))) {
      Log.i("MicroMsg.FTS.FTS5SOSHistoryStorage", "Table Exist, Not Need To Create");
    }
    for (;;)
    {
      String str1 = String.format("INSERT OR REPLACE INTO %s (key, timestamp, content) VALUES (?, ?, ?);", new Object[] { fxn() });
      this.HqT = this.HqR.compileStatement(str1);
      i = 1;
      break;
      Log.i("MicroMsg.FTS.FTS5SOSHistoryStorage", "Table Not Exist, Need To Create");
      str1 = String.format("DROP TABLE IF EXISTS %s;", new Object[] { fxo() });
      String str2 = String.format("DROP TABLE IF EXISTS %s;", new Object[] { fxn() });
      this.HqR.execSQL(str1);
      this.HqR.execSQL(str2);
      str1 = String.format("CREATE TABLE IF NOT EXISTS %s (key TEXT PRIMARY KEY, timestamp INTEGER, content TEXT);", new Object[] { fxn() });
      this.HqR.execSQL(str1);
      this.HqR.execSQL(String.format("CREATE INDEX IF NOT EXISTS SOSHistory_timestamp ON %s(timestamp);", new Object[] { fxn() }));
      this.HqR.aG(-109L, 2L);
    }
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(52810);
    Log.i("MicroMsg.FTS.FTS5SOSHistoryStorage", "OnDestroy %s | isDestroyed %b | isCreated %b", new Object[] { "FTS5SOSHistoryStorage", Boolean.valueOf(this.aUP), Boolean.valueOf(this.feX) });
    if ((!this.aUP) && (this.feX))
    {
      this.HqT.close();
      Log.i("MicroMsg.FTS.FTS5SOSHistoryStorage", "SetDestroyed");
      this.aUP = true;
    }
    AppMethodBeat.o(52810);
  }
  
  public final String fj(String paramString, int paramInt)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.e
 * JD-Core Version:    0.7.0.1
 */