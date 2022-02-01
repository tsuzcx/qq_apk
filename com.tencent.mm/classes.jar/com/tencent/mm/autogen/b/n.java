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

public abstract class n
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("AppBrandFakeNativeSplashScreenshot");
  private static final int jKX;
  public static final Column jKp;
  public static final Column jLD;
  public static final Column jLE;
  public static final Column jLF;
  public static final Column jLG;
  private static final int jLL;
  private static final int jLM;
  private static final int jLN;
  private static final int jLO;
  private static final StorageObserverOwner<n> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  public String field_appId;
  public int field_appVersion;
  public boolean field_isDarkMode;
  public String field_screenshotFilePath;
  public int field_versionType;
  private boolean jKG = true;
  private boolean jLH = true;
  private boolean jLI = true;
  private boolean jLJ = true;
  private boolean jLK = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    jKp = new Column("appId", "string", TABLE.getName(), "");
    jLD = new Column("versionType", "int", TABLE.getName(), "");
    jLE = new Column("appVersion", "int", TABLE.getName(), "");
    jLF = new Column("isDarkMode", "boolean", TABLE.getName(), "");
    jLG = new Column("screenshotFilePath", "string", TABLE.getName(), "");
    INDEX_CREATE = new String[] { "CREATE INDEX IF NOT EXISTS AppBrandFakeNativeSplashScreenshotAPPIDINDEX ON AppBrandFakeNativeSplashScreenshot(appId)" };
    jKX = "appId".hashCode();
    jLL = "versionType".hashCode();
    jLM = "appVersion".hashCode();
    jLN = "isDarkMode".hashCode();
    jLO = "screenshotFilePath".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[5];
    localMAutoDBInfo.columns = new String[6];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "appId";
    localMAutoDBInfo.colsMap.put("appId", "TEXT");
    localStringBuilder.append(" appId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[1] = "versionType";
    localMAutoDBInfo.colsMap.put("versionType", "INTEGER default '0' ");
    localStringBuilder.append(" versionType INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "appVersion";
    localMAutoDBInfo.colsMap.put("appVersion", "INTEGER default '0' ");
    localStringBuilder.append(" appVersion INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "isDarkMode";
    localMAutoDBInfo.colsMap.put("isDarkMode", "INTEGER default 'false' ");
    localStringBuilder.append(" isDarkMode INTEGER default 'false' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "screenshotFilePath";
    localMAutoDBInfo.colsMap.put("screenshotFilePath", "TEXT");
    localStringBuilder.append(" screenshotFilePath TEXT");
    localMAutoDBInfo.columns[5] = "rowid";
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
    if (paramContentValues.containsKey("versionType"))
    {
      this.field_versionType = paramContentValues.getAsInteger("versionType").intValue();
      if (paramBoolean) {
        this.jLH = true;
      }
    }
    if (paramContentValues.containsKey("appVersion"))
    {
      this.field_appVersion = paramContentValues.getAsInteger("appVersion").intValue();
      if (paramBoolean) {
        this.jLI = true;
      }
    }
    if (paramContentValues.containsKey("isDarkMode")) {
      if (paramContentValues.getAsInteger("isDarkMode").intValue() == 0) {
        break label178;
      }
    }
    label178:
    for (boolean bool = true;; bool = false)
    {
      this.field_isDarkMode = bool;
      if (paramBoolean) {
        this.jLJ = true;
      }
      if (paramContentValues.containsKey("screenshotFilePath"))
      {
        this.field_screenshotFilePath = paramContentValues.getAsString("screenshotFilePath");
        if (paramBoolean) {
          this.jLK = true;
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
      if (jLL == k)
      {
        this.field_versionType = paramCursor.getInt(i);
      }
      else if (jLM == k)
      {
        this.field_appVersion = paramCursor.getInt(i);
      }
      else
      {
        if (jLN == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_isDarkMode = bool;
            break;
          }
        }
        if (jLO == k) {
          this.field_screenshotFilePath = paramCursor.getString(i);
        } else if (rowid_HASHCODE == k) {
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
    if (this.jLH) {
      localContentValues.put("versionType", Integer.valueOf(this.field_versionType));
    }
    if (this.jLI) {
      localContentValues.put("appVersion", Integer.valueOf(this.field_appVersion));
    }
    if (this.jLJ) {
      localContentValues.put("isDarkMode", Boolean.valueOf(this.field_isDarkMode));
    }
    if (this.jLK) {
      localContentValues.put("screenshotFilePath", this.field_screenshotFilePath);
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
  
  public StorageObserverOwner<? extends n> getObserverOwner()
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
 * Qualified Name:     com.tencent.mm.autogen.b.n
 * JD-Core Version:    0.7.0.1
 */