package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class go
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eDc;
  private static final int eZj;
  private static final int eZk;
  private static final int eZl;
  private static final int faO;
  private static final int fci = "taskId".hashCode();
  private static final int fjd;
  private static final int fuf = "baseItemData".hashCode();
  private static final int fuh = "mixFlag".hashCode();
  private static final int fui;
  private static final int fvD;
  private static final int fvE;
  private static final int fvF;
  private static final int fvG;
  private static final int fvH;
  private static final int fvI;
  private static final int fvJ;
  private static final int fvK;
  private static final int fvL;
  private static final int fvM = "blurBgPath".hashCode();
  private static final int fvN = "fromScene".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eCZ = true;
  private boolean eYX = true;
  private boolean eYY = true;
  private boolean eYZ = true;
  private boolean faC = true;
  private boolean fbZ = true;
  private boolean fiX = true;
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
  private boolean fua = true;
  private boolean fuc = true;
  private boolean fud = true;
  private boolean fvA = true;
  private boolean fvB = true;
  private boolean fvC = true;
  private boolean fvs = true;
  private boolean fvt = true;
  private boolean fvu = true;
  private boolean fvv = true;
  private boolean fvw = true;
  private boolean fvx = true;
  private boolean fvy = true;
  private boolean fvz = true;
  
  static
  {
    fjd = "timeStamp".hashCode();
    fui = "mixRetryTime".hashCode();
    faO = "expiredTime".hashCode();
    eDc = "status".hashCode();
    fvD = "targetWidth".hashCode();
    fvE = "targetHeight".hashCode();
    eZj = "videoBitrate".hashCode();
    eZk = "audioBitrate".hashCode();
    fvF = "audioSampleRate".hashCode();
    fvG = "audioChannelCount".hashCode();
    eZl = "frameRate".hashCode();
    fvH = "videoRotate".hashCode();
    fvI = "extraConfig".hashCode();
    fvJ = "reportInfo".hashCode();
    fvK = "userData".hashCode();
    fvL = "location".hashCode();
  }
  
  public static c.a Vv()
  {
    c.a locala = new c.a();
    locala.IhA = new Field[21];
    locala.columns = new String[22];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "taskId";
    locala.IhC.put("taskId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" taskId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IhB = "taskId";
    locala.columns[1] = "baseItemData";
    locala.IhC.put("baseItemData", "BLOB");
    localStringBuilder.append(" baseItemData BLOB");
    localStringBuilder.append(", ");
    locala.columns[2] = "timeStamp";
    locala.IhC.put("timeStamp", "LONG");
    localStringBuilder.append(" timeStamp LONG");
    localStringBuilder.append(", ");
    locala.columns[3] = "mixRetryTime";
    locala.IhC.put("mixRetryTime", "INTEGER");
    localStringBuilder.append(" mixRetryTime INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "expiredTime";
    locala.IhC.put("expiredTime", "LONG");
    localStringBuilder.append(" expiredTime LONG");
    localStringBuilder.append(", ");
    locala.columns[5] = "status";
    locala.IhC.put("status", "INTEGER");
    localStringBuilder.append(" status INTEGER");
    localStringBuilder.append(", ");
    locala.columns[6] = "targetWidth";
    locala.IhC.put("targetWidth", "INTEGER");
    localStringBuilder.append(" targetWidth INTEGER");
    localStringBuilder.append(", ");
    locala.columns[7] = "targetHeight";
    locala.IhC.put("targetHeight", "INTEGER");
    localStringBuilder.append(" targetHeight INTEGER");
    localStringBuilder.append(", ");
    locala.columns[8] = "videoBitrate";
    locala.IhC.put("videoBitrate", "INTEGER");
    localStringBuilder.append(" videoBitrate INTEGER");
    localStringBuilder.append(", ");
    locala.columns[9] = "audioBitrate";
    locala.IhC.put("audioBitrate", "INTEGER");
    localStringBuilder.append(" audioBitrate INTEGER");
    localStringBuilder.append(", ");
    locala.columns[10] = "audioSampleRate";
    locala.IhC.put("audioSampleRate", "INTEGER");
    localStringBuilder.append(" audioSampleRate INTEGER");
    localStringBuilder.append(", ");
    locala.columns[11] = "audioChannelCount";
    locala.IhC.put("audioChannelCount", "INTEGER");
    localStringBuilder.append(" audioChannelCount INTEGER");
    localStringBuilder.append(", ");
    locala.columns[12] = "frameRate";
    locala.IhC.put("frameRate", "INTEGER");
    localStringBuilder.append(" frameRate INTEGER");
    localStringBuilder.append(", ");
    locala.columns[13] = "videoRotate";
    locala.IhC.put("videoRotate", "INTEGER");
    localStringBuilder.append(" videoRotate INTEGER");
    localStringBuilder.append(", ");
    locala.columns[14] = "extraConfig";
    locala.IhC.put("extraConfig", "BLOB");
    localStringBuilder.append(" extraConfig BLOB");
    localStringBuilder.append(", ");
    locala.columns[15] = "reportInfo";
    locala.IhC.put("reportInfo", "TEXT");
    localStringBuilder.append(" reportInfo TEXT");
    localStringBuilder.append(", ");
    locala.columns[16] = "userData";
    locala.IhC.put("userData", "TEXT");
    localStringBuilder.append(" userData TEXT");
    localStringBuilder.append(", ");
    locala.columns[17] = "location";
    locala.IhC.put("location", "BLOB");
    localStringBuilder.append(" location BLOB");
    localStringBuilder.append(", ");
    locala.columns[18] = "mixFlag";
    locala.IhC.put("mixFlag", "INTEGER");
    localStringBuilder.append(" mixFlag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[19] = "blurBgPath";
    locala.IhC.put("blurBgPath", "TEXT");
    localStringBuilder.append(" blurBgPath TEXT");
    localStringBuilder.append(", ");
    locala.columns[20] = "fromScene";
    locala.IhC.put("fromScene", "INTEGER");
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
      if (fci != k) {
        break label65;
      }
      this.field_taskId = paramCursor.getString(i);
      this.fbZ = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fuf == k) {
        this.field_baseItemData = paramCursor.getBlob(i);
      } else if (fjd == k) {
        this.field_timeStamp = paramCursor.getLong(i);
      } else if (fui == k) {
        this.field_mixRetryTime = paramCursor.getInt(i);
      } else if (faO == k) {
        this.field_expiredTime = paramCursor.getLong(i);
      } else if (eDc == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (fvD == k) {
        this.field_targetWidth = paramCursor.getInt(i);
      } else if (fvE == k) {
        this.field_targetHeight = paramCursor.getInt(i);
      } else if (eZj == k) {
        this.field_videoBitrate = paramCursor.getInt(i);
      } else if (eZk == k) {
        this.field_audioBitrate = paramCursor.getInt(i);
      } else if (fvF == k) {
        this.field_audioSampleRate = paramCursor.getInt(i);
      } else if (fvG == k) {
        this.field_audioChannelCount = paramCursor.getInt(i);
      } else if (eZl == k) {
        this.field_frameRate = paramCursor.getInt(i);
      } else if (fvH == k) {
        this.field_videoRotate = paramCursor.getInt(i);
      } else if (fvI == k) {
        this.field_extraConfig = paramCursor.getBlob(i);
      } else if (fvJ == k) {
        this.field_reportInfo = paramCursor.getString(i);
      } else if (fvK == k) {
        this.field_userData = paramCursor.getString(i);
      } else if (fvL == k) {
        this.field_location = paramCursor.getBlob(i);
      } else if (fuh == k) {
        this.field_mixFlag = paramCursor.getInt(i);
      } else if (fvM == k) {
        this.field_blurBgPath = paramCursor.getString(i);
      } else if (fvN == k) {
        this.field_fromScene = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fbZ) {
      localContentValues.put("taskId", this.field_taskId);
    }
    if (this.fua) {
      localContentValues.put("baseItemData", this.field_baseItemData);
    }
    if (this.fiX) {
      localContentValues.put("timeStamp", Long.valueOf(this.field_timeStamp));
    }
    if (this.fud) {
      localContentValues.put("mixRetryTime", Integer.valueOf(this.field_mixRetryTime));
    }
    if (this.faC) {
      localContentValues.put("expiredTime", Long.valueOf(this.field_expiredTime));
    }
    if (this.eCZ) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.fvs) {
      localContentValues.put("targetWidth", Integer.valueOf(this.field_targetWidth));
    }
    if (this.fvt) {
      localContentValues.put("targetHeight", Integer.valueOf(this.field_targetHeight));
    }
    if (this.eYX) {
      localContentValues.put("videoBitrate", Integer.valueOf(this.field_videoBitrate));
    }
    if (this.eYY) {
      localContentValues.put("audioBitrate", Integer.valueOf(this.field_audioBitrate));
    }
    if (this.fvu) {
      localContentValues.put("audioSampleRate", Integer.valueOf(this.field_audioSampleRate));
    }
    if (this.fvv) {
      localContentValues.put("audioChannelCount", Integer.valueOf(this.field_audioChannelCount));
    }
    if (this.eYZ) {
      localContentValues.put("frameRate", Integer.valueOf(this.field_frameRate));
    }
    if (this.fvw) {
      localContentValues.put("videoRotate", Integer.valueOf(this.field_videoRotate));
    }
    if (this.fvx) {
      localContentValues.put("extraConfig", this.field_extraConfig);
    }
    if (this.fvy) {
      localContentValues.put("reportInfo", this.field_reportInfo);
    }
    if (this.fvz) {
      localContentValues.put("userData", this.field_userData);
    }
    if (this.fvA) {
      localContentValues.put("location", this.field_location);
    }
    if (this.fuc) {
      localContentValues.put("mixFlag", Integer.valueOf(this.field_mixFlag));
    }
    if (this.fvB) {
      localContentValues.put("blurBgPath", this.field_blurBgPath);
    }
    if (this.fvC) {
      localContentValues.put("fromScene", Integer.valueOf(this.field_fromScene));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.go
 * JD-Core Version:    0.7.0.1
 */