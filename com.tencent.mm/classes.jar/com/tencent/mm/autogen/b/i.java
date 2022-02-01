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

public abstract class i
  extends IAutoDBItem
{
  public static final Column CREATETIME;
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("appattach");
  public static final Column TYPE;
  private static final int createTime_HASHCODE;
  private static final int jIF;
  public static final Column jIz;
  public static final Column jKA;
  public static final Column jKB;
  public static final Column jKC;
  public static final Column jKD;
  public static final Column jKE;
  public static final Column jKF;
  private static final int jKX;
  private static final int jKY;
  private static final int jKZ;
  public static final Column jKp;
  public static final Column jKq;
  public static final Column jKr;
  public static final Column jKs;
  public static final Column jKt;
  public static final Column jKu;
  public static final Column jKv;
  public static final Column jKw;
  public static final Column jKx;
  public static final Column jKy;
  public static final Column jKz;
  private static final int jLa;
  private static final int jLb;
  private static final int jLc;
  private static final int jLd;
  private static final int jLe;
  private static final int jLf;
  private static final int jLg;
  private static final int jLh;
  private static final int jLi;
  private static final int jLj;
  private static final int jLk;
  private static final int jLl;
  private static final int jLm;
  private static final int jLn;
  private static final StorageObserverOwner<i> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  private static final int type_HASHCODE;
  private boolean __hadSetcreateTime = true;
  private boolean __hadSettype = true;
  public String field_appId;
  public String field_clientAppDataId;
  public long field_createTime;
  public String field_fakeAeskey;
  public String field_fakeSignature;
  public String field_fileFullPath;
  public String field_fullXml;
  public boolean field_isUpload;
  public int field_isUseCdn;
  public long field_lastModifyTime;
  public String field_mediaId;
  public String field_mediaSvrId;
  public long field_msgInfoId;
  public long field_netTimes;
  public long field_offset;
  public long field_sdkVer;
  public String field_signature;
  public long field_status;
  public long field_totalLen;
  public long field_type;
  private boolean jIC = true;
  private boolean jKG = true;
  private boolean jKH = true;
  private boolean jKI = true;
  private boolean jKJ = true;
  private boolean jKK = true;
  private boolean jKL = true;
  private boolean jKM = true;
  private boolean jKN = true;
  private boolean jKO = true;
  private boolean jKP = true;
  private boolean jKQ = true;
  private boolean jKR = true;
  private boolean jKS = true;
  private boolean jKT = true;
  private boolean jKU = true;
  private boolean jKV = true;
  private boolean jKW = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    jKp = new Column("appId", "string", TABLE.getName(), "");
    jKq = new Column("sdkVer", "long", TABLE.getName(), "");
    jKr = new Column("mediaSvrId", "string", TABLE.getName(), "");
    jKs = new Column("mediaId", "string", TABLE.getName(), "");
    jKt = new Column("clientAppDataId", "string", TABLE.getName(), "");
    TYPE = new Column("type", "long", TABLE.getName(), "");
    jKu = new Column("totalLen", "long", TABLE.getName(), "");
    jKv = new Column("offset", "long", TABLE.getName(), "");
    jIz = new Column("status", "long", TABLE.getName(), "");
    jKw = new Column("isUpload", "boolean", TABLE.getName(), "");
    CREATETIME = new Column("createTime", "long", TABLE.getName(), "");
    jKx = new Column("lastModifyTime", "long", TABLE.getName(), "");
    jKy = new Column("fileFullPath", "string", TABLE.getName(), "");
    jKz = new Column("fullXml", "string", TABLE.getName(), "");
    jKA = new Column("msgInfoId", "long", TABLE.getName(), "");
    jKB = new Column("netTimes", "long", TABLE.getName(), "");
    jKC = new Column("isUseCdn", "int", TABLE.getName(), "");
    jKD = new Column("signature", "string", TABLE.getName(), "");
    jKE = new Column("fakeAeskey", "string", TABLE.getName(), "");
    jKF = new Column("fakeSignature", "string", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    jKX = "appId".hashCode();
    jKY = "sdkVer".hashCode();
    jKZ = "mediaSvrId".hashCode();
    jLa = "mediaId".hashCode();
    jLb = "clientAppDataId".hashCode();
    type_HASHCODE = "type".hashCode();
    jLc = "totalLen".hashCode();
    jLd = "offset".hashCode();
    jIF = "status".hashCode();
    jLe = "isUpload".hashCode();
    createTime_HASHCODE = "createTime".hashCode();
    jLf = "lastModifyTime".hashCode();
    jLg = "fileFullPath".hashCode();
    jLh = "fullXml".hashCode();
    jLi = "msgInfoId".hashCode();
    jLj = "netTimes".hashCode();
    jLk = "isUseCdn".hashCode();
    jLl = "signature".hashCode();
    jLm = "fakeAeskey".hashCode();
    jLn = "fakeSignature".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[20];
    localMAutoDBInfo.columns = new String[21];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "appId";
    localMAutoDBInfo.colsMap.put("appId", "TEXT");
    localStringBuilder.append(" appId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[1] = "sdkVer";
    localMAutoDBInfo.colsMap.put("sdkVer", "LONG");
    localStringBuilder.append(" sdkVer LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "mediaSvrId";
    localMAutoDBInfo.colsMap.put("mediaSvrId", "TEXT");
    localStringBuilder.append(" mediaSvrId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "mediaId";
    localMAutoDBInfo.colsMap.put("mediaId", "TEXT");
    localStringBuilder.append(" mediaId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "clientAppDataId";
    localMAutoDBInfo.colsMap.put("clientAppDataId", "TEXT");
    localStringBuilder.append(" clientAppDataId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "type";
    localMAutoDBInfo.colsMap.put("type", "LONG");
    localStringBuilder.append(" type LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "totalLen";
    localMAutoDBInfo.colsMap.put("totalLen", "LONG");
    localStringBuilder.append(" totalLen LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "offset";
    localMAutoDBInfo.colsMap.put("offset", "LONG");
    localStringBuilder.append(" offset LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "status";
    localMAutoDBInfo.colsMap.put("status", "LONG");
    localStringBuilder.append(" status LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "isUpload";
    localMAutoDBInfo.colsMap.put("isUpload", "INTEGER");
    localStringBuilder.append(" isUpload INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[10] = "createTime";
    localMAutoDBInfo.colsMap.put("createTime", "LONG");
    localStringBuilder.append(" createTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[11] = "lastModifyTime";
    localMAutoDBInfo.colsMap.put("lastModifyTime", "LONG");
    localStringBuilder.append(" lastModifyTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[12] = "fileFullPath";
    localMAutoDBInfo.colsMap.put("fileFullPath", "TEXT");
    localStringBuilder.append(" fileFullPath TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[13] = "fullXml";
    localMAutoDBInfo.colsMap.put("fullXml", "TEXT");
    localStringBuilder.append(" fullXml TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[14] = "msgInfoId";
    localMAutoDBInfo.colsMap.put("msgInfoId", "LONG");
    localStringBuilder.append(" msgInfoId LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[15] = "netTimes";
    localMAutoDBInfo.colsMap.put("netTimes", "LONG");
    localStringBuilder.append(" netTimes LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[16] = "isUseCdn";
    localMAutoDBInfo.colsMap.put("isUseCdn", "INTEGER");
    localStringBuilder.append(" isUseCdn INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[17] = "signature";
    localMAutoDBInfo.colsMap.put("signature", "TEXT");
    localStringBuilder.append(" signature TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[18] = "fakeAeskey";
    localMAutoDBInfo.colsMap.put("fakeAeskey", "TEXT");
    localStringBuilder.append(" fakeAeskey TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[19] = "fakeSignature";
    localMAutoDBInfo.colsMap.put("fakeSignature", "TEXT");
    localStringBuilder.append(" fakeSignature TEXT");
    localMAutoDBInfo.columns[20] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("appId"))
    {
      this.field_appId = paramContentValues.getAsString("appId");
      if (paramBoolean) {
        this.jKG = true;
      }
    }
    if (paramContentValues.containsKey("sdkVer"))
    {
      this.field_sdkVer = paramContentValues.getAsLong("sdkVer").longValue();
      if (paramBoolean) {
        this.jKH = true;
      }
    }
    if (paramContentValues.containsKey("mediaSvrId"))
    {
      this.field_mediaSvrId = paramContentValues.getAsString("mediaSvrId");
      if (paramBoolean) {
        this.jKI = true;
      }
    }
    if (paramContentValues.containsKey("mediaId"))
    {
      this.field_mediaId = paramContentValues.getAsString("mediaId");
      if (paramBoolean) {
        this.jKJ = true;
      }
    }
    if (paramContentValues.containsKey("clientAppDataId"))
    {
      this.field_clientAppDataId = paramContentValues.getAsString("clientAppDataId");
      if (paramBoolean) {
        this.jKK = true;
      }
    }
    if (paramContentValues.containsKey("type"))
    {
      this.field_type = paramContentValues.getAsLong("type").longValue();
      if (paramBoolean) {
        this.__hadSettype = true;
      }
    }
    if (paramContentValues.containsKey("totalLen"))
    {
      this.field_totalLen = paramContentValues.getAsLong("totalLen").longValue();
      if (paramBoolean) {
        this.jKL = true;
      }
    }
    if (paramContentValues.containsKey("offset"))
    {
      this.field_offset = paramContentValues.getAsLong("offset").longValue();
      if (paramBoolean) {
        this.jKM = true;
      }
    }
    if (paramContentValues.containsKey("status"))
    {
      this.field_status = paramContentValues.getAsLong("status").longValue();
      if (paramBoolean) {
        this.jIC = true;
      }
    }
    if (paramContentValues.containsKey("isUpload")) {
      if (paramContentValues.getAsInteger("isUpload").intValue() == 0) {
        break label622;
      }
    }
    label622:
    for (boolean bool = true;; bool = false)
    {
      this.field_isUpload = bool;
      if (paramBoolean) {
        this.jKN = true;
      }
      if (paramContentValues.containsKey("createTime"))
      {
        this.field_createTime = paramContentValues.getAsLong("createTime").longValue();
        if (paramBoolean) {
          this.__hadSetcreateTime = true;
        }
      }
      if (paramContentValues.containsKey("lastModifyTime"))
      {
        this.field_lastModifyTime = paramContentValues.getAsLong("lastModifyTime").longValue();
        if (paramBoolean) {
          this.jKO = true;
        }
      }
      if (paramContentValues.containsKey("fileFullPath"))
      {
        this.field_fileFullPath = paramContentValues.getAsString("fileFullPath");
        if (paramBoolean) {
          this.jKP = true;
        }
      }
      if (paramContentValues.containsKey("fullXml"))
      {
        this.field_fullXml = paramContentValues.getAsString("fullXml");
        if (paramBoolean) {
          this.jKQ = true;
        }
      }
      if (paramContentValues.containsKey("msgInfoId"))
      {
        this.field_msgInfoId = paramContentValues.getAsLong("msgInfoId").longValue();
        if (paramBoolean) {
          this.jKR = true;
        }
      }
      if (paramContentValues.containsKey("netTimes"))
      {
        this.field_netTimes = paramContentValues.getAsLong("netTimes").longValue();
        if (paramBoolean) {
          this.jKS = true;
        }
      }
      if (paramContentValues.containsKey("isUseCdn"))
      {
        this.field_isUseCdn = paramContentValues.getAsInteger("isUseCdn").intValue();
        if (paramBoolean) {
          this.jKT = true;
        }
      }
      if (paramContentValues.containsKey("signature"))
      {
        this.field_signature = paramContentValues.getAsString("signature");
        if (paramBoolean) {
          this.jKU = true;
        }
      }
      if (paramContentValues.containsKey("fakeAeskey"))
      {
        this.field_fakeAeskey = paramContentValues.getAsString("fakeAeskey");
        if (paramBoolean) {
          this.jKV = true;
        }
      }
      if (paramContentValues.containsKey("fakeSignature"))
      {
        this.field_fakeSignature = paramContentValues.getAsString("fakeSignature");
        if (paramBoolean) {
          this.jKW = true;
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
      if (jKY == k)
      {
        this.field_sdkVer = paramCursor.getLong(i);
      }
      else if (jKZ == k)
      {
        this.field_mediaSvrId = paramCursor.getString(i);
      }
      else if (jLa == k)
      {
        this.field_mediaId = paramCursor.getString(i);
      }
      else if (jLb == k)
      {
        this.field_clientAppDataId = paramCursor.getString(i);
      }
      else if (type_HASHCODE == k)
      {
        this.field_type = paramCursor.getLong(i);
      }
      else if (jLc == k)
      {
        this.field_totalLen = paramCursor.getLong(i);
      }
      else if (jLd == k)
      {
        this.field_offset = paramCursor.getLong(i);
      }
      else if (jIF == k)
      {
        this.field_status = paramCursor.getLong(i);
      }
      else
      {
        if (jLe == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_isUpload = bool;
            break;
          }
        }
        if (createTime_HASHCODE == k) {
          this.field_createTime = paramCursor.getLong(i);
        } else if (jLf == k) {
          this.field_lastModifyTime = paramCursor.getLong(i);
        } else if (jLg == k) {
          this.field_fileFullPath = paramCursor.getString(i);
        } else if (jLh == k) {
          this.field_fullXml = paramCursor.getString(i);
        } else if (jLi == k) {
          this.field_msgInfoId = paramCursor.getLong(i);
        } else if (jLj == k) {
          this.field_netTimes = paramCursor.getLong(i);
        } else if (jLk == k) {
          this.field_isUseCdn = paramCursor.getInt(i);
        } else if (jLl == k) {
          this.field_signature = paramCursor.getString(i);
        } else if (jLm == k) {
          this.field_fakeAeskey = paramCursor.getString(i);
        } else if (jLn == k) {
          this.field_fakeSignature = paramCursor.getString(i);
        } else if (rowid_HASHCODE == k) {
          this.systemRowid = paramCursor.getLong(i);
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
    if (this.jKH) {
      localContentValues.put("sdkVer", Long.valueOf(this.field_sdkVer));
    }
    if (this.jKI) {
      localContentValues.put("mediaSvrId", this.field_mediaSvrId);
    }
    if (this.jKJ) {
      localContentValues.put("mediaId", this.field_mediaId);
    }
    if (this.jKK) {
      localContentValues.put("clientAppDataId", this.field_clientAppDataId);
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Long.valueOf(this.field_type));
    }
    if (this.jKL) {
      localContentValues.put("totalLen", Long.valueOf(this.field_totalLen));
    }
    if (this.jKM) {
      localContentValues.put("offset", Long.valueOf(this.field_offset));
    }
    if (this.jIC) {
      localContentValues.put("status", Long.valueOf(this.field_status));
    }
    if (this.jKN) {
      localContentValues.put("isUpload", Boolean.valueOf(this.field_isUpload));
    }
    if (this.__hadSetcreateTime) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.jKO) {
      localContentValues.put("lastModifyTime", Long.valueOf(this.field_lastModifyTime));
    }
    if (this.jKP) {
      localContentValues.put("fileFullPath", this.field_fileFullPath);
    }
    if (this.jKQ) {
      localContentValues.put("fullXml", this.field_fullXml);
    }
    if (this.jKR) {
      localContentValues.put("msgInfoId", Long.valueOf(this.field_msgInfoId));
    }
    if (this.jKS) {
      localContentValues.put("netTimes", Long.valueOf(this.field_netTimes));
    }
    if (this.jKT) {
      localContentValues.put("isUseCdn", Integer.valueOf(this.field_isUseCdn));
    }
    if (this.jKU) {
      localContentValues.put("signature", this.field_signature);
    }
    if (this.jKV) {
      localContentValues.put("fakeAeskey", this.field_fakeAeskey);
    }
    if (this.jKW) {
      localContentValues.put("fakeSignature", this.field_fakeSignature);
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
  
  public StorageObserverOwner<? extends i> getObserverOwner()
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
 * Qualified Name:     com.tencent.mm.autogen.b.i
 * JD-Core Version:    0.7.0.1
 */