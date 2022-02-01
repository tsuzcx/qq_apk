package com.tencent.mm.plugin.hashinfo.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.observer.StorageObserverOwner;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class a
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column JmU;
  public static final Column JmV;
  private static final int JmY;
  private static final int JmZ;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("HashUserNameMap");
  public static final Column USERNAME;
  private static final int kvf;
  private static final StorageObserverOwner<a> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  private boolean JmW = true;
  private boolean JmX = true;
  public String field_CommHashUserName;
  public String field_HashUserName;
  public String field_UserName;
  private boolean kuW = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    USERNAME = new Column("UserName", "string", TABLE.getName(), "");
    JmU = new Column("HashUserName", "string", TABLE.getName(), "");
    JmV = new Column("CommHashUserName", "string", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    kvf = "UserName".hashCode();
    JmY = "HashUserName".hashCode();
    JmZ = "CommHashUserName".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[3];
    localMAutoDBInfo.columns = new String[4];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "UserName";
    localMAutoDBInfo.colsMap.put("UserName", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" UserName TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "UserName";
    localMAutoDBInfo.columns[1] = "HashUserName";
    localMAutoDBInfo.colsMap.put("HashUserName", "TEXT");
    localStringBuilder.append(" HashUserName TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "CommHashUserName";
    localMAutoDBInfo.colsMap.put("CommHashUserName", "TEXT");
    localStringBuilder.append(" CommHashUserName TEXT");
    localMAutoDBInfo.columns[3] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("UserName"))
    {
      this.field_UserName = paramContentValues.getAsString("UserName");
      if (paramBoolean) {
        this.kuW = true;
      }
    }
    if (paramContentValues.containsKey("HashUserName"))
    {
      this.field_HashUserName = paramContentValues.getAsString("HashUserName");
      if (paramBoolean) {
        this.JmW = true;
      }
    }
    if (paramContentValues.containsKey("CommHashUserName"))
    {
      this.field_CommHashUserName = paramContentValues.getAsString("CommHashUserName");
      if (paramBoolean) {
        this.JmX = true;
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
      if (kvf != k) {
        break label65;
      }
      this.field_UserName = paramCursor.getString(i);
      this.kuW = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (JmY == k) {
        this.field_HashUserName = paramCursor.getString(i);
      } else if (JmZ == k) {
        this.field_CommHashUserName = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.kuW) {
      localContentValues.put("UserName", this.field_UserName);
    }
    if (this.JmW) {
      localContentValues.put("HashUserName", this.field_HashUserName);
    }
    if (this.JmX) {
      localContentValues.put("CommHashUserName", this.field_CommHashUserName);
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
  
  public StorageObserverOwner<? extends a> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return this.field_UserName;
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
 * Qualified Name:     com.tencent.mm.plugin.hashinfo.c.a
 * JD-Core Version:    0.7.0.1
 */