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

public abstract class co
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("FinderLiveActionRecord");
  private static final int kmM;
  public static final Column kms;
  public static final Column krk;
  private static final int krm;
  private static final StorageObserverOwner<co> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  public String field_actionTag;
  public long field_actionTime;
  private boolean kmC = true;
  private boolean krl = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    krk = new Column("actionTag", "string", TABLE.getName(), "");
    kms = new Column("actionTime", "long", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    krm = "actionTag".hashCode();
    kmM = "actionTime".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[2];
    localMAutoDBInfo.columns = new String[3];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "actionTag";
    localMAutoDBInfo.colsMap.put("actionTag", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" actionTag TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "actionTag";
    localMAutoDBInfo.columns[1] = "actionTime";
    localMAutoDBInfo.colsMap.put("actionTime", "LONG");
    localStringBuilder.append(" actionTime LONG");
    localMAutoDBInfo.columns[2] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("actionTag"))
    {
      this.field_actionTag = paramContentValues.getAsString("actionTag");
      if (paramBoolean) {
        this.krl = true;
      }
    }
    if (paramContentValues.containsKey("actionTime"))
    {
      this.field_actionTime = paramContentValues.getAsLong("actionTime").longValue();
      if (paramBoolean) {
        this.kmC = true;
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
      if (krm != k) {
        break label65;
      }
      this.field_actionTag = paramCursor.getString(i);
      this.krl = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (kmM == k) {
        this.field_actionTime = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.krl) {
      localContentValues.put("actionTag", this.field_actionTag);
    }
    if (this.kmC) {
      localContentValues.put("actionTime", Long.valueOf(this.field_actionTime));
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
  
  public StorageObserverOwner<? extends co> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return this.field_actionTag;
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
 * Qualified Name:     com.tencent.mm.autogen.b.co
 * JD-Core Version:    0.7.0.1
 */