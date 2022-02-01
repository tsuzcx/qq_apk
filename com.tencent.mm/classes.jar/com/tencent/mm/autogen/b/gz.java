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

public abstract class gz
  extends IAutoDBItem
{
  public static final Column CREATETIME;
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final Column ID;
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("SecReportDataInfo");
  public static final Column TYPE;
  public static final Column UPDATETIME;
  private static final int createTime_HASHCODE;
  private static final int id_HASHCODE;
  public static final Column jLt;
  private static final int jLz;
  private static final int kWA;
  private static final int kWB;
  public static final Column kWw;
  public static final Column kWx;
  private static final int kyM;
  public static final Column kyq;
  private static final StorageObserverOwner<gz> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  private static final int type_HASHCODE;
  private static final int updateTime_HASHCODE;
  private boolean __hadSetcreateTime = true;
  private boolean __hadSetid = true;
  private boolean __hadSettype = true;
  private boolean __hadSetupdateTime = true;
  public long field_createTime;
  public byte[] field_data;
  public long field_expireTime;
  public String field_id;
  public String field_indexData;
  public String field_originId;
  public int field_type;
  public long field_updateTime;
  private boolean jLw = true;
  private boolean kWy = true;
  private boolean kWz = true;
  private boolean kyB = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    ID = new Column("id", "string", TABLE.getName(), "");
    kWw = new Column("originId", "string", TABLE.getName(), "");
    CREATETIME = new Column("createTime", "long", TABLE.getName(), "");
    UPDATETIME = new Column("updateTime", "long", TABLE.getName(), "");
    kyq = new Column("expireTime", "long", TABLE.getName(), "");
    TYPE = new Column("type", "int", TABLE.getName(), "");
    jLt = new Column("data", "byte[]", TABLE.getName(), "");
    kWx = new Column("indexData", "string", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    id_HASHCODE = "id".hashCode();
    kWA = "originId".hashCode();
    createTime_HASHCODE = "createTime".hashCode();
    updateTime_HASHCODE = "updateTime".hashCode();
    kyM = "expireTime".hashCode();
    type_HASHCODE = "type".hashCode();
    jLz = "data".hashCode();
    kWB = "indexData".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[8];
    localMAutoDBInfo.columns = new String[9];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "id";
    localMAutoDBInfo.colsMap.put("id", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" id TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "id";
    localMAutoDBInfo.columns[1] = "originId";
    localMAutoDBInfo.colsMap.put("originId", "TEXT default '' ");
    localStringBuilder.append(" originId TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "createTime";
    localMAutoDBInfo.colsMap.put("createTime", "LONG default '0' ");
    localStringBuilder.append(" createTime LONG default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "updateTime";
    localMAutoDBInfo.colsMap.put("updateTime", "LONG default '0' ");
    localStringBuilder.append(" updateTime LONG default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "expireTime";
    localMAutoDBInfo.colsMap.put("expireTime", "LONG default '0' ");
    localStringBuilder.append(" expireTime LONG default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "type";
    localMAutoDBInfo.colsMap.put("type", "INTEGER default '0' ");
    localStringBuilder.append(" type INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "data";
    localMAutoDBInfo.colsMap.put("data", "BLOB");
    localStringBuilder.append(" data BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "indexData";
    localMAutoDBInfo.colsMap.put("indexData", "TEXT default '' ");
    localStringBuilder.append(" indexData TEXT default '' ");
    localMAutoDBInfo.columns[8] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("id"))
    {
      this.field_id = paramContentValues.getAsString("id");
      if (paramBoolean) {
        this.__hadSetid = true;
      }
    }
    if (paramContentValues.containsKey("originId"))
    {
      this.field_originId = paramContentValues.getAsString("originId");
      if (paramBoolean) {
        this.kWy = true;
      }
    }
    if (paramContentValues.containsKey("createTime"))
    {
      this.field_createTime = paramContentValues.getAsLong("createTime").longValue();
      if (paramBoolean) {
        this.__hadSetcreateTime = true;
      }
    }
    if (paramContentValues.containsKey("updateTime"))
    {
      this.field_updateTime = paramContentValues.getAsLong("updateTime").longValue();
      if (paramBoolean) {
        this.__hadSetupdateTime = true;
      }
    }
    if (paramContentValues.containsKey("expireTime"))
    {
      this.field_expireTime = paramContentValues.getAsLong("expireTime").longValue();
      if (paramBoolean) {
        this.kyB = true;
      }
    }
    if (paramContentValues.containsKey("type"))
    {
      this.field_type = paramContentValues.getAsInteger("type").intValue();
      if (paramBoolean) {
        this.__hadSettype = true;
      }
    }
    if (paramContentValues.containsKey("data"))
    {
      this.field_data = paramContentValues.getAsByteArray("data");
      if (paramBoolean) {
        this.jLw = true;
      }
    }
    if (paramContentValues.containsKey("indexData"))
    {
      this.field_indexData = paramContentValues.getAsString("indexData");
      if (paramBoolean) {
        this.kWz = true;
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
      if (id_HASHCODE != k) {
        break label65;
      }
      this.field_id = paramCursor.getString(i);
      this.__hadSetid = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (kWA == k) {
        this.field_originId = paramCursor.getString(i);
      } else if (createTime_HASHCODE == k) {
        this.field_createTime = paramCursor.getLong(i);
      } else if (updateTime_HASHCODE == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (kyM == k) {
        this.field_expireTime = paramCursor.getLong(i);
      } else if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (jLz == k) {
        this.field_data = paramCursor.getBlob(i);
      } else if (kWB == k) {
        this.field_indexData = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.__hadSetid) {
      localContentValues.put("id", this.field_id);
    }
    if (this.field_originId == null) {
      this.field_originId = "";
    }
    if (this.kWy) {
      localContentValues.put("originId", this.field_originId);
    }
    if (this.__hadSetcreateTime) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.__hadSetupdateTime) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.kyB) {
      localContentValues.put("expireTime", Long.valueOf(this.field_expireTime));
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.jLw) {
      localContentValues.put("data", this.field_data);
    }
    if (this.field_indexData == null) {
      this.field_indexData = "";
    }
    if (this.kWz) {
      localContentValues.put("indexData", this.field_indexData);
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
  
  public StorageObserverOwner<? extends gz> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return this.field_id;
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
 * Qualified Name:     com.tencent.mm.autogen.b.gz
 * JD-Core Version:    0.7.0.1
 */