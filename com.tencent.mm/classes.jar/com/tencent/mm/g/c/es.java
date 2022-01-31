package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class es
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int dPs = "tagId".hashCode();
  private static final int dPt = "tagName".hashCode();
  private static final int dPu = "memberList".hashCode();
  private static final int dtj = "count".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean dPp = true;
  private boolean dPq = true;
  private boolean dPr = true;
  private boolean dsJ = true;
  public int field_count;
  public String field_memberList;
  public long field_tagId;
  public String field_tagName;
  
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
      if (dPs != k) {
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
      if (dPt == k) {
        this.field_tagName = paramCursor.getString(i);
      } else if (dtj == k) {
        this.field_count = paramCursor.getInt(i);
      } else if (dPu == k) {
        this.field_memberList = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.dPp) {
      localContentValues.put("tagId", Long.valueOf(this.field_tagId));
    }
    if (this.field_tagName == null) {
      this.field_tagName = "";
    }
    if (this.dPq) {
      localContentValues.put("tagName", this.field_tagName);
    }
    if (this.dsJ) {
      localContentValues.put("count", Integer.valueOf(this.field_count));
    }
    if (this.field_memberList == null) {
      this.field_memberList = "";
    }
    if (this.dPr) {
      localContentValues.put("memberList", this.field_memberList);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.es
 * JD-Core Version:    0.7.0.1
 */