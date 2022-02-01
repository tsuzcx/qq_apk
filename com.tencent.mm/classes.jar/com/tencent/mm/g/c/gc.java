package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class gc
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eSc = "count".hashCode();
  private static final int ftL = "tagId".hashCode();
  private static final int ftM = "tagName".hashCode();
  private static final int ftN = "memberList".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eRC = true;
  public int field_count;
  public String field_memberList;
  public long field_tagId;
  public String field_tagName;
  private boolean ftI = true;
  private boolean ftJ = true;
  private boolean ftK = true;
  
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
      if (ftL != k) {
        break label60;
      }
      this.field_tagId = paramCursor.getLong(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (ftM == k) {
        this.field_tagName = paramCursor.getString(i);
      } else if (eSc == k) {
        this.field_count = paramCursor.getInt(i);
      } else if (ftN == k) {
        this.field_memberList = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.ftI) {
      localContentValues.put("tagId", Long.valueOf(this.field_tagId));
    }
    if (this.field_tagName == null) {
      this.field_tagName = "";
    }
    if (this.ftJ) {
      localContentValues.put("tagName", this.field_tagName);
    }
    if (this.eRC) {
      localContentValues.put("count", Integer.valueOf(this.field_count));
    }
    if (this.field_memberList == null) {
      this.field_memberList = "";
    }
    if (this.ftK) {
      localContentValues.put("memberList", this.field_memberList);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.gc
 * JD-Core Version:    0.7.0.1
 */