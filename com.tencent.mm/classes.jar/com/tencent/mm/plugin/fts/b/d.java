package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.wcdb.database.SQLiteException;
import com.tencent.wcdb.database.SQLiteStatement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class d
  extends a
{
  private SQLiteStatement HwE;
  private SQLiteStatement HwF;
  
  public final Cursor a(j paramj, String paramString, Set<String> paramSet)
  {
    AppMethodBeat.i(52803);
    String str1 = paramj.fxx();
    if (!Util.isNullOrNil(paramString)) {}
    for (paramj = String.format(" AND aux_index = '%s'", new Object[] { paramString });; paramj = "")
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
        paramj = String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp, talker FROM %s JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s'" + paramString + paramj + " AND status >= 0;", new Object[] { fxn(), fxn(), fxo(), fxn(), fxo(), fxo(), str1 });
        paramj = this.HqR.rawQuery(paramj, null);
        AppMethodBeat.o(52803);
        return paramj;
      }
    }
  }
  
  public final Cursor a(j paramj, List<String> paramList)
  {
    AppMethodBeat.i(52804);
    paramj = paramj.fxx();
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
    paramj = String.format("SELECT MessageCount(%d, aux_index) FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND aux_index IN (%s) AND status >= 0;", new Object[] { Integer.valueOf(paramList.size()), fxn(), fxo(), fxn(), fxo(), fxo(), paramj, localObject });
    paramj = this.HqR.rawQuery(paramj, null);
    AppMethodBeat.o(52804);
    return paramj;
  }
  
  public final void a(int paramInt, long paramLong1, String paramString1, long paramLong2, String paramString2, String paramString3)
  {
    AppMethodBeat.i(52807);
    try
    {
      fxq().bindString(1, paramString2);
      fxq().execute();
      this.HwF.bindLong(1, 65536L);
      this.HwF.bindLong(2, paramInt);
      this.HwF.bindLong(3, paramLong1);
      this.HwF.bindString(4, paramString1);
      this.HwF.bindLong(5, paramLong2);
      this.HwF.bindString(6, paramString3);
      this.HwF.execute();
      AppMethodBeat.o(52807);
      return;
    }
    catch (SQLiteException paramString2)
    {
      Log.e("MicroMsg.FTS.FTS5MessageStorage", String.format("Failed inserting index: 0x%x, %d, %d, %s, %d", new Object[] { Integer.valueOf(65536), Integer.valueOf(paramInt), Long.valueOf(paramLong1), paramString1, Long.valueOf(paramLong2) }));
      paramString1 = fxp().simpleQueryForString();
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
    paramArrayOfInt = String.format("SELECT docid FROM %s WHERE type IN " + com.tencent.mm.plugin.fts.a.d.G(paramArrayOfInt) + " AND entity_id=? AND timestamp=?;", new Object[] { fxn() });
    paramArrayOfInt = this.HqR.rawQuery(paramArrayOfInt, new String[] { Long.toString(paramLong1), Long.toString(paramLong2) });
    while (paramArrayOfInt.moveToNext()) {
      localArrayList.add(Long.valueOf(paramArrayOfInt.getLong(0)));
    }
    paramArrayOfInt.close();
    hP(localArrayList);
    AppMethodBeat.o(52802);
  }
  
  public final void aXv()
  {
    AppMethodBeat.i(52800);
    if (aXw())
    {
      this.HqR.aG(-105L, 3L);
      this.HqR.aG(-200L, 9223372036854775807L);
    }
    this.HqR.execSQL(String.format("CREATE INDEX IF NOT EXISTS %s_timestamp ON %s(timestamp);", new Object[] { fxn(), fxn() }));
    this.HqR.execSQL(String.format("CREATE INDEX IF NOT EXISTS %s_talker ON %s(talker);", new Object[] { fxn(), fxn() }));
    String str = String.format("UPDATE %s SET status = ? WHERE aux_index = ? AND status <> ?", new Object[] { fxn() });
    this.HwE = this.HqR.compileStatement(str);
    str = String.format("INSERT INTO %s (docid, type, subtype, entity_id, aux_index, timestamp, talker) VALUES (last_insert_rowid(), ?, ?, ?, ?, ?, ?);", new Object[] { fxn() });
    this.HwF = this.HqR.compileStatement(str);
    AppMethodBeat.o(52800);
  }
  
  public final boolean aXw()
  {
    AppMethodBeat.i(52805);
    if (!iV(-105, 3))
    {
      AppMethodBeat.o(52805);
      return true;
    }
    AppMethodBeat.o(52805);
    return false;
  }
  
  public final boolean aXx()
  {
    AppMethodBeat.i(52801);
    this.HwE.close();
    this.HwF.close();
    boolean bool = super.aXx();
    AppMethodBeat.o(52801);
    return bool;
  }
  
  public final String dRh()
  {
    AppMethodBeat.i(52806);
    String str = String.format("CREATE TABLE IF NOT EXISTS %s (docid INTEGER PRIMARY KEY, type INT, subtype INT DEFAULT 0, entity_id INTEGER, aux_index TEXT, timestamp INTEGER, status INT DEFAULT 0, talker TEXT);", new Object[] { fxn() });
    AppMethodBeat.o(52806);
    return str;
  }
  
  public final Cursor e(int[] paramArrayOfInt, String paramString)
  {
    AppMethodBeat.i(265460);
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
    paramArrayOfInt = String.format("SELECT type, subtype, entity_id, aux_index, timestamp, talker FROM %s WHERE subtype IN (%s) %s AND status >= 0 ORDER BY timestamp desc;", new Object[] { fxn(), localStringBuffer.substring(0, localStringBuffer.length() - 1), paramString });
    paramArrayOfInt = this.HqR.rawQuery(paramArrayOfInt, null);
    AppMethodBeat.o(265460);
    return paramArrayOfInt;
  }
  
  public final String getLogTag()
  {
    return "MicroMsg.FTS.FTS5MessageStorage";
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.d
 * JD-Core Version:    0.7.0.1
 */