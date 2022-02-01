package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class a
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int elM = "payMsgId".hashCode();
  private static final int elN = "insertmsg".hashCode();
  private static final int elO = "chatroom".hashCode();
  private static final int elP = "msgId".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean elI = true;
  private boolean elJ = true;
  private boolean elK = true;
  private boolean elL = true;
  public String field_chatroom;
  public boolean field_insertmsg;
  public long field_msgId;
  public String field_payMsgId;
  
  public void convertFrom(Cursor paramCursor)
  {
    String[] arrayOfString = paramCursor.getColumnNames();
    if (arrayOfString == null) {
      return;
    }
    int j = arrayOfString.length;
    int i = 0;
    label20:
    int k;
    if (i < j)
    {
      k = arrayOfString[i].hashCode();
      if (elM != k) {
        break label65;
      }
      this.field_payMsgId = paramCursor.getString(i);
      this.elI = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (elN == k)
      {
        if (paramCursor.getInt(i) != 0) {}
        for (boolean bool = true;; bool = false)
        {
          this.field_insertmsg = bool;
          break;
        }
      }
      if (elO == k) {
        this.field_chatroom = paramCursor.getString(i);
      } else if (elP == k) {
        this.field_msgId = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.elI) {
      localContentValues.put("payMsgId", this.field_payMsgId);
    }
    if (this.elJ) {
      localContentValues.put("insertmsg", Boolean.valueOf(this.field_insertmsg));
    }
    if (this.elK) {
      localContentValues.put("chatroom", this.field_chatroom);
    }
    if (this.elL) {
      localContentValues.put("msgId", Long.valueOf(this.field_msgId));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.a
 * JD-Core Version:    0.7.0.1
 */