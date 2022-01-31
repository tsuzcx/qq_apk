package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ck
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int dCW;
  private static final int dCX = "appusername".hashCode();
  private static final int dDc = "step".hashCode();
  private static final int dhU;
  private static final int dsX = "sort".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean dCT = true;
  private boolean dCU = true;
  private boolean dDb = true;
  private boolean dhS = true;
  private boolean dsx = true;
  public String field_appusername;
  public String field_rankID;
  public int field_sort;
  public int field_step;
  public String field_username;
  
  static
  {
    dCW = "rankID".hashCode();
    dhU = "username".hashCode();
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
      if (dCX != k) {
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
      if (dCW == k) {
        this.field_rankID = paramCursor.getString(i);
      } else if (dhU == k) {
        this.field_username = paramCursor.getString(i);
      } else if (dDc == k) {
        this.field_step = paramCursor.getInt(i);
      } else if (dsX == k) {
        this.field_sort = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.dCU) {
      localContentValues.put("appusername", this.field_appusername);
    }
    if (this.dCT) {
      localContentValues.put("rankID", this.field_rankID);
    }
    if (this.dhS) {
      localContentValues.put("username", this.field_username);
    }
    if (this.dDb) {
      localContentValues.put("step", Integer.valueOf(this.field_step));
    }
    if (this.dsx) {
      localContentValues.put("sort", Integer.valueOf(this.field_sort));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.ck
 * JD-Core Version:    0.7.0.1
 */