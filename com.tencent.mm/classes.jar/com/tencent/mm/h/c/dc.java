package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class dc
  extends c
{
  private static final int cTy;
  public static final String[] cqY = new String[0];
  private static final int crg = "msgId".hashCode();
  private static final int crh = "rowid".hashCode();
  private static final int czp;
  private boolean cTx = true;
  private boolean crc = true;
  private boolean cze = true;
  public String field_isRead;
  public String field_msgContentXml;
  public String field_msgId;
  
  static
  {
    cTy = "msgContentXml".hashCode();
    czp = "isRead".hashCode();
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
      this.field_msgId = paramCursor.getString(i);
      this.crc = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (cTy == k) {
        this.field_msgContentXml = paramCursor.getString(i);
      } else if (czp == k) {
        this.field_isRead = paramCursor.getString(i);
      } else if (crh == k) {
        this.ujK = paramCursor.getLong(i);
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.crc) {
      localContentValues.put("msgId", this.field_msgId);
    }
    if (this.cTx) {
      localContentValues.put("msgContentXml", this.field_msgContentXml);
    }
    if (this.cze) {
      localContentValues.put("isRead", this.field_isRead);
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.h.c.dc
 * JD-Core Version:    0.7.0.1
 */