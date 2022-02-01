package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class co
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eFO = "createTime".hashCode();
  private static final int eQh = "id".hashCode();
  private static final int fcO = "protocolNumber".hashCode();
  private static final int fcP = "logContent".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eFr = true;
  private boolean eQd = true;
  private boolean fcM = true;
  private boolean fcN = true;
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
      if (eQh != k) {
        break label65;
      }
      this.field_id = paramCursor.getString(i);
      this.eQd = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fcO == k) {
        this.field_protocolNumber = paramCursor.getInt(i);
      } else if (fcP == k) {
        this.field_logContent = paramCursor.getString(i);
      } else if (eFO == k) {
        this.field_createTime = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eQd) {
      localContentValues.put("id", this.field_id);
    }
    if (this.fcM) {
      localContentValues.put("protocolNumber", Integer.valueOf(this.field_protocolNumber));
    }
    if (this.fcN) {
      localContentValues.put("logContent", this.field_logContent);
    }
    if (this.eFr) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.co
 * JD-Core Version:    0.7.0.1
 */