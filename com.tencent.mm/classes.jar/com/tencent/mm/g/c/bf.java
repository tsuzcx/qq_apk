package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class bf
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int ezC = "designerUin".hashCode();
  private static final int ezD = "productId".hashCode();
  private static final int ezE = "syncTime".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean ezA = true;
  private boolean ezB = true;
  private boolean ezz = true;
  public int field_designerUin;
  public String field_productId;
  public int field_syncTime;
  
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
      if (ezC != k) {
        break label60;
      }
      this.field_designerUin = paramCursor.getInt(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (ezD == k) {
        this.field_productId = paramCursor.getString(i);
      } else if (ezE == k) {
        this.field_syncTime = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.ezz) {
      localContentValues.put("designerUin", Integer.valueOf(this.field_designerUin));
    }
    if (this.ezA) {
      localContentValues.put("productId", this.field_productId);
    }
    if (this.ezB) {
      localContentValues.put("syncTime", Integer.valueOf(this.field_syncTime));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.bf
 * JD-Core Version:    0.7.0.1
 */