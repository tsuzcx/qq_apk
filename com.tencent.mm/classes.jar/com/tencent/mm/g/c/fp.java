package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class fp
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int frf = "originMD5".hashCode();
  private static final int frg = "resultFile".hashCode();
  private static final int frh = "fromLang".hashCode();
  private static final int fri = "toLang".hashCode();
  private static final int frj = "brand".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public String field_brand;
  public String field_fromLang;
  public String field_originMD5;
  public String field_resultFile;
  public String field_toLang;
  private boolean fra = true;
  private boolean frb = true;
  private boolean frc = true;
  private boolean frd = true;
  private boolean fre = true;
  
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
      if (frf != k) {
        break label65;
      }
      this.field_originMD5 = paramCursor.getString(i);
      this.fra = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (frg == k) {
        this.field_resultFile = paramCursor.getString(i);
      } else if (frh == k) {
        this.field_fromLang = paramCursor.getString(i);
      } else if (fri == k) {
        this.field_toLang = paramCursor.getString(i);
      } else if (frj == k) {
        this.field_brand = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fra) {
      localContentValues.put("originMD5", this.field_originMD5);
    }
    if (this.frb) {
      localContentValues.put("resultFile", this.field_resultFile);
    }
    if (this.frc) {
      localContentValues.put("fromLang", this.field_fromLang);
    }
    if (this.frd) {
      localContentValues.put("toLang", this.field_toLang);
    }
    if (this.fre) {
      localContentValues.put("brand", this.field_brand);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.fp
 * JD-Core Version:    0.7.0.1
 */