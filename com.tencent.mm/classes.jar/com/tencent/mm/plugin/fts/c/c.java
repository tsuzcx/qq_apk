package com.tencent.mm.plugin.fts.c;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.wcdb.database.SQLiteException;
import com.tencent.wcdb.database.SQLiteStatement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class c
  extends a
{
  private SQLiteStatement BLI;
  private SQLiteStatement BLJ;
  
  public final Cursor a(com.tencent.mm.plugin.fts.a.a.h paramh, String paramString, Set<String> paramSet)
  {
    AppMethodBeat.i(52803);
    String str1 = paramh.eqQ();
    if (!Util.isNullOrNil(paramString)) {}
    for (paramh = String.format(" AND aux_index = '%s'", new Object[] { paramString });; paramh = "")
    {
      paramString = new StringBuffer();
      paramSet = paramSet.iterator();
      while (paramSet.hasNext())
      {
        String str2 = (String)paramSet.next();
        paramString.append("'");
        paramString.append(str2);
        paramString.append("'");
        paramString.append(",");
      }
      if (paramString.length() > 0) {}
      for (paramString = " AND talker IN (" + paramString.substring(0, paramString.length() - 1) + ")";; paramString = "")
      {
        paramh = String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp, talker FROM %s JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s'" + paramString + paramh + " AND status >= 0;", new Object[] { eqI(), eqI(), eqJ(), eqI(), eqJ(), eqJ(), str1 });
        paramh = this.BGp.rawQuery(paramh, null);
        AppMethodBeat.o(52803);
        return paramh;
      }
    }
  }
  
  public final Cursor a(com.tencent.mm.plugin.fts.a.a.h paramh, List<String> paramList)
  {
    AppMethodBeat.i(52804);
    paramh = paramh.eqQ();
    Object localObject = new StringBuffer();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      ((StringBuffer)localObject).append("'");
      ((StringBuffer)localObject).append(str);
      ((StringBuffer)localObject).append("',");
    }
    localObject = ((StringBuffer)localObject).substring(0, ((StringBuffer)localObject).length() - 1);
    paramh = String.format("SELECT MessageCount(%d, aux_index) FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND aux_index IN (%s) AND status >= 0;", new Object[] { Integer.valueOf(paramList.size()), eqI(), eqJ(), eqI(), eqJ(), eqJ(), paramh, localObject });
    paramh = this.BGp.rawQuery(paramh, null);
    AppMethodBeat.o(52804);
    return paramh;
  }
  
  public final void a(int paramInt, long paramLong1, String paramString1, long paramLong2, String paramString2, String paramString3)
  {
    AppMethodBeat.i(52807);
    try
    {
      eqL().bindString(1, paramString2);
      eqL().execute();
      this.BLJ.bindLong(1, 65536L);
      this.BLJ.bindLong(2, paramInt);
      this.BLJ.bindLong(3, paramLong1);
      this.BLJ.bindString(4, paramString1);
      this.BLJ.bindLong(5, paramLong2);
      this.BLJ.bindString(6, paramString3);
      this.BLJ.execute();
      AppMethodBeat.o(52807);
      return;
    }
    catch (SQLiteException paramString2)
    {
      Log.e("MicroMsg.FTS.FTS5MessageStorage", String.format("Failed inserting index: 0x%x, %d, %d, %s, %d", new Object[] { Integer.valueOf(65536), Integer.valueOf(paramInt), Long.valueOf(paramLong1), paramString1, Long.valueOf(paramLong2) }));
      paramString1 = eqK().simpleQueryForString();
      if ((paramString1 != null) && (paramString1.length() > 0)) {
        Log.e("MicroMsg.FTS.FTS5MessageStorage", ">> ".concat(String.valueOf(paramString1)));
      }
      AppMethodBeat.o(52807);
      throw paramString2;
    }
  }
  
  public final void a(int[] paramArrayOfInt, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(52802);
    ArrayList localArrayList = new ArrayList(4);
    paramArrayOfInt = String.format("SELECT docid FROM %s WHERE type IN " + d.C(paramArrayOfInt) + " AND entity_id=? AND timestamp=?;", new Object[] { eqI() });
    paramArrayOfInt = this.BGp.rawQuery(paramArrayOfInt, new String[] { Long.toString(paramLong1), Long.toString(paramLong2) });
    while (paramArrayOfInt.moveToNext()) {
      localArrayList.add(Long.valueOf(paramArrayOfInt.getLong(0)));
    }
    paramArrayOfInt.close();
    fd(localArrayList);
    AppMethodBeat.o(52802);
  }
  
  public final void aEr()
  {
    AppMethodBeat.i(52800);
    if (aEs())
    {
      this.BGp.ad(-105L, 3L);
      this.BGp.ad(-200L, 9223372036854775807L);
    }
    this.BGp.execSQL(String.format("CREATE INDEX IF NOT EXISTS %s_timestamp ON %s(timestamp);", new Object[] { eqI(), eqI() }));
    this.BGp.execSQL(String.format("CREATE INDEX IF NOT EXISTS %s_talker ON %s(talker);", new Object[] { eqI(), eqI() }));
    String str = String.format("UPDATE %s SET status = ? WHERE aux_index = ? AND status <> ?", new Object[] { eqI() });
    this.BLI = this.BGp.compileStatement(str);
    str = String.format("INSERT INTO %s (docid, type, subtype, entity_id, aux_index, timestamp, talker) VALUES (last_insert_rowid(), ?, ?, ?, ?, ?, ?);", new Object[] { eqI() });
    this.BLJ = this.BGp.compileStatement(str);
    AppMethodBeat.o(52800);
  }
  
  public final boolean aEs()
  {
    AppMethodBeat.i(52805);
    if (!hw(-105, 3))
    {
      AppMethodBeat.o(52805);
      return true;
    }
    AppMethodBeat.o(52805);
    return false;
  }
  
  public final boolean aEt()
  {
    AppMethodBeat.i(52801);
    this.BLI.close();
    this.BLJ.close();
    boolean bool = super.aEt();
    AppMethodBeat.o(52801);
    return bool;
  }
  
  public final Cursor d(int[] paramArrayOfInt, String paramString)
  {
    AppMethodBeat.i(254342);
    if (Util.isNullOrNil(paramString)) {}
    StringBuffer localStringBuffer;
    for (paramString = "";; paramString = "AND aux_index = ".concat(String.valueOf(paramString)))
    {
      localStringBuffer = new StringBuffer();
      int j = paramArrayOfInt.length;
      int i = 0;
      while (i < j)
      {
        localStringBuffer.append(paramArrayOfInt[i]);
        localStringBuffer.append(",");
        i += 1;
      }
    }
    paramArrayOfInt = String.format("SELECT type, subtype, entity_id, aux_index, timestamp, talker FROM %s WHERE subtype IN (%s) %s AND status >= 0 ORDER BY timestamp desc;", new Object[] { eqI(), localStringBuffer.substring(0, localStringBuffer.length() - 1), paramString });
    paramArrayOfInt = this.BGp.rawQuery(paramArrayOfInt, null);
    AppMethodBeat.o(254342);
    return paramArrayOfInt;
  }
  
  public final String dkv()
  {
    AppMethodBeat.i(52806);
    String str = String.format("CREATE TABLE IF NOT EXISTS %s (docid INTEGER PRIMARY KEY, type INT, subtype INT DEFAULT 0, entity_id INTEGER, aux_index TEXT, timestamp INTEGER, status INT DEFAULT 0, talker TEXT);", new Object[] { eqI() });
    AppMethodBeat.o(52806);
    return str;
  }
  
  public final String getName()
  {
    return "FTS5MessageStorage";
  }
  
  public final int getPriority()
  {
    return 4;
  }
  
  public final String getTableName()
  {
    return "Message";
  }
  
  public final int getType()
  {
    return 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.c.c
 * JD-Core Version:    0.7.0.1
 */