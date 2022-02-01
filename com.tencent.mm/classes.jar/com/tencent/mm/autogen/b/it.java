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

public abstract class it
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column KEY;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("WebviewLocalData");
  public static final Column VALUE;
  private static final int jKX;
  public static final Column jKp;
  public static final Column jLV;
  private static final int jMd;
  private static final int key_HASHCODE;
  public static final Column llT;
  private static final int llV;
  private static final StorageObserverOwner<it> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  private static final int value_HASHCODE;
  private boolean __hadSetkey = true;
  private boolean __hadSetvalue = true;
  public String field_appId;
  public String field_domin;
  public String field_key;
  public int field_recordId;
  public String field_value;
  private boolean jKG = true;
  private boolean jLZ = true;
  private boolean llU = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    jLV = new Column("recordId", "int", TABLE.getName(), "");
    jKp = new Column("appId", "string", TABLE.getName(), "");
    llT = new Column("domin", "string", TABLE.getName(), "");
    KEY = new Column("key", "string", TABLE.getName(), "");
    VALUE = new Column("value", "string", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    jMd = "recordId".hashCode();
    jKX = "appId".hashCode();
    llV = "domin".hashCode();
    key_HASHCODE = "key".hashCode();
    value_HASHCODE = "value".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[5];
    localMAutoDBInfo.columns = new String[6];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "recordId";
    localMAutoDBInfo.colsMap.put("recordId", "INTEGER PRIMARY KEY ");
    localStringBuilder.append(" recordId INTEGER PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "recordId";
    localMAutoDBInfo.columns[1] = "appId";
    localMAutoDBInfo.colsMap.put("appId", "TEXT");
    localStringBuilder.append(" appId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "domin";
    localMAutoDBInfo.colsMap.put("domin", "TEXT");
    localStringBuilder.append(" domin TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "key";
    localMAutoDBInfo.colsMap.put("key", "TEXT");
    localStringBuilder.append(" key TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "value";
    localMAutoDBInfo.colsMap.put("value", "TEXT");
    localStringBuilder.append(" value TEXT");
    localMAutoDBInfo.columns[5] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("recordId"))
    {
      this.field_recordId = paramContentValues.getAsInteger("recordId").intValue();
      if (paramBoolean) {
        this.jLZ = true;
      }
    }
    if (paramContentValues.containsKey("appId"))
    {
      this.field_appId = paramContentValues.getAsString("appId");
      if (paramBoolean) {
        this.jKG = true;
      }
    }
    if (paramContentValues.containsKey("domin"))
    {
      this.field_domin = paramContentValues.getAsString("domin");
      if (paramBoolean) {
        this.llU = true;
      }
    }
    if (paramContentValues.containsKey("key"))
    {
      this.field_key = paramContentValues.getAsString("key");
      if (paramBoolean) {
        this.__hadSetkey = true;
      }
    }
    if (paramContentValues.containsKey("value"))
    {
      this.field_value = paramContentValues.getAsString("value");
      if (paramBoolean) {
        this.__hadSetvalue = true;
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
      if (jMd != k) {
        break label65;
      }
      this.field_recordId = paramCursor.getInt(i);
      this.jLZ = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (jKX == k) {
        this.field_appId = paramCursor.getString(i);
      } else if (llV == k) {
        this.field_domin = paramCursor.getString(i);
      } else if (key_HASHCODE == k) {
        this.field_key = paramCursor.getString(i);
      } else if (value_HASHCODE == k) {
        this.field_value = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.jLZ) {
      localContentValues.put("recordId", Integer.valueOf(this.field_recordId));
    }
    if (this.jKG) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.llU) {
      localContentValues.put("domin", this.field_domin);
    }
    if (this.__hadSetkey) {
      localContentValues.put("key", this.field_key);
    }
    if (this.__hadSetvalue) {
      localContentValues.put("value", this.field_value);
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
  
  public StorageObserverOwner<? extends it> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return Integer.valueOf(this.field_recordId);
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
 * Qualified Name:     com.tencent.mm.autogen.b.it
 * JD-Core Version:    0.7.0.1
 */