package com.tencent.mm.plugin.fts.c;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a;
import com.tencent.mm.plugin.fts.a.a.d;
import com.tencent.mm.plugin.fts.a.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.wcdb.database.SQLiteStatement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class b
  extends a
{
  private SQLiteStatement wZH;
  
  public final d Np(int paramInt)
  {
    AppMethodBeat.i(52798);
    Object localObject1 = "Select * from Feature where featureId = ".concat(String.valueOf(paramInt));
    localObject1 = this.wUt.rawQuery((String)localObject1, null);
    try
    {
      boolean bool = ((Cursor)localObject1).moveToFirst();
      if (!bool) {
        return null;
      }
      d locald = new d();
      locald.convertFrom((Cursor)localObject1);
      return locald;
    }
    finally
    {
      ((Cursor)localObject1).close();
      AppMethodBeat.o(52798);
    }
  }
  
  public final void awY()
  {
    AppMethodBeat.i(52794);
    if (awZ())
    {
      localObject = String.format("DROP TABLE IF EXISTS %s", new Object[] { "Feature" });
      this.wUt.execSQL((String)localObject);
      W(-101L, 3L);
    }
    if (!this.wUt.ayi("Feature"))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("CREATE TABLE IF NOT EXISTS Feature ( ");
      ((StringBuilder)localObject).append(d.info.sql);
      ((StringBuilder)localObject).append(");");
      localObject = ((StringBuilder)localObject).toString();
      this.wUt.execSQL((String)localObject);
    }
    Object localObject = String.format("INSERT INTO %s (featureId, title, titlePY, titleShortPY, tag, actionType, url, helpUrl, updateUrl, androidUrl, iconPath, timestamp) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);", new Object[] { "Feature" });
    this.wZH = this.wUt.compileStatement((String)localObject);
    AppMethodBeat.o(52794);
  }
  
  public final boolean awZ()
  {
    AppMethodBeat.i(52795);
    if (!gD(-101, 3))
    {
      AppMethodBeat.o(52795);
      return true;
    }
    AppMethodBeat.o(52795);
    return false;
  }
  
  public final boolean axa()
  {
    AppMethodBeat.i(52799);
    super.axa();
    this.wZH.close();
    AppMethodBeat.o(52799);
    return true;
  }
  
  public final List<a> dOY()
  {
    AppMethodBeat.i(52796);
    ArrayList localArrayList = new ArrayList();
    HashSet localHashSet = new HashSet();
    Object localObject = String.format("SELECT entity_id, timestamp FROM %s", new Object[] { dOt() });
    localObject = this.wUt.rawQuery((String)localObject, null);
    while (((Cursor)localObject).moveToNext())
    {
      int i = ((Cursor)localObject).getInt(0);
      if (localHashSet.add(Integer.valueOf(i)))
      {
        a locala = new a();
        locala.wZI = i;
        locala.timestamp = ((Cursor)localObject).getLong(1);
        localArrayList.add(locala);
      }
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(52796);
    return localArrayList;
  }
  
  public final boolean dOv()
  {
    return true;
  }
  
  public final boolean eR(List<d> paramList)
  {
    AppMethodBeat.i(52797);
    boolean bool = this.wUt.inTransaction();
    if (!bool) {
      this.wUt.beginTransaction();
    }
    this.wUt.execSQL("Delete from Feature");
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      d locald = (d)paramList.next();
      try
      {
        this.wZH.bindLong(1, locald.field_featureId);
        this.wZH.bindString(2, locald.field_title);
        this.wZH.bindString(3, locald.field_titlePY);
        this.wZH.bindString(4, locald.field_titleShortPY);
        this.wZH.bindString(5, locald.field_tag);
        this.wZH.bindLong(6, locald.field_actionType);
        this.wZH.bindString(7, locald.field_url);
        this.wZH.bindString(8, locald.field_helpUrl);
        this.wZH.bindString(9, locald.field_updateUrl);
        this.wZH.bindString(10, locald.field_androidUrl);
        this.wZH.bindString(11, locald.field_iconPath);
        this.wZH.bindLong(12, locald.field_timestamp);
        Log.d("MicroMsg.FTS.FTS5FeatureStorage", "insertFeatureItem rowid=%d timestamp=%d", new Object[] { Long.valueOf(this.wZH.executeInsert()), Long.valueOf(locald.field_timestamp) });
      }
      catch (Exception localException) {}
    }
    if (!bool) {
      this.wUt.commit();
    }
    AppMethodBeat.o(52797);
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
  
  public static final class a
  {
    public long timestamp;
    public int wZI;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.c.b
 * JD-Core Version:    0.7.0.1
 */