package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ed
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eTj = "width".hashCode();
  private static final int eTk;
  private static final int fjE = "packet_id".hashCode();
  private static final int fjL = "media_type".hashCode();
  private static final int fjM = "media_url".hashCode();
  private static final int fjN = "media_md5".hashCode();
  private static final int fjO = "media_fuzzy_thumbnail_url".hashCode();
  private static final int fjP = "media_fuzzy_thumbnail_md5".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eSx = true;
  private boolean eSy = true;
  public int field_height;
  public String field_media_fuzzy_thumbnail_md5;
  public String field_media_fuzzy_thumbnail_url;
  public String field_media_md5;
  public int field_media_type;
  public String field_media_url;
  public String field_packet_id;
  public int field_width;
  private boolean fjG = true;
  private boolean fjH = true;
  private boolean fjI = true;
  private boolean fjJ = true;
  private boolean fjK = true;
  private boolean fjw = true;
  
  static
  {
    eTk = "height".hashCode();
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
      if (fjL != k) {
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
      if (fjM == k) {
        this.field_media_url = paramCursor.getString(i);
      } else if (fjN == k) {
        this.field_media_md5 = paramCursor.getString(i);
      } else if (eTk == k) {
        this.field_height = paramCursor.getInt(i);
      } else if (eTj == k) {
        this.field_width = paramCursor.getInt(i);
      } else if (fjE == k) {
        this.field_packet_id = paramCursor.getString(i);
      } else if (fjO == k) {
        this.field_media_fuzzy_thumbnail_url = paramCursor.getString(i);
      } else if (fjP == k) {
        this.field_media_fuzzy_thumbnail_md5 = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fjG) {
      localContentValues.put("media_type", Integer.valueOf(this.field_media_type));
    }
    if (this.fjH) {
      localContentValues.put("media_url", this.field_media_url);
    }
    if (this.fjI) {
      localContentValues.put("media_md5", this.field_media_md5);
    }
    if (this.eSy) {
      localContentValues.put("height", Integer.valueOf(this.field_height));
    }
    if (this.eSx) {
      localContentValues.put("width", Integer.valueOf(this.field_width));
    }
    if (this.fjw) {
      localContentValues.put("packet_id", this.field_packet_id);
    }
    if (this.fjJ) {
      localContentValues.put("media_fuzzy_thumbnail_url", this.field_media_fuzzy_thumbnail_url);
    }
    if (this.fjK) {
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