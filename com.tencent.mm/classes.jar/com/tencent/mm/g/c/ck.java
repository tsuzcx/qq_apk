package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ck
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eIN = "protocolNumber".hashCode();
  private static final int eIO = "logContent".hashCode();
  private static final int emY = "createTime".hashCode();
  private static final int ewX = "id".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eIL = true;
  private boolean eIM = true;
  private boolean emB = true;
  private boolean ewT = true;
  public long field_createTime;
  public String field_id;
  public String field_logContent;
  public int field_protocolNumber;
  
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
      if (ewX != k) {
        break label65;
      }
      this.field_id = paramCursor.getString(i);
      this.ewT = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eIN == k) {
        this.field_protocolNumber = paramCursor.getInt(i);
      } else if (eIO == k) {
        this.field_logContent = paramCursor.getString(i);
      } else if (emY == k) {
        this.field_createTime = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.ewT) {
      localContentValues.put("id", this.field_id);
    }
    if (this.eIL) {
      localContentValues.put("protocolNumber", Integer.valueOf(this.field_protocolNumber));
    }
    if (this.eIM) {
      localContentValues.put("logContent", this.field_logContent);
    }
    if (this.emB) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.ck
 * JD-Core Version:    0.7.0.1
 */