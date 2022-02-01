package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class df
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eDv = "svrId".hashCode();
  private static final int eNP;
  private static final int eNQ = "descUrl".hashCode();
  private static final int eng;
  private static final int eqK;
  private static final int erH;
  private static final int eug = "isRead".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eDs = true;
  private boolean eNN = true;
  private boolean eNO = true;
  private boolean emI = true;
  private boolean eqH = true;
  private boolean ers = true;
  private boolean etS = true;
  public String field_content;
  public String field_descUrl;
  public short field_isRead;
  public int field_msgType;
  public long field_pushTime;
  public long field_svrId;
  public String field_title;
  
  static
  {
    eqK = "title".hashCode();
    eng = "content".hashCode();
    eNP = "pushTime".hashCode();
    erH = "msgType".hashCode();
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
      if (eDv != k) {
        break label65;
      }
      this.field_svrId = paramCursor.getLong(i);
      this.eDs = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eug == k) {
        this.field_isRead = paramCursor.getShort(i);
      } else if (eqK == k) {
        this.field_title = paramCursor.getString(i);
      } else if (eng == k) {
        this.field_content = paramCursor.getString(i);
      } else if (eNP == k) {
        this.field_pushTime = paramCursor.getLong(i);
      } else if (erH == k) {
        this.field_msgType = paramCursor.getInt(i);
      } else if (eNQ == k) {
        this.field_descUrl = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eDs) {
      localContentValues.put("svrId", Long.valueOf(this.field_svrId));
    }
    if (this.etS) {
      localContentValues.put("isRead", Short.valueOf(this.field_isRead));
    }
    if (this.eqH) {
      localContentValues.put("title", this.field_title);
    }
    if (this.emI) {
      localContentValues.put("content", this.field_content);
    }
    if (this.eNN) {
      localContentValues.put("pushTime", Long.valueOf(this.field_pushTime));
    }
    if (this.ers) {
      localContentValues.put("msgType", Integer.valueOf(this.field_msgType));
    }
    if (this.eNO) {
      localContentValues.put("descUrl", this.field_descUrl);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.df
 * JD-Core Version:    0.7.0.1
 */