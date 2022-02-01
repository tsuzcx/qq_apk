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

public abstract class dv
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("GetEmotionListCache");
  private static final int kAa;
  private static final int kAb;
  public static final Column kzW;
  public static final Column kzX;
  private static final StorageObserverOwner<dv> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  public byte[] field_cache;
  public String field_reqType;
  private boolean kzY = true;
  private boolean kzZ = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    kzW = new Column("reqType", "string", TABLE.getName(), "");
    kzX = new Column("cache", "byte[]", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    kAa = "reqType".hashCode();
    kAb = "cache".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[2];
    localMAutoDBInfo.columns = new String[3];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "reqType";
    localMAutoDBInfo.colsMap.put("reqType", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" reqType TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "reqType";
    localMAutoDBInfo.columns[1] = "cache";
    localMAutoDBInfo.colsMap.put("cache", "BLOB default '' ");
    localStringBuilder.append(" cache BLOB default '' ");
    localMAutoDBInfo.columns[2] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("reqType"))
    {
      this.field_reqType = paramContentValues.getAsString("reqType");
      if (paramBoolean) {
        this.kzY = true;
      }
    }
    if (paramContentValues.containsKey("cache"))
    {
      this.field_cache = paramContentValues.getAsByteArray("cache");
      if (paramBoolean) {
        this.kzZ = true;
      }
    }
    if (paramContentValues.containsKey("rowid")) {
      this.systemRowid = paramContentValues.getAsLong("rowid").longValue();
    }
  }
  
  public void convertFrom(Cursor paramCursor)
  {
    String[] arrayOfString = paramCursor.getColumnNames();
    if (arrayOfString == null) {
      return;
    }
    int i = 0;
    int j = arrayOfString.length;
    label20:
    int k;
    if (i < j)
    {
      k = arrayOfString[i].hashCode();
      if (kAa != k) {
        break label65;
      }
      this.field_reqType = paramCursor.getString(i);
      this.kzY = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (kAb == k) {
        this.field_cache = paramCursor.getBlob(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.kzY) {
      localContentValues.put("reqType", this.field_reqType);
    }
    if (this.kzZ) {
      localContentValues.put("cache", this.field_cache);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
  
  public IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return DB_INFO;
  }
  
  public String[] getIndexCreateSQL()
  {
    return INDEX_CREATE;
  }
  
  public StorageObserverOwner<? extends dv> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return this.field_reqType;
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
 * Qualified Name:     com.tencent.mm.autogen.b.dv
 * JD-Core Version:    0.7.0.1
 */