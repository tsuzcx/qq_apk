package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class dv
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int content_HASHCODE;
  private static final int fAj = "svrId".hashCode();
  private static final int fMN;
  private static final int fMO = "descUrl".hashCode();
  private static final int fne;
  private static final int fof;
  private static final int fqF = "isRead".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean __hadSetcontent = true;
  private boolean fAg = true;
  private boolean fML = true;
  private boolean fMM = true;
  public String field_content;
  public String field_descUrl;
  public short field_isRead;
  public int field_msgType;
  public long field_pushTime;
  public long field_svrId;
  public String field_title;
  private boolean fnQ = true;
  private boolean fnb = true;
  private boolean fqr = true;
  
  static
  {
    fne = "title".hashCode();
    content_HASHCODE = "content".hashCode();
    fMN = "pushTime".hashCode();
    fof = "msgType".hashCode();
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
      if (fAj != k) {
        break label65;
      }
      this.field_svrId = paramCursor.getLong(i);
      this.fAg = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fqF == k) {
        this.field_isRead = paramCursor.getShort(i);
      } else if (fne == k) {
        this.field_title = paramCursor.getString(i);
      } else if (content_HASHCODE == k) {
        this.field_content = paramCursor.getString(i);
      } else if (fMN == k) {
        this.field_pushTime = paramCursor.getLong(i);
      } else if (fof == k) {
        this.field_msgType = paramCursor.getInt(i);
      } else if (fMO == k) {
        this.field_descUrl = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fAg) {
      localContentValues.put("svrId", Long.valueOf(this.field_svrId));
    }
    if (this.fqr) {
      localContentValues.put("isRead", Short.valueOf(this.field_isRead));
    }
    if (this.fnb) {
      localContentValues.put("title", this.field_title);
    }
    if (this.__hadSetcontent) {
      localContentValues.put("content", this.field_content);
    }
    if (this.fML) {
      localContentValues.put("pushTime", Long.valueOf(this.field_pushTime));
    }
    if (this.fnQ) {
      localContentValues.put("msgType", Integer.valueOf(this.field_msgType));
    }
    if (this.fMM) {
      localContentValues.put("descUrl", this.field_descUrl);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.dv
 * JD-Core Version:    0.7.0.1
 */