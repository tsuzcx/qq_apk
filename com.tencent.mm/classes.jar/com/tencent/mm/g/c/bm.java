package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class bm
  extends c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS FavCdnTransferInfo_LocalId ON FavCdnInfo(favLocalId)", "CREATE INDEX IF NOT EXISTS FavCDNInfo_modifyTime_Index ON FavCdnInfo(modifyTime)" };
  private static final int dfJ = "status".hashCode();
  private static final int dhG;
  private static final int dhH;
  private static final int dib = "path".hashCode();
  private static final int dii = "dataType".hashCode();
  private static final int djr = "modifyTime".hashCode();
  private static final int duo;
  private static final int dwi = "dataId".hashCode();
  private static final int dwj = "favLocalId".hashCode();
  private static final int dwk;
  private static final int dwl = "extFlag".hashCode();
  private static final int dwm = "attrFlag".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE = "type".hashCode();
  private boolean __hadSettype = true;
  private boolean dfG = true;
  private boolean dhX = true;
  private boolean dhp = true;
  private boolean dhq = true;
  private boolean diU = true;
  private boolean dig = true;
  private boolean dtC = true;
  private boolean dwd = true;
  private boolean dwe = true;
  private boolean dwf = true;
  private boolean dwg = true;
  private boolean dwh = true;
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
    duo = "cdnUrl".hashCode();
    dwk = "cdnKey".hashCode();
    dhG = "totalLen".hashCode();
    dhH = "offset".hashCode();
  }
  
  public static c.a Hm()
  {
    c.a locala = new c.a();
    locala.yrK = new Field[13];
    locala.columns = new String[14];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "dataId";
    locala.yrM.put("dataId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" dataId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.yrL = "dataId";
    locala.columns[1] = "favLocalId";
    locala.yrM.put("favLocalId", "LONG");
    localStringBuilder.append(" favLocalId LONG");
    localStringBuilder.append(", ");
    locala.columns[2] = "type";
    locala.yrM.put("type", "INTEGER");
    localStringBuilder.append(" type INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "cdnUrl";
    locala.yrM.put("cdnUrl", "TEXT");
    localStringBuilder.append(" cdnUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "cdnKey";
    locala.yrM.put("cdnKey", "TEXT");
    localStringBuilder.append(" cdnKey TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "totalLen";
    locala.yrM.put("totalLen", "INTEGER");
    localStringBuilder.append(" totalLen INTEGER");
    localStringBuilder.append(", ");
    locala.columns[6] = "offset";
    locala.yrM.put("offset", "INTEGER");
    localStringBuilder.append(" offset INTEGER");
    localStringBuilder.append(", ");
    locala.columns[7] = "status";
    locala.yrM.put("status", "INTEGER");
    localStringBuilder.append(" status INTEGER");
    localStringBuilder.append(", ");
    locala.columns[8] = "path";
    locala.yrM.put("path", "TEXT");
    localStringBuilder.append(" path TEXT");
    localStringBuilder.append(", ");
    locala.columns[9] = "dataType";
    locala.yrM.put("dataType", "INTEGER");
    localStringBuilder.append(" dataType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[10] = "modifyTime";
    locala.yrM.put("modifyTime", "LONG default '0' ");
    localStringBuilder.append(" modifyTime LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[11] = "extFlag";
    locala.yrM.put("extFlag", "INTEGER default '0' ");
    localStringBuilder.append(" extFlag INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[12] = "attrFlag";
    locala.yrM.put("attrFlag", "LONG default '0' ");
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
      if (dwi != k) {
        break label65;
      }
      this.field_dataId = paramCursor.getString(i);
      this.dwd = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (dwj == k) {
        this.field_favLocalId = paramCursor.getLong(i);
      } else if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (duo == k) {
        this.field_cdnUrl = paramCursor.getString(i);
      } else if (dwk == k) {
        this.field_cdnKey = paramCursor.getString(i);
      } else if (dhG == k) {
        this.field_totalLen = paramCursor.getInt(i);
      } else if (dhH == k) {
        this.field_offset = paramCursor.getInt(i);
      } else if (dfJ == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (dib == k) {
        this.field_path = paramCursor.getString(i);
      } else if (dii == k) {
        this.field_dataType = paramCursor.getInt(i);
      } else if (djr == k) {
        this.field_modifyTime = paramCursor.getLong(i);
      } else if (dwl == k) {
        this.field_extFlag = paramCursor.getInt(i);
      } else if (dwm == k) {
        this.field_attrFlag = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.dwd) {
      localContentValues.put("dataId", this.field_dataId);
    }
    if (this.dwe) {
      localContentValues.put("favLocalId", Long.valueOf(this.field_favLocalId));
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.dtC) {
      localContentValues.put("cdnUrl", this.field_cdnUrl);
    }
    if (this.dwf) {
      localContentValues.put("cdnKey", this.field_cdnKey);
    }
    if (this.dhp) {
      localContentValues.put("totalLen", Integer.valueOf(this.field_totalLen));
    }
    if (this.dhq) {
      localContentValues.put("offset", Integer.valueOf(this.field_offset));
    }
    if (this.dfG) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.dhX) {
      localContentValues.put("path", this.field_path);
    }
    if (this.dig) {
      localContentValues.put("dataType", Integer.valueOf(this.field_dataType));
    }
    if (this.diU) {
      localContentValues.put("modifyTime", Long.valueOf(this.field_modifyTime));
    }
    if (this.dwg) {
      localContentValues.put("extFlag", Integer.valueOf(this.field_extFlag));
    }
    if (this.dwh) {
      localContentValues.put("attrFlag", Long.valueOf(this.field_attrFlag));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.c.bm
 * JD-Core Version:    0.7.0.1
 */