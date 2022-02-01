package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class co
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS FinderLiveNotifyExposureInfo_revokeId_index ON FinderLiveNotifyExposureInfo(revokeId)", "CREATE INDEX IF NOT EXISTS FinderLiveNotifyExposureInfo_msgId_index ON FinderLiveNotifyExposureInfo(msgId)", "CREATE INDEX IF NOT EXISTS FinderLiveNotifyExposureInfo_liveId ON FinderLiveNotifyExposureInfo(liveId)" };
  public static final SingleTable TABLE = new SingleTable("FinderLiveNotifyExposureInfo");
  public static final Column hQc;
  private static final int hRe;
  public static final Column hSK;
  private static final int hSO = "liveId".hashCode();
  public static final Column hST;
  public static final Column hSU;
  public static final Column hSV;
  public static final Column hSW;
  public static final Column hSX;
  public static final Column hSY;
  public static final Column hSZ;
  public static final Column hTa;
  public static final Column hTb;
  private static final int hTl;
  private static final int hTm;
  private static final int hTn;
  private static final int hTo;
  private static final int hTp;
  private static final int hTq = "controlFlag".hashCode();
  private static final int hTr = "forcePushId".hashCode();
  private static final int hTs = "ctrlInfoType".hashCode();
  private static final int hTt = "bypInfo".hashCode();
  public static final Column hml;
  private static final int hmt;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public byte[] field_businessBuf;
  public String field_bypInfo;
  public int field_controlFlag;
  public int field_ctrlInfoType;
  public int field_exposureStatus;
  public String field_forcePushId;
  public long field_insertTime;
  public String field_liveId;
  public int field_liveStatus;
  public long field_msgId;
  public String field_revokeId;
  public String field_tipsId;
  private boolean hQD = true;
  private boolean hSM = true;
  private boolean hTc = true;
  private boolean hTd = true;
  private boolean hTe = true;
  private boolean hTf = true;
  private boolean hTg = true;
  private boolean hTh = true;
  private boolean hTi = true;
  private boolean hTj = true;
  private boolean hTk = true;
  private boolean hmp = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "FinderLiveNotifyExposureInfo", "");
    hST = new Column("revokeid", "string", "FinderLiveNotifyExposureInfo", "");
    hml = new Column("msgid", "long", "FinderLiveNotifyExposureInfo", "");
    hSU = new Column("exposurestatus", "int", "FinderLiveNotifyExposureInfo", "");
    hQc = new Column("livestatus", "int", "FinderLiveNotifyExposureInfo", "");
    hSV = new Column("businessbuf", "byte[]", "FinderLiveNotifyExposureInfo", "");
    hSW = new Column("inserttime", "long", "FinderLiveNotifyExposureInfo", "");
    hSX = new Column("tipsid", "string", "FinderLiveNotifyExposureInfo", "");
    hSK = new Column("liveid", "string", "FinderLiveNotifyExposureInfo", "");
    hSY = new Column("controlflag", "int", "FinderLiveNotifyExposureInfo", "");
    hSZ = new Column("forcepushid", "string", "FinderLiveNotifyExposureInfo", "");
    hTa = new Column("ctrlinfotype", "int", "FinderLiveNotifyExposureInfo", "");
    hTb = new Column("bypinfo", "string", "FinderLiveNotifyExposureInfo", "");
    hTl = "revokeId".hashCode();
    hmt = "msgId".hashCode();
    hTm = "exposureStatus".hashCode();
    hRe = "liveStatus".hashCode();
    hTn = "businessBuf".hashCode();
    hTo = "insertTime".hashCode();
    hTp = "tipsId".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aoY()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[12];
    localMAutoDBInfo.columns = new String[13];
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
    localMAutoDBInfo.columns[12] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    return localMAutoDBInfo;
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
      if (hTl != k) {
        break label65;
      }
      this.field_revokeId = paramCursor.getString(i);
      this.hTc = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (hmt == k) {
        this.field_msgId = paramCursor.getLong(i);
      } else if (hTm == k) {
        this.field_exposureStatus = paramCursor.getInt(i);
      } else if (hRe == k) {
        this.field_liveStatus = paramCursor.getInt(i);
      } else if (hTn == k) {
        this.field_businessBuf = paramCursor.getBlob(i);
      } else if (hTo == k) {
        this.field_insertTime = paramCursor.getLong(i);
      } else if (hTp == k) {
        this.field_tipsId = paramCursor.getString(i);
      } else if (hSO == k) {
        this.field_liveId = paramCursor.getString(i);
      } else if (hTq == k) {
        this.field_controlFlag = paramCursor.getInt(i);
      } else if (hTr == k) {
        this.field_forcePushId = paramCursor.getString(i);
      } else if (hTs == k) {
        this.field_ctrlInfoType = paramCursor.getInt(i);
      } else if (hTt == k) {
        this.field_bypInfo = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.hTc) {
      localContentValues.put("revokeId", this.field_revokeId);
    }
    if (this.hmp) {
      localContentValues.put("msgId", Long.valueOf(this.field_msgId));
    }
    if (this.hTd) {
      localContentValues.put("exposureStatus", Integer.valueOf(this.field_exposureStatus));
    }
    if (this.hQD) {
      localContentValues.put("liveStatus", Integer.valueOf(this.field_liveStatus));
    }
    if (this.hTe) {
      localContentValues.put("businessBuf", this.field_businessBuf);
    }
    if (this.hTf) {
      localContentValues.put("insertTime", Long.valueOf(this.field_insertTime));
    }
    if (this.hTg) {
      localContentValues.put("tipsId", this.field_tipsId);
    }
    if (this.hSM) {
      localContentValues.put("liveId", this.field_liveId);
    }
    if (this.hTh) {
      localContentValues.put("controlFlag", Integer.valueOf(this.field_controlFlag));
    }
    if (this.hTi) {
      localContentValues.put("forcePushId", this.field_forcePushId);
    }
    if (this.hTj) {
      localContentValues.put("ctrlInfoType", Integer.valueOf(this.field_ctrlInfoType));
    }
    if (this.hTk) {
      localContentValues.put("bypInfo", this.field_bypInfo);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
  
  public String[] getIndexCreateSQL()
  {
    return INDEX_CREATE;
  }
  
  public String getTableName()
  {
    return "FinderLiveNotifyExposureInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.c.co
 * JD-Core Version:    0.7.0.1
 */