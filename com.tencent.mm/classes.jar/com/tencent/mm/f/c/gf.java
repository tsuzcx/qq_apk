package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class gf
  extends IAutoDBItem
{
  public static final Column C_CREATETIME;
  public static final Column C_ID;
  public static final Column C_ROWID;
  public static final Column C_TYPE;
  public static final Column C_UPDATETIME;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("SecReportDataInfo");
  private static final int createTime_HASHCODE;
  private static final int hZD;
  public static final Column hZf;
  public static final Column hoE;
  private static final int hoM = "data".hashCode();
  private static final int id_HASHCODE;
  public static final Column ivM;
  public static final Column ivN;
  private static final int ivQ;
  private static final int ivR = "indexData".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE;
  private static final int updateTime_HASHCODE;
  private boolean __hadSetcreateTime = true;
  private boolean __hadSetid = true;
  private boolean __hadSettype = true;
  private boolean __hadSetupdateTime = true;
  public long field_createTime;
  public byte[] field_data;
  public long field_expireTime;
  public String field_id;
  public String field_indexData;
  public String field_originId;
  public int field_type;
  public long field_updateTime;
  private boolean hZr = true;
  private boolean hoI = true;
  private boolean ivO = true;
  private boolean ivP = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "SecReportDataInfo", "");
    C_ID = new Column("id", "string", "SecReportDataInfo", "");
    ivM = new Column("originid", "string", "SecReportDataInfo", "");
    C_CREATETIME = new Column("createtime", "long", "SecReportDataInfo", "");
    C_UPDATETIME = new Column("updatetime", "long", "SecReportDataInfo", "");
    hZf = new Column("expiretime", "long", "SecReportDataInfo", "");
    C_TYPE = new Column("type", "int", "SecReportDataInfo", "");
    hoE = new Column("data", "byte[]", "SecReportDataInfo", "");
    ivN = new Column("indexdata", "string", "SecReportDataInfo", "");
    id_HASHCODE = "id".hashCode();
    ivQ = "originId".hashCode();
    createTime_HASHCODE = "createTime".hashCode();
    updateTime_HASHCODE = "updateTime".hashCode();
    hZD = "expireTime".hashCode();
    type_HASHCODE = "type".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aoY()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[8];
    localMAutoDBInfo.columns = new String[9];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "id";
    localMAutoDBInfo.colsMap.put("id", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" id TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "id";
    localMAutoDBInfo.columns[1] = "originId";
    localMAutoDBInfo.colsMap.put("originId", "TEXT default '' ");
    localStringBuilder.append(" originId TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "createTime";
    localMAutoDBInfo.colsMap.put("createTime", "LONG default '0' ");
    localStringBuilder.append(" createTime LONG default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "updateTime";
    localMAutoDBInfo.colsMap.put("updateTime", "LONG default '0' ");
    localStringBuilder.append(" updateTime LONG default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "expireTime";
    localMAutoDBInfo.colsMap.put("expireTime", "LONG default '0' ");
    localStringBuilder.append(" expireTime LONG default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "type";
    localMAutoDBInfo.colsMap.put("type", "INTEGER default '0' ");
    localStringBuilder.append(" type INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "data";
    localMAutoDBInfo.colsMap.put("data", "BLOB");
    localStringBuilder.append(" data BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "indexData";
    localMAutoDBInfo.colsMap.put("indexData", "TEXT default '' ");
    localStringBuilder.append(" indexData TEXT default '' ");
    localMAutoDBInfo.columns[8] = "rowid";
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
      if (id_HASHCODE != k) {
        break label65;
      }
      this.field_id = paramCursor.getString(i);
      this.__hadSetid = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (ivQ == k) {
        this.field_originId = paramCursor.getString(i);
      } else if (createTime_HASHCODE == k) {
        this.field_createTime = paramCursor.getLong(i);
      } else if (updateTime_HASHCODE == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (hZD == k) {
        this.field_expireTime = paramCursor.getLong(i);
      } else if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (hoM == k) {
        this.field_data = paramCursor.getBlob(i);
      } else if (ivR == k) {
        this.field_indexData = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.__hadSetid) {
      localContentValues.put("id", this.field_id);
    }
    if (this.field_originId == null) {
      this.field_originId = "";
    }
    if (this.ivO) {
      localContentValues.put("originId", this.field_originId);
    }
    if (this.__hadSetcreateTime) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.__hadSetupdateTime) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.hZr) {
      localContentValues.put("expireTime", Long.valueOf(this.field_expireTime));
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.hoI) {
      localContentValues.put("data", this.field_data);
    }
    if (this.field_indexData == null) {
      this.field_indexData = "";
    }
    if (this.ivP) {
      localContentValues.put("indexData", this.field_indexData);
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
    return "SecReportDataInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.c.gf
 * JD-Core Version:    0.7.0.1
 */