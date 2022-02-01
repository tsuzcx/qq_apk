package com.tencent.mm.plugin.fts.c;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.h.c;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.wcdb.database.SQLiteStatement;
import java.util.Iterator;
import java.util.List;

public final class a
  extends com.tencent.mm.plugin.fts.a.a
{
  public SQLiteStatement wZA;
  public SQLiteStatement wZB;
  private SQLiteStatement wZC;
  public SQLiteStatement wZD;
  public SQLiteStatement wZE;
  private SQLiteStatement wZF;
  public SQLiteStatement wZG;
  
  public final Cursor a(com.tencent.mm.plugin.fts.a.a.h paramh, String paramString, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    AppMethodBeat.i(52792);
    String str = paramh.dOz();
    if (Util.isNullOrNil(paramString))
    {
      paramh = "";
      if ((paramArrayOfInt1 == null) || (paramArrayOfInt1.length <= 0)) {
        break label196;
      }
      paramString = " AND type IN " + d.C(paramArrayOfInt1);
      label50:
      if ((paramArrayOfInt2 == null) || (paramArrayOfInt2.length <= 0)) {
        break label202;
      }
    }
    label196:
    label202:
    for (paramArrayOfInt1 = " AND subtype IN " + d.C(paramArrayOfInt2);; paramArrayOfInt1 = "")
    {
      paramh = String.format("SELECT aux_index, type, subtype FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s'" + paramh + paramString + paramArrayOfInt1 + " AND status >= 0 ORDER BY subtype;", new Object[] { dOt(), dOu(), dOt(), dOu(), dOu(), str });
      paramh = this.wUt.rawQuery(paramh, null);
      AppMethodBeat.o(52792);
      return paramh;
      paramh = String.format(" AND aux_index = '%s'", new Object[] { paramString });
      break;
      paramString = "";
      break label50;
    }
  }
  
  public final void awY()
  {
    AppMethodBeat.i(52783);
    if (awZ()) {
      this.wUt.W(-102L, 5L);
    }
    this.wUt.execSQL("CREATE TABLE IF NOT EXISTS FTS5ChatRoomMembers (chatroom TEXT, member TEXT);");
    this.wUt.execSQL("CREATE INDEX IF NOT EXISTS FTS5ChatRoomMembers_chatroom ON FTS5ChatRoomMembers(chatroom);");
    this.wUt.execSQL("CREATE INDEX IF NOT EXISTS FTS5ChatRoomMembers_member ON FTS5ChatRoomMembers(member);");
    this.wUt.execSQL("CREATE TABLE IF NOT EXISTS FTS5ContactLabels (user TEXT, label_id INTEGER);");
    this.wUt.execSQL("CREATE INDEX IF NOT EXISTS FTS5ContactLabels_user ON FTS5ContactLabels(user);");
    this.wUt.execSQL("CREATE INDEX IF NOT EXISTS FTS5ContactLabels_label ON FTS5ContactLabels(label_id);");
    this.wZA = this.wUt.compileStatement("INSERT INTO FTS5ChatRoomMembers (chatroom, member) VALUES (?, ?);");
    this.wZB = this.wUt.compileStatement("DELETE FROM FTS5ChatRoomMembers WHERE chatroom=? AND member=?;");
    this.wZC = this.wUt.compileStatement("DELETE FROM FTS5ChatRoomMembers WHERE chatroom=?;");
    this.wZD = this.wUt.compileStatement("INSERT INTO FTS5ContactLabels (user, label_id) VALUES (?, ?);");
    this.wZE = this.wUt.compileStatement("DELETE FROM FTS5ContactLabels WHERE user=? AND label_id=?;");
    this.wZF = this.wUt.compileStatement("DELETE FROM FTS5ContactLabels WHERE user=?;");
    this.wZG = this.wUt.compileStatement("SELECT changes();");
    AppMethodBeat.o(52783);
  }
  
  public final boolean awZ()
  {
    AppMethodBeat.i(52791);
    if (!gD(-102, 5))
    {
      AppMethodBeat.o(52791);
      return true;
    }
    AppMethodBeat.o(52791);
    return false;
  }
  
  public final boolean axa()
  {
    AppMethodBeat.i(52784);
    super.axa();
    this.wZA.close();
    this.wZB.close();
    this.wZC.close();
    this.wZD.close();
    this.wZE.close();
    this.wZF.close();
    this.wZG.close();
    AppMethodBeat.o(52784);
    return true;
  }
  
  public final void ayG(String paramString)
  {
    AppMethodBeat.i(52786);
    this.wZF.bindString(1, paramString);
    this.wZF.execute();
    AppMethodBeat.o(52786);
  }
  
  public final Cursor ayH(String paramString)
  {
    AppMethodBeat.i(52787);
    paramString = this.wUt.rawQuery("SELECT DISTINCT chatroom FROM FTS5ChatRoomMembers WHERE member=?;", new String[] { paramString });
    AppMethodBeat.o(52787);
    return paramString;
  }
  
  public final void ayI(String paramString)
  {
    AppMethodBeat.i(52789);
    this.wZC.bindString(1, paramString);
    this.wZC.execute();
    AppMethodBeat.o(52789);
  }
  
  public final boolean b(com.tencent.mm.plugin.fts.a.a.h paramh)
  {
    AppMethodBeat.i(52793);
    String str1 = dOt();
    String str2 = dOu();
    String str3 = dOt();
    String str4 = dOu();
    String str5 = dOu();
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < paramh.wWF.size())
    {
      localStringBuffer.append("(");
      localStringBuffer.append(((h.c)paramh.wWF.get(i)).dOB());
      localStringBuffer.append(")");
      if (i != paramh.wWF.size() - 1) {
        localStringBuffer.append(" OR ");
      }
      i += 1;
    }
    paramh = String.format("SELECT 1 FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND type=131072 LIMIT 1;", new Object[] { str1, str2, str3, str4, str5, localStringBuffer.toString() });
    paramh = this.wUt.rawQuery(paramh, null);
    boolean bool = paramh.moveToNext();
    paramh.close();
    AppMethodBeat.o(52793);
    return bool;
  }
  
  public final String cVp()
  {
    AppMethodBeat.i(52790);
    String str = String.format("CREATE TABLE IF NOT EXISTS %s (docid INTEGER PRIMARY KEY, type INT, subtype INT DEFAULT 0, entity_id INTEGER, aux_index TEXT, timestamp INTEGER, status INT DEFAULT 0);", new Object[] { dOt() });
    AppMethodBeat.o(52790);
    return str;
  }
  
  public final boolean dOv()
  {
    return true;
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
    boolean bool = this.wUt.inTransaction();
    if (!bool) {
      this.wUt.beginTransaction();
    }
    this.wZA.bindString(1, paramString);
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      paramString = paramArrayOfString[i];
      this.wZA.bindString(2, paramString);
      this.wZA.execute();
      i += 1;
    }
    if (!bool) {
      this.wUt.commit();
    }
    AppMethodBeat.o(52788);
  }
  
  public final void u(String paramString, List<Long> paramList)
  {
    AppMethodBeat.i(52785);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(52785);
      return;
    }
    boolean bool = this.wUt.inTransaction();
    if (!bool) {
      this.wUt.beginTransaction();
    }
    this.wZD.bindString(1, paramString);
    paramString = paramList.iterator();
    while (paramString.hasNext())
    {
      long l = ((Long)paramString.next()).longValue();
      this.wZD.bindLong(2, l);
      this.wZD.execute();
    }
    if (!bool) {
      this.wUt.commit();
    }
    AppMethodBeat.o(52785);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.c.a
 * JD-Core Version:    0.7.0.1
 */