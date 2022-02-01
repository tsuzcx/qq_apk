package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class dm
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fLu = "stickToollist".hashCode();
  private static final int fLv = "recentUseToolList".hashCode();
  private static final int fLw = "queryState".hashCode();
  private static final int fsZ = "chatroomname".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean fLr = true;
  private boolean fLs = true;
  private boolean fLt = true;
  public String field_chatroomname;
  public int field_queryState;
  public String field_recentUseToolList;
  public String field_stickToollist;
  private boolean fsz = true;
  
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
      if (fsZ != k) {
        break label65;
      }
      this.field_chatroomname = paramCursor.getString(i);
      this.fsz = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fLu == k) {
        this.field_stickToollist = paramCursor.getString(i);
      } else if (fLv == k) {
        this.field_recentUseToolList = paramCursor.getString(i);
      } else if (fLw == k) {
        this.field_queryState = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fsz) {
      localContentValues.put("chatroomname", this.field_chatroomname);
    }
    if (this.fLr) {
      localContentValues.put("stickToollist", this.field_stickToollist);
    }
    if (this.fLs) {
      localContentValues.put("recentUseToolList", this.field_recentUseToolList);
    }
    if (this.fLt) {
      localContentValues.put("queryState", Integer.valueOf(this.field_queryState));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.c.dm
 * JD-Core Version:    0.7.0.1
 */