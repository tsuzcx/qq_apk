package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class dt
  extends c
{
  private static final int cFH;
  private static final int cOc = "createtime".hashCode();
  private static final int cWl;
  private static final int cWm;
  public static final String[] cqY = new String[0];
  private static final int crh = "rowid".hashCode();
  private boolean cFe = true;
  private boolean cNX = true;
  private boolean cWj = true;
  private boolean cWk = true;
  public long field_createtime;
  public String field_devicetype;
  public String field_name;
  public String field_uid;
  
  static
  {
    cWl = "uid".hashCode();
    cFH = "name".hashCode();
    cWm = "devicetype".hashCode();
  }
  
  public final void d(Cursor paramCursor)
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
      if (cWl != k) {
        break label65;
      }
      this.field_uid = paramCursor.getString(i);
      this.cWj = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (cFH == k) {
        this.field_name = paramCursor.getString(i);
      } else if (cWm == k) {
        this.field_devicetype = paramCursor.getString(i);
      } else if (cOc == k) {
        this.field_createtime = paramCursor.getLong(i);
      } else if (crh == k) {
        this.ujK = paramCursor.getLong(i);
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.field_uid == null) {
      this.field_uid = "";
    }
    if (this.cWj) {
      localContentValues.put("uid", this.field_uid);
    }
    if (this.field_name == null) {
      this.field_name = "";
    }
    if (this.cFe) {
      localContentValues.put("name", this.field_name);
    }
    if (this.field_devicetype == null) {
      this.field_devicetype = "";
    }
    if (this.cWk) {
      localContentValues.put("devicetype", this.field_devicetype);
    }
    if (this.cNX) {
      localContentValues.put("createtime", Long.valueOf(this.field_createtime));
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.h.c.dt
 * JD-Core Version:    0.7.0.1
 */