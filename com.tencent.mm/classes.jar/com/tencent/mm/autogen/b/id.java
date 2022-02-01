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

public abstract class id
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("VideoEditInfo");
  private static final int jIF;
  public static final Column jIz;
  private static final int kIz;
  public static final Column kkd;
  private static final int ktG;
  private static final int ktH;
  private static final int ktI;
  public static final Column kti;
  public static final Column ktj;
  public static final Column ktk;
  public static final Column kug;
  private static final int kuq;
  private static final int kxT;
  public static final Column kxz;
  public static final Column lbO;
  public static final Column lbQ;
  public static final Column lbR;
  private static final int lbT;
  private static final int lbV;
  private static final int lbW;
  public static final Column ldK;
  public static final Column ldL;
  public static final Column ldM;
  public static final Column ldN;
  public static final Column ldO;
  public static final Column ldP;
  public static final Column ldQ;
  public static final Column ldR;
  public static final Column ldS;
  public static final Column ldT;
  public static final Column ldU;
  private static final int lej;
  private static final int lek;
  private static final int lel;
  private static final int lem;
  private static final int leo;
  private static final int lep;
  private static final int leq;
  private static final int ler;
  private static final int les;
  private static final int let;
  private static final int leu;
  private static final StorageObserverOwner<id> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
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
  private boolean jIC = true;
  private boolean kIu = true;
  private boolean ktu = true;
  private boolean ktv = true;
  private boolean ktw = true;
  private boolean kul = true;
  private boolean kxJ = true;
  private boolean ldV = true;
  private boolean ldW = true;
  private boolean ldX = true;
  private boolean ldY = true;
  private boolean ldZ = true;
  private boolean lea = true;
  private boolean leb = true;
  private boolean lec = true;
  private boolean led = true;
  private boolean lee = true;
  private boolean lef = true;
  private boolean leg = true;
  private boolean leh = true;
  private boolean lei = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    kxz = new Column("taskId", "string", TABLE.getName(), "");
    lbO = new Column("baseItemData", "byte[]", TABLE.getName(), "");
    kkd = new Column("timeStamp", "long", TABLE.getName(), "");
    lbR = new Column("mixRetryTime", "int", TABLE.getName(), "");
    kug = new Column("expiredTime", "long", TABLE.getName(), "");
    jIz = new Column("status", "int", TABLE.getName(), "");
    ldK = new Column("targetWidth", "int", TABLE.getName(), "");
    ldL = new Column("targetHeight", "int", TABLE.getName(), "");
    kti = new Column("videoBitrate", "int", TABLE.getName(), "");
    ktj = new Column("audioBitrate", "int", TABLE.getName(), "");
    ldM = new Column("audioSampleRate", "int", TABLE.getName(), "");
    ldN = new Column("audioChannelCount", "int", TABLE.getName(), "");
    ktk = new Column("frameRate", "int", TABLE.getName(), "");
    ldO = new Column("videoRotate", "int", TABLE.getName(), "");
    ldP = new Column("extraConfig", "byte[]", TABLE.getName(), "");
    ldQ = new Column("reportInfo", "string", TABLE.getName(), "");
    ldR = new Column("userData", "string", TABLE.getName(), "");
    ldS = new Column("location", "byte[]", TABLE.getName(), "");
    lbQ = new Column("mixFlag", "int", TABLE.getName(), "");
    ldT = new Column("blurBgPath", "string", TABLE.getName(), "");
    ldU = new Column("fromScene", "int", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    kxT = "taskId".hashCode();
    lbT = "baseItemData".hashCode();
    kIz = "timeStamp".hashCode();
    lbW = "mixRetryTime".hashCode();
    kuq = "expiredTime".hashCode();
    jIF = "status".hashCode();
    lej = "targetWidth".hashCode();
    lek = "targetHeight".hashCode();
    ktG = "videoBitrate".hashCode();
    ktH = "audioBitrate".hashCode();
    lel = "audioSampleRate".hashCode();
    lem = "audioChannelCount".hashCode();
    ktI = "frameRate".hashCode();
    leo = "videoRotate".hashCode();
    lep = "extraConfig".hashCode();
    leq = "reportInfo".hashCode();
    ler = "userData".hashCode();
    les = "location".hashCode();
    lbV = "mixFlag".hashCode();
    let = "blurBgPath".hashCode();
    leu = "fromScene".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
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
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("taskId"))
    {
      this.field_taskId = paramContentValues.getAsString("taskId");
      if (paramBoolean) {
        this.kxJ = true;
      }
    }
    if (paramContentValues.containsKey("baseItemData"))
    {
      this.field_baseItemData = paramContentValues.getAsByteArray("baseItemData");
      if (paramBoolean) {
        this.ldV = true;
      }
    }
    if (paramContentValues.containsKey("timeStamp"))
    {
      this.field_timeStamp = paramContentValues.getAsLong("timeStamp").longValue();
      if (paramBoolean) {
        this.kIu = true;
      }
    }
    if (paramContentValues.containsKey("mixRetryTime"))
    {
      this.field_mixRetryTime = paramContentValues.getAsInteger("mixRetryTime").intValue();
      if (paramBoolean) {
        this.ldW = true;
      }
    }
    if (paramContentValues.containsKey("expiredTime"))
    {
      this.field_expiredTime = paramContentValues.getAsLong("expiredTime").longValue();
      if (paramBoolean) {
        this.kul = true;
      }
    }
    if (paramContentValues.containsKey("status"))
    {
      this.field_status = paramContentValues.getAsInteger("status").intValue();
      if (paramBoolean) {
        this.jIC = true;
      }
    }
    if (paramContentValues.containsKey("targetWidth"))
    {
      this.field_targetWidth = paramContentValues.getAsInteger("targetWidth").intValue();
      if (paramBoolean) {
        this.ldX = true;
      }
    }
    if (paramContentValues.containsKey("targetHeight"))
    {
      this.field_targetHeight = paramContentValues.getAsInteger("targetHeight").intValue();
      if (paramBoolean) {
        this.ldY = true;
      }
    }
    if (paramContentValues.containsKey("videoBitrate"))
    {
      this.field_videoBitrate = paramContentValues.getAsInteger("videoBitrate").intValue();
      if (paramBoolean) {
        this.ktu = true;
      }
    }
    if (paramContentValues.containsKey("audioBitrate"))
    {
      this.field_audioBitrate = paramContentValues.getAsInteger("audioBitrate").intValue();
      if (paramBoolean) {
        this.ktv = true;
      }
    }
    if (paramContentValues.containsKey("audioSampleRate"))
    {
      this.field_audioSampleRate = paramContentValues.getAsInteger("audioSampleRate").intValue();
      if (paramBoolean) {
        this.ldZ = true;
      }
    }
    if (paramContentValues.containsKey("audioChannelCount"))
    {
      this.field_audioChannelCount = paramContentValues.getAsInteger("audioChannelCount").intValue();
      if (paramBoolean) {
        this.lea = true;
      }
    }
    if (paramContentValues.containsKey("frameRate"))
    {
      this.field_frameRate = paramContentValues.getAsInteger("frameRate").intValue();
      if (paramBoolean) {
        this.ktw = true;
      }
    }
    if (paramContentValues.containsKey("videoRotate"))
    {
      this.field_videoRotate = paramContentValues.getAsInteger("videoRotate").intValue();
      if (paramBoolean) {
        this.leb = true;
      }
    }
    if (paramContentValues.containsKey("extraConfig"))
    {
      this.field_extraConfig = paramContentValues.getAsByteArray("extraConfig");
      if (paramBoolean) {
        this.lec = true;
      }
    }
    if (paramContentValues.containsKey("reportInfo"))
    {
      this.field_reportInfo = paramContentValues.getAsString("reportInfo");
      if (paramBoolean) {
        this.led = true;
      }
    }
    if (paramContentValues.containsKey("userData"))
    {
      this.field_userData = paramContentValues.getAsString("userData");
      if (paramBoolean) {
        this.lee = true;
      }
    }
    if (paramContentValues.containsKey("location"))
    {
      this.field_location = paramContentValues.getAsByteArray("location");
      if (paramBoolean) {
        this.lef = true;
      }
    }
    if (paramContentValues.containsKey("mixFlag"))
    {
      this.field_mixFlag = paramContentValues.getAsInteger("mixFlag").intValue();
      if (paramBoolean) {
        this.leg = true;
      }
    }
    if (paramContentValues.containsKey("blurBgPath"))
    {
      this.field_blurBgPath = paramContentValues.getAsString("blurBgPath");
      if (paramBoolean) {
        this.leh = true;
      }
    }
    if (paramContentValues.containsKey("fromScene"))
    {
      this.field_fromScene = paramContentValues.getAsInteger("fromScene").intValue();
      if (paramBoolean) {
        this.lei = true;
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
      if (kxT != k) {
        break label65;
      }
      this.field_taskId = paramCursor.getString(i);
      this.kxJ = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (lbT == k) {
        this.field_baseItemData = paramCursor.getBlob(i);
      } else if (kIz == k) {
        this.field_timeStamp = paramCursor.getLong(i);
      } else if (lbW == k) {
        this.field_mixRetryTime = paramCursor.getInt(i);
      } else if (kuq == k) {
        this.field_expiredTime = paramCursor.getLong(i);
      } else if (jIF == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (lej == k) {
        this.field_targetWidth = paramCursor.getInt(i);
      } else if (lek == k) {
        this.field_targetHeight = paramCursor.getInt(i);
      } else if (ktG == k) {
        this.field_videoBitrate = paramCursor.getInt(i);
      } else if (ktH == k) {
        this.field_audioBitrate = paramCursor.getInt(i);
      } else if (lel == k) {
        this.field_audioSampleRate = paramCursor.getInt(i);
      } else if (lem == k) {
        this.field_audioChannelCount = paramCursor.getInt(i);
      } else if (ktI == k) {
        this.field_frameRate = paramCursor.getInt(i);
      } else if (leo == k) {
        this.field_videoRotate = paramCursor.getInt(i);
      } else if (lep == k) {
        this.field_extraConfig = paramCursor.getBlob(i);
      } else if (leq == k) {
        this.field_reportInfo = paramCursor.getString(i);
      } else if (ler == k) {
        this.field_userData = paramCursor.getString(i);
      } else if (les == k) {
        this.field_location = paramCursor.getBlob(i);
      } else if (lbV == k) {
        this.field_mixFlag = paramCursor.getInt(i);
      } else if (let == k) {
        this.field_blurBgPath = paramCursor.getString(i);
      } else if (leu == k) {
        this.field_fromScene = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.kxJ) {
      localContentValues.put("taskId", this.field_taskId);
    }
    if (this.ldV) {
      localContentValues.put("baseItemData", this.field_baseItemData);
    }
    if (this.kIu) {
      localContentValues.put("timeStamp", Long.valueOf(this.field_timeStamp));
    }
    if (this.ldW) {
      localContentValues.put("mixRetryTime", Integer.valueOf(this.field_mixRetryTime));
    }
    if (this.kul) {
      localContentValues.put("expiredTime", Long.valueOf(this.field_expiredTime));
    }
    if (this.jIC) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.ldX) {
      localContentValues.put("targetWidth", Integer.valueOf(this.field_targetWidth));
    }
    if (this.ldY) {
      localContentValues.put("targetHeight", Integer.valueOf(this.field_targetHeight));
    }
    if (this.ktu) {
      localContentValues.put("videoBitrate", Integer.valueOf(this.field_videoBitrate));
    }
    if (this.ktv) {
      localContentValues.put("audioBitrate", Integer.valueOf(this.field_audioBitrate));
    }
    if (this.ldZ) {
      localContentValues.put("audioSampleRate", Integer.valueOf(this.field_audioSampleRate));
    }
    if (this.lea) {
      localContentValues.put("audioChannelCount", Integer.valueOf(this.field_audioChannelCount));
    }
    if (this.ktw) {
      localContentValues.put("frameRate", Integer.valueOf(this.field_frameRate));
    }
    if (this.leb) {
      localContentValues.put("videoRotate", Integer.valueOf(this.field_videoRotate));
    }
    if (this.lec) {
      localContentValues.put("extraConfig", this.field_extraConfig);
    }
    if (this.led) {
      localContentValues.put("reportInfo", this.field_reportInfo);
    }
    if (this.lee) {
      localContentValues.put("userData", this.field_userData);
    }
    if (this.lef) {
      localContentValues.put("location", this.field_location);
    }
    if (this.leg) {
      localContentValues.put("mixFlag", Integer.valueOf(this.field_mixFlag));
    }
    if (this.leh) {
      localContentValues.put("blurBgPath", this.field_blurBgPath);
    }
    if (this.lei) {
      localContentValues.put("fromScene", Integer.valueOf(this.field_fromScene));
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
  
  public StorageObserverOwner<? extends id> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return this.field_taskId;
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
 * Qualified Name:     com.tencent.mm.autogen.b.id
 * JD-Core Version:    0.7.0.1
 */