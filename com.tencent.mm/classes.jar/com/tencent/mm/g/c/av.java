package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class av
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eEf = "createTime".hashCode();
  private static final int eFM = "size".hashCode();
  private static final int eHb = "modifyTime".hashCode();
  private static final int eOv = "deleteTime".hashCode();
  private static final int eOw = "id".hashCode();
  private static final int eOx = "saveTime".hashCode();
  private static final int eOy = "flags".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eDI = true;
  private boolean eFK = true;
  private boolean eGF = true;
  private boolean eOr = true;
  private boolean eOs = true;
  private boolean eOt = true;
  private boolean eOu = true;
  public long field_createTime;
  public long field_deleteTime;
  public long field_flags;
  public String field_id;
  public long field_modifyTime;
  public long field_saveTime;
  public long field_size;
  
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
      if (eEf != k) {
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
      if (eHb == k) {
        this.field_modifyTime = paramCursor.getLong(i);
      } else if (eOv == k) {
        this.field_deleteTime = paramCursor.getLong(i);
      } else if (eOw == k) {
        this.field_id = paramCursor.getString(i);
      } else if (eOx == k) {
        this.field_saveTime = paramCursor.getLong(i);
      } else if (eFM == k) {
        this.field_size = paramCursor.getLong(i);
      } else if (eOy == k) {
        this.field_flags = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eDI) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.eGF) {
      localContentValues.put("modifyTime", Long.valueOf(this.field_modifyTime));
    }
    if (this.eOr) {
      localContentValues.put("deleteTime", Long.valueOf(this.field_deleteTime));
    }
    if (this.field_id == null) {
      this.field_id = "";
    }
    if (this.eOs) {
      localContentValues.put("id", this.field_id);
    }
    if (this.eOt) {
      localContentValues.put("saveTime", Long.valueOf(this.field_saveTime));
    }
    if (this.eFK) {
      localContentValues.put("size", Long.valueOf(this.field_size));
    }
    if (this.eOu) {
      localContentValues.put("flags", Long.valueOf(this.field_flags));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.av
 * JD-Core Version:    0.7.0.1
 */