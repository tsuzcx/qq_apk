package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class fv
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fLi = "createtime".hashCode();
  private static final int fXv = "uid".hashCode();
  private static final int fXw;
  private static final int fyk = "name".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean fKX = true;
  private boolean fXt = true;
  private boolean fXu = true;
  public long field_createtime;
  public String field_devicetype;
  public String field_name;
  public String field_uid;
  private boolean fxy = true;
  
  static
  {
    fXw = "devicetype".hashCode();
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
      if (fXv != k) {
        break label65;
      }
      this.field_uid = paramCursor.getString(i);
      this.fXt = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fyk == k) {
        this.field_name = paramCursor.getString(i);
      } else if (fXw == k) {
        this.field_devicetype = paramCursor.getString(i);
      } else if (fLi == k) {
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
    if (this.fXt) {
      localContentValues.put("uid", this.field_uid);
    }
    if (this.field_name == null) {
      this.field_name = "";
    }
    if (this.fxy) {
      localContentValues.put("name", this.field_name);
    }
    if (this.field_devicetype == null) {
      this.field_devicetype = "";
    }
    if (this.fXu) {
      localContentValues.put("devicetype", this.field_devicetype);
    }
    if (this.fKX) {
      localContentValues.put("createtime", Long.valueOf(this.field_createtime));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.fv
 * JD-Core Version:    0.7.0.1
 */