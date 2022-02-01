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

public abstract class k
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("AppBrandBackgroundFetchData");
  public static final Column UPDATETIME;
  public static final Column USERNAME;
  private static final int jJD;
  public static final Column jJJ;
  public static final Column jJz;
  private static final int jKh;
  public static final Column jLr;
  public static final Column jLs;
  public static final Column jLt;
  private static final int jLx;
  private static final int jLy;
  private static final int jLz;
  private static final StorageObserverOwner<k> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  private static final int updateTime_HASHCODE;
  private static final int username_HASHCODE;
  private boolean __hadSetupdateTime = true;
  private boolean __hadSetusername = true;
  public String field_data;
  public int field_fetchType;
  public String field_path;
  public String field_query;
  public int field_scene;
  public long field_updateTime;
  public String field_username;
  private boolean jJB = true;
  private boolean jJV = true;
  private boolean jLu = true;
  private boolean jLv = true;
  private boolean jLw = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    USERNAME = new Column("username", "string", TABLE.getName(), "");
    jLr = new Column("fetchType", "int", TABLE.getName(), "");
    UPDATETIME = new Column("updateTime", "long", TABLE.getName(), "");
    jJJ = new Column("path", "string", TABLE.getName(), "");
    jLs = new Column("query", "string", TABLE.getName(), "");
    jJz = new Column("scene", "int", TABLE.getName(), "");
    jLt = new Column("data", "string", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    username_HASHCODE = "username".hashCode();
    jLx = "fetchType".hashCode();
    updateTime_HASHCODE = "updateTime".hashCode();
    jKh = "path".hashCode();
    jLy = "query".hashCode();
    jJD = "scene".hashCode();
    jLz = "data".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[7];
    localMAutoDBInfo.columns = new String[8];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "username";
    localMAutoDBInfo.colsMap.put("username", "TEXT");
    localStringBuilder.append(" username TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[1] = "fetchType";
    localMAutoDBInfo.colsMap.put("fetchType", "INTEGER");
    localStringBuilder.append(" fetchType INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "updateTime";
    localMAutoDBInfo.colsMap.put("updateTime", "LONG");
    localStringBuilder.append(" updateTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "path";
    localMAutoDBInfo.colsMap.put("path", "TEXT");
    localStringBuilder.append(" path TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "query";
    localMAutoDBInfo.colsMap.put("query", "TEXT");
    localStringBuilder.append(" query TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "scene";
    localMAutoDBInfo.colsMap.put("scene", "INTEGER");
    localStringBuilder.append(" scene INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "data";
    localMAutoDBInfo.colsMap.put("data", "TEXT");
    localStringBuilder.append(" data TEXT");
    localMAutoDBInfo.columns[7] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("username"))
    {
      this.field_username = paramContentValues.getAsString("username");
      if (paramBoolean) {
        this.__hadSetusername = true;
      }
    }
    if (paramContentValues.containsKey("fetchType"))
    {
      this.field_fetchType = paramContentValues.getAsInteger("fetchType").intValue();
      if (paramBoolean) {
        this.jLu = true;
      }
    }
    if (paramContentValues.containsKey("updateTime"))
    {
      this.field_updateTime = paramContentValues.getAsLong("updateTime").longValue();
      if (paramBoolean) {
        this.__hadSetupdateTime = true;
      }
    }
    if (paramContentValues.containsKey("path"))
    {
      this.field_path = paramContentValues.getAsString("path");
      if (paramBoolean) {
        this.jJV = true;
      }
    }
    if (paramContentValues.containsKey("query"))
    {
      this.field_query = paramContentValues.getAsString("query");
      if (paramBoolean) {
        this.jLv = true;
      }
    }
    if (paramContentValues.containsKey("scene"))
    {
      this.field_scene = paramContentValues.getAsInteger("scene").intValue();
      if (paramBoolean) {
        this.jJB = true;
      }
    }
    if (paramContentValues.containsKey("data"))
    {
      this.field_data = paramContentValues.getAsString("data");
      if (paramBoolean) {
        this.jLw = true;
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
      if (username_HASHCODE != k) {
        break label60;
      }
      this.field_username = paramCursor.getString(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (jLx == k) {
        this.field_fetchType = paramCursor.getInt(i);
      } else if (updateTime_HASHCODE == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (jKh == k) {
        this.field_path = paramCursor.getString(i);
      } else if (jLy == k) {
        this.field_query = paramCursor.getString(i);
      } else if (jJD == k) {
        this.field_scene = paramCursor.getInt(i);
      } else if (jLz == k) {
        this.field_data = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.__hadSetusername) {
      localContentValues.put("username", this.field_username);
    }
    if (this.jLu) {
      localContentValues.put("fetchType", Integer.valueOf(this.field_fetchType));
    }
    if (this.__hadSetupdateTime) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.jJV) {
      localContentValues.put("path", this.field_path);
    }
    if (this.jLv) {
      localContentValues.put("query", this.field_query);
    }
    if (this.jJB) {
      localContentValues.put("scene", Integer.valueOf(this.field_scene));
    }
    if (this.jLw) {
      localContentValues.put("data", this.field_data);
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
  
  public StorageObserverOwner<? extends k> getObserverOwner()
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
 * Qualified Name:     com.tencent.mm.autogen.b.k
 * JD-Core Version:    0.7.0.1
 */