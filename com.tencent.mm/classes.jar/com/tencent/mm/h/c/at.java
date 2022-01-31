package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class at
  extends c
{
  private static final int cDM = "transferId".hashCode();
  public static final String[] cqY = new String[0];
  private static final int crg = "msgId".hashCode();
  private static final int crh = "rowid".hashCode();
  private boolean cDL = true;
  private boolean crc = true;
  public long field_msgId;
  public String field_transferId;
  
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
      if (cDM == k) {
        this.field_transferId = paramCursor.getString(i);
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
    if (this.cDL) {
      localContentValues.put("transferId", this.field_transferId);
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.h.c.at
 * JD-Core Version:    0.7.0.1
 */