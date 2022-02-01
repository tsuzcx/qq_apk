package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class bm
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fyW = "desc".hashCode();
  private static final int fza = "groupID".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public String field_desc;
  public String field_groupID;
  private boolean fyS = true;
  private boolean fyZ = true;
  
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
      if (fza != k) {
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
      if (fyW == k) {
        this.field_desc = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fyZ) {
      localContentValues.put("groupID", this.field_groupID);
    }
    if (this.fyS) {
      localContentValues.put("desc", this.field_desc);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.bm
 * JD-Core Version:    0.7.0.1
 */