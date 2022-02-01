package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class dg
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int ePs = "chatroomname".hashCode();
  private static final int fgR = "stickToollist".hashCode();
  private static final int fgS = "recentUseToolList".hashCode();
  private static final int fgT = "queryState".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eOS = true;
  private boolean fgO = true;
  private boolean fgP = true;
  private boolean fgQ = true;
  public String field_chatroomname;
  public int field_queryState;
  public String field_recentUseToolList;
  public String field_stickToollist;
  
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
      if (ePs != k) {
        break label65;
      }
      this.field_chatroomname = paramCursor.getString(i);
      this.eOS = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fgR == k) {
        this.field_stickToollist = paramCursor.getString(i);
      } else if (fgS == k) {
        this.field_recentUseToolList = paramCursor.getString(i);
      } else if (fgT == k) {
        this.field_queryState = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eOS) {
      localContentValues.put("chatroomname", this.field_chatroomname);
    }
    if (this.fgO) {
      localContentValues.put("stickToollist", this.field_stickToollist);
    }
    if (this.fgP) {
      localContentValues.put("recentUseToolList", this.field_recentUseToolList);
    }
    if (this.fgQ) {
      localContentValues.put("queryState", Integer.valueOf(this.field_queryState));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.dg
 * JD-Core Version:    0.7.0.1
 */