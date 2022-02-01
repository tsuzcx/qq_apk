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

public abstract class ga
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("OpenMsgListener");
  private static final int jIF;
  public static final Column jIz;
  private static final int jKX;
  public static final Column jKp;
  private static final int jNX;
  public static final Column jNf;
  public static final Column kRf;
  public static final Column kRg;
  public static final Column kRh;
  private static final int kRl;
  private static final int kRm;
  private static final int kRn;
  private static final StorageObserverOwner<ga> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  public String field_appId;
  public int field_msgState;
  public int field_msgTypeFlag;
  public String field_packageName;
  public int field_sceneFlag;
  public int field_status;
  private boolean jIC = true;
  private boolean jKG = true;
  private boolean jNB = true;
  private boolean kRi = true;
  private boolean kRj = true;
  private boolean kRk = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    jKp = new Column("appId", "string", TABLE.getName(), "");
    jNf = new Column("packageName", "string", TABLE.getName(), "");
    jIz = new Column("status", "int", TABLE.getName(), "");
    kRf = new Column("sceneFlag", "int", TABLE.getName(), "");
    kRg = new Column("msgTypeFlag", "int", TABLE.getName(), "");
    kRh = new Column("msgState", "int", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    jKX = "appId".hashCode();
    jNX = "packageName".hashCode();
    jIF = "status".hashCode();
    kRl = "sceneFlag".hashCode();
    kRm = "msgTypeFlag".hashCode();
    kRn = "msgState".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[6];
    localMAutoDBInfo.columns = new String[7];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "appId";
    localMAutoDBInfo.colsMap.put("appId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" appId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "appId";
    localMAutoDBInfo.columns[1] = "packageName";
    localMAutoDBInfo.colsMap.put("packageName", "TEXT");
    localStringBuilder.append(" packageName TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "status";
    localMAutoDBInfo.colsMap.put("status", "INTEGER default '0' ");
    localStringBuilder.append(" status INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "sceneFlag";
    localMAutoDBInfo.colsMap.put("sceneFlag", "INTEGER default '0' ");
    localStringBuilder.append(" sceneFlag INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "msgTypeFlag";
    localMAutoDBInfo.colsMap.put("msgTypeFlag", "INTEGER default '0' ");
    localStringBuilder.append(" msgTypeFlag INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "msgState";
    localMAutoDBInfo.colsMap.put("msgState", "INTEGER default '0' ");
    localStringBuilder.append(" msgState INTEGER default '0' ");
    localMAutoDBInfo.columns[6] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("appId"))
    {
      this.field_appId = paramContentValues.getAsString("appId");
      if (paramBoolean) {
        this.jKG = true;
      }
    }
    if (paramContentValues.containsKey("packageName"))
    {
      this.field_packageName = paramContentValues.getAsString("packageName");
      if (paramBoolean) {
        this.jNB = true;
      }
    }
    if (paramContentValues.containsKey("status"))
    {
      this.field_status = paramContentValues.getAsInteger("status").intValue();
      if (paramBoolean) {
        this.jIC = true;
      }
    }
    if (paramContentValues.containsKey("sceneFlag"))
    {
      this.field_sceneFlag = paramContentValues.getAsInteger("sceneFlag").intValue();
      if (paramBoolean) {
        this.kRi = true;
      }
    }
    if (paramContentValues.containsKey("msgTypeFlag"))
    {
      this.field_msgTypeFlag = paramContentValues.getAsInteger("msgTypeFlag").intValue();
      if (paramBoolean) {
        this.kRj = true;
      }
    }
    if (paramContentValues.containsKey("msgState"))
    {
      this.field_msgState = paramContentValues.getAsInteger("msgState").intValue();
      if (paramBoolean) {
        this.kRk = true;
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
      if (jKX != k) {
        break label65;
      }
      this.field_appId = paramCursor.getString(i);
      this.jKG = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (jNX == k) {
        this.field_packageName = paramCursor.getString(i);
      } else if (jIF == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (kRl == k) {
        this.field_sceneFlag = paramCursor.getInt(i);
      } else if (kRm == k) {
        this.field_msgTypeFlag = paramCursor.getInt(i);
      } else if (kRn == k) {
        this.field_msgState = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.jKG) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.jNB) {
      localContentValues.put("packageName", this.field_packageName);
    }
    if (this.jIC) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.kRi) {
      localContentValues.put("sceneFlag", Integer.valueOf(this.field_sceneFlag));
    }
    if (this.kRj) {
      localContentValues.put("msgTypeFlag", Integer.valueOf(this.field_msgTypeFlag));
    }
    if (this.kRk) {
      localContentValues.put("msgState", Integer.valueOf(this.field_msgState));
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
  
  public StorageObserverOwner<? extends ga> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return this.field_appId;
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
 * Qualified Name:     com.tencent.mm.autogen.b.ga
 * JD-Core Version:    0.7.0.1
 */