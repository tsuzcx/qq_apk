package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class eu
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("MsgQuote");
  private static final int hmC = "status".hashCode();
  public static final Column hml;
  private static final int hmt;
  public static final Column hmw;
  public static final Column hwH;
  private static final int hxj;
  public static final Column ilA;
  public static final Column ilB;
  private static final int ilE;
  private static final int ilF;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public long field_msgId;
  public long field_msgSvrId;
  public long field_quotedMsgId;
  public long field_quotedMsgSvrId;
  public int field_status;
  private boolean hmp = true;
  private boolean hmz = true;
  private boolean hwV = true;
  private boolean ilC = true;
  private boolean ilD = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "MsgQuote", "");
    hml = new Column("msgid", "long", "MsgQuote", "");
    hwH = new Column("msgsvrid", "long", "MsgQuote", "");
    ilA = new Column("quotedmsgid", "long", "MsgQuote", "");
    ilB = new Column("quotedmsgsvrid", "long", "MsgQuote", "");
    hmw = new Column("status", "int", "MsgQuote", "");
    hmt = "msgId".hashCode();
    hxj = "msgSvrId".hashCode();
    ilE = "quotedMsgId".hashCode();
    ilF = "quotedMsgSvrId".hashCode();
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
      if (hmt != k) {
        break label60;
      }
      this.field_msgId = paramCursor.getLong(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (hxj == k) {
        this.field_msgSvrId = paramCursor.getLong(i);
      } else if (ilE == k) {
        this.field_quotedMsgId = paramCursor.getLong(i);
      } else if (ilF == k) {
        this.field_quotedMsgSvrId = paramCursor.getLong(i);
      } else if (hmC == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.hmp) {
      localContentValues.put("msgId", Long.valueOf(this.field_msgId));
    }
    if (this.hwV) {
      localContentValues.put("msgSvrId", Long.valueOf(this.field_msgSvrId));
    }
    if (this.ilC) {
      localContentValues.put("quotedMsgId", Long.valueOf(this.field_quotedMsgId));
    }
    if (this.ilD) {
      localContentValues.put("quotedMsgSvrId", Long.valueOf(this.field_quotedMsgSvrId));
    }
    if (this.hmz) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
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
    return "MsgQuote";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.c.eu
 * JD-Core Version:    0.7.0.1
 */