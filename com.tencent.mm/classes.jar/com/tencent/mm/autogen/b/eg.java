package com.tencent.mm.autogen.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.observer.StorageObserverOwner;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class eg
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("HardDeviceProfileRankDetail");
  public static final Column jON;
  private static final int jOT;
  public static final Column kDo;
  private static final int kDu;
  public static final Column kDw;
  private static final int kDx;
  private static final StorageObserverOwner<eg> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  public String field_appusername;
  public int field_score;
  public String field_title;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    kDo = new Column("appusername", "string", TABLE.getName(), "");
    jON = new Column("title", "string", TABLE.getName(), "");
    kDw = new Column("score", "int", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    kDu = "appusername".hashCode();
    jOT = "title".hashCode();
    kDx = "score".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[3];
    localMAutoDBInfo.columns = new String[4];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "appusername";
    localMAutoDBInfo.colsMap.put("appusername", "TEXT");
    localStringBuilder.append(" appusername TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[1] = "title";
    localMAutoDBInfo.colsMap.put("title", "TEXT");
    localStringBuilder.append(" title TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "score";
    localMAutoDBInfo.colsMap.put("score", "INTEGER");
    localStringBuilder.append(" score INTEGER");
    localMAutoDBInfo.columns[3] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("appusername"))
    {
      paramContentValues.getAsString("appusername");
      throw null;
    }
    if (paramContentValues.containsKey("title"))
    {
      paramContentValues.getAsString("title");
      throw null;
    }
    if (paramContentValues.containsKey("score"))
    {
      paramContentValues.getAsInteger("score").intValue();
      throw null;
    }
    if (paramContentValues.containsKey("rowid")) {
      this.systemRowid = paramContentValues.getAsLong("rowid").longValue();
    }
  }
  
  public void convertFrom(Cursor paramCursor)
  {
    String[] arrayOfString = paramCursor.getColumnNames();
    if (arrayOfString == null) {}
    for (;;)
    {
      return;
      int i = 0;
      int j = arrayOfString.length;
      while (i < j)
      {
        int k = arrayOfString[i].hashCode();
        if (kDu == k)
        {
          paramCursor.getString(i);
          throw null;
        }
        if (jOT == k)
        {
          paramCursor.getString(i);
          throw null;
        }
        if (kDx == k)
        {
          paramCursor.getInt(i);
          throw null;
        }
        if (rowid_HASHCODE == k) {
          this.systemRowid = paramCursor.getLong(i);
        }
        i += 1;
      }
    }
  }
  
  public ContentValues convertTo()
  {
    new ContentValues();
    throw null;
  }
  
  public IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return DB_INFO;
  }
  
  public String[] getIndexCreateSQL()
  {
    return INDEX_CREATE;
  }
  
  public StorageObserverOwner<? extends eg> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return Long.valueOf(this.systemRowid);
  }
  
  public SingleTable getTable()
  {
    return TABLE;
  }
  
  public String getTableName()
  {
    return TABLE.getName();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.b.eg
 * JD-Core Version:    0.7.0.1
 */