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

public abstract class y
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("AppBrandWxaPkgPreDownloadStatistics2");
  private static final int jKX;
  public static final Column jKp;
  private static final int jMG;
  public static final Column jML;
  public static final Column jMM;
  public static final Column jMN;
  public static final Column jMO;
  public static final Column jMP;
  private static final int jMV;
  private static final int jMW;
  private static final int jMX;
  private static final int jMY;
  private static final int jMZ;
  public static final Column jMw;
  private static final StorageObserverOwner<y> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  public String field_appId;
  public int field_hitCount;
  public String field_packageKey;
  public int field_packageType;
  public int field_reportId;
  public int field_source;
  public int field_version;
  private boolean jKG = true;
  private boolean jMB = true;
  private boolean jMQ = true;
  private boolean jMR = true;
  private boolean jMS = true;
  private boolean jMT = true;
  private boolean jMU = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    jKp = new Column("appId", "string", TABLE.getName(), "");
    jMw = new Column("version", "int", TABLE.getName(), "");
    jML = new Column("packageType", "int", TABLE.getName(), "");
    jMM = new Column("packageKey", "string", TABLE.getName(), "");
    jMN = new Column("source", "int", TABLE.getName(), "");
    jMO = new Column("hitCount", "int", TABLE.getName(), "");
    jMP = new Column("reportId", "int", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    jKX = "appId".hashCode();
    jMG = "version".hashCode();
    jMV = "packageType".hashCode();
    jMW = "packageKey".hashCode();
    jMX = "source".hashCode();
    jMY = "hitCount".hashCode();
    jMZ = "reportId".hashCode();
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
    localMAutoDBInfo.columns[1] = "version";
    localMAutoDBInfo.colsMap.put("version", "INTEGER");
    localStringBuilder.append(" version INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "packageType";
    localMAutoDBInfo.colsMap.put("packageType", "INTEGER");
    localStringBuilder.append(" packageType INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "packageKey";
    localMAutoDBInfo.colsMap.put("packageKey", "TEXT");
    localStringBuilder.append(" packageKey TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "source";
    localMAutoDBInfo.colsMap.put("source", "INTEGER default '0' ");
    localStringBuilder.append(" source INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "hitCount";
    localMAutoDBInfo.colsMap.put("hitCount", "INTEGER default '0' ");
    localStringBuilder.append(" hitCount INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "reportId";
    localMAutoDBInfo.colsMap.put("reportId", "INTEGER default '0' ");
    localStringBuilder.append(" reportId INTEGER default '0' ");
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
    if (paramContentValues.containsKey("version"))
    {
      this.field_version = paramContentValues.getAsInteger("version").intValue();
      if (paramBoolean) {
        this.jMB = true;
      }
    }
    if (paramContentValues.containsKey("packageType"))
    {
      this.field_packageType = paramContentValues.getAsInteger("packageType").intValue();
      if (paramBoolean) {
        this.jMQ = true;
      }
    }
    if (paramContentValues.containsKey("packageKey"))
    {
      this.field_packageKey = paramContentValues.getAsString("packageKey");
      if (paramBoolean) {
        this.jMR = true;
      }
    }
    if (paramContentValues.containsKey("source"))
    {
      this.field_source = paramContentValues.getAsInteger("source").intValue();
      if (paramBoolean) {
        this.jMS = true;
      }
    }
    if (paramContentValues.containsKey("hitCount"))
    {
      this.field_hitCount = paramContentValues.getAsInteger("hitCount").intValue();
      if (paramBoolean) {
        this.jMT = true;
      }
    }
    if (paramContentValues.containsKey("reportId"))
    {
      this.field_reportId = paramContentValues.getAsInteger("reportId").intValue();
      if (paramBoolean) {
        this.jMU = true;
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
      } else if (jMV == k) {
        this.field_packageType = paramCursor.getInt(i);
      } else if (jMW == k) {
        this.field_packageKey = paramCursor.getString(i);
      } else if (jMX == k) {
        this.field_source = paramCursor.getInt(i);
      } else if (jMY == k) {
        this.field_hitCount = paramCursor.getInt(i);
      } else if (jMZ == k) {
        this.field_reportId = paramCursor.getInt(i);
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
    if (this.jMQ) {
      localContentValues.put("packageType", Integer.valueOf(this.field_packageType));
    }
    if (this.jMR) {
      localContentValues.put("packageKey", this.field_packageKey);
    }
    if (this.jMS) {
      localContentValues.put("source", Integer.valueOf(this.field_source));
    }
    if (this.jMT) {
      localContentValues.put("hitCount", Integer.valueOf(this.field_hitCount));
    }
    if (this.jMU) {
      localContentValues.put("reportId", Integer.valueOf(this.field_reportId));
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
  
  public StorageObserverOwner<? extends y> getObserverOwner()
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
 * Qualified Name:     com.tencent.mm.autogen.b.y
 * JD-Core Version:    0.7.0.1
 */