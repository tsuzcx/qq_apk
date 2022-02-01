package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ac
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eoQ = "sessionName".hashCode();
  private static final int eoT = "msgListDataId".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eoN = true;
  private boolean eoS = true;
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
      if (eoT != k) {
        break label65;
      }
      this.field_msgListDataId = paramCursor.getString(i);
      this.eoS = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eoQ == k) {
        this.field_sessionName = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eoS) {
      localContentValues.put("msgListDataId", this.field_msgListDataId);
    }
    if (this.field_sessionName == null) {
      this.field_sessionName = "";
    }
    if (this.eoN) {
      localContentValues.put("sessionName", this.field_sessionName);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.ac
 * JD-Core Version:    0.7.0.1
 */