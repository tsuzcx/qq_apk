package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class a
  extends c
{
  public static final String[] cqY = new String[0];
  private static final int crd = "payMsgId".hashCode();
  private static final int cre = "insertmsg".hashCode();
  private static final int crf = "chatroom".hashCode();
  private static final int crg = "msgId".hashCode();
  private static final int crh = "rowid".hashCode();
  private boolean cqZ = true;
  private boolean cra = true;
  private boolean crb = true;
  private boolean crc = true;
  public String field_chatroom;
  public boolean field_insertmsg;
  public long field_msgId;
  public String field_payMsgId;
  
  public final void d(Cursor paramCursor)
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
      if (crd != k) {
        break label65;
      }
      this.field_payMsgId = paramCursor.getString(i);
      this.cqZ = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (cre == k)
      {
        if (paramCursor.getInt(i) != 0) {}
        for (boolean bool = true;; bool = false)
        {
          this.field_insertmsg = bool;
          break;
        }
      }
      if (crf == k) {
        this.field_chatroom = paramCursor.getString(i);
      } else if (crg == k) {
        this.field_msgId = paramCursor.getLong(i);
      } else if (crh == k) {
        this.ujK = paramCursor.getLong(i);
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.cqZ) {
      localContentValues.put("payMsgId", this.field_payMsgId);
    }
    if (this.cra) {
      localContentValues.put("insertmsg", Boolean.valueOf(this.field_insertmsg));
    }
    if (this.crb) {
      localContentValues.put("chatroom", this.field_chatroom);
    }
    if (this.crc) {
      localContentValues.put("msgId", Long.valueOf(this.field_msgId));
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.h.c.a
 * JD-Core Version:    0.7.0.1
 */