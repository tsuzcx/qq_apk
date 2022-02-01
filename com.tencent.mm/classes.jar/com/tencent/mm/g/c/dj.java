package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class dj
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fKJ = "chatRoomName".hashCode();
  private static final int fKK = "BindAppData".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean fKH = true;
  private boolean fKI = true;
  public byte[] field_BindAppData;
  public String field_chatRoomName;
  
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
      if (fKJ != k) {
        break label65;
      }
      this.field_chatRoomName = paramCursor.getString(i);
      this.fKH = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fKK == k) {
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
    if (this.fKH) {
      localContentValues.put("chatRoomName", this.field_chatRoomName);
    }
    if (this.fKI) {
      localContentValues.put("BindAppData", this.field_BindAppData);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.c.dj
 * JD-Core Version:    0.7.0.1
 */