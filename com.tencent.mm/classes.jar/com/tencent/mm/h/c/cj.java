package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class cj
  extends c
{
  private static final int cHt;
  private static final int cND;
  private static final int cNE = "descUrl".hashCode();
  public static final String[] cqY = new String[0];
  private static final int crh = "rowid".hashCode();
  private static final int csD;
  private static final int cvZ;
  private static final int cxe;
  private static final int czp;
  private boolean cHq = true;
  private boolean cNB = true;
  private boolean cNC = true;
  private boolean csf = true;
  private boolean cvV = true;
  private boolean cwQ = true;
  private boolean cze = true;
  public String field_content;
  public String field_descUrl;
  public short field_isRead;
  public int field_msgType;
  public long field_pushTime;
  public long field_svrId;
  public String field_title;
  
  static
  {
    cHt = "svrId".hashCode();
    czp = "isRead".hashCode();
    cvZ = "title".hashCode();
    csD = "content".hashCode();
    cND = "pushTime".hashCode();
    cxe = "msgType".hashCode();
  }
  
  public final void d(Cursor paramCursor)
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
      if (cHt != k) {
        break label65;
      }
      this.field_svrId = paramCursor.getLong(i);
      this.cHq = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (czp == k) {
        this.field_isRead = paramCursor.getShort(i);
      } else if (cvZ == k) {
        this.field_title = paramCursor.getString(i);
      } else if (csD == k) {
        this.field_content = paramCursor.getString(i);
      } else if (cND == k) {
        this.field_pushTime = paramCursor.getLong(i);
      } else if (cxe == k) {
        this.field_msgType = paramCursor.getInt(i);
      } else if (cNE == k) {
        this.field_descUrl = paramCursor.getString(i);
      } else if (crh == k) {
        this.ujK = paramCursor.getLong(i);
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.cHq) {
      localContentValues.put("svrId", Long.valueOf(this.field_svrId));
    }
    if (this.cze) {
      localContentValues.put("isRead", Short.valueOf(this.field_isRead));
    }
    if (this.cvV) {
      localContentValues.put("title", this.field_title);
    }
    if (this.csf) {
      localContentValues.put("content", this.field_content);
    }
    if (this.cNB) {
      localContentValues.put("pushTime", Long.valueOf(this.field_pushTime));
    }
    if (this.cwQ) {
      localContentValues.put("msgType", Integer.valueOf(this.field_msgType));
    }
    if (this.cNC) {
      localContentValues.put("descUrl", this.field_descUrl);
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.h.c.cj
 * JD-Core Version:    0.7.0.1
 */