package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class ba
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fvt = "labelId".hashCode();
  private static final int fvu = "contactName".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public String field_contactName;
  public String field_labelId;
  private boolean fvr;
  private boolean fvs;
  
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
      if (fvt != k) {
        break label60;
      }
      this.field_labelId = paramCursor.getString(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (fvu == k) {
        this.field_contactName = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fvr) {
      localContentValues.put("labelId", this.field_labelId);
    }
    if (this.fvs) {
      localContentValues.put("contactName", this.field_contactName);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.ba
 * JD-Core Version:    0.7.0.1
 */