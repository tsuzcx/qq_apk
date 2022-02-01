package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class hh
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("VideoEditInfo");
  public static final Column hMZ;
  public static final Column hTJ;
  public static final Column hTK;
  public static final Column hTL;
  private static final int hUh;
  private static final int hUi;
  private static final int hUj;
  public static final Column hVm;
  private static final int hVu;
  private static final int hYI;
  public static final Column hYo;
  private static final int hmC;
  public static final Column hmw;
  public static final Column iAl;
  public static final Column iAn;
  public static final Column iAo;
  private static final int iAq;
  private static final int iAs = "mixFlag".hashCode();
  private static final int iAt;
  private static final int iCG;
  private static final int iCH;
  private static final int iCI;
  private static final int iCJ;
  private static final int iCK;
  private static final int iCL;
  private static final int iCM;
  private static final int iCN;
  private static final int iCO;
  private static final int iCP = "blurBgPath".hashCode();
  private static final int iCQ = "fromScene".hashCode();
  public static final Column iCh;
  public static final Column iCi;
  public static final Column iCj;
  public static final Column iCk;
  public static final Column iCl;
  public static final Column iCm;
  public static final Column iCn;
  public static final Column iCo;
  public static final Column iCp;
  public static final Column iCq;
  public static final Column iCr;
  private static final int ijb;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public int field_audioBitrate;
  public int field_audioChannelCount;
  public int field_audioSampleRate;
  public byte[] field_baseItemData;
  public String field_blurBgPath;
  public long field_expiredTime;
  public byte[] field_extraConfig;
  public int field_frameRate;
  public int field_fromScene;
  public byte[] field_location;
  public int field_mixFlag;
  public int field_mixRetryTime;
  public String field_reportInfo;
  public int field_status;
  public int field_targetHeight;
  public int field_targetWidth;
  public String field_taskId;
  public long field_timeStamp;
  public String field_userData;
  public int field_videoBitrate;
  public int field_videoRotate;
  private boolean hTV = true;
  private boolean hTW = true;
  private boolean hTX = true;
  private boolean hVq = true;
  private boolean hYy = true;
  private boolean hmz = true;
  private boolean iCA = true;
  private boolean iCB = true;
  private boolean iCC = true;
  private boolean iCD = true;
  private boolean iCE = true;
  private boolean iCF = true;
  private boolean iCs = true;
  private boolean iCt = true;
  private boolean iCu = true;
  private boolean iCv = true;
  private boolean iCw = true;
  private boolean iCx = true;
  private boolean iCy = true;
  private boolean iCz = true;
  private boolean iiW = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "VideoEditInfo", "");
    hYo = new Column("taskid", "string", "VideoEditInfo", "");
    iAl = new Column("baseitemdata", "byte[]", "VideoEditInfo", "");
    hMZ = new Column("timestamp", "long", "VideoEditInfo", "");
    iAo = new Column("mixretrytime", "int", "VideoEditInfo", "");
    hVm = new Column("expiredtime", "long", "VideoEditInfo", "");
    hmw = new Column("status", "int", "VideoEditInfo", "");
    iCh = new Column("targetwidth", "int", "VideoEditInfo", "");
    iCi = new Column("targetheight", "int", "VideoEditInfo", "");
    hTJ = new Column("videobitrate", "int", "VideoEditInfo", "");
    hTK = new Column("audiobitrate", "int", "VideoEditInfo", "");
    iCj = new Column("audiosamplerate", "int", "VideoEditInfo", "");
    iCk = new Column("audiochannelcount", "int", "VideoEditInfo", "");
    hTL = new Column("framerate", "int", "VideoEditInfo", "");
    iCl = new Column("videorotate", "int", "VideoEditInfo", "");
    iCm = new Column("extraconfig", "byte[]", "VideoEditInfo", "");
    iCn = new Column("reportinfo", "string", "VideoEditInfo", "");
    iCo = new Column("userdata", "string", "VideoEditInfo", "");
    iCp = new Column("location", "byte[]", "VideoEditInfo", "");
    iAn = new Column("mixflag", "int", "VideoEditInfo", "");
    iCq = new Column("blurbgpath", "string", "VideoEditInfo", "");
    iCr = new Column("fromscene", "int", "VideoEditInfo", "");
    hYI = "taskId".hashCode();
    iAq = "baseItemData".hashCode();
    ijb = "timeStamp".hashCode();
    iAt = "mixRetryTime".hashCode();
    hVu = "expiredTime".hashCode();
    hmC = "status".hashCode();
    iCG = "targetWidth".hashCode();
    iCH = "targetHeight".hashCode();
    hUh = "videoBitrate".hashCode();
    hUi = "audioBitrate".hashCode();
    iCI = "audioSampleRate".hashCode();
    iCJ = "audioChannelCount".hashCode();
    hUj = "frameRate".hashCode();
    iCK = "videoRotate".hashCode();
    iCL = "extraConfig".hashCode();
    iCM = "reportInfo".hashCode();
    iCN = "userData".hashCode();
    iCO = "location".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aoY()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[21];
    localMAutoDBInfo.columns = new String[22];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "taskId";
    localMAutoDBInfo.colsMap.put("taskId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" taskId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "taskId";
    localMAutoDBInfo.columns[1] = "baseItemData";
    localMAutoDBInfo.colsMap.put("baseItemData", "BLOB");
    localStringBuilder.append(" baseItemData BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "timeStamp";
    localMAutoDBInfo.colsMap.put("timeStamp", "LONG");
    localStringBuilder.append(" timeStamp LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "mixRetryTime";
    localMAutoDBInfo.colsMap.put("mixRetryTime", "INTEGER");
    localStringBuilder.append(" mixRetryTime INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "expiredTime";
    localMAutoDBInfo.colsMap.put("expiredTime", "LONG");
    localStringBuilder.append(" expiredTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "status";
    localMAutoDBInfo.colsMap.put("status", "INTEGER");
    localStringBuilder.append(" status INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "targetWidth";
    localMAutoDBInfo.colsMap.put("targetWidth", "INTEGER");
    localStringBuilder.append(" targetWidth INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "targetHeight";
    localMAutoDBInfo.colsMap.put("targetHeight", "INTEGER");
    localStringBuilder.append(" targetHeight INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "videoBitrate";
    localMAutoDBInfo.colsMap.put("videoBitrate", "INTEGER");
    localStringBuilder.append(" videoBitrate INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "audioBitrate";
    localMAutoDBInfo.colsMap.put("audioBitrate", "INTEGER");
    localStringBuilder.append(" audioBitrate INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[10] = "audioSampleRate";
    localMAutoDBInfo.colsMap.put("audioSampleRate", "INTEGER");
    localStringBuilder.append(" audioSampleRate INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[11] = "audioChannelCount";
    localMAutoDBInfo.colsMap.put("audioChannelCount", "INTEGER");
    localStringBuilder.append(" audioChannelCount INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[12] = "frameRate";
    localMAutoDBInfo.colsMap.put("frameRate", "INTEGER");
    localStringBuilder.append(" frameRate INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[13] = "videoRotate";
    localMAutoDBInfo.colsMap.put("videoRotate", "INTEGER");
    localStringBuilder.append(" videoRotate INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[14] = "extraConfig";
    localMAutoDBInfo.colsMap.put("extraConfig", "BLOB");
    localStringBuilder.append(" extraConfig BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[15] = "reportInfo";
    localMAutoDBInfo.colsMap.put("reportInfo", "TEXT");
    localStringBuilder.append(" reportInfo TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[16] = "userData";
    localMAutoDBInfo.colsMap.put("userData", "TEXT");
    localStringBuilder.append(" userData TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[17] = "location";
    localMAutoDBInfo.colsMap.put("location", "BLOB");
    localStringBuilder.append(" location BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[18] = "mixFlag";
    localMAutoDBInfo.colsMap.put("mixFlag", "INTEGER");
    localStringBuilder.append(" mixFlag INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[19] = "blurBgPath";
    localMAutoDBInfo.colsMap.put("blurBgPath", "TEXT");
    localStringBuilder.append(" blurBgPath TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[20] = "fromScene";
    localMAutoDBInfo.colsMap.put("fromScene", "INTEGER");
    localStringBuilder.append(" fromScene INTEGER");
    localMAutoDBInfo.columns[21] = "rowid";
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
      if (hYI != k) {
        break label65;
      }
      this.field_taskId = paramCursor.getString(i);
      this.hYy = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (iAq == k) {
        this.field_baseItemData = paramCursor.getBlob(i);
      } else if (ijb == k) {
        this.field_timeStamp = paramCursor.getLong(i);
      } else if (iAt == k) {
        this.field_mixRetryTime = paramCursor.getInt(i);
      } else if (hVu == k) {
        this.field_expiredTime = paramCursor.getLong(i);
      } else if (hmC == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (iCG == k) {
        this.field_targetWidth = paramCursor.getInt(i);
      } else if (iCH == k) {
        this.field_targetHeight = paramCursor.getInt(i);
      } else if (hUh == k) {
        this.field_videoBitrate = paramCursor.getInt(i);
      } else if (hUi == k) {
        this.field_audioBitrate = paramCursor.getInt(i);
      } else if (iCI == k) {
        this.field_audioSampleRate = paramCursor.getInt(i);
      } else if (iCJ == k) {
        this.field_audioChannelCount = paramCursor.getInt(i);
      } else if (hUj == k) {
        this.field_frameRate = paramCursor.getInt(i);
      } else if (iCK == k) {
        this.field_videoRotate = paramCursor.getInt(i);
      } else if (iCL == k) {
        this.field_extraConfig = paramCursor.getBlob(i);
      } else if (iCM == k) {
        this.field_reportInfo = paramCursor.getString(i);
      } else if (iCN == k) {
        this.field_userData = paramCursor.getString(i);
      } else if (iCO == k) {
        this.field_location = paramCursor.getBlob(i);
      } else if (iAs == k) {
        this.field_mixFlag = paramCursor.getInt(i);
      } else if (iCP == k) {
        this.field_blurBgPath = paramCursor.getString(i);
      } else if (iCQ == k) {
        this.field_fromScene = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.hYy) {
      localContentValues.put("taskId", this.field_taskId);
    }
    if (this.iCs) {
      localContentValues.put("baseItemData", this.field_baseItemData);
    }
    if (this.iiW) {
      localContentValues.put("timeStamp", Long.valueOf(this.field_timeStamp));
    }
    if (this.iCt) {
      localContentValues.put("mixRetryTime", Integer.valueOf(this.field_mixRetryTime));
    }
    if (this.hVq) {
      localContentValues.put("expiredTime", Long.valueOf(this.field_expiredTime));
    }
    if (this.hmz) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.iCu) {
      localContentValues.put("targetWidth", Integer.valueOf(this.field_targetWidth));
    }
    if (this.iCv) {
      localContentValues.put("targetHeight", Integer.valueOf(this.field_targetHeight));
    }
    if (this.hTV) {
      localContentValues.put("videoBitrate", Integer.valueOf(this.field_videoBitrate));
    }
    if (this.hTW) {
      localContentValues.put("audioBitrate", Integer.valueOf(this.field_audioBitrate));
    }
    if (this.iCw) {
      localContentValues.put("audioSampleRate", Integer.valueOf(this.field_audioSampleRate));
    }
    if (this.iCx) {
      localContentValues.put("audioChannelCount", Integer.valueOf(this.field_audioChannelCount));
    }
    if (this.hTX) {
      localContentValues.put("frameRate", Integer.valueOf(this.field_frameRate));
    }
    if (this.iCy) {
      localContentValues.put("videoRotate", Integer.valueOf(this.field_videoRotate));
    }
    if (this.iCz) {
      localContentValues.put("extraConfig", this.field_extraConfig);
    }
    if (this.iCA) {
      localContentValues.put("reportInfo", this.field_reportInfo);
    }
    if (this.iCB) {
      localContentValues.put("userData", this.field_userData);
    }
    if (this.iCC) {
      localContentValues.put("location", this.field_location);
    }
    if (this.iCD) {
      localContentValues.put("mixFlag", Integer.valueOf(this.field_mixFlag));
    }
    if (this.iCE) {
      localContentValues.put("blurBgPath", this.field_blurBgPath);
    }
    if (this.iCF) {
      localContentValues.put("fromScene", Integer.valueOf(this.field_fromScene));
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
    return "VideoEditInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.c.hh
 * JD-Core Version:    0.7.0.1
 */