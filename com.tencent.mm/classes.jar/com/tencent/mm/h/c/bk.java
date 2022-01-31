package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class bk
  extends c
{
  private static final int cFT;
  private static final int cHA;
  private static final int cHB;
  private static final int cHC;
  private static final int cHD = "extFlag".hashCode();
  private static final int cHE = "attrFlag".hashCode();
  public static final String[] cqY = { "CREATE INDEX IF NOT EXISTS FavCdnTransferInfo_LocalId ON FavCdnInfo(favLocalId)", "CREATE INDEX IF NOT EXISTS FavCDNInfo_modifyTime_Index ON FavCdnInfo(modifyTime)" };
  private static final int crh = "rowid".hashCode();
  private static final int crn;
  private static final int csy;
  private static final int ctM;
  private static final int ctR;
  private static final int ctq;
  private static final int ctr;
  private static final int cvf;
  private boolean cFq = true;
  private boolean cHv = true;
  private boolean cHw = true;
  private boolean cHx = true;
  private boolean cHy = true;
  private boolean cHz = true;
  private boolean crk = true;
  private boolean csZ = true;
  private boolean csa = true;
  private boolean ctI = true;
  private boolean ctP = true;
  private boolean cta = true;
  private boolean cuI = true;
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
    cHA = "dataId".hashCode();
    cHB = "favLocalId".hashCode();
    csy = "type".hashCode();
    cFT = "cdnUrl".hashCode();
    cHC = "cdnKey".hashCode();
    ctq = "totalLen".hashCode();
    ctr = "offset".hashCode();
    crn = "status".hashCode();
    ctM = "path".hashCode();
    ctR = "dataType".hashCode();
    cvf = "modifyTime".hashCode();
  }
  
  public static c.a vg()
  {
    c.a locala = new c.a();
    locala.ujL = new Field[13];
    locala.columns = new String[14];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "dataId";
    locala.ujN.put("dataId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" dataId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.ujM = "dataId";
    locala.columns[1] = "favLocalId";
    locala.ujN.put("favLocalId", "LONG");
    localStringBuilder.append(" favLocalId LONG");
    localStringBuilder.append(", ");
    locala.columns[2] = "type";
    locala.ujN.put("type", "INTEGER");
    localStringBuilder.append(" type INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "cdnUrl";
    locala.ujN.put("cdnUrl", "TEXT");
    localStringBuilder.append(" cdnUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "cdnKey";
    locala.ujN.put("cdnKey", "TEXT");
    localStringBuilder.append(" cdnKey TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "totalLen";
    locala.ujN.put("totalLen", "INTEGER");
    localStringBuilder.append(" totalLen INTEGER");
    localStringBuilder.append(", ");
    locala.columns[6] = "offset";
    locala.ujN.put("offset", "INTEGER");
    localStringBuilder.append(" offset INTEGER");
    localStringBuilder.append(", ");
    locala.columns[7] = "status";
    locala.ujN.put("status", "INTEGER");
    localStringBuilder.append(" status INTEGER");
    localStringBuilder.append(", ");
    locala.columns[8] = "path";
    locala.ujN.put("path", "TEXT");
    localStringBuilder.append(" path TEXT");
    localStringBuilder.append(", ");
    locala.columns[9] = "dataType";
    locala.ujN.put("dataType", "INTEGER");
    localStringBuilder.append(" dataType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[10] = "modifyTime";
    locala.ujN.put("modifyTime", "LONG default '0' ");
    localStringBuilder.append(" modifyTime LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[11] = "extFlag";
    locala.ujN.put("extFlag", "INTEGER default '0' ");
    localStringBuilder.append(" extFlag INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[12] = "attrFlag";
    locala.ujN.put("attrFlag", "LONG default '0' ");
    localStringBuilder.append(" attrFlag LONG default '0' ");
    locala.columns[13] = "rowid";
    locala.sql = localStringBuilder.toString();
    return locala;
  }
  
  public final void d(Cursor paramCursor)
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
      if (cHA != k) {
        break label65;
      }
      this.field_dataId = paramCursor.getString(i);
      this.cHv = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (cHB == k) {
        this.field_favLocalId = paramCursor.getLong(i);
      } else if (csy == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (cFT == k) {
        this.field_cdnUrl = paramCursor.getString(i);
      } else if (cHC == k) {
        this.field_cdnKey = paramCursor.getString(i);
      } else if (ctq == k) {
        this.field_totalLen = paramCursor.getInt(i);
      } else if (ctr == k) {
        this.field_offset = paramCursor.getInt(i);
      } else if (crn == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (ctM == k) {
        this.field_path = paramCursor.getString(i);
      } else if (ctR == k) {
        this.field_dataType = paramCursor.getInt(i);
      } else if (cvf == k) {
        this.field_modifyTime = paramCursor.getLong(i);
      } else if (cHD == k) {
        this.field_extFlag = paramCursor.getInt(i);
      } else if (cHE == k) {
        this.field_attrFlag = paramCursor.getLong(i);
      } else if (crh == k) {
        this.ujK = paramCursor.getLong(i);
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.cHv) {
      localContentValues.put("dataId", this.field_dataId);
    }
    if (this.cHw) {
      localContentValues.put("favLocalId", Long.valueOf(this.field_favLocalId));
    }
    if (this.csa) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.cFq) {
      localContentValues.put("cdnUrl", this.field_cdnUrl);
    }
    if (this.cHx) {
      localContentValues.put("cdnKey", this.field_cdnKey);
    }
    if (this.csZ) {
      localContentValues.put("totalLen", Integer.valueOf(this.field_totalLen));
    }
    if (this.cta) {
      localContentValues.put("offset", Integer.valueOf(this.field_offset));
    }
    if (this.crk) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.ctI) {
      localContentValues.put("path", this.field_path);
    }
    if (this.ctP) {
      localContentValues.put("dataType", Integer.valueOf(this.field_dataType));
    }
    if (this.cuI) {
      localContentValues.put("modifyTime", Long.valueOf(this.field_modifyTime));
    }
    if (this.cHy) {
      localContentValues.put("extFlag", Integer.valueOf(this.field_extFlag));
    }
    if (this.cHz) {
      localContentValues.put("attrFlag", Long.valueOf(this.field_attrFlag));
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.h.c.bk
 * JD-Core Version:    0.7.0.1
 */