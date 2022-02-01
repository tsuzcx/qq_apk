package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class cu
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fmm = "modifyTime".hashCode();
  private static final int fus = "encryptUsername".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int username_HASHCODE = "username".hashCode();
  private boolean __hadSetusername = true;
  public String field_encryptUsername;
  public long field_modifyTime;
  public String field_username;
  private boolean flQ = true;
  private boolean fua = true;
  
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
      if (fus != k) {
        break label65;
      }
      this.field_encryptUsername = paramCursor.getString(i);
      this.fua = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (username_HASHCODE == k) {
        this.field_username = paramCursor.getString(i);
      } else if (fmm == k) {
        this.field_modifyTime = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.field_encryptUsername == null) {
      this.field_encryptUsername = "";
    }
    if (this.fua) {
      localContentValues.put("encryptUsername", this.field_encryptUsername);
    }
    if (this.field_username == null) {
      this.field_username = "";
    }
    if (this.__hadSetusername) {
      localContentValues.put("username", this.field_username);
    }
    if (this.flQ) {
      localContentValues.put("modifyTime", Long.valueOf(this.field_modifyTime));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.cu
 * JD-Core Version:    0.7.0.1
 */