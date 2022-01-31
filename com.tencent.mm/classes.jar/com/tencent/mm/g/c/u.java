package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class u
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int dfD = "msgId".hashCode();
  private static final int dhB;
  private static final int diK;
  private static final int dki = "xml".hashCode();
  private static final int dkj;
  private static final int dkk;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE;
  private boolean __hadSettype = true;
  private boolean dfz = true;
  private boolean dhk = true;
  private boolean diH = true;
  private boolean dkf = true;
  private boolean dkg = true;
  private boolean dkh = true;
  public String field_appId;
  public String field_description;
  public long field_msgId;
  public String field_source;
  public String field_title;
  public int field_type;
  public String field_xml;
  
  static
  {
    dhB = "appId".hashCode();
    dkj = "title".hashCode();
    dkk = "description".hashCode();
    diK = "source".hashCode();
    type_HASHCODE = "type".hashCode();
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
      if (dfD != k) {
        break label65;
      }
      this.field_msgId = paramCursor.getLong(i);
      this.dfz = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (dki == k) {
        this.field_xml = paramCursor.getString(i);
      } else if (dhB == k) {
        this.field_appId = paramCursor.getString(i);
      } else if (dkj == k) {
        this.field_title = paramCursor.getString(i);
      } else if (dkk == k) {
        this.field_description = paramCursor.getString(i);
      } else if (diK == k) {
        this.field_source = paramCursor.getString(i);
      } else if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.dfz) {
      localContentValues.put("msgId", Long.valueOf(this.field_msgId));
    }
    if (this.dkf) {
      localContentValues.put("xml", this.field_xml);
    }
    if (this.dhk) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.dkg) {
      localContentValues.put("title", this.field_title);
    }
    if (this.dkh) {
      localContentValues.put("description", this.field_description);
    }
    if (this.diH) {
      localContentValues.put("source", this.field_source);
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.u
 * JD-Core Version:    0.7.0.1
 */