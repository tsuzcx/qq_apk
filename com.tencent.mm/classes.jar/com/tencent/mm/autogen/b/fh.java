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

public abstract class fh
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("MonitoredBluetoothDeviceInfo");
  public static final Column UPDATETIME;
  private static final int jKX;
  public static final Column jKp;
  public static final Column jLD;
  private static final int jLL;
  public static final Column kKH;
  public static final Column kKI;
  public static final Column kKJ;
  public static final Column kKK;
  private static final int kKP;
  private static final int kKQ;
  private static final int kKR;
  private static final int kKS;
  private static final StorageObserverOwner<fh> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  private static final int updateTime_HASHCODE;
  private boolean __hadSetupdateTime = true;
  public String field_appId;
  public String field_bluetoothDeviceId;
  public String field_entryPackage;
  public boolean field_isBlocked;
  public long field_updateTime;
  public int field_versionType;
  public String field_wechatToken;
  private boolean jKG = true;
  private boolean jLH = true;
  private boolean kKL = true;
  private boolean kKM = true;
  private boolean kKN = true;
  private boolean kKO = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    jKp = new Column("appId", "string", TABLE.getName(), "");
    kKH = new Column("bluetoothDeviceId", "string", TABLE.getName(), "");
    kKI = new Column("wechatToken", "string", TABLE.getName(), "");
    jLD = new Column("versionType", "int", TABLE.getName(), "");
    kKJ = new Column("entryPackage", "string", TABLE.getName(), "");
    UPDATETIME = new Column("updateTime", "long", TABLE.getName(), "");
    kKK = new Column("isBlocked", "boolean", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    jKX = "appId".hashCode();
    kKP = "bluetoothDeviceId".hashCode();
    kKQ = "wechatToken".hashCode();
    jLL = "versionType".hashCode();
    kKR = "entryPackage".hashCode();
    updateTime_HASHCODE = "updateTime".hashCode();
    kKS = "isBlocked".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[7];
    localMAutoDBInfo.columns = new String[8];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "appId";
    localMAutoDBInfo.colsMap.put("appId", "TEXT");
    localStringBuilder.append(" appId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[1] = "bluetoothDeviceId";
    localMAutoDBInfo.colsMap.put("bluetoothDeviceId", "TEXT");
    localStringBuilder.append(" bluetoothDeviceId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "wechatToken";
    localMAutoDBInfo.colsMap.put("wechatToken", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" wechatToken TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "wechatToken";
    localMAutoDBInfo.columns[3] = "versionType";
    localMAutoDBInfo.colsMap.put("versionType", "INTEGER");
    localStringBuilder.append(" versionType INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "entryPackage";
    localMAutoDBInfo.colsMap.put("entryPackage", "TEXT");
    localStringBuilder.append(" entryPackage TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "updateTime";
    localMAutoDBInfo.colsMap.put("updateTime", "LONG");
    localStringBuilder.append(" updateTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "isBlocked";
    localMAutoDBInfo.colsMap.put("isBlocked", "INTEGER default 'false' ");
    localStringBuilder.append(" isBlocked INTEGER default 'false' ");
    localMAutoDBInfo.columns[7] = "rowid";
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
    if (paramContentValues.containsKey("bluetoothDeviceId"))
    {
      this.field_bluetoothDeviceId = paramContentValues.getAsString("bluetoothDeviceId");
      if (paramBoolean) {
        this.kKL = true;
      }
    }
    if (paramContentValues.containsKey("wechatToken"))
    {
      this.field_wechatToken = paramContentValues.getAsString("wechatToken");
      if (paramBoolean) {
        this.kKM = true;
      }
    }
    if (paramContentValues.containsKey("versionType"))
    {
      this.field_versionType = paramContentValues.getAsInteger("versionType").intValue();
      if (paramBoolean) {
        this.jLH = true;
      }
    }
    if (paramContentValues.containsKey("entryPackage"))
    {
      this.field_entryPackage = paramContentValues.getAsString("entryPackage");
      if (paramBoolean) {
        this.kKN = true;
      }
    }
    if (paramContentValues.containsKey("updateTime"))
    {
      this.field_updateTime = paramContentValues.getAsLong("updateTime").longValue();
      if (paramBoolean) {
        this.__hadSetupdateTime = true;
      }
    }
    if (paramContentValues.containsKey("isBlocked")) {
      if (paramContentValues.getAsInteger("isBlocked").intValue() == 0) {
        break label234;
      }
    }
    label234:
    for (boolean bool = true;; bool = false)
    {
      this.field_isBlocked = bool;
      if (paramBoolean) {
        this.kKO = true;
      }
      if (paramContentValues.containsKey("rowid")) {
        this.systemRowid = paramContentValues.getAsLong("rowid").longValue();
      }
      return;
    }
  }
  
  public void convertFrom(Cursor paramCursor)
  {
    String[] arrayOfString = paramCursor.getColumnNames();
    if (arrayOfString == null) {
      return;
    }
    int j = arrayOfString.length;
    int i = 0;
    label20:
    int k;
    if (i < j)
    {
      k = arrayOfString[i].hashCode();
      if (jKX != k) {
        break label60;
      }
      this.field_appId = paramCursor.getString(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (kKP == k)
      {
        this.field_bluetoothDeviceId = paramCursor.getString(i);
      }
      else if (kKQ == k)
      {
        this.field_wechatToken = paramCursor.getString(i);
        this.kKM = true;
      }
      else if (jLL == k)
      {
        this.field_versionType = paramCursor.getInt(i);
      }
      else if (kKR == k)
      {
        this.field_entryPackage = paramCursor.getString(i);
      }
      else if (updateTime_HASHCODE == k)
      {
        this.field_updateTime = paramCursor.getLong(i);
      }
      else
      {
        if (kKS == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_isBlocked = bool;
            break;
          }
        }
        if (rowid_HASHCODE == k) {
          this.systemRowid = paramCursor.getLong(i);
        }
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.jKG) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.kKL) {
      localContentValues.put("bluetoothDeviceId", this.field_bluetoothDeviceId);
    }
    if (this.kKM) {
      localContentValues.put("wechatToken", this.field_wechatToken);
    }
    if (this.jLH) {
      localContentValues.put("versionType", Integer.valueOf(this.field_versionType));
    }
    if (this.kKN) {
      localContentValues.put("entryPackage", this.field_entryPackage);
    }
    if (this.__hadSetupdateTime) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.kKO) {
      localContentValues.put("isBlocked", Boolean.valueOf(this.field_isBlocked));
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
  
  public StorageObserverOwner<? extends fh> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return this.field_wechatToken;
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
 * Qualified Name:     com.tencent.mm.autogen.b.fh
 * JD-Core Version:    0.7.0.1
 */