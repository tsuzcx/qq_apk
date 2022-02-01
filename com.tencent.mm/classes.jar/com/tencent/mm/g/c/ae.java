package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ae
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int erc = "appMsgReportContextId".hashCode();
  private static final int erd = "url".hashCode();
  private static final int ere = "reportTime".hashCode();
  private static final int erf = "aScene".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eqY = true;
  private boolean eqZ = true;
  private boolean era = true;
  private boolean erb = true;
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
      if (erc != k) {
        break label65;
      }
      this.field_appMsgReportContextId = paramCursor.getLong(i);
      this.eqY = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (erd == k) {
        this.field_url = paramCursor.getString(i);
      } else if (ere == k) {
        this.field_reportTime = paramCursor.getLong(i);
      } else if (erf == k) {
        this.field_aScene = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eqY) {
      localContentValues.put("appMsgReportContextId", Long.valueOf(this.field_appMsgReportContextId));
    }
    if (this.eqZ) {
      localContentValues.put("url", this.field_url);
    }
    if (this.era) {
      localContentValues.put("reportTime", Long.valueOf(this.field_reportTime));
    }
    if (this.erb) {
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