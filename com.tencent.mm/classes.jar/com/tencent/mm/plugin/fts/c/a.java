package com.tencent.mm.plugin.fts.c;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.g.c;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.h;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.wcdb.database.SQLiteStatement;
import java.util.Iterator;
import java.util.List;

public final class a
  extends com.tencent.mm.plugin.fts.a.a
{
  public SQLiteStatement mVA;
  public SQLiteStatement mVB;
  private SQLiteStatement mVC;
  public SQLiteStatement mVD;
  public SQLiteStatement mVx;
  public SQLiteStatement mVy;
  private SQLiteStatement mVz;
  
  public final void Pn()
  {
    AppMethodBeat.i(136810);
    if (Po()) {
      this.mQr.M(-102L, 4L);
    }
    this.mQr.execSQL("CREATE TABLE IF NOT EXISTS FTS5ChatRoomMembers (chatroom TEXT, member TEXT);");
    this.mQr.execSQL("CREATE INDEX IF NOT EXISTS FTS5ChatRoomMembers_chatroom ON FTS5ChatRoomMembers(chatroom);");
    this.mQr.execSQL("CREATE INDEX IF NOT EXISTS FTS5ChatRoomMembers_member ON FTS5ChatRoomMembers(member);");
    this.mQr.execSQL("CREATE TABLE IF NOT EXISTS FTS5ContactLabels (user TEXT, label_id INTEGER);");
    this.mQr.execSQL("CREATE INDEX IF NOT EXISTS FTS5ContactLabels_user ON FTS5ContactLabels(user);");
    this.mQr.execSQL("CREATE INDEX IF NOT EXISTS FTS5ContactLabels_label ON FTS5ContactLabels(label_id);");
    this.mVx = this.mQr.compileStatement("INSERT INTO FTS5ChatRoomMembers (chatroom, member) VALUES (?, ?);");
    this.mVy = this.mQr.compileStatement("DELETE FROM FTS5ChatRoomMembers WHERE chatroom=? AND member=?;");
    this.mVz = this.mQr.compileStatement("DELETE FROM FTS5ChatRoomMembers WHERE chatroom=?;");
    this.mVA = this.mQr.compileStatement("INSERT INTO FTS5ContactLabels (user, label_id) VALUES (?, ?);");
    this.mVB = this.mQr.compileStatement("DELETE FROM FTS5ContactLabels WHERE user=? AND label_id=?;");
    this.mVC = this.mQr.compileStatement("DELETE FROM FTS5ContactLabels WHERE user=?;");
    this.mVD = this.mQr.compileStatement("SELECT changes();");
    AppMethodBeat.o(136810);
  }
  
  public final void Po(String paramString)
  {
    AppMethodBeat.i(136813);
    this.mVC.bindString(1, paramString);
    this.mVC.execute();
    AppMethodBeat.o(136813);
  }
  
  public final boolean Po()
  {
    AppMethodBeat.i(136818);
    if (!er(-102, 4))
    {
      AppMethodBeat.o(136818);
      return true;
    }
    AppMethodBeat.o(136818);
    return false;
  }
  
  public final Cursor Pp(String paramString)
  {
    AppMethodBeat.i(136814);
    paramString = this.mQr.rawQuery("SELECT DISTINCT chatroom FROM FTS5ChatRoomMembers WHERE member=?;", new String[] { paramString });
    AppMethodBeat.o(136814);
    return paramString;
  }
  
  public final boolean Pp()
  {
    AppMethodBeat.i(136811);
    super.Pp();
    this.mVx.close();
    this.mVy.close();
    this.mVz.close();
    this.mVA.close();
    this.mVB.close();
    this.mVC.close();
    this.mVD.close();
    AppMethodBeat.o(136811);
    return true;
  }
  
  public final void Pq(String paramString)
  {
    AppMethodBeat.i(136816);
    this.mVz.bindString(1, paramString);
    this.mVz.execute();
    AppMethodBeat.o(136816);
  }
  
  public final Cursor a(g paramg, String paramString, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    AppMethodBeat.i(136819);
    String str = paramg.bBX();
    if (bo.isNullOrNil(paramString))
    {
      paramg = "";
      if ((paramArrayOfInt1 == null) || (paramArrayOfInt1.length <= 0)) {
        break label196;
      }
      paramString = " AND type IN " + d.v(paramArrayOfInt1);
      label50:
      if ((paramArrayOfInt2 == null) || (paramArrayOfInt2.length <= 0)) {
        break label202;
      }
    }
    label196:
    label202:
    for (paramArrayOfInt1 = " AND subtype IN " + d.v(paramArrayOfInt2);; paramArrayOfInt1 = "")
    {
      paramg = String.format("SELECT aux_index, type, subtype FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s'" + paramg + paramString + paramArrayOfInt1 + " AND status >= 0 ORDER BY subtype;", new Object[] { bBR(), bBS(), bBR(), bBS(), bBS(), str });
      paramg = this.mQr.rawQuery(paramg, null);
      AppMethodBeat.o(136819);
      return paramg;
      paramg = String.format(" AND aux_index = '%s'", new Object[] { paramString });
      break;
      paramString = "";
      break label50;
    }
  }
  
  public final boolean b(g paramg)
  {
    AppMethodBeat.i(136820);
    String str1 = bBR();
    String str2 = bBS();
    String str3 = bBR();
    String str4 = bBS();
    String str5 = bBS();
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < paramg.mSA.size())
    {
      localStringBuffer.append("(");
      localStringBuffer.append(((g.c)paramg.mSA.get(i)).bBZ());
      localStringBuffer.append(")");
      if (i != paramg.mSA.size() - 1) {
        localStringBuffer.append(" OR ");
      }
      i += 1;
    }
    paramg = String.format("SELECT 1 FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND type=131072 LIMIT 1;", new Object[] { str1, str2, str3, str4, str5, localStringBuffer.toString() });
    paramg = this.mQr.rawQuery(paramg, null);
    boolean bool = paramg.moveToNext();
    paramg.close();
    AppMethodBeat.o(136820);
    return bool;
  }
  
  public final boolean bBT()
  {
    return true;
  }
  
  public final String bxi()
  {
    AppMethodBeat.i(136817);
    String str = String.format("CREATE TABLE IF NOT EXISTS %s (docid INTEGER PRIMARY KEY, type INT, subtype INT DEFAULT 0, entity_id INTEGER, aux_index TEXT, timestamp INTEGER, status INT DEFAULT 0);", new Object[] { bBR() });
    AppMethodBeat.o(136817);
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
    AppMethodBeat.i(136815);
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0))
    {
      AppMethodBeat.o(136815);
      return;
    }
    boolean bool = this.mQr.inTransaction();
    if (!bool) {
      this.mQr.beginTransaction();
    }
    this.mVx.bindString(1, paramString);
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      paramString = paramArrayOfString[i];
      this.mVx.bindString(2, paramString);
      this.mVx.execute();
      i += 1;
    }
    if (!bool) {
      this.mQr.commit();
    }
    AppMethodBeat.o(136815);
  }
  
  public final void l(String paramString, List<Long> paramList)
  {
    AppMethodBeat.i(136812);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(136812);
      return;
    }
    boolean bool = this.mQr.inTransaction();
    if (!bool) {
      this.mQr.beginTransaction();
    }
    this.mVA.bindString(1, paramString);
    paramString = paramList.iterator();
    while (paramString.hasNext())
    {
      long l = ((Long)paramString.next()).longValue();
      this.mVA.bindLong(2, l);
      this.mVA.execute();
    }
    if (!bool) {
      this.mQr.commit();
    }
    AppMethodBeat.o(136812);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.c.a
 * JD-Core Version:    0.7.0.1
 */