package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class co
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int dDt;
  private static final int dDu = "descUrl".hashCode();
  private static final int dgT;
  private static final int dkj;
  private static final int dlf;
  private static final int dnq;
  private static final int dwb = "svrId".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean dDr = true;
  private boolean dDs = true;
  private boolean dgw = true;
  private boolean dkR = true;
  private boolean dkg = true;
  private boolean dnf = true;
  private boolean dvY = true;
  public String field_content;
  public String field_descUrl;
  public short field_isRead;
  public int field_msgType;
  public long field_pushTime;
  public long field_svrId;
  public String field_title;
  
  static
  {
    dnq = "isRead".hashCode();
    dkj = "title".hashCode();
    dgT = "content".hashCode();
    dDt = "pushTime".hashCode();
    dlf = "msgType".hashCode();
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
      if (dwb != k) {
        break label65;
      }
      this.field_svrId = paramCursor.getLong(i);
      this.dvY = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (dnq == k) {
        this.field_isRead = paramCursor.getShort(i);
      } else if (dkj == k) {
        this.field_title = paramCursor.getString(i);
      } else if (dgT == k) {
        this.field_content = paramCursor.getString(i);
      } else if (dDt == k) {
        this.field_pushTime = paramCursor.getLong(i);
      } else if (dlf == k) {
        this.field_msgType = paramCursor.getInt(i);
      } else if (dDu == k) {
        this.field_descUrl = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.dvY) {
      localContentValues.put("svrId", Long.valueOf(this.field_svrId));
    }
    if (this.dnf) {
      localContentValues.put("isRead", Short.valueOf(this.field_isRead));
    }
    if (this.dkg) {
      localContentValues.put("title", this.field_title);
    }
    if (this.dgw) {
      localContentValues.put("content", this.field_content);
    }
    if (this.dDr) {
      localContentValues.put("pushTime", Long.valueOf(this.field_pushTime));
    }
    if (this.dkR) {
      localContentValues.put("msgType", Integer.valueOf(this.field_msgType));
    }
    if (this.dDs) {
      localContentValues.put("descUrl", this.field_descUrl);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.g.c.co
 * JD-Core Version:    0.7.0.1
 */