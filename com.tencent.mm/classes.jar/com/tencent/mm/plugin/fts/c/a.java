package com.tencent.mm.plugin.fts.c;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.h.c;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.wcdb.database.SQLiteStatement;
import java.util.Iterator;
import java.util.List;

public final class a
  extends com.tencent.mm.plugin.fts.a.a
{
  public SQLiteStatement tIB;
  public SQLiteStatement tIC;
  private SQLiteStatement tID;
  public SQLiteStatement tIE;
  public SQLiteStatement tIF;
  private SQLiteStatement tIG;
  public SQLiteStatement tIH;
  
  public final Cursor a(com.tencent.mm.plugin.fts.a.a.h paramh, String paramString, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    AppMethodBeat.i(52792);
    String str = paramh.cVq();
    if (bu.isNullOrNil(paramString))
    {
      paramh = "";
      if ((paramArrayOfInt1 == null) || (paramArrayOfInt1.length <= 0)) {
        break label196;
      }
      paramString = " AND type IN " + d.A(paramArrayOfInt1);
      label50:
      if ((paramArrayOfInt2 == null) || (paramArrayOfInt2.length <= 0)) {
        break label202;
      }
    }
    label196:
    label202:
    for (paramArrayOfInt1 = " AND subtype IN " + d.A(paramArrayOfInt2);; paramArrayOfInt1 = "")
    {
      paramh = String.format("SELECT aux_index, type, subtype FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s'" + paramh + paramString + paramArrayOfInt1 + " AND status >= 0 ORDER BY subtype;", new Object[] { cVk(), cVl(), cVk(), cVl(), cVl(), str });
      paramh = this.tDu.rawQuery(paramh, null);
      AppMethodBeat.o(52792);
      return paramh;
      paramh = String.format(" AND aux_index = '%s'", new Object[] { paramString });
      break;
      paramString = "";
      break label50;
    }
  }
  
  public final void agM()
  {
    AppMethodBeat.i(52783);
    if (agN()) {
      this.tDu.R(-102L, 5L);
    }
    this.tDu.execSQL("CREATE TABLE IF NOT EXISTS FTS5ChatRoomMembers (chatroom TEXT, member TEXT);");
    this.tDu.execSQL("CREATE INDEX IF NOT EXISTS FTS5ChatRoomMembers_chatroom ON FTS5ChatRoomMembers(chatroom);");
    this.tDu.execSQL("CREATE INDEX IF NOT EXISTS FTS5ChatRoomMembers_member ON FTS5ChatRoomMembers(member);");
    this.tDu.execSQL("CREATE TABLE IF NOT EXISTS FTS5ContactLabels (user TEXT, label_id INTEGER);");
    this.tDu.execSQL("CREATE INDEX IF NOT EXISTS FTS5ContactLabels_user ON FTS5ContactLabels(user);");
    this.tDu.execSQL("CREATE INDEX IF NOT EXISTS FTS5ContactLabels_label ON FTS5ContactLabels(label_id);");
    this.tIB = this.tDu.compileStatement("INSERT INTO FTS5ChatRoomMembers (chatroom, member) VALUES (?, ?);");
    this.tIC = this.tDu.compileStatement("DELETE FROM FTS5ChatRoomMembers WHERE chatroom=? AND member=?;");
    this.tID = this.tDu.compileStatement("DELETE FROM FTS5ChatRoomMembers WHERE chatroom=?;");
    this.tIE = this.tDu.compileStatement("INSERT INTO FTS5ContactLabels (user, label_id) VALUES (?, ?);");
    this.tIF = this.tDu.compileStatement("DELETE FROM FTS5ContactLabels WHERE user=? AND label_id=?;");
    this.tIG = this.tDu.compileStatement("DELETE FROM FTS5ContactLabels WHERE user=?;");
    this.tIH = this.tDu.compileStatement("SELECT changes();");
    AppMethodBeat.o(52783);
  }
  
  public final boolean agN()
  {
    AppMethodBeat.i(52791);
    if (!ge(-102, 5))
    {
      AppMethodBeat.o(52791);
      return true;
    }
    AppMethodBeat.o(52791);
    return false;
  }
  
  public final boolean agO()
  {
    AppMethodBeat.i(52784);
    super.agO();
    this.tIB.close();
    this.tIC.close();
    this.tID.close();
    this.tIE.close();
    this.tIF.close();
    this.tIG.close();
    this.tIH.close();
    AppMethodBeat.o(52784);
    return true;
  }
  
  public final void alC(String paramString)
  {
    AppMethodBeat.i(52786);
    this.tIG.bindString(1, paramString);
    this.tIG.execute();
    AppMethodBeat.o(52786);
  }
  
  public final Cursor alD(String paramString)
  {
    AppMethodBeat.i(52787);
    paramString = this.tDu.rawQuery("SELECT DISTINCT chatroom FROM FTS5ChatRoomMembers WHERE member=?;", new String[] { paramString });
    AppMethodBeat.o(52787);
    return paramString;
  }
  
  public final void alE(String paramString)
  {
    AppMethodBeat.i(52789);
    this.tID.bindString(1, paramString);
    this.tID.execute();
    AppMethodBeat.o(52789);
  }
  
  public final boolean b(com.tencent.mm.plugin.fts.a.a.h paramh)
  {
    AppMethodBeat.i(52793);
    String str1 = cVk();
    String str2 = cVl();
    String str3 = cVk();
    String str4 = cVl();
    String str5 = cVl();
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < paramh.tFG.size())
    {
      localStringBuffer.append("(");
      localStringBuffer.append(((h.c)paramh.tFG.get(i)).cVs());
      localStringBuffer.append(")");
      if (i != paramh.tFG.size() - 1) {
        localStringBuffer.append(" OR ");
      }
      i += 1;
    }
    paramh = String.format("SELECT 1 FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND type=131072 LIMIT 1;", new Object[] { str1, str2, str3, str4, str5, localStringBuffer.toString() });
    paramh = this.tDu.rawQuery(paramh, null);
    boolean bool = paramh.moveToNext();
    paramh.close();
    AppMethodBeat.o(52793);
    return bool;
  }
  
  public final boolean cVm()
  {
    return true;
  }
  
  public final String cxl()
  {
    AppMethodBeat.i(52790);
    String str = String.format("CREATE TABLE IF NOT EXISTS %s (docid INTEGER PRIMARY KEY, type INT, subtype INT DEFAULT 0, entity_id INTEGER, aux_index TEXT, timestamp INTEGER, status INT DEFAULT 0);", new Object[] { cVk() });
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
    boolean bool = this.tDu.inTransaction();
    if (!bool) {
      this.tDu.beginTransaction();
    }
    this.tIB.bindString(1, paramString);
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      paramString = paramArrayOfString[i];
      this.tIB.bindString(2, paramString);
      this.tIB.execute();
      i += 1;
    }
    if (!bool) {
      this.tDu.commit();
    }
    AppMethodBeat.o(52788);
  }
  
  public final void t(String paramString, List<Long> paramList)
  {
    AppMethodBeat.i(52785);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(52785);
      return;
    }
    boolean bool = this.tDu.inTransaction();
    if (!bool) {
      this.tDu.beginTransaction();
    }
    this.tIE.bindString(1, paramString);
    paramString = paramList.iterator();
    while (paramString.hasNext())
    {
      long l = ((Long)paramString.next()).longValue();
      this.tIE.bindLong(2, l);
      this.tIE.execute();
    }
    if (!bool) {
      this.tDu.commit();
    }
    AppMethodBeat.o(52785);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.c.a
 * JD-Core Version:    0.7.0.1
 */