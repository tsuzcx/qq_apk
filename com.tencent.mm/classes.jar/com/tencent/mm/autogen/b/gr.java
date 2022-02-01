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

public abstract class gr
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column LOCALID;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("RecordCDNInfo");
  public static final Column TYPE;
  private static final int jIF;
  public static final Column jIz;
  public static final Column jJJ;
  private static final int jKh;
  public static final Column jKs;
  public static final Column jKu;
  public static final Column jKv;
  private static final int jLa;
  private static final int jLc;
  private static final int jLd;
  public static final Column kTA;
  public static final Column kTB;
  public static final Column kTC;
  public static final Column kTD;
  private static final int kTI;
  private static final int kTJ;
  private static final int kTK;
  private static final int kTL;
  public static final Column keB;
  public static final Column ker;
  private static final int kfU;
  private static final int kgd;
  private static final int kiA;
  private static final int kiC;
  public static final Column kiQ;
  public static final Column kir;
  public static final Column kit;
  private static final int kjs;
  public static final Column kkC;
  public static final Column kkL;
  private static final int klK;
  private static final int klT;
  private static final int localId_HASHCODE;
  private static final StorageObserverOwner<gr> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  private static final int type_HASHCODE;
  private boolean __hadSetlocalId = true;
  private boolean __hadSettype = true;
  public String field_cdnKey;
  public String field_cdnUrl;
  public String field_dataId;
  public int field_errCode;
  public int field_fileType;
  public boolean field_isThumb;
  public int field_localId;
  public String field_mediaId;
  public int field_offset;
  public String field_path;
  public int field_recordLocalId;
  public int field_status;
  public String field_toUser;
  public int field_totalLen;
  public String field_tpaeskey;
  public String field_tpauthkey;
  public String field_tpdataurl;
  public int field_type;
  private boolean jIC = true;
  private boolean jJV = true;
  private boolean jKJ = true;
  private boolean jKL = true;
  private boolean jKM = true;
  private boolean kTE = true;
  private boolean kTF = true;
  private boolean kTG = true;
  private boolean kTH = true;
  private boolean kfg = true;
  private boolean kfp = true;
  private boolean kiv = true;
  private boolean kix = true;
  private boolean kje = true;
  private boolean klg = true;
  private boolean klp = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    LOCALID = new Column("localId", "int", TABLE.getName(), "");
    kTA = new Column("recordLocalId", "int", TABLE.getName(), "");
    kiQ = new Column("toUser", "string", TABLE.getName(), "");
    kir = new Column("dataId", "string", TABLE.getName(), "");
    jKs = new Column("mediaId", "string", TABLE.getName(), "");
    jJJ = new Column("path", "string", TABLE.getName(), "");
    ker = new Column("cdnUrl", "string", TABLE.getName(), "");
    kit = new Column("cdnKey", "string", TABLE.getName(), "");
    jKu = new Column("totalLen", "int", TABLE.getName(), "");
    kTB = new Column("isThumb", "boolean", TABLE.getName(), "");
    jKv = new Column("offset", "int", TABLE.getName(), "");
    TYPE = new Column("type", "int", TABLE.getName(), "");
    kkC = new Column("fileType", "int", TABLE.getName(), "");
    jIz = new Column("status", "int", TABLE.getName(), "");
    kkL = new Column("errCode", "int", TABLE.getName(), "");
    kTC = new Column("tpaeskey", "string", TABLE.getName(), "");
    keB = new Column("tpauthkey", "string", TABLE.getName(), "");
    kTD = new Column("tpdataurl", "string", TABLE.getName(), "");
    INDEX_CREATE = new String[] { "CREATE INDEX IF NOT EXISTS record_localid_index ON RecordCDNInfo(recordLocalId)" };
    localId_HASHCODE = "localId".hashCode();
    kTI = "recordLocalId".hashCode();
    kjs = "toUser".hashCode();
    kiA = "dataId".hashCode();
    jLa = "mediaId".hashCode();
    jKh = "path".hashCode();
    kfU = "cdnUrl".hashCode();
    kiC = "cdnKey".hashCode();
    jLc = "totalLen".hashCode();
    kTJ = "isThumb".hashCode();
    jLd = "offset".hashCode();
    type_HASHCODE = "type".hashCode();
    klK = "fileType".hashCode();
    jIF = "status".hashCode();
    klT = "errCode".hashCode();
    kTK = "tpaeskey".hashCode();
    kgd = "tpauthkey".hashCode();
    kTL = "tpdataurl".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[18];
    localMAutoDBInfo.columns = new String[19];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "localId";
    localMAutoDBInfo.colsMap.put("localId", "INTEGER PRIMARY KEY ");
    localStringBuilder.append(" localId INTEGER PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "localId";
    localMAutoDBInfo.columns[1] = "recordLocalId";
    localMAutoDBInfo.colsMap.put("recordLocalId", "INTEGER");
    localStringBuilder.append(" recordLocalId INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "toUser";
    localMAutoDBInfo.colsMap.put("toUser", "TEXT default '' ");
    localStringBuilder.append(" toUser TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "dataId";
    localMAutoDBInfo.colsMap.put("dataId", "TEXT");
    localStringBuilder.append(" dataId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "mediaId";
    localMAutoDBInfo.colsMap.put("mediaId", "TEXT");
    localStringBuilder.append(" mediaId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "path";
    localMAutoDBInfo.colsMap.put("path", "TEXT");
    localStringBuilder.append(" path TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "cdnUrl";
    localMAutoDBInfo.colsMap.put("cdnUrl", "TEXT");
    localStringBuilder.append(" cdnUrl TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "cdnKey";
    localMAutoDBInfo.colsMap.put("cdnKey", "TEXT");
    localStringBuilder.append(" cdnKey TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "totalLen";
    localMAutoDBInfo.colsMap.put("totalLen", "INTEGER default '0' ");
    localStringBuilder.append(" totalLen INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "isThumb";
    localMAutoDBInfo.colsMap.put("isThumb", "INTEGER default 'false' ");
    localStringBuilder.append(" isThumb INTEGER default 'false' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[10] = "offset";
    localMAutoDBInfo.colsMap.put("offset", "INTEGER default '0' ");
    localStringBuilder.append(" offset INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[11] = "type";
    localMAutoDBInfo.colsMap.put("type", "INTEGER default '0' ");
    localStringBuilder.append(" type INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[12] = "fileType";
    localMAutoDBInfo.colsMap.put("fileType", "INTEGER default '5' ");
    localStringBuilder.append(" fileType INTEGER default '5' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[13] = "status";
    localMAutoDBInfo.colsMap.put("status", "INTEGER default '0' ");
    localStringBuilder.append(" status INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[14] = "errCode";
    localMAutoDBInfo.colsMap.put("errCode", "INTEGER default '0' ");
    localStringBuilder.append(" errCode INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[15] = "tpaeskey";
    localMAutoDBInfo.colsMap.put("tpaeskey", "TEXT");
    localStringBuilder.append(" tpaeskey TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[16] = "tpauthkey";
    localMAutoDBInfo.colsMap.put("tpauthkey", "TEXT");
    localStringBuilder.append(" tpauthkey TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[17] = "tpdataurl";
    localMAutoDBInfo.colsMap.put("tpdataurl", "TEXT");
    localStringBuilder.append(" tpdataurl TEXT");
    localMAutoDBInfo.columns[18] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("localId"))
    {
      this.field_localId = paramContentValues.getAsInteger("localId").intValue();
      if (paramBoolean) {
        this.__hadSetlocalId = true;
      }
    }
    if (paramContentValues.containsKey("recordLocalId"))
    {
      this.field_recordLocalId = paramContentValues.getAsInteger("recordLocalId").intValue();
      if (paramBoolean) {
        this.kTE = true;
      }
    }
    if (paramContentValues.containsKey("toUser"))
    {
      this.field_toUser = paramContentValues.getAsString("toUser");
      if (paramBoolean) {
        this.kje = true;
      }
    }
    if (paramContentValues.containsKey("dataId"))
    {
      this.field_dataId = paramContentValues.getAsString("dataId");
      if (paramBoolean) {
        this.kiv = true;
      }
    }
    if (paramContentValues.containsKey("mediaId"))
    {
      this.field_mediaId = paramContentValues.getAsString("mediaId");
      if (paramBoolean) {
        this.jKJ = true;
      }
    }
    if (paramContentValues.containsKey("path"))
    {
      this.field_path = paramContentValues.getAsString("path");
      if (paramBoolean) {
        this.jJV = true;
      }
    }
    if (paramContentValues.containsKey("cdnUrl"))
    {
      this.field_cdnUrl = paramContentValues.getAsString("cdnUrl");
      if (paramBoolean) {
        this.kfg = true;
      }
    }
    if (paramContentValues.containsKey("cdnKey"))
    {
      this.field_cdnKey = paramContentValues.getAsString("cdnKey");
      if (paramBoolean) {
        this.kix = true;
      }
    }
    if (paramContentValues.containsKey("totalLen"))
    {
      this.field_totalLen = paramContentValues.getAsInteger("totalLen").intValue();
      if (paramBoolean) {
        this.jKL = true;
      }
    }
    if (paramContentValues.containsKey("isThumb")) {
      if (paramContentValues.getAsInteger("isThumb").intValue() == 0) {
        break label560;
      }
    }
    label560:
    for (boolean bool = true;; bool = false)
    {
      this.field_isThumb = bool;
      if (paramBoolean) {
        this.kTF = true;
      }
      if (paramContentValues.containsKey("offset"))
      {
        this.field_offset = paramContentValues.getAsInteger("offset").intValue();
        if (paramBoolean) {
          this.jKM = true;
        }
      }
      if (paramContentValues.containsKey("type"))
      {
        this.field_type = paramContentValues.getAsInteger("type").intValue();
        if (paramBoolean) {
          this.__hadSettype = true;
        }
      }
      if (paramContentValues.containsKey("fileType"))
      {
        this.field_fileType = paramContentValues.getAsInteger("fileType").intValue();
        if (paramBoolean) {
          this.klg = true;
        }
      }
      if (paramContentValues.containsKey("status"))
      {
        this.field_status = paramContentValues.getAsInteger("status").intValue();
        if (paramBoolean) {
          this.jIC = true;
        }
      }
      if (paramContentValues.containsKey("errCode"))
      {
        this.field_errCode = paramContentValues.getAsInteger("errCode").intValue();
        if (paramBoolean) {
          this.klp = true;
        }
      }
      if (paramContentValues.containsKey("tpaeskey"))
      {
        this.field_tpaeskey = paramContentValues.getAsString("tpaeskey");
        if (paramBoolean) {
          this.kTG = true;
        }
      }
      if (paramContentValues.containsKey("tpauthkey"))
      {
        this.field_tpauthkey = paramContentValues.getAsString("tpauthkey");
        if (paramBoolean) {
          this.kfp = true;
        }
      }
      if (paramContentValues.containsKey("tpdataurl"))
      {
        this.field_tpdataurl = paramContentValues.getAsString("tpdataurl");
        if (paramBoolean) {
          this.kTH = true;
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
      if (localId_HASHCODE != k) {
        break label65;
      }
      this.field_localId = paramCursor.getInt(i);
      this.__hadSetlocalId = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (kTI == k)
      {
        this.field_recordLocalId = paramCursor.getInt(i);
      }
      else if (kjs == k)
      {
        this.field_toUser = paramCursor.getString(i);
      }
      else if (kiA == k)
      {
        this.field_dataId = paramCursor.getString(i);
      }
      else if (jLa == k)
      {
        this.field_mediaId = paramCursor.getString(i);
      }
      else if (jKh == k)
      {
        this.field_path = paramCursor.getString(i);
      }
      else if (kfU == k)
      {
        this.field_cdnUrl = paramCursor.getString(i);
      }
      else if (kiC == k)
      {
        this.field_cdnKey = paramCursor.getString(i);
      }
      else if (jLc == k)
      {
        this.field_totalLen = paramCursor.getInt(i);
      }
      else
      {
        if (kTJ == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_isThumb = bool;
            break;
          }
        }
        if (jLd == k) {
          this.field_offset = paramCursor.getInt(i);
        } else if (type_HASHCODE == k) {
          this.field_type = paramCursor.getInt(i);
        } else if (klK == k) {
          this.field_fileType = paramCursor.getInt(i);
        } else if (jIF == k) {
          this.field_status = paramCursor.getInt(i);
        } else if (klT == k) {
          this.field_errCode = paramCursor.getInt(i);
        } else if (kTK == k) {
          this.field_tpaeskey = paramCursor.getString(i);
        } else if (kgd == k) {
          this.field_tpauthkey = paramCursor.getString(i);
        } else if (kTL == k) {
          this.field_tpdataurl = paramCursor.getString(i);
        } else if (rowid_HASHCODE == k) {
          this.systemRowid = paramCursor.getLong(i);
        }
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.__hadSetlocalId) {
      localContentValues.put("localId", Integer.valueOf(this.field_localId));
    }
    if (this.kTE) {
      localContentValues.put("recordLocalId", Integer.valueOf(this.field_recordLocalId));
    }
    if (this.field_toUser == null) {
      this.field_toUser = "";
    }
    if (this.kje) {
      localContentValues.put("toUser", this.field_toUser);
    }
    if (this.kiv) {
      localContentValues.put("dataId", this.field_dataId);
    }
    if (this.jKJ) {
      localContentValues.put("mediaId", this.field_mediaId);
    }
    if (this.jJV) {
      localContentValues.put("path", this.field_path);
    }
    if (this.kfg) {
      localContentValues.put("cdnUrl", this.field_cdnUrl);
    }
    if (this.kix) {
      localContentValues.put("cdnKey", this.field_cdnKey);
    }
    if (this.jKL) {
      localContentValues.put("totalLen", Integer.valueOf(this.field_totalLen));
    }
    if (this.kTF) {
      localContentValues.put("isThumb", Boolean.valueOf(this.field_isThumb));
    }
    if (this.jKM) {
      localContentValues.put("offset", Integer.valueOf(this.field_offset));
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.klg) {
      localContentValues.put("fileType", Integer.valueOf(this.field_fileType));
    }
    if (this.jIC) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.klp) {
      localContentValues.put("errCode", Integer.valueOf(this.field_errCode));
    }
    if (this.kTG) {
      localContentValues.put("tpaeskey", this.field_tpaeskey);
    }
    if (this.kfp) {
      localContentValues.put("tpauthkey", this.field_tpauthkey);
    }
    if (this.kTH) {
      localContentValues.put("tpdataurl", this.field_tpdataurl);
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
  
  public StorageObserverOwner<? extends gr> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return Integer.valueOf(this.field_localId);
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
 * Qualified Name:     com.tencent.mm.autogen.b.gr
 * JD-Core Version:    0.7.0.1
 */