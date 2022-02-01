package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class dt
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eBL = "width".hashCode();
  private static final int eBM;
  private static final int eRh = "packet_id".hashCode();
  private static final int eRo = "media_type".hashCode();
  private static final int eRp = "media_url".hashCode();
  private static final int eRq = "media_md5".hashCode();
  private static final int eRr = "media_fuzzy_thumbnail_url".hashCode();
  private static final int eRs = "media_fuzzy_thumbnail_md5".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eAZ = true;
  private boolean eBa = true;
  private boolean eQZ = true;
  private boolean eRj = true;
  private boolean eRk = true;
  private boolean eRl = true;
  private boolean eRm = true;
  private boolean eRn = true;
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
    eBM = "height".hashCode();
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
      if (eRo != k) {
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
      if (eRp == k) {
        this.field_media_url = paramCursor.getString(i);
      } else if (eRq == k) {
        this.field_media_md5 = paramCursor.getString(i);
      } else if (eBM == k) {
        this.field_height = paramCursor.getInt(i);
      } else if (eBL == k) {
        this.field_width = paramCursor.getInt(i);
      } else if (eRh == k) {
        this.field_packet_id = paramCursor.getString(i);
      } else if (eRr == k) {
        this.field_media_fuzzy_thumbnail_url = paramCursor.getString(i);
      } else if (eRs == k) {
        this.field_media_fuzzy_thumbnail_md5 = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eRj) {
      localContentValues.put("media_type", Integer.valueOf(this.field_media_type));
    }
    if (this.eRk) {
      localContentValues.put("media_url", this.field_media_url);
    }
    if (this.eRl) {
      localContentValues.put("media_md5", this.field_media_md5);
    }
    if (this.eBa) {
      localContentValues.put("height", Integer.valueOf(this.field_height));
    }
    if (this.eAZ) {
      localContentValues.put("width", Integer.valueOf(this.field_width));
    }
    if (this.eQZ) {
      localContentValues.put("packet_id", this.field_packet_id);
    }
    if (this.eRm) {
      localContentValues.put("media_fuzzy_thumbnail_url", this.field_media_fuzzy_thumbnail_url);
    }
    if (this.eRn) {
      localContentValues.put("media_fuzzy_thumbnail_md5", this.field_media_fuzzy_thumbnail_md5);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.dt
 * JD-Core Version:    0.7.0.1
 */