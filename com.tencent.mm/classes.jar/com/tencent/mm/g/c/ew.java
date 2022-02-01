package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class ew
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS notifymessagerecordTalkerIndex ON NotifyMessageRecord(talker)" };
  private static final int createTime_HASHCODE = "createTime".hashCode();
  private static final int fjf = "msgId".hashCode();
  private static final int fnZ = "digest".hashCode();
  private static final int fqw = "talker".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean __hadSetcreateTime = true;
  public long field_createTime;
  public String field_digest;
  public long field_msgId;
  public String field_talker;
  private boolean fjb = true;
  private boolean fnK = true;
  private boolean fqi = true;
  
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
      if (fjf != k) {
        break label65;
      }
      this.field_msgId = paramCursor.getLong(i);
      this.fjb = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fqw == k) {
        this.field_talker = paramCursor.getString(i);
      } else if (createTime_HASHCODE == k) {
        this.field_createTime = paramCursor.getLong(i);
      } else if (fnZ == k) {
        this.field_digest = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fjb) {
      localContentValues.put("msgId", Long.valueOf(this.field_msgId));
    }
    if (this.fqi) {
      localContentValues.put("talker", this.field_talker);
    }
    if (this.__hadSetcreateTime) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.fnK) {
      localContentValues.put("digest", this.field_digest);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.ew
 * JD-Core Version:    0.7.0.1
 */