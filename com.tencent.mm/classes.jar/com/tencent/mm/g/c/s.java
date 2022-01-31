package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class s
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int dhB = "appId".hashCode();
  private static final int diB = "version".hashCode();
  private static final int diK = "source".hashCode();
  private static final int diL = "hitCount".hashCode();
  private static final int diM = "reportId".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean dhk = true;
  private boolean diH = true;
  private boolean diI = true;
  private boolean diJ = true;
  private boolean div = true;
  public String field_appId;
  public int field_hitCount;
  public int field_reportId;
  public int field_source;
  public int field_version;
  
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
      if (dhB != k) {
        break label60;
      }
      this.field_appId = paramCursor.getString(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (diB == k) {
        this.field_version = paramCursor.getInt(i);
      } else if (diK == k) {
        this.field_source = paramCursor.getInt(i);
      } else if (diL == k) {
        this.field_hitCount = paramCursor.getInt(i);
      } else if (diM == k) {
        this.field_reportId = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.dhk) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.div) {
      localContentValues.put("version", Integer.valueOf(this.field_version));
    }
    if (this.diH) {
      localContentValues.put("source", Integer.valueOf(this.field_source));
    }
    if (this.diI) {
      localContentValues.put("hitCount", Integer.valueOf(this.field_hitCount));
    }
    if (this.diJ) {
      localContentValues.put("reportId", Integer.valueOf(this.field_reportId));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.c.s
 * JD-Core Version:    0.7.0.1
 */