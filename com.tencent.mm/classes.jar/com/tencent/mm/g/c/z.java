package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class z
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int dkB = "appMsgReportContextId".hashCode();
  private static final int dkC = "url".hashCode();
  private static final int dkD = "reportTime".hashCode();
  private static final int dkE = "aScene".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean dkA = true;
  private boolean dkx = true;
  private boolean dky = true;
  private boolean dkz = true;
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
      if (dkB != k) {
        break label65;
      }
      this.field_appMsgReportContextId = paramCursor.getLong(i);
      this.dkx = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (dkC == k) {
        this.field_url = paramCursor.getString(i);
      } else if (dkD == k) {
        this.field_reportTime = paramCursor.getLong(i);
      } else if (dkE == k) {
        this.field_aScene = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.dkx) {
      localContentValues.put("appMsgReportContextId", Long.valueOf(this.field_appMsgReportContextId));
    }
    if (this.dky) {
      localContentValues.put("url", this.field_url);
    }
    if (this.dkz) {
      localContentValues.put("reportTime", Long.valueOf(this.field_reportTime));
    }
    if (this.dkA) {
      localContentValues.put("aScene", Integer.valueOf(this.field_aScene));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.z
 * JD-Core Version:    0.7.0.1
 */