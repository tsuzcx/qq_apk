package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class bd
  extends c
{
  private static final int cEz;
  private static final int cGs = "lan".hashCode();
  public static final String[] cqY = new String[0];
  private static final int crh = "rowid".hashCode();
  private static final int csD;
  private boolean cDZ = true;
  private boolean cGr = true;
  private boolean csf = true;
  public byte[] field_content;
  public String field_lan;
  public String field_productID;
  
  static
  {
    cEz = "productID".hashCode();
    csD = "content".hashCode();
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
      if (cEz != k) {
        break label65;
      }
      this.field_productID = paramCursor.getString(i);
      this.cDZ = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (csD == k) {
        this.field_content = paramCursor.getBlob(i);
      } else if (cGs == k) {
        this.field_lan = paramCursor.getString(i);
      } else if (crh == k) {
        this.ujK = paramCursor.getLong(i);
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.cDZ) {
      localContentValues.put("productID", this.field_productID);
    }
    if (this.csf) {
      localContentValues.put("content", this.field_content);
    }
    if (this.field_lan == null) {
      this.field_lan = "";
    }
    if (this.cGr) {
      localContentValues.put("lan", this.field_lan);
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.h.c.bd
 * JD-Core Version:    0.7.0.1
 */