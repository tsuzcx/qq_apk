package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class bu
  extends c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS FavCdnTransferInfo_LocalId ON FavCdnInfo(favLocalId)", "CREATE INDEX IF NOT EXISTS FavCDNInfo_modifyTime_Index ON FavCdnInfo(modifyTime)" };
  private static final int eEL = "status".hashCode();
  private static final int eGI;
  private static final int eGJ;
  private static final int eHf = "path".hashCode();
  private static final int eHu = "dataType".hashCode();
  private static final int eIK = "modifyTime".hashCode();
  private static final int eUR;
  private static final int eWL = "dataId".hashCode();
  private static final int eWM = "favLocalId".hashCode();
  private static final int eWN;
  private static final int eWO = "extFlag".hashCode();
  private static final int eWP = "attrFlag".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE = "type".hashCode();
  private boolean __hadSettype = true;
  private boolean eEI = true;
  private boolean eGr = true;
  private boolean eGs = true;
  private boolean eHb = true;
  private boolean eHs = true;
  private boolean eIo = true;
  private boolean eUf = true;
  private boolean eWG = true;
  private boolean eWH = true;
  private boolean eWI = true;
  private boolean eWJ = true;
  private boolean eWK = true;
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
  
  static
  {
    eUR = "cdnUrl".hashCode();
    eWN = "cdnKey".hashCode();
    eGI = "totalLen".hashCode();
    eGJ = "offset".hashCode();
  }
  
  public static c.a VD()
  {
    c.a locala = new c.a();
    locala.IBL = new Field[13];
    locala.columns = new String[14];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "dataId";
    locala.IBN.put("dataId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" dataId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IBM = "dataId";
    locala.columns[1] = "favLocalId";
    locala.IBN.put("favLocalId", "LONG");
    localStringBuilder.append(" favLocalId LONG");
    localStringBuilder.append(", ");
    locala.columns[2] = "type";
    locala.IBN.put("type", "INTEGER");
    localStringBuilder.append(" type INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "cdnUrl";
    locala.IBN.put("cdnUrl", "TEXT");
    localStringBuilder.append(" cdnUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "cdnKey";
    locala.IBN.put("cdnKey", "TEXT");
    localStringBuilder.append(" cdnKey TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "totalLen";
    locala.IBN.put("totalLen", "INTEGER");
    localStringBuilder.append(" totalLen INTEGER");
    localStringBuilder.append(", ");
    locala.columns[6] = "offset";
    locala.IBN.put("offset", "INTEGER");
    localStringBuilder.append(" offset INTEGER");
    localStringBuilder.append(", ");
    locala.columns[7] = "status";
    locala.IBN.put("status", "INTEGER");
    localStringBuilder.append(" status INTEGER");
    localStringBuilder.append(", ");
    locala.columns[8] = "path";
    locala.IBN.put("path", "TEXT");
    localStringBuilder.append(" path TEXT");
    localStringBuilder.append(", ");
    locala.columns[9] = "dataType";
    locala.IBN.put("dataType", "INTEGER");
    localStringBuilder.append(" dataType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[10] = "modifyTime";
    locala.IBN.put("modifyTime", "LONG default '0' ");
    localStringBuilder.append(" modifyTime LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[11] = "extFlag";
    locala.IBN.put("extFlag", "INTEGER default '0' ");
    localStringBuilder.append(" extFlag INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[12] = "attrFlag";
    locala.IBN.put("attrFlag", "LONG default '0' ");
    localStringBuilder.append(" attrFlag LONG default '0' ");
    locala.columns[13] = "rowid";
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
      if (eWL != k) {
        break label65;
      }
      this.field_dataId = paramCursor.getString(i);
      this.eWG = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eWM == k) {
        this.field_favLocalId = paramCursor.getLong(i);
      } else if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (eUR == k) {
        this.field_cdnUrl = paramCursor.getString(i);
      } else if (eWN == k) {
        this.field_cdnKey = paramCursor.getString(i);
      } else if (eGI == k) {
        this.field_totalLen = paramCursor.getInt(i);
      } else if (eGJ == k) {
        this.field_offset = paramCursor.getInt(i);
      } else if (eEL == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (eHf == k) {
        this.field_path = paramCursor.getString(i);
      } else if (eHu == k) {
        this.field_dataType = paramCursor.getInt(i);
      } else if (eIK == k) {
        this.field_modifyTime = paramCursor.getLong(i);
      } else if (eWO == k) {
        this.field_extFlag = paramCursor.getInt(i);
      } else if (eWP == k) {
        this.field_attrFlag = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eWG) {
      localContentValues.put("dataId", this.field_dataId);
    }
    if (this.eWH) {
      localContentValues.put("favLocalId", Long.valueOf(this.field_favLocalId));
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.eUf) {
      localContentValues.put("cdnUrl", this.field_cdnUrl);
    }
    if (this.eWI) {
      localContentValues.put("cdnKey", this.field_cdnKey);
    }
    if (this.eGr) {
      localContentValues.put("totalLen", Integer.valueOf(this.field_totalLen));
    }
    if (this.eGs) {
      localContentValues.put("offset", Integer.valueOf(this.field_offset));
    }
    if (this.eEI) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.eHb) {
      localContentValues.put("path", this.field_path);
    }
    if (this.eHs) {
      localContentValues.put("dataType", Integer.valueOf(this.field_dataType));
    }
    if (this.eIo) {
      localContentValues.put("modifyTime", Long.valueOf(this.field_modifyTime));
    }
    if (this.eWJ) {
      localContentValues.put("extFlag", Integer.valueOf(this.field_extFlag));
    }
    if (this.eWK) {
      localContentValues.put("attrFlag", Long.valueOf(this.field_attrFlag));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.bu
 * JD-Core Version:    0.7.0.1
 */