package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class z
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int ejL = "msgId".hashCode();
  private static final int elJ;
  private static final int eni;
  private static final int eoF = "xml".hashCode();
  private static final int eoG;
  private static final int eoH;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE;
  private boolean __hadSettype = true;
  private boolean ejH = true;
  private boolean els = true;
  private boolean enc = true;
  private boolean eoC = true;
  private boolean eoD = true;
  private boolean eoE = true;
  public String field_appId;
  public String field_description;
  public long field_msgId;
  public String field_source;
  public String field_title;
  public int field_type;
  public String field_xml;
  
  static
  {
    elJ = "appId".hashCode();
    eoG = "title".hashCode();
    eoH = "description".hashCode();
    eni = "source".hashCode();
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
      if (ejL != k) {
        break label65;
      }
      this.field_msgId = paramCursor.getLong(i);
      this.ejH = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eoF == k) {
        this.field_xml = paramCursor.getString(i);
      } else if (elJ == k) {
        this.field_appId = paramCursor.getString(i);
      } else if (eoG == k) {
        this.field_title = paramCursor.getString(i);
      } else if (eoH == k) {
        this.field_description = paramCursor.getString(i);
      } else if (eni == k) {
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
    if (this.ejH) {
      localContentValues.put("msgId", Long.valueOf(this.field_msgId));
    }
    if (this.eoC) {
      localContentValues.put("xml", this.field_xml);
    }
    if (this.els) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.eoD) {
      localContentValues.put("title", this.field_title);
    }
    if (this.eoE) {
      localContentValues.put("description", this.field_description);
    }
    if (this.enc) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.z
 * JD-Core Version:    0.7.0.1
 */