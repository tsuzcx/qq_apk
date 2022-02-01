package com.tencent.mm.plugin.fts.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.h;
import com.tencent.mm.plugin.fts.a.i;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.wcdb.database.SQLiteStatement;

public final class d
  implements i
{
  private boolean aMn;
  private boolean dbG;
  public h wUt;
  public SQLiteStatement wUv;
  
  public d()
  {
    AppMethodBeat.i(52808);
    Log.i("MicroMsg.FTS.FTS5SOSHistoryStorage", "Create %s", new Object[] { "FTS5SOSHistoryStorage" });
    AppMethodBeat.o(52808);
  }
  
  public static String dOt()
  {
    return "FTS5MetaSOSHistory";
  }
  
  public static String dOu()
  {
    return "FTS5IndexSOSHistory";
  }
  
  public final void create()
  {
    AppMethodBeat.i(52809);
    Log.i("MicroMsg.FTS.FTS5SOSHistoryStorage", "OnCreate %s | isCreated =%b", new Object[] { "FTS5SOSHistoryStorage", Boolean.valueOf(this.dbG) });
    int i;
    if (!this.dbG)
    {
      if (((n)g.ah(n.class)).isFTSContextReady()) {
        break label85;
      }
      Log.i("MicroMsg.FTS.FTS5SOSHistoryStorage", "Create Fail!");
      i = 0;
      if (i != 0)
      {
        Log.i("MicroMsg.FTS.FTS5SOSHistoryStorage", "SetCreated");
        this.dbG = true;
      }
    }
    AppMethodBeat.o(52809);
    return;
    label85:
    this.wUt = ((n)g.ah(n.class)).getFTSIndexDB();
    Log.i("MicroMsg.FTS.FTS5SOSHistoryStorage", "Create Success!");
    if ((this.wUt.ayi(dOt())) && (this.wUt.gD(-109, 2))) {
      Log.i("MicroMsg.FTS.FTS5SOSHistoryStorage", "Table Exist, Not Need To Create");
    }
    for (;;)
    {
      String str1 = String.format("INSERT OR REPLACE INTO %s (key, timestamp, content) VALUES (?, ?, ?);", new Object[] { dOt() });
      this.wUv = this.wUt.compileStatement(str1);
      i = 1;
      break;
      Log.i("MicroMsg.FTS.FTS5SOSHistoryStorage", "Table Not Exist, Need To Create");
      str1 = String.format("DROP TABLE IF EXISTS %s;", new Object[] { dOu() });
      String str2 = String.format("DROP TABLE IF EXISTS %s;", new Object[] { dOt() });
      this.wUt.execSQL(str1);
      this.wUt.execSQL(str2);
      str1 = String.format("CREATE TABLE IF NOT EXISTS %s (key TEXT PRIMARY KEY, timestamp INTEGER, content TEXT);", new Object[] { dOt() });
      this.wUt.execSQL(str1);
      this.wUt.execSQL(String.format("CREATE INDEX IF NOT EXISTS SOSHistory_timestamp ON %s(timestamp);", new Object[] { dOt() }));
      this.wUt.W(-109L, 2L);
    }
  }
  
  public final String dX(String paramString, int paramInt)
  {
    return null;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(52810);
    Log.i("MicroMsg.FTS.FTS5SOSHistoryStorage", "OnDestroy %s | isDestroyed %b | isCreated %b", new Object[] { "FTS5SOSHistoryStorage", Boolean.valueOf(this.aMn), Boolean.valueOf(this.dbG) });
    if ((!this.aMn) && (this.dbG))
    {
      this.wUv.close();
      Log.i("MicroMsg.FTS.FTS5SOSHistoryStorage", "SetDestroyed");
      this.aMn = true;
    }
    AppMethodBeat.o(52810);
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