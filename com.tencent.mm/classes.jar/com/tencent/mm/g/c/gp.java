package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class gp
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eEL;
  private static final int faW;
  private static final int faX;
  private static final int faY;
  private static final int fcD;
  private static final int fdX = "taskId".hashCode();
  private static final int fla;
  private static final int fwf = "baseItemData".hashCode();
  private static final int fwh = "mixFlag".hashCode();
  private static final int fwi;
  private static final int fxD;
  private static final int fxE;
  private static final int fxF;
  private static final int fxG;
  private static final int fxH;
  private static final int fxI;
  private static final int fxJ;
  private static final int fxK;
  private static final int fxL;
  private static final int fxM = "blurBgPath".hashCode();
  private static final int fxN = "fromScene".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eEI = true;
  private boolean faK = true;
  private boolean faL = true;
  private boolean faM = true;
  private boolean fcr = true;
  private boolean fdO = true;
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
  private boolean fkU = true;
  private boolean fwa = true;
  private boolean fwc = true;
  private boolean fwd = true;
  private boolean fxA = true;
  private boolean fxB = true;
  private boolean fxC = true;
  private boolean fxs = true;
  private boolean fxt = true;
  private boolean fxu = true;
  private boolean fxv = true;
  private boolean fxw = true;
  private boolean fxx = true;
  private boolean fxy = true;
  private boolean fxz = true;
  
  static
  {
    fla = "timeStamp".hashCode();
    fwi = "mixRetryTime".hashCode();
    fcD = "expiredTime".hashCode();
    eEL = "status".hashCode();
    fxD = "targetWidth".hashCode();
    fxE = "targetHeight".hashCode();
    faW = "videoBitrate".hashCode();
    faX = "audioBitrate".hashCode();
    fxF = "audioSampleRate".hashCode();
    fxG = "audioChannelCount".hashCode();
    faY = "frameRate".hashCode();
    fxH = "videoRotate".hashCode();
    fxI = "extraConfig".hashCode();
    fxJ = "reportInfo".hashCode();
    fxK = "userData".hashCode();
    fxL = "location".hashCode();
  }
  
  public static c.a VD()
  {
    c.a locala = new c.a();
    locala.IBL = new Field[21];
    locala.columns = new String[22];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "taskId";
    locala.IBN.put("taskId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" taskId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IBM = "taskId";
    locala.columns[1] = "baseItemData";
    locala.IBN.put("baseItemData", "BLOB");
    localStringBuilder.append(" baseItemData BLOB");
    localStringBuilder.append(", ");
    locala.columns[2] = "timeStamp";
    locala.IBN.put("timeStamp", "LONG");
    localStringBuilder.append(" timeStamp LONG");
    localStringBuilder.append(", ");
    locala.columns[3] = "mixRetryTime";
    locala.IBN.put("mixRetryTime", "INTEGER");
    localStringBuilder.append(" mixRetryTime INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "expiredTime";
    locala.IBN.put("expiredTime", "LONG");
    localStringBuilder.append(" expiredTime LONG");
    localStringBuilder.append(", ");
    locala.columns[5] = "status";
    locala.IBN.put("status", "INTEGER");
    localStringBuilder.append(" status INTEGER");
    localStringBuilder.append(", ");
    locala.columns[6] = "targetWidth";
    locala.IBN.put("targetWidth", "INTEGER");
    localStringBuilder.append(" targetWidth INTEGER");
    localStringBuilder.append(", ");
    locala.columns[7] = "targetHeight";
    locala.IBN.put("targetHeight", "INTEGER");
    localStringBuilder.append(" targetHeight INTEGER");
    localStringBuilder.append(", ");
    locala.columns[8] = "videoBitrate";
    locala.IBN.put("videoBitrate", "INTEGER");
    localStringBuilder.append(" videoBitrate INTEGER");
    localStringBuilder.append(", ");
    locala.columns[9] = "audioBitrate";
    locala.IBN.put("audioBitrate", "INTEGER");
    localStringBuilder.append(" audioBitrate INTEGER");
    localStringBuilder.append(", ");
    locala.columns[10] = "audioSampleRate";
    locala.IBN.put("audioSampleRate", "INTEGER");
    localStringBuilder.append(" audioSampleRate INTEGER");
    localStringBuilder.append(", ");
    locala.columns[11] = "audioChannelCount";
    locala.IBN.put("audioChannelCount", "INTEGER");
    localStringBuilder.append(" audioChannelCount INTEGER");
    localStringBuilder.append(", ");
    locala.columns[12] = "frameRate";
    locala.IBN.put("frameRate", "INTEGER");
    localStringBuilder.append(" frameRate INTEGER");
    localStringBuilder.append(", ");
    locala.columns[13] = "videoRotate";
    locala.IBN.put("videoRotate", "INTEGER");
    localStringBuilder.append(" videoRotate INTEGER");
    localStringBuilder.append(", ");
    locala.columns[14] = "extraConfig";
    locala.IBN.put("extraConfig", "BLOB");
    localStringBuilder.append(" extraConfig BLOB");
    localStringBuilder.append(", ");
    locala.columns[15] = "reportInfo";
    locala.IBN.put("reportInfo", "TEXT");
    localStringBuilder.append(" reportInfo TEXT");
    localStringBuilder.append(", ");
    locala.columns[16] = "userData";
    locala.IBN.put("userData", "TEXT");
    localStringBuilder.append(" userData TEXT");
    localStringBuilder.append(", ");
    locala.columns[17] = "location";
    locala.IBN.put("location", "BLOB");
    localStringBuilder.append(" location BLOB");
    localStringBuilder.append(", ");
    locala.columns[18] = "mixFlag";
    locala.IBN.put("mixFlag", "INTEGER");
    localStringBuilder.append(" mixFlag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[19] = "blurBgPath";
    locala.IBN.put("blurBgPath", "TEXT");
    localStringBuilder.append(" blurBgPath TEXT");
    localStringBuilder.append(", ");
    locala.columns[20] = "fromScene";
    locala.IBN.put("fromScene", "INTEGER");
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
      if (fdX != k) {
        break label65;
      }
      this.field_taskId = paramCursor.getString(i);
      this.fdO = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fwf == k) {
        this.field_baseItemData = paramCursor.getBlob(i);
      } else if (fla == k) {
        this.field_timeStamp = paramCursor.getLong(i);
      } else if (fwi == k) {
        this.field_mixRetryTime = paramCursor.getInt(i);
      } else if (fcD == k) {
        this.field_expiredTime = paramCursor.getLong(i);
      } else if (eEL == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (fxD == k) {
        this.field_targetWidth = paramCursor.getInt(i);
      } else if (fxE == k) {
        this.field_targetHeight = paramCursor.getInt(i);
      } else if (faW == k) {
        this.field_videoBitrate = paramCursor.getInt(i);
      } else if (faX == k) {
        this.field_audioBitrate = paramCursor.getInt(i);
      } else if (fxF == k) {
        this.field_audioSampleRate = paramCursor.getInt(i);
      } else if (fxG == k) {
        this.field_audioChannelCount = paramCursor.getInt(i);
      } else if (faY == k) {
        this.field_frameRate = paramCursor.getInt(i);
      } else if (fxH == k) {
        this.field_videoRotate = paramCursor.getInt(i);
      } else if (fxI == k) {
        this.field_extraConfig = paramCursor.getBlob(i);
      } else if (fxJ == k) {
        this.field_reportInfo = paramCursor.getString(i);
      } else if (fxK == k) {
        this.field_userData = paramCursor.getString(i);
      } else if (fxL == k) {
        this.field_location = paramCursor.getBlob(i);
      } else if (fwh == k) {
        this.field_mixFlag = paramCursor.getInt(i);
      } else if (fxM == k) {
        this.field_blurBgPath = paramCursor.getString(i);
      } else if (fxN == k) {
        this.field_fromScene = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fdO) {
      localContentValues.put("taskId", this.field_taskId);
    }
    if (this.fwa) {
      localContentValues.put("baseItemData", this.field_baseItemData);
    }
    if (this.fkU) {
      localContentValues.put("timeStamp", Long.valueOf(this.field_timeStamp));
    }
    if (this.fwd) {
      localContentValues.put("mixRetryTime", Integer.valueOf(this.field_mixRetryTime));
    }
    if (this.fcr) {
      localContentValues.put("expiredTime", Long.valueOf(this.field_expiredTime));
    }
    if (this.eEI) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.fxs) {
      localContentValues.put("targetWidth", Integer.valueOf(this.field_targetWidth));
    }
    if (this.fxt) {
      localContentValues.put("targetHeight", Integer.valueOf(this.field_targetHeight));
    }
    if (this.faK) {
      localContentValues.put("videoBitrate", Integer.valueOf(this.field_videoBitrate));
    }
    if (this.faL) {
      localContentValues.put("audioBitrate", Integer.valueOf(this.field_audioBitrate));
    }
    if (this.fxu) {
      localContentValues.put("audioSampleRate", Integer.valueOf(this.field_audioSampleRate));
    }
    if (this.fxv) {
      localContentValues.put("audioChannelCount", Integer.valueOf(this.field_audioChannelCount));
    }
    if (this.faM) {
      localContentValues.put("frameRate", Integer.valueOf(this.field_frameRate));
    }
    if (this.fxw) {
      localContentValues.put("videoRotate", Integer.valueOf(this.field_videoRotate));
    }
    if (this.fxx) {
      localContentValues.put("extraConfig", this.field_extraConfig);
    }
    if (this.fxy) {
      localContentValues.put("reportInfo", this.field_reportInfo);
    }
    if (this.fxz) {
      localContentValues.put("userData", this.field_userData);
    }
    if (this.fxA) {
      localContentValues.put("location", this.field_location);
    }
    if (this.fwc) {
      localContentValues.put("mixFlag", Integer.valueOf(this.field_mixFlag));
    }
    if (this.fxB) {
      localContentValues.put("blurBgPath", this.field_blurBgPath);
    }
    if (this.fxC) {
      localContentValues.put("fromScene", Integer.valueOf(this.field_fromScene));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.c.gp
 * JD-Core Version:    0.7.0.1
 */