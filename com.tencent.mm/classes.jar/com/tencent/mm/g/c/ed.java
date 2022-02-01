package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ed
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eUU = "width".hashCode();
  private static final int eUV;
  private static final int flB = "packet_id".hashCode();
  private static final int flI = "media_type".hashCode();
  private static final int flJ = "media_url".hashCode();
  private static final int flK = "media_md5".hashCode();
  private static final int flL = "media_fuzzy_thumbnail_url".hashCode();
  private static final int flM = "media_fuzzy_thumbnail_md5".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eUi = true;
  private boolean eUj = true;
  public int field_height;
  public String field_media_fuzzy_thumbnail_md5;
  public String field_media_fuzzy_thumbnail_url;
  public String field_media_md5;
  public int field_media_type;
  public String field_media_url;
  public String field_packet_id;
  public int field_width;
  private boolean flD = true;
  private boolean flE = true;
  private boolean flF = true;
  private boolean flG = true;
  private boolean flH = true;
  private boolean flt = true;
  
  static
  {
    eUV = "height".hashCode();
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
      if (flI != k) {
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
      if (flJ == k) {
        this.field_media_url = paramCursor.getString(i);
      } else if (flK == k) {
        this.field_media_md5 = paramCursor.getString(i);
      } else if (eUV == k) {
        this.field_height = paramCursor.getInt(i);
      } else if (eUU == k) {
        this.field_width = paramCursor.getInt(i);
      } else if (flB == k) {
        this.field_packet_id = paramCursor.getString(i);
      } else if (flL == k) {
        this.field_media_fuzzy_thumbnail_url = paramCursor.getString(i);
      } else if (flM == k) {
        this.field_media_fuzzy_thumbnail_md5 = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.flD) {
      localContentValues.put("media_type", Integer.valueOf(this.field_media_type));
    }
    if (this.flE) {
      localContentValues.put("media_url", this.field_media_url);
    }
    if (this.flF) {
      localContentValues.put("media_md5", this.field_media_md5);
    }
    if (this.eUj) {
      localContentValues.put("height", Integer.valueOf(this.field_height));
    }
    if (this.eUi) {
      localContentValues.put("width", Integer.valueOf(this.field_width));
    }
    if (this.flt) {
      localContentValues.put("packet_id", this.field_packet_id);
    }
    if (this.flG) {
      localContentValues.put("media_fuzzy_thumbnail_url", this.field_media_fuzzy_thumbnail_url);
    }
    if (this.flH) {
      localContentValues.put("media_fuzzy_thumbnail_md5", this.field_media_fuzzy_thumbnail_md5);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.ed
 * JD-Core Version:    0.7.0.1
 */