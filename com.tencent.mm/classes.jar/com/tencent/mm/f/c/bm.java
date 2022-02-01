package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class bm
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("EmojiSuggestDescInfo");
  public static final Column hHh;
  public static final Column hJn;
  private static final int hJv = "desc".hashCode();
  private static final int hJz;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public String field_desc;
  public String field_groupID;
  private boolean hJr = true;
  private boolean hJy = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "EmojiSuggestDescInfo", "");
    hHh = new Column("groupid", "string", "EmojiSuggestDescInfo", "");
    hJn = new Column("desc", "string", "EmojiSuggestDescInfo", "");
    hJz = "groupID".hashCode();
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
      if (hJz != k) {
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
      if (hJv == k) {
        this.field_desc = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.hJy) {
      localContentValues.put("groupID", this.field_groupID);
    }
    if (this.hJr) {
      localContentValues.put("desc", this.field_desc);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
  
  public String[] getIndexCreateSQL()
  {
    return INDEX_CREATE;
  }
  
  public String getTableName()
  {
    return "EmojiSuggestDescInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.c.bm
 * JD-Core Version:    0.7.0.1
 */