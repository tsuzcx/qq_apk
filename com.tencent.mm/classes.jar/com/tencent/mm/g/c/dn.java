package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class dn
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int dJI = "msgContentXml".hashCode();
  private static final int dfD = "msgId".hashCode();
  private static final int dnq = "isRead".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean dJH = true;
  private boolean dfz = true;
  private boolean dnf = true;
  public String field_isRead;
  public String field_msgContentXml;
  public String field_msgId;
  
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
      if (dfD != k) {
        break label65;
      }
      this.field_msgId = paramCursor.getString(i);
      this.dfz = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (dJI == k) {
        this.field_msgContentXml = paramCursor.getString(i);
      } else if (dnq == k) {
        this.field_isRead = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.dfz) {
      localContentValues.put("msgId", this.field_msgId);
    }
    if (this.dJH) {
      localContentValues.put("msgContentXml", this.field_msgContentXml);
    }
    if (this.dnf) {
      localContentValues.put("isRead", this.field_isRead);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.c.dn
 * JD-Core Version:    0.7.0.1
 */