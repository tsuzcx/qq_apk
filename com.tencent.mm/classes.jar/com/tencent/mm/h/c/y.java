package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class y
  extends c
{
  public static final String[] cqY = new String[0];
  private static final int crh = "rowid".hashCode();
  private static final int cwB = "appMsgReportContextId".hashCode();
  private static final int cwC;
  private static final int cwD;
  private static final int cwu = "url".hashCode();
  private boolean cwA = true;
  private boolean cwp = true;
  private boolean cwy = true;
  private boolean cwz = true;
  public int field_aScene;
  public long field_appMsgReportContextId;
  public long field_reportTime;
  public String field_url;
  
  static
  {
    cwC = "reportTime".hashCode();
    cwD = "aScene".hashCode();
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
      if (cwB != k) {
        break label65;
      }
      this.field_appMsgReportContextId = paramCursor.getLong(i);
      this.cwy = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (cwu == k) {
        this.field_url = paramCursor.getString(i);
      } else if (cwC == k) {
        this.field_reportTime = paramCursor.getLong(i);
      } else if (cwD == k) {
        this.field_aScene = paramCursor.getInt(i);
      } else if (crh == k) {
        this.ujK = paramCursor.getLong(i);
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.cwy) {
      localContentValues.put("appMsgReportContextId", Long.valueOf(this.field_appMsgReportContextId));
    }
    if (this.cwp) {
      localContentValues.put("url", this.field_url);
    }
    if (this.cwz) {
      localContentValues.put("reportTime", Long.valueOf(this.field_reportTime));
    }
    if (this.cwA) {
      localContentValues.put("aScene", Integer.valueOf(this.field_aScene));
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.h.c.y
 * JD-Core Version:    0.7.0.1
 */