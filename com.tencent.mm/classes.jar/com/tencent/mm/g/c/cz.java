package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class cz
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eKA;
  private static final int eKB = "appusername".hashCode();
  private static final int eKG = "step".hashCode();
  private static final int eme;
  private static final int exX = "sort".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eKF = true;
  private boolean eKx = true;
  private boolean eKy = true;
  private boolean emb = true;
  private boolean exx = true;
  public String field_appusername;
  public String field_rankID;
  public int field_sort;
  public int field_step;
  public String field_username;
  
  static
  {
    eKA = "rankID".hashCode();
    eme = "username".hashCode();
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
      if (eKB != k) {
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
      if (eKA == k) {
        this.field_rankID = paramCursor.getString(i);
      } else if (eme == k) {
        this.field_username = paramCursor.getString(i);
      } else if (eKG == k) {
        this.field_step = paramCursor.getInt(i);
      } else if (exX == k) {
        this.field_sort = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eKy) {
      localContentValues.put("appusername", this.field_appusername);
    }
    if (this.eKx) {
      localContentValues.put("rankID", this.field_rankID);
    }
    if (this.emb) {
      localContentValues.put("username", this.field_username);
    }
    if (this.eKF) {
      localContentValues.put("step", Integer.valueOf(this.field_step));
    }
    if (this.exx) {
      localContentValues.put("sort", Integer.valueOf(this.field_sort));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.cz
 * JD-Core Version:    0.7.0.1
 */