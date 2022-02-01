package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class dv
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eEC = "subtype".hashCode();
  private static final int eRA = "bubbleMd5".hashCode();
  private static final int eRB = "coverMd5".hashCode();
  private static final int eRC = "minilogoMd5".hashCode();
  private static final int epb = "version".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eEA = true;
  private boolean eRx = true;
  private boolean eRy = true;
  private boolean eRz = true;
  private boolean eoW = true;
  public String field_bubbleMd5;
  public String field_coverMd5;
  public String field_minilogoMd5;
  public int field_subtype;
  public int field_version;
  
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
      if (eEC != k) {
        break label65;
      }
      this.field_subtype = paramCursor.getInt(i);
      this.eEA = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eRA == k) {
        this.field_bubbleMd5 = paramCursor.getString(i);
      } else if (eRB == k) {
        this.field_coverMd5 = paramCursor.getString(i);
      } else if (eRC == k) {
        this.field_minilogoMd5 = paramCursor.getString(i);
      } else if (epb == k) {
        this.field_version = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eEA) {
      localContentValues.put("subtype", Integer.valueOf(this.field_subtype));
    }
    if (this.eRx) {
      localContentValues.put("bubbleMd5", this.field_bubbleMd5);
    }
    if (this.eRy) {
      localContentValues.put("coverMd5", this.field_coverMd5);
    }
    if (this.eRz) {
      localContentValues.put("minilogoMd5", this.field_minilogoMd5);
    }
    if (this.eoW) {
      localContentValues.put("version", Integer.valueOf(this.field_version));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.dv
 * JD-Core Version:    0.7.0.1
 */