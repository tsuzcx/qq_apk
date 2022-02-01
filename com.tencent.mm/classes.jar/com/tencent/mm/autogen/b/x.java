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

public abstract class x
  extends IAutoDBItem
{
  public static final Column CREATETIME;
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("AppBrandWxaPkgManifestRecord");
  private static final int createTime_HASHCODE;
  public static final Column jIK;
  public static final Column jIL;
  private static final int jIY;
  private static final int jIZ;
  private static final int jKX;
  public static final Column jKp;
  public static final Column jMA;
  private static final int jMG;
  private static final int jMH;
  private static final int jMI;
  private static final int jMJ;
  private static final int jMK;
  public static final Column jMt;
  private static final int jMv;
  public static final Column jMw;
  public static final Column jMx;
  public static final Column jMy;
  public static final Column jMz;
  private static final StorageObserverOwner<x> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  private boolean __hadSetcreateTime = true;
  public String field_NewMd5;
  public String field_appId;
  public long field_createTime;
  public int field_debugType;
  public String field_downloadURL;
  public long field_endTime;
  public String field_pkgPath;
  public long field_startTime;
  public int field_version;
  public String field_versionMd5;
  private boolean jIR = true;
  private boolean jIS = true;
  private boolean jKG = true;
  private boolean jMB = true;
  private boolean jMC = true;
  private boolean jMD = true;
  private boolean jME = true;
  private boolean jMF = true;
  private boolean jMu = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    jKp = new Column("appId", "string", TABLE.getName(), "");
    jMw = new Column("version", "int", TABLE.getName(), "");
    jMt = new Column("versionMd5", "string", TABLE.getName(), "");
    jMx = new Column("NewMd5", "string", TABLE.getName(), "");
    jMy = new Column("pkgPath", "string", TABLE.getName(), "");
    CREATETIME = new Column("createTime", "long", TABLE.getName(), "");
    jMz = new Column("debugType", "int", TABLE.getName(), "");
    jMA = new Column("downloadURL", "string", TABLE.getName(), "");
    jIK = new Column("startTime", "long", TABLE.getName(), "");
    jIL = new Column("endTime", "long", TABLE.getName(), "");
    INDEX_CREATE = new String[] { "CREATE INDEX IF NOT EXISTS AppBrandWxaPkgManifestRecordPkgPathIndex ON AppBrandWxaPkgManifestRecord(pkgPath)" };
    jKX = "appId".hashCode();
    jMG = "version".hashCode();
    jMv = "versionMd5".hashCode();
    jMH = "NewMd5".hashCode();
    jMI = "pkgPath".hashCode();
    createTime_HASHCODE = "createTime".hashCode();
    jMJ = "debugType".hashCode();
    jMK = "downloadURL".hashCode();
    jIY = "startTime".hashCode();
    jIZ = "endTime".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[10];
    localMAutoDBInfo.columns = new String[11];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "appId";
    localMAutoDBInfo.colsMap.put("appId", "TEXT");
    localStringBuilder.append(" appId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[1] = "version";
    localMAutoDBInfo.colsMap.put("version", "INTEGER");
    localStringBuilder.append(" version INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "versionMd5";
    localMAutoDBInfo.colsMap.put("versionMd5", "TEXT");
    localStringBuilder.append(" versionMd5 TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "NewMd5";
    localMAutoDBInfo.colsMap.put("NewMd5", "TEXT");
    localStringBuilder.append(" NewMd5 TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "pkgPath";
    localMAutoDBInfo.colsMap.put("pkgPath", "TEXT");
    localStringBuilder.append(" pkgPath TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "createTime";
    localMAutoDBInfo.colsMap.put("createTime", "LONG");
    localStringBuilder.append(" createTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "debugType";
    localMAutoDBInfo.colsMap.put("debugType", "INTEGER default '0' ");
    localStringBuilder.append(" debugType INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "downloadURL";
    localMAutoDBInfo.colsMap.put("downloadURL", "TEXT");
    localStringBuilder.append(" downloadURL TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "startTime";
    localMAutoDBInfo.colsMap.put("startTime", "LONG");
    localStringBuilder.append(" startTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "endTime";
    localMAutoDBInfo.colsMap.put("endTime", "LONG");
    localStringBuilder.append(" endTime LONG");
    localMAutoDBInfo.columns[10] = "rowid";
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
    if (paramContentValues.containsKey("version"))
    {
      this.field_version = paramContentValues.getAsInteger("version").intValue();
      if (paramBoolean) {
        this.jMB = true;
      }
    }
    if (paramContentValues.containsKey("versionMd5"))
    {
      this.field_versionMd5 = paramContentValues.getAsString("versionMd5");
      if (paramBoolean) {
        this.jMu = true;
      }
    }
    if (paramContentValues.containsKey("NewMd5"))
    {
      this.field_NewMd5 = paramContentValues.getAsString("NewMd5");
      if (paramBoolean) {
        this.jMC = true;
      }
    }
    if (paramContentValues.containsKey("pkgPath"))
    {
      this.field_pkgPath = paramContentValues.getAsString("pkgPath");
      if (paramBoolean) {
        this.jMD = true;
      }
    }
    if (paramContentValues.containsKey("createTime"))
    {
      this.field_createTime = paramContentValues.getAsLong("createTime").longValue();
      if (paramBoolean) {
        this.__hadSetcreateTime = true;
      }
    }
    if (paramContentValues.containsKey("debugType"))
    {
      this.field_debugType = paramContentValues.getAsInteger("debugType").intValue();
      if (paramBoolean) {
        this.jME = true;
      }
    }
    if (paramContentValues.containsKey("downloadURL"))
    {
      this.field_downloadURL = paramContentValues.getAsString("downloadURL");
      if (paramBoolean) {
        this.jMF = true;
      }
    }
    if (paramContentValues.containsKey("startTime"))
    {
      this.field_startTime = paramContentValues.getAsLong("startTime").longValue();
      if (paramBoolean) {
        this.jIR = true;
      }
    }
    if (paramContentValues.containsKey("endTime"))
    {
      this.field_endTime = paramContentValues.getAsLong("endTime").longValue();
      if (paramBoolean) {
        this.jIS = true;
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
      if (jMG == k) {
        this.field_version = paramCursor.getInt(i);
      } else if (jMv == k) {
        this.field_versionMd5 = paramCursor.getString(i);
      } else if (jMH == k) {
        this.field_NewMd5 = paramCursor.getString(i);
      } else if (jMI == k) {
        this.field_pkgPath = paramCursor.getString(i);
      } else if (createTime_HASHCODE == k) {
        this.field_createTime = paramCursor.getLong(i);
      } else if (jMJ == k) {
        this.field_debugType = paramCursor.getInt(i);
      } else if (jMK == k) {
        this.field_downloadURL = paramCursor.getString(i);
      } else if (jIY == k) {
        this.field_startTime = paramCursor.getLong(i);
      } else if (jIZ == k) {
        this.field_endTime = paramCursor.getLong(i);
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
    if (this.jMB) {
      localContentValues.put("version", Integer.valueOf(this.field_version));
    }
    if (this.jMu) {
      localContentValues.put("versionMd5", this.field_versionMd5);
    }
    if (this.jMC) {
      localContentValues.put("NewMd5", this.field_NewMd5);
    }
    if (this.jMD) {
      localContentValues.put("pkgPath", this.field_pkgPath);
    }
    if (this.__hadSetcreateTime) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.jME) {
      localContentValues.put("debugType", Integer.valueOf(this.field_debugType));
    }
    if (this.jMF) {
      localContentValues.put("downloadURL", this.field_downloadURL);
    }
    if (this.jIR) {
      localContentValues.put("startTime", Long.valueOf(this.field_startTime));
    }
    if (this.jIS) {
      localContentValues.put("endTime", Long.valueOf(this.field_endTime));
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
  
  public StorageObserverOwner<? extends x> getObserverOwner()
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
 * Qualified Name:     com.tencent.mm.autogen.b.x
 * JD-Core Version:    0.7.0.1
 */