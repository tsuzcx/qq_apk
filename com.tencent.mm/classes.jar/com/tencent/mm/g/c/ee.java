package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ee
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int dDS = "createtime".hashCode();
  private static final int dMx = "uid".hashCode();
  private static final int dMy;
  private static final int duc = "name".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean dDN = true;
  private boolean dMv = true;
  private boolean dMw = true;
  private boolean dtp = true;
  public long field_createtime;
  public String field_devicetype;
  public String field_name;
  public String field_uid;
  
  static
  {
    dMy = "devicetype".hashCode();
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
      if (dMx != k) {
        break label65;
      }
      this.field_uid = paramCursor.getString(i);
      this.dMv = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (duc == k) {
        this.field_name = paramCursor.getString(i);
      } else if (dMy == k) {
        this.field_devicetype = paramCursor.getString(i);
      } else if (dDS == k) {
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
    if (this.dMv) {
      localContentValues.put("uid", this.field_uid);
    }
    if (this.field_name == null) {
      this.field_name = "";
    }
    if (this.dtp) {
      localContentValues.put("name", this.field_name);
    }
    if (this.field_devicetype == null) {
      this.field_devicetype = "";
    }
    if (this.dMw) {
      localContentValues.put("devicetype", this.field_devicetype);
    }
    if (this.dDN) {
      localContentValues.put("createtime", Long.valueOf(this.field_createtime));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.c.ee
 * JD-Core Version:    0.7.0.1
 */