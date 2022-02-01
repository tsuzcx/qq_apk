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

public abstract class jh
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("WxaPluginCodeVersionInfo");
  private static final int lpA;
  private static final int lpB;
  public static final Column lpt;
  public static final Column lpu;
  public static final Column lpv;
  private static final int lpz;
  private static final StorageObserverOwner<jh> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  public String field_pluginAppID;
  public int field_pluginAppVersion;
  public String field_pluginStringVersion;
  private boolean lpw = true;
  private boolean lpx = true;
  private boolean lpy = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    lpt = new Column("pluginAppID", "string", TABLE.getName(), "");
    lpu = new Column("pluginAppVersion", "int", TABLE.getName(), "");
    lpv = new Column("pluginStringVersion", "string", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    lpz = "pluginAppID".hashCode();
    lpA = "pluginAppVersion".hashCode();
    lpB = "pluginStringVersion".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[3];
    localMAutoDBInfo.columns = new String[4];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "pluginAppID";
    localMAutoDBInfo.colsMap.put("pluginAppID", "TEXT");
    localStringBuilder.append(" pluginAppID TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[1] = "pluginAppVersion";
    localMAutoDBInfo.colsMap.put("pluginAppVersion", "INTEGER");
    localStringBuilder.append(" pluginAppVersion INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "pluginStringVersion";
    localMAutoDBInfo.colsMap.put("pluginStringVersion", "TEXT");
    localStringBuilder.append(" pluginStringVersion TEXT");
    localMAutoDBInfo.columns[3] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("pluginAppID"))
    {
      this.field_pluginAppID = paramContentValues.getAsString("pluginAppID");
      if (paramBoolean) {
        this.lpw = true;
      }
    }
    if (paramContentValues.containsKey("pluginAppVersion"))
    {
      this.field_pluginAppVersion = paramContentValues.getAsInteger("pluginAppVersion").intValue();
      if (paramBoolean) {
        this.lpx = true;
      }
    }
    if (paramContentValues.containsKey("pluginStringVersion"))
    {
      this.field_pluginStringVersion = paramContentValues.getAsString("pluginStringVersion");
      if (paramBoolean) {
        this.lpy = true;
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
      if (lpz != k) {
        break label60;
      }
      this.field_pluginAppID = paramCursor.getString(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (lpA == k) {
        this.field_pluginAppVersion = paramCursor.getInt(i);
      } else if (lpB == k) {
        this.field_pluginStringVersion = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.lpw) {
      localContentValues.put("pluginAppID", this.field_pluginAppID);
    }
    if (this.lpx) {
      localContentValues.put("pluginAppVersion", Integer.valueOf(this.field_pluginAppVersion));
    }
    if (this.lpy) {
      localContentValues.put("pluginStringVersion", this.field_pluginStringVersion);
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
  
  public StorageObserverOwner<? extends jh> getObserverOwner()
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
 * Qualified Name:     com.tencent.mm.autogen.b.jh
 * JD-Core Version:    0.7.0.1
 */