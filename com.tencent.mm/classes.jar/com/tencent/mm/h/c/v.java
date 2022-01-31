package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class v
  extends c
{
  public static final String[] cqY = new String[0];
  private static final int crh = "rowid".hashCode();
  private static final int cwk;
  private static final int cwn = "msgListDataId".hashCode();
  private boolean cwh = true;
  private boolean cwm = true;
  public String field_msgListDataId;
  public String field_sessionName;
  
  static
  {
    cwk = "sessionName".hashCode();
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
      if (cwn != k) {
        break label65;
      }
      this.field_msgListDataId = paramCursor.getString(i);
      this.cwm = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (cwk == k) {
        this.field_sessionName = paramCursor.getString(i);
      } else if (crh == k) {
        this.ujK = paramCursor.getLong(i);
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.cwm) {
      localContentValues.put("msgListDataId", this.field_msgListDataId);
    }
    if (this.field_sessionName == null) {
      this.field_sessionName = "";
    }
    if (this.cwh) {
      localContentValues.put("sessionName", this.field_sessionName);
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.h.c.v
 * JD-Core Version:    0.7.0.1
 */