package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class fb
  extends IAutoDBItem
{
  public static final Column C_CREATETIME;
  public static final Column C_ROWID;
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS notifymessagerecordTalkerIndex ON NotifyMessageRecord(talker)" };
  public static final SingleTable TABLE = new SingleTable("NotifyMessageRecord");
  private static final int createTime_HASHCODE = "createTime".hashCode();
  public static final Column hml;
  private static final int hmt;
  public static final Column hsY;
  private static final int htC = "digest".hashCode();
  public static final Column hwI;
  private static final int hxk;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean __hadSetcreateTime = true;
  public long field_createTime;
  public String field_digest;
  public long field_msgId;
  public String field_talker;
  private boolean hmp = true;
  private boolean htn = true;
  private boolean hwW = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "NotifyMessageRecord", "");
    hml = new Column("msgid", "long", "NotifyMessageRecord", "");
    hwI = new Column("talker", "string", "NotifyMessageRecord", "");
    C_CREATETIME = new Column("createtime", "long", "NotifyMessageRecord", "");
    hsY = new Column("digest", "string", "NotifyMessageRecord", "");
    hmt = "msgId".hashCode();
    hxk = "talker".hashCode();
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
        break label65;
      }
      this.field_msgId = paramCursor.getLong(i);
      this.hmp = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (hxk == k) {
        this.field_talker = paramCursor.getString(i);
      } else if (createTime_HASHCODE == k) {
        this.field_createTime = paramCursor.getLong(i);
      } else if (htC == k) {
        this.field_digest = paramCursor.getString(i);
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
    if (this.hwW) {
      localContentValues.put("talker", this.field_talker);
    }
    if (this.__hadSetcreateTime) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.htn) {
      localContentValues.put("digest", this.field_digest);
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
    return "NotifyMessageRecord";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.c.fb
 * JD-Core Version:    0.7.0.1
 */