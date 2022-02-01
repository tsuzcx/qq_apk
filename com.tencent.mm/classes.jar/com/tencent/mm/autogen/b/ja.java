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

public abstract class ja
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("WxFileIndex2");
  public static final Column USERNAME;
  public static final Column jIo;
  private static final int jIw;
  public static final Column jJJ;
  private static final int jKh;
  public static final Column jLQ;
  private static final int jLU;
  public static final Column jPR;
  private static final int jQv;
  public static final Column loa;
  public static final Column lob;
  private static final int lof;
  private static final int loh;
  private static final StorageObserverOwner<ja> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  private static final int username_HASHCODE;
  private boolean __hadSetusername = true;
  public long field_msgId;
  public int field_msgSubType;
  public int field_msgType;
  public long field_msgtime;
  public String field_path;
  public long field_size;
  public String field_username;
  private boolean jIs = true;
  private boolean jJV = true;
  private boolean jLS = true;
  private boolean jQg = true;
  private boolean lod = true;
  private boolean loe = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    jIo = new Column("msgId", "long", TABLE.getName(), "");
    USERNAME = new Column("username", "string", TABLE.getName(), "");
    jPR = new Column("msgType", "int", TABLE.getName(), "");
    loa = new Column("msgSubType", "int", TABLE.getName(), "");
    jJJ = new Column("path", "string", TABLE.getName(), "");
    jLQ = new Column("size", "long", TABLE.getName(), "");
    lob = new Column("msgtime", "long", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    jIw = "msgId".hashCode();
    username_HASHCODE = "username".hashCode();
    jQv = "msgType".hashCode();
    lof = "msgSubType".hashCode();
    jKh = "path".hashCode();
    jLU = "size".hashCode();
    loh = "msgtime".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[7];
    localMAutoDBInfo.columns = new String[8];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "msgId";
    localMAutoDBInfo.colsMap.put("msgId", "LONG");
    localStringBuilder.append(" msgId LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[1] = "username";
    localMAutoDBInfo.colsMap.put("username", "TEXT");
    localStringBuilder.append(" username TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "msgType";
    localMAutoDBInfo.colsMap.put("msgType", "INTEGER");
    localStringBuilder.append(" msgType INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "msgSubType";
    localMAutoDBInfo.colsMap.put("msgSubType", "INTEGER");
    localStringBuilder.append(" msgSubType INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "path";
    localMAutoDBInfo.colsMap.put("path", "TEXT");
    localStringBuilder.append(" path TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "size";
    localMAutoDBInfo.colsMap.put("size", "LONG");
    localStringBuilder.append(" size LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "msgtime";
    localMAutoDBInfo.colsMap.put("msgtime", "LONG");
    localStringBuilder.append(" msgtime LONG");
    localMAutoDBInfo.columns[7] = "rowid";
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
    if (paramContentValues.containsKey("username"))
    {
      this.field_username = paramContentValues.getAsString("username");
      if (paramBoolean) {
        this.__hadSetusername = true;
      }
    }
    if (paramContentValues.containsKey("msgType"))
    {
      this.field_msgType = paramContentValues.getAsInteger("msgType").intValue();
      if (paramBoolean) {
        this.jQg = true;
      }
    }
    if (paramContentValues.containsKey("msgSubType"))
    {
      this.field_msgSubType = paramContentValues.getAsInteger("msgSubType").intValue();
      if (paramBoolean) {
        this.lod = true;
      }
    }
    if (paramContentValues.containsKey("path"))
    {
      this.field_path = paramContentValues.getAsString("path");
      if (paramBoolean) {
        this.jJV = true;
      }
    }
    if (paramContentValues.containsKey("size"))
    {
      this.field_size = paramContentValues.getAsLong("size").longValue();
      if (paramBoolean) {
        this.jLS = true;
      }
    }
    if (paramContentValues.containsKey("msgtime"))
    {
      this.field_msgtime = paramContentValues.getAsLong("msgtime").longValue();
      if (paramBoolean) {
        this.loe = true;
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
        break label60;
      }
      this.field_msgId = paramCursor.getLong(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (username_HASHCODE == k) {
        this.field_username = paramCursor.getString(i);
      } else if (jQv == k) {
        this.field_msgType = paramCursor.getInt(i);
      } else if (lof == k) {
        this.field_msgSubType = paramCursor.getInt(i);
      } else if (jKh == k) {
        this.field_path = paramCursor.getString(i);
      } else if (jLU == k) {
        this.field_size = paramCursor.getLong(i);
      } else if (loh == k) {
        this.field_msgtime = paramCursor.getLong(i);
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
    if (this.__hadSetusername) {
      localContentValues.put("username", this.field_username);
    }
    if (this.jQg) {
      localContentValues.put("msgType", Integer.valueOf(this.field_msgType));
    }
    if (this.lod) {
      localContentValues.put("msgSubType", Integer.valueOf(this.field_msgSubType));
    }
    if (this.jJV) {
      localContentValues.put("path", this.field_path);
    }
    if (this.jLS) {
      localContentValues.put("size", Long.valueOf(this.field_size));
    }
    if (this.loe) {
      localContentValues.put("msgtime", Long.valueOf(this.field_msgtime));
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
  
  public StorageObserverOwner<? extends ja> getObserverOwner()
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
 * Qualified Name:     com.tencent.mm.autogen.b.ja
 * JD-Core Version:    0.7.0.1
 */