package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class ej
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fQf = "packet_id".hashCode();
  private static final int fQm = "media_type".hashCode();
  private static final int fQn = "media_url".hashCode();
  private static final int fQo = "media_md5".hashCode();
  private static final int fQp = "media_fuzzy_thumbnail_url".hashCode();
  private static final int fQq = "media_fuzzy_thumbnail_md5".hashCode();
  private static final int fyA = "height".hashCode();
  private static final int fyz = "width".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean fPX = true;
  private boolean fQh = true;
  private boolean fQi = true;
  private boolean fQj = true;
  private boolean fQk = true;
  private boolean fQl = true;
  public int field_height;
  public String field_media_fuzzy_thumbnail_md5;
  public String field_media_fuzzy_thumbnail_url;
  public String field_media_md5;
  public int field_media_type;
  public String field_media_url;
  public String field_packet_id;
  public int field_width;
  private boolean fxN = true;
  private boolean fxO = true;
  
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
      if (fQm != k) {
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
      if (fQn == k) {
        this.field_media_url = paramCursor.getString(i);
      } else if (fQo == k) {
        this.field_media_md5 = paramCursor.getString(i);
      } else if (fyA == k) {
        this.field_height = paramCursor.getInt(i);
      } else if (fyz == k) {
        this.field_width = paramCursor.getInt(i);
      } else if (fQf == k) {
        this.field_packet_id = paramCursor.getString(i);
      } else if (fQp == k) {
        this.field_media_fuzzy_thumbnail_url = paramCursor.getString(i);
      } else if (fQq == k) {
        this.field_media_fuzzy_thumbnail_md5 = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fQh) {
      localContentValues.put("media_type", Integer.valueOf(this.field_media_type));
    }
    if (this.fQi) {
      localContentValues.put("media_url", this.field_media_url);
    }
    if (this.fQj) {
      localContentValues.put("media_md5", this.field_media_md5);
    }
    if (this.fxO) {
      localContentValues.put("height", Integer.valueOf(this.field_height));
    }
    if (this.fxN) {
      localContentValues.put("width", Integer.valueOf(this.field_width));
    }
    if (this.fPX) {
      localContentValues.put("packet_id", this.field_packet_id);
    }
    if (this.fQk) {
      localContentValues.put("media_fuzzy_thumbnail_url", this.field_media_fuzzy_thumbnail_url);
    }
    if (this.fQl) {
      localContentValues.put("media_fuzzy_thumbnail_md5", this.field_media_fuzzy_thumbnail_md5);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.c.ej
 * JD-Core Version:    0.7.0.1
 */