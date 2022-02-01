package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class dp
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eFV;
  private static final int eJC;
  private static final int eKz = "msgType".hashCode();
  private static final int eMY;
  private static final int eWE = "svrId".hashCode();
  private static final int fii;
  private static final int fij = "descUrl".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eFy = true;
  private boolean eJz = true;
  private boolean eKk = true;
  private boolean eMK = true;
  private boolean eWB = true;
  public String field_content;
  public String field_descUrl;
  public short field_isRead;
  public int field_msgType;
  public long field_pushTime;
  public long field_svrId;
  public String field_title;
  private boolean fig = true;
  private boolean fih = true;
  
  static
  {
    eMY = "isRead".hashCode();
    eJC = "title".hashCode();
    eFV = "content".hashCode();
    fii = "pushTime".hashCode();
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
      if (eWE != k) {
        break label65;
      }
      this.field_svrId = paramCursor.getLong(i);
      this.eWB = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eMY == k) {
        this.field_isRead = paramCursor.getShort(i);
      } else if (eJC == k) {
        this.field_title = paramCursor.getString(i);
      } else if (eFV == k) {
        this.field_content = paramCursor.getString(i);
      } else if (fii == k) {
        this.field_pushTime = paramCursor.getLong(i);
      } else if (eKz == k) {
        this.field_msgType = paramCursor.getInt(i);
      } else if (fij == k) {
        this.field_descUrl = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eWB) {
      localContentValues.put("svrId", Long.valueOf(this.field_svrId));
    }
    if (this.eMK) {
      localContentValues.put("isRead", Short.valueOf(this.field_isRead));
    }
    if (this.eJz) {
      localContentValues.put("title", this.field_title);
    }
    if (this.eFy) {
      localContentValues.put("content", this.field_content);
    }
    if (this.fig) {
      localContentValues.put("pushTime", Long.valueOf(this.field_pushTime));
    }
    if (this.eKk) {
      localContentValues.put("msgType", Integer.valueOf(this.field_msgType));
    }
    if (this.fih) {
      localContentValues.put("descUrl", this.field_descUrl);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.dp
 * JD-Core Version:    0.7.0.1
 */