package com.tencent.mm.plugin.fts.c;

import android.database.Cursor;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.g.c;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.wcdb.database.SQLiteStatement;
import java.util.Iterator;
import java.util.List;

public final class a
  extends com.tencent.mm.plugin.fts.a.a
{
  public SQLiteStatement kzH;
  public SQLiteStatement kzI;
  private SQLiteStatement kzJ;
  public SQLiteStatement kzK;
  public SQLiteStatement kzL;
  private SQLiteStatement kzM;
  public SQLiteStatement kzN;
  
  protected final boolean BA()
  {
    return !cT(-102, 4);
  }
  
  protected final boolean BB()
  {
    super.BB();
    this.kzH.close();
    this.kzI.close();
    this.kzJ.close();
    this.kzK.close();
    this.kzL.close();
    this.kzM.close();
    this.kzN.close();
    return true;
  }
  
  protected final void Bz()
  {
    if (BA()) {
      this.kuE.A(-102L, 4L);
    }
    this.kuE.execSQL("CREATE TABLE IF NOT EXISTS FTS5ChatRoomMembers (chatroom TEXT, member TEXT);");
    this.kuE.execSQL("CREATE INDEX IF NOT EXISTS FTS5ChatRoomMembers_chatroom ON FTS5ChatRoomMembers(chatroom);");
    this.kuE.execSQL("CREATE INDEX IF NOT EXISTS FTS5ChatRoomMembers_member ON FTS5ChatRoomMembers(member);");
    this.kuE.execSQL("CREATE TABLE IF NOT EXISTS FTS5ContactLabels (user TEXT, label_id INTEGER);");
    this.kuE.execSQL("CREATE INDEX IF NOT EXISTS FTS5ContactLabels_user ON FTS5ContactLabels(user);");
    this.kuE.execSQL("CREATE INDEX IF NOT EXISTS FTS5ContactLabels_label ON FTS5ContactLabels(label_id);");
    this.kzH = this.kuE.compileStatement("INSERT INTO FTS5ChatRoomMembers (chatroom, member) VALUES (?, ?);");
    this.kzI = this.kuE.compileStatement("DELETE FROM FTS5ChatRoomMembers WHERE chatroom=? AND member=?;");
    this.kzJ = this.kuE.compileStatement("DELETE FROM FTS5ChatRoomMembers WHERE chatroom=?;");
    this.kzK = this.kuE.compileStatement("INSERT INTO FTS5ContactLabels (user, label_id) VALUES (?, ?);");
    this.kzL = this.kuE.compileStatement("DELETE FROM FTS5ContactLabels WHERE user=? AND label_id=?;");
    this.kzM = this.kuE.compileStatement("DELETE FROM FTS5ContactLabels WHERE user=?;");
    this.kzN = this.kuE.compileStatement("SELECT changes();");
  }
  
  public final void Ee(String paramString)
  {
    this.kzM.bindString(1, paramString);
    this.kzM.execute();
  }
  
  public final Cursor Ef(String paramString)
  {
    return this.kuE.rawQuery("SELECT DISTINCT chatroom FROM FTS5ChatRoomMembers WHERE member=?;", new String[] { paramString });
  }
  
  public final void Eg(String paramString)
  {
    this.kzJ.bindString(1, paramString);
    this.kzJ.execute();
  }
  
  public final Cursor a(g paramg, String paramString, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    String str = paramg.aVy();
    if (bk.bl(paramString))
    {
      paramg = "";
      if ((paramArrayOfInt1 == null) || (paramArrayOfInt1.length <= 0)) {
        break label184;
      }
      paramString = " AND type IN " + d.l(paramArrayOfInt1);
      label45:
      if ((paramArrayOfInt2 == null) || (paramArrayOfInt2.length <= 0)) {
        break label190;
      }
    }
    label184:
    label190:
    for (paramArrayOfInt1 = " AND subtype IN " + d.l(paramArrayOfInt2);; paramArrayOfInt1 = "")
    {
      paramg = String.format("SELECT aux_index, type, subtype FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s'" + paramg + paramString + paramArrayOfInt1 + " AND status >= 0 ORDER BY subtype;", new Object[] { aVs(), aVt(), aVs(), aVt(), aVt(), str });
      return this.kuE.rawQuery(paramg, null);
      paramg = String.format(" AND aux_index = '%s'", new Object[] { paramString });
      break;
      paramString = "";
      break label45;
    }
  }
  
  protected final String aQT()
  {
    return String.format("CREATE TABLE IF NOT EXISTS %s (docid INTEGER PRIMARY KEY, type INT, subtype INT DEFAULT 0, entity_id INTEGER, aux_index TEXT, timestamp INTEGER, status INT DEFAULT 0);", new Object[] { aVs() });
  }
  
  protected final boolean aVu()
  {
    return true;
  }
  
  public final boolean b(g paramg)
  {
    String str1 = aVs();
    String str2 = aVt();
    String str3 = aVs();
    String str4 = aVt();
    String str5 = aVt();
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < paramg.kwK.size())
    {
      localStringBuffer.append("(");
      localStringBuffer.append(((g.c)paramg.kwK.get(i)).aVz());
      localStringBuffer.append(")");
      if (i != paramg.kwK.size() - 1) {
        localStringBuffer.append(" OR ");
      }
      i += 1;
    }
    paramg = String.format("SELECT 1 FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND type=131072 LIMIT 1;", new Object[] { str1, str2, str3, str4, str5, localStringBuffer.toString() });
    paramg = this.kuE.rawQuery(paramg, null);
    boolean bool = paramg.moveToNext();
    paramg.close();
    return bool;
  }
  
  public final String getName()
  {
    return "FTS5ContactStorage";
  }
  
  public final int getPriority()
  {
    return 3;
  }
  
  protected final String getTableName()
  {
    return "Contact";
  }
  
  public final int getType()
  {
    return 3;
  }
  
  public final void i(String paramString, String[] paramArrayOfString)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {}
    boolean bool;
    do
    {
      return;
      bool = this.kuE.inTransaction();
      if (!bool) {
        this.kuE.beginTransaction();
      }
      this.kzH.bindString(1, paramString);
      int j = paramArrayOfString.length;
      int i = 0;
      while (i < j)
      {
        paramString = paramArrayOfString[i];
        this.kzH.bindString(2, paramString);
        this.kzH.execute();
        i += 1;
      }
    } while (bool);
    this.kuE.commit();
  }
  
  public final void k(String paramString, List<Long> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {}
    boolean bool;
    do
    {
      return;
      bool = this.kuE.inTransaction();
      if (!bool) {
        this.kuE.beginTransaction();
      }
      this.kzK.bindString(1, paramString);
      paramString = paramList.iterator();
      while (paramString.hasNext())
      {
        long l = ((Long)paramString.next()).longValue();
        this.kzK.bindLong(2, l);
        this.kzK.execute();
      }
    } while (bool);
    this.kuE.commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.c.a
 * JD-Core Version:    0.7.0.1
 */