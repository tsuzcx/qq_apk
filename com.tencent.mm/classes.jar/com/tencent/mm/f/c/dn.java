package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class dn
  extends IAutoDBItem
{
  public static final Column C_ROWID = new Column("rowid", "long", "GroupBindApp", "");
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("GroupBindApp");
  public static final Column hzX = new Column("chatroomname", "string", "GroupBindApp", "");
  public static final Column ibR = new Column("bindappdata", "byte[]", "GroupBindApp", "");
  private static final int ibU = "chatRoomName".hashCode();
  private static final int ibV = "BindAppData".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public byte[] field_BindAppData;
  public String field_chatRoomName;
  private boolean ibS = true;
  private boolean ibT = true;
  
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
      if (ibU != k) {
        break label65;
      }
      this.field_chatRoomName = paramCursor.getString(i);
      this.ibS = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (ibV == k) {
        this.field_BindAppData = paramCursor.getBlob(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.field_chatRoomName == null) {
      this.field_chatRoomName = "群username";
    }
    if (this.ibS) {
      localContentValues.put("chatRoomName", this.field_chatRoomName);
    }
    if (this.ibT) {
      localContentValues.put("BindAppData", this.field_BindAppData);
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
    return "GroupBindApp";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.c.dn
 * JD-Core Version:    0.7.0.1
 */