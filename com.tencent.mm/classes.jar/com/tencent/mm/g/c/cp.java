package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class cp
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eGY = "username".hashCode();
  private static final int eIK = "modifyTime".hashCode();
  private static final int eQN = "encryptUsername".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eGV = true;
  private boolean eIo = true;
  private boolean eQv = true;
  public String field_encryptUsername;
  public long field_modifyTime;
  public String field_username;
  
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
      if (eQN != k) {
        break label65;
      }
      this.field_encryptUsername = paramCursor.getString(i);
      this.eQv = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eGY == k) {
        this.field_username = paramCursor.getString(i);
      } else if (eIK == k) {
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
    if (this.eQv) {
      localContentValues.put("encryptUsername", this.field_encryptUsername);
    }
    if (this.field_username == null) {
      this.field_username = "";
    }
    if (this.eGV) {
      localContentValues.put("username", this.field_username);
    }
    if (this.eIo) {
      localContentValues.put("modifyTime", Long.valueOf(this.field_modifyTime));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.cp
 * JD-Core Version:    0.7.0.1
 */