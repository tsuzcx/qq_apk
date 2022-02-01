package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class br
  extends c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS FavCdnTransferInfo_LocalId ON FavCdnInfo(favLocalId)", "CREATE INDEX IF NOT EXISTS FavCDNInfo_modifyTime_Index ON FavCdnInfo(modifyTime)" };
  private static final int eBi = "dataId".hashCode();
  private static final int eBj = "favLocalId".hashCode();
  private static final int eBk;
  private static final int eBl = "extFlag".hashCode();
  private static final int eBm = "attrFlag".hashCode();
  private static final int ejR;
  private static final int elO;
  private static final int elP;
  private static final int emA;
  private static final int eml;
  private static final int enN;
  private static final int ezo;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE = "type".hashCode();
  private boolean __hadSettype = true;
  private boolean eBd = true;
  private boolean eBe = true;
  private boolean eBf = true;
  private boolean eBg = true;
  private boolean eBh = true;
  private boolean ejO = true;
  private boolean elx = true;
  private boolean ely = true;
  private boolean emh = true;
  private boolean emy = true;
  private boolean enr = true;
  private boolean eyC = true;
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
    ezo = "cdnUrl".hashCode();
    eBk = "cdnKey".hashCode();
    elO = "totalLen".hashCode();
    elP = "offset".hashCode();
    ejR = "status".hashCode();
    eml = "path".hashCode();
    emA = "dataType".hashCode();
    enN = "modifyTime".hashCode();
  }
  
  public static c.a So()
  {
    c.a locala = new c.a();
    locala.EYt = new Field[13];
    locala.columns = new String[14];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "dataId";
    locala.EYv.put("dataId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" dataId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.EYu = "dataId";
    locala.columns[1] = "favLocalId";
    locala.EYv.put("favLocalId", "LONG");
    localStringBuilder.append(" favLocalId LONG");
    localStringBuilder.append(", ");
    locala.columns[2] = "type";
    locala.EYv.put("type", "INTEGER");
    localStringBuilder.append(" type INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "cdnUrl";
    locala.EYv.put("cdnUrl", "TEXT");
    localStringBuilder.append(" cdnUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "cdnKey";
    locala.EYv.put("cdnKey", "TEXT");
    localStringBuilder.append(" cdnKey TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "totalLen";
    locala.EYv.put("totalLen", "INTEGER");
    localStringBuilder.append(" totalLen INTEGER");
    localStringBuilder.append(", ");
    locala.columns[6] = "offset";
    locala.EYv.put("offset", "INTEGER");
    localStringBuilder.append(" offset INTEGER");
    localStringBuilder.append(", ");
    locala.columns[7] = "status";
    locala.EYv.put("status", "INTEGER");
    localStringBuilder.append(" status INTEGER");
    localStringBuilder.append(", ");
    locala.columns[8] = "path";
    locala.EYv.put("path", "TEXT");
    localStringBuilder.append(" path TEXT");
    localStringBuilder.append(", ");
    locala.columns[9] = "dataType";
    locala.EYv.put("dataType", "INTEGER");
    localStringBuilder.append(" dataType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[10] = "modifyTime";
    locala.EYv.put("modifyTime", "LONG default '0' ");
    localStringBuilder.append(" modifyTime LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[11] = "extFlag";
    locala.EYv.put("extFlag", "INTEGER default '0' ");
    localStringBuilder.append(" extFlag INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[12] = "attrFlag";
    locala.EYv.put("attrFlag", "LONG default '0' ");
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
      if (eBi != k) {
        break label65;
      }
      this.field_dataId = paramCursor.getString(i);
      this.eBd = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eBj == k) {
        this.field_favLocalId = paramCursor.getLong(i);
      } else if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (ezo == k) {
        this.field_cdnUrl = paramCursor.getString(i);
      } else if (eBk == k) {
        this.field_cdnKey = paramCursor.getString(i);
      } else if (elO == k) {
        this.field_totalLen = paramCursor.getInt(i);
      } else if (elP == k) {
        this.field_offset = paramCursor.getInt(i);
      } else if (ejR == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (eml == k) {
        this.field_path = paramCursor.getString(i);
      } else if (emA == k) {
        this.field_dataType = paramCursor.getInt(i);
      } else if (enN == k) {
        this.field_modifyTime = paramCursor.getLong(i);
      } else if (eBl == k) {
        this.field_extFlag = paramCursor.getInt(i);
      } else if (eBm == k) {
        this.field_attrFlag = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eBd) {
      localContentValues.put("dataId", this.field_dataId);
    }
    if (this.eBe) {
      localContentValues.put("favLocalId", Long.valueOf(this.field_favLocalId));
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.eyC) {
      localContentValues.put("cdnUrl", this.field_cdnUrl);
    }
    if (this.eBf) {
      localContentValues.put("cdnKey", this.field_cdnKey);
    }
    if (this.elx) {
      localContentValues.put("totalLen", Integer.valueOf(this.field_totalLen));
    }
    if (this.ely) {
      localContentValues.put("offset", Integer.valueOf(this.field_offset));
    }
    if (this.ejO) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.emh) {
      localContentValues.put("path", this.field_path);
    }
    if (this.emy) {
      localContentValues.put("dataType", Integer.valueOf(this.field_dataType));
    }
    if (this.enr) {
      localContentValues.put("modifyTime", Long.valueOf(this.field_modifyTime));
    }
    if (this.eBg) {
      localContentValues.put("extFlag", Integer.valueOf(this.field_extFlag));
    }
    if (this.eBh) {
      localContentValues.put("attrFlag", Long.valueOf(this.field_attrFlag));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.br
 * JD-Core Version:    0.7.0.1
 */