package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a;
import com.tencent.mm.plugin.fts.a.a.f;
import com.tencent.mm.plugin.fts.a.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.wcdb.database.SQLiteStatement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class c
  extends a
{
  private SQLiteStatement HwC;
  
  private void a(f paramf)
  {
    AppMethodBeat.i(265427);
    try
    {
      this.HwC.bindLong(1, paramf.field_featureId);
      this.HwC.bindString(2, paramf.field_title);
      this.HwC.bindString(3, paramf.field_titlePY);
      this.HwC.bindString(4, paramf.field_titleShortPY);
      this.HwC.bindString(5, paramf.field_tag);
      this.HwC.bindLong(6, paramf.field_actionType);
      this.HwC.bindString(7, paramf.field_url);
      this.HwC.bindString(8, paramf.field_helpUrl);
      this.HwC.bindString(9, paramf.field_updateUrl);
      this.HwC.bindString(10, paramf.field_androidUrl);
      this.HwC.bindString(11, paramf.field_iconPath);
      this.HwC.bindLong(12, paramf.field_timestamp);
      Log.d("MicroMsg.FTS.FTS5FeatureStorage", "insertFeatureItem rowid=%d timestamp=%d", new Object[] { Long.valueOf(this.HwC.executeInsert()), Long.valueOf(paramf.field_timestamp) });
      AppMethodBeat.o(265427);
      return;
    }
    catch (Exception paramf)
    {
      AppMethodBeat.o(265427);
    }
  }
  
  private void fya()
  {
    AppMethodBeat.i(265431);
    this.HqR.execSQL("Delete from Feature");
    AppMethodBeat.o(265431);
  }
  
  public final f Wk(int paramInt)
  {
    AppMethodBeat.i(52798);
    Object localObject1 = "Select * from Feature where featureId = ".concat(String.valueOf(paramInt));
    localObject1 = this.HqR.rawQuery((String)localObject1, null);
    try
    {
      boolean bool = ((Cursor)localObject1).moveToFirst();
      if (!bool) {
        return null;
      }
      f localf = new f();
      localf.convertFrom((Cursor)localObject1);
      return localf;
    }
    finally
    {
      if (localObject1 != null) {
        ((Cursor)localObject1).close();
      }
      AppMethodBeat.o(52798);
    }
  }
  
  public final void aXv()
  {
    AppMethodBeat.i(52794);
    if (aXw())
    {
      localObject = String.format("DROP TABLE IF EXISTS %s", new Object[] { "Feature" });
      this.HqR.execSQL((String)localObject);
      aG(-101L, 3L);
    }
    if (!this.HqR.aDZ("Feature"))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("CREATE TABLE IF NOT EXISTS Feature ( ");
      ((StringBuilder)localObject).append(f.info.sql);
      ((StringBuilder)localObject).append(");");
      localObject = ((StringBuilder)localObject).toString();
      this.HqR.execSQL((String)localObject);
    }
    Object localObject = String.format("INSERT INTO %s (featureId, title, titlePY, titleShortPY, tag, actionType, url, helpUrl, updateUrl, androidUrl, iconPath, timestamp) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);", new Object[] { "Feature" });
    this.HwC = this.HqR.compileStatement((String)localObject);
    AppMethodBeat.o(52794);
  }
  
  public final boolean aXw()
  {
    AppMethodBeat.i(52795);
    if (!iV(-101, 3))
    {
      AppMethodBeat.o(52795);
      return true;
    }
    AppMethodBeat.o(52795);
    return false;
  }
  
  public final boolean aXx()
  {
    AppMethodBeat.i(52799);
    super.aXx();
    this.HwC.close();
    AppMethodBeat.o(52799);
    return true;
  }
  
  public final List<a> fxZ()
  {
    AppMethodBeat.i(52796);
    ArrayList localArrayList = new ArrayList();
    HashSet localHashSet = new HashSet();
    Object localObject = String.format("SELECT entity_id, timestamp FROM %s", new Object[] { fxn() });
    localObject = this.HqR.rawQuery((String)localObject, null);
    while (((Cursor)localObject).moveToNext())
    {
      int i = ((Cursor)localObject).getInt(0);
      if (localHashSet.add(Integer.valueOf(i)))
      {
        a locala = new a();
        locala.HwD = i;
        locala.timestamp = ((Cursor)localObject).getLong(1);
        localArrayList.add(locala);
      }
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(52796);
    return localArrayList;
  }
  
  public final boolean fxr()
  {
    return true;
  }
  
  public final String getLogTag()
  {
    return "MicroMsg.FTS.FTS5FeatureStorage";
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
  
  public final boolean hU(List<f> paramList)
  {
    AppMethodBeat.i(52797);
    boolean bool = this.HqR.inTransaction();
    if (!bool) {
      this.HqR.beginTransaction();
    }
    fya();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      a((f)paramList.next());
    }
    if (!bool) {
      this.HqR.commit();
    }
    AppMethodBeat.o(52797);
    return true;
  }
  
  public static final class a
  {
    public int HwD;
    public long timestamp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.c
 * JD-Core Version:    0.7.0.1
 */