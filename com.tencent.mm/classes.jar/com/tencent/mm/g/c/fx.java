package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class fx
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fXK = "originMD5".hashCode();
  private static final int fXL = "resultFile".hashCode();
  private static final int fXM = "fromLang".hashCode();
  private static final int fXN = "toLang".hashCode();
  private static final int fXO = "brand".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean fXF = true;
  private boolean fXG = true;
  private boolean fXH = true;
  private boolean fXI = true;
  private boolean fXJ = true;
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
      if (fXK != k) {
        break label65;
      }
      this.field_originMD5 = paramCursor.getString(i);
      this.fXF = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fXL == k) {
        this.field_resultFile = paramCursor.getString(i);
      } else if (fXM == k) {
        this.field_fromLang = paramCursor.getString(i);
      } else if (fXN == k) {
        this.field_toLang = paramCursor.getString(i);
      } else if (fXO == k) {
        this.field_brand = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fXF) {
      localContentValues.put("originMD5", this.field_originMD5);
    }
    if (this.fXG) {
      localContentValues.put("resultFile", this.field_resultFile);
    }
    if (this.fXH) {
      localContentValues.put("fromLang", this.field_fromLang);
    }
    if (this.fXI) {
      localContentValues.put("toLang", this.field_toLang);
    }
    if (this.fXJ) {
      localContentValues.put("brand", this.field_brand);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.c.fx
 * JD-Core Version:    0.7.0.1
 */