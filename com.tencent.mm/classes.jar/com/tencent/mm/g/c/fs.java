package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class fs
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eAE = "count".hashCode();
  private static final int fbx = "tagId".hashCode();
  private static final int fby = "tagName".hashCode();
  private static final int fbz = "memberList".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eAe = true;
  private boolean fbu = true;
  private boolean fbv = true;
  private boolean fbw = true;
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
      if (fbx != k) {
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
      if (fby == k) {
        this.field_tagName = paramCursor.getString(i);
      } else if (eAE == k) {
        this.field_count = paramCursor.getInt(i);
      } else if (fbz == k) {
        this.field_memberList = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fbu) {
      localContentValues.put("tagId", Long.valueOf(this.field_tagId));
    }
    if (this.field_tagName == null) {
      this.field_tagName = "";
    }
    if (this.fbv) {
      localContentValues.put("tagName", this.field_tagName);
    }
    if (this.eAe) {
      localContentValues.put("count", Integer.valueOf(this.field_count));
    }
    if (this.field_memberList == null) {
      this.field_memberList = "";
    }
    if (this.fbw) {
      localContentValues.put("memberList", this.field_memberList);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.fs
 * JD-Core Version:    0.7.0.1
 */