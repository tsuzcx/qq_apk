package com.tencent.mm.plugin.fts.c;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a;
import com.tencent.mm.plugin.fts.a.a.c;
import com.tencent.mm.plugin.fts.a.h;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.wcdb.database.SQLiteStatement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class b
  extends a
{
  private SQLiteStatement mVE;
  
  public final void Pn()
  {
    AppMethodBeat.i(136821);
    if (Po())
    {
      localObject = String.format("DROP TABLE IF EXISTS %s", new Object[] { "Feature" });
      this.mQr.execSQL((String)localObject);
      M(-101L, 2L);
    }
    if (!this.mQr.OS("Feature"))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("CREATE TABLE IF NOT EXISTS Feature ( ");
      ((StringBuilder)localObject).append(c.info.sql);
      ((StringBuilder)localObject).append(");");
      localObject = ((StringBuilder)localObject).toString();
      this.mQr.execSQL((String)localObject);
    }
    Object localObject = String.format("INSERT INTO %s (featureId, title, titlePY, titleShortPY, tag, actionType, url, helpUrl, updateUrl, androidUrl, iconPath, timestamp) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);", new Object[] { "Feature" });
    this.mVE = this.mQr.compileStatement((String)localObject);
    AppMethodBeat.o(136821);
  }
  
  public final boolean Po()
  {
    AppMethodBeat.i(136822);
    if (!er(-101, 2))
    {
      AppMethodBeat.o(136822);
      return true;
    }
    AppMethodBeat.o(136822);
    return false;
  }
  
  public final boolean Pp()
  {
    AppMethodBeat.i(136826);
    super.Pp();
    this.mVE.close();
    AppMethodBeat.o(136826);
    return true;
  }
  
  public final boolean bBT()
  {
    return true;
  }
  
  public final List<b.a> bCv()
  {
    AppMethodBeat.i(136823);
    ArrayList localArrayList = new ArrayList();
    HashSet localHashSet = new HashSet();
    Object localObject = String.format("SELECT entity_id, timestamp FROM %s", new Object[] { bBR() });
    localObject = this.mQr.rawQuery((String)localObject, null);
    while (((Cursor)localObject).moveToNext())
    {
      int i = ((Cursor)localObject).getInt(0);
      if (localHashSet.add(Integer.valueOf(i)))
      {
        b.a locala = new b.a();
        locala.mVF = i;
        locala.timestamp = ((Cursor)localObject).getLong(1);
        localArrayList.add(locala);
      }
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(136823);
    return localArrayList;
  }
  
  public final boolean bW(List<c> paramList)
  {
    AppMethodBeat.i(136824);
    boolean bool = this.mQr.inTransaction();
    if (!bool) {
      this.mQr.beginTransaction();
    }
    this.mQr.execSQL("Delete from Feature");
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      c localc = (c)paramList.next();
      try
      {
        this.mVE.bindLong(1, localc.field_featureId);
        this.mVE.bindString(2, localc.field_title);
        this.mVE.bindString(3, localc.field_titlePY);
        this.mVE.bindString(4, localc.field_titleShortPY);
        this.mVE.bindString(5, localc.field_tag);
        this.mVE.bindLong(6, localc.field_actionType);
        this.mVE.bindString(7, localc.field_url);
        this.mVE.bindString(8, localc.field_helpUrl);
        this.mVE.bindString(9, localc.field_updateUrl);
        this.mVE.bindString(10, localc.field_androidUrl);
        this.mVE.bindString(11, localc.field_iconPath);
        this.mVE.bindLong(12, localc.field_timestamp);
        ab.d("MicroMsg.FTS.FTS5FeatureStorage", "insertFeatureItem rowid=%d timestamp=%d", new Object[] { Long.valueOf(this.mVE.executeInsert()), Long.valueOf(localc.field_timestamp) });
      }
      catch (Exception localException) {}
    }
    if (!bool) {
      this.mQr.commit();
    }
    AppMethodBeat.o(136824);
    return true;
  }
  
  public final String getName()
  {
    return "FTS5FeatureStorage";
  }
  
  public final int getPriority()
  {
    return 17;
  }
  
  public final String getTableName()
  {
    return "Feature";
  }
  
  public final int getType()
  {
    return 17;
  }
  
  public final c wv(int paramInt)
  {
    AppMethodBeat.i(136825);
    Object localObject1 = "Select * from Feature where featureId = ".concat(String.valueOf(paramInt));
    localObject1 = this.mQr.rawQuery((String)localObject1, null);
    try
    {
      boolean bool = ((Cursor)localObject1).moveToFirst();
      if (!bool) {
        return null;
      }
      c localc = new c();
      localc.convertFrom((Cursor)localObject1);
      return localc;
    }
    finally
    {
      ((Cursor)localObject1).close();
      AppMethodBeat.o(136825);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.c.b
 * JD-Core Version:    0.7.0.1
 */