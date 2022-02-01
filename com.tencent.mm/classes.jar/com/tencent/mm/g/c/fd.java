package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class fd
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eBw;
  private static final int eMo = "createtime".hashCode();
  private static final int eYA = "uid".hashCode();
  private static final int eYB;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eAK = true;
  private boolean eMf = true;
  private boolean eYy = true;
  private boolean eYz = true;
  public long field_createtime;
  public String field_devicetype;
  public String field_name;
  public String field_uid;
  
  static
  {
    eBw = "name".hashCode();
    eYB = "devicetype".hashCode();
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
      if (eYA != k) {
        break label65;
      }
      this.field_uid = paramCursor.getString(i);
      this.eYy = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eBw == k) {
        this.field_name = paramCursor.getString(i);
      } else if (eYB == k) {
        this.field_devicetype = paramCursor.getString(i);
      } else if (eMo == k) {
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
    if (this.eYy) {
      localContentValues.put("uid", this.field_uid);
    }
    if (this.field_name == null) {
      this.field_name = "";
    }
    if (this.eAK) {
      localContentValues.put("name", this.field_name);
    }
    if (this.field_devicetype == null) {
      this.field_devicetype = "";
    }
    if (this.eYz) {
      localContentValues.put("devicetype", this.field_devicetype);
    }
    if (this.eMf) {
      localContentValues.put("createtime", Long.valueOf(this.field_createtime));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.fd
 * JD-Core Version:    0.7.0.1
 */