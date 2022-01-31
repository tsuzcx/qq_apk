package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class s
  extends c
{
  public static final String[] cqY = new String[0];
  private static final int crg = "msgId".hashCode();
  private static final int crh = "rowid".hashCode();
  private static final int csy;
  private static final int ctl;
  private static final int cvY = "xml".hashCode();
  private static final int cvZ;
  private static final int cwa;
  private static final int cwb;
  private boolean crc = true;
  private boolean csU = true;
  private boolean csa = true;
  private boolean cvU = true;
  private boolean cvV = true;
  private boolean cvW = true;
  private boolean cvX = true;
  public String field_appId;
  public String field_description;
  public long field_msgId;
  public String field_source;
  public String field_title;
  public int field_type;
  public String field_xml;
  
  static
  {
    ctl = "appId".hashCode();
    cvZ = "title".hashCode();
    cwa = "description".hashCode();
    cwb = "source".hashCode();
    csy = "type".hashCode();
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
      if (crg != k) {
        break label65;
      }
      this.field_msgId = paramCursor.getLong(i);
      this.crc = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (cvY == k) {
        this.field_xml = paramCursor.getString(i);
      } else if (ctl == k) {
        this.field_appId = paramCursor.getString(i);
      } else if (cvZ == k) {
        this.field_title = paramCursor.getString(i);
      } else if (cwa == k) {
        this.field_description = paramCursor.getString(i);
      } else if (cwb == k) {
        this.field_source = paramCursor.getString(i);
      } else if (csy == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (crh == k) {
        this.ujK = paramCursor.getLong(i);
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.crc) {
      localContentValues.put("msgId", Long.valueOf(this.field_msgId));
    }
    if (this.cvU) {
      localContentValues.put("xml", this.field_xml);
    }
    if (this.csU) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.cvV) {
      localContentValues.put("title", this.field_title);
    }
    if (this.cvW) {
      localContentValues.put("description", this.field_description);
    }
    if (this.cvX) {
      localContentValues.put("source", this.field_source);
    }
    if (this.csa) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.h.c.s
 * JD-Core Version:    0.7.0.1
 */