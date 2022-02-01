package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class bb
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int ejR = "status".hashCode();
  private static final int elJ = "appId".hashCode();
  private static final int enN = "modifyTime".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean ejO = true;
  private boolean els = true;
  private boolean enr = true;
  public String field_appId;
  public long field_modifyTime;
  public int field_status;
  
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
      if (elJ != k) {
        break label65;
      }
      this.field_appId = paramCursor.getString(i);
      this.els = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (ejR == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (enN == k) {
        this.field_modifyTime = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.els) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.ejO) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.enr) {
      localContentValues.put("modifyTime", Long.valueOf(this.field_modifyTime));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.bb
 * JD-Core Version:    0.7.0.1
 */