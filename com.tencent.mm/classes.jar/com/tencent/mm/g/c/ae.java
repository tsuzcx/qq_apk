package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ae
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eJU = "appMsgReportContextId".hashCode();
  private static final int eJV = "url".hashCode();
  private static final int eJW = "reportTime".hashCode();
  private static final int eJX = "aScene".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eJQ = true;
  private boolean eJR = true;
  private boolean eJS = true;
  private boolean eJT = true;
  public int field_aScene;
  public long field_appMsgReportContextId;
  public long field_reportTime;
  public String field_url;
  
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
      if (eJU != k) {
        break label65;
      }
      this.field_appMsgReportContextId = paramCursor.getLong(i);
      this.eJQ = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eJV == k) {
        this.field_url = paramCursor.getString(i);
      } else if (eJW == k) {
        this.field_reportTime = paramCursor.getLong(i);
      } else if (eJX == k) {
        this.field_aScene = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eJQ) {
      localContentValues.put("appMsgReportContextId", Long.valueOf(this.field_appMsgReportContextId));
    }
    if (this.eJR) {
      localContentValues.put("url", this.field_url);
    }
    if (this.eJS) {
      localContentValues.put("reportTime", Long.valueOf(this.field_reportTime));
    }
    if (this.eJT) {
      localContentValues.put("aScene", Integer.valueOf(this.field_aScene));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.ae
 * JD-Core Version:    0.7.0.1
 */