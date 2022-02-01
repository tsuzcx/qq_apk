package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class ct
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int createTime_HASHCODE = "createTime".hashCode();
  private static final int fHf;
  private static final int fHg;
  private static final int id_HASHCODE = "id".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean __hadSetcreateTime = true;
  private boolean __hadSetid = true;
  private boolean fHd = true;
  private boolean fHe = true;
  public long field_createTime;
  public String field_id;
  public String field_logContent;
  public int field_protocolNumber;
  
  static
  {
    fHf = "protocolNumber".hashCode();
    fHg = "logContent".hashCode();
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
      if (fHf == k) {
        this.field_protocolNumber = paramCursor.getInt(i);
      } else if (fHg == k) {
        this.field_logContent = paramCursor.getString(i);
      } else if (createTime_HASHCODE == k) {
        this.field_createTime = paramCursor.getLong(i);
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
    if (this.fHd) {
      localContentValues.put("protocolNumber", Integer.valueOf(this.field_protocolNumber));
    }
    if (this.fHe) {
      localContentValues.put("logContent", this.field_logContent);
    }
    if (this.__hadSetcreateTime) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.ct
 * JD-Core Version:    0.7.0.1
 */