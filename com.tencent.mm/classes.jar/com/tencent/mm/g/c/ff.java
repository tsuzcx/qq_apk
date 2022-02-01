package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ff
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eYP = "originMD5".hashCode();
  private static final int eYQ = "resultFile".hashCode();
  private static final int eYR = "fromLang".hashCode();
  private static final int eYS = "toLang".hashCode();
  private static final int eYT = "brand".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eYK = true;
  private boolean eYL = true;
  private boolean eYM = true;
  private boolean eYN = true;
  private boolean eYO = true;
  public String field_brand;
  public String field_fromLang;
  public String field_originMD5;
  public String field_resultFile;
  public String field_toLang;
  
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
      if (eYP != k) {
        break label65;
      }
      this.field_originMD5 = paramCursor.getString(i);
      this.eYK = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eYQ == k) {
        this.field_resultFile = paramCursor.getString(i);
      } else if (eYR == k) {
        this.field_fromLang = paramCursor.getString(i);
      } else if (eYS == k) {
        this.field_toLang = paramCursor.getString(i);
      } else if (eYT == k) {
        this.field_brand = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eYK) {
      localContentValues.put("originMD5", this.field_originMD5);
    }
    if (this.eYL) {
      localContentValues.put("resultFile", this.field_resultFile);
    }
    if (this.eYM) {
      localContentValues.put("fromLang", this.field_fromLang);
    }
    if (this.eYN) {
      localContentValues.put("toLang", this.field_toLang);
    }
    if (this.eYO) {
      localContentValues.put("brand", this.field_brand);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.c.ff
 * JD-Core Version:    0.7.0.1
 */