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

public abstract class bh
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("DuplicateKVLog");
  public static final Column kcc;
  public static final Column kcd;
  private static final int kce;
  private static final int kcf;
  private static final StorageObserverOwner<bh> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  public int field_bakLogId;
  public String field_valueStr;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    kcc = new Column("bakLogId", "int", TABLE.getName(), "");
    kcd = new Column("valueStr", "string", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    kce = "bakLogId".hashCode();
    kcf = "valueStr".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[2];
    localMAutoDBInfo.columns = new String[3];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "bakLogId";
    localMAutoDBInfo.colsMap.put("bakLogId", "INTEGER");
    localStringBuilder.append(" bakLogId INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[1] = "valueStr";
    localMAutoDBInfo.colsMap.put("valueStr", "TEXT");
    localStringBuilder.append(" valueStr TEXT");
    localMAutoDBInfo.columns[2] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("bakLogId"))
    {
      paramContentValues.getAsInteger("bakLogId").intValue();
      throw null;
    }
    if (paramContentValues.containsKey("valueStr"))
    {
      paramContentValues.getAsString("valueStr");
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
        if (kce == k)
        {
          paramCursor.getInt(i);
          throw null;
        }
        if (kcf == k)
        {
          paramCursor.getString(i);
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
  
  public StorageObserverOwner<? extends bh> getObserverOwner()
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
 * Qualified Name:     com.tencent.mm.autogen.b.bh
 * JD-Core Version:    0.7.0.1
 */