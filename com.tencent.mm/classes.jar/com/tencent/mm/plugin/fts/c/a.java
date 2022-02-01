package com.tencent.mm.plugin.fts.c;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.h.c;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.wcdb.database.SQLiteStatement;
import java.util.Iterator;
import java.util.List;

public final class a
  extends com.tencent.mm.plugin.fts.a.a
{
  public SQLiteStatement txK;
  public SQLiteStatement txL;
  private SQLiteStatement txM;
  public SQLiteStatement txN;
  public SQLiteStatement txO;
  private SQLiteStatement txP;
  public SQLiteStatement txQ;
  
  public final Cursor a(com.tencent.mm.plugin.fts.a.a.h paramh, String paramString, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    AppMethodBeat.i(52792);
    String str = paramh.cSL();
    if (bt.isNullOrNil(paramString))
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
      paramh = String.format("SELECT aux_index, type, subtype FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s'" + paramh + paramString + paramArrayOfInt1 + " AND status >= 0 ORDER BY subtype;", new Object[] { cSF(), cSG(), cSF(), cSG(), cSG(), str });
      paramh = this.tsD.rawQuery(paramh, null);
      AppMethodBeat.o(52792);
      return paramh;
      paramh = String.format(" AND aux_index = '%s'", new Object[] { paramString });
      break;
      paramString = "";
      break label50;
    }
  }
  
  public final boolean agA()
  {
    AppMethodBeat.i(52784);
    super.agA();
    this.txK.close();
    this.txL.close();
    this.txM.close();
    this.txN.close();
    this.txO.close();
    this.txP.close();
    this.txQ.close();
    AppMethodBeat.o(52784);
    return true;
  }
  
  public final void agy()
  {
    AppMethodBeat.i(52783);
    if (agz()) {
      this.tsD.S(-102L, 5L);
    }
    this.tsD.execSQL("CREATE TABLE IF NOT EXISTS FTS5ChatRoomMembers (chatroom TEXT, member TEXT);");
    this.tsD.execSQL("CREATE INDEX IF NOT EXISTS FTS5ChatRoomMembers_chatroom ON FTS5ChatRoomMembers(chatroom);");
    this.tsD.execSQL("CREATE INDEX IF NOT EXISTS FTS5ChatRoomMembers_member ON FTS5ChatRoomMembers(member);");
    this.tsD.execSQL("CREATE TABLE IF NOT EXISTS FTS5ContactLabels (user TEXT, label_id INTEGER);");
    this.tsD.execSQL("CREATE INDEX IF NOT EXISTS FTS5ContactLabels_user ON FTS5ContactLabels(user);");
    this.tsD.execSQL("CREATE INDEX IF NOT EXISTS FTS5ContactLabels_label ON FTS5ContactLabels(label_id);");
    this.txK = this.tsD.compileStatement("INSERT INTO FTS5ChatRoomMembers (chatroom, member) VALUES (?, ?);");
    this.txL = this.tsD.compileStatement("DELETE FROM FTS5ChatRoomMembers WHERE chatroom=? AND member=?;");
    this.txM = this.tsD.compileStatement("DELETE FROM FTS5ChatRoomMembers WHERE chatroom=?;");
    this.txN = this.tsD.compileStatement("INSERT INTO FTS5ContactLabels (user, label_id) VALUES (?, ?);");
    this.txO = this.tsD.compileStatement("DELETE FROM FTS5ContactLabels WHERE user=? AND label_id=?;");
    this.txP = this.tsD.compileStatement("DELETE FROM FTS5ContactLabels WHERE user=?;");
    this.txQ = this.tsD.compileStatement("SELECT changes();");
    AppMethodBeat.o(52783);
  }
  
  public final boolean agz()
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
  
  public final void akE(String paramString)
  {
    AppMethodBeat.i(52786);
    this.txP.bindString(1, paramString);
    this.txP.execute();
    AppMethodBeat.o(52786);
  }
  
  public final Cursor akF(String paramString)
  {
    AppMethodBeat.i(52787);
    paramString = this.tsD.rawQuery("SELECT DISTINCT chatroom FROM FTS5ChatRoomMembers WHERE member=?;", new String[] { paramString });
    AppMethodBeat.o(52787);
    return paramString;
  }
  
  public final void akG(String paramString)
  {
    AppMethodBeat.i(52789);
    this.txM.bindString(1, paramString);
    this.txM.execute();
    AppMethodBeat.o(52789);
  }
  
  public final boolean b(com.tencent.mm.plugin.fts.a.a.h paramh)
  {
    AppMethodBeat.i(52793);
    String str1 = cSF();
    String str2 = cSG();
    String str3 = cSF();
    String str4 = cSG();
    String str5 = cSG();
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < paramh.tuP.size())
    {
      localStringBuffer.append("(");
      localStringBuffer.append(((h.c)paramh.tuP.get(i)).cSN());
      localStringBuffer.append(")");
      if (i != paramh.tuP.size() - 1) {
        localStringBuffer.append(" OR ");
      }
      i += 1;
    }
    paramh = String.format("SELECT 1 FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND type=131072 LIMIT 1;", new Object[] { str1, str2, str3, str4, str5, localStringBuffer.toString() });
    paramh = this.tsD.rawQuery(paramh, null);
    boolean bool = paramh.moveToNext();
    paramh.close();
    AppMethodBeat.o(52793);
    return bool;
  }
  
  public final boolean cSH()
  {
    return true;
  }
  
  public final String cvK()
  {
    AppMethodBeat.i(52790);
    String str = String.format("CREATE TABLE IF NOT EXISTS %s (docid INTEGER PRIMARY KEY, type INT, subtype INT DEFAULT 0, entity_id INTEGER, aux_index TEXT, timestamp INTEGER, status INT DEFAULT 0);", new Object[] { cSF() });
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
    boolean bool = this.tsD.inTransaction();
    if (!bool) {
      this.tsD.beginTransaction();
    }
    this.txK.bindString(1, paramString);
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      paramString = paramArrayOfString[i];
      this.txK.bindString(2, paramString);
      this.txK.execute();
      i += 1;
    }
    if (!bool) {
      this.tsD.commit();
    }
    AppMethodBeat.o(52788);
  }
  
  public final void s(String paramString, List<Long> paramList)
  {
    AppMethodBeat.i(52785);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(52785);
      return;
    }
    boolean bool = this.tsD.inTransaction();
    if (!bool) {
      this.tsD.beginTransaction();
    }
    this.txN.bindString(1, paramString);
    paramString = paramList.iterator();
    while (paramString.hasNext())
    {
      long l = ((Long)paramString.next()).longValue();
      this.txN.bindLong(2, l);
      this.txN.execute();
    }
    if (!bool) {
      this.tsD.commit();
    }
    AppMethodBeat.o(52785);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.c.a
 * JD-Core Version:    0.7.0.1
 */