package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.h;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.wcdb.database.SQLiteStatement;
import java.util.Iterator;
import java.util.List;

public final class b
  extends a
{
  private SQLiteStatement HwA;
  public SQLiteStatement HwB;
  public SQLiteStatement Hwv;
  public SQLiteStatement Hww;
  private SQLiteStatement Hwx;
  public SQLiteStatement Hwy;
  public SQLiteStatement Hwz;
  
  public final void A(String paramString, List<Long> paramList)
  {
    AppMethodBeat.i(52785);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(52785);
      return;
    }
    boolean bool = this.HqR.inTransaction();
    if (!bool) {
      this.HqR.beginTransaction();
    }
    this.Hwy.bindString(1, paramString);
    paramString = paramList.iterator();
    while (paramString.hasNext())
    {
      long l = ((Long)paramString.next()).longValue();
      this.Hwy.bindLong(2, l);
      this.Hwy.execute();
    }
    if (!bool) {
      this.HqR.commit();
    }
    AppMethodBeat.o(52785);
  }
  
  public final Cursor a(j paramj, String paramString, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    AppMethodBeat.i(52792);
    String str = paramj.fxx();
    if (Util.isNullOrNil(paramString))
    {
      paramj = "";
      if ((paramArrayOfInt1 == null) || (paramArrayOfInt1.length <= 0)) {
        break label196;
      }
      paramString = " AND type IN " + d.G(paramArrayOfInt1);
      label50:
      if ((paramArrayOfInt2 == null) || (paramArrayOfInt2.length <= 0)) {
        break label202;
      }
    }
    label196:
    label202:
    for (paramArrayOfInt1 = " AND subtype IN " + d.G(paramArrayOfInt2);; paramArrayOfInt1 = "")
    {
      paramj = String.format("SELECT aux_index, type, subtype FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s'" + paramj + paramString + paramArrayOfInt1 + " AND status >= 0 ORDER BY subtype;", new Object[] { fxn(), fxo(), fxn(), fxo(), fxo(), str });
      paramj = this.HqR.rawQuery(paramj, null);
      AppMethodBeat.o(52792);
      return paramj;
      paramj = String.format(" AND aux_index = '%s'", new Object[] { paramString });
      break;
      paramString = "";
      break label50;
    }
  }
  
  public final void aEA(String paramString)
  {
    AppMethodBeat.i(52786);
    this.HwA.bindString(1, paramString);
    this.HwA.execute();
    AppMethodBeat.o(52786);
  }
  
  public final Cursor aEB(String paramString)
  {
    AppMethodBeat.i(52787);
    paramString = this.HqR.rawQuery("SELECT DISTINCT chatroom FROM FTS5ChatRoomMembers WHERE member=?;", new String[] { paramString });
    AppMethodBeat.o(52787);
    return paramString;
  }
  
  public final void aEC(String paramString)
  {
    AppMethodBeat.i(52789);
    this.Hwx.bindString(1, paramString);
    this.Hwx.execute();
    AppMethodBeat.o(52789);
  }
  
  public final void aXv()
  {
    AppMethodBeat.i(52783);
    if (aXw()) {
      this.HqR.aG(-102L, 5L);
    }
    this.HqR.execSQL("CREATE TABLE IF NOT EXISTS FTS5ChatRoomMembers (chatroom TEXT, member TEXT);");
    this.HqR.execSQL("CREATE INDEX IF NOT EXISTS FTS5ChatRoomMembers_chatroom ON FTS5ChatRoomMembers(chatroom);");
    this.HqR.execSQL("CREATE INDEX IF NOT EXISTS FTS5ChatRoomMembers_member ON FTS5ChatRoomMembers(member);");
    this.HqR.execSQL("CREATE TABLE IF NOT EXISTS FTS5ContactLabels (user TEXT, label_id INTEGER);");
    this.HqR.execSQL("CREATE INDEX IF NOT EXISTS FTS5ContactLabels_user ON FTS5ContactLabels(user);");
    this.HqR.execSQL("CREATE INDEX IF NOT EXISTS FTS5ContactLabels_label ON FTS5ContactLabels(label_id);");
    this.Hwv = this.HqR.compileStatement("INSERT INTO FTS5ChatRoomMembers (chatroom, member) VALUES (?, ?);");
    this.Hww = this.HqR.compileStatement("DELETE FROM FTS5ChatRoomMembers WHERE chatroom=? AND member=?;");
    this.Hwx = this.HqR.compileStatement("DELETE FROM FTS5ChatRoomMembers WHERE chatroom=?;");
    this.Hwy = this.HqR.compileStatement("INSERT INTO FTS5ContactLabels (user, label_id) VALUES (?, ?);");
    this.Hwz = this.HqR.compileStatement("DELETE FROM FTS5ContactLabels WHERE user=? AND label_id=?;");
    this.HwA = this.HqR.compileStatement("DELETE FROM FTS5ContactLabels WHERE user=?;");
    this.HwB = this.HqR.compileStatement("SELECT changes();");
    AppMethodBeat.o(52783);
  }
  
  public final boolean aXw()
  {
    AppMethodBeat.i(52791);
    if (!iV(-102, 5))
    {
      AppMethodBeat.o(52791);
      return true;
    }
    AppMethodBeat.o(52791);
    return false;
  }
  
  public final boolean aXx()
  {
    AppMethodBeat.i(52784);
    super.aXx();
    this.Hwv.close();
    this.Hww.close();
    this.Hwx.close();
    this.Hwy.close();
    this.Hwz.close();
    this.HwA.close();
    this.HwB.close();
    AppMethodBeat.o(52784);
    return true;
  }
  
  public final boolean b(j paramj)
  {
    AppMethodBeat.i(52793);
    paramj = String.format("SELECT 1 FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND type=131072 LIMIT 1;", new Object[] { fxn(), fxo(), fxn(), fxo(), fxo(), paramj.fxy() });
    paramj = this.HqR.rawQuery(paramj, null);
    boolean bool = paramj.moveToNext();
    paramj.close();
    AppMethodBeat.o(52793);
    return bool;
  }
  
  public final String dRh()
  {
    AppMethodBeat.i(52790);
    String str = String.format("CREATE TABLE IF NOT EXISTS %s (docid INTEGER PRIMARY KEY, type INT, subtype INT DEFAULT 0, entity_id INTEGER, aux_index TEXT, timestamp INTEGER, status INT DEFAULT 0);", new Object[] { fxn() });
    AppMethodBeat.o(52790);
    return str;
  }
  
  public final boolean fxr()
  {
    return true;
  }
  
  public final String getLogTag()
  {
    return "MicroMsg.FTS.FTS5ContactStorage";
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
    boolean bool = this.HqR.inTransaction();
    if (!bool) {
      this.HqR.beginTransaction();
    }
    this.Hwv.bindString(1, paramString);
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      paramString = paramArrayOfString[i];
      this.Hwv.bindString(2, paramString);
      this.Hwv.execute();
      i += 1;
    }
    if (!bool) {
      this.HqR.commit();
    }
    AppMethodBeat.o(52788);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.b
 * JD-Core Version:    0.7.0.1
 */