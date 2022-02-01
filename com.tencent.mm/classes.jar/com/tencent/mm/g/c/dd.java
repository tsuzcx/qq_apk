package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class dd
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eBb = "svrId".hashCode();
  private static final int eKX;
  private static final int eKY = "descUrl".hashCode();
  private static final int elb;
  private static final int eoG;
  private static final int epD;
  private static final int esc = "isRead".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eAY = true;
  private boolean eKV = true;
  private boolean eKW = true;
  private boolean ekE = true;
  private boolean eoD = true;
  private boolean epo = true;
  private boolean erO = true;
  public String field_content;
  public String field_descUrl;
  public short field_isRead;
  public int field_msgType;
  public long field_pushTime;
  public long field_svrId;
  public String field_title;
  
  static
  {
    eoG = "title".hashCode();
    elb = "content".hashCode();
    eKX = "pushTime".hashCode();
    epD = "msgType".hashCode();
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
      if (eBb != k) {
        break label65;
      }
      this.field_svrId = paramCursor.getLong(i);
      this.eAY = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (esc == k) {
        this.field_isRead = paramCursor.getShort(i);
      } else if (eoG == k) {
        this.field_title = paramCursor.getString(i);
      } else if (elb == k) {
        this.field_content = paramCursor.getString(i);
      } else if (eKX == k) {
        this.field_pushTime = paramCursor.getLong(i);
      } else if (epD == k) {
        this.field_msgType = paramCursor.getInt(i);
      } else if (eKY == k) {
        this.field_descUrl = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eAY) {
      localContentValues.put("svrId", Long.valueOf(this.field_svrId));
    }
    if (this.erO) {
      localContentValues.put("isRead", Short.valueOf(this.field_isRead));
    }
    if (this.eoD) {
      localContentValues.put("title", this.field_title);
    }
    if (this.ekE) {
      localContentValues.put("content", this.field_content);
    }
    if (this.eKV) {
      localContentValues.put("pushTime", Long.valueOf(this.field_pushTime));
    }
    if (this.epo) {
      localContentValues.put("msgType", Integer.valueOf(this.field_msgType));
    }
    if (this.eKW) {
      localContentValues.put("descUrl", this.field_descUrl);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.dd
 * JD-Core Version:    0.7.0.1
 */