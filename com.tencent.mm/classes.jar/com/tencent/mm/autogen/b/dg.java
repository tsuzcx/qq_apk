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

public abstract class dg
  extends IAutoDBItem
{
  public static final Column CREATETIME;
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("ForceNotifyData");
  public static final Column TYPE;
  public static final Column USERNAME;
  public static final Column jIz;
  public static final Column jOO;
  public static final Column jSx;
  public static final Column ksx;
  public static final Column kuQ;
  public static final Column kug;
  private static final int kva;
  private static final int kvb;
  private static final int kvc;
  private static final int kvd;
  private static final int kve;
  private static final int kvf;
  private static final int kvg;
  private static final int kvh;
  private static final int kvi;
  private static final StorageObserverOwner<dg> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  public long field_CreateTime;
  public String field_Description;
  public long field_ExpiredTime;
  public String field_ExtInfo;
  public String field_ForcePushId;
  public int field_Status;
  public int field_Type;
  public String field_UserIcon;
  public String field_UserName;
  private boolean kuR = true;
  private boolean kuS = true;
  private boolean kuT = true;
  private boolean kuU = true;
  private boolean kuV = true;
  private boolean kuW = true;
  private boolean kuX = true;
  private boolean kuY = true;
  private boolean kuZ = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    ksx = new Column("ForcePushId", "string", TABLE.getName(), "");
    CREATETIME = new Column("CreateTime", "long", TABLE.getName(), "");
    kug = new Column("ExpiredTime", "long", TABLE.getName(), "");
    jOO = new Column("Description", "string", TABLE.getName(), "");
    kuQ = new Column("UserIcon", "string", TABLE.getName(), "");
    USERNAME = new Column("UserName", "string", TABLE.getName(), "");
    jSx = new Column("ExtInfo", "string", TABLE.getName(), "");
    jIz = new Column("Status", "int", TABLE.getName(), "");
    TYPE = new Column("Type", "int", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    kva = "ForcePushId".hashCode();
    kvb = "CreateTime".hashCode();
    kvc = "ExpiredTime".hashCode();
    kvd = "Description".hashCode();
    kve = "UserIcon".hashCode();
    kvf = "UserName".hashCode();
    kvg = "ExtInfo".hashCode();
    kvh = "Status".hashCode();
    kvi = "Type".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[9];
    localMAutoDBInfo.columns = new String[10];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "ForcePushId";
    localMAutoDBInfo.colsMap.put("ForcePushId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" ForcePushId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "ForcePushId";
    localMAutoDBInfo.columns[1] = "CreateTime";
    localMAutoDBInfo.colsMap.put("CreateTime", "LONG");
    localStringBuilder.append(" CreateTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "ExpiredTime";
    localMAutoDBInfo.colsMap.put("ExpiredTime", "LONG");
    localStringBuilder.append(" ExpiredTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "Description";
    localMAutoDBInfo.colsMap.put("Description", "TEXT");
    localStringBuilder.append(" Description TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "UserIcon";
    localMAutoDBInfo.colsMap.put("UserIcon", "TEXT");
    localStringBuilder.append(" UserIcon TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "UserName";
    localMAutoDBInfo.colsMap.put("UserName", "TEXT");
    localStringBuilder.append(" UserName TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "ExtInfo";
    localMAutoDBInfo.colsMap.put("ExtInfo", "TEXT");
    localStringBuilder.append(" ExtInfo TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "Status";
    localMAutoDBInfo.colsMap.put("Status", "INTEGER default '0' ");
    localStringBuilder.append(" Status INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "Type";
    localMAutoDBInfo.colsMap.put("Type", "INTEGER default '0' ");
    localStringBuilder.append(" Type INTEGER default '0' ");
    localMAutoDBInfo.columns[9] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("ForcePushId"))
    {
      this.field_ForcePushId = paramContentValues.getAsString("ForcePushId");
      if (paramBoolean) {
        this.kuR = true;
      }
    }
    if (paramContentValues.containsKey("CreateTime"))
    {
      this.field_CreateTime = paramContentValues.getAsLong("CreateTime").longValue();
      if (paramBoolean) {
        this.kuS = true;
      }
    }
    if (paramContentValues.containsKey("ExpiredTime"))
    {
      this.field_ExpiredTime = paramContentValues.getAsLong("ExpiredTime").longValue();
      if (paramBoolean) {
        this.kuT = true;
      }
    }
    if (paramContentValues.containsKey("Description"))
    {
      this.field_Description = paramContentValues.getAsString("Description");
      if (paramBoolean) {
        this.kuU = true;
      }
    }
    if (paramContentValues.containsKey("UserIcon"))
    {
      this.field_UserIcon = paramContentValues.getAsString("UserIcon");
      if (paramBoolean) {
        this.kuV = true;
      }
    }
    if (paramContentValues.containsKey("UserName"))
    {
      this.field_UserName = paramContentValues.getAsString("UserName");
      if (paramBoolean) {
        this.kuW = true;
      }
    }
    if (paramContentValues.containsKey("ExtInfo"))
    {
      this.field_ExtInfo = paramContentValues.getAsString("ExtInfo");
      if (paramBoolean) {
        this.kuX = true;
      }
    }
    if (paramContentValues.containsKey("Status"))
    {
      this.field_Status = paramContentValues.getAsInteger("Status").intValue();
      if (paramBoolean) {
        this.kuY = true;
      }
    }
    if (paramContentValues.containsKey("Type"))
    {
      this.field_Type = paramContentValues.getAsInteger("Type").intValue();
      if (paramBoolean) {
        this.kuZ = true;
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
      if (kva != k) {
        break label65;
      }
      this.field_ForcePushId = paramCursor.getString(i);
      this.kuR = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (kvb == k) {
        this.field_CreateTime = paramCursor.getLong(i);
      } else if (kvc == k) {
        this.field_ExpiredTime = paramCursor.getLong(i);
      } else if (kvd == k) {
        this.field_Description = paramCursor.getString(i);
      } else if (kve == k) {
        this.field_UserIcon = paramCursor.getString(i);
      } else if (kvf == k) {
        this.field_UserName = paramCursor.getString(i);
      } else if (kvg == k) {
        this.field_ExtInfo = paramCursor.getString(i);
      } else if (kvh == k) {
        this.field_Status = paramCursor.getInt(i);
      } else if (kvi == k) {
        this.field_Type = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.kuR) {
      localContentValues.put("ForcePushId", this.field_ForcePushId);
    }
    if (this.kuS) {
      localContentValues.put("CreateTime", Long.valueOf(this.field_CreateTime));
    }
    if (this.kuT) {
      localContentValues.put("ExpiredTime", Long.valueOf(this.field_ExpiredTime));
    }
    if (this.kuU) {
      localContentValues.put("Description", this.field_Description);
    }
    if (this.kuV) {
      localContentValues.put("UserIcon", this.field_UserIcon);
    }
    if (this.kuW) {
      localContentValues.put("UserName", this.field_UserName);
    }
    if (this.kuX) {
      localContentValues.put("ExtInfo", this.field_ExtInfo);
    }
    if (this.kuY) {
      localContentValues.put("Status", Integer.valueOf(this.field_Status));
    }
    if (this.kuZ) {
      localContentValues.put("Type", Integer.valueOf(this.field_Type));
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
  
  public StorageObserverOwner<? extends dg> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return this.field_ForcePushId;
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
 * Qualified Name:     com.tencent.mm.autogen.b.dg
 * JD-Core Version:    0.7.0.1
 */