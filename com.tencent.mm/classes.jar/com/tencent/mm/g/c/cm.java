package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class cm
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int dfA = "payMsgId".hashCode();
  private static final int dfD = "msgId".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean dfw = true;
  private boolean dfz = true;
  public long field_msgId;
  public String field_payMsgId;
  
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
      if (dfA != k) {
        break label65;
      }
      this.field_payMsgId = paramCursor.getString(i);
      this.dfw = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (dfD == k) {
        this.field_msgId = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.dfw) {
      localContentValues.put("payMsgId", this.field_payMsgId);
    }
    if (this.dfz) {
      localContentValues.put("msgId", Long.valueOf(this.field_msgId));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.c.cm
 * JD-Core Version:    0.7.0.1
 */