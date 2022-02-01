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

public abstract class ay
  extends IAutoDBItem
{
  public static final Column CREATETIME;
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final Column ID;
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("CleanDeleteItem");
  private static final int createTime_HASHCODE;
  private static final int id_HASHCODE;
  public static final Column jLQ;
  private static final int jLU;
  private static final int jNY;
  public static final Column jNg;
  public static final Column jYK;
  public static final Column jYL;
  public static final Column jYM;
  private static final int jYQ;
  private static final int jYR;
  private static final int jYS;
  private static final StorageObserverOwner<ay> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  private boolean __hadSetcreateTime = true;
  private boolean __hadSetid = true;
  public long field_createTime;
  public long field_deleteTime;
  public long field_flags;
  public String field_id;
  public long field_modifyTime;
  public long field_saveTime;
  public long field_size;
  private boolean jLS = true;
  private boolean jNC = true;
  private boolean jYN = true;
  private boolean jYO = true;
  private boolean jYP = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    CREATETIME = new Column("createTime", "long", TABLE.getName(), "");
    jNg = new Column("modifyTime", "long", TABLE.getName(), "");
    jYK = new Column("deleteTime", "long", TABLE.getName(), "");
    ID = new Column("id", "string", TABLE.getName(), "");
    jYL = new Column("saveTime", "long", TABLE.getName(), "");
    jLQ = new Column("size", "long", TABLE.getName(), "");
    jYM = new Column("flags", "long", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    createTime_HASHCODE = "createTime".hashCode();
    jNY = "modifyTime".hashCode();
    jYQ = "deleteTime".hashCode();
    id_HASHCODE = "id".hashCode();
    jYR = "saveTime".hashCode();
    jLU = "size".hashCode();
    jYS = "flags".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[7];
    localMAutoDBInfo.columns = new String[8];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "createTime";
    localMAutoDBInfo.colsMap.put("createTime", "LONG default '0' ");
    localStringBuilder.append(" createTime LONG default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[1] = "modifyTime";
    localMAutoDBInfo.colsMap.put("modifyTime", "LONG default '0' ");
    localStringBuilder.append(" modifyTime LONG default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "deleteTime";
    localMAutoDBInfo.colsMap.put("deleteTime", "LONG default '0' ");
    localStringBuilder.append(" deleteTime LONG default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "id";
    localMAutoDBInfo.colsMap.put("id", "TEXT default '' ");
    localStringBuilder.append(" id TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "saveTime";
    localMAutoDBInfo.colsMap.put("saveTime", "LONG default '0' ");
    localStringBuilder.append(" saveTime LONG default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "size";
    localMAutoDBInfo.colsMap.put("size", "LONG default '0' ");
    localStringBuilder.append(" size LONG default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "flags";
    localMAutoDBInfo.colsMap.put("flags", "LONG default '0' ");
    localStringBuilder.append(" flags LONG default '0' ");
    localMAutoDBInfo.columns[7] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("createTime"))
    {
      this.field_createTime = paramContentValues.getAsLong("createTime").longValue();
      if (paramBoolean) {
        this.__hadSetcreateTime = true;
      }
    }
    if (paramContentValues.containsKey("modifyTime"))
    {
      this.field_modifyTime = paramContentValues.getAsLong("modifyTime").longValue();
      if (paramBoolean) {
        this.jNC = true;
      }
    }
    if (paramContentValues.containsKey("deleteTime"))
    {
      this.field_deleteTime = paramContentValues.getAsLong("deleteTime").longValue();
      if (paramBoolean) {
        this.jYN = true;
      }
    }
    if (paramContentValues.containsKey("id"))
    {
      this.field_id = paramContentValues.getAsString("id");
      if (paramBoolean) {
        this.__hadSetid = true;
      }
    }
    if (paramContentValues.containsKey("saveTime"))
    {
      this.field_saveTime = paramContentValues.getAsLong("saveTime").longValue();
      if (paramBoolean) {
        this.jYO = true;
      }
    }
    if (paramContentValues.containsKey("size"))
    {
      this.field_size = paramContentValues.getAsLong("size").longValue();
      if (paramBoolean) {
        this.jLS = true;
      }
    }
    if (paramContentValues.containsKey("flags"))
    {
      this.field_flags = paramContentValues.getAsLong("flags").longValue();
      if (paramBoolean) {
        this.jYP = true;
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
      if (createTime_HASHCODE != k) {
        break label60;
      }
      this.field_createTime = paramCursor.getLong(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (jNY == k) {
        this.field_modifyTime = paramCursor.getLong(i);
      } else if (jYQ == k) {
        this.field_deleteTime = paramCursor.getLong(i);
      } else if (id_HASHCODE == k) {
        this.field_id = paramCursor.getString(i);
      } else if (jYR == k) {
        this.field_saveTime = paramCursor.getLong(i);
      } else if (jLU == k) {
        this.field_size = paramCursor.getLong(i);
      } else if (jYS == k) {
        this.field_flags = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.__hadSetcreateTime) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.jNC) {
      localContentValues.put("modifyTime", Long.valueOf(this.field_modifyTime));
    }
    if (this.jYN) {
      localContentValues.put("deleteTime", Long.valueOf(this.field_deleteTime));
    }
    if (this.field_id == null) {
      this.field_id = "";
    }
    if (this.__hadSetid) {
      localContentValues.put("id", this.field_id);
    }
    if (this.jYO) {
      localContentValues.put("saveTime", Long.valueOf(this.field_saveTime));
    }
    if (this.jLS) {
      localContentValues.put("size", Long.valueOf(this.field_size));
    }
    if (this.jYP) {
      localContentValues.put("flags", Long.valueOf(this.field_flags));
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
  
  public StorageObserverOwner<? extends ay> getObserverOwner()
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
 * Qualified Name:     com.tencent.mm.autogen.b.ay
 * JD-Core Version:    0.7.0.1
 */