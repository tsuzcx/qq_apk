package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class aw
  extends IAutoDBItem
{
  public static final Column C_CREATETIME;
  public static final Column C_ID;
  public static final Column C_ROWID;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("CleanDeleteItem");
  private static final int createTime_HASHCODE;
  public static final Column hBO;
  public static final Column hBP;
  public static final Column hBQ;
  private static final int hBU;
  private static final int hBV;
  private static final int hBW = "flags".hashCode();
  public static final Column hpd;
  private static final int hph;
  public static final Column hqt;
  private static final int hrl;
  private static final int id_HASHCODE;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean __hadSetcreateTime = true;
  private boolean __hadSetid = true;
  public long field_createTime;
  public long field_deleteTime;
  public long field_flags;
  public String field_id;
  public long field_modifyTime;
  public long field_saveTime;
  public long field_size;
  private boolean hBR = true;
  private boolean hBS = true;
  private boolean hBT = true;
  private boolean hpf = true;
  private boolean hqP = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "CleanDeleteItem", "");
    C_CREATETIME = new Column("createtime", "long", "CleanDeleteItem", "");
    hqt = new Column("modifytime", "long", "CleanDeleteItem", "");
    hBO = new Column("deletetime", "long", "CleanDeleteItem", "");
    C_ID = new Column("id", "string", "CleanDeleteItem", "");
    hBP = new Column("savetime", "long", "CleanDeleteItem", "");
    hpd = new Column("size", "long", "CleanDeleteItem", "");
    hBQ = new Column("flags", "long", "CleanDeleteItem", "");
    createTime_HASHCODE = "createTime".hashCode();
    hrl = "modifyTime".hashCode();
    hBU = "deleteTime".hashCode();
    id_HASHCODE = "id".hashCode();
    hBV = "saveTime".hashCode();
    hph = "size".hashCode();
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
      if (createTime_HASHCODE != k) {
        break label60;
      }
      this.field_createTime = paramCursor.getLong(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (hrl == k) {
        this.field_modifyTime = paramCursor.getLong(i);
      } else if (hBU == k) {
        this.field_deleteTime = paramCursor.getLong(i);
      } else if (id_HASHCODE == k) {
        this.field_id = paramCursor.getString(i);
      } else if (hBV == k) {
        this.field_saveTime = paramCursor.getLong(i);
      } else if (hph == k) {
        this.field_size = paramCursor.getLong(i);
      } else if (hBW == k) {
        this.field_flags = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.__hadSetcreateTime) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.hqP) {
      localContentValues.put("modifyTime", Long.valueOf(this.field_modifyTime));
    }
    if (this.hBR) {
      localContentValues.put("deleteTime", Long.valueOf(this.field_deleteTime));
    }
    if (this.field_id == null) {
      this.field_id = "";
    }
    if (this.__hadSetid) {
      localContentValues.put("id", this.field_id);
    }
    if (this.hBS) {
      localContentValues.put("saveTime", Long.valueOf(this.field_saveTime));
    }
    if (this.hpf) {
      localContentValues.put("size", Long.valueOf(this.field_size));
    }
    if (this.hBT) {
      localContentValues.put("flags", Long.valueOf(this.field_flags));
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
    return "CleanDeleteItem";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.c.aw
 * JD-Core Version:    0.7.0.1
 */