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

public abstract class if
  extends IAutoDBItem
{
  public static final Column CONTENT;
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("VoiceTransText");
  private static final int content_HASHCODE;
  public static final Column jIo;
  private static final int jIw;
  public static final Column leX;
  private static final int leZ;
  private static final StorageObserverOwner<if> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  private boolean __hadSetcontent = true;
  public String field_cmsgId;
  public String field_content;
  public long field_msgId;
  private boolean jIs = true;
  private boolean leY = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    jIo = new Column("msgId", "long", TABLE.getName(), "");
    leX = new Column("cmsgId", "string", TABLE.getName(), "");
    CONTENT = new Column("content", "string", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    jIw = "msgId".hashCode();
    leZ = "cmsgId".hashCode();
    content_HASHCODE = "content".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[3];
    localMAutoDBInfo.columns = new String[4];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "msgId";
    localMAutoDBInfo.colsMap.put("msgId", "LONG PRIMARY KEY ");
    localStringBuilder.append(" msgId LONG PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "msgId";
    localMAutoDBInfo.columns[1] = "cmsgId";
    localMAutoDBInfo.colsMap.put("cmsgId", "TEXT");
    localStringBuilder.append(" cmsgId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "content";
    localMAutoDBInfo.colsMap.put("content", "TEXT default '' ");
    localStringBuilder.append(" content TEXT default '' ");
    localMAutoDBInfo.columns[3] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("msgId"))
    {
      this.field_msgId = paramContentValues.getAsLong("msgId").longValue();
      if (paramBoolean) {
        this.jIs = true;
      }
    }
    if (paramContentValues.containsKey("cmsgId"))
    {
      this.field_cmsgId = paramContentValues.getAsString("cmsgId");
      if (paramBoolean) {
        this.leY = true;
      }
    }
    if (paramContentValues.containsKey("content"))
    {
      this.field_content = paramContentValues.getAsString("content");
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
      if (jIw != k) {
        break label65;
      }
      this.field_msgId = paramCursor.getLong(i);
      this.jIs = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (leZ == k) {
        this.field_cmsgId = paramCursor.getString(i);
      } else if (content_HASHCODE == k) {
        this.field_content = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.jIs) {
      localContentValues.put("msgId", Long.valueOf(this.field_msgId));
    }
    if (this.leY) {
      localContentValues.put("cmsgId", this.field_cmsgId);
    }
    if (this.field_content == null) {
      this.field_content = "";
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
  
  public StorageObserverOwner<? extends if> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return Long.valueOf(this.field_msgId);
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
 * Qualified Name:     com.tencent.mm.autogen.b.if
 * JD-Core Version:    0.7.0.1
 */