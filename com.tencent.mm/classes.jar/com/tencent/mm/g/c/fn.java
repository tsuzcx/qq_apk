package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class fn
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eSU;
  private static final int feK = "createtime".hashCode();
  private static final int fqQ = "uid".hashCode();
  private static final int fqR;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eSi = true;
  private boolean feB = true;
  public long field_createtime;
  public String field_devicetype;
  public String field_name;
  public String field_uid;
  private boolean fqO = true;
  private boolean fqP = true;
  
  static
  {
    eSU = "name".hashCode();
    fqR = "devicetype".hashCode();
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
      if (fqQ != k) {
        break label65;
      }
      this.field_uid = paramCursor.getString(i);
      this.fqO = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eSU == k) {
        this.field_name = paramCursor.getString(i);
      } else if (fqR == k) {
        this.field_devicetype = paramCursor.getString(i);
      } else if (feK == k) {
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
    if (this.fqO) {
      localContentValues.put("uid", this.field_uid);
    }
    if (this.field_name == null) {
      this.field_name = "";
    }
    if (this.eSi) {
      localContentValues.put("name", this.field_name);
    }
    if (this.field_devicetype == null) {
      this.field_devicetype = "";
    }
    if (this.fqP) {
      localContentValues.put("devicetype", this.field_devicetype);
    }
    if (this.feB) {
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