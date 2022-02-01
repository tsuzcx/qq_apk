package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class ge
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eIC;
  private static final int eKa = "taskId".hashCode();
  private static final int eQG;
  private static final int elV;
  private static final int fbR = "baseItemData".hashCode();
  private static final int fbT = "mixFlag".hashCode();
  private static final int fbU;
  private static final int fdA;
  private static final int fdB;
  private static final int fdC;
  private static final int fdD;
  private static final int fdE = "blurBgPath".hashCode();
  private static final int fdF = "fromScene".hashCode();
  private static final int fds;
  private static final int fdt;
  private static final int fdu;
  private static final int fdv;
  private static final int fdw;
  private static final int fdx;
  private static final int fdy;
  private static final int fdz;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eIq = true;
  private boolean eJR = true;
  private boolean eQA = true;
  private boolean elS = true;
  private boolean fbM = true;
  private boolean fbO = true;
  private boolean fbP = true;
  private boolean fde = true;
  private boolean fdf = true;
  private boolean fdg = true;
  private boolean fdh = true;
  private boolean fdi = true;
  private boolean fdj = true;
  private boolean fdk = true;
  private boolean fdl = true;
  private boolean fdm = true;
  private boolean fdn = true;
  private boolean fdo = true;
  private boolean fdp = true;
  private boolean fdq = true;
  private boolean fdr = true;
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
  
  static
  {
    eQG = "timeStamp".hashCode();
    fbU = "mixRetryTime".hashCode();
    eIC = "expiredTime".hashCode();
    elV = "status".hashCode();
    fds = "targetWidth".hashCode();
    fdt = "targetHeight".hashCode();
    fdu = "videoBitrate".hashCode();
    fdv = "audioBitrate".hashCode();
    fdw = "audioSampleRate".hashCode();
    fdx = "audioChannelCount".hashCode();
    fdy = "frameRate".hashCode();
    fdz = "videoRotate".hashCode();
    fdA = "extraConfig".hashCode();
    fdB = "reportInfo".hashCode();
    fdC = "userData".hashCode();
    fdD = "location".hashCode();
  }
  
  public static c.a Th()
  {
    c.a locala = new c.a();
    locala.GvF = new Field[21];
    locala.columns = new String[22];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "taskId";
    locala.GvH.put("taskId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" taskId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.GvG = "taskId";
    locala.columns[1] = "baseItemData";
    locala.GvH.put("baseItemData", "BLOB");
    localStringBuilder.append(" baseItemData BLOB");
    localStringBuilder.append(", ");
    locala.columns[2] = "timeStamp";
    locala.GvH.put("timeStamp", "LONG");
    localStringBuilder.append(" timeStamp LONG");
    localStringBuilder.append(", ");
    locala.columns[3] = "mixRetryTime";
    locala.GvH.put("mixRetryTime", "INTEGER");
    localStringBuilder.append(" mixRetryTime INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "expiredTime";
    locala.GvH.put("expiredTime", "LONG");
    localStringBuilder.append(" expiredTime LONG");
    localStringBuilder.append(", ");
    locala.columns[5] = "status";
    locala.GvH.put("status", "INTEGER");
    localStringBuilder.append(" status INTEGER");
    localStringBuilder.append(", ");
    locala.columns[6] = "targetWidth";
    locala.GvH.put("targetWidth", "INTEGER");
    localStringBuilder.append(" targetWidth INTEGER");
    localStringBuilder.append(", ");
    locala.columns[7] = "targetHeight";
    locala.GvH.put("targetHeight", "INTEGER");
    localStringBuilder.append(" targetHeight INTEGER");
    localStringBuilder.append(", ");
    locala.columns[8] = "videoBitrate";
    locala.GvH.put("videoBitrate", "INTEGER");
    localStringBuilder.append(" videoBitrate INTEGER");
    localStringBuilder.append(", ");
    locala.columns[9] = "audioBitrate";
    locala.GvH.put("audioBitrate", "INTEGER");
    localStringBuilder.append(" audioBitrate INTEGER");
    localStringBuilder.append(", ");
    locala.columns[10] = "audioSampleRate";
    locala.GvH.put("audioSampleRate", "INTEGER");
    localStringBuilder.append(" audioSampleRate INTEGER");
    localStringBuilder.append(", ");
    locala.columns[11] = "audioChannelCount";
    locala.GvH.put("audioChannelCount", "INTEGER");
    localStringBuilder.append(" audioChannelCount INTEGER");
    localStringBuilder.append(", ");
    locala.columns[12] = "frameRate";
    locala.GvH.put("frameRate", "INTEGER");
    localStringBuilder.append(" frameRate INTEGER");
    localStringBuilder.append(", ");
    locala.columns[13] = "videoRotate";
    locala.GvH.put("videoRotate", "INTEGER");
    localStringBuilder.append(" videoRotate INTEGER");
    localStringBuilder.append(", ");
    locala.columns[14] = "extraConfig";
    locala.GvH.put("extraConfig", "BLOB");
    localStringBuilder.append(" extraConfig BLOB");
    localStringBuilder.append(", ");
    locala.columns[15] = "reportInfo";
    locala.GvH.put("reportInfo", "TEXT");
    localStringBuilder.append(" reportInfo TEXT");
    localStringBuilder.append(", ");
    locala.columns[16] = "userData";
    locala.GvH.put("userData", "TEXT");
    localStringBuilder.append(" userData TEXT");
    localStringBuilder.append(", ");
    locala.columns[17] = "location";
    locala.GvH.put("location", "BLOB");
    localStringBuilder.append(" location BLOB");
    localStringBuilder.append(", ");
    locala.columns[18] = "mixFlag";
    locala.GvH.put("mixFlag", "INTEGER");
    localStringBuilder.append(" mixFlag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[19] = "blurBgPath";
    locala.GvH.put("blurBgPath", "TEXT");
    localStringBuilder.append(" blurBgPath TEXT");
    localStringBuilder.append(", ");
    locala.columns[20] = "fromScene";
    locala.GvH.put("fromScene", "INTEGER");
    localStringBuilder.append(" fromScene INTEGER");
    locala.columns[21] = "rowid";
    locala.sql = localStringBuilder.toString();
    return locala;
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
      if (eKa != k) {
        break label65;
      }
      this.field_taskId = paramCursor.getString(i);
      this.eJR = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fbR == k) {
        this.field_baseItemData = paramCursor.getBlob(i);
      } else if (eQG == k) {
        this.field_timeStamp = paramCursor.getLong(i);
      } else if (fbU == k) {
        this.field_mixRetryTime = paramCursor.getInt(i);
      } else if (eIC == k) {
        this.field_expiredTime = paramCursor.getLong(i);
      } else if (elV == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (fds == k) {
        this.field_targetWidth = paramCursor.getInt(i);
      } else if (fdt == k) {
        this.field_targetHeight = paramCursor.getInt(i);
      } else if (fdu == k) {
        this.field_videoBitrate = paramCursor.getInt(i);
      } else if (fdv == k) {
        this.field_audioBitrate = paramCursor.getInt(i);
      } else if (fdw == k) {
        this.field_audioSampleRate = paramCursor.getInt(i);
      } else if (fdx == k) {
        this.field_audioChannelCount = paramCursor.getInt(i);
      } else if (fdy == k) {
        this.field_frameRate = paramCursor.getInt(i);
      } else if (fdz == k) {
        this.field_videoRotate = paramCursor.getInt(i);
      } else if (fdA == k) {
        this.field_extraConfig = paramCursor.getBlob(i);
      } else if (fdB == k) {
        this.field_reportInfo = paramCursor.getString(i);
      } else if (fdC == k) {
        this.field_userData = paramCursor.getString(i);
      } else if (fdD == k) {
        this.field_location = paramCursor.getBlob(i);
      } else if (fbT == k) {
        this.field_mixFlag = paramCursor.getInt(i);
      } else if (fdE == k) {
        this.field_blurBgPath = paramCursor.getString(i);
      } else if (fdF == k) {
        this.field_fromScene = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eJR) {
      localContentValues.put("taskId", this.field_taskId);
    }
    if (this.fbM) {
      localContentValues.put("baseItemData", this.field_baseItemData);
    }
    if (this.eQA) {
      localContentValues.put("timeStamp", Long.valueOf(this.field_timeStamp));
    }
    if (this.fbP) {
      localContentValues.put("mixRetryTime", Integer.valueOf(this.field_mixRetryTime));
    }
    if (this.eIq) {
      localContentValues.put("expiredTime", Long.valueOf(this.field_expiredTime));
    }
    if (this.elS) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.fde) {
      localContentValues.put("targetWidth", Integer.valueOf(this.field_targetWidth));
    }
    if (this.fdf) {
      localContentValues.put("targetHeight", Integer.valueOf(this.field_targetHeight));
    }
    if (this.fdg) {
      localContentValues.put("videoBitrate", Integer.valueOf(this.field_videoBitrate));
    }
    if (this.fdh) {
      localContentValues.put("audioBitrate", Integer.valueOf(this.field_audioBitrate));
    }
    if (this.fdi) {
      localContentValues.put("audioSampleRate", Integer.valueOf(this.field_audioSampleRate));
    }
    if (this.fdj) {
      localContentValues.put("audioChannelCount", Integer.valueOf(this.field_audioChannelCount));
    }
    if (this.fdk) {
      localContentValues.put("frameRate", Integer.valueOf(this.field_frameRate));
    }
    if (this.fdl) {
      localContentValues.put("videoRotate", Integer.valueOf(this.field_videoRotate));
    }
    if (this.fdm) {
      localContentValues.put("extraConfig", this.field_extraConfig);
    }
    if (this.fdn) {
      localContentValues.put("reportInfo", this.field_reportInfo);
    }
    if (this.fdo) {
      localContentValues.put("userData", this.field_userData);
    }
    if (this.fdp) {
      localContentValues.put("location", this.field_location);
    }
    if (this.fbO) {
      localContentValues.put("mixFlag", Integer.valueOf(this.field_mixFlag));
    }
    if (this.fdq) {
      localContentValues.put("blurBgPath", this.field_blurBgPath);
    }
    if (this.fdr) {
      localContentValues.put("fromScene", Integer.valueOf(this.field_fromScene));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.c.ge
 * JD-Core Version:    0.7.0.1
 */