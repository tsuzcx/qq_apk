package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class dq
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("GroupTools");
  private static final int hAY = "chatroomname".hashCode();
  public static final Column hzX;
  public static final Column icP;
  public static final Column icQ;
  public static final Column icR;
  private static final int icV = "stickToollist".hashCode();
  private static final int icW = "recentUseToolList".hashCode();
  private static final int icX = "queryState".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public String field_chatroomname;
  public int field_queryState;
  public String field_recentUseToolList;
  public String field_stickToollist;
  private boolean hAx = true;
  private boolean icS = true;
  private boolean icT = true;
  private boolean icU = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "GroupTools", "");
    hzX = new Column("chatroomname", "string", "GroupTools", "");
    icP = new Column("sticktoollist", "string", "GroupTools", "");
    icQ = new Column("recentusetoollist", "string", "GroupTools", "");
    icR = new Column("querystate", "int", "GroupTools", "");
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
      if (hAY != k) {
        break label65;
      }
      this.field_chatroomname = paramCursor.getString(i);
      this.hAx = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (icV == k) {
        this.field_stickToollist = paramCursor.getString(i);
      } else if (icW == k) {
        this.field_recentUseToolList = paramCursor.getString(i);
      } else if (icX == k) {
        this.field_queryState = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.hAx) {
      localContentValues.put("chatroomname", this.field_chatroomname);
    }
    if (this.icS) {
      localContentValues.put("stickToollist", this.field_stickToollist);
    }
    if (this.icT) {
      localContentValues.put("recentUseToolList", this.field_recentUseToolList);
    }
    if (this.icU) {
      localContentValues.put("queryState", Integer.valueOf(this.field_queryState));
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
    return "GroupTools";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.c.dq
 * JD-Core Version:    0.7.0.1
 */