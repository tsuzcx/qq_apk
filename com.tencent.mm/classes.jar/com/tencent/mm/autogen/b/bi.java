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

public abstract class bi
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final Column ID;
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("DynamicMsgCacheData");
  public static final Column UPDATETIME;
  private static final int id_HASHCODE;
  private static final int jKX;
  public static final Column jKp;
  public static final Column jLt;
  private static final int jLz;
  public static final Column kcg;
  public static final Column kch;
  private static final int kck;
  private static final int kcl;
  private static final StorageObserverOwner<bi> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  private static final int updateTime_HASHCODE;
  private boolean __hadSetid = true;
  private boolean __hadSetupdateTime = true;
  public String field_appId;
  public String field_cacheKey;
  public String field_data;
  public String field_id;
  public int field_interval;
  public long field_updateTime;
  private boolean jKG = true;
  private boolean jLw = true;
  private boolean kci = true;
  private boolean kcj = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    ID = new Column("id", "string", TABLE.getName(), "");
    kcg = new Column("cacheKey", "string", TABLE.getName(), "");
    jKp = new Column("appId", "string", TABLE.getName(), "");
    jLt = new Column("data", "string", TABLE.getName(), "");
    kch = new Column("interval", "int", TABLE.getName(), "");
    UPDATETIME = new Column("updateTime", "long", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    id_HASHCODE = "id".hashCode();
    kck = "cacheKey".hashCode();
    jKX = "appId".hashCode();
    jLz = "data".hashCode();
    kcl = "interval".hashCode();
    updateTime_HASHCODE = "updateTime".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[6];
    localMAutoDBInfo.columns = new String[7];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "id";
    localMAutoDBInfo.colsMap.put("id", "TEXT");
    localStringBuilder.append(" id TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[1] = "cacheKey";
    localMAutoDBInfo.colsMap.put("cacheKey", "TEXT");
    localStringBuilder.append(" cacheKey TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "appId";
    localMAutoDBInfo.colsMap.put("appId", "TEXT");
    localStringBuilder.append(" appId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "data";
    localMAutoDBInfo.colsMap.put("data", "TEXT");
    localStringBuilder.append(" data TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "interval";
    localMAutoDBInfo.colsMap.put("interval", "INTEGER");
    localStringBuilder.append(" interval INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "updateTime";
    localMAutoDBInfo.colsMap.put("updateTime", "LONG");
    localStringBuilder.append(" updateTime LONG");
    localMAutoDBInfo.columns[6] = "rowid";
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
    if (paramContentValues.containsKey("cacheKey"))
    {
      this.field_cacheKey = paramContentValues.getAsString("cacheKey");
      if (paramBoolean) {
        this.kci = true;
      }
    }
    if (paramContentValues.containsKey("appId"))
    {
      this.field_appId = paramContentValues.getAsString("appId");
      if (paramBoolean) {
        this.jKG = true;
      }
    }
    if (paramContentValues.containsKey("data"))
    {
      this.field_data = paramContentValues.getAsString("data");
      if (paramBoolean) {
        this.jLw = true;
      }
    }
    if (paramContentValues.containsKey("interval"))
    {
      this.field_interval = paramContentValues.getAsInteger("interval").intValue();
      if (paramBoolean) {
        this.kcj = true;
      }
    }
    if (paramContentValues.containsKey("updateTime"))
    {
      this.field_updateTime = paramContentValues.getAsLong("updateTime").longValue();
      if (paramBoolean) {
        this.__hadSetupdateTime = true;
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
        break label60;
      }
      this.field_id = paramCursor.getString(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (kck == k) {
        this.field_cacheKey = paramCursor.getString(i);
      } else if (jKX == k) {
        this.field_appId = paramCursor.getString(i);
      } else if (jLz == k) {
        this.field_data = paramCursor.getString(i);
      } else if (kcl == k) {
        this.field_interval = paramCursor.getInt(i);
      } else if (updateTime_HASHCODE == k) {
        this.field_updateTime = paramCursor.getLong(i);
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
    if (this.kci) {
      localContentValues.put("cacheKey", this.field_cacheKey);
    }
    if (this.jKG) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.jLw) {
      localContentValues.put("data", this.field_data);
    }
    if (this.kcj) {
      localContentValues.put("interval", Integer.valueOf(this.field_interval));
    }
    if (this.__hadSetupdateTime) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
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
  
  public StorageObserverOwner<? extends bi> getObserverOwner()
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
 * Qualified Name:     com.tencent.mm.autogen.b.bi
 * JD-Core Version:    0.7.0.1
 */