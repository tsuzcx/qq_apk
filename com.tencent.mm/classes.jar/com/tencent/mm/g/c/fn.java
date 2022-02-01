package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class fn
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eUF;
  private static final int fgF = "createtime".hashCode();
  private static final int fsQ = "uid".hashCode();
  private static final int fsR;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eTT = true;
  private boolean fgu = true;
  public long field_createtime;
  public String field_devicetype;
  public String field_name;
  public String field_uid;
  private boolean fsO = true;
  private boolean fsP = true;
  
  static
  {
    eUF = "name".hashCode();
    fsR = "devicetype".hashCode();
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
      if (fsQ != k) {
        break label65;
      }
      this.field_uid = paramCursor.getString(i);
      this.fsO = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eUF == k) {
        this.field_name = paramCursor.getString(i);
      } else if (fsR == k) {
        this.field_devicetype = paramCursor.getString(i);
      } else if (fgF == k) {
        this.field_createtime = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.field_uid == null) {
      this.field_uid = "";
    }
    if (this.fsO) {
      localContentValues.put("uid", this.field_uid);
    }
    if (this.field_name == null) {
      this.field_name = "";
    }
    if (this.eTT) {
      localContentValues.put("name", this.field_name);
    }
    if (this.field_devicetype == null) {
      this.field_devicetype = "";
    }
    if (this.fsP) {
      localContentValues.put("devicetype", this.field_devicetype);
    }
    if (this.fgu) {
      localContentValues.put("createtime", Long.valueOf(this.field_createtime));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.fn
 * JD-Core Version:    0.7.0.1
 */