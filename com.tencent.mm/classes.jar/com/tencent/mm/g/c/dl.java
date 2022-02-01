package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class dl
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eFp;
  private static final int eRQ = "sort".hashCode();
  private static final int ffO;
  private static final int ffP = "appusername".hashCode();
  private static final int ffU;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eFm = true;
  private boolean eRq = true;
  private boolean ffL = true;
  private boolean ffM = true;
  private boolean ffT = true;
  public String field_appusername;
  public String field_rankID;
  public int field_sort;
  public int field_step;
  public String field_username;
  
  static
  {
    ffO = "rankID".hashCode();
    eFp = "username".hashCode();
    ffU = "step".hashCode();
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
      if (ffP != k) {
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
      if (ffO == k) {
        this.field_rankID = paramCursor.getString(i);
      } else if (eFp == k) {
        this.field_username = paramCursor.getString(i);
      } else if (ffU == k) {
        this.field_step = paramCursor.getInt(i);
      } else if (eRQ == k) {
        this.field_sort = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.ffM) {
      localContentValues.put("appusername", this.field_appusername);
    }
    if (this.ffL) {
      localContentValues.put("rankID", this.field_rankID);
    }
    if (this.eFm) {
      localContentValues.put("username", this.field_username);
    }
    if (this.ffT) {
      localContentValues.put("step", Integer.valueOf(this.field_step));
    }
    if (this.eRq) {
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