package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class af
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fnA = "appMsgReportContextId".hashCode();
  private static final int fnB = "url".hashCode();
  private static final int fnC = "reportTime".hashCode();
  private static final int fnD = "aScene".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public int field_aScene;
  public long field_appMsgReportContextId;
  public long field_reportTime;
  public String field_url;
  private boolean fnw = true;
  private boolean fnx = true;
  private boolean fny = true;
  private boolean fnz = true;
  
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
      if (fnA != k) {
        break label65;
      }
      this.field_appMsgReportContextId = paramCursor.getLong(i);
      this.fnw = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fnB == k) {
        this.field_url = paramCursor.getString(i);
      } else if (fnC == k) {
        this.field_reportTime = paramCursor.getLong(i);
      } else if (fnD == k) {
        this.field_aScene = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fnw) {
      localContentValues.put("appMsgReportContextId", Long.valueOf(this.field_appMsgReportContextId));
    }
    if (this.fnx) {
      localContentValues.put("url", this.field_url);
    }
    if (this.fny) {
      localContentValues.put("reportTime", Long.valueOf(this.field_reportTime));
    }
    if (this.fnz) {
      localContentValues.put("aScene", Integer.valueOf(this.field_aScene));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.af
 * JD-Core Version:    0.7.0.1
 */