package com.tencent.mm.plugin.fts.c;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.h;
import com.tencent.mm.plugin.fts.a.i;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.wcdb.database.SQLiteStatement;

public final class d
  implements i
{
  private boolean isCreated;
  private boolean kuC;
  public h kuE;
  public SQLiteStatement kuF;
  public SQLiteStatement kuG;
  public SQLiteStatement kzS;
  
  public d()
  {
    y.i("MicroMsg.FTS.FTS5SOSHistoryStorage", "Create %s", new Object[] { "FTS5SOSHistoryStorage" });
  }
  
  public final String bG(String paramString, int paramInt)
  {
    return null;
  }
  
  public final void create()
  {
    y.i("MicroMsg.FTS.FTS5SOSHistoryStorage", "OnCreate %s | isCreated =%b", new Object[] { "FTS5SOSHistoryStorage", Boolean.valueOf(this.isCreated) });
    int i;
    if (!this.isCreated)
    {
      if (((n)g.t(n.class)).isFTSContextReady()) {
        break label75;
      }
      y.i("MicroMsg.FTS.FTS5SOSHistoryStorage", "Create Fail!");
      i = 0;
      if (i != 0)
      {
        y.i("MicroMsg.FTS.FTS5SOSHistoryStorage", "SetCreated");
        this.isCreated = true;
      }
    }
    return;
    label75:
    this.kuE = ((n)g.t(n.class)).getFTSIndexDB();
    y.i("MicroMsg.FTS.FTS5SOSHistoryStorage", "Create Success!");
    if ((this.kuE.DJ("FTS5IndexSOSHistory")) && (this.kuE.DJ("FTS5MetaSOSHistory"))) {
      y.d("MicroMsg.FTS.FTS5SOSHistoryStorage", "Table Exist, Not Need To Create");
    }
    for (;;)
    {
      String str1 = String.format("INSERT INTO %s (content) VALUES (?);", new Object[] { "FTS5IndexSOSHistory" });
      this.kuF = this.kuE.compileStatement(str1);
      str1 = String.format("INSERT INTO %s (docid, history, timestamp) VALUES (last_insert_rowid(), ?, ?);", new Object[] { "FTS5MetaSOSHistory" });
      this.kuG = this.kuE.compileStatement(str1);
      str1 = String.format("UPDATE %s SET timestamp=? WHERE docid = ?", new Object[] { "FTS5MetaSOSHistory" });
      this.kzS = this.kuE.compileStatement(str1);
      i = 1;
      break;
      y.d("MicroMsg.FTS.FTS5SOSHistoryStorage", "Table Not Exist, Need To Create");
      str1 = String.format("DROP TABLE IF EXISTS %s;", new Object[] { "FTS5IndexSOSHistory" });
      String str2 = String.format("DROP TABLE IF EXISTS %s;", new Object[] { "FTS5MetaSOSHistory" });
      this.kuE.execSQL(str1);
      this.kuE.execSQL(str2);
      str1 = String.format("CREATE VIRTUAL TABLE %s USING fts5(content, tokenize='mmSimple', prefix='1 2 3 4 5');", new Object[] { "FTS5IndexSOSHistory" });
      this.kuE.execSQL(str1);
      str1 = String.format("CREATE TABLE IF NOT EXISTS %s (docid INTEGER PRIMARY KEY, history TEXT, timestamp INTEGER);", new Object[] { "FTS5MetaSOSHistory" });
      this.kuE.execSQL(str1);
      this.kuE.execSQL(String.format("CREATE INDEX IF NOT EXISTS SOSHistory_history ON %s(history);", new Object[] { "FTS5MetaSOSHistory" }));
      this.kuE.execSQL(String.format("CREATE INDEX IF NOT EXISTS SOSHistory_timestamp ON %s(timestamp);", new Object[] { "FTS5MetaSOSHistory" }));
    }
  }
  
  public final void destroy()
  {
    y.i("MicroMsg.FTS.FTS5SOSHistoryStorage", "OnDestroy %s | isDestroyed %b | isCreated %b", new Object[] { "FTS5SOSHistoryStorage", Boolean.valueOf(this.kuC), Boolean.valueOf(this.isCreated) });
    if ((!this.kuC) && (this.isCreated))
    {
      this.kuF.close();
      this.kzS.close();
      this.kuG.close();
      y.i("MicroMsg.FTS.FTS5SOSHistoryStorage", "SetDestroyed");
      this.kuC = true;
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.c.d
 * JD-Core Version:    0.7.0.1
 */