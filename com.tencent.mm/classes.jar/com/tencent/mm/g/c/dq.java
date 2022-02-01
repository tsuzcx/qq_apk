package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class dq
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eOd = "packet_id".hashCode();
  private static final int eOk = "media_type".hashCode();
  private static final int eOl = "media_url".hashCode();
  private static final int eOm = "media_md5".hashCode();
  private static final int eOn = "media_fuzzy_thumbnail_url".hashCode();
  private static final int eOo = "media_fuzzy_thumbnail_md5".hashCode();
  private static final int ezr;
  private static final int ezs = "height".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eNV = true;
  private boolean eOf = true;
  private boolean eOg = true;
  private boolean eOh = true;
  private boolean eOi = true;
  private boolean eOj = true;
  private boolean eyF = true;
  private boolean eyG = true;
  public int field_height;
  public String field_media_fuzzy_thumbnail_md5;
  public String field_media_fuzzy_thumbnail_url;
  public String field_media_md5;
  public int field_media_type;
  public String field_media_url;
  public String field_packet_id;
  public int field_width;
  
  static
  {
    ezr = "width".hashCode();
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
      if (eOk != k) {
        break label60;
      }
      this.field_media_type = paramCursor.getInt(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (eOl == k) {
        this.field_media_url = paramCursor.getString(i);
      } else if (eOm == k) {
        this.field_media_md5 = paramCursor.getString(i);
      } else if (ezs == k) {
        this.field_height = paramCursor.getInt(i);
      } else if (ezr == k) {
        this.field_width = paramCursor.getInt(i);
      } else if (eOd == k) {
        this.field_packet_id = paramCursor.getString(i);
      } else if (eOn == k) {
        this.field_media_fuzzy_thumbnail_url = paramCursor.getString(i);
      } else if (eOo == k) {
        this.field_media_fuzzy_thumbnail_md5 = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eOf) {
      localContentValues.put("media_type", Integer.valueOf(this.field_media_type));
    }
    if (this.eOg) {
      localContentValues.put("media_url", this.field_media_url);
    }
    if (this.eOh) {
      localContentValues.put("media_md5", this.field_media_md5);
    }
    if (this.eyG) {
      localContentValues.put("height", Integer.valueOf(this.field_height));
    }
    if (this.eyF) {
      localContentValues.put("width", Integer.valueOf(this.field_width));
    }
    if (this.eNV) {
      localContentValues.put("packet_id", this.field_packet_id);
    }
    if (this.eOi) {
      localContentValues.put("media_fuzzy_thumbnail_url", this.field_media_fuzzy_thumbnail_url);
    }
    if (this.eOj) {
      localContentValues.put("media_fuzzy_thumbnail_md5", this.field_media_fuzzy_thumbnail_md5);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.dq
 * JD-Core Version:    0.7.0.1
 */