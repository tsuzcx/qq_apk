package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class ha
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fFb;
  private static final int fFc;
  private static final int fFd;
  private static final int fGk;
  private static final int fIp = "taskId".hashCode();
  private static final int fPE;
  private static final int fjl;
  private static final int gaX = "baseItemData".hashCode();
  private static final int gaZ = "mixFlag".hashCode();
  private static final int gba;
  private static final int gcA;
  private static final int gcB;
  private static final int gcC;
  private static final int gcD;
  private static final int gcE = "blurBgPath".hashCode();
  private static final int gcF = "fromScene".hashCode();
  private static final int gcv;
  private static final int gcw;
  private static final int gcx;
  private static final int gcy;
  private static final int gcz;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean fEP = true;
  private boolean fEQ = true;
  private boolean fER = true;
  private boolean fGe = true;
  private boolean fIf = true;
  private boolean fPy = true;
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
  private boolean fji = true;
  private boolean gaS = true;
  private boolean gaU = true;
  private boolean gaV = true;
  private boolean gck = true;
  private boolean gcl = true;
  private boolean gcm = true;
  private boolean gcn = true;
  private boolean gco = true;
  private boolean gcp = true;
  private boolean gcq = true;
  private boolean gcr = true;
  private boolean gcs = true;
  private boolean gct = true;
  private boolean gcu = true;
  
  static
  {
    fPE = "timeStamp".hashCode();
    gba = "mixRetryTime".hashCode();
    fGk = "expiredTime".hashCode();
    fjl = "status".hashCode();
    gcv = "targetWidth".hashCode();
    gcw = "targetHeight".hashCode();
    fFb = "videoBitrate".hashCode();
    fFc = "audioBitrate".hashCode();
    gcx = "audioSampleRate".hashCode();
    gcy = "audioChannelCount".hashCode();
    fFd = "frameRate".hashCode();
    gcz = "videoRotate".hashCode();
    gcA = "extraConfig".hashCode();
    gcB = "reportInfo".hashCode();
    gcC = "userData".hashCode();
    gcD = "location".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo ajs()
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
      if (fIp != k) {
        break label65;
      }
      this.field_taskId = paramCursor.getString(i);
      this.fIf = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (gaX == k) {
        this.field_baseItemData = paramCursor.getBlob(i);
      } else if (fPE == k) {
        this.field_timeStamp = paramCursor.getLong(i);
      } else if (gba == k) {
        this.field_mixRetryTime = paramCursor.getInt(i);
      } else if (fGk == k) {
        this.field_expiredTime = paramCursor.getLong(i);
      } else if (fjl == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (gcv == k) {
        this.field_targetWidth = paramCursor.getInt(i);
      } else if (gcw == k) {
        this.field_targetHeight = paramCursor.getInt(i);
      } else if (fFb == k) {
        this.field_videoBitrate = paramCursor.getInt(i);
      } else if (fFc == k) {
        this.field_audioBitrate = paramCursor.getInt(i);
      } else if (gcx == k) {
        this.field_audioSampleRate = paramCursor.getInt(i);
      } else if (gcy == k) {
        this.field_audioChannelCount = paramCursor.getInt(i);
      } else if (fFd == k) {
        this.field_frameRate = paramCursor.getInt(i);
      } else if (gcz == k) {
        this.field_videoRotate = paramCursor.getInt(i);
      } else if (gcA == k) {
        this.field_extraConfig = paramCursor.getBlob(i);
      } else if (gcB == k) {
        this.field_reportInfo = paramCursor.getString(i);
      } else if (gcC == k) {
        this.field_userData = paramCursor.getString(i);
      } else if (gcD == k) {
        this.field_location = paramCursor.getBlob(i);
      } else if (gaZ == k) {
        this.field_mixFlag = paramCursor.getInt(i);
      } else if (gcE == k) {
        this.field_blurBgPath = paramCursor.getString(i);
      } else if (gcF == k) {
        this.field_fromScene = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fIf) {
      localContentValues.put("taskId", this.field_taskId);
    }
    if (this.gaS) {
      localContentValues.put("baseItemData", this.field_baseItemData);
    }
    if (this.fPy) {
      localContentValues.put("timeStamp", Long.valueOf(this.field_timeStamp));
    }
    if (this.gaV) {
      localContentValues.put("mixRetryTime", Integer.valueOf(this.field_mixRetryTime));
    }
    if (this.fGe) {
      localContentValues.put("expiredTime", Long.valueOf(this.field_expiredTime));
    }
    if (this.fji) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.gck) {
      localContentValues.put("targetWidth", Integer.valueOf(this.field_targetWidth));
    }
    if (this.gcl) {
      localContentValues.put("targetHeight", Integer.valueOf(this.field_targetHeight));
    }
    if (this.fEP) {
      localContentValues.put("videoBitrate", Integer.valueOf(this.field_videoBitrate));
    }
    if (this.fEQ) {
      localContentValues.put("audioBitrate", Integer.valueOf(this.field_audioBitrate));
    }
    if (this.gcm) {
      localContentValues.put("audioSampleRate", Integer.valueOf(this.field_audioSampleRate));
    }
    if (this.gcn) {
      localContentValues.put("audioChannelCount", Integer.valueOf(this.field_audioChannelCount));
    }
    if (this.fER) {
      localContentValues.put("frameRate", Integer.valueOf(this.field_frameRate));
    }
    if (this.gco) {
      localContentValues.put("videoRotate", Integer.valueOf(this.field_videoRotate));
    }
    if (this.gcp) {
      localContentValues.put("extraConfig", this.field_extraConfig);
    }
    if (this.gcq) {
      localContentValues.put("reportInfo", this.field_reportInfo);
    }
    if (this.gcr) {
      localContentValues.put("userData", this.field_userData);
    }
    if (this.gcs) {
      localContentValues.put("location", this.field_location);
    }
    if (this.gaU) {
      localContentValues.put("mixFlag", Integer.valueOf(this.field_mixFlag));
    }
    if (this.gct) {
      localContentValues.put("blurBgPath", this.field_blurBgPath);
    }
    if (this.gcu) {
      localContentValues.put("fromScene", Integer.valueOf(this.field_fromScene));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.ha
 * JD-Core Version:    0.7.0.1
 */