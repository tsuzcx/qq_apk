package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class ga
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eFK;
  private static final int eHi = "taskId".hashCode();
  private static final int eYE = "baseItemData".hashCode();
  private static final int eYF = "timeStamp".hashCode();
  private static final int eYH = "mixFlag".hashCode();
  private static final int eYI = "mixRetryTime".hashCode();
  private static final int ejR;
  private static final int fag;
  private static final int fah;
  private static final int fai;
  private static final int faj;
  private static final int fak;
  private static final int fal;
  private static final int fam;
  private static final int fan;
  private static final int fao;
  private static final int fap;
  private static final int faq;
  private static final int far;
  private static final int fas = "blurBgPath".hashCode();
  private static final int fat = "fromScene".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eFy = true;
  private boolean eGZ = true;
  private boolean eYB = true;
  private boolean eYC = true;
  private boolean eYy = true;
  private boolean eYz = true;
  private boolean eZS = true;
  private boolean eZT = true;
  private boolean eZU = true;
  private boolean eZV = true;
  private boolean eZW = true;
  private boolean eZX = true;
  private boolean eZY = true;
  private boolean eZZ = true;
  private boolean ejO = true;
  private boolean faa = true;
  private boolean fab = true;
  private boolean fac = true;
  private boolean fad = true;
  private boolean fae = true;
  private boolean faf = true;
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
    eFK = "expiredTime".hashCode();
    ejR = "status".hashCode();
    fag = "targetWidth".hashCode();
    fah = "targetHeight".hashCode();
    fai = "videoBitrate".hashCode();
    faj = "audioBitrate".hashCode();
    fak = "audioSampleRate".hashCode();
    fal = "audioChannelCount".hashCode();
    fam = "frameRate".hashCode();
    fan = "videoRotate".hashCode();
    fao = "extraConfig".hashCode();
    fap = "reportInfo".hashCode();
    faq = "userData".hashCode();
    far = "location".hashCode();
  }
  
  public static c.a So()
  {
    c.a locala = new c.a();
    locala.EYt = new Field[21];
    locala.columns = new String[22];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "taskId";
    locala.EYv.put("taskId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" taskId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.EYu = "taskId";
    locala.columns[1] = "baseItemData";
    locala.EYv.put("baseItemData", "BLOB");
    localStringBuilder.append(" baseItemData BLOB");
    localStringBuilder.append(", ");
    locala.columns[2] = "timeStamp";
    locala.EYv.put("timeStamp", "LONG");
    localStringBuilder.append(" timeStamp LONG");
    localStringBuilder.append(", ");
    locala.columns[3] = "mixRetryTime";
    locala.EYv.put("mixRetryTime", "INTEGER");
    localStringBuilder.append(" mixRetryTime INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "expiredTime";
    locala.EYv.put("expiredTime", "LONG");
    localStringBuilder.append(" expiredTime LONG");
    localStringBuilder.append(", ");
    locala.columns[5] = "status";
    locala.EYv.put("status", "INTEGER");
    localStringBuilder.append(" status INTEGER");
    localStringBuilder.append(", ");
    locala.columns[6] = "targetWidth";
    locala.EYv.put("targetWidth", "INTEGER");
    localStringBuilder.append(" targetWidth INTEGER");
    localStringBuilder.append(", ");
    locala.columns[7] = "targetHeight";
    locala.EYv.put("targetHeight", "INTEGER");
    localStringBuilder.append(" targetHeight INTEGER");
    localStringBuilder.append(", ");
    locala.columns[8] = "videoBitrate";
    locala.EYv.put("videoBitrate", "INTEGER");
    localStringBuilder.append(" videoBitrate INTEGER");
    localStringBuilder.append(", ");
    locala.columns[9] = "audioBitrate";
    locala.EYv.put("audioBitrate", "INTEGER");
    localStringBuilder.append(" audioBitrate INTEGER");
    localStringBuilder.append(", ");
    locala.columns[10] = "audioSampleRate";
    locala.EYv.put("audioSampleRate", "INTEGER");
    localStringBuilder.append(" audioSampleRate INTEGER");
    localStringBuilder.append(", ");
    locala.columns[11] = "audioChannelCount";
    locala.EYv.put("audioChannelCount", "INTEGER");
    localStringBuilder.append(" audioChannelCount INTEGER");
    localStringBuilder.append(", ");
    locala.columns[12] = "frameRate";
    locala.EYv.put("frameRate", "INTEGER");
    localStringBuilder.append(" frameRate INTEGER");
    localStringBuilder.append(", ");
    locala.columns[13] = "videoRotate";
    locala.EYv.put("videoRotate", "INTEGER");
    localStringBuilder.append(" videoRotate INTEGER");
    localStringBuilder.append(", ");
    locala.columns[14] = "extraConfig";
    locala.EYv.put("extraConfig", "BLOB");
    localStringBuilder.append(" extraConfig BLOB");
    localStringBuilder.append(", ");
    locala.columns[15] = "reportInfo";
    locala.EYv.put("reportInfo", "TEXT");
    localStringBuilder.append(" reportInfo TEXT");
    localStringBuilder.append(", ");
    locala.columns[16] = "userData";
    locala.EYv.put("userData", "TEXT");
    localStringBuilder.append(" userData TEXT");
    localStringBuilder.append(", ");
    locala.columns[17] = "location";
    locala.EYv.put("location", "BLOB");
    localStringBuilder.append(" location BLOB");
    localStringBuilder.append(", ");
    locala.columns[18] = "mixFlag";
    locala.EYv.put("mixFlag", "INTEGER");
    localStringBuilder.append(" mixFlag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[19] = "blurBgPath";
    locala.EYv.put("blurBgPath", "TEXT");
    localStringBuilder.append(" blurBgPath TEXT");
    localStringBuilder.append(", ");
    locala.columns[20] = "fromScene";
    locala.EYv.put("fromScene", "INTEGER");
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
      if (eHi != k) {
        break label65;
      }
      this.field_taskId = paramCursor.getString(i);
      this.eGZ = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eYE == k) {
        this.field_baseItemData = paramCursor.getBlob(i);
      } else if (eYF == k) {
        this.field_timeStamp = paramCursor.getLong(i);
      } else if (eYI == k) {
        this.field_mixRetryTime = paramCursor.getInt(i);
      } else if (eFK == k) {
        this.field_expiredTime = paramCursor.getLong(i);
      } else if (ejR == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (fag == k) {
        this.field_targetWidth = paramCursor.getInt(i);
      } else if (fah == k) {
        this.field_targetHeight = paramCursor.getInt(i);
      } else if (fai == k) {
        this.field_videoBitrate = paramCursor.getInt(i);
      } else if (faj == k) {
        this.field_audioBitrate = paramCursor.getInt(i);
      } else if (fak == k) {
        this.field_audioSampleRate = paramCursor.getInt(i);
      } else if (fal == k) {
        this.field_audioChannelCount = paramCursor.getInt(i);
      } else if (fam == k) {
        this.field_frameRate = paramCursor.getInt(i);
      } else if (fan == k) {
        this.field_videoRotate = paramCursor.getInt(i);
      } else if (fao == k) {
        this.field_extraConfig = paramCursor.getBlob(i);
      } else if (fap == k) {
        this.field_reportInfo = paramCursor.getString(i);
      } else if (faq == k) {
        this.field_userData = paramCursor.getString(i);
      } else if (far == k) {
        this.field_location = paramCursor.getBlob(i);
      } else if (eYH == k) {
        this.field_mixFlag = paramCursor.getInt(i);
      } else if (fas == k) {
        this.field_blurBgPath = paramCursor.getString(i);
      } else if (fat == k) {
        this.field_fromScene = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eGZ) {
      localContentValues.put("taskId", this.field_taskId);
    }
    if (this.eYy) {
      localContentValues.put("baseItemData", this.field_baseItemData);
    }
    if (this.eYz) {
      localContentValues.put("timeStamp", Long.valueOf(this.field_timeStamp));
    }
    if (this.eYC) {
      localContentValues.put("mixRetryTime", Integer.valueOf(this.field_mixRetryTime));
    }
    if (this.eFy) {
      localContentValues.put("expiredTime", Long.valueOf(this.field_expiredTime));
    }
    if (this.ejO) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.eZS) {
      localContentValues.put("targetWidth", Integer.valueOf(this.field_targetWidth));
    }
    if (this.eZT) {
      localContentValues.put("targetHeight", Integer.valueOf(this.field_targetHeight));
    }
    if (this.eZU) {
      localContentValues.put("videoBitrate", Integer.valueOf(this.field_videoBitrate));
    }
    if (this.eZV) {
      localContentValues.put("audioBitrate", Integer.valueOf(this.field_audioBitrate));
    }
    if (this.eZW) {
      localContentValues.put("audioSampleRate", Integer.valueOf(this.field_audioSampleRate));
    }
    if (this.eZX) {
      localContentValues.put("audioChannelCount", Integer.valueOf(this.field_audioChannelCount));
    }
    if (this.eZY) {
      localContentValues.put("frameRate", Integer.valueOf(this.field_frameRate));
    }
    if (this.eZZ) {
      localContentValues.put("videoRotate", Integer.valueOf(this.field_videoRotate));
    }
    if (this.faa) {
      localContentValues.put("extraConfig", this.field_extraConfig);
    }
    if (this.fab) {
      localContentValues.put("reportInfo", this.field_reportInfo);
    }
    if (this.fac) {
      localContentValues.put("userData", this.field_userData);
    }
    if (this.fad) {
      localContentValues.put("location", this.field_location);
    }
    if (this.eYB) {
      localContentValues.put("mixFlag", Integer.valueOf(this.field_mixFlag));
    }
    if (this.fae) {
      localContentValues.put("blurBgPath", this.field_blurBgPath);
    }
    if (this.faf) {
      localContentValues.put("fromScene", Integer.valueOf(this.field_fromScene));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.ga
 * JD-Core Version:    0.7.0.1
 */