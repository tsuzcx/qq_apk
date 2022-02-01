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

public abstract class aj
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("BizChatMyUserInfo");
  public static final Column jPG;
  private static final int jQk;
  public static final Column jRl;
  private static final int jRn;
  private static final StorageObserverOwner<aj> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  public String field_brandUserName;
  public String field_userId;
  private boolean jPV = true;
  private boolean jRm = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    jPG = new Column("brandUserName", "string", TABLE.getName(), "");
    jRl = new Column("userId", "string", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    jQk = "brandUserName".hashCode();
    jRn = "userId".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[2];
    localMAutoDBInfo.columns = new String[3];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "brandUserName";
    localMAutoDBInfo.colsMap.put("brandUserName", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" brandUserName TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "brandUserName";
    localMAutoDBInfo.columns[1] = "userId";
    localMAutoDBInfo.colsMap.put("userId", "TEXT");
    localStringBuilder.append(" userId TEXT");
    localMAutoDBInfo.columns[2] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("brandUserName"))
    {
      this.field_brandUserName = paramContentValues.getAsString("brandUserName");
      if (paramBoolean) {
        this.jPV = true;
      }
    }
    if (paramContentValues.containsKey("userId"))
    {
      this.field_userId = paramContentValues.getAsString("userId");
      if (paramBoolean) {
        this.jRm = true;
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
      if (jQk != k) {
        break label65;
      }
      this.field_brandUserName = paramCursor.getString(i);
      this.jPV = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (jRn == k) {
        this.field_userId = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.jPV) {
      localContentValues.put("brandUserName", this.field_brandUserName);
    }
    if (this.jRm) {
      localContentValues.put("userId", this.field_userId);
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
  
  public StorageObserverOwner<? extends aj> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return this.field_brandUserName;
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
 * Qualified Name:     com.tencent.mm.autogen.b.aj
 * JD-Core Version:    0.7.0.1
 */