package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class gq
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eCW = "msgId".hashCode();
  private static final int eEm = "content".hashCode();
  private static final int fwn = "cmsgId".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eCS = true;
  private boolean eDP = true;
  public String field_cmsgId;
  public String field_content;
  public long field_msgId;
  private boolean fwm = true;
  
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
      if (eCW != k) {
        break label65;
      }
      this.field_msgId = paramCursor.getLong(i);
      this.eCS = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fwn == k) {
        this.field_cmsgId = paramCursor.getString(i);
      } else if (eEm == k) {
        this.field_content = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eCS) {
      localContentValues.put("msgId", Long.valueOf(this.field_msgId));
    }
    if (this.fwm) {
      localContentValues.put("cmsgId", this.field_cmsgId);
    }
    if (this.field_content == null) {
      this.field_content = "";
    }
    if (this.eDP) {
      localContentValues.put("content", this.field_content);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.gq
 * JD-Core Version:    0.7.0.1
 */