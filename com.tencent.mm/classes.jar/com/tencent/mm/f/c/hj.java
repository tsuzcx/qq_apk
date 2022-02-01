package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class hj
  extends IAutoDBItem
{
  public static final Column C_CONTENT;
  public static final Column C_ROWID;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("VoiceTransText");
  private static final int content_HASHCODE = "content".hashCode();
  public static final Column hml;
  private static final int hmt;
  public static final Column iDv;
  private static final int iDx;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean __hadSetcontent = true;
  public String field_cmsgId;
  public String field_content;
  public long field_msgId;
  private boolean hmp = true;
  private boolean iDw = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "VoiceTransText", "");
    hml = new Column("msgid", "long", "VoiceTransText", "");
    iDv = new Column("cmsgid", "string", "VoiceTransText", "");
    C_CONTENT = new Column("content", "string", "VoiceTransText", "");
    hmt = "msgId".hashCode();
    iDx = "cmsgId".hashCode();
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
      if (iDx == k) {
        this.field_cmsgId = paramCursor.getString(i);
      } else if (content_HASHCODE == k) {
        this.field_content = paramCursor.getString(i);
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
    if (this.iDw) {
      localContentValues.put("cmsgId", this.field_cmsgId);
    }
    if (this.field_content == null) {
      this.field_content = "";
    }
    if (this.__hadSetcontent) {
      localContentValues.put("content", this.field_content);
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
    return "VoiceTransText";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.c.hj
 * JD-Core Version:    0.7.0.1
 */