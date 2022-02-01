package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class hv
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("WebViewHistory");
  public static final Column hMZ;
  public static final Column hpi;
  private static final int hpq;
  public static final Column hqa;
  private static final int hqk = "source".hashCode();
  public static final Column hsa;
  private static final int hsg;
  public static final Column iJT;
  public static final Column iJU;
  private static final int iJX;
  private static final int iJY = "imgUrl".hashCode();
  private static final int ijb = "timeStamp".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public String field_imgUrl;
  public String field_link;
  public String field_recordId;
  public String field_source;
  public long field_timeStamp;
  public String field_title;
  private boolean hpm = true;
  private boolean hqf = true;
  private boolean hsd = true;
  private boolean iJV = true;
  private boolean iJW = true;
  private boolean iiW = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "WebViewHistory", "");
    hpi = new Column("recordid", "string", "WebViewHistory", "");
    iJT = new Column("link", "string", "WebViewHistory", "");
    hsa = new Column("title", "string", "WebViewHistory", "");
    hqa = new Column("source", "string", "WebViewHistory", "");
    iJU = new Column("imgurl", "string", "WebViewHistory", "");
    hMZ = new Column("timestamp", "long", "WebViewHistory", "");
    hpq = "recordId".hashCode();
    iJX = "link".hashCode();
    hsg = "title".hashCode();
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
      if (hpq != k) {
        break label65;
      }
      this.field_recordId = paramCursor.getString(i);
      this.hpm = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (iJX == k) {
        this.field_link = paramCursor.getString(i);
      } else if (hsg == k) {
        this.field_title = paramCursor.getString(i);
      } else if (hqk == k) {
        this.field_source = paramCursor.getString(i);
      } else if (iJY == k) {
        this.field_imgUrl = paramCursor.getString(i);
      } else if (ijb == k) {
        this.field_timeStamp = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.hpm) {
      localContentValues.put("recordId", this.field_recordId);
    }
    if (this.iJV) {
      localContentValues.put("link", this.field_link);
    }
    if (this.hsd) {
      localContentValues.put("title", this.field_title);
    }
    if (this.hqf) {
      localContentValues.put("source", this.field_source);
    }
    if (this.iJW) {
      localContentValues.put("imgUrl", this.field_imgUrl);
    }
    if (this.iiW) {
      localContentValues.put("timeStamp", Long.valueOf(this.field_timeStamp));
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
    return "WebViewHistory";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.c.hv
 * JD-Core Version:    0.7.0.1
 */