package com.tencent.mm.plugin.fts.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.h;
import com.tencent.mm.plugin.fts.a.i;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.wcdb.database.SQLiteStatement;

public final class d
  implements i
{
  private boolean bRJ;
  public h mQr;
  public SQLiteStatement mQs;
  public SQLiteStatement mQt;
  private boolean mVI;
  public SQLiteStatement mVJ;
  
  public d()
  {
    AppMethodBeat.i(136835);
    ab.i("MicroMsg.FTS.FTS5SOSHistoryStorage", "Create %s", new Object[] { "FTS5SOSHistoryStorage" });
    AppMethodBeat.o(136835);
  }
  
  public final String co(String paramString, int paramInt)
  {
    return null;
  }
  
  public final void create()
  {
    AppMethodBeat.i(136836);
    ab.i("MicroMsg.FTS.FTS5SOSHistoryStorage", "OnCreate %s | isCreated =%b", new Object[] { "FTS5SOSHistoryStorage", Boolean.valueOf(this.bRJ) });
    int i;
    if (!this.bRJ)
    {
      if (((n)g.G(n.class)).isFTSContextReady()) {
        break label85;
      }
      ab.i("MicroMsg.FTS.FTS5SOSHistoryStorage", "Create Fail!");
      i = 0;
      if (i != 0)
      {
        ab.i("MicroMsg.FTS.FTS5SOSHistoryStorage", "SetCreated");
        this.bRJ = true;
      }
    }
    AppMethodBeat.o(136836);
    return;
    label85:
    this.mQr = ((n)g.G(n.class)).getFTSIndexDB();
    ab.i("MicroMsg.FTS.FTS5SOSHistoryStorage", "Create Success!");
    if ((this.mQr.OS("FTS5IndexSOSHistory")) && (this.mQr.OS("FTS5MetaSOSHistory"))) {
      ab.d("MicroMsg.FTS.FTS5SOSHistoryStorage", "Table Exist, Not Need To Create");
    }
    for (;;)
    {
      String str1 = String.format("INSERT INTO %s (content) VALUES (?);", new Object[] { "FTS5IndexSOSHistory" });
      this.mQs = this.mQr.compileStatement(str1);
      str1 = String.format("INSERT INTO %s (docid, history, timestamp) VALUES (last_insert_rowid(), ?, ?);", new Object[] { "FTS5MetaSOSHistory" });
      this.mQt = this.mQr.compileStatement(str1);
      str1 = String.format("UPDATE %s SET timestamp=? WHERE docid = ?", new Object[] { "FTS5MetaSOSHistory" });
      this.mVJ = this.mQr.compileStatement(str1);
      i = 1;
      break;
      ab.d("MicroMsg.FTS.FTS5SOSHistoryStorage", "Table Not Exist, Need To Create");
      str1 = String.format("DROP TABLE IF EXISTS %s;", new Object[] { "FTS5IndexSOSHistory" });
      String str2 = String.format("DROP TABLE IF EXISTS %s;", new Object[] { "FTS5MetaSOSHistory" });
      this.mQr.execSQL(str1);
      this.mQr.execSQL(str2);
      str1 = String.format("CREATE VIRTUAL TABLE %s USING fts5(content, tokenize='mmSimple', prefix='1 2 3 4 5');", new Object[] { "FTS5IndexSOSHistory" });
      this.mQr.execSQL(str1);
      str1 = String.format("CREATE TABLE IF NOT EXISTS %s (docid INTEGER PRIMARY KEY, history TEXT, timestamp INTEGER);", new Object[] { "FTS5MetaSOSHistory" });
      this.mQr.execSQL(str1);
      this.mQr.execSQL(String.format("CREATE INDEX IF NOT EXISTS SOSHistory_history ON %s(history);", new Object[] { "FTS5MetaSOSHistory" }));
      this.mQr.execSQL(String.format("CREATE INDEX IF NOT EXISTS SOSHistory_timestamp ON %s(timestamp);", new Object[] { "FTS5MetaSOSHistory" }));
    }
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(136837);
    ab.i("MicroMsg.FTS.FTS5SOSHistoryStorage", "OnDestroy %s | isDestroyed %b | isCreated %b", new Object[] { "FTS5SOSHistoryStorage", Boolean.valueOf(this.mVI), Boolean.valueOf(this.bRJ) });
    if ((!this.mVI) && (this.bRJ))
    {
      this.mQs.close();
      this.mVJ.close();
      this.mQt.close();
      ab.i("MicroMsg.FTS.FTS5SOSHistoryStorage", "SetDestroyed");
      this.mVI = true;
    }
    AppMethodBeat.o(136837);
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