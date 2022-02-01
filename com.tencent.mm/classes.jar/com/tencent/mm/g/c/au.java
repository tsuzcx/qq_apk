package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class au
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int emY = "createTime".hashCode();
  private static final int eoH = "size".hashCode();
  private static final int epS = "modifyTime".hashCode();
  private static final int ewW = "deleteTime".hashCode();
  private static final int ewX = "id".hashCode();
  private static final int ewY = "saveTime".hashCode();
  private static final int ewZ = "flags".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean emB = true;
  private boolean eoF = true;
  private boolean epw = true;
  private boolean ewS = true;
  private boolean ewT = true;
  private boolean ewU = true;
  private boolean ewV = true;
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
      if (emY != k) {
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
      if (epS == k) {
        this.field_modifyTime = paramCursor.getLong(i);
      } else if (ewW == k) {
        this.field_deleteTime = paramCursor.getLong(i);
      } else if (ewX == k) {
        this.field_id = paramCursor.getString(i);
      } else if (ewY == k) {
        this.field_saveTime = paramCursor.getLong(i);
      } else if (eoH == k) {
        this.field_size = paramCursor.getLong(i);
      } else if (ewZ == k) {
        this.field_flags = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.emB) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.epw) {
      localContentValues.put("modifyTime", Long.valueOf(this.field_modifyTime));
    }
    if (this.ewS) {
      localContentValues.put("deleteTime", Long.valueOf(this.field_deleteTime));
    }
    if (this.field_id == null) {
      this.field_id = "";
    }
    if (this.ewT) {
      localContentValues.put("id", this.field_id);
    }
    if (this.ewU) {
      localContentValues.put("saveTime", Long.valueOf(this.field_saveTime));
    }
    if (this.eoF) {
      localContentValues.put("size", Long.valueOf(this.field_size));
    }
    if (this.ewV) {
      localContentValues.put("flags", Long.valueOf(this.field_flags));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.au
 * JD-Core Version:    0.7.0.1
 */