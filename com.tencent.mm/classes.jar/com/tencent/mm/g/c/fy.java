package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class fy
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int createTime_HASHCODE;
  private static final int fJb;
  private static final int fXR;
  private static final int fXS = "indexData".hashCode();
  private static final int fkJ;
  private static final int id_HASHCODE = "id".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE;
  private static final int updateTime_HASHCODE;
  private boolean __hadSetcreateTime = true;
  private boolean __hadSetid = true;
  private boolean __hadSettype = true;
  private boolean __hadSetupdateTime = true;
  private boolean fIP = true;
  private boolean fXP = true;
  private boolean fXQ = true;
  public long field_createTime;
  public byte[] field_data;
  public long field_expireTime;
  public String field_id;
  public String field_indexData;
  public String field_originId;
  public int field_type;
  public long field_updateTime;
  private boolean fkF = true;
  
  static
  {
    fXR = "originId".hashCode();
    createTime_HASHCODE = "createTime".hashCode();
    updateTime_HASHCODE = "updateTime".hashCode();
    fJb = "expireTime".hashCode();
    type_HASHCODE = "type".hashCode();
    fkJ = "data".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo ajs()
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
      if (fXR == k) {
        this.field_originId = paramCursor.getString(i);
      } else if (createTime_HASHCODE == k) {
        this.field_createTime = paramCursor.getLong(i);
      } else if (updateTime_HASHCODE == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (fJb == k) {
        this.field_expireTime = paramCursor.getLong(i);
      } else if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (fkJ == k) {
        this.field_data = paramCursor.getBlob(i);
      } else if (fXS == k) {
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
    if (this.fXP) {
      localContentValues.put("originId", this.field_originId);
    }
    if (this.__hadSetcreateTime) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.__hadSetupdateTime) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.fIP) {
      localContentValues.put("expireTime", Long.valueOf(this.field_expireTime));
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.fkF) {
      localContentValues.put("data", this.field_data);
    }
    if (this.field_indexData == null) {
      this.field_indexData = "";
    }
    if (this.fXQ) {
      localContentValues.put("indexData", this.field_indexData);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.fy
 * JD-Core Version:    0.7.0.1
 */