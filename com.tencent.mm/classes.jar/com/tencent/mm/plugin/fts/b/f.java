package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.message.b.b;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.wcdb.database.SQLiteException;
import com.tencent.wcdb.database.SQLiteStatement;
import java.util.ArrayList;

public final class f
  extends com.tencent.mm.plugin.fts.a.a
{
  private SQLiteStatement HwF;
  
  public static Cursor c(j paramj)
  {
    AppMethodBeat.i(265424);
    paramj = paramj.Hte;
    paramj = ((b)com.tencent.mm.kernel.h.az(b.class)).getNotifyMessageRecordStorage().Ho(paramj);
    AppMethodBeat.o(265424);
    return paramj;
  }
  
  public final Cursor a(j paramj, String paramString)
  {
    AppMethodBeat.i(265445);
    paramj = paramj.fxx();
    String str1 = fxn();
    String str2 = fxo();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SELECT ").append(str1).append(".docid, type, subtype, entity_id, aux_index, timestamp, talker FROM ").append(str1).append(" JOIN ").append(str2).append(" ON (").append(str1).append(".docid = ").append(str2).append(".rowid) WHERE ").append(str2).append(" MATCH '").append(paramj).append("' AND aux_index = 'notifymessage' AND status >= 0 ");
    if (!Util.isNullOrNil(paramString)) {
      localStringBuilder.append("AND talker = ? ");
    }
    localStringBuilder.append("ORDER BY timestamp desc;");
    paramj = null;
    if (!Util.isNullOrNil(paramString))
    {
      paramj = new String[1];
      paramj[0] = paramString;
    }
    paramj = this.HqR.rawQuery(localStringBuilder.toString(), paramj);
    AppMethodBeat.o(265445);
    return paramj;
  }
  
  public final void a(int paramInt, long paramLong1, String paramString1, long paramLong2, String paramString2, String paramString3)
  {
    AppMethodBeat.i(265456);
    try
    {
      fxq().bindString(1, paramString2);
      fxq().execute();
      this.HwF.bindLong(1, 524288L);
      this.HwF.bindLong(2, paramInt);
      this.HwF.bindLong(3, paramLong1);
      this.HwF.bindString(4, paramString1);
      this.HwF.bindLong(5, paramLong2);
      this.HwF.bindString(6, paramString3);
      this.HwF.execute();
      AppMethodBeat.o(265456);
      return;
    }
    catch (SQLiteException paramString2)
    {
      Log.e("MicroMsg.FTS.FTS5ServiceNotifyStorage", String.format("Failed inserting index: 0x%x, %d, %d, %s, %d", new Object[] { Integer.valueOf(524288), Integer.valueOf(paramInt), Long.valueOf(paramLong1), paramString1, Long.valueOf(paramLong2) }));
      paramString1 = fxp().simpleQueryForString();
      if ((paramString1 != null) && (paramString1.length() > 0)) {
        Log.e("MicroMsg.FTS.FTS5ServiceNotifyStorage", ">> ".concat(String.valueOf(paramString1)));
      }
      AppMethodBeat.o(265456);
      throw paramString2;
    }
  }
  
  public final void a(int[] paramArrayOfInt, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(265442);
    ArrayList localArrayList = new ArrayList(4);
    paramArrayOfInt = String.format("SELECT docid FROM %s WHERE type IN " + d.G(paramArrayOfInt) + " AND entity_id=? AND timestamp=?;", new Object[] { fxn() });
    paramArrayOfInt = this.HqR.rawQuery(paramArrayOfInt, new String[] { Long.toString(paramLong1), Long.toString(paramLong2) });
    while (paramArrayOfInt.moveToNext()) {
      localArrayList.add(Long.valueOf(paramArrayOfInt.getLong(0)));
    }
    paramArrayOfInt.close();
    hP(localArrayList);
    AppMethodBeat.o(265442);
  }
  
  public final void aXv()
  {
    AppMethodBeat.i(265428);
    if (aXw())
    {
      this.HqR.aG(-111L, 1L);
      this.HqR.aG(-201L, 9223372036854775807L);
    }
    this.HqR.execSQL(String.format("CREATE INDEX IF NOT EXISTS %s_timestamp ON %s(timestamp);", new Object[] { fxn(), fxn() }));
    this.HqR.execSQL(String.format("CREATE INDEX IF NOT EXISTS %s_talker ON %s(talker);", new Object[] { fxn(), fxn() }));
    String str = String.format("INSERT INTO %s (docid, type, subtype, entity_id, aux_index, timestamp, talker) VALUES (last_insert_rowid(), ?, ?, ?, ?, ?, ?);", new Object[] { fxn() });
    this.HwF = this.HqR.compileStatement(str);
    AppMethodBeat.o(265428);
  }
  
  public final boolean aXw()
  {
    AppMethodBeat.i(265448);
    if (!iV(-111, 1))
    {
      AppMethodBeat.o(265448);
      return true;
    }
    AppMethodBeat.o(265448);
    return false;
  }
  
  public final boolean aXx()
  {
    AppMethodBeat.i(265432);
    this.HwF.close();
    boolean bool = super.aXx();
    AppMethodBeat.o(265432);
    return bool;
  }
  
  public final String dRh()
  {
    AppMethodBeat.i(265452);
    String str = String.format("CREATE TABLE IF NOT EXISTS %s (docid INTEGER PRIMARY KEY, type INT, subtype INT DEFAULT 0, entity_id INTEGER, aux_index TEXT, timestamp INTEGER, status INT DEFAULT 0, talker TEXT);", new Object[] { fxn() });
    AppMethodBeat.o(265452);
    return str;
  }
  
  public final String getName()
  {
    return "FTS5NotifyServiceStorage";
  }
  
  public final int getPriority()
  {
    return 1536;
  }
  
  public final String getTableName()
  {
    return "ServiceNotify";
  }
  
  public final int getType()
  {
    return 1536;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.f
 * JD-Core Version:    0.7.0.1
 */