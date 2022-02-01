package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class dg
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eNH = "chatroomname".hashCode();
  private static final int feU = "stickToollist".hashCode();
  private static final int feV = "recentUseToolList".hashCode();
  private static final int feW = "queryState".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eNh = true;
  private boolean feR = true;
  private boolean feS = true;
  private boolean feT = true;
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
      if (eNH != k) {
        break label65;
      }
      this.field_chatroomname = paramCursor.getString(i);
      this.eNh = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (feU == k) {
        this.field_stickToollist = paramCursor.getString(i);
      } else if (feV == k) {
        this.field_recentUseToolList = paramCursor.getString(i);
      } else if (feW == k) {
        this.field_queryState = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.field_chatroomname == null) {
      this.field_chatroomname = "群username";
    }
    if (this.eNh) {
      localContentValues.put("chatroomname", this.field_chatroomname);
    }
    if (this.feR) {
      localContentValues.put("stickToollist", this.field_stickToollist);
    }
    if (this.feS) {
      localContentValues.put("recentUseToolList", this.field_recentUseToolList);
    }
    if (this.feT) {
      localContentValues.put("queryState", Integer.valueOf(this.field_queryState));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.dg
 * JD-Core Version:    0.7.0.1
 */