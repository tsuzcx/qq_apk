package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class fj
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("OrderCommonMsgXml");
  public static final Column hml;
  private static final int hmt;
  public static final Column hwR;
  private static final int hxt = "isRead".hashCode();
  public static final Column iqD;
  private static final int iqF;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public String field_isRead;
  public String field_msgContentXml;
  public String field_msgId;
  private boolean hmp = true;
  private boolean hxf = true;
  private boolean iqE = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "OrderCommonMsgXml", "");
    hml = new Column("msgid", "string", "OrderCommonMsgXml", "");
    iqD = new Column("msgcontentxml", "string", "OrderCommonMsgXml", "");
    hwR = new Column("isread", "string", "OrderCommonMsgXml", "");
    hmt = "msgId".hashCode();
    iqF = "msgContentXml".hashCode();
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
      this.field_msgId = paramCursor.getString(i);
      this.hmp = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (iqF == k) {
        this.field_msgContentXml = paramCursor.getString(i);
      } else if (hxt == k) {
        this.field_isRead = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.hmp) {
      localContentValues.put("msgId", this.field_msgId);
    }
    if (this.iqE) {
      localContentValues.put("msgContentXml", this.field_msgContentXml);
    }
    if (this.hxf) {
      localContentValues.put("isRead", this.field_isRead);
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
    return "OrderCommonMsgXml";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.c.fj
 * JD-Core Version:    0.7.0.1
 */