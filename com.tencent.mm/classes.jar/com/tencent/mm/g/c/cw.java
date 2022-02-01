package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class cw
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eMA = "queryState".hashCode();
  private static final int eMy;
  private static final int eMz;
  private static final int ewj = "chatroomname".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eMv = true;
  private boolean eMw = true;
  private boolean eMx = true;
  private boolean evK = true;
  public String field_chatroomname;
  public int field_queryState;
  public String field_recentUseToolList;
  public String field_stickToollist;
  
  static
  {
    eMy = "stickToollist".hashCode();
    eMz = "recentUseToolList".hashCode();
  }
  
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
      if (ewj != k) {
        break label65;
      }
      this.field_chatroomname = paramCursor.getString(i);
      this.evK = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eMy == k) {
        this.field_stickToollist = paramCursor.getString(i);
      } else if (eMz == k) {
        this.field_recentUseToolList = paramCursor.getString(i);
      } else if (eMA == k) {
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
    if (this.evK) {
      localContentValues.put("chatroomname", this.field_chatroomname);
    }
    if (this.eMv) {
      localContentValues.put("stickToollist", this.field_stickToollist);
    }
    if (this.eMw) {
      localContentValues.put("recentUseToolList", this.field_recentUseToolList);
    }
    if (this.eMx) {
      localContentValues.put("queryState", Integer.valueOf(this.field_queryState));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.cw
 * JD-Core Version:    0.7.0.1
 */