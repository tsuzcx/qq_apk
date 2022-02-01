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

public abstract class gw
  extends IAutoDBItem
{
  public static final Column CREATETIME;
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("SafeDeviceInfo");
  private static final int kBR;
  public static final Column kCr;
  public static final Column kVQ;
  private static final int kVT;
  private static final int kVU;
  public static final Column kef;
  private static final int kfI;
  private static final StorageObserverOwner<gw> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  public long field_createtime;
  public String field_devicetype;
  public String field_name;
  public String field_uid;
  private boolean kBG = true;
  private boolean kVR = true;
  private boolean kVS = true;
  private boolean keU = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    kVQ = new Column("uid", "string", TABLE.getName(), "");
    kef = new Column("name", "string", TABLE.getName(), "");
    kCr = new Column("devicetype", "string", TABLE.getName(), "");
    CREATETIME = new Column("createtime", "long", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    kVT = "uid".hashCode();
    kfI = "name".hashCode();
    kVU = "devicetype".hashCode();
    kBR = "createtime".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[4];
    localMAutoDBInfo.columns = new String[5];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "uid";
    localMAutoDBInfo.colsMap.put("uid", "TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(" uid TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "uid";
    localMAutoDBInfo.columns[1] = "name";
    localMAutoDBInfo.colsMap.put("name", "TEXT default '' ");
    localStringBuilder.append(" name TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "devicetype";
    localMAutoDBInfo.colsMap.put("devicetype", "TEXT default '' ");
    localStringBuilder.append(" devicetype TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "createtime";
    localMAutoDBInfo.colsMap.put("createtime", "LONG default '0' ");
    localStringBuilder.append(" createtime LONG default '0' ");
    localMAutoDBInfo.columns[4] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("uid"))
    {
      this.field_uid = paramContentValues.getAsString("uid");
      if (paramBoolean) {
        this.kVR = true;
      }
    }
    if (paramContentValues.containsKey("name"))
    {
      this.field_name = paramContentValues.getAsString("name");
      if (paramBoolean) {
        this.keU = true;
      }
    }
    if (paramContentValues.containsKey("devicetype"))
    {
      this.field_devicetype = paramContentValues.getAsString("devicetype");
      if (paramBoolean) {
        this.kVS = true;
      }
    }
    if (paramContentValues.containsKey("createtime"))
    {
      this.field_createtime = paramContentValues.getAsLong("createtime").longValue();
      if (paramBoolean) {
        this.kBG = true;
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
      if (kVT != k) {
        break label65;
      }
      this.field_uid = paramCursor.getString(i);
      this.kVR = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (kfI == k) {
        this.field_name = paramCursor.getString(i);
      } else if (kVU == k) {
        this.field_devicetype = paramCursor.getString(i);
      } else if (kBR == k) {
        this.field_createtime = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.field_uid == null) {
      this.field_uid = "";
    }
    if (this.kVR) {
      localContentValues.put("uid", this.field_uid);
    }
    if (this.field_name == null) {
      this.field_name = "";
    }
    if (this.keU) {
      localContentValues.put("name", this.field_name);
    }
    if (this.field_devicetype == null) {
      this.field_devicetype = "";
    }
    if (this.kVS) {
      localContentValues.put("devicetype", this.field_devicetype);
    }
    if (this.kBG) {
      localContentValues.put("createtime", Long.valueOf(this.field_createtime));
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
  
  public StorageObserverOwner<? extends gw> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return this.field_uid;
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
 * Qualified Name:     com.tencent.mm.autogen.b.gw
 * JD-Core Version:    0.7.0.1
 */