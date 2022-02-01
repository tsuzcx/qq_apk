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

public abstract class ek
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("HardIotDeviceInfo");
  public static final Column jPb;
  private static final int jPh;
  public static final Column jTk;
  private static final int kCP;
  public static final Column kCr;
  public static final Column kDT;
  public static final Column kDU;
  private static final int kDX;
  private static final int kDY;
  private static final int kwM;
  private static final StorageObserverOwner<ek> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  public String field_deviceId;
  public int field_deviceType;
  public String field_iconUrl;
  public String field_nickName;
  public String field_supportMsgTypeList;
  private boolean jPe = true;
  private boolean kCD = true;
  private boolean kDV = true;
  private boolean kDW = true;
  private boolean kww = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    jPb = new Column("deviceId", "string", TABLE.getName(), "");
    kCr = new Column("deviceType", "int", TABLE.getName(), "");
    jTk = new Column("nickName", "string", TABLE.getName(), "");
    kDT = new Column("iconUrl", "string", TABLE.getName(), "");
    kDU = new Column("supportMsgTypeList", "string", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    jPh = "deviceId".hashCode();
    kCP = "deviceType".hashCode();
    kwM = "nickName".hashCode();
    kDX = "iconUrl".hashCode();
    kDY = "supportMsgTypeList".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[5];
    localMAutoDBInfo.columns = new String[6];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "deviceId";
    localMAutoDBInfo.colsMap.put("deviceId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" deviceId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "deviceId";
    localMAutoDBInfo.columns[1] = "deviceType";
    localMAutoDBInfo.colsMap.put("deviceType", "INTEGER");
    localStringBuilder.append(" deviceType INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "nickName";
    localMAutoDBInfo.colsMap.put("nickName", "TEXT");
    localStringBuilder.append(" nickName TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "iconUrl";
    localMAutoDBInfo.colsMap.put("iconUrl", "TEXT");
    localStringBuilder.append(" iconUrl TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "supportMsgTypeList";
    localMAutoDBInfo.colsMap.put("supportMsgTypeList", "TEXT");
    localStringBuilder.append(" supportMsgTypeList TEXT");
    localMAutoDBInfo.columns[5] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("deviceId"))
    {
      this.field_deviceId = paramContentValues.getAsString("deviceId");
      if (paramBoolean) {
        this.jPe = true;
      }
    }
    if (paramContentValues.containsKey("deviceType"))
    {
      this.field_deviceType = paramContentValues.getAsInteger("deviceType").intValue();
      if (paramBoolean) {
        this.kCD = true;
      }
    }
    if (paramContentValues.containsKey("nickName"))
    {
      this.field_nickName = paramContentValues.getAsString("nickName");
      if (paramBoolean) {
        this.kww = true;
      }
    }
    if (paramContentValues.containsKey("iconUrl"))
    {
      this.field_iconUrl = paramContentValues.getAsString("iconUrl");
      if (paramBoolean) {
        this.kDV = true;
      }
    }
    if (paramContentValues.containsKey("supportMsgTypeList"))
    {
      this.field_supportMsgTypeList = paramContentValues.getAsString("supportMsgTypeList");
      if (paramBoolean) {
        this.kDW = true;
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
      if (jPh != k) {
        break label65;
      }
      this.field_deviceId = paramCursor.getString(i);
      this.jPe = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (kCP == k) {
        this.field_deviceType = paramCursor.getInt(i);
      } else if (kwM == k) {
        this.field_nickName = paramCursor.getString(i);
      } else if (kDX == k) {
        this.field_iconUrl = paramCursor.getString(i);
      } else if (kDY == k) {
        this.field_supportMsgTypeList = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.jPe) {
      localContentValues.put("deviceId", this.field_deviceId);
    }
    if (this.kCD) {
      localContentValues.put("deviceType", Integer.valueOf(this.field_deviceType));
    }
    if (this.kww) {
      localContentValues.put("nickName", this.field_nickName);
    }
    if (this.kDV) {
      localContentValues.put("iconUrl", this.field_iconUrl);
    }
    if (this.kDW) {
      localContentValues.put("supportMsgTypeList", this.field_supportMsgTypeList);
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
  
  public StorageObserverOwner<? extends ek> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return this.field_deviceId;
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
 * Qualified Name:     com.tencent.mm.autogen.b.ek
 * JD-Core Version:    0.7.0.1
 */