package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class bv
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS FavCdnTransferInfo_LocalId ON FavCdnInfo(favLocalId)", "CREATE INDEX IF NOT EXISTS FavCDNInfo_modifyTime_Index ON FavCdnInfo(modifyTime)" };
  private static final int fAq = "dataId".hashCode();
  private static final int fAr = "favLocalId".hashCode();
  private static final int fAs;
  private static final int fAt = "extFlag".hashCode();
  private static final int fAu = "attrFlag".hashCode();
  private static final int fjl;
  private static final int fkH;
  private static final int fkW;
  private static final int fko;
  private static final int fkp;
  private static final int fmm;
  private static final int fyw;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE = "type".hashCode();
  private boolean __hadSettype = true;
  private boolean fAl = true;
  private boolean fAm = true;
  private boolean fAn = true;
  private boolean fAo = true;
  private boolean fAp = true;
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
  private boolean fjX = true;
  private boolean fjY = true;
  private boolean fji = true;
  private boolean fkD = true;
  private boolean fkU = true;
  private boolean flQ = true;
  private boolean fxK = true;
  
  static
  {
    fyw = "cdnUrl".hashCode();
    fAs = "cdnKey".hashCode();
    fko = "totalLen".hashCode();
    fkp = "offset".hashCode();
    fjl = "status".hashCode();
    fkH = "path".hashCode();
    fkW = "dataType".hashCode();
    fmm = "modifyTime".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo ajs()
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
      if (fAq != k) {
        break label65;
      }
      this.field_dataId = paramCursor.getString(i);
      this.fAl = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fAr == k) {
        this.field_favLocalId = paramCursor.getLong(i);
      } else if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (fyw == k) {
        this.field_cdnUrl = paramCursor.getString(i);
      } else if (fAs == k) {
        this.field_cdnKey = paramCursor.getString(i);
      } else if (fko == k) {
        this.field_totalLen = paramCursor.getInt(i);
      } else if (fkp == k) {
        this.field_offset = paramCursor.getInt(i);
      } else if (fjl == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (fkH == k) {
        this.field_path = paramCursor.getString(i);
      } else if (fkW == k) {
        this.field_dataType = paramCursor.getInt(i);
      } else if (fmm == k) {
        this.field_modifyTime = paramCursor.getLong(i);
      } else if (fAt == k) {
        this.field_extFlag = paramCursor.getInt(i);
      } else if (fAu == k) {
        this.field_attrFlag = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fAl) {
      localContentValues.put("dataId", this.field_dataId);
    }
    if (this.fAm) {
      localContentValues.put("favLocalId", Long.valueOf(this.field_favLocalId));
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.fxK) {
      localContentValues.put("cdnUrl", this.field_cdnUrl);
    }
    if (this.fAn) {
      localContentValues.put("cdnKey", this.field_cdnKey);
    }
    if (this.fjX) {
      localContentValues.put("totalLen", Integer.valueOf(this.field_totalLen));
    }
    if (this.fjY) {
      localContentValues.put("offset", Integer.valueOf(this.field_offset));
    }
    if (this.fji) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.fkD) {
      localContentValues.put("path", this.field_path);
    }
    if (this.fkU) {
      localContentValues.put("dataType", Integer.valueOf(this.field_dataType));
    }
    if (this.flQ) {
      localContentValues.put("modifyTime", Long.valueOf(this.field_modifyTime));
    }
    if (this.fAo) {
      localContentValues.put("extFlag", Integer.valueOf(this.field_extFlag));
    }
    if (this.fAp) {
      localContentValues.put("attrFlag", Long.valueOf(this.field_attrFlag));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.bv
 * JD-Core Version:    0.7.0.1
 */