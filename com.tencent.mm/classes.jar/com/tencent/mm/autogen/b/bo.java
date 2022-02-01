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

public abstract class bo
  extends IAutoDBItem
{
  public static final Column CONTENT;
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("EmojiSuggestCacheInfo");
  public static final Column UPDATETIME;
  private static final int content_HASHCODE;
  private static final int kgA;
  public static final Column kgs;
  private static final StorageObserverOwner<bo> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  private static final int updateTime_HASHCODE;
  private boolean __hadSetcontent = true;
  private boolean __hadSetupdateTime = true;
  public byte[] field_content;
  public String field_desc;
  public int field_updateTime;
  private boolean kgw = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    kgs = new Column("desc", "string", TABLE.getName(), "");
    UPDATETIME = new Column("updateTime", "int", TABLE.getName(), "");
    CONTENT = new Column("content", "byte[]", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    kgA = "desc".hashCode();
    updateTime_HASHCODE = "updateTime".hashCode();
    content_HASHCODE = "content".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[3];
    localMAutoDBInfo.columns = new String[4];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "desc";
    localMAutoDBInfo.colsMap.put("desc", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" desc TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "desc";
    localMAutoDBInfo.columns[1] = "updateTime";
    localMAutoDBInfo.colsMap.put("updateTime", "INTEGER");
    localStringBuilder.append(" updateTime INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "content";
    localMAutoDBInfo.colsMap.put("content", "BLOB");
    localStringBuilder.append(" content BLOB");
    localMAutoDBInfo.columns[3] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("desc"))
    {
      this.field_desc = paramContentValues.getAsString("desc");
      if (paramBoolean) {
        this.kgw = true;
      }
    }
    if (paramContentValues.containsKey("updateTime"))
    {
      this.field_updateTime = paramContentValues.getAsInteger("updateTime").intValue();
      if (paramBoolean) {
        this.__hadSetupdateTime = true;
      }
    }
    if (paramContentValues.containsKey("content"))
    {
      this.field_content = paramContentValues.getAsByteArray("content");
      if (paramBoolean) {
        this.__hadSetcontent = true;
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
      if (kgA != k) {
        break label65;
      }
      this.field_desc = paramCursor.getString(i);
      this.kgw = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (updateTime_HASHCODE == k) {
        this.field_updateTime = paramCursor.getInt(i);
      } else if (content_HASHCODE == k) {
        this.field_content = paramCursor.getBlob(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.kgw) {
      localContentValues.put("desc", this.field_desc);
    }
    if (this.__hadSetupdateTime) {
      localContentValues.put("updateTime", Integer.valueOf(this.field_updateTime));
    }
    if (this.__hadSetcontent) {
      localContentValues.put("content", this.field_content);
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
  
  public StorageObserverOwner<? extends bo> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return this.field_desc;
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
 * Qualified Name:     com.tencent.mm.autogen.b.bo
 * JD-Core Version:    0.7.0.1
 */