package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class eg
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int dMN = "originMD5".hashCode();
  private static final int dMO = "resultFile".hashCode();
  private static final int dMP = "fromLang".hashCode();
  private static final int dMQ = "toLang".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean dMJ = true;
  private boolean dMK = true;
  private boolean dML = true;
  private boolean dMM = true;
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
      if (dMN != k) {
        break label65;
      }
      this.field_originMD5 = paramCursor.getString(i);
      this.dMJ = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (dMO == k) {
        this.field_resultFile = paramCursor.getString(i);
      } else if (dMP == k) {
        this.field_fromLang = paramCursor.getString(i);
      } else if (dMQ == k) {
        this.field_toLang = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.dMJ) {
      localContentValues.put("originMD5", this.field_originMD5);
    }
    if (this.dMK) {
      localContentValues.put("resultFile", this.field_resultFile);
    }
    if (this.dML) {
      localContentValues.put("fromLang", this.field_fromLang);
    }
    if (this.dMM) {
      localContentValues.put("toLang", this.field_toLang);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.c.eg
 * JD-Core Version:    0.7.0.1
 */