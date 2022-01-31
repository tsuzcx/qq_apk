package com.tencent.mm.plugin.fts.c;

import android.database.Cursor;
import com.tencent.mm.plugin.fts.a.a;
import com.tencent.mm.plugin.fts.a.a.c;
import com.tencent.mm.plugin.fts.a.h;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.wcdb.database.SQLiteStatement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class b
  extends a
{
  private SQLiteStatement kzO;
  
  protected final boolean BA()
  {
    return !cT(-101, 2);
  }
  
  protected final boolean BB()
  {
    super.BB();
    this.kzO.close();
    return true;
  }
  
  protected final void Bz()
  {
    if (BA())
    {
      localObject = String.format("DROP TABLE IF EXISTS %s", new Object[] { "Feature" });
      this.kuE.execSQL((String)localObject);
      A(-101L, 2L);
    }
    if (!this.kuE.DJ("Feature"))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("CREATE TABLE IF NOT EXISTS Feature ( ");
      ((StringBuilder)localObject).append(c.buS.sql);
      ((StringBuilder)localObject).append(");");
      localObject = ((StringBuilder)localObject).toString();
      this.kuE.execSQL((String)localObject);
    }
    Object localObject = String.format("INSERT INTO %s (featureId, title, titlePY, titleShortPY, tag, actionType, url, helpUrl, updateUrl, androidUrl, iconPath, timestamp) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);", new Object[] { "Feature" });
    this.kzO = this.kuE.compileStatement((String)localObject);
  }
  
  public final List<b.a> aVS()
  {
    ArrayList localArrayList = new ArrayList();
    HashSet localHashSet = new HashSet();
    Object localObject = String.format("SELECT entity_id, timestamp FROM %s", new Object[] { aVs() });
    localObject = this.kuE.rawQuery((String)localObject, null);
    while (((Cursor)localObject).moveToNext())
    {
      int i = ((Cursor)localObject).getInt(0);
      if (localHashSet.add(Integer.valueOf(i)))
      {
        b.a locala = new b.a();
        locala.kzP = i;
        locala.timestamp = ((Cursor)localObject).getLong(1);
        localArrayList.add(locala);
      }
    }
    ((Cursor)localObject).close();
    return localArrayList;
  }
  
  protected final boolean aVu()
  {
    return true;
  }
  
  public final boolean bB(List<c> paramList)
  {
    boolean bool = this.kuE.inTransaction();
    if (!bool) {
      this.kuE.beginTransaction();
    }
    this.kuE.execSQL("Delete from Feature");
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      c localc = (c)paramList.next();
      try
      {
        this.kzO.bindLong(1, localc.field_featureId);
        this.kzO.bindString(2, localc.field_title);
        this.kzO.bindString(3, localc.field_titlePY);
        this.kzO.bindString(4, localc.field_titleShortPY);
        this.kzO.bindString(5, localc.field_tag);
        this.kzO.bindLong(6, localc.field_actionType);
        this.kzO.bindString(7, localc.field_url);
        this.kzO.bindString(8, localc.field_helpUrl);
        this.kzO.bindString(9, localc.field_updateUrl);
        this.kzO.bindString(10, localc.field_androidUrl);
        this.kzO.bindString(11, localc.field_iconPath);
        this.kzO.bindLong(12, localc.field_timestamp);
        y.d("MicroMsg.FTS.FTS5FeatureStorage", "insertFeatureItem rowid=%d timestamp=%d", new Object[] { Long.valueOf(this.kzO.executeInsert()), Long.valueOf(localc.field_timestamp) });
      }
      catch (Exception localException) {}
    }
    if (!bool) {
      this.kuE.commit();
    }
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
  
  protected final String getTableName()
  {
    return "Feature";
  }
  
  public final int getType()
  {
    return 17;
  }
  
  public final c rz(int paramInt)
  {
    Object localObject1 = "Select * from Feature where featureId = " + paramInt;
    localObject1 = this.kuE.rawQuery((String)localObject1, null);
    try
    {
      boolean bool = ((Cursor)localObject1).moveToFirst();
      if (!bool) {
        return null;
      }
      c localc = new c();
      localc.d((Cursor)localObject1);
      return localc;
    }
    finally
    {
      ((Cursor)localObject1).close();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.c.b
 * JD-Core Version:    0.7.0.1
 */