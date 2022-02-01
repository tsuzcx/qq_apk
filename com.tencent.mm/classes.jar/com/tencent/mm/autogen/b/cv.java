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

public abstract class cv
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("FinderLiveNotifyExposureInfo");
  public static final Column jIo;
  private static final int jIw;
  public static final Column jJF;
  private static final int jKd;
  private static final int kmL;
  public static final Column kmr;
  public static final Column knm;
  private static final int koI;
  public static final Column krn;
  private static final int krv;
  private static final int ksI;
  private static final int ksJ;
  private static final int ksK;
  private static final int ksL;
  private static final int ksM;
  private static final int ksN;
  private static final int ksO;
  private static final int ksP;
  public static final Column kss;
  public static final Column kst;
  public static final Column ksu;
  public static final Column ksv;
  public static final Column ksw;
  public static final Column ksx;
  public static final Column ksy;
  public static final Column ksz;
  private static final StorageObserverOwner<cv> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  public byte[] field_businessBuf;
  public String field_bypInfo;
  public int field_controlFlag;
  public int field_ctrlInfoType;
  public int field_exposureStatus;
  public String field_feedId;
  public String field_forcePushId;
  public long field_insertTime;
  public String field_liveId;
  public int field_liveStatus;
  public long field_msgId;
  public String field_revokeId;
  public String field_tipsId;
  private boolean jIs = true;
  private boolean jJR = true;
  private boolean kmB = true;
  private boolean knX = true;
  private boolean krr = true;
  private boolean ksA = true;
  private boolean ksB = true;
  private boolean ksC = true;
  private boolean ksD = true;
  private boolean ksE = true;
  private boolean ksF = true;
  private boolean ksG = true;
  private boolean ksH = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    kss = new Column("revokeId", "string", TABLE.getName(), "");
    jIo = new Column("msgId", "long", TABLE.getName(), "");
    kst = new Column("exposureStatus", "int", TABLE.getName(), "");
    knm = new Column("liveStatus", "int", TABLE.getName(), "");
    ksu = new Column("businessBuf", "byte[]", TABLE.getName(), "");
    ksv = new Column("insertTime", "long", TABLE.getName(), "");
    jJF = new Column("tipsId", "string", TABLE.getName(), "");
    krn = new Column("liveId", "string", TABLE.getName(), "");
    ksw = new Column("controlFlag", "int", TABLE.getName(), "");
    ksx = new Column("forcePushId", "string", TABLE.getName(), "");
    ksy = new Column("ctrlInfoType", "int", TABLE.getName(), "");
    ksz = new Column("bypInfo", "string", TABLE.getName(), "");
    kmr = new Column("feedId", "string", TABLE.getName(), "");
    INDEX_CREATE = new String[] { "CREATE INDEX IF NOT EXISTS FinderLiveNotifyExposureInfo_revokeId_index ON FinderLiveNotifyExposureInfo(revokeId)", "CREATE INDEX IF NOT EXISTS FinderLiveNotifyExposureInfo_msgId_index ON FinderLiveNotifyExposureInfo(msgId)", "CREATE INDEX IF NOT EXISTS FinderLiveNotifyExposureInfo_liveId ON FinderLiveNotifyExposureInfo(liveId)" };
    ksI = "revokeId".hashCode();
    jIw = "msgId".hashCode();
    ksJ = "exposureStatus".hashCode();
    koI = "liveStatus".hashCode();
    ksK = "businessBuf".hashCode();
    ksL = "insertTime".hashCode();
    jKd = "tipsId".hashCode();
    krv = "liveId".hashCode();
    ksM = "controlFlag".hashCode();
    ksN = "forcePushId".hashCode();
    ksO = "ctrlInfoType".hashCode();
    ksP = "bypInfo".hashCode();
    kmL = "feedId".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[13];
    localMAutoDBInfo.columns = new String[14];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "revokeId";
    localMAutoDBInfo.colsMap.put("revokeId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" revokeId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "revokeId";
    localMAutoDBInfo.columns[1] = "msgId";
    localMAutoDBInfo.colsMap.put("msgId", "LONG");
    localStringBuilder.append(" msgId LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "exposureStatus";
    localMAutoDBInfo.colsMap.put("exposureStatus", "INTEGER default '0' ");
    localStringBuilder.append(" exposureStatus INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "liveStatus";
    localMAutoDBInfo.colsMap.put("liveStatus", "INTEGER default '1' ");
    localStringBuilder.append(" liveStatus INTEGER default '1' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "businessBuf";
    localMAutoDBInfo.colsMap.put("businessBuf", "BLOB");
    localStringBuilder.append(" businessBuf BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "insertTime";
    localMAutoDBInfo.colsMap.put("insertTime", "LONG");
    localStringBuilder.append(" insertTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "tipsId";
    localMAutoDBInfo.colsMap.put("tipsId", "TEXT");
    localStringBuilder.append(" tipsId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "liveId";
    localMAutoDBInfo.colsMap.put("liveId", "TEXT");
    localStringBuilder.append(" liveId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "controlFlag";
    localMAutoDBInfo.colsMap.put("controlFlag", "INTEGER");
    localStringBuilder.append(" controlFlag INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "forcePushId";
    localMAutoDBInfo.colsMap.put("forcePushId", "TEXT");
    localStringBuilder.append(" forcePushId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[10] = "ctrlInfoType";
    localMAutoDBInfo.colsMap.put("ctrlInfoType", "INTEGER default '0' ");
    localStringBuilder.append(" ctrlInfoType INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[11] = "bypInfo";
    localMAutoDBInfo.colsMap.put("bypInfo", "TEXT");
    localStringBuilder.append(" bypInfo TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[12] = "feedId";
    localMAutoDBInfo.colsMap.put("feedId", "TEXT");
    localStringBuilder.append(" feedId TEXT");
    localMAutoDBInfo.columns[13] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("revokeId"))
    {
      this.field_revokeId = paramContentValues.getAsString("revokeId");
      if (paramBoolean) {
        this.ksA = true;
      }
    }
    if (paramContentValues.containsKey("msgId"))
    {
      this.field_msgId = paramContentValues.getAsLong("msgId").longValue();
      if (paramBoolean) {
        this.jIs = true;
      }
    }
    if (paramContentValues.containsKey("exposureStatus"))
    {
      this.field_exposureStatus = paramContentValues.getAsInteger("exposureStatus").intValue();
      if (paramBoolean) {
        this.ksB = true;
      }
    }
    if (paramContentValues.containsKey("liveStatus"))
    {
      this.field_liveStatus = paramContentValues.getAsInteger("liveStatus").intValue();
      if (paramBoolean) {
        this.knX = true;
      }
    }
    if (paramContentValues.containsKey("businessBuf"))
    {
      this.field_businessBuf = paramContentValues.getAsByteArray("businessBuf");
      if (paramBoolean) {
        this.ksC = true;
      }
    }
    if (paramContentValues.containsKey("insertTime"))
    {
      this.field_insertTime = paramContentValues.getAsLong("insertTime").longValue();
      if (paramBoolean) {
        this.ksD = true;
      }
    }
    if (paramContentValues.containsKey("tipsId"))
    {
      this.field_tipsId = paramContentValues.getAsString("tipsId");
      if (paramBoolean) {
        this.jJR = true;
      }
    }
    if (paramContentValues.containsKey("liveId"))
    {
      this.field_liveId = paramContentValues.getAsString("liveId");
      if (paramBoolean) {
        this.krr = true;
      }
    }
    if (paramContentValues.containsKey("controlFlag"))
    {
      this.field_controlFlag = paramContentValues.getAsInteger("controlFlag").intValue();
      if (paramBoolean) {
        this.ksE = true;
      }
    }
    if (paramContentValues.containsKey("forcePushId"))
    {
      this.field_forcePushId = paramContentValues.getAsString("forcePushId");
      if (paramBoolean) {
        this.ksF = true;
      }
    }
    if (paramContentValues.containsKey("ctrlInfoType"))
    {
      this.field_ctrlInfoType = paramContentValues.getAsInteger("ctrlInfoType").intValue();
      if (paramBoolean) {
        this.ksG = true;
      }
    }
    if (paramContentValues.containsKey("bypInfo"))
    {
      this.field_bypInfo = paramContentValues.getAsString("bypInfo");
      if (paramBoolean) {
        this.ksH = true;
      }
    }
    if (paramContentValues.containsKey("feedId"))
    {
      this.field_feedId = paramContentValues.getAsString("feedId");
      if (paramBoolean) {
        this.kmB = true;
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
      if (ksI != k) {
        break label65;
      }
      this.field_revokeId = paramCursor.getString(i);
      this.ksA = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (jIw == k) {
        this.field_msgId = paramCursor.getLong(i);
      } else if (ksJ == k) {
        this.field_exposureStatus = paramCursor.getInt(i);
      } else if (koI == k) {
        this.field_liveStatus = paramCursor.getInt(i);
      } else if (ksK == k) {
        this.field_businessBuf = paramCursor.getBlob(i);
      } else if (ksL == k) {
        this.field_insertTime = paramCursor.getLong(i);
      } else if (jKd == k) {
        this.field_tipsId = paramCursor.getString(i);
      } else if (krv == k) {
        this.field_liveId = paramCursor.getString(i);
      } else if (ksM == k) {
        this.field_controlFlag = paramCursor.getInt(i);
      } else if (ksN == k) {
        this.field_forcePushId = paramCursor.getString(i);
      } else if (ksO == k) {
        this.field_ctrlInfoType = paramCursor.getInt(i);
      } else if (ksP == k) {
        this.field_bypInfo = paramCursor.getString(i);
      } else if (kmL == k) {
        this.field_feedId = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.ksA) {
      localContentValues.put("revokeId", this.field_revokeId);
    }
    if (this.jIs) {
      localContentValues.put("msgId", Long.valueOf(this.field_msgId));
    }
    if (this.ksB) {
      localContentValues.put("exposureStatus", Integer.valueOf(this.field_exposureStatus));
    }
    if (this.knX) {
      localContentValues.put("liveStatus", Integer.valueOf(this.field_liveStatus));
    }
    if (this.ksC) {
      localContentValues.put("businessBuf", this.field_businessBuf);
    }
    if (this.ksD) {
      localContentValues.put("insertTime", Long.valueOf(this.field_insertTime));
    }
    if (this.jJR) {
      localContentValues.put("tipsId", this.field_tipsId);
    }
    if (this.krr) {
      localContentValues.put("liveId", this.field_liveId);
    }
    if (this.ksE) {
      localContentValues.put("controlFlag", Integer.valueOf(this.field_controlFlag));
    }
    if (this.ksF) {
      localContentValues.put("forcePushId", this.field_forcePushId);
    }
    if (this.ksG) {
      localContentValues.put("ctrlInfoType", Integer.valueOf(this.field_ctrlInfoType));
    }
    if (this.ksH) {
      localContentValues.put("bypInfo", this.field_bypInfo);
    }
    if (this.kmB) {
      localContentValues.put("feedId", this.field_feedId);
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
  
  public StorageObserverOwner<? extends cv> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return this.field_revokeId;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.autogen.b.cv
 * JD-Core Version:    0.7.0.1
 */