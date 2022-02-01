package com.tencent.mm.plugin.fts.c;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.h.c;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.wcdb.database.SQLiteStatement;
import java.util.Iterator;
import java.util.List;

public final class a
  extends com.tencent.mm.plugin.fts.a.a
{
  public SQLiteStatement sBj;
  public SQLiteStatement sBk;
  private SQLiteStatement sBl;
  public SQLiteStatement sBm;
  public SQLiteStatement sBn;
  private SQLiteStatement sBo;
  public SQLiteStatement sBp;
  
  public final Cursor a(com.tencent.mm.plugin.fts.a.a.h paramh, String paramString, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    AppMethodBeat.i(52792);
    String str = paramh.cKw();
    if (bs.isNullOrNil(paramString))
    {
      paramh = "";
      if ((paramArrayOfInt1 == null) || (paramArrayOfInt1.length <= 0)) {
        break label196;
      }
      paramString = " AND type IN " + d.z(paramArrayOfInt1);
      label50:
      if ((paramArrayOfInt2 == null) || (paramArrayOfInt2.length <= 0)) {
        break label202;
      }
    }
    label196:
    label202:
    for (paramArrayOfInt1 = " AND subtype IN " + d.z(paramArrayOfInt2);; paramArrayOfInt1 = "")
    {
      paramh = String.format("SELECT aux_index, type, subtype FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s'" + paramh + paramString + paramArrayOfInt1 + " AND status >= 0 ORDER BY subtype;", new Object[] { cKq(), cKr(), cKq(), cKr(), cKr(), str });
      paramh = this.swc.rawQuery(paramh, null);
      AppMethodBeat.o(52792);
      return paramh;
      paramh = String.format(" AND aux_index = '%s'", new Object[] { paramString });
      break;
      paramString = "";
      break label50;
    }
  }
  
  public final void adS()
  {
    AppMethodBeat.i(52783);
    if (adT()) {
      this.swc.R(-102L, 5L);
    }
    this.swc.execSQL("CREATE TABLE IF NOT EXISTS FTS5ChatRoomMembers (chatroom TEXT, member TEXT);");
    this.swc.execSQL("CREATE INDEX IF NOT EXISTS FTS5ChatRoomMembers_chatroom ON FTS5ChatRoomMembers(chatroom);");
    this.swc.execSQL("CREATE INDEX IF NOT EXISTS FTS5ChatRoomMembers_member ON FTS5ChatRoomMembers(member);");
    this.swc.execSQL("CREATE TABLE IF NOT EXISTS FTS5ContactLabels (user TEXT, label_id INTEGER);");
    this.swc.execSQL("CREATE INDEX IF NOT EXISTS FTS5ContactLabels_user ON FTS5ContactLabels(user);");
    this.swc.execSQL("CREATE INDEX IF NOT EXISTS FTS5ContactLabels_label ON FTS5ContactLabels(label_id);");
    this.sBj = this.swc.compileStatement("INSERT INTO FTS5ChatRoomMembers (chatroom, member) VALUES (?, ?);");
    this.sBk = this.swc.compileStatement("DELETE FROM FTS5ChatRoomMembers WHERE chatroom=? AND member=?;");
    this.sBl = this.swc.compileStatement("DELETE FROM FTS5ChatRoomMembers WHERE chatroom=?;");
    this.sBm = this.swc.compileStatement("INSERT INTO FTS5ContactLabels (user, label_id) VALUES (?, ?);");
    this.sBn = this.swc.compileStatement("DELETE FROM FTS5ContactLabels WHERE user=? AND label_id=?;");
    this.sBo = this.swc.compileStatement("DELETE FROM FTS5ContactLabels WHERE user=?;");
    this.sBp = this.swc.compileStatement("SELECT changes();");
    AppMethodBeat.o(52783);
  }
  
  public final boolean adT()
  {
    AppMethodBeat.i(52791);
    if (!fO(-102, 5))
    {
      AppMethodBeat.o(52791);
      return true;
    }
    AppMethodBeat.o(52791);
    return false;
  }
  
  public final boolean adU()
  {
    AppMethodBeat.i(52784);
    super.adU();
    this.sBj.close();
    this.sBk.close();
    this.sBl.close();
    this.sBm.close();
    this.sBn.close();
    this.sBo.close();
    this.sBp.close();
    AppMethodBeat.o(52784);
    return true;
  }
  
  public final void agg(String paramString)
  {
    AppMethodBeat.i(52786);
    this.sBo.bindString(1, paramString);
    this.sBo.execute();
    AppMethodBeat.o(52786);
  }
  
  public final Cursor agh(String paramString)
  {
    AppMethodBeat.i(52787);
    paramString = this.swc.rawQuery("SELECT DISTINCT chatroom FROM FTS5ChatRoomMembers WHERE member=?;", new String[] { paramString });
    AppMethodBeat.o(52787);
    return paramString;
  }
  
  public final void agi(String paramString)
  {
    AppMethodBeat.i(52789);
    this.sBl.bindString(1, paramString);
    this.sBl.execute();
    AppMethodBeat.o(52789);
  }
  
  public final boolean b(com.tencent.mm.plugin.fts.a.a.h paramh)
  {
    AppMethodBeat.i(52793);
    String str1 = cKq();
    String str2 = cKr();
    String str3 = cKq();
    String str4 = cKr();
    String str5 = cKr();
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < paramh.syo.size())
    {
      localStringBuffer.append("(");
      localStringBuffer.append(((h.c)paramh.syo.get(i)).cKy());
      localStringBuffer.append(")");
      if (i != paramh.syo.size() - 1) {
        localStringBuffer.append(" OR ");
      }
      i += 1;
    }
    paramh = String.format("SELECT 1 FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND type=131072 LIMIT 1;", new Object[] { str1, str2, str3, str4, str5, localStringBuffer.toString() });
    paramh = this.swc.rawQuery(paramh, null);
    boolean bool = paramh.moveToNext();
    paramh.close();
    AppMethodBeat.o(52793);
    return bool;
  }
  
  public final boolean cKs()
  {
    return true;
  }
  
  public final String cqf()
  {
    AppMethodBeat.i(52790);
    String str = String.format("CREATE TABLE IF NOT EXISTS %s (docid INTEGER PRIMARY KEY, type INT, subtype INT DEFAULT 0, entity_id INTEGER, aux_index TEXT, timestamp INTEGER, status INT DEFAULT 0);", new Object[] { cKq() });
    AppMethodBeat.o(52790);
    return str;
  }
  
  public final String getName()
  {
    return "FTS5ContactStorage";
  }
  
  public final int getPriority()
  {
    return 3;
  }
  
  public final String getTableName()
  {
    return "Contact";
  }
  
  public final int getType()
  {
    return 3;
  }
  
  public final void k(String paramString, String[] paramArrayOfString)
  {
    AppMethodBeat.i(52788);
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0))
    {
      AppMethodBeat.o(52788);
      return;
    }
    boolean bool = this.swc.inTransaction();
    if (!bool) {
      this.swc.beginTransaction();
    }
    this.sBj.bindString(1, paramString);
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      paramString = paramArrayOfString[i];
      this.sBj.bindString(2, paramString);
      this.sBj.execute();
      i += 1;
    }
    if (!bool) {
      this.swc.commit();
    }
    AppMethodBeat.o(52788);
  }
  
  public final void q(String paramString, List<Long> paramList)
  {
    AppMethodBeat.i(52785);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(52785);
      return;
    }
    boolean bool = this.swc.inTransaction();
    if (!bool) {
      this.swc.beginTransaction();
    }
    this.sBm.bindString(1, paramString);
    paramString = paramList.iterator();
    while (paramString.hasNext())
    {
      long l = ((Long)paramString.next()).longValue();
      this.sBm.bindLong(2, l);
      this.sBm.execute();
    }
    if (!bool) {
      this.swc.commit();
    }
    AppMethodBeat.o(52785);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.c.a
 * JD-Core Version:    0.7.0.1
 */