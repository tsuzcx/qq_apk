package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class x
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int dkt = "sessionName".hashCode();
  private static final int dkw = "msgListDataId".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean dkq = true;
  private boolean dkv = true;
  public String field_msgListDataId;
  public String field_sessionName;
  
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
      if (dkw != k) {
        break label65;
      }
      this.field_msgListDataId = paramCursor.getString(i);
      this.dkv = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (dkt == k) {
        this.field_sessionName = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.dkv) {
      localContentValues.put("msgListDataId", this.field_msgListDataId);
    }
    if (this.field_sessionName == null) {
      this.field_sessionName = "";
    }
    if (this.dkq) {
      localContentValues.put("sessionName", this.field_sessionName);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.g.c.x
 * JD-Core Version:    0.7.0.1
 */