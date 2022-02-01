package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class bt
  extends c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS FavCdnTransferInfo_LocalId ON FavCdnInfo(favLocalId)", "CREATE INDEX IF NOT EXISTS FavCDNInfo_modifyTime_Index ON FavCdnInfo(modifyTime)" };
  private static final int eBI;
  private static final int eDC = "dataId".hashCode();
  private static final int eDD = "favLocalId".hashCode();
  private static final int eDE;
  private static final int eDF = "extFlag".hashCode();
  private static final int eDG = "attrFlag".hashCode();
  private static final int elV;
  private static final int enT;
  private static final int enU;
  private static final int eoG;
  private static final int eor;
  private static final int epS;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE = "type".hashCode();
  private boolean __hadSettype = true;
  private boolean eAW = true;
  private boolean eDA = true;
  private boolean eDB = true;
  private boolean eDx = true;
  private boolean eDy = true;
  private boolean eDz = true;
  private boolean elS = true;
  private boolean enC = true;
  private boolean enD = true;
  private boolean eoE = true;
  private boolean eon = true;
  private boolean epw = true;
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
    eBI = "cdnUrl".hashCode();
    eDE = "cdnKey".hashCode();
    enT = "totalLen".hashCode();
    enU = "offset".hashCode();
    elV = "status".hashCode();
    eor = "path".hashCode();
    eoG = "dataType".hashCode();
    epS = "modifyTime".hashCode();
  }
  
  public static c.a Th()
  {
    c.a locala = new c.a();
    locala.GvF = new Field[13];
    locala.columns = new String[14];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "dataId";
    locala.GvH.put("dataId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" dataId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.GvG = "dataId";
    locala.columns[1] = "favLocalId";
    locala.GvH.put("favLocalId", "LONG");
    localStringBuilder.append(" favLocalId LONG");
    localStringBuilder.append(", ");
    locala.columns[2] = "type";
    locala.GvH.put("type", "INTEGER");
    localStringBuilder.append(" type INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "cdnUrl";
    locala.GvH.put("cdnUrl", "TEXT");
    localStringBuilder.append(" cdnUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "cdnKey";
    locala.GvH.put("cdnKey", "TEXT");
    localStringBuilder.append(" cdnKey TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "totalLen";
    locala.GvH.put("totalLen", "INTEGER");
    localStringBuilder.append(" totalLen INTEGER");
    localStringBuilder.append(", ");
    locala.columns[6] = "offset";
    locala.GvH.put("offset", "INTEGER");
    localStringBuilder.append(" offset INTEGER");
    localStringBuilder.append(", ");
    locala.columns[7] = "status";
    locala.GvH.put("status", "INTEGER");
    localStringBuilder.append(" status INTEGER");
    localStringBuilder.append(", ");
    locala.columns[8] = "path";
    locala.GvH.put("path", "TEXT");
    localStringBuilder.append(" path TEXT");
    localStringBuilder.append(", ");
    locala.columns[9] = "dataType";
    locala.GvH.put("dataType", "INTEGER");
    localStringBuilder.append(" dataType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[10] = "modifyTime";
    locala.GvH.put("modifyTime", "LONG default '0' ");
    localStringBuilder.append(" modifyTime LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[11] = "extFlag";
    locala.GvH.put("extFlag", "INTEGER default '0' ");
    localStringBuilder.append(" extFlag INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[12] = "attrFlag";
    locala.GvH.put("attrFlag", "LONG default '0' ");
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
      if (eDC != k) {
        break label65;
      }
      this.field_dataId = paramCursor.getString(i);
      this.eDx = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eDD == k) {
        this.field_favLocalId = paramCursor.getLong(i);
      } else if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (eBI == k) {
        this.field_cdnUrl = paramCursor.getString(i);
      } else if (eDE == k) {
        this.field_cdnKey = paramCursor.getString(i);
      } else if (enT == k) {
        this.field_totalLen = paramCursor.getInt(i);
      } else if (enU == k) {
        this.field_offset = paramCursor.getInt(i);
      } else if (elV == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (eor == k) {
        this.field_path = paramCursor.getString(i);
      } else if (eoG == k) {
        this.field_dataType = paramCursor.getInt(i);
      } else if (epS == k) {
        this.field_modifyTime = paramCursor.getLong(i);
      } else if (eDF == k) {
        this.field_extFlag = paramCursor.getInt(i);
      } else if (eDG == k) {
        this.field_attrFlag = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eDx) {
      localContentValues.put("dataId", this.field_dataId);
    }
    if (this.eDy) {
      localContentValues.put("favLocalId", Long.valueOf(this.field_favLocalId));
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.eAW) {
      localContentValues.put("cdnUrl", this.field_cdnUrl);
    }
    if (this.eDz) {
      localContentValues.put("cdnKey", this.field_cdnKey);
    }
    if (this.enC) {
      localContentValues.put("totalLen", Integer.valueOf(this.field_totalLen));
    }
    if (this.enD) {
      localContentValues.put("offset", Integer.valueOf(this.field_offset));
    }
    if (this.elS) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.eon) {
      localContentValues.put("path", this.field_path);
    }
    if (this.eoE) {
      localContentValues.put("dataType", Integer.valueOf(this.field_dataType));
    }
    if (this.epw) {
      localContentValues.put("modifyTime", Long.valueOf(this.field_modifyTime));
    }
    if (this.eDA) {
      localContentValues.put("extFlag", Integer.valueOf(this.field_extFlag));
    }
    if (this.eDB) {
      localContentValues.put("attrFlag", Long.valueOf(this.field_attrFlag));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.bt
 * JD-Core Version:    0.7.0.1
 */