package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class bv
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final Column C_TYPE;
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS FavCdnTransferInfo_LocalId ON FavCdnInfo(favLocalId)", "CREATE INDEX IF NOT EXISTS FavCDNInfo_modifyTime_Index ON FavCdnInfo(modifyTime)" };
  public static final SingleTable TABLE = new SingleTable("FavCdnInfo");
  public static final Column hEf;
  public static final Column hHn;
  private static final int hIP;
  public static final Column hLm;
  public static final Column hLn;
  public static final Column hLo;
  public static final Column hLp;
  private static final int hLv;
  private static final int hLw;
  private static final int hLx;
  private static final int hLy = "extFlag".hashCode();
  private static final int hLz = "attrFlag".hashCode();
  private static final int hmC;
  public static final Column hmw;
  public static final Column hnE;
  public static final Column hnF;
  public static final Column hoC;
  private static final int hoK;
  private static final int hom;
  private static final int hon;
  public static final Column hpc;
  private static final int hpg;
  public static final Column hqt;
  private static final int hrl;
  private static final int rowid_HASHCODE = "rowid".hashCode();
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
  private boolean hIb = true;
  private boolean hLq = true;
  private boolean hLr = true;
  private boolean hLs = true;
  private boolean hLt = true;
  private boolean hLu = true;
  private boolean hmz = true;
  private boolean hnV = true;
  private boolean hnW = true;
  private boolean hoG = true;
  private boolean hpe = true;
  private boolean hqP = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "FavCdnInfo", "");
    hLm = new Column("dataid", "string", "FavCdnInfo", "");
    hLn = new Column("favlocalid", "long", "FavCdnInfo", "");
    C_TYPE = new Column("type", "int", "FavCdnInfo", "");
    hHn = new Column("cdnurl", "string", "FavCdnInfo", "");
    hLo = new Column("cdnkey", "string", "FavCdnInfo", "");
    hnE = new Column("totallen", "int", "FavCdnInfo", "");
    hnF = new Column("offset", "int", "FavCdnInfo", "");
    hmw = new Column("status", "int", "FavCdnInfo", "");
    hoC = new Column("path", "string", "FavCdnInfo", "");
    hpc = new Column("datatype", "int", "FavCdnInfo", "");
    hqt = new Column("modifytime", "long", "FavCdnInfo", "");
    hLp = new Column("extflag", "int", "FavCdnInfo", "");
    hEf = new Column("attrflag", "long", "FavCdnInfo", "");
    hLv = "dataId".hashCode();
    hLw = "favLocalId".hashCode();
    type_HASHCODE = "type".hashCode();
    hIP = "cdnUrl".hashCode();
    hLx = "cdnKey".hashCode();
    hom = "totalLen".hashCode();
    hon = "offset".hashCode();
    hmC = "status".hashCode();
    hoK = "path".hashCode();
    hpg = "dataType".hashCode();
    hrl = "modifyTime".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aoY()
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
      if (hLv != k) {
        break label65;
      }
      this.field_dataId = paramCursor.getString(i);
      this.hLq = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (hLw == k) {
        this.field_favLocalId = paramCursor.getLong(i);
      } else if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (hIP == k) {
        this.field_cdnUrl = paramCursor.getString(i);
      } else if (hLx == k) {
        this.field_cdnKey = paramCursor.getString(i);
      } else if (hom == k) {
        this.field_totalLen = paramCursor.getInt(i);
      } else if (hon == k) {
        this.field_offset = paramCursor.getInt(i);
      } else if (hmC == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (hoK == k) {
        this.field_path = paramCursor.getString(i);
      } else if (hpg == k) {
        this.field_dataType = paramCursor.getInt(i);
      } else if (hrl == k) {
        this.field_modifyTime = paramCursor.getLong(i);
      } else if (hLy == k) {
        this.field_extFlag = paramCursor.getInt(i);
      } else if (hLz == k) {
        this.field_attrFlag = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.hLq) {
      localContentValues.put("dataId", this.field_dataId);
    }
    if (this.hLr) {
      localContentValues.put("favLocalId", Long.valueOf(this.field_favLocalId));
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.hIb) {
      localContentValues.put("cdnUrl", this.field_cdnUrl);
    }
    if (this.hLs) {
      localContentValues.put("cdnKey", this.field_cdnKey);
    }
    if (this.hnV) {
      localContentValues.put("totalLen", Integer.valueOf(this.field_totalLen));
    }
    if (this.hnW) {
      localContentValues.put("offset", Integer.valueOf(this.field_offset));
    }
    if (this.hmz) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.hoG) {
      localContentValues.put("path", this.field_path);
    }
    if (this.hpe) {
      localContentValues.put("dataType", Integer.valueOf(this.field_dataType));
    }
    if (this.hqP) {
      localContentValues.put("modifyTime", Long.valueOf(this.field_modifyTime));
    }
    if (this.hLt) {
      localContentValues.put("extFlag", Integer.valueOf(this.field_extFlag));
    }
    if (this.hLu) {
      localContentValues.put("attrFlag", Long.valueOf(this.field_attrFlag));
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
    return "FavCdnInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.c.bv
 * JD-Core Version:    0.7.0.1
 */