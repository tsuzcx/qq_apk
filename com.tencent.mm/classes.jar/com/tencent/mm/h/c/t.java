package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class t
  extends c
{
  public static final String[] cqY = new String[0];
  private static final int crh = "rowid".hashCode();
  private static final int ctl;
  private static final int cwe = "flag".hashCode();
  private static final int cwf;
  private boolean csU = true;
  private boolean cwc = true;
  private boolean cwd = true;
  public String field_appId;
  public long field_flag;
  public int field_sortId;
  
  static
  {
    ctl = "appId".hashCode();
    cwf = "sortId".hashCode();
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
      if (cwe != k) {
        break label60;
      }
      this.field_flag = paramCursor.getLong(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (ctl == k) {
        this.field_appId = paramCursor.getString(i);
      } else if (cwf == k) {
        this.field_sortId = paramCursor.getInt(i);
      } else if (crh == k) {
        this.ujK = paramCursor.getLong(i);
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.cwc) {
      localContentValues.put("flag", Long.valueOf(this.field_flag));
    }
    if (this.field_appId == null) {
      this.field_appId = "";
    }
    if (this.csU) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.cwd) {
      localContentValues.put("sortId", Integer.valueOf(this.field_sortId));
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.h.c.t
 * JD-Core Version:    0.7.0.1
 */