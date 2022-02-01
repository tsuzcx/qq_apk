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

public abstract class by
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("FavCdnInfo");
  public static final Column TYPE;
  private static final int jIF;
  public static final Column jIz;
  public static final Column jJJ;
  private static final int jKh;
  public static final Column jKu;
  public static final Column jKv;
  public static final Column jLP;
  private static final int jLT;
  private static final int jLc;
  private static final int jLd;
  private static final int jNY;
  public static final Column jNg;
  public static final Column kba;
  public static final Column ker;
  private static final int kfU;
  private static final int kiA;
  private static final int kiB;
  private static final int kiC;
  private static final int kiD;
  private static final int kiE;
  public static final Column kir;
  public static final Column kis;
  public static final Column kit;
  public static final Column kiu;
  private static final StorageObserverOwner<by> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  private static final int type_HASHCODE;
  private boolean __hadSettype = true;
  public long field_attrFlag;
  public String field_cdnKey;
  public String field_cdnUrl;
  public String field_dataId;
  public int field_dataType;
  public int field_extFlag;
  public long field_favLocalId;
  public long field_modifyTime;
  public int field_offset;
  public String field_path;
  public int field_status;
  public int field_totalLen;
  public int field_type;
  private boolean jIC = true;
  private boolean jJV = true;
  private boolean jKL = true;
  private boolean jKM = true;
  private boolean jLR = true;
  private boolean jNC = true;
  private boolean kfg = true;
  private boolean kiv = true;
  private boolean kiw = true;
  private boolean kix = true;
  private boolean kiy = true;
  private boolean kiz = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    kir = new Column("dataId", "string", TABLE.getName(), "");
    kis = new Column("favLocalId", "long", TABLE.getName(), "");
    TYPE = new Column("type", "int", TABLE.getName(), "");
    ker = new Column("cdnUrl", "string", TABLE.getName(), "");
    kit = new Column("cdnKey", "string", TABLE.getName(), "");
    jKu = new Column("totalLen", "int", TABLE.getName(), "");
    jKv = new Column("offset", "int", TABLE.getName(), "");
    jIz = new Column("status", "int", TABLE.getName(), "");
    jJJ = new Column("path", "string", TABLE.getName(), "");
    jLP = new Column("dataType", "int", TABLE.getName(), "");
    jNg = new Column("modifyTime", "long", TABLE.getName(), "");
    kiu = new Column("extFlag", "int", TABLE.getName(), "");
    kba = new Column("attrFlag", "long", TABLE.getName(), "");
    INDEX_CREATE = new String[] { "CREATE INDEX IF NOT EXISTS FavCdnTransferInfo_LocalId ON FavCdnInfo(favLocalId)", "CREATE INDEX IF NOT EXISTS FavCDNInfo_modifyTime_Index ON FavCdnInfo(modifyTime)" };
    kiA = "dataId".hashCode();
    kiB = "favLocalId".hashCode();
    type_HASHCODE = "type".hashCode();
    kfU = "cdnUrl".hashCode();
    kiC = "cdnKey".hashCode();
    jLc = "totalLen".hashCode();
    jLd = "offset".hashCode();
    jIF = "status".hashCode();
    jKh = "path".hashCode();
    jLT = "dataType".hashCode();
    jNY = "modifyTime".hashCode();
    kiD = "extFlag".hashCode();
    kiE = "attrFlag".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[13];
    localMAutoDBInfo.columns = new String[14];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "dataId";
    localMAutoDBInfo.colsMap.put("dataId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" dataId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "dataId";
    localMAutoDBInfo.columns[1] = "favLocalId";
    localMAutoDBInfo.colsMap.put("favLocalId", "LONG");
    localStringBuilder.append(" favLocalId LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "type";
    localMAutoDBInfo.colsMap.put("type", "INTEGER");
    localStringBuilder.append(" type INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "cdnUrl";
    localMAutoDBInfo.colsMap.put("cdnUrl", "TEXT");
    localStringBuilder.append(" cdnUrl TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "cdnKey";
    localMAutoDBInfo.colsMap.put("cdnKey", "TEXT");
    localStringBuilder.append(" cdnKey TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "totalLen";
    localMAutoDBInfo.colsMap.put("totalLen", "INTEGER");
    localStringBuilder.append(" totalLen INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "offset";
    localMAutoDBInfo.colsMap.put("offset", "INTEGER");
    localStringBuilder.append(" offset INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "status";
    localMAutoDBInfo.colsMap.put("status", "INTEGER");
    localStringBuilder.append(" status INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "path";
    localMAutoDBInfo.colsMap.put("path", "TEXT");
    localStringBuilder.append(" path TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "dataType";
    localMAutoDBInfo.colsMap.put("dataType", "INTEGER");
    localStringBuilder.append(" dataType INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[10] = "modifyTime";
    localMAutoDBInfo.colsMap.put("modifyTime", "LONG default '0' ");
    localStringBuilder.append(" modifyTime LONG default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[11] = "extFlag";
    localMAutoDBInfo.colsMap.put("extFlag", "INTEGER default '0' ");
    localStringBuilder.append(" extFlag INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[12] = "attrFlag";
    localMAutoDBInfo.colsMap.put("attrFlag", "LONG default '0' ");
    localStringBuilder.append(" attrFlag LONG default '0' ");
    localMAutoDBInfo.columns[13] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("dataId"))
    {
      this.field_dataId = paramContentValues.getAsString("dataId");
      if (paramBoolean) {
        this.kiv = true;
      }
    }
    if (paramContentValues.containsKey("favLocalId"))
    {
      this.field_favLocalId = paramContentValues.getAsLong("favLocalId").longValue();
      if (paramBoolean) {
        this.kiw = true;
      }
    }
    if (paramContentValues.containsKey("type"))
    {
      this.field_type = paramContentValues.getAsInteger("type").intValue();
      if (paramBoolean) {
        this.__hadSettype = true;
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
    if (paramContentValues.containsKey("offset"))
    {
      this.field_offset = paramContentValues.getAsInteger("offset").intValue();
      if (paramBoolean) {
        this.jKM = true;
      }
    }
    if (paramContentValues.containsKey("status"))
    {
      this.field_status = paramContentValues.getAsInteger("status").intValue();
      if (paramBoolean) {
        this.jIC = true;
      }
    }
    if (paramContentValues.containsKey("path"))
    {
      this.field_path = paramContentValues.getAsString("path");
      if (paramBoolean) {
        this.jJV = true;
      }
    }
    if (paramContentValues.containsKey("dataType"))
    {
      this.field_dataType = paramContentValues.getAsInteger("dataType").intValue();
      if (paramBoolean) {
        this.jLR = true;
      }
    }
    if (paramContentValues.containsKey("modifyTime"))
    {
      this.field_modifyTime = paramContentValues.getAsLong("modifyTime").longValue();
      if (paramBoolean) {
        this.jNC = true;
      }
    }
    if (paramContentValues.containsKey("extFlag"))
    {
      this.field_extFlag = paramContentValues.getAsInteger("extFlag").intValue();
      if (paramBoolean) {
        this.kiy = true;
      }
    }
    if (paramContentValues.containsKey("attrFlag"))
    {
      this.field_attrFlag = paramContentValues.getAsLong("attrFlag").longValue();
      if (paramBoolean) {
        this.kiz = true;
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
      if (kiA != k) {
        break label65;
      }
      this.field_dataId = paramCursor.getString(i);
      this.kiv = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (kiB == k) {
        this.field_favLocalId = paramCursor.getLong(i);
      } else if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (kfU == k) {
        this.field_cdnUrl = paramCursor.getString(i);
      } else if (kiC == k) {
        this.field_cdnKey = paramCursor.getString(i);
      } else if (jLc == k) {
        this.field_totalLen = paramCursor.getInt(i);
      } else if (jLd == k) {
        this.field_offset = paramCursor.getInt(i);
      } else if (jIF == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (jKh == k) {
        this.field_path = paramCursor.getString(i);
      } else if (jLT == k) {
        this.field_dataType = paramCursor.getInt(i);
      } else if (jNY == k) {
        this.field_modifyTime = paramCursor.getLong(i);
      } else if (kiD == k) {
        this.field_extFlag = paramCursor.getInt(i);
      } else if (kiE == k) {
        this.field_attrFlag = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.kiv) {
      localContentValues.put("dataId", this.field_dataId);
    }
    if (this.kiw) {
      localContentValues.put("favLocalId", Long.valueOf(this.field_favLocalId));
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
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
    if (this.jKM) {
      localContentValues.put("offset", Integer.valueOf(this.field_offset));
    }
    if (this.jIC) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.jJV) {
      localContentValues.put("path", this.field_path);
    }
    if (this.jLR) {
      localContentValues.put("dataType", Integer.valueOf(this.field_dataType));
    }
    if (this.jNC) {
      localContentValues.put("modifyTime", Long.valueOf(this.field_modifyTime));
    }
    if (this.kiy) {
      localContentValues.put("extFlag", Integer.valueOf(this.field_extFlag));
    }
    if (this.kiz) {
      localContentValues.put("attrFlag", Long.valueOf(this.field_attrFlag));
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
  
  public StorageObserverOwner<? extends by> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return this.field_dataId;
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
 * Qualified Name:     com.tencent.mm.autogen.b.by
 * JD-Core Version:    0.7.0.1
 */