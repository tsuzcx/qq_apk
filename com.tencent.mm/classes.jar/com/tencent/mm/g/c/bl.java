package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class bl
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eTG = "desc".hashCode();
  private static final int eTK = "groupID".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eTC = true;
  private boolean eTJ = true;
  public String field_desc;
  public String field_groupID;
  
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
      if (eTK != k) {
        break label60;
      }
      this.field_groupID = paramCursor.getString(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (eTG == k) {
        this.field_desc = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eTJ) {
      localContentValues.put("groupID", this.field_groupID);
    }
    if (this.eTC) {
      localContentValues.put("desc", this.field_desc);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.bl
 * JD-Core Version:    0.7.0.1
 */