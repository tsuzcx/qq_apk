package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class aw
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int createTime_HASHCODE = "createTime".hashCode();
  private static final int fkX = "size".hashCode();
  private static final int fmm = "modifyTime".hashCode();
  private static final int ftM = "deleteTime".hashCode();
  private static final int ftN;
  private static final int ftO = "flags".hashCode();
  private static final int id_HASHCODE = "id".hashCode();
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
  private boolean fkV = true;
  private boolean flQ = true;
  private boolean ftJ = true;
  private boolean ftK = true;
  private boolean ftL = true;
  
  static
  {
    ftN = "saveTime".hashCode();
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
      if (fmm == k) {
        this.field_modifyTime = paramCursor.getLong(i);
      } else if (ftM == k) {
        this.field_deleteTime = paramCursor.getLong(i);
      } else if (id_HASHCODE == k) {
        this.field_id = paramCursor.getString(i);
      } else if (ftN == k) {
        this.field_saveTime = paramCursor.getLong(i);
      } else if (fkX == k) {
        this.field_size = paramCursor.getLong(i);
      } else if (ftO == k) {
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
    if (this.flQ) {
      localContentValues.put("modifyTime", Long.valueOf(this.field_modifyTime));
    }
    if (this.ftJ) {
      localContentValues.put("deleteTime", Long.valueOf(this.field_deleteTime));
    }
    if (this.field_id == null) {
      this.field_id = "";
    }
    if (this.__hadSetid) {
      localContentValues.put("id", this.field_id);
    }
    if (this.ftK) {
      localContentValues.put("saveTime", Long.valueOf(this.field_saveTime));
    }
    if (this.fkV) {
      localContentValues.put("size", Long.valueOf(this.field_size));
    }
    if (this.ftL) {
      localContentValues.put("flags", Long.valueOf(this.field_flags));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.aw
 * JD-Core Version:    0.7.0.1
 */