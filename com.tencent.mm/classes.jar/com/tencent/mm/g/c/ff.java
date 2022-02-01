package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class ff
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fDK = "retryCount".hashCode();
  private static final int fUA = "cardUserId".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean fDu = true;
  private boolean fUz = true;
  public String field_cardUserId;
  public int field_retryCount;
  
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
      if (fUA != k) {
        break label65;
      }
      this.field_cardUserId = paramCursor.getString(i);
      this.fUz = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fDK == k) {
        this.field_retryCount = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fUz) {
      localContentValues.put("cardUserId", this.field_cardUserId);
    }
    if (this.fDu) {
      localContentValues.put("retryCount", Integer.valueOf(this.field_retryCount));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.ff
 * JD-Core Version:    0.7.0.1
 */