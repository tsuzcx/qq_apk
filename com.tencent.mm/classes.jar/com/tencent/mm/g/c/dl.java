package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class dl
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eGY;
  private static final int eTB = "sort".hashCode();
  private static final int fhL;
  private static final int fhM = "appusername".hashCode();
  private static final int fhR;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eGV = true;
  private boolean eTb = true;
  private boolean fhI = true;
  private boolean fhJ = true;
  private boolean fhQ = true;
  public String field_appusername;
  public String field_rankID;
  public int field_sort;
  public int field_step;
  public String field_username;
  
  static
  {
    fhL = "rankID".hashCode();
    eGY = "username".hashCode();
    fhR = "step".hashCode();
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
      if (fhM != k) {
        break label60;
      }
      this.field_appusername = paramCursor.getString(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (fhL == k) {
        this.field_rankID = paramCursor.getString(i);
      } else if (eGY == k) {
        this.field_username = paramCursor.getString(i);
      } else if (fhR == k) {
        this.field_step = paramCursor.getInt(i);
      } else if (eTB == k) {
        this.field_sort = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fhJ) {
      localContentValues.put("appusername", this.field_appusername);
    }
    if (this.fhI) {
      localContentValues.put("rankID", this.field_rankID);
    }
    if (this.eGV) {
      localContentValues.put("username", this.field_username);
    }
    if (this.fhQ) {
      localContentValues.put("step", Integer.valueOf(this.field_step));
    }
    if (this.eTb) {
      localContentValues.put("sort", Integer.valueOf(this.field_sort));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.dl
 * JD-Core Version:    0.7.0.1
 */