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

public abstract class q
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("AppBrandLauncherLayoutItem");
  public static final Column UPDATETIME;
  private static final int jJD;
  public static final Column jJz;
  public static final Column jLD;
  private static final int jLL;
  public static final Column jLV;
  public static final Column jLW;
  public static final Column jLX;
  public static final Column jLY;
  private static final int jMd;
  private static final int jMe;
  private static final int jMf;
  private static final int jMg;
  private static final StorageObserverOwner<q> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  private static final int updateTime_HASHCODE;
  private boolean __hadSetupdateTime = true;
  public String field_brandId;
  public int field_recordId;
  public int field_scene;
  public String field_thirdPartyAppUsingDesc;
  public long field_updateTime;
  public boolean field_usedInThirdPartyAppRecently;
  public int field_versionType;
  private boolean jJB = true;
  private boolean jLH = true;
  private boolean jLZ = true;
  private boolean jMa = true;
  private boolean jMb = true;
  private boolean jMc = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    jLV = new Column("recordId", "int", TABLE.getName(), "");
    jLW = new Column("brandId", "string", TABLE.getName(), "");
    jLD = new Column("versionType", "int", TABLE.getName(), "");
    UPDATETIME = new Column("updateTime", "long", TABLE.getName(), "");
    jJz = new Column("scene", "int", TABLE.getName(), "");
    jLX = new Column("usedInThirdPartyAppRecently", "boolean", TABLE.getName(), "");
    jLY = new Column("thirdPartyAppUsingDesc", "string", TABLE.getName(), "");
    INDEX_CREATE = new String[] { "CREATE INDEX IF NOT EXISTS AppBrandLauncherLayoutItemUpdateTimeIndex ON AppBrandLauncherLayoutItem(updateTime)", "CREATE INDEX IF NOT EXISTS AppBrandLauncherLayoutItemSceneIndex ON AppBrandLauncherLayoutItem(scene)" };
    jMd = "recordId".hashCode();
    jMe = "brandId".hashCode();
    jLL = "versionType".hashCode();
    updateTime_HASHCODE = "updateTime".hashCode();
    jJD = "scene".hashCode();
    jMf = "usedInThirdPartyAppRecently".hashCode();
    jMg = "thirdPartyAppUsingDesc".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[7];
    localMAutoDBInfo.columns = new String[8];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "recordId";
    localMAutoDBInfo.colsMap.put("recordId", "INTEGER PRIMARY KEY ");
    localStringBuilder.append(" recordId INTEGER PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "recordId";
    localMAutoDBInfo.columns[1] = "brandId";
    localMAutoDBInfo.colsMap.put("brandId", "TEXT");
    localStringBuilder.append(" brandId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "versionType";
    localMAutoDBInfo.colsMap.put("versionType", "INTEGER");
    localStringBuilder.append(" versionType INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "updateTime";
    localMAutoDBInfo.colsMap.put("updateTime", "LONG");
    localStringBuilder.append(" updateTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "scene";
    localMAutoDBInfo.colsMap.put("scene", "INTEGER");
    localStringBuilder.append(" scene INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "usedInThirdPartyAppRecently";
    localMAutoDBInfo.colsMap.put("usedInThirdPartyAppRecently", "INTEGER default 'false' ");
    localStringBuilder.append(" usedInThirdPartyAppRecently INTEGER default 'false' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "thirdPartyAppUsingDesc";
    localMAutoDBInfo.colsMap.put("thirdPartyAppUsingDesc", "TEXT");
    localStringBuilder.append(" thirdPartyAppUsingDesc TEXT");
    localMAutoDBInfo.columns[7] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("recordId"))
    {
      this.field_recordId = paramContentValues.getAsInteger("recordId").intValue();
      if (paramBoolean) {
        this.jLZ = true;
      }
    }
    if (paramContentValues.containsKey("brandId"))
    {
      this.field_brandId = paramContentValues.getAsString("brandId");
      if (paramBoolean) {
        this.jMa = true;
      }
    }
    if (paramContentValues.containsKey("versionType"))
    {
      this.field_versionType = paramContentValues.getAsInteger("versionType").intValue();
      if (paramBoolean) {
        this.jLH = true;
      }
    }
    if (paramContentValues.containsKey("updateTime"))
    {
      this.field_updateTime = paramContentValues.getAsLong("updateTime").longValue();
      if (paramBoolean) {
        this.__hadSetupdateTime = true;
      }
    }
    if (paramContentValues.containsKey("scene"))
    {
      this.field_scene = paramContentValues.getAsInteger("scene").intValue();
      if (paramBoolean) {
        this.jJB = true;
      }
    }
    if (paramContentValues.containsKey("usedInThirdPartyAppRecently")) {
      if (paramContentValues.getAsInteger("usedInThirdPartyAppRecently").intValue() == 0) {
        break label240;
      }
    }
    label240:
    for (boolean bool = true;; bool = false)
    {
      this.field_usedInThirdPartyAppRecently = bool;
      if (paramBoolean) {
        this.jMb = true;
      }
      if (paramContentValues.containsKey("thirdPartyAppUsingDesc"))
      {
        this.field_thirdPartyAppUsingDesc = paramContentValues.getAsString("thirdPartyAppUsingDesc");
        if (paramBoolean) {
          this.jMc = true;
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
      if (jMd != k) {
        break label65;
      }
      this.field_recordId = paramCursor.getInt(i);
      this.jLZ = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (jMe == k)
      {
        this.field_brandId = paramCursor.getString(i);
      }
      else if (jLL == k)
      {
        this.field_versionType = paramCursor.getInt(i);
      }
      else if (updateTime_HASHCODE == k)
      {
        this.field_updateTime = paramCursor.getLong(i);
      }
      else if (jJD == k)
      {
        this.field_scene = paramCursor.getInt(i);
      }
      else
      {
        if (jMf == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_usedInThirdPartyAppRecently = bool;
            break;
          }
        }
        if (jMg == k) {
          this.field_thirdPartyAppUsingDesc = paramCursor.getString(i);
        } else if (rowid_HASHCODE == k) {
          this.systemRowid = paramCursor.getLong(i);
        }
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.jLZ) {
      localContentValues.put("recordId", Integer.valueOf(this.field_recordId));
    }
    if (this.jMa) {
      localContentValues.put("brandId", this.field_brandId);
    }
    if (this.jLH) {
      localContentValues.put("versionType", Integer.valueOf(this.field_versionType));
    }
    if (this.__hadSetupdateTime) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.jJB) {
      localContentValues.put("scene", Integer.valueOf(this.field_scene));
    }
    if (this.jMb) {
      localContentValues.put("usedInThirdPartyAppRecently", Boolean.valueOf(this.field_usedInThirdPartyAppRecently));
    }
    if (this.jMc) {
      localContentValues.put("thirdPartyAppUsingDesc", this.field_thirdPartyAppUsingDesc);
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
  
  public StorageObserverOwner<? extends q> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return Integer.valueOf(this.field_recordId);
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
 * Qualified Name:     com.tencent.mm.autogen.b.q
 * JD-Core Version:    0.7.0.1
 */