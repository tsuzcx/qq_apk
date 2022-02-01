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

public abstract class iz
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("WidgetSafeMode");
  public static final Column jKp;
  private static final int kQd;
  public static final Column lnO;
  public static final Column lnP;
  public static final Column lnQ;
  public static final Column lnR;
  private static final int lnW;
  private static final int lnX;
  private static final int lnY;
  private static final int lnZ;
  private static final StorageObserverOwner<iz> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  public String field_appid;
  public long field_beginTimestamp;
  public int field_crashCount;
  public int field_jsExceptionCount;
  public int field_pkgVersion;
  private boolean kQb = true;
  private boolean lnS = true;
  private boolean lnT = true;
  private boolean lnU = true;
  private boolean lnV = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    jKp = new Column("appid", "string", TABLE.getName(), "");
    lnO = new Column("jsExceptionCount", "int", TABLE.getName(), "");
    lnP = new Column("crashCount", "int", TABLE.getName(), "");
    lnQ = new Column("beginTimestamp", "long", TABLE.getName(), "");
    lnR = new Column("pkgVersion", "int", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    kQd = "appid".hashCode();
    lnW = "jsExceptionCount".hashCode();
    lnX = "crashCount".hashCode();
    lnY = "beginTimestamp".hashCode();
    lnZ = "pkgVersion".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[5];
    localMAutoDBInfo.columns = new String[6];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "appid";
    localMAutoDBInfo.colsMap.put("appid", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" appid TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "appid";
    localMAutoDBInfo.columns[1] = "jsExceptionCount";
    localMAutoDBInfo.colsMap.put("jsExceptionCount", "INTEGER");
    localStringBuilder.append(" jsExceptionCount INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "crashCount";
    localMAutoDBInfo.colsMap.put("crashCount", "INTEGER");
    localStringBuilder.append(" crashCount INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "beginTimestamp";
    localMAutoDBInfo.colsMap.put("beginTimestamp", "LONG");
    localStringBuilder.append(" beginTimestamp LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "pkgVersion";
    localMAutoDBInfo.colsMap.put("pkgVersion", "INTEGER");
    localStringBuilder.append(" pkgVersion INTEGER");
    localMAutoDBInfo.columns[5] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("appid"))
    {
      this.field_appid = paramContentValues.getAsString("appid");
      if (paramBoolean) {
        this.kQb = true;
      }
    }
    if (paramContentValues.containsKey("jsExceptionCount"))
    {
      this.field_jsExceptionCount = paramContentValues.getAsInteger("jsExceptionCount").intValue();
      if (paramBoolean) {
        this.lnS = true;
      }
    }
    if (paramContentValues.containsKey("crashCount"))
    {
      this.field_crashCount = paramContentValues.getAsInteger("crashCount").intValue();
      if (paramBoolean) {
        this.lnT = true;
      }
    }
    if (paramContentValues.containsKey("beginTimestamp"))
    {
      this.field_beginTimestamp = paramContentValues.getAsLong("beginTimestamp").longValue();
      if (paramBoolean) {
        this.lnU = true;
      }
    }
    if (paramContentValues.containsKey("pkgVersion"))
    {
      this.field_pkgVersion = paramContentValues.getAsInteger("pkgVersion").intValue();
      if (paramBoolean) {
        this.lnV = true;
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
      if (kQd != k) {
        break label65;
      }
      this.field_appid = paramCursor.getString(i);
      this.kQb = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (lnW == k) {
        this.field_jsExceptionCount = paramCursor.getInt(i);
      } else if (lnX == k) {
        this.field_crashCount = paramCursor.getInt(i);
      } else if (lnY == k) {
        this.field_beginTimestamp = paramCursor.getLong(i);
      } else if (lnZ == k) {
        this.field_pkgVersion = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.kQb) {
      localContentValues.put("appid", this.field_appid);
    }
    if (this.lnS) {
      localContentValues.put("jsExceptionCount", Integer.valueOf(this.field_jsExceptionCount));
    }
    if (this.lnT) {
      localContentValues.put("crashCount", Integer.valueOf(this.field_crashCount));
    }
    if (this.lnU) {
      localContentValues.put("beginTimestamp", Long.valueOf(this.field_beginTimestamp));
    }
    if (this.lnV) {
      localContentValues.put("pkgVersion", Integer.valueOf(this.field_pkgVersion));
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
  
  public StorageObserverOwner<? extends iz> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return this.field_appid;
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
 * Qualified Name:     com.tencent.mm.autogen.b.iz
 * JD-Core Version:    0.7.0.1
 */