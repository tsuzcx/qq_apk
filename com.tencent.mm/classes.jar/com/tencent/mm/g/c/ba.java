package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ba
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int elP = "msgId".hashCode();
  private static final int ezo = "transferId".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean elL = true;
  private boolean ezn = true;
  public long field_msgId;
  public String field_transferId;
  
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
      if (elP != k) {
        break label65;
      }
      this.field_msgId = paramCursor.getLong(i);
      this.elL = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (ezo == k) {
        this.field_transferId = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.elL) {
      localContentValues.put("msgId", Long.valueOf(this.field_msgId));
    }
    if (this.ezn) {
      localContentValues.put("transferId", this.field_transferId);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.ba
 * JD-Core Version:    0.7.0.1
 */