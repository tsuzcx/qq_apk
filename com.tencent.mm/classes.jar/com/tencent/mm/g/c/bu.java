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
  private static final int eDc;
  private static final int eEZ;
  private static final int eFL = "dataType".hashCode();
  private static final int eFa;
  private static final int eFw;
  private static final int eHb = "modifyTime".hashCode();
  private static final int eTg;
  private static final int eVa = "dataId".hashCode();
  private static final int eVb = "favLocalId".hashCode();
  private static final int eVc;
  private static final int eVd = "extFlag".hashCode();
  private static final int eVe = "attrFlag".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE = "type".hashCode();
  private boolean __hadSettype = true;
  private boolean eCZ = true;
  private boolean eEI = true;
  private boolean eEJ = true;
  private boolean eFJ = true;
  private boolean eFs = true;
  private boolean eGF = true;
  private boolean eSu = true;
  private boolean eUV = true;
  private boolean eUW = true;
  private boolean eUX = true;
  private boolean eUY = true;
  private boolean eUZ = true;
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
    eTg = "cdnUrl".hashCode();
    eVc = "cdnKey".hashCode();
    eEZ = "totalLen".hashCode();
    eFa = "offset".hashCode();
    eDc = "status".hashCode();
    eFw = "path".hashCode();
  }
  
  public static c.a Vv()
  {
    c.a locala = new c.a();
    locala.IhA = new Field[13];
    locala.columns = new String[14];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "dataId";
    locala.IhC.put("dataId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" dataId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IhB = "dataId";
    locala.columns[1] = "favLocalId";
    locala.IhC.put("favLocalId", "LONG");
    localStringBuilder.append(" favLocalId LONG");
    localStringBuilder.append(", ");
    locala.columns[2] = "type";
    locala.IhC.put("type", "INTEGER");
    localStringBuilder.append(" type INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "cdnUrl";
    locala.IhC.put("cdnUrl", "TEXT");
    localStringBuilder.append(" cdnUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "cdnKey";
    locala.IhC.put("cdnKey", "TEXT");
    localStringBuilder.append(" cdnKey TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "totalLen";
    locala.IhC.put("totalLen", "INTEGER");
    localStringBuilder.append(" totalLen INTEGER");
    localStringBuilder.append(", ");
    locala.columns[6] = "offset";
    locala.IhC.put("offset", "INTEGER");
    localStringBuilder.append(" offset INTEGER");
    localStringBuilder.append(", ");
    locala.columns[7] = "status";
    locala.IhC.put("status", "INTEGER");
    localStringBuilder.append(" status INTEGER");
    localStringBuilder.append(", ");
    locala.columns[8] = "path";
    locala.IhC.put("path", "TEXT");
    localStringBuilder.append(" path TEXT");
    localStringBuilder.append(", ");
    locala.columns[9] = "dataType";
    locala.IhC.put("dataType", "INTEGER");
    localStringBuilder.append(" dataType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[10] = "modifyTime";
    locala.IhC.put("modifyTime", "LONG default '0' ");
    localStringBuilder.append(" modifyTime LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[11] = "extFlag";
    locala.IhC.put("extFlag", "INTEGER default '0' ");
    localStringBuilder.append(" extFlag INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[12] = "attrFlag";
    locala.IhC.put("attrFlag", "LONG default '0' ");
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
      if (eVa != k) {
        break label65;
      }
      this.field_dataId = paramCursor.getString(i);
      this.eUV = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eVb == k) {
        this.field_favLocalId = paramCursor.getLong(i);
      } else if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (eTg == k) {
        this.field_cdnUrl = paramCursor.getString(i);
      } else if (eVc == k) {
        this.field_cdnKey = paramCursor.getString(i);
      } else if (eEZ == k) {
        this.field_totalLen = paramCursor.getInt(i);
      } else if (eFa == k) {
        this.field_offset = paramCursor.getInt(i);
      } else if (eDc == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (eFw == k) {
        this.field_path = paramCursor.getString(i);
      } else if (eFL == k) {
        this.field_dataType = paramCursor.getInt(i);
      } else if (eHb == k) {
        this.field_modifyTime = paramCursor.getLong(i);
      } else if (eVd == k) {
        this.field_extFlag = paramCursor.getInt(i);
      } else if (eVe == k) {
        this.field_attrFlag = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eUV) {
      localContentValues.put("dataId", this.field_dataId);
    }
    if (this.eUW) {
      localContentValues.put("favLocalId", Long.valueOf(this.field_favLocalId));
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.eSu) {
      localContentValues.put("cdnUrl", this.field_cdnUrl);
    }
    if (this.eUX) {
      localContentValues.put("cdnKey", this.field_cdnKey);
    }
    if (this.eEI) {
      localContentValues.put("totalLen", Integer.valueOf(this.field_totalLen));
    }
    if (this.eEJ) {
      localContentValues.put("offset", Integer.valueOf(this.field_offset));
    }
    if (this.eCZ) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.eFs) {
      localContentValues.put("path", this.field_path);
    }
    if (this.eFJ) {
      localContentValues.put("dataType", Integer.valueOf(this.field_dataType));
    }
    if (this.eGF) {
      localContentValues.put("modifyTime", Long.valueOf(this.field_modifyTime));
    }
    if (this.eUY) {
      localContentValues.put("extFlag", Integer.valueOf(this.field_extFlag));
    }
    if (this.eUZ) {
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