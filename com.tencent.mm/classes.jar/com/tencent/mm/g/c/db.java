package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class db
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eAs = "sort".hashCode();
  private static final int eNs;
  private static final int eNt = "appusername".hashCode();
  private static final int eNy;
  private static final int eok;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eNp = true;
  private boolean eNq = true;
  private boolean eNx = true;
  private boolean eoh = true;
  private boolean ezS = true;
  public String field_appusername;
  public String field_rankID;
  public int field_sort;
  public int field_step;
  public String field_username;
  
  static
  {
    eNs = "rankID".hashCode();
    eok = "username".hashCode();
    eNy = "step".hashCode();
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
      if (eNt != k) {
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
      if (eNs == k) {
        this.field_rankID = paramCursor.getString(i);
      } else if (eok == k) {
        this.field_username = paramCursor.getString(i);
      } else if (eNy == k) {
        this.field_step = paramCursor.getInt(i);
      } else if (eAs == k) {
        this.field_sort = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eNq) {
      localContentValues.put("appusername", this.field_appusername);
    }
    if (this.eNp) {
      localContentValues.put("rankID", this.field_rankID);
    }
    if (this.eoh) {
      localContentValues.put("username", this.field_username);
    }
    if (this.eNx) {
      localContentValues.put("step", Integer.valueOf(this.field_step));
    }
    if (this.ezS) {
      localContentValues.put("sort", Integer.valueOf(this.field_sort));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.db
 * JD-Core Version:    0.7.0.1
 */