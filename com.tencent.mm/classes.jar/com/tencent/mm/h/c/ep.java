package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ep
  extends c
{
  public static final String[] cqY = new String[0];
  private static final int crg = "msgId".hashCode();
  private static final int crh = "rowid".hashCode();
  private static final int csD;
  private static final int dak = "cmsgId".hashCode();
  private boolean crc = true;
  private boolean csf = true;
  private boolean daj = true;
  public String field_cmsgId;
  public String field_content;
  public long field_msgId;
  
  static
  {
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
      if (crg != k) {
        break label65;
      }
      this.field_msgId = paramCursor.getLong(i);
      this.crc = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (dak == k) {
        this.field_cmsgId = paramCursor.getString(i);
      } else if (csD == k) {
        this.field_content = paramCursor.getString(i);
      } else if (crh == k) {
        this.ujK = paramCursor.getLong(i);
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.crc) {
      localContentValues.put("msgId", Long.valueOf(this.field_msgId));
    }
    if (this.daj) {
      localContentValues.put("cmsgId", this.field_cmsgId);
    }
    if (this.field_content == null) {
      this.field_content = "";
    }
    if (this.csf) {
      localContentValues.put("content", this.field_content);
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.h.c.ep
 * JD-Core Version:    0.7.0.1
 */