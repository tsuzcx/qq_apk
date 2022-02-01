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

public abstract class jf
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("WxaCheckDemoInfo");
  private static final int jKX;
  public static final Column jKp;
  public static final Column lpk;
  public static final Column lpl;
  private static final int lpo;
  private static final int lpp;
  private static final StorageObserverOwner<jf> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  public String field_appId;
  public boolean field_permissionDemo;
  public long field_versiontime;
  private boolean jKG = true;
  private boolean lpm = true;
  private boolean lpn = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    jKp = new Column("appId", "string", TABLE.getName(), "");
    lpk = new Column("permissionDemo", "boolean", TABLE.getName(), "");
    lpl = new Column("versiontime", "long", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    jKX = "appId".hashCode();
    lpo = "permissionDemo".hashCode();
    lpp = "versiontime".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[3];
    localMAutoDBInfo.columns = new String[4];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "appId";
    localMAutoDBInfo.colsMap.put("appId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" appId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "appId";
    localMAutoDBInfo.columns[1] = "permissionDemo";
    localMAutoDBInfo.colsMap.put("permissionDemo", "INTEGER default 'false' ");
    localStringBuilder.append(" permissionDemo INTEGER default 'false' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "versiontime";
    localMAutoDBInfo.colsMap.put("versiontime", "LONG");
    localStringBuilder.append(" versiontime LONG");
    localMAutoDBInfo.columns[3] = "rowid";
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
    if (paramContentValues.containsKey("permissionDemo")) {
      if (paramContentValues.getAsInteger("permissionDemo").intValue() == 0) {
        break label119;
      }
    }
    label119:
    for (boolean bool = true;; bool = false)
    {
      this.field_permissionDemo = bool;
      if (paramBoolean) {
        this.lpm = true;
      }
      if (paramContentValues.containsKey("versiontime"))
      {
        this.field_versiontime = paramContentValues.getAsLong("versiontime").longValue();
        if (paramBoolean) {
          this.lpn = true;
        }
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
      if (lpo == k)
      {
        if (paramCursor.getInt(i) != 0) {}
        for (boolean bool = true;; bool = false)
        {
          this.field_permissionDemo = bool;
          break;
        }
      }
      if (lpp == k) {
        this.field_versiontime = paramCursor.getLong(i);
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
    if (this.lpm) {
      localContentValues.put("permissionDemo", Boolean.valueOf(this.field_permissionDemo));
    }
    if (this.lpn) {
      localContentValues.put("versiontime", Long.valueOf(this.field_versiontime));
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
  
  public StorageObserverOwner<? extends jf> getObserverOwner()
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
 * Qualified Name:     com.tencent.mm.autogen.b.jf
 * JD-Core Version:    0.7.0.1
 */