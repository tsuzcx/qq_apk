package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class aa
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eGD = "appId".hashCode();
  private static final int eJG = "flag".hashCode();
  private static final int eJH = "sortId".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eGm = true;
  private boolean eJE = true;
  private boolean eJF = true;
  public String field_appId;
  public long field_flag;
  public int field_sortId;
  
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
      if (eJG != k) {
        break label60;
      }
      this.field_flag = paramCursor.getLong(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (eGD == k) {
        this.field_appId = paramCursor.getString(i);
      } else if (eJH == k) {
        this.field_sortId = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eJE) {
      localContentValues.put("flag", Long.valueOf(this.field_flag));
    }
    if (this.field_appId == null) {
      this.field_appId = "";
    }
    if (this.eGm) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.eJF) {
      localContentValues.put("sortId", Integer.valueOf(this.field_sortId));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.aa
 * JD-Core Version:    0.7.0.1
 */