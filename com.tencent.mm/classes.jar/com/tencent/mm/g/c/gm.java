package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class gm
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fxs = "count".hashCode();
  private static final int gav = "tagId".hashCode();
  private static final int gaw = "tagName".hashCode();
  private static final int gax = "memberList".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public int field_count;
  public String field_memberList;
  public long field_tagId;
  public String field_tagName;
  private boolean fwS = true;
  private boolean gas = true;
  private boolean gat = true;
  private boolean gau = true;
  
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
      if (gav != k) {
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
      if (gaw == k) {
        this.field_tagName = paramCursor.getString(i);
      } else if (fxs == k) {
        this.field_count = paramCursor.getInt(i);
      } else if (gax == k) {
        this.field_memberList = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.gas) {
      localContentValues.put("tagId", Long.valueOf(this.field_tagId));
    }
    if (this.field_tagName == null) {
      this.field_tagName = "";
    }
    if (this.gat) {
      localContentValues.put("tagName", this.field_tagName);
    }
    if (this.fwS) {
      localContentValues.put("count", Integer.valueOf(this.field_count));
    }
    if (this.field_memberList == null) {
      this.field_memberList = "";
    }
    if (this.gau) {
      localContentValues.put("memberList", this.field_memberList);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.gm
 * JD-Core Version:    0.7.0.1
 */