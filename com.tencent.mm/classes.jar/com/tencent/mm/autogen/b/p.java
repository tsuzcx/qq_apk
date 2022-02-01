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

public abstract class p
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column KEY;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("AppBrandKVData");
  public static final Column jLP;
  public static final Column jLQ;
  private static final int jLT;
  private static final int jLU;
  public static final Column jLt;
  private static final int jLz;
  private static final int key_HASHCODE;
  private static final StorageObserverOwner<p> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  private boolean __hadSetkey = true;
  public String field_data;
  public String field_dataType;
  public String field_key;
  public int field_size;
  private boolean jLR = true;
  private boolean jLS = true;
  private boolean jLw = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    KEY = new Column("key", "string", TABLE.getName(), "");
    jLt = new Column("data", "string", TABLE.getName(), "");
    jLP = new Column("dataType", "string", TABLE.getName(), "");
    jLQ = new Column("size", "int", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    key_HASHCODE = "key".hashCode();
    jLz = "data".hashCode();
    jLT = "dataType".hashCode();
    jLU = "size".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[4];
    localMAutoDBInfo.columns = new String[5];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "key";
    localMAutoDBInfo.colsMap.put("key", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" key TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "key";
    localMAutoDBInfo.columns[1] = "data";
    localMAutoDBInfo.colsMap.put("data", "TEXT");
    localStringBuilder.append(" data TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "dataType";
    localMAutoDBInfo.colsMap.put("dataType", "TEXT");
    localStringBuilder.append(" dataType TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "size";
    localMAutoDBInfo.colsMap.put("size", "INTEGER");
    localStringBuilder.append(" size INTEGER");
    localMAutoDBInfo.columns[4] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("key"))
    {
      this.field_key = paramContentValues.getAsString("key");
      if (paramBoolean) {
        this.__hadSetkey = true;
      }
    }
    if (paramContentValues.containsKey("data"))
    {
      this.field_data = paramContentValues.getAsString("data");
      if (paramBoolean) {
        this.jLw = true;
      }
    }
    if (paramContentValues.containsKey("dataType"))
    {
      this.field_dataType = paramContentValues.getAsString("dataType");
      if (paramBoolean) {
        this.jLR = true;
      }
    }
    if (paramContentValues.containsKey("size"))
    {
      this.field_size = paramContentValues.getAsInteger("size").intValue();
      if (paramBoolean) {
        this.jLS = true;
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
      if (key_HASHCODE != k) {
        break label65;
      }
      this.field_key = paramCursor.getString(i);
      this.__hadSetkey = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (jLz == k) {
        this.field_data = paramCursor.getString(i);
      } else if (jLT == k) {
        this.field_dataType = paramCursor.getString(i);
      } else if (jLU == k) {
        this.field_size = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.__hadSetkey) {
      localContentValues.put("key", this.field_key);
    }
    if (this.jLw) {
      localContentValues.put("data", this.field_data);
    }
    if (this.jLR) {
      localContentValues.put("dataType", this.field_dataType);
    }
    if (this.jLS) {
      localContentValues.put("size", Integer.valueOf(this.field_size));
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
  
  public StorageObserverOwner<? extends p> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return this.field_key;
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
 * Qualified Name:     com.tencent.mm.autogen.b.p
 * JD-Core Version:    0.7.0.1
 */