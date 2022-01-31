package com.tencent.mm.plugin.fts.c;

import android.database.Cursor;
import com.tencent.mm.plugin.fts.a.a;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.wcdb.database.SQLiteException;
import com.tencent.wcdb.database.SQLiteStatement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class c
  extends a
{
  public SQLiteStatement kzQ;
  private SQLiteStatement kzR;
  
  protected final boolean BA()
  {
    return !cT(-105, 3);
  }
  
  protected final boolean BB()
  {
    this.kzQ.close();
    this.kzR.close();
    return super.BB();
  }
  
  protected final void Bz()
  {
    if (BA())
    {
      this.kuE.A(-105L, 3L);
      this.kuE.A(-200L, 9223372036854775807L);
    }
    this.kuE.execSQL(String.format("CREATE INDEX IF NOT EXISTS %s_timestamp ON %s(timestamp);", new Object[] { aVs(), aVs() }));
    this.kuE.execSQL(String.format("CREATE INDEX IF NOT EXISTS %s_talker ON %s(talker);", new Object[] { aVs(), aVs() }));
    String str = String.format("UPDATE %s SET status = ? WHERE aux_index = ? AND status <> ?", new Object[] { aVs() });
    this.kzQ = this.kuE.compileStatement(str);
    str = String.format("INSERT INTO %s (docid, type, subtype, entity_id, aux_index, timestamp, talker) VALUES (last_insert_rowid(), ?, ?, ?, ?, ?, ?);", new Object[] { aVs() });
    this.kzR = this.kuE.compileStatement(str);
  }
  
  public final Cursor a(g paramg, String paramString, Set<String> paramSet)
  {
    String str1 = paramg.aVy();
    if (!bk.bl(paramString)) {}
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
        paramg = String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp, talker FROM %s JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s'" + paramString + paramg + " AND status >= 0;", new Object[] { aVs(), aVs(), aVt(), aVs(), aVt(), aVt(), str1 });
        return this.kuE.rawQuery(paramg, null);
      }
    }
  }
  
  public final Cursor a(g paramg, List<String> paramList)
  {
    paramg = paramg.aVy();
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
    paramg = String.format("SELECT MessageCount(%d, aux_index) FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND aux_index IN (%s) AND status >= 0;", new Object[] { Integer.valueOf(paramList.size()), aVs(), aVt(), aVs(), aVt(), aVt(), paramg, localObject });
    return this.kuE.rawQuery(paramg, null);
  }
  
  public final void a(int paramInt, long paramLong1, String paramString1, long paramLong2, String paramString2, String paramString3)
  {
    try
    {
      this.kuF.bindString(1, paramString2);
      this.kuF.execute();
      this.kzR.bindLong(1, 65536L);
      this.kzR.bindLong(2, paramInt);
      this.kzR.bindLong(3, paramLong1);
      this.kzR.bindString(4, paramString1);
      this.kzR.bindLong(5, paramLong2);
      this.kzR.bindString(6, paramString3);
      this.kzR.execute();
      return;
    }
    catch (SQLiteException paramString2)
    {
      y.e("MicroMsg.FTS.FTS5MessageStorage", String.format("Failed inserting index: 0x%x, %d, %d, %s, %d", new Object[] { Integer.valueOf(65536), Integer.valueOf(paramInt), Long.valueOf(paramLong1), paramString1, Long.valueOf(paramLong2) }));
      paramString1 = this.kuM.simpleQueryForString();
      if ((paramString1 != null) && (paramString1.length() > 0)) {
        y.e("MicroMsg.FTS.FTS5MessageStorage", ">> " + paramString1);
      }
      throw paramString2;
    }
  }
  
  public final void a(int[] paramArrayOfInt, long paramLong1, long paramLong2)
  {
    ArrayList localArrayList = new ArrayList(4);
    paramArrayOfInt = String.format("SELECT docid FROM %s WHERE type IN " + d.l(paramArrayOfInt) + " AND entity_id=? AND timestamp=?;", new Object[] { aVs() });
    paramArrayOfInt = this.kuE.rawQuery(paramArrayOfInt, new String[] { Long.toString(paramLong1), Long.toString(paramLong2) });
    while (paramArrayOfInt.moveToNext()) {
      localArrayList.add(Long.valueOf(paramArrayOfInt.getLong(0)));
    }
    paramArrayOfInt.close();
    by(localArrayList);
  }
  
  protected final String aQT()
  {
    return String.format("CREATE TABLE IF NOT EXISTS %s (docid INTEGER PRIMARY KEY, type INT, subtype INT DEFAULT 0, entity_id INTEGER, aux_index TEXT, timestamp INTEGER, status INT DEFAULT 0, talker TEXT);", new Object[] { aVs() });
  }
  
  public final String getName()
  {
    return "FTS5MessageStorage";
  }
  
  public final int getPriority()
  {
    return 4;
  }
  
  protected final String getTableName()
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