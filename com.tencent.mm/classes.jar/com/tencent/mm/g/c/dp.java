package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class dp
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eEm;
  private static final int eHT;
  private static final int eIQ = "msgType".hashCode();
  private static final int eLo;
  private static final int eUT = "svrId".hashCode();
  private static final int fgl;
  private static final int fgm = "descUrl".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eDP = true;
  private boolean eHQ = true;
  private boolean eIB = true;
  private boolean eLb = true;
  private boolean eUQ = true;
  private boolean fgj = true;
  private boolean fgk = true;
  public String field_content;
  public String field_descUrl;
  public short field_isRead;
  public int field_msgType;
  public long field_pushTime;
  public long field_svrId;
  public String field_title;
  
  static
  {
    eLo = "isRead".hashCode();
    eHT = "title".hashCode();
    eEm = "content".hashCode();
    fgl = "pushTime".hashCode();
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
      if (eUT != k) {
        break label65;
      }
      this.field_svrId = paramCursor.getLong(i);
      this.eUQ = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eLo == k) {
        this.field_isRead = paramCursor.getShort(i);
      } else if (eHT == k) {
        this.field_title = paramCursor.getString(i);
      } else if (eEm == k) {
        this.field_content = paramCursor.getString(i);
      } else if (fgl == k) {
        this.field_pushTime = paramCursor.getLong(i);
      } else if (eIQ == k) {
        this.field_msgType = paramCursor.getInt(i);
      } else if (fgm == k) {
        this.field_descUrl = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eUQ) {
      localContentValues.put("svrId", Long.valueOf(this.field_svrId));
    }
    if (this.eLb) {
      localContentValues.put("isRead", Short.valueOf(this.field_isRead));
    }
    if (this.eHQ) {
      localContentValues.put("title", this.field_title);
    }
    if (this.eDP) {
      localContentValues.put("content", this.field_content);
    }
    if (this.fgj) {
      localContentValues.put("pushTime", Long.valueOf(this.field_pushTime));
    }
    if (this.eIB) {
      localContentValues.put("msgType", Integer.valueOf(this.field_msgType));
    }
    if (this.fgk) {
      localContentValues.put("descUrl", this.field_descUrl);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.dp
 * JD-Core Version:    0.7.0.1
 */