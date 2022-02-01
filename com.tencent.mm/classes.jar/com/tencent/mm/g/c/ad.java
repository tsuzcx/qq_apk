package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class ad
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fjx = "startTime".hashCode();
  private static final int fjy = "endTime".hashCode();
  private static final int fno = "sessionName".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public long field_endTime;
  public String field_sessionName;
  public long field_startTime;
  private boolean fjq = true;
  private boolean fjr = true;
  private boolean fnl = true;
  
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
      if (fno != k) {
        break label60;
      }
      this.field_sessionName = paramCursor.getString(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (fjx == k) {
        this.field_startTime = paramCursor.getLong(i);
      } else if (fjy == k) {
        this.field_endTime = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.field_sessionName == null) {
      this.field_sessionName = "";
    }
    if (this.fnl) {
      localContentValues.put("sessionName", this.field_sessionName);
    }
    if (this.fjq) {
      localContentValues.put("startTime", Long.valueOf(this.field_startTime));
    }
    if (this.fjr) {
      localContentValues.put("endTime", Long.valueOf(this.field_endTime));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.ad
 * JD-Core Version:    0.7.0.1
 */