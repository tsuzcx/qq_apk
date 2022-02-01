package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class dr
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fMo;
  private static final int fMp = "appusername".hashCode();
  private static final int fMu = "step".hashCode();
  private static final int fxg = "sort".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int username_HASHCODE;
  private boolean __hadSetusername = true;
  private boolean fMl = true;
  private boolean fMm = true;
  private boolean fMt = true;
  public String field_appusername;
  public String field_rankID;
  public int field_sort;
  public int field_step;
  public String field_username;
  private boolean fwG = true;
  
  static
  {
    fMo = "rankID".hashCode();
    username_HASHCODE = "username".hashCode();
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
      if (fMp != k) {
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
      if (fMo == k) {
        this.field_rankID = paramCursor.getString(i);
      } else if (username_HASHCODE == k) {
        this.field_username = paramCursor.getString(i);
      } else if (fMu == k) {
        this.field_step = paramCursor.getInt(i);
      } else if (fxg == k) {
        this.field_sort = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fMm) {
      localContentValues.put("appusername", this.field_appusername);
    }
    if (this.fMl) {
      localContentValues.put("rankID", this.field_rankID);
    }
    if (this.__hadSetusername) {
      localContentValues.put("username", this.field_username);
    }
    if (this.fMt) {
      localContentValues.put("step", Integer.valueOf(this.field_step));
    }
    if (this.fwG) {
      localContentValues.put("sort", Integer.valueOf(this.field_sort));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.dr
 * JD-Core Version:    0.7.0.1
 */