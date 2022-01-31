package com.tencent.mm.plugin.fts.c;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.wcdb.database.SQLiteException;
import com.tencent.wcdb.database.SQLiteStatement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class c
  extends a
{
  private SQLiteStatement mVG;
  private SQLiteStatement mVH;
  
  public final void Pn()
  {
    AppMethodBeat.i(136827);
    if (Po())
    {
      this.mQr.M(-105L, 3L);
      this.mQr.M(-200L, 9223372036854775807L);
    }
    this.mQr.execSQL(String.format("CREATE INDEX IF NOT EXISTS %s_timestamp ON %s(timestamp);", new Object[] { bBR(), bBR() }));
    this.mQr.execSQL(String.format("CREATE INDEX IF NOT EXISTS %s_talker ON %s(talker);", new Object[] { bBR(), bBR() }));
    String str = String.format("UPDATE %s SET status = ? WHERE aux_index = ? AND status <> ?", new Object[] { bBR() });
    this.mVG = this.mQr.compileStatement(str);
    str = String.format("INSERT INTO %s (docid, type, subtype, entity_id, aux_index, timestamp, talker) VALUES (last_insert_rowid(), ?, ?, ?, ?, ?, ?);", new Object[] { bBR() });
    this.mVH = this.mQr.compileStatement(str);
    AppMethodBeat.o(136827);
  }
  
  public final boolean Po()
  {
    AppMethodBeat.i(136832);
    if (!er(-105, 3))
    {
      AppMethodBeat.o(136832);
      return true;
    }
    AppMethodBeat.o(136832);
    return false;
  }
  
  public final boolean Pp()
  {
    AppMethodBeat.i(136828);
    this.mVG.close();
    this.mVH.close();
    boolean bool = super.Pp();
    AppMethodBeat.o(136828);
    return bool;
  }
  
  public final Cursor a(g paramg, String paramString, Set<String> paramSet)
  {
    AppMethodBeat.i(136830);
    String str1 = paramg.bBX();
    if (!bo.isNullOrNil(paramString)) {}
    for (paramg = String.format(" AND aux_index = '%s'", new Object[] { paramString });; paramg = "")
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
        paramg = String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp, talker FROM %s JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s'" + paramString + paramg + " AND status >= 0;", new Object[] { bBR(), bBR(), bBS(), bBR(), bBS(), bBS(), str1 });
        paramg = this.mQr.rawQuery(paramg, null);
        AppMethodBeat.o(136830);
        return paramg;
      }
    }
  }
  
  public final Cursor a(g paramg, List<String> paramList)
  {
    AppMethodBeat.i(136831);
    paramg = paramg.bBX();
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
    paramg = String.format("SELECT MessageCount(%d, aux_index) FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND aux_index IN (%s) AND status >= 0;", new Object[] { Integer.valueOf(paramList.size()), bBR(), bBS(), bBR(), bBS(), bBS(), paramg, localObject });
    paramg = this.mQr.rawQuery(paramg, null);
    AppMethodBeat.o(136831);
    return paramg;
  }
  
  public final void a(int paramInt, long paramLong1, String paramString1, long paramLong2, String paramString2, String paramString3)
  {
    AppMethodBeat.i(136834);
    try
    {
      this.mQs.bindString(1, paramString2);
      this.mQs.execute();
      this.mVH.bindLong(1, 65536L);
      this.mVH.bindLong(2, paramInt);
      this.mVH.bindLong(3, paramLong1);
      this.mVH.bindString(4, paramString1);
      this.mVH.bindLong(5, paramLong2);
      this.mVH.bindString(6, paramString3);
      this.mVH.execute();
      AppMethodBeat.o(136834);
      return;
    }
    catch (SQLiteException paramString2)
    {
      ab.e("MicroMsg.FTS.FTS5MessageStorage", String.format("Failed inserting index: 0x%x, %d, %d, %s, %d", new Object[] { Integer.valueOf(65536), Integer.valueOf(paramInt), Long.valueOf(paramLong1), paramString1, Long.valueOf(paramLong2) }));
      paramString1 = this.mQz.simpleQueryForString();
      if ((paramString1 != null) && (paramString1.length() > 0)) {
        ab.e("MicroMsg.FTS.FTS5MessageStorage", ">> ".concat(String.valueOf(paramString1)));
      }
      AppMethodBeat.o(136834);
      throw paramString2;
    }
  }
  
  public final void a(int[] paramArrayOfInt, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(136829);
    ArrayList localArrayList = new ArrayList(4);
    paramArrayOfInt = String.format("SELECT docid FROM %s WHERE type IN " + d.v(paramArrayOfInt) + " AND entity_id=? AND timestamp=?;", new Object[] { bBR() });
    paramArrayOfInt = this.mQr.rawQuery(paramArrayOfInt, new String[] { Long.toString(paramLong1), Long.toString(paramLong2) });
    while (paramArrayOfInt.moveToNext()) {
      localArrayList.add(Long.valueOf(paramArrayOfInt.getLong(0)));
    }
    paramArrayOfInt.close();
    bS(localArrayList);
    AppMethodBeat.o(136829);
  }
  
  public final String bxi()
  {
    AppMethodBeat.i(136833);
    String str = String.format("CREATE TABLE IF NOT EXISTS %s (docid INTEGER PRIMARY KEY, type INT, subtype INT DEFAULT 0, entity_id INTEGER, aux_index TEXT, timestamp INTEGER, status INT DEFAULT 0, talker TEXT);", new Object[] { bBR() });
    AppMethodBeat.o(136833);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.c.c
 * JD-Core Version:    0.7.0.1
 */