package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class fb
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eVC = "originMD5".hashCode();
  private static final int eVD = "resultFile".hashCode();
  private static final int eVE = "fromLang".hashCode();
  private static final int eVF = "toLang".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eVA = true;
  private boolean eVB = true;
  private boolean eVy = true;
  private boolean eVz = true;
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
      if (eVC != k) {
        break label65;
      }
      this.field_originMD5 = paramCursor.getString(i);
      this.eVy = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eVD == k) {
        this.field_resultFile = paramCursor.getString(i);
      } else if (eVE == k) {
        this.field_fromLang = paramCursor.getString(i);
      } else if (eVF == k) {
        this.field_toLang = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eVy) {
      localContentValues.put("originMD5", this.field_originMD5);
    }
    if (this.eVz) {
      localContentValues.put("resultFile", this.field_resultFile);
    }
    if (this.eVA) {
      localContentValues.put("fromLang", this.field_fromLang);
    }
    if (this.eVB) {
      localContentValues.put("toLang", this.field_toLang);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.c.fb
 * JD-Core Version:    0.7.0.1
 */