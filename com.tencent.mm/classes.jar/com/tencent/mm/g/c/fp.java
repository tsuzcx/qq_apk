package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class fp
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int ftf = "originMD5".hashCode();
  private static final int ftg = "resultFile".hashCode();
  private static final int fth = "fromLang".hashCode();
  private static final int fti = "toLang".hashCode();
  private static final int ftj = "brand".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public String field_brand;
  public String field_fromLang;
  public String field_originMD5;
  public String field_resultFile;
  public String field_toLang;
  private boolean fta = true;
  private boolean ftb = true;
  private boolean ftc = true;
  private boolean ftd = true;
  private boolean fte = true;
  
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
      if (ftf != k) {
        break label65;
      }
      this.field_originMD5 = paramCursor.getString(i);
      this.fta = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (ftg == k) {
        this.field_resultFile = paramCursor.getString(i);
      } else if (fth == k) {
        this.field_fromLang = paramCursor.getString(i);
      } else if (fti == k) {
        this.field_toLang = paramCursor.getString(i);
      } else if (ftj == k) {
        this.field_brand = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fta) {
      localContentValues.put("originMD5", this.field_originMD5);
    }
    if (this.ftb) {
      localContentValues.put("resultFile", this.field_resultFile);
    }
    if (this.ftc) {
      localContentValues.put("fromLang", this.field_fromLang);
    }
    if (this.ftd) {
      localContentValues.put("toLang", this.field_toLang);
    }
    if (this.fte) {
      localContentValues.put("brand", this.field_brand);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.c.fp
 * JD-Core Version:    0.7.0.1
 */