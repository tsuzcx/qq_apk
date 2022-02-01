package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class dt
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fjc = "payMsgId".hashCode();
  private static final int fjf = "msgId".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean fiY = true;
  public long field_msgId;
  public String field_payMsgId;
  private boolean fjb = true;
  
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
      if (fjc != k) {
        break label65;
      }
      this.field_payMsgId = paramCursor.getString(i);
      this.fiY = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fjf == k) {
        this.field_msgId = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fiY) {
      localContentValues.put("payMsgId", this.field_payMsgId);
    }
    if (this.fjb) {
      localContentValues.put("msgId", Long.valueOf(this.field_msgId));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.dt
 * JD-Core Version:    0.7.0.1
 */