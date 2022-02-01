package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class a
  extends IAutoDBItem
{
  public static final Column C_ROWID = new Column("rowid", "long", "AAPayRecord", "");
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("AAPayRecord");
  public static final Column hmi = new Column("paymsgid", "string", "AAPayRecord", "");
  public static final Column hmj = new Column("insertmsg", "boolean", "AAPayRecord", "");
  public static final Column hmk = new Column("chatroom", "string", "AAPayRecord", "");
  public static final Column hml = new Column("msgid", "long", "AAPayRecord", "");
  private static final int hmq = "payMsgId".hashCode();
  private static final int hmr = "insertmsg".hashCode();
  private static final int hms = "chatroom".hashCode();
  private static final int hmt = "msgId".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public String field_chatroom;
  public boolean field_insertmsg;
  public long field_msgId;
  public String field_payMsgId;
  private boolean hmm = true;
  private boolean hmn = true;
  private boolean hmo = true;
  private boolean hmp = true;
  
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
      if (hmq != k) {
        break label65;
      }
      this.field_payMsgId = paramCursor.getString(i);
      this.hmm = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (hmr == k)
      {
        if (paramCursor.getInt(i) != 0) {}
        for (boolean bool = true;; bool = false)
        {
          this.field_insertmsg = bool;
          break;
        }
      }
      if (hms == k) {
        this.field_chatroom = paramCursor.getString(i);
      } else if (hmt == k) {
        this.field_msgId = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.hmm) {
      localContentValues.put("payMsgId", this.field_payMsgId);
    }
    if (this.hmn) {
      localContentValues.put("insertmsg", Boolean.valueOf(this.field_insertmsg));
    }
    if (this.hmo) {
      localContentValues.put("chatroom", this.field_chatroom);
    }
    if (this.hmp) {
      localContentValues.put("msgId", Long.valueOf(this.field_msgId));
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
    return "AAPayRecord";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.c.a
 * JD-Core Version:    0.7.0.1
 */