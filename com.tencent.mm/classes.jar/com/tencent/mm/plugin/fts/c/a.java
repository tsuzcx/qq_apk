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
  public SQLiteStatement BLA;
  private SQLiteStatement BLB;
  public SQLiteStatement BLC;
  public SQLiteStatement BLD;
  private SQLiteStatement BLE;
  public SQLiteStatement BLF;
  public SQLiteStatement BLz;
  
  public final Cursor a(com.tencent.mm.plugin.fts.a.a.h paramh, String paramString, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    AppMethodBeat.i(52792);
    String str = paramh.eqQ();
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
      paramh = String.format("SELECT aux_index, type, subtype FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s'" + paramh + paramString + paramArrayOfInt1 + " AND status >= 0 ORDER BY subtype;", new Object[] { eqI(), eqJ(), eqI(), eqJ(), eqJ(), str });
      paramh = this.BGp.rawQuery(paramh, null);
      AppMethodBeat.o(52792);
      return paramh;
      paramh = String.format(" AND aux_index = '%s'", new Object[] { paramString });
      break;
      paramString = "";
      break label50;
    }
  }
  
  public final void aEr()
  {
    AppMethodBeat.i(52783);
    if (aEs()) {
      this.BGp.ad(-102L, 5L);
    }
    this.BGp.execSQL("CREATE TABLE IF NOT EXISTS FTS5ChatRoomMembers (chatroom TEXT, member TEXT);");
    this.BGp.execSQL("CREATE INDEX IF NOT EXISTS FTS5ChatRoomMembers_chatroom ON FTS5ChatRoomMembers(chatroom);");
    this.BGp.execSQL("CREATE INDEX IF NOT EXISTS FTS5ChatRoomMembers_member ON FTS5ChatRoomMembers(member);");
    this.BGp.execSQL("CREATE TABLE IF NOT EXISTS FTS5ContactLabels (user TEXT, label_id INTEGER);");
    this.BGp.execSQL("CREATE INDEX IF NOT EXISTS FTS5ContactLabels_user ON FTS5ContactLabels(user);");
    this.BGp.execSQL("CREATE INDEX IF NOT EXISTS FTS5ContactLabels_label ON FTS5ContactLabels(label_id);");
    this.BLz = this.BGp.compileStatement("INSERT INTO FTS5ChatRoomMembers (chatroom, member) VALUES (?, ?);");
    this.BLA = this.BGp.compileStatement("DELETE FROM FTS5ChatRoomMembers WHERE chatroom=? AND member=?;");
    this.BLB = this.BGp.compileStatement("DELETE FROM FTS5ChatRoomMembers WHERE chatroom=?;");
    this.BLC = this.BGp.compileStatement("INSERT INTO FTS5ContactLabels (user, label_id) VALUES (?, ?);");
    this.BLD = this.BGp.compileStatement("DELETE FROM FTS5ContactLabels WHERE user=? AND label_id=?;");
    this.BLE = this.BGp.compileStatement("DELETE FROM FTS5ContactLabels WHERE user=?;");
    this.BLF = this.BGp.compileStatement("SELECT changes();");
    AppMethodBeat.o(52783);
  }
  
  public final boolean aEs()
  {
    AppMethodBeat.i(52791);
    if (!hw(-102, 5))
    {
      AppMethodBeat.o(52791);
      return true;
    }
    AppMethodBeat.o(52791);
    return false;
  }
  
  public final boolean aEt()
  {
    AppMethodBeat.i(52784);
    super.aEt();
    this.BLz.close();
    this.BLA.close();
    this.BLB.close();
    this.BLC.close();
    this.BLD.close();
    this.BLE.close();
    this.BLF.close();
    AppMethodBeat.o(52784);
    return true;
  }
  
  public final void aIb(String paramString)
  {
    AppMethodBeat.i(52786);
    this.BLE.bindString(1, paramString);
    this.BLE.execute();
    AppMethodBeat.o(52786);
  }
  
  public final Cursor aIc(String paramString)
  {
    AppMethodBeat.i(52787);
    paramString = this.BGp.rawQuery("SELECT DISTINCT chatroom FROM FTS5ChatRoomMembers WHERE member=?;", new String[] { paramString });
    AppMethodBeat.o(52787);
    return paramString;
  }
  
  public final void aId(String paramString)
  {
    AppMethodBeat.i(52789);
    this.BLB.bindString(1, paramString);
    this.BLB.execute();
    AppMethodBeat.o(52789);
  }
  
  public final boolean b(com.tencent.mm.plugin.fts.a.a.h paramh)
  {
    AppMethodBeat.i(52793);
    String str1 = eqI();
    String str2 = eqJ();
    String str3 = eqI();
    String str4 = eqJ();
    String str5 = eqJ();
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < paramh.BIA.size())
    {
      localStringBuffer.append("(");
      localStringBuffer.append(((h.c)paramh.BIA.get(i)).eqS());
      localStringBuffer.append(")");
      if (i != paramh.BIA.size() - 1) {
        localStringBuffer.append(" OR ");
      }
      i += 1;
    }
    paramh = String.format("SELECT 1 FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND type=131072 LIMIT 1;", new Object[] { str1, str2, str3, str4, str5, localStringBuffer.toString() });
    paramh = this.BGp.rawQuery(paramh, null);
    boolean bool = paramh.moveToNext();
    paramh.close();
    AppMethodBeat.o(52793);
    return bool;
  }
  
  public final String dkv()
  {
    AppMethodBeat.i(52790);
    String str = String.format("CREATE TABLE IF NOT EXISTS %s (docid INTEGER PRIMARY KEY, type INT, subtype INT DEFAULT 0, entity_id INTEGER, aux_index TEXT, timestamp INTEGER, status INT DEFAULT 0);", new Object[] { eqI() });
    AppMethodBeat.o(52790);
    return str;
  }
  
  public final boolean eqM()
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
  
  public final void j(String paramString, String[] paramArrayOfString)
  {
    AppMethodBeat.i(52788);
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0))
    {
      AppMethodBeat.o(52788);
      return;
    }
    boolean bool = this.BGp.inTransaction();
    if (!bool) {
      this.BGp.beginTransaction();
    }
    this.BLz.bindString(1, paramString);
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      paramString = paramArrayOfString[i];
      this.BLz.bindString(2, paramString);
      this.BLz.execute();
      i += 1;
    }
    if (!bool) {
      this.BGp.commit();
    }
    AppMethodBeat.o(52788);
  }
  
  public final void v(String paramString, List<Long> paramList)
  {
    AppMethodBeat.i(52785);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(52785);
      return;
    }
    boolean bool = this.BGp.inTransaction();
    if (!bool) {
      this.BGp.beginTransaction();
    }
    this.BLC.bindString(1, paramString);
    paramString = paramList.iterator();
    while (paramString.hasNext())
    {
      long l = ((Long)paramString.next()).longValue();
      this.BLC.bindLong(2, l);
      this.BLC.execute();
    }
    if (!bool) {
      this.BGp.commit();
    }
    AppMethodBeat.o(52785);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.c.a
 * JD-Core Version:    0.7.0.1
 */