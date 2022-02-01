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

public abstract class fd
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("LuckyMoneyDetailOpenRecord");
  public static final Column kJR;
  public static final Column kJS;
  private static final int kJV;
  private static final int kJW;
  private static final StorageObserverOwner<fd> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  public int field_open_count;
  public String field_send_id;
  private boolean kJT = true;
  private boolean kJU = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    kJR = new Column("send_id", "string", TABLE.getName(), "");
    kJS = new Column("open_count", "int", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    kJV = "send_id".hashCode();
    kJW = "open_count".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[2];
    localMAutoDBInfo.columns = new String[3];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "send_id";
    localMAutoDBInfo.colsMap.put("send_id", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" send_id TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "send_id";
    localMAutoDBInfo.columns[1] = "open_count";
    localMAutoDBInfo.colsMap.put("open_count", "INTEGER");
    localStringBuilder.append(" open_count INTEGER");
    localMAutoDBInfo.columns[2] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("send_id"))
    {
      this.field_send_id = paramContentValues.getAsString("send_id");
      if (paramBoolean) {
        this.kJT = true;
      }
    }
    if (paramContentValues.containsKey("open_count"))
    {
      this.field_open_count = paramContentValues.getAsInteger("open_count").intValue();
      if (paramBoolean) {
        this.kJU = true;
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
      if (kJV != k) {
        break label65;
      }
      this.field_send_id = paramCursor.getString(i);
      this.kJT = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (kJW == k) {
        this.field_open_count = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.kJT) {
      localContentValues.put("send_id", this.field_send_id);
    }
    if (this.kJU) {
      localContentValues.put("open_count", Integer.valueOf(this.field_open_count));
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
  
  public StorageObserverOwner<? extends fd> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return this.field_send_id;
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
 * Qualified Name:     com.tencent.mm.autogen.b.fd
 * JD-Core Version:    0.7.0.1
 */