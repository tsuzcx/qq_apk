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

public abstract class gl
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("PredownloadBlockCgiRequest");
  public static final Column USERNAME;
  public static final Column jIK;
  public static final Column jIL;
  private static final int jIY;
  private static final int jIZ;
  private static final int jKX;
  public static final Column jKp;
  public static final Column jMP;
  private static final int jMZ;
  public static final Column kRV;
  public static final Column kRW;
  private static final int kRZ;
  private static final int kSa;
  private static final StorageObserverOwner<gl> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  private static final int username_HASHCODE;
  private boolean __hadSetusername = true;
  public String field_appId;
  public String field_cgiList;
  public long field_endTime;
  public int field_reportId;
  public String field_sceneList;
  public long field_startTime;
  public String field_username;
  private boolean jIR = true;
  private boolean jIS = true;
  private boolean jKG = true;
  private boolean jMU = true;
  private boolean kRX = true;
  private boolean kRY = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    USERNAME = new Column("username", "string", TABLE.getName(), "");
    jKp = new Column("appId", "string", TABLE.getName(), "");
    jIK = new Column("startTime", "long", TABLE.getName(), "");
    jIL = new Column("endTime", "long", TABLE.getName(), "");
    kRV = new Column("sceneList", "string", TABLE.getName(), "");
    kRW = new Column("cgiList", "string", TABLE.getName(), "");
    jMP = new Column("reportId", "int", TABLE.getName(), "");
    INDEX_CREATE = new String[] { "CREATE INDEX IF NOT EXISTS PredownloadBlockCgiRequestAppIDIndex ON PredownloadBlockCgiRequest(appId)", "CREATE INDEX IF NOT EXISTS PredownloadBlockCgiRequestStartTimeIndex ON PredownloadBlockCgiRequest(startTime)", "CREATE INDEX IF NOT EXISTS PredownloadBlockCgiRequestEndTimeIndex ON PredownloadBlockCgiRequest(endTime)" };
    username_HASHCODE = "username".hashCode();
    jKX = "appId".hashCode();
    jIY = "startTime".hashCode();
    jIZ = "endTime".hashCode();
    kRZ = "sceneList".hashCode();
    kSa = "cgiList".hashCode();
    jMZ = "reportId".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[7];
    localMAutoDBInfo.columns = new String[8];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "username";
    localMAutoDBInfo.colsMap.put("username", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" username TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "username";
    localMAutoDBInfo.columns[1] = "appId";
    localMAutoDBInfo.colsMap.put("appId", "TEXT");
    localStringBuilder.append(" appId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "startTime";
    localMAutoDBInfo.colsMap.put("startTime", "LONG");
    localStringBuilder.append(" startTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "endTime";
    localMAutoDBInfo.colsMap.put("endTime", "LONG");
    localStringBuilder.append(" endTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "sceneList";
    localMAutoDBInfo.colsMap.put("sceneList", "TEXT");
    localStringBuilder.append(" sceneList TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "cgiList";
    localMAutoDBInfo.colsMap.put("cgiList", "TEXT");
    localStringBuilder.append(" cgiList TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "reportId";
    localMAutoDBInfo.colsMap.put("reportId", "INTEGER");
    localStringBuilder.append(" reportId INTEGER");
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
    if (paramContentValues.containsKey("appId"))
    {
      this.field_appId = paramContentValues.getAsString("appId");
      if (paramBoolean) {
        this.jKG = true;
      }
    }
    if (paramContentValues.containsKey("startTime"))
    {
      this.field_startTime = paramContentValues.getAsLong("startTime").longValue();
      if (paramBoolean) {
        this.jIR = true;
      }
    }
    if (paramContentValues.containsKey("endTime"))
    {
      this.field_endTime = paramContentValues.getAsLong("endTime").longValue();
      if (paramBoolean) {
        this.jIS = true;
      }
    }
    if (paramContentValues.containsKey("sceneList"))
    {
      this.field_sceneList = paramContentValues.getAsString("sceneList");
      if (paramBoolean) {
        this.kRX = true;
      }
    }
    if (paramContentValues.containsKey("cgiList"))
    {
      this.field_cgiList = paramContentValues.getAsString("cgiList");
      if (paramBoolean) {
        this.kRY = true;
      }
    }
    if (paramContentValues.containsKey("reportId"))
    {
      this.field_reportId = paramContentValues.getAsInteger("reportId").intValue();
      if (paramBoolean) {
        this.jMU = true;
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
        break label65;
      }
      this.field_username = paramCursor.getString(i);
      this.__hadSetusername = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (jKX == k) {
        this.field_appId = paramCursor.getString(i);
      } else if (jIY == k) {
        this.field_startTime = paramCursor.getLong(i);
      } else if (jIZ == k) {
        this.field_endTime = paramCursor.getLong(i);
      } else if (kRZ == k) {
        this.field_sceneList = paramCursor.getString(i);
      } else if (kSa == k) {
        this.field_cgiList = paramCursor.getString(i);
      } else if (jMZ == k) {
        this.field_reportId = paramCursor.getInt(i);
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
    if (this.jKG) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.jIR) {
      localContentValues.put("startTime", Long.valueOf(this.field_startTime));
    }
    if (this.jIS) {
      localContentValues.put("endTime", Long.valueOf(this.field_endTime));
    }
    if (this.kRX) {
      localContentValues.put("sceneList", this.field_sceneList);
    }
    if (this.kRY) {
      localContentValues.put("cgiList", this.field_cgiList);
    }
    if (this.jMU) {
      localContentValues.put("reportId", Integer.valueOf(this.field_reportId));
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
  
  public StorageObserverOwner<? extends gl> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return this.field_username;
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
 * Qualified Name:     com.tencent.mm.autogen.b.gl
 * JD-Core Version:    0.7.0.1
 */