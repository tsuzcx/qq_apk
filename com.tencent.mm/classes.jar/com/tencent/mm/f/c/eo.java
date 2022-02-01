package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class eo
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("LocalStoryDetail");
  public static final Column hHq;
  public static final Column hHr;
  private static final int hIS = "width".hashCode();
  private static final int hIT;
  public static final Column ijA;
  private static final int ijS = "packet_id".hashCode();
  public static final Column ijV;
  public static final Column ijW;
  public static final Column ijX;
  public static final Column ijY;
  public static final Column ijZ;
  private static final int ikf;
  private static final int ikg;
  private static final int ikh;
  private static final int iki = "media_fuzzy_thumbnail_url".hashCode();
  private static final int ikj = "media_fuzzy_thumbnail_md5".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public int field_height;
  public String field_media_fuzzy_thumbnail_md5;
  public String field_media_fuzzy_thumbnail_url;
  public String field_media_md5;
  public int field_media_type;
  public String field_media_url;
  public String field_packet_id;
  public int field_width;
  private boolean hIe = true;
  private boolean hIf = true;
  private boolean ijJ = true;
  private boolean ika = true;
  private boolean ikb = true;
  private boolean ikc = true;
  private boolean ikd = true;
  private boolean ike = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "LocalStoryDetail", "");
    ijV = new Column("media_type", "int", "LocalStoryDetail", "");
    ijW = new Column("media_url", "string", "LocalStoryDetail", "");
    ijX = new Column("media_md5", "string", "LocalStoryDetail", "");
    hHr = new Column("height", "int", "LocalStoryDetail", "");
    hHq = new Column("width", "int", "LocalStoryDetail", "");
    ijA = new Column("packet_id", "string", "LocalStoryDetail", "");
    ijY = new Column("media_fuzzy_thumbnail_url", "string", "LocalStoryDetail", "");
    ijZ = new Column("media_fuzzy_thumbnail_md5", "string", "LocalStoryDetail", "");
    ikf = "media_type".hashCode();
    ikg = "media_url".hashCode();
    ikh = "media_md5".hashCode();
    hIT = "height".hashCode();
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
      if (ikf != k) {
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
      if (ikg == k) {
        this.field_media_url = paramCursor.getString(i);
      } else if (ikh == k) {
        this.field_media_md5 = paramCursor.getString(i);
      } else if (hIT == k) {
        this.field_height = paramCursor.getInt(i);
      } else if (hIS == k) {
        this.field_width = paramCursor.getInt(i);
      } else if (ijS == k) {
        this.field_packet_id = paramCursor.getString(i);
      } else if (iki == k) {
        this.field_media_fuzzy_thumbnail_url = paramCursor.getString(i);
      } else if (ikj == k) {
        this.field_media_fuzzy_thumbnail_md5 = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.ika) {
      localContentValues.put("media_type", Integer.valueOf(this.field_media_type));
    }
    if (this.ikb) {
      localContentValues.put("media_url", this.field_media_url);
    }
    if (this.ikc) {
      localContentValues.put("media_md5", this.field_media_md5);
    }
    if (this.hIf) {
      localContentValues.put("height", Integer.valueOf(this.field_height));
    }
    if (this.hIe) {
      localContentValues.put("width", Integer.valueOf(this.field_width));
    }
    if (this.ijJ) {
      localContentValues.put("packet_id", this.field_packet_id);
    }
    if (this.ikd) {
      localContentValues.put("media_fuzzy_thumbnail_url", this.field_media_fuzzy_thumbnail_url);
    }
    if (this.ike) {
      localContentValues.put("media_fuzzy_thumbnail_md5", this.field_media_fuzzy_thumbnail_md5);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
  
  public String[] getIndexCreateSQL()
  {
    return INDEX_CREATE;
  }
  
  public String getTableName()
  {
    return "LocalStoryDetail";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.f.c.eo
 * JD-Core Version:    0.7.0.1
 */