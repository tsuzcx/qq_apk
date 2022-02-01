package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ez
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eJw = "createtime".hashCode();
  private static final int eVo = "uid".hashCode();
  private static final int eVp;
  private static final int ezc = "name".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eJn = true;
  private boolean eVm = true;
  private boolean eVn = true;
  private boolean eyq = true;
  public long field_createtime;
  public String field_devicetype;
  public String field_name;
  public String field_uid;
  
  static
  {
    eVp = "devicetype".hashCode();
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
      if (eVo != k) {
        break label65;
      }
      this.field_uid = paramCursor.getString(i);
      this.eVm = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (ezc == k) {
        this.field_name = paramCursor.getString(i);
      } else if (eVp == k) {
        this.field_devicetype = paramCursor.getString(i);
      } else if (eJw == k) {
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
    if (this.eVm) {
      localContentValues.put("uid", this.field_uid);
    }
    if (this.field_name == null) {
      this.field_name = "";
    }
    if (this.eyq) {
      localContentValues.put("name", this.field_name);
    }
    if (this.field_devicetype == null) {
      this.field_devicetype = "";
    }
    if (this.eVn) {
      localContentValues.put("devicetype", this.field_devicetype);
    }
    if (this.eJn) {
      localContentValues.put("createtime", Long.valueOf(this.field_createtime));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.ez
 * JD-Core Version:    0.7.0.1
 */