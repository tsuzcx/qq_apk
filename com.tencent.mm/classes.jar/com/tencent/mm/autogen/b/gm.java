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

public abstract class gm
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("PredownloadCmdGetCodePersistentInfo2");
  public static final Column TYPE;
  private static final int jJD;
  public static final Column jJz;
  private static final int jKX;
  public static final Column jKp;
  private static final int jMG;
  public static final Column jML;
  public static final Column jMM;
  public static final Column jMP;
  private static final int jMV;
  private static final int jMW;
  private static final int jMZ;
  public static final Column jMw;
  private static final int kSA;
  public static final Column kSb;
  public static final Column kSc;
  public static final Column kSd;
  public static final Column kSe;
  public static final Column kSf;
  public static final Column kSg;
  public static final Column kSh;
  public static final Column kSi;
  private static final int kSs;
  private static final int kSt;
  private static final int kSu;
  private static final int kSv;
  private static final int kSw;
  private static final int kSx;
  private static final int kSy;
  private static final int kSz;
  public static final Column kvm;
  private static final StorageObserverOwner<gm> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  private static final int type_HASHCODE;
  private boolean __hadSettype = true;
  public String field_appId;
  public long field_cmdSequence;
  public boolean field_firstTimeTried;
  public long field_lastRetryTime;
  public int field_networkType;
  public String field_packageKey;
  public int field_packageType;
  public String field_pkgMd5;
  public int field_reportId;
  public int field_retriedCount;
  public long field_retryInterval;
  public int field_retryTimes;
  public int field_scene;
  public boolean field_splitDownloadURLCgi;
  public int field_type;
  public int field_version;
  private boolean jJB = true;
  private boolean jKG = true;
  private boolean jMB = true;
  private boolean jMQ = true;
  private boolean jMR = true;
  private boolean jMU = true;
  private boolean kSj = true;
  private boolean kSk = true;
  private boolean kSl = true;
  private boolean kSm = true;
  private boolean kSn = true;
  private boolean kSo = true;
  private boolean kSp = true;
  private boolean kSq = true;
  private boolean kSr = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    jKp = new Column("appId", "string", TABLE.getName(), "");
    jMw = new Column("version", "int", TABLE.getName(), "");
    TYPE = new Column("type", "int", TABLE.getName(), "");
    kSb = new Column("retryTimes", "int", TABLE.getName(), "");
    kSc = new Column("retriedCount", "int", TABLE.getName(), "");
    kvm = new Column("retryInterval", "long", TABLE.getName(), "");
    kSd = new Column("networkType", "int", TABLE.getName(), "");
    kSe = new Column("pkgMd5", "string", TABLE.getName(), "");
    jMM = new Column("packageKey", "string", TABLE.getName(), "");
    jML = new Column("packageType", "int", TABLE.getName(), "");
    kSf = new Column("lastRetryTime", "long", TABLE.getName(), "");
    kSg = new Column("firstTimeTried", "boolean", TABLE.getName(), "");
    jMP = new Column("reportId", "int", TABLE.getName(), "");
    kSh = new Column("splitDownloadURLCgi", "boolean", TABLE.getName(), "");
    jJz = new Column("scene", "int", TABLE.getName(), "");
    kSi = new Column("cmdSequence", "long", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    jKX = "appId".hashCode();
    jMG = "version".hashCode();
    type_HASHCODE = "type".hashCode();
    kSs = "retryTimes".hashCode();
    kSt = "retriedCount".hashCode();
    kSu = "retryInterval".hashCode();
    kSv = "networkType".hashCode();
    kSw = "pkgMd5".hashCode();
    jMW = "packageKey".hashCode();
    jMV = "packageType".hashCode();
    kSx = "lastRetryTime".hashCode();
    kSy = "firstTimeTried".hashCode();
    jMZ = "reportId".hashCode();
    kSz = "splitDownloadURLCgi".hashCode();
    jJD = "scene".hashCode();
    kSA = "cmdSequence".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[16];
    localMAutoDBInfo.columns = new String[17];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "appId";
    localMAutoDBInfo.colsMap.put("appId", "TEXT");
    localStringBuilder.append(" appId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[1] = "version";
    localMAutoDBInfo.colsMap.put("version", "INTEGER");
    localStringBuilder.append(" version INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "type";
    localMAutoDBInfo.colsMap.put("type", "INTEGER");
    localStringBuilder.append(" type INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "retryTimes";
    localMAutoDBInfo.colsMap.put("retryTimes", "INTEGER");
    localStringBuilder.append(" retryTimes INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "retriedCount";
    localMAutoDBInfo.colsMap.put("retriedCount", "INTEGER");
    localStringBuilder.append(" retriedCount INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "retryInterval";
    localMAutoDBInfo.colsMap.put("retryInterval", "LONG");
    localStringBuilder.append(" retryInterval LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "networkType";
    localMAutoDBInfo.colsMap.put("networkType", "INTEGER");
    localStringBuilder.append(" networkType INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "pkgMd5";
    localMAutoDBInfo.colsMap.put("pkgMd5", "TEXT");
    localStringBuilder.append(" pkgMd5 TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "packageKey";
    localMAutoDBInfo.colsMap.put("packageKey", "TEXT");
    localStringBuilder.append(" packageKey TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "packageType";
    localMAutoDBInfo.colsMap.put("packageType", "INTEGER default '0' ");
    localStringBuilder.append(" packageType INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[10] = "lastRetryTime";
    localMAutoDBInfo.colsMap.put("lastRetryTime", "LONG");
    localStringBuilder.append(" lastRetryTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[11] = "firstTimeTried";
    localMAutoDBInfo.colsMap.put("firstTimeTried", "INTEGER");
    localStringBuilder.append(" firstTimeTried INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[12] = "reportId";
    localMAutoDBInfo.colsMap.put("reportId", "INTEGER");
    localStringBuilder.append(" reportId INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[13] = "splitDownloadURLCgi";
    localMAutoDBInfo.colsMap.put("splitDownloadURLCgi", "INTEGER");
    localStringBuilder.append(" splitDownloadURLCgi INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[14] = "scene";
    localMAutoDBInfo.colsMap.put("scene", "INTEGER");
    localStringBuilder.append(" scene INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[15] = "cmdSequence";
    localMAutoDBInfo.colsMap.put("cmdSequence", "LONG");
    localStringBuilder.append(" cmdSequence LONG");
    localMAutoDBInfo.columns[16] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    boolean bool2 = false;
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
    if (paramContentValues.containsKey("type"))
    {
      this.field_type = paramContentValues.getAsInteger("type").intValue();
      if (paramBoolean) {
        this.__hadSettype = true;
      }
    }
    if (paramContentValues.containsKey("retryTimes"))
    {
      this.field_retryTimes = paramContentValues.getAsInteger("retryTimes").intValue();
      if (paramBoolean) {
        this.kSj = true;
      }
    }
    if (paramContentValues.containsKey("retriedCount"))
    {
      this.field_retriedCount = paramContentValues.getAsInteger("retriedCount").intValue();
      if (paramBoolean) {
        this.kSk = true;
      }
    }
    if (paramContentValues.containsKey("retryInterval"))
    {
      this.field_retryInterval = paramContentValues.getAsLong("retryInterval").longValue();
      if (paramBoolean) {
        this.kSl = true;
      }
    }
    if (paramContentValues.containsKey("networkType"))
    {
      this.field_networkType = paramContentValues.getAsInteger("networkType").intValue();
      if (paramBoolean) {
        this.kSm = true;
      }
    }
    if (paramContentValues.containsKey("pkgMd5"))
    {
      this.field_pkgMd5 = paramContentValues.getAsString("pkgMd5");
      if (paramBoolean) {
        this.kSn = true;
      }
    }
    if (paramContentValues.containsKey("packageKey"))
    {
      this.field_packageKey = paramContentValues.getAsString("packageKey");
      if (paramBoolean) {
        this.jMR = true;
      }
    }
    if (paramContentValues.containsKey("packageType"))
    {
      this.field_packageType = paramContentValues.getAsInteger("packageType").intValue();
      if (paramBoolean) {
        this.jMQ = true;
      }
    }
    if (paramContentValues.containsKey("lastRetryTime"))
    {
      this.field_lastRetryTime = paramContentValues.getAsLong("lastRetryTime").longValue();
      if (paramBoolean) {
        this.kSo = true;
      }
    }
    if (paramContentValues.containsKey("firstTimeTried")) {
      if (paramContentValues.getAsInteger("firstTimeTried").intValue() == 0) {
        break label528;
      }
    }
    label528:
    for (boolean bool1 = true;; bool1 = false)
    {
      this.field_firstTimeTried = bool1;
      if (paramBoolean) {
        this.kSp = true;
      }
      if (paramContentValues.containsKey("reportId"))
      {
        this.field_reportId = paramContentValues.getAsInteger("reportId").intValue();
        if (paramBoolean) {
          this.jMU = true;
        }
      }
      if (paramContentValues.containsKey("splitDownloadURLCgi"))
      {
        bool1 = bool2;
        if (paramContentValues.getAsInteger("splitDownloadURLCgi").intValue() != 0) {
          bool1 = true;
        }
        this.field_splitDownloadURLCgi = bool1;
        if (paramBoolean) {
          this.kSq = true;
        }
      }
      if (paramContentValues.containsKey("scene"))
      {
        this.field_scene = paramContentValues.getAsInteger("scene").intValue();
        if (paramBoolean) {
          this.jJB = true;
        }
      }
      if (paramContentValues.containsKey("cmdSequence"))
      {
        this.field_cmdSequence = paramContentValues.getAsLong("cmdSequence").longValue();
        if (paramBoolean) {
          this.kSr = true;
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
      if (jMG == k)
      {
        this.field_version = paramCursor.getInt(i);
      }
      else if (type_HASHCODE == k)
      {
        this.field_type = paramCursor.getInt(i);
      }
      else if (kSs == k)
      {
        this.field_retryTimes = paramCursor.getInt(i);
      }
      else if (kSt == k)
      {
        this.field_retriedCount = paramCursor.getInt(i);
      }
      else if (kSu == k)
      {
        this.field_retryInterval = paramCursor.getLong(i);
      }
      else if (kSv == k)
      {
        this.field_networkType = paramCursor.getInt(i);
      }
      else if (kSw == k)
      {
        this.field_pkgMd5 = paramCursor.getString(i);
      }
      else if (jMW == k)
      {
        this.field_packageKey = paramCursor.getString(i);
      }
      else if (jMV == k)
      {
        this.field_packageType = paramCursor.getInt(i);
      }
      else if (kSx == k)
      {
        this.field_lastRetryTime = paramCursor.getLong(i);
      }
      else
      {
        boolean bool;
        if (kSy == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_firstTimeTried = bool;
            break;
          }
        }
        if (jMZ == k)
        {
          this.field_reportId = paramCursor.getInt(i);
        }
        else
        {
          if (kSz == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_splitDownloadURLCgi = bool;
              break;
            }
          }
          if (jJD == k) {
            this.field_scene = paramCursor.getInt(i);
          } else if (kSA == k) {
            this.field_cmdSequence = paramCursor.getLong(i);
          } else if (rowid_HASHCODE == k) {
            this.systemRowid = paramCursor.getLong(i);
          }
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
    if (this.jMB) {
      localContentValues.put("version", Integer.valueOf(this.field_version));
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.kSj) {
      localContentValues.put("retryTimes", Integer.valueOf(this.field_retryTimes));
    }
    if (this.kSk) {
      localContentValues.put("retriedCount", Integer.valueOf(this.field_retriedCount));
    }
    if (this.kSl) {
      localContentValues.put("retryInterval", Long.valueOf(this.field_retryInterval));
    }
    if (this.kSm) {
      localContentValues.put("networkType", Integer.valueOf(this.field_networkType));
    }
    if (this.kSn) {
      localContentValues.put("pkgMd5", this.field_pkgMd5);
    }
    if (this.jMR) {
      localContentValues.put("packageKey", this.field_packageKey);
    }
    if (this.jMQ) {
      localContentValues.put("packageType", Integer.valueOf(this.field_packageType));
    }
    if (this.kSo) {
      localContentValues.put("lastRetryTime", Long.valueOf(this.field_lastRetryTime));
    }
    if (this.kSp) {
      localContentValues.put("firstTimeTried", Boolean.valueOf(this.field_firstTimeTried));
    }
    if (this.jMU) {
      localContentValues.put("reportId", Integer.valueOf(this.field_reportId));
    }
    if (this.kSq) {
      localContentValues.put("splitDownloadURLCgi", Boolean.valueOf(this.field_splitDownloadURLCgi));
    }
    if (this.jJB) {
      localContentValues.put("scene", Integer.valueOf(this.field_scene));
    }
    if (this.kSr) {
      localContentValues.put("cmdSequence", Long.valueOf(this.field_cmdSequence));
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
  
  public StorageObserverOwner<? extends gm> getObserverOwner()
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
 * Qualified Name:     com.tencent.mm.autogen.b.gm
 * JD-Core Version:    0.7.0.1
 */