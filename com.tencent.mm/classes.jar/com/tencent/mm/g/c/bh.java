package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class bh
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fwq = "designerUin".hashCode();
  private static final int fwr = "productId".hashCode();
  private static final int fws = "syncTime".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public int field_designerUin;
  public String field_productId;
  public int field_syncTime;
  private boolean fwn = true;
  private boolean fwo = true;
  private boolean fwp = true;
  
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
      if (fwq != k) {
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
      if (fwr == k) {
        this.field_productId = paramCursor.getString(i);
      } else if (fws == k) {
        this.field_syncTime = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fwn) {
      localContentValues.put("designerUin", Integer.valueOf(this.field_designerUin));
    }
    if (this.fwo) {
      localContentValues.put("productId", this.field_productId);
    }
    if (this.fwp) {
      localContentValues.put("syncTime", Integer.valueOf(this.field_syncTime));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.bh
 * JD-Core Version:    0.7.0.1
 */